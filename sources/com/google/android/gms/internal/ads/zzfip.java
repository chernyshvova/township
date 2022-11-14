package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.unity3d.ads.BuildConfig;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfip {
    public static final HashMap<String, Class<?>> zza = new HashMap<>();
    public final Context zzb;
    public final zzfiq zzc;
    public final zzfgn zzd;
    public final zzfgj zze;
    @Nullable
    public zzfie zzf;
    public final Object zzg = new Object();

    public zzfip(@NonNull Context context, @NonNull zzfiq zzfiq, @NonNull zzfgn zzfgn, @NonNull zzfgj zzfgj) {
        this.zzb = context;
        this.zzc = zzfiq;
        this.zzd = zzfgn;
        this.zze = zzfgj;
    }

    private final synchronized Class<?> zzd(@NonNull zzfif zzfif) throws zzfio {
        String zza2 = zzfif.zza().zza();
        Class<?> cls = zza.get(zza2);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzfif.zzb())) {
                File zzc2 = zzfif.zzc();
                if (!zzc2.exists()) {
                    zzc2.mkdirs();
                }
                Class<?> loadClass = new DexClassLoader(zzfif.zzb().getAbsolutePath(), zzc2.getAbsolutePath(), (String) null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                zza.put(zza2, loadClass);
                return loadClass;
            }
            throw new zzfio(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e) {
            throw new zzfio(2026, (Throwable) e);
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
            throw new zzfio((int) AdError.REMOTE_ADS_SERVICE_ERROR, e2);
        }
    }

    public final boolean zza(@NonNull zzfif zzfif) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class<?> zzd2 = zzd(zzfif);
            zzfie zzfie = new zzfie(zzd2.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzb, "msa-r", zzfif.zzd(), null, new Bundle(), 2}), zzfif, this.zzc, this.zzd);
            if (zzfie.zzf()) {
                int zzh = zzfie.zzh();
                if (zzh == 0) {
                    synchronized (this.zzg) {
                        zzfie zzfie2 = this.zzf;
                        if (zzfie2 != null) {
                            try {
                                zzfie2.zzg();
                            } catch (zzfio e) {
                                this.zzd.zzd(e.zza(), -1, e);
                            }
                        }
                        this.zzf = zzfie;
                    }
                    this.zzd.zzc(3000, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzh);
                throw new zzfio(4001, sb.toString());
            }
            throw new zzfio(4000, "init failed");
        } catch (Exception e2) {
            throw new zzfio((int) AdError.INTERNAL_ERROR_2004, (Throwable) e2);
        } catch (zzfio e3) {
            this.zzd.zzd(e3.zza(), System.currentTimeMillis() - currentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzd(BuildConfig.VERSION_CODE, System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        }
    }

    @Nullable
    public final zzfgq zzb() {
        zzfie zzfie;
        synchronized (this.zzg) {
            zzfie = this.zzf;
        }
        return zzfie;
    }

    @Nullable
    public final zzfif zzc() {
        synchronized (this.zzg) {
            zzfie zzfie = this.zzf;
            if (zzfie == null) {
                return null;
            }
            zzfif zze2 = zzfie.zze();
            return zze2;
        }
    }
}
