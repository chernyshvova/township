package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.C0030Px;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.android.billingclient.api.zzam;
import com.google.android.material.R$animator;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableWidget {
    public ColorStateList backgroundTint;
    public PorterDuff.Mode backgroundTintMode;
    public int borderWidth;
    public boolean compatPadding;
    public int customSize;
    public final ExpandableWidgetHelper expandableWidgetHelper;
    public final AppCompatImageHelper imageHelper;
    @Nullable
    public PorterDuff.Mode imageMode;
    public int imagePadding;
    @Nullable
    public ColorStateList imageTint;
    public FloatingActionButtonImpl impl;
    public int maxImageSize;
    public ColorStateList rippleColor;
    public final Rect shadowPadding = new Rect();
    public int size;
    public final Rect touchArea = new Rect();

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$1 */
    public class C21291 implements FloatingActionButtonImpl.InternalVisibilityChangedListener {
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public boolean autoHideEnabled;
        public Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        public static boolean isBottomSheet(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect) {
            return getInsetDodgeRect((FloatingActionButton) view, rect);
        }

        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
                return false;
            } else if (!isBottomSheet(view2)) {
                return false;
            } else {
                updateFabVisibilityForBottomSheet(view2, floatingActionButton);
                return false;
            }
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            int i2;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = dependencies.get(i4);
                if (!(view2 instanceof AppBarLayout)) {
                    if (isBottomSheet(view2) && updateFabVisibilityForBottomSheet(view2, floatingActionButton)) {
                        break;
                    }
                } else if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            Rect rect = floatingActionButton.shadowPadding;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return true;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin) {
                i2 = rect.right;
            } else {
                i2 = floatingActionButton.getLeft() <= layoutParams.leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams.bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= layoutParams.topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i3);
            }
            if (i2 == 0) {
                return true;
            }
            ViewCompat.offsetLeftAndRight(floatingActionButton, i2);
            return true;
        }

        public final boolean shouldUpdateVisibility(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (this.autoHideEnabled && layoutParams.getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        public final boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide((OnVisibilityChangedListener) null, false);
                return true;
            }
            floatingActionButton.show((OnVisibilityChangedListener) null, false);
            return true;
        }

        public final boolean updateFabVisibilityForBottomSheet(View view, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.hide((OnVisibilityChangedListener) null, false);
                return true;
            }
            floatingActionButton.show((OnVisibilityChangedListener) null, false);
            return true;
        }

        public boolean getInsetDodgeRect(@NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class OnVisibilityChangedListener {
    }

    public class ShadowDelegateImpl implements ShadowViewDelegate {
        public ShadowDelegateImpl() {
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.FloatingActionButton, i, R$style.Widget_Design_FloatingActionButton, new int[0]);
        this.backgroundTint = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = zzam.parseTintMode(obtainStyledAttributes.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.rippleColor = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.FloatingActionButton_rippleColor);
        this.size = obtainStyledAttributes.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.customSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.compatPadding = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        this.maxImageSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0);
        MotionSpec createFromAttribute = MotionSpec.createFromAttribute(context, obtainStyledAttributes, R$styleable.FloatingActionButton_showMotionSpec);
        MotionSpec createFromAttribute2 = MotionSpec.createFromAttribute(context, obtainStyledAttributes, R$styleable.FloatingActionButton_hideMotionSpec);
        obtainStyledAttributes.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.imageHelper = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
        getImpl().setBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.elevation != dimension) {
            impl2.elevation = dimension;
            impl2.onElevationsChanged(dimension, impl2.hoveredFocusedTranslationZ, impl2.pressedTranslationZ);
        }
        FloatingActionButtonImpl impl3 = getImpl();
        if (impl3.hoveredFocusedTranslationZ != dimension2) {
            impl3.hoveredFocusedTranslationZ = dimension2;
            impl3.onElevationsChanged(impl3.elevation, dimension2, impl3.pressedTranslationZ);
        }
        FloatingActionButtonImpl impl4 = getImpl();
        if (impl4.pressedTranslationZ != dimension3) {
            impl4.pressedTranslationZ = dimension3;
            impl4.onElevationsChanged(impl4.elevation, impl4.hoveredFocusedTranslationZ, dimension3);
        }
        FloatingActionButtonImpl impl5 = getImpl();
        int i2 = this.maxImageSize;
        if (impl5.maxImageSize != i2) {
            impl5.maxImageSize = i2;
            impl5.setImageMatrixScale(impl5.imageMatrixScale);
        }
        getImpl().showMotionSpec = createFromAttribute;
        getImpl().hideMotionSpec = createFromAttribute2;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private FloatingActionButtonImpl getImpl() {
        FloatingActionButtonImpl floatingActionButtonImpl;
        if (this.impl == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                floatingActionButtonImpl = new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
            } else {
                floatingActionButtonImpl = new FloatingActionButtonImpl(this, new ShadowDelegateImpl());
            }
            this.impl = floatingActionButtonImpl;
        }
        return this.impl;
    }

    public static int resolveAdjustedSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size2);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size2;
        }
        throw new IllegalArgumentException();
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.hideListeners == null) {
            impl2.hideListeners = new ArrayList<>();
        }
        impl2.hideListeners.add(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.showListeners == null) {
            impl2.showListeners = new ArrayList<>();
        }
        impl2.showListeners.add(animatorListener);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().hoveredFocusedTranslationZ;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().pressedTranslationZ;
    }

    @NonNull
    public Drawable getContentBackground() {
        return getImpl().contentBackground;
    }

    @Deprecated
    public boolean getContentRect(@NonNull Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(rect);
        return true;
    }

    @C0030Px
    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.expandedComponentIdHint;
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().hideMotionSpec;
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().showMotionSpec;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide(@Nullable OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        FloatingActionButtonImpl impl2 = getImpl();
        boolean z2 = false;
        if (impl2.view.getVisibility() != 0 ? impl2.animState != 2 : impl2.animState == 1) {
            z2 = true;
        }
        if (!z2) {
            Animator animator = impl2.currentAnimator;
            if (animator != null) {
                animator.cancel();
            }
            if (impl2.shouldAnimateVisibilityChange()) {
                MotionSpec motionSpec = impl2.hideMotionSpec;
                if (motionSpec == null) {
                    if (impl2.defaultHideMotionSpec == null) {
                        impl2.defaultHideMotionSpec = MotionSpec.createFromResource(impl2.view.getContext(), R$animator.design_fab_hide_motion_spec);
                    }
                    motionSpec = impl2.defaultHideMotionSpec;
                }
                AnimatorSet createAnimator = impl2.createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
                createAnimator.addListener(new AnimatorListenerAdapter(z, (FloatingActionButtonImpl.InternalVisibilityChangedListener) null) {
                    public boolean cancelled;
                    public final /* synthetic */ boolean val$fromUser;
                    public final /* synthetic */ InternalVisibilityChangedListener val$listener;

                    {
                        this.val$fromUser = r2;
                        this.val$listener = r3;
                    }

                    public void onAnimationCancel(Animator animator) {
                        this.cancelled = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 0;
                        floatingActionButtonImpl.currentAnimator = null;
                        if (!this.cancelled) {
                            floatingActionButtonImpl.view.internalSetVisibility(this.val$fromUser ? 8 : 4, this.val$fromUser);
                            InternalVisibilityChangedListener internalVisibilityChangedListener = this.val$listener;
                            if (internalVisibilityChangedListener != null) {
                                FloatingActionButton.C21291 r4 = (FloatingActionButton.C21291) internalVisibilityChangedListener;
                                throw null;
                            }
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 1;
                        floatingActionButtonImpl.currentAnimator = animator;
                        this.cancelled = false;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = impl2.hideListeners;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        createAnimator.addListener(it.next());
                    }
                }
                createAnimator.start();
                return;
            }
            impl2.view.internalSetVisibility(z ? 8 : 4, z);
        }
    }

    public boolean isExpanded() {
        return this.expandableWidgetHelper.expanded;
    }

    public boolean isOrWillBeShown() {
        return getImpl().isOrWillBeShown();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().jumpDrawableToCurrentState();
    }

    public final void offsetRectWithShadow(@NonNull Rect rect) {
        int i = rect.left;
        Rect rect2 = this.shadowPadding;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public final void onApplySupportImageTint() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.imageTint;
            if (colorStateList == null) {
                DrawableCompat.clearColorFilter(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.imageMode;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.requirePreDrawListener()) {
            if (impl2.preDrawListener == null) {
                impl2.preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        float rotation = floatingActionButtonImpl.view.getRotation();
                        if (floatingActionButtonImpl.rotation != rotation) {
                            floatingActionButtonImpl.rotation = rotation;
                            if (Build.VERSION.SDK_INT == 19) {
                                if (rotation % 90.0f != 0.0f) {
                                    if (floatingActionButtonImpl.view.getLayerType() != 1) {
                                        floatingActionButtonImpl.view.setLayerType(1, (Paint) null);
                                    }
                                } else if (floatingActionButtonImpl.view.getLayerType() != 0) {
                                    floatingActionButtonImpl.view.setLayerType(0, (Paint) null);
                                }
                            }
                            ShadowDrawableWrapper shadowDrawableWrapper = floatingActionButtonImpl.shadowDrawable;
                            if (shadowDrawableWrapper != null) {
                                float f = -floatingActionButtonImpl.rotation;
                                if (shadowDrawableWrapper.rotation != f) {
                                    shadowDrawableWrapper.rotation = f;
                                    shadowDrawableWrapper.invalidateSelf();
                                }
                            }
                            CircularBorderDrawable circularBorderDrawable = floatingActionButtonImpl.borderDrawable;
                            if (circularBorderDrawable != null) {
                                float f2 = -floatingActionButtonImpl.rotation;
                                if (f2 != circularBorderDrawable.rotation) {
                                    circularBorderDrawable.rotation = f2;
                                    circularBorderDrawable.invalidateSelf();
                                }
                            }
                        }
                        return true;
                    }
                };
            }
            impl2.view.getViewTreeObserver().addOnPreDrawListener(impl2.preDrawListener);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.preDrawListener != null) {
            impl2.view.getViewTreeObserver().removeOnPreDrawListener(impl2.preDrawListener);
            impl2.preDrawListener = null;
        }
    }

    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().updatePadding();
        int min = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        Rect rect = this.shadowPadding;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        ExpandableWidgetHelper expandableWidgetHelper2 = this.expandableWidgetHelper;
        Bundle bundle = extendableSavedState.extendableStates.get("expandableWidgetHelper");
        if (expandableWidgetHelper2 != null) {
            expandableWidgetHelper2.expanded = bundle.getBoolean("expanded", false);
            expandableWidgetHelper2.expandedComponentIdHint = bundle.getInt("expandedComponentIdHint", 0);
            if (expandableWidgetHelper2.expanded) {
                ViewParent parent = expandableWidgetHelper2.widget.getParent();
                if (parent instanceof CoordinatorLayout) {
                    ((CoordinatorLayout) parent).dispatchDependentViewsChanged(expandableWidgetHelper2.widget);
                    return;
                }
                return;
            }
            return;
        }
        throw null;
    }

    public Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        SimpleArrayMap<String, Bundle> simpleArrayMap = extendableSavedState.extendableStates;
        ExpandableWidgetHelper expandableWidgetHelper2 = this.expandableWidgetHelper;
        if (expandableWidgetHelper2 != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("expanded", expandableWidgetHelper2.expanded);
            bundle.putInt("expandedComponentIdHint", expandableWidgetHelper2.expandedComponentIdHint);
            simpleArrayMap.put("expandableWidgetHelper", bundle);
            return extendableSavedState;
        }
        throw null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !getContentRect(this.touchArea) || this.touchArea.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = getImpl().hideListeners;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = getImpl().showListeners;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            FloatingActionButtonImpl impl2 = getImpl();
            Drawable drawable = impl2.shapeDrawable;
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            CircularBorderDrawable circularBorderDrawable = impl2.borderDrawable;
            if (circularBorderDrawable != null) {
                circularBorderDrawable.setBorderTint(colorStateList);
            }
        }
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            Drawable drawable = getImpl().shapeDrawable;
            if (drawable != null) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
    }

    public void setCompatElevation(float f) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.elevation != f) {
            impl2.elevation = f;
            impl2.onElevationsChanged(f, impl2.hoveredFocusedTranslationZ, impl2.pressedTranslationZ);
        }
    }

    public void setCompatElevationResource(@DimenRes int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.hoveredFocusedTranslationZ != f) {
            impl2.hoveredFocusedTranslationZ = f;
            impl2.onElevationsChanged(impl2.elevation, f, impl2.pressedTranslationZ);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.pressedTranslationZ != f) {
            impl2.pressedTranslationZ = f;
            impl2.onElevationsChanged(impl2.elevation, impl2.hoveredFocusedTranslationZ, f);
        }
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(@C0030Px int i) {
        if (i >= 0) {
            this.customSize = i;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setExpandedComponentIdHint(@IdRes int i) {
        this.expandableWidgetHelper.expandedComponentIdHint = i;
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        getImpl().hideMotionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        FloatingActionButtonImpl impl2 = getImpl();
        impl2.setImageMatrixScale(impl2.imageMatrixScale);
    }

    public void setImageResource(@DrawableRes int i) {
        this.imageHelper.setImageResource(i);
    }

    public void setRippleColor(@ColorInt int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        getImpl().showMotionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setSize(int i) {
        this.customSize = 0;
        if (i != this.size) {
            this.size = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.imageMode != mode) {
            this.imageMode = mode;
            onApplySupportImageTint();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.compatPadding != z) {
            this.compatPadding = z;
            getImpl().onCompatShadowChanged();
        }
    }

    public void show(OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (!impl2.isOrWillBeShown()) {
            Animator animator = impl2.currentAnimator;
            if (animator != null) {
                animator.cancel();
            }
            if (impl2.shouldAnimateVisibilityChange()) {
                if (impl2.view.getVisibility() != 0) {
                    impl2.view.setAlpha(0.0f);
                    impl2.view.setScaleY(0.0f);
                    impl2.view.setScaleX(0.0f);
                    impl2.setImageMatrixScale(0.0f);
                }
                MotionSpec motionSpec = impl2.showMotionSpec;
                if (motionSpec == null) {
                    if (impl2.defaultShowMotionSpec == null) {
                        impl2.defaultShowMotionSpec = MotionSpec.createFromResource(impl2.view.getContext(), R$animator.design_fab_show_motion_spec);
                    }
                    motionSpec = impl2.defaultShowMotionSpec;
                }
                AnimatorSet createAnimator = impl2.createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
                createAnimator.addListener(new AnimatorListenerAdapter(z, (FloatingActionButtonImpl.InternalVisibilityChangedListener) null) {
                    public final /* synthetic */ boolean val$fromUser;
                    public final /* synthetic */ InternalVisibilityChangedListener val$listener;

                    {
                        this.val$fromUser = r2;
                        this.val$listener = r3;
                    }

                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 0;
                        floatingActionButtonImpl.currentAnimator = null;
                        InternalVisibilityChangedListener internalVisibilityChangedListener = this.val$listener;
                        if (internalVisibilityChangedListener != null) {
                            FloatingActionButton.C21291 r2 = (FloatingActionButton.C21291) internalVisibilityChangedListener;
                            throw null;
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 2;
                        floatingActionButtonImpl.currentAnimator = animator;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = impl2.showListeners;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        createAnimator.addListener(it.next());
                    }
                }
                createAnimator.start();
                return;
            }
            impl2.view.internalSetVisibility(0, z);
            impl2.view.setAlpha(1.0f);
            impl2.view.setScaleY(1.0f);
            impl2.view.setScaleX(1.0f);
            impl2.setImageMatrixScale(1.0f);
        }
    }

    public final int getSizeDimension(int i) {
        int i2 = this.customSize;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            if (i != 1) {
                return resources.getDimensionPixelSize(R$dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return getSizeDimension(1);
        } else {
            return getSizeDimension(0);
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            getImpl().setRippleColor(this.rippleColor);
        }
    }
}
