package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzejv extends zzbfm {
    @VisibleForTesting
    public final zzeyv zza = new zzeyv();
    @VisibleForTesting
    public final zzdmk zzb = new zzdmk();
    public final Context zzc;
    public final zzcop zzd;
    public zzbfe zze;

    public zzejv(zzcop zzcop, Context context, String str) {
        this.zzd = zzcop;
        this.zza.zzf(str);
        this.zzc = context;
    }

    public final zzbfk zze() {
        zzdml zzg = this.zzb.zzg();
        this.zza.zzl(zzg.zzh());
        this.zza.zzm(zzg.zzi());
        zzeyv zzeyv = this.zza;
        if (zzeyv.zze() == null) {
            zzeyv.zzc(zzbdp.zzb());
        }
        return new zzejw(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    public final void zzf(zzbfe zzbfe) {
        this.zze = zzbfe;
    }

    public final void zzg(zzbng zzbng) {
        this.zzb.zzb(zzbng);
    }

    public final void zzh(zzbnj zzbnj) {
        this.zzb.zza(zzbnj);
    }

    public final void zzi(String str, zzbnp zzbnp, @Nullable zzbnm zzbnm) {
        this.zzb.zzf(str, zzbnp, zzbnm);
    }

    public final void zzj(zzblw zzblw) {
        this.zza.zzn(zzblw);
    }

    public final void zzk(zzbnt zzbnt, zzbdp zzbdp) {
        this.zzb.zzd(zzbnt);
        this.zza.zzc(zzbdp);
    }

    public final void zzl(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzq(publisherAdViewOptions);
    }

    public final void zzm(zzbnw zzbnw) {
        this.zzb.zzc(zzbnw);
    }

    public final void zzn(zzbry zzbry) {
        this.zza.zzp(zzbry);
    }

    public final void zzo(zzbsh zzbsh) {
        this.zzb.zze(zzbsh);
    }

    public final void zzp(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzr(adManagerAdViewOptions);
    }

    public final void zzq(zzbgc zzbgc) {
        this.zza.zzN(zzbgc);
    }
}
