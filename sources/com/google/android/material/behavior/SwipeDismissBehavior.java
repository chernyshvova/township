package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public float alphaEndSwipeDistance = 0.5f;
    public float alphaStartSwipeDistance = 0.0f;
    public final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        public int activePointerId = -1;
        public int originalCapturedViewLeft;

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int i3;
            int i4;
            int width;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int i5 = SwipeDismissBehavior.this.swipeDirection;
            if (i5 != 0) {
                if (i5 != 1) {
                    i3 = this.originalCapturedViewLeft - view.getWidth();
                    i4 = view.getWidth() + this.originalCapturedViewLeft;
                } else if (z) {
                    i3 = this.originalCapturedViewLeft;
                    width = view.getWidth();
                } else {
                    i3 = this.originalCapturedViewLeft - view.getWidth();
                    i4 = this.originalCapturedViewLeft;
                }
                return Math.min(Math.max(i3, i), i4);
            } else if (z) {
                i3 = this.originalCapturedViewLeft - view.getWidth();
                i4 = this.originalCapturedViewLeft;
                return Math.min(Math.max(i3, i), i4);
            } else {
                i3 = this.originalCapturedViewLeft;
                width = view.getWidth();
            }
            i4 = width + i3;
            return Math.min(Math.max(i3, i), i4);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        public void onViewCaptured(View view, int i) {
            this.activePointerId = i;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void onViewDragStateChanged(int i) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                BaseTransientBottomBar.C21505 r0 = (BaseTransientBottomBar.C21505) onDismissListener;
                if (r0 == null) {
                    throw null;
                } else if (i == 0) {
                    SnackbarManager.getInstance().restoreTimeoutIfPaused(BaseTransientBottomBar.this.managerCallback);
                } else if (i == 1 || i == 2) {
                    SnackbarManager.getInstance().pauseTimeout(BaseTransientBottomBar.this.managerCallback);
                }
            }
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width = (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaStartSwipeDistance) + ((float) this.originalCapturedViewLeft);
            float width2 = (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaEndSwipeDistance) + ((float) this.originalCapturedViewLeft);
            float f = (float) i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1.0f - ((f - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
            if (java.lang.Math.abs(r7.getLeft() - r6.originalCapturedViewLeft) >= java.lang.Math.round(((float) r7.getWidth()) * r6.this$0.dragDismissThreshold)) goto L_0x0057;
         */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(android.view.View r7, float r8, float r9) {
            /*
                r6 = this;
                r9 = -1
                r6.activePointerId = r9
                int r9 = r7.getWidth()
                r0 = 1
                r1 = 0
                r2 = 0
                int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x003b
                int r3 = androidx.core.view.ViewCompat.getLayoutDirection(r7)
                if (r3 != r0) goto L_0x0016
                r3 = 1
                goto L_0x0017
            L_0x0016:
                r3 = 0
            L_0x0017:
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r4 = r4.swipeDirection
                r5 = 2
                if (r4 != r5) goto L_0x001f
                goto L_0x0057
            L_0x001f:
                if (r4 != 0) goto L_0x002d
                if (r3 == 0) goto L_0x0028
                int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r8 >= 0) goto L_0x0059
                goto L_0x0057
            L_0x0028:
                int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r8 <= 0) goto L_0x0059
                goto L_0x0057
            L_0x002d:
                if (r4 != r0) goto L_0x0059
                if (r3 == 0) goto L_0x0036
                int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r8 <= 0) goto L_0x0059
                goto L_0x0057
            L_0x0036:
                int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r8 >= 0) goto L_0x0059
                goto L_0x0057
            L_0x003b:
                int r8 = r7.getLeft()
                int r2 = r6.originalCapturedViewLeft
                int r8 = r8 - r2
                int r2 = r7.getWidth()
                float r2 = (float) r2
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r3 = r3.dragDismissThreshold
                float r2 = r2 * r3
                int r2 = java.lang.Math.round(r2)
                int r8 = java.lang.Math.abs(r8)
                if (r8 < r2) goto L_0x0059
            L_0x0057:
                r8 = 1
                goto L_0x005a
            L_0x0059:
                r8 = 0
            L_0x005a:
                if (r8 == 0) goto L_0x0068
                int r8 = r7.getLeft()
                int r2 = r6.originalCapturedViewLeft
                if (r8 >= r2) goto L_0x0066
                int r2 = r2 - r9
                goto L_0x006b
            L_0x0066:
                int r2 = r2 + r9
                goto L_0x006b
            L_0x0068:
                int r2 = r6.originalCapturedViewLeft
                r0 = 0
            L_0x006b:
                com.google.android.material.behavior.SwipeDismissBehavior r8 = com.google.android.material.behavior.SwipeDismissBehavior.this
                androidx.customview.widget.ViewDragHelper r8 = r8.viewDragHelper
                int r9 = r7.getTop()
                boolean r8 = r8.settleCapturedViewAt(r2, r9)
                if (r8 == 0) goto L_0x0084
                com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable r8 = new com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r8.<init>(r7, r0)
                androidx.core.view.ViewCompat.postOnAnimation(r7, r8)
                goto L_0x0098
            L_0x0084:
                if (r0 == 0) goto L_0x0098
                com.google.android.material.behavior.SwipeDismissBehavior r8 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener r8 = r8.listener
                if (r8 == 0) goto L_0x0098
                com.google.android.material.snackbar.BaseTransientBottomBar$5 r8 = (com.google.android.material.snackbar.BaseTransientBottomBar.C21505) r8
                r9 = 8
                r7.setVisibility(r9)
                com.google.android.material.snackbar.BaseTransientBottomBar r7 = com.google.android.material.snackbar.BaseTransientBottomBar.this
                r7.dispatchDismiss(r1)
            L_0x0098:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.C21041.onViewReleased(android.view.View, float, float):void");
        }

        public boolean tryCaptureView(View view, int i) {
            return this.activePointerId == -1 && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }
    };
    public float dragDismissThreshold = 0.5f;
    public boolean interceptingEvents;
    public OnDismissListener listener;
    public float sensitivity = 0.0f;
    public int swipeDirection = 2;
    public ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
    }

    public class SettleRunnable implements Runnable {
        public final boolean dismiss;
        public final View view;

        public SettleRunnable(View view2, boolean z) {
            this.view = view2;
            this.dismiss = z;
        }

        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else if (this.dismiss && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                this.view.setVisibility(8);
                BaseTransientBottomBar.this.dispatchDismiss(0);
            }
        }
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public boolean canSwipeDismissView(@NonNull View view) {
        return true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!z) {
            return false;
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null) {
            return false;
        }
        viewDragHelper2.processTouchEvent(motionEvent);
        return true;
    }
}
