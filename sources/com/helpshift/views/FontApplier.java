package com.helpshift.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import java.lang.ref.WeakReference;

public final class FontApplier {
    public static final String TAG = "HS_FontApplier";
    public static String fontPathInternal = null;
    public static Typeface typeface = null;
    public static boolean typefaceInitialisationTried = false;
    public static HSTypefaceSpan typefaceSpan;

    public static class FontLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public final WeakReference<View> viewRef;

        public FontLayoutListener(View view) {
            this.viewRef = new WeakReference<>(view);
        }

        public void onGlobalLayout() {
            View view = (View) this.viewRef.get();
            if (view != null) {
                FontApplier.applyInternal(view);
            }
        }
    }

    public static void apply(TextView textView) {
        initTypeface(textView.getContext());
        Typeface typeface2 = typeface;
        if (typeface2 != null) {
            textView.setTypeface(typeface2);
        }
    }

    public static void applyInternal(View view) {
        if (view instanceof TextView) {
            apply((TextView) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                applyInternal(viewGroup.getChildAt(i));
            }
        }
    }

    @Nullable
    public static String getFontPath() {
        return fontPathInternal;
    }

    @Nullable
    public static HSTypefaceSpan getTypefaceSpan() {
        if (typeface != null && typefaceSpan == null) {
            typefaceSpan = new HSTypefaceSpan(typeface);
        }
        return typefaceSpan;
    }

    public static void initTypeface(Context context) {
        String fontPath = getFontPath();
        if (StringUtils.isNotEmpty(fontPath) && typeface == null && !typefaceInitialisationTried) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontPath);
            } catch (Exception e) {
                HSLogger.m3241e(TAG, "Typeface initialisation failed. Using default typeface. " + e.getMessage());
            } catch (Throwable th) {
                typefaceInitialisationTried = true;
                throw th;
            }
            typefaceInitialisationTried = true;
        }
    }

    public static void setFontPath(String str) {
        fontPathInternal = str;
    }

    public static void apply(Dialog dialog) {
        apply(dialog.findViewById(16908290));
    }

    public static void apply(View view) {
        initTypeface(view.getContext());
        if (typeface != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new FontLayoutListener(view));
        }
    }
}
