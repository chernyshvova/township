package com.helpshift.animation;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

public class CollapseViewAnimation extends Animation {
    public LinearLayout view;
    public int viewHeight;

    public CollapseViewAnimation(LinearLayout linearLayout) {
        this.view = linearLayout;
        this.viewHeight = linearLayout.getHeight();
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.view.getLayoutParams().height = (int) ((1.0f - f) * ((float) this.viewHeight));
        this.view.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
