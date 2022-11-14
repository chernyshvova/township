package androidx.core.util;

import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: LruCache.kt */
public final class LruCacheKt$lruCache$3 extends Lambda implements Function4<Boolean, K, V, V, Unit> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    public LruCacheKt$lruCache$3() {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Boolean) obj).booleanValue(), obj2, obj3, obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, K k, V v, V v2) {
        Intrinsics.checkParameterIsNotNull(k, "<anonymous parameter 1>");
        Intrinsics.checkParameterIsNotNull(v, "<anonymous parameter 2>");
    }
}
