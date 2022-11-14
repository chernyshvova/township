package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;

public class CutoutDrawable extends GradientDrawable {
    public final RectF cutoutBounds = new RectF();
    public final Paint cutoutPaint;
    public int savedLayer;

    public CutoutDrawable() {
        Paint paint = new Paint(1);
        this.cutoutPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public void draw(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            ((View) callback).setLayerType(2, (Paint) null);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.savedLayer = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
        } else {
            this.savedLayer = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
        }
        super.draw(canvas);
        canvas.drawRect(this.cutoutBounds, this.cutoutPaint);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.savedLayer);
        }
    }

    public void setCutout(float f, float f2, float f3, float f4) {
        RectF rectF = this.cutoutBounds;
        if (f != rectF.left || f2 != rectF.top || f3 != rectF.right || f4 != rectF.bottom) {
            this.cutoutBounds.set(f, f2, f3, f4);
            invalidateSelf();
        }
    }
}
