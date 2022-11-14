package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzr implements BaseImplementation.ResultHolder<Status> {
    public final /* synthetic */ BaseGmsClient.SignOutCallbacks zza;

    public zzr(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        this.zza = signOutCallbacks;
    }

    public final void setFailedResult(Status status) {
        this.zza.onSignOutComplete();
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        this.zza.onSignOutComplete();
    }
}
