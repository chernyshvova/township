package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Half.kt */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s) {
        Half valueOf = Half.valueOf(s);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(float f) {
        Half valueOf = Half.valueOf(f);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toHalf");
        Half valueOf = Half.valueOf(str);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(double d) {
        Half valueOf = Half.valueOf((float) d);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }
}
