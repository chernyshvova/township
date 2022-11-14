package com.swrve.sdk.conversations.p035ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.conversations.C1694R;

/* renamed from: com.swrve.sdk.conversations.ui.ConversationRoundedLinearLayout */
public class ConversationRoundedLinearLayout extends LinearLayout {
    public boolean clippingNotSupported = false;
    public int maxModalWidthPx;
    public Path path = new Path();
    public float radius;
    public final RectF rect = new RectF();

    public ConversationRoundedLinearLayout(Context context) {
        super(context);
        init();
    }

    private void drawRoundedCorners(int i, int i2) {
        this.path.reset();
        float f = 0.0f;
        this.rect.set(0.0f, 0.0f, (float) i, (float) i2);
        if (getWidth() >= this.maxModalWidthPx) {
            f = this.radius;
        }
        this.path.addRoundRect(this.rect, f, f, Path.Direction.CW);
        this.path.close();
    }

    private void init() {
        setFocusable(false);
        this.maxModalWidthPx = getResources().getDimensionPixelSize(C1694R.dimen.swrve__conversation_max_modal_width);
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.radius > 0.0f && !this.clippingNotSupported) {
            int save = canvas.save();
            try {
                canvas.clipPath(this.path);
            } catch (UnsupportedOperationException e) {
                SwrveLogger.m2753e("Could not use clipPath", e, new Object[0]);
                this.clippingNotSupported = true;
            }
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.dispatchDraw(canvas);
    }

    public float getRadius() {
        return this.radius;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        drawRoundedCorners(i, i2);
    }

    public void setRadius(float f) {
        if (this.radius != f) {
            this.radius = f;
            drawRoundedCorners(getWidth(), getHeight());
        }
    }

    public ConversationRoundedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
