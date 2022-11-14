package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcag;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzfqa;
import java.util.Collections;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzs implements zzfqa<Uri> {
    public final /* synthetic */ zzcag zza;

    public zzs(zzt zzt, zzcag zzcag) {
        this.zza = zzcag;
    }

    public final void zza(Throwable th) {
        try {
            zzcag zzcag = this.zza;
            String valueOf = String.valueOf(th.getMessage());
            zzcag.zzf(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        try {
            this.zza.zze(Collections.singletonList((Uri) obj));
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }
}
