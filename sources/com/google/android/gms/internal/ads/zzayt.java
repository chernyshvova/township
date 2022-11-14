package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayt {
    @GuardedBy("lock")
    @Nullable
    public zzayi zza;
    @GuardedBy("lock")
    public boolean zzb;
    public final Context zzc;
    public final Object zzd = new Object();

    public zzayt(Context context) {
        this.zzc = context;
    }

    public static /* synthetic */ void zzb(zzayt zzayt) {
        synchronized (zzayt.zzd) {
            zzayi zzayi = zzayt.zza;
            if (zzayi != null) {
                zzayi.disconnect();
                zzayt.zza = null;
                Binder.flushPendingCommands();
            }
        }
    }

    public final Future<zzayv> zza(zzayj zzayj) {
        zzayn zzayn = new zzayn(this);
        zzayr zzayr = new zzayr(this, zzayj, zzayn);
        zzays zzays = new zzays(this, zzayn);
        synchronized (this.zzd) {
            zzayi zzayi = new zzayi(this.zzc, zzs.zzq().zza(), zzayr, zzays);
            this.zza = zzayi;
            zzayi.checkAvailabilityAndConnect();
        }
        return zzayn;
    }
}
