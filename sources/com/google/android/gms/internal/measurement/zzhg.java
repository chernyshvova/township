package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzhg implements zzjy {
    public final zzhb zza;
    public int zzb;
    public int zzc;
    public int zzd = 0;

    public zzhg(zzhb zzhb) {
        zzhb zzhb2 = (zzhb) zzia.zza(zzhb, "input");
        this.zza = zzhb2;
        zzhb2.zzc = this;
    }

    public static zzhg zza(zzhb zzhb) {
        zzhg zzhg = zzhb.zzc;
        if (zzhg != null) {
            return zzhg;
        }
        return new zzhg(zzhb);
    }

    public final int zzb() {
        return this.zzb;
    }

    public final boolean zzc() throws IOException {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzb(i);
    }

    public final double zzd() throws IOException {
        zza(1);
        return this.zza.zzb();
    }

    public final float zze() throws IOException {
        zza(5);
        return this.zza.zzc();
    }

    public final long zzf() throws IOException {
        zza(0);
        return this.zza.zzd();
    }

    public final long zzg() throws IOException {
        zza(0);
        return this.zza.zze();
    }

    public final int zzh() throws IOException {
        zza(0);
        return this.zza.zzf();
    }

    public final long zzi() throws IOException {
        zza(1);
        return this.zza.zzg();
    }

    public final int zzj() throws IOException {
        zza(5);
        return this.zza.zzh();
    }

    public final boolean zzk() throws IOException {
        zza(0);
        return this.zza.zzi();
    }

    public final String zzl() throws IOException {
        zza(2);
        return this.zza.zzj();
    }

    public final String zzm() throws IOException {
        zza(2);
        return this.zza.zzk();
    }

    public final zzgp zzn() throws IOException {
        zza(2);
        return this.zza.zzl();
    }

    public final int zzo() throws IOException {
        zza(0);
        return this.zza.zzm();
    }

    public final int zzp() throws IOException {
        zza(0);
        return this.zza.zzn();
    }

    public final int zzq() throws IOException {
        zza(5);
        return this.zza.zzo();
    }

    public final long zzr() throws IOException {
        zza(1);
        return this.zza.zzp();
    }

    public final int zzs() throws IOException {
        zza(0);
        return this.zza.zzq();
    }

    public final long zzt() throws IOException {
        zza(0);
        return this.zza.zzr();
    }

    public final <T> T zzb(zzkb<T> zzkb, zzhl zzhl) throws IOException {
        zza(3);
        return zzd(zzkb, zzhl);
    }

    private final <T> T zzc(zzkb<T> zzkb, zzhl zzhl) throws IOException {
        int zzm = this.zza.zzm();
        zzhb zzhb = this.zza;
        if (zzhb.zza < zzhb.zzb) {
            int zzc2 = zzhb.zzc(zzm);
            T zza2 = zzkb.zza();
            this.zza.zza++;
            zzkb.zza(zza2, this, zzhl);
            zzkb.zzc(zza2);
            this.zza.zza(0);
            zzhb zzhb2 = this.zza;
            zzhb2.zza--;
            zzhb2.zzd(zzc2);
            return zza2;
        }
        throw new zzij("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzkb<T> zzkb, zzhl zzhl) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza2 = zzkb.zza();
            zzkb.zza(zza2, this, zzhl);
            zzkb.zzc(zza2);
            if (this.zzb == this.zzc) {
                return zza2;
            }
            throw zzij.zzg();
        } finally {
            this.zzc = i;
        }
    }

    public final int zza() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zza();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final void zze(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzib.zzd(this.zza.zzf());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzib.zzd(this.zza.zzf());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzix.zza(this.zza.zzg());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzix.zza(this.zza.zzg());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzg(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzib.zzd(this.zza.zzh());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzib.zzd(this.zza.zzh());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgn) {
            zzgn zzgn = (zzgn) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgn.zza(this.zza.zzi());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgn.zza(this.zza.zzi());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzj(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzk(List<zzgp> list) throws IOException {
        int zza2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzn());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        throw zzij.zzf();
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzib.zzd(this.zza.zzm());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzib.zzd(this.zza.zzm());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzib.zzd(this.zza.zzn());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzib.zzd(this.zza.zzn());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzn(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzib.zzd(this.zza.zzo());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzib.zzd(this.zza.zzo());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzo(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzix.zza(this.zza.zzp());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzix.zza(this.zza.zzp());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzp(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzib.zzd(this.zza.zzq());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzib.zzd(this.zza.zzq());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzq(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzix.zza(this.zza.zzr());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzix.zza(this.zza.zzr());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzb(List<Float> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzhx) {
            zzhx zzhx = (zzhx) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzhx.zza(this.zza.zzc());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzhx.zza(this.zza.zzc());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzij.zzf();
            }
        }
    }

    private final void zza(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzij.zzf();
        }
    }

    public final <T> T zza(zzkb<T> zzkb, zzhl zzhl) throws IOException {
        zza(2);
        return zzc(zzkb, zzhl);
    }

    public final void zza(List<Double> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzhj) {
            zzhj zzhj = (zzhj) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzhj.zza(this.zza.zzb());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzhj.zza(this.zza.zzb());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzd(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzix.zza(this.zza.zze());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzix.zza(this.zza.zze());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final void zzc(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzix.zza(this.zza.zzd());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzix.zza(this.zza.zzd());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzij.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzij.zzf();
            }
        }
    }

    public final <T> void zzb(List<T> list, zzkb<T> zzkb, zzhl zzhl) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzkb, zzhl));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzij.zzf();
    }

    public static void zzb(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzij.zzg();
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zza2;
        int zza3;
        if ((this.zzb & 7) != 2) {
            throw zzij.zzf();
        } else if (!(list instanceof zziq) || z) {
            do {
                list.add(z ? zzm() : zzl());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        } else {
            zziq zziq = (zziq) list;
            do {
                zziq.zza(zzn());
                if (!this.zza.zzt()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
        }
    }

    private final void zzd(int i) throws IOException {
        if (this.zza.zzu() != i) {
            throw zzij.zza();
        }
    }

    public static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzij.zzg();
        }
    }

    public final <T> void zza(List<T> list, zzkb<T> zzkb, zzhl zzhl) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzkb, zzhl));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzij.zzf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzc() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.measurement.zzij("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.measurement.zzja<K, V> r9, com.google.android.gms.internal.measurement.zzhl r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zza((int) r0)
            com.google.android.gms.internal.measurement.zzhb r1 = r7.zza
            int r1 = r1.zzm()
            com.google.android.gms.internal.measurement.zzhb r2 = r7.zza
            int r1 = r2.zzc(r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L_0x0014:
            int r4 = r7.zza()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.measurement.zzhb r5 = r7.zza     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzt()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzc()     // Catch:{ zzii -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.measurement.zzij r4 = new com.google.android.gms.internal.measurement.zzij     // Catch:{ zzii -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzii -> 0x004e }
            throw r4     // Catch:{ zzii -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.measurement.zzlg r4 = r9.zzc     // Catch:{ zzii -> 0x004e }
            V r5 = r9.zzd     // Catch:{ zzii -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzii -> 0x004e }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.measurement.zzlg) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzhl) r10)     // Catch:{ zzii -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.measurement.zzlg r4 = r9.zza     // Catch:{ zzii -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza((com.google.android.gms.internal.measurement.zzlg) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzhl) r5)     // Catch:{ zzii -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzc()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.measurement.zzij r8 = new com.google.android.gms.internal.measurement.zzij     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.measurement.zzhb r8 = r7.zza
            r8.zzd(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.measurement.zzhb r9 = r7.zza
            r9.zzd(r1)
            goto L_0x006c
        L_0x006b:
            throw r8
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhg.zza(java.util.Map, com.google.android.gms.internal.measurement.zzja, com.google.android.gms.internal.measurement.zzhl):void");
    }

    private final Object zza(zzlg zzlg, Class<?> cls, zzhl zzhl) throws IOException {
        switch (zzhf.zza[zzlg.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzk());
            case 2:
                return zzn();
            case 3:
                return Double.valueOf(zzd());
            case 4:
                return Integer.valueOf(zzp());
            case 5:
                return Integer.valueOf(zzj());
            case 6:
                return Long.valueOf(zzi());
            case 7:
                return Float.valueOf(zze());
            case 8:
                return Integer.valueOf(zzh());
            case 9:
                return Long.valueOf(zzg());
            case 10:
                zza(2);
                return zzc(zzjx.zza().zza(cls), zzhl);
            case 11:
                return Integer.valueOf(zzq());
            case 12:
                return Long.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Long.valueOf(zzt());
            case 15:
                return zzm();
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
