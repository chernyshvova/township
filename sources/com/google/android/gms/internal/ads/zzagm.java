package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagm extends zzaha {
    public static final Parcelable.Creator<zzagm> CREATOR = new zzagl();
    public static final zzagm zza = new zzagn().zzb();
    public final boolean zzA;
    public final boolean zzB;
    public final SparseArray<Map<zzaft, zzagp>> zzK;
    public final SparseBooleanArray zzL;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final int zzm;
    public final int zzn;
    public final boolean zzo;
    public final zzfml<String> zzp;
    public final int zzq;
    public final int zzr;
    public final boolean zzs;
    public final boolean zzt;
    public final boolean zzu;
    public final boolean zzv;
    public final zzfml<String> zzw;
    public final boolean zzx;
    public final boolean zzy;
    public final boolean zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzagm(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, boolean z3, int i9, int i10, boolean z4, zzfml<String> zzfml, zzfml<String> zzfml2, int i11, int i12, int i13, boolean z5, boolean z6, boolean z7, boolean z8, zzfml<String> zzfml3, zzfml<String> zzfml4, int i14, boolean z9, int i15, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, SparseArray<Map<zzaft, zzagp>> sparseArray, SparseBooleanArray sparseBooleanArray) {
        super(zzfml2, i11, zzfml4, i14, z9, i15);
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = i8;
        this.zzj = z;
        this.zzk = z2;
        this.zzl = z3;
        this.zzm = i9;
        this.zzn = i10;
        this.zzo = z4;
        this.zzp = zzfml;
        this.zzq = i12;
        this.zzr = i13;
        this.zzs = z5;
        this.zzt = z6;
        this.zzu = z7;
        this.zzv = z8;
        this.zzw = zzfml3;
        this.zzx = z10;
        this.zzy = z11;
        this.zzz = z12;
        this.zzA = z13;
        this.zzB = z14;
        this.zzK = sparseArray;
        this.zzL = sparseBooleanArray;
    }

    public static zzagm zza(Context context) {
        return new zzagn(context).zzb();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagm.class == obj.getClass()) {
            zzagm zzagm = (zzagm) obj;
            if (super.equals(obj) && this.zzb == zzagm.zzb && this.zzc == zzagm.zzc && this.zzd == zzagm.zzd && this.zze == zzagm.zze && this.zzf == zzagm.zzf && this.zzg == zzagm.zzg && this.zzh == zzagm.zzh && this.zzi == zzagm.zzi && this.zzj == zzagm.zzj && this.zzk == zzagm.zzk && this.zzl == zzagm.zzl && this.zzo == zzagm.zzo && this.zzm == zzagm.zzm && this.zzn == zzagm.zzn && this.zzp.equals(zzagm.zzp) && this.zzq == zzagm.zzq && this.zzr == zzagm.zzr && this.zzs == zzagm.zzs && this.zzt == zzagm.zzt && this.zzu == zzagm.zzu && this.zzv == zzagm.zzv && this.zzw.equals(zzagm.zzw) && this.zzx == zzagm.zzx && this.zzy == zzagm.zzy && this.zzz == zzagm.zzz && this.zzA == zzagm.zzA && this.zzB == zzagm.zzB) {
                SparseBooleanArray sparseBooleanArray = this.zzL;
                SparseBooleanArray sparseBooleanArray2 = zzagm.zzL;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            SparseArray<Map<zzaft, zzagp>> sparseArray = this.zzK;
                            SparseArray<Map<zzaft, zzagp>> sparseArray2 = zzagm.zzK;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                int i2 = 0;
                                while (i2 < size2) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (indexOfKey >= 0) {
                                        Map valueAt = sparseArray.valueAt(i2);
                                        Map valueAt2 = sparseArray2.valueAt(indexOfKey);
                                        if (valueAt2.size() == valueAt.size()) {
                                            for (Map.Entry entry : valueAt.entrySet()) {
                                                zzaft zzaft = (zzaft) entry.getKey();
                                                if (valueAt2.containsKey(zzaft)) {
                                                    if (!zzalh.zzc(entry.getValue(), valueAt2.get(zzaft))) {
                                                    }
                                                }
                                            }
                                            i2++;
                                        }
                                    }
                                }
                                return true;
                            }
                        } else if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzp.hashCode();
        return ((((((((((this.zzw.hashCode() + ((((((((((((((hashCode + (((((((((((((((((((((((((((((super.hashCode() * 31) + this.zzb) * 31) + this.zzc) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31) + this.zzi) * 31) + (this.zzj ? 1 : 0)) * 31) + (this.zzk ? 1 : 0)) * 31) + (this.zzl ? 1 : 0)) * 31) + (this.zzo ? 1 : 0)) * 31) + this.zzm) * 31) + this.zzn) * 31)) * 31) + this.zzq) * 31) + this.zzr) * 31) + (this.zzs ? 1 : 0)) * 31) + (this.zzt ? 1 : 0)) * 31) + (this.zzu ? 1 : 0)) * 31) + (this.zzv ? 1 : 0)) * 31)) * 31) + (this.zzx ? 1 : 0)) * 31) + (this.zzy ? 1 : 0)) * 31) + (this.zzz ? 1 : 0)) * 31) + (this.zzA ? 1 : 0)) * 31) + (this.zzB ? 1 : 0);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeInt(this.zzh);
        parcel.writeInt(this.zzi);
        zzalh.zzo(parcel, this.zzj);
        zzalh.zzo(parcel, this.zzk);
        zzalh.zzo(parcel, this.zzl);
        parcel.writeInt(this.zzm);
        parcel.writeInt(this.zzn);
        zzalh.zzo(parcel, this.zzo);
        parcel.writeList(this.zzp);
        parcel.writeInt(this.zzq);
        parcel.writeInt(this.zzr);
        zzalh.zzo(parcel, this.zzs);
        zzalh.zzo(parcel, this.zzt);
        zzalh.zzo(parcel, this.zzu);
        zzalh.zzo(parcel, this.zzv);
        parcel.writeList(this.zzw);
        zzalh.zzo(parcel, this.zzx);
        zzalh.zzo(parcel, this.zzy);
        zzalh.zzo(parcel, this.zzz);
        zzalh.zzo(parcel, this.zzA);
        zzalh.zzo(parcel, this.zzB);
        SparseArray<Map<zzaft, zzagp>> sparseArray = this.zzK;
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            Map valueAt = sparseArray.valueAt(i2);
            int size2 = valueAt.size();
            parcel.writeInt(keyAt);
            parcel.writeInt(size2);
            for (Map.Entry entry : valueAt.entrySet()) {
                parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                parcel.writeParcelable((Parcelable) entry.getValue(), 0);
            }
        }
        parcel.writeSparseBooleanArray(this.zzL);
    }

    public final boolean zzb(int i) {
        return this.zzL.get(i);
    }

    public final boolean zzc(int i, zzaft zzaft) {
        Map map = this.zzK.get(i);
        return map != null && map.containsKey(zzaft);
    }

    @Nullable
    public final zzagp zzd(int i, zzaft zzaft) {
        Map map = this.zzK.get(i);
        if (map != null) {
            return (zzagp) map.get(zzaft);
        }
        return null;
    }

    public final zzagn zze() {
        return new zzagn(this, (zzagi) null);
    }

    public zzagm(Parcel parcel) {
        super(parcel);
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = parcel.readInt();
        this.zzi = parcel.readInt();
        this.zzj = zzalh.zzn(parcel);
        this.zzk = zzalh.zzn(parcel);
        this.zzl = zzalh.zzn(parcel);
        this.zzm = parcel.readInt();
        this.zzn = parcel.readInt();
        this.zzo = zzalh.zzn(parcel);
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, (ClassLoader) null);
        this.zzp = zzfml.zzp(arrayList);
        this.zzq = parcel.readInt();
        this.zzr = parcel.readInt();
        this.zzs = zzalh.zzn(parcel);
        this.zzt = zzalh.zzn(parcel);
        this.zzu = zzalh.zzn(parcel);
        this.zzv = zzalh.zzn(parcel);
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, (ClassLoader) null);
        this.zzw = zzfml.zzp(arrayList2);
        this.zzx = zzalh.zzn(parcel);
        this.zzy = zzalh.zzn(parcel);
        this.zzz = zzalh.zzn(parcel);
        this.zzA = zzalh.zzn(parcel);
        this.zzB = zzalh.zzn(parcel);
        int readInt = parcel.readInt();
        SparseArray<Map<zzaft, zzagp>> sparseArray = new SparseArray<>(readInt);
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            HashMap hashMap = new HashMap(readInt3);
            int i2 = 0;
            while (i2 < readInt3) {
                zzaft zzaft = (zzaft) parcel.readParcelable(zzaft.class.getClassLoader());
                if (zzaft != null) {
                    hashMap.put(zzaft, (zzagp) parcel.readParcelable(zzagp.class.getClassLoader()));
                    i2++;
                } else {
                    throw null;
                }
            }
            sparseArray.put(readInt2, hashMap);
        }
        this.zzK = sparseArray;
        this.zzL = parcel.readSparseBooleanArray();
    }
}
