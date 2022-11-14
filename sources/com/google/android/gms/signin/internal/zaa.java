package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AuthAccountResultCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zac();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zaa;
    @SafeParcelable.Field(getter = "getConnectionResultCode", mo17147id = 2)
    public int zab;
    @SafeParcelable.Field(getter = "getRawAuthResolutionIntent", mo17147id = 3)
    @Nullable
    public Intent zac;

    @SafeParcelable.Constructor
    public zaa(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) int i2, @SafeParcelable.Param(mo17150id = 3) @Nullable Intent intent) {
        this.zaa = i;
        this.zab = i2;
        this.zac = intent;
    }

    public final Status getStatus() {
        if (this.zab == 0) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zaa() {
        this(0, (Intent) null);
    }

    public zaa(int i, @Nullable Intent intent) {
        this(2, 0, (Intent) null);
    }
}
