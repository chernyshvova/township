package com.helpshift.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.textfield.TextInputLayout;

public class HSTextInputLayout extends TextInputLayout {
    public HSTextInputLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        FontApplier.apply((View) this);
    }

    public HSTextInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HSTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
