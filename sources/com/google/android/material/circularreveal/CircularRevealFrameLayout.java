package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealWidget;

public class CircularRevealFrameLayout extends FrameLayout implements CircularRevealWidget {
    public void buildCircularRevealCache() {
        throw null;
    }

    public void destroyCircularRevealCache() {
        throw null;
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        throw null;
    }

    public int getCircularRevealScrimColor() {
        throw null;
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        throw null;
    }

    public boolean isOpaque() {
        return super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        throw null;
    }

    public void setCircularRevealScrimColor(@ColorInt int i) {
        throw null;
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        throw null;
    }
}
