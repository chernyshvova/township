package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfa extends zzez {
    public zzfa(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    public static zzfa zzs(String str, Context context, boolean z, int i) {
        zzez.zzm(context, z);
        return new zzfa(context, str, z, i);
    }

    public final List<Callable<Void>> zzp(zzfy zzfy, Context context, zzcn zzcn, zzce zzce) {
        if (zzfy.zzd() == null || !this.zzt) {
            return super.zzp(zzfy, context, zzcn, (zzce) null);
        }
        int zzs = zzfy.zzs();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzp(zzfy, context, zzcn, (zzce) null));
        arrayList.add(new zzgn(zzfy, "llqwiPI9WBGdX3ILtNQP0ldd/oo65vCmZGiUmTtHOSQw67bDkVyvEAM6wctf4g5A", "ciEjxtHwaQq5vQY33BpqQuStjcQqNXynEA7E/ixfFmM=", zzcn, zzs, 24));
        return arrayList;
    }
}
