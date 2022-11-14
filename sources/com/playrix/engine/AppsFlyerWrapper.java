package com.playrix.engine;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import java.util.HashMap;
import java.util.Map;

public class AppsFlyerWrapper {
    public static volatile AppsFlyerLib mAppsFlyer;
    public static final DeferredExecuteQueue mDeferredTasks = new DeferredExecuteQueue();
    public static final Handler mUiThreadHandler = new Handler(Looper.getMainLooper());

    public static AppsFlyerConversionListener createConversionListener() {
        return new AppsFlyerConversionListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
                r1 = android.net.Uri.parse(r4.get(r1)).getQueryParameter("af_dp");
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onAppOpenAttribution(final java.util.Map<java.lang.String, java.lang.String> r4) {
                /*
                    r3 = this;
                    java.util.Set r0 = r4.keySet()
                    java.util.Iterator r0 = r0.iterator()
                L_0x0008:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L_0x0043
                    java.lang.Object r1 = r0.next()
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.String r2 = "link"
                    boolean r2 = r1.equals(r2)
                    if (r2 == 0) goto L_0x0008
                    java.lang.Object r2 = r4.get(r1)
                    if (r2 == 0) goto L_0x0008
                    java.lang.Object r1 = r4.get(r1)
                    java.lang.String r1 = (java.lang.String) r1
                    android.net.Uri r1 = android.net.Uri.parse(r1)
                    java.lang.String r2 = "af_dp"
                    java.lang.String r1 = r1.getQueryParameter(r2)
                    if (r1 == 0) goto L_0x0008
                    boolean r2 = r1.isEmpty()
                    if (r2 != 0) goto L_0x0008
                    com.playrix.engine.AppsFlyerWrapper$5$3 r2 = new com.playrix.engine.AppsFlyerWrapper$5$3
                    r2.<init>(r1, r4)
                    com.playrix.engine.Engine.runOnGLThread(r2)
                    goto L_0x0008
                L_0x0043:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.AppsFlyerWrapper.C30155.onAppOpenAttribution(java.util.Map):void");
            }

            public void onAttributionFailure(final String str) {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        AppsFlyerWrapper.nativeOnAppOpenAttributionFailure(str);
                    }
                });
            }

            public void onConversionDataFail(final String str) {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        AppsFlyerWrapper.nativeOnInstallConversionFailure(str);
                    }
                });
            }

            public void onConversionDataSuccess(final Map<String, Object> map) {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        HashMap hashMap = new HashMap();
                        Map map = map;
                        if (map != null) {
                            for (Map.Entry entry : map.entrySet()) {
                                if (entry.getValue() != null) {
                                    hashMap.put(entry.getKey(), entry.getValue().toString());
                                }
                            }
                        }
                        AppsFlyerWrapper.nativeOnInstallConversionDataLoaded(hashMap);
                    }
                });
            }
        };
    }

    public static AppsFlyerInAppPurchaseValidatorListener createValidatorListener() {
        return new AppsFlyerInAppPurchaseValidatorListener() {
            public void onValidateInApp() {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        AppsFlyerWrapper.nativeOnValidateInApp();
                    }
                });
            }

            public void onValidateInAppFailure(final String str) {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        AppsFlyerWrapper.nativeOnValidateInAppFailure(str);
                    }
                });
            }
        };
    }

    public static String getAttributeName(String str) {
        try {
            return (String) AFInAppEventParameterName.class.getField(str).get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getEventName(String str) {
        try {
            return (String) AFInAppEventType.class.getField(str).get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSdkVersion() {
        return AppsFlyerLib.getInstance().getSdkVersion();
    }

    public static boolean initialize(final String str, final boolean z) {
        return NativeThread.getInstance().queueInitalizeEvent(new Runnable() {
            public void run() {
                AppsFlyerWrapper.initializeTracker(str, z);
                AppsFlyerWrapper.mDeferredTasks.process();
            }
        });
    }

    public static void initializeTracker(String str, boolean z) {
        AppsFlyerLib instance = AppsFlyerLib.getInstance();
        instance.setDebugLog(z);
        instance.setCollectIMEI(false);
        instance.setAndroidIdData(Engine.getAndroidId());
        instance.waitForCustomerUserId(true);
        instance.init(str, createConversionListener(), Engine.getApplication());
        instance.registerValidatorListener(Engine.getApplication(), createValidatorListener());
        mAppsFlyer = instance;
        mAppsFlyer.start(Engine.getApplication(), str);
    }

    public static native void nativeOnAppOpenAttribution(String str, Map<String, String> map);

    public static native void nativeOnAppOpenAttributionFailure(String str);

    public static native void nativeOnInstallConversionDataLoaded(Map<String, String> map);

    public static native void nativeOnInstallConversionFailure(String str);

    public static native void nativeOnUserAgentResult(String str);

    public static native void nativeOnValidateInApp();

    public static native void nativeOnValidateInAppFailure(String str);

    public static void requestWebViewUserAgent() {
        mUiThreadHandler.post(new Runnable() {
            public void run() {
                try {
                    AppsFlyerWrapper.resultWebViewUserAgent(new WebView(Engine.getContext()).getSettings().getUserAgentString());
                } catch (Exception unused) {
                    AppsFlyerWrapper.resultWebViewUserAgent((String) null);
                }
            }
        });
    }

    public static void resultWebViewUserAgent(final String str) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                AppsFlyerWrapper.nativeOnUserAgentResult(str);
            }
        });
    }

    public static void setUserId(final String str) {
        if (str != null && !str.isEmpty()) {
            mDeferredTasks.execute(new Runnable() {
                public void run() {
                    AppsFlyerLib.getInstance().setCustomerIdAndLogSession(str, Engine.getApplication());
                }
            });
        }
    }

    public static void trackEvent(final String str, final Map<String, Object> map) {
        mDeferredTasks.execute(new Runnable() {
            public void run() {
                AppsFlyerWrapper.mAppsFlyer.logEvent(Engine.getApplication(), str, map);
            }
        });
    }

    public static void updateServerUninstallToken(final String str) {
        mDeferredTasks.execute(new Runnable() {
            public void run() {
                AppsFlyerLib.getInstance().updateServerUninstallToken(Engine.getApplication(), str);
            }
        });
    }

    public static void validatePurchase(Map<String, String> map, String str, String str2, String str3, String str4, String str5) {
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        final Map<String, String> map2 = map;
        mDeferredTasks.execute(new Runnable() {
            public void run() {
                AppsFlyerWrapper.mAppsFlyer.validateAndLogInAppPurchase(Engine.getApplication(), str6, str7, str8, str9, str10, map2);
            }
        });
    }
}
