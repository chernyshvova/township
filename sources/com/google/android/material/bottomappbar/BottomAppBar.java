package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.C0030Px;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.android.billingclient.api.zzam;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapePathModel;
import java.util.ArrayList;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    @Nullable
    public Animator attachAnimator;
    public int fabAlignmentMode;
    public AnimatorListenerAdapter fabAnimationListener = new AnimatorListenerAdapter() {
        public void onAnimationStart(Animator animator) {
            BottomAppBar bottomAppBar = BottomAppBar.this;
            BottomAppBar.access$700(bottomAppBar, bottomAppBar.fabAttached);
            BottomAppBar bottomAppBar2 = BottomAppBar.this;
            bottomAppBar2.maybeAnimateMenuView(bottomAppBar2.fabAlignmentMode, bottomAppBar2.fabAttached);
        }
    };
    public boolean fabAttached = true;
    public final int fabOffsetEndMode;
    public boolean hideOnScroll;
    public final MaterialShapeDrawable materialShapeDrawable;
    @Nullable
    public Animator menuAnimator;
    @Nullable
    public Animator modeAnimator;
    public final BottomAppBarTopEdgeTreatment topEdgeTreatment;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        public int fabAlignmentMode;
        public boolean fabAttached;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }
    }

    public BottomAppBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.BottomAppBar, i, R$style.Widget_MaterialComponents_BottomAppBar, new int[0]);
        ColorStateList colorStateList = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.BottomAppBar_backgroundTint);
        this.fabAlignmentMode = obtainStyledAttributes.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.hideOnScroll = obtainStyledAttributes.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        obtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        this.topEdgeTreatment = new BottomAppBarTopEdgeTreatment((float) obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0));
        ShapePathModel shapePathModel = new ShapePathModel();
        shapePathModel.topEdge = this.topEdgeTreatment;
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(shapePathModel);
        this.materialShapeDrawable = materialShapeDrawable2;
        materialShapeDrawable2.shadowEnabled = true;
        materialShapeDrawable2.invalidateSelf();
        MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
        materialShapeDrawable3.paintStyle = Paint.Style.FILL;
        materialShapeDrawable3.invalidateSelf();
        DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
        ViewCompat.setBackground(this, this.materialShapeDrawable);
    }

    public static void access$700(BottomAppBar bottomAppBar, boolean z) {
        if (bottomAppBar == null) {
            throw null;
        } else if (ViewCompat.isLaidOut(bottomAppBar)) {
            Animator animator = bottomAppBar.attachAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = z && bottomAppBar.isVisibleFab();
            if (z2) {
                bottomAppBar.topEdgeTreatment.horizontalOffset = bottomAppBar.getFabTranslationX();
            }
            float[] fArr = new float[2];
            fArr[0] = bottomAppBar.materialShapeDrawable.interpolation;
            fArr[1] = z2 ? 1.0f : 0.0f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MaterialShapeDrawable materialShapeDrawable = BottomAppBar.this.materialShapeDrawable;
                    materialShapeDrawable.interpolation = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    materialShapeDrawable.invalidateSelf();
                }
            });
            ofFloat.setDuration(300);
            arrayList.add(ofFloat);
            FloatingActionButton findDependentFab = bottomAppBar.findDependentFab();
            if (findDependentFab != null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findDependentFab, "translationY", new float[]{bottomAppBar.getFabTranslationY(z)});
                ofFloat2.setDuration(300);
                arrayList.add(ofFloat2);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            bottomAppBar.attachAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.attachAnimator = null;
                }
            });
            bottomAppBar.attachAnimator.start();
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    @Nullable
    public final FloatingActionButton findDependentFab() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View next : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if (next instanceof FloatingActionButton) {
                return (FloatingActionButton) next;
            }
        }
        return null;
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.tintList;
    }

    @NonNull
    public CoordinatorLayout.Behavior<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return this.topEdgeTreatment.cradleVerticalOffset;
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public float getFabCradleMargin() {
        return this.topEdgeTreatment.fabMargin;
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return this.topEdgeTreatment.roundedCornerRadius;
    }

    public final int getFabTranslationX(int i) {
        int i2 = 1;
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        if (i != 1) {
            return 0;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - this.fabOffsetEndMode;
        if (z) {
            i2 = -1;
        }
        return measuredWidth * i2;
    }

    public final float getFabTranslationY(boolean z) {
        FloatingActionButton findDependentFab = findDependentFab();
        if (findDependentFab == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        findDependentFab.getContentRect(rect);
        float height = (float) rect.height();
        if (height == 0.0f) {
            height = (float) findDependentFab.getMeasuredHeight();
        }
        float height2 = (float) (findDependentFab.getHeight() - rect.height());
        float height3 = (height / 2.0f) + (-getCradleVerticalOffset()) + ((float) (findDependentFab.getHeight() - rect.bottom));
        float paddingBottom = height2 - ((float) findDependentFab.getPaddingBottom());
        float f = (float) (-getMeasuredHeight());
        if (!z) {
            height3 = paddingBottom;
        }
        return f + height3;
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public final boolean isVisibleFab() {
        FloatingActionButton findDependentFab = findDependentFab();
        return findDependentFab != null && findDependentFab.isOrWillBeShown();
    }

    public final void maybeAnimateMenuView(final int i, final boolean z) {
        if (ViewCompat.isLaidOut(this)) {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!isVisibleFab()) {
                i = 0;
                z = false;
            }
            final ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
                if ((this.fabAttached || (z && isVisibleFab())) && (this.fabAlignmentMode == 1 || i == 1)) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                    ofFloat2.addListener(new AnimatorListenerAdapter() {
                        public boolean cancelled;

                        public void onAnimationCancel(Animator animator) {
                            this.cancelled = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.cancelled) {
                                BottomAppBar.this.translateActionMenuView(actionMenuView, i, z);
                            }
                        }
                    });
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(150);
                    animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                    arrayList.add(animatorSet);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(ofFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.menuAnimator = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.menuAnimator = null;
                }
            });
            this.menuAnimator.start();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Animator animator = this.attachAnimator;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.menuAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.modeAnimator;
        if (animator3 != null) {
            animator3.cancel();
        }
        setCutoutState();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f) {
        if (f != getCradleVerticalOffset()) {
            this.topEdgeTreatment.cradleVerticalOffset = f;
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public final void setCutoutState() {
        this.topEdgeTreatment.horizontalOffset = getFabTranslationX();
        FloatingActionButton findDependentFab = findDependentFab();
        MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
        materialShapeDrawable2.interpolation = (!this.fabAttached || !isVisibleFab()) ? 0.0f : 1.0f;
        materialShapeDrawable2.invalidateSelf();
        if (findDependentFab != null) {
            findDependentFab.setTranslationY(getFabTranslationY());
            findDependentFab.setTranslationX(getFabTranslationX());
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!isVisibleFab()) {
                translateActionMenuView(actionMenuView, 0, false);
            } else {
                translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
            }
        }
    }

    public void setFabAlignmentMode(int i) {
        if (this.fabAlignmentMode != i && ViewCompat.isLaidOut(this)) {
            Animator animator = this.modeAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.fabAttached) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.topEdgeTreatment.horizontalOffset, (float) getFabTranslationX(i)});
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BottomAppBar.this.topEdgeTreatment.horizontalOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        BottomAppBar.this.materialShapeDrawable.invalidateSelf();
                    }
                });
                ofFloat.setDuration(300);
                arrayList.add(ofFloat);
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{(float) getFabTranslationX(i)});
            ofFloat2.setDuration(300);
            arrayList.add(ofFloat2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.modeAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.modeAnimator = null;
                }
            });
            this.modeAnimator.start();
        }
        maybeAnimateMenuView(i, this.fabAttached);
        this.fabAlignmentMode = i;
    }

    public void setFabCradleMargin(@Dimension float f) {
        if (f != getFabCradleMargin()) {
            this.topEdgeTreatment.fabMargin = f;
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            this.topEdgeTreatment.roundedCornerRadius = f;
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabDiameter(@C0030Px int i) {
        float f = (float) i;
        BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = this.topEdgeTreatment;
        if (f != bottomAppBarTopEdgeTreatment.fabDiameter) {
            bottomAppBarTopEdgeTreatment.fabDiameter = f;
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.hideOnScroll = z;
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public final void translateActionMenuView(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                i2 = Math.max(i2, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i != 1 || !z) ? 0.0f : (float) (i2 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft())));
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect fabContentRect = new Rect();

        public Behavior() {
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            Animator animator;
            Animator animator2;
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            FloatingActionButton access$1100 = bottomAppBar.findDependentFab();
            boolean z = false;
            if (access$1100 != null) {
                ((CoordinatorLayout.LayoutParams) access$1100.getLayoutParams()).anchorGravity = 17;
                access$1100.removeOnHideAnimationListener(bottomAppBar.fabAnimationListener);
                access$1100.removeOnShowAnimationListener(bottomAppBar.fabAnimationListener);
                access$1100.addOnHideAnimationListener(bottomAppBar.fabAnimationListener);
                access$1100.addOnShowAnimationListener(bottomAppBar.fabAnimationListener);
                Rect rect = this.fabContentRect;
                rect.set(0, 0, access$1100.getMeasuredWidth(), access$1100.getMeasuredHeight());
                access$1100.offsetRectWithShadow(rect);
                bottomAppBar.setFabDiameter(this.fabContentRect.height());
            }
            Animator animator3 = bottomAppBar.attachAnimator;
            if ((animator3 != null && animator3.isRunning()) || (((animator = bottomAppBar.menuAnimator) != null && animator.isRunning()) || ((animator2 = bottomAppBar.modeAnimator) != null && animator2.isRunning()))) {
                z = true;
            }
            if (!z) {
                bottomAppBar.setCutoutState();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i);
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i, int i2) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view2, view3, i, i2);
        }

        public void slideDown(View view) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            super.slideDown(bottomAppBar);
            FloatingActionButton access$1100 = bottomAppBar.findDependentFab();
            if (access$1100 != null) {
                access$1100.getContentRect(this.fabContentRect);
                access$1100.clearAnimation();
                access$1100.animate().translationY(((float) (-access$1100.getPaddingBottom())) + ((float) (access$1100.getMeasuredHeight() - this.fabContentRect.height()))).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setDuration(175);
            }
        }

        public void slideUp(View view) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            super.slideUp(bottomAppBar);
            FloatingActionButton access$1100 = bottomAppBar.findDependentFab();
            if (access$1100 != null) {
                access$1100.clearAnimation();
                access$1100.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setDuration(225);
            }
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    private float getFabTranslationX() {
        return (float) getFabTranslationX(this.fabAlignmentMode);
    }

    /* access modifiers changed from: private */
    public float getFabTranslationY() {
        return getFabTranslationY(this.fabAttached);
    }
}
