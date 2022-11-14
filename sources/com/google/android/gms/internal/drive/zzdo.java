package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.events.OpenFileCallback;

public final class zzdo implements ListenerHolder.Notifier<OpenFileCallback> {
    public final /* synthetic */ zzdg zzgp;

    public zzdo(zzdk zzdk, zzdg zzdg) {
        this.zzgp = zzdg;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        this.zzgp.accept((OpenFileCallback) obj);
    }

    public final void onNotifyListenerFailed() {
    }
}
