package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.drive.zzez;
import com.google.android.gms.internal.drive.zzkk;

@ShowFirstParty
@SafeParcelable.Class(creator = "ChangeSequenceNumberCreator")
@SafeParcelable.Reserved({1})
public class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    @SafeParcelable.Field(mo17147id = 2)
    public final long zze;
    @SafeParcelable.Field(mo17147id = 3)
    public final long zzf;
    @SafeParcelable.Field(mo17147id = 4)
    public final long zzg;
    public volatile String zzh = null;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(mo17150id = 2) long j, @SafeParcelable.Param(mo17150id = 3) long j2, @SafeParcelable.Param(mo17150id = 4) long j3) {
        boolean z = true;
        Preconditions.checkArgument(j != -1);
        Preconditions.checkArgument(j2 != -1);
        Preconditions.checkArgument(j3 == -1 ? false : z);
        this.zze = j;
        this.zzf = j2;
        this.zzg = j3;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zza.class) {
            zza zza = (zza) obj;
            if (zza.zzf == this.zzf && zza.zzg == this.zzg && zza.zze == this.zze) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        String valueOf3 = String.valueOf(this.zzg);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf).length());
        sb.append(valueOf);
        sb.append(valueOf2);
        sb.append(valueOf3);
        return sb.toString().hashCode();
    }

    public String toString() {
        if (this.zzh == null) {
            String valueOf = String.valueOf(Base64.encodeToString(((zzez) ((zzkk) zzez.zzaj().zzk(1).zzc(this.zze).zzd(this.zzf).zze(this.zzg).zzdf())).toByteArray(), 10));
            this.zzh = valueOf.length() != 0 ? "ChangeSequenceNumber:".concat(valueOf) : new String("ChangeSequenceNumber:");
        }
        return this.zzh;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.zze);
        SafeParcelWriter.writeLong(parcel, 3, this.zzf);
        SafeParcelWriter.writeLong(parcel, 4, this.zzg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
