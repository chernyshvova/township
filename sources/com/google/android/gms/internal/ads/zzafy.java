package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.swrve.sdk.rest.RESTClient;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzafy {
    public static final zzafy zza = new zzafy((Object) null, new long[0], new zzafx[0], 0, -9223372036854775807L);
    public static final zzif<zzafy> zzf = zzafv.zza;
    public final int zzb;
    public final long[] zzc;
    public final zzafx[] zzd;
    public final long zze;

    public zzafy(@Nullable Object obj, long[] jArr, zzafx[] zzafxArr, long j, long j2) {
        int length = jArr.length;
        zzajg.zza(zzafxArr.length == length);
        this.zzc = jArr;
        this.zze = 0;
        this.zzb = length;
        this.zzd = zzafxArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafy.class == obj.getClass()) {
            zzafy zzafy = (zzafy) obj;
            return zzalh.zzc((Object) null, (Object) null) && this.zzb == zzafy.zzb && Arrays.equals(this.zzc, zzafy.zzc) && Arrays.equals(this.zzd, zzafy.zzd);
        }
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.zzc);
        return Arrays.hashCode(this.zzd) + ((hashCode + (((this.zzb * 29791) + ((int) -9223372036854775807L)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append((Object) null);
        sb.append(", adResumePositionUs=0, adGroups=[");
        for (int i = 0; i < this.zzd.length; i++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.zzc[i]);
            sb.append(", ads=[");
            for (int i2 = 0; i2 < this.zzd[i].zzc.length; i2++) {
                sb.append("ad(state=");
                int i3 = this.zzd[i].zzc[i2];
                if (i3 == 0) {
                    sb.append('_');
                } else if (i3 == 1) {
                    sb.append('R');
                } else if (i3 == 2) {
                    sb.append('S');
                } else if (i3 == 3) {
                    sb.append('P');
                } else if (i3 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.zzd[i].zzd[i2]);
                sb.append(')');
                if (i2 < this.zzd[i].zzc.length - 1) {
                    sb.append(RESTClient.COMMA_SEPARATOR);
                }
            }
            sb.append("])");
            if (i < this.zzd.length - 1) {
                sb.append(RESTClient.COMMA_SEPARATOR);
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
