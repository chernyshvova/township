package com.helpshift.support.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.helpshift.C2466R;
import java.util.Iterator;

public class HSTypingIndicatorView extends LinearLayout {
    public static final int ALPHA_DARK = 179;
    public static final int ALPHA_LIGHT = 76;
    public final long ANIMATION_DURATION;
    public final long LOOP_START_DELAY;
    public int LightDotColor;
    public AnimatorSet dotAnimatorSet;
    public Animator[] dotAnimators;
    public float dotDiameter;
    public DotView[] dots;
    public float interDotPadding;

    public HSTypingIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2466R.styleable.HSTypingIndicatorView, 0, 0);
        int color = obtainStyledAttributes.getColor(C2466R.styleable.HSTypingIndicatorView_hs__dotColor, 0);
        this.LightDotColor = Color.argb(76, Color.red(color), Color.green(color), Color.blue(color));
        this.interDotPadding = obtainStyledAttributes.getDimension(C2466R.styleable.HSTypingIndicatorView_hs__interDotPadding, 0.0f);
        this.dotDiameter = obtainStyledAttributes.getDimension(C2466R.styleable.HSTypingIndicatorView_hs__dotDiameter, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private void setup() {
        this.dots = new DotView[3];
        for (int i = 0; i < 3; i++) {
            this.dots[i] = new DotView(getContext(), this.LightDotColor);
            float f = this.interDotPadding;
            float f2 = f / 2.0f;
            float f3 = f / 2.0f;
            long j = 0;
            if (i == 0) {
                f2 = 0.0f;
            } else if (i == 1) {
                j = 225;
            } else if (i == 2) {
                j = 450;
                f3 = 0.0f;
            }
            float f4 = this.dotDiameter;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) f4, (int) f4);
            layoutParams.setMargins((int) f2, 0, (int) f3, 0);
            addView(this.dots[i], layoutParams);
            this.dotAnimators[i] = getAnimator(j, this.dots[i]);
        }
    }

    private void startTypingAnimation() {
        if (this.dotAnimatorSet == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.dotAnimatorSet = animatorSet;
            animatorSet.playTogether(this.dotAnimators);
            this.dotAnimatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    animator.setStartDelay(450);
                    animator.start();
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
            this.dotAnimatorSet.start();
        }
    }

    private void stopTypingAnimation() {
        AnimatorSet animatorSet = this.dotAnimatorSet;
        if (animatorSet != null) {
            Iterator<Animator> it = animatorSet.getChildAnimations().iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.dotAnimatorSet.cancel();
            this.dotAnimatorSet.removeAllListeners();
            this.dotAnimatorSet = null;
            for (DotView dotColor : this.dots) {
                dotColor.setDotColor(this.LightDotColor);
            }
        }
    }

    public ValueAnimator getAnimator(long j, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{76, ALPHA_DARK, 76});
        ofInt.setStartDelay(j);
        ofInt.setDuration(900);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(animatorUpdateListener);
        return ofInt;
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            startTypingAnimation();
        } else {
            stopTypingAnimation();
        }
    }

    public HSTypingIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ANIMATION_DURATION = 900;
        this.LOOP_START_DELAY = 450;
        this.dotAnimators = new Animator[3];
        initAttributes(context, attributeSet);
        setup();
    }
}
