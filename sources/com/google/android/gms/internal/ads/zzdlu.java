package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdlu implements zzavz {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzdlv zzb;

    public zzdlu(zzdlv zzdlv, String str) {
        this.zzb = zzdlv;
        this.zza = str;
    }

    public final void zzc(zzavy zzavy) {
        if (zzavy.zzj) {
            this.zzb.zzx.put(this.zza, Boolean.TRUE);
            zzdlv zzdlv = this.zzb;
            zzdlv.zzp(zzdlv.zzn.zzbP(), this.zzb.zzn.zzj(), this.zzb.zzn.zzk(), true);
        }
    }
}
