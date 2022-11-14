package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbv;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzx extends zzu {
    public zzbv.zze zzg;
    public final /* synthetic */ zzr zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzx(zzr zzr, String str, int i, zzbv.zze zze) {
        super(str, i);
        this.zzh = zzr;
        this.zzg = zze;
    }

    public final int zza() {
        return this.zzg.zzb();
    }

    public final boolean zzb() {
        return true;
    }

    public final boolean zzc() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v17, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.Long r11, java.lang.Long r12, com.google.android.gms.internal.measurement.zzcd.zzk r13, boolean r14) {
        /*
            r10 = this;
            boolean r0 = com.google.android.gms.internal.measurement.zzmx.zzb()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.measurement.internal.zzr r0 = r10.zzh
            com.google.android.gms.measurement.internal.zzab r0 = r0.zzs()
            java.lang.String r3 = r10.zza
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzas.zzaz
            boolean r0 = r0.zzd(r3, r4)
            if (r0 == 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            com.google.android.gms.internal.measurement.zzbv$zze r3 = r10.zzg
            boolean r3 = r3.zze()
            com.google.android.gms.internal.measurement.zzbv$zze r4 = r10.zzg
            boolean r4 = r4.zzf()
            com.google.android.gms.internal.measurement.zzbv$zze r5 = r10.zzg
            boolean r5 = r5.zzh()
            if (r3 != 0) goto L_0x0036
            if (r4 != 0) goto L_0x0036
            if (r5 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r3 = 0
            goto L_0x0037
        L_0x0036:
            r3 = 1
        L_0x0037:
            r4 = 0
            if (r14 == 0) goto L_0x0064
            if (r3 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.zzr r11 = r10.zzh
            com.google.android.gms.measurement.internal.zzeq r11 = r11.zzq()
            com.google.android.gms.measurement.internal.zzes r11 = r11.zzw()
            int r12 = r10.zzb
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.google.android.gms.internal.measurement.zzbv$zze r13 = r10.zzg
            boolean r13 = r13.zza()
            if (r13 == 0) goto L_0x005e
            com.google.android.gms.internal.measurement.zzbv$zze r13 = r10.zzg
            int r13 = r13.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
        L_0x005e:
            java.lang.String r13 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r11.zza(r13, r12, r4)
            return r2
        L_0x0064:
            com.google.android.gms.internal.measurement.zzbv$zze r6 = r10.zzg
            com.google.android.gms.internal.measurement.zzbv$zzc r6 = r6.zzd()
            boolean r7 = r6.zzf()
            boolean r8 = r13.zzf()
            if (r8 == 0) goto L_0x00ab
            boolean r8 = r6.zzc()
            if (r8 != 0) goto L_0x0099
            com.google.android.gms.measurement.internal.zzr r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzeq r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzh()
            com.google.android.gms.measurement.internal.zzr r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "No number filter for long property. property"
            r6.zza(r8, r7)
            goto L_0x0189
        L_0x0099:
            long r8 = r13.zzg()
            com.google.android.gms.internal.measurement.zzbv$zzd r4 = r6.zzd()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.zzu.zza((long) r8, (com.google.android.gms.internal.measurement.zzbv.zzd) r4)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.zzu.zza((java.lang.Boolean) r4, (boolean) r7)
            goto L_0x0189
        L_0x00ab:
            boolean r8 = r13.zzh()
            if (r8 == 0) goto L_0x00e8
            boolean r8 = r6.zzc()
            if (r8 != 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.zzr r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzeq r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzh()
            com.google.android.gms.measurement.internal.zzr r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "No number filter for double property. property"
            r6.zza(r8, r7)
            goto L_0x0189
        L_0x00d6:
            double r8 = r13.zzi()
            com.google.android.gms.internal.measurement.zzbv$zzd r4 = r6.zzd()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.zzu.zza((double) r8, (com.google.android.gms.internal.measurement.zzbv.zzd) r4)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.zzu.zza((java.lang.Boolean) r4, (boolean) r7)
            goto L_0x0189
        L_0x00e8:
            boolean r8 = r13.zzd()
            if (r8 == 0) goto L_0x016c
            boolean r8 = r6.zza()
            if (r8 != 0) goto L_0x0155
            boolean r8 = r6.zzc()
            if (r8 != 0) goto L_0x0118
            com.google.android.gms.measurement.internal.zzr r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzeq r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzh()
            com.google.android.gms.measurement.internal.zzr r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            r6.zza(r8, r7)
            goto L_0x0189
        L_0x0118:
            java.lang.String r8 = r13.zze()
            boolean r8 = com.google.android.gms.measurement.internal.zzkr.zza((java.lang.String) r8)
            if (r8 == 0) goto L_0x0133
            java.lang.String r4 = r13.zze()
            com.google.android.gms.internal.measurement.zzbv$zzd r6 = r6.zzd()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.zzu.zza((java.lang.String) r4, (com.google.android.gms.internal.measurement.zzbv.zzd) r6)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.zzu.zza((java.lang.Boolean) r4, (boolean) r7)
            goto L_0x0189
        L_0x0133:
            com.google.android.gms.measurement.internal.zzr r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzeq r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzh()
            com.google.android.gms.measurement.internal.zzr r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = r13.zze()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.zza(r9, r7, r8)
            goto L_0x0189
        L_0x0155:
            java.lang.String r4 = r13.zze()
            com.google.android.gms.internal.measurement.zzbv$zzf r6 = r6.zzb()
            com.google.android.gms.measurement.internal.zzr r8 = r10.zzh
            com.google.android.gms.measurement.internal.zzeq r8 = r8.zzq()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.zzu.zza((java.lang.String) r4, (com.google.android.gms.internal.measurement.zzbv.zzf) r6, (com.google.android.gms.measurement.internal.zzeq) r8)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.zzu.zza((java.lang.Boolean) r4, (boolean) r7)
            goto L_0x0189
        L_0x016c:
            com.google.android.gms.measurement.internal.zzr r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzeq r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzh()
            com.google.android.gms.measurement.internal.zzr r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "User property has no value, property"
            r6.zza(r8, r7)
        L_0x0189:
            com.google.android.gms.measurement.internal.zzr r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzeq r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzw()
            if (r4 != 0) goto L_0x0198
            java.lang.String r7 = "null"
            goto L_0x0199
        L_0x0198:
            r7 = r4
        L_0x0199:
            java.lang.String r8 = "Property filter result"
            r6.zza(r8, r7)
            if (r4 != 0) goto L_0x01a1
            return r1
        L_0x01a1:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r10.zzc = r1
            if (r5 == 0) goto L_0x01ae
            boolean r1 = r4.booleanValue()
            if (r1 != 0) goto L_0x01ae
            return r2
        L_0x01ae:
            if (r14 == 0) goto L_0x01b8
            com.google.android.gms.internal.measurement.zzbv$zze r14 = r10.zzg
            boolean r14 = r14.zze()
            if (r14 == 0) goto L_0x01ba
        L_0x01b8:
            r10.zzd = r4
        L_0x01ba:
            boolean r14 = r4.booleanValue()
            if (r14 == 0) goto L_0x01ff
            if (r3 == 0) goto L_0x01ff
            boolean r14 = r13.zza()
            if (r14 == 0) goto L_0x01ff
            long r13 = r13.zzb()
            if (r11 == 0) goto L_0x01d2
            long r13 = r11.longValue()
        L_0x01d2:
            if (r0 == 0) goto L_0x01ea
            com.google.android.gms.internal.measurement.zzbv$zze r11 = r10.zzg
            boolean r11 = r11.zze()
            if (r11 == 0) goto L_0x01ea
            com.google.android.gms.internal.measurement.zzbv$zze r11 = r10.zzg
            boolean r11 = r11.zzf()
            if (r11 != 0) goto L_0x01ea
            if (r12 == 0) goto L_0x01ea
            long r13 = r12.longValue()
        L_0x01ea:
            com.google.android.gms.internal.measurement.zzbv$zze r11 = r10.zzg
            boolean r11 = r11.zzf()
            if (r11 == 0) goto L_0x01f9
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.zzf = r11
            goto L_0x01ff
        L_0x01f9:
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.zze = r11
        L_0x01ff:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzcd$zzk, boolean):boolean");
    }
}
