package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzkv extends zzkt<zzks, zzks> {
    public static void zza(Object obj, zzks zzks) {
        ((zzhy) obj).zzb = zzks;
    }

    public final boolean zza(zzjy zzjy) {
        return false;
    }

    public final /* synthetic */ void zzb(Object obj, zzlm zzlm) throws IOException {
        ((zzks) obj).zza(zzlm);
    }

    public final /* synthetic */ Object zzc(Object obj, Object obj2) {
        zzks zzks = (zzks) obj;
        zzks zzks2 = (zzks) obj2;
        if (zzks2.equals(zzks.zza())) {
            return zzks;
        }
        return zzks.zza(zzks, zzks2);
    }

    public final void zzd(Object obj) {
        ((zzhy) obj).zzb.zzc();
    }

    public final /* synthetic */ int zze(Object obj) {
        return ((zzks) obj).zzd();
    }

    public final /* synthetic */ int zzf(Object obj) {
        return ((zzks) obj).zze();
    }

    public final /* synthetic */ void zza(Object obj, zzlm zzlm) throws IOException {
        ((zzks) obj).zzb(zzlm);
    }

    public final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzks) obj2);
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Object obj2) {
        zza(obj, (zzks) obj2);
    }

    public final /* synthetic */ Object zzc(Object obj) {
        zzks zzks = ((zzhy) obj).zzb;
        if (zzks != zzks.zza()) {
            return zzks;
        }
        zzks zzb = zzks.zzb();
        zza(obj, zzb);
        return zzb;
    }

    public final /* synthetic */ Object zza(Object obj) {
        zzks zzks = (zzks) obj;
        zzks.zzc();
        return zzks;
    }

    public final /* synthetic */ Object zzb(Object obj) {
        return ((zzhy) obj).zzb;
    }

    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzks) obj).zza((i << 3) | 1, (Object) Long.valueOf(j));
    }

    public final /* synthetic */ Object zza() {
        return zzks.zzb();
    }

    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzks) obj).zza((i << 3) | 3, (Object) (zzks) obj2);
    }

    public final /* synthetic */ void zza(Object obj, int i, zzgp zzgp) {
        ((zzks) obj).zza((i << 3) | 2, (Object) zzgp);
    }

    public final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzks) obj).zza((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzks) obj).zza(i << 3, (Object) Long.valueOf(j));
    }
}
