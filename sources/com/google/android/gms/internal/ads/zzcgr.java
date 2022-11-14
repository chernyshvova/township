package com.google.android.gms.internal.ads;

import android.content.Context;
import android.provider.Settings;
import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcgr {
    public static final /* synthetic */ int zza = 0;
    public static final Object zzb = new Object();
    @GuardedBy("lock")
    public static boolean zzc = false;
    @GuardedBy("lock")
    public static boolean zzd = false;
    public static final Clock zze = DefaultClock.getInstance();
    public static final Set<String> zzf = new HashSet(Arrays.asList(new String[0]));
    public final List<String> zzg;

    public zzcgr() {
        this((String) null);
    }

    public static void zzg() {
        synchronized (zzb) {
            zzc = false;
            zzd = false;
            zzcgs.zzi("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzh(boolean z) {
        synchronized (zzb) {
            zzc = true;
            zzd = z;
        }
    }

    public static boolean zzi() {
        boolean z;
        synchronized (zzb) {
            z = zzc;
        }
        return z;
    }

    public static boolean zzj() {
        boolean z;
        synchronized (zzb) {
            z = false;
            if (zzc && zzd) {
                z = true;
            }
        }
        return z;
    }

    public static boolean zzk(Context context) {
        if (!zzbkx.zza.zze().booleanValue()) {
            return false;
        }
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            zzcgs.zzj("Fail to determine debug setting.", e);
            return false;
        }
    }

    public static final /* synthetic */ void zzl(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        zzq(jsonWriter, map);
        jsonWriter.endObject();
    }

    public static final /* synthetic */ void zzm(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zzq(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    private final void zzn(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        zzr("onNetworkRequest", new zzcgm(str, str2, map, bArr));
    }

    private final void zzo(@Nullable Map<String, ?> map, int i) {
        zzr("onNetworkResponse", new zzcgn(i, map));
    }

    private final void zzp(@Nullable String str) {
        zzr("onNetworkRequestError", new zzcgp(str));
    }

    public static void zzq(JsonWriter jsonWriter, @Nullable Map<String, ?> map) throws IOException {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                String str = (String) next.getKey();
                if (!zzf.contains(str)) {
                    if (!(next.getValue() instanceof List)) {
                        if (!(next.getValue() instanceof String)) {
                            zzcgs.zzf("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value((String) next.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String value : (List) next.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(str);
                            jsonWriter.name("value").value(value);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    private final void zzr(String str, zzcgq zzcgq) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zze.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.zzg) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            zzcgq.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzcgs.zzg("unable to log", e);
        }
        zzs(stringWriter.toString());
    }

    public static synchronized void zzs(String str) {
        synchronized (zzcgr.class) {
            zzcgs.zzh("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 4000;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzcgs.zzh(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzcgs.zzh("GMA Debug FINISH");
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        HashMap hashMap;
        if (zzj()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            zzn(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    public final void zzb(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        if (zzj()) {
            zzn(str, "GET", map, bArr);
        }
    }

    public final void zzc(HttpURLConnection httpURLConnection, int i) {
        HashMap hashMap;
        if (zzj()) {
            String str = null;
            if (httpURLConnection.getHeaderFields() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getHeaderFields());
            }
            zzo(hashMap, i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String valueOf = String.valueOf(e.getMessage());
                    zzcgs.zzi(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzp(str);
            }
        }
    }

    public final void zzd(@Nullable Map<String, ?> map, int i) {
        if (zzj()) {
            zzo(map, i);
            if (i < 200 || i >= 300) {
                zzp((String) null);
            }
        }
    }

    public final void zze(@Nullable String str) {
        if (zzj() && str != null) {
            zzf(str.getBytes());
        }
    }

    public final void zzf(byte[] bArr) {
        zzr("onNetworkResponseBody", new zzcgo(bArr));
    }

    public zzcgr(@Nullable String str) {
        List<String> list;
        if (!zzj()) {
            list = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            list = Arrays.asList(strArr);
        }
        this.zzg = list;
    }
}
