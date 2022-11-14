package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcsy implements zzcsg {
    public final zzdxo zza;

    public zzcsy(zzdxo zzdxo) {
        this.zza = zzdxo;
    }

    public final void zza(Map<String, String> map) {
        String str = map.get("test_mode_enabled");
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzc(str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        }
    }
}
