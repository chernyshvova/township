package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "MethodInvocationCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zao> CREATOR = new zan();
    @SafeParcelable.Field(getter = "getMethodKey", mo17147id = 1)
    public final int zaa;
    @SafeParcelable.Field(getter = "getResultStatusCode", mo17147id = 2)
    public final int zab;
    @SafeParcelable.Field(getter = "getConnectionResultStatusCode", mo17147id = 3)
    public final int zac;
    @SafeParcelable.Field(getter = "getStartTimeMillis", mo17147id = 4)
    public final long zad;
    @SafeParcelable.Field(getter = "getEndTimeMillis", mo17147id = 5)
    public final long zae;

    @SafeParcelable.Constructor
    public zao(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) int i2, @SafeParcelable.Param(mo17150id = 3) int i3, @SafeParcelable.Param(mo17150id = 4) long j, @SafeParcelable.Param(mo17150id = 5) long j2) {
        this.zaa = i;
        this.zab = i2;
        this.zac = i3;
        this.zad = j;
        this.zae = j2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeInt(parcel, 3, this.zac);
        SafeParcelWriter.writeLong(parcel, 4, this.zad);
        SafeParcelWriter.writeLong(parcel, 5, this.zae);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
