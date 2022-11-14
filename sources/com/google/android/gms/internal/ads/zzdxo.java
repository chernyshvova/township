package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.ads.internal.zzs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdxo implements zzdxw, zzdwz {
    public final zzdxv zza;
    public final zzdxx zzb;
    public final zzdxa zzc;
    public final zzdxj zzd;
    public final zzdwy zze;
    public final String zzf;
    public final Map<String, List<zzdxc>> zzg;
    public String zzh = JsonUtils.EMPTY_JSON;
    public String zzi = "";
    public long zzj = RecyclerView.FOREVER_NS;
    public zzdxk zzk = zzdxk.NONE;
    public boolean zzl;
    public int zzm;
    public boolean zzn;
    public zzdxn zzo = zzdxn.UNKNOWN;

    public zzdxo(zzdxv zzdxv, zzdxx zzdxx, zzdxa zzdxa, Context context, zzcgy zzcgy, zzdxj zzdxj) {
        this.zza = zzdxv;
        this.zzb = zzdxx;
        this.zzc = zzdxa;
        this.zzg = new HashMap();
        this.zze = new zzdwy(context);
        this.zzf = zzcgy.zza;
        this.zzd = zzdxj;
        zzs.zzm().zza(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzo(boolean r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzl     // Catch:{ all -> 0x003d }
            if (r0 != r2) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r1.zzl = r2     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzbjn.zzgq     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x003d }
            java.lang.Object r2 = r0.zzb(r2)     // Catch:{ all -> 0x003d }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x003d }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0027
            com.google.android.gms.ads.internal.util.zzay r2 = com.google.android.gms.ads.internal.zzs.zzm()     // Catch:{ all -> 0x003d }
            boolean r2 = r2.zzk()     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x002b
        L_0x0027:
            r1.zzs()     // Catch:{ all -> 0x003d }
            goto L_0x0034
        L_0x002b:
            boolean r2 = r1.zzn()     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0034
            r1.zzt()     // Catch:{ all -> 0x003d }
        L_0x0034:
            if (r3 == 0) goto L_0x003b
            r1.zzu()     // Catch:{ all -> 0x003d }
            monitor-exit(r1)
            return
        L_0x003b:
            monitor-exit(r1)
            return
        L_0x003d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxo.zzo(boolean, boolean):void");
    }

    private final synchronized void zzp(zzdxk zzdxk, boolean z) {
        if (this.zzk != zzdxk) {
            if (zzn()) {
                zzt();
            }
            this.zzk = zzdxk;
            if (zzn()) {
                zzs();
            }
            if (z) {
                zzu();
            }
        }
    }

    private final synchronized JSONObject zzq() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry next : this.zzg.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (zzdxc zzdxc : (List) next.getValue()) {
                if (zzdxc.zzb()) {
                    jSONArray.put(zzdxc.zzc());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) next.getKey(), jSONArray);
            }
        }
        return jSONObject;
    }

    private final void zzr() {
        this.zzn = true;
        this.zzd.zza();
        this.zza.zzg(this);
        this.zzb.zza(this);
        this.zzc.zza(this);
        zzv(zzs.zzg().zzl().zzG());
    }

    private final synchronized void zzs() {
        zzdxk zzdxk = zzdxk.NONE;
        int ordinal = this.zzk.ordinal();
        if (ordinal == 1) {
            this.zzb.zzb();
        } else if (ordinal == 2) {
            this.zzc.zzb();
        }
    }

    private final synchronized void zzt() {
        zzdxk zzdxk = zzdxk.NONE;
        int ordinal = this.zzk.ordinal();
        if (ordinal == 1) {
            this.zzb.zzc();
        } else if (ordinal == 2) {
            this.zzc.zzc();
        }
    }

    private final void zzu() {
        zzs.zzg().zzl().zzH(zzh());
    }

    private final synchronized void zzv(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                zzo(jSONObject.optBoolean("isTestMode", false), false);
                zzp(zzdxk.zza(jSONObject.optString("gesture", "NONE")), false);
                this.zzh = jSONObject.optString("networkExtras", JsonUtils.EMPTY_JSON);
                this.zzj = jSONObject.optLong("networkExtrasExpirationSecs", RecyclerView.FOREVER_NS);
            } catch (JSONException unused) {
            }
        }
    }

    public final void zza() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue()) {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgq)).booleanValue() || !zzs.zzg().zzl().zzI()) {
                String zzG = zzs.zzg().zzl().zzG();
                if (!TextUtils.isEmpty(zzG)) {
                    try {
                        if (new JSONObject(zzG).optBoolean("isTestMode", false)) {
                            zzr();
                        }
                    } catch (JSONException unused) {
                    }
                }
            } else {
                zzr();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r2 != false) goto L_0x000c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.zzn
            if (r0 != 0) goto L_0x000a
            if (r2 == 0) goto L_0x0015
            r1.zzr()
            goto L_0x000c
        L_0x000a:
            if (r2 == 0) goto L_0x0015
        L_0x000c:
            boolean r2 = r1.zzl
            if (r2 == 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            r1.zzs()
            return
        L_0x0015:
            boolean r2 = r1.zzn()
            if (r2 != 0) goto L_0x001e
            r1.zzt()
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxo.zzb(boolean):void");
    }

    public final void zzc(boolean z) {
        if (!this.zzn && z) {
            zzr();
        }
        zzo(z, true);
    }

    public final synchronized boolean zzd() {
        return this.zzl;
    }

    public final void zze(zzdxk zzdxk) {
        zzp(zzdxk, true);
    }

    public final zzdxk zzf() {
        return this.zzk;
    }

    public final synchronized String zzg() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue()) {
            if (zzn()) {
                if (this.zzj < zzs.zzj().currentTimeMillis() / 1000) {
                    this.zzh = JsonUtils.EMPTY_JSON;
                    this.zzj = RecyclerView.FOREVER_NS;
                    return "";
                } else if (this.zzh.equals(JsonUtils.EMPTY_JSON)) {
                    return "";
                } else {
                    return this.zzh;
                }
            }
        }
        return "";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|(1:7)|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzh() {
        /*
            r7 = this;
            monitor-enter(r7)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0039 }
            r0.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "isTestMode"
            boolean r2 = r7.zzl     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            java.lang.String r1 = "gesture"
            com.google.android.gms.internal.ads.zzdxk r2 = r7.zzk     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            long r1 = r7.zzj     // Catch:{ JSONException -> 0x0033 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ JSONException -> 0x0033 }
            long r3 = r3.currentTimeMillis()     // Catch:{ JSONException -> 0x0033 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0033
            java.lang.String r1 = "networkExtras"
            java.lang.String r2 = r7.zzh     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            java.lang.String r1 = "networkExtrasExpirationSecs"
            long r2 = r7.zzj     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
        L_0x0033:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0039 }
            monitor-exit(r7)
            return r0
        L_0x0039:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxo.zzh():java.lang.String");
    }

    public final synchronized void zzi(String str, long j) {
        this.zzh = str;
        this.zzj = j;
        zzu();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzj(java.lang.String r4, com.google.android.gms.internal.ads.zzdxc r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzgb     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x005c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x005a
            boolean r0 = r3.zzn()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x001a
            goto L_0x005a
        L_0x001a:
            int r0 = r3.zzm     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzbjn.zzgd     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x005c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x005c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x005c }
            if (r0 < r1) goto L_0x0035
            java.lang.String r4 = "Maximum number of ad requests stored reached. Dropping the current request."
            com.google.android.gms.internal.ads.zzcgs.zzi(r4)     // Catch:{ all -> 0x005c }
            monitor-exit(r3)
            return
        L_0x0035:
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzdxc>> r0 = r3.zzg     // Catch:{ all -> 0x005c }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x0047
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzdxc>> r0 = r3.zzg     // Catch:{ all -> 0x005c }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x005c }
            r1.<init>()     // Catch:{ all -> 0x005c }
            r0.put(r4, r1)     // Catch:{ all -> 0x005c }
        L_0x0047:
            int r0 = r3.zzm     // Catch:{ all -> 0x005c }
            int r0 = r0 + 1
            r3.zzm = r0     // Catch:{ all -> 0x005c }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzdxc>> r0 = r3.zzg     // Catch:{ all -> 0x005c }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x005c }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x005c }
            r4.add(r5)     // Catch:{ all -> 0x005c }
            monitor-exit(r3)
            return
        L_0x005a:
            monitor-exit(r3)
            return
        L_0x005c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxo.zzj(java.lang.String, com.google.android.gms.internal.ads.zzdxc):void");
    }

    public final synchronized void zzk(zzbgu zzbgu, zzdxn zzdxn) {
        if (!zzn()) {
            try {
                zzbgu.zze(zzezr.zzd(18, (String) null, (zzbdd) null));
            } catch (RemoteException unused) {
                zzcgs.zzi("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
            }
        } else {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue()) {
                try {
                    zzbgu.zze(zzezr.zzd(1, (String) null, (zzbdd) null));
                } catch (RemoteException unused2) {
                    zzcgs.zzi("Ad inspector had an internal error.");
                }
            } else {
                this.zzo = zzdxn;
                this.zza.zzh(zzbgu, new zzbpt(this));
            }
        }
    }

    public final synchronized void zzl(String str) {
        this.zzi = str;
    }

    public final synchronized JSONObject zzm() {
        JSONObject jSONObject;
        String str;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "ANDROID");
            jSONObject.put("internalSdkVersion", this.zzf);
            jSONObject.put("adapters", this.zzd.zzb());
            if (this.zzj < zzs.zzj().currentTimeMillis() / 1000) {
                this.zzh = JsonUtils.EMPTY_JSON;
            }
            jSONObject.put("networkExtras", this.zzh);
            jSONObject.put("adSlots", zzq());
            jSONObject.put("appInfo", this.zze.zza());
            String zzd2 = zzs.zzg().zzl().zzn().zzd();
            if (!TextUtils.isEmpty(zzd2)) {
                jSONObject.put("cld", new JSONObject(zzd2));
            }
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgr)).booleanValue() && !TextUtils.isEmpty(this.zzi)) {
                String valueOf = String.valueOf(this.zzi);
                if (valueOf.length() != 0) {
                    str = "Policy violation data: ".concat(valueOf);
                } else {
                    str = new String("Policy violation data: ");
                }
                zzcgs.zzd(str);
                jSONObject.put("policyViolations", new JSONObject(this.zzi));
            }
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgq)).booleanValue()) {
                jSONObject.put("openAction", this.zzo);
                jSONObject.put("gesture", this.zzk);
            }
        } catch (JSONException e) {
            zzs.zzg().zzh(e, "Inspector.toJson");
            zzcgs.zzj("Ad inspector encountered an error", e);
        }
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        return r2.zzl || com.google.android.gms.ads.internal.zzs.zzm().zzk();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzn() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzgq     // Catch:{ all -> 0x002b }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x002b }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x002b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0027
            boolean r0 = r2.zzl     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0025
            com.google.android.gms.ads.internal.util.zzay r0 = com.google.android.gms.ads.internal.zzs.zzm()     // Catch:{ all -> 0x002b }
            boolean r0 = r0.zzk()     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0022
            goto L_0x0025
        L_0x0022:
            r0 = 0
        L_0x0023:
            monitor-exit(r2)
            return r0
        L_0x0025:
            r0 = 1
            goto L_0x0023
        L_0x0027:
            boolean r0 = r2.zzl     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return r0
        L_0x002b:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x002f
        L_0x002e:
            throw r0
        L_0x002f:
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxo.zzn():boolean");
    }
}
