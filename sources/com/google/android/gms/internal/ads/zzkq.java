package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzkq {
    public static final zzif<zzkq> zzf = zzkg.zza;
    public final String zza;
    @Nullable
    public final zzkp zzb;
    public final zzko zzc;
    public final zzku zzd;
    public final zzkl zze;

    public /* synthetic */ zzkq(String str, zzkl zzkl, zzkp zzkp, zzko zzko, zzku zzku, zzkh zzkh) {
        this.zza = str;
        this.zzb = zzkp;
        this.zzc = zzko;
        this.zzd = zzku;
        this.zze = zzkl;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkq)) {
            return false;
        }
        zzkq zzkq = (zzkq) obj;
        return zzalh.zzc(this.zza, zzkq.zza) && this.zze.equals(zzkq.zze) && zzalh.zzc(this.zzb, zzkq.zzb) && zzalh.zzc(this.zzc, zzkq.zzc) && zzalh.zzc(this.zzd, zzkq.zzd);
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() * 31;
        zzkp zzkp = this.zzb;
        int hashCode2 = zzkp != null ? zzkp.hashCode() : 0;
        int hashCode3 = this.zzc.hashCode();
        return this.zzd.hashCode() + ((this.zze.hashCode() + ((hashCode3 + ((hashCode + hashCode2) * 31)) * 31)) * 31);
    }
}
