package com.helpshift.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

public class HSToolbar extends Toolbar {
    public HSToolbar(Context context) {
        super(context);
        init();
    }

    private void init() {
        FontApplier.apply((View) this);
    }

    public HSToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HSToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
