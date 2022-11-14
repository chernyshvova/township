package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpt implements zzbps<Object> {
    public final zzdxo zza;

    public zzbpt(zzdxo zzdxo) {
        Preconditions.checkNotNull(zzdxo, "The Inspector Manager must not be null");
        this.zza = zzdxo;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (map != null && map.containsKey("extras")) {
            boolean containsKey = map.containsKey("expires");
            long j = RecyclerView.FOREVER_NS;
            if (containsKey) {
                try {
                    j = Long.parseLong(map.get("expires"));
                } catch (NumberFormatException unused) {
                }
            }
            this.zza.zzi(map.get("extras"), j);
        }
    }
}
