package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AdValueParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdr> CREATOR = new zzbds();
    @SafeParcelable.Field(mo17147id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final int zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final String zzc;
    @SafeParcelable.Field(mo17147id = 4)
    public final long zzd;

    @SafeParcelable.Constructor
    public zzbdr(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) int i2, @SafeParcelable.Param(mo17150id = 3) String str, @SafeParcelable.Param(mo17150id = 4) long j) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = j;
    }

    public static zzbdr zza(JSONObject jSONObject) throws JSONException {
        return new zzbdr(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString("currency"), jSONObject.getLong("value"));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
