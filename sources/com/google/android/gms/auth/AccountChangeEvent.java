package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AccountChangeEventCreator")
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zze;
    @SafeParcelable.Field(mo17147id = 2)
    public final long zzf;
    @SafeParcelable.Field(mo17147id = 3)
    public final String zzg;
    @SafeParcelable.Field(mo17147id = 4)
    public final int zzh;
    @SafeParcelable.Field(mo17147id = 5)
    public final int zzi;
    @SafeParcelable.Field(mo17147id = 6)
    public final String zzj;

    @SafeParcelable.Constructor
    public AccountChangeEvent(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) long j, @SafeParcelable.Param(mo17150id = 3) String str, @SafeParcelable.Param(mo17150id = 4) int i2, @SafeParcelable.Param(mo17150id = 5) int i3, @SafeParcelable.Param(mo17150id = 6) String str2) {
        this.zze = i;
        this.zzf = j;
        this.zzg = (String) Preconditions.checkNotNull(str);
        this.zzh = i2;
        this.zzi = i3;
        this.zzj = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            return this.zze == accountChangeEvent.zze && this.zzf == accountChangeEvent.zzf && Objects.equal(this.zzg, accountChangeEvent.zzg) && this.zzh == accountChangeEvent.zzh && this.zzi == accountChangeEvent.zzi && Objects.equal(this.zzj, accountChangeEvent.zzj);
        }
    }

    public String getAccountName() {
        return this.zzg;
    }

    public String getChangeData() {
        return this.zzj;
    }

    public int getChangeType() {
        return this.zzh;
    }

    public int getEventIndex() {
        return this.zzi;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zze), Long.valueOf(this.zzf), this.zzg, Integer.valueOf(this.zzh), Integer.valueOf(this.zzi), this.zzj);
    }

    public String toString() {
        int i = this.zzh;
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        String str2 = this.zzg;
        String str3 = this.zzj;
        int i2 = this.zzi;
        StringBuilder outline23 = GeneratedOutlineSupport.outline23(GeneratedOutlineSupport.outline3(str3, str.length() + GeneratedOutlineSupport.outline3(str2, 91)), "AccountChangeEvent {accountName = ", str2, ", changeType = ", str);
        outline23.append(", changeData = ");
        outline23.append(str3);
        outline23.append(", eventIndex = ");
        outline23.append(i2);
        outline23.append("}");
        return outline23.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zze);
        SafeParcelWriter.writeLong(parcel, 2, this.zzf);
        SafeParcelWriter.writeString(parcel, 3, this.zzg, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzh);
        SafeParcelWriter.writeInt(parcel, 5, this.zzi);
        SafeParcelWriter.writeString(parcel, 6, this.zzj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.zze = 1;
        this.zzf = j;
        this.zzg = (String) Preconditions.checkNotNull(str);
        this.zzh = i;
        this.zzi = i2;
        this.zzj = str2;
    }
}
