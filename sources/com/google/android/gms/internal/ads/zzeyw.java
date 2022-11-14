package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.util.zzr;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeyw {
    @Nullable
    public final zzbiv zza;
    @Nullable
    public final zzbry zzb;
    @Nullable
    public final zzekq zzc;
    public final zzbdk zzd;
    public final zzbdp zze;
    public final String zzf;
    public final ArrayList<String> zzg;
    public final ArrayList<String> zzh;
    public final zzblw zzi;
    public final zzbdv zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final zzbfy zzn;
    public final zzeym zzo;
    public final boolean zzp;
    @Nullable
    public final zzbgc zzq;

    public /* synthetic */ zzeyw(zzeyv zzeyv, zzeyu zzeyu) {
        zzbiv zzbiv;
        zzblw zzblw;
        this.zze = zzeyv.zzb;
        this.zzf = zzeyv.zzc;
        this.zzq = zzeyv.zzr;
        int i = zzeyv.zza.zza;
        long j = zzeyv.zza.zzb;
        Bundle bundle = zzeyv.zza.zzc;
        int i2 = zzeyv.zza.zzd;
        List<String> list = zzeyv.zza.zze;
        boolean z = zzeyv.zza.zzf;
        int i3 = zzeyv.zza.zzg;
        boolean z2 = true;
        if (!zzeyv.zza.zzh && !zzeyv.zze) {
            z2 = false;
        }
        this.zzd = new zzbdk(i, j, bundle, i2, list, z, i3, z2, zzeyv.zza.zzi, zzeyv.zza.zzj, zzeyv.zza.zzk, zzeyv.zza.zzl, zzeyv.zza.zzm, zzeyv.zza.zzn, zzeyv.zza.zzo, zzeyv.zza.zzp, zzeyv.zza.zzq, zzeyv.zza.zzr, zzeyv.zza.zzs, zzeyv.zza.zzt, zzeyv.zza.zzu, zzeyv.zza.zzv, zzr.zza(zzeyv.zza.zzw), zzeyv.zza.zzx);
        if (zzeyv.zzd != null) {
            zzbiv = zzeyv.zzd;
        } else {
            zzbiv = zzeyv.zzh != null ? zzeyv.zzh.zzf : null;
        }
        this.zza = zzbiv;
        this.zzg = zzeyv.zzf;
        this.zzh = zzeyv.zzg;
        if (zzeyv.zzf == null) {
            zzblw = null;
        } else {
            zzblw = zzeyv.zzh == null ? new zzblw(new NativeAdOptions.Builder().build()) : zzeyv.zzh;
        }
        this.zzi = zzblw;
        this.zzj = zzeyv.zzi;
        this.zzk = zzeyv.zzm;
        this.zzl = zzeyv.zzj;
        this.zzm = zzeyv.zzk;
        this.zzn = zzeyv.zzl;
        this.zzb = zzeyv.zzn;
        this.zzo = new zzeym(zzeyv.zzo, (zzeyk) null);
        this.zzp = zzeyv.zzp;
        this.zzc = zzeyv.zzq;
    }

    public final zzbnz zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzc();
        }
        return this.zzl.zza();
    }
}
