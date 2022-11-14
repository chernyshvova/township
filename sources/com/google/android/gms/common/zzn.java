package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupQueryCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();
    @SafeParcelable.Field(getter = "getCallingPackage", mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getAllowTestKeys", mo17147id = 2)
    public final boolean zzb;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", mo17147id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(getter = "getCallingContextBinder", mo17147id = 4, type = "android.os.IBinder")
    public final Context zzd;
    @SafeParcelable.Field(getter = "getIsChimeraPackage", mo17147id = 5)
    public final boolean zze;

    @SafeParcelable.Constructor
    public zzn(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) boolean z, @SafeParcelable.Param(mo17150id = 3) boolean z2, @SafeParcelable.Param(mo17150id = 4) IBinder iBinder, @SafeParcelable.Param(mo17150id = 5) boolean z3) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zze = z3;
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzd), false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
