package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzepv implements Callable {
    public final List zza;

    public zzepv(List list) {
        this.zza = list;
    }

    public final Object call() {
        List<zzfqn> list = this.zza;
        JSONArray jSONArray = new JSONArray();
        for (zzfqn zzfqn : list) {
            if (((JSONObject) zzfqn.get()) != null) {
                jSONArray.put(zzfqn.get());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzepx(jSONArray.toString());
    }
}
