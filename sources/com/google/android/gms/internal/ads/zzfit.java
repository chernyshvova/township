package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfit {
    @VisibleForTesting
    public boolean zza;
    @VisibleForTesting
    public zzfiu zzb;

    public zzfit(Context context, String str, String str2) {
        zzfiu zzfiu;
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
            if (instantiate == null) {
                zzfiu = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                if (queryLocalInterface instanceof zzfiu) {
                    zzfiu = (zzfiu) queryLocalInterface;
                } else {
                    zzfiu = new zzfiu(instantiate);
                }
            }
            try {
                this.zzb = zzfiu;
                this.zzb.zzj(ObjectWrapper.wrap(context), str, (String) null);
                this.zza = true;
                Log.i("GASS", "GassClearcutLogger Initialized.");
            } catch (RemoteException | zzfhv | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
            }
        } catch (Exception e) {
            throw new zzfhv(e);
        } catch (Exception e2) {
            throw new zzfhv(e2);
        }
    }

    public final zzfis zza(byte[] bArr) {
        return new zzfis(this, bArr, (zzfir) null);
    }
}
