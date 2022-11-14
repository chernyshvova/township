package com.google.android.gms.internal.consent_sdk;

import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zze {
    public final Executor zza;

    public zze(Executor executor) {
        this.zza = executor;
    }

    @AnyThread
    public final void zza(@Nullable String str, @Nullable String str2, zzi... zziArr) {
        this.zza.execute(new zzg(str, str2, zziArr));
    }

    @AnyThread
    public final Executor zza() {
        return this.zza;
    }
}
