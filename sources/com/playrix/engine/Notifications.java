package com.playrix.engine;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.common.internal.ImagesContract;
import com.swrve.sdk.ISwrveCommon;
import com.swrve.sdk.SwrveNotificationConstants;
import com.swrve.sdk.rest.RESTClient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Notifications {
    public static final String ACTION_KEY = "com.playrix.engine.NotificationAction";
    public static final String ALERT_ONCE_KEY = "alertOnce";
    public static final String APP_STATUS_KEY = "appStatus";
    public static final String CATEGORY_KEY = "category";
    public static final String CHANNEL_KEY = "channel";
    public static final String DEFAULT_SOUND_ID = "default";
    public static final String DEFAULT_TAG = "default";
    public static final int DELETE_ACTION = 0;
    public static final int GROUP_ID = 1;
    public static final String GROUP_KEY = "group";
    public static final String GROUP_TAG_PREFIX = "group.";
    public static final String IMAGE_KEY = "image";
    public static final String INTENT_KEY = "com.playrix.engine.NotificationInfo";
    public static final String LOG_TAG = "[notifications] ";
    public static final String MESSAGE_KEY = "message";
    public static final int NOTIFICATION_ID = 0;
    public static final String NOTIFICATION_OLD_STYLE_KEY = "__NOTIFICATIONS__";
    public static final String PAYLOAD_KEY = "userInfo";
    public static final String SOUND_KEY = "sound";
    public static final String SOURCE_KEY = "source";
    public static final String SUMMARY_ARG = "summaryArg";
    public static final String SUMMARY_ARG_COUNT = "summaryArgCnt";
    public static final String TAG_KEY = "tag";
    public static final String TITLE_KEY = "title";
    public static final String TYPE_KEY = "type";
    public static final Scheduler scheduler = new Scheduler(NotificationReceiver.class, "__NOTIF_NUM__");
    public static final State state = new State();

    public interface Delegate {
        void onNotification(NotificationCompat.Builder builder, Content content);

        void onSummary(NotificationCompat.Builder builder, Content content, Summary summary);
    }

    public static class ActionParams {
        public final String actionIdentifier;
        public final String iconId;
        public final String title;

        public ActionParams(String str, String str2, String str3) {
            this.actionIdentifier = str;
            this.title = str2;
            this.iconId = str3;
        }
    }

    public static class CategoryParams {
        public final ActionParams[] actions;
        public final String summary;

        public CategoryParams(ActionParams[] actionParamsArr, String str) {
            this.actions = actionParamsArr;
            this.summary = str;
        }
    }

    public static class ChannelParams {
        public final boolean defaultSound;
        public final String description;
        public final boolean showBadge;
        public final String sound;
        public final String title;
        public final boolean useVibro;

        public ChannelParams(String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
            this.title = str;
            this.description = str2;
            this.sound = str3;
            this.defaultSound = z;
            this.useVibro = z2;
            this.showBadge = z3;
        }
    }

    public static class Content {
        public final CategoryParams categoryParams;
        public final JSONObject content;
        public final int iconLargeId;
        public final int iconSmallId;
        public final String message;
        public final String title;

        public Content(JSONObject jSONObject, String str, String str2, int i, int i2, CategoryParams categoryParams2) {
            this.content = jSONObject;
            this.title = str;
            this.message = str2;
            this.iconSmallId = i;
            this.iconLargeId = i2;
            this.categoryParams = categoryParams2;
        }
    }

    public static class GroupInfo {
        public final int count;
        public final int size;
        public final String summaryArg;

        public GroupInfo(int i, int i2, String str) {
            this.size = i;
            this.count = i2;
            this.summaryArg = str;
        }
    }

    public enum NotificationType {
        LOCAL,
        PUSH
    }

    public static class State {
        public Map<String, CategoryParams> categories;
        public Map<String, ChannelParams> channels;
        public String defaultCategory;
        public String defaultChannel;
        public final Handler deferredQueue;
        public Delegate delegate;
        public boolean independentSounds;
        public boolean isSoundEnabled;
        public long nextQueueTime;
        public long notificationDelay;
        public int uniqueIntentId;

        public State() {
            this.isSoundEnabled = true;
            this.independentSounds = false;
            this.channels = null;
            this.defaultChannel = "default";
            this.categories = null;
            this.defaultCategory = "default";
            this.uniqueIntentId = 0;
            this.deferredQueue = new Handler(Looper.getMainLooper());
            this.nextQueueTime = 0;
            this.notificationDelay = 3000;
            this.delegate = null;
        }

        public synchronized void addNotificationToQueue(Runnable runnable) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.nextQueueTime - elapsedRealtime;
            if (j <= 0) {
                this.nextQueueTime = elapsedRealtime + this.notificationDelay;
                runnable.run();
            } else {
                Logger.logDebug("[notifications] Delaying display of notification for " + j);
                this.deferredQueue.postDelayed(runnable, j);
                this.nextQueueTime = this.nextQueueTime + this.notificationDelay;
            }
        }

        public synchronized String defaultCategoryId() {
            return this.defaultCategory;
        }

        public synchronized String defaultChannelId() {
            return this.defaultChannel;
        }

        public synchronized String fixCategoryId(String str) {
            if (str != null) {
                if (this.categories != null && this.categories.containsKey(str)) {
                    return str;
                }
            }
            Logger.logWarning("[notifications] Unknown notification category " + str);
            return this.defaultCategory;
        }

        public synchronized String fixChannelId(String str) {
            if (str != null) {
                if (this.channels != null && this.channels.containsKey(str)) {
                    return str;
                }
            }
            Logger.logWarning("[notifications] Unknown notification channel " + str);
            return this.defaultChannel;
        }

        public synchronized int generateUniqueIntentId() {
            int i = this.uniqueIntentId + 1;
            this.uniqueIntentId = i;
            if (i == 0) {
                this.uniqueIntentId = i + 1;
            }
            return this.uniqueIntentId;
        }

        public synchronized Map<String, ChannelParams> getAllChannelParams() {
            return this.channels;
        }

        public synchronized CategoryParams getCategoryParams(String str) {
            return this.categories != null ? this.categories.get(str) : null;
        }

        public synchronized ChannelParams getChannelParams(String str) {
            return this.channels != null ? this.channels.get(str) : null;
        }

        public synchronized Delegate getDelegate() {
            return this.delegate;
        }

        public synchronized boolean isIndependentSounds() {
            return this.independentSounds;
        }

        public synchronized boolean isSoundEnabled() {
            return this.isSoundEnabled;
        }

        public synchronized void resetNotificationQueue() {
            this.deferredQueue.removeCallbacksAndMessages((Object) null);
        }

        public synchronized void setDelegate(Delegate delegate2) {
            this.delegate = delegate2;
        }

        public synchronized void setupCategories(Map<String, CategoryParams> map, String str) {
            this.categories = map;
            this.defaultCategory = str;
        }

        public synchronized void setupChannels(Map<String, ChannelParams> map, String str) {
            this.channels = map;
            this.defaultChannel = str;
        }

        public synchronized void setupSettings(boolean z, boolean z2, long j) {
            this.isSoundEnabled = z;
            this.independentSounds = z2;
            this.notificationDelay = j;
        }
    }

    public static class Summary {
        public final int number;
        public final String summary;

        public Summary(int i, String str) {
            this.number = i;
            this.summary = str;
        }
    }

    public static boolean addNotification(String str, long j) {
        Logger.logDebug("[notifications] addNotification(): " + j + RESTClient.COMMA_SEPARATOR + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            long j2 = j * 1000;
            return scheduler.schedule(j2 + System.currentTimeMillis(), jSONObject);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean areNotificationsEnabled() {
        if (!NotificationManagerCompat.from(Engine.getContext()).areNotificationsEnabled()) {
            return false;
        }
        if (!isChannelsAvailable()) {
            return true;
        }
        return isAnyChannelEnabled();
    }

    public static PendingIntent createIntent(Context context, JSONObject jSONObject, String str) throws ClassNotFoundException {
        Intent createLaunchIntent = Engine.createLaunchIntent();
        createLaunchIntent.putExtra(INTENT_KEY, jSONObject.toString());
        if (str != null) {
            createLaunchIntent.putExtra(ACTION_KEY, str);
        }
        int generateUniqueIntentId = state.generateUniqueIntentId();
        createLaunchIntent.setData(new Uri.Builder().scheme("playrixintent").appendPath(context.getPackageName()).appendPath(String.valueOf(generateUniqueIntentId)).build());
        return PendingIntent.getActivity(context, generateUniqueIntentId, createLaunchIntent, 1207959552);
    }

    public static NotificationCompat.Builder createSummary(Context context, String str, String str2, String str3) {
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context, str).setGroup(str2).setGroupSummary(true).setSmallIcon(getSmallIcon(context)).setAutoCancel(true);
        int backgroundColor = getBackgroundColor(context);
        if (backgroundColor != 0) {
            autoCancel.setColor(backgroundColor);
        }
        if (!TextUtils.isEmpty(str3)) {
            autoCancel.setStyle(new NotificationCompat.InboxStyle().setSummaryText(str3));
        }
        return autoCancel;
    }

    public static String defaultCategoryId() {
        return state.defaultCategoryId();
    }

    public static String defaultChannelId() {
        return state.defaultChannelId();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r4.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getBackgroundColor(android.content.Context r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 21
            if (r0 >= r2) goto L_0x0008
            return r1
        L_0x0008:
            android.content.res.Resources r0 = r4.getResources()
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r2 = "color_notif_bkg"
            java.lang.String r3 = "color"
            int r4 = r0.getIdentifier(r2, r3, r4)
            if (r4 != 0) goto L_0x001b
            return r1
        L_0x001b:
            int r4 = getResourcesColor(r0, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.Notifications.getBackgroundColor(android.content.Context):int");
    }

    public static int getImageResourceId(String str) {
        String nativeTranslateImage = nativeTranslateImage(str);
        if (nativeTranslateImage == null || nativeTranslateImage.isEmpty()) {
            return 0;
        }
        Context context = Engine.getContext();
        return context.getResources().getIdentifier(nativeTranslateImage, "drawable", context.getPackageName());
    }

    public static int getLargeIcon(Context context, JSONObject jSONObject) throws JSONException {
        Resources resources = context.getResources();
        String nativeTranslateImage = nativeTranslateImage(jSONObject.optString("image"));
        int identifier = (nativeTranslateImage == null || nativeTranslateImage.isEmpty()) ? 0 : resources.getIdentifier(nativeTranslateImage, "drawable", context.getPackageName());
        return identifier == 0 ? resources.getIdentifier("ic_notif_large", "drawable", context.getPackageName()) : identifier;
    }

    public static NotificationManager getNotificationManager(Context context) {
        if (context != null) {
            try {
                return (NotificationManager) Engine.getContext().getSystemService(SwrveNotificationConstants.PUSH_BUNDLE);
            } catch (NullPointerException e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("[notifications] NPE in getSystemService for notification manager ");
                outline24.append(e.getMessage());
                Logger.logError(outline24.toString());
                return null;
            }
        } else {
            Logger.logError("[notifications] Null context in getNotificationManager");
            return null;
        }
    }

    public static int getResourcesColor(Resources resources, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            return resources.getColor(i);
        }
        return getResourcesColorNew(resources, i);
    }

    @TargetApi(23)
    public static int getResourcesColorNew(Resources resources, int i) {
        return resources.getColor(i, (Resources.Theme) null);
    }

    @TargetApi(23)
    public static GroupInfo getSameGroupInfo(NotificationManager notificationManager, String str, String str2) {
        StatusBarNotification[] activeNotifications;
        Notification notification;
        if (!isGroupsAvailable() || (activeNotifications = notificationManager.getActiveNotifications()) == null) {
            return null;
        }
        String str3 = "";
        int i = 0;
        int i2 = 0;
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            if (statusBarNotification != null && statusBarNotification.getId() == 0 && !str.equals(statusBarNotification.getTag()) && (notification = statusBarNotification.getNotification()) != null && str2.equals(notification.getGroup())) {
                i++;
                Bundle bundle = notification.extras;
                int i3 = 1;
                if (bundle != null) {
                    str3 = bundle.getString("summaryArg", "");
                    i3 = notification.extras.getInt("summaryArgCnt", 1);
                }
                i2 += i3;
            }
        }
        if (i == 0) {
            return null;
        }
        return new GroupInfo(i, i2, str3);
    }

    public static int getSmallIcon(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("ic_notif", "drawable", context.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        Logger.logError("[notifications] showNotification(): can't find resource ic_notif");
        return resources.getIdentifier("ic_launcher", "drawable", context.getPackageName());
    }

    public static Uri getSoundUri(String str) {
        String nativeTranslateSound = nativeTranslateSound(str);
        if (nativeTranslateSound == null || nativeTranslateSound.isEmpty()) {
            return Uri.EMPTY;
        }
        String lowerCase = nativeTranslateSound.replace('/', '_').toLowerCase(Locale.US);
        Context context = Engine.getContext();
        if (context.getResources().getIdentifier(lowerCase, "raw", context.getPackageName()) == 0) {
            Logger.logError("[notifications] not found notification sound " + nativeTranslateSound);
            return Uri.EMPTY;
        }
        Uri.Builder authority = new Uri.Builder().scheme("android.resource").authority(context.getPackageName());
        return authority.path("raw/" + lowerCase).build();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r8 = r2.getString(INTENT_KEY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void handleActivation(android.content.Intent r10) {
        /*
            java.lang.String r0 = "com.playrix.engine.NotificationAction"
            java.lang.String r1 = "com.playrix.engine.NotificationInfo"
            android.os.Bundle r2 = r10.getExtras()     // Catch:{ Exception -> 0x005f }
            if (r2 == 0) goto L_0x0069
            java.lang.String r8 = r2.getString(r1)     // Catch:{ Exception -> 0x005f }
            if (r8 == 0) goto L_0x0069
            boolean r3 = r8.isEmpty()     // Catch:{ Exception -> 0x005f }
            if (r3 != 0) goto L_0x0069
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x005f }
            r4.<init>(r8)     // Catch:{ Exception -> 0x005f }
            java.lang.String r7 = r2.getString(r0)     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = "type"
            java.lang.String r2 = r4.optString(r2)     // Catch:{ Exception -> 0x005f }
            java.lang.String r3 = "push"
            boolean r5 = r2.equals(r3)     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = "appStatus"
            java.lang.String r2 = r4.optString(r2)     // Catch:{ Exception -> 0x005f }
            java.lang.String r3 = "launchedNow"
            boolean r6 = r2.equals(r3)     // Catch:{ Exception -> 0x005f }
            if (r7 == 0) goto L_0x004f
            java.lang.String r2 = "tag"
            java.lang.String r3 = "default"
            java.lang.String r2 = r4.optString(r2, r3)     // Catch:{ Exception -> 0x005f }
            android.content.Context r3 = com.playrix.engine.Engine.getContext()     // Catch:{ Exception -> 0x005f }
            android.app.NotificationManager r3 = getNotificationManager(r3)     // Catch:{ Exception -> 0x005f }
            if (r3 == 0) goto L_0x004f
            r9 = 0
            r3.cancel(r2, r9)     // Catch:{ Exception -> 0x005f }
        L_0x004f:
            com.playrix.engine.Notifications$3 r2 = new com.playrix.engine.Notifications$3     // Catch:{ Exception -> 0x005f }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005f }
            com.playrix.engine.Engine.runOnGLThread(r2)     // Catch:{ Exception -> 0x005f }
            r10.removeExtra(r1)     // Catch:{ Exception -> 0x005f }
            r10.removeExtra(r0)     // Catch:{ Exception -> 0x005f }
            goto L_0x0069
        L_0x005f:
            r10 = move-exception
            java.lang.String r0 = "[notifications] handleActivation Exception: "
            java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r0)
            com.android.tools.p006r8.GeneratedOutlineSupport.outline32(r10, r0)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.Notifications.handleActivation(android.content.Intent):void");
    }

    @TargetApi(26)
    public static boolean isAnyChannelEnabled() {
        try {
            NotificationManager notificationManager = getNotificationManager(Engine.getContext());
            if (notificationManager == null) {
                return false;
            }
            for (NotificationChannel importance : notificationManager.getNotificationChannels()) {
                if (importance.getImportance() >= 2) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isChannelsAvailable() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isGroupsAvailable() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isSoundForAnyChannelEnabled() {
        if (!isChannelsAvailable()) {
            return false;
        }
        return isSoundForAnyChannelEnabledImpl();
    }

    @TargetApi(26)
    public static boolean isSoundForAnyChannelEnabledImpl() {
        try {
            NotificationManager notificationManager = getNotificationManager(Engine.getContext());
            if (notificationManager == null || !notificationManager.areNotificationsEnabled()) {
                return false;
            }
            for (NotificationChannel next : notificationManager.getNotificationChannels()) {
                if (next.getImportance() > 2) {
                    Uri sound = next.getSound();
                    if (sound != null && !sound.equals(Uri.EMPTY)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String makeSummaryText(CategoryParams categoryParams, String str, int i) {
        String nativeLocalizeQuantityString;
        if (categoryParams == null || (nativeLocalizeQuantityString = nativeLocalizeQuantityString(categoryParams.summary, i)) == null) {
            return null;
        }
        return nativeLocalizeQuantityString.replace("%@", nativeLocalizeString(str)).replace("%u", String.valueOf(i));
    }

    @TargetApi(23)
    public static void modifyGroupOnDeleteNotification(JSONObject jSONObject) {
        Context context;
        NotificationManager notificationManager;
        String optString = jSONObject.optString("tag");
        String optString2 = jSONObject.optString("group");
        String fixChannelId = state.fixChannelId(jSONObject.optString("channel"));
        String fixCategoryId = state.fixCategoryId(jSONObject.optString("category"));
        if (optString2 != null && (notificationManager = getNotificationManager(context)) != null) {
            String str = (context = Engine.getContext()).getPackageName() + CodelessMatcher.CURRENT_CLASS_NAME + optString2;
            GroupInfo sameGroupInfo = getSameGroupInfo(notificationManager, optString, str);
            if (sameGroupInfo != null) {
                String makeSummaryText = sameGroupInfo.size > 1 ? makeSummaryText(state.getCategoryParams(fixCategoryId), sameGroupInfo.summaryArg, sameGroupInfo.count) : null;
                NotificationCompat.Builder createSummary = createSummary(context, fixChannelId, str, makeSummaryText);
                Delegate delegate = state.getDelegate();
                if (delegate != null) {
                    delegate.onSummary(createSummary, (Content) null, new Summary(sameGroupInfo.size, makeSummaryText));
                }
                notificationManager.notify(GeneratedOutlineSupport.outline16(GROUP_TAG_PREFIX, optString2), 1, createSummary.build());
            }
        }
    }

    public static native String nativeLocalizeQuantityString(String str, int i);

    public static native String nativeLocalizeString(String str);

    public static native void nativeOnNotificationActivated(boolean z, boolean z2, String str, String str2);

    public static native String nativeOnNotificationReceived(boolean z, boolean z2, String str);

    public static native String nativeTranslateImage(String str);

    public static native String nativeTranslateSound(String str);

    public static void onLocaleChanged() {
        if (isChannelsAvailable()) {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Map<String, ChannelParams> allChannelParams = Notifications.state.getAllChannelParams();
                    if (allChannelParams != null) {
                        Notifications.updateChannels(allChannelParams);
                    }
                }
            });
        }
    }

    public static void processNotification(final JSONObject jSONObject, final NotificationType notificationType) {
        if (jSONObject != null) {
            final boolean z = Engine.getActivity() == null;
            try {
                jSONObject.put("type", notificationType == NotificationType.LOCAL ? ImagesContract.LOCAL : ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_PUSH);
                jSONObject.put(APP_STATUS_KEY, z ? "launchedNow" : "alreadyRunning");
                state.addNotificationToQueue(new Runnable() {
                    public void run() {
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                boolean z = NotificationType.this == NotificationType.PUSH;
                                C16531 r1 = C16531.this;
                                String nativeOnNotificationReceived = Notifications.nativeOnNotificationReceived(z, z, jSONObject.toString());
                                if (nativeOnNotificationReceived != null && !nativeOnNotificationReceived.isEmpty()) {
                                    try {
                                        EngineActivity activity = Engine.getActivity();
                                        if (activity == null || !activity.isVisible) {
                                            Notifications.showNotification(new JSONObject(nativeOnNotificationReceived));
                                        }
                                    } catch (Exception e) {
                                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("[notifications] parse notification data exception: ");
                                        outline24.append(e.getMessage());
                                        Logger.logError(outline24.toString());
                                    }
                                }
                            }
                        });
                    }
                });
            } catch (Exception e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("[notifications] processNotification Exception: ");
                outline24.append(e.getMessage());
                Logger.logError(outline24.toString());
            }
        }
    }

    public static void processNotificationAction(int i, final JSONObject jSONObject) {
        if (i == 0 && isGroupsAvailable()) {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Notifications.modifyGroupOnDeleteNotification(jSONObject);
                }
            });
        }
    }

    public static void removeNotifications(boolean z, boolean z2) {
        Context context = Engine.getContext();
        if (z) {
            Logger.logDebug("[notifications] removeScheduledNotifications");
            scheduler.cancelAll();
            state.resetNotificationQueue();
        }
        if (z2) {
            Logger.logDebug("[notifications] removeDeliveredNotifications");
            try {
                NotificationManager notificationManager = getNotificationManager(context);
                if (notificationManager != null) {
                    notificationManager.cancelAll();
                }
            } catch (Exception e) {
                GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("[notifications] exception while canceling notifications: "));
            }
        }
    }

    public static void removeOldStyleNotifications() {
        Context context = Engine.getContext();
        if (Engine.containsSharedPreferencesValue(NOTIFICATION_OLD_STYLE_KEY)) {
            Logger.logInfo("[notifications] removing old style notifications");
            Engine.removeSharedPreferencesValue(NOTIFICATION_OLD_STYLE_KEY);
            try {
                ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, NotificationReceiver.class), 134217728));
            } catch (Exception e) {
                GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("[notifications] exception while removing notifications: "));
            }
        }
    }

    public static void setDelegate(Delegate delegate) {
        state.setDelegate(delegate);
    }

    public static void setupActions(NotificationCompat.Builder builder, Context context, JSONObject jSONObject, CategoryParams categoryParams) throws JSONException, ClassNotFoundException {
        ActionParams[] actionParamsArr;
        if (categoryParams != null && (actionParamsArr = categoryParams.actions) != null) {
            for (ActionParams actionParams : actionParamsArr) {
                if (actionParams != null) {
                    builder.addAction(getImageResourceId(actionParams.iconId), nativeLocalizeString(actionParams.title), createIntent(context, jSONObject, actionParams.actionIdentifier));
                }
            }
        }
    }

    public static void setupCategories(Map<String, CategoryParams> map, String str) {
        state.setupCategories(map, str);
    }

    public static void setupChannels(Map<String, ChannelParams> map, String str) {
        state.setupChannels(map, str);
        if (isChannelsAvailable()) {
            updateChannels(map);
        }
    }

    public static void setupSettings(boolean z, boolean z2, long j) {
        state.setupSettings(z, z2, j);
    }

    public static void setupSoundAndDefaults(NotificationCompat.Builder builder, JSONObject jSONObject, String str) throws JSONException {
        Uri uri = Uri.EMPTY;
        int i = 0;
        if (state.isSoundEnabled()) {
            if (state.isIndependentSounds()) {
                String optString = jSONObject.optString("sound");
                if (optString != null && !optString.isEmpty()) {
                    if (optString.equals("default")) {
                        i = 1;
                    } else {
                        uri = getSoundUri(optString);
                    }
                }
            } else {
                ChannelParams channelParams = state.getChannelParams(str);
                if (channelParams != null) {
                    String optString2 = jSONObject.optString("sound");
                    if (optString2 != null && !optString2.isEmpty()) {
                        if (channelParams.defaultSound) {
                            i = 1;
                        } else {
                            uri = getSoundUri(channelParams.sound);
                        }
                    }
                    if (channelParams.useVibro) {
                        i |= 2;
                    }
                }
            }
        }
        if (uri != Uri.EMPTY) {
            builder.setSound(uri);
        }
        builder.setDefaults(i);
    }

    public static void showNotification(JSONObject jSONObject) {
        String str;
        String str2;
        NotificationManager notificationManager;
        String str3;
        JSONObject jSONObject2 = jSONObject;
        try {
            String nativeLocalizeString = nativeLocalizeString(jSONObject2.optString("message", ""));
            String nativeLocalizeString2 = nativeLocalizeString(jSONObject2.optString("title"));
            if (nativeLocalizeString2 == null || nativeLocalizeString2.isEmpty()) {
                nativeLocalizeString2 = GlobalConstants.getString("app_name", "");
            }
            Logger.logDebug("[notifications] showNotification(): " + nativeLocalizeString);
            Context context = Engine.getContext();
            Resources resources = context.getResources();
            NotificationManager notificationManager2 = getNotificationManager(context);
            if (notificationManager2 == null) {
                Logger.logError("[notifications] showNotification(): null manager");
                return;
            }
            Bundle bundle = new Bundle();
            String optString = jSONObject2.optString("summaryArg", "");
            str = "[notifications] showNotification(): ";
            try {
                int optInt = jSONObject2.optInt("summaryArgCnt", 1);
                bundle.putString("summaryArg", optString);
                bundle.putInt("summaryArgCnt", optInt);
                String fixChannelId = state.fixChannelId(jSONObject2.optString("channel"));
                NotificationCompat.Builder extras = new NotificationCompat.Builder(context, fixChannelId).setContentTitle(nativeLocalizeString2).setContentText(nativeLocalizeString).setTicker(nativeLocalizeString).setAutoCancel(true).setExtras(bundle);
                if (!isChannelsAvailable()) {
                    setupSoundAndDefaults(extras, jSONObject2, fixChannelId);
                }
                String fixCategoryId = state.fixCategoryId(jSONObject2.optString("category"));
                CategoryParams categoryParams = state.getCategoryParams(fixCategoryId);
                setupActions(extras, context, jSONObject2, categoryParams);
                CategoryParams categoryParams2 = categoryParams;
                String str4 = fixChannelId;
                if (jSONObject2.optBoolean("alertOnce", false)) {
                    extras.setOnlyAlertOnce(true);
                }
                int smallIcon = getSmallIcon(context);
                if (smallIcon != 0) {
                    extras.setSmallIcon(smallIcon);
                }
                int largeIcon = getLargeIcon(context, jSONObject2);
                if (largeIcon != 0) {
                    extras.setLargeIcon(BitmapFactory.decodeResource(resources, largeIcon));
                }
                int backgroundColor = getBackgroundColor(context);
                if (backgroundColor != 0) {
                    extras.setColor(backgroundColor);
                }
                CategoryParams categoryParams3 = categoryParams2;
                String str5 = optString;
                String str6 = str4;
                int i = optInt;
                String str7 = fixCategoryId;
                NotificationManager notificationManager3 = notificationManager2;
                Content content = r1;
                String str8 = "category";
                NotificationCompat.Builder builder = extras;
                Content content2 = new Content(jSONObject, nativeLocalizeString2, nativeLocalizeString, smallIcon, largeIcon, categoryParams3);
                Delegate delegate = state.getDelegate();
                if (delegate != null) {
                    delegate.onNotification(builder, content);
                }
                GroupInfo groupInfo = null;
                builder.setContentIntent(createIntent(context, jSONObject2, (String) null));
                String optString2 = jSONObject2.optString("tag", "default");
                if (isGroupsAvailable()) {
                    String optString3 = jSONObject2.optString("group");
                    if (optString3 == null || optString3.isEmpty()) {
                        notificationManager = notificationManager3;
                        str2 = optString3;
                        str3 = null;
                    } else {
                        String str9 = context.getPackageName() + CodelessMatcher.CURRENT_CLASS_NAME + optString3;
                        builder.setGroup(str9);
                        builder.setDeleteIntent(NotificationActionReceiver.createActionIntent(context, state.generateUniqueIntentId(), 0, new JSONObject().put("tag", optString2).put("group", optString3).put("channel", str6).put(str8, str7)));
                        notificationManager = notificationManager3;
                        str2 = optString3;
                        str3 = str9;
                        groupInfo = getSameGroupInfo(notificationManager, optString2, str9);
                    }
                } else {
                    notificationManager = notificationManager3;
                    str3 = null;
                    str2 = null;
                }
                notificationManager.notify(optString2, 0, builder.build());
                if (groupInfo != null) {
                    String makeSummaryText = makeSummaryText(categoryParams3, str5, groupInfo.count + i);
                    NotificationCompat.Builder createSummary = createSummary(context, str6, str3, makeSummaryText);
                    if (delegate != null) {
                        delegate.onSummary(createSummary, content, new Summary(groupInfo.size, makeSummaryText));
                    }
                    notificationManager.notify(GROUP_TAG_PREFIX + str2, 1, createSummary.build());
                }
            } catch (Exception e) {
                e = e;
                GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24(str));
            }
        } catch (Exception e2) {
            e = e2;
            str = "[notifications] showNotification(): ";
            GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24(str));
        }
    }

    @TargetApi(26)
    public static void updateChannels(Map<String, ChannelParams> map) {
        String str;
        try {
            NotificationManager notificationManager = getNotificationManager(Engine.getContext());
            if (notificationManager == null) {
                Logger.logError("[notifications] Null manager in createChannel");
                return;
            }
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            HashSet hashSet = new HashSet();
            if (notificationChannels != null) {
                for (NotificationChannel id : notificationChannels) {
                    hashSet.add(id.getId());
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                String str2 = (String) next.getKey();
                ChannelParams channelParams = (ChannelParams) next.getValue();
                NotificationChannel notificationChannel = new NotificationChannel(str2, nativeLocalizeString(channelParams.title), 3);
                if (!channelParams.defaultSound) {
                    notificationChannel.setSound(getSoundUri(channelParams.sound), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
                notificationChannel.setShowBadge(channelParams.showBadge);
                notificationChannel.enableVibration(channelParams.useVibro);
                notificationChannel.setDescription(nativeLocalizeString(channelParams.description));
                arrayList.add(notificationChannel);
                hashSet.remove(str2);
            }
            if (!arrayList.isEmpty()) {
                notificationManager.createNotificationChannels(arrayList);
            }
            if (!hashSet.isEmpty()) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    if (!str.equals("miscellaneous")) {
                        notificationManager.deleteNotificationChannel(str);
                    }
                }
            }
        } catch (Throwable th) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[notifications] Exception while registering channels: ");
            outline24.append(th.getMessage());
            Logger.logError(outline24.toString());
        }
    }
}
