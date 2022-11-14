package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzaam implements zzaaw {
    public final zzkc zza;

    public zzaam(zzkc zzkc) {
        this.zza = zzkc;
    }

    public final int zza(Object obj) {
        zzkc zzkc = this.zza;
        zzaah zzaah = (zzaah) obj;
        int i = zzaax.zza;
        try {
            return !zzaah.zzc(zzkc) ? 0 : 1;
        } catch (zzaas unused) {
            return -1;
        }
    }
}
