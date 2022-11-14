package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    public int currentState = 0;

    public ExpandableBehavior() {
    }

    public final boolean didStateChange(boolean z) {
        if (z) {
            int i = this.currentState;
            return i == 0 || i == 2;
        } else if (this.currentState == 1) {
            return true;
        } else {
            return false;
        }
    }

    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!didStateChange(expandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = expandableWidget.isExpanded() ? 1 : 2;
        return onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), true);
    }

    public abstract boolean onExpandedStateChange(View view, View view2, boolean z, boolean z2);

    @CallSuper
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final View view, int i) {
        final ExpandableWidget expandableWidget;
        if (!ViewCompat.isLaidOut(view)) {
            List<View> dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    expandableWidget = null;
                    break;
                }
                View view2 = dependencies.get(i2);
                if (layoutDependsOn(coordinatorLayout, view, view2)) {
                    expandableWidget = (ExpandableWidget) view2;
                    break;
                }
                i2++;
            }
            if (expandableWidget != null && didStateChange(expandableWidget.isExpanded())) {
                final int i3 = expandableWidget.isExpanded() ? 1 : 2;
                this.currentState = i3;
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                        if (expandableBehavior.currentState == i3) {
                            ExpandableWidget expandableWidget = expandableWidget;
                            expandableBehavior.onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), false);
                        }
                        return false;
                    }
                });
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
