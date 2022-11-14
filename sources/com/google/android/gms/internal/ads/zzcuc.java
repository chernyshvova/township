package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcuc implements zzavz {
    public zzcmr zza;
    public final Executor zzb;
    public final zzcto zzc;
    public final Clock zzd;
    public boolean zze = false;
    public boolean zzf = false;
    public final zzctr zzg = new zzctr();

    public zzcuc(Executor executor, zzcto zzcto, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcto;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject zza2 = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new zzcub(this, zza2));
            }
        } catch (JSONException e) {
            zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zza(zzcmr zzcmr) {
        this.zza = zzcmr;
    }

    public final void zzb() {
        this.zze = false;
    }

    public final void zzc(zzavy zzavy) {
        zzctr zzctr = this.zzg;
        zzctr.zza = this.zzf ? false : zzavy.zzj;
        zzctr.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzavy;
        if (this.zze) {
            zzg();
        }
    }

    public final void zzd() {
        this.zze = true;
        zzg();
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final /* synthetic */ void zzf(JSONObject jSONObject) {
        this.zza.zzr("AFMA_updateActiveView", jSONObject);
    }
}
