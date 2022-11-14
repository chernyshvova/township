package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LruCache.kt */
public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    public final /* synthetic */ Function1 $create;
    public final /* synthetic */ int $maxSize;
    public final /* synthetic */ Function4 $onEntryRemoved;
    public final /* synthetic */ Function2 $sizeOf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(Function2 function2, Function1 function1, Function4 function4, int i, int i2) {
        super(i2);
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = function4;
        this.$maxSize = i;
    }

    public V create(K k) {
        Intrinsics.checkParameterIsNotNull(k, "key");
        return this.$create.invoke(k);
    }

    public void entryRemoved(boolean z, K k, V v, V v2) {
        Intrinsics.checkParameterIsNotNull(k, "key");
        Intrinsics.checkParameterIsNotNull(v, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), k, v, v2);
    }

    public int sizeOf(K k, V v) {
        Intrinsics.checkParameterIsNotNull(k, "key");
        Intrinsics.checkParameterIsNotNull(v, "value");
        return ((Number) this.$sizeOf.invoke(k, v)).intValue();
    }
}
