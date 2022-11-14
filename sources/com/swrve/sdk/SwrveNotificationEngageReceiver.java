package com.swrve.sdk;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.swrve.sdk.notifications.model.SwrveNotification;
import com.swrve.sdk.notifications.model.SwrveNotificationButton;
import java.util.Date;
import java.util.Map;

public class SwrveNotificationEngageReceiver extends BroadcastReceiver {
    public Context context;

    /* renamed from: com.swrve.sdk.SwrveNotificationEngageReceiver$1 */
    public static /* synthetic */ class C16891 {

        /* renamed from: $SwitchMap$com$swrve$sdk$notifications$model$SwrveNotificationButton$ActionType */
        public static final /* synthetic */ int[] f2782x3d843945;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.swrve.sdk.notifications.model.SwrveNotificationButton$ActionType[] r0 = com.swrve.sdk.notifications.model.SwrveNotificationButton.ActionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2782x3d843945 = r0
                r1 = 1
                com.swrve.sdk.notifications.model.SwrveNotificationButton$ActionType r2 = com.swrve.sdk.notifications.model.SwrveNotificationButton.ActionType.OPEN_URL     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f2782x3d843945     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.notifications.model.SwrveNotificationButton$ActionType r3 = com.swrve.sdk.notifications.model.SwrveNotificationButton.ActionType.OPEN_APP     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f2782x3d843945     // Catch:{ NoSuchFieldError -> 0x001d }
                com.swrve.sdk.notifications.model.SwrveNotificationButton$ActionType r3 = com.swrve.sdk.notifications.model.SwrveNotificationButton.ActionType.OPEN_CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2782x3d843945     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.swrve.sdk.notifications.model.SwrveNotificationButton$ActionType r2 = com.swrve.sdk.notifications.model.SwrveNotificationButton.ActionType.DISMISS     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveNotificationEngageReceiver.C16891.<clinit>():void");
        }
    }

    private void closeNotificationBar() {
        this.context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    private void executeCustomNotificationListener(Bundle bundle) {
        SwrvePushNotificationListener notificationListener = SwrveCommon.getInstance().getNotificationListener();
        if (notificationListener != null) {
            notificationListener.onPushNotification(SwrveHelper.convertPayloadToJSONObject(bundle));
        }
    }

    private int generateTimestampId() {
        return (int) (new Date().getTime() % 2147483647L);
    }

    private Class<?> getActivityClass() {
        String str;
        SwrveNotificationConfig notificationConfig = SwrveCommon.getInstance().getNotificationConfig();
        if (notificationConfig != null && notificationConfig.getActivityClass() != null) {
            return notificationConfig.getActivityClass();
        }
        try {
            PackageManager packageManager = this.context.getPackageManager();
            ResolveInfo resolveActivity = packageManager.resolveActivity(packageManager.getLaunchIntentForPackage(this.context.getPackageName()), 65536);
            if (resolveActivity != null) {
                str = resolveActivity.activityInfo.name;
                if (str.startsWith(CodelessMatcher.CURRENT_CLASS_NAME)) {
                    str = this.context.getPackageName() + str;
                }
            } else {
                str = null;
            }
            if (!SwrveHelper.isNotNullOrEmpty(str)) {
                return null;
            }
            if (str.startsWith(CodelessMatcher.CURRENT_CLASS_NAME)) {
                str = this.context.getPackageName() + str;
            }
            return Class.forName(str);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception getting activity class to start when notification is engaged.", e, new Object[0]);
            return null;
        }
    }

    private Intent getActivityIntent(Bundle bundle) {
        Class<?> activityClass = getActivityClass();
        if (activityClass == null) {
            return null;
        }
        Intent intent = new Intent(this.context, activityClass);
        intent.putExtra(SwrveNotificationConstants.PUSH_BUNDLE, bundle);
        intent.setAction("openActivity");
        return intent;
    }

    private void openActivity(Bundle bundle) throws PendingIntent.CanceledException {
        PendingIntent.getActivity(this.context, generateTimestampId(), getActivityIntent(bundle), 134217728).send();
        closeNotificationBar();
    }

    private void openDeeplink(Bundle bundle, String str) {
        SwrveLogger.m2752d("Found push deeplink. Will attempt to open: %s", str);
        Bundle bundle2 = new Bundle(bundle);
        bundle2.remove(SwrveNotificationInternalPayloadConstants.SWRVE_TRACKING_KEY);
        bundle2.remove(SwrveNotificationInternalPayloadConstants.DEEPLINK_KEY);
        SwrveIntentHelper.openDeepLink(this.context, str, bundle2);
        closeNotificationBar();
    }

    private void processIntent(Intent intent) throws Exception {
        Bundle extras;
        Bundle bundle;
        if (intent != null && (extras = intent.getExtras()) != null && !extras.isEmpty() && (bundle = extras.getBundle(SwrveNotificationConstants.PUSH_BUNDLE)) != null) {
            Object obj = bundle.get(SwrveNotificationInternalPayloadConstants.SWRVE_TRACKING_KEY);
            String obj2 = obj != null ? obj.toString() : null;
            if (!SwrveHelper.isNullOrEmpty(obj2)) {
                new SwrveCampaignInfluence().removeInfluenceCampaign(this.context, obj2);
                String string = extras.getString(SwrveNotificationConstants.CONTEXT_ID_KEY);
                if (SwrveHelper.isNotNullOrEmpty(string)) {
                    sendButtonEngagedEvent(extras, bundle, obj2, string);
                } else {
                    setNotificationSwrveCampaignIdFromPayload(bundle);
                    sendEngagedEvent(extras, bundle, obj2);
                }
                executeCustomNotificationListener(bundle);
            }
        }
    }

    private void sendButtonEngagedEvent(Bundle bundle, Bundle bundle2, String str, String str2) throws Exception {
        SwrveLogger.m2752d("Found engaged event: %s, with contextId: %s", str, str2);
        String string = bundle.getString(SwrveNotificationConstants.CAMPAIGN_TYPE);
        Map<String, String> bundleAsMap = SwrveHelper.getBundleAsMap(bundle.getBundle(SwrveNotificationConstants.EVENT_PAYLOAD));
        EventHelper.sendEngagedEvent(this.context, string, str, bundleAsMap);
        bundleAsMap.put(ISwrveCommon.GENERIC_EVENT_PAYLOAD_BUTTON_TEXT, bundle.getString(SwrveNotificationConstants.BUTTON_TEXT_KEY));
        EventHelper.sendButtonClickEvent(this.context, string, str, str2, bundleAsMap);
        int ordinal = ((SwrveNotificationButton.ActionType) bundle.get("action_type")).ordinal();
        if (ordinal == 0) {
            openDeeplink(bundle2, bundle.getString(SwrveNotificationConstants.PUSH_ACTION_URL_KEY));
        } else if (ordinal == 1) {
            openActivity(bundle2);
        } else if (ordinal == 2) {
            setNotificationSwrveCampaignIdFromButtonAction(bundle.getString(SwrveNotificationConstants.PUSH_ACTION_URL_KEY));
            openActivity(bundle2);
        }
        closeNotification(bundle.getInt("notification_id"));
    }

    private void sendEngagedEvent(Bundle bundle, Bundle bundle2, String str) throws Exception {
        SwrveLogger.m2752d("Found engaged event: %s", str);
        EventHelper.sendEngagedEvent(this.context, bundle.getString(SwrveNotificationConstants.CAMPAIGN_TYPE), str, SwrveHelper.getBundleAsMap(bundle.getBundle(SwrveNotificationConstants.EVENT_PAYLOAD)));
        if (bundle2.containsKey(SwrveNotificationInternalPayloadConstants.DEEPLINK_KEY)) {
            openDeeplink(bundle2, bundle2.getString(SwrveNotificationInternalPayloadConstants.DEEPLINK_KEY));
        } else {
            openActivity(bundle2);
        }
    }

    private void setNotificationSwrveCampaignIdFromButtonAction(String str) {
        ISwrveCommon instance = SwrveCommon.getInstance();
        if (SwrveHelper.isNotNullOrEmpty(str)) {
            instance.setNotificationSwrveCampaignId(str);
        }
    }

    private void setNotificationSwrveCampaignIdFromPayload(Bundle bundle) {
        SwrveNotification fromJson;
        ISwrveCommon instance = SwrveCommon.getInstance();
        String string = bundle.getString(SwrveNotificationInternalPayloadConstants.SWRVE_PAYLOAD_KEY);
        if (SwrveHelper.isNotNullOrEmpty(string) && (fromJson = SwrveNotification.fromJson(string)) != null && fromJson.getCampaign() != null) {
            instance.setNotificationSwrveCampaignId(fromJson.getCampaign().getId());
        }
    }

    public void closeNotification(int i) {
        ((NotificationManager) this.context.getSystemService(SwrveNotificationConstants.PUSH_BUNDLE)).cancel(i);
    }

    public void onReceive(Context context2, Intent intent) {
        try {
            this.context = context2;
            processIntent(intent);
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveNotificationEngageReceiver. Error processing intent. Intent: %s", e, intent.toString());
        }
    }
}
