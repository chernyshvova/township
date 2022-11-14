package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzepm implements zzeqp<zzepn> {
    public final zzfqo zza;
    public final Bundle zzb;

    public zzepm(zzfqo zzfqo, @Nullable Bundle bundle) {
        this.zza = zzfqo;
        this.zzb = bundle;
    }

    public final zzfqn<zzepn> zza() {
        return this.zza.zzb(new zzepl(this));
    }

    public final /* synthetic */ zzepn zzb() throws Exception {
        return new zzepn(this.zzb);
    }
}
