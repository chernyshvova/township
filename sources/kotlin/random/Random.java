package kotlin.random;

import com.swrve.sdk.rest.RESTClient;
import java.io.Serializable;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Random.kt */
public abstract class Random {
    public static final Default Default = new Default((DefaultConstructorMarker) null);
    public static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    /* compiled from: Random.kt */
    public static final class Default extends Random implements Serializable {

        /* compiled from: Random.kt */
        public static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            public static final long serialVersionUID = 0;

            private final Object readResolve() {
                return Random.Default;
            }
        }

        public Default() {
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        public int nextBits(int i) {
            return Random.defaultRandom.nextBits(i);
        }

        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        public Default(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public int nextInt(int i) {
            return Random.defaultRandom.nextInt(i);
        }

        public int nextInt(int i, int i2) {
            return Random.defaultRandom.nextInt(i, i2);
        }
    }

    public abstract int nextBits(int i);

    public abstract int nextInt();

    public abstract int nextInt(int i);

    public int nextInt(int i, int i2) {
        int i3;
        int nextInt;
        int i4;
        if (i2 > i) {
            int i5 = i2 - i;
            if (i5 > 0 || i5 == Integer.MIN_VALUE) {
                if (((-i5) & i5) == i5) {
                    i3 = nextBits(31 - Integer.numberOfLeadingZeros(i5));
                } else {
                    do {
                        nextInt = nextInt() >>> 1;
                        i4 = nextInt % i5;
                    } while ((i5 - 1) + (nextInt - i4) < 0);
                    i3 = i4;
                }
                return i + i3;
            }
            while (true) {
                int nextInt2 = nextInt();
                if (i <= nextInt2 && i2 > nextInt2) {
                    return nextInt2;
                }
            }
        } else {
            Integer valueOf = Integer.valueOf(i);
            Integer valueOf2 = Integer.valueOf(i2);
            Intrinsics.checkNotNullParameter(valueOf, "from");
            Intrinsics.checkNotNullParameter(valueOf2, "until");
            throw new IllegalArgumentException(("Random range is empty: [" + valueOf + RESTClient.COMMA_SEPARATOR + valueOf2 + ").").toString());
        }
    }
}
