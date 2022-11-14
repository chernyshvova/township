package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzkc implements Parcelable {
    public static final Parcelable.Creator<zzkc> CREATOR = new zzka();
    public final int zzA;
    public final int zzB;
    public final int zzC;
    public final int zzD;
    @Nullable
    public final Class zzE;
    public int zzF;
    @Nullable
    public final String zza;
    @Nullable
    public final String zzb;
    @Nullable
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    @Nullable
    public final String zzi;
    @Nullable
    public final zzabe zzj;
    @Nullable
    public final String zzk;
    @Nullable
    public final String zzl;
    public final int zzm;
    public final List<byte[]> zzn;
    @Nullable
    public final zzsa zzo;
    public final long zzp;
    public final int zzq;
    public final int zzr;
    public final float zzs;
    public final int zzt;
    public final float zzu;
    @Nullable
    public final byte[] zzv;
    public final int zzw;
    @Nullable
    public final zzall zzx;
    public final int zzy;
    public final int zzz;

    public zzkc(Parcel parcel) {
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        int readInt = parcel.readInt();
        this.zzg = readInt;
        this.zzh = readInt == -1 ? this.zzf : readInt;
        this.zzi = parcel.readString();
        this.zzj = (zzabe) parcel.readParcelable(zzabe.class.getClassLoader());
        this.zzk = parcel.readString();
        this.zzl = parcel.readString();
        this.zzm = parcel.readInt();
        int readInt2 = parcel.readInt();
        this.zzn = new ArrayList(readInt2);
        int i = 0;
        while (true) {
            Class cls = null;
            if (i < readInt2) {
                List<byte[]> list = this.zzn;
                byte[] createByteArray = parcel.createByteArray();
                if (createByteArray != null) {
                    list.add(createByteArray);
                    i++;
                } else {
                    throw null;
                }
            } else {
                this.zzo = (zzsa) parcel.readParcelable(zzsa.class.getClassLoader());
                this.zzp = parcel.readLong();
                this.zzq = parcel.readInt();
                this.zzr = parcel.readInt();
                this.zzs = parcel.readFloat();
                this.zzt = parcel.readInt();
                this.zzu = parcel.readFloat();
                this.zzv = zzalh.zzn(parcel) ? parcel.createByteArray() : null;
                this.zzw = parcel.readInt();
                this.zzx = (zzall) parcel.readParcelable(zzall.class.getClassLoader());
                this.zzy = parcel.readInt();
                this.zzz = parcel.readInt();
                this.zzA = parcel.readInt();
                this.zzB = parcel.readInt();
                this.zzC = parcel.readInt();
                this.zzD = parcel.readInt();
                this.zzE = this.zzo != null ? zzsm.class : cls;
                return;
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkc.class == obj.getClass()) {
            zzkc zzkc = (zzkc) obj;
            int i2 = this.zzF;
            if ((i2 == 0 || (i = zzkc.zzF) == 0 || i2 == i) && this.zzd == zzkc.zzd && this.zze == zzkc.zze && this.zzf == zzkc.zzf && this.zzg == zzkc.zzg && this.zzm == zzkc.zzm && this.zzp == zzkc.zzp && this.zzq == zzkc.zzq && this.zzr == zzkc.zzr && this.zzt == zzkc.zzt && this.zzw == zzkc.zzw && this.zzy == zzkc.zzy && this.zzz == zzkc.zzz && this.zzA == zzkc.zzA && this.zzB == zzkc.zzB && this.zzC == zzkc.zzC && this.zzD == zzkc.zzD && Float.compare(this.zzs, zzkc.zzs) == 0 && Float.compare(this.zzu, zzkc.zzu) == 0 && zzalh.zzc(this.zzE, zzkc.zzE) && zzalh.zzc(this.zza, zzkc.zza) && zzalh.zzc(this.zzb, zzkc.zzb) && zzalh.zzc(this.zzi, zzkc.zzi) && zzalh.zzc(this.zzk, zzkc.zzk) && zzalh.zzc(this.zzl, zzkc.zzl) && zzalh.zzc(this.zzc, zzkc.zzc) && Arrays.equals(this.zzv, zzkc.zzv) && zzalh.zzc(this.zzj, zzkc.zzj) && zzalh.zzc(this.zzx, zzkc.zzx) && zzalh.zzc(this.zzo, zzkc.zzo) && zzd(zzkc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.zzF;
        if (i6 != 0) {
            return i6;
        }
        String str = this.zza;
        int i7 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
        String str2 = this.zzb;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzc;
        if (str3 == null) {
            i = 0;
        } else {
            i = str3.hashCode();
        }
        int i8 = (((((((((hashCode2 + i) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31;
        String str4 = this.zzi;
        if (str4 == null) {
            i2 = 0;
        } else {
            i2 = str4.hashCode();
        }
        int i9 = (i8 + i2) * 31;
        zzabe zzabe = this.zzj;
        if (zzabe == null) {
            i3 = 0;
        } else {
            i3 = zzabe.hashCode();
        }
        int i10 = (i9 + i3) * 31;
        String str5 = this.zzk;
        if (str5 == null) {
            i4 = 0;
        } else {
            i4 = str5.hashCode();
        }
        int i11 = (i10 + i4) * 31;
        String str6 = this.zzl;
        if (str6 == null) {
            i5 = 0;
        } else {
            i5 = str6.hashCode();
        }
        int floatToIntBits = (((((((((((((((Float.floatToIntBits(this.zzu) + ((((Float.floatToIntBits(this.zzs) + ((((((((((i11 + i5) * 31) + this.zzm) * 31) + ((int) this.zzp)) * 31) + this.zzq) * 31) + this.zzr) * 31)) * 31) + this.zzt) * 31)) * 31) + this.zzw) * 31) + this.zzy) * 31) + this.zzz) * 31) + this.zzA) * 31) + this.zzB) * 31) + this.zzC) * 31) + this.zzD) * 31;
        Class cls = this.zzE;
        if (cls != null) {
            i7 = cls.hashCode();
        }
        int i12 = floatToIntBits + i7;
        this.zzF = i12;
        return i12;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String str3 = this.zzk;
        String str4 = this.zzl;
        String str5 = this.zzi;
        int i = this.zzh;
        String str6 = this.zzc;
        int i2 = this.zzq;
        int i3 = this.zzr;
        float f = this.zzs;
        int i4 = this.zzy;
        int i5 = this.zzz;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        int length3 = String.valueOf(str3).length();
        int length4 = String.valueOf(str4).length();
        StringBuilder sb = new StringBuilder(length + 104 + length2 + length3 + length4 + String.valueOf(str5).length() + String.valueOf(str6).length());
        GeneratedOutlineSupport.outline34(sb, "Format(", str, RESTClient.COMMA_SEPARATOR, str2);
        GeneratedOutlineSupport.outline34(sb, RESTClient.COMMA_SEPARATOR, str3, RESTClient.COMMA_SEPARATOR, str4);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(str5);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(i);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(str6);
        sb.append(", [");
        sb.append(i2);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(i3);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeString(this.zzi);
        boolean z = false;
        parcel.writeParcelable(this.zzj, 0);
        parcel.writeString(this.zzk);
        parcel.writeString(this.zzl);
        parcel.writeInt(this.zzm);
        int size = this.zzn.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzn.get(i2));
        }
        parcel.writeParcelable(this.zzo, 0);
        parcel.writeLong(this.zzp);
        parcel.writeInt(this.zzq);
        parcel.writeInt(this.zzr);
        parcel.writeFloat(this.zzs);
        parcel.writeInt(this.zzt);
        parcel.writeFloat(this.zzu);
        if (this.zzv != null) {
            z = true;
        }
        zzalh.zzo(parcel, z);
        byte[] bArr = this.zzv;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzw);
        parcel.writeParcelable(this.zzx, i);
        parcel.writeInt(this.zzy);
        parcel.writeInt(this.zzz);
        parcel.writeInt(this.zzA);
        parcel.writeInt(this.zzB);
        parcel.writeInt(this.zzC);
        parcel.writeInt(this.zzD);
    }

    public final zzkb zza() {
        return new zzkb(this, (zzka) null);
    }

    public final zzkc zzb(@Nullable Class cls) {
        zzkb zzkb = new zzkb(this, (zzka) null);
        zzkb.zzC(cls);
        return new zzkc(zzkb);
    }

    public final int zzc() {
        int i;
        int i2 = this.zzq;
        if (i2 == -1 || (i = this.zzr) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final boolean zzd(zzkc zzkc) {
        if (this.zzn.size() != zzkc.zzn.size()) {
            return false;
        }
        for (int i = 0; i < this.zzn.size(); i++) {
            if (!Arrays.equals(this.zzn.get(i), zzkc.zzn.get(i))) {
                return false;
            }
        }
        return true;
    }

    public zzkc(zzkb zzkb) {
        this.zza = zzkb.zza;
        this.zzb = zzkb.zzb;
        this.zzc = zzalh.zzq(zzkb.zzc);
        this.zzd = zzkb.zzd;
        this.zze = zzkb.zze;
        this.zzf = zzkb.zzf;
        int zzK = zzkb.zzg;
        this.zzg = zzK;
        this.zzh = zzK == -1 ? this.zzf : zzK;
        this.zzi = zzkb.zzh;
        this.zzj = zzkb.zzi;
        this.zzk = zzkb.zzj;
        this.zzl = zzkb.zzk;
        this.zzm = zzkb.zzl;
        this.zzn = zzkb.zzm == null ? Collections.emptyList() : zzkb.zzm;
        this.zzo = zzkb.zzn;
        this.zzp = zzkb.zzo;
        this.zzq = zzkb.zzp;
        this.zzr = zzkb.zzq;
        this.zzs = zzkb.zzr;
        int i = 0;
        this.zzt = zzkb.zzs == -1 ? 0 : zzkb.zzs;
        this.zzu = zzkb.zzt == -1.0f ? 1.0f : zzkb.zzt;
        this.zzv = zzkb.zzu;
        this.zzw = zzkb.zzv;
        this.zzx = zzkb.zzw;
        this.zzy = zzkb.zzx;
        this.zzz = zzkb.zzy;
        this.zzA = zzkb.zzz;
        this.zzB = zzkb.zzA == -1 ? 0 : zzkb.zzA;
        this.zzC = zzkb.zzB != -1 ? zzkb.zzB : i;
        this.zzD = zzkb.zzC;
        this.zzE = (zzkb.zzD != null || this.zzo == null) ? zzkb.zzD : zzsm.class;
    }

    public /* synthetic */ zzkc(zzkb zzkb, zzka zzka) {
        this(zzkb);
    }
}
