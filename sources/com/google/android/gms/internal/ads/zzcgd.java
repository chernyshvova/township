package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcgd {
    public final Object zza = new Object();
    public final zzj zzb = new zzj();
    public final zzcgh zzc = new zzcgh(zzbev.zzc(), this.zzb);
    public boolean zzd = false;
    public Context zze;
    public zzcgy zzf;
    @Nullable
    public zzbjs zzg = null;
    @Nullable
    public Boolean zzh = null;
    public final AtomicInteger zzi = new AtomicInteger(0);
    public final zzcgc zzj = new zzcgc((zzcgb) null);
    public final Object zzk = new Object();
    @GuardedBy("grantedPermissionLock")
    public zzfqn<ArrayList<String>> zzl;

    @Nullable
    public final zzbjs zza() {
        zzbjs zzbjs;
        synchronized (this.zza) {
            zzbjs = this.zzg;
        }
        return zzbjs;
    }

    public final void zzb(Boolean bool) {
        synchronized (this.zza) {
            this.zzh = bool;
        }
    }

    public final Boolean zzc() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzh;
        }
        return bool;
    }

    public final void zzd() {
        this.zzj.zza();
    }

    @TargetApi(23)
    public final void zze(Context context, zzcgy zzcgy) {
        zzbjs zzbjs;
        synchronized (this.zza) {
            if (!this.zzd) {
                this.zze = context.getApplicationContext();
                this.zzf = zzcgy;
                zzs.zzf().zzb(this.zzc);
                this.zzb.zza(this.zze);
                zzcas.zzb(this.zze, this.zzf);
                zzs.zzl();
                if (!zzbkv.zzc.zze().booleanValue()) {
                    zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzbjs = null;
                } else {
                    zzbjs = new zzbjs();
                }
                this.zzg = zzbjs;
                if (zzbjs != null) {
                    zzchh.zza(new zzcgb(this).zzb(), "AppState.registerCsiReporter");
                }
                this.zzd = true;
                zzn();
            }
        }
        zzs.zzc().zze(context, zzcgy.zza);
    }

    @Nullable
    public final Resources zzf() {
        if (this.zzf.zzd) {
            return this.zze.getResources();
        }
        try {
            zzcgw.zzb(this.zze).getResources();
            return null;
        } catch (zzcgv e) {
            zzcgs.zzj("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zzg(Throwable th, String str) {
        zzcas.zzb(this.zze, this.zzf).zzd(th, str);
    }

    public final void zzh(Throwable th, String str) {
        zzcas.zzb(this.zze, this.zzf).zze(th, str, zzblh.zzg.zze().floatValue());
    }

    public final void zzi() {
        this.zzi.incrementAndGet();
    }

    public final void zzj() {
        this.zzi.decrementAndGet();
    }

    public final int zzk() {
        return this.zzi.get();
    }

    public final zzg zzl() {
        zzj zzj2;
        synchronized (this.zza) {
            zzj2 = this.zzb;
        }
        return zzj2;
    }

    @Nullable
    public final Context zzm() {
        return this.zze;
    }

    public final zzfqn<ArrayList<String>> zzn() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zze != null) {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzbK)).booleanValue()) {
                synchronized (this.zzk) {
                    zzfqn<ArrayList<String>> zzfqn = this.zzl;
                    if (zzfqn != null) {
                        return zzfqn;
                    }
                    zzfqn<ArrayList<String>> zzb2 = zzche.zza.zzb(new zzcga(this));
                    this.zzl = zzb2;
                    return zzb2;
                }
            }
        }
        return zzfqe.zza(new ArrayList());
    }

    public final zzcgh zzo() {
        return this.zzc;
    }

    public final /* synthetic */ ArrayList zzp() throws Exception {
        Context zza2 = zzcby.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(zza2).getPackageInfo(zza2.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }
}
