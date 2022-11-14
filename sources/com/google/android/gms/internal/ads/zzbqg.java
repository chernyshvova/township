package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbqg implements zzbps<Object> {
    public final Object zza = new Object();
    @GuardedBy("lock")
    public final Map<String, zzbqf> zzb = new HashMap();

    public final void zza(Object obj, Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = map.get("id");
        String str6 = map.get("fail");
        String str7 = map.get("fail_reason");
        String str8 = map.get("fail_stack");
        String str9 = map.get("result");
        if (true == TextUtils.isEmpty(str8)) {
            str7 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str8)) {
            str = "";
        } else {
            String valueOf = String.valueOf(str8);
            str = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.zza) {
            zzbqf remove = this.zzb.remove(str5);
            if (remove == null) {
                String valueOf2 = String.valueOf(str5);
                if (valueOf2.length() != 0) {
                    str4 = "Received result for unexpected method invocation: ".concat(valueOf2);
                } else {
                    str4 = new String("Received result for unexpected method invocation: ");
                }
                zzcgs.zzi(str4);
            } else if (!TextUtils.isEmpty(str6)) {
                String valueOf3 = String.valueOf(str7);
                String valueOf4 = String.valueOf(str);
                if (valueOf4.length() != 0) {
                    str3 = valueOf3.concat(valueOf4);
                } else {
                    str3 = new String(valueOf3);
                }
                remove.zzb(str3);
            } else if (str9 == null) {
                remove.zza((JSONObject) null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str9);
                    if (zze.zzc()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        if (valueOf5.length() != 0) {
                            str2 = "Result GMSG: ".concat(valueOf5);
                        } else {
                            str2 = new String("Result GMSG: ");
                        }
                        zze.zza(str2);
                    }
                    remove.zza(jSONObject);
                } catch (JSONException e) {
                    remove.zzb(e.getMessage());
                }
            }
        }
    }

    public final void zzb(String str, zzbqf zzbqf) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbqf);
        }
    }

    public final <EngineT extends zzbsx> zzfqn<JSONObject> zzc(EngineT enginet, String str, JSONObject jSONObject) {
        zzchj zzchj = new zzchj();
        zzs.zzc();
        String uuid = UUID.randomUUID().toString();
        zzb(uuid, new zzbqe(this, zzchj));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", uuid);
            jSONObject2.put("args", jSONObject);
            enginet.zzr(str, jSONObject2);
        } catch (Exception e) {
            zzchj.zzd(e);
        }
        return zzchj;
    }
}
