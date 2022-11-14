package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class AppBarLayout extends LinearLayout {
    public int downPreScrollRange;
    public int downScrollRange;
    public boolean haveChildWithInterpolator;
    public boolean liftOnScroll;
    public boolean liftable;
    public boolean lifted;
    public List<BaseOnOffsetChangedListener> listeners;
    public int pendingAction;
    public int[] tmpStatesArray;
    public int totalScrollRange;

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        public WeakReference<View> lastNestedScrollingChildRef;
        public int lastStartedType;
        public ValueAnimator offsetAnimator;
        public int offsetDelta;
        public int offsetToChildIndexOnLayout = -1;
        public boolean offsetToChildIndexOnLayoutIsMinHeight;
        public float offsetToChildIndexOnLayoutPerc;

        public BaseBehavior() {
        }

        public static boolean checkFlag(int i, int i2) {
            return (i & i2) == i2;
        }

        public final void animateOffsetTo(final CoordinatorLayout coordinatorLayout, final T t, int i, float f) {
            int i2;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                i2 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i2 = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.offsetAnimator.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.offsetAnimator = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration((long) Math.min(i2, 600));
            this.offsetAnimator.setIntValues(new int[]{topBottomOffsetForScrollingSibling, i});
            this.offsetAnimator.start();
        }

        public boolean canDragView(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view2 = (View) weakReference.get();
            if (view2 == null || !view2.isShown() || view2.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            int i2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.onLayoutChild(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            int i3 = this.offsetToChildIndexOnLayout;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.offsetToChildIndexOnLayoutIsMinHeight) {
                    i2 = appBarLayout.getTopInset() + ViewCompat.getMinimumHeight(childAt) + i4;
                } else {
                    i2 = Math.round(((float) childAt.getHeight()) * this.offsetToChildIndexOnLayoutPerc) + i4;
                }
                setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, i2);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, i5, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.pendingAction = 0;
            this.offsetToChildIndexOnLayout = -1;
            int clamp = MathUtils.clamp(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0);
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            if (viewOffsetHelper != null) {
                viewOffsetHelper.setTopAndBottomOffset(clamp);
            } else {
                this.tempTopBottomOffset = clamp;
            }
            updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, getTopAndBottomOffset(), 0, true);
            appBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
            return true;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).height != -2) {
                return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.onMeasureChild(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            onNestedPreScroll(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr, i3);
        }

        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5) {
            onNestedScroll(coordinatorLayout, (AppBarLayout) view, view2, i4, i5);
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, savedState.getSuperState());
                this.offsetToChildIndexOnLayout = savedState.firstVisibleChildIndex;
                this.offsetToChildIndexOnLayoutPerc = savedState.firstVisibleChildPercentageShown;
                this.offsetToChildIndexOnLayoutIsMinHeight = savedState.firstVisibleChildAtMinimumHeight;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
            this.offsetToChildIndexOnLayout = -1;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.firstVisibleChildIndex = i;
                    if (bottom == appBarLayout.getTopInset() + ViewCompat.getMinimumHeight(childAt)) {
                        z = true;
                    }
                    savedState.firstVisibleChildAtMinimumHeight = z;
                    savedState.firstVisibleChildPercentageShown = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (((r4.getTotalScrollRange() != 0) && r3.getHeight() - r5.getHeight() <= r4.getHeight()) != false) goto L_0x002b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, com.google.android.material.appbar.AppBarLayout r4, android.view.View r5, int r6, int r7) {
            /*
                r2 = this;
                r6 = r6 & 2
                r0 = 1
                r1 = 0
                if (r6 == 0) goto L_0x002a
                boolean r6 = r4.liftOnScroll
                if (r6 != 0) goto L_0x002b
                int r6 = r4.getTotalScrollRange()
                if (r6 == 0) goto L_0x0012
                r6 = 1
                goto L_0x0013
            L_0x0012:
                r6 = 0
            L_0x0013:
                if (r6 == 0) goto L_0x0026
                int r3 = r3.getHeight()
                int r5 = r5.getHeight()
                int r3 = r3 - r5
                int r4 = r4.getHeight()
                if (r3 > r4) goto L_0x0026
                r3 = 1
                goto L_0x0027
            L_0x0026:
                r3 = 0
            L_0x0027:
                if (r3 == 0) goto L_0x002a
                goto L_0x002b
            L_0x002a:
                r0 = 0
            L_0x002b:
                if (r0 == 0) goto L_0x0034
                android.animation.ValueAnimator r3 = r2.offsetAnimator
                if (r3 == 0) goto L_0x0034
                r3.cancel()
            L_0x0034:
                r3 = 0
                r2.lastNestedScrollingChildRef = r3
                r2.lastStartedType = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int):boolean");
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.lastStartedType == 0 || i == 1) {
                snapToChildIfNeeded(coordinatorLayout, appBarLayout);
            }
            this.lastNestedScrollingChildRef = new WeakReference<>(view2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int setHeaderTopBottomOffset(androidx.coordinatorlayout.widget.CoordinatorLayout r8, android.view.View r9, int r10, int r11, int r12) {
            /*
                r7 = this;
                r2 = r9
                com.google.android.material.appbar.AppBarLayout r2 = (com.google.android.material.appbar.AppBarLayout) r2
                int r9 = r7.getTopBottomOffsetForScrollingSibling()
                r0 = 0
                if (r11 == 0) goto L_0x00b8
                if (r9 < r11) goto L_0x00b8
                if (r9 > r12) goto L_0x00b8
                int r3 = androidx.core.math.MathUtils.clamp((int) r10, (int) r11, (int) r12)
                if (r9 == r3) goto L_0x00ba
                boolean r10 = r2.haveChildWithInterpolator
                if (r10 == 0) goto L_0x0087
                int r10 = java.lang.Math.abs(r3)
                int r11 = r2.getChildCount()
                r12 = 0
            L_0x0021:
                if (r12 >= r11) goto L_0x0087
                android.view.View r1 = r2.getChildAt(r12)
                android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r4 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r4
                android.view.animation.Interpolator r5 = r4.scrollInterpolator
                int r6 = r1.getTop()
                if (r10 < r6) goto L_0x0084
                int r6 = r1.getBottom()
                if (r10 > r6) goto L_0x0084
                if (r5 == 0) goto L_0x0087
                int r11 = r4.scrollFlags
                r12 = r11 & 1
                if (r12 == 0) goto L_0x0058
                int r12 = r1.getHeight()
                int r6 = r4.topMargin
                int r12 = r12 + r6
                int r4 = r4.bottomMargin
                int r12 = r12 + r4
                int r12 = r12 + r0
                r11 = r11 & 2
                if (r11 == 0) goto L_0x0059
                int r11 = androidx.core.view.ViewCompat.getMinimumHeight(r1)
                int r12 = r12 - r11
                goto L_0x0059
            L_0x0058:
                r12 = 0
            L_0x0059:
                boolean r11 = androidx.core.view.ViewCompat.getFitsSystemWindows(r1)
                if (r11 == 0) goto L_0x0064
                int r11 = r2.getTopInset()
                int r12 = r12 - r11
            L_0x0064:
                if (r12 <= 0) goto L_0x0087
                int r11 = r1.getTop()
                int r10 = r10 - r11
                float r11 = (float) r12
                float r10 = (float) r10
                float r10 = r10 / r11
                float r10 = r5.getInterpolation(r10)
                float r10 = r10 * r11
                int r10 = java.lang.Math.round(r10)
                int r11 = java.lang.Integer.signum(r3)
                int r12 = r1.getTop()
                int r12 = r12 + r10
                int r12 = r12 * r11
                goto L_0x0088
            L_0x0084:
                int r12 = r12 + 1
                goto L_0x0021
            L_0x0087:
                r12 = r3
            L_0x0088:
                com.google.android.material.appbar.ViewOffsetHelper r10 = r7.viewOffsetHelper
                if (r10 == 0) goto L_0x0091
                boolean r0 = r10.setTopAndBottomOffset(r12)
                goto L_0x0093
            L_0x0091:
                r7.tempTopBottomOffset = r12
            L_0x0093:
                int r10 = r9 - r3
                int r11 = r3 - r12
                r7.offsetDelta = r11
                if (r0 != 0) goto L_0x00a2
                boolean r11 = r2.haveChildWithInterpolator
                if (r11 == 0) goto L_0x00a2
                r8.dispatchDependentViewsChanged(r2)
            L_0x00a2:
                int r11 = r7.getTopAndBottomOffset()
                r2.dispatchOffsetUpdates(r11)
                if (r3 >= r9) goto L_0x00ae
                r9 = -1
                r4 = -1
                goto L_0x00b0
            L_0x00ae:
                r9 = 1
                r4 = 1
            L_0x00b0:
                r5 = 0
                r0 = r7
                r1 = r8
                r0.updateAppBarLayoutDrawableState(r1, r2, r3, r4, r5)
                r0 = r10
                goto L_0x00ba
            L_0x00b8:
                r7.offsetDelta = r0
            L_0x00ba:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.setHeaderTopBottomOffset(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, T t) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childCount = t.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = t.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.scrollFlags, 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i2 = -topBottomOffsetForScrollingSibling;
                if (top <= i2 && bottom >= i2) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                View childAt2 = t.getChildAt(i);
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                int i3 = layoutParams2.scrollFlags;
                if ((i3 & 17) == 17) {
                    int i4 = -childAt2.getTop();
                    int i5 = -childAt2.getBottom();
                    if (i == t.getChildCount() - 1) {
                        i5 += t.getTopInset();
                    }
                    if (checkFlag(i3, 2)) {
                        i5 += ViewCompat.getMinimumHeight(childAt2);
                    } else if (checkFlag(i3, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt2) + i5;
                        if (topBottomOffsetForScrollingSibling < minimumHeight) {
                            i4 = minimumHeight;
                        } else {
                            i5 = minimumHeight;
                        }
                    }
                    if (checkFlag(i3, 32)) {
                        i4 += layoutParams2.topMargin;
                        i5 -= layoutParams2.bottomMargin;
                    }
                    if (topBottomOffsetForScrollingSibling < (i5 + i4) / 2) {
                        i4 = i5;
                    }
                    animateOffsetTo(coordinatorLayout, t, MathUtils.clamp(i4, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void stopNestedScrollIfNeeded(int i, T t, View view, int i2) {
            if (i2 == 1) {
                int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
                if ((i < 0 && topBottomOffsetForScrollingSibling == 0) || (i > 0 && topBottomOffsetForScrollingSibling == (-t.getDownNestedScrollRange()))) {
                    ViewCompat.stopNestedScroll(view, 1);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0086  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void updateAppBarLayoutDrawableState(androidx.coordinatorlayout.widget.CoordinatorLayout r8, T r9, int r10, int r11, boolean r12) {
            /*
                r7 = this;
                int r0 = java.lang.Math.abs(r10)
                int r1 = r9.getChildCount()
                r2 = 0
                r3 = 0
            L_0x000a:
                r4 = 0
                if (r3 >= r1) goto L_0x0021
                android.view.View r5 = r9.getChildAt(r3)
                int r6 = r5.getTop()
                if (r0 < r6) goto L_0x001e
                int r6 = r5.getBottom()
                if (r0 > r6) goto L_0x001e
                goto L_0x0022
            L_0x001e:
                int r3 = r3 + 1
                goto L_0x000a
            L_0x0021:
                r5 = r4
            L_0x0022:
                if (r5 == 0) goto L_0x00b7
                android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r0 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r0
                int r0 = r0.scrollFlags
                r1 = r0 & 1
                r3 = 1
                if (r1 == 0) goto L_0x005c
                int r1 = androidx.core.view.ViewCompat.getMinimumHeight(r5)
                if (r11 <= 0) goto L_0x0049
                r11 = r0 & 12
                if (r11 == 0) goto L_0x0049
                int r10 = -r10
                int r11 = r5.getBottom()
                int r11 = r11 - r1
                int r0 = r9.getTopInset()
                int r11 = r11 - r0
                if (r10 < r11) goto L_0x005c
                goto L_0x005a
            L_0x0049:
                r11 = r0 & 2
                if (r11 == 0) goto L_0x005c
                int r10 = -r10
                int r11 = r5.getBottom()
                int r11 = r11 - r1
                int r0 = r9.getTopInset()
                int r11 = r11 - r0
                if (r10 < r11) goto L_0x005c
            L_0x005a:
                r10 = 1
                goto L_0x005d
            L_0x005c:
                r10 = 0
            L_0x005d:
                boolean r11 = r9.liftOnScroll
                if (r11 == 0) goto L_0x0080
                int r11 = r8.getChildCount()
                r0 = 0
            L_0x0066:
                if (r0 >= r11) goto L_0x0075
                android.view.View r1 = r8.getChildAt(r0)
                boolean r5 = r1 instanceof androidx.core.view.NestedScrollingChild
                if (r5 == 0) goto L_0x0072
                r4 = r1
                goto L_0x0075
            L_0x0072:
                int r0 = r0 + 1
                goto L_0x0066
            L_0x0075:
                if (r4 == 0) goto L_0x0080
                int r10 = r4.getScrollY()
                if (r10 <= 0) goto L_0x007f
                r10 = 1
                goto L_0x0080
            L_0x007f:
                r10 = 0
            L_0x0080:
                boolean r10 = r9.setLiftedState(r10)
                if (r12 != 0) goto L_0x00b4
                if (r10 == 0) goto L_0x00b7
                java.util.List r8 = r8.getDependents(r9)
                int r10 = r8.size()
                r11 = 0
            L_0x0091:
                if (r11 >= r10) goto L_0x00b2
                java.lang.Object r12 = r8.get(r11)
                android.view.View r12 = (android.view.View) r12
                android.view.ViewGroup$LayoutParams r12 = r12.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r12 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r12
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r12 = r12.getBehavior()
                boolean r0 = r12 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r0 == 0) goto L_0x00af
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r12 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r12
                int r8 = r12.overlayTop
                if (r8 == 0) goto L_0x00b2
                r2 = 1
                goto L_0x00b2
            L_0x00af:
                int r11 = r11 + 1
                goto L_0x0091
            L_0x00b2:
                if (r2 == 0) goto L_0x00b7
            L_0x00b4:
                r9.jumpDrawablesToCurrentState()
            L_0x00b7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.updateAppBarLayoutDrawableState(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int[] iArr, int i2) {
            int i3;
            int i4;
            if (i != 0) {
                if (i < 0) {
                    int i5 = -appBarLayout.getTotalScrollRange();
                    i4 = i5;
                    i3 = appBarLayout.getDownNestedPreScrollRange() + i5;
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    i3 = 0;
                }
                if (i4 != i3) {
                    iArr[1] = scroll(coordinatorLayout, appBarLayout, i, i4, i3);
                    stopNestedScrollIfNeeded(i, appBarLayout, view, i2);
                }
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2) {
            if (i < 0) {
                scroll(coordinatorLayout, appBarLayout, i, -appBarLayout.getDownNestedScrollRange(), 0);
                stopNestedScrollIfNeeded(i, appBarLayout, view, i2);
            }
            if (appBarLayout.liftOnScroll) {
                appBarLayout.setLiftedState(view.getScrollY() > 0);
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

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
            public boolean firstVisibleChildAtMinimumHeight;
            public int firstVisibleChildIndex;
            public float firstVisibleChildPercentageShown;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return onStartNestedScroll(coordinatorLayout, (AppBarLayout) view, view2, i, i2);
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t, int i);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public AppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).offsetDelta) + this.verticalLayoutGap) - getOverlapPixelsForOffset(view2));
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.liftOnScroll) {
                    appBarLayout.setLiftedState(view.getScrollY() > 0);
                }
            }
            return false;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.tempRect1;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    findFirstDependency.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            this.overlayTop = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchOffsetUpdates(int i) {
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners.get(i2);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(this, i);
                }
            }
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public int getDownNestedPreScrollRange() {
        int i;
        int i2 = this.downPreScrollRange;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.scrollFlags;
            if ((i4 & 5) == 5) {
                int i5 = layoutParams.topMargin + layoutParams.bottomMargin + i3;
                if ((i4 & 8) != 0) {
                    i3 = ViewCompat.getMinimumHeight(childAt) + i5;
                } else {
                    if ((i4 & 2) != 0) {
                        i = ViewCompat.getMinimumHeight(childAt);
                    } else {
                        i = getTopInset();
                    }
                    i3 = (measuredHeight - i) + i5;
                }
            } else if (i3 > 0) {
                break;
            }
        }
        int max = Math.max(0, i3);
        this.downPreScrollRange = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.downScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = layoutParams.topMargin + layoutParams.bottomMargin + childAt.getMeasuredHeight();
            int i4 = layoutParams.scrollFlags;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= getTopInset() + ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.downScrollRange = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.pendingAction;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.totalScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.scrollFlags;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3 - getTopInset());
        this.totalScrollRange = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public int[] onCreateDrawableState(int i) {
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.liftable ? R$attr.state_liftable : -R$attr.state_liftable;
        iArr[1] = (!this.liftable || !this.lifted) ? -R$attr.state_lifted : R$attr.state_lifted;
        iArr[2] = this.liftable ? R$attr.state_collapsible : -R$attr.state_collapsible;
        iArr[3] = (!this.liftable || !this.lifted) ? -R$attr.state_collapsed : R$attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r3 != false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        /*
            r1 = this;
            super.onLayout(r2, r3, r4, r5, r6)
            r2 = -1
            r1.totalScrollRange = r2
            r1.downPreScrollRange = r2
            r1.downScrollRange = r2
            r2 = 0
            r1.haveChildWithInterpolator = r2
            int r3 = r1.getChildCount()
            r4 = 0
        L_0x0012:
            r5 = 1
            if (r4 >= r3) goto L_0x0029
            android.view.View r6 = r1.getChildAt(r4)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$LayoutParams r6 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r6
            android.view.animation.Interpolator r6 = r6.scrollInterpolator
            if (r6 == 0) goto L_0x0026
            r1.haveChildWithInterpolator = r5
            goto L_0x0029
        L_0x0026:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x0029:
            boolean r3 = r1.liftOnScroll
            if (r3 != 0) goto L_0x0055
            int r3 = r1.getChildCount()
            r4 = 0
        L_0x0032:
            if (r4 >= r3) goto L_0x0052
            android.view.View r6 = r1.getChildAt(r4)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$LayoutParams r6 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r6
            int r6 = r6.scrollFlags
            r0 = r6 & 1
            if (r0 != r5) goto L_0x004a
            r6 = r6 & 10
            if (r6 == 0) goto L_0x004a
            r6 = 1
            goto L_0x004b
        L_0x004a:
            r6 = 0
        L_0x004b:
            if (r6 == 0) goto L_0x004f
            r3 = 1
            goto L_0x0053
        L_0x004f:
            int r4 = r4 + 1
            goto L_0x0032
        L_0x0052:
            r3 = 0
        L_0x0053:
            if (r3 == 0) goto L_0x0056
        L_0x0055:
            r2 = 1
        L_0x0056:
            boolean r3 = r1.liftable
            if (r3 == r2) goto L_0x005f
            r1.liftable = r2
            r1.refreshDrawableState()
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    public void setExpanded(boolean z) {
        setExpanded(z, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.liftOnScroll = z;
    }

    public boolean setLiftedState(boolean z) {
        if (this.lifted == z) {
            return false;
        }
        this.lifted = z;
        refreshDrawableState();
        return true;
    }

    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            int integer = getResources().getInteger(R$integer.app_bar_elevation_anim_duration);
            StateListAnimator stateListAnimator = new StateListAnimator();
            long j = (long) integer;
            stateListAnimator.addState(new int[]{16842766, R$attr.state_liftable, -R$attr.state_lifted}, ObjectAnimator.ofFloat(this, "elevation", new float[]{0.0f}).setDuration(j));
            stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(this, "elevation", new float[]{f}).setDuration(j));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", new float[]{0.0f}).setDuration(0));
            setStateListAnimator(stateListAnimator);
        }
    }

    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m3672generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void setExpanded(boolean z, boolean z2) {
        this.pendingAction = (z ? 1 : 2) | (z2 ? 4 : 0) | 8;
        requestLayout();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m3673generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public int scrollFlags = 1;
        public Interpolator scrollInterpolator;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.scrollFlags = obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
