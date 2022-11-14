package com.google.android.datatransport.cct.p032a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p032a.zzy;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.a.zzz */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzz implements ObjectEncoder<zzn> {
    public void encode(@Nullable Object obj, @NonNull Object obj2) throws EncodingException, IOException {
        zzn zzn = (zzn) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        zzy.zzb zzb = zzn.zzb;
        if (zzb != null) {
            objectEncoderContext.add("mobileSubtype", (Object) zzb.name());
        }
        zzy.zzc zzc = zzn.zza;
        if (zzc != null) {
            objectEncoderContext.add("networkType", (Object) zzc.name());
        }
    }
}
