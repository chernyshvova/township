package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArraySet;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AuthenticatorTransferInfoCreator")
public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    public static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaz;
    @SafeParcelable.Indicator
    public final Set<Integer> zzba;
    @SafeParcelable.Field(getter = "getAccountType", mo17147id = 2)
    public String zzbn;
    @SafeParcelable.Field(getter = "getStatus", mo17147id = 3)
    public int zzbo;
    @SafeParcelable.Field(getter = "getTransferBytes", mo17147id = 4)
    public byte[] zzbp;
    @SafeParcelable.Field(getter = "getPendingIntent", mo17147id = 5)
    public PendingIntent zzbq;
    @SafeParcelable.Field(getter = "getDeviceMetaData", mo17147id = 6)
    public DeviceMetaData zzbr;
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zzv;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        zzaz = hashMap;
        hashMap.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
        zzaz.put("status", FastJsonResponse.Field.forInteger("status", 3));
        zzaz.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
    }

    @SafeParcelable.Constructor
    public zzt(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) int i2, @SafeParcelable.Param(mo17150id = 4) byte[] bArr, @SafeParcelable.Param(mo17150id = 5) PendingIntent pendingIntent, @SafeParcelable.Param(mo17150id = 6) DeviceMetaData deviceMetaData) {
        this.zzba = set;
        this.zzv = i;
        this.zzbn = str;
        this.zzbo = i2;
        this.zzbp = bArr;
        this.zzbq = pendingIntent;
        this.zzbr = deviceMetaData;
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
            return this.zzbn;
        }
        if (safeParcelableFieldId == 3) {
            return Integer.valueOf(this.zzbo);
        }
        if (safeParcelableFieldId == 4) {
            return this.zzbp;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline9(37, "Unknown SafeParcelable id=", field.getSafeParcelableFieldId()));
    }

    public boolean isFieldSet(FastJsonResponse.Field field) {
        return this.zzba.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 4) {
            this.zzbp = bArr;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline10(59, "Field with id=", safeParcelableFieldId, " is not known to be an byte array."));
    }

    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.zzbo = i;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline10(52, "Field with id=", safeParcelableFieldId, " is not known to be an int."));
    }

    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.zzbn = str2;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zzba;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeString(parcel, 2, this.zzbn, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.zzbo);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.zzbp, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.zzbq, i, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.zzbr, i, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzt() {
        this.zzba = new ArraySet(3);
        this.zzv = 1;
    }
}
