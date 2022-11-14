package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "TelemetryDataCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaaa> CREATOR = new zaad();
    @SafeParcelable.Field(getter = "getTelemetryConfigVersion", mo17147id = 1)
    public final int zaa;
    @SafeParcelable.Field(getter = "getMethodInvocations", mo17147id = 2)
    @Nullable
    public List<zao> zab;

    @SafeParcelable.Constructor
    public zaaa(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) @Nullable List<zao> list) {
        this.zaa = i;
        this.zab = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zab, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zaa() {
        return this.zaa;
    }

    @Nullable
    public final List<zao> zab() {
        return this.zab;
    }

    public final void zaa(zao zao) {
        if (this.zab == null) {
            this.zab = new ArrayList();
        }
        this.zab.add(zao);
    }
}
