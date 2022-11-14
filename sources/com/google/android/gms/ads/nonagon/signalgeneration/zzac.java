package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzcbk;
import com.google.android.gms.internal.ads.zzfpl;
import com.google.android.gms.internal.ads.zzfqe;
import com.google.android.gms.internal.ads.zzfqn;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzac implements zzfpl {
    public final zzcbk zza;

    public zzac(zzcbk zzcbk) {
        this.zza = zzcbk;
    }

    public final zzfqn zza(Object obj) {
        zzcbk zzcbk = this.zza;
        zzaf zzaf = new zzaf(new JsonReader(new InputStreamReader((InputStream) obj)));
        try {
            zzaf.zzb = zzs.zzc().zzh(zzcbk.zza).toString();
        } catch (JSONException unused) {
            zzaf.zzb = JsonUtils.EMPTY_JSON;
        }
        return zzfqe.zza(zzaf);
    }
}
