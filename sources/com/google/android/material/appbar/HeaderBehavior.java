package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;

public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public int activePointerId = -1;
    public Runnable flingRunnable;
    public boolean isBeingDragged;
    public int lastMotionY;
    public OverScroller scroller;
    public int touchSlop = -1;
    public VelocityTracker velocityTracker;

    public class FlingRunnable implements Runnable {
        public final V layout;
        public final CoordinatorLayout parent;

        public FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.parent = coordinatorLayout;
            this.layout = v;
        }

        public void run() {
            OverScroller overScroller;
            if (this.layout != null && (overScroller = HeaderBehavior.this.scroller) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
                    ViewCompat.postOnAnimation(this.layout, this);
                    return;
                }
                HeaderBehavior headerBehavior2 = HeaderBehavior.this;
                CoordinatorLayout coordinatorLayout = this.parent;
                V v = this.layout;
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) headerBehavior2;
                if (baseBehavior != null) {
                    baseBehavior.snapToChildIfNeeded(coordinatorLayout, (AppBarLayout) v);
                    return;
                }
                throw null;
            }
        }
    }

    public HeaderBehavior() {
    }

    public abstract boolean canDragView(V v);

    public abstract int getTopBottomOffsetForScrollingSibling();

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r0 != 3) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.touchSlop
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.touchSlop = r0
        L_0x0012:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L_0x001f
            boolean r0 = r4.isBeingDragged
            if (r0 == 0) goto L_0x001f
            return r2
        L_0x001f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L_0x0060
            r5 = -1
            if (r0 == r2) goto L_0x0051
            if (r0 == r1) goto L_0x002f
            r6 = 3
            if (r0 == r6) goto L_0x0051
            goto L_0x008a
        L_0x002f:
            int r6 = r4.activePointerId
            if (r6 != r5) goto L_0x0034
            goto L_0x008a
        L_0x0034:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L_0x003b
            goto L_0x008a
        L_0x003b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.lastMotionY
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.touchSlop
            if (r6 <= r0) goto L_0x008a
            r4.isBeingDragged = r2
            r4.lastMotionY = r5
            goto L_0x008a
        L_0x0051:
            r4.isBeingDragged = r3
            r4.activePointerId = r5
            android.view.VelocityTracker r5 = r4.velocityTracker
            if (r5 == 0) goto L_0x008a
            r5.recycle()
            r5 = 0
            r4.velocityTracker = r5
            goto L_0x008a
        L_0x0060:
            r4.isBeingDragged = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.canDragView(r6)
            if (r2 == 0) goto L_0x008a
            boolean r5 = r5.isPointInChildBounds(r6, r0, r1)
            if (r5 == 0) goto L_0x008a
            r4.lastMotionY = r1
            int r5 = r7.getPointerId(r3)
            r4.activePointerId = r5
            android.view.VelocityTracker r5 = r4.velocityTracker
            if (r5 != 0) goto L_0x008a
            android.view.VelocityTracker r5 = android.view.VelocityTracker.obtain()
            r4.velocityTracker = r5
        L_0x008a:
            android.view.VelocityTracker r5 = r4.velocityTracker
            if (r5 == 0) goto L_0x0091
            r5.addMovement(r7)
        L_0x0091:
            boolean r5 = r4.isBeingDragged
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r0 != 3) goto L_0x0108;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r21, V r22, android.view.MotionEvent r23) {
        /*
            r20 = this;
            r6 = r20
            r1 = r21
            r2 = r22
            r7 = r23
            int r0 = r6.touchSlop
            if (r0 >= 0) goto L_0x001a
            android.content.Context r0 = r21.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r6.touchSlop = r0
        L_0x001a:
            int r0 = r23.getActionMasked()
            r8 = 1
            r3 = 0
            if (r0 == 0) goto L_0x00e0
            r4 = 0
            r5 = -1
            if (r0 == r8) goto L_0x006c
            r9 = 2
            if (r0 == r9) goto L_0x002e
            r1 = 3
            if (r0 == r1) goto L_0x00d2
            goto L_0x0108
        L_0x002e:
            int r0 = r6.activePointerId
            int r0 = r7.findPointerIndex(r0)
            if (r0 != r5) goto L_0x0037
            return r3
        L_0x0037:
            float r0 = r7.getY(r0)
            int r0 = (int) r0
            int r3 = r6.lastMotionY
            int r3 = r3 - r0
            boolean r4 = r6.isBeingDragged
            if (r4 != 0) goto L_0x0052
            int r4 = java.lang.Math.abs(r3)
            int r5 = r6.touchSlop
            if (r4 <= r5) goto L_0x0052
            r6.isBeingDragged = r8
            if (r3 <= 0) goto L_0x0051
            int r3 = r3 - r5
            goto L_0x0052
        L_0x0051:
            int r3 = r3 + r5
        L_0x0052:
            boolean r4 = r6.isBeingDragged
            if (r4 == 0) goto L_0x0108
            r6.lastMotionY = r0
            r0 = r2
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            int r0 = r0.getDownNestedScrollRange()
            int r4 = -r0
            r5 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r0.scroll(r1, r2, r3, r4, r5)
            goto L_0x0108
        L_0x006c:
            android.view.VelocityTracker r0 = r6.velocityTracker
            if (r0 == 0) goto L_0x00d2
            r0.addMovement(r7)
            android.view.VelocityTracker r0 = r6.velocityTracker
            r9 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r9)
            android.view.VelocityTracker r0 = r6.velocityTracker
            int r9 = r6.activePointerId
            float r0 = r0.getYVelocity(r9)
            r9 = r2
            com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
            int r10 = r9.getTotalScrollRange()
            int r10 = -r10
            r19 = 0
            java.lang.Runnable r11 = r6.flingRunnable
            if (r11 == 0) goto L_0x0095
            r2.removeCallbacks(r11)
            r6.flingRunnable = r4
        L_0x0095:
            android.widget.OverScroller r11 = r6.scroller
            if (r11 != 0) goto L_0x00a4
            android.widget.OverScroller r11 = new android.widget.OverScroller
            android.content.Context r12 = r22.getContext()
            r11.<init>(r12)
            r6.scroller = r11
        L_0x00a4:
            android.widget.OverScroller r11 = r6.scroller
            r12 = 0
            int r13 = r20.getTopAndBottomOffset()
            r14 = 0
            int r15 = java.lang.Math.round(r0)
            r16 = 0
            r17 = 0
            r18 = r10
            r11.fling(r12, r13, r14, r15, r16, r17, r18, r19)
            android.widget.OverScroller r0 = r6.scroller
            boolean r0 = r0.computeScrollOffset()
            if (r0 == 0) goto L_0x00cc
            com.google.android.material.appbar.HeaderBehavior$FlingRunnable r0 = new com.google.android.material.appbar.HeaderBehavior$FlingRunnable
            r0.<init>(r1, r2)
            r6.flingRunnable = r0
            androidx.core.view.ViewCompat.postOnAnimation(r2, r0)
            goto L_0x00d2
        L_0x00cc:
            r0 = r6
            com.google.android.material.appbar.AppBarLayout$BaseBehavior r0 = (com.google.android.material.appbar.AppBarLayout.BaseBehavior) r0
            r0.snapToChildIfNeeded(r1, r9)
        L_0x00d2:
            r6.isBeingDragged = r3
            r6.activePointerId = r5
            android.view.VelocityTracker r0 = r6.velocityTracker
            if (r0 == 0) goto L_0x0108
            r0.recycle()
            r6.velocityTracker = r4
            goto L_0x0108
        L_0x00e0:
            float r0 = r23.getX()
            int r0 = (int) r0
            float r4 = r23.getY()
            int r4 = (int) r4
            boolean r0 = r1.isPointInChildBounds(r2, r0, r4)
            if (r0 == 0) goto L_0x0110
            boolean r0 = r6.canDragView(r2)
            if (r0 == 0) goto L_0x0110
            r6.lastMotionY = r4
            int r0 = r7.getPointerId(r3)
            r6.activePointerId = r0
            android.view.VelocityTracker r0 = r6.velocityTracker
            if (r0 != 0) goto L_0x0108
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.velocityTracker = r0
        L_0x0108:
            android.view.VelocityTracker r0 = r6.velocityTracker
            if (r0 == 0) goto L_0x010f
            r0.addMovement(r7)
        L_0x010f:
            return r8
        L_0x0110:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
