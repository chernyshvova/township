package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzehf<AdT> implements zzfpl<zzeyq, AdT> {
    public final zzfcx zza;
    public final zzdbf zzb;
    public final zzfdw zzc;
    public final zzfdz zzd;
    public final Executor zze;
    public final ScheduledExecutorService zzf;
    public final zzcxl<AdT> zzg;
    public final zzeha zzh;
    public final zzeds zzi;

    public zzehf(zzfcx zzfcx, zzeha zzeha, zzdbf zzdbf, zzfdw zzfdw, zzfdz zzfdz, zzcxl<AdT> zzcxl, Executor executor, ScheduledExecutorService scheduledExecutorService, zzeds zzeds) {
        this.zza = zzfcx;
        this.zzh = zzeha;
        this.zzb = zzdbf;
        this.zzc = zzfdw;
        this.zzd = zzfdz;
        this.zzg = zzcxl;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzeds;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.ads.zzfqn zza(java.lang.Object r9) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzeyq r9 = (com.google.android.gms.internal.ads.zzeyq) r9
            com.google.android.gms.internal.ads.zzeyp r0 = r9.zzb
            com.google.android.gms.internal.ads.zzeyh r0 = r0.zzb
            int r0 = r0.zze
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 300(0x12c, float:4.2E-43)
            if (r0 == 0) goto L_0x0039
            if (r0 < r1) goto L_0x0027
            if (r0 >= r2) goto L_0x0027
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzdM
            com.google.android.gms.internal.ads.zzbjl r3 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r3.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0039
            java.lang.String r0 = "No fill."
            goto L_0x003b
        L_0x0027:
            if (r0 < r2) goto L_0x0030
            r3 = 400(0x190, float:5.6E-43)
            if (r0 >= r3) goto L_0x0030
            java.lang.String r0 = "No location header to follow redirect or too many redirects."
            goto L_0x003b
        L_0x0030:
            r3 = 46
            java.lang.String r4 = "Received error HTTP response code: "
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r3, r4, r0)
            goto L_0x003b
        L_0x0039:
            java.lang.String r0 = "No ad config."
        L_0x003b:
            com.google.android.gms.internal.ads.zzeyp r3 = r9.zzb
            com.google.android.gms.internal.ads.zzeyh r3 = r3.zzb
            com.google.android.gms.internal.ads.zzeyg r3 = r3.zzi
            if (r3 == 0) goto L_0x0047
            java.lang.String r0 = r3.zza()
        L_0x0047:
            com.google.android.gms.internal.ads.zzeds r3 = r8.zzi
            com.google.android.gms.internal.ads.zzeyp r4 = r9.zzb
            com.google.android.gms.internal.ads.zzeyh r4 = r4.zzb
            r3.zza(r4)
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzbjn.zzfI
            com.google.android.gms.internal.ads.zzbjl r4 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = 3
            if (r3 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzeyp r3 = r9.zzb
            com.google.android.gms.internal.ads.zzeyh r3 = r3.zzb
            int r3 = r3.zze
            if (r3 == 0) goto L_0x007a
            if (r3 < r1) goto L_0x006f
            if (r3 < r2) goto L_0x007a
        L_0x006f:
            com.google.android.gms.internal.ads.zzehd r9 = new com.google.android.gms.internal.ads.zzehd
            r9.<init>(r4, r0)
            com.google.android.gms.internal.ads.zzfqn r9 = com.google.android.gms.internal.ads.zzfqe.zzc(r9)
            goto L_0x0174
        L_0x007a:
            com.google.android.gms.internal.ads.zzfcx r1 = r8.zza
            com.google.android.gms.internal.ads.zzfcr r2 = com.google.android.gms.internal.ads.zzfcr.RENDER_CONFIG_INIT
            com.google.android.gms.internal.ads.zzehd r3 = new com.google.android.gms.internal.ads.zzehd
            r3.<init>(r4, r0)
            com.google.android.gms.internal.ads.zzfqn r0 = com.google.android.gms.internal.ads.zzfqe.zzc(r3)
            com.google.android.gms.internal.ads.zzfco r0 = com.google.android.gms.internal.ads.zzfci.zza(r0, r2, r1)
            com.google.android.gms.internal.ads.zzfcd r0 = r0.zzi()
            com.google.android.gms.internal.ads.zzdbf r1 = r8.zzb
            com.google.android.gms.internal.ads.zzctb r2 = new com.google.android.gms.internal.ads.zzctb
            com.google.android.gms.internal.ads.zzfdz r3 = r8.zzd
            com.google.android.gms.internal.ads.zzfdw r4 = r8.zzc
            r2.<init>(r9, r3, r4)
            java.util.concurrent.Executor r3 = r8.zze
            r1.zzh(r2, r3)
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzbjn.zzfJ
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzeyp r1 = r9.zzb
            java.util.List<com.google.android.gms.internal.ads.zzeye> r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
        L_0x00b9:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00fb
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.ads.zzeye r2 = (com.google.android.gms.internal.ads.zzeye) r2
            com.google.android.gms.internal.ads.zzeds r3 = r8.zzi
            r3.zzb(r2)
            java.util.List<java.lang.String> r3 = r2.zza
            java.util.Iterator r3 = r3.iterator()
        L_0x00d0:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00ed
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.internal.ads.zzcxl<AdT> r5 = r8.zzg
            int r6 = r2.zzb
            com.google.android.gms.internal.ads.zzedn r4 = r5.zza(r6, r4)
            if (r4 == 0) goto L_0x00d0
            boolean r4 = r4.zza(r9, r2)
            if (r4 == 0) goto L_0x00d0
            goto L_0x00b9
        L_0x00ed:
            com.google.android.gms.internal.ads.zzeds r3 = r8.zzi
            r4 = 0
            r6 = 1
            r7 = 0
            com.google.android.gms.internal.ads.zzbdd r6 = com.google.android.gms.internal.ads.zzezr.zzd(r6, r7, r7)
            r3.zzc(r2, r4, r6)
            goto L_0x00b9
        L_0x00fb:
            com.google.android.gms.internal.ads.zzeyp r1 = r9.zzb
            java.util.List<com.google.android.gms.internal.ads.zzeye> r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x0104:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0173
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzeye r3 = (com.google.android.gms.internal.ads.zzeye) r3
            java.util.List<java.lang.String> r4 = r3.zza
            java.util.Iterator r4 = r4.iterator()
        L_0x0116:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0170
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzcxl<AdT> r6 = r8.zzg
            int r7 = r3.zzb
            com.google.android.gms.internal.ads.zzedn r6 = r6.zza(r7, r5)
            if (r6 == 0) goto L_0x0116
            boolean r7 = r6.zza(r9, r3)
            if (r7 == 0) goto L_0x0116
            com.google.android.gms.internal.ads.zzfcx r4 = r8.zza
            com.google.android.gms.internal.ads.zzfcr r7 = com.google.android.gms.internal.ads.zzfcr.RENDER_CONFIG_WATERFALL
            com.google.android.gms.internal.ads.zzfco r0 = r4.zza(r7, r0)
            java.lang.String r4 = java.lang.String.valueOf(r5)
            int r4 = r4.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r4 = r4 + 26
            r7.<init>(r4)
            java.lang.String r4 = "render-config-"
            r7.append(r4)
            r7.append(r2)
            java.lang.String r4 = "-"
            r7.append(r4)
            r7.append(r5)
            java.lang.String r4 = r7.toString()
            com.google.android.gms.internal.ads.zzfco r0 = r0.zza(r4)
            com.google.android.gms.internal.ads.zzehe r4 = new com.google.android.gms.internal.ads.zzehe
            r4.<init>(r8, r9, r3, r6)
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            com.google.android.gms.internal.ads.zzfco r0 = r0.zzg(r3, r4)
            com.google.android.gms.internal.ads.zzfcd r0 = r0.zzi()
        L_0x0170:
            int r2 = r2 + 1
            goto L_0x0104
        L_0x0173:
            r9 = r0
        L_0x0174:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehf.zza(java.lang.Object):com.google.android.gms.internal.ads.zzfqn");
    }

    public final /* synthetic */ zzfqn zzb(zzeyq zzeyq, zzeye zzeye, zzedn zzedn, Throwable th) throws Exception {
        zzeha zzeha = this.zzh;
        zzeyh zzeyh = zzeyq.zzb.zzb;
        zzfqn zzh2 = zzfqe.zzh(zzedn.zzb(zzeyq, zzeye), (long) zzeye.zzN, TimeUnit.MILLISECONDS, this.zzf);
        zzeha.zza(zzeyh, zzeye, zzh2);
        return zzh2;
    }
}
