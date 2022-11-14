package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzhf {
    public static final String zza = "zzhf";
    public final zzfy zzb;
    public final String zzc;
    public final String zzd;
    public volatile Method zze = null;
    public final Class<?>[] zzf;
    public final CountDownLatch zzg = new CountDownLatch(1);

    public zzhf(zzfy zzfy, String str, String str2, Class<?>... clsArr) {
        this.zzb = zzfy;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        zzfy.zzd().submit(new zzhe(this));
    }

    public static /* synthetic */ void zzb(zzhf zzhf) {
        CountDownLatch countDownLatch;
        try {
            Class loadClass = zzhf.zzb.zze().loadClass(zzhf.zzc(zzhf.zzb.zzg(), zzhf.zzc));
            if (loadClass == null) {
                countDownLatch = zzhf.zzg;
            } else {
                zzhf.zze = loadClass.getMethod(zzhf.zzc(zzhf.zzb.zzg(), zzhf.zzd), zzhf.zzf);
                if (zzhf.zze == null) {
                    countDownLatch = zzhf.zzg;
                }
                countDownLatch = zzhf.zzg;
            }
        } catch (zzfd | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException unused) {
        } catch (NullPointerException unused2) {
            countDownLatch = zzhf.zzg;
        } catch (Throwable th) {
            zzhf.zzg.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzfd, UnsupportedEncodingException {
        return new String(this.zzb.zzf().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (!this.zzg.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zze;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
