package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.data.BitmapTeleporter;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface SnapshotMetadataChange {
    @RecentlyNonNull
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public static final class Builder {
        public String zza;
        public Long zzb;
        public Long zzc;
        public BitmapTeleporter zzd;
        public Uri zze;

        @RecentlyNonNull
        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zza, this.zzb, this.zzd, this.zze, this.zzc);
        }

        @RecentlyNonNull
        public Builder fromMetadata(@RecentlyNonNull SnapshotMetadata snapshotMetadata) {
            this.zza = snapshotMetadata.getDescription();
            this.zzb = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.zzc = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.zzb.longValue() == -1) {
                this.zzb = null;
            }
            Uri coverImageUri = snapshotMetadata.getCoverImageUri();
            this.zze = coverImageUri;
            if (coverImageUri != null) {
                this.zzd = null;
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setCoverImage(@RecentlyNonNull Bitmap bitmap) {
            this.zzd = new BitmapTeleporter(bitmap);
            this.zze = null;
            return this;
        }

        @RecentlyNonNull
        public Builder setDescription(@RecentlyNonNull String str) {
            this.zza = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setPlayedTimeMillis(long j) {
            this.zzb = Long.valueOf(j);
            return this;
        }

        @RecentlyNonNull
        public Builder setProgressValue(long j) {
            this.zzc = Long.valueOf(j);
            return this;
        }
    }

    @RecentlyNullable
    Bitmap getCoverImage();

    @RecentlyNullable
    String getDescription();

    @RecentlyNullable
    Long getPlayedTimeMillis();

    @RecentlyNullable
    Long getProgressValue();

    @RecentlyNullable
    BitmapTeleporter zza();
}
