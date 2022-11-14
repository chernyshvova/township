package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypedArray.kt */
public final class TypedArrayKt {
    public static final void checkAttribute(TypedArray typedArray, @StyleableRes int i) {
        if (!typedArray.hasValue(i)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getBooleanOrThrow");
        checkAttribute(typedArray, i);
        return typedArray.getBoolean(i, false);
    }

    @ColorInt
    public static final int getColorOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getColorOrThrow");
        checkAttribute(typedArray, i);
        return typedArray.getColor(i, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getColorStateListOrThrow");
        checkAttribute(typedArray, i);
        ColorStateList colorStateList = typedArray.getColorStateList(i);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getDimensionOrThrow");
        checkAttribute(typedArray, i);
        return typedArray.getDimension(i, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getDimensionPixelOffsetOrThrow");
        checkAttribute(typedArray, i);
        return typedArray.getDimensionPixelOffset(i, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getDimensionPixelSizeOrThrow");
        checkAttribute(typedArray, i);
        return typedArray.getDimensionPixelSize(i, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getDrawableOrThrow");
        checkAttribute(typedArray, i);
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable != null) {
            return drawable;
        }
        Intrinsics.throwNpe();
        throw null;
    }

    public static final float getFloatOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getFloatOrThrow");
        checkAttribute(typedArray, i);
        return typedArray.getFloat(i, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getFontOrThrow");
        checkAttribute(typedArray, i);
        Typeface font = typedArray.getFont(i);
        if (font != null) {
            return font;
        }
        Intrinsics.throwNpe();
        throw null;
    }

    public static final int getIntOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getIntOrThrow");
        checkAttribute(typedArray, i);
        return typedArray.getInt(i, 0);
    }

    public static final int getIntegerOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getIntegerOrThrow");
        checkAttribute(typedArray, i);
        return typedArray.getInteger(i, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getResourceIdOrThrow");
        checkAttribute(typedArray, i);
        return typedArray.getResourceId(i, 0);
    }

    public static final String getStringOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getStringOrThrow");
        checkAttribute(typedArray, i);
        String string = typedArray.getString(i);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getTextArrayOrThrow");
        checkAttribute(typedArray, i);
        CharSequence[] textArray = typedArray.getTextArray(i);
        Intrinsics.checkExpressionValueIsNotNull(textArray, "getTextArray(index)");
        return textArray;
    }

    public static final CharSequence getTextOrThrow(TypedArray typedArray, @StyleableRes int i) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$getTextOrThrow");
        checkAttribute(typedArray, i);
        CharSequence text = typedArray.getText(i);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(TypedArray typedArray, Function1<? super TypedArray, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(typedArray, "$this$use");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        R invoke = function1.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
