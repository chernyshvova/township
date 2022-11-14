package com.google.android.gms.internal.games_v2;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzam {
    @Nullable
    public IBinder zza;
    public final int zzb;
    public int zzc = -1;
    public int zzd = 0;
    public int zze = 0;
    public int zzf = 0;
    public int zzg = 0;

    public zzam(int i, @Nullable IBinder iBinder) {
        this.zzb = i;
        this.zza = null;
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putInt("popupLocationInfo.gravity", this.zzb);
        bundle.putInt("popupLocationInfo.displayId", this.zzc);
        bundle.putInt("popupLocationInfo.left", this.zzd);
        bundle.putInt("popupLocationInfo.top", this.zze);
        bundle.putInt("popupLocationInfo.right", this.zzf);
        bundle.putInt("popupLocationInfo.bottom", this.zzg);
        return bundle;
    }
}
