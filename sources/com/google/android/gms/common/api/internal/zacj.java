package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zacj extends TaskApiCall<A, ResultT> {
    public final /* synthetic */ TaskApiCall.Builder zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zacj(TaskApiCall.Builder builder, Feature[] featureArr, boolean z, int i) {
        super(featureArr, z, i);
        this.zaa = builder;
    }

    public final void doExecute(A a, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException {
        this.zaa.zaa.accept(a, taskCompletionSource);
    }
}
