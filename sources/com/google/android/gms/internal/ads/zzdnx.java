package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdnx implements zzdmi {
    @Nullable
    public final zzbvw zza;
    public final zzdbv zzb;
    public final zzdbb zzc;
    public final Context zzd;
    public final zzeye zze;
    public final zzcgy zzf;
    public final zzeyw zzg;
    public boolean zzh = false;
    public boolean zzi = false;
    public boolean zzj = true;
    @Nullable
    public final zzbvs zzk;
    @Nullable
    public final zzbvt zzl;

    public zzdnx(@Nullable zzbvs zzbvs, @Nullable zzbvt zzbvt, @Nullable zzbvw zzbvw, zzdbv zzdbv, zzdbb zzdbb, Context context, zzeye zzeye, zzcgy zzcgy, zzeyw zzeyw, byte[] bArr) {
        this.zzk = zzbvs;
        this.zzl = zzbvt;
        this.zza = zzbvw;
        this.zzb = zzdbv;
        this.zzc = zzdbb;
        this.zzd = context;
        this.zze = zzeye;
        this.zzf = zzcgy;
        this.zzg = zzeyw;
    }

    private final void zzi(View view) {
        try {
            zzbvw zzbvw = this.zza;
            if (zzbvw != null) {
                if (!zzbvw.zzu()) {
                    this.zza.zzw(ObjectWrapper.wrap(view));
                    this.zzc.onAdClicked();
                    return;
                }
            }
            zzbvs zzbvs = this.zzk;
            if (zzbvs != null) {
                if (!zzbvs.zzq()) {
                    this.zzk.zzn(ObjectWrapper.wrap(view));
                    this.zzc.onAdClicked();
                    return;
                }
            }
            zzbvt zzbvt = this.zzl;
            if (zzbvt != null && !zzbvt.zzo()) {
                this.zzl.zzl(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
            }
        } catch (RemoteException e) {
            zzcgs.zzj("Failed to call handleClick", e);
        }
    }

    public static final HashMap<String, View> zzy(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry next : map.entrySet()) {
                View view = (View) ((WeakReference) next.getValue()).get();
                if (view != null) {
                    hashMap.put((String) next.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.view.View r9, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r10, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r11, android.view.View.OnTouchListener r12, android.view.View.OnClickListener r13) {
        /*
            r8 = this;
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzeye r12 = r8.zze     // Catch:{ RemoteException -> 0x0124 }
            org.json.JSONObject r12 = r12.zzaf     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r13 = com.google.android.gms.internal.ads.zzbjn.zzbb     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Object r13 = r0.zzb(r13)     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ RemoteException -> 0x0124 }
            boolean r13 = r13.booleanValue()     // Catch:{ RemoteException -> 0x0124 }
            r0 = 1
            r1 = 0
            if (r13 == 0) goto L_0x00e0
            int r13 = r12.length()     // Catch:{ RemoteException -> 0x0124 }
            if (r13 != 0) goto L_0x0024
            goto L_0x00e0
        L_0x0024:
            if (r10 != 0) goto L_0x002c
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0124 }
            r13.<init>()     // Catch:{ RemoteException -> 0x0124 }
            goto L_0x002d
        L_0x002c:
            r13 = r10
        L_0x002d:
            if (r11 != 0) goto L_0x0035
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0124 }
            r2.<init>()     // Catch:{ RemoteException -> 0x0124 }
            goto L_0x0036
        L_0x0035:
            r2 = r11
        L_0x0036:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0124 }
            r3.<init>()     // Catch:{ RemoteException -> 0x0124 }
            r3.putAll(r13)     // Catch:{ RemoteException -> 0x0124 }
            r3.putAll(r2)     // Catch:{ RemoteException -> 0x0124 }
            java.util.Iterator r13 = r12.keys()     // Catch:{ RemoteException -> 0x0124 }
        L_0x0045:
            boolean r2 = r13.hasNext()     // Catch:{ RemoteException -> 0x0124 }
            if (r2 == 0) goto L_0x00e0
            java.lang.Object r2 = r13.next()     // Catch:{ RemoteException -> 0x0124 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ RemoteException -> 0x0124 }
            org.json.JSONArray r4 = r12.optJSONArray(r2)     // Catch:{ RemoteException -> 0x0124 }
            if (r4 == 0) goto L_0x0045
            java.lang.Object r5 = r3.get(r2)     // Catch:{ RemoteException -> 0x0124 }
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5     // Catch:{ RemoteException -> 0x0124 }
            if (r5 != 0) goto L_0x0062
        L_0x005f:
            r0 = 0
            goto L_0x00e0
        L_0x0062:
            java.lang.Object r5 = r5.get()     // Catch:{ RemoteException -> 0x0124 }
            if (r5 != 0) goto L_0x0069
            goto L_0x005f
        L_0x0069:
            java.lang.Class r5 = r5.getClass()     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzbjn.zzbc     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbjl r7 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ RemoteException -> 0x0124 }
            boolean r6 = r6.booleanValue()     // Catch:{ RemoteException -> 0x0124 }
            if (r6 == 0) goto L_0x00b3
            java.lang.String r6 = "3010"
            boolean r2 = r2.equals(r6)     // Catch:{ RemoteException -> 0x0124 }
            if (r2 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzbvw r2 = r8.zza     // Catch:{ RemoteException -> 0x0124 }
            r5 = 0
            if (r2 == 0) goto L_0x0093
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzq()     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x00a6
        L_0x0091:
            goto L_0x00ac
        L_0x0093:
            com.google.android.gms.internal.ads.zzbvs r2 = r8.zzk     // Catch:{ RemoteException -> 0x0124 }
            if (r2 == 0) goto L_0x009c
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzw()     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x00a6
        L_0x009c:
            com.google.android.gms.internal.ads.zzbvt r2 = r8.zzl     // Catch:{ RemoteException -> 0x0124 }
            if (r2 == 0) goto L_0x00a5
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzu()     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x00a6
        L_0x00a5:
            r2 = r5
        L_0x00a6:
            if (r2 == 0) goto L_0x00ac
            java.lang.Object r5 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{  }
        L_0x00ac:
            if (r5 != 0) goto L_0x00af
            goto L_0x005f
        L_0x00af:
            java.lang.Class r5 = r5.getClass()     // Catch:{ RemoteException -> 0x0124 }
        L_0x00b3:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0045 }
            r2.<init>()     // Catch:{ JSONException -> 0x0045 }
            com.google.android.gms.ads.internal.util.zzbv.zza(r4, r2)     // Catch:{ JSONException -> 0x0045 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ JSONException -> 0x0045 }
            android.content.Context r4 = r8.zzd     // Catch:{ JSONException -> 0x0045 }
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ JSONException -> 0x0045 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ JSONException -> 0x0045 }
        L_0x00c8:
            boolean r6 = r2.hasNext()     // Catch:{ JSONException -> 0x0045 }
            if (r6 == 0) goto L_0x005f
            java.lang.Object r6 = r2.next()     // Catch:{ JSONException -> 0x0045 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x0045 }
            java.lang.Class r6 = java.lang.Class.forName(r6, r1, r4)     // Catch:{ all -> 0x00c8 }
            boolean r6 = r6.isAssignableFrom(r5)     // Catch:{ all -> 0x00c8 }
            if (r6 == 0) goto L_0x00c8
            goto L_0x0045
        L_0x00e0:
            r8.zzj = r0     // Catch:{ RemoteException -> 0x0124 }
            java.util.HashMap r10 = zzy(r10)     // Catch:{ RemoteException -> 0x0124 }
            java.util.HashMap r11 = zzy(r11)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbvw r12 = r8.zza     // Catch:{ RemoteException -> 0x0124 }
            if (r12 == 0) goto L_0x00fa
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0124 }
            r12.zzx(r9, r10, r11)     // Catch:{ RemoteException -> 0x0124 }
            return
        L_0x00fa:
            com.google.android.gms.internal.ads.zzbvs r12 = r8.zzk     // Catch:{ RemoteException -> 0x0124 }
            if (r12 == 0) goto L_0x010f
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0124 }
            r12.zzy(r9, r10, r11)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbvs r10 = r8.zzk     // Catch:{ RemoteException -> 0x0124 }
            r10.zzo(r9)     // Catch:{ RemoteException -> 0x0124 }
            return
        L_0x010f:
            com.google.android.gms.internal.ads.zzbvt r12 = r8.zzl     // Catch:{ RemoteException -> 0x0124 }
            if (r12 == 0) goto L_0x0123
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0124 }
            r12.zzw(r9, r10, r11)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbvt r10 = r8.zzl     // Catch:{ RemoteException -> 0x0124 }
            r10.zzm(r9)     // Catch:{ RemoteException -> 0x0124 }
        L_0x0123:
            return
        L_0x0124:
            r9 = move-exception
            java.lang.String r10 = "Failed to call trackView"
            com.google.android.gms.internal.ads.zzcgs.zzj(r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdnx.zza(android.view.View, java.util.Map, java.util.Map, android.view.View$OnTouchListener, android.view.View$OnClickListener):void");
    }

    public final void zzb(View view, @Nullable Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzbvw zzbvw = this.zza;
            if (zzbvw != null) {
                zzbvw.zzy(wrap);
                return;
            }
            zzbvs zzbvs = this.zzk;
            if (zzbvs != null) {
                zzbvs.zzs(wrap);
                return;
            }
            zzbvt zzbvt = this.zzl;
            if (zzbvt != null) {
                zzbvt.zzq(wrap);
            }
        } catch (RemoteException e) {
            zzcgs.zzj("Failed to call untrackView", e);
        }
    }

    public final void zzc(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzi || !this.zze.zzH) {
            zzi(view);
        }
    }

    public final void zzd(String str) {
    }

    public final void zze(Bundle bundle) {
    }

    public final void zzf(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzi) {
            zzcgs.zzi("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zze.zzH) {
            zzcgs.zzi("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zzi(view);
        }
    }

    public final void zzg() {
        this.zzi = true;
    }

    public final boolean zzh() {
        return this.zze.zzH;
    }

    public final void zzj(View view, MotionEvent motionEvent, @Nullable View view2) {
    }

    public final void zzk(Bundle bundle) {
    }

    @Nullable
    public final JSONObject zzl(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    @Nullable
    public final JSONObject zzm(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    public final void zzn() {
    }

    public final void zzo(View view) {
    }

    public final void zzp(zzboc zzboc) {
    }

    public final void zzq() {
    }

    public final void zzr(@Nullable zzbgq zzbgq) {
        zzcgs.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzs(zzbgm zzbgm) {
        zzcgs.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzt() {
        throw null;
    }

    public final void zzu(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzh) {
                this.zzh = zzs.zzm().zzg(this.zzd, this.zzf.zza, this.zze.zzC.toString(), this.zzg.zzf);
            }
            if (this.zzj) {
                zzbvw zzbvw = this.zza;
                if (zzbvw != null) {
                    if (!zzbvw.zzt()) {
                        this.zza.zzv();
                        this.zzb.zza();
                        return;
                    }
                }
                zzbvs zzbvs = this.zzk;
                if (zzbvs != null) {
                    if (!zzbvs.zzp()) {
                        this.zzk.zzm();
                        this.zzb.zza();
                        return;
                    }
                }
                zzbvt zzbvt = this.zzl;
                if (zzbvt != null && !zzbvt.zzn()) {
                    this.zzl.zzk();
                    this.zzb.zza();
                }
            }
        } catch (RemoteException e) {
            zzcgs.zzj("Failed to call recordImpression", e);
        }
    }

    public final void zzv() {
    }

    public final boolean zzw(Bundle bundle) {
        return false;
    }

    public final void zzx() {
    }
}
