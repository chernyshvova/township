package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "NativeAdLayoutInfoParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcan> CREATOR = new zzcao();
    @SafeParcelable.Field(getter = "getAdViewAsBinder", mo17147id = 1, type = "android.os.IBinder")
    public final View zza;
    @SafeParcelable.Field(getter = "getAssetViewMapAsBinder", mo17147id = 2, type = "android.os.IBinder")
    public final Map<String, WeakReference<View>> zzb;

    @SafeParcelable.Constructor
    public zzcan(@SafeParcelable.Param(mo17150id = 1) IBinder iBinder, @SafeParcelable.Param(mo17150id = 2) IBinder iBinder2) {
        this.zza = (View) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzb = (Map) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, ObjectWrapper.wrap(this.zza).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, ObjectWrapper.wrap(this.zzb).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
