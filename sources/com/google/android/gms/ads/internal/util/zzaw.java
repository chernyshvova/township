package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaw implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzax zza;

    public zzaw(zzax zzax) {
        this.zza = zzax;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzs.zzc();
        zzr.zzX(this.zza.zza, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
