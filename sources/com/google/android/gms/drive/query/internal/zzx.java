package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.helpshift.support.FaqTagFilter;

@SafeParcelable.Class(creator = "OperatorCreator")
@SafeParcelable.Reserved({1000})
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    public static final zzx zzmq = new zzx("=");
    public static final zzx zzmr = new zzx("<");
    public static final zzx zzms = new zzx("<=");
    public static final zzx zzmt = new zzx(">");
    public static final zzx zzmu = new zzx(">=");
    public static final zzx zzmv = new zzx(FaqTagFilter.Operator.AND);
    public static final zzx zzmw = new zzx(FaqTagFilter.Operator.f3347OR);
    public static final zzx zzmx = new zzx(FaqTagFilter.Operator.NOT);
    public static final zzx zzmy = new zzx("contains");
    @SafeParcelable.Field(mo17147id = 1)
    public final String tag;

    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(mo17150id = 1) String str) {
        this.tag = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzx.class != obj.getClass()) {
            return false;
        }
        zzx zzx = (zzx) obj;
        String str = this.tag;
        if (str == null) {
            if (zzx.tag != null) {
                return false;
            }
        } else if (!str.equals(zzx.tag)) {
            return false;
        }
        return true;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int hashCode() {
        String str = this.tag;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.tag, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
