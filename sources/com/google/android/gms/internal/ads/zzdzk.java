package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzba;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzk extends zzcbf {
    public final /* synthetic */ zzdzl zza;

    public zzdzk(zzdzl zzdzl) {
        this.zza = zzdzl;
    }

    public final void zze(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzc(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }

    public final void zzf(zzbb zzbb) {
        this.zza.zza.zzd(new zzba(zzbb.zza, zzbb.zzb));
    }
}
