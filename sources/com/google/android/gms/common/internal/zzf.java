package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzf extends zza {
    @Nullable
    public final IBinder zze;
    public final /* synthetic */ BaseGmsClient zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzf(BaseGmsClient baseGmsClient, @Nullable int i, @Nullable IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i, bundle);
        this.zzf = baseGmsClient;
        this.zze = iBinder;
    }

    public final boolean zza() {
        try {
            IBinder iBinder = this.zze;
            Preconditions.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.zzf.getServiceDescriptor().equals(interfaceDescriptor)) {
                String serviceDescriptor = this.zzf.getServiceDescriptor();
                Log.e("GmsClient", GeneratedOutlineSupport.outline20(new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length()), "service descriptor mismatch: ", serviceDescriptor, " vs. ", interfaceDescriptor));
                return false;
            }
            IInterface createServiceInterface = this.zzf.createServiceInterface(this.zze);
            if (createServiceInterface == null || (!BaseGmsClient.zzl(this.zzf, 2, 4, createServiceInterface) && !BaseGmsClient.zzl(this.zzf, 3, 4, createServiceInterface))) {
                return false;
            }
            ConnectionResult unused = this.zzf.zzB = null;
            Bundle connectionHint = this.zzf.getConnectionHint();
            if (this.zzf.zzw == null) {
                return true;
            }
            this.zzf.zzw.onConnected(connectionHint);
            return true;
        } catch (RemoteException unused2) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    public final void zzb(ConnectionResult connectionResult) {
        if (this.zzf.zzx != null) {
            this.zzf.zzx.onConnectionFailed(connectionResult);
        }
        this.zzf.onConnectionFailed(connectionResult);
    }
}
