package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInButtonConfigCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaw> CREATOR = new zaz();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zaa;
    @SafeParcelable.Field(getter = "getButtonSize", mo17147id = 2)
    public final int zab;
    @SafeParcelable.Field(getter = "getColorScheme", mo17147id = 3)
    public final int zac;
    @SafeParcelable.Field(getter = "getScopes", mo17147id = 4)
    @Deprecated
    @Nullable
    public final Scope[] zad;

    @SafeParcelable.Constructor
    public zaw(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) int i2, @SafeParcelable.Param(mo17150id = 3) int i3, @SafeParcelable.Param(mo17150id = 4) @Nullable Scope[] scopeArr) {
        this.zaa = i;
        this.zab = i2;
        this.zac = i3;
        this.zad = scopeArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeInt(parcel, 3, this.zac);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zad, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zaw(int i, int i2, @Nullable Scope[] scopeArr) {
        this(1, i, i2, (Scope[]) null);
    }
}
