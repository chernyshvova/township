package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzep implements RemoteCall {
    public final /* synthetic */ SnapshotMetadata zza;

    public /* synthetic */ zzep(SnapshotMetadata snapshotMetadata) {
        this.zza = snapshotMetadata;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzas) obj).zzu((TaskCompletionSource) obj2, this.zza.getSnapshotId());
    }
}
