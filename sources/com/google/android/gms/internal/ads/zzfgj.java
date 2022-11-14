package com.google.android.gms.internal.ads;

import android.os.Build;
import com.facebook.internal.Utility;
import com.google.android.gms.common.util.VisibleForTesting;
import com.playrix.gplay.billing.Base64;
import com.swrve.sdk.ISwrveCommon;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfgj {
    @VisibleForTesting
    public static final byte[] zza = {Base64.EQUALS_SIGN, 122, 18, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, 63, 50, 108, -113, -103, 74};
    @VisibleForTesting
    public static final byte[] zzb = {16, 57, 56, -18, 69, 55, -27, -98, -114, -25, -110, -10, 84, 80, 79, -72, 52, 111, -58, -77, 70, -48, -69, -60, 65, 95, -61, 57, -4, -4, -114, -63};
    public final byte[] zzc = zzb;
    public final byte[] zzd = zza;

    public final boolean zza(File file) throws GeneralSecurityException {
        try {
            X509Certificate[][] zza2 = zzi.zza(file.getAbsolutePath());
            if (zza2.length == 1) {
                byte[] digest = MessageDigest.getInstance(Utility.HASH_ALGORITHM_SHA256).digest(zza2[0][0].getEncoded());
                if (!Arrays.equals(this.zzd, digest)) {
                    return !ISwrveCommon.BATCH_EVENT_KEY_USER.equals(Build.TYPE) && Arrays.equals(this.zzc, digest);
                }
                return true;
            }
            throw new GeneralSecurityException("APK has more than one signature.");
        } catch (zzf e) {
            throw new GeneralSecurityException("Package is not signed", e);
        } catch (IOException | RuntimeException e2) {
            throw new GeneralSecurityException("Failed to verify signatures", e2);
        }
    }
}
