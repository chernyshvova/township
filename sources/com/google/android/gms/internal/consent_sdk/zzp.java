package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.webkit.WebSettings;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener;
import com.google.android.ump.ConsentRequestParameters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzp {
    public final Application zza;
    public final zzab zzb;
    public final Handler zzc;
    public final Executor zzd;
    public final zzal zze;
    public final zzaz zzf;
    public final zzn zzg;
    public final zzz zzh;
    public final zze zzi;

    public zzp(Application application, zzab zzab, Handler handler, Executor executor, zzal zzal, zzaz zzaz, zzn zzn, zzz zzz, zze zze2) {
        this.zza = application;
        this.zzb = zzab;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzal;
        this.zzf = zzaz;
        this.zzg = zzn;
        this.zzh = zzz;
        this.zzi = zze2;
    }

    public final void zza(@Nullable Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener, ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener) {
        this.zzd.execute(new zzs(this, activity, consentRequestParameters, consentInformation$OnConsentInfoUpdateSuccessListener, consentInformation$OnConsentInfoUpdateFailureListener));
    }

    public final void zzb(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener, ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener) {
        if (consentRequestParameters != null) {
            try {
                throw null;
            } catch (zzk e) {
                this.zzc.post(new zzt(consentInformation$OnConsentInfoUpdateFailureListener, e));
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(Log.getStackTraceString(e2));
                this.zzc.post(new zzw(consentInformation$OnConsentInfoUpdateFailureListener, new zzk(1, valueOf.length() != 0 ? "Caught exception when trying to request consent info update: ".concat(valueOf) : new String("Caught exception when trying to request consent info update: "))));
            }
        } else {
            throw null;
        }
    }

    @WorkerThread
    private final zzby zza(zzbn zzbn) throws zzk {
        try {
            return zzb(zzbn);
        } catch (SocketTimeoutException e) {
            throw new zzk(4, "The server timed out.", e);
        } catch (IOException e2) {
            throw new zzk(2, "Error making request.", e2);
        }
    }

    public final /* synthetic */ void zza(ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener) {
        Handler handler = this.zzc;
        consentInformation$OnConsentInfoUpdateSuccessListener.getClass();
        handler.post(zzu.zza(consentInformation$OnConsentInfoUpdateSuccessListener));
    }

    @WorkerThread
    private final zzby zzb(zzbn zzbn) throws IOException {
        JsonWriter jsonWriter;
        JsonReader jsonReader;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://fundingchoicesmessages.google.com/a/consent").openConnection();
        httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, WebSettings.getDefaultUserAgent(this.zza));
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
        try {
            jsonWriter = new JsonWriter(outputStreamWriter);
            jsonWriter.beginObject();
            String str = zzbn.zza;
            if (str != null) {
                jsonWriter.name("admob_app_id");
                jsonWriter.value(str);
            }
            String str2 = zzbn.zzb;
            if (str2 != null) {
                jsonWriter.name("adid");
                jsonWriter.value(str2);
            }
            zzbr zzbr = zzbn.zzc;
            if (zzbr != null) {
                jsonWriter.name(DeviceRequestsHelper.DEVICE_INFO_PARAM);
                jsonWriter.beginObject();
                int i = zzbr.zza;
                if (i != zzbu.zza) {
                    jsonWriter.name("os_type");
                    zzbu.zza(i, jsonWriter);
                }
                String str3 = zzbr.zzb;
                if (str3 != null) {
                    jsonWriter.name(DeviceRequestsHelper.DEVICE_INFO_MODEL);
                    jsonWriter.value(str3);
                }
                Integer num = zzbr.zzc;
                if (num != null) {
                    jsonWriter.name("android_api_level");
                    jsonWriter.value(num);
                }
                jsonWriter.endObject();
            }
            String str4 = zzbn.zzd;
            if (str4 != null) {
                jsonWriter.name("publisher_privacy_policy_url");
                jsonWriter.value(str4);
            }
            String str5 = zzbn.zze;
            if (str5 != null) {
                jsonWriter.name("language_code");
                jsonWriter.value(str5);
            }
            String str6 = zzbn.zzf;
            if (str6 != null) {
                jsonWriter.name("country_code_if_unknown_region");
                jsonWriter.value(str6);
            }
            Boolean bool = zzbn.zzg;
            if (bool != null) {
                jsonWriter.name("opt_out_if_unknown_region");
                jsonWriter.value(bool.booleanValue());
            }
            Boolean bool2 = zzbn.zzh;
            if (bool2 != null) {
                jsonWriter.name("tag_for_under_age_of_consent");
                jsonWriter.value(bool2.booleanValue());
            }
            Boolean bool3 = zzbn.zzi;
            if (bool3 != null) {
                jsonWriter.name("is_lat");
                jsonWriter.value(bool3.booleanValue());
            }
            Map<String, String> map = zzbn.zzj;
            if (!map.isEmpty()) {
                jsonWriter.name("stored_infos_map");
                jsonWriter.beginObject();
                for (Map.Entry next : map.entrySet()) {
                    jsonWriter.name((String) next.getKey());
                    jsonWriter.value((String) next.getValue());
                }
                jsonWriter.endObject();
            }
            zzbt zzbt = zzbn.zzk;
            if (zzbt != null) {
                jsonWriter.name("screen_info");
                jsonWriter.beginObject();
                Integer num2 = zzbt.zza;
                if (num2 != null) {
                    jsonWriter.name("width");
                    jsonWriter.value(num2);
                }
                Integer num3 = zzbt.zzb;
                if (num3 != null) {
                    jsonWriter.name("height");
                    jsonWriter.value(num3);
                }
                Double d = zzbt.zzc;
                if (d != null) {
                    jsonWriter.name("density");
                    jsonWriter.value(d);
                }
                List<zzbw> list = zzbt.zzd;
                if (!list.isEmpty()) {
                    jsonWriter.name("screen_insets");
                    jsonWriter.beginArray();
                    for (zzbw next2 : list) {
                        jsonWriter.beginObject();
                        Integer num4 = next2.zza;
                        if (num4 != null) {
                            jsonWriter.name(ViewHierarchyConstants.DIMENSION_TOP_KEY);
                            jsonWriter.value(num4);
                        }
                        Integer num5 = next2.zzb;
                        if (num5 != null) {
                            jsonWriter.name(ViewHierarchyConstants.DIMENSION_LEFT_KEY);
                            jsonWriter.value(num5);
                        }
                        Integer num6 = next2.zzc;
                        if (num6 != null) {
                            jsonWriter.name("right");
                            jsonWriter.value(num6);
                        }
                        Integer num7 = next2.zzd;
                        if (num7 != null) {
                            jsonWriter.name("bottom");
                            jsonWriter.value(num7);
                        }
                        jsonWriter.endObject();
                    }
                    jsonWriter.endArray();
                }
                jsonWriter.endObject();
            }
            zzbp zzbp = zzbn.zzl;
            if (zzbp != null) {
                jsonWriter.name("app_info");
                jsonWriter.beginObject();
                String str7 = zzbp.zza;
                if (str7 != null) {
                    jsonWriter.name("package_name");
                    jsonWriter.value(str7);
                }
                String str8 = zzbp.zzb;
                if (str8 != null) {
                    jsonWriter.name("publisher_display_name");
                    jsonWriter.value(str8);
                }
                String str9 = zzbp.zzc;
                if (str9 != null) {
                    jsonWriter.name("version");
                    jsonWriter.value(str9);
                }
                jsonWriter.endObject();
            }
            zzbv zzbv = zzbn.zzm;
            if (zzbv != null) {
                jsonWriter.name("sdk_info");
                jsonWriter.beginObject();
                String str10 = zzbv.zza;
                if (str10 != null) {
                    jsonWriter.name("version");
                    jsonWriter.value(str10);
                }
                jsonWriter.endObject();
            }
            List<zzbs> list2 = zzbn.zzn;
            if (!list2.isEmpty()) {
                jsonWriter.name("debug_params");
                jsonWriter.beginArray();
                for (zzbs zza2 : list2) {
                    zza2.zza(jsonWriter);
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
            jsonWriter.close();
            outputStreamWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String headerField = httpURLConnection.getHeaderField("x-ump-using-header");
                if (headerField != null) {
                    zzby zza3 = zzby.zza(new JsonReader(new StringReader(headerField)));
                    zza3.zzb = new Scanner(httpURLConnection.getInputStream()).useDelimiter("\\A").next();
                    return zza3;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                try {
                    bufferedReader.readLine();
                    jsonReader = new JsonReader(bufferedReader);
                    zzby zza4 = zzby.zza(jsonReader);
                    jsonReader.close();
                    bufferedReader.close();
                    return zza4;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        zzcj.zza(th, th2);
                    }
                    throw th;
                }
            } else {
                String next3 = new Scanner(httpURLConnection.getErrorStream()).useDelimiter("\\A").next();
                StringBuilder sb = new StringBuilder(String.valueOf(next3).length() + 31);
                sb.append("Http error code - ");
                sb.append(responseCode);
                sb.append(".\n");
                sb.append(next3);
                throw new IOException(sb.toString());
            }
            throw th;
            throw th;
        } catch (Throwable th3) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th4) {
                zzcj.zza(th3, th4);
            }
            throw th3;
        }
    }
}
