package com.helpshift.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.helpshift.C2466R;

public class Styles {
    public static float dpToPx(Context context, float f) {
        return f * context.getResources().getDisplayMetrics().density;
    }

    public static int getColor(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        return color;
    }

    public static String getHexColor(Context context, int i) {
        return getHexColor(getColor(context, i));
    }

    public static void setActionButtonIconColor(Context context, Drawable drawable) {
        setColorFilter(context, drawable, C2466R.attr.hs__actionButtonIconColor);
    }

    public static void setColorFilter(Context context, Drawable drawable, int i) {
        if (drawable != null) {
            drawable.setColorFilter(getColor(context, i), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static void setDrawable(Context context, View view, int i, int i2) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        setColorFilter(context, drawable, i2);
        view.setBackground(drawable);
    }

    public static void setGradientBackground(@NonNull View view, int i, int i2, GradientDrawable.Orientation orientation) {
        ViewCompat.setBackground(view, new GradientDrawable(orientation, new int[]{i, i2}));
    }

    public static String getHexColor(int i) {
        return String.format("#%06X", new Object[]{Integer.valueOf(i & ViewCompat.MEASURED_SIZE_MASK)});
    }

    public static void setColorFilter(Drawable drawable, int i) {
        if (drawable != null) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
