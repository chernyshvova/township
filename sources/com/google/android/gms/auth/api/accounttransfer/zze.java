package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzad;
import com.google.android.gms.internal.auth.zzx;
import com.google.android.gms.internal.auth.zzz;

public final class zze extends AccountTransferClient.zzb<byte[]> {
    public final /* synthetic */ zzad zzap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zze(AccountTransferClient accountTransferClient, zzad zzad) {
        super((zzc) null);
        this.zzap = zzad;
    }

    public final void zza(zzz zzz) throws RemoteException {
        zzz.zza((zzx) new zzf(this, this), this.zzap);
    }
}
