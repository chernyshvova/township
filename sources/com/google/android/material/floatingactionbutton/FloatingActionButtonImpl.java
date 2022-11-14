package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.android.billingclient.api.zzam;
import com.google.android.material.R$color;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;

public class FloatingActionButtonImpl {
    public static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final int[] EMPTY_STATE_SET = new int[0];
    public static final int[] ENABLED_STATE_SET = {16842910};
    public static final int[] FOCUSED_ENABLED_STATE_SET = {16842908, 16842910};
    public static final int[] HOVERED_ENABLED_STATE_SET = {16843623, 16842910};
    public static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {16843623, 16842908, 16842910};
    public static final int[] PRESSED_ENABLED_STATE_SET = {16842919, 16842910};
    public int animState = 0;
    public CircularBorderDrawable borderDrawable;
    public Drawable contentBackground;
    @Nullable
    public Animator currentAnimator;
    @Nullable
    public MotionSpec defaultHideMotionSpec;
    @Nullable
    public MotionSpec defaultShowMotionSpec;
    public float elevation;
    public ArrayList<Animator.AnimatorListener> hideListeners;
    @Nullable
    public MotionSpec hideMotionSpec;
    public float hoveredFocusedTranslationZ;
    public float imageMatrixScale = 1.0f;
    public int maxImageSize;
    public ViewTreeObserver.OnPreDrawListener preDrawListener;
    public float pressedTranslationZ;
    public Drawable rippleDrawable;
    public float rotation;
    public ShadowDrawableWrapper shadowDrawable;
    public final ShadowViewDelegate shadowViewDelegate;
    public Drawable shapeDrawable;
    public ArrayList<Animator.AnimatorListener> showListeners;
    @Nullable
    public MotionSpec showMotionSpec;
    public final StateListAnimator stateListAnimator;
    public final Matrix tmpMatrix = new Matrix();
    public final Rect tmpRect = new Rect();
    public final RectF tmpRectF1 = new RectF();
    public final RectF tmpRectF2 = new RectF();
    public final VisibilityAwareImageButton view;

    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        public DisabledElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            super((C21301) null);
        }

        public float getTargetShadowSize() {
            return 0.0f;
        }
    }

    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        public ElevateToHoveredFocusedTranslationZAnimation() {
            super((C21301) null);
        }

        public float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.hoveredFocusedTranslationZ;
        }
    }

    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        public ElevateToPressedTranslationZAnimation() {
            super((C21301) null);
        }

        public float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.pressedTranslationZ;
        }
    }

    public interface InternalVisibilityChangedListener {
    }

    public class ResetElevationAnimation extends ShadowAnimatorImpl {
        public ResetElevationAnimation() {
            super((C21301) null);
        }

        public float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation;
        }
    }

    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public float shadowSizeEnd;
        public float shadowSizeStart;
        public boolean validValues;

        public ShadowAnimatorImpl(C21301 r2) {
        }

        public abstract float getTargetShadowSize();

        public void onAnimationEnd(Animator animator) {
            ShadowDrawableWrapper shadowDrawableWrapper = FloatingActionButtonImpl.this.shadowDrawable;
            shadowDrawableWrapper.setShadowSize(this.shadowSizeEnd, shadowDrawableWrapper.rawMaxShadowSize);
            this.validValues = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.validValues) {
                this.shadowSizeStart = FloatingActionButtonImpl.this.shadowDrawable.rawShadowSize;
                this.shadowSizeEnd = getTargetShadowSize();
                this.validValues = true;
            }
            ShadowDrawableWrapper shadowDrawableWrapper = FloatingActionButtonImpl.this.shadowDrawable;
            float f = this.shadowSizeStart;
            shadowDrawableWrapper.setShadowSize((valueAnimator.getAnimatedFraction() * (this.shadowSizeEnd - f)) + f, shadowDrawableWrapper.rawMaxShadowSize);
        }
    }

    public FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate2) {
        this.view = visibilityAwareImageButton;
        this.shadowViewDelegate = shadowViewDelegate2;
        StateListAnimator stateListAnimator2 = new StateListAnimator();
        this.stateListAnimator = stateListAnimator2;
        stateListAnimator2.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation()));
        this.stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation()));
        this.stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = this.view.getRotation();
    }

    public final void calculateImageMatrixFromScale(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.view.getDrawable();
        if (drawable != null && this.maxImageSize != 0) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i = this.maxImageSize;
            rectF2.set(0.0f, 0.0f, (float) i, (float) i);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i2 = this.maxImageSize;
            matrix.postScale(f, f, ((float) i2) / 2.0f, ((float) i2) / 2.0f);
        }
    }

    @NonNull
    public final AnimatorSet createAnimator(@NonNull MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[]{f});
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{f2});
        motionSpec.getTiming("scale").apply(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{f2});
        motionSpec.getTiming("scale").apply(ofFloat3);
        arrayList.add(ofFloat3);
        calculateImageMatrixFromScale(f3, this.tmpMatrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator(), new Matrix[]{new Matrix(this.tmpMatrix)});
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        zzam.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public CircularBorderDrawable createBorderDrawable(int i, ColorStateList colorStateList) {
        Context context = this.view.getContext();
        CircularBorderDrawable newCircularDrawable = newCircularDrawable();
        int color = ContextCompat.getColor(context, R$color.design_fab_stroke_top_outer_color);
        int color2 = ContextCompat.getColor(context, R$color.design_fab_stroke_top_inner_color);
        int color3 = ContextCompat.getColor(context, R$color.design_fab_stroke_end_inner_color);
        int color4 = ContextCompat.getColor(context, R$color.design_fab_stroke_end_outer_color);
        newCircularDrawable.topOuterStrokeColor = color;
        newCircularDrawable.topInnerStrokeColor = color2;
        newCircularDrawable.bottomOuterStrokeColor = color3;
        newCircularDrawable.bottomInnerStrokeColor = color4;
        float f = (float) i;
        if (newCircularDrawable.borderWidth != f) {
            newCircularDrawable.borderWidth = f;
            newCircularDrawable.paint.setStrokeWidth(f * 1.3333f);
            newCircularDrawable.invalidateShader = true;
            newCircularDrawable.invalidateSelf();
        }
        newCircularDrawable.setBorderTint(colorStateList);
        return newCircularDrawable;
    }

    public final ValueAnimator createElevationAnimator(@NonNull ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    public GradientDrawable createShapeDrawable() {
        GradientDrawable newGradientDrawableForShape = newGradientDrawableForShape();
        newGradientDrawableForShape.setShape(1);
        newGradientDrawableForShape.setColor(-1);
        return newGradientDrawableForShape;
    }

    public float getElevation() {
        return this.elevation;
    }

    public void getPadding(Rect rect) {
        this.shadowDrawable.getPadding(rect);
    }

    public boolean isOrWillBeShown() {
        if (this.view.getVisibility() != 0) {
            if (this.animState == 2) {
                return true;
            }
            return false;
        } else if (this.animState != 1) {
            return true;
        } else {
            return false;
        }
    }

    public void jumpDrawableToCurrentState() {
        StateListAnimator stateListAnimator2 = this.stateListAnimator;
        ValueAnimator valueAnimator = stateListAnimator2.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            stateListAnimator2.runningAnimator = null;
        }
    }

    public CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawable();
    }

    public GradientDrawable newGradientDrawableForShape() {
        return new GradientDrawable();
    }

    public void onCompatShadowChanged() {
    }

    public void onDrawableStateChanged(int[] iArr) {
        StateListAnimator.Tuple tuple;
        ValueAnimator valueAnimator;
        StateListAnimator stateListAnimator2 = this.stateListAnimator;
        int size = stateListAnimator2.tuples.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                tuple = null;
                break;
            }
            tuple = stateListAnimator2.tuples.get(i);
            if (StateSet.stateSetMatches(tuple.specs, iArr)) {
                break;
            }
            i++;
        }
        StateListAnimator.Tuple tuple2 = stateListAnimator2.lastMatch;
        if (tuple != tuple2) {
            if (!(tuple2 == null || (valueAnimator = stateListAnimator2.runningAnimator) == null)) {
                valueAnimator.cancel();
                stateListAnimator2.runningAnimator = null;
            }
            stateListAnimator2.lastMatch = tuple;
            if (tuple != null) {
                ValueAnimator valueAnimator2 = tuple.animator;
                stateListAnimator2.runningAnimator = valueAnimator2;
                valueAnimator2.start();
            }
        }
    }

    public void onElevationsChanged(float f, float f2, float f3) {
        ShadowDrawableWrapper shadowDrawableWrapper = this.shadowDrawable;
        if (shadowDrawableWrapper != null) {
            shadowDrawableWrapper.setShadowSize(f, this.pressedTranslationZ + f);
            updatePadding();
        }
    }

    public void onPaddingUpdated(Rect rect) {
    }

    public boolean requirePreDrawListener() {
        return true;
    }

    public void setBackgroundDrawable(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable[] drawableArr;
        Drawable wrap = DrawableCompat.wrap(createShapeDrawable());
        this.shapeDrawable = wrap;
        DrawableCompat.setTintList(wrap, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.shapeDrawable, mode);
        }
        Drawable wrap2 = DrawableCompat.wrap(createShapeDrawable());
        this.rippleDrawable = wrap2;
        DrawableCompat.setTintList(wrap2, RippleUtils.convertToRippleDrawableColor(colorStateList2));
        if (i > 0) {
            CircularBorderDrawable createBorderDrawable = createBorderDrawable(i, colorStateList);
            this.borderDrawable = createBorderDrawable;
            drawableArr = new Drawable[]{createBorderDrawable, this.shapeDrawable, this.rippleDrawable};
        } else {
            this.borderDrawable = null;
            drawableArr = new Drawable[]{this.shapeDrawable, this.rippleDrawable};
        }
        this.contentBackground = new LayerDrawable(drawableArr);
        float f = this.elevation;
        ShadowDrawableWrapper shadowDrawableWrapper = new ShadowDrawableWrapper(this.view.getContext(), this.contentBackground, ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f, f, f + this.pressedTranslationZ);
        this.shadowDrawable = shadowDrawableWrapper;
        shadowDrawableWrapper.addPaddingForCorners = false;
        shadowDrawableWrapper.invalidateSelf();
        ShadowViewDelegate shadowViewDelegate2 = this.shadowViewDelegate;
        FloatingActionButtonImpl.super.setBackgroundDrawable(this.shadowDrawable);
    }

    public final void setImageMatrixScale(float f) {
        this.imageMatrixScale = f;
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f, matrix);
        this.view.setImageMatrix(matrix);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.convertToRippleDrawableColor(colorStateList));
        }
    }

    public final boolean shouldAnimateVisibilityChange() {
        return ViewCompat.isLaidOut(this.view) && !this.view.isInEditMode();
    }

    public final void updatePadding() {
        Rect rect = this.tmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        ShadowViewDelegate shadowViewDelegate2 = this.shadowViewDelegate;
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        FloatingActionButton.ShadowDelegateImpl shadowDelegateImpl = (FloatingActionButton.ShadowDelegateImpl) shadowViewDelegate2;
        FloatingActionButton.this.shadowPadding.set(i, i2, i3, i4);
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        int i5 = floatingActionButton.imagePadding;
        floatingActionButton.setPadding(i + i5, i2 + i5, i3 + i5, i4 + i5);
    }
}
