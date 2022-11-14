package com.helpshift.views;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.Snackbar;

public class HSSnackbar {
    @NonNull
    public static Snackbar make(View view, CharSequence charSequence, int i) {
        Snackbar make = Snackbar.make(view, charSequence, i);
        FontApplier.apply((View) make.view);
        return make;
    }

    @NonNull
    public static Snackbar make(View view, int i, int i2) {
        return make(view, view.getResources().getText(i), i2);
    }
}
