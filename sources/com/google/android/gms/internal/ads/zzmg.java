package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzmg {
    public final Context zza;
    public final zzmd zzb;
    public final zzajh zzc = zzajh.zza;
    public zzahc zzd;
    public final zzaeg zze;
    public zzkf zzf;
    public final zzahl zzg;
    public final zzou zzh;
    public final Looper zzi = zzalh.zzk();
    public final zzpi zzj = zzpi.zza;
    public final zzme zzk = zzme.zze;
    public boolean zzl;
    public final zzij zzm = zzii.zza(0.97f, 1.03f, 1000, 1.0E-7f, zzig.zzb(20), zzig.zzb(500), 0.999f);

    public zzmg(Context context, zzmd zzmd) {
        zzsy zzsy = new zzsy();
        zzags zzags = new zzags(context);
        zzadi zzadi = new zzadi(new zzaid(context, (String) null, (zzajd) null), zzsy);
        zzik zzik = new zzik();
        zzaib zzc2 = zzaib.zzc(context);
        zzou zzou = new zzou(zzajh.zza);
        this.zza = context;
        this.zzb = zzmd;
        this.zzd = zzags;
        this.zze = zzadi;
        this.zzf = zzik;
        this.zzg = zzc2;
        this.zzh = zzou;
    }

    public final zzmg zza(zzahc zzahc) {
        zzajg.zzd(!this.zzl);
        this.zzd = zzahc;
        return this;
    }

    public final zzmg zzb(zzkf zzkf) {
        zzajg.zzd(!this.zzl);
        this.zzf = zzkf;
        return this;
    }

    public final zzmj zzc() {
        zzajg.zzd(!this.zzl);
        this.zzl = true;
        return new zzmj(this);
    }
}
