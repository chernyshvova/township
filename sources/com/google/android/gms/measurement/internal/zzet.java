package com.google.android.gms.measurement.internal;

import com.facebook.internal.security.CertificateUtil;
import com.swrve.sdk.SwrveImp;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzet implements Runnable {
    public final /* synthetic */ int zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ Object zzd;
    public final /* synthetic */ Object zze;
    public final /* synthetic */ zzeq zzf;

    public zzet(zzeq zzeq, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzeq;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzfc zzb2 = this.zzf.zzy.zzb();
        if (!zzb2.zzaa()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zzs().zze()) {
                char unused = this.zzf.zza = 'C';
            } else {
                char unused2 = this.zzf.zza = 'c';
            }
        }
        if (this.zzf.zzb < 0) {
            long unused3 = this.zzf.zzb = 33025;
        }
        char charAt = "01VDIWEA?".charAt(this.zza);
        char zza2 = this.zzf.zza;
        long zzb3 = this.zzf.zzb;
        String zza3 = zzeq.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(zza3).length() + 24);
        sb.append(SwrveImp.CAMPAIGN_RESPONSE_VERSION);
        sb.append(charAt);
        sb.append(zza2);
        sb.append(zzb3);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(zza3);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.zzb.substring(0, 1024);
        }
        zzb2.zzb.zza(sb2, 1);
    }
}
