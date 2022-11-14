package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.graphics.PaintCompat;
import com.helpshift.analytics.AnalyticsEventKey;
import java.net.URISyntaxException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpr {
    public static final zzbps<zzcmr> zza = zzbow.zza;
    public static final zzbps<zzcmr> zzb = zzbox.zza;
    public static final zzbps<zzcmr> zzc = zzboy.zza;
    public static final zzbps<zzcmr> zzd = zzbpc.zza;
    public static final zzbps<zzcmr> zze = new zzbpj();
    public static final zzbps<zzcmr> zzf = new zzbpk();
    public static final zzbps<zzcmr> zzg = zzbpd.zza;
    public static final zzbps<Object> zzh = new zzbpl();
    public static final zzbps<zzcmr> zzi = new zzbpm();
    public static final zzbps<zzcmr> zzj = zzbpe.zza;
    public static final zzbps<zzcmr> zzk = new zzbpn();
    public static final zzbps<zzcmr> zzl = new zzbpo();
    public static final zzbps<zzciz> zzm = new zzckm();
    public static final zzbps<zzciz> zzn = new zzckn();
    public static final zzbps<zzcmr> zzo = new zzbov();
    public static final zzbqg zzp = new zzbqg();
    public static final zzbps<zzcmr> zzq = new zzbpp();
    public static final zzbps<zzcmr> zzr = new zzbpq();
    public static final zzbps<zzcmr> zzs = new zzbpf();
    public static final zzbps<zzcmr> zzt = new zzbpg();
    public static final zzbps<zzcmr> zzu = new zzbph();

    public static zzfqn<String> zza(zzcmr zzcmr, String str) {
        Uri parse = Uri.parse(str);
        try {
            zzfb zzU = zzcmr.zzU();
            if (zzU != null && zzU.zza(parse)) {
                parse = zzU.zze(parse, zzcmr.getContext(), zzcmr.zzH(), zzcmr.zzj());
            }
        } catch (zzfc unused) {
            zzcgs.zzi(str.length() != 0 ? "Unable to append parameter to URL: ".concat(str) : new String("Unable to append parameter to URL: "));
        }
        String zzb2 = zzcfd.zzb(parse, zzcmr.getContext());
        if (!zzbkz.zzf.zze().booleanValue()) {
            return zzfqe.zza(zzb2);
        }
        return zzfqe.zzf(zzfqe.zzj(zzfqe.zzf(zzfpv.zzw(zzcmr.zzaE()), Throwable.class, zzboz.zza, zzche.zzf), new zzbpa(zzb2), zzche.zzf), Throwable.class, new zzbpb(zzb2), zzche.zzf);
    }

    public static final /* synthetic */ void zzb(zzcnt zzcnt, Map map) {
        String str;
        PackageManager packageManager = zzcnt.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString(AnalyticsEventKey.URL);
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString(PaintCompat.EM_STRING);
                        String optString5 = jSONObject2.optString(AnalyticsEventKey.PROTOCOL);
                        String optString6 = jSONObject2.optString("c");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                URISyntaxException uRISyntaxException = e;
                                String valueOf = String.valueOf(optString7);
                                if (valueOf.length() != 0) {
                                    str = "Error parsing the url: ".concat(valueOf);
                                } else {
                                    str = new String("Error parsing the url: ");
                                }
                                zzcgs.zzg(str, uRISyntaxException);
                            }
                        }
                        boolean z = true;
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        if (packageManager.resolveActivity(intent, 65536) == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e2) {
                            zzcgs.zzg("Error constructing openable urls response.", e2);
                        }
                    } catch (JSONException e3) {
                        zzcgs.zzg("Error parsing the intent data.", e3);
                    }
                }
                ((zzbsj) zzcnt).zzd("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzbsj) zzcnt).zzd("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzbsj) zzcnt).zzd("openableIntents", new JSONObject());
        }
    }
}
