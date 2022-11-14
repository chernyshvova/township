package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public abstract class zzq<T> {
    public final int zza;
    public final TaskCompletionSource<T> zzb = new TaskCompletionSource<>();
    public final int zzc;
    public final Bundle zzd;

    public zzq(int i, int i2, Bundle bundle) {
        this.zza = i;
        this.zzc = i2;
        this.zzd = bundle;
    }

    public String toString() {
        int i = this.zzc;
        int i2 = this.zza;
        boolean zza2 = zza();
        StringBuilder outline22 = GeneratedOutlineSupport.outline22(55, "Request { what=", i, " id=", i2);
        outline22.append(" oneWay=");
        outline22.append(zza2);
        outline22.append("}");
        return outline22.toString();
    }

    public abstract void zza(Bundle bundle);

    public final void zza(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length() + 16);
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.zzb.setResult(t);
    }

    public abstract boolean zza();

    public final void zza(zzp zzp) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzp);
            StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length() + 14);
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.zzb.setException(zzp);
    }
}
