package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zza extends AsyncTask<Void, Void, Integer> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ ProviderInstaller.ProviderInstallListener zzb;

    public zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.zza = context;
        this.zzb = providerInstallListener;
    }

    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        int i;
        Void[] voidArr = (Void[]) objArr;
        try {
            ProviderInstaller.installIfNeeded(this.zza);
            i = 0;
        } catch (GooglePlayServicesRepairableException e) {
            i = e.getConnectionStatusCode();
        } catch (GooglePlayServicesNotAvailableException e2) {
            i = e2.errorCode;
        }
        return Integer.valueOf(i);
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.zzb.onProviderInstalled();
            return;
        }
        this.zzb.onProviderInstallFailed(num.intValue(), ProviderInstaller.zza.getErrorResolutionIntent(this.zza, num.intValue(), "pi"));
    }
}
