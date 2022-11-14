package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMapPairCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new zak();
    @SafeParcelable.Field(mo17147id = 2)
    public final String zaa;
    @SafeParcelable.Field(mo17147id = 3)
    public final FastJsonResponse.Field<?, ?> zab;
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zac;

    @SafeParcelable.Constructor
    public zal(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) FastJsonResponse.Field<?, ?> field) {
        this.zac = i;
        this.zaa = str;
        this.zab = field;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zac);
        SafeParcelWriter.writeString(parcel, 2, this.zaa, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zab, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zal(String str, FastJsonResponse.Field<?, ?> field) {
        this.zac = 1;
        this.zaa = str;
        this.zab = field;
    }
}
