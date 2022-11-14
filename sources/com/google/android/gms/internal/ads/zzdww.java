package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import com.vungle.warren.network.VungleApiImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdww {
    public boolean zza = false;
    public boolean zzb = false;
    @GuardedBy("this")
    public boolean zzc = false;
    public final long zzd;
    public final zzchj<Boolean> zze = new zzchj<>();
    public final Context zzf;
    public final WeakReference<Context> zzg;
    public final zzdss zzh;
    public final Executor zzi;
    public final Executor zzj;
    public final ScheduledExecutorService zzk;
    public final zzdvd zzl;
    public final zzcgy zzm;
    public final Map<String, zzbrm> zzn = new ConcurrentHashMap();
    public final zzdhl zzo;
    public boolean zzp = true;

    public zzdww(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzdss zzdss, ScheduledExecutorService scheduledExecutorService, zzdvd zzdvd, zzcgy zzcgy, zzdhl zzdhl) {
        this.zzh = zzdss;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdvd;
        this.zzm = zzcgy;
        this.zzo = zzdhl;
        this.zzd = zzs.zzj().elapsedRealtime();
        zzu("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public static /* synthetic */ void zzq(zzdww zzdww, String str) {
        zzdww zzdww2 = zzdww;
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject(VungleApiImpl.CONFIG);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzchj zzchj = new zzchj();
                zzfqn zzh2 = zzfqe.zzh(zzchj, ((Long) zzbex.zzc().zzb(zzbjn.zzbh)).longValue(), TimeUnit.SECONDS, zzdww2.zzk);
                zzdww2.zzl.zza(next);
                zzdww2.zzo.zza(next);
                long elapsedRealtime = zzs.zzj().elapsedRealtime();
                Iterator<String> it = keys;
                zzdwp zzdwp = r1;
                zzdwp zzdwp2 = new zzdwp(zzdww, obj, zzchj, next, elapsedRealtime);
                zzh2.zze(zzdwp, zzdww2.zzi);
                arrayList.add(zzh2);
                zzdwv zzdwv = new zzdwv(zzdww, obj, next, elapsedRealtime, zzchj);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString(GraphRequest.FORMAT_PARAM, "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzbrw(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdww2.zzu(next, false, "", 0);
                try {
                    zzdww2.zzj.execute(new zzdwr(zzdww, zzdww2.zzh.zzb(next, new JSONObject()), zzdwv, arrayList2, next));
                } catch (zzezb unused2) {
                    try {
                        zzdwv.zzf("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzcgs.zzg("", e);
                    }
                }
                keys = it;
            }
            zzfqe.zzm(arrayList).zza(new zzdwq(zzdww2), zzdww2.zzi);
        } catch (JSONException e2) {
            zze.zzb("Malformed CLD response", e2);
        }
    }

    private final synchronized zzfqn<String> zzt() {
        String zzd2 = zzs.zzg().zzl().zzn().zzd();
        if (!TextUtils.isEmpty(zzd2)) {
            return zzfqe.zza(zzd2);
        }
        zzchj zzchj = new zzchj();
        zzs.zzg().zzl().zzp(new zzdwn(this, zzchj));
        return zzchj;
    }

    /* access modifiers changed from: private */
    public final void zzu(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbrm(str, z, i, str2));
    }

    public final void zza() {
        this.zzp = false;
    }

    public final void zzb(zzbrt zzbrt) {
        this.zze.zze(new zzdwl(this, zzbrt), this.zzj);
    }

    public final void zzc() {
        if (!zzble.zza.zze().booleanValue()) {
            if (this.zzm.zzc >= ((Integer) zzbex.zzc().zzb(zzbjn.zzbg)).intValue() && this.zzp) {
                if (!this.zza) {
                    synchronized (this) {
                        if (!this.zza) {
                            this.zzl.zzd();
                            this.zzo.zzd();
                            this.zze.zze(new zzdwm(this), this.zzi);
                            this.zza = true;
                            zzfqn<String> zzt = zzt();
                            this.zzk.schedule(new zzdwo(this), ((Long) zzbex.zzc().zzb(zzbjn.zzbi)).longValue(), TimeUnit.SECONDS);
                            zzfqe.zzp(zzt, new zzdwu(this), this.zzi);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zza) {
            zzu("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzc(Boolean.FALSE);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final List<zzbrm> zzd() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.zzn.keySet()) {
            zzbrm zzbrm = this.zzn.get(next);
            arrayList.add(new zzbrm(next, zzbrm.zzb, zzbrm.zzc, zzbrm.zzd));
        }
        return arrayList;
    }

    public final boolean zze() {
        return this.zzb;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        com.google.android.gms.internal.ads.zzcgs.zzg("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 74);
        r4.append("Failed to initialize adapter. ");
        r4.append(r5);
        r4.append(" does not implement the initialize() method.");
        r3.zzf(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzf(com.google.android.gms.internal.ads.zzezn r2, com.google.android.gms.internal.ads.zzbrq r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.zzg     // Catch:{ zzezb -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzezb -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzezb -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzf     // Catch:{ zzezb -> 0x0011 }
        L_0x000d:
            r2.zzy(r0, r3, r4)     // Catch:{ zzezb -> 0x0011 }
            return
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2.length()     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2 + 74
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0035 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = "Failed to initialize adapter. "
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            r4.append(r5)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = r4.toString()     // Catch:{ RemoteException -> 0x0035 }
            r3.zzf(r2)     // Catch:{ RemoteException -> 0x0035 }
            return
        L_0x0035:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzcgs.zzg(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdww.zzf(com.google.android.gms.internal.ads.zzezn, com.google.android.gms.internal.ads.zzbrq, java.util.List, java.lang.String):void");
    }

    public final /* synthetic */ Object zzg() throws Exception {
        this.zze.zzc(Boolean.TRUE);
        return null;
    }

    public final /* synthetic */ void zzh(Object obj, zzchj zzchj, String str, long j) {
        synchronized (obj) {
            if (!zzchj.isDone()) {
                zzu(str, false, "Timeout.", (int) (zzs.zzj().elapsedRealtime() - j));
                this.zzl.zzc(str, "timeout");
                this.zzo.zzc(str, "timeout");
                zzchj.zzc(Boolean.FALSE);
            }
        }
    }

    public final /* synthetic */ void zzi() {
        synchronized (this) {
            if (!this.zzc) {
                zzu("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzs.zzj().elapsedRealtime() - this.zzd));
                this.zze.zzd(new Exception());
            }
        }
    }

    public final /* synthetic */ void zzj(zzchj zzchj) {
        this.zzi.execute(new zzdws(this, zzchj));
    }

    public final /* synthetic */ void zzk() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }
}
