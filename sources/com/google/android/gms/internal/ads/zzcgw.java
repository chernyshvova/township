package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcgw {
    public static <T> T zza(Context context, String str, zzcgu<IBinder, T> zzcgu) throws zzcgv {
        try {
            return zzcgu.zza(zzc(context).instantiate(str));
        } catch (Exception e) {
            throw new zzcgv(e);
        }
    }

    public static Context zzb(Context context) throws zzcgv {
        return zzc(context).getModuleContext();
    }

    public static DynamiteModule zzc(Context context) throws zzcgv {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzcgv(e);
        }
    }
}
