package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzfle extends AbstractCollection {
    @NullableDecl
    public final Object zza;
    public Collection zzb;
    @NullableDecl
    public final zzfle zzc;
    @NullableDecl
    public final Collection zzd;
    public final /* synthetic */ zzflh zze;

    public zzfle(@NullableDecl zzflh zzflh, Object obj, @NullableDecl Collection collection, zzfle zzfle) {
        this.zze = zzflh;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzfle;
        this.zzd = zzfle == null ? null : zzfle.zzb;
    }

    public final boolean add(Object obj) {
        zza();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (!add) {
            return add;
        }
        zzflh.zzp(this.zze);
        if (!isEmpty) {
            return add;
        }
        zzc();
        return true;
    }

    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        zzflh.zzq(this.zze, this.zzb.size() - size);
        if (size != 0) {
            return addAll;
        }
        zzc();
        return true;
    }

    public final void clear() {
        int size = size();
        if (size != 0) {
            this.zzb.clear();
            zzflh.zzr(this.zze, size);
            zzb();
        }
    }

    public final boolean contains(Object obj) {
        zza();
        return this.zzb.contains(obj);
    }

    public final boolean containsAll(Collection<?> collection) {
        zza();
        return this.zzb.containsAll(collection);
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        zza();
        return this.zzb.equals(obj);
    }

    public final int hashCode() {
        zza();
        return this.zzb.hashCode();
    }

    public final Iterator iterator() {
        zza();
        return new zzfld(this);
    }

    public final boolean remove(Object obj) {
        zza();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzflh.zzo(this.zze);
            zzb();
        }
        return remove;
    }

    public final boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            zzflh.zzq(this.zze, this.zzb.size() - size);
            zzb();
        }
        return removeAll;
    }

    public final boolean retainAll(Collection<?> collection) {
        if (collection != null) {
            int size = size();
            boolean retainAll = this.zzb.retainAll(collection);
            if (retainAll) {
                zzflh.zzq(this.zze, this.zzb.size() - size);
                zzb();
            }
            return retainAll;
        }
        throw null;
    }

    public final int size() {
        zza();
        return this.zzb.size();
    }

    public final String toString() {
        zza();
        return this.zzb.toString();
    }

    public final void zza() {
        Collection collection;
        zzfle zzfle = this.zzc;
        if (zzfle != null) {
            zzfle.zza();
            if (this.zzc.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
        } else if (this.zzb.isEmpty() && (collection = (Collection) this.zze.zza.get(this.zza)) != null) {
            this.zzb = collection;
        }
    }

    public final void zzb() {
        zzfle zzfle = this.zzc;
        if (zzfle != null) {
            zzfle.zzb();
        } else if (this.zzb.isEmpty()) {
            this.zze.zza.remove(this.zza);
        }
    }

    public final void zzc() {
        zzfle zzfle = this.zzc;
        if (zzfle != null) {
            zzfle.zzc();
        } else {
            this.zze.zza.put(this.zza, this.zzb);
        }
    }
}
