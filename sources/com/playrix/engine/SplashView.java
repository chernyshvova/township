package com.playrix.engine;

import android.os.Handler;
import android.os.Looper;
import android.view.animation.AlphaAnimation;
import androidx.appcompat.widget.AppCompatImageView;

public class SplashView extends AppCompatImageView {
    public static SplashView view;
    public boolean hiding;
    public EngineActivity mActivity;

    public static void hide() {
        EngineActivity activity = Engine.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (SplashView.view != null && !SplashView.view.hiding) {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation.setDuration(200);
                        alphaAnimation.setFillEnabled(true);
                        alphaAnimation.setFillAfter(true);
                        boolean unused = SplashView.view.hiding = true;
                        SplashView.view.startAnimation(alphaAnimation);
                    }
                }
            });
        }
    }

    public static native void nativeOnSplashWasHidden();

    public static void show() {
        show((String) null, -1);
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                SplashView.this.setVisibility(8);
                if (!(SplashView.this.mActivity == null || SplashView.view == null)) {
                    SplashView.this.mActivity.GetParentFramelayout().removeView(SplashView.view);
                }
                SplashView unused = SplashView.view = null;
                EngineActivity unused2 = SplashView.this.mActivity = null;
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        SplashView.nativeOnSplashWasHidden();
                    }
                });
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SplashView(android.content.Context r7, java.lang.String r8, int r9) {
        /*
            r6 = this;
            r6.<init>(r7)
            r7 = 0
            if (r8 == 0) goto L_0x0037
            java.lang.String r0 = "file:///android_asset/"
            boolean r0 = r8.startsWith(r0)
            if (r0 == 0) goto L_0x0027
            android.content.Context r0 = com.playrix.engine.Engine.getContext()     // Catch:{ Exception -> 0x0037 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x0037 }
            r1 = 22
            java.lang.String r8 = r8.substring(r1)     // Catch:{ Exception -> 0x0037 }
            java.io.InputStream r8 = r0.open(r8)     // Catch:{ Exception -> 0x0037 }
            if (r8 == 0) goto L_0x0037
            android.graphics.drawable.Drawable r8 = android.graphics.drawable.Drawable.createFromStream(r8, r7)     // Catch:{ Exception -> 0x0037 }
            goto L_0x0038
        L_0x0027:
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0037
            android.graphics.drawable.Drawable r8 = android.graphics.drawable.Drawable.createFromPath(r8)
            goto L_0x0038
        L_0x0037:
            r8 = r7
        L_0x0038:
            if (r8 != 0) goto L_0x0082
            android.graphics.Point r8 = com.playrix.engine.Engine.getRealScreenSize()
            int r0 = r8.x
            int r1 = r8.y
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2)
            android.content.res.Resources r1 = r6.getResources()
            int r2 = com.playrix.engine.C3204R.C3205drawable.splash
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r1, r2)
            int r2 = r0.getDensity()
            r1.setDensity(r2)
            int r2 = r8.x
            int r3 = r1.getWidth()
            int r2 = r2 - r3
            float r2 = (float) r2
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r3
            r4 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 - r4
            int r8 = r8.y
            int r5 = r1.getHeight()
            int r8 = r8 - r5
            float r8 = (float) r8
            float r8 = r8 / r3
            float r8 = r8 - r4
            android.graphics.Canvas r3 = new android.graphics.Canvas
            r3.<init>(r0)
            r3.drawBitmap(r1, r2, r8, r7)
            android.graphics.drawable.BitmapDrawable r8 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r7 = r6.getResources()
            r8.<init>(r7, r0)
        L_0x0082:
            r6.setImageDrawable(r8)
            r6.setBackgroundColor(r9)
            android.widget.ImageView$ScaleType r7 = android.widget.ImageView.ScaleType.CENTER_CROP
            r6.setScaleType(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.SplashView.<init>(android.content.Context, java.lang.String, int):void");
    }

    public static void show(final String str, final int i) {
        final EngineActivity activity = Engine.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (SplashView.view == null) {
                        SplashView unused = SplashView.view = new SplashView(EngineActivity.this, str, i);
                        EngineActivity.this.GetParentFramelayout().addView(SplashView.view);
                        EngineActivity unused2 = SplashView.view.mActivity = EngineActivity.this;
                    }
                }
            });
        }
    }
}
