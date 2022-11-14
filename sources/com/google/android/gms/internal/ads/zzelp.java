package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzelp implements zzeqp<zzelq> {
    public final zzfqo zza;
    public final Context zzb;
    public final zzeyw zzc;
    public final View zzd;

    public zzelp(zzfqo zzfqo, Context context, zzeyw zzeyw, @Nullable ViewGroup viewGroup) {
        this.zza = zzfqo;
        this.zzb = context;
        this.zzc = zzeyw;
        this.zzd = viewGroup;
    }

    public final zzfqn<zzelq> zza() {
        return this.zza.zzb(new zzelo(this));
    }

    public final /* synthetic */ zzelq zzb() throws Exception {
        Context context = this.zzb;
        zzbdp zzbdp = this.zzc.zze;
        ArrayList arrayList = new ArrayList();
        View view = this.zzd;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzelq(context, zzbdp, arrayList);
    }
}
