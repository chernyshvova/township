package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzedl implements zzbzl {
    public static zzfep zzb(@Nullable String str) {
        if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str)) {
            return zzfep.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzfep.JAVASCRIPT;
        }
        return zzfep.NONE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfeo zzl(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L_0x0020
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.google.android.gms.internal.ads.zzfeo r4 = com.google.android.gms.internal.ads.zzfeo.UNSPECIFIED
            return r4
        L_0x003e:
            com.google.android.gms.internal.ads.zzfeo r4 = com.google.android.gms.internal.ads.zzfeo.ONE_PIXEL
            return r4
        L_0x0041:
            com.google.android.gms.internal.ads.zzfeo r4 = com.google.android.gms.internal.ads.zzfeo.DEFINED_BY_JAVASCRIPT
            return r4
        L_0x0044:
            com.google.android.gms.internal.ads.zzfeo r4 = com.google.android.gms.internal.ads.zzfeo.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedl.zzl(java.lang.String):com.google.android.gms.internal.ads.zzfeo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfem zzm(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.google.android.gms.internal.ads.zzfem r4 = com.google.android.gms.internal.ads.zzfem.zzd
            return r4
        L_0x0040:
            com.google.android.gms.internal.ads.zzfem r4 = com.google.android.gms.internal.ads.zzfem.NATIVE_DISPLAY
            return r4
        L_0x0043:
            com.google.android.gms.internal.ads.zzfem r4 = com.google.android.gms.internal.ads.zzfem.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedl.zzm(java.lang.String):com.google.android.gms.internal.ads.zzfem");
    }

    public final boolean zza(Context context) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
            zzcgs.zzi("Omid flag is disabled");
            return false;
        } else if (zzfef.zzb()) {
            return true;
        } else {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdq)).booleanValue()) {
                zzfef.zza(context);
                return zzfef.zzb();
            }
            zzfef.zzc("1.3.3-google_20200416", context);
            return true;
        }
    }

    @Nullable
    public final String zzc(Context context) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
            return null;
        }
        return "a.1.3.3-google_20200416";
    }

    @Nullable
    public final IObjectWrapper zzd(String str, WebView webView, String str2, String str3, @Nullable String str4) {
        return zze(str, webView, "", "javascript", str4, "Google");
    }

    @Nullable
    public final IObjectWrapper zze(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue() || !zzfef.zzb()) {
            return null;
        }
        zzfeq zza = zzfeq.zza(str5, str);
        zzfep zzb = zzb("javascript");
        zzfep zzb2 = zzb(str4);
        if (zzb == zzfep.NONE) {
            return null;
        }
        return ObjectWrapper.wrap(zzfeh.zzf(zzfei.zzb(zzb, zzb2, true), zzfej.zza(zza, webView, "")));
    }

    @Nullable
    public final IObjectWrapper zzf(String str, WebView webView, String str2, String str3, @Nullable String str4, zzbzn zzbzn, zzbzm zzbzm, @Nullable String str5) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue() || !zzfef.zzb()) {
            return null;
        }
        zzfeq zza = zzfeq.zza("Google", str);
        zzfep zzb = zzb("javascript");
        zzfem zzm = zzm(zzbzm.toString());
        if (zzb == zzfep.NONE) {
            zzcgs.zzi("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzm == null) {
            String valueOf = String.valueOf(zzbzm);
            StringBuilder sb = new StringBuilder(valueOf.length() + 56);
            sb.append("Omid html session error; Unable to parse creative type: ");
            sb.append(valueOf);
            zzcgs.zzi(sb.toString());
            return null;
        } else {
            zzfep zzb2 = zzb(str4);
            if (zzm == zzfem.zzd && zzb2 == zzfep.NONE) {
                String valueOf2 = String.valueOf(str4);
                zzcgs.zzi(valueOf2.length() != 0 ? "Omid html session error; Video events owner unknown for video creative: ".concat(valueOf2) : new String("Omid html session error; Video events owner unknown for video creative: "));
                return null;
            }
            return ObjectWrapper.wrap(zzfeh.zzf(zzfei.zza(zzm, zzl(zzbzn.toString()), zzb, zzb2, true), zzfej.zzb(zza, webView, str5, "")));
        }
    }

    @Nullable
    public final IObjectWrapper zzg(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5, zzbzn zzbzn, zzbzm zzbzm, @Nullable String str6) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue() || !zzfef.zzb()) {
            return null;
        }
        zzfeq zza = zzfeq.zza(str5, str);
        zzfep zzb = zzb("javascript");
        zzfep zzb2 = zzb(str4);
        zzfem zzm = zzm(zzbzm.toString());
        if (zzb == zzfep.NONE) {
            zzcgs.zzi("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzm == null) {
            String valueOf = String.valueOf(zzbzm);
            StringBuilder sb = new StringBuilder(valueOf.length() + 54);
            sb.append("Omid js session error; Unable to parse creative type: ");
            sb.append(valueOf);
            zzcgs.zzi(sb.toString());
            return null;
        } else if (zzm == zzfem.zzd && zzb2 == zzfep.NONE) {
            String valueOf2 = String.valueOf(str4);
            zzcgs.zzi(valueOf2.length() != 0 ? "Omid js session error; Video events owner unknown for video creative: ".concat(valueOf2) : new String("Omid js session error; Video events owner unknown for video creative: "));
            return null;
        } else {
            return ObjectWrapper.wrap(zzfeh.zzf(zzfei.zza(zzm, zzl(zzbzn.toString()), zzb, zzb2, true), zzfej.zzc(zza, webView, str6, "")));
        }
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue() && zzfef.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfeh) {
                ((zzfeh) unwrap).zza();
            }
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue() && zzfef.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfeh) {
                ((zzfeh) unwrap).zzc();
            }
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper, View view) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue() && zzfef.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfeh) {
                ((zzfeh) unwrap).zzb(view);
            }
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, View view) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue() && zzfef.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfeh) {
                zzfeh zzfeh = (zzfeh) unwrap;
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdt)).booleanValue()) {
                    zzfeh.zzd(view, zzfen.NOT_VISIBLE, "Ad overlay");
                } else {
                    zzfeh.zze(view);
                }
            }
        }
    }
}
