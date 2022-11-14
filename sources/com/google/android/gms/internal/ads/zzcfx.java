package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcfx {
    public final /* synthetic */ zzcfy zza;
    public long zzb = -1;
    public long zzc = -1;

    public zzcfx(zzcfy zzcfy) {
        this.zza = zzcfy;
    }

    public final long zza() {
        return this.zzc;
    }

    public final void zzb() {
        this.zzc = this.zza.zza.elapsedRealtime();
    }

    public final void zzc() {
        this.zzb = this.zza.zza.elapsedRealtime();
    }

    public final Bundle zzd() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzb);
        bundle.putLong("tclose", this.zzc);
        return bundle;
    }
}
