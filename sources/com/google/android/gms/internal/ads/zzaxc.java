package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaxc {
    @VisibleForTesting
    public ByteArrayOutputStream zza = new ByteArrayOutputStream(4096);
    @VisibleForTesting
    public Base64OutputStream zzb = new Base64OutputStream(this.zza, 10);

    public final String toString() {
        try {
            this.zzb.close();
        } catch (IOException e) {
            zzcgs.zzg("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zza.close();
            return this.zza.toString();
        } catch (IOException e2) {
            zzcgs.zzg("HashManager: Unable to convert to Base64.", e2);
            return "";
        } finally {
            this.zza = null;
            this.zzb = null;
        }
    }
}
