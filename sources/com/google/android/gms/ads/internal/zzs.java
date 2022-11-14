package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zza;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zzch;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzawt;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzbjt;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzcbs;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.internal.ads.zzcgd;
import com.google.android.gms.internal.ads.zzchk;
import com.google.android.gms.internal.ads.zzchr;
import com.google.android.gms.internal.ads.zzckq;
import com.google.android.gms.internal.ads.zzcnd;
import com.google.android.gms.internal.ads.zzedl;
import com.google.android.gms.internal.ads.zzedm;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzs {
    public static final zzs zza = new zzs();
    public final zzch zzA;
    public final zzckq zzB;
    public final zzchr zzC;
    public final zza zzb;
    public final zzm zzc;
    public final zzr zzd;
    public final zzcnd zze;
    public final zzac zzf;
    public final zzawt zzg;
    public final zzcgd zzh;
    public final zzad zzi;
    public final zzayf zzj;
    public final Clock zzk;
    public final zze zzl;
    public final zzbjt zzm;
    public final zzay zzn;
    public final zzcbs zzo;
    public final zzbsm zzp;
    public final zzchk zzq;
    public final zzbty zzr;
    public final zzbw zzs;
    public final zzw zzt;
    public final zzx zzu;
    public final zzbvd zzv;
    public final zzbx zzw;
    public final zzbzl zzx;
    public final zzayu zzy;
    public final zzcfb zzz;

    public zzs() {
        zza zza2 = new zza();
        zzm zzm2 = new zzm();
        zzr zzr2 = new zzr();
        zzcnd zzcnd = new zzcnd();
        zzac zzt2 = zzac.zzt(Build.VERSION.SDK_INT);
        zzawt zzawt = new zzawt();
        zzcgd zzcgd = new zzcgd();
        zzad zzad = new zzad();
        zzayf zzayf = new zzayf();
        Clock instance = DefaultClock.getInstance();
        zze zze2 = new zze();
        zzbjt zzbjt = new zzbjt();
        zzay zzay = new zzay();
        zzcbs zzcbs = new zzcbs();
        zzbsm zzbsm = new zzbsm();
        zzchk zzchk = new zzchk();
        zzbty zzbty = new zzbty();
        zzbw zzbw = new zzbw();
        zzw zzw2 = new zzw();
        zzx zzx2 = new zzx();
        zzbvd zzbvd = new zzbvd();
        zzbx zzbx = new zzbx();
        zzcbs zzcbs2 = zzcbs;
        zzay zzay2 = zzay;
        zzedm zzedm = new zzedm(new zzedl(), new zzbzk());
        zzayu zzayu = new zzayu();
        zzcfb zzcfb = new zzcfb();
        zzch zzch = new zzch();
        zzckq zzckq = new zzckq();
        zzchr zzchr = new zzchr();
        this.zzb = zza2;
        this.zzc = zzm2;
        this.zzd = zzr2;
        this.zze = zzcnd;
        this.zzf = zzt2;
        this.zzg = zzawt;
        this.zzh = zzcgd;
        this.zzi = zzad;
        this.zzj = zzayf;
        this.zzk = instance;
        this.zzl = zze2;
        this.zzm = zzbjt;
        this.zzn = zzay2;
        this.zzo = zzcbs2;
        this.zzp = zzbsm;
        this.zzq = zzchk;
        this.zzr = zzbty;
        this.zzs = zzbw;
        this.zzt = zzw2;
        this.zzu = zzx2;
        this.zzv = zzbvd;
        this.zzw = zzbx;
        this.zzx = zzedm;
        this.zzy = zzayu;
        this.zzz = zzcfb;
        this.zzA = zzch;
        this.zzB = zzckq;
        this.zzC = zzchr;
    }

    public static zzcfb zzA() {
        return zza.zzz;
    }

    public static zza zza() {
        return zza.zzb;
    }

    public static zzm zzb() {
        return zza.zzc;
    }

    public static zzr zzc() {
        return zza.zzd;
    }

    public static zzcnd zzd() {
        return zza.zze;
    }

    public static zzac zze() {
        return zza.zzf;
    }

    public static zzawt zzf() {
        return zza.zzg;
    }

    public static zzcgd zzg() {
        return zza.zzh;
    }

    public static zzad zzh() {
        return zza.zzi;
    }

    public static zzayf zzi() {
        return zza.zzj;
    }

    public static Clock zzj() {
        return zza.zzk;
    }

    public static zze zzk() {
        return zza.zzl;
    }

    public static zzbjt zzl() {
        return zza.zzm;
    }

    public static zzay zzm() {
        return zza.zzn;
    }

    public static zzcbs zzn() {
        return zza.zzo;
    }

    public static zzchk zzo() {
        return zza.zzq;
    }

    public static zzbty zzp() {
        return zza.zzr;
    }

    public static zzbw zzq() {
        return zza.zzs;
    }

    public static zzbzl zzr() {
        return zza.zzx;
    }

    public static zzw zzs() {
        return zza.zzt;
    }

    public static zzx zzt() {
        return zza.zzu;
    }

    public static zzbvd zzu() {
        return zza.zzv;
    }

    public static zzbx zzv() {
        return zza.zzw;
    }

    public static zzayu zzw() {
        return zza.zzy;
    }

    public static zzch zzx() {
        return zza.zzA;
    }

    public static zzckq zzy() {
        return zza.zzB;
    }

    public static zzchr zzz() {
        return zza.zzC;
    }
}
