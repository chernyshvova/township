package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final /* synthetic */ class zzbdn implements Comparator {
    public static final Comparator zza = new zzbdn();

    public final int compare(Object obj, Object obj2) {
        return RequestConfiguration.zza.indexOf((String) obj) - RequestConfiguration.zza.indexOf((String) obj2);
    }
}
