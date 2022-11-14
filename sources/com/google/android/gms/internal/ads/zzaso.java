package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaso implements zzasl, zzask {
    public final zzasl[] zza;
    public final IdentityHashMap<zzasx, Integer> zzb = new IdentityHashMap<>();
    public zzask zzc;
    public int zzd;
    public zzatc zze;
    public zzasl[] zzf;
    public zzasz zzg;

    public zzaso(zzasl... zzaslArr) {
        this.zza = zzaslArr;
    }

    public final long zzB(zzatg[] zzatgArr, boolean[] zArr, zzasx[] zzasxArr, boolean[] zArr2, long j) {
        int length;
        int i;
        zzatg[] zzatgArr2 = zzatgArr;
        zzasx[] zzasxArr2 = zzasxArr;
        int length2 = zzatgArr2.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i2 = 0;
        while (true) {
            length = zzatgArr2.length;
            if (i2 >= length) {
                break;
            }
            zzasx zzasx = zzasxArr2[i2];
            if (zzasx == null) {
                i = -1;
            } else {
                i = this.zzb.get(zzasx).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            zzatg zzatg = zzatgArr2[i2];
            if (zzatg != null) {
                zzatb zza2 = zzatg.zza();
                int i3 = 0;
                while (true) {
                    zzasl[] zzaslArr = this.zza;
                    if (i3 >= zzaslArr.length) {
                        break;
                    } else if (zzaslArr[i3].zzg().zzb(zza2) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
        this.zzb.clear();
        zzasx[] zzasxArr3 = new zzasx[length];
        zzasx[] zzasxArr4 = new zzasx[length];
        zzatg[] zzatgArr3 = new zzatg[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.zza.length) {
            for (int i5 = 0; i5 < zzatgArr2.length; i5++) {
                zzatg zzatg2 = null;
                zzasxArr4[i5] = iArr[i5] == i4 ? zzasxArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzatg2 = zzatgArr2[i5];
                }
                zzatgArr3[i5] = zzatg2;
            }
            int i6 = i4;
            zzatg[] zzatgArr4 = zzatgArr3;
            ArrayList arrayList2 = arrayList;
            long zzB = this.zza[i4].zzB(zzatgArr3, zArr, zzasxArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = zzB;
            } else if (zzB != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzatgArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    zzaul.zzd(zzasxArr4[i7] != null);
                    zzasx zzasx2 = zzasxArr4[i7];
                    zzasxArr3[i7] = zzasx2;
                    this.zzb.put(zzasx2, Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (zzasxArr4[i7] != null) {
                        z2 = false;
                    }
                    zzaul.zzd(z2);
                }
            }
            if (z) {
                arrayList2.add(this.zza[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzatgArr3 = zzatgArr4;
            zzasxArr2 = zzasxArr;
        }
        zzasx[] zzasxArr5 = zzasxArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzasxArr3, 0, zzasxArr5, 0, length);
        zzasl[] zzaslArr2 = new zzasl[arrayList3.size()];
        this.zzf = zzaslArr2;
        arrayList3.toArray(zzaslArr2);
        this.zzg = new zzarz(this.zzf);
        return j2;
    }

    public final long zza() {
        return this.zzg.zza();
    }

    public final boolean zzb(long j) {
        return this.zzg.zzb(j);
    }

    public final void zzbp(zzasl zzasl) {
        int i = this.zzd - 1;
        this.zzd = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzasl zzg2 : this.zza) {
                i2 += zzg2.zzg().zzb;
            }
            zzatb[] zzatbArr = new zzatb[i2];
            int i3 = 0;
            for (zzasl zzg3 : this.zza) {
                zzatc zzg4 = zzg3.zzg();
                int i4 = zzg4.zzb;
                int i5 = 0;
                while (i5 < i4) {
                    zzatbArr[i3] = zzg4.zza(i5);
                    i5++;
                    i3++;
                }
            }
            this.zze = new zzatc(zzatbArr);
            this.zzc.zzbp(this);
        }
    }

    public final void zze(zzask zzask, long j) {
        this.zzc = zzask;
        this.zzd = r0;
        for (zzasl zze2 : this.zza) {
            zze2.zze(this, j);
        }
    }

    public final void zzf() throws IOException {
        for (zzasl zzf2 : this.zza) {
            zzf2.zzf();
        }
    }

    public final zzatc zzg() {
        return this.zze;
    }

    public final void zzh(long j) {
        for (zzasl zzh : this.zzf) {
            zzh.zzh(j);
        }
    }

    public final long zzi() {
        long zzi = this.zza[0].zzi();
        int i = 1;
        while (true) {
            zzasl[] zzaslArr = this.zza;
            if (i >= zzaslArr.length) {
                if (zzi != -9223372036854775807L) {
                    zzasl[] zzaslArr2 = this.zzf;
                    int length = zzaslArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zzasl zzasl = zzaslArr2[i2];
                        if (zzasl == this.zza[0] || zzasl.zzk(zzi) == zzi) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzi;
            } else if (zzaslArr[i].zzi() == -9223372036854775807L) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    public final long zzj() {
        long j = Long.MAX_VALUE;
        for (zzasl zzj : this.zzf) {
            long zzj2 = zzj.zzj();
            if (zzj2 != Long.MIN_VALUE) {
                j = Math.min(j, zzj2);
            }
        }
        if (j == RecyclerView.FOREVER_NS) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long zzk(long j) {
        long zzk = this.zzf[0].zzk(j);
        int i = 1;
        while (true) {
            zzasl[] zzaslArr = this.zzf;
            if (i >= zzaslArr.length) {
                return zzk;
            }
            if (zzaslArr[i].zzk(zzk) == zzk) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzn(zzasz zzasz) {
        zzasl zzasl = (zzasl) zzasz;
        if (this.zze != null) {
            this.zzc.zzn(this);
        }
    }
}
