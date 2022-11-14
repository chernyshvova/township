package com.google.android.gms.internal.drive;

public final class zzjk {
    public final byte[] buffer;
    public final zzjr zznx;

    public zzjk(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zznx = zzjr.zzb(bArr);
    }

    public final zzjc zzbx() {
        this.zznx.zzcb();
        return new zzjm(this.buffer);
    }

    public final zzjr zzby() {
        return this.zznx;
    }

    public /* synthetic */ zzjk(int i, zzjd zzjd) {
        this(i);
    }
}
