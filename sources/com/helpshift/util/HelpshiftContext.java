package com.helpshift.util;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.helpshift.CoreApi;
import com.helpshift.JavaCore;
import com.helpshift.app.CampaignAppLifeCycleListener;
import com.helpshift.common.HSBlockReason;
import com.helpshift.common.platform.AndroidPlatform;
import com.helpshift.common.platform.Platform;
import com.helpshift.exceptions.HelpshiftInitializationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class HelpshiftContext {
    public static final String TAG = "Helpshift_Context";
    public static CampaignAppLifeCycleListener campaignAppLifeCycleListener;
    public static Context context;
    public static CoreApi coreApi;
    public static AtomicBoolean installAPICalled = new AtomicBoolean(false);
    public static AtomicBoolean installCallSuccessful = new AtomicBoolean(false);
    public static final Object lock = new Object();
    public static Platform platform;

    public static Context getApplicationContext() {
        return context;
    }

    public static CampaignAppLifeCycleListener getCampaignAppLifeCycleListener() {
        return campaignAppLifeCycleListener;
    }

    public static CoreApi getCoreApi() {
        return coreApi;
    }

    public static Platform getPlatform() {
        return platform;
    }

    public static void initializeCore(String str, String str2, String str3) {
        if (platform == null) {
            platform = new AndroidPlatform(context, str, str2, str3);
        }
        if (coreApi == null) {
            coreApi = new JavaCore(platform);
        }
    }

    public static void setApplicationContext(Context context2) {
        synchronized (lock) {
            if (context == null) {
                context = context2;
            }
        }
    }

    public static void setCampaignAppLifeCycleListener(@NonNull CampaignAppLifeCycleListener campaignAppLifeCycleListener2) {
        if (campaignAppLifeCycleListener == null) {
            campaignAppLifeCycleListener = campaignAppLifeCycleListener2;
        }
    }

    public static boolean verifyInstall() {
        if (!installAPICalled.get()) {
            Context context2 = context;
            if (context2 == null || context2.getApplicationInfo() == null) {
                Log.e(TAG, "com.helpshift.Core.install() method not called with valid arguments");
                return false;
            } else if (!ApplicationUtil.isApplicationDebuggable(context)) {
                Log.e(TAG, "com.helpshift.Core.install() method not called with valid arguments");
                return false;
            } else {
                throw new HelpshiftInitializationException("com.helpshift.Core.install() method not called with valid arguments");
            }
        } else {
            CoreApi coreApi2 = coreApi;
            if (coreApi2 == null || coreApi2.getDomain() == null || coreApi.getDomain().getReasonForBlockAPI() != HSBlockReason.FETCH_ACTIVE_USER_ERROR) {
                return true;
            }
            Log.e(TAG, "ConversationInboxManagerDM Error in fetching active user from DB");
            return false;
        }
    }
}
