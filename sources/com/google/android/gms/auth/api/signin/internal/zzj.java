package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

public final class zzj extends zzc {
    public final /* synthetic */ zzi zzbk;

    public zzj(zzi zzi) {
        this.zzbk = zzi;
    }

    public final void zzc(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zzp.zzd(this.zzbk.val$context).zzc(this.zzbk.zzbj, googleSignInAccount);
        }
        this.zzbk.setResult(new GoogleSignInResult(googleSignInAccount, status));
    }
}
