package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.swrve.sdk.ISwrveCommon;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgj extends zzhg {
    public static final zzhh<zzdy> zzi = new zzhh<>();
    public final Context zzj;

    public zzgj(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2, Context context, zzce zzce) {
        super(zzfy, "1EA+kmHznPumSxbhAp5gNBZCuE/8gd/8nXHr3+4N+BC7/aHUweFYbF77Za3km6PL", "n+EIVanZgVE5bWZK/bmUeAKMrsDwbmyGU+LX/MkMxZ0=", zzcn, i, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzn() != null) {
                this.zzb.zzn().get();
            }
            zzdc zzm = this.zzb.zzm();
            if (zzm == null || !zzm.zza()) {
                return null;
            }
            return zzm.zzc();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzdy zzdy;
        zzcj zzcj;
        Boolean bool;
        AtomicReference<zzdy> zza = zzi.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzdy zzdy2 = zza.get();
            if (zzdy2 == null || zzgb.zze(zzdy2.zza) || zzdy2.zza.equals("E") || zzdy2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (!zzgb.zze((String) null)) {
                    zzcj = zzcj.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
                } else {
                    if (!zzgb.zze((String) null)) {
                        bool = Boolean.FALSE;
                    } else {
                        bool = Boolean.FALSE;
                    }
                    if (!bool.booleanValue() || !this.zzb.zzj()) {
                        zzcj = zzcj.ENUM_SIGNAL_SOURCE_ADSHIELD;
                    } else {
                        zzcj = zzcj.ENUM_SIGNAL_SOURCE_GASS;
                    }
                }
                Boolean valueOf = Boolean.valueOf(zzcj == zzcj.ENUM_SIGNAL_SOURCE_ADSHIELD);
                Boolean bool2 = (Boolean) zzbex.zzc().zzb(zzbjn.zzby);
                String zzb = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbx)).booleanValue() ? zzb() : null;
                if (bool2.booleanValue() && this.zzb.zzj() && zzgb.zze(zzb)) {
                    zzb = zzc();
                }
                zzdy zzdy3 = new zzdy((String) this.zzf.invoke((Object) null, new Object[]{this.zzj, valueOf, zzb}));
                if (zzgb.zze(zzdy3.zza) || zzdy3.zza.equals("E")) {
                    int ordinal = zzcj.ordinal();
                    if (ordinal == 3) {
                        String zzc = zzc();
                        if (!zzgb.zze(zzc)) {
                            zzdy3.zza = zzc;
                        }
                    } else if (ordinal == 4) {
                        throw null;
                    }
                }
                zza.set(zzdy3);
            }
            zzdy = zza.get();
        }
        synchronized (this.zze) {
            if (zzdy != null) {
                this.zze.zzo(zzdy.zza);
                this.zze.zzu(zzdy.zzb);
                this.zze.zzt(zzdy.zzc);
                this.zze.zzD(zzdy.zzd);
                this.zze.zzE(zzdy.zze);
            }
        }
    }

    public final String zzb() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byte[] zzc = zzgb.zzc((String) zzbex.zzc().zzb(zzbjn.zzbz));
            ArrayList arrayList = new ArrayList();
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzc)));
            if (!Build.TYPE.equals(ISwrveCommon.BATCH_EVENT_KEY_USER)) {
                arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzgb.zzc((String) zzbex.zzc().zzb(zzbjn.zzbA)))));
            }
            Context context = this.zzj;
            return zzhj.zza(context, context.getPackageName(), arrayList, this.zzb.zzd());
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
