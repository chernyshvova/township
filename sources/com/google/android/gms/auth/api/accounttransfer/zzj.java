package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzx;
import com.google.android.gms.internal.auth.zzz;

public final class zzj extends AccountTransferClient.zzc {
    public final /* synthetic */ zzab zzau;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzj(AccountTransferClient accountTransferClient, zzab zzab) {
        super((zzc) null);
        this.zzau = zzab;
    }

    public final void zza(zzz zzz) throws RemoteException {
        zzz.zza((zzx) this.zzax, this.zzau);
    }
}
