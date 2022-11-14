package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$color;

public class ShadowDrawableWrapper extends DrawableWrapper {
    public static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    public boolean addPaddingForCorners = true;
    public final RectF contentBounds;
    public float cornerRadius;
    public final Paint cornerShadowPaint;
    public Path cornerShadowPath;
    public boolean dirty = true;
    public final Paint edgeShadowPaint;
    public boolean printedShadowClipWarning = false;
    public float rawMaxShadowSize;
    public float rawShadowSize;
    public float rotation;
    public final int shadowEndColor;
    public final int shadowMiddleColor;
    public float shadowSize;
    public final int shadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.shadowStartColor = ContextCompat.getColor(context, R$color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(context, R$color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(context, R$color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = (float) Math.round(f);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(this.cornerShadowPaint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    public static float calculateHorizontalPadding(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d = (double) f;
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (((1.0d - COS_45) * d2) + d);
    }

    public static float calculateVerticalPadding(float f, float f2, boolean z) {
        if (!z) {
            return f * 1.5f;
        }
        double d = (double) (f * 1.5f);
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (((1.0d - COS_45) * d2) + d);
    }

    public void draw(Canvas canvas) {
        boolean z;
        int i;
        int i2;
        Canvas canvas2 = canvas;
        if (this.dirty) {
            Rect bounds = getBounds();
            float f = this.rawMaxShadowSize;
            float f2 = 1.5f * f;
            this.contentBounds.set(((float) bounds.left) + f, ((float) bounds.top) + f2, ((float) bounds.right) - f, ((float) bounds.bottom) - f2);
            Drawable wrappedDrawable = getWrappedDrawable();
            RectF rectF = this.contentBounds;
            wrappedDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            float f3 = this.cornerRadius;
            float f4 = -f3;
            RectF rectF2 = new RectF(f4, f4, f3, f3);
            RectF rectF3 = new RectF(rectF2);
            float f5 = -this.shadowSize;
            rectF3.inset(f5, f5);
            Path path = this.cornerShadowPath;
            if (path == null) {
                this.cornerShadowPath = new Path();
            } else {
                path.reset();
            }
            this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
            this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
            this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
            this.cornerShadowPath.arcTo(rectF3, 180.0f, 90.0f, false);
            this.cornerShadowPath.arcTo(rectF2, 270.0f, -90.0f, false);
            this.cornerShadowPath.close();
            float f6 = -rectF3.top;
            if (f6 > 0.0f) {
                float f7 = this.cornerRadius / f6;
                this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f7, ((1.0f - f7) / 2.0f) + f7, 1.0f}, Shader.TileMode.CLAMP));
            }
            z = true;
            this.edgeShadowPaint.setShader(new LinearGradient(0.0f, rectF2.top, 0.0f, rectF3.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.edgeShadowPaint.setAntiAlias(false);
            this.dirty = false;
        } else {
            z = true;
        }
        int save = canvas.save();
        canvas2.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f8 = this.cornerRadius;
        float f9 = (-f8) - this.shadowSize;
        float f10 = f8 * 2.0f;
        boolean z2 = this.contentBounds.width() - f10 > 0.0f;
        if (this.contentBounds.height() - f10 <= 0.0f) {
            z = false;
        }
        float f11 = this.rawShadowSize;
        float f12 = f8 / ((f11 - (0.5f * f11)) + f8);
        float f13 = f8 / ((f11 - (0.25f * f11)) + f8);
        float f14 = f8 / ((f11 - (f11 * 1.0f)) + f8);
        int save2 = canvas.save();
        RectF rectF4 = this.contentBounds;
        canvas2.translate(rectF4.left + f8, rectF4.top + f8);
        canvas2.scale(f12, f13);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas2.scale(1.0f / f12, 1.0f);
            i = save;
            i2 = save2;
            canvas.drawRect(0.0f, f9, this.contentBounds.width() - f10, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            i = save;
            i2 = save2;
        }
        canvas2.restoreToCount(i2);
        int save3 = canvas.save();
        RectF rectF5 = this.contentBounds;
        canvas2.translate(rectF5.right - f8, rectF5.bottom - f8);
        canvas2.scale(f12, f14);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas2.scale(1.0f / f12, 1.0f);
            canvas.drawRect(0.0f, f9, this.contentBounds.width() - f10, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF6 = this.contentBounds;
        canvas2.translate(rectF6.left + f8, rectF6.bottom - f8);
        canvas2.scale(f12, f14);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z) {
            canvas2.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f9, this.contentBounds.height() - f10, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF7 = this.contentBounds;
        canvas2.translate(rectF7.right - f8, rectF7.top + f8);
        canvas2.scale(f12, f13);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z) {
            canvas2.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f9, this.contentBounds.height() - f10, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(i);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.cornerShadowPaint.setAlpha(i);
        this.edgeShadowPaint.setAlpha(i);
    }

    public void setShadowSize(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        int round = Math.round(f);
        if (round % 2 == 1) {
            round--;
        }
        float f3 = (float) round;
        int round2 = Math.round(f2);
        if (round2 % 2 == 1) {
            round2--;
        }
        float f4 = (float) round2;
        if (f3 > f4) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            f3 = f4;
        }
        if (this.rawShadowSize != f3 || this.rawMaxShadowSize != f4) {
            this.rawShadowSize = f3;
            this.rawMaxShadowSize = f4;
            this.shadowSize = (float) Math.round(f3 * 1.5f);
            this.dirty = true;
            invalidateSelf();
        }
    }
}
