package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzeo implements RemoteCall {
    public final /* synthetic */ Snapshot zza;
    public final /* synthetic */ SnapshotMetadataChange zzb;

    public /* synthetic */ zzeo(Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        this.zza = snapshot;
        this.zzb = snapshotMetadataChange;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzas) obj).zzt((TaskCompletionSource) obj2, this.zza, this.zzb);
    }
}
