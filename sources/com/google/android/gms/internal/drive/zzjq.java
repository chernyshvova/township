package com.google.android.gms.internal.drive;

public final class zzjq extends zzjo {
    public final byte[] buffer;
    public int limit;
    public int pos;
    public final boolean zzoc;
    public int zzod;
    public int zzoe;
    public int zzof;

    public zzjq(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzof = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzoe = i;
        this.zzoc = z;
    }

    public final int zzbz() {
        return this.pos - this.zzoe;
    }

    public final int zzv(int i) throws zzkq {
        if (i >= 0) {
            int zzbz = zzbz() + i;
            int i2 = this.zzof;
            if (zzbz <= i2) {
                this.zzof = zzbz;
                int i3 = this.limit + this.zzod;
                this.limit = i3;
                int i4 = i3 - this.zzoe;
                if (i4 > zzbz) {
                    int i5 = i4 - zzbz;
                    this.zzod = i5;
                    this.limit = i3 - i5;
                } else {
                    this.zzod = 0;
                }
                return i2;
            }
            throw zzkq.zzdi();
        }
        throw zzkq.zzdj();
    }
}
