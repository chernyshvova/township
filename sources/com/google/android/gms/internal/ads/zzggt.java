package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzggt extends AbstractList<String> implements RandomAccess, zzgeu {
    public final zzgeu zza;

    public zzggt(zzgeu zzgeu) {
        this.zza = zzgeu;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzget) this.zza).get(i);
    }

    public final Iterator<String> iterator() {
        return new zzggs(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzggr(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzgcz zzgcz) {
        throw new UnsupportedOperationException();
    }

    public final Object zzg(int i) {
        return this.zza.zzg(i);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final zzgeu zzi() {
        return this;
    }
}
