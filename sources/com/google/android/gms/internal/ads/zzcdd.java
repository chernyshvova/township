package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcdd implements RewardItem {
    public final zzccq zza;

    public zzcdd(zzccq zzccq) {
        this.zza = zzccq;
    }

    public final int getAmount() {
        zzccq zzccq = this.zza;
        if (zzccq != null) {
            try {
                return zzccq.zzf();
            } catch (RemoteException e) {
                zzcgs.zzj("Could not forward getAmount to RewardItem", e);
            }
        }
        return 0;
    }

    public final String getType() {
        zzccq zzccq = this.zza;
        if (zzccq != null) {
            try {
                return zzccq.zze();
            } catch (RemoteException e) {
                zzcgs.zzj("Could not forward getType to RewardItem", e);
            }
        }
        return null;
    }
}
