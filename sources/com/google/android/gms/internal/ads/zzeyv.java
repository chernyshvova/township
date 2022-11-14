package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeyv {
    public zzbdk zza;
    public zzbdp zzb;
    public String zzc;
    public zzbiv zzd;
    public boolean zze;
    public ArrayList<String> zzf;
    public ArrayList<String> zzg;
    public zzblw zzh;
    public zzbdv zzi;
    public AdManagerAdViewOptions zzj;
    public PublisherAdViewOptions zzk;
    @Nullable
    public zzbfy zzl;
    public int zzm = 1;
    public zzbry zzn;
    public final zzeyl zzo = new zzeyl();
    public boolean zzp = false;
    @Nullable
    public zzekq zzq;
    public zzbgc zzr;

    public final zzeyv zzN(zzbgc zzbgc) {
        this.zzr = zzbgc;
        return this;
    }

    public final zzeyv zza(zzbdk zzbdk) {
        this.zza = zzbdk;
        return this;
    }

    public final zzbdk zzb() {
        return this.zza;
    }

    public final zzeyv zzc(zzbdp zzbdp) {
        this.zzb = zzbdp;
        return this;
    }

    public final zzeyv zzd(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzbdp zze() {
        return this.zzb;
    }

    public final zzeyv zzf(String str) {
        this.zzc = str;
        return this;
    }

    public final String zzg() {
        return this.zzc;
    }

    public final zzeyv zzh(zzbiv zzbiv) {
        this.zzd = zzbiv;
        return this;
    }

    public final zzeyl zzi() {
        return this.zzo;
    }

    public final zzeyv zzj(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzeyv zzk(int i) {
        this.zzm = i;
        return this;
    }

    public final zzeyv zzl(ArrayList<String> arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzeyv zzm(ArrayList<String> arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzeyv zzn(zzblw zzblw) {
        this.zzh = zzblw;
        return this;
    }

    public final zzeyv zzo(zzbdv zzbdv) {
        this.zzi = zzbdv;
        return this;
    }

    public final zzeyv zzp(zzbry zzbry) {
        this.zzn = zzbry;
        this.zzd = new zzbiv(false, true, false);
        return this;
    }

    public final zzeyv zzq(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zza();
            this.zzl = publisherAdViewOptions.zzb();
        }
        return this;
    }

    public final zzeyv zzr(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzeyv zzs(zzekq zzekq) {
        this.zzq = zzekq;
        return this;
    }

    public final zzeyv zzt(zzeyw zzeyw) {
        this.zzo.zza(zzeyw.zzo.zza);
        this.zza = zzeyw.zzd;
        this.zzb = zzeyw.zze;
        this.zzr = zzeyw.zzq;
        this.zzc = zzeyw.zzf;
        this.zzd = zzeyw.zza;
        this.zzf = zzeyw.zzg;
        this.zzg = zzeyw.zzh;
        this.zzh = zzeyw.zzi;
        this.zzi = zzeyw.zzj;
        zzr(zzeyw.zzl);
        zzq(zzeyw.zzm);
        this.zzp = zzeyw.zzp;
        this.zzq = zzeyw.zzc;
        return this;
    }

    public final zzeyw zzu() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzeyw(this, (zzeyu) null);
    }

    public final boolean zzv() {
        return this.zzp;
    }
}
