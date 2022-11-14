package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcky implements zzbps<zzciz> {
    public static final Integer zzb(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(str.length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzcgs.zzi(sb.toString());
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzckx zzckx;
        zzciz zzciz = (zzciz) obj;
        if (zzcgs.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(valueOf.length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzcgs.zzd(sb.toString());
        }
        zzs.zzy();
        if (!map.containsKey("abort")) {
            String str = (String) map.get(AnalyticsEventKey.FAQ_SOURCE);
            Integer zzb = zzb(map, "periodicReportIntervalMs");
            Integer zzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
            Integer zzb3 = zzb(map, "exoPlayerIdleIntervalMs");
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        zzcgs.zzi(str2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(str2) : new String("Malformed demuxed URL list for precache: "));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (zzckq.zzc(zzciz) != null) {
                    zzcgs.zzi("Precache task is already running.");
                    return;
                } else if (zzciz.zzk() == null) {
                    zzcgs.zzi("Precache requires a dependency provider.");
                    return;
                } else {
                    zzciy zzciy = new zzciy((String) map.get("flags"));
                    Integer zzb4 = zzb(map, "player");
                    if (zzb4 == null) {
                        zzb4 = 0;
                    }
                    if (zzb != null) {
                        zzciz.zzo(zzb.intValue());
                    }
                    if (zzb2 != null) {
                        zzciz.zzB(zzb2.intValue());
                    }
                    if (zzb3 != null) {
                        zzciz.zzC(zzb3.intValue());
                    }
                    int intValue = zzb4.intValue();
                    zzckk zzckk = zzciz.zzk().zzc;
                    if (intValue > 0) {
                        int zzao = zzciq.zzao();
                        if (zzao < zzciy.zzh) {
                            zzckx = new zzclf(zzciz, zzciy);
                        } else if (zzao < zzciy.zzb) {
                            zzckx = new zzcld(zzciz, zzciy);
                        } else {
                            zzckx = new zzclb(zzciz);
                        }
                    } else {
                        zzckx = new zzcla(zzciz);
                    }
                    new zzckp(zzciz, zzckx, str, strArr).zzb();
                }
            } else {
                zzckp zzc = zzckq.zzc(zzciz);
                if (zzc != null) {
                    zzckx = zzc.zzb;
                } else {
                    zzcgs.zzi("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb5 = zzb(map, "minBufferMs");
            if (zzb5 != null) {
                zzckx.zzd(zzb5.intValue());
            }
            Integer zzb6 = zzb(map, "maxBufferMs");
            if (zzb6 != null) {
                zzckx.zzc(zzb6.intValue());
            }
            Integer zzb7 = zzb(map, "bufferForPlaybackMs");
            if (zzb7 != null) {
                zzckx.zze(zzb7.intValue());
            }
            Integer zzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
            if (zzb8 != null) {
                zzckx.zzf(zzb8.intValue());
            }
        } else if (!zzckq.zzd(zzciz)) {
            zzcgs.zzi("Precache abort but no precache task running.");
        }
    }
}
