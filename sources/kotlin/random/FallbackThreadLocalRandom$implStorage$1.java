package kotlin.random;

import java.util.Random;

/* compiled from: PlatformRandom.kt */
public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal<Random> {
    public Object initialValue() {
        return new Random();
    }
}
