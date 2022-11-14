package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformRandom.kt */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final FallbackThreadLocalRandom$implStorage$1 implStorage = new FallbackThreadLocalRandom$implStorage$1();

    public Random getImpl() {
        Object obj = this.implStorage.get();
        Intrinsics.checkNotNullExpressionValue(obj, "implStorage.get()");
        return (Random) obj;
    }
}
