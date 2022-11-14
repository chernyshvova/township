package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.applinks.FacebookAppLinkResolver;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AuthenticatorAnnotatedDataCreator")
public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    public static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaz;
    @SafeParcelable.Field(getter = "getPackageName", mo17147id = 4)
    public String mPackageName;
    @SafeParcelable.Indicator
    public final Set<Integer> zzba;
    @SafeParcelable.Field(getter = "getInfo", mo17147id = 2)
    public zzt zzbk;
    @SafeParcelable.Field(getter = "getSignature", mo17147id = 3)
    public String zzbl;
    @SafeParcelable.Field(getter = "getId", mo17147id = 5)
    public String zzbm;
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zzv;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        zzaz = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.forConcreteType("authenticatorInfo", 2, zzt.class));
        zzaz.put("signature", FastJsonResponse.Field.forString("signature", 3));
        zzaz.put(FacebookAppLinkResolver.APP_LINK_TARGET_PACKAGE_KEY, FastJsonResponse.Field.forString(FacebookAppLinkResolver.APP_LINK_TARGET_PACKAGE_KEY, 4));
    }

    public zzr() {
        this.zzba = new HashSet(3);
        this.zzv = 1;
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.zzbk = (zzt) t;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", new Object[]{Integer.valueOf(safeParcelableFieldId), t.getClass().getCanonicalName()}));
    }

    public /* synthetic */ Map getFieldMappings() {
        return zzaz;
    }

    public Object getFieldValue(FastJsonResponse.Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 1) {
            return Integer.valueOf(this.zzv);
        }
        if (safeParcelableFieldId == 2) {
            return this.zzbk;
        }
        if (safeParcelableFieldId == 3) {
            return this.zzbl;
        }
        if (safeParcelableFieldId == 4) {
            return this.mPackageName;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline9(37, "Unknown SafeParcelable id=", field.getSafeParcelableFieldId()));
    }

    public boolean isFieldSet(FastJsonResponse.Field field) {
        return this.zzba.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.zzbl = str2;
        } else if (safeParcelableFieldId == 4) {
            this.mPackageName = str2;
        } else {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
        }
        this.zzba.add(Integer.valueOf(safeParcelableFieldId));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zzba;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeParcelable(parcel, 2, this.zzbk, i, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeString(parcel, 3, this.zzbl, true);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeString(parcel, 4, this.mPackageName, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeString(parcel, 5, this.zzbm, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) zzt zzt, @SafeParcelable.Param(mo17150id = 3) String str, @SafeParcelable.Param(mo17150id = 4) String str2, @SafeParcelable.Param(mo17150id = 5) String str3) {
        this.zzba = set;
        this.zzv = i;
        this.zzbk = zzt;
        this.zzbl = str;
        this.mPackageName = str2;
        this.zzbm = str3;
    }
}
