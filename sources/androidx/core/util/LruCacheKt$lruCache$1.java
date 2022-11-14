package androidx.core.util;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: LruCache.kt */
public final class LruCacheKt$lruCache$1 extends Lambda implements Function2<K, V, Integer> {
    public static final LruCacheKt$lruCache$1 INSTANCE = new LruCacheKt$lruCache$1();

    public LruCacheKt$lruCache$1() {
        super(2);
    }

    public final int invoke(K k, V v) {
        Intrinsics.checkParameterIsNotNull(k, "<anonymous parameter 0>");
        Intrinsics.checkParameterIsNotNull(v, "<anonymous parameter 1>");
        return 1;
    }
}
