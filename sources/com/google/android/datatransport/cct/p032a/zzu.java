package com.google.android.datatransport.cct.p032a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.a.zzu */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzu implements ObjectEncoder<zzi> {
    public void encode(@Nullable Object obj, @NonNull Object obj2) throws EncodingException, IOException {
        zzi zzi = (zzi) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add("eventTimeMs", zzi.zza).add("eventUptimeMs", zzi.zzc).add("timezoneOffsetSeconds", zzi.zzf);
        byte[] bArr = zzi.zzd;
        if (bArr != null) {
            objectEncoderContext.add("sourceExtension", (Object) bArr);
        }
        String str = zzi.zze;
        if (str != null) {
            objectEncoderContext.add("sourceExtensionJsonProto3", (Object) str);
        }
        int i = zzi.zzb;
        if (i != Integer.MIN_VALUE) {
            objectEncoderContext.add("eventCode", i);
        }
        zzy zzy = zzi.zzg;
        if (zzy != null) {
            objectEncoderContext.add("networkConnectionInfo", (Object) zzy);
        }
    }
}
