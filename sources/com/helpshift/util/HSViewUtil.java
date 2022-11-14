package com.helpshift.util;

import android.view.View;

public class HSViewUtil {
    public static boolean isGone(View view) {
        return isVisibilityStateEquals(view, 8);
    }

    public static boolean isViewDirectionRtl(View view) {
        return view != null && view.getLayoutDirection() == 1;
    }

    public static boolean isVisibilityStateEquals(View view, int i) {
        return view != null && view.getVisibility() == i;
    }

    public static boolean isVisible(View view) {
        return isVisibilityStateEquals(view, 0);
    }
}
