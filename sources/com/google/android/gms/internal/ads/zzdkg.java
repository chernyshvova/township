package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdkg implements zzdbd, zzdhr {
    public final zzcej zza;
    public final Context zzb;
    public final zzcfb zzc;
    @Nullable
    public final View zzd;
    public String zze;
    public final zzazh zzf;

    public zzdkg(zzcej zzcej, Context context, zzcfb zzcfb, @Nullable View view, zzazh zzazh) {
        this.zza = zzcej;
        this.zzb = context;
        this.zzc = zzcfb;
        this.zzd = view;
        this.zzf = zzazh;
    }

    public final void zza() {
    }

    public final void zzc() {
        View view = this.zzd;
        if (!(view == null || this.zze == null)) {
            this.zzc.zzi(view.getContext(), this.zze);
        }
        this.zza.zza(true);
    }

    public final void zzd() {
        this.zza.zza(false);
    }

    public final void zze() {
    }

    @ParametersAreNonnullByDefault
    public final void zzf(zzcca zzcca, String str, String str2) {
        if (this.zzc.zzb(this.zzb)) {
            try {
                zzcfb zzcfb = this.zzc;
                Context context = this.zzb;
                zzcfb.zzr(context, zzcfb.zzl(context), this.zza.zzb(), zzcca.zzb(), zzcca.zzc());
            } catch (RemoteException e) {
                zzcgs.zzj("Remote Exception to get reward item.", e);
            }
        }
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzj() {
        String zzh = this.zzc.zzh(this.zzb);
        this.zze = zzh;
        String valueOf = String.valueOf(zzh);
        String str = this.zzf == zzazh.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.zze = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }
}
