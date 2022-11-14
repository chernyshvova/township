package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcnp implements zzcnr {
    public final zzcmr zza;

    public zzcnp(zzcmr zzcmr) {
        this.zza = zzcmr;
    }

    public final void zza(Uri uri) {
        zzcmy zzaQ = ((zzcnk) this.zza).zzaQ();
        if (zzaQ == null) {
            zzcgs.zzf("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaQ.zzD(uri);
        }
    }
}
