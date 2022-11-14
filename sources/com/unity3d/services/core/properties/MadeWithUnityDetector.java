package com.unity3d.services.core.properties;

public class MadeWithUnityDetector {
    public static final String UNITY_PLAYER_CLASS_NAME = "com.unity3d.player.UnityPlayer";

    public static boolean isMadeWithUnity() {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }
}
