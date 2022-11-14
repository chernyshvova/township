package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzemt implements zzeqo {
    public final ArrayList zza;

    public zzemt(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zzd(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zza);
    }
}
