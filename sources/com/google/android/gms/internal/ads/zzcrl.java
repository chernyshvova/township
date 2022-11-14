package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcrl extends zzbgh {
    public final Context zza;
    public final zzcgy zzb;
    public final zzdss zzc;
    public final zzedp<zzezn, zzefk> zzd;
    public final zzejp zze;
    public final zzdww zzf;
    public final zzcfb zzg;
    public final zzdsx zzh;
    public final zzdxo zzi;
    @GuardedBy("this")
    public boolean zzj = false;

    public zzcrl(Context context, zzcgy zzcgy, zzdss zzdss, zzedp<zzezn, zzefk> zzedp, zzejp zzejp, zzdww zzdww, zzcfb zzcfb, zzdsx zzdsx, zzdxo zzdxo) {
        this.zza = context;
        this.zzb = zzcgy;
        this.zzc = zzdss;
        this.zzd = zzedp;
        this.zze = zzejp;
        this.zzf = zzdww;
        this.zzg = zzcfb;
        this.zzh = zzdsx;
        this.zzi = zzdxo;
    }

    @VisibleForTesting
    public final void zzb() {
        if (zzs.zzg().zzl().zzI()) {
            if (!zzs.zzm().zze(this.zza, zzs.zzg().zzl().zzK(), this.zzb.zza)) {
                zzs.zzg().zzl().zzJ(false);
                zzs.zzg().zzl().zzL("");
            }
        }
    }

    @VisibleForTesting
    public final void zzc(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzbvc> zzf2 = zzs.zzg().zzl().zzn().zzf();
        if (!zzf2.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzcgs.zzj("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzc.zzd()) {
                HashMap hashMap = new HashMap();
                for (zzbvc zzbvc : zzf2.values()) {
                    for (zzbvb next : zzbvc.zza) {
                        String str = next.zzk;
                        for (String next2 : next.zzc) {
                            if (!hashMap.containsKey(next2)) {
                                hashMap.put(next2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(next2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        zzedq<zzezn, zzefk> zza2 = this.zzd.zza(str2, jSONObject);
                        if (zza2 != null) {
                            zzezn zzezn = (zzezn) zza2.zzb;
                            if (!zzezn.zzn() && zzezn.zzq()) {
                                zzezn.zzr(this.zza, (zzefk) zza2.zzc, (List) entry.getValue());
                                String valueOf = String.valueOf(str2);
                                zzcgs.zzd(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                            }
                        }
                    } catch (zzezb e) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str2);
                        sb.append("\"");
                        zzcgs.zzj(sb.toString(), e);
                    }
                }
            }
        }
    }

    public final synchronized void zze() {
        if (this.zzj) {
            zzcgs.zzi("Mobile ads is initialized already.");
            return;
        }
        zzbjn.zza(this.zza);
        zzs.zzg().zze(this.zza, this.zzb);
        zzs.zzi().zza(this.zza);
        this.zzj = true;
        this.zzf.zzc();
        this.zze.zza();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcp)).booleanValue()) {
            this.zzh.zza();
        }
        this.zzi.zza();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgq)).booleanValue()) {
            zzche.zza.execute(new zzcri(this));
        }
    }

    public final synchronized void zzf(float f) {
        zzs.zzh().zza(f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzbjn.zza(r0)     // Catch:{ all -> 0x002e }
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzco     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x002e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002c
            com.google.android.gms.ads.internal.zze r0 = com.google.android.gms.ads.internal.zzs.zzk()     // Catch:{ all -> 0x002e }
            android.content.Context r1 = r4.zza     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzcgy r2 = r4.zzb     // Catch:{ all -> 0x002e }
            r3 = 0
            r0.zza(r1, r2, r5, r3)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)
            return
        L_0x002c:
            monitor-exit(r4)
            return
        L_0x002e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrl.zzg(java.lang.String):void");
    }

    public final synchronized void zzh(boolean z) {
        zzs.zzh().zzc(z);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzcgs.zzf("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzcgs.zzf("Context is null. Failed to open debug menu.");
            return;
        }
        zzau zzau = new zzau(context);
        zzau.zzc(str);
        zzau.zzd(this.zzb.zza);
        zzau.zzb();
    }

    public final void zzj(@Nullable String str, IObjectWrapper iObjectWrapper) {
        String str2;
        zzcrj zzcrj;
        zzbjn.zza(this.zza);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcr)).booleanValue()) {
            zzs.zzc();
            str2 = zzr.zzv(this.zza);
        } else {
            str2 = "";
        }
        boolean z = true;
        if (true != TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzbex.zzc().zzb(zzbjn.zzco)).booleanValue() | ((Boolean) zzbex.zzc().zzb(zzbjn.zzaB)).booleanValue();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaB)).booleanValue()) {
                zzcrj = new zzcrj(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                z = booleanValue;
                zzcrj = null;
            }
            if (z) {
                zzs.zzk().zza(this.zza, this.zzb, str, zzcrj);
            }
        }
    }

    public final synchronized float zzk() {
        return zzs.zzh().zzb();
    }

    public final synchronized boolean zzl() {
        return zzs.zzh().zzd();
    }

    public final String zzm() {
        return this.zzb.zza;
    }

    public final void zzn(String str) {
        this.zze.zzc(str);
    }

    public final void zzo(zzbvh zzbvh) throws RemoteException {
        this.zzc.zza(zzbvh);
    }

    public final void zzp(zzbrt zzbrt) throws RemoteException {
        this.zzf.zzb(zzbrt);
    }

    public final List<zzbrm> zzq() throws RemoteException {
        return this.zzf.zzd();
    }

    public final void zzr(zzbip zzbip) throws RemoteException {
        this.zzg.zzc(this.zza, zzbip);
    }

    public final void zzs() {
        this.zzf.zza();
    }

    public final void zzt(zzbgu zzbgu) throws RemoteException {
        this.zzi.zzk(zzbgu, zzdxn.API);
    }
}
