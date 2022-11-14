package com.google.android.datatransport.cct.p032a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.a.zzp */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzp implements ObjectEncoder<zze> {
    public void encode(@Nullable Object obj, @NonNull Object obj2) throws EncodingException, IOException {
        ((ObjectEncoderContext) obj2).add("logRequest", (Object) ((zze) obj).zza);
    }
}
