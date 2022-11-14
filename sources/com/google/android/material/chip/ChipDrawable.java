package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.android.billingclient.api.zzam;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ChipDrawable extends Drawable implements TintAwareDrawable, Drawable.Callback {
    public static final int[] DEFAULT_STATE = {16842910};
    public int alpha = 255;
    public boolean checkable;
    @Nullable
    public Drawable checkedIcon;
    public boolean checkedIconVisible;
    @Nullable
    public ColorStateList chipBackgroundColor;
    public float chipCornerRadius;
    public float chipEndPadding;
    @Nullable
    public Drawable chipIcon;
    public float chipIconSize;
    @Nullable
    public ColorStateList chipIconTint;
    public boolean chipIconVisible;
    public float chipMinHeight;
    public final Paint chipPaint = new Paint(1);
    public float chipStartPadding;
    @Nullable
    public ColorStateList chipStrokeColor;
    public float chipStrokeWidth;
    @Nullable
    public Drawable closeIcon;
    @Nullable
    public CharSequence closeIconContentDescription;
    public float closeIconEndPadding;
    public float closeIconSize;
    public float closeIconStartPadding;
    public int[] closeIconStateSet;
    @Nullable
    public ColorStateList closeIconTint;
    public boolean closeIconVisible;
    @Nullable
    public ColorFilter colorFilter;
    @Nullable
    public ColorStateList compatRippleColor;
    public final Context context;
    public boolean currentChecked;
    @ColorInt
    public int currentChipBackgroundColor;
    @ColorInt
    public int currentChipStrokeColor;
    @ColorInt
    public int currentCompatRippleColor;
    @ColorInt
    public int currentTextColor;
    @ColorInt
    public int currentTint;
    @Nullable
    public final Paint debugPaint;
    public WeakReference<Delegate> delegate;
    public final ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback() {
        public void onFontRetrievalFailed(int i) {
        }

        public void onFontRetrieved(@NonNull Typeface typeface) {
            ChipDrawable chipDrawable = ChipDrawable.this;
            chipDrawable.textWidthDirty = true;
            chipDrawable.onSizeChange();
            ChipDrawable.this.invalidateSelf();
        }
    };
    public final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    @Nullable
    public MotionSpec hideMotionSpec;
    public float iconEndPadding;
    public float iconStartPadding;
    public int maxWidth;
    public final PointF pointF = new PointF();
    @Nullable
    public CharSequence rawText;
    public final RectF rectF = new RectF();
    @Nullable
    public ColorStateList rippleColor;
    public boolean shouldDrawText;
    @Nullable
    public MotionSpec showMotionSpec;
    @Nullable
    public TextAppearance textAppearance;
    public float textEndPadding;
    public final TextPaint textPaint = new TextPaint(1);
    public float textStartPadding;
    public float textWidth;
    public boolean textWidthDirty;
    @Nullable
    public ColorStateList tint;
    @Nullable
    public PorterDuffColorFilter tintFilter;
    @Nullable
    public PorterDuff.Mode tintMode = PorterDuff.Mode.SRC_IN;
    public TextUtils.TruncateAt truncateAt;
    @Nullable
    public CharSequence unicodeWrappedText;
    public boolean useCompatRipple;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    public ChipDrawable(Context context2) {
        Paint paint = null;
        this.delegate = new WeakReference<>(paint);
        this.textWidthDirty = true;
        this.context = context2;
        this.rawText = "";
        this.textPaint.density = context2.getResources().getDisplayMetrics().density;
        this.debugPaint = paint;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(DEFAULT_STATE);
        setCloseIconState(DEFAULT_STATE);
        this.shouldDrawText = true;
    }

    public final void applyChildDrawable(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.closeIcon) {
                if (drawable.isStateful()) {
                    drawable.setState(this.closeIconStateSet);
                }
                DrawableCompat.setTintList(drawable, this.closeIconTint);
            } else if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    public final void calculateChipIconBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f = this.chipStartPadding + this.iconStartPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = ((float) rect.left) + f;
                rectF2.left = f2;
                rectF2.right = f2 + this.chipIconSize;
            } else {
                float f3 = ((float) rect.right) - f;
                rectF2.right = f3;
                rectF2.left = f3 - this.chipIconSize;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.chipIconSize;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF2.top = f5;
            rectF2.bottom = f5 + f4;
        }
    }

    public float calculateChipIconWidth() {
        if (showsChipIcon() || showsCheckedIcon()) {
            return this.iconStartPadding + this.chipIconSize + this.iconEndPadding;
        }
        return 0.0f;
    }

    public final void calculateCloseIconBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = ((float) rect.right) - f;
                rectF2.right = f2;
                rectF2.left = f2 - this.closeIconSize;
            } else {
                float f3 = ((float) rect.left) + f;
                rectF2.left = f3;
                rectF2.right = f3 + this.closeIconSize;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.closeIconSize;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF2.top = f5;
            rectF2.bottom = f5 + f4;
        }
    }

    public final void calculateCloseIconTouchBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = (float) rect.right;
                rectF2.right = f2;
                rectF2.left = f2 - f;
            } else {
                int i = rect.left;
                rectF2.left = (float) i;
                rectF2.right = ((float) i) + f;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    public final float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    public void draw(@NonNull Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && (i = this.alpha) != 0) {
            if (i < 255) {
                float f = (float) bounds.left;
                float f2 = (float) bounds.top;
                float f3 = (float) bounds.right;
                float f4 = (float) bounds.bottom;
                if (Build.VERSION.SDK_INT > 21) {
                    i4 = canvas.saveLayerAlpha(f, f2, f3, f4, i);
                } else {
                    i4 = canvas.saveLayerAlpha(f, f2, f3, f4, i, 31);
                }
                i2 = i4;
            } else {
                i2 = 0;
            }
            this.chipPaint.setColor(this.currentChipBackgroundColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            Paint paint = this.chipPaint;
            ColorFilter colorFilter2 = this.colorFilter;
            if (colorFilter2 == null) {
                colorFilter2 = this.tintFilter;
            }
            paint.setColorFilter(colorFilter2);
            this.rectF.set(bounds);
            RectF rectF2 = this.rectF;
            float f5 = this.chipCornerRadius;
            canvas2.drawRoundRect(rectF2, f5, f5, this.chipPaint);
            if (this.chipStrokeWidth > 0.0f) {
                this.chipPaint.setColor(this.currentChipStrokeColor);
                this.chipPaint.setStyle(Paint.Style.STROKE);
                Paint paint2 = this.chipPaint;
                ColorFilter colorFilter3 = this.colorFilter;
                if (colorFilter3 == null) {
                    colorFilter3 = this.tintFilter;
                }
                paint2.setColorFilter(colorFilter3);
                RectF rectF3 = this.rectF;
                float f6 = this.chipStrokeWidth / 2.0f;
                rectF3.set(((float) bounds.left) + f6, ((float) bounds.top) + f6, ((float) bounds.right) - f6, ((float) bounds.bottom) - f6);
                float f7 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
                canvas2.drawRoundRect(this.rectF, f7, f7, this.chipPaint);
            }
            this.chipPaint.setColor(this.currentCompatRippleColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.rectF.set(bounds);
            RectF rectF4 = this.rectF;
            float f8 = this.chipCornerRadius;
            canvas2.drawRoundRect(rectF4, f8, f8, this.chipPaint);
            if (showsChipIcon()) {
                calculateChipIconBounds(bounds, this.rectF);
                RectF rectF5 = this.rectF;
                float f9 = rectF5.left;
                float f10 = rectF5.top;
                canvas2.translate(f9, f10);
                this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
                this.chipIcon.draw(canvas2);
                canvas2.translate(-f9, -f10);
            }
            if (showsCheckedIcon()) {
                calculateChipIconBounds(bounds, this.rectF);
                RectF rectF6 = this.rectF;
                float f11 = rectF6.left;
                float f12 = rectF6.top;
                canvas2.translate(f11, f12);
                this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
                this.checkedIcon.draw(canvas2);
                canvas2.translate(-f11, -f12);
            }
            if (this.shouldDrawText && this.unicodeWrappedText != null) {
                PointF pointF2 = this.pointF;
                pointF2.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.unicodeWrappedText != null) {
                    float calculateChipIconWidth = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                    if (DrawableCompat.getLayoutDirection(this) == 0) {
                        pointF2.x = ((float) bounds.left) + calculateChipIconWidth;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF2.x = ((float) bounds.right) - calculateChipIconWidth;
                        align = Paint.Align.RIGHT;
                    }
                    this.textPaint.getFontMetrics(this.fontMetrics);
                    Paint.FontMetrics fontMetrics2 = this.fontMetrics;
                    pointF2.y = ((float) bounds.centerY()) - ((fontMetrics2.descent + fontMetrics2.ascent) / 2.0f);
                }
                RectF rectF7 = this.rectF;
                rectF7.setEmpty();
                if (this.unicodeWrappedText != null) {
                    float calculateChipIconWidth2 = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                    float calculateCloseIconWidth = calculateCloseIconWidth() + this.chipEndPadding + this.textEndPadding;
                    if (DrawableCompat.getLayoutDirection(this) == 0) {
                        rectF7.left = ((float) bounds.left) + calculateChipIconWidth2;
                        rectF7.right = ((float) bounds.right) - calculateCloseIconWidth;
                    } else {
                        rectF7.left = ((float) bounds.left) + calculateCloseIconWidth;
                        rectF7.right = ((float) bounds.right) - calculateChipIconWidth2;
                    }
                    rectF7.top = (float) bounds.top;
                    rectF7.bottom = (float) bounds.bottom;
                }
                if (this.textAppearance != null) {
                    this.textPaint.drawableState = getState();
                    this.textAppearance.updateDrawState(this.context, this.textPaint, this.fontCallback);
                }
                this.textPaint.setTextAlign(align);
                boolean z = Math.round(getTextWidth()) > Math.round(this.rectF.width());
                if (z) {
                    int save = canvas.save();
                    canvas2.clipRect(this.rectF);
                    i3 = save;
                } else {
                    i3 = 0;
                }
                CharSequence charSequence = this.unicodeWrappedText;
                if (z && this.truncateAt != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.textPaint, this.rectF.width(), this.truncateAt);
                }
                CharSequence charSequence2 = charSequence;
                int length = charSequence2.length();
                PointF pointF3 = this.pointF;
                canvas.drawText(charSequence2, 0, length, pointF3.x, pointF3.y, this.textPaint);
                if (z) {
                    canvas2.restoreToCount(i3);
                }
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(bounds, this.rectF);
                RectF rectF8 = this.rectF;
                float f13 = rectF8.left;
                float f14 = rectF8.top;
                canvas2.translate(f13, f14);
                this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
                this.closeIcon.draw(canvas2);
                canvas2.translate(-f13, -f14);
            }
            Paint paint3 = this.debugPaint;
            if (paint3 != null) {
                paint3.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
                canvas2.drawRect(bounds, this.debugPaint);
                if (showsChipIcon() || showsCheckedIcon()) {
                    calculateChipIconBounds(bounds, this.rectF);
                    canvas2.drawRect(this.rectF, this.debugPaint);
                }
                if (this.unicodeWrappedText != null) {
                    canvas.drawLine((float) bounds.left, bounds.exactCenterY(), (float) bounds.right, bounds.exactCenterY(), this.debugPaint);
                }
                if (showsCloseIcon()) {
                    calculateCloseIconBounds(bounds, this.rectF);
                    canvas2.drawRect(this.rectF, this.debugPaint);
                }
                this.debugPaint.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
                RectF rectF9 = this.rectF;
                rectF9.set(bounds);
                if (showsCloseIcon()) {
                    float f15 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
                    if (DrawableCompat.getLayoutDirection(this) == 0) {
                        rectF9.right = ((float) bounds.right) - f15;
                    } else {
                        rectF9.left = ((float) bounds.left) + f15;
                    }
                }
                canvas2.drawRect(this.rectF, this.debugPaint);
                this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
                calculateCloseIconTouchBounds(bounds, this.rectF);
                canvas2.drawRect(this.rectF, this.debugPaint);
            }
            if (this.alpha < 255) {
                canvas2.restoreToCount(i2);
            }
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable = this.chipIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    @Nullable
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(calculateCloseIconWidth() + getTextWidth() + calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding + this.textEndPadding + this.chipEndPadding), this.maxWidth);
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.chipMinHeight, this.chipCornerRadius);
        }
        outline.setAlpha(((float) this.alpha) / 255.0f);
    }

    public final float getTextWidth() {
        float f;
        if (!this.textWidthDirty) {
            return this.textWidth;
        }
        CharSequence charSequence = this.unicodeWrappedText;
        if (charSequence == null) {
            f = 0.0f;
        } else {
            f = this.textPaint.measureText(charSequence, 0, charSequence.length());
        }
        this.textWidth = f;
        this.textWidthDirty = false;
        return f;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r0 = r0.textColor;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r3 = this;
            android.content.res.ColorStateList r0 = r3.chipBackgroundColor
            boolean r0 = isStateful((android.content.res.ColorStateList) r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x005a
            android.content.res.ColorStateList r0 = r3.chipStrokeColor
            boolean r0 = isStateful((android.content.res.ColorStateList) r0)
            if (r0 != 0) goto L_0x005a
            boolean r0 = r3.useCompatRipple
            if (r0 == 0) goto L_0x001e
            android.content.res.ColorStateList r0 = r3.compatRippleColor
            boolean r0 = isStateful((android.content.res.ColorStateList) r0)
            if (r0 != 0) goto L_0x005a
        L_0x001e:
            com.google.android.material.resources.TextAppearance r0 = r3.textAppearance
            if (r0 == 0) goto L_0x002e
            android.content.res.ColorStateList r0 = r0.textColor
            if (r0 == 0) goto L_0x002e
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x002e
            r0 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 != 0) goto L_0x005a
            boolean r0 = r3.checkedIconVisible
            if (r0 == 0) goto L_0x003f
            android.graphics.drawable.Drawable r0 = r3.checkedIcon
            if (r0 == 0) goto L_0x003f
            boolean r0 = r3.checkable
            if (r0 == 0) goto L_0x003f
            r0 = 1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r0 != 0) goto L_0x005a
            android.graphics.drawable.Drawable r0 = r3.chipIcon
            boolean r0 = isStateful((android.graphics.drawable.Drawable) r0)
            if (r0 != 0) goto L_0x005a
            android.graphics.drawable.Drawable r0 = r3.checkedIcon
            boolean r0 = isStateful((android.graphics.drawable.Drawable) r0)
            if (r0 != 0) goto L_0x005a
            android.content.res.ColorStateList r0 = r3.tint
            boolean r0 = isStateful((android.content.res.ColorStateList) r0)
            if (r0 == 0) goto L_0x005b
        L_0x005a:
            r1 = 1
        L_0x005b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.isStateful():boolean");
    }

    @TargetApi(23)
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= this.chipIcon.setLayoutDirection(i);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= this.checkedIcon.setLayoutDirection(i);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= this.closeIcon.setLayoutDirection(i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public void onSizeChange() {
        Delegate delegate2 = (Delegate) this.delegate.get();
        if (delegate2 != null) {
            delegate2.onChipDrawableSizeChange();
        }
    }

    public boolean onStateChange(int[] iArr) {
        return onStateChange(iArr, this.closeIconStateSet);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipCornerRadius(float f) {
        if (this.chipCornerRadius != f) {
            this.chipCornerRadius = f;
            invalidateSelf();
        }
    }

    public void setChipEndPadding(float f) {
        if (this.chipEndPadding != f) {
            this.chipEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        Drawable chipIcon2 = getChipIcon();
        if (chipIcon2 != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIcon = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(chipIcon2);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSize(float f) {
        if (this.chipIconSize != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                DrawableCompat.setTintList(this.chipIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconVisible(boolean z) {
        if (this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipMinHeight(float f) {
        if (this.chipMinHeight != f) {
            this.chipMinHeight = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPadding(float f) {
        if (this.chipStartPadding != f) {
            this.chipStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipStrokeWidth(float f) {
        if (this.chipStrokeWidth != f) {
            this.chipStrokeWidth = f;
            this.chipPaint.setStrokeWidth(f);
            invalidateSelf();
        }
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        Drawable closeIcon2 = getCloseIcon();
        if (closeIcon2 != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            this.closeIcon = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon2);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPadding(float f) {
        if (this.closeIconEndPadding != f) {
            this.closeIconEndPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSize(float f) {
        if (this.closeIconSize != f) {
            this.closeIconSize = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPadding(float f) {
        if (this.closeIconStartPadding != f) {
            this.closeIconStartPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public boolean setCloseIconState(@NonNull int[] iArr) {
        if (Arrays.equals(this.closeIconStateSet, iArr)) {
            return false;
        }
        this.closeIconStateSet = iArr;
        if (showsCloseIcon()) {
            return onStateChange(getState(), iArr);
        }
        return false;
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                DrawableCompat.setTintList(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconVisible(boolean z) {
        if (this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter2) {
        if (this.colorFilter != colorFilter2) {
            this.colorFilter = colorFilter2;
            invalidateSelf();
        }
    }

    public void setIconEndPadding(float f) {
        if (this.iconEndPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPadding(float f) {
        if (this.iconStartPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            this.compatRippleColor = this.useCompatRipple ? RippleUtils.convertToRippleDrawableColor(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.rawText != charSequence) {
            this.rawText = charSequence;
            this.unicodeWrappedText = BidiFormatter.getInstance().unicodeWrap(charSequence);
            this.textWidthDirty = true;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance2) {
        if (this.textAppearance != textAppearance2) {
            this.textAppearance = textAppearance2;
            if (textAppearance2 != null) {
                textAppearance2.updateMeasureState(this.context, this.textPaint, this.fontCallback);
                this.textWidthDirty = true;
            }
            onStateChange(getState());
            onSizeChange();
        }
    }

    public void setTextEndPadding(float f) {
        if (this.textEndPadding != f) {
            this.textEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPadding(float f) {
        if (this.textStartPadding != f) {
            this.textStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = zzam.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z) {
        if (this.useCompatRipple != z) {
            this.useCompatRipple = z;
            this.compatRippleColor = z ? RippleUtils.convertToRippleDrawableColor(this.rippleColor) : null;
            onStateChange(getState());
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    public final boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    public final boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    public final void unapplyChildDrawable(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onStateChange(int[] r9, int[] r10) {
        /*
            r8 = this;
            boolean r0 = super.onStateChange(r9)
            android.content.res.ColorStateList r1 = r8.chipBackgroundColor
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r8.currentChipBackgroundColor
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r3 = r8.currentChipBackgroundColor
            r4 = 1
            if (r3 == r1) goto L_0x0019
            r8.currentChipBackgroundColor = r1
            r0 = 1
        L_0x0019:
            android.content.res.ColorStateList r1 = r8.chipStrokeColor
            if (r1 == 0) goto L_0x0024
            int r3 = r8.currentChipStrokeColor
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            int r3 = r8.currentChipStrokeColor
            if (r3 == r1) goto L_0x002c
            r8.currentChipStrokeColor = r1
            r0 = 1
        L_0x002c:
            android.content.res.ColorStateList r1 = r8.compatRippleColor
            if (r1 == 0) goto L_0x0037
            int r3 = r8.currentCompatRippleColor
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            int r3 = r8.currentCompatRippleColor
            if (r3 == r1) goto L_0x0043
            r8.currentCompatRippleColor = r1
            boolean r1 = r8.useCompatRipple
            if (r1 == 0) goto L_0x0043
            r0 = 1
        L_0x0043:
            com.google.android.material.resources.TextAppearance r1 = r8.textAppearance
            if (r1 == 0) goto L_0x0052
            android.content.res.ColorStateList r1 = r1.textColor
            if (r1 == 0) goto L_0x0052
            int r3 = r8.currentTextColor
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            int r3 = r8.currentTextColor
            if (r3 == r1) goto L_0x005a
            r8.currentTextColor = r1
            r0 = 1
        L_0x005a:
            int[] r1 = r8.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            if (r1 != 0) goto L_0x0065
        L_0x0063:
            r1 = 0
            goto L_0x0072
        L_0x0065:
            int r5 = r1.length
            r6 = 0
        L_0x0067:
            if (r6 >= r5) goto L_0x0063
            r7 = r1[r6]
            if (r7 != r3) goto L_0x006f
            r1 = 1
            goto L_0x0072
        L_0x006f:
            int r6 = r6 + 1
            goto L_0x0067
        L_0x0072:
            if (r1 == 0) goto L_0x007a
            boolean r1 = r8.checkable
            if (r1 == 0) goto L_0x007a
            r1 = 1
            goto L_0x007b
        L_0x007a:
            r1 = 0
        L_0x007b:
            boolean r3 = r8.currentChecked
            if (r3 == r1) goto L_0x0095
            android.graphics.drawable.Drawable r3 = r8.checkedIcon
            if (r3 == 0) goto L_0x0095
            float r0 = r8.calculateChipIconWidth()
            r8.currentChecked = r1
            float r1 = r8.calculateChipIconWidth()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0094
            r0 = 1
            r1 = 1
            goto L_0x0096
        L_0x0094:
            r0 = 1
        L_0x0095:
            r1 = 0
        L_0x0096:
            android.content.res.ColorStateList r3 = r8.tint
            if (r3 == 0) goto L_0x00a0
            int r2 = r8.currentTint
            int r2 = r3.getColorForState(r9, r2)
        L_0x00a0:
            int r3 = r8.currentTint
            if (r3 == r2) goto L_0x00b1
            r8.currentTint = r2
            android.content.res.ColorStateList r0 = r8.tint
            android.graphics.PorterDuff$Mode r2 = r8.tintMode
            android.graphics.PorterDuffColorFilter r0 = com.android.billingclient.api.zzam.updateTintFilter(r8, r0, r2)
            r8.tintFilter = r0
            goto L_0x00b2
        L_0x00b1:
            r4 = r0
        L_0x00b2:
            android.graphics.drawable.Drawable r0 = r8.chipIcon
            boolean r0 = isStateful((android.graphics.drawable.Drawable) r0)
            if (r0 == 0) goto L_0x00c1
            android.graphics.drawable.Drawable r0 = r8.chipIcon
            boolean r0 = r0.setState(r9)
            r4 = r4 | r0
        L_0x00c1:
            android.graphics.drawable.Drawable r0 = r8.checkedIcon
            boolean r0 = isStateful((android.graphics.drawable.Drawable) r0)
            if (r0 == 0) goto L_0x00d0
            android.graphics.drawable.Drawable r0 = r8.checkedIcon
            boolean r9 = r0.setState(r9)
            r4 = r4 | r9
        L_0x00d0:
            android.graphics.drawable.Drawable r9 = r8.closeIcon
            boolean r9 = isStateful((android.graphics.drawable.Drawable) r9)
            if (r9 == 0) goto L_0x00df
            android.graphics.drawable.Drawable r9 = r8.closeIcon
            boolean r9 = r9.setState(r10)
            r4 = r4 | r9
        L_0x00df:
            if (r4 == 0) goto L_0x00e4
            r8.invalidateSelf()
        L_0x00e4:
            if (r1 == 0) goto L_0x00e9
            r8.onSizeChange()
        L_0x00e9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.onStateChange(int[], int[]):boolean");
    }

    public static boolean isStateful(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean isStateful(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }
}
