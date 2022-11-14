package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzk;
import com.google.android.gms.internal.drive.zzaw;
import com.google.android.gms.internal.drive.zzeo;
import com.google.android.gms.internal.drive.zzgm;

@Deprecated
public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    public String zzba;
    public String[] zzbb;
    public Filter zzbc;
    public DriveId zzbd;

    public IntentSender build(GoogleApiClient googleApiClient) {
        Preconditions.checkState(googleApiClient.isConnected(), "Client must be connected");
        zzg();
        try {
            return ((zzeo) ((zzaw) googleApiClient.getClient(Drive.CLIENT_KEY)).getService()).zza(new zzgm(this.zzba, this.zzbb, this.zzbd, this.zzbc == null ? null : new FilterHolder(this.zzbc)));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public final String getTitle() {
        return this.zzba;
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.zzbd = (DriveId) Preconditions.checkNotNull(driveId);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String str) {
        this.zzba = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] strArr) {
        Preconditions.checkArgument(strArr != null, "mimeTypes may not be null");
        this.zzbb = strArr;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        Preconditions.checkArgument(filter != null, "filter may not be null");
        Preconditions.checkArgument(true ^ zzk.zza(filter), "FullTextSearchFilter cannot be used as a selection filter");
        this.zzbc = filter;
        return this;
    }

    public final void zzg() {
        if (this.zzbb == null) {
            this.zzbb = new String[0];
        }
        if (this.zzbb.length > 0 && this.zzbc != null) {
            throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
        }
    }

    public final String[] zzs() {
        return this.zzbb;
    }

    public final Filter zzt() {
        return this.zzbc;
    }

    public final DriveId zzu() {
        return this.zzbd;
    }
}
