package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzanc extends Handler {
    public final /* synthetic */ zzand zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzanc(zzand zzand, Looper looper) {
        super(looper);
        this.zza = zzand;
    }

    public final void handleMessage(Message message) {
        this.zza.zzs(message);
    }
}
