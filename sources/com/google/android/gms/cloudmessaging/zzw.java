package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class zzw implements SuccessContinuation {
    public static final SuccessContinuation zza = new zzw();

    public final Task then(Object obj) {
        return Rpc.zza((Bundle) obj);
    }
}
