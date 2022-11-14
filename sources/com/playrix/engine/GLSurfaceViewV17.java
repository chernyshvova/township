package com.playrix.engine;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowInsets;
import com.playrix.engine.EglContextManager;

public class GLSurfaceViewV17 extends SurfaceView implements SurfaceHolder.Callback {
    public final Cutout displayCutout = new Cutout();
    public boolean mIsImeShown = false;
    public int mPixelHeight;
    public int mPixelWidth;
    public EglContextManager.Renderer mRenderer;
    public Scale2D mSetScale = new Scale2D();
    public int surfaceHeight = 0;
    public int surfaceWidth = 0;

    public static class Cutout {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public Cutout() {
            this.left = 0;
            this.right = 0;
            this.top = 0;
            this.bottom = 0;
        }
    }

    public GLSurfaceViewV17(Context context) {
        super(context);
        init();
    }

    private void applyResolutionScale() {
        int i = this.mPixelWidth;
        if (i >= 0 && this.mPixelHeight >= 0) {
            final int round = Math.round(this.mSetScale.getScaleW() * ((float) i));
            final int round2 = Math.round(this.mSetScale.getScaleH() * ((float) this.mPixelHeight));
            Engine.runOnUiThread(new Runnable() {
                public void run() {
                    SurfaceHolder holder = GLSurfaceViewV17.this.getHolder();
                    if (holder != null) {
                        holder.setFixedSize(round, round2);
                    }
                }
            });
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public float getResolutionScaleH() {
        return this.mSetScale.getScaleH();
    }

    public float getResolutionScaleW() {
        return this.mSetScale.getScaleW();
    }

    public int getSurfaceHeight() {
        return this.surfaceHeight;
    }

    public int getSurfaceWidth() {
        return this.surfaceWidth;
    }

    @TargetApi(28)
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 28) {
            DisplayCutout displayCutout2 = windowInsets.getDisplayCutout();
            if (displayCutout2 != null) {
                this.displayCutout.left = displayCutout2.getSafeInsetLeft();
                this.displayCutout.right = displayCutout2.getSafeInsetRight();
                this.displayCutout.top = displayCutout2.getSafeInsetTop();
                this.displayCutout.bottom = displayCutout2.getSafeInsetBottom();
            } else {
                Cutout cutout = this.displayCutout;
                cutout.left = 0;
                cutout.right = 0;
                cutout.top = 0;
                cutout.bottom = 0;
            }
        }
        if (Build.VERSION.SDK_INT >= 30) {
            final boolean isVisible = windowInsets.isVisible(WindowInsets.Type.ime());
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    if (isVisible != GLSurfaceViewV17.this.mIsImeShown) {
                        boolean unused = GLSurfaceViewV17.this.mIsImeShown = isVisible;
                        KeyboardManager.nativeKeyboardImeChangeVisibility(isVisible);
                    }
                }
            });
        }
        return windowInsets;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mPixelWidth = View.MeasureSpec.getSize(i);
        this.mPixelHeight = View.MeasureSpec.getSize(i2);
        applyResolutionScale();
    }

    public void onPause() {
        NativeThread.getInstance().onPause();
    }

    public void onResume() {
        NativeThread.getInstance().onResume();
    }

    public void setRenderer(EglContextManager.Renderer renderer) {
        this.mRenderer = renderer;
    }

    public void setResolutionScale(Scale2D scale2D) {
        if (scale2D == null) {
            scale2D = new Scale2D();
        }
        this.mSetScale = scale2D;
        applyResolutionScale();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        EngineActivity engineActivity = (EngineActivity) getContext();
        if (engineActivity == null || engineActivity.isAllowedOrientation()) {
            this.surfaceWidth = i2;
            this.surfaceHeight = i3;
            Point displaySize = Engine.getDisplaySize();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            final int max = Math.max(this.displayCutout.left - iArr[0], 0);
            final int max2 = Math.max(this.displayCutout.right - (displaySize.x - (iArr[0] + this.mPixelWidth)), 0);
            final int max3 = Math.max(this.displayCutout.top - iArr[1], 0);
            final int max4 = Math.max(this.displayCutout.bottom - (displaySize.y - (iArr[1] + this.mPixelHeight)), 0);
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeDisplayCutout(max, max2, max3, max4);
                }
            });
            NativeThread.getInstance().onWindowResize(i2, i3);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        NativeThread.getInstance().surfaceCreated(surfaceHolder, this.mRenderer);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        NativeThread.getInstance().surfaceDestroyed();
    }

    public static class Scale2D {
        public float mScaleH;
        public float mScaleW;

        public Scale2D() {
            this.mScaleW = 1.0f;
            this.mScaleH = 1.0f;
            this.mScaleW = 1.0f;
            this.mScaleH = 1.0f;
        }

        public float getScale() {
            float f = this.mScaleW;
            if (f == this.mScaleH) {
                return f;
            }
            throw new IllegalStateException();
        }

        public float getScaleH() {
            return this.mScaleH;
        }

        public float getScaleW() {
            return this.mScaleW;
        }

        public Scale2D(float f, float f2) {
            this.mScaleW = 1.0f;
            this.mScaleH = 1.0f;
            f = (Float.isInfinite(f) || Float.isNaN(f)) ? 1.0f : f;
            f2 = (Float.isInfinite(f2) || Float.isNaN(f2)) ? 1.0f : f2;
            this.mScaleW = f;
            this.mScaleH = f2;
        }
    }

    public GLSurfaceViewV17(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
