package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzaha implements Parcelable {
    public static final Parcelable.Creator<zzaha> CREATOR = new zzagy();
    public static final zzaha zzC;
    @Deprecated
    public static final zzaha zzD;
    public final zzfml<String> zzE;
    public final int zzF;
    public final zzfml<String> zzG;
    public final int zzH;
    public final boolean zzI;
    public final int zzJ;

    static {
        zzagz zzagz = new zzagz();
        zzaha zzaha = new zzaha(zzagz.zza, zzagz.zzb, zzagz.zzc, zzagz.zzd, zzagz.zze, zzagz.zzf);
        zzC = zzaha;
        zzD = zzaha;
    }

    public zzaha(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, (ClassLoader) null);
        this.zzE = zzfml.zzp(arrayList);
        this.zzF = parcel.readInt();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, (ClassLoader) null);
        this.zzG = zzfml.zzp(arrayList2);
        this.zzH = parcel.readInt();
        this.zzI = zzalh.zzn(parcel);
        this.zzJ = parcel.readInt();
    }

    public zzaha(zzfml<String> zzfml, int i, zzfml<String> zzfml2, int i2, boolean z, int i3) {
        this.zzE = zzfml;
        this.zzF = i;
        this.zzG = zzfml2;
        this.zzH = i2;
        this.zzI = z;
        this.zzJ = i3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaha zzaha = (zzaha) obj;
            return this.zzE.equals(zzaha.zzE) && this.zzF == zzaha.zzF && this.zzG.equals(zzaha.zzG) && this.zzH == zzaha.zzH && this.zzI == zzaha.zzI && this.zzJ == zzaha.zzJ;
        }
    }

    public int hashCode() {
        return ((((((this.zzG.hashCode() + ((((this.zzE.hashCode() + 31) * 31) + this.zzF) * 31)) * 31) + this.zzH) * 31) + (this.zzI ? 1 : 0)) * 31) + this.zzJ;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.zzE);
        parcel.writeInt(this.zzF);
        parcel.writeList(this.zzG);
        parcel.writeInt(this.zzH);
        zzalh.zzo(parcel, this.zzI);
        parcel.writeInt(this.zzJ);
    }
}
