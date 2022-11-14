package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzafr implements Parcelable {
    public static final Parcelable.Creator<zzafr> CREATOR = new zzafq();
    public final int zza;
    public final zzkc[] zzb;
    public int zzc;

    public zzafr(Parcel parcel) {
        int readInt = parcel.readInt();
        this.zza = readInt;
        this.zzb = new zzkc[readInt];
        for (int i = 0; i < this.zza; i++) {
            this.zzb[i] = (zzkc) parcel.readParcelable(zzkc.class.getClassLoader());
        }
    }

    public static String zzc(@Nullable String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    public static void zzd(String str, @Nullable String str2, @Nullable String str3, int i) {
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(str.length(), 78, String.valueOf(str2).length(), String.valueOf(str3).length()));
        GeneratedOutlineSupport.outline34(sb, "Different ", str, " combined in one TrackGroup: '", str2);
        sb.append("' (track 0) and '");
        sb.append(str3);
        sb.append("' (track ");
        sb.append(i);
        sb.append(")");
        zzaka.zzb("TrackGroup", "", new IllegalStateException(sb.toString()));
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafr.class == obj.getClass()) {
            zzafr zzafr = (zzafr) obj;
            return this.zza == zzafr.zza && Arrays.equals(this.zzb, zzafr.zzb);
        }
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb) + 527;
        this.zzc = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        for (int i2 = 0; i2 < this.zza; i2++) {
            parcel.writeParcelable(this.zzb[i2], 0);
        }
    }

    public final zzkc zza(int i) {
        return this.zzb[i];
    }

    public final int zzb(zzkc zzkc) {
        int i = 0;
        while (true) {
            zzkc[] zzkcArr = this.zzb;
            if (i >= zzkcArr.length) {
                return -1;
            }
            if (zzkc == zzkcArr[i]) {
                return i;
            }
            i++;
        }
    }

    public zzafr(zzkc... zzkcArr) {
        int length = zzkcArr.length;
        int i = 1;
        zzajg.zzd(length > 0);
        this.zzb = zzkcArr;
        this.zza = length;
        String zzc2 = zzc(zzkcArr[0].zzc);
        int i2 = this.zzb[0].zze | 16384;
        while (true) {
            zzkc[] zzkcArr2 = this.zzb;
            if (i >= zzkcArr2.length) {
                return;
            }
            if (!zzc2.equals(zzc(zzkcArr2[i].zzc))) {
                zzkc[] zzkcArr3 = this.zzb;
                zzd("languages", zzkcArr3[0].zzc, zzkcArr3[i].zzc, i);
                return;
            }
            zzkc[] zzkcArr4 = this.zzb;
            if (i2 != (zzkcArr4[i].zze | 16384)) {
                zzd("role flags", Integer.toBinaryString(zzkcArr4[0].zze), Integer.toBinaryString(this.zzb[i].zze), i);
                return;
            }
            i++;
        }
    }
}
