package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;

public abstract class zzea extends zzau<DriveResource.MetadataResult> {
    public zzea(zzdp zzdp, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzdz(status, (Metadata) null);
    }

    public /* synthetic */ zzea(zzdp zzdp, GoogleApiClient googleApiClient, zzdq zzdq) {
        this(zzdp, googleApiClient);
    }
}
