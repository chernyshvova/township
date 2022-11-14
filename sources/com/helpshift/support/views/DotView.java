package com.helpshift.support.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class DotView extends View implements ValueAnimator.AnimatorUpdateListener {
    public float centerX;
    public float centerY;
    public int dotColor;
    public RectF ovalRectF;
    public Paint paint;
    public float radius;

    public DotView(Context context, int i) {
        super(context);
        this.centerX = -1.0f;
        this.centerY = -1.0f;
        this.dotColor = i;
        setup();
    }

    private void setup() {
        this.ovalRectF = new RectF();
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.paint.setColor(this.dotColor);
    }

    private void updateOvalRectF() {
        RectF rectF = this.ovalRectF;
        float f = this.centerX;
        float f2 = this.radius;
        rectF.left = f - f2;
        rectF.right = f + f2;
        float f3 = this.centerY;
        rectF.top = f3 - f2;
        rectF.bottom = f3 + f2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int argb = Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), Color.red(this.dotColor), Color.green(this.dotColor), Color.blue(this.dotColor));
        this.dotColor = argb;
        this.paint.setColor(argb);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        canvas.drawOval(this.ovalRectF, this.paint);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.centerX = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        this.centerY = height;
        this.radius = Math.min(this.centerX, height);
        updateOvalRectF();
    }

    public void setDotColor(int i) {
        this.dotColor = i;
        invalidate();
    }

    public DotView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DotView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.centerX = -1.0f;
        this.centerY = -1.0f;
    }
}
