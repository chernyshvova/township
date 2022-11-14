package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcmk implements DialogInterface.OnClickListener {
    public final /* synthetic */ JsResult zza;

    public zzcmk(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.cancel();
    }
}
