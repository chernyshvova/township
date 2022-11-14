package com.playrix.township.lib;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.engine.BlockingManager;
import com.playrix.engine.Engine;
import com.playrix.engine.EngineActivity;
import com.playrix.engine.GLSurfaceView;
import com.playrix.engine.ImmersiveMode;
import com.playrix.engine.Logger;
import com.playrix.lib.VideoAdUtils;
import java.io.File;

public abstract class GameActivity extends EngineActivity implements BlockingManager.IBlockingSectionListener {
    public static volatile long HIDDEN_FOR_LONG_TIME_PERIOD = 25;
    public static final String NOT_FIRST_ACTIVITY_WARNING = "It's not a first activity.";
    public static final String TAG = "GameActivity";
    public static int activityCreateCounter;
    public static volatile boolean becomeActiveFromActivity = false;
    public static final Handler handler = new Handler();
    public static final Runnable hiddenForLongTime = new Runnable() {
        public void run() {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    GameActivity.nativeHiddenForLongTime();
                }
            });
        }
    };

    public static boolean becomeActiveFromActivityResult() {
        return becomeActiveFromActivity;
    }

    private void createNoMediaFiles() {
        try {
            File file = new File(Engine.getExternalStoragePath(), ".nomedia");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable unused) {
        }
    }

    public static native void nativeHiddenForLongTime();

    public static native void nativeOnBackPressed();

    public static native void nativeSetGameScale(double d);

    private void setGameScale() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        double d = (double) displayMetrics.heightPixels;
        double d2 = (double) displayMetrics.densityDpi;
        Double.isNaN(d);
        Double.isNaN(d2);
        final double d3 = d / d2;
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                GameActivity.nativeSetGameScale(d3);
            }
        });
    }

    public static void setHiddenForLongTimePeriod(int i) {
        HIDDEN_FOR_LONG_TIME_PERIOD = (long) i;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        becomeActiveFromActivity = true;
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                GameActivity.nativeOnBackPressed();
            }
        });
        try {
            super.onBackPressed();
        } catch (IllegalStateException unused) {
        }
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(9);
        requestWindowFeature(10);
        Logger.logInfo("GameActivity onCreate");
        activityCreateCounter++;
        Engine.onCreate(this);
        Utils.onCreate();
        createNoMediaFiles();
        Engine.getPreferences();
        super.onCreate(bundle);
        BlockingManager.addBlockingListener(this);
        becomeActiveFromActivity = false;
        setGameScale();
        ImmersiveMode.enable(!Settings.isImmersiveModeDisabled());
        VideoAdUtils.isWebviewValidCached(this);
        if (activityCreateCounter > 1) {
            Logger.logWarning("GameActivity It's not a first activity.");
        }
    }

    public void onDestroy() {
        Logger.logInfo("GameActivity onDestroy");
        BlockingManager.removeBlockingListener(this);
        if (hiddenForLongTime != null && Utils.getSharedPreferencesBool("_ProcessHiddenForLongTimeOnDestroy_", true)) {
            hiddenForLongTime.run();
        }
        super.onDestroy();
    }

    public void onEnterBlockingSection() {
        Logger.logInfo("GameActivity Disable touch");
        GLSurfaceView.setDeliverTouchEvents(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public void onLeaveBlockingSection() {
        Logger.logInfo("GameActivity Enable touch");
        GLSurfaceView.setDeliverTouchEvents(true);
    }

    public void onPause() {
        Logger.logInfo("GameActivity onPause start");
        becomeActiveFromActivity = false;
        super.onPause();
        Logger.logInfo("GameActivity onPause end");
    }

    public void onResume() {
        Logger.logInfo("GameActivity onResume start");
        super.onResume();
        Logger.logInfo("GameActivity onResume end");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        Intent intent = getIntent();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("GameActivity onStart ");
        outline24.append(intent.getAction());
        outline24.append(", data ");
        outline24.append(intent.getData());
        outline24.append(", extras: ");
        outline24.append(intent.getExtras());
        outline24.append(", flags: ");
        outline24.append(Integer.toHexString(intent.getFlags()));
        Logger.logInfo(outline24.toString());
        super.onStart();
        handler.removeCallbacks(hiddenForLongTime);
    }

    public void onStop() {
        Logger.logInfo("GameActivity onStop");
        super.onStop();
        handler.postDelayed(hiddenForLongTime, HIDDEN_FOR_LONG_TIME_PERIOD * 1000);
    }

    public void onWindowFocusChanged(boolean z) {
        Logger.logInfo("GameActivity onWindowFocusChanged start f:" + z);
        super.onWindowFocusChanged(z);
        Logger.logInfo("GameActivity onWindowFocusChanged end");
    }
}
