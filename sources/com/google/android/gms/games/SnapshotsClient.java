package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface SnapshotsClient {
    public static final int DISPLAY_LIMIT_NONE = -1;
    @RecentlyNonNull
    public static final String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";
    @RecentlyNonNull
    public static final String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";
    public static final int RESOLUTION_POLICY_HIGHEST_PROGRESS = 4;
    public static final int RESOLUTION_POLICY_LAST_KNOWN_GOOD = 2;
    public static final int RESOLUTION_POLICY_LONGEST_PLAYTIME = 1;
    public static final int RESOLUTION_POLICY_MANUAL = -1;
    public static final int RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED = 3;

    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public static final class DataOrConflict<T> {
        public final T zza;
        public final SnapshotConflict zzb;

        public DataOrConflict(@Nullable T t, @Nullable SnapshotConflict snapshotConflict) {
            this.zza = t;
            this.zzb = snapshotConflict;
        }

        @RecentlyNullable
        public SnapshotConflict getConflict() {
            if (isConflict()) {
                return this.zzb;
            }
            throw new IllegalStateException("getConflict called when there is no conflict.");
        }

        @RecentlyNullable
        public T getData() {
            if (!isConflict()) {
                return this.zza;
            }
            throw new IllegalStateException("getData called when there is a conflict.");
        }

        public boolean isConflict() {
            return this.zzb != null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public @interface ResolutionPolicy {
    }

    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public static final class SnapshotConflict {
        public final Snapshot zza;
        public final String zzb;
        public final Snapshot zzc;
        public final SnapshotContents zzd;

        public SnapshotConflict(@RecentlyNonNull Snapshot snapshot, @RecentlyNonNull String str, @RecentlyNonNull Snapshot snapshot2, @RecentlyNonNull SnapshotContents snapshotContents) {
            this.zza = snapshot;
            this.zzb = str;
            this.zzc = snapshot2;
            this.zzd = snapshotContents;
        }

        @RecentlyNonNull
        public String getConflictId() {
            return this.zzb;
        }

        @RecentlyNonNull
        public Snapshot getConflictingSnapshot() {
            return this.zzc;
        }

        @RecentlyNonNull
        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzd;
        }

        @RecentlyNonNull
        public Snapshot getSnapshot() {
            return this.zza;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public static final class SnapshotContentUnavailableApiException extends ApiException {
        @RecentlyNonNull
        public final SnapshotMetadata metadata;

        public SnapshotContentUnavailableApiException(@RecentlyNonNull Status status, @RecentlyNonNull SnapshotMetadata snapshotMetadata) {
            super(status);
            this.metadata = snapshotMetadata;
        }

        @RecentlyNonNull
        public SnapshotMetadata getSnapshotMetadata() {
            return this.metadata;
        }
    }

    @RecentlyNonNull
    Task<SnapshotMetadata> commitAndClose(@RecentlyNonNull Snapshot snapshot, @RecentlyNonNull SnapshotMetadataChange snapshotMetadataChange);

    @RecentlyNonNull
    Task<String> delete(@RecentlyNonNull SnapshotMetadata snapshotMetadata);

    @RecentlyNonNull
    Task<Void> discardAndClose(@RecentlyNonNull Snapshot snapshot);

    @RecentlyNonNull
    Task<Integer> getMaxCoverImageSize();

    @RecentlyNonNull
    Task<Integer> getMaxDataSize();

    @RecentlyNonNull
    Task<Intent> getSelectSnapshotIntent(@RecentlyNonNull String str, boolean z, boolean z2, int i);

    @RecentlyNonNull
    Task<AnnotatedData<SnapshotMetadataBuffer>> load(boolean z);

    @RecentlyNonNull
    Task<DataOrConflict<Snapshot>> open(@RecentlyNonNull SnapshotMetadata snapshotMetadata);

    @RecentlyNonNull
    Task<DataOrConflict<Snapshot>> open(@RecentlyNonNull SnapshotMetadata snapshotMetadata, int i);

    @RecentlyNonNull
    Task<DataOrConflict<Snapshot>> open(@RecentlyNonNull String str, boolean z);

    @RecentlyNonNull
    Task<DataOrConflict<Snapshot>> open(@RecentlyNonNull String str, boolean z, int i);

    @RecentlyNonNull
    Task<DataOrConflict<Snapshot>> resolveConflict(@RecentlyNonNull String str, @RecentlyNonNull Snapshot snapshot);

    @RecentlyNonNull
    Task<DataOrConflict<Snapshot>> resolveConflict(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull SnapshotMetadataChange snapshotMetadataChange, @RecentlyNonNull SnapshotContents snapshotContents);
}
