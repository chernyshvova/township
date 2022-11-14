package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcth implements zzdbd, zzdcr, zzdbx, zzbcz, zzdbt {
    public final Context zza;
    public final Executor zzb;
    public final Executor zzc;
    public final ScheduledExecutorService zzd;
    public final zzeyq zze;
    public final zzeye zzf;
    public final zzfdw zzg;
    public final zzezg zzh;
    public final zzfb zzi;
    public final zzbkm zzj;
    public final WeakReference<View> zzk;
    @GuardedBy("this")
    public boolean zzl;
    public final AtomicBoolean zzm = new AtomicBoolean();
    public final zzbko zzn;

    public zzcth(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzeyq zzeyq, zzeye zzeye, zzfdw zzfdw, zzezg zzezg, @Nullable View view, zzfb zzfb, zzbkm zzbkm, zzbko zzbko, byte[] bArr) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzeyq;
        this.zzf = zzeye;
        this.zzg = zzfdw;
        this.zzh = zzezg;
        this.zzi = zzfb;
        this.zzk = new WeakReference<>(view);
        this.zzj = zzbkm;
        this.zzn = zzbko;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzq */
    public final void zzp() {
        String zzi2 = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbW)).booleanValue() ? this.zzi.zzb().zzi(this.zza, (View) this.zzk.get(), (Activity) null) : null;
        if ((!((Boolean) zzbex.zzc().zzb(zzbjn.zzai)).booleanValue() || !this.zze.zzb.zzb.zzg) && zzbkz.zzg.zze().booleanValue()) {
            zzfqe.zzp((zzfpv) zzfqe.zzh(zzfpv.zzw(zzfqe.zza(null)), ((Long) zzbex.zzc().zzb(zzbjn.zzaG)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzctg(this, zzi2), this.zzb);
            return;
        }
        zzezg zzezg = this.zzh;
        zzfdw zzfdw = this.zzg;
        zzeyq zzeyq = this.zze;
        zzeye zzeye = this.zzf;
        zzezg.zza(zzfdw.zzb(zzeyq, zzeye, false, zzi2, (String) null, zzeye.zzd));
    }

    public final void onAdClicked() {
        if ((!((Boolean) zzbex.zzc().zzb(zzbjn.zzai)).booleanValue() || !this.zze.zzb.zzb.zzg) && zzbkz.zzd.zze().booleanValue()) {
            zzfqe.zzp(zzfqe.zzf(zzfpv.zzw(this.zzj.zzb()), Throwable.class, zzctc.zza, zzche.zzf), new zzctf(this), this.zzb);
            return;
        }
        zzezg zzezg = this.zzh;
        zzfdw zzfdw = this.zzg;
        zzeyq zzeyq = this.zze;
        zzeye zzeye = this.zzf;
        List<String> zza2 = zzfdw.zza(zzeyq, zzeye, zzeye.zzc);
        zzs.zzc();
        int i = 1;
        if (true == zzr.zzI(this.zza)) {
            i = 2;
        }
        zzezg.zzb(zza2, i);
    }

    public final void zzbF() {
        if (this.zzm.compareAndSet(false, true)) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbY)).booleanValue()) {
                this.zzc.execute(new zzctd(this));
            } else {
                zzp();
            }
        }
    }

    public final synchronized void zzbU() {
        if (this.zzl) {
            ArrayList arrayList = new ArrayList(this.zzf.zzd);
            arrayList.addAll(this.zzf.zzg);
            this.zzh.zza(this.zzg.zzb(this.zze, this.zzf, true, (String) null, (String) null, arrayList));
        } else {
            zzezg zzezg = this.zzh;
            zzfdw zzfdw = this.zzg;
            zzeyq zzeyq = this.zze;
            zzeye zzeye = this.zzf;
            zzezg.zza(zzfdw.zza(zzeyq, zzeye, zzeye.zzn));
            zzezg zzezg2 = this.zzh;
            zzfdw zzfdw2 = this.zzg;
            zzeyq zzeyq2 = this.zze;
            zzeye zzeye2 = this.zzf;
            zzezg2.zza(zzfdw2.zza(zzeyq2, zzeye2, zzeye2.zzg));
        }
        this.zzl = true;
    }

    public final void zzc() {
    }

    public final void zzd() {
    }

    public final void zze() {
    }

    public final void zzf(zzcca zzcca, String str, String str2) {
        zzezg zzezg = this.zzh;
        zzfdw zzfdw = this.zzg;
        zzeye zzeye = this.zzf;
        zzezg.zza(zzfdw.zzc(zzeye, zzeye.zzi, zzcca));
    }

    public final void zzg() {
        zzezg zzezg = this.zzh;
        zzfdw zzfdw = this.zzg;
        zzeyq zzeyq = this.zze;
        zzeye zzeye = this.zzf;
        zzezg.zza(zzfdw.zza(zzeyq, zzeye, zzeye.zzh));
    }

    public final void zzh() {
        zzezg zzezg = this.zzh;
        zzfdw zzfdw = this.zzg;
        zzeyq zzeyq = this.zze;
        zzeye zzeye = this.zzf;
        zzezg.zza(zzfdw.zza(zzeyq, zzeye, zzeye.zzj));
    }

    public final void zzi(zzbdd zzbdd) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaZ)).booleanValue()) {
            this.zzh.zza(this.zzg.zza(this.zze, this.zzf, zzfdw.zzd(2, zzbdd.zza, this.zzf.zzo)));
        }
    }

    public final /* synthetic */ void zzj() {
        this.zzb.execute(new zzcte(this));
    }
}
