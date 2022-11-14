package com.facebook.appevents.p030ml;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.facebook.appevents.ml.MTensor */
/* compiled from: MTensor.kt */
public final class MTensor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public int capacity;
    public float[] data;
    public int[] shape;

    /* renamed from: com.facebook.appevents.ml.MTensor$Companion */
    /* compiled from: MTensor.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int getCapacity(int[] iArr) {
            int i = 1;
            if (!(iArr.length == 0)) {
                int i2 = iArr[0];
                Intrinsics.checkNotNullParameter(iArr, "$this$lastIndex");
                int length = iArr.length - 1;
                if (1 <= length) {
                    while (true) {
                        i2 *= iArr[i];
                        if (i == length) {
                            break;
                        }
                        i++;
                    }
                }
                return i2;
            }
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
    }

    public MTensor(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "shape");
        this.shape = iArr;
        int access$getCapacity = Companion.getCapacity(iArr);
        this.capacity = access$getCapacity;
        this.data = new float[access$getCapacity];
    }

    public final float[] getData() {
        return this.data;
    }

    public final int getShape(int i) {
        return this.shape[i];
    }

    public final int getShapeSize() {
        return this.shape.length;
    }

    public final void reshape(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "shape");
        this.shape = iArr;
        int access$getCapacity = Companion.getCapacity(iArr);
        float[] fArr = new float[access$getCapacity];
        System.arraycopy(this.data, 0, fArr, 0, Math.min(this.capacity, access$getCapacity));
        this.data = fArr;
        this.capacity = access$getCapacity;
    }
}
