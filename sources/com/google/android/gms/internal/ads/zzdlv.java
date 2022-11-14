package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdlv extends zzcxi {
    public final Executor zzc;
    public final zzdma zzd;
    public final zzdmi zze;
    public final zzdmz zzf;
    public final zzdmf zzg;
    public final zzdml zzh;
    public final zzgja<zzdqa> zzi;
    public final zzgja<zzdpy> zzj;
    public final zzgja<zzdqf> zzk;
    public final zzgja<zzdpw> zzl;
    public final zzgja<zzdqd> zzm;
    public zzdnu zzn;
    public boolean zzo;
    public boolean zzp;
    public boolean zzq;
    public final zzcej zzr;
    public final zzfb zzs;
    public final zzcgy zzt;
    public final Context zzu;
    public final zzdlx zzv;
    public final zzekt zzw;
    public final Map<String, Boolean> zzx = new HashMap();
    public final List<zzawa> zzy = new ArrayList();
    public final zzawb zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdlv(zzcxh zzcxh, Executor executor, zzdma zzdma, zzdmi zzdmi, zzdmz zzdmz, zzdmf zzdmf, zzdml zzdml, zzgja<zzdqa> zzgja, zzgja<zzdpy> zzgja2, zzgja<zzdqf> zzgja3, zzgja<zzdpw> zzgja4, zzgja<zzdqd> zzgja5, zzcej zzcej, zzfb zzfb, zzcgy zzcgy, Context context, zzdlx zzdlx, zzekt zzekt, zzawb zzawb) {
        super(zzcxh);
        this.zzc = executor;
        this.zzd = zzdma;
        this.zze = zzdmi;
        this.zzf = zzdmz;
        this.zzg = zzdmf;
        this.zzh = zzdml;
        this.zzi = zzgja;
        this.zzj = zzgja2;
        this.zzk = zzgja3;
        this.zzl = zzgja4;
        this.zzm = zzgja5;
        this.zzr = zzcej;
        this.zzs = zzfb;
        this.zzt = zzcgy;
        this.zzu = context;
        this.zzv = zzdlx;
        this.zzw = zzekt;
        this.zzz = zzawb;
    }

    public static boolean zzA(View view) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgD)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
        }
        zzs.zzc();
        long zzA = zzr.zzA(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null)) {
            if (zzA >= ((long) ((Integer) zzbex.zzc().zzb(zzbjn.zzgE)).intValue())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzQ */
    public final synchronized void zzL(zzdnu zzdnu) {
        View view;
        zzex zzb;
        if (!this.zzo) {
            this.zzn = zzdnu;
            this.zzf.zza(zzdnu);
            this.zze.zza(zzdnu.zzbP(), zzdnu.zzk(), zzdnu.zzl(), zzdnu, zzdnu);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbH)).booleanValue() && (zzb = this.zzs.zzb()) != null) {
                zzb.zzh(zzdnu.zzbP());
            }
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbf)).booleanValue()) {
                zzeye zzeye = this.zzb;
                if (zzeye.zzag) {
                    Iterator<String> keys = zzeye.zzaf.keys();
                    if (keys != null) {
                        while (keys.hasNext()) {
                            String next = keys.next();
                            WeakReference weakReference = this.zzn.zzj().get(next);
                            this.zzx.put(next, Boolean.FALSE);
                            if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
                                zzawa zzawa = new zzawa(this.zzu, view);
                                this.zzy.add(zzawa);
                                zzawa.zza(new zzdlu(this, next));
                            }
                        }
                    }
                }
            }
            if (zzdnu.zzh() != null) {
                zzdnu.zzh().zza(this.zzr);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzR */
    public final void zzK(zzdnu zzdnu) {
        this.zze.zzb(zzdnu.zzbP(), zzdnu.zzj());
        if (zzdnu.zzbL() != null) {
            zzdnu.zzbL().setClickable(false);
            zzdnu.zzbL().removeAllViews();
        }
        if (zzdnu.zzh() != null) {
            zzdnu.zzh().zzb(this.zzr);
        }
        this.zzn = null;
    }

    public final boolean zzB() {
        return this.zzg.zzc();
    }

    public final String zzC() {
        return this.zzg.zzf();
    }

    public final void zzD(String str, boolean z) {
        String str2;
        IObjectWrapper iObjectWrapper;
        zzbzm zzbzm;
        zzbzn zzbzn;
        if (this.zzg.zzd() && !TextUtils.isEmpty(str)) {
            zzcmr zzT = this.zzd.zzT();
            zzcmr zzR = this.zzd.zzR();
            if (zzT != null || zzR != null) {
                if (zzT != null) {
                    str2 = null;
                } else {
                    str2 = "javascript";
                    zzT = zzR;
                }
                String str3 = str2;
                if (!zzs.zzr().zza(this.zzu)) {
                    zzcgs.zzi("Failed to initialize omid in InternalNativeAd");
                    return;
                }
                zzcgy zzcgy = this.zzt;
                int i = zzcgy.zzb;
                int i2 = zzcgy.zzc;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i);
                sb.append(CodelessMatcher.CURRENT_CLASS_NAME);
                sb.append(i2);
                String sb2 = sb.toString();
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzds)).booleanValue()) {
                    if (zzR != null) {
                        zzbzm = zzbzm.zzc;
                        zzbzn = zzbzn.DEFINED_BY_JAVASCRIPT;
                    } else {
                        zzbzm = zzbzm.NATIVE_DISPLAY;
                        if (this.zzd.zzv() == 3) {
                            zzbzn = zzbzn.UNSPECIFIED;
                        } else {
                            zzbzn = zzbzn.ONE_PIXEL;
                        }
                    }
                    iObjectWrapper = zzs.zzr().zzg(sb2, zzT.zzG(), "", "javascript", str3, str, zzbzn, zzbzm, this.zzb.zzah);
                } else {
                    iObjectWrapper = zzs.zzr().zze(sb2, zzT.zzG(), "", "javascript", str3, str);
                }
                if (iObjectWrapper == null) {
                    zzcgs.zzi("Failed to create omid session in InternalNativeAd");
                    return;
                }
                this.zzd.zzp(iObjectWrapper);
                zzT.zzak(iObjectWrapper);
                if (zzR != null) {
                    zzs.zzr().zzj(iObjectWrapper, zzR.zzH());
                    this.zzq = true;
                }
                if (z) {
                    zzs.zzr().zzh(iObjectWrapper);
                    if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdu)).booleanValue()) {
                        zzT.zze("onSdkLoaded", new ArrayMap());
                    }
                }
            }
        }
    }

    public final boolean zzE() {
        return this.zzg.zzd();
    }

    public final void zzF(View view) {
        IObjectWrapper zzU = this.zzd.zzU();
        zzcmr zzT = this.zzd.zzT();
        if (this.zzg.zzd() && zzU != null && zzT != null && view != null) {
            zzs.zzr().zzj(zzU, view);
        }
    }

    public final void zzG(View view) {
        IObjectWrapper zzU = this.zzd.zzU();
        if (this.zzg.zzd() && zzU != null && view != null) {
            zzs.zzr().zzk(zzU, view);
        }
    }

    public final zzdlx zzH() {
        return this.zzv;
    }

    public final synchronized void zzI(zzbha zzbha) {
        this.zzw.zza(zzbha);
    }

    public final /* synthetic */ void zzJ(boolean z) {
        this.zze.zzf(this.zzn.zzbP(), this.zzn.zzj(), this.zzn.zzk(), z);
    }

    public final /* synthetic */ void zzM() {
        this.zze.zzx();
        this.zzd.zzZ();
    }

    public final /* bridge */ /* synthetic */ void zzP() {
        try {
            int zzv2 = this.zzd.zzv();
            if (zzv2 != 1) {
                if (zzv2 != 2) {
                    if (zzv2 != 3) {
                        if (zzv2 != 6) {
                            if (zzv2 != 7) {
                                zzcgs.zzf("Wrong native template id!");
                            } else if (this.zzh.zze() != null) {
                                this.zzh.zze().zze(this.zzl.zzb());
                            }
                        } else if (this.zzh.zzc() != null) {
                            zzD("Google", true);
                            this.zzh.zzc().zze(this.zzk.zzb());
                        }
                    } else if (this.zzh.zzf(this.zzd.zzQ()) != null) {
                        if (this.zzd.zzR() != null) {
                            zzD("Google", true);
                        }
                        this.zzh.zzf(this.zzd.zzQ()).zze(this.zzm.zzb());
                    }
                } else if (this.zzh.zzb() != null) {
                    zzD("Google", true);
                    this.zzh.zzb().zze(this.zzj.zzb());
                }
            } else if (this.zzh.zza() != null) {
                zzD("Google", true);
                this.zzh.zza().zze(this.zzi.zzb());
            }
        } catch (RemoteException e) {
            zzcgs.zzg("RemoteException when notifyAdLoad is called", e);
        }
    }

    @AnyThread
    public final void zzS() {
        this.zzc.execute(new zzdlo(this));
        if (this.zzd.zzv() != 7) {
            Executor executor = this.zzc;
            zzdmi zzdmi = this.zze;
            zzdmi.getClass();
            executor.execute(zzdlp.zza(zzdmi));
        }
        super.zzS();
    }

    public final synchronized void zzT() {
        this.zzo = true;
        this.zzc.execute(new zzdlq(this));
        super.zzT();
    }

    public final synchronized void zza(String str) {
        this.zze.zzd(str);
    }

    public final synchronized void zzb() {
        if (!this.zzp) {
            this.zze.zzn();
        }
    }

    public final synchronized void zzc(Bundle bundle) {
        this.zze.zze(bundle);
    }

    public final synchronized boolean zze(Bundle bundle) {
        if (this.zzp) {
            return true;
        }
        boolean zzw2 = this.zze.zzw(bundle);
        this.zzp = zzw2;
        return zzw2;
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zze.zzk(bundle);
    }

    public final synchronized void zzg(zzdnu zzdnu) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbe)).booleanValue()) {
            zzr.zza.post(new zzdlr(this, zzdnu));
        } else {
            zzL(zzdnu);
        }
    }

    public final synchronized void zzh(zzdnu zzdnu) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbe)).booleanValue()) {
            zzr.zza.post(new zzdls(this, zzdnu));
        } else {
            zzK(zzdnu);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzj(android.view.View r9, android.view.View r10, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r11, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r12, boolean r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzdmz r0 = r8.zzf     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzdnu r1 = r8.zzn     // Catch:{ all -> 0x0045 }
            r0.zzb(r1)     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzdmi r2 = r8.zze     // Catch:{ all -> 0x0045 }
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.zzc(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0045 }
            boolean r9 = r8.zzq     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzbjn.zzcg     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzbjl r10 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x0045 }
            java.lang.Object r9 = r10.zzb(r9)     // Catch:{ all -> 0x0045 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0045 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzdma r9 = r8.zzd     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzcmr r9 = r9.zzR()     // Catch:{ all -> 0x0045 }
            if (r9 != 0) goto L_0x0031
            goto L_0x0043
        L_0x0031:
            com.google.android.gms.internal.ads.zzdma r9 = r8.zzd     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzcmr r9 = r9.zzR()     // Catch:{ all -> 0x0045 }
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0045 }
            r10.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r11 = "onSdkAdUserInteractionClick"
            r9.zze(r11, r10)     // Catch:{ all -> 0x0045 }
            monitor-exit(r8)
            return
        L_0x0043:
            monitor-exit(r8)
            return
        L_0x0045:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlv.zzj(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzk(View view, MotionEvent motionEvent, View view2) {
        this.zze.zzj(view, motionEvent, view2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzp(android.view.View r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzp     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzbf     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x00a6 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a6 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzeye r0 = r3.zzb     // Catch:{ all -> 0x00a6 }
            boolean r0 = r0.zzag     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0045
            java.util.Map<java.lang.String, java.lang.Boolean> r0 = r3.zzx     // Catch:{ all -> 0x00a6 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00a6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a6 }
        L_0x0029:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00a6 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00a6 }
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r3.zzx     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00a6 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x0029
            monitor-exit(r3)
            return
        L_0x0045:
            r0 = 1
            if (r7 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzdmz r7 = r3.zzf     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzdnu r1 = r3.zzn     // Catch:{ all -> 0x00a6 }
            r7.zzc(r1)     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzdmi r7 = r3.zze     // Catch:{ all -> 0x00a6 }
            r7.zzu(r4, r5, r6)     // Catch:{ all -> 0x00a6 }
            r3.zzp = r0     // Catch:{ all -> 0x00a6 }
            monitor-exit(r3)
            return
        L_0x0058:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r7 = com.google.android.gms.internal.ads.zzbjn.zzcl     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x00a6 }
            java.lang.Object r7 = r1.zzb(r7)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x00a6 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x00a6 }
            if (r7 == 0) goto L_0x00a4
            if (r5 == 0) goto L_0x00a4
            java.util.Set r7 = r5.entrySet()     // Catch:{ all -> 0x00a6 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00a6 }
        L_0x0074:
            boolean r1 = r7.hasNext()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x00a4
            java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x00a6 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00a6 }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00a6 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0074
            boolean r1 = zzA(r1)     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0074
            com.google.android.gms.internal.ads.zzdmz r7 = r3.zzf     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzdnu r1 = r3.zzn     // Catch:{ all -> 0x00a6 }
            r7.zzc(r1)     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzdmi r7 = r3.zze     // Catch:{ all -> 0x00a6 }
            r7.zzu(r4, r5, r6)     // Catch:{ all -> 0x00a6 }
            r3.zzp = r0     // Catch:{ all -> 0x00a6 }
            monitor-exit(r3)
            return
        L_0x00a4:
            monitor-exit(r3)
            return
        L_0x00a6:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x00aa
        L_0x00a9:
            throw r4
        L_0x00aa:
            goto L_0x00a9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlv.zzp(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized JSONObject zzq(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zze.zzl(view, map, map2);
    }

    public final synchronized JSONObject zzr(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zze.zzm(view, map, map2);
    }

    public final synchronized void zzs(View view) {
        this.zze.zzo(view);
    }

    public final synchronized void zzt(zzboc zzboc) {
        this.zze.zzp(zzboc);
    }

    public final synchronized void zzu() {
        this.zze.zzq();
    }

    public final synchronized void zzv(@Nullable zzbgq zzbgq) {
        this.zze.zzr(zzbgq);
    }

    public final synchronized void zzw(zzbgm zzbgm) {
        this.zze.zzs(zzbgm);
    }

    public final synchronized void zzx() {
        this.zze.zzg();
    }

    public final synchronized void zzy() {
        zzdnu zzdnu = this.zzn;
        if (zzdnu == null) {
            zzcgs.zzd("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzc.execute(new zzdlt(this, zzdnu instanceof zzdmt));
        }
    }

    public final synchronized boolean zzz() {
        return this.zze.zzh();
    }
}
