package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaqw implements zzapl, zzaps {
    public static final zzapn zza = new zzaqu();
    public static final int zzb = zzava.zzl("qt  ");
    public final zzaut zzc = new zzaut(zzaur.zza);
    public final zzaut zzd = new zzaut(4);
    public final zzaut zze = new zzaut(16);
    public final Stack<zzaqe> zzf = new Stack<>();
    public int zzg;
    public int zzh;
    public long zzi;
    public int zzj;
    public zzaut zzk;
    public int zzl;
    public int zzm;
    public zzapm zzn;
    public zzaqv[] zzo;
    public long zzp;
    public boolean zzq;

    private final void zzh() {
        this.zzg = 0;
        this.zzj = 0;
    }

    private final void zzi(long j) throws zzann {
        zzarq zzarq;
        zzarq zzarq2;
        zzapp zzapp;
        zzaqy zza2;
        while (!this.zzf.isEmpty() && this.zzf.peek().zza == j) {
            zzaqe pop = this.zzf.pop();
            if (pop.zzaR == zzaqg.zzE) {
                ArrayList arrayList = new ArrayList();
                zzapp zzapp2 = new zzapp();
                zzaqf zzc2 = pop.zzc(zzaqg.zzaC);
                if (zzc2 != null) {
                    zzarq = zzaqn.zzc(zzc2, this.zzq);
                    if (zzarq != null) {
                        zzapp2.zza(zzarq);
                    }
                } else {
                    zzarq = null;
                }
                long j2 = -9223372036854775807L;
                long j3 = RecyclerView.FOREVER_NS;
                int i = 0;
                while (i < pop.zzc.size()) {
                    zzaqe zzaqe = pop.zzc.get(i);
                    if (zzaqe.zzaR == zzaqg.zzG && (zza2 = zzaqn.zza(zzaqe, pop.zzc(zzaqg.zzF), -9223372036854775807L, (zzaph) null, this.zzq)) != null) {
                        zzarb zzb2 = zzaqn.zzb(zza2, zzaqe.zzd(zzaqg.zzH).zzd(zzaqg.zzI).zzd(zzaqg.zzJ), zzapp2);
                        if (zzb2.zza != 0) {
                            zzaqv zzaqv = new zzaqv(zza2, zzb2, this.zzn.zzbn(i, zza2.zzb));
                            zzank zzg2 = zza2.zzf.zzg(zzb2.zzd + 30);
                            if (zza2.zzb == 1) {
                                if (zzapp2.zzb()) {
                                    zzg2 = zzg2.zzh(zzapp2.zzb, zzapp2.zzc);
                                }
                                if (zzarq != null) {
                                    zzg2 = zzg2.zzj(zzarq);
                                }
                            }
                            zzaqv.zzc.zza(zzg2);
                            zzapp = zzapp2;
                            zzarq2 = zzarq;
                            long max = Math.max(j2, zza2.zze);
                            arrayList.add(zzaqv);
                            long j4 = zzb2.zzb[0];
                            if (j4 < j3) {
                                j2 = max;
                                j3 = j4;
                            } else {
                                j2 = max;
                            }
                            i++;
                            zzapp2 = zzapp;
                            zzarq = zzarq2;
                        }
                    }
                    zzapp = zzapp2;
                    zzarq2 = zzarq;
                    i++;
                    zzapp2 = zzapp;
                    zzarq = zzarq2;
                }
                this.zzp = j2;
                this.zzo = (zzaqv[]) arrayList.toArray(new zzaqv[arrayList.size()]);
                this.zzn.zzbo();
                this.zzn.zzc(this);
                this.zzf.clear();
                this.zzg = 2;
            } else if (!this.zzf.isEmpty()) {
                this.zzf.peek().zzb(pop);
            }
        }
        if (this.zzg != 2) {
            zzh();
        }
    }

    public final boolean zza() {
        return true;
    }

    public final long zzb() {
        return this.zzp;
    }

    public final long zzc(long j) {
        long j2 = RecyclerView.FOREVER_NS;
        for (zzaqv zzaqv : this.zzo) {
            zzarb zzarb = zzaqv.zzb;
            int zza2 = zzarb.zza(j);
            if (zza2 == -1) {
                zza2 = zzarb.zzb(j);
            }
            long j3 = zzarb.zzb[zza2];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public final void zzd(zzapm zzapm) {
        this.zzn = zzapm;
    }

    public final void zze(long j, long j2) {
        this.zzf.clear();
        this.zzj = 0;
        this.zzl = 0;
        this.zzm = 0;
        if (j == 0) {
            zzh();
            return;
        }
        zzaqv[] zzaqvArr = this.zzo;
        if (zzaqvArr != null) {
            for (zzaqv zzaqv : zzaqvArr) {
                zzarb zzarb = zzaqv.zzb;
                int zza2 = zzarb.zza(j2);
                if (zza2 == -1) {
                    zza2 = zzarb.zzb(j2);
                }
                zzaqv.zzd = zza2;
            }
        }
    }

    public final boolean zzf(zzapk zzapk) throws IOException, InterruptedException {
        return zzaqx.zzb(zzapk);
    }

    public final int zzg(zzapk zzapk, zzapq zzapq) throws IOException, InterruptedException {
        zzaqv[] zzaqvArr;
        boolean z;
        boolean z2;
        zzapk zzapk2 = zzapk;
        zzapq zzapq2 = zzapq;
        while (true) {
            int i = this.zzg;
            if (i == 0) {
                if (this.zzj == 0) {
                    if (!zzapk2.zzb(this.zze.zza, 0, 8, true)) {
                        return -1;
                    }
                    this.zzj = 8;
                    this.zze.zzi(0);
                    this.zzi = this.zze.zzp();
                    this.zzh = this.zze.zzr();
                }
                if (this.zzi == 1) {
                    zzapk2.zzb(this.zze.zza, 8, 8, false);
                    this.zzj += 8;
                    this.zzi = this.zze.zzv();
                }
                int i2 = this.zzh;
                if (i2 == zzaqg.zzE || i2 == zzaqg.zzG || i2 == zzaqg.zzH || i2 == zzaqg.zzI || i2 == zzaqg.zzJ || i2 == zzaqg.zzS) {
                    long zzh2 = (zzapk.zzh() + this.zzi) - ((long) this.zzj);
                    this.zzf.add(new zzaqe(this.zzh, zzh2));
                    if (this.zzi == ((long) this.zzj)) {
                        zzi(zzh2);
                    } else {
                        zzh();
                    }
                } else {
                    if (i2 == zzaqg.zzU || i2 == zzaqg.zzF || i2 == zzaqg.zzV || i2 == zzaqg.zzW || i2 == zzaqg.zzao || i2 == zzaqg.zzap || i2 == zzaqg.zzaq || i2 == zzaqg.zzT || i2 == zzaqg.zzar || i2 == zzaqg.zzas || i2 == zzaqg.zzat || i2 == zzaqg.zzau || i2 == zzaqg.zzav || i2 == zzaqg.zzR || i2 == zzaqg.zzd || i2 == zzaqg.zzaC) {
                        zzaul.zzd(this.zzj == 8);
                        zzaul.zzd(this.zzi <= 2147483647L);
                        zzaut zzaut = new zzaut((int) this.zzi);
                        this.zzk = zzaut;
                        System.arraycopy(this.zze.zza, 0, zzaut.zza, 0, 8);
                    } else {
                        this.zzk = null;
                    }
                    this.zzg = 1;
                }
            } else if (i != 1) {
                long j = RecyclerView.FOREVER_NS;
                int i3 = 0;
                int i4 = -1;
                while (true) {
                    zzaqvArr = this.zzo;
                    if (i3 >= zzaqvArr.length) {
                        break;
                    }
                    zzaqv zzaqv = zzaqvArr[i3];
                    int i5 = zzaqv.zzd;
                    zzarb zzarb = zzaqv.zzb;
                    if (i5 != zzarb.zza) {
                        long j2 = zzarb.zzb[i5];
                        if (j2 < j) {
                            i4 = i3;
                            j = j2;
                        }
                    }
                    i3++;
                }
                if (i4 == -1) {
                    return -1;
                }
                zzaqv zzaqv2 = zzaqvArr[i4];
                zzapu zzapu = zzaqv2.zzc;
                int i6 = zzaqv2.zzd;
                zzarb zzarb2 = zzaqv2.zzb;
                long j3 = zzarb2.zzb[i6];
                int i7 = zzarb2.zzc[i6];
                if (zzaqv2.zza.zzg == 1) {
                    j3 += 8;
                    i7 -= 8;
                }
                long zzh3 = (j3 - zzapk.zzh()) + ((long) this.zzl);
                if (zzh3 < 0 || zzh3 >= 262144) {
                    zzapq2.zza = j3;
                    return 1;
                }
                int i8 = (int) zzh3;
                boolean z3 = false;
                zzapk2.zzd(i8, false);
                int i9 = zzaqv2.zza.zzk;
                if (i9 == 0) {
                    while (true) {
                        int i10 = this.zzl;
                        if (i10 >= i7) {
                            break;
                        }
                        int zzd2 = zzapu.zzd(zzapk2, i7 - i10, false);
                        this.zzl += zzd2;
                        this.zzm -= zzd2;
                    }
                } else {
                    byte[] bArr = this.zzd.zza;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i11 = 4 - i9;
                    while (this.zzl < i7) {
                        int i12 = this.zzm;
                        if (i12 == 0) {
                            zzapk2.zzb(this.zzd.zza, i11, i9, z3);
                            this.zzd.zzi(z3 ? 1 : 0);
                            this.zzm = this.zzd.zzu();
                            this.zzc.zzi(z3);
                            zzapu.zzb(this.zzc, 4);
                            this.zzl += 4;
                            i7 += i11;
                        } else {
                            int zzd3 = zzapu.zzd(zzapk2, i12, z3);
                            this.zzl += zzd3;
                            this.zzm -= zzd3;
                            z3 = false;
                        }
                    }
                }
                int i13 = i7;
                zzarb zzarb3 = zzaqv2.zzb;
                zzapu.zzc(zzarb3.zze[i6], zzarb3.zzf[i6], i13, 0, (zzapt) null);
                zzaqv2.zzd++;
                this.zzl = 0;
                this.zzm = 0;
                return 0;
            } else {
                long j4 = this.zzi - ((long) this.zzj);
                long zzh4 = zzapk.zzh() + j4;
                zzaut zzaut2 = this.zzk;
                if (zzaut2 != null) {
                    zzapk2.zzb(zzaut2.zza, this.zzj, (int) j4, false);
                    if (this.zzh == zzaqg.zzd) {
                        zzaut zzaut3 = this.zzk;
                        zzaut3.zzi(8);
                        if (zzaut3.zzr() == zzb) {
                            z2 = true;
                        } else {
                            zzaut3.zzj(4);
                            while (true) {
                                if (zzaut3.zzd() > 0) {
                                    if (zzaut3.zzr() == zzb) {
                                        break;
                                    }
                                } else {
                                    z2 = false;
                                    break;
                                }
                            }
                            z2 = true;
                        }
                        this.zzq = z2;
                    } else if (!this.zzf.isEmpty()) {
                        this.zzf.peek().zza(new zzaqf(this.zzh, this.zzk));
                    }
                } else if (j4 < 262144) {
                    zzapk2.zzd((int) j4, false);
                } else {
                    zzapq2.zza = zzapk.zzh() + j4;
                    z = true;
                    zzi(zzh4);
                    if (z && this.zzg != 2) {
                        return 1;
                    }
                }
                z = false;
                zzi(zzh4);
                return 1;
            }
        }
    }
}
