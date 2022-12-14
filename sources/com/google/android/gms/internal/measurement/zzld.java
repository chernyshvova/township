package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class zzld {
    public abstract int zza(int i, byte[] bArr, int i2, int i3);

    public abstract int zza(CharSequence charSequence, byte[] bArr, int i, int i2);

    public abstract String zza(byte[] bArr, int i, int i2) throws zzij;

    public final boolean zzb(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
