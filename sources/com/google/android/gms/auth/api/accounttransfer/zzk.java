package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzs;

public final class zzk extends zzs {
    public final /* synthetic */ AccountTransferClient.zzc zzay;

    public zzk(AccountTransferClient.zzc zzc) {
        this.zzay = zzc;
    }

    public final void onFailure(Status status) {
        this.zzay.zza(status);
    }

    public final void zzd() {
        this.zzay.setResult(null);
    }
}
