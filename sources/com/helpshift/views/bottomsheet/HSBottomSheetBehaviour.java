package com.helpshift.views.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class HSBottomSheetBehaviour<V extends View> extends BottomSheetBehavior<V> {
    public boolean isDraggable = true;

    public HSBottomSheetBehaviour() {
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!this.isDraggable) {
            return false;
        }
        return super.onInterceptTouchEvent(coordinatorLayout, v, motionEvent);
    }

    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f, float f2) {
        if (!this.isDraggable) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, v, view, f, f2);
    }

    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, int i3, int i4, int i5) {
        if (this.isDraggable) {
            super.onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4, i5);
        }
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i, int i2) {
        if (!this.isDraggable) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, v, view, view2, i, i2);
    }

    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i) {
        if (this.isDraggable) {
            super.onStopNestedScroll(coordinatorLayout, v, view, i);
        }
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!this.isDraggable) {
            return false;
        }
        return super.onTouchEvent(coordinatorLayout, v, motionEvent);
    }

    public void setDraggable(boolean z) {
        this.isDraggable = z;
    }

    public HSBottomSheetBehaviour(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
