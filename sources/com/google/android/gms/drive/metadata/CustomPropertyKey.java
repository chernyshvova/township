package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "CustomPropertyKeyCreator")
@SafeParcelable.Reserved({1})
public class CustomPropertyKey extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new zzc();
    public static final int PRIVATE = 1;
    public static final int PUBLIC = 0;
    public static final Pattern zzja = Pattern.compile("[\\w.!@$%^&*()/-]+");
    @SafeParcelable.Field(mo17147id = 3)
    public final int visibility;
    @SafeParcelable.Field(mo17147id = 2)
    public final String zziz;

    @SafeParcelable.Constructor
    public CustomPropertyKey(@SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) int i) {
        Preconditions.checkNotNull(str, "key");
        Preconditions.checkArgument(zzja.matcher(str).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        boolean z = true;
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z, "visibility must be either PUBLIC or PRIVATE");
        this.zziz = str;
        this.visibility = i;
    }

    public static CustomPropertyKey fromJson(JSONObject jSONObject) throws JSONException {
        return new CustomPropertyKey(jSONObject.getString("key"), jSONObject.getInt(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == CustomPropertyKey.class) {
            CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
            return customPropertyKey.getKey().equals(this.zziz) && customPropertyKey.getVisibility() == this.visibility;
        }
    }

    public String getKey() {
        return this.zziz;
    }

    public int getVisibility() {
        return this.visibility;
    }

    public int hashCode() {
        String str = this.zziz;
        int i = this.visibility;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11);
        sb.append(str);
        sb.append(i);
        return sb.toString().hashCode();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", getKey());
        jSONObject.put(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, getVisibility());
        return jSONObject;
    }

    public String toString() {
        String str = this.zziz;
        int i = this.visibility;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("CustomPropertyKey(");
        sb.append(str);
        sb.append(",");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zziz, false);
        SafeParcelWriter.writeInt(parcel, 3, this.visibility);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
