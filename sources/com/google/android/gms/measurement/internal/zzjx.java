package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzq;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjx extends zzg {
    public final zzkf zza = new zzkf(this);
    public final zzkd zzb = new zzkd(this);
    public Handler zzc;
    public final zzjy zzd = new zzjy(this);

    public zzjx(zzfu zzfu) {
        super(zzfu);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzaa() {
        zzc();
        if (this.zzc == null) {
            this.zzc = new zzq(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(long j) {
        zzc();
        zzaa();
        zzq().zzw().zza("Activity resumed, time", Long.valueOf(j));
        if (zzs().zza(zzas.zzbu)) {
            if (zzs().zzh().booleanValue() || zzr().zzr.zza()) {
                this.zzb.zza(j);
            }
            this.zzd.zza();
        } else {
            this.zzd.zza();
            if (zzs().zzh().booleanValue()) {
                this.zzb.zza(j);
            }
        }
        zzkf zzkf = this.zza;
        zzkf.zza.zzc();
        if (zzkf.zza.zzy.zzaa()) {
            if (!zzkf.zza.zzs().zza(zzas.zzbu)) {
                zzkf.zza.zzr().zzr.zza(false);
            }
            zzkf.zza(zzkf.zza.zzl().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(long j) {
        zzc();
        zzaa();
        zzq().zzw().zza("Activity paused, time", Long.valueOf(j));
        this.zzd.zza(j);
        if (zzs().zzh().booleanValue()) {
            this.zzb.zzb(j);
        }
        zzkf zzkf = this.zza;
        if (!zzkf.zza.zzs().zza(zzas.zzbu)) {
            zzkf.zza.zzr().zzr.zza(true);
        }
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.zza(z, z2, j);
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzhb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzen zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzir zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzii zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzem zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzjx zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    public final boolean zzy() {
        return false;
    }

    public final long zza(long j) {
        return this.zzb.zzc(j);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }
}
