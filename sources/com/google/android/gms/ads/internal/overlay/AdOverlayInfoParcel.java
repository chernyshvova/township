package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbos;
import com.google.android.gms.internal.ads.zzbou;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzcmr;
import com.google.android.gms.internal.ads.zzdbq;
import com.google.android.gms.internal.ads.zzduu;
import com.google.android.gms.internal.ads.zzedb;
import com.google.android.gms.internal.ads.zzfdh;

@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    @SafeParcelable.Field(mo17147id = 2)
    public final zzc zza;
    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", mo17147id = 3, type = "android.os.IBinder")
    public final zzbcz zzb;
    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", mo17147id = 4, type = "android.os.IBinder")
    public final zzo zzc;
    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", mo17147id = 5, type = "android.os.IBinder")
    public final zzcmr zzd;
    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", mo17147id = 6, type = "android.os.IBinder")
    public final zzbou zze;
    @RecentlyNonNull
    @SafeParcelable.Field(mo17147id = 7)
    public final String zzf;
    @SafeParcelable.Field(mo17147id = 8)
    public final boolean zzg;
    @RecentlyNonNull
    @SafeParcelable.Field(mo17147id = 9)
    public final String zzh;
    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", mo17147id = 10, type = "android.os.IBinder")
    public final zzv zzi;
    @SafeParcelable.Field(mo17147id = 11)
    public final int zzj;
    @SafeParcelable.Field(mo17147id = 12)
    public final int zzk;
    @RecentlyNonNull
    @SafeParcelable.Field(mo17147id = 13)
    public final String zzl;
    @SafeParcelable.Field(mo17147id = 14)
    public final zzcgy zzm;
    @RecentlyNonNull
    @SafeParcelable.Field(mo17147id = 16)
    public final String zzn;
    @SafeParcelable.Field(mo17147id = 17)
    public final zzj zzo;
    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", mo17147id = 18, type = "android.os.IBinder")
    public final zzbos zzp;
    @RecentlyNonNull
    @SafeParcelable.Field(mo17147id = 19)
    public final String zzq;
    @SafeParcelable.Field(getter = "getOfflineDatabaseManagerAsBinder", mo17147id = 20, type = "android.os.IBinder")
    public final zzedb zzr;
    @SafeParcelable.Field(getter = "getCsiReporterAsBinder", mo17147id = 21, type = "android.os.IBinder")
    public final zzduu zzs;
    @SafeParcelable.Field(getter = "getLoggerAsBinder", mo17147id = 22, type = "android.os.IBinder")
    public final zzfdh zzt;
    @SafeParcelable.Field(getter = "getWorkManagerUtilAsBinder", mo17147id = 23, type = "android.os.IBinder")
    public final zzbs zzu;
    @RecentlyNonNull
    @SafeParcelable.Field(mo17147id = 24)
    public final String zzv;
    @RecentlyNonNull
    @SafeParcelable.Field(mo17147id = 25)
    public final String zzw;
    @SafeParcelable.Field(getter = "getAdFailedToShowEventEmitterAsBinder", mo17147id = 26, type = "android.os.IBinder")
    public final zzdbq zzx;

    public AdOverlayInfoParcel(zzbcz zzbcz, zzo zzo2, zzbos zzbos, zzbou zzbou, zzv zzv2, zzcmr zzcmr, boolean z, int i, String str, zzcgy zzcgy) {
        this.zza = null;
        this.zzb = zzbcz;
        this.zzc = zzo2;
        this.zzd = zzcmr;
        this.zzp = zzbos;
        this.zze = zzbou;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzv2;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = zzcgy;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
    }

    @RecentlyNonNull
    public static AdOverlayInfoParcel zza(@RecentlyNonNull Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzb).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzc).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzd).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zze).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzi).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeIBinder(parcel, 20, ObjectWrapper.wrap(this.zzr).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 21, ObjectWrapper.wrap(this.zzs).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 22, ObjectWrapper.wrap(this.zzt).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 23, ObjectWrapper.wrap(this.zzu).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 24, this.zzv, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzw, false);
        SafeParcelWriter.writeIBinder(parcel, 26, ObjectWrapper.wrap(this.zzx).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AdOverlayInfoParcel(zzbcz zzbcz, zzo zzo2, zzbos zzbos, zzbou zzbou, zzv zzv2, zzcmr zzcmr, boolean z, int i, String str, String str2, zzcgy zzcgy) {
        this.zza = null;
        this.zzb = zzbcz;
        this.zzc = zzo2;
        this.zzd = zzcmr;
        this.zzp = zzbos;
        this.zze = zzbou;
        this.zzf = str2;
        this.zzg = z;
        this.zzh = str;
        this.zzi = zzv2;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = zzcgy;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
    }

    public AdOverlayInfoParcel(zzbcz zzbcz, zzo zzo2, zzv zzv2, zzcmr zzcmr, int i, zzcgy zzcgy, String str, zzj zzj2, String str2, String str3, String str4, zzdbq zzdbq) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzo2;
        this.zzd = zzcmr;
        this.zzp = null;
        this.zze = null;
        this.zzf = str2;
        this.zzg = false;
        this.zzh = str3;
        this.zzi = null;
        this.zzj = i;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = zzcgy;
        this.zzn = str;
        this.zzo = zzj2;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = str4;
        this.zzx = zzdbq;
    }

    public AdOverlayInfoParcel(zzbcz zzbcz, zzo zzo2, zzv zzv2, zzcmr zzcmr, boolean z, int i, zzcgy zzcgy) {
        this.zza = null;
        this.zzb = zzbcz;
        this.zzc = zzo2;
        this.zzd = zzcmr;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzv2;
        this.zzj = i;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = zzcgy;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
    }

    @SafeParcelable.Constructor
    public AdOverlayInfoParcel(@SafeParcelable.Param(mo17150id = 2) zzc zzc2, @SafeParcelable.Param(mo17150id = 3) IBinder iBinder, @SafeParcelable.Param(mo17150id = 4) IBinder iBinder2, @SafeParcelable.Param(mo17150id = 5) IBinder iBinder3, @SafeParcelable.Param(mo17150id = 6) IBinder iBinder4, @SafeParcelable.Param(mo17150id = 7) String str, @SafeParcelable.Param(mo17150id = 8) boolean z, @SafeParcelable.Param(mo17150id = 9) String str2, @SafeParcelable.Param(mo17150id = 10) IBinder iBinder5, @SafeParcelable.Param(mo17150id = 11) int i, @SafeParcelable.Param(mo17150id = 12) int i2, @SafeParcelable.Param(mo17150id = 13) String str3, @SafeParcelable.Param(mo17150id = 14) zzcgy zzcgy, @SafeParcelable.Param(mo17150id = 16) String str4, @SafeParcelable.Param(mo17150id = 17) zzj zzj2, @SafeParcelable.Param(mo17150id = 18) IBinder iBinder6, @SafeParcelable.Param(mo17150id = 19) String str5, @SafeParcelable.Param(mo17150id = 20) IBinder iBinder7, @SafeParcelable.Param(mo17150id = 21) IBinder iBinder8, @SafeParcelable.Param(mo17150id = 22) IBinder iBinder9, @SafeParcelable.Param(mo17150id = 23) IBinder iBinder10, @SafeParcelable.Param(mo17150id = 24) String str6, @SafeParcelable.Param(mo17150id = 25) String str7, @SafeParcelable.Param(mo17150id = 26) IBinder iBinder11) {
        this.zza = zzc2;
        this.zzb = (zzbcz) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzc = (zzo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzd = (zzcmr) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzp = (zzbos) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zze = (zzbou) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzf = str;
        this.zzg = z;
        this.zzh = str2;
        this.zzi = (zzv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.zzj = i;
        this.zzk = i2;
        this.zzl = str3;
        this.zzm = zzcgy;
        this.zzn = str4;
        this.zzo = zzj2;
        this.zzq = str5;
        this.zzv = str6;
        this.zzr = (zzedb) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzs = (zzduu) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzt = (zzfdh) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
        this.zzu = (zzbs) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder10));
        this.zzw = str7;
        this.zzx = (zzdbq) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder11));
    }

    public AdOverlayInfoParcel(zzc zzc2, zzbcz zzbcz, zzo zzo2, zzv zzv2, zzcgy zzcgy, zzcmr zzcmr) {
        this.zza = zzc2;
        this.zzb = zzbcz;
        this.zzc = zzo2;
        this.zzd = zzcmr;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzv2;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = zzcgy;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
    }

    public AdOverlayInfoParcel(zzo zzo2, zzcmr zzcmr, int i, zzcgy zzcgy) {
        this.zzc = zzo2;
        this.zzd = zzcmr;
        this.zzj = 1;
        this.zzm = zzcgy;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
    }

    public AdOverlayInfoParcel(zzcmr zzcmr, zzcgy zzcgy, zzbs zzbs, zzedb zzedb, zzduu zzduu, zzfdh zzfdh, String str, String str2, int i) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcmr;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = i;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = zzcgy;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzv = str2;
        this.zzr = zzedb;
        this.zzs = zzduu;
        this.zzt = zzfdh;
        this.zzu = zzbs;
        this.zzw = null;
        this.zzx = null;
    }
}
