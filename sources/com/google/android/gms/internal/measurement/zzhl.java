package com.google.android.gms.internal.measurement;

import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.internal.measurement.zzhy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class zzhl {
    public static volatile boolean zza = false;
    public static boolean zzb = true;
    public static volatile zzhl zzc;
    public static volatile zzhl zzd;
    public static final zzhl zze = new zzhl(true);
    public final Map<zza, zzhy.zzf<?, ?>> zzf;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class zza {
        public final Object zza;
        public final int zzb;

        public zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            if (this.zza == zza2.zza && this.zzb == zza2.zzb) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * SupportMenu.USER_MASK) + this.zzb;
        }
    }

    public zzhl() {
        this.zzf = new HashMap();
    }

    public static zzhl zza() {
        zzhl zzhl = zzc;
        if (zzhl == null) {
            synchronized (zzhl.class) {
                zzhl = zzc;
                if (zzhl == null) {
                    zzhl = zze;
                    zzc = zzhl;
                }
            }
        }
        return zzhl;
    }

    public static zzhl zzb() {
        Class<zzhl> cls = zzhl.class;
        zzhl zzhl = zzd;
        if (zzhl != null) {
            return zzhl;
        }
        synchronized (cls) {
            zzhl zzhl2 = zzd;
            if (zzhl2 != null) {
                return zzhl2;
            }
            zzhl zza2 = zzhw.zza(cls);
            zzd = zza2;
            return zza2;
        }
    }

    public zzhl(boolean z) {
        this.zzf = Collections.emptyMap();
    }

    public final <ContainingType extends zzjj> zzhy.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzf.get(new zza(containingtype, i));
    }
}
