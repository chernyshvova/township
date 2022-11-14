package com.helpshift.util;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

public class HtmlUtil {
    public static Spanned fromHtml(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }
}
