package com.unity3d.ads;

import android.app.Activity;
import android.content.Context;
import com.unity3d.services.UnityServices;
import com.unity3d.services.ads.UnityAdsImplementation;

public final class UnityAds {

    public enum UnityAdsInitializationError {
        INTERNAL_ERROR,
        INVALID_ARGUMENT,
        AD_BLOCKER_DETECTED
    }

    public enum UnityAdsLoadError {
        INITIALIZE_FAILED,
        INTERNAL_ERROR,
        INVALID_ARGUMENT,
        NO_FILL,
        TIMEOUT
    }

    public enum UnityAdsShowCompletionState {
        SKIPPED,
        COMPLETED
    }

    public enum UnityAdsShowError {
        NOT_INITIALIZED,
        NOT_READY,
        VIDEO_PLAYER_ERROR,
        INVALID_ARGUMENT,
        NO_CONNECTION,
        ALREADY_SHOWING,
        INTERNAL_ERROR
    }

    public static boolean getDebugMode() {
        return UnityAdsImplementation.getDebugMode();
    }

    public static String getToken() {
        return UnityAdsImplementation.getToken();
    }

    public static String getVersion() {
        return UnityAdsImplementation.getVersion();
    }

    public static void initialize(Context context, String str) {
        UnityAdsImplementation.initialize(context, str, false, (IUnityAdsInitializationListener) null);
    }

    public static boolean isInitialized() {
        return UnityServices.isInitialized();
    }

    public static boolean isSupported() {
        return UnityAdsImplementation.isSupported();
    }

    @Deprecated
    public static void load(String str) {
        load(str, new IUnityAdsLoadListener() {
            public void onUnityAdsAdLoaded(String str) {
            }

            public void onUnityAdsFailedToLoad(String str, UnityAdsLoadError unityAdsLoadError, String str2) {
            }
        });
    }

    public static void setDebugMode(boolean z) {
        UnityAdsImplementation.setDebugMode(z);
    }

    @Deprecated
    public static void show(Activity activity, String str) {
        UnityAdsImplementation.show(activity, str, (IUnityAdsShowListener) null);
    }

    public static void initialize(Context context, String str, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        UnityAdsImplementation.initialize(context, str, false, iUnityAdsInitializationListener);
    }

    public static void load(String str, IUnityAdsLoadListener iUnityAdsLoadListener) {
        UnityAdsImplementation.load(str, new UnityAdsLoadOptions(), iUnityAdsLoadListener);
    }

    public static void show(Activity activity, String str, IUnityAdsShowListener iUnityAdsShowListener) {
        UnityAdsImplementation.show(activity, str, iUnityAdsShowListener);
    }

    public static void initialize(Context context, String str, boolean z) {
        UnityAdsImplementation.initialize(context, str, z, (IUnityAdsInitializationListener) null);
    }

    public static void load(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener) {
        UnityAdsImplementation.load(str, unityAdsLoadOptions, iUnityAdsLoadListener);
    }

    @Deprecated
    public static void show(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions) {
        UnityAdsImplementation.show(activity, str, unityAdsShowOptions, (IUnityAdsShowListener) null);
    }

    public static void initialize(Context context, String str, boolean z, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        UnityAdsImplementation.initialize(context, str, z, iUnityAdsInitializationListener);
    }

    public static void show(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions, IUnityAdsShowListener iUnityAdsShowListener) {
        UnityAdsImplementation.show(activity, str, unityAdsShowOptions, iUnityAdsShowListener);
    }
}
