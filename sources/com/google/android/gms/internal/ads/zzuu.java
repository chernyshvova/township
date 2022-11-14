package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzuu implements zzta {
    public final zzakr zza = new zzakr(6);
    public zztd zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public long zzf = -1;
    @Nullable
    public zzacu zzg;
    public zztb zzh;
    public zzux zzi;
    @Nullable
    public zzwr zzj;

    private final int zza(zztb zztb) throws IOException {
        this.zza.zza(2);
        ((zzsx) zztb).zzh(this.zza.zzi(), 0, 2, false);
        return this.zza.zzo();
    }

    private final void zzb() {
        zzc(new zzabd[0]);
        zztd zztd = this.zzb;
        if (zztd != null) {
            zztd.zzbl();
            this.zzb.zzbm(new zztu(-9223372036854775807L, 0));
            this.zzc = 6;
            return;
        }
        throw null;
    }

    private final void zzc(zzabd... zzabdArr) {
        zztd zztd = this.zzb;
        if (zztd != null) {
            zztz zza2 = zztd.zza(1024, 4);
            zzkb zzkb = new zzkb();
            zzkb.zzi(new zzabe(zzabdArr));
            zza2.zza(zzkb.zzD());
            return;
        }
        throw null;
    }

    public final boolean zzd(zztb zztb) throws IOException {
        if (zza(zztb) != 65496) {
            return false;
        }
        int zza2 = zza(zztb);
        this.zzd = zza2;
        if (zza2 == 65504) {
            this.zza.zza(2);
            zzsx zzsx = (zzsx) zztb;
            zzsx.zzh(this.zza.zzi(), 0, 2, false);
            zzsx.zzj(this.zza.zzo() - 2, false);
            zza2 = zza(zztb);
            this.zzd = zza2;
        }
        if (zza2 == 65505) {
            zzsx zzsx2 = (zzsx) zztb;
            zzsx2.zzj(2, false);
            this.zza.zza(6);
            zzsx2.zzh(this.zza.zzi(), 0, 6, false);
            if (this.zza.zzt() == 1165519206 && this.zza.zzo() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void zze(zztd zztd) {
        this.zzb = zztd;
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        String zzG;
        zzuw zza2;
        long j;
        zztb zztb2 = zztb;
        zzts zzts2 = zzts;
        int i = this.zzc;
        if (i == 0) {
            this.zza.zza(2);
            ((zzsx) zztb2).zzb(this.zza.zzi(), 0, 2, false);
            int zzo = this.zza.zzo();
            this.zzd = zzo;
            if (zzo == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                } else {
                    zzb();
                }
            } else if ((zzo < 65488 || zzo > 65497) && zzo != 65281) {
                this.zzc = 1;
            }
            return 0;
        } else if (i != 1) {
            zzacu zzacu = null;
            if (i == 2) {
                if (this.zzd == 65505) {
                    zzakr zzakr = new zzakr(this.zze);
                    ((zzsx) zztb2).zzb(zzakr.zzi(), 0, this.zze, false);
                    if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzakr.zzG(0)) && (zzG = zzakr.zzG(0)) != null) {
                        long zzo2 = zztb.zzo();
                        if (!(zzo2 == -1 || (zza2 = zzva.zza(zzG)) == null || zza2.zzb.size() < 2)) {
                            long j2 = -1;
                            long j3 = -1;
                            long j4 = -1;
                            long j5 = -1;
                            boolean z = false;
                            for (int size = zza2.zzb.size() - 1; size >= 0; size--) {
                                zzuv zzuv = zza2.zzb.get(size);
                                z |= "video/mp4".equals(zzuv.zza);
                                if (size == 0) {
                                    zzo2 -= zzuv.zzd;
                                    j = 0;
                                } else {
                                    j = zzo2 - zzuv.zzc;
                                }
                                long j6 = zzo2;
                                zzo2 = j;
                                long j7 = j6;
                                if (z && zzo2 != j7) {
                                    j5 = j7 - zzo2;
                                    j4 = zzo2;
                                    z = false;
                                }
                                if (size == 0) {
                                    j3 = j7;
                                }
                                if (size == 0) {
                                    j2 = zzo2;
                                }
                            }
                            zzacu = (j4 == -1 || j5 == -1 || j2 == -1 || j3 == -1) ? null : new zzacu(j2, j3, zza2.zza, j4, j5);
                        }
                        this.zzg = zzacu;
                        if (zzacu != null) {
                            this.zzf = zzacu.zzd;
                        }
                    }
                } else {
                    ((zzsx) zztb2).zze(this.zze, false);
                }
                this.zzc = 0;
                return 0;
            } else if (i == 4) {
                long zzn = zztb.zzn();
                long j8 = this.zzf;
                if (zzn == j8) {
                    if (!zztb2.zzh(this.zza.zzi(), 0, 1, true)) {
                        zzb();
                    } else {
                        zztb.zzl();
                        if (this.zzj == null) {
                            this.zzj = new zzwr(0);
                        }
                        zzux zzux = new zzux(zztb2, this.zzf);
                        this.zzi = zzux;
                        if (this.zzj.zzd(zzux)) {
                            zzwr zzwr = this.zzj;
                            long j9 = this.zzf;
                            zztd zztd = this.zzb;
                            if (zztd != null) {
                                zzwr.zze(new zzuz(j9, zztd));
                                zzabd[] zzabdArr = new zzabd[1];
                                zzacu zzacu2 = this.zzg;
                                if (zzacu2 != null) {
                                    zzabdArr[0] = zzacu2;
                                    zzc(zzabdArr);
                                    this.zzc = 5;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else {
                            zzb();
                        }
                    }
                    return 0;
                }
                zzts2.zza = j8;
                return 1;
            } else if (i == 5) {
                if (this.zzi == null || zztb2 != this.zzh) {
                    this.zzh = zztb2;
                    this.zzi = new zzux(zztb2, this.zzf);
                }
                zzwr zzwr2 = this.zzj;
                if (zzwr2 != null) {
                    int zzf2 = zzwr2.zzf(this.zzi, zzts2);
                    if (zzf2 == 1) {
                        zzts2.zza += this.zzf;
                    }
                    return zzf2;
                }
                throw null;
            } else if (i == 6) {
                return -1;
            } else {
                throw new IllegalStateException();
            }
        } else {
            this.zza.zza(2);
            ((zzsx) zztb2).zzb(this.zza.zzi(), 0, 2, false);
            this.zze = this.zza.zzo() - 2;
            this.zzc = 2;
            return 0;
        }
    }

    public final void zzg(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzwr zzwr = this.zzj;
            if (zzwr != null) {
                zzwr.zzg(j, j2);
                return;
            }
            throw null;
        }
    }
}
