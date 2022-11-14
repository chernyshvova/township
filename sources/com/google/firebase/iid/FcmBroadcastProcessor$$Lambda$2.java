package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class FcmBroadcastProcessor$$Lambda$2 implements Continuation {
    public final Context arg$1;
    public final Intent arg$2;

    public FcmBroadcastProcessor$$Lambda$2(Context context, Intent intent) {
        this.arg$1 = context;
        this.arg$2 = intent;
    }

    public final Object then(Task task) {
        return (!PlatformVersion.isAtLeastO() || ((Integer) task.getResult()).intValue() != 402) ? task : FcmBroadcastProcessor.bindToMessagingService(this.arg$1, this.arg$2).continueWith(FirebaseIidExecutors.DIRECT_EXECUTOR, FcmBroadcastProcessor$$Lambda$4.$instance);
    }
}
