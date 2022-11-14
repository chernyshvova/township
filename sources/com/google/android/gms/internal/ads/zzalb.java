package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalb implements zzajs {
    @Nullable
    public Message zza;
    @Nullable
    public zzalc zzb;

    public zzalb() {
    }

    public /* synthetic */ zzalb(zzala zzala) {
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        zzalc.zzl(this);
    }

    public final void zza() {
        Message message = this.zza;
        if (message != null) {
            message.sendToTarget();
            zzd();
            return;
        }
        throw null;
    }

    public final zzalb zzb(Message message, zzalc zzalc) {
        this.zza = message;
        this.zzb = zzalc;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        if (message != null) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
            zzd();
            return sendMessageAtFrontOfQueue;
        }
        throw null;
    }
}
