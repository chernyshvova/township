package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzku extends AbstractList<String> implements zziq, RandomAccess {
    public final zziq zza;

    public zzku(zziq zziq) {
        this.zza = zziq;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    /* renamed from: h_ */
    public final zziq mo30782h_() {
        return this;
    }

    public final Iterator<String> iterator() {
        return new zzkw(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzkx(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zza(zzgp zzgp) {
        throw new UnsupportedOperationException();
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final List<?> zzb() {
        return this.zza.zzb();
    }
}
