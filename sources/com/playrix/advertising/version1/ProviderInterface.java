package com.playrix.advertising.version1;

import android.app.Activity;
import android.content.Intent;
import java.util.Map;

public interface ProviderInterface {
    public static final int CACHE_AUTO = 3;
    public static final int CACHE_AUTO_ONLY = 1;
    public static final int CACHE_MANUAL = 2;
    public static final int CACHE_MANUAL_ONLY = 0;
    public static final int MODE_INTERSTITIAL = 0;
    public static final int MODE_MORE_APPS = 2;
    public static final int MODE_REWARDED_VIDEO = 1;
    public static final int SHOW_CANCELED = 1;
    public static final int SHOW_FAILED = 0;
    public static final int SHOW_FINISHED = 2;
    public static final int STATE_DISABLED = 0;
    public static final int STATE_FAILED = 3;
    public static final int STATE_READY = 1;
    public static final int STATE_WAITING = 2;

    public interface Callbacks {
        void onAssert(String str);

        void onLoadFailed(int i, String str, String str2);

        void onLoadSuccess(int i, String str, String str2);

        void onLog(String str);

        void onShowDone(int i, String str, boolean z);

        void onShowFinish(int i);

        void onShowStart();

        void onTrackMediation(String str);
    }

    boolean cache(int i, String str);

    void enableAutoCache(boolean z);

    void execute();

    int getCacheMode();

    String getDebugInfo();

    String getName();

    int getState();

    String getVersion();

    void initialize(Map<String, String> map);

    boolean isModeAvailable(int i);

    boolean isReady(int i, String str);

    boolean isShowing();

    boolean onActivityResult(int i, int i2, Intent intent);

    boolean onBackPressed(Activity activity);

    void onCreate(Activity activity);

    void onDestroy(Activity activity);

    void onPause(Activity activity);

    void onResume(Activity activity);

    void onStart(Activity activity);

    void onStop(Activity activity);

    void setCallbacks(Callbacks callbacks);

    void setCallbacksId(int i);

    void setEnvironment(Map<String, String> map);

    void setImmersiveMode(boolean z);

    boolean show(int i, String str);
}
