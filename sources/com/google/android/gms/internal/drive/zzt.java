package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

@Deprecated
public final class zzt {
    public String zzba;
    public DriveId zzbd;
    public Integer zzdk;
    public final int zzdl = 0;
    public MetadataChangeSet zzdm;

    public zzt(int i) {
    }

    public final IntentSender build(GoogleApiClient googleApiClient) {
        Preconditions.checkState(googleApiClient.isConnected(), "Client must be connected");
        zzg();
        zzaw zzaw = (zzaw) googleApiClient.getClient(Drive.CLIENT_KEY);
        this.zzdm.zzq().zza(zzaw.getContext());
        try {
            return ((zzeo) zzaw.getService()).zza(new zzu(this.zzdm.zzq(), this.zzdk.intValue(), this.zzba, this.zzbd, 0));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public final int getRequestId() {
        return this.zzdk.intValue();
    }

    public final void zza(MetadataChangeSet metadataChangeSet) {
        this.zzdm = (MetadataChangeSet) Preconditions.checkNotNull(metadataChangeSet);
    }

    public final MetadataChangeSet zzc() {
        return this.zzdm;
    }

    public final DriveId zzd() {
        return this.zzbd;
    }

    public final String zze() {
        return this.zzba;
    }

    public final void zzg() {
        Preconditions.checkNotNull(this.zzdm, "Must provide initial metadata via setInitialMetadata.");
        Integer num = this.zzdk;
        this.zzdk = Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public final void zza(DriveId driveId) {
        this.zzbd = (DriveId) Preconditions.checkNotNull(driveId);
    }

    public final void zzc(String str) {
        this.zzba = (String) Preconditions.checkNotNull(str);
    }

    public final void zzd(int i) {
        this.zzdk = Integer.valueOf(i);
    }
}
