package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbve;
import com.google.android.gms.internal.ads.zzcgs;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class AdService extends IntentService {
    public AdService() {
        super("AdService");
    }

    public final void onHandleIntent(@RecentlyNonNull Intent intent) {
        try {
            zzbev.zzb().zzi(this, new zzbve()).zze(intent);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 50);
            sb.append("RemoteException calling handleNotificationIntent: ");
            sb.append(valueOf);
            zzcgs.zzf(sb.toString());
        }
    }
}
