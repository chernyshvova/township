package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Size.kt */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(Size size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$component1");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(Size size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$component2");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(SizeF sizeF) {
        Intrinsics.checkParameterIsNotNull(sizeF, "$this$component1");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF sizeF) {
        Intrinsics.checkParameterIsNotNull(sizeF, "$this$component2");
        return sizeF.getHeight();
    }
}
