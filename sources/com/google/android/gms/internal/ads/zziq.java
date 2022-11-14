package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zziq {
    public final zzma[] zza;
    public final zzajh zzb = zzajh.zza;
    public zzahc zzc;
    public final zzaeg zzd;
    public zzkf zze;
    public final zzahl zzf;
    public final Looper zzg = zzalh.zzk();
    public final zzme zzh = zzme.zze;
    public boolean zzi;
    public final zzij zzj = zzii.zza(0.97f, 1.03f, 1000, 1.0E-7f, zzig.zzb(20), zzig.zzb(500), 0.999f);

    public zziq(Context context, zzma... zzmaArr) {
        zzags zzags = new zzags(context);
        zzadi zzadi = new zzadi(new zzaid(context, (String) null, (zzajd) null), new zzsy());
        zzik zzik = new zzik();
        zzaib zzc2 = zzaib.zzc(context);
        this.zza = zzmaArr;
        this.zzc = zzags;
        this.zzd = zzadi;
        this.zze = zzik;
        this.zzf = zzc2;
    }

    public final zziq zza(zzahc zzahc) {
        zzajg.zzd(!this.zzi);
        this.zzc = zzahc;
        return this;
    }

    public final zziq zzb(zzkf zzkf) {
        zzajg.zzd(!this.zzi);
        this.zze = zzkf;
        return this;
    }

    public final zzir zzc() {
        zzajg.zzd(!this.zzi);
        this.zzi = true;
        return new zzjn(this.zza, this.zzc, this.zzd, this.zze, this.zzf, (zzou) null, true, this.zzh, this.zzj, 500, false, this.zzb, this.zzg, (zzlu) null, zzlp.zza, (byte[]) null);
    }
}
