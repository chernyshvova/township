package androidx.core.graphics;

import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Paint.kt */
public final class PaintKt {
    public static final boolean setBlendMode(Paint paint, BlendModeCompat blendModeCompat) {
        Intrinsics.checkParameterIsNotNull(paint, "$this$setBlendMode");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
