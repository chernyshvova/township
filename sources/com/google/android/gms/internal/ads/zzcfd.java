package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcfd {
    public static String zza(String str, Context context, boolean z) {
        String zzl;
        if ((((Boolean) zzbex.zzc().zzb(zzbjn.zzag)).booleanValue() && !z) || !zzs.zzA().zzb(context) || TextUtils.isEmpty(str) || (zzl = zzs.zzA().zzl(context)) == null) {
            return str;
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzY)).booleanValue()) {
            String str2 = (String) zzbex.zzc().zzb(zzbjn.zzZ);
            if (!str.contains(str2)) {
                return str;
            }
            if (zzs.zzc().zzl(str)) {
                zzs.zzA().zzn(context, zzl);
                return zzd(str, context).replace(str2, zzl);
            } else if (!zzs.zzc().zzm(str)) {
                return str;
            } else {
                zzs.zzA().zzo(context, zzl);
                return zzd(str, context).replace(str2, zzl);
            }
        } else if (str.contains("fbs_aeid")) {
            return str;
        } else {
            if (zzs.zzc().zzl(str)) {
                zzs.zzA().zzn(context, zzl);
                return zzc(zzd(str, context), "fbs_aeid", zzl).toString();
            } else if (!zzs.zzc().zzm(str)) {
                return str;
            } else {
                zzs.zzA().zzo(context, zzl);
                return zzc(zzd(str, context), "fbs_aeid", zzl).toString();
            }
        }
    }

    public static String zzb(Uri uri, Context context) {
        if (!zzs.zzA().zzb(context)) {
            return uri.toString();
        }
        String zzl = zzs.zzA().zzl(context);
        if (zzl == null) {
            return uri.toString();
        }
        String str = (String) zzbex.zzc().zzb(zzbjn.zzZ);
        String uri2 = uri.toString();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzY)).booleanValue() && uri2.contains(str)) {
            zzs.zzA().zzn(context, zzl);
            return zzd(uri2, context).replace(str, zzl);
        } else if (!TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            return uri2;
        } else {
            String uri3 = zzc(zzd(uri2, context), "fbs_aeid", zzl).toString();
            zzs.zzA().zzn(context, zzl);
            return uri3;
        }
    }

    @VisibleForTesting
    public static Uri zzc(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        StringBuilder sb = new StringBuilder(str.substring(0, i));
        GeneratedOutlineSupport.outline34(sb, str2, "=", str3, "&");
        sb.append(str.substring(i));
        return Uri.parse(sb.toString());
    }

    public static String zzd(String str, Context context) {
        String zzj = zzs.zzA().zzj(context);
        String zzk = zzs.zzA().zzk(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzj)) {
            str = zzc(str, "gmp_app_id", zzj).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzk)) ? str : zzc(str, "fbs_aiid", zzk).toString();
    }
}
