package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfhg {
    public final Context zza;
    public final Executor zzb;
    public final zzfgn zzc;
    public final zzfgp zzd;
    public final zzfhf zze;
    public final zzfhf zzf;
    public Task<zzdc> zzg;
    public Task<zzdc> zzh;

    @VisibleForTesting
    public zzfhg(Context context, Executor executor, zzfgn zzfgn, zzfgp zzfgp, zzfhd zzfhd, zzfhe zzfhe) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfgn;
        this.zzd = zzfgp;
        this.zze = zzfhd;
        this.zzf = zzfhe;
    }

    public static zzfhg zza(@NonNull Context context, @NonNull Executor executor, @NonNull zzfgn zzfgn, @NonNull zzfgp zzfgp) {
        zzfhg zzfhg = new zzfhg(context, executor, zzfgn, zzfgp, new zzfhd(), new zzfhe());
        if (zzfhg.zzd.zzb()) {
            zzfhg.zzg = zzfhg.zzg(new zzfha(zzfhg));
        } else {
            zzfhg.zzg = Tasks.forResult(zzfhg.zze.zza());
        }
        zzfhg.zzh = zzfhg.zzg(new zzfhb(zzfhg));
        return zzfhg;
    }

    private final Task<zzdc> zzg(@NonNull Callable<zzdc> callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, (OnFailureListener) new zzfhc(this));
    }

    public static zzdc zzh(@NonNull Task<zzdc> task, @NonNull zzdc zzdc) {
        if (!task.isSuccessful()) {
            return zzdc;
        }
        return task.getResult();
    }

    public final zzdc zzb() {
        return zzh(this.zzg, this.zze.zza());
    }

    public final zzdc zzc() {
        return zzh(this.zzh, this.zzf.zza());
    }

    public final /* synthetic */ void zzd(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzd(2025, -1, exc);
    }

    public final /* synthetic */ zzdc zze() throws Exception {
        Context context = this.zza;
        return zzfgv.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public final /* synthetic */ zzdc zzf() throws Exception {
        Context context = this.zza;
        zzcn zzj = zzdc.zzj();
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context);
        advertisingIdClient.start();
        AdvertisingIdClient.Info info = advertisingIdClient.getInfo();
        String id = info.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zzj.zzX(id);
            zzj.zzZ(info.isLimitAdTrackingEnabled());
            zzj.zzY(zzct.DEVICE_IDENTIFIER_ANDROID_AD_ID);
        }
        return (zzdc) zzj.zzah();
    }
}
