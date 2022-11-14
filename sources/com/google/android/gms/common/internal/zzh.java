package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzh implements Parcelable.Creator<BinderWrapper> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (zzh) null);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
