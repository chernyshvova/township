package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcam {
    @Nonnull
    public final View zza;
    @Nullable
    public final Map<String, WeakReference<View>> zzb;
    @Nullable
    public final zzcfo zzc;

    public zzcam(zzcal zzcal) {
        this.zza = zzcal.zza;
        this.zzb = zzcal.zzb;
        zzcfo zza2 = zzcai.zza(zzcal.zza.getContext());
        this.zzc = zza2;
        if (zza2 != null && !this.zzb.isEmpty()) {
            try {
                this.zzc.zzi(new zzcan(ObjectWrapper.wrap(this.zza).asBinder(), ObjectWrapper.wrap(this.zzb).asBinder()));
            } catch (RemoteException unused) {
                zzcgs.zzf("Failed to call remote method.");
            }
        }
    }

    public final void zza(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzc == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzg(list, ObjectWrapper.wrap(this.zza), new zzcaj(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }

    public final void zzb(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzc == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzh(new ArrayList(Arrays.asList(new Uri[]{uri})), ObjectWrapper.wrap(this.zza), new zzcak(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        zzcfo zzcfo = this.zzc;
        if (zzcfo != null) {
            try {
                zzcfo.zzf(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException unused) {
                zzcgs.zzf("Failed to call remote method.");
            }
        } else {
            zzcgs.zzd("Failed to get internal reporting info generator.");
        }
    }
}
