package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.GraphRequest;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.p032a.zzaa;
import com.google.android.datatransport.cct.p032a.zzd;
import com.google.android.datatransport.cct.p032a.zze;
import com.google.android.datatransport.cct.p032a.zzg;
import com.google.android.datatransport.cct.p032a.zzi;
import com.google.android.datatransport.cct.p032a.zzk;
import com.google.android.datatransport.cct.p032a.zzn;
import com.google.android.datatransport.cct.p032a.zzo;
import com.google.android.datatransport.cct.p032a.zzp;
import com.google.android.datatransport.cct.p032a.zzq;
import com.google.android.datatransport.cct.p032a.zzr;
import com.google.android.datatransport.cct.p032a.zzu;
import com.google.android.datatransport.cct.p032a.zzw;
import com.google.android.datatransport.cct.p032a.zzy;
import com.google.android.datatransport.cct.p032a.zzz;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzc implements TransportBackend {
    public final DataEncoder zza;
    public final ConnectivityManager zzb;
    public final URL zzc = zza(CCTDestination.zza);
    public final Clock zzd;
    public final Clock zze;
    public final int zzf;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zza {
        public final URL zza;
        public final zzo zzb;
        @Nullable
        public final String zzc;

        public zza(URL url, zzo zzo, @Nullable String str) {
            this.zza = url;
            this.zzb = zzo;
            this.zzc = str;
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zzb {
        public final int zza;
        @Nullable
        public final URL zzb;
        public final long zzc;

        public zzb(int i, @Nullable URL url, long j) {
            this.zza = i;
            this.zzb = url;
            this.zzc = j;
        }
    }

    public zzc(Context context, Clock clock, Clock clock2) {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        jsonDataEncoderBuilder.registerEncoder(zze.class, new zzp());
        jsonDataEncoderBuilder.registerEncoder(zzk.class, new zzw());
        jsonDataEncoderBuilder.registerEncoder(zzg.class, new zzr());
        jsonDataEncoderBuilder.registerEncoder(zzi.class, new zzu());
        jsonDataEncoderBuilder.registerEncoder(zzd.class, new com.google.android.datatransport.cct.p032a.zzb());
        jsonDataEncoderBuilder.registerEncoder(zzn.class, new zzz());
        this.zza = new DataEncoder() {
            public void encode(@NonNull Object obj, @NonNull Writer writer) throws IOException, EncodingException {
                JsonDataEncoderBuilder jsonDataEncoderBuilder = JsonDataEncoderBuilder.this;
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders);
                jsonValueObjectEncoderContext.add(obj);
                jsonValueObjectEncoderContext.maybeUnNest();
                jsonValueObjectEncoderContext.jsonWriter.flush();
            }
        };
        this.zzb = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzd = clock2;
        this.zze = clock;
        this.zzf = 40000;
    }

    public static URL zza(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("Invalid url: ", str), e);
        }
    }

    public EventInternal decorate(EventInternal eventInternal) {
        int i;
        int i2;
        NetworkInfo activeNetworkInfo = this.zzb.getActiveNetworkInfo();
        EventInternal.Builder builder = eventInternal.toBuilder();
        builder.getAutoMetadata().put("sdk-version", String.valueOf(Build.VERSION.SDK_INT));
        builder.getAutoMetadata().put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        builder.getAutoMetadata().put("hardware", Build.HARDWARE);
        builder.getAutoMetadata().put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Build.DEVICE);
        builder.getAutoMetadata().put(AppLovinEventTypes.USER_VIEWED_PRODUCT, Build.PRODUCT);
        builder.getAutoMetadata().put("os-uild", Build.ID);
        builder.getAutoMetadata().put("manufacturer", Build.MANUFACTURER);
        builder.getAutoMetadata().put("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        builder.getAutoMetadata().put("tz-offset", String.valueOf((long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000)));
        if (activeNetworkInfo == null) {
            i = zzy.zzc.NONE.zzu;
        } else {
            i = activeNetworkInfo.getType();
        }
        builder.getAutoMetadata().put("net-type", String.valueOf(i));
        if (activeNetworkInfo == null) {
            i2 = zzy.zzb.UNKNOWN_MOBILE_SUBTYPE.zzw;
        } else {
            i2 = activeNetworkInfo.getSubtype();
            if (i2 == -1) {
                i2 = zzy.zzb.COMBINED.zzw;
            } else if (zzy.zzb.zzv.get(i2) == null) {
                i2 = 0;
            }
        }
        builder.getAutoMetadata().put("mobile-subtype", String.valueOf(i2));
        return builder.build();
    }

    public BackendResponse send(BackendRequest backendRequest) {
        String str;
        BackendResponse.Status status;
        String str2;
        zzi.zza zza2;
        long j;
        zzc zzc2 = this;
        BackendResponse.Status status2 = BackendResponse.Status.TRANSIENT_ERROR;
        HashMap hashMap = new HashMap();
        AutoValue_BackendRequest autoValue_BackendRequest = (AutoValue_BackendRequest) backendRequest;
        for (EventInternal next : autoValue_BackendRequest.events) {
            String str3 = ((AutoValue_EventInternal) next).transportName;
            if (!hashMap.containsKey(str3)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(str3, arrayList);
            } else {
                ((List) hashMap.get(str3)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            Integer num = Integer.MIN_VALUE;
            zzaa zzaa = zzaa.DEFAULT;
            Long valueOf = Long.valueOf(zzc2.zze.getTime());
            Long valueOf2 = Long.valueOf(zzc2.zzd.getTime());
            zzq.zzb zzb2 = zzq.zzb.ANDROID;
            Integer valueOf3 = Integer.valueOf(eventInternal.getInteger("sdk-version"));
            String str4 = eventInternal.get(DeviceRequestsHelper.DEVICE_INFO_MODEL);
            String str5 = eventInternal.get("hardware");
            String str6 = eventInternal.get(DeviceRequestsHelper.DEVICE_INFO_DEVICE);
            String str7 = eventInternal.get(AppLovinEventTypes.USER_VIEWED_PRODUCT);
            String str8 = eventInternal.get("os-uild");
            String str9 = eventInternal.get("manufacturer");
            String str10 = eventInternal.get("fingerprint");
            String str11 = "";
            String str12 = valueOf3 == null ? " sdkVersion" : str11;
            if (str12.isEmpty()) {
                zzg zzg = new zzg(zzb2, new zzd(valueOf3.intValue(), str4, str5, str6, str7, str8, str9, str10));
                try {
                    num = Integer.valueOf(Integer.valueOf((String) entry.getKey()).intValue());
                    str2 = null;
                } catch (NumberFormatException unused) {
                    str2 = (String) entry.getKey();
                }
                String str13 = str2;
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((List) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    EventInternal eventInternal2 = (EventInternal) it2.next();
                    AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) eventInternal2;
                    Iterator it3 = it;
                    EncodedPayload encodedPayload = autoValue_EventInternal.encodedPayload;
                    Iterator it4 = it2;
                    Encoding encoding = encodedPayload.encoding;
                    String str14 = str11;
                    BackendResponse.Status status3 = status2;
                    if (encoding.equals(new Encoding("proto"))) {
                        byte[] bArr = encodedPayload.bytes;
                        zza2 = new zzi.zza();
                        zza2.zza(Integer.MIN_VALUE);
                        zza2.zzd = bArr;
                    } else if (encoding.equals(new Encoding(GraphRequest.FORMAT_JSON))) {
                        String str15 = new String(encodedPayload.bytes, Charset.forName("UTF-8"));
                        zzi.zza zza3 = new zzi.zza();
                        zza3.zza(Integer.MIN_VALUE);
                        zza3.zze = str15;
                        zza2 = zza3;
                    } else {
                        Log.w(zzam.getTag("CctTransportBackend"), String.format("Received event of unsupported encoding %s. Skipping...", new Object[]{encoding}));
                        it2 = it4;
                        it = it3;
                        str11 = str14;
                        status2 = status3;
                    }
                    zza2.zza = Long.valueOf(autoValue_EventInternal.eventMillis);
                    zza2.zzc = Long.valueOf(autoValue_EventInternal.uptimeMillis);
                    String str16 = autoValue_EventInternal.autoMetadata.get("tz-offset");
                    if (str16 == null) {
                        j = 0;
                    } else {
                        j = Long.valueOf(str16).longValue();
                    }
                    zza2.zzf = Long.valueOf(j);
                    zza2.zzg = new zzn(zzy.zzc.zzt.get(eventInternal2.getInteger("net-type")), zzy.zzb.zzv.get(eventInternal2.getInteger("mobile-subtype")));
                    Integer num2 = autoValue_EventInternal.code;
                    if (num2 != null) {
                        zza2.zza(num2.intValue());
                    }
                    String str17 = zza2.zza == null ? " eventTimeMs" : str14;
                    if (zza2.zzb == null) {
                        str17 = GeneratedOutlineSupport.outline16(str17, " eventCode");
                    }
                    if (zza2.zzc == null) {
                        str17 = GeneratedOutlineSupport.outline16(str17, " eventUptimeMs");
                    }
                    if (zza2.zzf == null) {
                        str17 = GeneratedOutlineSupport.outline16(str17, " timezoneOffsetSeconds");
                    }
                    if (str17.isEmpty()) {
                        arrayList3.add(new zzi(zza2.zza.longValue(), zza2.zzb.intValue(), zza2.zzc.longValue(), zza2.zzd, zza2.zze, zza2.zzf.longValue(), zza2.zzg));
                        it2 = it4;
                        it = it3;
                        str11 = str14;
                        status2 = status3;
                    } else {
                        throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str17));
                    }
                }
                Iterator it5 = it;
                BackendResponse.Status status4 = status2;
                String str18 = valueOf == null ? " requestTimeMs" : str11;
                if (valueOf2 == null) {
                    str18 = GeneratedOutlineSupport.outline16(str18, " requestUptimeMs");
                }
                if (num == null) {
                    str18 = GeneratedOutlineSupport.outline16(str18, " logSource");
                }
                if (str18.isEmpty()) {
                    arrayList2.add(new zzk(valueOf.longValue(), valueOf2.longValue(), zzg, num.intValue(), str13, arrayList3, zzaa));
                    zzc2 = this;
                    it = it5;
                    status2 = status4;
                } else {
                    throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str18));
                }
            } else {
                throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str12));
            }
        }
        BackendResponse.Status status5 = status2;
        zze zze2 = new zze(arrayList2);
        URL url = this.zzc;
        if (autoValue_BackendRequest.extras != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(((AutoValue_BackendRequest) backendRequest).extras);
                str = fromByteArray.zzf != null ? fromByteArray.zzf : null;
                if (fromByteArray.zze != null) {
                    url = zza(fromByteArray.zze);
                }
            } catch (IllegalArgumentException unused2) {
                return BackendResponse.fatalError();
            }
        } else {
            str = null;
        }
        try {
            zzb zzb3 = (zzb) zzam.retry(5, new zza(url, zze2, str), new zza(this), zzb.zza);
            if (zzb3.zza == 200) {
                return new AutoValue_BackendResponse(BackendResponse.Status.OK, zzb3.zzc);
            }
            int i = zzb3.zza;
            if (i < 500) {
                if (i != 404) {
                    return BackendResponse.fatalError();
                }
            }
            status = status5;
            try {
                return new AutoValue_BackendResponse(status, -1);
            } catch (IOException e) {
                e = e;
                Log.e(zzam.getTag("CctTransportBackend"), "Could not make request to the backend", e);
                return new AutoValue_BackendResponse(status, -1);
            }
        } catch (IOException e2) {
            e = e2;
            status = status5;
            Log.e(zzam.getTag("CctTransportBackend"), "Could not make request to the backend", e);
            return new AutoValue_BackendResponse(status, -1);
        }
    }
}
