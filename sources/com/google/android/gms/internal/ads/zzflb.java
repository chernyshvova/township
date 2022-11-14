package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzflb extends zzfku implements SortedMap {
    @NullableDecl
    public SortedSet zzd;
    public final /* synthetic */ zzflh zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzflb(zzflh zzflh, SortedMap sortedMap) {
        super(zzflh, sortedMap);
        this.zze = zzflh;
    }

    public final Comparator comparator() {
        return zzg().comparator();
    }

    public final Object firstKey() {
        return zzg().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new zzflb(this.zze, zzg().headMap(obj));
    }

    public final Object lastKey() {
        return zzg().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new zzflb(this.zze, zzg().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new zzflb(this.zze, zzg().tailMap(obj));
    }

    /* renamed from: zze */
    public SortedSet zzh() {
        return new zzflc(this.zze, zzg());
    }

    /* renamed from: zzf */
    public SortedSet keySet() {
        SortedSet sortedSet = this.zzd;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet zze2 = zzh();
        this.zzd = zze2;
        return zze2;
    }

    public SortedMap zzg() {
        return (SortedMap) this.zza;
    }
}
