package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zabg implements BaseGmsClient.SignOutCallbacks {
    public final /* synthetic */ GoogleApiManager.zaa zaa;

    public zabg(GoogleApiManager.zaa zaa2) {
        this.zaa = zaa2;
    }

    public final void onSignOutComplete() {
        GoogleApiManager.this.zat.post(new zabi(this));
    }
}
