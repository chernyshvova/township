package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfz extends zzgcz {
    public static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    public final int zzc;
    public final zzgcz zzd;
    public final zzgcz zze;
    public final int zzf;
    public final int zzg;

    public zzgfz(zzgcz zzgcz, zzgcz zzgcz2) {
        this.zzd = zzgcz;
        this.zze = zzgcz2;
        int zzc2 = zzgcz.zzc();
        this.zzf = zzc2;
        this.zzc = zzgcz2.zzc() + zzc2;
        this.zzg = Math.max(zzgcz.zzf(), zzgcz2.zzf()) + 1;
    }

    public static zzgcz zzH(zzgcz zzgcz, zzgcz zzgcz2) {
        int zzc2 = zzgcz.zzc();
        int zzc3 = zzgcz2.zzc();
        byte[] bArr = new byte[(zzc2 + zzc3)];
        zzgcz.zzy(bArr, 0, 0, zzc2);
        zzgcz2.zzy(bArr, 0, zzc2, zzc3);
        return new zzgcw(bArr);
    }

    public static zzgcz zzd(zzgcz zzgcz, zzgcz zzgcz2) {
        if (zzgcz2.zzc() == 0) {
            return zzgcz;
        }
        if (zzgcz.zzc() == 0) {
            return zzgcz2;
        }
        int zzc2 = zzgcz2.zzc() + zzgcz.zzc();
        if (zzc2 < 128) {
            return zzH(zzgcz, zzgcz2);
        }
        if (zzgcz instanceof zzgfz) {
            zzgfz zzgfz = (zzgfz) zzgcz;
            if (zzgcz2.zzc() + zzgfz.zze.zzc() < 128) {
                return new zzgfz(zzgfz.zzd, zzH(zzgfz.zze, zzgcz2));
            } else if (zzgfz.zzd.zzf() > zzgfz.zze.zzf() && zzgfz.zzg > zzgcz2.zzf()) {
                return new zzgfz(zzgfz.zzd, new zzgfz(zzgfz.zze, zzgcz2));
            }
        }
        if (zzc2 >= zzh(Math.max(zzgcz.zzf(), zzgcz2.zzf()) + 1)) {
            return new zzgfz(zzgcz, zzgcz2);
        }
        return zzgfx.zza(new zzgfx((zzgfw) null), zzgcz, zzgcz2);
    }

    public static int zzh(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgcz)) {
            return false;
        }
        zzgcz zzgcz = (zzgcz) obj;
        if (this.zzc != zzgcz.zzc()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int zzC = zzC();
        int zzC2 = zzgcz.zzC();
        if (zzC != 0 && zzC2 != 0 && zzC != zzC2) {
            return false;
        }
        zzgfy zzgfy = new zzgfy(this, (zzgfw) null);
        zzgcv zza2 = zzgfy.next();
        zzgfy zzgfy2 = new zzgfy(zzgcz, (zzgfw) null);
        zzgcv zza3 = zzgfy2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int zzc2 = zza2.zzc() - i;
            int zzc3 = zza3.zzc() - i2;
            int min = Math.min(zzc2, zzc3);
            if (i == 0) {
                z = zza2.zzh(zza3, i2, min);
            } else {
                z = zza3.zzh(zza2, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.zzc;
            if (i3 < i4) {
                if (min == zzc2) {
                    zza2 = zzgfy.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == zzc3) {
                    zza3 = zzgfy2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new zzgfw(this);
    }

    public final byte zza(int i) {
        zzgcz.zzD(i, this.zzc);
        return zzb(i);
    }

    public final byte zzb(int i) {
        int i2 = this.zzf;
        if (i < i2) {
            return this.zzd.zzb(i);
        }
        return this.zze.zzb(i - i2);
    }

    public final int zzc() {
        return this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.zzf;
        if (i + i3 <= i4) {
            this.zzd.zze(bArr, i, i2, i3);
        } else if (i >= i4) {
            this.zze.zze(bArr, i - i4, i2, i3);
        } else {
            int i5 = i4 - i;
            this.zzd.zze(bArr, i, i2, i5);
            this.zze.zze(bArr, 0, i2 + i5, i3 - i5);
        }
    }

    public final int zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzc >= zzh(this.zzg);
    }

    public final zzgcz zzi(int i, int i2) {
        int zzE = zzgcz.zzE(i, i2, this.zzc);
        if (zzE == 0) {
            return zzgcz.zzb;
        }
        if (zzE == this.zzc) {
            return this;
        }
        int i3 = this.zzf;
        if (i2 <= i3) {
            return this.zzd.zzi(i, i2);
        }
        if (i >= i3) {
            return this.zze.zzi(i - i3, i2 - i3);
        }
        zzgcz zzgcz = this.zzd;
        return new zzgfz(zzgcz.zzi(i, zzgcz.zzc()), this.zze.zzi(0, i2 - this.zzf));
    }

    public final ByteBuffer zzj() {
        throw null;
    }

    public final void zzk(zzgcp zzgcp) throws IOException {
        this.zzd.zzk(zzgcp);
        this.zze.zzk(zzgcp);
    }

    public final String zzl(Charset charset) {
        return new String(zzz(), charset);
    }

    public final boolean zzm() {
        int zzn = this.zzd.zzn(0, 0, this.zzf);
        zzgcz zzgcz = this.zze;
        if (zzgcz.zzn(zzn, 0, zzgcz.zzc()) == 0) {
            return true;
        }
        return false;
    }

    public final int zzn(int i, int i2, int i3) {
        int i4 = this.zzf;
        if (i2 + i3 <= i4) {
            return this.zzd.zzn(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.zze.zzn(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.zze.zzn(this.zzd.zzn(i, i2, i5), 0, i3 - i5);
    }

    public final int zzo(int i, int i2, int i3) {
        int i4 = this.zzf;
        if (i2 + i3 <= i4) {
            return this.zzd.zzo(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.zze.zzo(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.zze.zzo(this.zzd.zzo(i, i2, i5), 0, i3 - i5);
    }

    public final zzgde zzp() {
        ArrayList arrayList = new ArrayList();
        zzgfy zzgfy = new zzgfy(this, (zzgfw) null);
        while (zzgfy.hasNext()) {
            arrayList.add(zzgfy.next().zzj());
        }
        Iterator it = arrayList.iterator();
        boolean z = false;
        int i = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            i += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                z |= true;
            } else {
                z = byteBuffer.isDirect() ? z | true : z | true;
            }
        }
        if (z) {
            return new zzgdc(arrayList, i, true, (zzgda) null);
        }
        return new zzgdd(new zzgep(arrayList), 4096, (zzgda) null);
    }

    public final zzgcu zzq() {
        return new zzgfw(this);
    }

    public /* synthetic */ zzgfz(zzgcz zzgcz, zzgcz zzgcz2, zzgfw zzgfw) {
        this(zzgcz, zzgcz2);
    }
}
