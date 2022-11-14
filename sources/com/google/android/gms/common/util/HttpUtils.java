package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class HttpUtils {
    public static final Pattern zza = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    public static final Pattern zzb = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    public static final Pattern zzc = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    @RecentlyNonNull
    @KeepForSdk
    public static Map<String, String> parse(@RecentlyNonNull URI uri, @RecentlyNonNull String str) {
        Map<String, String> emptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        HashMap hashMap = emptyMap;
        if (rawQuery != null) {
            hashMap = emptyMap;
            if (rawQuery.length() > 0) {
                HashMap hashMap2 = new HashMap();
                Scanner scanner = new Scanner(rawQuery);
                scanner.useDelimiter("&");
                while (scanner.hasNext()) {
                    String[] split = scanner.next().split("=");
                    int length = split.length;
                    if (length == 0 || length > 2) {
                        throw new IllegalArgumentException("bad parameter");
                    }
                    hashMap2.put(zza(split[0], str), length == 2 ? zza(split[1], str) : null);
                }
                hashMap = hashMap2;
            }
        }
        return hashMap;
    }

    public static String zza(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
