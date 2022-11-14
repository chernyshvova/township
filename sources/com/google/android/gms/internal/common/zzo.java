package com.google.android.gms.internal.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class zzo<E> extends zzp<E> {
    public Object[] zza = new Object[4];
    public int zzb = 0;
    public boolean zzc;

    public zzo(int i) {
    }

    private final void zzb(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i) {
            int i2 = length + (length >> 1) + 1;
            if (i2 < i) {
                int highestOneBit = Integer.highestOneBit(i - 1);
                i2 = highestOneBit + highestOneBit;
            }
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i2);
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
    }

    public final zzo<E> zza(E e) {
        if (e != null) {
            zzb(this.zzb + 1);
            Object[] objArr = this.zza;
            int i = this.zzb;
            this.zzb = i + 1;
            objArr[i] = e;
            return this;
        }
        throw null;
    }
}
