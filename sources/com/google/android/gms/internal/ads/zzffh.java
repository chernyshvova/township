package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffh implements zzfff {
    public final zzfff zza;

    public zzffh(zzfff zzfff) {
        this.zza = zzfff;
    }

    public final JSONObject zza(View view) {
        throw null;
    }

    public final void zzb(View view, JSONObject jSONObject, zzffe zzffe, boolean z) {
        ArrayList arrayList = new ArrayList();
        zzfew zza2 = zzfew.zza();
        if (zza2 != null) {
            Collection<zzfel> zzf = zza2.zzf();
            int size = zzf.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            for (zzfel zzj : zzf) {
                View zzj2 = zzj.zzj();
                if (zzj2 != null && zzj2.isAttachedToWindow() && zzj2.isShown()) {
                    View view2 = zzj2;
                    while (true) {
                        if (view2 != null) {
                            if (view2.getAlpha() == 0.0f) {
                                break;
                            }
                            ViewParent parent = view2.getParent();
                            view2 = parent instanceof View ? (View) parent : null;
                        } else {
                            View rootView = zzj2.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float zza3 = zzffq.zza(rootView);
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i = size2 - 1;
                                    if (zzffq.zza((View) arrayList.get(i)) <= zza3) {
                                        break;
                                    }
                                    size2 = i;
                                }
                                arrayList.add(size2, rootView);
                            }
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i2 = 0; i2 < size3; i2++) {
            zzffe.zza((View) arrayList.get(i2), this.zza, jSONObject);
        }
    }
}
