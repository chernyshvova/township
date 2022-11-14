package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsa implements Comparator<zzrz>, Parcelable {
    public static final Parcelable.Creator<zzsa> CREATOR = new zzrx();
    @Nullable
    public final String zza;
    public final zzrz[] zzb;
    public int zzc;

    public zzsa(Parcel parcel) {
        this.zza = parcel.readString();
        zzrz[] zzrzArr = (zzrz[]) zzalh.zzd((zzrz[]) parcel.createTypedArray(zzrz.CREATOR));
        this.zzb = zzrzArr;
        int length = zzrzArr.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzrz zzrz = (zzrz) obj;
        zzrz zzrz2 = (zzrz) obj2;
        if (zzig.zza.equals(zzrz.zza)) {
            return !zzig.zza.equals(zzrz2.zza) ? 1 : 0;
        }
        return zzrz.zza.compareTo(zzrz2.zza);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzsa.class == obj.getClass()) {
            zzsa zzsa = (zzsa) obj;
            return zzalh.zzc(this.zza, zzsa.zza) && Arrays.equals(this.zzb, zzsa.zzb);
        }
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int hashCode = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.zzb);
        this.zzc = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeTypedArray(this.zzb, 0);
    }

    public final zzsa zza(@Nullable String str) {
        if (zzalh.zzc(this.zza, str)) {
            return this;
        }
        return new zzsa(str, false, this.zzb);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.gms.internal.ads.zzrz[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzsa(@androidx.annotation.Nullable java.lang.String r1, boolean r2, com.google.android.gms.internal.ads.zzrz... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zza = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.google.android.gms.internal.ads.zzrz[] r3 = (com.google.android.gms.internal.ads.zzrz[]) r3
        L_0x000e:
            r0.zzb = r3
            int r1 = r3.length
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsa.<init>(java.lang.String, boolean, com.google.android.gms.internal.ads.zzrz[]):void");
    }

    public zzsa(@Nullable String str, zzrz... zzrzArr) {
        this((String) null, true, zzrzArr);
    }

    public zzsa(List<zzrz> list) {
        this((String) null, false, (zzrz[]) list.toArray(new zzrz[0]));
    }
}
