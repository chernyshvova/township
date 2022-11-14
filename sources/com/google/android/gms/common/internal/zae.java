package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zae extends zab {
    public final /* synthetic */ Intent zaa;
    public final /* synthetic */ Activity zab;
    public final /* synthetic */ int zac;

    public zae(Intent intent, Activity activity, int i) {
        this.zaa = intent;
        this.zab = activity;
        this.zac = i;
    }

    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, this.zac);
        }
    }
}
