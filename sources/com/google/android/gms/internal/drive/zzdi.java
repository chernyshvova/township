package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.OnChangeListener;
import com.google.android.gms.drive.events.zzj;

public final class zzdi {
    public OnChangeListener zzgg;
    public zzee zzgh;
    public DriveId zzk;

    public zzdi(zzch zzch, OnChangeListener onChangeListener, DriveId driveId) {
        Preconditions.checkState(zzj.zza(1, driveId));
        this.zzgg = onChangeListener;
        this.zzk = driveId;
        Looper looper = zzch.getLooper();
        Context applicationContext = zzch.getApplicationContext();
        onChangeListener.getClass();
        zzee zzee = new zzee(looper, applicationContext, 1, zzdj.zza(onChangeListener));
        this.zzgh = zzee;
        zzee.zzf(1);
    }
}
