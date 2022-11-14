package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckl extends zzbl {
    public static final zzckl zzb = new zzckl();

    public final zzbp zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbr();
        }
        if ("mvhd".equals(str)) {
            return new zzbs();
        }
        return new zzbt(str);
    }
}
