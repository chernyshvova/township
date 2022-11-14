package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.nio.charset.Charset;

public class zzjm extends zzjl {
    public final byte[] zzny;

    public zzjm(byte[] bArr) {
        if (bArr != null) {
            this.zzny = bArr;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjc) || size() != ((zzjc) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzjm)) {
            return obj.equals(this);
        }
        zzjm zzjm = (zzjm) obj;
        int zzbv = zzbv();
        int zzbv2 = zzjm.zzbv();
        if (zzbv == 0 || zzbv2 == 0 || zzbv == zzbv2) {
            return zza((zzjc) zzjm, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzny.length;
    }

    public final zzjc zza(int i, int i2) {
        int zzb = zzjc.zzb(0, i2, size());
        if (zzb == 0) {
            return zzjc.zznq;
        }
        return new zzjh(this.zzny, zzbw(), zzb);
    }

    public final boolean zzbu() {
        int zzbw = zzbw();
        return zznf.zze(this.zzny, zzbw, size() + zzbw);
    }

    public int zzbw() {
        return 0;
    }

    public byte zzs(int i) {
        return this.zzny[i];
    }

    public byte zzt(int i) {
        return this.zzny[i];
    }

    public final void zza(zzjb zzjb) throws IOException {
        zzjb.zza(this.zzny, zzbw(), size());
    }

    public final String zza(Charset charset) {
        return new String(this.zzny, zzbw(), size(), charset);
    }

    public final boolean zza(zzjc zzjc, int i, int i2) {
        if (i2 > zzjc.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzjc.size()) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline11(59, "Ran off end of other: 0, ", i2, RESTClient.COMMA_SEPARATOR, zzjc.size()));
        } else if (!(zzjc instanceof zzjm)) {
            return zzjc.zza(0, i2).equals(zza(0, i2));
        } else {
            zzjm zzjm = (zzjm) zzjc;
            byte[] bArr = this.zzny;
            byte[] bArr2 = zzjm.zzny;
            int zzbw = zzbw() + i2;
            int zzbw2 = zzbw();
            int zzbw3 = zzjm.zzbw();
            while (zzbw2 < zzbw) {
                if (bArr[zzbw2] != bArr2[zzbw3]) {
                    return false;
                }
                zzbw2++;
                zzbw3++;
            }
            return true;
        }
    }

    public final int zza(int i, int i2, int i3) {
        return zzkm.zza(i, this.zzny, zzbw(), i3);
    }
}
