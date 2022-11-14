package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeEnforcement {
    public static final int[] APPCOMPAT_CHECK_ATTRS = {R$attr.colorPrimary};
    public static final int[] MATERIAL_CHECK_ATTRS = {R$attr.colorSecondary};

    public static void checkCompatibleTheme(Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ThemeEnforcement, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            checkTheme(context, MATERIAL_CHECK_ATTRS, "Theme.MaterialComponents");
        }
        checkTheme(context, APPCOMPAT_CHECK_ATTRS, "Theme.AppCompat");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r0.getResourceId(com.google.android.material.R$styleable.ThemeEnforcement_android_textAppearance, -1) != -1) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void checkTextAppearance(android.content.Context r4, android.util.AttributeSet r5, @androidx.annotation.StyleableRes int[] r6, @androidx.annotation.AttrRes int r7, @androidx.annotation.StyleRes int r8, @androidx.annotation.StyleableRes int... r9) {
        /*
            int[] r0 = com.google.android.material.R$styleable.ThemeEnforcement
            android.content.res.TypedArray r0 = r4.obtainStyledAttributes(r5, r0, r7, r8)
            int r1 = com.google.android.material.R$styleable.ThemeEnforcement_enforceTextAppearance
            r2 = 0
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 != 0) goto L_0x0013
            r0.recycle()
            return
        L_0x0013:
            r1 = -1
            if (r9 == 0) goto L_0x0035
            int r3 = r9.length
            if (r3 != 0) goto L_0x001a
            goto L_0x0035
        L_0x001a:
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r6, r7, r8)
            int r5 = r9.length
            r6 = 0
        L_0x0020:
            if (r6 >= r5) goto L_0x0031
            r7 = r9[r6]
            int r7 = r4.getResourceId(r7, r1)
            if (r7 != r1) goto L_0x002e
            r4.recycle()
            goto L_0x003e
        L_0x002e:
            int r6 = r6 + 1
            goto L_0x0020
        L_0x0031:
            r4.recycle()
            goto L_0x003d
        L_0x0035:
            int r4 = com.google.android.material.R$styleable.ThemeEnforcement_android_textAppearance
            int r4 = r0.getResourceId(r4, r1)
            if (r4 == r1) goto L_0x003e
        L_0x003d:
            r2 = 1
        L_0x003e:
            r0.recycle()
            if (r2 == 0) goto L_0x0044
            return
        L_0x0044:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant)."
            r4.<init>(r5)
            goto L_0x004d
        L_0x004c:
            throw r4
        L_0x004d:
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ThemeEnforcement.checkTextAppearance(android.content.Context, android.util.AttributeSet, int[], int, int, int[]):void");
    }

    public static void checkTheme(Context context, int[] iArr, String str) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (!hasValue) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline17("The style on this component requires your app theme to be ", str, " (or a descendant)."));
        }
    }

    public static TypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, @StyleableRes int[] iArr, @AttrRes int i, @StyleRes int i2, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i, i2);
        checkTextAppearance(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    public static TintTypedArray obtainTintedStyledAttributes(Context context, AttributeSet attributeSet, @StyleableRes int[] iArr, @AttrRes int i, @StyleRes int i2, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i, i2);
        checkTextAppearance(context, attributeSet, iArr, i, i2, iArr2);
        return TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, i2);
    }
}
