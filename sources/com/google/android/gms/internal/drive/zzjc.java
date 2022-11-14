package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzjc implements Serializable, Iterable<Byte> {
    public static final zzjc zznq = new zzjm(zzkm.zzsn);
    public static final zzji zznr = (zzix.zzbr() ? new zzjn((zzjd) null) : new zzjg((zzjd) null));
    public static final Comparator<zzjc> zznt = new zzje();
    public int zzns = 0;

    public static int zza(byte b) {
        return b & Base64.EQUALS_SIGN_ENC;
    }

    public static zzjc zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzjm(zznr.zzc(bArr, i, i2));
    }

    public static zzjc zzk(String str) {
        return new zzjm(str.getBytes(zzkm.UTF_8));
    }

    public static zzjk zzu(int i) {
        return new zzjk(i, (zzjd) null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzns;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzns = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzjd(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract int zza(int i, int i2, int i3);

    public abstract zzjc zza(int i, int i2);

    public abstract String zza(Charset charset);

    public abstract void zza(zzjb zzjb) throws IOException;

    public final String zzbt() {
        return size() == 0 ? "" : zza(zzkm.UTF_8);
    }

    public abstract boolean zzbu();

    public final int zzbv() {
        return this.zzns;
    }

    public abstract byte zzs(int i);

    public abstract byte zzt(int i);

    public static int zzb(int i, int i2, int i3) {
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
}
