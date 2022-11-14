package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsd {
    public final int zza;
    @Nullable
    public final zzadv zzb;
    public final CopyOnWriteArrayList<zzsc> zzc;

    public zzsd() {
        this(new CopyOnWriteArrayList(), 0, (zzadv) null);
    }

    public zzsd(CopyOnWriteArrayList<zzsc> copyOnWriteArrayList, int i, @Nullable zzadv zzadv) {
        this.zzc = copyOnWriteArrayList;
        this.zza = i;
        this.zzb = zzadv;
    }

    @CheckResult
    public final zzsd zza(int i, @Nullable zzadv zzadv) {
        return new zzsd(this.zzc, i, zzadv);
    }

    public final void zzb(Handler handler, zzse zzse) {
        this.zzc.add(new zzsc(handler, zzse));
    }

    public final void zzc(zzse zzse) {
        Iterator<zzsc> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzsc next = it.next();
            if (next.zzb == zzse) {
                this.zzc.remove(next);
            }
        }
    }
}
