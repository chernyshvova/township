package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzkh extends zzkn {
    public final /* synthetic */ zzkc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzkh(zzkc zzkc) {
        super(zzkc, (zzkf) null);
        this.zza = zzkc;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzke(this.zza, (zzkf) null);
    }

    public /* synthetic */ zzkh(zzkc zzkc, zzkf zzkf) {
        this(zzkc);
    }
}
