package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.helpshift.analytics.AnalyticsEventKey;
import com.vungle.warren.network.VungleApiImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bitmap.kt */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$applyCanvas");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        function1.invoke(new Canvas(bitmap));
        return bitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r3 = r3.y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean contains(android.graphics.Bitmap r2, android.graphics.Point r3) {
        /*
            java.lang.String r0 = "$this$contains"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "p"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            int r0 = r3.x
            if (r0 < 0) goto L_0x0020
            int r1 = r2.getWidth()
            if (r0 >= r1) goto L_0x0020
            int r3 = r3.y
            if (r3 < 0) goto L_0x0020
            int r2 = r2.getHeight()
            if (r3 >= r2) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapKt.contains(android.graphics.Bitmap, android.graphics.Point):boolean");
    }

    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkParameterIsNotNull(config, VungleApiImpl.CONFIG);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        Intrinsics.checkParameterIsNotNull(config, VungleApiImpl.CONFIG);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(Bitmap bitmap, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$get");
        return bitmap.getPixel(i, i2);
    }

    public static final Bitmap scale(Bitmap bitmap, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$scale");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z);
        Intrinsics.checkExpressionValueIsNotNull(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$scale");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z);
        Intrinsics.checkExpressionValueIsNotNull(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(Bitmap bitmap, int i, int i2, @ColorInt int i3) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$set");
        bitmap.setPixel(i, i2, i3);
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$contains");
        Intrinsics.checkParameterIsNotNull(pointF, AnalyticsEventKey.PROTOCOL);
        float f = pointF.x;
        float f2 = (float) 0;
        if (f < f2 || f >= ((float) bitmap.getWidth())) {
            return false;
        }
        float f3 = pointF.y;
        return f3 >= f2 && f3 < ((float) bitmap.getHeight());
    }

    @RequiresApi(26)
    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace) {
        Intrinsics.checkParameterIsNotNull(config, VungleApiImpl.CONFIG);
        Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            Intrinsics.checkExpressionValueIsNotNull(colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        Intrinsics.checkParameterIsNotNull(config, VungleApiImpl.CONFIG);
        Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }
}
