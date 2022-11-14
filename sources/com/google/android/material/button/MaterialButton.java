package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.C0030Px;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

public class MaterialButton extends AppCompatButton {
    public Drawable icon;
    public int iconGravity;
    @C0030Px
    public int iconLeft;
    @C0030Px
    public int iconPadding;
    @C0030Px
    public int iconSize;
    public ColorStateList iconTint;
    public PorterDuff.Mode iconTintMode;
    @Nullable
    public final MaterialButtonHelper materialButtonHelper;

    /* JADX WARNING: type inference failed for: r3v9, types: [android.graphics.drawable.Drawable] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(android.content.Context r19, android.util.AttributeSet r20, int r21) {
        /*
            r18 = this;
            r0 = r18
            r18.<init>(r19, r20, r21)
            int[] r3 = com.google.android.material.R$styleable.MaterialButton
            int r5 = com.google.android.material.R$style.Widget_MaterialComponents_Button
            r7 = 0
            int[] r6 = new int[r7]
            r1 = r19
            r2 = r20
            r4 = r21
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R$styleable.MaterialButton_iconPadding
            int r2 = r1.getDimensionPixelSize(r2, r7)
            r0.iconPadding = r2
            int r2 = com.google.android.material.R$styleable.MaterialButton_iconTintMode
            r3 = -1
            int r2 = r1.getInt(r2, r3)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r2 = com.android.billingclient.api.zzam.parseTintMode(r2, r4)
            r0.iconTintMode = r2
            android.content.Context r2 = r18.getContext()
            int r4 = com.google.android.material.R$styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r2 = com.android.billingclient.api.zzam.getColorStateList(r2, r1, r4)
            r0.iconTint = r2
            android.content.Context r2 = r18.getContext()
            int r4 = com.google.android.material.R$styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r2 = com.android.billingclient.api.zzam.getDrawable(r2, r1, r4)
            r0.icon = r2
            int r2 = com.google.android.material.R$styleable.MaterialButton_iconGravity
            r4 = 1
            int r2 = r1.getInteger(r2, r4)
            r0.iconGravity = r2
            int r2 = com.google.android.material.R$styleable.MaterialButton_iconSize
            int r2 = r1.getDimensionPixelSize(r2, r7)
            r0.iconSize = r2
            com.google.android.material.button.MaterialButtonHelper r2 = new com.google.android.material.button.MaterialButtonHelper
            r2.<init>(r0)
            r0.materialButtonHelper = r2
            if (r2 == 0) goto L_0x019c
            int r5 = com.google.android.material.R$styleable.MaterialButton_android_insetLeft
            int r5 = r1.getDimensionPixelOffset(r5, r7)
            r2.insetLeft = r5
            int r5 = com.google.android.material.R$styleable.MaterialButton_android_insetRight
            int r5 = r1.getDimensionPixelOffset(r5, r7)
            r2.insetRight = r5
            int r5 = com.google.android.material.R$styleable.MaterialButton_android_insetTop
            int r5 = r1.getDimensionPixelOffset(r5, r7)
            r2.insetTop = r5
            int r5 = com.google.android.material.R$styleable.MaterialButton_android_insetBottom
            int r5 = r1.getDimensionPixelOffset(r5, r7)
            r2.insetBottom = r5
            int r5 = com.google.android.material.R$styleable.MaterialButton_cornerRadius
            int r5 = r1.getDimensionPixelSize(r5, r7)
            r2.cornerRadius = r5
            int r5 = com.google.android.material.R$styleable.MaterialButton_strokeWidth
            int r5 = r1.getDimensionPixelSize(r5, r7)
            r2.strokeWidth = r5
            int r5 = com.google.android.material.R$styleable.MaterialButton_backgroundTintMode
            int r5 = r1.getInt(r5, r3)
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r5 = com.android.billingclient.api.zzam.parseTintMode(r5, r6)
            r2.backgroundTintMode = r5
            com.google.android.material.button.MaterialButton r5 = r2.materialButton
            android.content.Context r5 = r5.getContext()
            int r6 = com.google.android.material.R$styleable.MaterialButton_backgroundTint
            android.content.res.ColorStateList r5 = com.android.billingclient.api.zzam.getColorStateList(r5, r1, r6)
            r2.backgroundTint = r5
            com.google.android.material.button.MaterialButton r5 = r2.materialButton
            android.content.Context r5 = r5.getContext()
            int r6 = com.google.android.material.R$styleable.MaterialButton_strokeColor
            android.content.res.ColorStateList r5 = com.android.billingclient.api.zzam.getColorStateList(r5, r1, r6)
            r2.strokeColor = r5
            com.google.android.material.button.MaterialButton r5 = r2.materialButton
            android.content.Context r5 = r5.getContext()
            int r6 = com.google.android.material.R$styleable.MaterialButton_rippleColor
            android.content.res.ColorStateList r5 = com.android.billingclient.api.zzam.getColorStateList(r5, r1, r6)
            r2.rippleColor = r5
            android.graphics.Paint r5 = r2.buttonStrokePaint
            android.graphics.Paint$Style r6 = android.graphics.Paint.Style.STROKE
            r5.setStyle(r6)
            android.graphics.Paint r5 = r2.buttonStrokePaint
            int r6 = r2.strokeWidth
            float r6 = (float) r6
            r5.setStrokeWidth(r6)
            android.graphics.Paint r5 = r2.buttonStrokePaint
            android.content.res.ColorStateList r6 = r2.strokeColor
            if (r6 == 0) goto L_0x00e7
            com.google.android.material.button.MaterialButton r8 = r2.materialButton
            int[] r8 = r8.getDrawableState()
            int r6 = r6.getColorForState(r8, r7)
            goto L_0x00e8
        L_0x00e7:
            r6 = 0
        L_0x00e8:
            r5.setColor(r6)
            com.google.android.material.button.MaterialButton r5 = r2.materialButton
            int r5 = androidx.core.view.ViewCompat.getPaddingStart(r5)
            com.google.android.material.button.MaterialButton r6 = r2.materialButton
            int r6 = r6.getPaddingTop()
            com.google.android.material.button.MaterialButton r8 = r2.materialButton
            int r8 = androidx.core.view.ViewCompat.getPaddingEnd(r8)
            com.google.android.material.button.MaterialButton r9 = r2.materialButton
            int r9 = r9.getPaddingBottom()
            com.google.android.material.button.MaterialButton r10 = r2.materialButton
            boolean r11 = com.google.android.material.button.MaterialButtonHelper.IS_LOLLIPOP
            if (r11 == 0) goto L_0x010e
            android.graphics.drawable.Drawable r3 = r2.createBackgroundLollipop()
            goto L_0x017c
        L_0x010e:
            android.graphics.drawable.GradientDrawable r11 = new android.graphics.drawable.GradientDrawable
            r11.<init>()
            r2.colorableBackgroundDrawableCompat = r11
            int r12 = r2.cornerRadius
            float r12 = (float) r12
            r13 = 925353388(0x3727c5ac, float:1.0E-5)
            float r12 = r12 + r13
            r11.setCornerRadius(r12)
            android.graphics.drawable.GradientDrawable r11 = r2.colorableBackgroundDrawableCompat
            r11.setColor(r3)
            android.graphics.drawable.GradientDrawable r11 = r2.colorableBackgroundDrawableCompat
            android.graphics.drawable.Drawable r11 = androidx.core.graphics.drawable.DrawableCompat.wrap(r11)
            r2.tintableBackgroundDrawableCompat = r11
            android.content.res.ColorStateList r12 = r2.backgroundTint
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r11, r12)
            android.graphics.PorterDuff$Mode r11 = r2.backgroundTintMode
            if (r11 == 0) goto L_0x013a
            android.graphics.drawable.Drawable r12 = r2.tintableBackgroundDrawableCompat
            androidx.core.graphics.drawable.DrawableCompat.setTintMode(r12, r11)
        L_0x013a:
            android.graphics.drawable.GradientDrawable r11 = new android.graphics.drawable.GradientDrawable
            r11.<init>()
            r2.rippleDrawableCompat = r11
            int r12 = r2.cornerRadius
            float r12 = (float) r12
            float r12 = r12 + r13
            r11.setCornerRadius(r12)
            android.graphics.drawable.GradientDrawable r11 = r2.rippleDrawableCompat
            r11.setColor(r3)
            android.graphics.drawable.GradientDrawable r3 = r2.rippleDrawableCompat
            android.graphics.drawable.Drawable r3 = androidx.core.graphics.drawable.DrawableCompat.wrap(r3)
            r2.tintableRippleDrawableCompat = r3
            android.content.res.ColorStateList r11 = r2.rippleColor
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r3, r11)
            android.graphics.drawable.LayerDrawable r13 = new android.graphics.drawable.LayerDrawable
            r3 = 2
            android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r3]
            android.graphics.drawable.Drawable r11 = r2.tintableBackgroundDrawableCompat
            r3[r7] = r11
            android.graphics.drawable.Drawable r7 = r2.tintableRippleDrawableCompat
            r3[r4] = r7
            r13.<init>(r3)
            android.graphics.drawable.InsetDrawable r3 = new android.graphics.drawable.InsetDrawable
            int r14 = r2.insetLeft
            int r15 = r2.insetTop
            int r4 = r2.insetRight
            int r7 = r2.insetBottom
            r12 = r3
            r16 = r4
            r17 = r7
            r12.<init>(r13, r14, r15, r16, r17)
        L_0x017c:
            r10.setInternalBackground(r3)
            com.google.android.material.button.MaterialButton r3 = r2.materialButton
            int r4 = r2.insetLeft
            int r5 = r5 + r4
            int r4 = r2.insetTop
            int r6 = r6 + r4
            int r4 = r2.insetRight
            int r8 = r8 + r4
            int r2 = r2.insetBottom
            int r9 = r9 + r2
            androidx.core.view.ViewCompat.setPaddingRelative(r3, r5, r6, r8, r9)
            r1.recycle()
            int r1 = r0.iconPadding
            r0.setCompoundDrawablePadding(r1)
            r18.updateIcon()
            return
        L_0x019c:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @C0030Px
    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.cornerRadius;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    @C0030Px
    public int getIconPadding() {
        return this.iconPadding;
    }

    @C0030Px
    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.rippleColor;
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.strokeColor;
        }
        return null;
    }

    @C0030Px
    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.strokeWidth;
        }
        return 0;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTint;
        }
        return super.getSupportBackgroundTintList();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTintMode;
        }
        return super.getSupportBackgroundTintMode();
    }

    public final boolean isUsingOriginalBackground() {
        MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
        return materialButtonHelper2 != null && !materialButtonHelper2.backgroundOverwritten;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT < 21 && isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2 == null) {
                throw null;
            } else if (canvas != null && materialButtonHelper2.strokeColor != null && materialButtonHelper2.strokeWidth > 0) {
                materialButtonHelper2.bounds.set(materialButtonHelper2.materialButton.getBackground().getBounds());
                RectF rectF = materialButtonHelper2.rectF;
                Rect rect = materialButtonHelper2.bounds;
                float f = ((float) materialButtonHelper2.strokeWidth) / 2.0f;
                rectF.set(((float) rect.left) + f + ((float) materialButtonHelper2.insetLeft), ((float) rect.top) + f + ((float) materialButtonHelper2.insetTop), (((float) rect.right) - f) - ((float) materialButtonHelper2.insetRight), (((float) rect.bottom) - f) - ((float) materialButtonHelper2.insetBottom));
                float f2 = ((float) materialButtonHelper2.cornerRadius) - (((float) materialButtonHelper2.strokeWidth) / 2.0f);
                canvas.drawRoundRect(materialButtonHelper2.rectF, f2, f2, materialButtonHelper2.buttonStrokePaint);
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        MaterialButtonHelper materialButtonHelper2;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT == 21 && (materialButtonHelper2 = this.materialButtonHelper) != null) {
            int i5 = i4 - i2;
            int i6 = i3 - i;
            GradientDrawable gradientDrawable = materialButtonHelper2.maskDrawableLollipop;
            if (gradientDrawable != null) {
                gradientDrawable.setBounds(materialButtonHelper2.insetLeft, materialButtonHelper2.insetTop, i6 - materialButtonHelper2.insetRight, i5 - materialButtonHelper2.insetBottom);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.icon != null && this.iconGravity == 2) {
            int measureText = (int) getPaint().measureText(getText().toString());
            int i3 = this.iconSize;
            if (i3 == 0) {
                i3 = this.icon.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - measureText) - ViewCompat.getPaddingEnd(this)) - i3) - this.iconPadding) - ViewCompat.getPaddingStart(this)) / 2;
            boolean z = true;
            if (ViewCompat.getLayoutDirection(this) != 1) {
                z = false;
            }
            if (z) {
                measuredWidth = -measuredWidth;
            }
            if (this.iconLeft != measuredWidth) {
                this.iconLeft = measuredWidth;
                updateIcon();
            }
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(@ColorInt int i) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2 == null) {
                throw null;
            } else if (MaterialButtonHelper.IS_LOLLIPOP && (gradientDrawable2 = materialButtonHelper2.backgroundDrawableLollipop) != null) {
                gradientDrawable2.setColor(i);
            } else if (!MaterialButtonHelper.IS_LOLLIPOP && (gradientDrawable = materialButtonHelper2.colorableBackgroundDrawableCompat) != null) {
                gradientDrawable.setColor(i);
            }
        } else {
            super.setBackgroundColor(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.i("MaterialButton", "Setting a custom background is not supported.");
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            materialButtonHelper2.backgroundOverwritten = true;
            materialButtonHelper2.materialButton.setSupportBackgroundTintList(materialButtonHelper2.backgroundTint);
            materialButtonHelper2.materialButton.setSupportBackgroundTintMode(materialButtonHelper2.backgroundTintMode);
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    /* JADX WARNING: type inference failed for: r1v23, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCornerRadius(@androidx.annotation.C0030Px int r7) {
        /*
            r6 = this;
            boolean r0 = r6.isUsingOriginalBackground()
            if (r0 == 0) goto L_0x00ae
            com.google.android.material.button.MaterialButtonHelper r0 = r6.materialButtonHelper
            int r1 = r0.cornerRadius
            if (r1 == r7) goto L_0x00ae
            r0.cornerRadius = r7
            boolean r1 = com.google.android.material.button.MaterialButtonHelper.IS_LOLLIPOP
            r2 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r1 == 0) goto L_0x0093
            android.graphics.drawable.GradientDrawable r1 = r0.backgroundDrawableLollipop
            if (r1 == 0) goto L_0x0093
            android.graphics.drawable.GradientDrawable r1 = r0.strokeDrawableLollipop
            if (r1 == 0) goto L_0x0093
            android.graphics.drawable.GradientDrawable r1 = r0.maskDrawableLollipop
            if (r1 == 0) goto L_0x0093
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r1 != r3) goto L_0x0081
            boolean r1 = com.google.android.material.button.MaterialButtonHelper.IS_LOLLIPOP
            r3 = 0
            r4 = 0
            if (r1 == 0) goto L_0x0050
            com.google.android.material.button.MaterialButton r1 = r0.materialButton
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            if (r1 == 0) goto L_0x0050
            com.google.android.material.button.MaterialButton r1 = r0.materialButton
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            android.graphics.drawable.RippleDrawable r1 = (android.graphics.drawable.RippleDrawable) r1
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            android.graphics.drawable.InsetDrawable r1 = (android.graphics.drawable.InsetDrawable) r1
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            android.graphics.drawable.LayerDrawable r1 = (android.graphics.drawable.LayerDrawable) r1
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            goto L_0x0051
        L_0x0050:
            r1 = r4
        L_0x0051:
            float r5 = (float) r7
            float r5 = r5 + r2
            r1.setCornerRadius(r5)
            boolean r1 = com.google.android.material.button.MaterialButtonHelper.IS_LOLLIPOP
            if (r1 == 0) goto L_0x007e
            com.google.android.material.button.MaterialButton r1 = r0.materialButton
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            if (r1 == 0) goto L_0x007e
            com.google.android.material.button.MaterialButton r1 = r0.materialButton
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            android.graphics.drawable.RippleDrawable r1 = (android.graphics.drawable.RippleDrawable) r1
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            android.graphics.drawable.InsetDrawable r1 = (android.graphics.drawable.InsetDrawable) r1
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            android.graphics.drawable.LayerDrawable r1 = (android.graphics.drawable.LayerDrawable) r1
            r3 = 1
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r4 = r1
            android.graphics.drawable.GradientDrawable r4 = (android.graphics.drawable.GradientDrawable) r4
        L_0x007e:
            r4.setCornerRadius(r5)
        L_0x0081:
            android.graphics.drawable.GradientDrawable r1 = r0.backgroundDrawableLollipop
            float r7 = (float) r7
            float r7 = r7 + r2
            r1.setCornerRadius(r7)
            android.graphics.drawable.GradientDrawable r1 = r0.strokeDrawableLollipop
            r1.setCornerRadius(r7)
            android.graphics.drawable.GradientDrawable r0 = r0.maskDrawableLollipop
            r0.setCornerRadius(r7)
            goto L_0x00ae
        L_0x0093:
            boolean r1 = com.google.android.material.button.MaterialButtonHelper.IS_LOLLIPOP
            if (r1 != 0) goto L_0x00ae
            android.graphics.drawable.GradientDrawable r1 = r0.colorableBackgroundDrawableCompat
            if (r1 == 0) goto L_0x00ae
            android.graphics.drawable.GradientDrawable r3 = r0.rippleDrawableCompat
            if (r3 == 0) goto L_0x00ae
            float r7 = (float) r7
            float r7 = r7 + r2
            r1.setCornerRadius(r7)
            android.graphics.drawable.GradientDrawable r1 = r0.rippleDrawableCompat
            r1.setCornerRadius(r7)
            com.google.android.material.button.MaterialButton r7 = r0.materialButton
            r7.invalidate()
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.setCornerRadius(int):void");
    }

    public void setCornerRadiusResource(@DimenRes int i) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon();
        }
    }

    public void setIconGravity(int i) {
        this.iconGravity = i;
    }

    public void setIconPadding(@C0030Px int i) {
        if (this.iconPadding != i) {
            this.iconPadding = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(@DrawableRes int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIconSize(@C0030Px int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.iconSize != i) {
            this.iconSize = i;
            updateIcon();
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon();
        }
    }

    public void setIconTintResource(@ColorRes int i) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.rippleColor != colorStateList) {
                materialButtonHelper2.rippleColor = colorStateList;
                if (MaterialButtonHelper.IS_LOLLIPOP && (materialButtonHelper2.materialButton.getBackground() instanceof RippleDrawable)) {
                    ((RippleDrawable) materialButtonHelper2.materialButton.getBackground()).setColor(colorStateList);
                } else if (!MaterialButtonHelper.IS_LOLLIPOP && (drawable = materialButtonHelper2.tintableRippleDrawableCompat) != null) {
                    DrawableCompat.setTintList(drawable, colorStateList);
                }
            }
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.strokeColor != colorStateList) {
                materialButtonHelper2.strokeColor = colorStateList;
                Paint paint = materialButtonHelper2.buttonStrokePaint;
                int i = 0;
                if (colorStateList != null) {
                    i = colorStateList.getColorForState(materialButtonHelper2.materialButton.getDrawableState(), 0);
                }
                paint.setColor(i);
                materialButtonHelper2.updateStroke();
            }
        }
    }

    public void setStrokeColorResource(@ColorRes int i) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setStrokeWidth(@C0030Px int i) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.strokeWidth != i) {
                materialButtonHelper2.strokeWidth = i;
                materialButtonHelper2.buttonStrokePaint.setStrokeWidth((float) i);
                materialButtonHelper2.updateStroke();
            }
        }
    }

    public void setStrokeWidthResource(@DimenRes int i) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.backgroundTint != colorStateList) {
                materialButtonHelper2.backgroundTint = colorStateList;
                if (MaterialButtonHelper.IS_LOLLIPOP) {
                    materialButtonHelper2.updateTintAndTintModeLollipop();
                    return;
                }
                Drawable drawable = materialButtonHelper2.tintableBackgroundDrawableCompat;
                if (drawable != null) {
                    DrawableCompat.setTintList(drawable, colorStateList);
                }
            }
        } else if (this.materialButtonHelper != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper2 = this.materialButtonHelper;
            if (materialButtonHelper2.backgroundTintMode != mode) {
                materialButtonHelper2.backgroundTintMode = mode;
                if (MaterialButtonHelper.IS_LOLLIPOP) {
                    materialButtonHelper2.updateTintAndTintModeLollipop();
                    return;
                }
                Drawable drawable = materialButtonHelper2.tintableBackgroundDrawableCompat;
                if (drawable != null && mode != null) {
                    DrawableCompat.setTintMode(drawable, mode);
                }
            }
        } else if (this.materialButtonHelper != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public final void updateIcon() {
        Drawable drawable = this.icon;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.icon = mutate;
            DrawableCompat.setTintList(mutate, this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                DrawableCompat.setTintMode(this.icon, mode);
            }
            int i = this.iconSize;
            if (i == 0) {
                i = this.icon.getIntrinsicWidth();
            }
            int i2 = this.iconSize;
            if (i2 == 0) {
                i2 = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i3 = this.iconLeft;
            drawable2.setBounds(i3, 0, i + i3, i2);
        }
        TextViewCompat.setCompoundDrawablesRelative(this, this.icon, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
