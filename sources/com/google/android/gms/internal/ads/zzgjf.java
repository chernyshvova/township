package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgjf<T> implements zzgju, zzgja {
    public static final Object zza = new Object();
    public volatile zzgju<T> zzb;
    public volatile Object zzc = zza;

    public zzgjf(zzgju<T> zzgju) {
        this.zzb = zzgju;
    }

    public static <P extends zzgju<T>, T> zzgju<T> zza(P p) {
        if (p == null) {
            throw null;
        } else if (p instanceof zzgjf) {
            return p;
        } else {
            return new zzgjf(p);
        }
    }

    public static <P extends zzgju<T>, T> zzgja<T> zzc(P p) {
        if (p instanceof zzgja) {
            return (zzgja) p;
        }
        if (p != null) {
            return new zzgjf(p);
        }
        throw null;
    }

    public final T zzb() {
        T t = this.zzc;
        if (t == zza) {
            synchronized (this) {
                t = this.zzc;
                if (t == zza) {
                    t = this.zzb.zzb();
                    T t2 = this.zzc;
                    if (t2 != zza && !(t2 instanceof zzgjo)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 118 + valueOf2.length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzc = t;
                    this.zzb = null;
                }
            }
        }
        return t;
    }
}
