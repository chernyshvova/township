package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zziv extends zzit {
    public static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public zziv() {
        super();
    }

    public static <E> List<E> zzc(Object obj, long j) {
        return (List) zzkz.zzf(obj, j);
    }

    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzkz.zzf(obj, j);
        if (list instanceof zziq) {
            obj2 = ((zziq) list).mo30782h_();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzjv) || !(list instanceof zzig)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzig zzig = (zzig) list;
                if (zzig.zza()) {
                    zzig.mo30511i_();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzkz.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.measurement.zzir} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.measurement.zzir} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.measurement.zzir} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <L> java.util.List<L> zza(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = zzc(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zziq
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.measurement.zzir r0 = new com.google.android.gms.internal.measurement.zzir
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjv
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzig
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.measurement.zzig r0 = (com.google.android.gms.internal.measurement.zzig) r0
            com.google.android.gms.internal.measurement.zzig r6 = r0.zza(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            goto L_0x007f
        L_0x002d:
            java.lang.Class<?> r1 = zza
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
        L_0x0049:
            r0 = r1
            goto L_0x007f
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzku
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.measurement.zzir r1 = new com.google.android.gms.internal.measurement.zzir
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.measurement.zzku r0 = (com.google.android.gms.internal.measurement.zzku) r0
            r1.addAll(r0)
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            goto L_0x0049
        L_0x0062:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjv
            if (r1 == 0) goto L_0x007f
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzig
            if (r1 == 0) goto L_0x007f
            r1 = r0
            com.google.android.gms.internal.measurement.zzig r1 = (com.google.android.gms.internal.measurement.zzig) r1
            boolean r2 = r1.zza()
            if (r2 != 0) goto L_0x007f
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.measurement.zzig r0 = r1.zza(r0)
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zziv.zza(java.lang.Object, long, int):java.util.List");
    }

    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzkz.zza(obj, j, (Object) zzc);
    }
}
