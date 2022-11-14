package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeud implements zzdbg, zzddc, zzevs, zzo, zzddo {
    public final zzfad zza;
    public final AtomicReference<zzaxv> zzb = new AtomicReference<>();
    public final AtomicReference<zzaxw> zzc = new AtomicReference<>();
    public final AtomicReference<zzaxz> zzd = new AtomicReference<>();
    public final AtomicReference<zzddc> zze = new AtomicReference<>();
    public final AtomicReference<zzo> zzf = new AtomicReference<>();
    public final AtomicReference<zzbha> zzg = new AtomicReference<>();
    public zzeud zzh = null;

    public zzeud(zzfad zzfad) {
        this.zza = zzfad;
    }

    public static zzeud zzg(zzeud zzeud) {
        zzeud zzeud2 = new zzeud(zzeud.zza);
        zzeud2.zzh = zzeud;
        return zzeud2;
    }

    public final void zzK() {
        zzeud zzeud = this.zzh;
        if (zzeud != null) {
            zzeud.zzK();
        } else {
            zzevk.zza(this.zze, zzetz.zza);
        }
    }

    public final void zzbE() {
        zzeud zzeud = this.zzh;
        if (zzeud != null) {
            zzeud.zzbE();
            return;
        }
        zzevk.zza(this.zzf, zzeua.zza);
        zzevk.zza(this.zzd, zzeub.zza);
        zzevk.zza(this.zzd, zzeuc.zza);
    }

    public final void zzbH() {
        zzeud zzeud = this.zzh;
        if (zzeud != null) {
            zzeud.zzbH();
        } else {
            zzevk.zza(this.zzf, zzets.zza);
        }
    }

    public final void zzbI() {
        zzeud zzeud = this.zzh;
        if (zzeud != null) {
            zzeud.zzbI();
        } else {
            zzevk.zza(this.zzf, zzett.zza);
        }
    }

    public final void zzbJ() {
    }

    public final void zzbK(int i) {
        zzeud zzeud = this.zzh;
        if (zzeud != null) {
            zzeud.zzbK(i);
        } else {
            zzevk.zza(this.zzf, new zzetr(i));
        }
    }

    public final void zzbT(zzbdd zzbdd) {
        zzeud zzeud = this.zzh;
        if (zzeud != null) {
            zzeud.zzbT(zzbdd);
            return;
        }
        zzevk.zza(this.zzb, new zzetv(zzbdd));
        zzevk.zza(this.zzb, new zzetw(zzbdd));
    }

    public final void zzca() {
    }

    public final void zzh(zzaxv zzaxv) {
        this.zzb.set(zzaxv);
    }

    public final void zzi(zzaxz zzaxz) {
        this.zzd.set(zzaxz);
    }

    public final void zzj(zzddc zzddc) {
        this.zze.set(zzddc);
    }

    public final void zzk(@NonNull zzbdr zzbdr) {
        zzeud zzeud = this.zzh;
        if (zzeud != null) {
            zzeud.zzk(zzbdr);
        } else {
            zzevk.zza(this.zzg, new zzetq(zzbdr));
        }
    }

    public final void zzl(zzo zzo) {
        this.zzf.set(zzo);
    }

    public final void zzm(zzbha zzbha) {
        this.zzg.set(zzbha);
    }

    public final void zzn(zzaxs zzaxs) {
        zzeud zzeud = this.zzh;
        if (zzeud != null) {
            zzeud.zzn(zzaxs);
        } else {
            zzevk.zza(this.zzb, new zzetu(zzaxs));
        }
    }

    public final void zzo() {
        zzeud zzeud = this.zzh;
        if (zzeud != null) {
            zzeud.zzo();
            return;
        }
        this.zza.zzb();
        zzevk.zza(this.zzc, zzetx.zza);
        zzevk.zza(this.zzd, zzety.zza);
    }

    public final void zzp(zzevs zzevs) {
        this.zzh = (zzeud) zzevs;
    }

    public final void zzq(zzaxw zzaxw) {
        this.zzc.set(zzaxw);
    }
}
