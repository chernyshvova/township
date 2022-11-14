package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.ads.internal.util.zzci;
import com.google.android.gms.ads.internal.util.zze;
import com.helpshift.analytics.AnalyticsEventKey;
import com.swrve.sdk.conversations.engine.model.UserInputResult;
import com.swrve.sdk.conversations.engine.model.styles.ConversationColorStyle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckm implements zzbps<zzciz> {
    public boolean zza;

    public static int zzb(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                zzbev.zza();
                i = zzcgl.zzs(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(str.length() + 34 + str2.length());
                sb.append("Could not parse ");
                sb.append(str);
                sb.append(" in a video GMSG: ");
                sb.append(str2);
                zzcgs.zzi(sb.toString());
            }
        }
        if (zze.zzc()) {
            StringBuilder sb2 = new StringBuilder(str.length() + 48 + String.valueOf(str2).length());
            GeneratedOutlineSupport.outline34(sb2, "Parse pixels for ", str, ", got string ", str2);
            sb2.append(", int ");
            sb2.append(i);
            sb2.append(CodelessMatcher.CURRENT_CLASS_NAME);
            zze.zza(sb2.toString());
        }
        return i;
    }

    public static void zzc(zzcin zzcin, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcin.zzw(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzcgs.zzi(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzcin.zzx(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcin.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcin.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcin.zzA(Integer.parseInt(str5));
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int i;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        zzciz zzciz = (zzciz) obj;
        String str5 = (String) map.get("action");
        if (str5 == null) {
            zzcgs.zzi("Action missing from video GMSG.");
            return;
        }
        if (zzcgs.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(str5.length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str5);
            sb.append(" ");
            sb.append(jSONObject2);
            zzcgs.zzd(sb.toString());
        }
        if (NotificationCompat.WearableExtender.KEY_BACKGROUND.equals(str5)) {
            String str6 = (String) map.get(ConversationColorStyle.TYPE_COLOR);
            if (TextUtils.isEmpty(str6)) {
                zzcgs.zzi("Color parameter missing from background video GMSG.");
                return;
            }
            try {
                zzciz.setBackgroundColor(Color.parseColor(str6));
            } catch (IllegalArgumentException unused) {
                zzcgs.zzi("Invalid color parameter in background video GMSG.");
            }
        } else if ("playerBackground".equals(str5)) {
            String str7 = (String) map.get(ConversationColorStyle.TYPE_COLOR);
            if (TextUtils.isEmpty(str7)) {
                zzcgs.zzi("Color parameter missing from playerBackground video GMSG.");
                return;
            }
            try {
                zzciz.zzw(Color.parseColor(str7));
            } catch (IllegalArgumentException unused2) {
                zzcgs.zzi("Invalid color parameter in playerBackground video GMSG.");
            }
        } else {
            if ("decoderProps".equals(str5)) {
                String str8 = (String) map.get("mimeTypes");
                if (str8 == null) {
                    zzcgs.zzi("No MIME types specified for decoder properties inspection.");
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", "decoderProps");
                    hashMap.put("error", "missingMimeTypes");
                    zzciz.zze("onVideoEvent", hashMap);
                    return;
                }
                HashMap hashMap2 = new HashMap();
                for (String str9 : str8.split(",")) {
                    hashMap2.put(str9, zzci.zza(str9.trim()));
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("event", "decoderProps");
                hashMap3.put("mimeTypes", hashMap2);
                zzciz.zze("onVideoEvent", hashMap3);
                return;
            }
            zzcio zzf = zzciz.zzf();
            if (zzf == null) {
                zzcgs.zzi("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str5);
            boolean equals2 = "position".equals(str5);
            if (equals || equals2) {
                Context context = zzciz.getContext();
                int zzb = zzb(context, map, "x", 0);
                int zzb2 = zzb(context, map, "y", 0);
                int zzb3 = zzb(context, map, "w", -1);
                if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzck)).booleanValue()) {
                    if (zze.zzc()) {
                        StringBuilder outline22 = GeneratedOutlineSupport.outline22(110, "Calculate width with original width ", zzb3, ", videoHost.getVideoBoundingWidth() ", zzciz.zzz());
                        outline22.append(", x ");
                        outline22.append(zzb);
                        outline22.append(CodelessMatcher.CURRENT_CLASS_NAME);
                        zze.zza(outline22.toString());
                    }
                    i = Math.min(zzb3, zzciz.zzz() - zzb);
                } else if (zzb3 == -1) {
                    i = zzciz.zzz();
                } else {
                    i = Math.min(zzb3, zzciz.zzz());
                }
                int zzb4 = zzb(context, map, "h", -1);
                if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzck)).booleanValue()) {
                    if (zze.zzc()) {
                        StringBuilder outline222 = GeneratedOutlineSupport.outline22(113, "Calculate height with original height ", zzb4, ", videoHost.getVideoBoundingHeight() ", zzciz.zzy());
                        outline222.append(", y ");
                        outline222.append(zzb2);
                        outline222.append(CodelessMatcher.CURRENT_CLASS_NAME);
                        zze.zza(outline222.toString());
                    }
                    i2 = Math.min(zzb4, zzciz.zzy() - zzb2);
                } else if (zzb4 == -1) {
                    i2 = zzciz.zzy();
                } else {
                    i2 = Math.min(zzb4, zzciz.zzy());
                }
                int i4 = i2;
                try {
                    i3 = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException unused3) {
                    i3 = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzf.zzc() != null) {
                    zzf.zza(zzb, zzb2, i, i4);
                    return;
                }
                zzf.zzb(zzb, zzb2, i, i4, i3, parseBoolean, new zzciy((String) map.get("flags")));
                zzcin zzc = zzf.zzc();
                if (zzc != null) {
                    zzc(zzc, map);
                    return;
                }
                return;
            }
            zzcnn zzh = zzciz.zzh();
            if (zzh != null) {
                if ("timeupdate".equals(str5)) {
                    String str10 = (String) map.get("currentTime");
                    if (str10 == null) {
                        zzcgs.zzi("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzh.zzd(Float.parseFloat(str10));
                        return;
                    } catch (NumberFormatException unused4) {
                        if (str10.length() != 0) {
                            str4 = "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str10);
                        } else {
                            str4 = new String("Could not parse currentTime parameter from timeupdate video GMSG: ");
                        }
                        zzcgs.zzi(str4);
                        return;
                    }
                } else if ("skip".equals(str5)) {
                    zzh.zzr();
                    return;
                }
            }
            zzcin zzc2 = zzf.zzc();
            if (zzc2 == null) {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("event", "no_video_view");
                zzciz.zze("onVideoEvent", hashMap4);
            } else if ("click".equals(str5)) {
                Context context2 = zzciz.getContext();
                int zzb5 = zzb(context2, map, "x", 0);
                int zzb6 = zzb(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zzb5, (float) zzb6, 0);
                zzc2.zzB(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str5)) {
                String str11 = (String) map.get("time");
                if (str11 == null) {
                    zzcgs.zzi("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzc2.zzs((int) (Float.parseFloat(str11) * 1000.0f));
                } catch (NumberFormatException unused5) {
                    if (str11.length() != 0) {
                        str3 = "Could not parse time parameter from currentTime video GMSG: ".concat(str11);
                    } else {
                        str3 = new String("Could not parse time parameter from currentTime video GMSG: ");
                    }
                    zzcgs.zzi(str3);
                }
            } else if ("hide".equals(str5)) {
                zzc2.setVisibility(4);
            } else if ("load".equals(str5)) {
                zzc2.zzp();
            } else if ("loadControl".equals(str5)) {
                zzc(zzc2, map);
            } else if ("muted".equals(str5)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzc2.zzt();
                } else {
                    zzc2.zzu();
                }
            } else if ("pause".equals(str5)) {
                zzc2.zzq();
            } else if (UserInputResult.TYPE_VIDEO_PLAY.equals(str5)) {
                zzc2.zzr();
            } else if ("show".equals(str5)) {
                zzc2.setVisibility(0);
            } else if (AnalyticsEventKey.FAQ_SOURCE.equals(str5)) {
                String str12 = (String) map.get(AnalyticsEventKey.FAQ_SOURCE);
                Integer num = null;
                if (map.containsKey("periodicReportIntervalMs")) {
                    try {
                        num = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
                    } catch (NumberFormatException unused6) {
                        String str13 = (String) map.get("periodicReportIntervalMs");
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str13).length() + 65);
                        sb2.append("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ");
                        sb2.append(str13);
                        zzcgs.zzi(sb2.toString());
                    }
                }
                String[] strArr = {str12};
                String str14 = (String) map.get("demuxed");
                if (str14 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str14);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                            strArr2[i5] = jSONArray.getString(i5);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused7) {
                        if (str14.length() != 0) {
                            str2 = "Malformed demuxed URL list for playback: ".concat(str14);
                        } else {
                            str2 = new String("Malformed demuxed URL list for playback: ");
                        }
                        zzcgs.zzi(str2);
                        strArr = new String[]{str12};
                    }
                }
                if (num != null) {
                    zzciz.zzo(num.intValue());
                }
                zzc2.zzn(str12, strArr);
            } else if ("touchMove".equals(str5)) {
                Context context3 = zzciz.getContext();
                zzc2.zzo((float) zzb(context3, map, "dx", 0), (float) zzb(context3, map, "dy", 0));
                if (!this.zza) {
                    zzciz.zzl();
                    this.zza = true;
                }
            } else if ("volume".equals(str5)) {
                String str15 = (String) map.get("volume");
                if (str15 == null) {
                    zzcgs.zzi("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzc2.zzv(Float.parseFloat(str15));
                } catch (NumberFormatException unused8) {
                    if (str15.length() != 0) {
                        str = "Could not parse volume parameter from volume video GMSG: ".concat(str15);
                    } else {
                        str = new String("Could not parse volume parameter from volume video GMSG: ");
                    }
                    zzcgs.zzi(str);
                }
            } else if ("watermark".equals(str5)) {
                zzc2.zzC();
            } else {
                zzcgs.zzi(str5.length() != 0 ? "Unknown video action: ".concat(str5) : new String("Unknown video action: "));
            }
        }
    }
}
