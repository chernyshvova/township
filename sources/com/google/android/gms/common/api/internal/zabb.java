package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.base.zas;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zabb extends zas {
    public final /* synthetic */ zaaz zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zabb(zaaz zaaz, Looper looper) {
        super(looper);
        this.zaa = zaaz;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((zaay) message.obj).zaa(this.zaa);
        } else if (i != 2) {
            GeneratedOutlineSupport.outline29(31, "Unknown message id: ", i, "GACStateManager");
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
