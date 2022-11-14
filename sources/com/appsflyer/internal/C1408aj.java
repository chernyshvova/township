package com.appsflyer.internal;

import com.appsflyer.AFLogger;

/* renamed from: com.appsflyer.internal.aj */
public final class C1408aj {
    public C1410b AFInAppEventParameterName = new C1410b() {
        public final Class<?> AFInAppEventParameterName(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }
    };

    /* renamed from: com.appsflyer.internal.aj$b */
    public interface C1410b {
        Class<?> AFInAppEventParameterName(String str) throws ClassNotFoundException;
    }

    /* renamed from: com.appsflyer.internal.aj$d */
    public enum C1411d {
        ADOBE_AIR("android_adobe_air", "com.appsflyer.adobeair.AppsFlyerExtension"),
        ADOBE_MOBILE_SDK("android_adobe_mobile", "com.appsflyer.adobeextension.AppsFlyerAdobeExtension"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        CORDOVA("android_cordova", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        DEFAULT("android_native", "android_native"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin"),
        M_PARTICLE("android_mparticle", "com.mparticle.kits.AppsFlyerKit"),
        NATIVE_SCRIPT("android_native_script", "com.tns.NativeScriptActivity"),
        REACT_NATIVE("android_reactNative", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        SEGMENT("android_segment", "com.segment.analytics.android.integrations.appsflyer.AppsflyerIntegration"),
        UNITY("android_unity", "com.appsflyer.unity.AppsFlyerAndroidWrapper"),
        UNREAL_ENGINE("android_unreal", "com.epicgames.ue4.GameActivity"),
        XAMARIN("android_xamarin", "mono.android.app.XamarinAndroidEnvironmentVariables");
        
        public String onAppOpenAttributionNative;
        public String onInstallConversionFailureNative;

        /* access modifiers changed from: public */
        C1411d(String str, String str2) {
            this.onAppOpenAttributionNative = str;
            this.onInstallConversionFailureNative = str2;
        }
    }

    private boolean AFKeystoreWrapper(String str) {
        try {
            this.AFInAppEventParameterName.AFInAppEventParameterName(str);
            StringBuilder sb = new StringBuilder("Class: ");
            sb.append(str);
            sb.append(" is found.");
            AFLogger.AFKeystoreWrapper(sb.toString());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            AFLogger.values(th.getMessage(), th);
            return false;
        }
    }

    public final String values() {
        for (C1411d dVar : C1411d.values()) {
            if (AFKeystoreWrapper(dVar.onInstallConversionFailureNative)) {
                return dVar.onAppOpenAttributionNative;
            }
        }
        return C1411d.DEFAULT.onAppOpenAttributionNative;
    }
}
