package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.OpenFileCallback;

public final /* synthetic */ class zzdn implements zzdg {
    public final zzdk zzgl;
    public final zzfh zzgo;

    public zzdn(zzdk zzdk, zzfh zzfh) {
        this.zzgl = zzdk;
        this.zzgo = zzfh;
    }

    public final void accept(Object obj) {
        this.zzgl.zza(this.zzgo, (OpenFileCallback) obj);
    }
}
