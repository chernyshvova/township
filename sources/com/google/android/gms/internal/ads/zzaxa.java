package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzaxa {
    @Nullable
    public static MessageDigest zzb;
    public final Object zza = new Object();

    public abstract byte[] zza(String str);

    @Nullable
    public final MessageDigest zzb() {
        synchronized (this.zza) {
            if (zzb != null) {
                MessageDigest messageDigest = zzb;
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzb = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            MessageDigest messageDigest2 = zzb;
            return messageDigest2;
        }
    }
}
