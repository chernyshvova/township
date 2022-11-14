package com.helpshift;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.Core;
import com.helpshift.applifecycle.HSAppLifeCycleController;
import com.helpshift.common.HelpshiftUtils;
import com.helpshift.exceptions.HelpshiftInitializationException;
import com.helpshift.exceptions.InstallException;
import com.helpshift.exceptions.handlers.UncaughtExceptionHandler;
import com.helpshift.executors.ActionExecutor;
import com.helpshift.logger.Logger;
import com.helpshift.logger.logmodels.LogExtrasModelFactory;
import com.helpshift.logger.logmodels.LogExtrasModelProvider;
import com.helpshift.static_classes.ErrorReporting;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.SchemaUtil;
import com.helpshift.util.TextUtils;
import com.helpshift.util.concurrent.ApiExecutor;
import com.helpshift.util.concurrent.ApiExecutorFactory;
import java.util.HashMap;
import java.util.Map;

public class CoreInternal {
    public static final String TAG = "Helpshift_CoreInternal";
    public static Core.ApiProvider apiProvider;

    public static void clearAnonymousUser() {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    CoreInternal.apiProvider._clearAnonymousUser();
                    HSLogger.m3237d(CoreInternal.TAG, "resetAnonymousUser API called");
                }
            });
        }
    }

    public static ActionExecutor getActionExecutor() {
        return apiProvider._getActionExecutor();
    }

    public static void handlePush(final Context context, final Intent intent) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    HSLogger.m3237d(CoreInternal.TAG, "Handling push");
                    CoreInternal.apiProvider._handlePush(context, intent);
                }
            });
        }
    }

    public static void init(Core.ApiProvider apiProvider2) {
        apiProvider = apiProvider2;
    }

    public static void initLogging(Context context, Map map) {
        Object obj = map.get("enableLogging");
        boolean z = false;
        boolean z2 = (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
        Object obj2 = map.get("disableErrorReporting");
        if ((obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue()) {
            z = true;
        }
        float serverTimeDelta = HelpshiftContext.getPlatform().getNetworkRequestDAO().getServerTimeDelta();
        HSLogger.initialize(new Logger(context, HSLogger.LOG_STORE_DB_NAME, "7.11.0"), ApplicationUtil.isApplicationDebuggable(context) ? 2 : 4, HelpshiftContext.getCoreApi().getSDKConfigurationDM().getRequiredLogCachingLevel());
        LogExtrasModelProvider.initialize(new LogExtrasModelFactory());
        HSLogger.updateTimeStampDelta(serverTimeDelta);
        HSLogger.enableLogging(z2, !z);
        ErrorReporting.shouldEnable(!z);
        if (!z) {
            UncaughtExceptionHandler.init(context);
        }
    }

    public static void install(Application application, String str, String str2, String str3) throws InstallException {
        install(application, str, str2, str3, new HashMap());
    }

    public static void login(final HelpshiftUser helpshiftUser) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    if (HelpshiftUtils.isValidHelpshiftUser(helpshiftUser)) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Login state changed : name : ");
                        outline24.append(helpshiftUser.getName());
                        HSLogger.m3237d(CoreInternal.TAG, outline24.toString());
                        CoreInternal.apiProvider._login(helpshiftUser);
                        return;
                    }
                    HSLogger.m3237d(CoreInternal.TAG, "Login called with invalid helpshift user,So calling Logout");
                    CoreInternal.apiProvider._logout();
                }
            });
        }
    }

    public static void logout() {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    CoreInternal.apiProvider._logout();
                    HSLogger.m3237d(CoreInternal.TAG, "Logged out.");
                }
            });
        }
    }

    public static void onAppBackground() {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    HSLogger.m3237d(CoreInternal.TAG, "Application background");
                    HSAppLifeCycleController.getInstance().onManualAppBackgroundAPI();
                }
            });
        }
    }

    public static void onAppForeground() {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    HSLogger.m3237d(CoreInternal.TAG, "Application foreground");
                    HSAppLifeCycleController.getInstance().onManualAppForegroundAPI();
                }
            });
        }
    }

    public static void registerDeviceToken(final Context context, final String str) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Registering push token : ");
                    outline24.append(str);
                    HSLogger.m3237d(CoreInternal.TAG, outline24.toString());
                    CoreInternal.apiProvider._registerDeviceToken(context, str);
                }
            });
        }
    }

    public static void setNameAndEmail(final String str, final String str2) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    CoreInternal.apiProvider._setNameAndEmail(str, str2);
                }
            });
        }
    }

    public static void setSDKLanguage(final String str) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Setting SDK language : ");
                    outline24.append(str);
                    HSLogger.m3237d(CoreInternal.TAG, outline24.toString());
                    CoreInternal.apiProvider._setSDKLanguage(str);
                }
            });
        }
    }

    public static void setTheme(final int i) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Setting SDK theme : ");
                    outline24.append(i);
                    HSLogger.m3237d(CoreInternal.TAG, outline24.toString());
                    CoreInternal.apiProvider._setTheme(i);
                }
            });
        }
    }

    public static void verifyInit() {
        if (apiProvider == null) {
            throw new HelpshiftInitializationException("com.helpshift.Core.init() method not called with valid arguments");
        }
    }

    public static void install(Application application, String str, String str2, String str3, Map map) throws InstallException {
        verifyInit();
        if (!TextUtils.isEmpty(str)) {
            str = str.trim();
        }
        String trim = !TextUtils.isEmpty(str2) ? str2.trim() : str2;
        if (!TextUtils.isEmpty(str3)) {
            str3 = str3.trim();
        }
        SchemaUtil.validateInstallCredentials(str, trim, str3);
        ApiExecutor handlerExecutor = ApiExecutorFactory.getHandlerExecutor();
        final Application application2 = application;
        final String str4 = str;
        final String str5 = trim;
        final String str6 = str3;
        final Map map2 = map;
        handlerExecutor.runSync(new Runnable() {
            public void run() {
                if (!HelpshiftContext.installCallSuccessful.get()) {
                    CoreInternal.apiProvider._preInstall(application2, str4, str5, str6, map2);
                }
            }
        });
        final Map map3 = map;
        final String str7 = str2;
        final String str8 = str;
        final String str9 = trim;
        final String str10 = str3;
        handlerExecutor.runAsync(new Runnable() {
            public void run() {
                if (!HelpshiftContext.installCallSuccessful.get()) {
                    CoreInternal.initLogging(application2.getApplicationContext(), map3);
                    HSLogger.m3237d(CoreInternal.TAG, "Helpshift install :\n Flavor : " + CoreInternal.apiProvider.getClass().getSimpleName() + "\n Domain : " + str7 + "\n Config : " + map3.toString() + "\n Package Id : " + application2.getPackageName() + "\n SDK version : " + "7.11.0" + "\n OS version : " + Build.VERSION.SDK_INT + "\n Device : " + Build.DEVICE);
                    CoreInternal.apiProvider._install(application2, str8, str9, str10, map3);
                    HelpshiftContext.installCallSuccessful.compareAndSet(false, true);
                    if (PluginEventBridge.shouldCallFirstForegroundEvent()) {
                        HSAppLifeCycleController.getInstance().onAppForeground(application2.getApplicationContext());
                    }
                }
            }
        });
        HelpshiftContext.installAPICalled.compareAndSet(false, true);
    }

    public static void handlePush(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        handlePush(context, intent);
    }

    public static void handlePush(Context context, Map<String, String> map) {
        if (map != null && map.size() != 0) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            for (Map.Entry next : map.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            intent.putExtras(bundle);
            handlePush(context, intent);
        }
    }
}
