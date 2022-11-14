package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class zzk extends zzi {
    public static final WeakReference<byte[]> zzb = new WeakReference<>((Object) null);
    public WeakReference<byte[]> zza = zzb;

    public zzk(byte[] bArr) {
        super(bArr);
    }

    public abstract byte[] zzb();

    public final byte[] zzc() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zza.get();
            if (bArr == null) {
                bArr = zzb();
                this.zza = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
