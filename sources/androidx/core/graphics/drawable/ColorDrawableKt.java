package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorDrawable.kt */
public final class ColorDrawableKt {
    public static final ColorDrawable toDrawable(@ColorInt int i) {
        return new ColorDrawable(i);
    }

    @RequiresApi(26)
    public static final ColorDrawable toDrawable(Color color) {
        Intrinsics.checkParameterIsNotNull(color, "$this$toDrawable");
        return new ColorDrawable(color.toArgb());
    }
}
