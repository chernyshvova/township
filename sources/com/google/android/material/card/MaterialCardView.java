package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

public class MaterialCardView extends CardView {
    public final MaterialCardViewHelper cardViewHelper;

    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.MaterialCardView, i, R$style.Widget_MaterialComponents_CardView, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this);
        this.cardViewHelper = materialCardViewHelper;
        if (materialCardViewHelper != null) {
            materialCardViewHelper.strokeColor = obtainStyledAttributes.getColor(R$styleable.MaterialCardView_strokeColor, -1);
            materialCardViewHelper.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
            materialCardViewHelper.updateForeground();
            materialCardViewHelper.adjustContentPadding();
            obtainStyledAttributes.recycle();
            return;
        }
        throw null;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.cardViewHelper.strokeColor;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.strokeWidth;
    }

    public void setRadius(float f) {
        super.setRadius(f);
        this.cardViewHelper.updateForeground();
    }

    public void setStrokeColor(@ColorInt int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.strokeColor = i;
        materialCardViewHelper.updateForeground();
    }

    public void setStrokeWidth(@Dimension int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.strokeWidth = i;
        materialCardViewHelper.updateForeground();
        materialCardViewHelper.adjustContentPadding();
    }
}
