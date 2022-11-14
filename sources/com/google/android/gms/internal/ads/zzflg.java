package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzflg extends zzfle implements List {
    public final /* synthetic */ zzflh zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzflg(@NullableDecl zzflh zzflh, Object obj, @NullableDecl List list, zzfle zzfle) {
        super(zzflh, obj, list, zzfle);
        this.zzf = zzflh;
    }

    public final void add(int i, Object obj) {
        zza();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        zzflh.zzp(this.zzf);
        if (isEmpty) {
            zzc();
        }
    }

    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i, collection);
        if (!addAll) {
            return addAll;
        }
        zzflh.zzq(this.zzf, this.zzb.size() - size);
        if (size != 0) {
            return addAll;
        }
        zzc();
        return true;
    }

    public final Object get(int i) {
        zza();
        return ((List) this.zzb).get(i);
    }

    public final int indexOf(Object obj) {
        zza();
        return ((List) this.zzb).indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        zza();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        zza();
        return new zzflf(this);
    }

    public final Object remove(int i) {
        zza();
        Object remove = ((List) this.zzb).remove(i);
        zzflh.zzo(this.zzf);
        zzb();
        return remove;
    }

    public final Object set(int i, Object obj) {
        zza();
        return ((List) this.zzb).set(i, obj);
    }

    public final List subList(int i, int i2) {
        zza();
        zzflh zzflh = this.zzf;
        Object obj = this.zza;
        List subList = ((List) this.zzb).subList(i, i2);
        zzfle zzfle = this.zzc;
        if (zzfle == null) {
            zzfle = this;
        }
        return zzflh.zzg(obj, subList, zzfle);
    }

    public final ListIterator listIterator(int i) {
        zza();
        return new zzflf(this, i);
    }
}
