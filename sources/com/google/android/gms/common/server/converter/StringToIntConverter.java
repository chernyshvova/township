package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

@KeepForSdk
@SafeParcelable.Class(creator = "StringToIntConverterCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    @RecentlyNonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zad();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zaa;
    public final HashMap<String, Integer> zab;
    public final SparseArray<String> zac;
    @SafeParcelable.Field(getter = "getSerializedMap", mo17147id = 2)
    @Nullable
    public final ArrayList<zaa> zad;

    @SafeParcelable.Constructor
    public StringToIntConverter(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) ArrayList<zaa> arrayList) {
        this.zaa = i;
        this.zab = new HashMap<>();
        this.zac = new SparseArray<>();
        this.zad = null;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zaa zaa2 = arrayList.get(i2);
            i2++;
            zaa zaa3 = zaa2;
            add(zaa3.zaa, zaa3.zab);
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public final StringToIntConverter add(@RecentlyNonNull String str, int i) {
        this.zab.put(str, Integer.valueOf(i));
        this.zac.put(i, str);
        return this;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        ArrayList arrayList = new ArrayList();
        for (String next : this.zab.keySet()) {
            arrayList.add(new zaa(next, this.zab.get(next).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zaa() {
        return 7;
    }

    @RecentlyNonNull
    public final /* synthetic */ Object zaa(@RecentlyNonNull Object obj) {
        String str = this.zac.get(((Integer) obj).intValue());
        return (str != null || !this.zab.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public final int zab() {
        return 0;
    }

    @RecentlyNullable
    public final /* synthetic */ Object zab(@RecentlyNonNull Object obj) {
        Integer num = this.zab.get((String) obj);
        return num == null ? this.zab.get("gms_unknown") : num;
    }

    @SafeParcelable.Class(creator = "StringToIntConverterEntryCreator")
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new zac();
        @SafeParcelable.Field(mo17147id = 2)
        public final String zaa;
        @SafeParcelable.Field(mo17147id = 3)
        public final int zab;
        @SafeParcelable.VersionField(mo17153id = 1)
        public final int zac;

        @SafeParcelable.Constructor
        public zaa(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) int i2) {
            this.zac = i;
            this.zaa = str;
            this.zab = i2;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zac);
            SafeParcelWriter.writeString(parcel, 2, this.zaa, false);
            SafeParcelWriter.writeInt(parcel, 3, this.zab);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        public zaa(String str, int i) {
            this.zac = 1;
            this.zaa = str;
            this.zab = i;
        }
    }

    @KeepForSdk
    public StringToIntConverter() {
        this.zaa = 1;
        this.zab = new HashMap<>();
        this.zac = new SparseArray<>();
        this.zad = null;
    }
}
