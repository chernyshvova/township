package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzb implements OnSuccessListener<Void> {
    public final /* synthetic */ OnTokenCanceledListener zza;

    public zzb(zza zza2, OnTokenCanceledListener onTokenCanceledListener) {
        this.zza = onTokenCanceledListener;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Void voidR = (Void) obj;
        this.zza.onCanceled();
    }
}
