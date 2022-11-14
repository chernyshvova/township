package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbzk implements zzbzl {
    @GuardedBy("lock")
    @VisibleForTesting
    public static boolean zza = false;
    @GuardedBy("lock")
    @VisibleForTesting
    public static boolean zzb = false;
    public static final Object zzd = new Object();
    @VisibleForTesting
    public zzfed zzc;

    public final boolean zza(Context context) {
        synchronized (zzd) {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
                return false;
            }
            if (zza) {
                return true;
            }
            try {
                zzb(context);
                boolean zze = this.zzc.zze(ObjectWrapper.wrap(context));
                zza = zze;
                return zze;
            } catch (RemoteException e) {
                e = e;
                zzcgs.zzl("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e2) {
                e = e2;
                zzcgs.zzl("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @VisibleForTesting
    public final void zzb(Context context) {
        synchronized (zzd) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue() && !zzb) {
                try {
                    zzb = true;
                    this.zzc = (zzfed) zzcgw.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzbzj.zza);
                } catch (zzcgv e) {
                    zzcgs.zzl("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Nullable
    public final String zzc(Context context) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
            return null;
        }
        try {
            zzb(context);
            String valueOf = String.valueOf(this.zzc.zzh());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Nullable
    public final IObjectWrapper zzd(String str, WebView webView, String str2, String str3, String str4) {
        return zze(str, webView, "", "javascript", str4, "Google");
    }

    @Nullable
    public final IObjectWrapper zze(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5) {
        synchronized (zzd) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
                if (zza) {
                    try {
                        return this.zzc.zzk(str, ObjectWrapper.wrap(webView), "", "javascript", str4, str5);
                    } catch (RemoteException | NullPointerException e) {
                        zzcgs.zzl("#007 Could not call remote method.", e);
                        return null;
                    }
                }
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzbex.zzc().zzb(com.google.android.gms.internal.ads.zzbjn.zzdr)).booleanValue() != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        r13 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        com.google.android.gms.internal.ads.zzcgs.zzl("#007 Could not call remote method.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return zze(r15, r16, "", "javascript", r19, "Google");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r14.zzc.zzm(r15, com.google.android.gms.dynamic.ObjectWrapper.wrap(r16), "", "javascript", r19, "Google", r20.toString(), r21.toString(), r22);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:13:0x0041, B:18:0x0063] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.dynamic.IObjectWrapper zzf(java.lang.String r15, android.webkit.WebView r16, java.lang.String r17, java.lang.String r18, @androidx.annotation.Nullable java.lang.String r19, com.google.android.gms.internal.ads.zzbzn r20, com.google.android.gms.internal.ads.zzbzm r21, @androidx.annotation.Nullable java.lang.String r22) {
        /*
            r14 = this;
            java.lang.Object r1 = zzd
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzdo     // Catch:{ all -> 0x0065 }
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x0065 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ all -> 0x0065 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0065 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0065 }
            r2 = 0
            if (r0 == 0) goto L_0x0062
            boolean r0 = zza     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x001b
            goto L_0x0062
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x0065 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzdr
            java.lang.String r9 = "Google"
            java.lang.String r7 = "javascript"
            java.lang.String r6 = ""
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0040
            r3 = r14
            r4 = r15
            r5 = r16
            r8 = r19
            com.google.android.gms.dynamic.IObjectWrapper r2 = r3.zze(r4, r5, r6, r7, r8, r9)
            r13 = r14
            goto L_0x0064
        L_0x0040:
            r13 = r14
            com.google.android.gms.internal.ads.zzfed r3 = r13.zzc     // Catch:{ RemoteException -> 0x005b, NullPointerException -> 0x0059 }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x005b, NullPointerException -> 0x0059 }
            java.lang.String r10 = r20.toString()     // Catch:{ RemoteException -> 0x005b, NullPointerException -> 0x0059 }
            java.lang.String r11 = r21.toString()     // Catch:{ RemoteException -> 0x005b, NullPointerException -> 0x0059 }
            r4 = r15
            r8 = r19
            r12 = r22
            com.google.android.gms.dynamic.IObjectWrapper r2 = r3.zzm(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ RemoteException -> 0x005b, NullPointerException -> 0x0059 }
            goto L_0x0064
        L_0x0059:
            r0 = move-exception
            goto L_0x005c
        L_0x005b:
            r0 = move-exception
        L_0x005c:
            java.lang.String r1 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzcgs.zzl(r1, r0)
            goto L_0x0064
        L_0x0062:
            r13 = r14
            monitor-exit(r1)     // Catch:{ all -> 0x0069 }
        L_0x0064:
            return r2
        L_0x0065:
            r0 = move-exception
            r13 = r14
        L_0x0067:
            monitor-exit(r1)     // Catch:{ all -> 0x0069 }
            throw r0
        L_0x0069:
            r0 = move-exception
            goto L_0x0067
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzk.zzf(java.lang.String, android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzbzn, com.google.android.gms.internal.ads.zzbzm, java.lang.String):com.google.android.gms.dynamic.IObjectWrapper");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzbex.zzc().zzb(com.google.android.gms.internal.ads.zzbjn.zzds)).booleanValue() != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        return zze(r15, r16, "", "javascript", r19, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        return r14.zzc.zzl(r15, com.google.android.gms.dynamic.ObjectWrapper.wrap(r16), "", "javascript", r19, r20, r21.toString(), r22.toString(), r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
        com.google.android.gms.internal.ads.zzcgs.zzl("#007 Could not call remote method.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.dynamic.IObjectWrapper zzg(java.lang.String r15, android.webkit.WebView r16, java.lang.String r17, java.lang.String r18, @androidx.annotation.Nullable java.lang.String r19, java.lang.String r20, com.google.android.gms.internal.ads.zzbzn r21, com.google.android.gms.internal.ads.zzbzm r22, @androidx.annotation.Nullable java.lang.String r23) {
        /*
            r14 = this;
            java.lang.Object r1 = zzd
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzdo     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x0066 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ all -> 0x0066 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0066 }
            r2 = 0
            if (r0 == 0) goto L_0x0063
            boolean r0 = zza     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x001b
            goto L_0x0063
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzds
            java.lang.String r7 = "javascript"
            java.lang.String r6 = ""
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x003f
            r3 = r14
            r4 = r15
            r5 = r16
            r8 = r19
            r9 = r20
            com.google.android.gms.dynamic.IObjectWrapper r0 = r3.zze(r4, r5, r6, r7, r8, r9)
            return r0
        L_0x003f:
            r13 = r14
            com.google.android.gms.internal.ads.zzfed r3 = r13.zzc     // Catch:{ RemoteException -> 0x005c, NullPointerException -> 0x005a }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x005c, NullPointerException -> 0x005a }
            java.lang.String r10 = r21.toString()     // Catch:{ RemoteException -> 0x005c, NullPointerException -> 0x005a }
            java.lang.String r11 = r22.toString()     // Catch:{ RemoteException -> 0x005c, NullPointerException -> 0x005a }
            r4 = r15
            r8 = r19
            r9 = r20
            r12 = r23
            com.google.android.gms.dynamic.IObjectWrapper r0 = r3.zzl(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ RemoteException -> 0x005c, NullPointerException -> 0x005a }
            return r0
        L_0x005a:
            r0 = move-exception
            goto L_0x005d
        L_0x005c:
            r0 = move-exception
        L_0x005d:
            java.lang.String r1 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzcgs.zzl(r1, r0)
            return r2
        L_0x0063:
            r13 = r14
            monitor-exit(r1)     // Catch:{ all -> 0x006a }
            return r2
        L_0x0066:
            r0 = move-exception
            r13 = r14
        L_0x0068:
            monitor-exit(r1)     // Catch:{ all -> 0x006a }
            throw r0
        L_0x006a:
            r0 = move-exception
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzk.zzg(java.lang.String, android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzbzn, com.google.android.gms.internal.ads.zzbzm, java.lang.String):com.google.android.gms.dynamic.IObjectWrapper");
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        synchronized (zzd) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
                if (zza) {
                    try {
                        this.zzc.zzf(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzcgs.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        synchronized (zzd) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
                if (zza) {
                    try {
                        this.zzc.zzi(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzcgs.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper, View view) {
        synchronized (zzd) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
                if (zza) {
                    try {
                        this.zzc.zzg(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzcgs.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, View view) {
        synchronized (zzd) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
                if (zza) {
                    try {
                        this.zzc.zzj(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzcgs.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }
}
