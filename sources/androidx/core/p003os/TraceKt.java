package androidx.core.p003os;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.core.os.TraceKt */
/* compiled from: Trace.kt */
public final class TraceKt {
    public static final <T> T trace(String str, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(str, "sectionName");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        TraceCompat.beginSection(str);
        try {
            return function0.invoke();
        } finally {
            TraceCompat.endSection();
        }
    }
}
