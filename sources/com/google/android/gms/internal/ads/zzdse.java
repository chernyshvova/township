package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzb;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdse {
    public final zzdbb zza;
    public final zzdck zzb;
    public final zzdcx zzc;
    public final zzddj zzd;
    public final zzdfs zze;
    public final Executor zzf;
    public final zzdib zzg;
    public final zzcts zzh;
    public final zzb zzi;
    public final zzcdz zzj;
    public final zzfb zzk;
    public final zzdfj zzl;
    public final zzedb zzm;
    public final zzfdz zzn;
    public final zzduu zzo;
    public final zzfdh zzp;

    public zzdse(zzdbb zzdbb, zzdck zzdck, zzdcx zzdcx, zzddj zzddj, zzdfs zzdfs, Executor executor, zzdib zzdib, zzcts zzcts, zzb zzb2, @Nullable zzcdz zzcdz, zzfb zzfb, zzdfj zzdfj, zzedb zzedb, zzfdz zzfdz, zzduu zzduu, zzfdh zzfdh) {
        this.zza = zzdbb;
        this.zzb = zzdck;
        this.zzc = zzdcx;
        this.zzd = zzddj;
        this.zze = zzdfs;
        this.zzf = executor;
        this.zzg = zzdib;
        this.zzh = zzcts;
        this.zzi = zzb2;
        this.zzj = zzcdz;
        this.zzk = zzfb;
        this.zzl = zzdfj;
        this.zzm = zzedb;
        this.zzn = zzfdz;
        this.zzo = zzduu;
        this.zzp = zzfdh;
    }

    public static final zzfqn<?> zzj(zzcmr zzcmr, String str, String str2) {
        zzchj zzchj = new zzchj();
        zzcmr.zzR().zzw(new zzdsc(zzchj));
        zzcmr.zzat(str, str2, (String) null);
        return zzchj;
    }

    public final /* synthetic */ void zza(zzcmr zzcmr, zzcmr zzcmr2, Map map) {
        this.zzh.zzi(zzcmr);
    }

    public final /* synthetic */ void zzb(View view) {
        this.zzi.zza();
    }

    public final /* synthetic */ boolean zzc(View view, MotionEvent motionEvent) {
        this.zzi.zza();
        return false;
    }

    public final /* synthetic */ void zzd() {
        this.zzb.zzb();
    }

    public final /* synthetic */ void zze(String str, String str2) {
        this.zze.zzbS(str, str2);
    }

    public final /* synthetic */ void zzf() {
        this.zza.onAdClicked();
    }

    public final void zzi(zzcmr zzcmr, boolean z, zzbpv zzbpv) {
        zzex zzb2;
        zzcmr zzcmr2 = zzcmr;
        zzcmr.zzR().zzK(new zzdrv(this), this.zzc, this.zzd, new zzdrw(this), new zzdrx(this), z, zzbpv, this.zzi, new zzdsd(this), this.zzj, this.zzm, this.zzn, this.zzo, this.zzp, (zzbpt) null);
        zzcmr2.setOnTouchListener(new zzdry(this));
        zzcmr2.setOnClickListener(new zzdrz(this));
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbH)).booleanValue() && (zzb2 = this.zzk.zzb()) != null) {
            zzb2.zzh((View) zzcmr2);
        }
        this.zzg.zzh(zzcmr2, this.zzf);
        this.zzg.zzh(new zzdsa(zzcmr2), this.zzf);
        this.zzg.zza((View) zzcmr2);
        zzcmr2.zzab("/trackActiveViewUnit", new zzdsb(this, zzcmr2));
        this.zzh.zzj(zzcmr2);
    }
}
