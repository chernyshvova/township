package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.swrve.sdk.SwrveImp;
import com.swrve.sdk.rest.RESTClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzeo extends zzgq {
    public static final AtomicReference<String[]> zza = new AtomicReference<>();
    public static final AtomicReference<String[]> zzb = new AtomicReference<>();
    public static final AtomicReference<String[]> zzc = new AtomicReference<>();

    public zzeo(zzfu zzfu) {
        super(zzfu);
    }

    private final boolean zzf() {
        return this.zzy.zzk() && this.zzy.zzq().zza(3);
    }

    @Nullable
    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        if (!zzf()) {
            return str;
        }
        return zza(str, zzgv.zzc, zzgv.zza, zza);
    }

    @Nullable
    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        if (!zzf()) {
            return str;
        }
        return zza(str, zzgu.zzb, zzgu.zza, zzb);
    }

    @Nullable
    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!zzf()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, zzgx.zzb, zzgx.zza, zzc);
        }
        return "experiment_id" + "(" + str + ")";
    }

    public final boolean zzd() {
        return false;
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

    @Nullable
    public static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzkv.zzc(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Nullable
    public final String zza(zzaq zzaq) {
        String str = null;
        if (zzaq == null) {
            return null;
        }
        if (!zzf()) {
            return zzaq.toString();
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("origin=");
        outline24.append(zzaq.zzc);
        outline24.append(",name=");
        outline24.append(zza(zzaq.zza));
        outline24.append(",params=");
        zzap zzap = zzaq.zzb;
        if (zzap != null) {
            if (!zzf()) {
                str = zzap.toString();
            } else {
                str = zza(zzap.zzb());
            }
        }
        outline24.append(str);
        return outline24.toString();
    }

    @Nullable
    public final String zza(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!zzf()) {
            return bundle.toString();
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Bundle[{");
        for (String str2 : bundle.keySet()) {
            if (outline24.length() != 8) {
                outline24.append(RESTClient.COMMA_SEPARATOR);
            }
            outline24.append(zzb(str2));
            outline24.append("=");
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                str = zza(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = zza((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = zza(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            outline24.append(str);
        }
        outline24.append("}]");
        return outline24.toString();
    }

    @Nullable
    private final String zza(Object[] objArr) {
        String str;
        if (objArr == null) {
            return SwrveImp.EMPTY_JSON_ARRAY;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = zza(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (outline24.length() != 1) {
                    outline24.append(RESTClient.COMMA_SEPARATOR);
                }
                outline24.append(str);
            }
        }
        outline24.append("]");
        return outline24.toString();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
