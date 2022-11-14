package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class BinderWrapper implements Parcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzh();
    public IBinder zza;

    @KeepForSdk
    public BinderWrapper(@RecentlyNonNull IBinder iBinder) {
        this.zza = iBinder;
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, zzh zzh) {
        this.zza = parcel.readStrongBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zza);
    }
}
