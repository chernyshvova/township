package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzfqa;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzq implements zzfqa<zzaf> {
    public final /* synthetic */ zzcfl zza;
    public final /* synthetic */ zzt zzb;

    public zzq(zzt zzt, zzcfl zzcfl) {
        this.zzb = zzt;
        this.zza = zzcfl;
    }

    public final void zza(Throwable th) {
        String message = th.getMessage();
        zzs.zzg().zzg(th, "SignalGeneratorImpl.generateSignals");
        zzt.zzp(this.zzb, "sgf", "sgf_reason", message);
        try {
            zzcfl zzcfl = this.zza;
            String valueOf = String.valueOf(message);
            zzcfl.zzb(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        zzaf zzaf = (zzaf) obj;
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfj)).booleanValue()) {
            try {
                this.zza.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(valueOf.length() + 39);
                sb.append("QueryInfo generation has been disabled.");
                sb.append(valueOf);
                zzcgs.zzf(sb.toString());
            }
        } else if (zzaf == null) {
            try {
                this.zza.zzc((String) null, (String) null, (Bundle) null);
                zzt.zzp(this.zzb, "sgs", "rid", "-1");
            } catch (RemoteException e2) {
                zzcgs.zzg("", e2);
            }
        } else {
            try {
                String optString = new JSONObject(zzaf.zzb).optString("request_id", "");
                if (TextUtils.isEmpty(optString)) {
                    zzcgs.zzi("The request ID is empty in request JSON.");
                    this.zza.zzb("Internal error: request ID is empty in request JSON.");
                    zzt.zzp(this.zzb, "sgf", "sgf_reason", "rid_missing");
                    return;
                }
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzff)).booleanValue()) {
                    this.zzb.zzp.zza(optString, zzaf.zzb);
                }
                this.zza.zzc(zzaf.zza, zzaf.zzb, zzaf.zzc);
                zzt.zzp(this.zzb, "sgs", "rid", optString);
            } catch (JSONException e3) {
                zzcgs.zzi("Failed to create JSON object from the request string.");
                zzcfl zzcfl = this.zza;
                String valueOf2 = String.valueOf(e3);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 33);
                sb2.append("Internal error for request JSON: ");
                sb2.append(valueOf2);
                zzcfl.zzb(sb2.toString());
                zzt.zzp(this.zzb, "sgf", "sgf_reason", "request_invalid");
            }
        }
    }
}
