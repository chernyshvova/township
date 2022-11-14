package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzm {
    public final int zza;
    @Nullable
    public final String zzb;
    public final List<zzzl> zzc;
    public final byte[] zzd;

    public zzzm(int i, @Nullable String str, @Nullable List<zzzl> list, byte[] bArr) {
        List<zzzl> list2;
        this.zza = i;
        this.zzb = str;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.zzc = list2;
        this.zzd = bArr;
    }
}
