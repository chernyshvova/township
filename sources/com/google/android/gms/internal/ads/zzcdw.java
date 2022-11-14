package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcdw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcdw> CREATOR = new zzcdx();
    @SafeParcelable.Field(mo17147id = 2)
    public final String zza;
    @SafeParcelable.Field(mo17147id = 3)
    public final String zzb;
    @SafeParcelable.Field(mo17147id = 4)
    public final boolean zzc;
    @SafeParcelable.Field(mo17147id = 5)
    public final boolean zzd;
    @SafeParcelable.Field(mo17147id = 6)
    public final List<String> zze;
    @SafeParcelable.Field(mo17147id = 7)
    public final boolean zzf;
    @SafeParcelable.Field(mo17147id = 8)
    public final boolean zzg;
    @SafeParcelable.Field(mo17147id = 9)
    public final List<String> zzh;

    @SafeParcelable.Constructor
    public zzcdw(@SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) String str2, @SafeParcelable.Param(mo17150id = 4) boolean z, @SafeParcelable.Param(mo17150id = 5) boolean z2, @SafeParcelable.Param(mo17150id = 6) List<String> list, @SafeParcelable.Param(mo17150id = 7) boolean z3, @SafeParcelable.Param(mo17150id = 8) boolean z4, @SafeParcelable.Param(mo17150id = 9) List<String> list2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = z2;
        this.zze = list;
        this.zzf = z3;
        this.zzg = z4;
        this.zzh = list2 == null ? new ArrayList<>() : list2;
    }

    @Nullable
    public static zzcdw zza(JSONObject jSONObject) throws JSONException {
        return new zzcdw(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzbv.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzbv.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeStringList(parcel, 6, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
