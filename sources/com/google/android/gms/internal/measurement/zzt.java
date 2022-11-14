package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzt extends zzz {
    public final AtomicReference<Bundle> zza = new AtomicReference<>();
    public boolean zzb;

    public final void zza(Bundle bundle) {
        synchronized (this.zza) {
            try {
                this.zza.set(bundle);
                this.zzb = true;
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }

    public final Bundle zzb(long j) {
        Bundle bundle;
        synchronized (this.zza) {
            if (!this.zzb) {
                try {
                    this.zza.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.zza.get();
        }
        return bundle;
    }

    public final String zza(long j) {
        return (String) zza(zzb(j), String.class);
    }

    public static <T> T zza(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK)) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            String canonicalName = cls.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            Log.w("AM", String.format("Unexpected object type. Expected, Received".concat(": %s, %s"), new Object[]{canonicalName, canonicalName2}), e);
            throw e;
        }
    }
}
