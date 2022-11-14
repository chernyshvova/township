package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.material.R$styleable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {
    @Nullable
    public Typeface font;
    @Nullable
    public final String fontFamily;
    @FontRes
    public final int fontFamilyResourceId;
    public boolean fontResolved = false;
    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    @Nullable
    public final ColorStateList textColor;
    @Nullable
    public final ColorStateList textColorHint;
    @Nullable
    public final ColorStateList textColorLink;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context context, @StyleRes int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        this.textColorHint = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        this.textColorLink = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int i2 = R$styleable.TextAppearance_fontFamily;
        i2 = !obtainStyledAttributes.hasValue(i2) ? R$styleable.TextAppearance_android_fontFamily : i2;
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(i2, 0);
        this.fontFamily = obtainStyledAttributes.getString(i2);
        obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public final void createFallbackTypeface() {
        if (this.font == null) {
            this.font = Typeface.create(this.fontFamily, this.textStyle);
        }
        if (this.font == null) {
            int i = this.typeface;
            if (i == 1) {
                this.font = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.font = Typeface.SERIF;
            } else if (i != 3) {
                this.font = Typeface.DEFAULT;
            } else {
                this.font = Typeface.MONOSPACE;
            }
            Typeface typeface2 = this.font;
            if (typeface2 != null) {
                this.font = Typeface.create(typeface2, this.textStyle);
            }
        }
    }

    public void updateDrawState(Context context, TextPaint textPaint, ResourcesCompat.FontCallback fontCallback) {
        updateMeasureState(context, textPaint, fontCallback);
        ColorStateList colorStateList = this.textColor;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f = this.shadowRadius;
        float f2 = this.shadowDx;
        float f3 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void updateMeasureState(Context context, final TextPaint textPaint, @Nullable final ResourcesCompat.FontCallback fontCallback) {
        if (this.fontResolved) {
            updateTextPaintMeasureState(textPaint, this.font);
        } else {
            createFallbackTypeface();
            if (context.isRestricted()) {
                this.fontResolved = true;
                updateTextPaintMeasureState(textPaint, this.font);
            } else {
                try {
                    ResourcesCompat.getFont(context, this.fontFamilyResourceId, new ResourcesCompat.FontCallback() {
                        public void onFontRetrievalFailed(int i) {
                            TextAppearance.this.createFallbackTypeface();
                            TextAppearance.this.fontResolved = true;
                            fontCallback.onFontRetrievalFailed(i);
                        }

                        public void onFontRetrieved(@NonNull Typeface typeface) {
                            TextAppearance textAppearance = TextAppearance.this;
                            textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                            TextAppearance.this.updateTextPaintMeasureState(textPaint, typeface);
                            TextAppearance.this.fontResolved = true;
                            fontCallback.onFontRetrieved(typeface);
                        }
                    }, (Handler) null);
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                } catch (Exception e) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error loading font ");
                    outline24.append(this.fontFamily);
                    Log.d("TextAppearance", outline24.toString(), e);
                }
            }
        }
        if (!this.fontResolved) {
            updateTextPaintMeasureState(textPaint, this.font);
        }
    }

    public void updateTextPaintMeasureState(@NonNull TextPaint textPaint, @NonNull Typeface typeface2) {
        textPaint.setTypeface(typeface2);
        int style = (typeface2.getStyle() ^ -1) & this.textStyle;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
    }
}
