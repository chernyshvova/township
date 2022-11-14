package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class zzgp implements Serializable, Iterable<Byte> {
    public static final zzgp zza = new zzgz(zzia.zzb);
    public static final zzgv zzb = (zzgm.zza() ? new zzhc((zzgs) null) : new zzgt((zzgs) null));
    public static final Comparator<zzgp> zzd = new zzgr();
    public int zzc = 0;

    public static zzgp zza(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzgz(zzb.zza(bArr, i, i2));
    }

    public static int zzb(byte b) {
        return b & Base64.EQUALS_SIGN_ENC;
    }

    public static zzgx zzc(int i) {
        return new zzgx(i, (zzgs) null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zza2 = zza();
            i = zza(zza2, 0, zza2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzgs(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zza());
        objArr[2] = zza() <= 50 ? zzkp.zza(this) : String.valueOf(zzkp.zza(zza(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    public abstract int zza();

    public abstract int zza(int i, int i2, int i3);

    public abstract zzgp zza(int i, int i2);

    public abstract String zza(Charset charset);

    public abstract void zza(zzgq zzgq) throws IOException;

    public abstract byte zzb(int i);

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzia.zza);
    }

    public abstract boolean zzc();

    public final int zzd() {
        return this.zzc;
    }

    public static zzgp zza(byte[] bArr) {
        return new zzgz(bArr);
    }

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

    public static zzgp zza(String str) {
        return new zzgz(str.getBytes(zzia.zza));
    }
}
