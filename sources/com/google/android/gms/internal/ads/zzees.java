package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.zza;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzees implements zzedv<zzcvj, zzezn, zzefj> {
    public final Context zza;
    public final zzcwg zzb;
    public final Executor zzc;

    public zzees(Context context, zzcwg zzcwg, Executor executor) {
        this.zza = context;
        this.zzb = zzcwg;
        this.zzc = executor;
    }

    public final void zza(zzeyq zzeyq, zzeye zzeye, zzedq<zzezn, zzefj> zzedq) throws zzezb {
        zzbdp zzb2;
        zzbdp zzbdp = zzeyq.zza.zza.zze;
        if (zzbdp.zzn) {
            zzb2 = new zzbdp(this.zza, zza.zzb(zzbdp.zze, zzbdp.zzb));
        } else {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfn)).booleanValue() || !zzeye.zzac) {
                zzb2 = zzeza.zzb(this.zza, zzeye.zzu);
            } else {
                zzb2 = new zzbdp(this.zza, zza.zzc(zzbdp.zze, zzbdp.zzb));
            }
        }
        zzbdp zzbdp2 = zzb2;
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfn)).booleanValue() || !zzeye.zzac) {
            ((zzezn) zzedq.zzb).zzg(this.zza, zzbdp2, zzeyq.zza.zza.zzd, zzeye.zzv.toString(), zzbv.zzl(zzeye.zzs), (zzbvn) zzedq.zzc);
        } else {
            ((zzezn) zzedq.zzb).zzb(this.zza, zzbdp2, zzeyq.zza.zza.zzd, zzeye.zzv.toString(), zzbv.zzl(zzeye.zzs), (zzbvn) zzedq.zzc);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zzb(com.google.android.gms.internal.ads.zzeyq r7, com.google.android.gms.internal.ads.zzeye r8, com.google.android.gms.internal.ads.zzedq r9) throws com.google.android.gms.internal.ads.zzezb, com.google.android.gms.internal.ads.zzehd {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzfn
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0077
            boolean r0 = r8.zzac
            if (r0 == 0) goto L_0x0077
            AdapterT r0 = r9.zzb
            com.google.android.gms.internal.ads.zzezn r0 = (com.google.android.gms.internal.ads.zzezn) r0
            com.google.android.gms.internal.ads.zzbvq r0 = r0.zzc()
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.dynamic.IObjectWrapper r2 = r0.zze()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0060 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ RemoteException -> 0x0060 }
            boolean r0 = r0.zzf()     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x007f
            com.google.android.gms.internal.ads.zzfqn r0 = com.google.android.gms.internal.ads.zzfqe.zza(r1)
            com.google.android.gms.internal.ads.zzeer r3 = new com.google.android.gms.internal.ads.zzeer
            r3.<init>(r6, r2, r8)
            com.google.android.gms.internal.ads.zzfqo r2 = com.google.android.gms.internal.ads.zzche.zze
            com.google.android.gms.internal.ads.zzfqn r0 = com.google.android.gms.internal.ads.zzfqe.zzi(r0, r3, r2)
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            goto L_0x007f
        L_0x004a:
            r7 = move-exception
            goto L_0x004d
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            com.google.android.gms.internal.ads.zzezb r8 = new com.google.android.gms.internal.ads.zzezb
            r8.<init>(r7)
            throw r8
        L_0x0053:
            com.google.android.gms.internal.ads.zzezb r7 = new com.google.android.gms.internal.ads.zzezb
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "BannerAdapterWrapper interscrollerView should not be null"
            r8.<init>(r9)
            r7.<init>(r8)
            throw r7
        L_0x0060:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzezb r8 = new com.google.android.gms.internal.ads.zzezb
            r8.<init>(r7)
            throw r8
        L_0x0067:
            java.lang.String r7 = "getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."
            com.google.android.gms.internal.ads.zzcgs.zzf(r7)
            com.google.android.gms.internal.ads.zzezb r8 = new com.google.android.gms.internal.ads.zzezb
            java.lang.Exception r9 = new java.lang.Exception
            r9.<init>(r7)
            r8.<init>(r9)
            throw r8
        L_0x0077:
            AdapterT r0 = r9.zzb
            com.google.android.gms.internal.ads.zzezn r0 = (com.google.android.gms.internal.ads.zzezn) r0
            android.view.View r2 = r0.zza()
        L_0x007f:
            com.google.android.gms.internal.ads.zzcwg r0 = r6.zzb
            com.google.android.gms.internal.ads.zzcxx r3 = new com.google.android.gms.internal.ads.zzcxx
            java.lang.String r4 = r9.zza
            r3.<init>(r7, r8, r4)
            com.google.android.gms.internal.ads.zzcvq r7 = new com.google.android.gms.internal.ads.zzcvq
            AdapterT r4 = r9.zzb
            com.google.android.gms.internal.ads.zzezn r4 = (com.google.android.gms.internal.ads.zzezn) r4
            com.google.android.gms.internal.ads.zzcxg r4 = com.google.android.gms.internal.ads.zzeeq.zzb(r4)
            java.util.List<com.google.android.gms.internal.ads.zzeyf> r8 = r8.zzu
            r5 = 0
            java.lang.Object r8 = r8.get(r5)
            com.google.android.gms.internal.ads.zzeyf r8 = (com.google.android.gms.internal.ads.zzeyf) r8
            r7.<init>(r2, r1, r4, r8)
            com.google.android.gms.internal.ads.zzcvk r7 = r0.zzd(r3, r7)
            com.google.android.gms.internal.ads.zzdib r8 = r7.zzj()
            r8.zza(r2)
            com.google.android.gms.internal.ads.zzdcc r8 = r7.zza()
            com.google.android.gms.internal.ads.zzcta r0 = new com.google.android.gms.internal.ads.zzcta
            AdapterT r1 = r9.zzb
            com.google.android.gms.internal.ads.zzezn r1 = (com.google.android.gms.internal.ads.zzezn) r1
            r0.<init>(r1)
            java.util.concurrent.Executor r1 = r6.zzc
            r8.zzh(r0, r1)
            ListenerT r8 = r9.zzc
            com.google.android.gms.internal.ads.zzefj r8 = (com.google.android.gms.internal.ads.zzefj) r8
            com.google.android.gms.internal.ads.zzeip r9 = r7.zzf()
            r8.zzc(r9)
            com.google.android.gms.internal.ads.zzcvj r7 = r7.zzh()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzees.zzb(com.google.android.gms.internal.ads.zzeyq, com.google.android.gms.internal.ads.zzeye, com.google.android.gms.internal.ads.zzedq):java.lang.Object");
    }

    public final /* synthetic */ zzfqn zzc(View view, zzeye zzeye, Object obj) throws Exception {
        return zzfqe.zza(zzcwx.zza(this.zza, view, zzeye));
    }
}
