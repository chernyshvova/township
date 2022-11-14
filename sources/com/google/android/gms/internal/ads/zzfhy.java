package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfhy extends zzc<zzfid> {
    public final int zze;

    public zzfhy(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, int i) {
        super(context, looper, 116, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
        this.zze = i;
    }

    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        if (queryLocalInterface instanceof zzfid) {
            return (zzfid) queryLocalInterface;
        }
        return new zzfid(iBinder);
    }

    public final int getMinApkVersion() {
        return this.zze;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.gass.START";
    }

    public final zzfid zzp() throws DeadObjectException {
        return (zzfid) super.getService();
    }
}
