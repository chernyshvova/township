package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaej implements zzadt, zzads {
    public final zzadt[] zza;
    public final IdentityHashMap<zzafj, Integer> zzb;
    public final ArrayList<zzadt> zzc = new ArrayList<>();
    @Nullable
    public zzads zzd;
    @Nullable
    public zzaft zze;
    public zzadt[] zzf;
    public zzafl zzg;
    public final zzadh zzh;

    public zzaej(zzadh zzadh, long[] jArr, zzadt[] zzadtArr, byte... bArr) {
        this.zzh = zzadh;
        this.zza = zzadtArr;
        this.zzg = new zzadg(new zzafl[0]);
        this.zzb = new IdentityHashMap<>();
        this.zzf = new zzadt[0];
        for (int i = 0; i < zzadtArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zza[i] = new zzaeh(zzadtArr[i], j);
            }
        }
    }

    public final zzadt zza(int i) {
        zzadt zzadt = this.zza[i];
        return zzadt instanceof zzaeh ? ((zzaeh) zzadt).zza : zzadt;
    }

    public final void zzb(zzads zzads, long j) {
        this.zzd = zzads;
        Collections.addAll(this.zzc, this.zza);
        for (zzadt zzb2 : this.zza) {
            zzb2.zzb(this, j);
        }
    }

    public final void zzc() throws IOException {
        for (zzadt zzc2 : this.zza) {
            zzc2.zzc();
        }
    }

    public final zzaft zzd() {
        zzaft zzaft = this.zze;
        if (zzaft != null) {
            return zzaft;
        }
        throw null;
    }

    public final void zze(long j, boolean z) {
        for (zzadt zze2 : this.zzf) {
            zze2.zze(j, false);
        }
    }

    public final void zzf(long j) {
        this.zzg.zzf(j);
    }

    public final long zzg() {
        long j = -9223372036854775807L;
        for (zzadt zzadt : this.zzf) {
            long zzg2 = zzadt.zzg();
            if (zzg2 != -9223372036854775807L) {
                if (j == -9223372036854775807L) {
                    zzadt[] zzadtArr = this.zzf;
                    int length = zzadtArr.length;
                    int i = 0;
                    while (i < length) {
                        zzadt zzadt2 = zzadtArr[i];
                        if (zzadt2 == zzadt) {
                            break;
                        } else if (zzadt2.zzi(zzg2) == zzg2) {
                            i++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = zzg2;
                } else if (zzg2 != j) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j == -9223372036854775807L || zzadt.zzi(j) == j)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    public final long zzh() {
        return this.zzg.zzh();
    }

    public final long zzi(long j) {
        long zzi = this.zzf[0].zzi(j);
        int i = 1;
        while (true) {
            zzadt[] zzadtArr = this.zzf;
            if (i >= zzadtArr.length) {
                return zzi;
            }
            if (zzadtArr[i].zzi(zzi) == zzi) {
                i++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public final void zzj(zzadt zzadt) {
        this.zzc.remove(zzadt);
        if (this.zzc.isEmpty()) {
            int i = 0;
            for (zzadt zzd2 : this.zza) {
                i += zzd2.zzd().zzb;
            }
            zzafr[] zzafrArr = new zzafr[i];
            int i2 = 0;
            for (zzadt zzd3 : this.zza) {
                zzaft zzd4 = zzd3.zzd();
                int i3 = zzd4.zzb;
                int i4 = 0;
                while (i4 < i3) {
                    zzafrArr[i2] = zzd4.zza(i4);
                    i4++;
                    i2++;
                }
            }
            this.zze = new zzaft(zzafrArr);
            zzads zzads = this.zzd;
            if (zzads != null) {
                zzads.zzj(this);
                return;
            }
            throw null;
        }
    }

    public final long zzk(long j, zzme zzme) {
        zzadt zzadt;
        zzadt[] zzadtArr = this.zzf;
        if (zzadtArr.length > 0) {
            zzadt = zzadtArr[0];
        } else {
            zzadt = this.zza[0];
        }
        return zzadt.zzk(j, zzme);
    }

    public final long zzl() {
        return this.zzg.zzl();
    }

    public final /* bridge */ /* synthetic */ void zzm(zzafl zzafl) {
        zzadt zzadt = (zzadt) zzafl;
        zzads zzads = this.zzd;
        if (zzads != null) {
            zzads.zzm(this);
            return;
        }
        throw null;
    }

    public final boolean zzn(long j) {
        if (this.zzc.isEmpty()) {
            return this.zzg.zzn(j);
        }
        int size = this.zzc.size();
        for (int i = 0; i < size; i++) {
            this.zzc.get(i).zzn(j);
        }
        return false;
    }

    public final boolean zzo() {
        return this.zzg.zzo();
    }

    public final long zzq(zzagf[] zzagfArr, boolean[] zArr, zzafj[] zzafjArr, boolean[] zArr2, long j) {
        int length;
        ArrayList arrayList;
        int i;
        zzagf[] zzagfArr2 = zzagfArr;
        zzafj[] zzafjArr2 = zzafjArr;
        int length2 = zzagfArr2.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i2 = 0;
        while (true) {
            length = zzagfArr2.length;
            Integer num = null;
            if (i2 >= length) {
                break;
            }
            zzafj zzafj = zzafjArr2[i2];
            if (zzafj != null) {
                num = this.zzb.get(zzafj);
            }
            if (num == null) {
                i = -1;
            } else {
                i = num.intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            zzagf zzagf = zzagfArr2[i2];
            if (zzagf != null) {
                zzafr zzb2 = zzagf.zzb();
                int i3 = 0;
                while (true) {
                    zzadt[] zzadtArr = this.zza;
                    if (i3 >= zzadtArr.length) {
                        break;
                    } else if (zzadtArr[i3].zzd().zzb(zzb2) != -1) {
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
        zzafj[] zzafjArr3 = new zzafj[length];
        zzafj[] zzafjArr4 = new zzafj[length];
        zzagf[] zzagfArr3 = new zzagf[length];
        ArrayList arrayList2 = new ArrayList(this.zza.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.zza.length) {
            for (int i5 = 0; i5 < zzagfArr2.length; i5++) {
                zzafjArr4[i5] = iArr[i5] == i4 ? zzafjArr2[i5] : null;
                zzagfArr3[i5] = iArr2[i5] == i4 ? zzagfArr2[i5] : null;
            }
            int i6 = i4;
            ArrayList arrayList3 = arrayList2;
            zzafj[] zzafjArr5 = zzafjArr4;
            zzagf[] zzagfArr4 = zzagfArr3;
            long zzq = this.zza[i4].zzq(zzagfArr3, zArr, zzafjArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = zzq;
            } else if (zzq != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzagfArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    zzafj zzafj2 = zzafjArr5[i7];
                    if (zzafj2 != null) {
                        zzafjArr3[i7] = zzafj2;
                        this.zzb.put(zzafj2, Integer.valueOf(i6));
                        z = true;
                    } else {
                        throw null;
                    }
                } else if (iArr[i7] == i6) {
                    if (zzafjArr5[i7] != null) {
                        z2 = false;
                    }
                    zzajg.zzd(z2);
                }
            }
            if (z) {
                arrayList = arrayList3;
                arrayList.add(this.zza[i6]);
            } else {
                arrayList = arrayList3;
            }
            i4 = i6 + 1;
            arrayList2 = arrayList;
            zzafjArr4 = zzafjArr5;
            zzagfArr3 = zzagfArr4;
        }
        System.arraycopy(zzafjArr3, 0, zzafjArr2, 0, length);
        zzadt[] zzadtArr2 = (zzadt[]) arrayList2.toArray(new zzadt[0]);
        this.zzf = zzadtArr2;
        this.zzg = new zzadg(zzadtArr2);
        return j2;
    }
}
