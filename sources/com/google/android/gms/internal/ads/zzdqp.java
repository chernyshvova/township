package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdqp implements zzbcz, zzbos, zzo, zzbou, zzv {
    public zzbcz zza;
    public zzbos zzb;
    public zzo zzc;
    public zzbou zzd;
    public zzv zze;

    public zzdqp() {
    }

    public /* synthetic */ zzdqp(zzdqk zzdqk) {
    }

    /* access modifiers changed from: private */
    public final synchronized void zzi(zzbcz zzbcz, zzbos zzbos, zzo zzo, zzbou zzbou, zzv zzv) {
        this.zza = zzbcz;
        this.zzb = zzbos;
        this.zzc = zzo;
        this.zzd = zzbou;
        this.zze = zzv;
    }

    public final synchronized void onAdClicked() {
        zzbcz zzbcz = this.zza;
        if (zzbcz != null) {
            zzbcz.onAdClicked();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        zzbos zzbos = this.zzb;
        if (zzbos != null) {
            zzbos.zza(str, bundle);
        }
    }

    public final synchronized void zzbE() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbE();
        }
    }

    public final synchronized void zzbH() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbH();
        }
    }

    public final synchronized void zzbI() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbI();
        }
    }

    public final synchronized void zzbJ() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbJ();
        }
    }

    public final synchronized void zzbK(int i) {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbK(i);
        }
    }

    public final synchronized void zzbS(String str, @Nullable String str2) {
        zzbou zzbou = this.zzd;
        if (zzbou != null) {
            zzbou.zzbS(str, str2);
        }
    }

    public final synchronized void zzca() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzca();
        }
    }

    public final synchronized void zzg() {
        zzv zzv = this.zze;
        if (zzv != null) {
            zzv.zzg();
        }
    }
}
