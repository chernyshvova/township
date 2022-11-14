package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbrl implements zzv {
    public volatile zzbqy zza;
    public final Context zzb;

    public zzbrl(Context context) {
        this.zzb = context;
    }

    public static /* synthetic */ void zzb(zzbrl zzbrl) {
        if (zzbrl.zza != null) {
            zzbrl.zza.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzy zza(zzac<?> zzac) throws zzal {
        Parcelable.Creator<zzbqz> creator = zzbqz.CREATOR;
        Map<String, String> zzm = zzac.zzm();
        int size = zzm.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry next : zzm.entrySet()) {
            strArr[i2] = (String) next.getKey();
            strArr2[i2] = (String) next.getValue();
            i2++;
        }
        zzbqz zzbqz = new zzbqz(zzac.zzh(), strArr, strArr2);
        long elapsedRealtime = zzs.zzj().elapsedRealtime();
        try {
            zzchj zzchj = new zzchj();
            this.zza = new zzbqy(this.zzb, zzs.zzq().zza(), new zzbrj(this, zzchj), new zzbrk(this, zzchj));
            this.zza.checkAvailabilityAndConnect();
            zzfqn zzh = zzfqe.zzh(zzfqe.zzi(zzchj, new zzbrh(this, zzbqz), zzche.zza), (long) ((Integer) zzbex.zzc().zzb(zzbjn.zzcM)).intValue(), TimeUnit.MILLISECONDS, zzche.zzd);
            zzh.zze(new zzbri(this), zzche.zza);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzh.get();
            long elapsedRealtime2 = zzs.zzj().elapsedRealtime();
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2 - elapsedRealtime);
            sb.append("ms");
            zze.zza(sb.toString());
            zzbrb zzbrb = (zzbrb) new zzcbi(parcelFileDescriptor).zza(zzbrb.CREATOR);
            if (zzbrb == null) {
                return null;
            }
            if (zzbrb.zza) {
                throw new zzal(zzbrb.zzb);
            } else if (zzbrb.zze.length != zzbrb.zzf.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzbrb.zze;
                    if (i >= strArr3.length) {
                        return new zzy(zzbrb.zzc, zzbrb.zzd, (Map<String, String>) hashMap, zzbrb.zzg, zzbrb.zzh);
                    }
                    hashMap.put(strArr3[i], zzbrb.zzf[i]);
                    i++;
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
            long elapsedRealtime3 = zzs.zzj().elapsedRealtime();
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(elapsedRealtime3 - elapsedRealtime);
            sb2.append("ms");
            zze.zza(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime4 = zzs.zzj().elapsedRealtime();
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime4 - elapsedRealtime);
            sb3.append("ms");
            zze.zza(sb3.toString());
            throw th;
        }
    }
}
