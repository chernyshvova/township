package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgdf implements zzgfv {
    public final zzgde zza;
    public int zzb;
    public int zzc;
    public int zzd = 0;

    public zzgdf(zzgde zzgde) {
        zzgem.zzb(zzgde, "input");
        this.zza = zzgde;
        zzgde.zzb = this;
    }

    private final void zzP(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzgeo.zzi();
        }
    }

    private final <T> T zzQ(zzgga<T> zzgga, zzgdo zzgdo) throws IOException {
        int zzo = this.zza.zzo();
        zzgde zzgde = this.zza;
        if (zzgde.zza < 100) {
            int zzz = zzgde.zzz(zzo);
            T zza2 = zzgga.zza();
            this.zza.zza++;
            zzgga.zzf(zza2, this, zzgdo);
            zzgga.zzj(zza2);
            this.zza.zzb(0);
            zzgde zzgde2 = this.zza;
            zzgde2.zza--;
            zzgde2.zzA(zzz);
            return zza2;
        }
        throw new zzgeo("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzR(zzgga<T> zzgga, zzgdo zzgdo) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza2 = zzgga.zza();
            zzgga.zzf(zza2, this, zzgdo);
            zzgga.zzj(zza2);
            if (this.zzb == this.zzc) {
                return zza2;
            }
            throw zzgeo.zzk();
        } finally {
            this.zzc = i;
        }
    }

    private final void zzS(int i) throws IOException {
        if (this.zza.zzC() != i) {
            throw zzgeo.zzd();
        }
    }

    public static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzgeo.zzk();
        }
    }

    public static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzgeo.zzk();
        }
    }

    public static zzgdf zza(zzgde zzgde) {
        zzgdf zzgdf = zzgde.zzb;
        return zzgdf != null ? zzgdf : new zzgdf(zzgde);
    }

    public final void zzA(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgez) {
            zzgez zzgez = (zzgez) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgez.zzg(this.zza.zzg());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzgez.zzg(this.zza.zzg());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzB(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzged.zzh(this.zza.zzh());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzged.zzh(this.zza.zzh());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzC(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgez) {
            zzgez zzgez = (zzgez) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzgez.zzg(this.zza.zzi());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzo = this.zza.zzo();
                zzU(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzgez.zzg(this.zza.zzi());
                } while (this.zza.zzC() < zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzi()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzU(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Long.valueOf(this.zza.zzi()));
                } while (this.zza.zzC() < zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzD(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzo = this.zza.zzo();
                zzT(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzged.zzh(this.zza.zzj());
                } while (this.zza.zzC() < zzC);
            } else if (i == 5) {
                do {
                    zzged.zzh(this.zza.zzj());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzT(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzC() < zzC2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzE(List<Boolean> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgco) {
            zzgco zzgco = (zzgco) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgco.zzd(this.zza.zzk());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzgco.zzd(this.zza.zzk());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzk()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Boolean.valueOf(this.zza.zzk()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzF(List<String> list, boolean z) throws IOException {
        int zza2;
        int zza3;
        if ((this.zzb & 7) != 2) {
            throw zzgeo.zzi();
        } else if ((list instanceof zzgeu) && !z) {
            zzgeu zzgeu = (zzgeu) list;
            do {
                zzgeu.zzf(zzq());
                if (!this.zza.zzB()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
        } else {
            do {
                list.add(z ? zzn() : zzm());
                if (!this.zza.zzB()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        }
    }

    public final <T> void zzG(List<T> list, zzgga<T> zzgga, zzgdo zzgdo) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzQ(zzgga, zzgdo));
                if (!this.zza.zzB() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzgeo.zzi();
    }

    public final <T> void zzH(List<T> list, zzgga<T> zzgga, zzgdo zzgdo) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzR(zzgga, zzgdo));
                if (!this.zza.zzB() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzgeo.zzi();
    }

    public final void zzI(List<zzgcz> list) throws IOException {
        int zza2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzq());
                if (!this.zza.zzB()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        throw zzgeo.zzi();
    }

    public final void zzJ(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzged.zzh(this.zza.zzo());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzged.zzh(this.zza.zzo());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzK(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzged.zzh(this.zza.zzp());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzged.zzh(this.zza.zzp());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzp()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Integer.valueOf(this.zza.zzp()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzL(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzo = this.zza.zzo();
                zzT(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzged.zzh(this.zza.zzq());
                } while (this.zza.zzC() < zzC);
            } else if (i == 5) {
                do {
                    zzged.zzh(this.zza.zzq());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzT(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                } while (this.zza.zzC() < zzC2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzM(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgez) {
            zzgez zzgez = (zzgez) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzgez.zzg(this.zza.zzr());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzo = this.zza.zzo();
                zzU(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzgez.zzg(this.zza.zzr());
                } while (this.zza.zzC() < zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzU(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                } while (this.zza.zzC() < zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzN(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzged.zzh(this.zza.zzs());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzged.zzh(this.zza.zzs());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzs()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Integer.valueOf(this.zza.zzs()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzO(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgez) {
            zzgez zzgez = (zzgez) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgez.zzg(this.zza.zzt());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzgez.zzg(this.zza.zzt());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final int zzb() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zza();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() throws IOException {
        int i;
        if (this.zza.zzB() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzc(i);
    }

    public final double zze() throws IOException {
        zzP(1);
        return this.zza.zzd();
    }

    public final float zzf() throws IOException {
        zzP(5);
        return this.zza.zze();
    }

    public final long zzg() throws IOException {
        zzP(0);
        return this.zza.zzf();
    }

    public final long zzh() throws IOException {
        zzP(0);
        return this.zza.zzg();
    }

    public final int zzi() throws IOException {
        zzP(0);
        return this.zza.zzh();
    }

    public final long zzj() throws IOException {
        zzP(1);
        return this.zza.zzi();
    }

    public final int zzk() throws IOException {
        zzP(5);
        return this.zza.zzj();
    }

    public final boolean zzl() throws IOException {
        zzP(0);
        return this.zza.zzk();
    }

    public final String zzm() throws IOException {
        zzP(2);
        return this.zza.zzl();
    }

    public final String zzn() throws IOException {
        zzP(2);
        return this.zza.zzm();
    }

    public final <T> T zzo(zzgga<T> zzgga, zzgdo zzgdo) throws IOException {
        zzP(2);
        return zzQ(zzgga, zzgdo);
    }

    public final <T> T zzp(zzgga<T> zzgga, zzgdo zzgdo) throws IOException {
        zzP(3);
        return zzR(zzgga, zzgdo);
    }

    public final zzgcz zzq() throws IOException {
        zzP(2);
        return this.zza.zzn();
    }

    public final int zzr() throws IOException {
        zzP(0);
        return this.zza.zzo();
    }

    public final int zzs() throws IOException {
        zzP(0);
        return this.zza.zzp();
    }

    public final int zzt() throws IOException {
        zzP(5);
        return this.zza.zzq();
    }

    public final long zzu() throws IOException {
        zzP(1);
        return this.zza.zzr();
    }

    public final int zzv() throws IOException {
        zzP(0);
        return this.zza.zzs();
    }

    public final long zzw() throws IOException {
        zzP(0);
        return this.zza.zzt();
    }

    public final void zzx(List<Double> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgdl) {
            zzgdl zzgdl = (zzgdl) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzgdl.zzd(this.zza.zzd());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzo = this.zza.zzo();
                zzU(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzgdl.zzd(this.zza.zzd());
                } while (this.zza.zzC() < zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzd()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzU(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Double.valueOf(this.zza.zzd()));
                } while (this.zza.zzC() < zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzy(List<Float> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgdv) {
            zzgdv zzgdv = (zzgdv) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzo = this.zza.zzo();
                zzT(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzgdv.zzd(this.zza.zze());
                } while (this.zza.zzC() < zzC);
            } else if (i == 5) {
                do {
                    zzgdv.zzd(this.zza.zze());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzT(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Float.valueOf(this.zza.zze()));
                } while (this.zza.zzC() < zzC2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zze()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzgeo.zzi();
            }
        }
    }

    public final void zzz(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgez) {
            zzgez zzgez = (zzgez) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgez.zzg(this.zza.zzf());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzgez.zzg(this.zza.zzf());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzgeo.zzi();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzf()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Long.valueOf(this.zza.zzf()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzgeo.zzi();
            }
        }
    }
}
