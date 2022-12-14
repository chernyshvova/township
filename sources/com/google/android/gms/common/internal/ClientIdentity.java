package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class ClientIdentity extends AbstractSafeParcelable {
    @RecentlyNonNull
    @KeepForSdk
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new zaa();
    @SafeParcelable.Field(defaultValueUnchecked = "0", mo17147id = 1)
    public final int zaa;
    @SafeParcelable.Field(defaultValueUnchecked = "null", mo17147id = 2)
    @Nullable
    public final String zab;

    @SafeParcelable.Constructor
    public ClientIdentity(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) @Nullable String str) {
        this.zaa = i;
        this.zab = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.zaa == this.zaa && Objects.equal(clientIdentity.zab, this.zab);
    }

    public int hashCode() {
        return this.zaa;
    }

    @RecentlyNonNull
    public String toString() {
        int i = this.zaa;
        String str = this.zab;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeString(parcel, 2, this.zab, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
