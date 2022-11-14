package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final /* synthetic */ class zzb implements Executor {
    public static final Executor zza = new zzb();

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
