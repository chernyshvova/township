package com.google.android.material.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.ripple.RippleUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialButtonHelper {
    public static final boolean IS_LOLLIPOP = (Build.VERSION.SDK_INT >= 21);
    @Nullable
    public GradientDrawable backgroundDrawableLollipop;
    public boolean backgroundOverwritten = false;
    @Nullable
    public ColorStateList backgroundTint;
    @Nullable
    public PorterDuff.Mode backgroundTintMode;
    public final Rect bounds = new Rect();
    public final Paint buttonStrokePaint = new Paint(1);
    @Nullable
    public GradientDrawable colorableBackgroundDrawableCompat;
    public int cornerRadius;
    public int insetBottom;
    public int insetLeft;
    public int insetRight;
    public int insetTop;
    @Nullable
    public GradientDrawable maskDrawableLollipop;
    public final MaterialButton materialButton;
    public final RectF rectF = new RectF();
    @Nullable
    public ColorStateList rippleColor;
    @Nullable
    public GradientDrawable rippleDrawableCompat;
    @Nullable
    public ColorStateList strokeColor;
    @Nullable
    public GradientDrawable strokeDrawableLollipop;
    public int strokeWidth;
    @Nullable
    public Drawable tintableBackgroundDrawableCompat;
    @Nullable
    public Drawable tintableRippleDrawableCompat;

    public MaterialButtonHelper(MaterialButton materialButton2) {
        this.materialButton = materialButton2;
    }

    @TargetApi(21)
    public final Drawable createBackgroundLollipop() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.backgroundDrawableLollipop = gradientDrawable;
        gradientDrawable.setCornerRadius(((float) this.cornerRadius) + 1.0E-5f);
        this.backgroundDrawableLollipop.setColor(-1);
        updateTintAndTintModeLollipop();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.strokeDrawableLollipop = gradientDrawable2;
        gradientDrawable2.setCornerRadius(((float) this.cornerRadius) + 1.0E-5f);
        this.strokeDrawableLollipop.setColor(0);
        this.strokeDrawableLollipop.setStroke(this.strokeWidth, this.strokeColor);
        InsetDrawable insetDrawable = new InsetDrawable(new LayerDrawable(new Drawable[]{this.backgroundDrawableLollipop, this.strokeDrawableLollipop}), this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.maskDrawableLollipop = gradientDrawable3;
        gradientDrawable3.setCornerRadius(((float) this.cornerRadius) + 1.0E-5f);
        this.maskDrawableLollipop.setColor(-1);
        return new MaterialButtonBackgroundDrawable(RippleUtils.convertToRippleDrawableColor(this.rippleColor), insetDrawable, this.maskDrawableLollipop);
    }

    public final void updateStroke() {
        if (IS_LOLLIPOP && this.strokeDrawableLollipop != null) {
            this.materialButton.setInternalBackground(createBackgroundLollipop());
        } else if (!IS_LOLLIPOP) {
            this.materialButton.invalidate();
        }
    }

    public final void updateTintAndTintModeLollipop() {
        GradientDrawable gradientDrawable = this.backgroundDrawableLollipop;
        if (gradientDrawable != null) {
            DrawableCompat.setTintList(gradientDrawable, this.backgroundTint);
            PorterDuff.Mode mode = this.backgroundTintMode;
            if (mode != null) {
                DrawableCompat.setTintMode(this.backgroundDrawableLollipop, mode);
            }
        }
    }
}
