package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.swrve.sdk.rest.RESTClient;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzeq extends zzgq {
    public char zza = 0;
    public long zzb = -1;
    @GuardedBy("this")
    public String zzc;
    public final zzes zzd = new zzes(this, 6, false, false);
    public final zzes zze = new zzes(this, 6, true, false);
    public final zzes zzf = new zzes(this, 6, false, true);
    public final zzes zzg = new zzes(this, 5, false, false);
    public final zzes zzh = new zzes(this, 5, true, false);
    public final zzes zzi = new zzes(this, 5, false, true);
    public final zzes zzj = new zzes(this, 4, false, false);
    public final zzes zzk = new zzes(this, 3, false, false);
    public final zzes zzl = new zzes(this, 2, false, false);

    public zzeq(zzfu zzfu) {
        super(zzfu);
    }

    public static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzev(str);
    }

    public static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    @VisibleForTesting
    private final String zzy() {
        String str;
        synchronized (this) {
            if (this.zzc == null) {
                this.zzc = this.zzy.zzr() != null ? this.zzy.zzr() : "FA";
            }
            str = this.zzc;
        }
        return str;
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final boolean zzd() {
        return false;
    }

    public final zzes zze() {
        return this.zzd;
    }

    public final zzes zzf() {
        return this.zze;
    }

    public final zzes zzg() {
        return this.zzf;
    }

    public final zzes zzh() {
        return this.zzg;
    }

    public final zzes zzi() {
        return this.zzh;
    }

    public final zzes zzj() {
        return this.zzi;
    }

    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    public final zzes zzu() {
        return this.zzj;
    }

    public final zzes zzv() {
        return this.zzk;
    }

    public final zzes zzw() {
        return this.zzl;
    }

    public final String zzx() {
        Pair<String, Long> zza2 = zzr().zzb.zza();
        if (zza2 == null || zza2 == zzfc.zza) {
            return null;
        }
        String valueOf = String.valueOf(zza2.second);
        String str = (String) zza2.first;
        return GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(str, valueOf.length() + 1), valueOf, CertificateUtil.DELIMITER, str);
    }

    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zza(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzfr zzf2 = this.zzy.zzf();
            if (zzf2 == null) {
                zza(6, "Scheduler not set. Not logging error/warn");
            } else if (!zzf2.zzaa()) {
                zza(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i < 0) {
                    i = 0;
                }
                zzf2.zza((Runnable) new zzet(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @VisibleForTesting
    public final boolean zza(int i) {
        return Log.isLoggable(zzy(), i);
    }

    @VisibleForTesting
    public final void zza(int i, String str) {
        Log.println(i, zzy(), str);
    }

    public static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String zza2 = zza(z, obj);
        String zza3 = zza(z, obj2);
        String zza4 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        boolean isEmpty = TextUtils.isEmpty(zza2);
        String str3 = RESTClient.COMMA_SEPARATOR;
        if (!isEmpty) {
            sb.append(str2);
            sb.append(zza2);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zza3)) {
            sb.append(str2);
            sb.append(zza3);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zza4)) {
            sb.append(str3);
            sb.append(zza4);
        }
        return sb.toString();
    }

    @VisibleForTesting
    public static String zza(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + str.length() + 43);
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzb2 = zzb(zzfu.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(zzb2)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i++;
                }
                return sb2.toString();
            } else if (obj instanceof zzev) {
                return ((zzev) obj).zza;
            } else {
                if (z) {
                    return "-";
                }
                return String.valueOf(obj);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
