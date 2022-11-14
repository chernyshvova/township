package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.legacy.widget.Space;
import com.android.billingclient.api.zzam;
import com.google.android.material.R$dimen;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.List;

public final class IndicatorViewController {
    @Nullable
    public Animator captionAnimator;
    public FrameLayout captionArea;
    public int captionDisplayed;
    public int captionToShow;
    public final float captionTranslationYPx;
    public int captionViewsAdded;
    public final Context context;
    public boolean errorEnabled;
    public CharSequence errorText;
    public int errorTextAppearance;
    public TextView errorView;
    public CharSequence helperText;
    public boolean helperTextEnabled;
    public int helperTextTextAppearance;
    public TextView helperTextView;
    public LinearLayout indicatorArea;
    public int indicatorsAdded;
    public final TextInputLayout textInputView;
    public Typeface typeface;

    public IndicatorViewController(TextInputLayout textInputLayout) {
        Context context2 = textInputLayout.getContext();
        this.context = context2;
        this.textInputView = textInputLayout;
        this.captionTranslationYPx = (float) context2.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    public void addIndicator(TextView textView, int i) {
        if (this.indicatorArea == null && this.captionArea == null) {
            LinearLayout linearLayout = new LinearLayout(this.context);
            this.indicatorArea = linearLayout;
            linearLayout.setOrientation(0);
            this.textInputView.addView(this.indicatorArea, -1, -2);
            FrameLayout frameLayout = new FrameLayout(this.context);
            this.captionArea = frameLayout;
            this.indicatorArea.addView(frameLayout, -1, new FrameLayout.LayoutParams(-2, -2));
            this.indicatorArea.addView(new Space(this.context), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.textInputView.getEditText() != null) {
                adjustIndicatorPadding();
            }
        }
        if (i == 0 || i == 1) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(textView);
            this.captionViewsAdded++;
        } else {
            this.indicatorArea.addView(textView, i);
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
    }

    public void adjustIndicatorPadding() {
        if ((this.indicatorArea == null || this.textInputView.getEditText() == null) ? false : true) {
            ViewCompat.setPaddingRelative(this.indicatorArea, ViewCompat.getPaddingStart(this.textInputView.getEditText()), 0, ViewCompat.getPaddingEnd(this.textInputView.getEditText()), 0);
        }
    }

    public void cancelCaptionAnimator() {
        Animator animator = this.captionAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void createCaptionAnimators(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView != null && z) {
            if (i == i3 || i == i2) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{i3 == i ? 1.0f : 0.0f});
                ofFloat.setDuration(167);
                ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                list.add(ofFloat);
                if (i3 == i) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.captionTranslationYPx, 0.0f});
                    ofFloat2.setDuration(217);
                    ofFloat2.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                    list.add(ofFloat2);
                }
            }
        }
    }

    public boolean errorShouldBeShown() {
        if (this.captionToShow != 1 || this.errorView == null || TextUtils.isEmpty(this.errorText)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final TextView getCaptionViewFromDisplayState(int i) {
        if (i == 1) {
            return this.errorView;
        }
        if (i != 2) {
            return null;
        }
        return this.helperTextView;
    }

    @ColorInt
    public int getErrorViewCurrentTextColor() {
        TextView textView = this.errorView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) {
            if (!this.helperTextEnabled || TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 0;
            } else {
                this.captionToShow = 2;
            }
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, (CharSequence) null));
    }

    public void removeIndicator(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.indicatorArea != null) {
            if (!(i == 0 || i == 1) || (frameLayout = this.captionArea) == null) {
                this.indicatorArea.removeView(textView);
            } else {
                int i2 = this.captionViewsAdded - 1;
                this.captionViewsAdded = i2;
                if (i2 == 0) {
                    frameLayout.setVisibility(8);
                }
                this.captionArea.removeView(textView);
            }
            int i3 = this.indicatorsAdded - 1;
            this.indicatorsAdded = i3;
            LinearLayout linearLayout = this.indicatorArea;
            if (i3 == 0) {
                linearLayout.setVisibility(8);
            }
        }
    }

    public final boolean shouldAnimateCaptionView(TextView textView, @Nullable CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.textInputView) && this.textInputView.isEnabled() && (this.captionToShow != this.captionDisplayed || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void updateCaptionViewsVisibility(int i, int i2, boolean z) {
        TextView captionViewFromDisplayState;
        TextView captionViewFromDisplayState2;
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.captionAnimator = animatorSet;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = arrayList;
            int i5 = i;
            int i6 = i2;
            createCaptionAnimators(arrayList2, this.helperTextEnabled, this.helperTextView, 2, i5, i6);
            createCaptionAnimators(arrayList2, this.errorEnabled, this.errorView, 1, i5, i6);
            zzam.playTogether(animatorSet, arrayList);
            final TextView captionViewFromDisplayState3 = getCaptionViewFromDisplayState(i);
            final TextView captionViewFromDisplayState4 = getCaptionViewFromDisplayState(i2);
            final int i7 = i2;
            final int i8 = i;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    TextView textView;
                    IndicatorViewController indicatorViewController = IndicatorViewController.this;
                    indicatorViewController.captionDisplayed = i7;
                    indicatorViewController.captionAnimator = null;
                    TextView textView2 = captionViewFromDisplayState3;
                    if (textView2 != null) {
                        textView2.setVisibility(4);
                        if (i8 == 1 && (textView = IndicatorViewController.this.errorView) != null) {
                            textView.setText((CharSequence) null);
                        }
                    }
                }

                public void onAnimationStart(Animator animator) {
                    TextView textView = captionViewFromDisplayState4;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else if (i3 != i4) {
            if (!(i4 == 0 || (captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i2)) == null)) {
                captionViewFromDisplayState2.setVisibility(0);
                captionViewFromDisplayState2.setAlpha(1.0f);
            }
            if (!(i3 == 0 || (captionViewFromDisplayState = getCaptionViewFromDisplayState(i)) == null)) {
                captionViewFromDisplayState.setVisibility(4);
                if (i3 == 1) {
                    captionViewFromDisplayState.setText((CharSequence) null);
                }
            }
            this.captionDisplayed = i4;
        }
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateLabelState(z2);
        this.textInputView.updateTextInputBoxState();
    }
}
