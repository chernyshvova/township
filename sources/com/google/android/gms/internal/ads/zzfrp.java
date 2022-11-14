package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfk;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzfrp<PrimitiveT, KeyProtoT extends zzgfk> implements zzfrn<PrimitiveT> {
    public final zzfrv<KeyProtoT> zza;
    public final Class<PrimitiveT> zzb;

    public zzfrp(zzfrv<KeyProtoT> zzfrv, Class<PrimitiveT> cls) {
        if (zzfrv.zzg().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzfrv;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzfrv.toString(), cls.getName()}));
    }

    private final PrimitiveT zzg(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.zzb)) {
            this.zza.zze(keyprotot);
            return this.zza.zzf(keyprotot, this.zzb);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    private final zzfro<?, KeyProtoT> zzh() {
        return new zzfro<>(this.zza.zzi());
    }

    public final PrimitiveT zza(zzgcz zzgcz) throws GeneralSecurityException {
        try {
            return zzg(this.zza.zzd(zzgcz));
        } catch (zzgeo e) {
            String name = this.zza.zza().getName();
            throw new GeneralSecurityException(name.length() != 0 ? "Failures parsing proto of type ".concat(name) : new String("Failures parsing proto of type "), e);
        }
    }

    public final PrimitiveT zzb(zzgfk zzgfk) throws GeneralSecurityException {
        String str;
        String name = this.zza.zza().getName();
        if (name.length() != 0) {
            str = "Expected proto of type ".concat(name);
        } else {
            str = new String("Expected proto of type ");
        }
        if (this.zza.zza().isInstance(zzgfk)) {
            return zzg(zzgfk);
        }
        throw new GeneralSecurityException(str);
    }

    public final zzgfk zzc(zzgcz zzgcz) throws GeneralSecurityException {
        try {
            return zzh().zza(zzgcz);
        } catch (zzgeo e) {
            String name = this.zza.zzi().zza().getName();
            throw new GeneralSecurityException(name.length() != 0 ? "Failures parsing proto of type ".concat(name) : new String("Failures parsing proto of type "), e);
        }
    }

    public final String zzd() {
        return this.zza.zzb();
    }

    public final Class<PrimitiveT> zze() {
        return this.zzb;
    }

    public final zzfys zzf(zzgcz zzgcz) throws GeneralSecurityException {
        try {
            zzgfk zza2 = zzh().zza(zzgcz);
            zzfyp zze = zzfys.zze();
            zze.zza(this.zza.zzb());
            zze.zzb(zza2.zzan());
            zze.zzc(this.zza.zzc());
            return (zzfys) zze.zzah();
        } catch (zzgeo e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
