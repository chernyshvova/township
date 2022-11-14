package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcta implements zzdby {
    public final zzezn zza;

    public zzcta(zzezn zzezn) {
        this.zza = zzezn;
    }

    public final void zzb(@Nullable Context context) {
        try {
            this.zza.zzj();
            if (context != null) {
                this.zza.zzp(context);
            }
        } catch (zzezb e) {
            zzcgs.zzj("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    public final void zzbD(@Nullable Context context) {
        try {
            this.zza.zzf();
        } catch (zzezb e) {
            zzcgs.zzj("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }

    public final void zzbG(@Nullable Context context) {
        try {
            this.zza.zzi();
        } catch (zzezb e) {
            zzcgs.zzj("Cannot invoke onPause for the mediation adapter.", e);
        }
    }
}
