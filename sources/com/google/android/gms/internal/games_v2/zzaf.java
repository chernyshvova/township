package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInResolutionResultCreator")
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
    @SafeParcelable.Field(getter = "getResultData", mo17147id = 1)
    @Nullable
    public final Intent zza;

    @SafeParcelable.Constructor
    public zzaf(@SafeParcelable.Param(mo17150id = 1) @Nullable Intent intent) {
        this.zza = intent;
    }

    public static zzaf zza(@SafeParcelable.Param(mo17150id = 1) @Nullable Intent intent) {
        return new zzaf(intent);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaf)) {
            return false;
        }
        return Objects.equal(this.zza, ((zzaf) obj).zza);
    }

    public final int hashCode() {
        Intent intent = this.zza;
        if (intent != null) {
            return intent.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("resultData", this.zza).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
