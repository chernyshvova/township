package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeqe implements zzeqp<zzeqf> {
    public final zzfqo zza;
    public final Context zzb;
    public final zzcgy zzc;

    public zzeqe(zzfqo zzfqo, Context context, zzcgy zzcgy) {
        this.zza = zzfqo;
        this.zzb = context;
        this.zzc = zzcgy;
    }

    public final zzfqn<zzeqf> zza() {
        return this.zza.zzb(new zzeqd(this));
    }

    public final /* synthetic */ zzeqf zzb() throws Exception {
        int i;
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzb).isCallerInstantApp();
        zzs.zzc();
        boolean zzH = zzr.zzH(this.zzb);
        String str = this.zzc.zza;
        zzs.zze();
        boolean zzu = zzac.zzu();
        zzs.zzc();
        ApplicationInfo applicationInfo = this.zzb.getApplicationInfo();
        if (applicationInfo == null) {
            i = 0;
        } else {
            i = applicationInfo.targetSdkVersion;
        }
        return new zzeqf(isCallerInstantApp, zzH, str, zzu, i, DynamiteModule.getRemoteVersion(this.zzb, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.zzb, ModuleDescriptor.MODULE_ID));
    }
}
