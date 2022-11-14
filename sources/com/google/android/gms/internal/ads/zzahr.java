package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzahr extends zzahm {
    @Nullable
    public zzahx zza;
    @Nullable
    public byte[] zzb;
    public int zzc;
    public int zzd;

    public zzahr() {
        super(false);
    }

    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(zzalh.zzd(this.zzb), this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzi(min);
        return min;
    }

    public final long zzc(zzahx zzahx) throws IOException {
        String str;
        zzg(zzahx);
        this.zza = zzahx;
        Uri uri = zzahx.zza;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            String valueOf = String.valueOf(scheme);
            if (valueOf.length() != 0) {
                str = "Unsupported scheme: ".concat(valueOf);
            } else {
                str = new String("Unsupported scheme: ");
            }
            throw new zzlg(str, (Throwable) null);
        }
        String[] zzt = zzalh.zzt(uri.getSchemeSpecificPart(), ",");
        if (zzt.length == 2) {
            String str2 = zzt[1];
            if (zzt[0].contains(";base64")) {
                try {
                    this.zzb = Base64.decode(str2, 0);
                } catch (IllegalArgumentException e) {
                    String valueOf2 = String.valueOf(str2);
                    throw new zzlg(valueOf2.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(valueOf2) : new String("Error while parsing Base64 encoded string: "), e);
                }
            } else {
                this.zzb = zzalh.zzs(URLDecoder.decode(str2, zzfjs.zza.name()));
            }
            long j = zzahx.zzf;
            int length = this.zzb.length;
            if (j <= ((long) length)) {
                int i = (int) j;
                this.zzc = i;
                int i2 = length - i;
                this.zzd = i2;
                long j2 = zzahx.zzg;
                if (j2 != -1) {
                    this.zzd = (int) Math.min((long) i2, j2);
                }
                zzh(zzahx);
                long j3 = zzahx.zzg;
                return j3 != -1 ? j3 : (long) this.zzd;
            }
            this.zzb = null;
            throw new zzahu(0);
        }
        String valueOf3 = String.valueOf(uri);
        throw new zzlg(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf3.length() + 23), "Unexpected URI format: ", valueOf3), (Throwable) null);
    }

    @Nullable
    public final Uri zzd() {
        zzahx zzahx = this.zza;
        if (zzahx != null) {
            return zzahx.zza;
        }
        return null;
    }

    public final void zzf() {
        if (this.zzb != null) {
            this.zzb = null;
            zzj();
        }
        this.zza = null;
    }
}
