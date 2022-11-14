package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzeq implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ SnapshotMetadataChange zzc;
    public final /* synthetic */ SnapshotContents zzd;

    public /* synthetic */ zzeq(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = snapshotMetadataChange;
        this.zzd = snapshotContents;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzas) obj).zzR((TaskCompletionSource) obj2, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
