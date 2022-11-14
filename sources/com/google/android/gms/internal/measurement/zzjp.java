package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjp<T> implements zzkb<T> {
    public final zzjj zza;
    public final zzkt<?, ?> zzb;
    public final boolean zzc;
    public final zzhn<?> zzd;

    public zzjp(zzkt<?, ?> zzkt, zzhn<?> zzhn, zzjj zzjj) {
        this.zzb = zzkt;
        this.zzc = zzhn.zza(zzjj);
        this.zzd = zzhn;
        this.zza = zzjj;
    }

    public static <T> zzjp<T> zza(zzkt<?, ?> zzkt, zzhn<?> zzhn, zzjj zzjj) {
        return new zzjp<>(zzkt, zzhn, zzjj);
    }

    public final void zzb(T t, T t2) {
        zzkd.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzkd.zza(this.zzd, t, t2);
        }
    }

    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    public final T zza() {
        return this.zza.zzbu().zzx();
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zzb(T t) {
        zzkt<?, ?> zzkt = this.zzb;
        int zze = zzkt.zze(zzkt.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    public final void zza(T t, zzlm zzlm) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzht zzht = (zzht) next.getKey();
            if (zzht.zzc() != zzln.MESSAGE || zzht.zzd() || zzht.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzim) {
                zzlm.zza(zzht.zza(), (Object) ((zzim) next).zza().zzc());
            } else {
                zzlm.zza(zzht.zza(), next.getValue());
            }
        }
        zzkt<?, ?> zzkt = this.zzb;
        zzkt.zzb(zzkt.zzb(t), zzlm);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzhy$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzgo r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzhy r0 = (com.google.android.gms.internal.measurement.zzhy) r0
            com.google.android.gms.internal.measurement.zzks r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzks r2 = com.google.android.gms.internal.measurement.zzks.zza()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzks r1 = com.google.android.gms.internal.measurement.zzks.zzb()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzhy$zzd r10 = (com.google.android.gms.internal.measurement.zzhy.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.measurement.zzhn<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzhl r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzjj r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzhy$zzf r0 = (com.google.android.gms.internal.measurement.zzhy.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzgl.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzks) r6, (com.google.android.gms.internal.measurement.zzgo) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.measurement.zzjx.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.measurement.zzgl.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgo) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzgl.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzgp r2 = (com.google.android.gms.internal.measurement.zzgp) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.measurement.zzjx.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzhn<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzhl r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzjj r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzhy$zzf r0 = (com.google.android.gms.internal.measurement.zzhy.zzf) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgo) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza((int) r12, (java.lang.Object) r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.measurement.zzij r10 = com.google.android.gms.internal.measurement.zzij.zzg()
            goto L_0x00ad
        L_0x00ac:
            throw r10
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjp.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgo):void");
    }

    public final void zza(T t, zzjy zzjy, zzhl zzhl) throws IOException {
        boolean z;
        zzkt<?, ?> zzkt = this.zzb;
        zzhn<?> zzhn = this.zzd;
        Object zzc2 = zzkt.zzc(t);
        zzhr<?> zzb2 = zzhn.zzb(t);
        do {
            try {
                if (zzjy.zza() == Integer.MAX_VALUE) {
                    zzkt.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzjy.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgp zzgp = null;
                    while (zzjy.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzjy.zzb();
                        if (zzb4 == 16) {
                            i = zzjy.zzo();
                            obj = zzhn.zza(zzhl, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzhn.zza(zzjy, obj, zzhl, zzb2);
                            } else {
                                zzgp = zzjy.zzn();
                            }
                        } else if (!zzjy.zzc()) {
                            break;
                        }
                    }
                    if (zzjy.zzb() != 12) {
                        throw zzij.zze();
                    } else if (zzgp != null) {
                        if (obj != null) {
                            zzhn.zza(zzgp, obj, zzhl, zzb2);
                        } else {
                            zzkt.zza(zzc2, i, zzgp);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzhn.zza(zzhl, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzhn.zza(zzjy, zza2, zzhl, zzb2);
                    } else {
                        z = zzkt.zza(zzc2, zzjy);
                        continue;
                    }
                } else {
                    z = zzjy.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzkt.zzb((Object) t, zzc2);
            }
        } while (z);
    }
}
