package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfo<T> implements zzgga<T> {
    public final zzgfk zza;
    public final zzggo<?, ?> zzb;
    public final boolean zzc;
    public final zzgdp<?> zzd;

    public zzgfo(zzggo<?, ?> zzggo, zzgdp<?> zzgdp, zzgfk zzgfk) {
        this.zzb = zzggo;
        this.zzc = zzgdp.zza(zzgfk);
        this.zzd = zzgdp;
        this.zza = zzgfk;
    }

    public static <T> zzgfo<T> zzg(zzggo<?, ?> zzggo, zzgdp<?> zzgdp, zzgfk zzgfk) {
        return new zzgfo<>(zzggo, zzgdp, zzgfk);
    }

    public final T zza() {
        return this.zza.zzaM().zzak();
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzj(t).equals(this.zzb.zzj(t2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zzb(t);
        this.zzd.zzb(t2);
        throw null;
    }

    public final int zzc(T t) {
        int hashCode = this.zzb.zzj(t).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzd(T t, T t2) {
        zzggc.zzF(this.zzb, t, t2);
        if (this.zzc) {
            zzggc.zzE(this.zzd, t, t2);
        }
    }

    public final int zze(T t) {
        zzggo<?, ?> zzggo = this.zzb;
        int zzp = zzggo.zzp(zzggo.zzj(t));
        if (!this.zzc) {
            return zzp;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzf(T t, zzgfv zzgfv, zzgdo zzgdo) throws IOException {
        boolean z;
        zzggo<?, ?> zzggo = this.zzb;
        zzgdp<?> zzgdp = this.zzd;
        Object zzk = zzggo.zzk(t);
        zzgdt<?> zzc2 = zzgdp.zzc(t);
        while (zzgfv.zzb() != Integer.MAX_VALUE) {
            int zzc3 = zzgfv.zzc();
            if (zzc3 != 11) {
                if ((zzc3 & 7) == 2) {
                    Object zzf = zzgdp.zzf(zzgdo, this.zza, zzc3 >>> 3);
                    if (zzf != null) {
                        zzgdp.zzg(zzgfv, zzf, zzgdo, zzc2);
                    } else {
                        z = zzggo.zzn(zzk, zzgfv);
                    }
                } else {
                    z = zzgfv.zzd();
                }
                if (!z) {
                    zzggo.zzl(t, zzk);
                    return;
                }
            } else {
                int i = 0;
                Object obj = null;
                zzgcz zzgcz = null;
                while (true) {
                    try {
                        if (zzgfv.zzb() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzc4 = zzgfv.zzc();
                        if (zzc4 == 16) {
                            i = zzgfv.zzr();
                            obj = zzgdp.zzf(zzgdo, this.zza, i);
                        } else if (zzc4 == 26) {
                            if (obj != null) {
                                zzgdp.zzg(zzgfv, obj, zzgdo, zzc2);
                            } else {
                                zzgcz = zzgfv.zzq();
                            }
                        } else if (!zzgfv.zzd()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzggo.zzl(t, zzk);
                        throw th;
                    }
                }
                if (zzgfv.zzc() != 12) {
                    throw zzgeo.zzh();
                } else if (zzgcz != null) {
                    if (obj != null) {
                        zzgdp.zzh(zzgcz, obj, zzgdo, zzc2);
                    } else {
                        zzggo.zze(zzk, i, zzgcz);
                    }
                }
            }
        }
        zzggo.zzl(t, zzk);
    }

    public final void zzi(T t, byte[] bArr, int i, int i2, zzgcm zzgcm) throws IOException {
        zzgec zzgec = (zzgec) t;
        if (zzgec.zzc == zzggp.zza()) {
            zzgec.zzc = zzggp.zzb();
        }
        zzgdz zzgdz = (zzgdz) t;
        throw null;
    }

    public final void zzj(T t) {
        this.zzb.zzm(t);
        this.zzd.zzd(t);
    }

    public final boolean zzk(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzn(T t, zzgdk zzgdk) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
