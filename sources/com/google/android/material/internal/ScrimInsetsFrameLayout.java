package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {
    public Drawable insetForeground;
    public Rect insets;
    public Rect tempRect = new Rect();

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.insetForeground = obtainStyledAttributes.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                if (scrimInsetsFrameLayout.insets == null) {
                    scrimInsetsFrameLayout.insets = new Rect();
                }
                ScrimInsetsFrameLayout.this.insets.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                ScrimInsetsFrameLayout.this.onInsetsChanged(windowInsetsCompat);
                ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.insetForeground == null);
                ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.insets != null && this.insetForeground != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.tempRect.set(0, 0, width, this.insets.top);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
            this.tempRect.set(0, height - this.insets.bottom, width, height);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
            Rect rect = this.tempRect;
            Rect rect2 = this.insets;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
            Rect rect3 = this.tempRect;
            Rect rect4 = this.insets;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
    }
}
