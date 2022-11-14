package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsx extends zzfrt<zzfvw, zzfvt> {
    public final /* synthetic */ zzfsy zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfsx(zzfsy zzfsy, Class cls) {
        super(cls);
        this.zza = zzfsy;
    }

    public static final zzfvt zzg(zzfvw zzfvw) throws GeneralSecurityException {
        zzfvs zzf = zzfvt.zzf();
        zzf.zzb(zzfvw.zza());
        zzf.zzc(zzgcz.zzt(zzgbv.zza(zzfvw.zzc())));
        zzf.zza(0);
        return (zzfvt) zzf.zzah();
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfvw.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        return zzg((zzfvw) zzgfk);
    }

    /* renamed from: zzf */
    public final void zzb(zzfvw zzfvw) throws GeneralSecurityException {
        zzgbx.zza(zzfvw.zzc());
        zzfsy.zzl(zzfvw.zza());
    }
}
