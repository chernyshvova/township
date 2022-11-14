package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzank implements Parcelable {
    public static final Parcelable.Creator<zzank> CREATOR = new zzanj();
    public int zzA;
    public final String zza;
    public final int zzb;
    public final String zzc;
    public final zzarq zzd;
    public final String zze;
    public final String zzf;
    public final int zzg;
    public final List<byte[]> zzh;
    public final zzaph zzi;
    public final int zzj;
    public final int zzk;
    public final float zzl;
    public final int zzm;
    public final float zzn;
    public final int zzo;
    public final byte[] zzp;
    public final zzavd zzq;
    public final int zzr;
    public final int zzs;
    public final int zzt;
    public final int zzu;
    public final int zzv;
    public final long zzw;
    public final int zzx;
    public final String zzy;
    public final int zzz;

    public zzank(Parcel parcel) {
        this.zza = parcel.readString();
        this.zze = parcel.readString();
        this.zzf = parcel.readString();
        this.zzc = parcel.readString();
        this.zzb = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzj = parcel.readInt();
        this.zzk = parcel.readInt();
        this.zzl = parcel.readFloat();
        this.zzm = parcel.readInt();
        this.zzn = parcel.readFloat();
        this.zzp = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzo = parcel.readInt();
        this.zzq = (zzavd) parcel.readParcelable(zzavd.class.getClassLoader());
        this.zzr = parcel.readInt();
        this.zzs = parcel.readInt();
        this.zzt = parcel.readInt();
        this.zzu = parcel.readInt();
        this.zzv = parcel.readInt();
        this.zzx = parcel.readInt();
        this.zzy = parcel.readString();
        this.zzz = parcel.readInt();
        this.zzw = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzh = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzh.add(parcel.createByteArray());
        }
        this.zzi = (zzaph) parcel.readParcelable(zzaph.class.getClassLoader());
        this.zzd = (zzarq) parcel.readParcelable(zzarq.class.getClassLoader());
    }

    public static zzank zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zzavd zzavd, zzaph zzaph) {
        return new zzank(str, (String) null, str2, (String) null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zzavd, -1, -1, -1, -1, -1, 0, (String) null, -1, RecyclerView.FOREVER_NS, list, zzaph, (zzarq) null);
    }

    public static zzank zzb(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzaph zzaph, int i5, String str4) {
        return zzc(str, str2, (String) null, -1, -1, i3, i4, -1, -1, -1, (List<byte[]>) null, zzaph, 0, str4, (zzarq) null);
    }

    public static zzank zzc(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, zzaph zzaph, int i8, String str4, zzarq zzarq) {
        return new zzank(str, (String) null, str2, (String) null, -1, i2, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzavd) null, i3, i4, i5, -1, -1, i8, str4, -1, RecyclerView.FOREVER_NS, list, zzaph, (zzarq) null);
    }

    public static zzank zzd(String str, String str2, String str3, int i, int i2, String str4, int i3, zzaph zzaph, long j, List<byte[]> list) {
        return new zzank(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzavd) null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzaph, (zzarq) null);
    }

    public static zzank zze(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzaph zzaph) {
        return new zzank(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzavd) null, -1, -1, -1, -1, -1, 0, str4, -1, RecyclerView.FOREVER_NS, list, zzaph, (zzarq) null);
    }

    public static zzank zzf(String str, String str2, String str3, int i, zzaph zzaph) {
        return new zzank(str, (String) null, "application/x-camera-motion", (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzavd) null, -1, -1, -1, -1, -1, 0, (String) null, -1, RecyclerView.FOREVER_NS, (List<byte[]>) null, zzaph, (zzarq) null);
    }

    @TargetApi(16)
    public static void zzm(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzank.class == obj.getClass()) {
            zzank zzank = (zzank) obj;
            if (this.zzb == zzank.zzb && this.zzg == zzank.zzg && this.zzj == zzank.zzj && this.zzk == zzank.zzk && this.zzl == zzank.zzl && this.zzm == zzank.zzm && this.zzn == zzank.zzn && this.zzo == zzank.zzo && this.zzr == zzank.zzr && this.zzs == zzank.zzs && this.zzt == zzank.zzt && this.zzu == zzank.zzu && this.zzv == zzank.zzv && this.zzw == zzank.zzw && this.zzx == zzank.zzx && zzava.zza(this.zza, zzank.zza) && zzava.zza(this.zzy, zzank.zzy) && this.zzz == zzank.zzz && zzava.zza(this.zze, zzank.zze) && zzava.zza(this.zzf, zzank.zzf) && zzava.zza(this.zzc, zzank.zzc) && zzava.zza(this.zzi, zzank.zzi) && zzava.zza(this.zzd, zzank.zzd) && zzava.zza(this.zzq, zzank.zzq) && Arrays.equals(this.zzp, zzank.zzp) && this.zzh.size() == zzank.zzh.size()) {
                for (int i = 0; i < this.zzh.size(); i++) {
                    if (!Arrays.equals(this.zzh.get(i), zzank.zzh.get(i))) {
                        return false;
                    }
                }
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
        int i6 = this.zzA;
        if (i6 != 0) {
            return i6;
        }
        String str = this.zza;
        int i7 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
        String str2 = this.zze;
        if (str2 == null) {
            i = 0;
        } else {
            i = str2.hashCode();
        }
        int i8 = (hashCode + i) * 31;
        String str3 = this.zzf;
        if (str3 == null) {
            i2 = 0;
        } else {
            i2 = str3.hashCode();
        }
        int i9 = (i8 + i2) * 31;
        String str4 = this.zzc;
        if (str4 == null) {
            i3 = 0;
        } else {
            i3 = str4.hashCode();
        }
        int i10 = (((((((((((i9 + i3) * 31) + this.zzb) * 31) + this.zzj) * 31) + this.zzk) * 31) + this.zzr) * 31) + this.zzs) * 31;
        String str5 = this.zzy;
        if (str5 == null) {
            i4 = 0;
        } else {
            i4 = str5.hashCode();
        }
        int i11 = (((i10 + i4) * 31) + this.zzz) * 31;
        zzaph zzaph = this.zzi;
        if (zzaph == null) {
            i5 = 0;
        } else {
            i5 = zzaph.hashCode();
        }
        int i12 = (i11 + i5) * 31;
        zzarq zzarq = this.zzd;
        if (zzarq != null) {
            i7 = zzarq.hashCode();
        }
        int i13 = i12 + i7;
        this.zzA = i13;
        return i13;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zze;
        String str3 = this.zzf;
        int i = this.zzb;
        String str4 = this.zzy;
        int i2 = this.zzj;
        int i3 = this.zzk;
        float f = this.zzl;
        int i4 = this.zzr;
        int i5 = this.zzs;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 100 + length2 + String.valueOf(str3).length() + String.valueOf(str4).length());
        GeneratedOutlineSupport.outline34(sb, "Format(", str, RESTClient.COMMA_SEPARATOR, str2);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(str3);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(i);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(str4);
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
        parcel.writeString(this.zze);
        parcel.writeString(this.zzf);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzg);
        parcel.writeInt(this.zzj);
        parcel.writeInt(this.zzk);
        parcel.writeFloat(this.zzl);
        parcel.writeInt(this.zzm);
        parcel.writeFloat(this.zzn);
        parcel.writeInt(this.zzp != null ? 1 : 0);
        byte[] bArr = this.zzp;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzo);
        parcel.writeParcelable(this.zzq, i);
        parcel.writeInt(this.zzr);
        parcel.writeInt(this.zzs);
        parcel.writeInt(this.zzt);
        parcel.writeInt(this.zzu);
        parcel.writeInt(this.zzv);
        parcel.writeInt(this.zzx);
        parcel.writeString(this.zzy);
        parcel.writeInt(this.zzz);
        parcel.writeLong(this.zzw);
        int size = this.zzh.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzh.get(i2));
        }
        parcel.writeParcelable(this.zzi, 0);
        parcel.writeParcelable(this.zzd, 0);
    }

    public final zzank zzg(int i) {
        String str = this.zza;
        return new zzank(str, this.zze, this.zzf, this.zzc, this.zzb, i, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, this.zzi, this.zzd);
    }

    public final zzank zzh(int i, int i2) {
        String str = this.zza;
        return new zzank(str, this.zze, this.zzf, this.zzc, this.zzb, this.zzg, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, i, i2, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, this.zzi, this.zzd);
    }

    public final zzank zzi(zzaph zzaph) {
        String str = this.zza;
        return new zzank(str, this.zze, this.zzf, this.zzc, this.zzb, this.zzg, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, zzaph, this.zzd);
    }

    public final zzank zzj(zzarq zzarq) {
        String str = this.zza;
        return new zzank(str, this.zze, this.zzf, this.zzc, this.zzb, this.zzg, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, this.zzi, zzarq);
    }

    public final int zzk() {
        int i;
        int i2 = this.zzj;
        if (i2 == -1 || (i = this.zzk) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzl() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzf);
        String str = this.zzy;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        zzm(mediaFormat, "max-input-size", this.zzg);
        zzm(mediaFormat, "width", this.zzj);
        zzm(mediaFormat, "height", this.zzk);
        float f = this.zzl;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        zzm(mediaFormat, "rotation-degrees", this.zzm);
        zzm(mediaFormat, "channel-count", this.zzr);
        zzm(mediaFormat, "sample-rate", this.zzs);
        zzm(mediaFormat, "encoder-delay", this.zzu);
        zzm(mediaFormat, "encoder-padding", this.zzv);
        for (int i = 0; i < this.zzh.size(); i++) {
            mediaFormat.setByteBuffer(GeneratedOutlineSupport.outline9(15, "csd-", i), ByteBuffer.wrap(this.zzh.get(i)));
        }
        zzavd zzavd = this.zzq;
        if (zzavd != null) {
            zzm(mediaFormat, "color-transfer", zzavd.zzc);
            zzm(mediaFormat, "color-standard", zzavd.zza);
            zzm(mediaFormat, "color-range", zzavd.zzb);
            byte[] bArr = zzavd.zzd;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public zzank(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zzavd zzavd, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzaph zzaph, zzarq zzarq) {
        this.zza = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzc = str4;
        this.zzb = i;
        this.zzg = i2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = f;
        this.zzm = i5;
        this.zzn = f2;
        this.zzp = bArr;
        this.zzo = i6;
        this.zzq = zzavd;
        this.zzr = i7;
        this.zzs = i8;
        this.zzt = i9;
        this.zzu = i10;
        this.zzv = i11;
        this.zzx = i12;
        this.zzy = str5;
        this.zzz = i13;
        this.zzw = j;
        this.zzh = list == null ? Collections.emptyList() : list;
        this.zzi = zzaph;
        this.zzd = zzarq;
    }
}
