package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzae;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzgy {
    public final Context zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public Boolean zze;
    public long zzf;
    public zzae zzg;
    public boolean zzh = true;
    public Long zzi;

    @VisibleForTesting
    public zzgy(Context context, zzae zzae, Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzae != null) {
            this.zzg = zzae;
            this.zzb = zzae.zzf;
            this.zzc = zzae.zze;
            this.zzd = zzae.zzd;
            this.zzh = zzae.zzc;
            this.zzf = zzae.zzb;
            Bundle bundle = zzae.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
