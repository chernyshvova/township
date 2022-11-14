package com.playrix.engine;

import com.playrix.gamecenter.BuildConfig;

public class GameCenter {
    public static final int AUTHENTICATION_RESULT_CANCELED = 2;
    public static final int AUTHENTICATION_RESULT_FAILED = 1;
    public static final int AUTHENTICATION_RESULT_NOT_AUTHENTICATED = 3;
    public static final int AUTHENTICATION_RESULT_RECOVERABLE = 4;
    public static final int AUTHENTICATION_RESULT_SUCCESS = 0;
    public static final int AUTHENTICATION_RESULT_TURNED_OFF = 5;
    public static final int AUTHENTICATION_RESULT_UNKNOWN = -1;
    public static final int GAME_CENTER_TYPE_GOOGLE = 1;
    public static final int GAME_CENTER_TYPE_NONE = 0;
    public static IGameCenter impl;

    public interface IGameCenter {
        int getErrorCode();

        void getPlayGamesAuthCodeWithCallback(long j);

        String getPlayerId();

        String getPlayerName();

        String getPlayerToken();

        boolean isAuthenticated();

        boolean isSupported();

        void setAchievementProgress(String str, float f);

        void setLeaderboardScore(String str, long j);

        void showAchievements();

        void showAuth();

        void showLeaderboard(String str);

        void signOutGC();

        void silentSignIn();

        void submitData();
    }

    public static int getErrorCode() {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            return iGameCenter.getErrorCode();
        }
        return 5;
    }

    public static void getPlayGamesAuthCodeWithCallback(long j) {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            iGameCenter.getPlayGamesAuthCodeWithCallback(j);
        }
    }

    public static String getPlayerId() {
        IGameCenter iGameCenter = impl;
        return iGameCenter != null ? iGameCenter.getPlayerId() : "";
    }

    public static String getPlayerName() {
        IGameCenter iGameCenter = impl;
        return iGameCenter != null ? iGameCenter.getPlayerName() : "";
    }

    public static String getPlayerToken() {
        IGameCenter iGameCenter = impl;
        return iGameCenter != null ? iGameCenter.getPlayerToken() : "";
    }

    public static int getType() {
        String flavor = Engine.getFlavor(BuildConfig.LIBRARY_PACKAGE_NAME);
        if (flavor != null) {
            return (flavor.equals("google") || flavor.equals(BuildConfig.FLAVOR)) ? 1 : 0;
        }
        return 0;
    }

    public static void init(IGameCenter iGameCenter) {
        impl = iGameCenter;
    }

    public static boolean isAuthenticated() {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            return iGameCenter.isAuthenticated();
        }
        return false;
    }

    public static boolean isSupported() {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            return iGameCenter.isSupported();
        }
        return false;
    }

    public static native void nativeAchievementsLoaded();

    public static native void nativeGetPlayGamesAuthCodeFinished(long j, String str);

    public static native void nativeSignInCompleted();

    public static void setAchievementProgress(String str, float f) {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            iGameCenter.setAchievementProgress(str, f);
        }
    }

    public static void setLeaderboardScore(String str, long j) {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            iGameCenter.setLeaderboardScore(str, j);
        }
    }

    public static void showAchievements() {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            iGameCenter.showAchievements();
        }
    }

    public static void showAuth() {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            iGameCenter.showAuth();
        }
    }

    public static void showLeaderboard(String str) {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            iGameCenter.showLeaderboard(str);
        }
    }

    public static void signOut() {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            iGameCenter.signOutGC();
        }
    }

    public static void silentSignIn() {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            iGameCenter.silentSignIn();
        }
    }

    public static void submitData() {
        IGameCenter iGameCenter = impl;
        if (iGameCenter != null) {
            iGameCenter.submitData();
        }
    }
}
