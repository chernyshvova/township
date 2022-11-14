package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "RecordConsentByConsentResultResponseCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zai extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zai> CREATOR = new zah();
    @SafeParcelable.Field(getter = "getGrantedScopes", mo17147id = 1)
    public final List<String> zaa;
    @SafeParcelable.Field(getter = "getToken", mo17147id = 2)
    @Nullable
    public final String zab;

    @SafeParcelable.Constructor
    public zai(@SafeParcelable.Param(mo17150id = 1) List<String> list, @SafeParcelable.Param(mo17150id = 2) @Nullable String str) {
        this.zaa = list;
        this.zab = str;
    }

    public final Status getStatus() {
        if (this.zab != null) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 1, this.zaa, false);
        SafeParcelWriter.writeString(parcel, 2, this.zab, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
