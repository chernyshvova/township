package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.C0030Px;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$string;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import java.lang.ref.WeakReference;
import java.util.List;

public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate {
    public static final Rect EMPTY_BOUNDS = new Rect();
    public static final int[] SELECTED_STATE = {16842913};
    @Nullable
    public ChipDrawable chipDrawable;
    public boolean closeIconFocused;
    public boolean closeIconHovered;
    public boolean closeIconPressed;
    public boolean deferredCheckedValue;
    public int focusedVirtualView = Integer.MIN_VALUE;
    public final ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback() {
        public void onFontRetrievalFailed(int i) {
        }

        public void onFontRetrieved(@NonNull Typeface typeface) {
            Chip chip = Chip.this;
            chip.setText(chip.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    };
    @Nullable
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    @Nullable
    public View.OnClickListener onCloseIconClickListener;
    public final Rect rect = new Rect();
    public final RectF rectF = new RectF();
    @Nullable
    public RippleDrawable ripple;
    public final ChipTouchHelper touchHelper;

    public class ChipTouchHelper extends ExploreByTouchHelper {
        public ChipTouchHelper(Chip chip) {
            super(chip);
        }

        public int getVirtualViewAt(float f, float f2) {
            return (!Chip.access$100(Chip.this) || !Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? -1 : 0;
        }

        public void getVisibleVirtualViews(List<Integer> list) {
            if (Chip.access$100(Chip.this)) {
                list.add(0);
            }
        }

        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (i2 == 16 && i == 0) {
                return Chip.this.performCloseIconClick();
            }
            return false;
        }

        public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ChipDrawable chipDrawable = Chip.this.chipDrawable;
            accessibilityNodeInfoCompat.setCheckable(chipDrawable != null && chipDrawable.checkable);
            accessibilityNodeInfoCompat.setClassName(Chip.class.getName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.setText(text);
            } else {
                accessibilityNodeInfoCompat.setContentDescription(text);
            }
        }

        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence = "";
            if (Chip.access$100(Chip.this)) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = R$string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    accessibilityNodeInfoCompat.setContentDescription(context.getString(i2, objArr).trim());
                }
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.setContentDescription(charSequence);
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.EMPTY_BOUNDS);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e2, code lost:
        r5 = r13.getResourceId(r5, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            r10.<init>(r11, r12, r13)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r10.focusedVirtualView = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.rect = r0
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r10.rectF = r0
            com.google.android.material.chip.Chip$1 r0 = new com.google.android.material.chip.Chip$1
            r0.<init>()
            r10.fontCallback = r0
            r0 = 8388627(0x800013, float:1.175497E-38)
            r1 = 1
            if (r12 != 0) goto L_0x0023
            goto L_0x007e
        L_0x0023:
            java.lang.String r2 = "http://schemas.android.com/apk/res/android"
            java.lang.String r3 = "background"
            java.lang.String r3 = r12.getAttributeValue(r2, r3)
            if (r3 != 0) goto L_0x02a3
            java.lang.String r3 = "drawableLeft"
            java.lang.String r3 = r12.getAttributeValue(r2, r3)
            if (r3 != 0) goto L_0x029b
            java.lang.String r3 = "drawableStart"
            java.lang.String r3 = r12.getAttributeValue(r2, r3)
            if (r3 != 0) goto L_0x0293
            java.lang.String r3 = "drawableEnd"
            java.lang.String r3 = r12.getAttributeValue(r2, r3)
            java.lang.String r4 = "Please set end drawable using R.attr#closeIcon."
            if (r3 != 0) goto L_0x028d
            java.lang.String r3 = "drawableRight"
            java.lang.String r3 = r12.getAttributeValue(r2, r3)
            if (r3 != 0) goto L_0x0287
            java.lang.String r3 = "singleLine"
            boolean r3 = r12.getAttributeBooleanValue(r2, r3, r1)
            if (r3 == 0) goto L_0x027f
            java.lang.String r3 = "lines"
            int r3 = r12.getAttributeIntValue(r2, r3, r1)
            if (r3 != r1) goto L_0x027f
            java.lang.String r3 = "minLines"
            int r3 = r12.getAttributeIntValue(r2, r3, r1)
            if (r3 != r1) goto L_0x027f
            java.lang.String r3 = "maxLines"
            int r3 = r12.getAttributeIntValue(r2, r3, r1)
            if (r3 != r1) goto L_0x027f
            java.lang.String r3 = "gravity"
            int r2 = r12.getAttributeIntValue(r2, r3, r0)
            if (r2 == r0) goto L_0x007e
            java.lang.String r2 = "Chip"
            java.lang.String r3 = "Chip text must be vertically center and start aligned"
            android.util.Log.w(r2, r3)
        L_0x007e:
            int r8 = com.google.android.material.R$style.Widget_MaterialComponents_Chip_Action
            com.google.android.material.chip.ChipDrawable r2 = new com.google.android.material.chip.ChipDrawable
            r2.<init>(r11)
            android.content.Context r4 = r2.context
            int[] r6 = com.google.android.material.R$styleable.Chip
            r11 = 0
            int[] r9 = new int[r11]
            r5 = r12
            r7 = r13
            android.content.res.TypedArray r13 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r4, r5, r6, r7, r8, r9)
            android.content.Context r3 = r2.context
            int r4 = com.google.android.material.R$styleable.Chip_chipBackgroundColor
            android.content.res.ColorStateList r3 = com.android.billingclient.api.zzam.getColorStateList(r3, r13, r4)
            r2.setChipBackgroundColor(r3)
            int r3 = com.google.android.material.R$styleable.Chip_chipMinHeight
            r4 = 0
            float r3 = r13.getDimension(r3, r4)
            r2.setChipMinHeight(r3)
            int r3 = com.google.android.material.R$styleable.Chip_chipCornerRadius
            float r3 = r13.getDimension(r3, r4)
            r2.setChipCornerRadius(r3)
            android.content.Context r3 = r2.context
            int r5 = com.google.android.material.R$styleable.Chip_chipStrokeColor
            android.content.res.ColorStateList r3 = com.android.billingclient.api.zzam.getColorStateList(r3, r13, r5)
            r2.setChipStrokeColor(r3)
            int r3 = com.google.android.material.R$styleable.Chip_chipStrokeWidth
            float r3 = r13.getDimension(r3, r4)
            r2.setChipStrokeWidth(r3)
            android.content.Context r3 = r2.context
            int r5 = com.google.android.material.R$styleable.Chip_rippleColor
            android.content.res.ColorStateList r3 = com.android.billingclient.api.zzam.getColorStateList(r3, r13, r5)
            r2.setRippleColor(r3)
            int r3 = com.google.android.material.R$styleable.Chip_android_text
            java.lang.CharSequence r3 = r13.getText(r3)
            r2.setText(r3)
            android.content.Context r3 = r2.context
            int r5 = com.google.android.material.R$styleable.Chip_android_textAppearance
            boolean r6 = r13.hasValue(r5)
            if (r6 == 0) goto L_0x00ee
            int r5 = r13.getResourceId(r5, r11)
            if (r5 == 0) goto L_0x00ee
            com.google.android.material.resources.TextAppearance r6 = new com.google.android.material.resources.TextAppearance
            r6.<init>(r3, r5)
            goto L_0x00ef
        L_0x00ee:
            r6 = 0
        L_0x00ef:
            r2.setTextAppearance(r6)
            int r3 = com.google.android.material.R$styleable.Chip_android_ellipsize
            int r3 = r13.getInt(r3, r11)
            if (r3 == r1) goto L_0x010b
            r1 = 2
            if (r3 == r1) goto L_0x0106
            r1 = 3
            if (r3 == r1) goto L_0x0101
            goto L_0x010f
        L_0x0101:
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.END
            r2.truncateAt = r1
            goto L_0x010f
        L_0x0106:
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.MIDDLE
            r2.truncateAt = r1
            goto L_0x010f
        L_0x010b:
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.START
            r2.truncateAt = r1
        L_0x010f:
            int r1 = com.google.android.material.R$styleable.Chip_chipIconVisible
            boolean r1 = r13.getBoolean(r1, r11)
            r2.setChipIconVisible(r1)
            java.lang.String r1 = "http://schemas.android.com/apk/res-auto"
            if (r12 == 0) goto L_0x0135
            java.lang.String r3 = "chipIconEnabled"
            java.lang.String r3 = r12.getAttributeValue(r1, r3)
            if (r3 == 0) goto L_0x0135
            java.lang.String r3 = "chipIconVisible"
            java.lang.String r3 = r12.getAttributeValue(r1, r3)
            if (r3 != 0) goto L_0x0135
            int r3 = com.google.android.material.R$styleable.Chip_chipIconEnabled
            boolean r3 = r13.getBoolean(r3, r11)
            r2.setChipIconVisible(r3)
        L_0x0135:
            android.content.Context r3 = r2.context
            int r5 = com.google.android.material.R$styleable.Chip_chipIcon
            android.graphics.drawable.Drawable r3 = com.android.billingclient.api.zzam.getDrawable(r3, r13, r5)
            r2.setChipIcon(r3)
            android.content.Context r3 = r2.context
            int r5 = com.google.android.material.R$styleable.Chip_chipIconTint
            android.content.res.ColorStateList r3 = com.android.billingclient.api.zzam.getColorStateList(r3, r13, r5)
            r2.setChipIconTint(r3)
            int r3 = com.google.android.material.R$styleable.Chip_chipIconSize
            float r3 = r13.getDimension(r3, r4)
            r2.setChipIconSize(r3)
            int r3 = com.google.android.material.R$styleable.Chip_closeIconVisible
            boolean r3 = r13.getBoolean(r3, r11)
            r2.setCloseIconVisible(r3)
            if (r12 == 0) goto L_0x0178
            java.lang.String r3 = "closeIconEnabled"
            java.lang.String r3 = r12.getAttributeValue(r1, r3)
            if (r3 == 0) goto L_0x0178
            java.lang.String r3 = "closeIconVisible"
            java.lang.String r3 = r12.getAttributeValue(r1, r3)
            if (r3 != 0) goto L_0x0178
            int r3 = com.google.android.material.R$styleable.Chip_closeIconEnabled
            boolean r3 = r13.getBoolean(r3, r11)
            r2.setCloseIconVisible(r3)
        L_0x0178:
            android.content.Context r3 = r2.context
            int r5 = com.google.android.material.R$styleable.Chip_closeIcon
            android.graphics.drawable.Drawable r3 = com.android.billingclient.api.zzam.getDrawable(r3, r13, r5)
            r2.setCloseIcon(r3)
            android.content.Context r3 = r2.context
            int r5 = com.google.android.material.R$styleable.Chip_closeIconTint
            android.content.res.ColorStateList r3 = com.android.billingclient.api.zzam.getColorStateList(r3, r13, r5)
            r2.setCloseIconTint(r3)
            int r3 = com.google.android.material.R$styleable.Chip_closeIconSize
            float r3 = r13.getDimension(r3, r4)
            r2.setCloseIconSize(r3)
            int r3 = com.google.android.material.R$styleable.Chip_android_checkable
            boolean r3 = r13.getBoolean(r3, r11)
            r2.setCheckable(r3)
            int r3 = com.google.android.material.R$styleable.Chip_checkedIconVisible
            boolean r3 = r13.getBoolean(r3, r11)
            r2.setCheckedIconVisible(r3)
            if (r12 == 0) goto L_0x01c4
            java.lang.String r3 = "checkedIconEnabled"
            java.lang.String r3 = r12.getAttributeValue(r1, r3)
            if (r3 == 0) goto L_0x01c4
            java.lang.String r3 = "checkedIconVisible"
            java.lang.String r12 = r12.getAttributeValue(r1, r3)
            if (r12 != 0) goto L_0x01c4
            int r12 = com.google.android.material.R$styleable.Chip_checkedIconEnabled
            boolean r12 = r13.getBoolean(r12, r11)
            r2.setCheckedIconVisible(r12)
        L_0x01c4:
            android.content.Context r12 = r2.context
            int r1 = com.google.android.material.R$styleable.Chip_checkedIcon
            android.graphics.drawable.Drawable r12 = com.android.billingclient.api.zzam.getDrawable(r12, r13, r1)
            r2.setCheckedIcon(r12)
            android.content.Context r12 = r2.context
            int r1 = com.google.android.material.R$styleable.Chip_showMotionSpec
            com.google.android.material.animation.MotionSpec r12 = com.google.android.material.animation.MotionSpec.createFromAttribute(r12, r13, r1)
            r2.showMotionSpec = r12
            android.content.Context r12 = r2.context
            int r1 = com.google.android.material.R$styleable.Chip_hideMotionSpec
            com.google.android.material.animation.MotionSpec r12 = com.google.android.material.animation.MotionSpec.createFromAttribute(r12, r13, r1)
            r2.hideMotionSpec = r12
            int r12 = com.google.android.material.R$styleable.Chip_chipStartPadding
            float r12 = r13.getDimension(r12, r4)
            r2.setChipStartPadding(r12)
            int r12 = com.google.android.material.R$styleable.Chip_iconStartPadding
            float r12 = r13.getDimension(r12, r4)
            r2.setIconStartPadding(r12)
            int r12 = com.google.android.material.R$styleable.Chip_iconEndPadding
            float r12 = r13.getDimension(r12, r4)
            r2.setIconEndPadding(r12)
            int r12 = com.google.android.material.R$styleable.Chip_textStartPadding
            float r12 = r13.getDimension(r12, r4)
            r2.setTextStartPadding(r12)
            int r12 = com.google.android.material.R$styleable.Chip_textEndPadding
            float r12 = r13.getDimension(r12, r4)
            r2.setTextEndPadding(r12)
            int r12 = com.google.android.material.R$styleable.Chip_closeIconStartPadding
            float r12 = r13.getDimension(r12, r4)
            r2.setCloseIconStartPadding(r12)
            int r12 = com.google.android.material.R$styleable.Chip_closeIconEndPadding
            float r12 = r13.getDimension(r12, r4)
            r2.setCloseIconEndPadding(r12)
            int r12 = com.google.android.material.R$styleable.Chip_chipEndPadding
            float r12 = r13.getDimension(r12, r4)
            r2.setChipEndPadding(r12)
            int r12 = com.google.android.material.R$styleable.Chip_android_maxWidth
            r1 = 2147483647(0x7fffffff, float:NaN)
            int r12 = r13.getDimensionPixelSize(r12, r1)
            r2.maxWidth = r12
            r13.recycle()
            r10.setChipDrawable(r2)
            com.google.android.material.chip.Chip$ChipTouchHelper r12 = new com.google.android.material.chip.Chip$ChipTouchHelper
            r12.<init>(r10)
            r10.touchHelper = r12
            androidx.core.view.ViewCompat.setAccessibilityDelegate(r10, r12)
            int r12 = android.os.Build.VERSION.SDK_INT
            r13 = 21
            if (r12 < r13) goto L_0x0254
            com.google.android.material.chip.Chip$2 r12 = new com.google.android.material.chip.Chip$2
            r12.<init>()
            r10.setOutlineProvider(r12)
        L_0x0254:
            boolean r12 = r10.deferredCheckedValue
            r10.setChecked(r12)
            r2.shouldDrawText = r11
            java.lang.CharSequence r12 = r2.rawText
            r10.setText(r12)
            android.text.TextUtils$TruncateAt r12 = r2.truncateAt
            r10.setEllipsize(r12)
            r10.setIncludeFontPadding(r11)
            com.google.android.material.resources.TextAppearance r11 = r10.getTextAppearance()
            if (r11 == 0) goto L_0x0275
            com.google.android.material.resources.TextAppearance r11 = r10.getTextAppearance()
            r10.updateTextPaintDrawState(r11)
        L_0x0275:
            r10.setSingleLine()
            r10.setGravity(r0)
            r10.updatePaddingInternal()
            return
        L_0x027f:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.String r12 = "Chip does not support multi-line text"
            r11.<init>(r12)
            throw r11
        L_0x0287:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            r11.<init>(r4)
            throw r11
        L_0x028d:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            r11.<init>(r4)
            throw r11
        L_0x0293:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.String r12 = "Please set start drawable using R.attr#chipIcon."
            r11.<init>(r12)
            throw r11
        L_0x029b:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.String r12 = "Please set left drawable using R.attr#chipIcon."
            r11.<init>(r12)
            throw r11
        L_0x02a3:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.String r12 = "Do not set the background; Chip manages its own background drawable."
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public static boolean access$100(Chip chip) {
        ChipDrawable chipDrawable2 = chip.chipDrawable;
        return (chipDrawable2 == null || chipDrawable2.getCloseIcon() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if ((chipDrawable2 == null || chipDrawable2.getCloseIcon() == null) ? false : true) {
            ChipDrawable chipDrawable3 = this.chipDrawable;
            chipDrawable3.calculateCloseIconTouchBounds(chipDrawable3.getBounds(), this.rectF);
        }
        return this.rectF;
    }

    /* access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.rect;
    }

    @Nullable
    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.textAppearance;
        }
        return null;
    }

    private void setCloseIconFocused(boolean z) {
        if (this.closeIconFocused != z) {
            this.closeIconFocused = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.closeIconHovered != z) {
            this.closeIconHovered = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.closeIconPressed != z) {
            this.closeIconPressed = z;
            refreshDrawableState();
        }
    }

    private void setFocusedVirtualView(int i) {
        int i2 = this.focusedVirtualView;
        if (i2 != i) {
            if (i2 == 0) {
                setCloseIconFocused(false);
            }
            this.focusedVirtualView = i;
            if (i == 0) {
                setCloseIconFocused(true);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchHoverEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            java.lang.Class<androidx.customview.widget.ExploreByTouchHelper> r0 = androidx.customview.widget.ExploreByTouchHelper.class
            java.lang.String r1 = "Unable to send Accessibility Exit event"
            java.lang.String r2 = "Chip"
            int r3 = r10.getAction()
            r4 = 10
            r5 = 1
            r6 = 0
            if (r3 != r4) goto L_0x005a
            java.lang.String r3 = "mHoveredVirtualViewId"
            java.lang.reflect.Field r3 = r0.getDeclaredField(r3)     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            r3.setAccessible(r5)     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            com.google.android.material.chip.Chip$ChipTouchHelper r4 = r9.touchHelper     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            int r3 = r3.intValue()     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x005a
            java.lang.String r3 = "updateHoveredVirtualView"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            r7[r6] = r8     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r3, r7)     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            r0.setAccessible(r5)     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            com.google.android.material.chip.Chip$ChipTouchHelper r3 = r9.touchHelper     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            r7[r6] = r4     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            r0.invoke(r3, r7)     // Catch:{ NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0051, InvocationTargetException -> 0x004c, NoSuchFieldException -> 0x0047 }
            r0 = 1
            goto L_0x005b
        L_0x0047:
            r0 = move-exception
            android.util.Log.e(r2, r1, r0)
            goto L_0x005a
        L_0x004c:
            r0 = move-exception
            android.util.Log.e(r2, r1, r0)
            goto L_0x005a
        L_0x0051:
            r0 = move-exception
            android.util.Log.e(r2, r1, r0)
            goto L_0x005a
        L_0x0056:
            r0 = move-exception
            android.util.Log.e(r2, r1, r0)
        L_0x005a:
            r0 = 0
        L_0x005b:
            if (r0 != 0) goto L_0x006d
            com.google.android.material.chip.Chip$ChipTouchHelper r0 = r9.touchHelper
            boolean r0 = r0.dispatchHoverEvent(r10)
            if (r0 != 0) goto L_0x006d
            boolean r10 = super.dispatchHoverEvent(r10)
            if (r10 == 0) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            r5 = 0
        L_0x006d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.touchHelper.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable chipDrawable2 = this.chipDrawable;
        int i = 0;
        if (chipDrawable2 != null && ChipDrawable.isStateful(chipDrawable2.closeIcon)) {
            ChipDrawable chipDrawable3 = this.chipDrawable;
            int isEnabled = isEnabled();
            if (this.closeIconFocused) {
                isEnabled++;
            }
            if (this.closeIconHovered) {
                isEnabled++;
            }
            if (this.closeIconPressed) {
                isEnabled++;
            }
            if (isChecked()) {
                isEnabled++;
            }
            int[] iArr = new int[isEnabled];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.closeIconFocused) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.closeIconHovered) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.closeIconPressed) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            i = chipDrawable3.setCloseIconState(iArr);
        }
        if (i != 0) {
            invalidate();
        }
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.checkedIcon;
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipBackgroundColor;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipCornerRadius;
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipEndPadding;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipIcon();
        }
        return null;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipIconSize;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipIconTint;
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipMinHeight;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipStartPadding;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipStrokeColor;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipStrokeWidth;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCloseIcon();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconContentDescription;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconEndPadding;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconSize;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconStartPadding;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconTint;
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.truncateAt;
        }
        return null;
    }

    public void getFocusedRect(Rect rect2) {
        if (this.focusedVirtualView == 0) {
            rect2.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect2);
        }
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.hideMotionSpec;
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.iconEndPadding;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.iconStartPadding;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.rippleColor;
        }
        return null;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.showMotionSpec;
        }
        return null;
    }

    public CharSequence getText() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null ? chipDrawable2.rawText : "";
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.textEndPadding;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.textStartPadding;
        }
        return 0.0f;
    }

    public final boolean moveFocus(boolean z) {
        if (this.focusedVirtualView == Integer.MIN_VALUE) {
            setFocusedVirtualView(-1);
        }
        if (z) {
            if (this.focusedVirtualView == -1) {
                setFocusedVirtualView(0);
                return true;
            }
        } else if (this.focusedVirtualView == 0) {
            setFocusedVirtualView(-1);
            return true;
        }
        return false;
    }

    public void onChipDrawableSizeChange() {
        updatePaddingInternal();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, SELECTED_STATE);
        }
        return onCreateDrawableState;
    }

    public void onDraw(Canvas canvas) {
        ChipDrawable chipDrawable2;
        if (TextUtils.isEmpty(getText()) || (chipDrawable2 = this.chipDrawable) == null || chipDrawable2.shouldDrawText) {
            super.onDraw(canvas);
            return;
        }
        int save = canvas.save();
        ChipDrawable chipDrawable3 = this.chipDrawable;
        float textStartPadding = getTextStartPadding() + chipDrawable3.calculateChipIconWidth() + getChipStartPadding();
        if (ViewCompat.getLayoutDirection(this) != 0) {
            textStartPadding = -textStartPadding;
        }
        canvas.translate(textStartPadding, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void onFocusChanged(boolean z, int i, Rect rect2) {
        if (z) {
            setFocusedVirtualView(-1);
        } else {
            setFocusedVirtualView(Integer.MIN_VALUE);
        }
        invalidate();
        super.onFocusChanged(z, i, rect2);
        this.touchHelper.onFocusChanged(z, i, rect2);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
            r6 = this;
            int r0 = r8.getKeyCode()
            r1 = 61
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0041
            r1 = 66
            if (r0 == r1) goto L_0x0031
            switch(r0) {
                case 21: goto L_0x0022;
                case 22: goto L_0x0012;
                case 23: goto L_0x0031;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x006d
        L_0x0012:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006d
            boolean r0 = com.android.billingclient.api.zzam.isLayoutRtl(r6)
            r0 = r0 ^ r3
            boolean r2 = r6.moveFocus(r0)
            goto L_0x006d
        L_0x0022:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006d
            boolean r0 = com.android.billingclient.api.zzam.isLayoutRtl(r6)
            boolean r2 = r6.moveFocus(r0)
            goto L_0x006d
        L_0x0031:
            int r0 = r6.focusedVirtualView
            r1 = -1
            if (r0 == r1) goto L_0x003d
            if (r0 == 0) goto L_0x0039
            goto L_0x006d
        L_0x0039:
            r6.performCloseIconClick()
            return r3
        L_0x003d:
            r6.performClick()
            return r3
        L_0x0041:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x0049
            r0 = 2
            goto L_0x0052
        L_0x0049:
            boolean r0 = r8.hasModifiers(r3)
            if (r0 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            if (r0 == 0) goto L_0x006d
            android.view.ViewParent r1 = r6.getParent()
            r4 = r6
        L_0x0059:
            android.view.View r4 = r4.focusSearch(r0)
            if (r4 == 0) goto L_0x0067
            if (r4 == r6) goto L_0x0067
            android.view.ViewParent r5 = r4.getParent()
            if (r5 == r1) goto L_0x0059
        L_0x0067:
            if (r4 == 0) goto L_0x006d
            r4.requestFocus()
            return r3
        L_0x006d:
            if (r2 == 0) goto L_0x0073
            r6.invalidate()
            return r3
        L_0x0073:
            boolean r7 = super.onKeyDown(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 == r3) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0034
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x003e
            r5.setCloseIconPressed(r2)
            goto L_0x003e
        L_0x002b:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L_0x0034
            r5.performCloseIconClick()
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r5.setCloseIconPressed(r2)
            goto L_0x0041
        L_0x0039:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r3)
        L_0x003e:
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r0 != 0) goto L_0x0049
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
        L_0x0049:
            r2 = 1
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @CallSuper
    public boolean performCloseIconClick() {
        boolean z;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.onCloseIconClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        } else {
            z = false;
        }
        this.touchHelper.sendEventForVirtualView(0, 1);
        return z;
    }

    public void setBackground(Drawable drawable) {
        if (drawable == this.chipDrawable || drawable == this.ripple) {
            super.setBackground(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }

    public void setBackgroundColor(int i) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == this.chipDrawable || drawable == this.ripple) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
    }

    public void setBackgroundResource(int i) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckable(z);
        }
    }

    public void setCheckableResource(@BoolRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckable(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null) {
            this.deferredCheckedValue = z;
        } else if (chipDrawable2.checkable) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.onCheckedChangeListenerInternal) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIcon(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIcon(AppCompatResources.getDrawable(chipDrawable2.context, i));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconVisible(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipBackgroundColor != colorStateList) {
            chipDrawable2.chipBackgroundColor = colorStateList;
            chipDrawable2.onStateChange(chipDrawable2.getState());
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipBackgroundColor(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setChipCornerRadius(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipCornerRadius != f) {
            chipDrawable2.chipCornerRadius = f;
            chipDrawable2.invalidateSelf();
        }
    }

    public void setChipCornerRadiusResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipCornerRadius(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(@NonNull ChipDrawable chipDrawable2) {
        ChipDrawable chipDrawable3 = this.chipDrawable;
        if (chipDrawable3 != chipDrawable2) {
            if (chipDrawable3 != null) {
                chipDrawable3.delegate = new WeakReference<>((Object) null);
            }
            this.chipDrawable = chipDrawable2;
            if (chipDrawable2 != null) {
                chipDrawable2.delegate = new WeakReference<>(this);
                if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                    this.ripple = new RippleDrawable(RippleUtils.convertToRippleDrawableColor(this.chipDrawable.rippleColor), this.chipDrawable, (Drawable) null);
                    this.chipDrawable.setUseCompatRipple(false);
                    ViewCompat.setBackground(this, this.ripple);
                    return;
                }
                this.chipDrawable.setUseCompatRipple(true);
                ViewCompat.setBackground(this, this.chipDrawable);
                return;
            }
            throw null;
        }
    }

    public void setChipEndPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipEndPadding != f) {
            chipDrawable2.chipEndPadding = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIcon(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(@DrawableRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIcon(AppCompatResources.getDrawable(chipDrawable2.context, i));
        }
    }

    public void setChipIconSize(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconSize(f);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconSize(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconTint(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconTint(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setChipIconVisible(@BoolRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconVisible(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipMinHeight != f) {
            chipDrawable2.chipMinHeight = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setChipMinHeightResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipMinHeight(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipStartPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipStartPadding != f) {
            chipDrawable2.chipStartPadding = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipStrokeColor != colorStateList) {
            chipDrawable2.chipStrokeColor = colorStateList;
            chipDrawable2.onStateChange(chipDrawable2.getState());
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeColor(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeWidth(f);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeWidth(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIcon(drawable);
        }
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.closeIconContentDescription != charSequence) {
            chipDrawable2.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(charSequence);
            chipDrawable2.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconEndPadding(f);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(@DrawableRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIcon(AppCompatResources.getDrawable(chipDrawable2.context, i));
        }
    }

    public void setCloseIconSize(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconSize(f);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconSize(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconStartPadding(f);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconTint(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconTint(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setCloseIconVisible(@BoolRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconVisible(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.chipDrawable != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                ChipDrawable chipDrawable2 = this.chipDrawable;
                if (chipDrawable2 != null) {
                    chipDrawable2.truncateAt = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.hideMotionSpec = motionSpec;
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.hideMotionSpec = MotionSpec.createFromResource(chipDrawable2.context, i);
        }
    }

    public void setIconEndPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconEndPadding(f);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconStartPadding(f);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(@C0030Px int i) {
        super.setMaxWidth(i);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.maxWidth = i;
        }
    }

    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListenerInternal = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.onCloseIconClickListener = onClickListener;
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setRippleColor(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.showMotionSpec = motionSpec;
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.showMotionSpec = MotionSpec.createFromResource(chipDrawable2.context, i);
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.chipDrawable != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            CharSequence unicodeWrap = BidiFormatter.getInstance().unicodeWrap(charSequence);
            if (this.chipDrawable.shouldDrawText) {
                unicodeWrap = null;
            }
            super.setText(unicodeWrap, bufferType);
            ChipDrawable chipDrawable2 = this.chipDrawable;
            if (chipDrawable2 != null) {
                chipDrawable2.setText(charSequence);
            }
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearance(textAppearance);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().updateMeasureState(getContext(), getPaint(), this.fontCallback);
            updateTextPaintDrawState(textAppearance);
        }
    }

    public void setTextAppearanceResource(@StyleRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearance(new TextAppearance(chipDrawable2.context, i));
        }
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.textEndPadding != f) {
            chipDrawable2.textEndPadding = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setTextStartPadding(float f) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.textStartPadding != f) {
            chipDrawable2.textStartPadding = f;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (isChecked() != false) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updatePaddingInternal() {
        /*
            r4 = this;
            java.lang.CharSequence r0 = r4.getText()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x006f
            com.google.android.material.chip.ChipDrawable r0 = r4.chipDrawable
            if (r0 != 0) goto L_0x000f
            goto L_0x006f
        L_0x000f:
            float r1 = r0.chipStartPadding
            float r2 = r0.chipEndPadding
            float r1 = r1 + r2
            float r2 = r0.textStartPadding
            float r1 = r1 + r2
            float r2 = r0.textEndPadding
            float r1 = r1 + r2
            boolean r2 = r0.chipIconVisible
            if (r2 == 0) goto L_0x0024
            android.graphics.drawable.Drawable r0 = r0.getChipIcon()
            if (r0 != 0) goto L_0x0034
        L_0x0024:
            com.google.android.material.chip.ChipDrawable r0 = r4.chipDrawable
            android.graphics.drawable.Drawable r2 = r0.checkedIcon
            if (r2 == 0) goto L_0x003f
            boolean r0 = r0.checkedIconVisible
            if (r0 == 0) goto L_0x003f
            boolean r0 = r4.isChecked()
            if (r0 == 0) goto L_0x003f
        L_0x0034:
            com.google.android.material.chip.ChipDrawable r0 = r4.chipDrawable
            float r2 = r0.iconStartPadding
            float r3 = r0.iconEndPadding
            float r2 = r2 + r3
            float r0 = r0.chipIconSize
            float r2 = r2 + r0
            float r1 = r1 + r2
        L_0x003f:
            com.google.android.material.chip.ChipDrawable r0 = r4.chipDrawable
            boolean r2 = r0.closeIconVisible
            if (r2 == 0) goto L_0x0056
            android.graphics.drawable.Drawable r0 = r0.getCloseIcon()
            if (r0 == 0) goto L_0x0056
            com.google.android.material.chip.ChipDrawable r0 = r4.chipDrawable
            float r2 = r0.closeIconStartPadding
            float r3 = r0.closeIconEndPadding
            float r2 = r2 + r3
            float r0 = r0.closeIconSize
            float r2 = r2 + r0
            float r1 = r1 + r2
        L_0x0056:
            int r0 = androidx.core.view.ViewCompat.getPaddingEnd(r4)
            float r0 = (float) r0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x006f
            int r0 = androidx.core.view.ViewCompat.getPaddingStart(r4)
            int r2 = r4.getPaddingTop()
            int r1 = (int) r1
            int r3 = r4.getPaddingBottom()
            androidx.core.view.ViewCompat.setPaddingRelative(r4, r0, r2, r1, r3)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.updatePaddingInternal():void");
    }

    public final void updateTextPaintDrawState(TextAppearance textAppearance) {
        TextPaint paint = getPaint();
        paint.drawableState = this.chipDrawable.getState();
        textAppearance.updateDrawState(getContext(), paint, this.fontCallback);
    }

    public void setCheckedIconVisible(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconVisible(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconVisible(z);
        }
    }

    public void setCloseIconVisible(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconVisible(z);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearance(new TextAppearance(chipDrawable2.context, i));
        }
        if (getTextAppearance() != null) {
            getTextAppearance().updateMeasureState(context, getPaint(), this.fontCallback);
            updateTextPaintDrawState(getTextAppearance());
        }
    }

    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearance(new TextAppearance(chipDrawable2.context, i));
        }
        if (getTextAppearance() != null) {
            getTextAppearance().updateMeasureState(getContext(), getPaint(), this.fontCallback);
            updateTextPaintDrawState(getTextAppearance());
        }
    }
}
