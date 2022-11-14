package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zam extends zabm {
    public final /* synthetic */ Dialog zaa;
    public final /* synthetic */ zan zab;

    public zam(zan zan, Dialog dialog) {
        this.zab = zan;
        this.zaa = dialog;
    }

    public final void zaa() {
        this.zab.zaa.zab();
        if (this.zaa.isShowing()) {
            this.zaa.dismiss();
        }
    }
}
