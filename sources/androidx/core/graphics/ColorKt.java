package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Color.kt */
public final class ColorKt {
    @RequiresApi(26)
    public static final float component1(Color color) {
        Intrinsics.checkParameterIsNotNull(color, "$this$component1");
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(Color color) {
        Intrinsics.checkParameterIsNotNull(color, "$this$component2");
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(Color color) {
        Intrinsics.checkParameterIsNotNull(color, "$this$component3");
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(Color color) {
        Intrinsics.checkParameterIsNotNull(color, "$this$component4");
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace.Named named) {
        Intrinsics.checkParameterIsNotNull(named, "colorSpace");
        return Color.convert(i, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j) {
        return Color.alpha(j);
    }

    public static final int getAlpha(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j) {
        return Color.blue(j);
    }

    public static final int getBlue(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j) {
        ColorSpace colorSpace = Color.colorSpace(j);
        Intrinsics.checkExpressionValueIsNotNull(colorSpace, "Color.colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j) {
        return Color.green(j);
    }

    public static final int getGreen(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i) {
        return Color.luminance(i);
    }

    @RequiresApi(26)
    public static final float getRed(long j) {
        return Color.red(j);
    }

    public static final int getRed(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j) {
        return Color.isSrgb(j);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j) {
        return Color.isWideGamut(j);
    }

    @RequiresApi(26)
    public static final Color plus(Color color, Color color2) {
        Intrinsics.checkParameterIsNotNull(color, "$this$plus");
        Intrinsics.checkParameterIsNotNull(color2, "c");
        Color compositeColors = ColorUtils.compositeColors(color2, color);
        Intrinsics.checkExpressionValueIsNotNull(compositeColors, "ColorUtils.compositeColors(c, this)");
        return compositeColors;
    }

    @RequiresApi(26)
    public static final Color toColor(@ColorInt int i) {
        Color valueOf = Color.valueOf(i);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @ColorInt
    public static final int toColorInt(long j) {
        return Color.toArgb(j);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i) {
        return Color.pack(i);
    }

    @RequiresApi(26)
    public static final float component1(long j) {
        return Color.red(j);
    }

    @RequiresApi(26)
    public static final float component2(long j) {
        return Color.green(j);
    }

    @RequiresApi(26)
    public static final float component3(long j) {
        return Color.blue(j);
    }

    @RequiresApi(26)
    public static final float component4(long j) {
        return Color.alpha(j);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace colorSpace) {
        Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        return Color.convert(i, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j) {
        return Color.luminance(j);
    }

    @RequiresApi(26)
    public static final Color toColor(long j) {
        Color valueOf = Color.valueOf(j);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @ColorInt
    public static final int toColorInt(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toColorInt");
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace.Named named) {
        Intrinsics.checkParameterIsNotNull(named, "colorSpace");
        return Color.convert(j, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace colorSpace) {
        Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        return Color.convert(j, colorSpace);
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace.Named named) {
        Intrinsics.checkParameterIsNotNull(color, "$this$convertTo");
        Intrinsics.checkParameterIsNotNull(named, "colorSpace");
        Color convert = color.convert(ColorSpace.get(named));
        Intrinsics.checkExpressionValueIsNotNull(convert, "convert(ColorSpace.get(colorSpace))");
        return convert;
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        Intrinsics.checkParameterIsNotNull(color, "$this$convertTo");
        Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        Color convert = color.convert(colorSpace);
        Intrinsics.checkExpressionValueIsNotNull(convert, "convert(colorSpace)");
        return convert;
    }
}
