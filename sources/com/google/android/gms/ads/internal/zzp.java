package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzfb;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzp extends AsyncTask<Void, Void, String> {
    public final /* synthetic */ zzr zza;

    public /* synthetic */ zzp(zzr zzr, zzm zzm) {
        this.zza = zzr;
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.zza.zzf != null && str != null) {
            this.zza.zzf.loadUrl(str);
        }
    }

    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzr zzr = this.zza;
            zzfb unused = zzr.zzh = (zzfb) zzr.zzc.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            zzcgs.zzj("", e);
        } catch (TimeoutException e2) {
            zzcgs.zzj("", e2);
        }
        return this.zza.zzM();
    }
}
