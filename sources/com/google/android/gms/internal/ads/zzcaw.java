package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcaw> CREATOR = new zzcax();
    @SafeParcelable.Field(mo17147id = 31)
    public final long zzA;
    @SafeParcelable.Field(mo17147id = 33)
    public final String zzB;
    @SafeParcelable.Field(mo17147id = 34)
    public final float zzC;
    @SafeParcelable.Field(mo17147id = 35)
    public final int zzD;
    @SafeParcelable.Field(mo17147id = 36)
    public final int zzE;
    @SafeParcelable.Field(mo17147id = 37)
    public final boolean zzF;
    @SafeParcelable.Field(mo17147id = 39)
    public final String zzG;
    @SafeParcelable.Field(mo17147id = 40)
    public final boolean zzH;
    @SafeParcelable.Field(mo17147id = 41)
    public final String zzI;
    @SafeParcelable.Field(mo17147id = 42)
    public final boolean zzJ;
    @SafeParcelable.Field(mo17147id = 43)
    public final int zzK;
    @SafeParcelable.Field(mo17147id = 44)
    public final Bundle zzL;
    @SafeParcelable.Field(mo17147id = 45)
    public final String zzM;
    @SafeParcelable.Field(mo17147id = 46)
    @Nullable
    public final zzbhk zzN;
    @SafeParcelable.Field(mo17147id = 47)
    public final boolean zzO;
    @SafeParcelable.Field(mo17147id = 48)
    public final Bundle zzP;
    @SafeParcelable.Field(mo17147id = 49)
    @Nullable
    public final String zzQ;
    @SafeParcelable.Field(mo17147id = 50)
    @Nullable
    public final String zzR;
    @SafeParcelable.Field(mo17147id = 51)
    @Nullable
    public final String zzS;
    @SafeParcelable.Field(mo17147id = 52)
    public final boolean zzT;
    @SafeParcelable.Field(mo17147id = 53)
    public final List<Integer> zzU;
    @SafeParcelable.Field(mo17147id = 54)
    public final String zzV;
    @SafeParcelable.Field(mo17147id = 55)
    public final List<String> zzW;
    @SafeParcelable.Field(mo17147id = 56)
    public final int zzX;
    @SafeParcelable.Field(mo17147id = 57)
    public final boolean zzY;
    @SafeParcelable.Field(mo17147id = 58)
    public final boolean zzZ;
    @SafeParcelable.Field(mo17147id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 59)
    public final boolean zzaa;
    @SafeParcelable.Field(mo17147id = 60)
    public final ArrayList<String> zzab;
    @SafeParcelable.Field(mo17147id = 61)
    public final String zzac;
    @SafeParcelable.Field(mo17147id = 63)
    public final zzbry zzad;
    @SafeParcelable.Field(mo17147id = 64)
    @Nullable
    public final String zzae;
    @SafeParcelable.Field(mo17147id = 65)
    public final Bundle zzaf;
    @SafeParcelable.Field(mo17147id = 2)
    @Nullable
    public final Bundle zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final zzbdk zzc;
    @SafeParcelable.Field(mo17147id = 4)
    public final zzbdp zzd;
    @SafeParcelable.Field(mo17147id = 5)
    public final String zze;
    @SafeParcelable.Field(mo17147id = 6)
    public final ApplicationInfo zzf;
    @SafeParcelable.Field(mo17147id = 7)
    @Nullable
    public final PackageInfo zzg;
    @SafeParcelable.Field(mo17147id = 8)
    public final String zzh;
    @SafeParcelable.Field(mo17147id = 9)
    public final String zzi;
    @SafeParcelable.Field(mo17147id = 10)
    public final String zzj;
    @SafeParcelable.Field(mo17147id = 11)
    public final zzcgy zzk;
    @SafeParcelable.Field(mo17147id = 12)
    public final Bundle zzl;
    @SafeParcelable.Field(mo17147id = 13)
    public final int zzm;
    @SafeParcelable.Field(mo17147id = 14)
    public final List<String> zzn;
    @SafeParcelable.Field(mo17147id = 15)
    public final Bundle zzo;
    @SafeParcelable.Field(mo17147id = 16)
    public final boolean zzp;
    @SafeParcelable.Field(mo17147id = 18)
    public final int zzq;
    @SafeParcelable.Field(mo17147id = 19)
    public final int zzr;
    @SafeParcelable.Field(mo17147id = 20)
    public final float zzs;
    @SafeParcelable.Field(mo17147id = 21)
    public final String zzt;
    @SafeParcelable.Field(mo17147id = 25)
    public final long zzu;
    @SafeParcelable.Field(mo17147id = 26)
    public final String zzv;
    @SafeParcelable.Field(mo17147id = 27)
    @Nullable
    public final List<String> zzw;
    @SafeParcelable.Field(mo17147id = 28)
    public final String zzx;
    @SafeParcelable.Field(mo17147id = 29)
    public final zzblw zzy;
    @SafeParcelable.Field(mo17147id = 30)
    public final List<String> zzz;

    @SafeParcelable.Constructor
    public zzcaw(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) Bundle bundle, @SafeParcelable.Param(mo17150id = 3) zzbdk zzbdk, @SafeParcelable.Param(mo17150id = 4) zzbdp zzbdp, @SafeParcelable.Param(mo17150id = 5) String str, @SafeParcelable.Param(mo17150id = 6) ApplicationInfo applicationInfo, @SafeParcelable.Param(mo17150id = 7) PackageInfo packageInfo, @SafeParcelable.Param(mo17150id = 8) String str2, @SafeParcelable.Param(mo17150id = 9) String str3, @SafeParcelable.Param(mo17150id = 10) String str4, @SafeParcelable.Param(mo17150id = 11) zzcgy zzcgy, @SafeParcelable.Param(mo17150id = 12) Bundle bundle2, @SafeParcelable.Param(mo17150id = 13) int i2, @SafeParcelable.Param(mo17150id = 14) List<String> list, @SafeParcelable.Param(mo17150id = 15) Bundle bundle3, @SafeParcelable.Param(mo17150id = 16) boolean z, @SafeParcelable.Param(mo17150id = 18) int i3, @SafeParcelable.Param(mo17150id = 19) int i4, @SafeParcelable.Param(mo17150id = 20) float f, @SafeParcelable.Param(mo17150id = 21) String str5, @SafeParcelable.Param(mo17150id = 25) long j, @SafeParcelable.Param(mo17150id = 26) String str6, @SafeParcelable.Param(mo17150id = 27) List<String> list2, @SafeParcelable.Param(mo17150id = 28) String str7, @SafeParcelable.Param(mo17150id = 29) zzblw zzblw, @SafeParcelable.Param(mo17150id = 30) List<String> list3, @SafeParcelable.Param(mo17150id = 31) long j2, @SafeParcelable.Param(mo17150id = 33) String str8, @SafeParcelable.Param(mo17150id = 34) float f2, @SafeParcelable.Param(mo17150id = 40) boolean z2, @SafeParcelable.Param(mo17150id = 35) int i5, @SafeParcelable.Param(mo17150id = 36) int i6, @SafeParcelable.Param(mo17150id = 37) boolean z3, @SafeParcelable.Param(mo17150id = 39) String str9, @SafeParcelable.Param(mo17150id = 41) String str10, @SafeParcelable.Param(mo17150id = 42) boolean z4, @SafeParcelable.Param(mo17150id = 43) int i7, @SafeParcelable.Param(mo17150id = 44) Bundle bundle4, @SafeParcelable.Param(mo17150id = 45) String str11, @SafeParcelable.Param(mo17150id = 46) zzbhk zzbhk, @SafeParcelable.Param(mo17150id = 47) boolean z5, @SafeParcelable.Param(mo17150id = 48) Bundle bundle5, @SafeParcelable.Param(mo17150id = 49) @Nullable String str12, @SafeParcelable.Param(mo17150id = 50) @Nullable String str13, @SafeParcelable.Param(mo17150id = 51) @Nullable String str14, @SafeParcelable.Param(mo17150id = 52) boolean z6, @SafeParcelable.Param(mo17150id = 53) List<Integer> list4, @SafeParcelable.Param(mo17150id = 54) String str15, @SafeParcelable.Param(mo17150id = 55) List<String> list5, @SafeParcelable.Param(mo17150id = 56) int i8, @SafeParcelable.Param(mo17150id = 57) boolean z7, @SafeParcelable.Param(mo17150id = 58) boolean z8, @SafeParcelable.Param(mo17150id = 59) boolean z9, @SafeParcelable.Param(mo17150id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(mo17150id = 61) String str16, @SafeParcelable.Param(mo17150id = 63) zzbry zzbry, @SafeParcelable.Param(mo17150id = 64) @Nullable String str17, @SafeParcelable.Param(mo17150id = 65) Bundle bundle6) {
        List<String> list6;
        List<String> list7;
        this.zza = i;
        this.zzb = bundle;
        this.zzc = zzbdk;
        this.zzd = zzbdp;
        this.zze = str;
        this.zzf = applicationInfo;
        this.zzg = packageInfo;
        this.zzh = str2;
        this.zzi = str3;
        this.zzj = str4;
        this.zzk = zzcgy;
        this.zzl = bundle2;
        this.zzm = i2;
        this.zzn = list;
        if (list3 == null) {
            list6 = Collections.emptyList();
        } else {
            list6 = Collections.unmodifiableList(list3);
        }
        this.zzz = list6;
        this.zzo = bundle3;
        this.zzp = z;
        this.zzq = i3;
        this.zzr = i4;
        this.zzs = f;
        this.zzt = str5;
        this.zzu = j;
        this.zzv = str6;
        if (list2 == null) {
            list7 = Collections.emptyList();
        } else {
            list7 = Collections.unmodifiableList(list2);
        }
        this.zzw = list7;
        this.zzx = str7;
        this.zzy = zzblw;
        this.zzA = j2;
        this.zzB = str8;
        this.zzC = f2;
        this.zzH = z2;
        this.zzD = i5;
        this.zzE = i6;
        this.zzF = z3;
        this.zzG = str9;
        this.zzI = str10;
        this.zzJ = z4;
        this.zzK = i7;
        this.zzL = bundle4;
        this.zzM = str11;
        this.zzN = zzbhk;
        this.zzO = z5;
        this.zzP = bundle5;
        this.zzQ = str12;
        this.zzR = str13;
        this.zzS = str14;
        this.zzT = z6;
        this.zzU = list4;
        this.zzV = str15;
        this.zzW = list5;
        this.zzX = i8;
        this.zzY = z7;
        this.zzZ = z8;
        this.zzaa = z9;
        this.zzab = arrayList;
        this.zzac = str16;
        this.zzad = zzbry;
        this.zzae = str17;
        this.zzaf = bundle6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzp);
        SafeParcelWriter.writeInt(parcel, 18, this.zzq);
        SafeParcelWriter.writeInt(parcel, 19, this.zzr);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzs);
        SafeParcelWriter.writeString(parcel, 21, this.zzt, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzu);
        SafeParcelWriter.writeString(parcel, 26, this.zzv, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzw, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzx, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzy, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzz, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzA);
        SafeParcelWriter.writeString(parcel, 33, this.zzB, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzC);
        SafeParcelWriter.writeInt(parcel, 35, this.zzD);
        SafeParcelWriter.writeInt(parcel, 36, this.zzE);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzF);
        SafeParcelWriter.writeString(parcel, 39, this.zzG, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzH);
        SafeParcelWriter.writeString(parcel, 41, this.zzI, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzJ);
        SafeParcelWriter.writeInt(parcel, 43, this.zzK);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzL, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzM, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzN, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzO);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzP, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzQ, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzR, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzS, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzT);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzU, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzV, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzW, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzX);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzY);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzZ);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzaa);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzab, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzac, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzad, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzae, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzaf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
