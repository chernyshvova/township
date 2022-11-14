package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzflc extends zzfkx implements SortedSet {
    public final /* synthetic */ zzflh zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzflc(zzflh zzflh, SortedMap sortedMap) {
        super(zzflh, sortedMap);
        this.zzc = zzflh;
    }

    public final Comparator comparator() {
        return zza().comparator();
    }

    public final Object first() {
        return zza().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new zzflc(this.zzc, zza().headMap(obj));
    }

    public final Object last() {
        return zza().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new zzflc(this.zzc, zza().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new zzflc(this.zzc, zza().tailMap(obj));
    }

    public SortedMap zza() {
        return (SortedMap) this.zzd;
    }
}
