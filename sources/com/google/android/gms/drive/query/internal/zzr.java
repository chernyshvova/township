package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "LogicalFilterCreator")
@SafeParcelable.Reserved({1000})
public final class zzr extends zza {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    public List<Filter> zzls;
    @SafeParcelable.Field(mo17147id = 1)
    public final zzx zzlz;
    @SafeParcelable.Field(mo17147id = 2)
    public final List<FilterHolder> zzmo;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(mo17150id = 1) zzx zzx, @SafeParcelable.Param(mo17150id = 2) List<FilterHolder> list) {
        this.zzlz = zzx;
        this.zzmo = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzlz, i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzmo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final <T> T zza(zzj<T> zzj) {
        ArrayList arrayList = new ArrayList();
        for (FilterHolder filter : this.zzmo) {
            arrayList.add(filter.getFilter().zza(zzj));
        }
        return zzj.zza(this.zzlz, (List<T>) arrayList);
    }

    public zzr(zzx zzx, Iterable<Filter> iterable) {
        this.zzlz = zzx;
        this.zzls = new ArrayList();
        this.zzmo = new ArrayList();
        for (Filter next : iterable) {
            this.zzls.add(next);
            this.zzmo.add(new FilterHolder(next));
        }
    }

    public zzr(zzx zzx, Filter filter, Filter... filterArr) {
        this.zzlz = zzx;
        ArrayList arrayList = new ArrayList(filterArr.length + 1);
        this.zzmo = arrayList;
        arrayList.add(new FilterHolder(filter));
        ArrayList arrayList2 = new ArrayList(filterArr.length + 1);
        this.zzls = arrayList2;
        arrayList2.add(filter);
        for (Filter filter2 : filterArr) {
            this.zzmo.add(new FilterHolder(filter2));
            this.zzls.add(filter2);
        }
    }
}
