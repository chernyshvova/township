package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzflq extends AbstractSet<Map.Entry> {
    public final /* synthetic */ zzflv zza;

    public zzflq(zzflv zzflv) {
        this.zza = zzflv;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@NullableDecl Object obj) {
        Map zzc = this.zza.zzc();
        if (zzc != null) {
            return zzc.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzk = this.zza.zzr(entry.getKey());
            if (zzk == -1 || !zzfka.zza(this.zza.zzc[zzk], entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator<Map.Entry> iterator() {
        zzflv zzflv = this.zza;
        Map zzc = zzflv.zzc();
        if (zzc != null) {
            return zzc.entrySet().iterator();
        }
        return new zzflo(zzflv);
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzc = this.zza.zzc();
        if (zzc != null) {
            return zzc.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.zza.zzb()) {
            return false;
        }
        int zzl = this.zza.zzp();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object zzm = this.zza.zze;
        zzflv zzflv = this.zza;
        int zze = zzflw.zze(key, value, zzl, zzm, zzflv.zza, zzflv.zzb, zzflv.zzc);
        if (zze == -1) {
            return false;
        }
        this.zza.zze(zze, zzl);
        zzflv.zzn(this.zza);
        this.zza.zzd();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
