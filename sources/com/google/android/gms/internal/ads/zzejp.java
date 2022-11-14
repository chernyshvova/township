package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzejp {
    public final Map<String, zzejr> zza = new ConcurrentHashMap();
    public final Map<String, Map<String, List<zzejr>>> zzb = new ConcurrentHashMap();
    public final Executor zzc;
    public JSONObject zzd;

    public zzejp(Executor executor) {
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzg */
    public final synchronized void zzf() {
        JSONObject zzg = zzs.zzg().zzl().zzn().zzg();
        if (zzg != null) {
            try {
                JSONArray optJSONArray = zzg.optJSONArray("ad_unit_id_settings");
                this.zzd = zzg.optJSONObject("ad_unit_patterns");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        String optString = jSONObject.optString("ad_unit_id", "");
                        String optString2 = jSONObject.optString(GraphRequest.FORMAT_PARAM, "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("ad_networks");
                            if (optJSONArray2 != null) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                    ArrayList arrayList2 = new ArrayList();
                                    if (jSONObject2 != null) {
                                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                        Bundle bundle = new Bundle();
                                        if (optJSONObject2 != null) {
                                            Iterator<String> keys = optJSONObject2.keys();
                                            while (keys.hasNext()) {
                                                String next = keys.next();
                                                bundle.putString(next, optJSONObject2.optString(next, ""));
                                            }
                                        }
                                        JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                        if (optJSONArray3 != null) {
                                            ArrayList arrayList3 = new ArrayList();
                                            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                                String optString3 = optJSONArray3.optString(i3, "");
                                                if (!TextUtils.isEmpty(optString3)) {
                                                    arrayList3.add(optString3);
                                                }
                                            }
                                            int size = arrayList3.size();
                                            for (int i4 = 0; i4 < size; i4++) {
                                                String str = (String) arrayList3.get(i4);
                                                zzc(str);
                                                if (this.zza.get(str) != null) {
                                                    arrayList2.add(new zzejr(str, optString2, bundle));
                                                }
                                            }
                                        }
                                    }
                                    arrayList.addAll(arrayList2);
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                            Map map = this.zzb.get(optString2);
                            if (map == null) {
                                map = new ConcurrentHashMap();
                            }
                            this.zzb.put(optString2, map);
                            List list = (List) map.get(optString);
                            if (list == null) {
                                list = new ArrayList();
                            }
                            list.addAll(arrayList);
                            map.put(optString, list);
                        }
                    }
                }
            } catch (JSONException e) {
                zze.zzb("Malformed config loading JSON.", e);
            }
        }
    }

    public final void zza() {
        zzs.zzg().zzl().zzp(new zzejm(this));
        this.zzc.execute(new zzejn(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.util.List<android.os.Bundle>> zzb(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x006a
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x000d
            goto L_0x006a
        L_0x000d:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzejr>>> r0 = r3.zzb
            java.lang.Object r0 = r0.get(r4)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x001c
            java.util.Map r4 = java.util.Collections.emptyMap()
            return r4
        L_0x001c:
            java.lang.Object r1 = r0.get(r5)
            java.util.List r1 = (java.util.List) r1
            if (r1 != 0) goto L_0x0031
            org.json.JSONObject r1 = r3.zzd
            java.lang.String r4 = com.google.android.gms.internal.ads.zzdsz.zza(r1, r5, r4)
            java.lang.Object r4 = r0.get(r4)
            r1 = r4
            java.util.List r1 = (java.util.List) r1
        L_0x0031:
            if (r1 != 0) goto L_0x0038
            java.util.Map r4 = java.util.Collections.emptyMap()
            return r4
        L_0x0038:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.Iterator r5 = r1.iterator()
        L_0x0041:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0069
            java.lang.Object r0 = r5.next()
            com.google.android.gms.internal.ads.zzejr r0 = (com.google.android.gms.internal.ads.zzejr) r0
            java.lang.String r1 = r0.zza
            boolean r2 = r4.containsKey(r1)
            if (r2 != 0) goto L_0x005d
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4.put(r1, r2)
        L_0x005d:
            java.lang.Object r1 = r4.get(r1)
            java.util.List r1 = (java.util.List) r1
            android.os.Bundle r0 = r0.zzc
            r1.add(r0)
            goto L_0x0041
        L_0x0069:
            return r4
        L_0x006a:
            java.util.Map r4 = java.util.Collections.emptyMap()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejp.zzb(java.lang.String, java.lang.String):java.util.Map");
    }

    public final void zzc(String str) {
        if (!TextUtils.isEmpty(str) && !this.zza.containsKey(str)) {
            this.zza.put(str, new zzejr(str, "", new Bundle()));
        }
    }

    public final /* synthetic */ void zze() {
        this.zzc.execute(new zzejo(this));
    }
}
