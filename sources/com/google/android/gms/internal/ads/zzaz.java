package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.vungle.warren.downloader.AssetDownloader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaz {
    @Nullable
    public static zzl zza(zzy zzy) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        zzy zzy2 = zzy;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzy2.zzc;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long zzb = str != null ? zzb(str) : 0;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            int i2 = 0;
            j2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j = 0;
        }
        String str3 = map.get("Expires");
        long zzb2 = str3 != null ? zzb(str3) : 0;
        String str4 = map.get(AssetDownloader.LAST_MODIFIED);
        long zzb3 = str4 != null ? zzb(str4) : 0;
        String str5 = map.get(AssetDownloader.ETAG);
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i != 0) {
                j5 = j4;
            } else {
                Long.signum(j);
                j5 = (j * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (zzb <= 0 || zzb2 < zzb) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (zzb2 - zzb);
                j3 = j4;
            }
        }
        zzl zzl = new zzl();
        zzl.zza = zzy2.zzb;
        zzl.zzb = str5;
        zzl.zzf = j4;
        zzl.zze = j3;
        zzl.zzc = zzb;
        zzl.zzd = zzb3;
        zzl.zzg = map;
        zzl.zzh = zzy2.zzd;
        return zzl;
    }

    public static long zzb(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "-1".equals(str)) {
                zzao.zza("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            zzao.zzd(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static String zzc(long j) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    public static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
