package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaph implements Comparator<zzapg>, Parcelable {
    public static final Parcelable.Creator<zzaph> CREATOR = new zzape();
    public final int zza;
    public final zzapg[] zzb;
    public int zzc;

    public zzaph(Parcel parcel) {
        zzapg[] zzapgArr = (zzapg[]) parcel.createTypedArray(zzapg.CREATOR);
        this.zzb = zzapgArr;
        this.zza = zzapgArr.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzapg zzapg = (zzapg) obj;
        zzapg zzapg2 = (zzapg) obj2;
        if (zzamv.zzb.equals(zzapg.zze)) {
            return !zzamv.zzb.equals(zzapg2.zze) ? 1 : 0;
        }
        return zzapg.zze.compareTo(zzapg2.zze);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzaph.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzaph) obj).zzb);
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb);
        this.zzc = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzb, 0);
    }

    public final zzapg zza(int i) {
        return this.zzb[i];
    }

    public zzaph(List<zzapg> list) {
        this(false, (zzapg[]) list.toArray(new zzapg[list.size()]));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.google.android.gms.internal.ads.zzapg[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaph(boolean r3, com.google.android.gms.internal.ads.zzapg... r4) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 == 0) goto L_0x000c
            java.lang.Object r3 = r4.clone()
            r4 = r3
            com.google.android.gms.internal.ads.zzapg[] r4 = (com.google.android.gms.internal.ads.zzapg[]) r4
        L_0x000c:
            java.util.Arrays.sort(r4, r2)
            r3 = 1
        L_0x0010:
            int r0 = r4.length
            if (r3 >= r0) goto L_0x004b
            int r0 = r3 + -1
            r0 = r4[r0]
            java.util.UUID r0 = r0.zze
            r1 = r4[r3]
            java.util.UUID r1 = r1.zze
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            int r3 = r3 + 1
            goto L_0x0010
        L_0x002a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = r4[r3]
            java.util.UUID r3 = r3.zze
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = r4 + 25
            r1.<init>(r4)
            java.lang.String r4 = "Duplicate data for uuid: "
            java.lang.String r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline18(r1, r4, r3)
            r0.<init>(r3)
            throw r0
        L_0x004b:
            r2.zzb = r4
            r2.zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaph.<init>(boolean, com.google.android.gms.internal.ads.zzapg[]):void");
    }

    public zzaph(zzapg... zzapgArr) {
        this(true, zzapgArr);
    }
}
