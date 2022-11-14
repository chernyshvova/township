package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzex implements SnapshotsClient {
    public final zzar zza;

    public zzex(zzar zzar) {
        this.zza = zzar;
    }

    public final Task<SnapshotMetadata> commitAndClose(@NonNull Snapshot snapshot, @NonNull SnapshotMetadataChange snapshotMetadataChange) {
        return this.zza.zzb(new zzeg(snapshot, snapshotMetadataChange));
    }

    public final Task<String> delete(@NonNull SnapshotMetadata snapshotMetadata) {
        return this.zza.zzb(new zzeh(snapshotMetadata));
    }

    public final Task<Void> discardAndClose(@NonNull Snapshot snapshot) {
        return this.zza.zzb(new zzew(snapshot));
    }

    public final Task<Integer> getMaxCoverImageSize() {
        return this.zza.zzb(zzem.zza);
    }

    public final Task<Integer> getMaxDataSize() {
        return this.zza.zzb(zzen.zza);
    }

    public final Task<Intent> getSelectSnapshotIntent(@NonNull String str, boolean z, boolean z2, int i) {
        return this.zza.zzb(new zzek(str, z, z2, i));
    }

    public final Task<AnnotatedData<SnapshotMetadataBuffer>> load(boolean z) {
        return this.zza.zzb(new zzel(z));
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(@NonNull SnapshotMetadata snapshotMetadata) {
        return open(snapshotMetadata.getUniqueName(), false, -1);
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(@NonNull String str, @NonNull Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
        builder.fromMetadata(metadata);
        SnapshotMetadataChange build = builder.build();
        return this.zza.zzb(new zzei(str, metadata.getSnapshotId(), build, snapshot.getSnapshotContents()));
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(@NonNull SnapshotMetadata snapshotMetadata, int i) {
        return open(snapshotMetadata.getUniqueName(), false, i);
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(@NonNull String str, boolean z) {
        return open(str, z, -1);
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(@NonNull String str, boolean z, int i) {
        return this.zza.zzb(new zzej(str, z, i));
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(@NonNull String str, @NonNull String str2, @NonNull SnapshotMetadataChange snapshotMetadataChange, @NonNull SnapshotContents snapshotContents) {
        return this.zza.zzb(new zzei(str, str2, snapshotMetadataChange, snapshotContents));
    }
}
