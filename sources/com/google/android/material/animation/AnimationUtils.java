package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.android.tools.p006r8.GeneratedOutlineSupport;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtils {
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();

    public static float lerp(float f, float f2, float f3) {
        return GeneratedOutlineSupport.outline0(f2, f, f3, f);
    }

    public static int lerp(int i, int i2, float f) {
        return Math.round(f * ((float) (i2 - i))) + i;
    }
}
