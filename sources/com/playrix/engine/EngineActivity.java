package com.playrix.engine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.playrix.engine.Dialog;
import java.lang.reflect.Field;
import org.fmod.FMOD;

public class EngineActivity extends LifeCycleActivity implements Dialog.FocusListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public static final String LOG_TAG = "PlayrixEngine";
    public static final int VIEW_ORIENTATIONS_LANDSCAPE_AND_PORTRAIT = 2;
    public static final int VIEW_ORIENTATIONS_LANDSCAPE_ONLY = 0;
    public static final int VIEW_ORIENTATIONS_PORTRAIT_ONLY = 1;
    public static final long mLostFocusDelayMs = 500;
    public FrameLayout framelayout = null;
    public boolean isVisible = false;
    public Runnable mDelayedLostFocus = null;
    public DummyEdit mEdit = null;
    public GLSurfaceView mGLView = null;
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean mHasFocus = false;
    public boolean mHasIndirectFocus = false;
    public boolean mIsActive = true;
    public boolean mIsPaused = true;
    public KeyboardExtension mKeyboardExtension = null;
    public boolean mKeyboardFocus = false;
    public OrientationEventListener mOrientationListener = null;
    public boolean mWindowFocus = false;
    public int orientationSettings = 2;
    public int prevSurfaceRotation = -1;

    public static void callNativeOnLowMemory() {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                Engine.nativeOnLowMemory();
            }
        });
    }

    /* access modifiers changed from: private */
    public void delayedProcessChangeFocus(boolean z) {
        Runnable runnable = this.mDelayedLostFocus;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mDelayedLostFocus = null;
        }
        if (z) {
            processChangeFocus();
            return;
        }
        C30568 r4 = new Runnable() {
            public void run() {
                EngineActivity.this.processChangeFocus();
            }
        };
        this.mDelayedLostFocus = r4;
        this.mHandler.postDelayed(r4, 500);
    }

    private void doPause() {
        if (!this.mIsPaused) {
            this.mIsPaused = true;
            C30546 r0 = new ControlledRunnable() {
                public void controlledRun() {
                    Engine.nativeOnPause();
                }
            };
            if (Engine.runOnGLThread(r0)) {
                r0.waitFinish();
            }
            this.mGLView.onPause();
        }
    }

    private void doResume() {
        if (this.mIsPaused && this.mIsActive) {
            this.mIsPaused = false;
            this.mGLView.onResume();
            ImmersiveMode.onResume();
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeOnResume();
                }
            });
        }
    }

    private int getScreenOrientation() {
        Point displaySize = Engine.getDisplaySize();
        return displaySize.x >= displaySize.y ? 2 : 1;
    }

    public static int getSensorActivityOrientation(int i) {
        if (i == 0) {
            return 6;
        }
        if (i != 1) {
            return i != 2 ? -1 : 10;
        }
        return 7;
    }

    @TargetApi(18)
    public static int getUserActivityOrientation(int i) {
        if (i == 0) {
            return 11;
        }
        if (i != 1) {
            return i != 2 ? -1 : 13;
        }
        return 12;
    }

    private void handleActivation() {
        Intent intent = getIntent();
        final String dataString = intent.getDataString();
        if (dataString != null && !dataString.isEmpty()) {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeOnUrlActivate(dataString);
                }
            });
            intent.setData((Uri) null);
        }
        Notifications.handleActivation(intent);
        Shortcuts.handleActivation(intent);
    }

    /* access modifiers changed from: private */
    public void handleFocusLoss() {
        if (!this.mHasIndirectFocus) {
            doPause();
        }
    }

    /* access modifiers changed from: private */
    public void handleFocusRestore() {
        if (this.mHasFocus || this.mHasIndirectFocus) {
            doResume();
        }
    }

    private void initActivityOrientation() {
        if (NativeThread.getInstance().isLibrariesLoaded()) {
            this.orientationSettings = Engine.nativeGetOrientationSettings();
        }
        int userActivityOrientation = getUserActivityOrientation(this.orientationSettings);
        if (userActivityOrientation != -1) {
            setRequestedOrientation(userActivityOrientation);
        }
    }

    private void initRotationListener() {
        this.mOrientationListener = new OrientationEventListener(this, 3) {
            public void onOrientationChanged(int i) {
                int deviceRotation = Engine.getDeviceRotation();
                if (EngineActivity.this.prevSurfaceRotation != deviceRotation) {
                    int unused = EngineActivity.this.prevSurfaceRotation = deviceRotation;
                    Engine.runOnGLThread(new Runnable() {
                        public void run() {
                            Engine.nativeOnOrientationChanged();
                        }
                    });
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void processChangeFocus() {
        boolean z = this.mKeyboardFocus || this.mWindowFocus;
        ImmersiveMode.onWindowFocusChanged(z);
        if (this.mHasFocus != z) {
            this.mHasFocus = z;
            if (z) {
                handleFocusRestore();
            } else {
                handleFocusLoss();
            }
        }
    }

    private void setCutoutLayoutMode() {
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
    }

    public static void setupRestoreVisibleInsetsHandle(Activity activity) {
        if (Build.VERSION.SDK_INT <= 28) {
            activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    EngineActivity activity = Engine.getActivity();
                    if (activity != null) {
                        try {
                            View decorView = activity.getWindow().getDecorView();
                            Field declaredField = View.class.getDeclaredField("mAttachInfo");
                            declaredField.setAccessible(true);
                            Object obj = declaredField.get(decorView);
                            if (obj != null) {
                                Field declaredField2 = obj.getClass().getDeclaredField("mVisibleInsets");
                                declaredField2.setAccessible(true);
                                Rect rect = (Rect) declaredField2.get(obj);
                                if (rect != null && rect.top != 0) {
                                    rect.top = 0;
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public FrameLayout GetParentFramelayout() {
        return this.framelayout;
    }

    public DummyEdit getEdit() {
        return this.mEdit;
    }

    public GLSurfaceViewV17 getGLView() {
        return this.mGLView;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    public boolean isAllowedOrientation() {
        int i = this.orientationSettings;
        if (i != 0) {
            if (i == 1 && getScreenOrientation() != 1) {
                return false;
            }
            return true;
        } else if (getScreenOrientation() == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (!Marketing.onActivityResult(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (!Advertising.getInstance().onBackPressed(this) && !WebFragment.onBackPressed()) {
            GLSurfaceView gLSurfaceView = this.mGLView;
            if (gLSurfaceView == null || !gLSurfaceView.isTouchInProgress()) {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        KeyboardManager.nativeKeyDown(-4);
                    }
                });
            }
        }
    }

    public void onCreate(Bundle bundle) {
        FMOD.init(this);
        Engine.onCreate(this);
        ImmersiveMode.onCreate(this);
        setupRestoreVisibleInsetsHandle(this);
        registerActivityLifecycleCallbacks(Advertising.getInstance());
        super.onCreate(bundle);
        setTheme(C3204R.style.MainTheme);
        getWindow().setSoftInputMode(1);
        setCutoutLayoutMode();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        this.framelayout = frameLayout;
        frameLayout.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        DummyEdit dummyEdit = new DummyEdit(this);
        this.mEdit = dummyEdit;
        dummyEdit.setLayoutParams(layoutParams2);
        this.framelayout.addView(this.mEdit);
        GLSurfaceView gLSurfaceView = new GLSurfaceView(this);
        this.mGLView = gLSurfaceView;
        this.framelayout.addView(gLSurfaceView);
        setContentView((View) this.framelayout);
        initActivityOrientation();
        initRotationListener();
        handleActivation();
        Engine.onPlayrixActivityCreated(this);
    }

    public void onDestroy() {
        C30502 r0 = new Runnable() {
            public void run() {
                Engine.nativeOnDestroy();
                FMOD.close();
                synchronized (this) {
                    notify();
                }
            }
        };
        synchronized (r0) {
            if (NativeThread.getInstance().queueEvent(r0)) {
                try {
                    r0.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        NativeThread.getInstance().requestExitAndWait();
        super.onDestroy();
    }

    public void onDialogFocusChanged(final boolean z) {
        runOnUiThread(new Runnable() {
            public void run() {
                boolean access$500 = EngineActivity.this.mHasIndirectFocus;
                boolean z = z;
                if (access$500 != z) {
                    boolean unused = EngineActivity.this.mHasIndirectFocus = z;
                    if (EngineActivity.this.mHasIndirectFocus) {
                        if (!EngineActivity.this.mHasFocus) {
                            EngineActivity.this.handleFocusRestore();
                        }
                    } else if (!EngineActivity.this.mHasFocus && SystemDialog.isPresent()) {
                        EngineActivity.this.handleFocusLoss();
                    }
                }
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        this.mGLView.onKeyDown(i, keyEvent);
        ImmersiveMode.onKeyDown(i, keyEvent);
        return super.onKeyDown(i, keyEvent);
    }

    public void onKeyboardFocus(final boolean z) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (EngineActivity.this.mGLView != null) {
                    EngineActivity.this.mGLView.resetTouchInProgress();
                }
                boolean access$200 = EngineActivity.this.mKeyboardFocus;
                boolean z = z;
                if (access$200 != z) {
                    boolean unused = EngineActivity.this.mKeyboardFocus = z;
                    EngineActivity.this.delayedProcessChangeFocus(z);
                }
            }
        });
    }

    public void onLowMemory() {
        super.onLowMemory();
        callNativeOnLowMemory();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onPause() {
        super.onPause();
        doPause();
        this.mOrientationListener.disable();
        this.isVisible = false;
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!Permissions.onRequestPermissionsResult(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        handleFocusRestore();
        handleActivation();
        if (this.mOrientationListener.canDetectOrientation()) {
            this.mOrientationListener.enable();
        }
        this.isVisible = true;
    }

    public void onStart() {
        super.onStart();
        this.mIsActive = true;
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                Engine.nativeOnStart();
            }
        });
    }

    public void onStop() {
        super.onStop();
        this.mIsActive = false;
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                Engine.nativeOnStop();
            }
        });
    }

    @SuppressLint({"SwitchIntDef"})
    public void onTrimMemory(int i) {
        Log.e(LOG_TAG, "EngineActivity.onTrimMemory: " + i);
        super.onTrimMemory(i);
        if (i == 5 || i == 10 || i == 15) {
            callOnLowMemory();
            callNativeOnLowMemory();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mWindowFocus != z) {
            this.mWindowFocus = z;
            delayedProcessChangeFocus(z);
        }
    }
}
