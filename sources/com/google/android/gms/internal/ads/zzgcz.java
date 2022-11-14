package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgcz implements Iterable<Byte>, Serializable {
    public static final zzgcz zzb = new zzgcw(zzgem.zzc);
    public static final Comparator<zzgcz> zzc = new zzgcr();
    public static final zzgcy zzd = new zzgcy((zzgcq) null);
    public int zza = 0;

    static {
        int i = zzgcl.zza;
    }

    public static zzgcx zzB() {
        return new zzgcx(128);
    }

    public static void zzD(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline9(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline11(40, "Index > length: ", i, RESTClient.COMMA_SEPARATOR, i2));
    }

    public static int zzE(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline10(32, "Beginning index: ", i, " < 0"));
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline11(66, "Beginning index larger than ending index: ", i, RESTClient.COMMA_SEPARATOR, i2));
        } else {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline11(37, "End index: ", i2, " >= ", i3));
        }
    }

    public static zzgcz zzd(Iterator<zzgcz> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return it.next();
        } else {
            int i2 = i >>> 1;
            zzgcz zzd2 = zzd(it, i2);
            zzgcz zzd3 = zzd(it, i - i2);
            if (Integer.MAX_VALUE - zzd2.zzc() >= zzd3.zzc()) {
                return zzgfz.zzd(zzd2, zzd3);
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline11(53, "ByteString would be too long: ", zzd2.zzc(), "+", zzd3.zzc()));
        }
    }

    public static zzgcz zzs(byte[] bArr, int i, int i2) {
        zzE(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzgcw(bArr2);
    }

    public static zzgcz zzt(byte[] bArr) {
        return zzs(bArr, 0, bArr.length);
    }

    public static zzgcz zzu(byte[] bArr) {
        return new zzgcw(bArr);
    }

    public static zzgcz zzv(String str) {
        return new zzgcw(str.getBytes(zzgem.zza));
    }

    public static zzgcz zzw(InputStream inputStream) throws IOException {
        zzgcz zzgcz;
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == 0) {
                zzgcz = null;
            } else {
                zzgcz = zzs(bArr, 0, i2);
            }
            if (zzgcz == null) {
                return zzx(arrayList);
            }
            arrayList.add(zzgcz);
            i = Math.min(i + i, 8192);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable<com.google.android.gms.internal.ads.zzgcz>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzgcz zzx(java.lang.Iterable<com.google.android.gms.internal.ads.zzgcz> r3) {
        /*
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 != 0) goto L_0x0015
            java.util.Iterator r0 = r3.iterator()
            r1 = 0
        L_0x0009:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            r0.next()
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0015:
            int r1 = r3.size()
        L_0x0019:
            if (r1 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzgcz r3 = zzb
            return r3
        L_0x001e:
            java.util.Iterator r3 = r3.iterator()
            com.google.android.gms.internal.ads.zzgcz r3 = zzd(r3, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgcz.zzx(java.lang.Iterable):com.google.android.gms.internal.ads.zzgcz");
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zza;
        if (i == 0) {
            int zzc2 = zzc();
            i = zzo(zzc2, 0, zzc2);
            if (i == 0) {
                i = 1;
            }
            this.zza = i;
        }
        return i;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzc());
        objArr[2] = zzc() <= 50 ? zzggm.zza(this) : String.valueOf(zzggm.zza(zzi(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final String zzA(Charset charset) {
        return zzc() == 0 ? "" : zzl(charset);
    }

    public final int zzC() {
        return this.zza;
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzc();

    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    public abstract int zzf();

    public abstract boolean zzg();

    public abstract zzgcz zzi(int i, int i2);

    public abstract ByteBuffer zzj();

    public abstract void zzk(zzgcp zzgcp) throws IOException;

    public abstract String zzl(Charset charset);

    public abstract boolean zzm();

    public abstract int zzn(int i, int i2, int i3);

    public abstract int zzo(int i, int i2, int i3);

    public abstract zzgde zzp();

    /* renamed from: zzq */
    public zzgcu iterator() {
        return new zzgcq(this);
    }

    public final boolean zzr() {
        return zzc() == 0;
    }

    @Deprecated
    public final void zzy(byte[] bArr, int i, int i2, int i3) {
        zzE(0, i3, zzc());
        zzE(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }

    public final byte[] zzz() {
        int zzc2 = zzc();
        if (zzc2 == 0) {
            return zzgem.zzc;
        }
        byte[] bArr = new byte[zzc2];
        zze(bArr, 0, 0, zzc2);
        return bArr;
    }
}
