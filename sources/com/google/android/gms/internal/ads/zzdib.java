package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdib extends zzdgf<zzavz> implements zzavz {
    @GuardedBy("this")
    public final Map<View, zzawa> zzb = new WeakHashMap(1);
    public final Context zzc;
    public final zzeye zzd;

    public zzdib(Context context, Set<zzdhz<zzavz>> set, zzeye zzeye) {
        super(set);
        this.zzc = context;
        this.zzd = zzeye;
    }

    public final synchronized void zza(View view) {
        zzawa zzawa = this.zzb.get(view);
        if (zzawa == null) {
            zzawa = new zzawa(this.zzc, view);
            zzawa.zza(this);
            this.zzb.put(view, zzawa);
        }
        if (this.zzd.zzS) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaS)).booleanValue()) {
                zzawa.zzd(((Long) zzbex.zzc().zzb(zzbjn.zzaR)).longValue());
                return;
            }
        }
        zzawa.zze();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            this.zzb.get(view).zzb(this);
            this.zzb.remove(view);
        }
    }

    public final synchronized void zzc(zzavy zzavy) {
        zzr(new zzdia(zzavy));
    }
}
