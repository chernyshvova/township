package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhx extends zzbgp {
    public final String zza;
    public final String zzb;

    public zzbhx(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final String zze() throws RemoteException {
        return this.zza;
    }

    public final String zzf() throws RemoteException {
        return this.zzb;
    }
}
