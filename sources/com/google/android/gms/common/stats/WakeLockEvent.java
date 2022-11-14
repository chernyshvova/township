package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class WakeLockEvent extends StatsEvent {
    @RecentlyNonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getTimeMillis", mo17147id = 2)
    public final long zzb;
    @SafeParcelable.Field(getter = "getEventType", mo17147id = 11)
    public int zzc;
    @SafeParcelable.Field(getter = "getWakeLockName", mo17147id = 4)
    public final String zzd;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", mo17147id = 10)
    public final String zze;
    @SafeParcelable.Field(getter = "getCodePackage", mo17147id = 17)
    public final String zzf;
    @SafeParcelable.Field(getter = "getWakeLockType", mo17147id = 5)
    public final int zzg;
    @SafeParcelable.Field(getter = "getCallingPackages", mo17147id = 6)
    @Nullable
    public final List<String> zzh;
    @SafeParcelable.Field(getter = "getEventKey", mo17147id = 12)
    public final String zzi;
    @SafeParcelable.Field(getter = "getElapsedRealtime", mo17147id = 8)
    public final long zzj;
    @SafeParcelable.Field(getter = "getDeviceState", mo17147id = 14)
    public int zzk;
    @SafeParcelable.Field(getter = "getHostPackage", mo17147id = 13)
    public final String zzl;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", mo17147id = 15)
    public final float zzm;
    @SafeParcelable.Field(getter = "getTimeout", mo17147id = 16)
    public final long zzn;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", mo17147id = 18)
    public final boolean zzo;
    public long zzp = -1;

    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) long j, @SafeParcelable.Param(mo17150id = 11) int i2, @SafeParcelable.Param(mo17150id = 4) String str, @SafeParcelable.Param(mo17150id = 5) int i3, @SafeParcelable.Param(mo17150id = 6) @Nullable List<String> list, @SafeParcelable.Param(mo17150id = 12) String str2, @SafeParcelable.Param(mo17150id = 8) long j2, @SafeParcelable.Param(mo17150id = 14) int i4, @SafeParcelable.Param(mo17150id = 10) String str3, @SafeParcelable.Param(mo17150id = 13) String str4, @SafeParcelable.Param(mo17150id = 15) float f, @SafeParcelable.Param(mo17150id = 16) long j3, @SafeParcelable.Param(mo17150id = 17) String str5, @SafeParcelable.Param(mo17150id = 18) boolean z) {
        this.zza = i;
        this.zzb = j;
        this.zzc = i2;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i3;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j2;
        this.zzk = i4;
        this.zzl = str4;
        this.zzm = f;
        this.zzn = j3;
        this.zzo = z;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzc);
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final long zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return this.zzp;
    }

    @RecentlyNonNull
    public final String zzd() {
        List<String> list = this.zzh;
        String str = this.zzd;
        int i = this.zzg;
        String str2 = "";
        String join = list == null ? str2 : TextUtils.join(",", list);
        int i2 = this.zzk;
        String str3 = this.zze;
        if (str3 == null) {
            str3 = str2;
        }
        String str4 = this.zzl;
        if (str4 == null) {
            str4 = str2;
        }
        float f = this.zzm;
        String str5 = this.zzf;
        if (str5 != null) {
            str2 = str5;
        }
        boolean z = this.zzo;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(join).length();
        StringBuilder sb = new StringBuilder(length + 51 + length2 + str3.length() + str4.length() + str2.length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        GeneratedOutlineSupport.outline34(sb, "\t", str3, "\t", str4);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }
}
