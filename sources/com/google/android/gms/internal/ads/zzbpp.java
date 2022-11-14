package com.google.android.gms.internal.ads;

import com.facebook.share.internal.VideoUploader;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpp implements zzbps<zzcmr> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmr zzcmr = (zzcmr) obj;
        if (map.keySet().contains(VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE)) {
            zzcmr.zzR().zzi();
        } else if (map.keySet().contains("stop")) {
            zzcmr.zzR().zzj();
        } else if (map.keySet().contains("cancel")) {
            zzcmr.zzR().zzk();
        }
    }
}
