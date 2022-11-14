package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzemd implements zzeqo {
    public final ArrayList zza;

    public zzemd(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zzd(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zza);
    }
}
