package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int tempLeftRightOffset = 0;
    public int tempTopBottomOffset = 0;
    public ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.offsetTop;
        }
        return 0;
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        layoutChild(coordinatorLayout, v, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new ViewOffsetHelper(v);
        }
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        viewOffsetHelper2.layoutTop = viewOffsetHelper2.view.getTop();
        viewOffsetHelper2.layoutLeft = viewOffsetHelper2.view.getLeft();
        viewOffsetHelper2.updateOffsets();
        int i2 = this.tempTopBottomOffset;
        if (i2 != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(i2);
            this.tempTopBottomOffset = 0;
        }
        int i3 = this.tempLeftRightOffset;
        if (i3 == 0) {
            return true;
        }
        ViewOffsetHelper viewOffsetHelper3 = this.viewOffsetHelper;
        if (viewOffsetHelper3.offsetLeft != i3) {
            viewOffsetHelper3.offsetLeft = i3;
            viewOffsetHelper3.updateOffsets();
        }
        this.tempLeftRightOffset = 0;
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
