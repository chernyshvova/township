package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GamesSignInRequestCreator")
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();
    @SafeParcelable.Field(getter = "getSignInType", mo17147id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getPreviousStepResolutionResult", mo17147id = 2)
    @Nullable
    public final zzaf zzb;

    @SafeParcelable.Constructor
    public zzy(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) @Nullable zzaf zzaf) {
        this.zza = i;
        this.zzb = zzaf;
    }

    public static zzy zzb(int i) {
        return new zzy(i, (zzaf) null);
    }

    public static zzy zzc(int i, zzaf zzaf) {
        return new zzy(i, zzaf);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzy)) {
            return false;
        }
        zzy zzy = (zzy) obj;
        return this.zza == zzy.zza && Objects.equal(this.zzb, zzy.zzb);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("signInType", Integer.valueOf(this.zza)).add("previousStepResolutionResult", this.zzb).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzb == null;
    }
}
