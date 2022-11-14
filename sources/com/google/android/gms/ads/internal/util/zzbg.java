package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbg {
    public final List<String> zza = new ArrayList();
    public final List<Double> zzb = new ArrayList();
    public final List<Double> zzc = new ArrayList();

    public final zzbg zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zza.size()) {
            double doubleValue = this.zzc.get(i).doubleValue();
            double doubleValue2 = this.zzb.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zza.add(i, str);
        this.zzc.add(i, Double.valueOf(d));
        this.zzb.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzbh zzb() {
        return new zzbh(this, (zzbe) null);
    }
}
