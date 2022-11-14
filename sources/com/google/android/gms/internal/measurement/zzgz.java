package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class zzgz extends zzha {
    public final byte[] zzb;

    public zzgz(byte[] bArr) {
        if (bArr != null) {
            this.zzb = bArr;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgp) || zza() != ((zzgp) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzgz)) {
            return obj.equals(this);
        }
        zzgz zzgz = (zzgz) obj;
        int zzd = zzd();
        int zzd2 = zzgz.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza((zzgp) zzgz, 0, zza());
        }
        return false;
    }

    public byte zza(int i) {
        return this.zzb[i];
    }

    public byte zzb(int i) {
        return this.zzb[i];
    }

    public final boolean zzc() {
        int zze = zze();
        return zzlb.zza(this.zzb, zze, zza() + zze);
    }

    public int zze() {
        return 0;
    }

    public int zza() {
        return this.zzb.length;
    }

    public final zzgp zza(int i, int i2) {
        int zzb2 = zzgp.zzb(0, i2, zza());
        if (zzb2 == 0) {
            return zzgp.zza;
        }
        return new zzgw(this.zzb, zze(), zzb2);
    }

    public final void zza(zzgq zzgq) throws IOException {
        zzgq.zza(this.zzb, zze(), zza());
    }

    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    public final boolean zza(zzgp zzgp, int i, int i2) {
        if (i2 > zzgp.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzgp.zza()) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline11(59, "Ran off end of other: 0, ", i2, RESTClient.COMMA_SEPARATOR, zzgp.zza()));
        } else if (!(zzgp instanceof zzgz)) {
            return zzgp.zza(0, i2).equals(zza(0, i2));
        } else {
            zzgz zzgz = (zzgz) zzgp;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzgz.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzgz.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    public final int zza(int i, int i2, int i3) {
        return zzia.zza(i, this.zzb, zze(), i3);
    }
}
