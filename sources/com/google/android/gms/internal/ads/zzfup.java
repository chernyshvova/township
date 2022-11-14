package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfup implements zzgaw {
    public final String zza;
    public final int zzb;
    public zzfwl zzc;
    public zzfvn zzd;
    public int zze;
    public zzfwx zzf;

    public zzfup(zzfyx zzfyx) throws GeneralSecurityException {
        String str;
        String zza2 = zzfyx.zza();
        this.zza = zza2;
        if (zza2.equals(zzfsp.zzb)) {
            try {
                zzfwo zzc2 = zzfwo.zzc(zzfyx.zzc(), zzgdo.zza());
                this.zzc = (zzfwl) zzfsn.zzh(zzfyx);
                this.zzb = zzc2.zza();
            } catch (zzgeo e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.zza.equals(zzfsp.zza)) {
            try {
                zzfvq zzd2 = zzfvq.zzd(zzfyx.zzc(), zzgdo.zza());
                this.zzd = (zzfvn) zzfsn.zzh(zzfyx);
                this.zze = zzd2.zza().zzc();
                this.zzb = this.zze + zzd2.zzc().zzc();
            } catch (zzgeo e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else if (this.zza.equals(zzfua.zza)) {
            try {
                zzfxa zzc3 = zzfxa.zzc(zzfyx.zzc(), zzgdo.zza());
                this.zzf = (zzfwx) zzfsn.zzh(zzfyx);
                this.zzb = zzc3.zza();
            } catch (zzgeo e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            String valueOf = String.valueOf(this.zza);
            if (valueOf.length() != 0) {
                str = "unsupported AEAD DEM key type: ".concat(valueOf);
            } else {
                str = new String("unsupported AEAD DEM key type: ");
            }
            throw new GeneralSecurityException(str);
        }
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzfuq zzb(byte[] bArr) throws GeneralSecurityException {
        Class<zzfrh> cls = zzfrh.class;
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zza.equals(zzfsp.zzb)) {
            zzfwk zze2 = zzfwl.zze();
            zze2.zzai(this.zzc);
            zze2.zzb(zzgcz.zzs(bArr, 0, this.zzb));
            return new zzfuq((zzfrh) zzfsn.zzi(this.zza, (zzfwl) zze2.zzah(), cls));
        } else if (this.zza.equals(zzfsp.zza)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
            zzfvs zzf2 = zzfvt.zzf();
            zzf2.zzai(this.zzd.zzc());
            zzf2.zzc(zzgcz.zzt(copyOfRange));
            zzfyg zzf3 = zzfyh.zzf();
            zzf3.zzai(this.zzd.zzd());
            zzf3.zzc(zzgcz.zzt(copyOfRange2));
            zzfvm zzf4 = zzfvn.zzf();
            zzf4.zza(this.zzd.zza());
            zzf4.zzb((zzfvt) zzf2.zzah());
            zzf4.zzc((zzfyh) zzf3.zzah());
            return new zzfuq((zzfrh) zzfsn.zzi(this.zza, (zzfvn) zzf4.zzah(), cls));
        } else if (this.zza.equals(zzfua.zza)) {
            zzfww zze3 = zzfwx.zze();
            zze3.zzai(this.zzf);
            zze3.zzb(zzgcz.zzs(bArr, 0, this.zzb));
            return new zzfuq((zzfrk) zzfsn.zzi(this.zza, (zzfwx) zze3.zzah(), zzfrk.class));
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
