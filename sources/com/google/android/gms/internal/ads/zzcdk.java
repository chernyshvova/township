package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcdk extends zzccp {
    public final String zza;
    public final int zzb;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzcdk(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public final String zze() throws RemoteException {
        return this.zza;
    }

    public final int zzf() throws RemoteException {
        return this.zzb;
    }

    public zzcdk(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
