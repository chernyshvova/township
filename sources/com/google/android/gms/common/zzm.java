package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzm {
    public static final zzk zza = new zze(zzi.zzf("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));
    public static final zzk zzb = new zzf(zzi.zzf("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));
    public static final zzk zzc = new zzg(zzi.zzf("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));
    public static final zzk zzd = new zzh(zzi.zzf("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));
    public static volatile zzae zze;
    public static final Object zzf = new Object();
    public static Context zzg;

    public static synchronized void zza(Context context) {
        synchronized (zzm.class) {
            if (zzg != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzg = context.getApplicationContext();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    public static zzw zzb(String str, boolean z, boolean z2, boolean z3) {
        zzw zzw;
        String str2;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzg);
            try {
                zzf();
                zzq zzf2 = zze.zzf(new zzn(str, z, false, ObjectWrapper.wrap(zzg), false));
                if (zzf2.zza()) {
                    zzw = zzw.zzb();
                } else {
                    String zzb2 = zzf2.zzb();
                    if (zzb2 == null) {
                        zzb2 = "error checking package certificate";
                    }
                    zzw = zzf2.zzc() == 4 ? zzw.zze(zzb2, new PackageManager.NameNotFoundException()) : zzw.zzd(zzb2);
                }
            } catch (DynamiteModule.LoadingException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    str2 = "module init: ".concat(valueOf);
                } else {
                    str2 = new String("module init: ");
                }
                zzw = zzw.zze(str2, e);
            }
        } catch (RemoteException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            zzw = zzw.zze("module call", e2);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return zzw;
    }

    public static zzw zzc(String str, zzi zzi, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzg(str, zzi, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean zzd() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            zzf();
            boolean zzg2 = zze.zzg();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zzg2;
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    public static final /* synthetic */ String zze(boolean z, String str, zzi zzi) throws Exception {
        boolean z2 = true;
        if (z || !zzg(str, zzi, true, false).zza) {
            z2 = false;
        }
        return zzw.zzg(str, zzi, z, z2);
    }

    public static void zzf() throws DynamiteModule.LoadingException {
        if (zze == null) {
            Preconditions.checkNotNull(zzg);
            synchronized (zzf) {
                if (zze == null) {
                    zze = zzad.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }

    public static zzw zzg(String str, zzi zzi, boolean z, boolean z2) {
        String str2;
        try {
            zzf();
            Preconditions.checkNotNull(zzg);
            try {
                if (zze.zze(new zzs(str, zzi, z, z2), ObjectWrapper.wrap(zzg.getPackageManager()))) {
                    return zzw.zzb();
                }
                return zzw.zzc(new zzd(z, str, zzi));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return zzw.zze("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                str2 = "module init: ".concat(valueOf);
            } else {
                str2 = new String("module init: ");
            }
            return zzw.zze(str2, e2);
        }
    }
}
