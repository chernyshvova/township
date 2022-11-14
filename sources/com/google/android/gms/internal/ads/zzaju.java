package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzaju implements Handler.Callback {
    public final zzajz zza;

    public zzaju(zzajz zzajz) {
        this.zza = zzajz;
    }

    public final boolean handleMessage(Message message) {
        this.zza.zzh(message);
        return true;
    }
}
