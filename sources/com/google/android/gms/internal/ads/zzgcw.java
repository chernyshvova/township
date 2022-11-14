package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzgcw extends zzgcv {
    public final byte[] zza;

    public zzgcw(byte[] bArr) {
        if (bArr != null) {
            this.zza = bArr;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgcz) || zzc() != ((zzgcz) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzgcw)) {
            return obj.equals(this);
        }
        zzgcw zzgcw = (zzgcw) obj;
        int zzC = zzC();
        int zzC2 = zzgcw.zzC();
        if (zzC == 0 || zzC2 == 0 || zzC == zzC2) {
            return zzh(zzgcw, 0, zzc());
        }
        return false;
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    public final boolean zzh(zzgcz zzgcz, int i, int i2) {
        if (i2 <= zzgcz.zzc()) {
            int i3 = i + i2;
            if (i3 > zzgcz.zzc()) {
                int zzc = zzgcz.zzc();
                StringBuilder outline22 = GeneratedOutlineSupport.outline22(59, "Ran off end of other: ", i, RESTClient.COMMA_SEPARATOR, i2);
                outline22.append(RESTClient.COMMA_SEPARATOR);
                outline22.append(zzc);
                throw new IllegalArgumentException(outline22.toString());
            } else if (!(zzgcz instanceof zzgcw)) {
                return zzgcz.zzi(i, i3).equals(zzi(0, i2));
            } else {
                zzgcw zzgcw = (zzgcw) zzgcz;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzgcw.zza;
                int zzd = zzd() + i2;
                int zzd2 = zzd();
                int zzd3 = zzgcw.zzd() + i;
                while (zzd2 < zzd) {
                    if (bArr[zzd2] != bArr2[zzd3]) {
                        return false;
                    }
                    zzd2++;
                    zzd3++;
                }
                return true;
            }
        } else {
            int zzc2 = zzc();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zzc2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final zzgcz zzi(int i, int i2) {
        int zzE = zzgcz.zzE(i, i2, zzc());
        if (zzE == 0) {
            return zzgcz.zzb;
        }
        return new zzgct(this.zza, zzd() + i, zzE);
    }

    public final ByteBuffer zzj() {
        return ByteBuffer.wrap(this.zza, zzd(), zzc()).asReadOnlyBuffer();
    }

    public final void zzk(zzgcp zzgcp) throws IOException {
        ((zzgdh) zzgcp).zzp(this.zza, zzd(), zzc());
    }

    public final String zzl(Charset charset) {
        return new String(this.zza, zzd(), zzc(), charset);
    }

    public final boolean zzm() {
        int zzd = zzd();
        return zzghd.zzb(this.zza, zzd, zzc() + zzd);
    }

    public final int zzn(int i, int i2, int i3) {
        int zzd = zzd() + i2;
        return zzghd.zzc(i, this.zza, zzd, i3 + zzd);
    }

    public final int zzo(int i, int i2, int i3) {
        return zzgem.zzh(i, this.zza, zzd() + i2, i3);
    }

    public final zzgde zzp() {
        return zzgde.zzF(this.zza, zzd(), zzc(), true);
    }
}
