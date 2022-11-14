package com.helpshift.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

public class HSTabLayout extends TabLayout {
    public HSTabLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        FontApplier.apply((View) this);
    }

    public HSTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HSTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
