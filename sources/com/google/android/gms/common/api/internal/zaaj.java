package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaaj extends zaay {
    public final /* synthetic */ ConnectionResult zaa;
    public final /* synthetic */ zaag zab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaaj(zaag zaag, zaaw zaaw, ConnectionResult connectionResult) {
        super(zaaw);
        this.zab = zaag;
        this.zaa = connectionResult;
    }

    @GuardedBy("mLock")
    public final void zaa() {
        this.zab.zaa.zab(this.zaa);
    }
}
