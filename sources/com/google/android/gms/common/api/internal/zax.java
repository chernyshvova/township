package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zax implements PendingResult.StatusListener {
    public final /* synthetic */ BasePendingResult zaa;
    public final /* synthetic */ zav zab;

    public zax(zav zav, BasePendingResult basePendingResult) {
        this.zab = zav;
        this.zaa = basePendingResult;
    }

    public final void onComplete(Status status) {
        this.zab.zaa.remove(this.zaa);
    }
}
