package com.google.android.gms.cloudmessaging;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class zzc implements Parcelable.Creator<zza> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zza(parcel.readStrongBinder());
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zza[i];
    }
}
