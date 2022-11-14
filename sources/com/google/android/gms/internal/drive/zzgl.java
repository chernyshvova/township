package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;

public final class zzgl extends zzl {
    public final BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> zzdx;
    public final DriveFile.DownloadProgressListener zziq;

    public zzgl(BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> resultHolder, DriveFile.DownloadProgressListener downloadProgressListener) {
        this.zzdx = resultHolder;
        this.zziq = downloadProgressListener;
    }

    public final void zza(zzfh zzfh) throws RemoteException {
        Status status;
        if (zzfh.zzhv) {
            status = new Status(-1);
        } else {
            status = Status.RESULT_SUCCESS;
        }
        this.zzdx.setResult(new zzal(status, new zzbi(zzfh.zzes)));
    }

    public final void zza(zzfl zzfl) throws RemoteException {
        DriveFile.DownloadProgressListener downloadProgressListener = this.zziq;
        if (downloadProgressListener != null) {
            downloadProgressListener.onProgress(zzfl.zzhy, zzfl.zzhz);
        }
    }

    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzal(status, (DriveContents) null));
    }
}
