package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.zaaa;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final /* synthetic */ class zap implements RemoteCall {
    public final zaaa zaa;

    public zap(zaaa zaaa) {
        this.zaa = zaaa;
    }

    public final void accept(Object obj, Object obj2) {
        zaq.zaa(this.zaa, (zar) obj, (TaskCompletionSource) obj2);
    }
}
