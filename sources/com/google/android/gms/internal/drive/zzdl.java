package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.events.OpenFileCallback;

public final /* synthetic */ class zzdl implements zzdg {
    public final zzdk zzgl;
    public final Status zzgm;

    public zzdl(zzdk zzdk, Status status) {
        this.zzgl = zzdk;
        this.zzgm = status;
    }

    public final void accept(Object obj) {
        this.zzgl.zza(this.zzgm, (OpenFileCallback) obj);
    }
}
