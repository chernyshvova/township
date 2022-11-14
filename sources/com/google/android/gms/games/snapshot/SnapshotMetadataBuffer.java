package com.google.android.gms.games.snapshot;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class SnapshotMetadataBuffer extends AbstractDataBuffer<SnapshotMetadata> {
    public SnapshotMetadataBuffer(@RecentlyNonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @RecentlyNonNull
    public SnapshotMetadata get(int i) {
        return new SnapshotMetadataRef(this.mDataHolder, i);
    }
}
