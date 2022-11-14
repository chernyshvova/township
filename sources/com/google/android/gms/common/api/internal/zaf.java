package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaf<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zab {
    public final A zab;

    public zaf(int i, A a) {
        super(i);
        this.zab = (BaseImplementation.ApiMethodImpl) Preconditions.checkNotNull(a, "Null methods are not runnable.");
    }

    public final void zaa(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            this.zab.run(zaa.zab());
        } catch (RuntimeException e) {
            zaa((Exception) e);
        }
    }

    public final void zaa(@NonNull Status status) {
        try {
            this.zab.setFailedResult(status);
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    public final void zaa(@NonNull Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        try {
            this.zab.setFailedResult(new Status(10, GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(localizedMessage, simpleName.length() + 2), simpleName, ": ", localizedMessage)));
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    public final void zaa(@NonNull zav zav, boolean z) {
        zav.zaa((BasePendingResult<? extends Result>) this.zab, z);
    }
}
