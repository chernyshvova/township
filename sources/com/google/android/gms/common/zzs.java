package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();
    @SafeParcelable.Field(getter = "getCallingPackage", mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getCallingCertificateBinder", mo17147id = 2, type = "android.os.IBinder")
    @Nullable
    public final zzi zzb;
    @SafeParcelable.Field(getter = "getAllowTestKeys", mo17147id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", mo17147id = 4)
    public final boolean zzd;

    @SafeParcelable.Constructor
    public zzs(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(mo17150id = 3) boolean z, @SafeParcelable.Param(mo17150id = 4) boolean z2) {
        byte[] bArr;
        this.zza = str;
        zzj zzj = null;
        if (iBinder != null) {
            try {
                IObjectWrapper zzd2 = zzx.zzg(iBinder).zzd();
                if (zzd2 == null) {
                    bArr = null;
                } else {
                    bArr = (byte[]) ObjectWrapper.unwrap(zzd2);
                }
                if (bArr != null) {
                    zzj = new zzj(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.zzb = zzj;
        this.zzc = z;
        this.zzd = z2;
    }

    public zzs(String str, @Nullable zzi zzi, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = zzi;
        this.zzc = z;
        this.zzd = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        zzi zzi = this.zzb;
        if (zzi == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzi = null;
        }
        SafeParcelWriter.writeIBinder(parcel, 2, zzi, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
