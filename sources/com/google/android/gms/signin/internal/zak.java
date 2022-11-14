package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zau;

@SafeParcelable.Class(creator = "SignInResponseCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zam();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zaa;
    @SafeParcelable.Field(getter = "getConnectionResult", mo17147id = 2)
    public final ConnectionResult zab;
    @SafeParcelable.Field(getter = "getResolveAccountResponse", mo17147id = 3)
    @Nullable
    public final zau zac;

    @SafeParcelable.Constructor
    public zak(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(mo17150id = 3) @Nullable zau zau) {
        this.zaa = i;
        this.zab = connectionResult;
        this.zac = zau;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.zab;
    }

    @Nullable
    public final zau zab() {
        return this.zac;
    }

    public zak(int i) {
        this(new ConnectionResult(8, (PendingIntent) null), (zau) null);
    }

    public zak(ConnectionResult connectionResult, @Nullable zau zau) {
        this(1, connectionResult, (zau) null);
    }
}
