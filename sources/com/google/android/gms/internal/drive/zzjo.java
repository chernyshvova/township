package com.google.android.gms.internal.drive;

public abstract class zzjo {
    public int zznz;
    public int zzoa;
    public boolean zzob;

    public zzjo() {
        this.zznz = 100;
        this.zzoa = Integer.MAX_VALUE;
        this.zzob = false;
    }

    public static zzjo zza(byte[] bArr, int i, int i2, boolean z) {
        zzjq zzjq = new zzjq(bArr, 0, i2, false);
        try {
            zzjq.zzv(i2);
            return zzjq;
        } catch (zzkq e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzk(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzw(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zzbz();

    public abstract int zzv(int i) throws zzkq;
}
