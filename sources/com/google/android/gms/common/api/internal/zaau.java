package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.base.zas;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaau extends zas {
    public final /* synthetic */ zaar zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaau(zaar zaar, Looper looper) {
        super(looper);
        this.zaa = zaar;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.zaa.zaf();
        } else if (i != 2) {
            GeneratedOutlineSupport.outline29(31, "Unknown message id: ", i, "GoogleApiClientImpl");
        } else {
            this.zaa.zae();
        }
    }
}
