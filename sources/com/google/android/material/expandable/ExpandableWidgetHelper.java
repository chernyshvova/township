package com.google.android.material.expandable;

import android.view.View;
import androidx.annotation.IdRes;

public final class ExpandableWidgetHelper {
    public boolean expanded = false;
    @IdRes
    public int expandedComponentIdHint = 0;
    public final View widget;

    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.widget = (View) expandableWidget;
    }
}
