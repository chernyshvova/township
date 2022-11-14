package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgn extends zzhg {
    public zzgn(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "llqwiPI9WBGdX3ILtNQP0ldd/oo65vCmZGiUmTtHOSQw67bDkVyvEAM6wctf4g5A", "ciEjxtHwaQq5vQY33BpqQuStjcQqNXynEA7E/ixfFmM=", zzcn, i, 24);
    }

    private final void zzc() {
        AdvertisingIdClient zzr = this.zzb.zzr();
        if (zzr != null) {
            try {
                AdvertisingIdClient.Info info = zzr.getInfo();
                String zza = zzgb.zza(info.getId());
                if (zza != null) {
                    synchronized (this.zze) {
                        this.zze.zzX(zza);
                        this.zze.zzZ(info.isLimitAdTrackingEnabled());
                        this.zze.zzY(zzct.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzk();
        return null;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (!this.zzb.zzh()) {
            synchronized (this.zze) {
                this.zze.zzX((String) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()}));
            }
            return;
        }
        zzc();
    }

    public final Void zzk() throws Exception {
        if (this.zzb.zzc()) {
            super.zzk();
            return null;
        }
        if (this.zzb.zzh()) {
            zzc();
        }
        return null;
    }
}
