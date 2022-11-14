package com.helpshift.views;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class HSTypefaceSpan extends MetricAffectingSpan {
    public final Typeface typeface;

    public HSTypefaceSpan(Typeface typeface2) {
        this.typeface = typeface2;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTypeface(this.typeface);
    }

    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTypeface(this.typeface);
    }
}
