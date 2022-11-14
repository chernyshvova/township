package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountResponseCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zau> CREATOR = new zax();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zaa;
    @SafeParcelable.Field(mo17147id = 2)
    @Nullable
    public IBinder zab;
    @SafeParcelable.Field(getter = "getConnectionResult", mo17147id = 3)
    public ConnectionResult zac;
    @SafeParcelable.Field(getter = "getSaveDefaultAccount", mo17147id = 4)
    public boolean zad;
    @SafeParcelable.Field(getter = "isFromCrossClientAuth", mo17147id = 5)
    public boolean zae;

    @SafeParcelable.Constructor
    public zau(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(mo17150id = 3) ConnectionResult connectionResult, @SafeParcelable.Param(mo17150id = 4) boolean z, @SafeParcelable.Param(mo17150id = 5) boolean z2) {
        this.zaa = i;
        this.zab = iBinder;
        this.zac = connectionResult;
        this.zad = z;
        this.zae = z2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zau)) {
            return false;
        }
        zau zau = (zau) obj;
        return this.zac.equals(zau.zac) && Objects.equal(zaa(), zau.zaa());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zab, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zad);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zae);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final IAccountAccessor zaa() {
        IBinder iBinder = this.zab;
        if (iBinder == null) {
            return null;
        }
        return IAccountAccessor.Stub.asInterface(iBinder);
    }

    public final ConnectionResult zab() {
        return this.zac;
    }

    public final boolean zac() {
        return this.zad;
    }

    public final boolean zad() {
        return this.zae;
    }
}
