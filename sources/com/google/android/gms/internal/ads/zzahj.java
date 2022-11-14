package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzahj {
    public final CopyOnWriteArrayList<zzahi> zza = new CopyOnWriteArrayList<>();

    public final void zza(Handler handler, zzahk zzahk) {
        zzb(zzahk);
        this.zza.add(new zzahi(handler, zzahk));
    }

    public final void zzb(zzahk zzahk) {
        Iterator<zzahi> it = this.zza.iterator();
        while (it.hasNext()) {
            zzahi next = it.next();
            if (next.zzb == zzahk) {
                next.zza();
                this.zza.remove(next);
            }
        }
    }

    public final void zzc(int i, long j, long j2) {
        Iterator<zzahi> it = this.zza.iterator();
        while (it.hasNext()) {
            zzahi next = it.next();
            if (!next.zzc) {
                next.zza.post(new zzahh(next, i, j, j2));
            }
        }
    }
}
