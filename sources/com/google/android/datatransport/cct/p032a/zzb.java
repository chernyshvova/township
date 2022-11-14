package com.google.android.datatransport.cct.p032a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.a.zzb */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzb implements ObjectEncoder<zzd> {
    public void encode(@Nullable Object obj, @NonNull Object obj2) throws EncodingException, IOException {
        zzd zzd = (zzd) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        int i = zzd.zza;
        if (i != Integer.MIN_VALUE) {
            objectEncoderContext.add("sdkVersion", i);
        }
        String str = zzd.zzb;
        if (str != null) {
            objectEncoderContext.add(DeviceRequestsHelper.DEVICE_INFO_MODEL, (Object) str);
        }
        String str2 = zzd.zzc;
        if (str2 != null) {
            objectEncoderContext.add("hardware", (Object) str2);
        }
        String str3 = zzd.zzd;
        if (str3 != null) {
            objectEncoderContext.add(DeviceRequestsHelper.DEVICE_INFO_DEVICE, (Object) str3);
        }
        String str4 = zzd.zze;
        if (str4 != null) {
            objectEncoderContext.add(AppLovinEventTypes.USER_VIEWED_PRODUCT, (Object) str4);
        }
        String str5 = zzd.zzf;
        if (str5 != null) {
            objectEncoderContext.add("osBuild", (Object) str5);
        }
        String str6 = zzd.zzg;
        if (str6 != null) {
            objectEncoderContext.add("manufacturer", (Object) str6);
        }
        String str7 = zzd.zzh;
        if (str7 != null) {
            objectEncoderContext.add("fingerprint", (Object) str7);
        }
    }
}
