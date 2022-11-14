package com.google.android.datatransport.cct.p032a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p032a.zzq;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.a.zzr */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzr implements ObjectEncoder<zzg> {
    public void encode(@Nullable Object obj, @NonNull Object obj2) throws EncodingException, IOException {
        zzg zzg = (zzg) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        zzq.zzb zzb = zzg.zza;
        if (zzb != null) {
            objectEncoderContext.add("clientType", (Object) zzb.name());
        }
        zza zza = zzg.zzb;
        if (zza != null) {
            objectEncoderContext.add("androidClientInfo", (Object) zza);
        }
    }
}
