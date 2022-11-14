package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CircularBorderDrawable extends Drawable {
    public ColorStateList borderTint;
    @Dimension
    public float borderWidth;
    @ColorInt
    public int bottomInnerStrokeColor;
    @ColorInt
    public int bottomOuterStrokeColor;
    @ColorInt
    public int currentBorderTintColor;
    public boolean invalidateShader = true;
    public final Paint paint;
    public final Rect rect = new Rect();
    public final RectF rectF = new RectF();
    @FloatRange(from = 0.0d, mo263to = 360.0d)
    public float rotation;
    public final CircularBorderState state = new CircularBorderState((C21341) null);
    @ColorInt
    public int topInnerStrokeColor;
    @ColorInt
    public int topOuterStrokeColor;

    public class CircularBorderState extends Drawable.ConstantState {
        public CircularBorderState(C21341 r2) {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return CircularBorderDrawable.this;
        }
    }

    public CircularBorderDrawable() {
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    public void draw(Canvas canvas) {
        if (this.invalidateShader) {
            Paint paint2 = this.paint;
            Rect rect2 = this.rect;
            copyBounds(rect2);
            float height = this.borderWidth / ((float) rect2.height());
            paint2.setShader(new LinearGradient(0.0f, (float) rect2.top, 0.0f, (float) rect2.bottom, new int[]{ColorUtils.compositeColors(this.topOuterStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.topInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomOuterStrokeColor, this.currentBorderTintColor)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP));
            this.invalidateShader = false;
        }
        float strokeWidth = this.paint.getStrokeWidth() / 2.0f;
        RectF rectF2 = this.rectF;
        copyBounds(this.rect);
        rectF2.set(this.rect);
        rectF2.left += strokeWidth;
        rectF2.top += strokeWidth;
        rectF2.right -= strokeWidth;
        rectF2.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.rotation, rectF2.centerX(), rectF2.centerY());
        canvas.drawOval(rectF2, this.paint);
        canvas.restore();
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public int getOpacity() {
        return this.borderWidth > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect2) {
        int round = Math.round(this.borderWidth);
        rect2.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.borderTint;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public void onBoundsChange(Rect rect2) {
        this.invalidateShader = true;
    }

    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.borderTint;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.currentBorderTintColor)) == this.currentBorderTintColor)) {
            this.invalidateShader = true;
            this.currentBorderTintColor = colorForState;
        }
        if (this.invalidateShader) {
            invalidateSelf();
        }
        return this.invalidateShader;
    }

    public void setAlpha(@IntRange(from = 0, mo281to = 255) int i) {
        this.paint.setAlpha(i);
        invalidateSelf();
    }

    public void setBorderTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.currentBorderTintColor = colorStateList.getColorForState(getState(), this.currentBorderTintColor);
        }
        this.borderTint = colorStateList;
        this.invalidateShader = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
