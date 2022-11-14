package com.google.android.datatransport.cct.p032a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.a.zzw */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzw implements ObjectEncoder<zzk> {
    public void encode(@Nullable Object obj, @NonNull Object obj2) throws EncodingException, IOException {
        zzk zzk = (zzk) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add("requestTimeMs", zzk.zza).add("requestUptimeMs", zzk.zzb);
        zzq zzq = zzk.zzc;
        if (zzq != null) {
            objectEncoderContext.add("clientInfo", (Object) zzq);
        }
        String str = zzk.zze;
        if (str != null) {
            objectEncoderContext.add("logSourceName", (Object) str);
        } else {
            int i = zzk.zzd;
            if (i != Integer.MIN_VALUE) {
                objectEncoderContext.add("logSource", i);
            } else {
                throw new EncodingException("Log request must have either LogSourceName or LogSource");
            }
        }
        if (!zzk.zzf.isEmpty()) {
            objectEncoderContext.add("logEvent", (Object) zzk.zzf);
        }
    }
}
