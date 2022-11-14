package androidx.core.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: LruCache.kt */
public final class LruCacheKt$lruCache$2 extends Lambda implements Function1<K, V> {
    public static final LruCacheKt$lruCache$2 INSTANCE = new LruCacheKt$lruCache$2();

    public LruCacheKt$lruCache$2() {
        super(1);
    }

    public final V invoke(K k) {
        Intrinsics.checkParameterIsNotNull(k, "it");
        return null;
    }
}
