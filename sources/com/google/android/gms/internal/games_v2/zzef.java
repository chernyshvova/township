package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.internal.zzay;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzef implements RemoteCall {
    public final /* synthetic */ Snapshot zza;

    public /* synthetic */ zzef(Snapshot snapshot) {
        this.zza = snapshot;
    }

    public final void accept(Object obj, Object obj2) {
        SnapshotContents snapshotContents = this.zza.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents zza2 = snapshotContents.zza();
        snapshotContents.zzb();
        ((zzay) ((zzas) obj).getService()).zzu(zza2);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
