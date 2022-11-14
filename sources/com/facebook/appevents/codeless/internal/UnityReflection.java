package com.facebook.appevents.codeless.internal;

import android.util.Log;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnityReflection.kt */
public final class UnityReflection {
    public static final String CAPTURE_VIEW_HIERARCHY_METHOD = "CaptureViewHierarchy";
    public static final String EVENT_MAPPING_METHOD = "OnReceiveMapping";
    public static final String FB_UNITY_GAME_OBJECT = "UnityFacebookSDKPlugin";
    public static final UnityReflection INSTANCE = new UnityReflection();
    public static final String TAG = UnityReflection.class.getCanonicalName();
    public static final String UNITY_PLAYER_CLASS = "com.unity3d.player.UnityPlayer";
    public static final String UNITY_SEND_MESSAGE_METHOD = "UnitySendMessage";
    public static Class<?> unityPlayer;

    public static final void captureViewHierarchy() {
        sendMessage(FB_UNITY_GAME_OBJECT, CAPTURE_VIEW_HIERARCHY_METHOD, "");
    }

    private final Class<?> getUnityPlayerClass() {
        Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
        Intrinsics.checkNotNullExpressionValue(cls, "forName(UNITY_PLAYER_CLASS)");
        return cls;
    }

    public static final void sendEventMapping(String str) {
        sendMessage(FB_UNITY_GAME_OBJECT, EVENT_MAPPING_METHOD, str);
    }

    public static final void sendMessage(String str, String str2, String str3) {
        Class<String> cls = String.class;
        try {
            if (unityPlayer == null) {
                unityPlayer = INSTANCE.getUnityPlayerClass();
            }
            Class<?> cls2 = unityPlayer;
            if (cls2 != null) {
                Method method = cls2.getMethod(UNITY_SEND_MESSAGE_METHOD, new Class[]{cls, cls, cls});
                Intrinsics.checkNotNullExpressionValue(method, "unityPlayer.getMethod(\n              UNITY_SEND_MESSAGE_METHOD, String::class.java, String::class.java, String::class.java)");
                Class<?> cls3 = unityPlayer;
                if (cls3 != null) {
                    method.invoke(cls3, new Object[]{str, str2, str3});
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("unityPlayer");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("unityPlayer");
            throw null;
        } catch (Exception e) {
            Log.e(TAG, "Failed to send message to Unity", e);
        }
    }
}
