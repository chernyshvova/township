package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfth extends zzfrv<zzfwr> {
    public zzfth() {
        super(zzfwr.class, new zzftf(zzfrh.class));
    }

    public static void zzj(boolean z) throws GeneralSecurityException {
        if (zzl()) {
            zzfsn.zzc(new zzfth(), true);
        }
    }

    public static /* synthetic */ zzfrs zzk(int i, int i2) {
        zzfwt zzd = zzfwu.zzd();
        zzd.zza(i);
        return new zzfrs((zzfwu) zzd.zzah(), i2);
    }

    public static boolean zzl() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfwr.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzfwr zzfwr = (zzfwr) zzgfk;
        zzgbx.zzb(zzfwr.zza(), 0);
        zzgbx.zza(zzfwr.zzc().zzc());
    }

    public final zzfrt<zzfwu, zzfwr> zzi() {
        return new zzftg(this, zzfwu.class);
    }
}
