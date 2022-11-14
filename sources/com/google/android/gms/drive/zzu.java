package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class zzu extends AbstractSafeParcelable {
    public volatile transient boolean zzbt = false;

    public void writeToParcel(Parcel parcel, int i) {
        Preconditions.checkState(!this.zzbt);
        this.zzbt = true;
        zza(parcel, i);
    }

    public abstract void zza(Parcel parcel, int i);
}
