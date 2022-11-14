package com.helpshift.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class HSAnimationUtil {
    public static void fadeVisibilityGone(final View view, int i) {
        view.animate().alpha(0.0f).setDuration((long) i).setInterpolator(new LinearInterpolator()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
            }
        }).start();
    }

    public static void fadeVisibilityIn(final View view, int i) {
        view.animate().alpha(1.0f).setDuration((long) i).setInterpolator(new LinearInterpolator()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(0);
            }
        }).start();
    }

    public static void rotate(View view, int i, float f) {
        view.animate().rotation(f).setDuration((long) i).setInterpolator(new LinearInterpolator());
    }
}
