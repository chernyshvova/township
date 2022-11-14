package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzebb extends zzcbb {
    public final Context zza;
    public final Executor zzb;
    public final zzcbv zzc;
    public final zzcsd zzd;
    public final HashMap<String, zzeay> zze;
    public final zzcbw zzf;
    public final zzebg zzg;

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, java.util.concurrent.Executor] */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.concurrent.Executor, com.google.android.gms.internal.ads.zzcbw] */
    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzcsd, com.google.android.gms.internal.ads.zzcbw] */
    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.internal.ads.zzcsd, com.google.android.gms.internal.ads.zzcbv] */
    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.android.gms.internal.ads.zzcbv, java.util.HashMap<java.lang.String, com.google.android.gms.internal.ads.zzeay>] */
    /* JADX WARNING: type inference failed for: r7v0, types: [com.google.android.gms.internal.ads.zzebg, java.util.HashMap<java.lang.String, com.google.android.gms.internal.ads.zzeay>] */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzebb(android.content.Context r1, android.content.Context r2, java.util.concurrent.Executor r3, com.google.android.gms.internal.ads.zzcbw r4, com.google.android.gms.internal.ads.zzcsd r5, com.google.android.gms.internal.ads.zzcbv r6, java.util.HashMap<java.lang.String, com.google.android.gms.internal.ads.zzeay> r7, com.google.android.gms.internal.ads.zzebg r8) {
        /*
            r0 = this;
            r0.<init>()
            com.google.android.gms.internal.ads.zzbjn.zza(r1)
            r0.zza = r1
            r0.zzb = r2
            r0.zzf = r3
            r0.zzc = r5
            r0.zzd = r4
            r0.zze = r6
            r0.zzg = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebb.<init>(android.content.Context, java.util.concurrent.Executor, com.google.android.gms.internal.ads.zzcbw, com.google.android.gms.internal.ads.zzcsd, com.google.android.gms.internal.ads.zzcbv, java.util.HashMap, com.google.android.gms.internal.ads.zzebg, byte[]):void");
    }

    public static zzfqn<JSONObject> zzl(zzcbk zzcbk, zzfcx zzfcx, zzerh zzerh) {
        zzeap zzeap = new zzeap(zzerh);
        return zzfcx.zza(zzfcr.GMS_SIGNALS, zzfqe.zza(zzcbk.zza)).zzc(zzeap).zzb(zzeaq.zza).zzi();
    }

    public static zzfqn<zzcbn> zzm(zzfqn<JSONObject> zzfqn, zzfcx zzfcx, zzbuh zzbuh) {
        return zzfcx.zza(zzfcr.BUILD_URL, zzfqn).zzc(zzbuh.zza("AFMA_getAdDictionary", zzbue.zza, zzear.zza)).zzi();
    }

    private final void zzn(zzfqn<InputStream> zzfqn, zzcbg zzcbg) {
        zzfqe.zzp(zzfqe.zzi(zzfqn, new zzeav(this), zzche.zza), new zzeax(this, zzcbg), zzche.zzf);
    }

    public final zzfqn<InputStream> zzb(zzcbk zzcbk, int i) {
        zzbuh zza2 = zzs.zzp().zza(this.zza, zzcgy.zza());
        zzerh zzA = this.zzd.zzA(zzcbk, i);
        zzbtx<I, O> zza3 = zza2.zza("google.afma.response.normalize", zzeba.zzd, zzbue.zzb);
        zzebi zzebi = new zzebi(zzcbk.zzg);
        zzebf zzebf = new zzebf(this.zza, zzcbk.zzb.zza, this.zzf, i, (byte[]) null);
        zzfcx zzc2 = zzA.zzc();
        zzeay zzeay = null;
        if (!zzblf.zza.zze().booleanValue()) {
            String str = zzcbk.zzj;
            if (str != null && !str.isEmpty()) {
                zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            String str2 = zzcbk.zzj;
            if (str2 != null && !str2.isEmpty()) {
                zzeay remove = this.zze.remove(zzcbk.zzj);
                if (remove == null) {
                    zze.zza("Request contained a PoolKey but no matching parameters were found.");
                } else {
                    zzeay = remove;
                }
            }
        }
        if (zzeay == null) {
            zzfqn<JSONObject> zzl = zzl(zzcbk, zzc2, zzA);
            zzfqn<zzcbn> zzm = zzm(zzl, zzc2, zza2);
            zzfcd zzi = zzc2.zzb(zzfcr.HTTP, zzm, zzl).zza(new zzeam(zzl, zzm)).zzb(zzebi).zzb(zzebf).zzi();
            return zzc2.zzb(zzfcr.PRE_PROCESS, zzl, zzm, zzi).zza(new zzean(zzi, zzl, zzm)).zzc(zza3).zzi();
        }
        zzfcd zzi2 = zzc2.zza(zzfcr.HTTP, zzfqe.zza(new zzebh(zzeay.zzb, zzeay.zza))).zzb(zzebi).zzb(zzebf).zzi();
        zzfqn zza4 = zzfqe.zza(zzeay);
        return zzc2.zzb(zzfcr.PRE_PROCESS, zzi2, zza4).zza(new zzeao(zzi2, zza4)).zzc(zza3).zzi();
    }

    public final zzfqn<InputStream> zzc(zzcbk zzcbk, int i) {
        if (!zzblf.zza.zze().booleanValue()) {
            return zzfqe.zzc(new Exception("Split request is disabled."));
        }
        zzfao zzfao = zzcbk.zzi;
        if (zzfao == null) {
            return zzfqe.zzc(new Exception("Pool configuration missing from request."));
        }
        if (zzfao.zzc == 0 || zzfao.zzd == 0) {
            return zzfqe.zzc(new Exception("Caching is disabled."));
        }
        zzbuh zza2 = zzs.zzp().zza(this.zza, zzcgy.zza());
        zzerh zzA = this.zzd.zzA(zzcbk, i);
        zzfcx zzc2 = zzA.zzc();
        zzfqn<JSONObject> zzl = zzl(zzcbk, zzc2, zzA);
        zzfqn<zzcbn> zzm = zzm(zzl, zzc2, zza2);
        return zzc2.zzb(zzfcr.GET_URL_AND_CACHE_KEY, zzl, zzm).zza(new zzeat(this, zzm, zzl)).zzi();
    }

    public final zzfqn<InputStream> zzd(String str) {
        if (!zzblf.zza.zze().booleanValue()) {
            return zzfqe.zzc(new Exception("Split request is disabled."));
        }
        zzeaw zzeaw = new zzeaw(this);
        if (this.zze.remove(str) != null) {
            return zzfqe.zza(zzeaw);
        }
        String valueOf = String.valueOf(str);
        return zzfqe.zzc(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
    }

    public final void zze(zzcbk zzcbk, zzcbg zzcbg) {
        zzfqn<InputStream> zzb2 = zzb(zzcbk, Binder.getCallingUid());
        zzn(zzb2, zzcbg);
        zzb2.zze(new zzeas(this), this.zzb);
    }

    public final void zzf(zzcbk zzcbk, zzcbg zzcbg) {
        zzn(zzi(zzcbk, Binder.getCallingUid()), zzcbg);
    }

    public final void zzg(zzcbk zzcbk, zzcbg zzcbg) {
        zzn(zzc(zzcbk, Binder.getCallingUid()), zzcbg);
    }

    public final void zzh(String str, zzcbg zzcbg) {
        zzn(zzd(str), zzcbg);
    }

    public final zzfqn<InputStream> zzi(zzcbk zzcbk, int i) {
        zzbuh zza2 = zzs.zzp().zza(this.zza, zzcgy.zza());
        if (!zzblk.zza.zze().booleanValue()) {
            return zzfqe.zzc(new Exception("Signal collection disabled."));
        }
        zzerh zzA = this.zzd.zzA(zzcbk, i);
        zzeqs<JSONObject> zzb2 = zzA.zzb();
        return zzA.zzc().zza(zzfcr.GET_SIGNALS, zzfqe.zza(zzcbk.zza)).zzc(new zzeau(zzb2)).zzj(zzfcr.JS_SIGNALS).zzc(zza2.zza("google.afma.request.getSignals", zzbue.zza, zzbue.zzb)).zzi();
    }

    public final /* synthetic */ InputStream zzj(zzfqn zzfqn, zzfqn zzfqn2) throws Exception {
        String zzi = ((zzcbn) zzfqn.get()).zzi();
        this.zze.put(zzi, new zzeay((zzcbn) zzfqn.get(), (JSONObject) zzfqn2.get()));
        return new ByteArrayInputStream(zzi.getBytes(zzfjs.zzc));
    }

    public final /* synthetic */ void zzk() {
        zzchh.zza(this.zzc.zza(), "persistFlags");
    }
}
