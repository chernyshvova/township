package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcml implements DialogInterface.OnClickListener {
    public final /* synthetic */ JsResult zza;

    public zzcml(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.confirm();
    }
}
