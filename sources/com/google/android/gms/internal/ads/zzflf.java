package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzflf extends zzfld implements ListIterator {
    public final /* synthetic */ zzflg zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzflf(zzflg zzflg) {
        super(zzflg);
        this.zzd = zzflg;
    }

    public final void add(Object obj) {
        boolean isEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzflh.zzp(this.zzd.zzf);
        if (isEmpty) {
            this.zzd.zzc();
        }
    }

    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzflf(zzflg zzflg, int i) {
        super(zzflg, ((List) zzflg.zzb).listIterator(i));
        this.zzd = zzflg;
    }
}
