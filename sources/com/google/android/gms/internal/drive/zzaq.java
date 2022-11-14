package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.MetadataBuffer;

public final class zzaq implements DriveApi.MetadataBufferResult {
    public final Status zzdy;
    public final MetadataBuffer zzdz;
    public final boolean zzea;

    public zzaq(Status status, MetadataBuffer metadataBuffer, boolean z) {
        this.zzdy = status;
        this.zzdz = metadataBuffer;
        this.zzea = z;
    }

    public final MetadataBuffer getMetadataBuffer() {
        return this.zzdz;
    }

    public final Status getStatus() {
        return this.zzdy;
    }

    public final void release() {
        MetadataBuffer metadataBuffer = this.zzdz;
        if (metadataBuffer != null) {
            metadataBuffer.release();
        }
    }
}
