package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzfkk {
    public final zzfjr zza;
    public final zzfkh zzb;

    public zzfkk(zzfkh zzfkh, byte[] bArr) {
        zzfjq zzfjq = zzfjq.zza;
        this.zzb = zzfkh;
        this.zza = zzfjq;
    }

    public static zzfkk zza(zzfjr zzfjr) {
        return new zzfkk(new zzfkh(zzfjr), (byte[]) null);
    }

    /* access modifiers changed from: private */
    public final Iterator<String> zzf(CharSequence charSequence) {
        return new zzfkg(this.zzb, this, charSequence);
    }

    public final Iterable<String> zzb(CharSequence charSequence) {
        if (charSequence != null) {
            return new zzfki(this, charSequence);
        }
        throw null;
    }

    public final List<String> zzc(CharSequence charSequence) {
        Iterator<String> zzf = zzf(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzf.hasNext()) {
            arrayList.add(zzf.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
