package com.playrix.engine;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.vungle.warren.VisionController;

public class KeyboardExtension {
    public static final int mButtonsIndent = 4;
    public static final int mClearButtonIndent = 15;
    public static final int mClearButtonSizeFont = 10;
    public static final int mClearButtonVerticalIndent = 7;
    public static final int mEditFieldIndent = 1;
    public static final float mInvisibleKeyboardTop = 1000000.0f;
    public static final int mSendButtonSizeFont = 18;
    public static final int mSendButtonWidth = 80;
    public final Activity mActivity;
    public final Button mClearButton;
    public FrameLayout mDecorView = null;
    public Runnable mDelayedDestroy = null;
    public final EditText mEditField;
    public ViewGroup mEditFieldSubstrate = null;
    public boolean mEditFieldVisible = false;
    public ViewGroup.LayoutParams mEditLayoutParameters = null;
    public int mEditViewIndex = 0;
    public ViewGroup mEditViewParent = null;
    public final OnWindowFocusChangedListener mFocusChangedListener;
    public boolean mFocused = false;
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean mIsActive = false;
    public final OnKeyboardCloseListener mKeyboardCloseListener;
    public boolean mKeyboardVisible = false;
    public float mLastKeyboardPosition = -1.0E20f;
    public final ViewGroup mMainFrameLayout;
    public final int mNavigationBarHeight;
    public RelativeLayout mRelativeLayout = null;
    public final Button mSendButton;
    public final WindowManager mWindowManager;

    public interface OnKeyboardCloseListener {
        void onClose();
    }

    public interface OnWindowFocusChangedListener {
        void onFocus(boolean z);
    }

    public class PopupDecorView extends FrameLayout {
        public int[] mLocation = new int[2];
        public Matrix mMatrix = new Matrix();

        public PopupDecorView(Context context) {
            super(context);
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (super.dispatchTouchEvent(motionEvent)) {
                return true;
            }
            if (KeyboardExtension.this.mActivity == null) {
                return false;
            }
            getLocationOnScreen(this.mLocation);
            Matrix matrix = this.mMatrix;
            int[] iArr = this.mLocation;
            matrix.setTranslate((float) iArr[0], (float) iArr[1]);
            motionEvent.transform(this.mMatrix);
            return KeyboardExtension.this.mActivity.dispatchTouchEvent(motionEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            KeyboardExtension.this.processWindowFocusChanged(z);
        }
    }

    public KeyboardExtension(Activity activity, EditText editText, ViewGroup viewGroup, OnWindowFocusChangedListener onWindowFocusChangedListener, OnKeyboardCloseListener onKeyboardCloseListener) {
        this.mActivity = activity;
        this.mEditField = editText;
        this.mMainFrameLayout = viewGroup;
        this.mWindowManager = (WindowManager) activity.getSystemService(VisionController.WINDOW);
        this.mFocusChangedListener = onWindowFocusChangedListener;
        this.mKeyboardCloseListener = onKeyboardCloseListener;
        this.mNavigationBarHeight = getNavigationBarHeight();
        this.mSendButton = createSendButton();
        this.mClearButton = createClearButton();
    }

    private void cancelDelayedDestroy() {
        Runnable runnable = this.mDelayedDestroy;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mDelayedDestroy = null;
        }
    }

    private int computeFlags(int i) {
        int i2 = (i & -426521) | 32 | 8388608;
        return Build.VERSION.SDK_INT >= 22 ? i2 | 1073741824 : i2;
    }

    private void connectEditField() {
        if (this.mRelativeLayout == null) {
            this.mEditViewParent = this.mEditField.getParent() instanceof ViewGroup ? (ViewGroup) this.mEditField.getParent() : null;
            this.mEditLayoutParameters = this.mEditField.getLayoutParams();
            ViewGroup viewGroup = this.mEditViewParent;
            if (viewGroup != null) {
                this.mEditViewIndex = viewGroup.indexOfChild(this.mEditField);
                this.mEditViewParent.removeView(this.mEditField);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.mActivity);
            this.mRelativeLayout = relativeLayout;
            relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
            layoutParams.addRule(12);
            FrameLayout frameLayout = new FrameLayout(this.mActivity);
            this.mEditFieldSubstrate = frameLayout;
            frameLayout.setBackgroundColor(Color.rgb(240, 240, 240));
            this.mEditFieldSubstrate.setLayoutParams(layoutParams);
            this.mRelativeLayout.addView(this.mEditFieldSubstrate);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            this.mEditField.setLayoutParams(layoutParams2);
            this.mEditField.setBackgroundColor(Color.rgb(240, 240, 240));
            this.mEditFieldSubstrate.addView(this.mEditField);
            this.mSendButton.setLayoutParams(layoutParams2);
            this.mEditFieldSubstrate.addView(this.mSendButton);
            this.mClearButton.setLayoutParams(layoutParams2);
            this.mEditFieldSubstrate.addView(this.mClearButton);
        }
    }

    private void create() {
        if (this.mDecorView == null) {
            cancelDelayedDestroy();
            WindowManager.LayoutParams createPopupLayoutParams = createPopupLayoutParams(this.mMainFrameLayout.getWindowToken());
            connectEditField();
            FrameLayout createDecorView = createDecorView();
            this.mDecorView = createDecorView;
            this.mWindowManager.addView(createDecorView, createPopupLayoutParams);
            this.mDecorView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public int[] mLocationEdit = new int[2];
                public int[] mLocationMain = new int[2];

                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (KeyboardExtension.this.mRelativeLayout != null) {
                        KeyboardExtension.this.updatePanelPosition();
                    }
                    if (!(KeyboardExtension.this.mMainFrameLayout == null || KeyboardExtension.this.mDecorView == null)) {
                        KeyboardExtension.this.mMainFrameLayout.getLocationOnScreen(this.mLocationMain);
                        boolean z = true;
                        int height = KeyboardExtension.this.mMainFrameLayout.getHeight() + this.mLocationMain[1];
                        KeyboardExtension.this.mDecorView.getLocationOnScreen(this.mLocationEdit);
                        int height2 = KeyboardExtension.this.mDecorView.getHeight() + this.mLocationEdit[1];
                        boolean access$400 = KeyboardExtension.this.mKeyboardVisible;
                        KeyboardExtension keyboardExtension = KeyboardExtension.this;
                        if (height2 >= height - keyboardExtension.mNavigationBarHeight) {
                            z = false;
                        }
                        boolean unused = keyboardExtension.mKeyboardVisible = z;
                        KeyboardExtension keyboardExtension2 = KeyboardExtension.this;
                        keyboardExtension2.setActive(keyboardExtension2.mIsActive);
                        if (access$400 && !KeyboardExtension.this.needShow() && KeyboardExtension.this.mDelayedDestroy == null) {
                            Runnable unused2 = KeyboardExtension.this.mDelayedDestroy = new Runnable() {
                                public void run() {
                                    Runnable unused = KeyboardExtension.this.mDelayedDestroy = null;
                                    if (!KeyboardExtension.this.needShow()) {
                                        KeyboardExtension.this.destroy();
                                    }
                                }
                            };
                            KeyboardExtension.this.mHandler.postDelayed(KeyboardExtension.this.mDelayedDestroy, 1000);
                        }
                    }
                    KeyboardExtension keyboardExtension3 = KeyboardExtension.this;
                    keyboardExtension3.onKeyboardChangePosition(keyboardExtension3.getKeyboardTop());
                }
            });
        }
    }

    private Button createClearButton() {
        Button button = new Button(this.mActivity);
        button.setTextColor(Color.rgb(255, 255, 255));
        button.setBackgroundDrawable(ContextCompat.getDrawable(this.mActivity, C3204R.C3205drawable.clear_button_shape));
        button.setTextSize(1, 10.0f);
        button.setGravity(17);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (KeyboardExtension.this.mEditFieldVisible) {
                    KeyboardManager.OnClearButton();
                }
            }
        });
        return button;
    }

    private FrameLayout createDecorView() {
        PopupDecorView popupDecorView = new PopupDecorView(this.mActivity);
        popupDecorView.addView(this.mRelativeLayout, -1, -1);
        popupDecorView.setClipChildren(false);
        popupDecorView.setClipToPadding(false);
        popupDecorView.setFitsSystemWindows(false);
        return popupDecorView;
    }

    private WindowManager.LayoutParams createPopupLayoutParams(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.packageName = this.mActivity.getPackageName();
        layoutParams.gravity = 8388659;
        layoutParams.flags = computeFlags(layoutParams.flags);
        layoutParams.type = 1000;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = 21;
        layoutParams.windowAnimations = 0;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.setTitle("KeyboardExtensionWindow");
        return layoutParams;
    }

    private Button createSendButton() {
        Button button = new Button(this.mActivity);
        button.setTextColor(Color.rgb(255, 255, 255));
        button.setBackgroundDrawable(ContextCompat.getDrawable(this.mActivity, C3204R.C3205drawable.send_button_shape));
        button.setTextSize(1, 18.0f);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (KeyboardExtension.this.mEditFieldVisible) {
                    Engine.runOnGLThread(new Runnable() {
                        public void run() {
                            KeyboardManager.nativeOnSendButton();
                        }
                    });
                }
            }
        });
        return button;
    }

    /* access modifiers changed from: private */
    public void destroy() {
        cancelDelayedDestroy();
        if (this.mDecorView != null) {
            disconnectEditField();
            if (this.mDecorView.getParent() != null) {
                this.mWindowManager.removeViewImmediate(this.mDecorView);
            }
            this.mDecorView.removeView(this.mRelativeLayout);
            this.mDecorView = null;
            this.mRelativeLayout = null;
            processWindowFocusChanged(false);
        }
    }

    private void disconnectEditField() {
        if (this.mRelativeLayout != null) {
            this.mEditFieldSubstrate.removeView(this.mClearButton);
            this.mEditFieldSubstrate.removeView(this.mSendButton);
            this.mEditFieldSubstrate.removeView(this.mEditField);
            this.mRelativeLayout.removeView(this.mEditFieldSubstrate);
            this.mEditField.setLayoutParams(this.mEditLayoutParameters);
            ViewGroup viewGroup = this.mEditViewParent;
            if (viewGroup != null) {
                viewGroup.addView(this.mEditField, this.mEditViewIndex);
            }
            OnKeyboardCloseListener onKeyboardCloseListener = this.mKeyboardCloseListener;
            if (onKeyboardCloseListener != null) {
                onKeyboardCloseListener.onClose();
            }
            this.mEditFieldSubstrate = null;
        }
    }

    /* access modifiers changed from: private */
    public float getKeyboardTop() {
        int bottom;
        RelativeLayout relativeLayout = this.mRelativeLayout;
        if (relativeLayout == null || !this.mKeyboardVisible) {
            return 1000000.0f;
        }
        ViewGroup viewGroup = this.mEditFieldSubstrate;
        if (viewGroup != null) {
            bottom = viewGroup.getTop();
        } else {
            bottom = relativeLayout.getBottom();
        }
        return (float) bottom;
    }

    private int getNavigationBarHeight() {
        int identifier = this.mActivity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.mActivity.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public boolean needShow() {
        return this.mKeyboardVisible || this.mEditFieldVisible;
    }

    /* access modifiers changed from: private */
    public void onKeyboardChangePosition(final float f) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                float resolutionScaleH = Engine.getResolutionScaleH() * f;
                if (resolutionScaleH != KeyboardExtension.this.mLastKeyboardPosition) {
                    float unused = KeyboardExtension.this.mLastKeyboardPosition = resolutionScaleH;
                    KeyboardManager.nativeKeyboardChangePosition(resolutionScaleH);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void processWindowFocusChanged(boolean z) {
        OnWindowFocusChangedListener onWindowFocusChangedListener = this.mFocusChangedListener;
        if (onWindowFocusChangedListener != null && z != this.mFocused) {
            this.mFocused = z;
            onWindowFocusChangedListener.onFocus(z);
        }
    }

    public static void setViewRect(View view, int i, int i2, int i3, int i4) {
        if (view.getTop() != i3) {
            view.setTop(i3);
        }
        if (view.getBottom() != i4) {
            view.setBottom(i4);
        }
        if (view.getLeft() != i) {
            view.setLeft(i);
        }
        if (view.getRight() != i2) {
            view.setRight(i2);
        }
    }

    private void setVisibility() {
        RelativeLayout relativeLayout = this.mRelativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(needShow() ? 0 : 4);
        }
    }

    /* access modifiers changed from: private */
    public void updatePanelPosition() {
        RelativeLayout relativeLayout = this.mRelativeLayout;
        if (relativeLayout != null) {
            int bottom = relativeLayout.getBottom();
            EditText editText = this.mEditField;
            if (!(editText == null || this.mEditFieldSubstrate == null)) {
                if (!this.mEditFieldVisible || editText.getLayout() == null) {
                    setViewRect(this.mEditFieldSubstrate, this.mRelativeLayout.getLeft(), this.mRelativeLayout.getRight(), bottom, bottom + 1);
                    setViewRect(this.mEditField, 0, 1, 0, 1);
                    setViewRect(this.mSendButton, 0, 1, 0, 1);
                    setViewRect(this.mClearButton, 0, 1, 0, 1);
                    this.mSendButton.setText("");
                    this.mClearButton.setText("");
                } else {
                    int ceil = ((int) Math.ceil((double) (this.mEditField.getLayout().getLineTop(this.mEditField.getLayout().getLineCount()) + this.mEditField.getCompoundPaddingBottom() + this.mEditField.getCompoundPaddingTop()))) + 2;
                    setViewRect(this.mEditFieldSubstrate, this.mRelativeLayout.getLeft(), this.mRelativeLayout.getRight(), bottom - ceil, bottom);
                    int right = (this.mEditFieldSubstrate.getRight() - this.mEditFieldSubstrate.getLeft()) - 4;
                    setViewRect(this.mSendButton, right - 80, right, 4, ceil - 4);
                    int i = right - 95;
                    int i2 = ceil - 14;
                    setViewRect(this.mClearButton, i - i2, i, 7, ceil - 7);
                    setViewRect(this.mEditField, 1, i - (i2 + 4), 1, ceil - 1);
                    this.mSendButton.setText("✓");
                    this.mClearButton.setText("❌");
                }
            }
            onKeyboardChangePosition(getKeyboardTop());
        }
    }

    public void setActive(boolean z) {
        this.mIsActive = z;
        if (z) {
            create();
            this.mEditField.requestFocus();
        } else if (!needShow() && this.mDelayedDestroy == null) {
            destroy();
        }
        setVisibility();
    }

    public void setEditFieldVisible(boolean z) {
        this.mEditFieldVisible = z;
        if (!needShow()) {
            destroy();
            return;
        }
        if (this.mEditFieldVisible) {
            create();
            this.mEditField.requestFocus();
        }
        setVisibility();
        updatePanelPosition();
    }
}
