package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.OnChangeListener;

public final /* synthetic */ class zzdj implements ChangeListener {
    public final OnChangeListener zzgi;

    public zzdj(OnChangeListener onChangeListener) {
        this.zzgi = onChangeListener;
    }

    public static ChangeListener zza(OnChangeListener onChangeListener) {
        return new zzdj(onChangeListener);
    }

    public final void onChange(ChangeEvent changeEvent) {
        this.zzgi.onChange(changeEvent);
    }
}
