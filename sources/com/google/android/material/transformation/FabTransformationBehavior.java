package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.android.billingclient.api.zzam;
import com.google.android.material.R$animator;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat$1;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.swrve.sdk.conversations.engine.model.styles.ConversationColorStyle;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final int[] tmpArray = new int[2];
    public final Rect tmpRect = new Rect();
    public final RectF tmpRectF1 = new RectF();
    public final RectF tmpRectF2 = new RectF();

    public static class FabTransformationSpec {
        public Positioning positioning;
        public MotionSpec timings;
    }

    public FabTransformationBehavior() {
    }

    public final float calculateTranslationX(View view, View view2, Positioning positioning) {
        float f;
        float f2;
        float f3;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i = positioning.gravity & 7;
        if (i == 1) {
            f3 = rectF2.centerX();
            f2 = rectF.centerX();
        } else if (i == 3) {
            f3 = rectF2.left;
            f2 = rectF.left;
        } else if (i != 5) {
            f = 0.0f;
            return f + positioning.xAdjustment;
        } else {
            f3 = rectF2.right;
            f2 = rectF.right;
        }
        f = f3 - f2;
        return f + positioning.xAdjustment;
    }

    public final float calculateTranslationY(View view, View view2, Positioning positioning) {
        float f;
        float f2;
        float f3;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i = positioning.gravity & 112;
        if (i == 16) {
            f3 = rectF2.centerY();
            f2 = rectF.centerY();
        } else if (i == 48) {
            f3 = rectF2.top;
            f2 = rectF.top;
        } else if (i != 80) {
            f = 0.0f;
            return f + positioning.yAdjustment;
        } else {
            f3 = rectF2.bottom;
            f2 = rectF.bottom;
        }
        f = f3 - f2;
        return f + positioning.yAdjustment;
    }

    public final float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f, float f2) {
        long j = motionTiming.delay;
        long j2 = motionTiming.duration;
        MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        return AnimationUtils.lerp(f, f2, motionTiming.getInterpolator().getInterpolation(((float) (((timing.delay + timing.duration) + 17) - j)) / ((float) j2)));
    }

    public final void calculateWindowBounds(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.tmpArray;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    public final void createChildrenFadeAnimation(View view, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        ViewGroup viewGroup;
        ObjectAnimator objectAnimator;
        if (view instanceof ViewGroup) {
            if (!(view instanceof CircularRevealWidget) || CircularRevealHelper.STRATEGY != 0) {
                View findViewById = view.findViewById(R$id.mtrl_child_content_container);
                if (findViewById != null) {
                    viewGroup = toViewGroupOrNull(findViewById);
                } else if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
                    viewGroup = toViewGroupOrNull(((ViewGroup) view).getChildAt(0));
                } else {
                    viewGroup = toViewGroupOrNull(view);
                }
                if (viewGroup != null) {
                    if (z) {
                        if (!z2) {
                            ChildrenAlphaProperty.CHILDREN_ALPHA.set(viewGroup, Float.valueOf(0.0f));
                        }
                        objectAnimator = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
                    } else {
                        objectAnimator = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
                    }
                    fabTransformationSpec.timings.getTiming("contentFade").apply(objectAnimator);
                    list.add(objectAnimator);
                }
            }
        }
    }

    public final void createColorAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
            int i = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    circularRevealWidget.setCircularRevealScrimColor(colorForState);
                }
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{i});
            } else {
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{colorForState});
            }
            objectAnimator.setEvaluator(ArgbEvaluatorCompat.instance);
            fabTransformationSpec.timings.getTiming(ConversationColorStyle.TYPE_COLOR).apply(objectAnimator);
            list.add(objectAnimator);
        }
    }

    @TargetApi(21)
    public final void createElevationAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        ObjectAnimator objectAnimator;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-elevation});
        }
        fabTransformationSpec.timings.getTiming("elevation").apply(objectAnimator);
        list.add(objectAnimator);
    }

    public final void createPreFillRadialExpansion(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j);
            list.add(createCircularReveal);
        }
    }

    public final void createTranslationAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list, RectF rectF) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
        if (calculateTranslationX == 0.0f || calculateTranslationY == 0.0f) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXLinear");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYLinear");
        } else if ((!z || calculateTranslationY >= 0.0f) && (z || calculateTranslationY <= 0.0f)) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
        } else {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
        }
        if (z) {
            if (!z2) {
                view2.setTranslationX(-calculateTranslationX);
                view2.setTranslationY(-calculateTranslationY);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f});
            float calculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming2, -calculateTranslationX, 0.0f);
            float calculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming, -calculateTranslationY, 0.0f);
            Rect rect = this.tmpRect;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.tmpRectF1;
            rectF2.set(rect);
            RectF rectF3 = this.tmpRectF2;
            calculateWindowBounds(view2, rectF3);
            rectF3.offset(calculateValueOfAnimationAtEndOfExpansion, calculateValueOfAnimationAtEndOfExpansion2);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{-calculateTranslationX});
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{-calculateTranslationY});
        }
        motionTiming2.apply(objectAnimator2);
        motionTiming.apply(objectAnimator);
        list.add(objectAnimator2);
        list.add(objectAnimator);
    }

    @CallSuper
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean z, boolean z2) {
        int i;
        FabTransformationSpec fabTransformationSpec;
        Animator animator;
        CircularRevealWidget circularRevealWidget;
        MotionTiming motionTiming;
        ObjectAnimator objectAnimator;
        View view3 = view;
        final View view4 = view2;
        boolean z3 = z;
        Context context = view2.getContext();
        if (z3) {
            i = R$animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i = R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationSpec fabTransformationSpec2 = new FabTransformationSpec();
        fabTransformationSpec2.timings = MotionSpec.createFromResource(context, i);
        fabTransformationSpec2.positioning = new Positioning(17, 0.0f, 0.0f);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            createElevationAnimation(view, view2, z, z2, fabTransformationSpec2, arrayList);
        }
        RectF rectF = this.tmpRectF1;
        createTranslationAnimation(view, view2, z, z2, fabTransformationSpec2, arrayList, rectF);
        float width = rectF.width();
        float height = rectF.height();
        boolean z4 = view4 instanceof CircularRevealWidget;
        if (z4 && (view3 instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget2 = (CircularRevealWidget) view4;
            final Drawable drawable = ((ImageView) view3).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z3) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{255});
                }
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view4.invalidate();
                    }
                });
                fabTransformationSpec2.timings.getTiming("iconFade").apply(objectAnimator);
                arrayList.add(objectAnimator);
                arrayList2.add(new AnimatorListenerAdapter(this) {
                    public void onAnimationEnd(Animator animator) {
                        circularRevealWidget2.setCircularRevealOverlayDrawable((Drawable) null);
                    }

                    public void onAnimationStart(Animator animator) {
                        circularRevealWidget2.setCircularRevealOverlayDrawable(drawable);
                    }
                });
            }
        }
        if (!z4) {
            fabTransformationSpec = fabTransformationSpec2;
        } else {
            final CircularRevealWidget circularRevealWidget3 = (CircularRevealWidget) view4;
            Positioning positioning = fabTransformationSpec2.positioning;
            RectF rectF2 = this.tmpRectF1;
            RectF rectF3 = this.tmpRectF2;
            calculateWindowBounds(view3, rectF2);
            calculateWindowBounds(view4, rectF3);
            rectF3.offset(-calculateTranslationX(view3, view4, positioning), 0.0f);
            float centerX = rectF2.centerX() - rectF3.left;
            Positioning positioning2 = fabTransformationSpec2.positioning;
            RectF rectF4 = this.tmpRectF1;
            RectF rectF5 = this.tmpRectF2;
            calculateWindowBounds(view3, rectF4);
            calculateWindowBounds(view4, rectF5);
            rectF5.offset(0.0f, -calculateTranslationY(view3, view4, positioning2));
            float centerY = rectF4.centerY() - rectF5.top;
            ((FloatingActionButton) view3).getContentRect(this.tmpRect);
            float width2 = ((float) this.tmpRect.width()) / 2.0f;
            MotionTiming timing = fabTransformationSpec2.timings.getTiming("expansion");
            if (z3) {
                if (!z2) {
                    circularRevealWidget3.setRevealInfo(new CircularRevealWidget.RevealInfo(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = circularRevealWidget3.getRevealInfo().radius;
                }
                float dist = zzam.dist(centerX, centerY, 0.0f, 0.0f);
                float dist2 = zzam.dist(centerX, centerY, width, 0.0f);
                float dist3 = zzam.dist(centerX, centerY, width, height);
                float dist4 = zzam.dist(centerX, centerY, 0.0f, height);
                if (dist <= dist2 || dist <= dist3 || dist <= dist4) {
                    dist = (dist2 <= dist3 || dist2 <= dist4) ? dist3 > dist4 ? dist3 : dist4 : dist2;
                }
                Animator createCircularReveal = zzam.createCircularReveal(circularRevealWidget3, centerX, centerY, dist);
                createCircularReveal.addListener(new AnimatorListenerAdapter(this) {
                    public void onAnimationEnd(Animator animator) {
                        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget3.getRevealInfo();
                        revealInfo.radius = Float.MAX_VALUE;
                        circularRevealWidget3.setRevealInfo(revealInfo);
                    }
                });
                createPreFillRadialExpansion(view2, timing.delay, (int) centerX, (int) centerY, width2, arrayList);
                fabTransformationSpec = fabTransformationSpec2;
                motionTiming = timing;
                animator = createCircularReveal;
                circularRevealWidget = circularRevealWidget3;
            } else {
                MotionTiming motionTiming2 = timing;
                CircularRevealWidget circularRevealWidget4 = circularRevealWidget3;
                float f = circularRevealWidget4.getRevealInfo().radius;
                CircularRevealWidget circularRevealWidget5 = circularRevealWidget4;
                Animator createCircularReveal2 = zzam.createCircularReveal(circularRevealWidget5, centerX, centerY, width2);
                int i2 = (int) centerX;
                int i3 = (int) centerY;
                int i4 = i2;
                circularRevealWidget = circularRevealWidget5;
                float f2 = width2;
                createPreFillRadialExpansion(view2, motionTiming2.delay, i2, i3, f, arrayList);
                long j = motionTiming2.delay;
                long j2 = motionTiming2.duration;
                MotionSpec motionSpec = fabTransformationSpec2.timings;
                int size = motionSpec.timings.size();
                long j3 = 0;
                int i5 = 0;
                while (i5 < size) {
                    int i6 = size;
                    MotionTiming valueAt = motionSpec.timings.valueAt(i5);
                    j3 = Math.max(j3, valueAt.delay + valueAt.duration);
                    i5++;
                    size = i6;
                    fabTransformationSpec2 = fabTransformationSpec2;
                    motionTiming2 = motionTiming2;
                    motionSpec = motionSpec;
                }
                fabTransformationSpec = fabTransformationSpec2;
                MotionTiming motionTiming3 = motionTiming2;
                if (Build.VERSION.SDK_INT >= 21) {
                    long j4 = j + j2;
                    if (j4 < j3) {
                        Animator createCircularReveal3 = ViewAnimationUtils.createCircularReveal(view4, i4, i3, f2, f2);
                        createCircularReveal3.setStartDelay(j4);
                        createCircularReveal3.setDuration(j3 - j4);
                        arrayList.add(createCircularReveal3);
                    }
                }
                animator = createCircularReveal2;
                motionTiming = motionTiming3;
            }
            motionTiming.apply(animator);
            arrayList.add(animator);
            arrayList2.add(new CircularRevealCompat$1(circularRevealWidget));
        }
        createColorAnimation(view, view2, z, z2, fabTransformationSpec, arrayList);
        createChildrenFadeAnimation(view2, z, z2, fabTransformationSpec, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        zzam.playTogether(animatorSet, arrayList);
        final View view5 = view;
        final boolean z5 = z;
        animatorSet.addListener(new AnimatorListenerAdapter(this) {
            public void onAnimationEnd(Animator animator) {
                if (!z5) {
                    view4.setVisibility(4);
                    view5.setAlpha(1.0f);
                    view5.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z5) {
                    view4.setVisibility(0);
                    view5.setAlpha(0.0f);
                    view5.setVisibility(4);
                }
            }
        });
        int size2 = arrayList2.size();
        for (int i7 = 0; i7 < size2; i7++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i7));
        }
        return animatorSet;
    }

    @Nullable
    public final ViewGroup toViewGroupOrNull(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
