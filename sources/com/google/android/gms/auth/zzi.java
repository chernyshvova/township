package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzay;
import com.google.android.gms.internal.auth.zzf;
import java.io.IOException;

public final class zzi implements zzj<Boolean> {
    public final /* synthetic */ String zzt;

    public zzi(String str) {
        this.zzt = str;
    }

    public final /* synthetic */ Object zzb(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle bundle = (Bundle) zzd.zza(zzf.zza(iBinder).zza(this.zzt));
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzay zzc = zzay.zzc(string);
        if (zzay.SUCCESS.equals(zzc)) {
            return Boolean.TRUE;
        }
        if (zzay.zza(zzc)) {
            Logger zza = zzd.zzn;
            String valueOf = String.valueOf(zzc);
            StringBuilder sb = new StringBuilder(valueOf.length() + 31);
            sb.append("isUserRecoverableError status: ");
            sb.append(valueOf);
            zza.mo17269w("GoogleAuthUtil", sb.toString());
            throw new UserRecoverableAuthException(string, intent);
        }
        throw new GoogleAuthException(string);
    }
}
