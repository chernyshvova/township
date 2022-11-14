package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface Snapshot extends Freezable<Snapshot>, Parcelable {
    @RecentlyNonNull
    SnapshotMetadata getMetadata();

    @RecentlyNonNull
    SnapshotContents getSnapshotContents();
}
