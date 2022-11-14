package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzggq extends zzggo<zzggp, zzggp> {
    public final boolean zza(zzgfv zzgfv) {
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzggp) obj).zzh(i << 3, Long.valueOf(j));
    }

    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzggp) obj).zzh((i << 3) | 5, Integer.valueOf(i2));
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, long j) {
        ((zzggp) obj).zzh((i << 3) | 1, Long.valueOf(j));
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, zzgcz zzgcz) {
        ((zzggp) obj).zzh((i << 3) | 2, zzgcz);
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzggp) obj).zzh((i << 3) | 3, obj2);
    }

    public final /* bridge */ /* synthetic */ Object zzg() {
        return zzggp.zzb();
    }

    public final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        zzggp zzggp = (zzggp) obj;
        zzggp.zzd();
        return zzggp;
    }

    public final /* bridge */ /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zzgec) obj).zzc = (zzggp) obj2;
    }

    public final /* bridge */ /* synthetic */ Object zzj(Object obj) {
        return ((zzgec) obj).zzc;
    }

    public final /* bridge */ /* synthetic */ Object zzk(Object obj) {
        zzgec zzgec = (zzgec) obj;
        zzggp zzggp = zzgec.zzc;
        if (zzggp != zzggp.zza()) {
            return zzggp;
        }
        zzggp zzb = zzggp.zzb();
        zzgec.zzc = zzb;
        return zzb;
    }

    public final /* bridge */ /* synthetic */ void zzl(Object obj, Object obj2) {
        ((zzgec) obj).zzc = (zzggp) obj2;
    }

    public final void zzm(Object obj) {
        ((zzgec) obj).zzc.zzd();
    }

    public final /* bridge */ /* synthetic */ Object zzo(Object obj, Object obj2) {
        zzggp zzggp = (zzggp) obj2;
        if (zzggp.equals(zzggp.zza())) {
            return obj;
        }
        return zzggp.zzc((zzggp) obj, zzggp);
    }

    public final /* bridge */ /* synthetic */ int zzp(Object obj) {
        return ((zzggp) obj).zze();
    }

    public final /* bridge */ /* synthetic */ int zzq(Object obj) {
        return ((zzggp) obj).zzf();
    }

    public final /* bridge */ /* synthetic */ void zzr(Object obj, zzgdk zzgdk) throws IOException {
        ((zzggp) obj).zzi(zzgdk);
    }
}
