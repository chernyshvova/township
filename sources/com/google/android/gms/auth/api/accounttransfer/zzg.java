package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzv;
import com.google.android.gms.internal.auth.zzx;
import com.google.android.gms.internal.auth.zzz;

public final class zzg extends AccountTransferClient.zzb<DeviceMetaData> {
    public final /* synthetic */ zzv zzar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzg(AccountTransferClient accountTransferClient, zzv zzv) {
        super((zzc) null);
        this.zzar = zzv;
    }

    public final void zza(zzz zzz) throws RemoteException {
        zzz.zza((zzx) new zzh(this, this), this.zzar);
    }
}
