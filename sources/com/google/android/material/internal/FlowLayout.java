package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {
    public int itemSpacing;
    public int lineSpacing;
    public boolean singleLine = false;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() != 0) {
            boolean z2 = true;
            if (ViewCompat.getLayoutDirection(this) != 1) {
                z2 = false;
            }
            int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
            int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
            int paddingTop = getPaddingTop();
            int i7 = (i3 - i) - paddingLeft;
            int i8 = paddingRight;
            int i9 = paddingTop;
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i5 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                        i6 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                    } else {
                        i6 = 0;
                        i5 = 0;
                    }
                    int measuredWidth = childAt.getMeasuredWidth() + i8 + i5;
                    if (!this.singleLine && measuredWidth > i7) {
                        i9 = this.lineSpacing + paddingTop;
                        i8 = paddingRight;
                    }
                    int i11 = i8 + i5;
                    int measuredWidth2 = childAt.getMeasuredWidth() + i11;
                    int measuredHeight = childAt.getMeasuredHeight() + i9;
                    if (z2) {
                        childAt.layout(i7 - measuredWidth2, i9, (i7 - i8) - i5, measuredHeight);
                    } else {
                        childAt.layout(i11, i9, measuredWidth2, measuredHeight);
                    }
                    i8 += childAt.getMeasuredWidth() + i5 + i6 + this.itemSpacing;
                    paddingTop = measuredHeight;
                }
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i6 = Integer.MIN_VALUE;
        int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i7 - getPaddingRight();
        int i8 = paddingTop;
        int i9 = 0;
        int i10 = 0;
        while (i9 < getChildCount()) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                int i11 = i2;
            } else {
                measureChild(childAt, i, i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i4 = marginLayoutParams.leftMargin + 0;
                    i5 = marginLayoutParams.rightMargin + 0;
                } else {
                    i5 = 0;
                    i4 = 0;
                }
                if (childAt.getMeasuredWidth() + paddingLeft + i4 > paddingRight && !this.singleLine) {
                    paddingLeft = getPaddingLeft();
                    i8 = paddingTop + this.lineSpacing;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i4;
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                if (measuredWidth > i10) {
                    i10 = measuredWidth;
                }
                paddingLeft = childAt.getMeasuredWidth() + i4 + i5 + this.itemSpacing + paddingLeft;
                paddingTop = measuredHeight;
            }
            i9++;
            i6 = Integer.MIN_VALUE;
        }
        if (mode != i6) {
            i3 = 1073741824;
            if (mode != 1073741824) {
                size = i10;
            }
        } else {
            i3 = 1073741824;
            size = Math.min(i10, size);
        }
        if (mode2 == i6) {
            size2 = Math.min(paddingTop, size2);
        } else if (mode2 != i3) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i) {
        this.itemSpacing = i;
    }

    public void setLineSpacing(int i) {
        this.lineSpacing = i;
    }

    public void setSingleLine(boolean z) {
        this.singleLine = z;
    }
}
