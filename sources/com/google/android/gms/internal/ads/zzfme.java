package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzfme<E> extends zzfmf<E> {
    public Object[] zza;
    public int zzb = 0;
    public boolean zzc;

    public zzfme(int i) {
        this.zza = new Object[i];
    }

    private final void zze(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i) {
            this.zza = Arrays.copyOf(objArr, zzfmf.zzd(length, i));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
    }

    public final zzfme<E> zza(E e) {
        if (e != null) {
            zze(this.zzb + 1);
            Object[] objArr = this.zza;
            int i = this.zzb;
            this.zzb = i + 1;
            objArr[i] = e;
            return this;
        }
        throw null;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfmf<E> zzb(java.lang.Iterable<? extends E> r3) {
        /*
            r2 = this;
            int r0 = r2.zzb
            int r1 = r3.size()
            int r1 = r1 + r0
            r2.zze(r1)
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zzfmg
            if (r0 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.iterator()
        L_0x0012:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0020
            java.lang.Object r0 = r3.next()
            r2.zzc(r0)
            goto L_0x0012
        L_0x0020:
            return r2
        L_0x0021:
            com.google.android.gms.internal.ads.zzfmg r3 = (com.google.android.gms.internal.ads.zzfmg) r3
            java.lang.Object[] r0 = r2.zza
            int r1 = r2.zzb
            int r3 = r3.zzg(r0, r1)
            r2.zzb = r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfme.zzb(java.lang.Iterable):com.google.android.gms.internal.ads.zzfmf");
    }

    public /* bridge */ /* synthetic */ zzfmf zzc(Object obj) {
        throw null;
    }
}
