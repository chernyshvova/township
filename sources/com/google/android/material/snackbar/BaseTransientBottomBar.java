package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int[] SNACKBAR_STYLE_ATTR = {R$attr.snackbarStyle};
    public static final boolean USE_OFFSET_API = (Build.VERSION.SDK_INT <= 19);
    public static final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                if (baseTransientBottomBar.view.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.view.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                        Behavior behavior = new Behavior();
                        BehaviorDelegate behaviorDelegate = behavior.delegate;
                        if (behaviorDelegate != null) {
                            behaviorDelegate.managerCallback = baseTransientBottomBar.managerCallback;
                            behavior.listener = new SwipeDismissBehavior.OnDismissListener() {
                            };
                            layoutParams2.setBehavior(behavior);
                            layoutParams2.insetEdge = 80;
                        } else {
                            throw null;
                        }
                    }
                    baseTransientBottomBar.targetParent.addView(baseTransientBottomBar.view);
                }
                baseTransientBottomBar.view.setOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                });
                if (!ViewCompat.isLaidOut(baseTransientBottomBar.view)) {
                    baseTransientBottomBar.view.setOnLayoutChangeListener(new OnLayoutChangeListener() {
                    });
                } else if (baseTransientBottomBar.shouldAnimate()) {
                    baseTransientBottomBar.animateViewIn();
                } else {
                    baseTransientBottomBar.onViewShown();
                }
                return true;
            } else if (i != 1) {
                return false;
            } else {
                BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
                int i2 = message.arg1;
                if (!baseTransientBottomBar2.shouldAnimate() || baseTransientBottomBar2.view.getVisibility() != 0) {
                    baseTransientBottomBar2.onViewHidden(i2);
                } else {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setIntValues(new int[]{0, baseTransientBottomBar2.getTranslationYBottom()});
                    valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                    valueAnimator.setDuration(250);
                    valueAnimator.addListener(new AnimatorListenerAdapter(i2) {
                        public final /* synthetic */ int val$event;

                        {
                            this.val$event = r2;
                        }

                        public void onAnimationEnd(Animator animator) {
                            BaseTransientBottomBar.this.onViewHidden(this.val$event);
                        }

                        public void onAnimationStart(Animator animator) {
                            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) BaseTransientBottomBar.this.contentViewCallback;
                            snackbarContentLayout.messageView.setAlpha(1.0f);
                            long j = (long) 180;
                            long j2 = (long) 0;
                            snackbarContentLayout.messageView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
                            if (snackbarContentLayout.actionView.getVisibility() == 0) {
                                snackbarContentLayout.actionView.setAlpha(1.0f);
                                snackbarContentLayout.actionView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
                            }
                        }
                    });
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public int previousAnimatedIntValue = 0;

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            if (BaseTransientBottomBar.USE_OFFSET_API) {
                                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.view, intValue - this.previousAnimatedIntValue);
                            } else {
                                BaseTransientBottomBar.this.view.setTranslationY((float) intValue);
                            }
                            this.previousAnimatedIntValue = intValue;
                        }
                    });
                    valueAnimator.start();
                }
                return true;
            }
        }
    });
    public final AccessibilityManager accessibilityManager;
    public final ContentViewCallback contentViewCallback;
    public final Context context;
    public int duration;
    public final SnackbarManager.Callback managerCallback = new SnackbarManager.Callback() {
        public void dismiss(int i) {
            Handler handler = BaseTransientBottomBar.handler;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }

        public void show() {
            Handler handler = BaseTransientBottomBar.handler;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    };
    public final ViewGroup targetParent;
    public final SnackbarBaseLayout view;

    public static class Behavior extends SwipeDismissBehavior<View> {
        public final BehaviorDelegate delegate = new BehaviorDelegate(this);

        public boolean canSwipeDismissView(View view) {
            if (this.delegate != null) {
                return view instanceof SnackbarBaseLayout;
            }
            throw null;
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            BehaviorDelegate behaviorDelegate = this.delegate;
            if (behaviorDelegate != null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        SnackbarManager.getInstance().restoreTimeoutIfPaused(behaviorDelegate.managerCallback);
                    }
                } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    SnackbarManager.getInstance().pauseTimeout(behaviorDelegate.managerCallback);
                }
                return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            }
            throw null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BehaviorDelegate {
        public SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.alphaStartSwipeDistance = SwipeDismissBehavior.clamp(0.0f, 0.1f, 1.0f);
            swipeDismissBehavior.alphaEndSwipeDistance = SwipeDismissBehavior.clamp(0.0f, 0.6f, 1.0f);
            swipeDismissBehavior.swipeDirection = 0;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnAttachStateChangeListener {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnLayoutChangeListener {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SnackbarBaseLayout extends FrameLayout {
        public final AccessibilityManager accessibilityManager;
        public OnAttachStateChangeListener onAttachStateChangeListener;
        public OnLayoutChangeListener onLayoutChangeListener;
        public final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            C21561 r3 = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() {
                public void onTouchExplorationStateChanged(boolean z) {
                    SnackbarBaseLayout.this.setClickableOrFocusableBasedOnAccessibility(z);
                }
            };
            this.touchExplorationStateChangeListener = r3;
            AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.accessibilityManager, r3);
            setClickableOrFocusableBasedOnAccessibility(this.accessibilityManager.isTouchExplorationEnabled());
        }

        /* access modifiers changed from: private */
        public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
            setClickable(!z);
            setFocusable(z);
        }

        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener onAttachStateChangeListener2 = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener2 == null || ((C21516) onAttachStateChangeListener2) != null) {
                ViewCompat.requestApplyInsets(this);
                return;
            }
            throw null;
        }

        public void onDetachedFromWindow() {
            boolean z;
            super.onDetachedFromWindow();
            OnAttachStateChangeListener onAttachStateChangeListener2 = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener2 != null) {
                C21516 r0 = (C21516) onAttachStateChangeListener2;
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                if (baseTransientBottomBar != null) {
                    SnackbarManager instance = SnackbarManager.getInstance();
                    SnackbarManager.Callback callback = baseTransientBottomBar.managerCallback;
                    synchronized (instance.lock) {
                        if (!instance.isCurrentSnackbarLocked(callback)) {
                            if (!instance.isNextSnackbarLocked(callback)) {
                                z = false;
                            }
                        }
                        z = true;
                    }
                    if (z) {
                        BaseTransientBottomBar.handler.post(new Runnable() {
                            public void run() {
                                BaseTransientBottomBar.this.onViewHidden(3);
                            }
                        });
                    }
                } else {
                    throw null;
                }
            }
            AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(this.accessibilityManager, this.touchExplorationStateChangeListener);
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            OnLayoutChangeListener onLayoutChangeListener2 = this.onLayoutChangeListener;
            if (onLayoutChangeListener2 != null) {
                C21537 r1 = (C21537) onLayoutChangeListener2;
                BaseTransientBottomBar.this.view.setOnLayoutChangeListener((OnLayoutChangeListener) null);
                if (BaseTransientBottomBar.this.shouldAnimate()) {
                    BaseTransientBottomBar.this.animateViewIn();
                } else {
                    BaseTransientBottomBar.this.onViewShown();
                }
            }
        }

        public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener2) {
            this.onAttachStateChangeListener = onAttachStateChangeListener2;
        }

        public void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener2) {
            this.onLayoutChangeListener = onLayoutChangeListener2;
        }
    }

    public BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view2, @NonNull ContentViewCallback contentViewCallback2) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view2 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback2 != null) {
            this.targetParent = viewGroup;
            this.contentViewCallback = contentViewCallback2;
            Context context2 = viewGroup.getContext();
            this.context = context2;
            ThemeEnforcement.checkTheme(context2, ThemeEnforcement.APPCOMPAT_CHECK_ATTRS, "Theme.AppCompat");
            LayoutInflater from = LayoutInflater.from(this.context);
            TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) from.inflate(resourceId != -1 ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar, this.targetParent, false);
            this.view = snackbarBaseLayout;
            snackbarBaseLayout.addView(view2);
            ViewCompat.setAccessibilityLiveRegion(this.view, 1);
            ViewCompat.setImportantForAccessibility(this.view, 1);
            ViewCompat.setFitsSystemWindows(this.view, true);
            ViewCompat.setOnApplyWindowInsetsListener(this.view, new OnApplyWindowInsetsListener(this) {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    return windowInsetsCompat;
                }
            });
            ViewCompat.setAccessibilityDelegate(this.view, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    if (i != 1048576) {
                        return super.performAccessibilityAction(view, i, bundle);
                    }
                    ((Snackbar) BaseTransientBottomBar.this).dispatchDismiss(3);
                    return true;
                }
            });
            this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    public void animateViewIn() {
        final int translationYBottom = getTranslationYBottom();
        if (USE_OFFSET_API) {
            ViewCompat.offsetTopAndBottom(this.view, translationYBottom);
        } else {
            this.view.setTranslationY((float) translationYBottom);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{translationYBottom, 0});
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.onViewShown();
            }

            public void onAnimationStart(Animator animator) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) BaseTransientBottomBar.this.contentViewCallback;
                snackbarContentLayout.messageView.setAlpha(0.0f);
                long j = (long) 180;
                long j2 = (long) 70;
                snackbarContentLayout.messageView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
                if (snackbarContentLayout.actionView.getVisibility() == 0) {
                    snackbarContentLayout.actionView.setAlpha(0.0f);
                    snackbarContentLayout.actionView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
                }
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public int previousAnimatedIntValue = translationYBottom;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.USE_OFFSET_API) {
                    ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.view, intValue - this.previousAnimatedIntValue);
                } else {
                    BaseTransientBottomBar.this.view.setTranslationY((float) intValue);
                }
                this.previousAnimatedIntValue = intValue;
            }
        });
        valueAnimator.start();
    }

    public void dispatchDismiss(int i) {
        SnackbarManager instance = SnackbarManager.getInstance();
        SnackbarManager.Callback callback = this.managerCallback;
        synchronized (instance.lock) {
            if (instance.isCurrentSnackbarLocked(callback)) {
                instance.cancelSnackbarLocked(instance.currentSnackbar, i);
            } else if (instance.isNextSnackbarLocked(callback)) {
                instance.cancelSnackbarLocked(instance.nextSnackbar, i);
            }
        }
    }

    public final int getTranslationYBottom() {
        int height = this.view.getHeight();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public void onViewHidden(int i) {
        SnackbarManager instance = SnackbarManager.getInstance();
        SnackbarManager.Callback callback = this.managerCallback;
        synchronized (instance.lock) {
            if (instance.isCurrentSnackbarLocked(callback)) {
                instance.currentSnackbar = null;
                if (instance.nextSnackbar != null) {
                    instance.showNextSnackbarLocked();
                }
            }
        }
        ViewParent parent = this.view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.view);
        }
    }

    public void onViewShown() {
        SnackbarManager instance = SnackbarManager.getInstance();
        SnackbarManager.Callback callback = this.managerCallback;
        synchronized (instance.lock) {
            if (instance.isCurrentSnackbarLocked(callback)) {
                instance.scheduleTimeoutLocked(instance.currentSnackbar);
            }
        }
    }

    public boolean shouldAnimate() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }
}
