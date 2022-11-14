package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PorterDuff.kt */
public final class PorterDuffKt {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode mode, int i) {
        Intrinsics.checkParameterIsNotNull(mode, "$this$toColorFilter");
        return new PorterDuffColorFilter(i, mode);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode mode) {
        Intrinsics.checkParameterIsNotNull(mode, "$this$toXfermode");
        return new PorterDuffXfermode(mode);
    }
}
