package com.google.android.gms.cloudmessaging;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class zzz implements Executor {
    public static final Executor zza = new zzz();

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
