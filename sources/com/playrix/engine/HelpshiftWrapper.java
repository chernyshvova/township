package com.playrix.engine;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.Core;
import com.helpshift.HelpshiftUser;
import com.helpshift.InstallConfig;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.conversation.activeconversation.model.ActionType;
import com.helpshift.delegate.AuthenticationFailureReason;
import com.helpshift.enums.ACTION_TYPE;
import com.helpshift.exceptions.InstallException;
import com.helpshift.support.ApiConfig;
import com.helpshift.support.Metadata;
import com.helpshift.support.MetadataCallable;
import com.helpshift.support.Support;
import com.helpshift.support.SupportInternal;
import com.helpshift.support.flows.ConversationFlow;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.concurrent.ApiExecutorFactory;
import com.playrix.engine.PushNotifications;
import com.swrve.sdk.localstorage.SwrveSQLiteOpenHelper;
import com.swrve.sdk.rest.RESTClient;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HelpshiftWrapper {
    public static final String INITIALIZE_OPTIONS_DISABLE_INAPP_NOTIFICATIONS = "DisableInappNotifications";
    public static final String INITIALIZE_OPTIONS_ENABLE_LOGGING = "EnableLogging";
    public static final String INITIALIZE_OPTIONS_ENABLE_VERBOSE_LOGGING = "EnableVerboseLogging";
    public static final String PREFS_NAME = "HSPersistentData";
    public static final String TAG = "[HelpshiftWrapper] ";
    public static final String VAR_ENABLED = "enabledFromNative";
    public static final String VERBOSE_LOG_TAG = "[HelpshiftVerbose] ";
    public static final DeferredExecuteQueue queue = new DeferredExecuteQueue();
    public static final State state = new State();

    /* renamed from: com.playrix.engine.HelpshiftWrapper$15 */
    public static /* synthetic */ class C314815 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$delegate$AuthenticationFailureReason;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.helpshift.delegate.AuthenticationFailureReason[] r0 = com.helpshift.delegate.AuthenticationFailureReason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$delegate$AuthenticationFailureReason = r0
                r1 = 1
                com.helpshift.delegate.AuthenticationFailureReason r2 = com.helpshift.delegate.AuthenticationFailureReason.AUTH_TOKEN_NOT_PROVIDED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$helpshift$delegate$AuthenticationFailureReason     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.delegate.AuthenticationFailureReason r2 = com.helpshift.delegate.AuthenticationFailureReason.INVALID_AUTH_TOKEN     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.HelpshiftWrapper.C314815.<clinit>():void");
        }
    }

    public static class HelpshiftDelegates implements Support.Delegate {
        public HelpshiftDelegates() {
        }

        public void authenticationFailed(HelpshiftUser helpshiftUser, AuthenticationFailureReason authenticationFailureReason) {
            int ordinal = authenticationFailureReason.ordinal();
            if (ordinal == 0) {
                Logger.logError("[HelpshiftWrapper] authentication failed because auth token isn't provided");
            } else if (ordinal != 1) {
                Logger.logError("[HelpshiftWrapper] authentication failed due to unknown reason");
            } else {
                Logger.logError("[HelpshiftWrapper] authentication failed because invalid auth token");
            }
        }

        public void conversationEnded() {
            Logger.logDebug("[HelpshiftWrapper] conversationEnded");
        }

        public void didReceiveNotification(final int i) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] didReceiveNotification:");
            outline24.append(Integer.toString(i));
            Logger.logDebug(outline24.toString());
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    HelpshiftWrapper.nativeOnReceiveNotification(i);
                }
            });
        }

        public void displayAttachmentFile(File file) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] displayAttachmentFile:");
            outline24.append(file.getName());
            Logger.logDebug(outline24.toString());
        }

        public void newConversationStarted(String str) {
            Logger.logDebug("[HelpshiftWrapper] newConversationStarted:" + str);
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    HelpshiftWrapper.nativeOnNewConversationStarted();
                }
            });
        }

        public void sessionBegan() {
            HelpshiftWrapper.state.onSessionBegin();
        }

        public void sessionEnded() {
            if (HelpshiftWrapper.state.onSessionEnd()) {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        HelpshiftWrapper.nativeOnFAQClosed();
                    }
                });
            }
        }

        public void userClickOnAction(ActionType actionType, String str) {
            Logger.logDebug("[HelpshiftWrapper] userClickOnAction:" + actionType + " " + str);
        }

        public void userCompletedCustomerSatisfactionSurvey(final int i, final String str) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] userCompletedCustomerSatisfactionSurvey: rating-");
            outline24.append(Integer.toString(i));
            outline24.append(" feedback-");
            outline24.append(str);
            Logger.logDebug(outline24.toString());
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    HelpshiftWrapper.nativeOnUserCompletedCustomerSatisfactionSurvey(i, str);
                }
            });
        }

        public void userRepliedToConversation(String str) {
            Logger.logDebug("[HelpshiftWrapper] userRepliedToConversation:" + str);
        }

        public void displayAttachmentFile(Uri uri) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] displayAttachmentFile Uri:");
            outline24.append(uri.toString());
            Logger.logDebug(outline24.toString());
        }
    }

    public static class State {
        public int activationCounter;
        public Application applicationContext;
        public boolean conversationResolutionQuestion;
        public Handler countHandler;
        public int enableContactUs;
        public Handler failHandler;
        public boolean gotoConversationAfterContactUs;
        public boolean pushNotificationEnabled;
        public Map<String, String[]> savedCustomIssueFields;
        public String[] savedInfo;
        public Map<String, String> savedMetadata;
        public String[] savedTags;
        public String savedUserId;
        public String savedUserName;
        public boolean searchOnNewConversation;
        public boolean showConversationInfoScreen;
        public Wrapper wrapper;

        public State() {
            this.wrapper = null;
            this.pushNotificationEnabled = true;
            this.activationCounter = 0;
            this.savedUserId = "";
            this.savedUserName = "";
            this.savedMetadata = null;
            this.savedCustomIssueFields = null;
            this.conversationResolutionQuestion = false;
            this.enableContactUs = SupportInternal.EnableContactUs.NEVER.intValue();
            this.searchOnNewConversation = true;
            this.showConversationInfoScreen = false;
            this.gotoConversationAfterContactUs = false;
            this.applicationContext = null;
            this.countHandler = null;
            this.failHandler = null;
        }

        private synchronized HashMap<String, Object> createMetadata(String str) {
            ArrayList arrayList;
            HashMap<String, Object> hashMap;
            Logger.logDebug("[HelpshiftWrapper] createTags: ");
            if (this.savedTags != null) {
                arrayList = new ArrayList(Arrays.asList(this.savedTags));
            } else {
                arrayList = new ArrayList();
            }
            if (!HelpshiftWrapper.isNullOrEmpty(str)) {
                arrayList.add(str);
            }
            Logger.logDebug("[HelpshiftWrapper] get Metadata, tags = " + arrayList.toString());
            hashMap = new HashMap<>();
            hashMap.put(Support.TagsKey, arrayList.toArray(new String[0]));
            if (this.savedMetadata != null) {
                for (Map.Entry next : this.savedMetadata.entrySet()) {
                    hashMap.put(next.getKey(), next.getValue());
                }
            }
            return hashMap;
        }

        public synchronized ApiConfig.Builder createConfigBuilder() {
            ApiConfig.Builder createConfigBuilderBase;
            createConfigBuilderBase = createConfigBuilderBase((String) null);
            createConfigBuilderBase.setEnableContactUs(Integer.valueOf(this.enableContactUs));
            return createConfigBuilderBase;
        }

        public synchronized ApiConfig.Builder createConfigBuilderBase(String str) {
            ApiConfig.Builder builder;
            builder = new ApiConfig.Builder();
            builder.setShowConversationResolutionQuestion(this.conversationResolutionQuestion);
            builder.setShowSearchOnNewConversation(this.searchOnNewConversation);
            builder.setShowConversationInfoScreen(this.showConversationInfoScreen);
            builder.setGotoConversationAfterContactUs(this.gotoConversationAfterContactUs);
            builder.setCustomMetadata(new Metadata(createMetadata(str)));
            if (this.savedCustomIssueFields != null && !this.savedCustomIssueFields.isEmpty()) {
                builder.setCustomIssueFields(this.savedCustomIssueFields);
            }
            return builder;
        }

        public synchronized Application getApplicationContext() {
            return this.applicationContext;
        }

        public synchronized void getNotificationCount() {
            if (!(this.countHandler == null || this.failHandler == null)) {
                this.wrapper.getNotificationCount(this.countHandler, this.failHandler);
            }
        }

        public synchronized Wrapper getWrapper() {
            return this.wrapper;
        }

        public synchronized void initialize(Wrapper wrapper2) {
            this.wrapper = wrapper2;
            this.countHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    Bundle bundle = (Bundle) message.obj;
                    final Integer valueOf = Integer.valueOf(bundle.getInt("value"));
                    if (Boolean.valueOf(bundle.getBoolean(SwrveSQLiteOpenHelper.CACHE_TABLE_NAME)).booleanValue()) {
                        Logger.logDebug("[HelpshiftWrapper] getNotificationCount returned cached value " + valueOf);
                    } else {
                        Logger.logDebug("[HelpshiftWrapper] getNotificationCount returned value from server " + valueOf);
                    }
                    Engine.runOnGLThread(new Runnable() {
                        public void run() {
                            HelpshiftWrapper.nativeOnReceiveNotification(valueOf.intValue());
                        }
                    });
                }
            };
            this.failHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                }
            };
        }

        public synchronized boolean isFAQShown() {
            return this.activationCounter > 0;
        }

        public synchronized boolean isPushNotificationsEnabled() {
            return this.pushNotificationEnabled;
        }

        public synchronized void logoutUser() {
            this.wrapper.logout();
            this.savedUserId = "";
            this.savedUserName = "";
        }

        public synchronized void onSessionBegin() {
            Logger.logDebug("[HelpshiftWrapper] sessionBegan");
            this.activationCounter++;
        }

        public synchronized boolean onSessionEnd() {
            boolean z;
            Logger.logDebug("[HelpshiftWrapper] sessionEnded");
            z = true;
            int i = this.activationCounter - 1;
            this.activationCounter = i;
            if (i > 0) {
                z = false;
            }
            return z;
        }

        public synchronized void onShowFAQ() {
            this.activationCounter = 0;
        }

        public synchronized void setApplicationContext(Application application) {
            this.applicationContext = application;
        }

        public synchronized void setEnableContactUs(int i) {
            this.enableContactUs = i;
        }

        public synchronized void setGotoConversationAfterContactUs(boolean z) {
            this.gotoConversationAfterContactUs = z;
        }

        public synchronized void setPushNotificationsEnabled(boolean z) {
            this.pushNotificationEnabled = z;
        }

        public synchronized void setShowConversationInfoScreen(boolean z) {
            this.showConversationInfoScreen = z;
        }

        public synchronized void setShowConversationResolutionQuestion(boolean z) {
            this.conversationResolutionQuestion = z;
        }

        public synchronized void setShowSearchOnNewConversation(boolean z) {
            this.searchOnNewConversation = z;
        }

        public synchronized void setupPlayerInfo() {
            this.wrapper.clearBreadCrumbs();
            for (String leaveBreadCrumb : this.savedInfo) {
                this.wrapper.leaveBreadCrumb(leaveBreadCrumb);
            }
            final HashMap<String, Object> createMetadata = createMetadata((String) null);
            this.wrapper.setMetadataCallback(new MetadataCallable() {
                public Metadata call() {
                    return new Metadata(createMetadata);
                }
            });
            this.wrapper.forceMetadataCallback();
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0091  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void setupUser(java.lang.String r4, java.lang.String r5, java.lang.String[] r6, java.lang.String[] r7, java.util.Map<java.lang.String, java.lang.String> r8, java.util.Map<java.lang.String, java.lang.String[]> r9) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
                r0.<init>()     // Catch:{ all -> 0x009f }
                java.lang.String r1 = "[HelpshiftWrapper] setupUser: "
                r0.append(r1)     // Catch:{ all -> 0x009f }
                r0.append(r4)     // Catch:{ all -> 0x009f }
                java.lang.String r1 = ", name: "
                r0.append(r1)     // Catch:{ all -> 0x009f }
                r0.append(r5)     // Catch:{ all -> 0x009f }
                java.lang.String r1 = ", tags: "
                r0.append(r1)     // Catch:{ all -> 0x009f }
                r0.append(r6)     // Catch:{ all -> 0x009f }
                java.lang.String r1 = ", info: "
                r0.append(r1)     // Catch:{ all -> 0x009f }
                r0.append(r7)     // Catch:{ all -> 0x009f }
                java.lang.String r1 = ", metadata:"
                r0.append(r1)     // Catch:{ all -> 0x009f }
                r0.append(r8)     // Catch:{ all -> 0x009f }
                java.lang.String r1 = ", customIssueFields:"
                r0.append(r1)     // Catch:{ all -> 0x009f }
                r0.append(r9)     // Catch:{ all -> 0x009f }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x009f }
                com.playrix.engine.Logger.logDebug(r0)     // Catch:{ all -> 0x009f }
                java.lang.String r0 = r3.savedUserId     // Catch:{ all -> 0x009f }
                boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x009f }
                if (r0 == 0) goto L_0x0056
                boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x009f }
                if (r0 != 0) goto L_0x0054
                java.lang.String r0 = r3.savedUserName     // Catch:{ all -> 0x009f }
                boolean r0 = r0.equals(r5)     // Catch:{ all -> 0x009f }
                if (r0 != 0) goto L_0x0054
                goto L_0x0056
            L_0x0054:
                r0 = 0
                goto L_0x0057
            L_0x0056:
                r0 = 1
            L_0x0057:
                if (r0 == 0) goto L_0x0070
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
                r1.<init>()     // Catch:{ all -> 0x009f }
                java.lang.String r2 = "[HelpshiftWrapper] login: "
                r1.append(r2)     // Catch:{ all -> 0x009f }
                r1.append(r4)     // Catch:{ all -> 0x009f }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x009f }
                com.playrix.engine.Logger.logDebug(r1)     // Catch:{ all -> 0x009f }
                r3.logoutUser()     // Catch:{ all -> 0x009f }
            L_0x0070:
                r3.savedUserId = r4     // Catch:{ all -> 0x009f }
                r3.savedUserName = r5     // Catch:{ all -> 0x009f }
                r3.savedTags = r6     // Catch:{ all -> 0x009f }
                r3.savedInfo = r7     // Catch:{ all -> 0x009f }
                r3.savedMetadata = r8     // Catch:{ all -> 0x009f }
                r3.savedCustomIssueFields = r9     // Catch:{ all -> 0x009f }
                if (r0 == 0) goto L_0x009d
                boolean r6 = r4.isEmpty()     // Catch:{ all -> 0x009f }
                if (r6 != 0) goto L_0x009d
                com.helpshift.HelpshiftUser$Builder r6 = new com.helpshift.HelpshiftUser$Builder     // Catch:{ all -> 0x009f }
                java.lang.String r7 = ""
                r6.<init>(r4, r7)     // Catch:{ all -> 0x009f }
                boolean r4 = r5.isEmpty()     // Catch:{ all -> 0x009f }
                if (r4 != 0) goto L_0x0094
                r6.setName(r5)     // Catch:{ all -> 0x009f }
            L_0x0094:
                com.playrix.engine.HelpshiftWrapper$Wrapper r4 = r3.wrapper     // Catch:{ all -> 0x009f }
                com.helpshift.HelpshiftUser r5 = r6.build()     // Catch:{ all -> 0x009f }
                r4.login(r5)     // Catch:{ all -> 0x009f }
            L_0x009d:
                monitor-exit(r3)
                return
            L_0x009f:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.HelpshiftWrapper.State.setupUser(java.lang.String, java.lang.String, java.lang.String[], java.lang.String[], java.util.Map, java.util.Map):void");
        }
    }

    public interface Wrapper {
        void clearBreadCrumbs();

        void forceMetadataCallback();

        void getNotificationCount(Handler handler, Handler handler2);

        void handlePush(Context context, Intent intent);

        void handlePush(Context context, Bundle bundle);

        void init();

        void install(Application application, String str, String str2, String str3, InstallConfig installConfig) throws InstallException;

        void leaveBreadCrumb(String str);

        void login(HelpshiftUser helpshiftUser);

        void logout();

        void registerDeviceToken(Context context, String str);

        void setDelegate(Support.Delegate delegate);

        void setMetadataCallback(MetadataCallable metadataCallable);

        void setSDKLanguage(String str);

        void showConversation(Activity activity, ApiConfig apiConfig);

        void showFAQSection(Activity activity, String str, ApiConfig apiConfig);

        void showFAQs(Activity activity, ApiConfig apiConfig);

        void showSingleFAQ(Activity activity, String str, ApiConfig apiConfig);
    }

    public static class WrapperRelease implements Wrapper {
        public WrapperRelease() {
        }

        public void clearBreadCrumbs() {
            Support.clearBreadCrumbs();
        }

        public void forceMetadataCallback() {
            if (HelpshiftContext.verifyInstall()) {
                ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                    public void run() {
                        HelpshiftContext.getCoreApi().getMetaDataDM().getCustomMetaData();
                    }
                });
            }
        }

        public void getNotificationCount(Handler handler, Handler handler2) {
            Support.getNotificationCount(handler, handler2);
        }

        public void handlePush(Context context, Intent intent) {
            Core.handlePush(context, intent);
        }

        public void init() {
            Core.init(Support.getInstance());
        }

        public void install(Application application, String str, String str2, String str3, InstallConfig installConfig) throws InstallException {
            Core.install(application, str, str2, str3, installConfig);
        }

        public void leaveBreadCrumb(String str) {
            Support.leaveBreadCrumb(str);
        }

        public void login(HelpshiftUser helpshiftUser) {
            Core.login(helpshiftUser);
        }

        public void logout() {
            Core.logout();
        }

        public void registerDeviceToken(Context context, String str) {
            Core.registerDeviceToken(context, str);
        }

        public void setDelegate(Support.Delegate delegate) {
            Support.setDelegate(delegate);
        }

        public void setMetadataCallback(MetadataCallable metadataCallable) {
            Support.setMetadataCallback(metadataCallable);
        }

        public void setSDKLanguage(String str) {
            Support.setSDKLanguage(str);
        }

        public void showConversation(Activity activity, ApiConfig apiConfig) {
            Support.showConversation(activity, apiConfig);
        }

        public void showFAQSection(Activity activity, String str, ApiConfig apiConfig) {
            Support.showFAQSection(activity, str, apiConfig);
        }

        public void showFAQs(Activity activity, ApiConfig apiConfig) {
            Support.showFAQs(activity, apiConfig);
        }

        public void showSingleFAQ(Activity activity, String str, ApiConfig apiConfig) {
            Support.showSingleFAQ(activity, str, apiConfig);
        }

        public void handlePush(Context context, Bundle bundle) {
            Core.handlePush(context, bundle);
        }
    }

    public static boolean acceptPush(final Context context, final Intent intent) {
        if (context == null || intent == null || !intent.getExtras().getString("origin", "").equals("helpshift")) {
            return false;
        }
        if (isEnabled() && state.isPushNotificationsEnabled()) {
            queue.execute(new Runnable() {
                public void run() {
                    HelpshiftWrapper.state.getWrapper().handlePush(context, intent);
                }
            });
        }
        return true;
    }

    public static int getMetaResource(Application application, String str) {
        try {
            return application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.getInt(str);
        } catch (Throwable th) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper]  Exception in getMetaResource: ");
            outline24.append(th.getMessage());
            Logger.logError(outline24.toString());
            return 0;
        }
    }

    public static String getMetaString(Application application, String str) {
        try {
            return application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.getString(str);
        } catch (Throwable th) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper]  Exception in getMetaString: ");
            outline24.append(th.getMessage());
            Logger.logError(outline24.toString());
            return "";
        }
    }

    public static void getNotificationCount() {
        queue.execute(new Runnable() {
            public void run() {
                HelpshiftWrapper.state.getNotificationCount();
            }
        });
    }

    public static String getSdkVersion() {
        return "7.11.0";
    }

    public static boolean initWithParameters(String str, String str2, String str3, String str4) {
        if (state.getApplicationContext() != null) {
            return true;
        }
        final Application application = Engine.getApplication();
        if (application == null) {
            return false;
        }
        state.setApplicationContext(application);
        final String str5 = str4;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str;
        return NativeThread.getInstance().queueInitalizeEvent(new Runnable() {
            public void run() {
                int i;
                List asList = Arrays.asList(str5.split("\\|"));
                Wrapper wrapperDebug = asList.contains(HelpshiftWrapper.INITIALIZE_OPTIONS_ENABLE_VERBOSE_LOGGING) ? new WrapperDebug() : new WrapperRelease();
                HelpshiftWrapper.state.initialize(wrapperDebug);
                Logger.logDebug("[HelpshiftWrapper] init");
                wrapperDebug.init();
                try {
                    InstallConfig.Builder builder = new InstallConfig.Builder();
                    if (Build.VERSION.SDK_INT >= 21) {
                        i = HelpshiftWrapper.getMetaResource(application, "helpshift-icon-lollipop");
                    } else {
                        i = HelpshiftWrapper.getMetaResource(application, "helpshift-icon-kitkat");
                    }
                    if (i != 0) {
                        builder.setNotificationIcon(i);
                    }
                    if (asList.contains(HelpshiftWrapper.INITIALIZE_OPTIONS_ENABLE_LOGGING)) {
                        builder.setEnableLogging(true);
                    }
                    if (asList.contains(HelpshiftWrapper.INITIALIZE_OPTIONS_DISABLE_INAPP_NOTIFICATIONS)) {
                        builder.setEnableInAppNotification(false);
                    }
                    String access$600 = HelpshiftWrapper.getMetaString(application, "helpshift-support-nchannel");
                    if (!HelpshiftWrapper.isNullOrEmpty(access$600)) {
                        builder.setSupportNotificationChannelId(access$600);
                    }
                    wrapperDebug.install(application, str6, str7, str8, builder.build());
                } catch (InstallException e) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] install call error : ");
                    outline24.append(e.toString());
                    Logger.logError(outline24.toString());
                }
                wrapperDebug.setDelegate(new HelpshiftDelegates());
                HelpshiftWrapper.registerPushNotificationsDelegate();
                HelpshiftWrapper.queue.process();
            }
        });
    }

    public static boolean isCurrentTimeBetween(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            Calendar instance = Calendar.getInstance();
            int i = (instance.get(11) * 60) + instance.get(12);
            instance.setTime(simpleDateFormat.parse(str));
            int i2 = (instance.get(11) * 60) + instance.get(12);
            instance.setTime(simpleDateFormat.parse(str2));
            int i3 = (instance.get(11) * 60) + instance.get(12);
            if (i2 <= i3) {
                if (i2 > i || i > i3) {
                    return false;
                }
            } else if (i2 <= i || i <= i3) {
                return true;
            } else {
                return false;
            }
            return true;
        } catch (ParseException e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] Error in time format: ");
            outline24.append(e.toString());
            Logger.logError(outline24.toString());
            return false;
        }
    }

    public static boolean isEnabled() {
        if (state.getApplicationContext() == null) {
            return false;
        }
        return state.getApplicationContext().getSharedPreferences(PREFS_NAME, 0).getBoolean(VAR_ENABLED, true);
    }

    public static boolean isFAQShown() {
        return state.isFAQShown();
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static void logout() {
        queue.execute(new Runnable() {
            public void run() {
                HelpshiftWrapper.state.logoutUser();
            }
        });
    }

    public static native void nativeOnFAQClosed();

    public static native void nativeOnNewConversationStarted();

    public static native void nativeOnReceiveNotification(int i);

    public static native void nativeOnUserCompletedCustomerSatisfactionSurvey(int i, String str);

    public static native void nativeUpdateNotificationCounter();

    public static void registerPushNotificationsDelegate() {
        PushNotifications.registerPushNotificationsDelegate(new PushNotifications.IPushNotificationsDelegate() {
            public static final String TAG = "Helpshift PushNotificationsDelegate ";

            public PushNotifications.PushNotificationData processPushNotification(Bundle bundle) {
                String str;
                String str2;
                if (!bundle.getString("origin", "").equals("helpshift") || !HelpshiftWrapper.isEnabled() || !HelpshiftWrapper.state.isPushNotificationsEnabled()) {
                    return null;
                }
                Logger.logInfo("Helpshift PushNotificationsDelegate Processing Helpshift notification");
                if (!bundle.getString(AnalyticsEventKey.ISSUE_ID, "").isEmpty()) {
                    Logger.logDebug("Helpshift PushNotificationsDelegate Helpshift conversation push detected");
                    str = GlobalConstants.getString("notif_channel_helpshift_support_default", "");
                } else {
                    str = "";
                }
                if (!GlobalConstants.nameIsDefined("helpshift_silent_notif_time_begin") || !GlobalConstants.nameIsDefined("helpshift_silent_notif_time_end") || !HelpshiftWrapper.isCurrentTimeBetween(GlobalConstants.getString("helpshift_silent_notif_time_begin", ""), GlobalConstants.getString("helpshift_silent_notif_time_end", ""))) {
                    str2 = "default";
                } else {
                    Logger.logDebug("Helpshift PushNotificationsDelegate Silent notification");
                    str2 = null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sound", str2);
                    jSONObject.put("source", "helpshift");
                    jSONObject.put("message", bundle.getString("alert", ""));
                    jSONObject.put("channel", str);
                    jSONObject.put("category", Notifications.defaultCategoryId());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", "helpshift");
                    jSONObject2.put("action", ACTION_TYPE.SHOW_CONVERSATION);
                    jSONObject.put(Notifications.PAYLOAD_KEY, jSONObject2);
                } catch (JSONException e) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Helpshift PushNotificationsDelegate Error in extractPushData: ");
                    outline24.append(e.toString());
                    Logger.logError(outline24.toString());
                }
                EngineActivity activity = Engine.getActivity();
                if (activity != null && activity.isVisible) {
                    Logger.logDebug("Helpshift PushNotificationsDelegate Game is active, updating notification count");
                    if (!HelpshiftWrapper.isFAQShown()) {
                        HelpshiftWrapper.updateNotificationCounter();
                        Logger.logDebug("Helpshift PushNotificationsDelegate Game is active, Helpshift is not shown, omitting the notification, updating the counter");
                        return null;
                    }
                } else if (activity != null && HelpshiftWrapper.isFAQShown()) {
                    Logger.logDebug("Helpshift PushNotificationsDelegate Game is active, Helpshift is shown, omitting the notification");
                    return null;
                } else if (activity != null) {
                    Logger.logDebug("Helpshift PushNotificationsDelegate Game is in background, Helpshift is initialized");
                    HelpshiftWrapper.updateNotificationCounter();
                }
                return new PushNotifications.PushNotificationData(jSONObject, 5);
            }
        });
    }

    public static void registerPushToken(final String str) {
        queue.execute(new Runnable() {
            public void run() {
                if (HelpshiftWrapper.state.getApplicationContext() != null) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] registerDeviceToken with ");
                    outline24.append(str);
                    Logger.logDebug(outline24.toString());
                    HelpshiftWrapper.state.getWrapper().registerDeviceToken(HelpshiftWrapper.state.getApplicationContext(), str);
                    return;
                }
                Logger.logWarning("[HelpshiftWrapper] Can't registerDeviceToken: null context");
            }
        });
    }

    public static void setConfigBuilderFlowsContactUs(ApiConfig.Builder builder, String str) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new ConversationFlow(jSONObject.getString("text"), state.createConfigBuilderBase(jSONObject.getString("tag")).build()));
        }
        if (!arrayList.isEmpty()) {
            builder.setCustomContactUsFlows(arrayList);
        }
    }

    public static void setEnableContactUs(int i) {
        state.setEnableContactUs(i);
    }

    public static void setEnabled(boolean z) {
        if (state.getApplicationContext() != null) {
            SharedPreferences.Editor edit = state.getApplicationContext().getSharedPreferences(PREFS_NAME, 0).edit();
            edit.putBoolean(VAR_ENABLED, z);
            edit.commit();
        }
    }

    public static void setGotoConversationAfterContactUs(boolean z) {
        state.setGotoConversationAfterContactUs(z);
    }

    public static void setHSData(String str, String str2, String[] strArr, String[] strArr2, Map<String, String> map, Map<String, String[]> map2) {
        final String str3 = str;
        final String str4 = str2;
        final String[] strArr3 = strArr;
        final String[] strArr4 = strArr2;
        final Map<String, String> map3 = map;
        final Map<String, String[]> map4 = map2;
        queue.execute(new Runnable() {
            public void run() {
                HelpshiftWrapper.state.setupUser(str3, str4, strArr3, strArr4, map3, map4);
            }
        });
    }

    public static void setLanguage(final String str) {
        queue.execute(new Runnable() {
            public void run() {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] setLanguage: ");
                outline24.append(str);
                Logger.logDebug(outline24.toString());
                HelpshiftWrapper.state.getWrapper().setSDKLanguage(str);
            }
        });
    }

    public static void setPushNotificationsEnabled(boolean z) {
        state.setPushNotificationsEnabled(z);
    }

    public static void setShowConversationInfoScreen(boolean z) {
        state.setShowConversationInfoScreen(z);
    }

    public static void setShowConversationResolutionQuestion(boolean z) {
        state.setShowConversationResolutionQuestion(z);
    }

    public static void setShowSearchOnNewConversation(boolean z) {
        state.setShowSearchOnNewConversation(z);
    }

    public static void showConversation() {
        queue.execute(new Runnable() {
            public void run() {
                Logger.logDebug("[HelpshiftWrapper] showConversation");
                EngineActivity activity = Engine.getActivity();
                if (activity != null) {
                    try {
                        HelpshiftWrapper.state.setupPlayerInfo();
                        HelpshiftWrapper.state.onShowFAQ();
                        HelpshiftWrapper.state.getWrapper().showConversation(activity, HelpshiftWrapper.state.createConfigBuilder().build());
                    } catch (Exception e) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] showFAQ exception: ");
                        outline24.append(e.getMessage());
                        Logger.logError(outline24.toString());
                    }
                }
            }
        });
    }

    public static void showFaq(final String str) {
        queue.execute(new Runnable() {
            public void run() {
                Logger.logDebug("[HelpshiftWrapper] showFaq");
                EngineActivity activity = Engine.getActivity();
                if (activity != null) {
                    try {
                        HelpshiftWrapper.state.setupPlayerInfo();
                        HelpshiftWrapper.state.onShowFAQ();
                        ApiConfig.Builder createConfigBuilder = HelpshiftWrapper.state.createConfigBuilder();
                        HelpshiftWrapper.setConfigBuilderFlowsContactUs(createConfigBuilder, str);
                        HelpshiftWrapper.state.getWrapper().showFAQs(activity, createConfigBuilder.build());
                    } catch (Exception e) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] showFAQ exception: ");
                        outline24.append(e.getMessage());
                        Logger.logError(outline24.toString());
                    }
                }
            }
        });
    }

    public static void showFaqSection(final String str) {
        queue.execute(new Runnable() {
            public void run() {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] showFaqSection: ");
                outline24.append(str);
                Logger.logDebug(outline24.toString());
                EngineActivity activity = Engine.getActivity();
                if (activity != null) {
                    try {
                        HelpshiftWrapper.state.setupPlayerInfo();
                        if (!HelpshiftWrapper.isNullOrEmpty(str)) {
                            ApiConfig.Builder createConfigBuilder = HelpshiftWrapper.state.createConfigBuilder();
                            Logger.logDebug("[HelpshiftWrapper] showFAQSection, sectionId =  " + str + " , config = " + createConfigBuilder.toString());
                            HelpshiftWrapper.state.getWrapper().showFAQSection(activity, str, createConfigBuilder.build());
                        }
                    } catch (Exception e) {
                        StringBuilder outline242 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] showFaqSection exception: ");
                        outline242.append(e.getMessage());
                        Logger.logError(outline242.toString());
                    }
                }
            }
        });
    }

    public static void showSingleFaq(final String str, final String str2, final String str3) {
        queue.execute(new Runnable() {
            public void run() {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] showSingleFaq: ");
                outline24.append(str);
                outline24.append(RESTClient.COMMA_SEPARATOR);
                outline24.append(str2);
                Logger.logDebug(outline24.toString());
                EngineActivity activity = Engine.getActivity();
                if (activity != null) {
                    try {
                        HelpshiftWrapper.state.setupPlayerInfo();
                        if (!HelpshiftWrapper.isNullOrEmpty(str2)) {
                            ApiConfig.Builder createConfigBuilder = HelpshiftWrapper.state.createConfigBuilder();
                            HelpshiftWrapper.setConfigBuilderFlowsContactUs(createConfigBuilder, str3);
                            Logger.logDebug("[HelpshiftWrapper] showSingleFAQ, sectionId =  " + str + ", article = " + str2 + " , config = " + createConfigBuilder.toString());
                            HelpshiftWrapper.state.getWrapper().showSingleFAQ(activity, str2, createConfigBuilder.build());
                        }
                    } catch (Exception e) {
                        StringBuilder outline242 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] showFaqSection exception: ");
                        outline242.append(e.getMessage());
                        Logger.logError(outline242.toString());
                    }
                }
            }
        });
    }

    public static void updateNotificationCounter() {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                HelpshiftWrapper.nativeUpdateNotificationCounter();
            }
        });
    }

    public static class WrapperDebug extends WrapperRelease {
        public WrapperDebug() {
            super();
        }

        public static String logUser(HelpshiftUser helpshiftUser) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("{ identifier: \"");
            outline24.append(helpshiftUser.getIdentifier());
            outline24.append("\" email: \"");
            outline24.append(helpshiftUser.getEmail());
            outline24.append("\" name: \"");
            outline24.append(helpshiftUser.getName());
            outline24.append("\" authToken: ");
            outline24.append(helpshiftUser.getAuthToken());
            outline24.append("\"}");
            return outline24.toString();
        }

        public static void verboseLog(String str) {
            Logger.logInfo(HelpshiftWrapper.VERBOSE_LOG_TAG + str);
        }

        public void clearBreadCrumbs() {
            verboseLog("Support.clearBreadCrumbs();");
            super.clearBreadCrumbs();
        }

        public void forceMetadataCallback() {
            verboseLog("if (HelpshiftContext.verifyInstall()) { ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {");
            verboseLog("public void run() { HelpshiftContext.getCoreApi().getMetaDataDM().getCustomMetaData(); }");
            verboseLog("}); }");
            super.forceMetadataCallback();
        }

        public void getNotificationCount(Handler handler, Handler handler2) {
            verboseLog("Support.getNotificationCount(success, failure);");
            super.getNotificationCount(handler, handler2);
        }

        public void handlePush(Context context, Intent intent) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Core.handlePush(context, ");
            outline24.append(intent.toString());
            outline24.append(");");
            verboseLog(outline24.toString());
            super.handlePush(context, intent);
        }

        public void init() {
            verboseLog("Core.init(Support.getInstance());");
            super.init();
        }

        public void install(Application application, String str, String str2, String str3, InstallConfig installConfig) throws InstallException {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Core.install(application, apiKey(secret), domain(secret), appId(secret), ");
            outline24.append(installConfig.toMap().toString());
            outline24.append(");");
            verboseLog(outline24.toString());
            super.install(application, str, str2, str3, installConfig);
        }

        public void leaveBreadCrumb(String str) {
            verboseLog("Support.leaveBreadCrumb(\"" + str + "\");");
            super.leaveBreadCrumb(str);
        }

        public void login(HelpshiftUser helpshiftUser) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Core.login(");
            outline24.append(logUser(helpshiftUser));
            outline24.append(");");
            verboseLog(outline24.toString());
            super.login(helpshiftUser);
        }

        public void logout() {
            verboseLog("Core.logout();");
            super.logout();
        }

        public void registerDeviceToken(Context context, String str) {
            verboseLog("Core.registerDeviceToken(context, \"" + str + "\");");
            super.registerDeviceToken(context, str);
        }

        public void setDelegate(Support.Delegate delegate) {
            verboseLog("Support.setDelegate(delegate);");
            super.setDelegate(delegate);
        }

        public void setMetadataCallback(MetadataCallable metadataCallable) {
            verboseLog("Support.setMetadataCallback(metadataCallable);");
            super.setMetadataCallback(metadataCallable);
        }

        public void setSDKLanguage(String str) {
            verboseLog("Support.setSDKLanguage(\"" + str + "\");");
            super.setSDKLanguage(str);
        }

        public void showConversation(Activity activity, ApiConfig apiConfig) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Support.showConversation(");
            outline24.append(activity.toString());
            outline24.append(RESTClient.COMMA_SEPARATOR);
            outline24.append(apiConfig.toMap().toString());
            outline24.append(");");
            verboseLog(outline24.toString());
            super.showConversation(activity, apiConfig);
        }

        public void showFAQSection(Activity activity, String str, ApiConfig apiConfig) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Support.showFAQSection(");
            outline24.append(activity.toString());
            outline24.append(", \"");
            outline24.append(str);
            outline24.append("\", ");
            outline24.append(apiConfig.toMap().toString());
            outline24.append(");");
            verboseLog(outline24.toString());
            super.showFAQSection(activity, str, apiConfig);
        }

        public void showFAQs(Activity activity, ApiConfig apiConfig) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Support.showFAQs(");
            outline24.append(activity.toString());
            outline24.append(RESTClient.COMMA_SEPARATOR);
            outline24.append(apiConfig.toMap().toString());
            outline24.append(");");
            verboseLog(outline24.toString());
            Support.showFAQs(activity, apiConfig);
        }

        public void showSingleFAQ(Activity activity, String str, ApiConfig apiConfig) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Support.showSingleFAQ(");
            outline24.append(activity.toString());
            outline24.append(", \"");
            outline24.append(str);
            outline24.append("\", ");
            outline24.append(apiConfig.toMap().toString());
            outline24.append(");");
            verboseLog(outline24.toString());
            super.showSingleFAQ(activity, str, apiConfig);
        }

        public void handlePush(Context context, Bundle bundle) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Core.handlePush(context, ");
            outline24.append(bundle.toString());
            outline24.append(");");
            verboseLog(outline24.toString());
            super.handlePush(context, bundle);
        }
    }

    public static boolean acceptPush(final Context context, final Bundle bundle) {
        if (context == null || bundle == null || !bundle.getString("origin", "").equals("helpshift")) {
            return false;
        }
        if (isEnabled() && state.isPushNotificationsEnabled()) {
            queue.execute(new Runnable() {
                public void run() {
                    HelpshiftWrapper.state.getWrapper().handlePush(context, bundle);
                }
            });
        }
        return true;
    }

    public static boolean acceptPush(Object obj) {
        if (!(state.getApplicationContext() == null || obj == null)) {
            try {
                return acceptPush((Context) state.getApplicationContext(), (Bundle) obj);
            } catch (ClassCastException e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HelpshiftWrapper] acceptPush exception: ");
                outline24.append(e.getMessage());
                Logger.logError(outline24.toString());
            }
        }
        return false;
    }
}
