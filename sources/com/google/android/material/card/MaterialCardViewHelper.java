package com.google.android.material.card;

import android.graphics.drawable.GradientDrawable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialCardViewHelper {
    public final MaterialCardView materialCardView;
    public int strokeColor;
    public int strokeWidth;

    public MaterialCardViewHelper(MaterialCardView materialCardView2) {
        this.materialCardView = materialCardView2;
    }

    public final void adjustContentPadding() {
        this.materialCardView.setContentPadding(this.materialCardView.getContentPaddingLeft() + this.strokeWidth, this.materialCardView.getContentPaddingTop() + this.strokeWidth, this.materialCardView.getContentPaddingRight() + this.strokeWidth, this.materialCardView.getContentPaddingBottom() + this.strokeWidth);
    }

    public void updateForeground() {
        MaterialCardView materialCardView2 = this.materialCardView;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.materialCardView.getRadius());
        int i = this.strokeColor;
        if (i != -1) {
            gradientDrawable.setStroke(this.strokeWidth, i);
        }
        materialCardView2.setForeground(gradientDrawable);
    }
}
