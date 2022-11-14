package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffr {
    public final zzfez zza;
    public final ArrayList<String> zzb;

    public zzffr(zzfez zzfez, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.zzb = arrayList;
        this.zza = zzfez;
        arrayList.add(str);
    }

    public final void zza(String str) {
        this.zzb.add(str);
    }

    public final zzfez zzb() {
        return this.zza;
    }

    public final ArrayList<String> zzc() {
        return this.zzb;
    }
}
