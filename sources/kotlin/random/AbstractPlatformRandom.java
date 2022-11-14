package kotlin.random;

import java.util.Random;

/* compiled from: PlatformRandom.kt */
public abstract class AbstractPlatformRandom extends Random {
    public abstract Random getImpl();

    public int nextBits(int i) {
        return ((-i) >> 31) & (getImpl().nextInt() >>> (32 - i));
    }

    public int nextInt() {
        return getImpl().nextInt();
    }

    public int nextInt(int i) {
        return getImpl().nextInt(i);
    }
}
