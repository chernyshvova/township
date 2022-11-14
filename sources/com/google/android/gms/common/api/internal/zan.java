package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zan implements Runnable {
    public final /* synthetic */ zal zaa;
    public final zak zab;

    public zan(zal zal, zak zak) {
        this.zaa = zal;
        this.zab = zak;
    }

    @MainThread
    public final void run() {
        if (this.zaa.zaa) {
            ConnectionResult zab2 = this.zab.zab();
            if (zab2.hasResolution()) {
                zal zal = this.zaa;
                zal.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zal.getActivity(), (PendingIntent) Preconditions.checkNotNull(zab2.getResolution()), this.zab.zaa(), false), 1);
                return;
            }
            zal zal2 = this.zaa;
            if (zal2.zac.getErrorResolutionIntent(zal2.getActivity(), zab2.getErrorCode(), (String) null) != null) {
                zal zal3 = this.zaa;
                zal3.zac.zaa(zal3.getActivity(), this.zaa.mLifecycleFragment, zab2.getErrorCode(), 2, this.zaa);
            } else if (zab2.getErrorCode() == 18) {
                Dialog zaa2 = GoogleApiAvailability.zaa(this.zaa.getActivity(), (DialogInterface.OnCancelListener) this.zaa);
                zal zal4 = this.zaa;
                zal4.zac.zaa(zal4.getActivity().getApplicationContext(), (zabm) new zam(this, zaa2));
            } else {
                this.zaa.zaa(zab2, this.zab.zaa());
            }
        }
    }
}
