package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzck extends TaskApiCall<zzaw, DriveFolder> {
    public zzck(zzch zzch) {
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        if (zzaw.zzae() == null) {
            taskCompletionSource.setException(new ApiException(new Status(10, "Drive#SCOPE_FILE must be requested")));
        } else {
            taskCompletionSource.setResult(new zzbs(zzaw.zzae()));
        }
    }
}
