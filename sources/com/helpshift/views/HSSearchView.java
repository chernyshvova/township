package com.helpshift.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SearchView;

public class HSSearchView extends SearchView {
    public HSSearchView(Context context) {
        super(context);
        init();
    }

    private void init() {
        FontApplier.apply((View) this);
    }

    public HSSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HSSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
