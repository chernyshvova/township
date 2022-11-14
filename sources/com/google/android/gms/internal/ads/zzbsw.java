package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbsw implements zzbso, zzbsl {
    public final zzcmr zza;

    public zzbsw(Context context, zzcgy zzcgy, @Nullable zzfb zzfb, zza zza2) throws zzcnc {
        zzs.zzd();
        zzcmr zza3 = zzcnd.zza(context, zzcoh.zzb(), "", false, false, (zzfb) null, (zzbkm) null, zzcgy, (zzbkc) null, (zzl) null, (zza) null, zzayx.zza(), (zzeye) null, (zzeyh) null);
        this.zza = zza3;
        ((View) zza3).setWillNotDraw(true);
    }

    public static final void zzs(Runnable runnable) {
        zzbev.zza();
        if (zzcgl.zzp()) {
            runnable.run();
        } else {
            zzr.zza.post(runnable);
        }
    }

    public final void zza(String str) {
        zzs(new zzbsp(this, str));
    }

    public final void zzb(String str, String str2) {
        zzbsk.zzb(this, str, str2);
    }

    public final void zzc(String str) {
        zzs(new zzbsq(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzd(String str, JSONObject jSONObject) {
        zzbsk.zzc(this, str, jSONObject);
    }

    public final void zze(String str, Map map) {
        zzbsk.zzd(this, str, map);
    }

    public final void zzf(String str) {
        zzs(new zzbss(this, str));
    }

    public final void zzg(String str) {
        zzs(new zzbsr(this, str));
    }

    public final void zzh(zzbsn zzbsn) {
        this.zza.zzR().zzx(zzbsu.zza(zzbsn));
    }

    public final void zzi() {
        this.zza.destroy();
    }

    public final boolean zzj() {
        return this.zza.zzX();
    }

    public final zzbtv zzk() {
        return new zzbtv(this);
    }

    public final void zzl(String str, zzbps<? super zzbtu> zzbps) {
        this.zza.zzab(str, new zzbsv(this, zzbps));
    }

    public final void zzm(String str, zzbps<? super zzbtu> zzbps) {
        this.zza.zzad(str, new zzbst(zzbps));
    }

    public final /* synthetic */ void zzn(String str) {
        this.zza.loadUrl(str);
    }

    public final /* synthetic */ void zzo(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    public final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    public final /* synthetic */ void zzq(String str) {
        this.zza.zza(str);
    }

    public final void zzr(String str, JSONObject jSONObject) {
        zzbsk.zza(this, str, jSONObject);
    }
}
