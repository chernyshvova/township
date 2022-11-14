package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdqu {
    public final zzdqp zza = new zzdqp((zzdqk) null);
    public final zza zzb;
    public final zzcnd zzc;
    public final Context zzd;
    public final zzduu zze;
    public final zzfdh zzf;
    public final Executor zzg;
    public final zzfb zzh;
    public final zzcgy zzi;
    public final zzbqg zzj;
    public final zzedb zzk;
    public final zzfdz zzl;
    public zzfqn<zzcmr> zzm;

    public zzdqu(zzdqs zzdqs) {
        this.zzd = zzdqs.zzc;
        this.zzg = zzdqs.zzg;
        this.zzh = zzdqs.zzh;
        this.zzi = zzdqs.zzi;
        this.zzb = zzdqs.zza;
        this.zzc = zzdqs.zzb;
        this.zzj = new zzbqg();
        this.zzk = zzdqs.zzf;
        this.zzl = zzdqs.zzj;
        this.zze = zzdqs.zzd;
        this.zzf = zzdqs.zze;
    }

    public final synchronized void zza() {
        zzfqn<zzcmr> zzj2 = zzfqe.zzj(zzcnd.zzb(this.zzd, this.zzi, (String) zzbex.zzc().zzb(zzbjn.zzcc), this.zzh, this.zzb), new zzdqi(this), this.zzg);
        this.zzm = zzj2;
        zzchh.zza(zzj2, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb() {
        zzfqn<zzcmr> zzfqn = this.zzm;
        if (zzfqn != null) {
            zzfqe.zzp(zzfqn, new zzdqk(this), this.zzg);
            this.zzm = null;
        }
    }

    public final synchronized zzfqn<JSONObject> zzc(String str, JSONObject jSONObject) {
        zzfqn<zzcmr> zzfqn = this.zzm;
        if (zzfqn == null) {
            return zzfqe.zza(null);
        }
        return zzfqe.zzi(zzfqn, new zzdqj(this, str, jSONObject), this.zzg);
    }

    public final synchronized void zzd(String str, zzbps<Object> zzbps) {
        zzfqn<zzcmr> zzfqn = this.zzm;
        if (zzfqn != null) {
            zzfqe.zzp(zzfqn, new zzdql(this, str, zzbps), this.zzg);
        }
    }

    public final synchronized void zze(String str, zzbps<Object> zzbps) {
        zzfqn<zzcmr> zzfqn = this.zzm;
        if (zzfqn != null) {
            zzfqe.zzp(zzfqn, new zzdqm(this, str, zzbps), this.zzg);
        }
    }

    public final synchronized void zzf(String str, Map<String, ?> map) {
        zzfqn<zzcmr> zzfqn = this.zzm;
        if (zzfqn != null) {
            zzfqe.zzp(zzfqn, new zzdqn(this, "sendMessageToNativeJs", map), this.zzg);
        }
    }

    public final synchronized void zzg(zzeye zzeye, zzeyh zzeyh) {
        zzfqn<zzcmr> zzfqn = this.zzm;
        if (zzfqn != null) {
            zzfqe.zzp(zzfqn, new zzdqo(this, zzeye, zzeyh), this.zzg);
        }
    }

    public final <T> void zzh(WeakReference<T> weakReference, String str, zzbps<T> zzbps) {
        zzd(str, new zzdqt(this, weakReference, str, zzbps, (zzdqk) null));
    }

    public final /* synthetic */ zzfqn zzi(String str, JSONObject jSONObject, zzcmr zzcmr) throws Exception {
        return this.zzj.zzc(zzcmr, str, jSONObject);
    }

    public final /* synthetic */ zzcmr zzj(zzcmr zzcmr) {
        zzcmr zzcmr2 = zzcmr;
        zzcmr2.zzab("/result", this.zzj);
        zzcof zzR = zzcmr.zzR();
        zzdqp zzdqp = this.zza;
        zzb zzb2 = new zzb(this.zzd, (zzcdz) null, (zzcay) null);
        zzedb zzedb = this.zzk;
        zzfdz zzfdz = this.zzl;
        zzR.zzK((zzbcz) null, zzdqp, zzdqp, zzdqp, zzdqp, false, (zzbpv) null, zzb2, (zzbyr) null, (zzcdz) null, zzedb, zzfdz, this.zze, this.zzf, (zzbpt) null);
        return zzcmr2;
    }
}
