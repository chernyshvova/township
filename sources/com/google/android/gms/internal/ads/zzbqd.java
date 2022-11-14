package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.PaintCompat;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzcmi;
import com.google.android.gms.internal.ads.zzcmr;
import com.google.android.gms.internal.ads.zzcno;
import com.google.android.gms.internal.ads.zzcnt;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzcoa;
import com.google.android.gms.internal.ads.zzcoc;
import com.helpshift.analytics.AnalyticsEventKey;
import com.vungle.warren.log.LogEntry;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbqd<T extends zzbcz & zzcmi & zzcmr & zzbsj & zzcno & zzcnt & zzcnx & zzcoa & zzcoc> implements zzbps<T> {
    @Nullable
    public final zzb zza;
    @Nullable
    public final zzduu zzb;
    @Nullable
    public final zzfdh zzc;
    public final zzcgx zzd;
    @Nullable
    public final zzbyk zze;
    @Nullable
    public final zzedb zzf;
    public zzt zzg = null;

    public zzbqd(zzb zzb2, zzbyk zzbyk, zzedb zzedb, zzduu zzduu, zzfdh zzfdh) {
        this.zza = zzb2;
        this.zze = zzbyk;
        this.zzf = zzedb;
        this.zzb = zzduu;
        this.zzc = zzfdh;
        this.zzd = new zzcgx((String) null);
    }

    public static boolean zzc(Map<String, String> map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    public static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if (AnalyticsEventKey.PROTOCOL.equalsIgnoreCase(str)) {
            return 7;
        }
        if (AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL.equalsIgnoreCase(str)) {
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return zzs.zze().zzh();
        }
        return -1;
    }

    @VisibleForTesting
    public static Uri zze(Context context, zzfb zzfb, Uri uri, View view, @Nullable Activity activity) {
        if (zzfb == null) {
            return uri;
        }
        try {
            if (zzfb.zzf(uri)) {
                return zzfb.zze(uri, context, view, activity);
            }
            return uri;
        } catch (zzfc unused) {
            return uri;
        } catch (Exception e) {
            zzs.zzg().zzg(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    @VisibleForTesting
    public static Uri zzf(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzcgs.zzg(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    private final boolean zzh(T t, Context context, String str, String str2) {
        String str3 = str2;
        zzs.zzc();
        boolean zzI = zzr.zzI(context);
        zzs.zzc();
        zzbs zzD = zzr.zzD(context);
        zzduu zzduu = this.zzb;
        if (zzduu != null) {
            zzedj.zzd(context, zzduu, this.zzc, this.zzf, str2, "offline_open");
        }
        zzcmr zzcmr = (zzcmr) t;
        boolean z = zzcmr.zzP().zzg() && zzcmr.zzj() == null;
        if (zzI) {
            this.zzf.zzc(this.zzd, str3);
            return false;
        }
        zzs.zzc();
        if (NotificationManagerCompat.from(context).areNotificationsEnabled() && zzD != null && !z) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfM)).booleanValue()) {
                if (zzcmr.zzP().zzg()) {
                    zzedj.zzc(zzcmr.zzj(), (zzl) null, zzD, this.zzf, this.zzb, this.zzc, str2, str);
                } else {
                    ((zzcnx) t).zzaJ(zzD, this.zzf, this.zzb, this.zzc, str2, str, zzs.zze().zzh());
                }
                zzduu zzduu2 = this.zzb;
                if (zzduu2 != null) {
                    zzedj.zzd(context, zzduu2, this.zzc, this.zzf, str2, "dialog_impression");
                }
                t.onAdClicked();
                return true;
            }
        }
        this.zzf.zzd(str3);
        if (this.zzb != null) {
            HashMap hashMap = new HashMap();
            zzs.zzc();
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (zzD == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfM)).booleanValue()) {
                    hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
                } else if (z) {
                    hashMap.put("dialog_not_shown_reason", "fullscreen_no_activity");
                }
            }
            zzedj.zzh(context, this.zzb, this.zzc, this.zzf, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: android.net.Uri} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [android.content.Intent] */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r11v18 */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00df, code lost:
        if (r3 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzi(T r18, java.util.Map<java.lang.String, java.lang.String> r19, boolean r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = 1
            r1.zzj(r3)
            r4 = r0
            com.google.android.gms.internal.ads.zzcmr r4 = (com.google.android.gms.internal.ads.zzcmr) r4
            android.content.Context r5 = r4.getContext()
            com.google.android.gms.internal.ads.zzfb r6 = r4.zzU()
            android.view.View r7 = r4.zzH()
            java.lang.String r8 = "activity"
            java.lang.Object r8 = r5.getSystemService(r8)
            android.app.ActivityManager r8 = (android.app.ActivityManager) r8
            java.lang.String r9 = "u"
            java.lang.Object r9 = r2.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            r11 = 0
            if (r10 == 0) goto L_0x0032
            goto L_0x0133
        L_0x0032:
            android.net.Uri r9 = android.net.Uri.parse(r9)
            android.net.Uri r9 = zze(r5, r6, r9, r7, r11)
            android.net.Uri r9 = zzf(r9)
            java.lang.String r10 = "use_first_package"
            java.lang.Object r10 = r2.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            boolean r10 = java.lang.Boolean.parseBoolean(r10)
            java.lang.String r12 = "use_running_process"
            java.lang.Object r12 = r2.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            java.lang.String r13 = "use_custom_tabs"
            java.lang.Object r2 = r2.get(r13)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            if (r2 != 0) goto L_0x0078
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzbjn.zzcN
            com.google.android.gms.internal.ads.zzbjl r14 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r2 = r14.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r3 = 0
        L_0x0078:
            java.lang.String r2 = r9.getScheme()
            java.lang.String r14 = "http"
            boolean r2 = r14.equalsIgnoreCase(r2)
            java.lang.String r15 = "https"
            if (r2 == 0) goto L_0x0093
            android.net.Uri$Builder r2 = r9.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r15)
            android.net.Uri r11 = r2.build()
            goto L_0x00a9
        L_0x0093:
            java.lang.String r2 = r9.getScheme()
            boolean r2 = r15.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00a9
            android.net.Uri$Builder r2 = r9.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r14)
            android.net.Uri r11 = r2.build()
        L_0x00a9:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.content.Intent r9 = com.google.android.gms.internal.ads.zzbqc.zza(r9, r5, r6, r7)
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqc.zza(r11, r5, r6, r7)
            if (r3 == 0) goto L_0x00c4
            com.google.android.gms.ads.internal.zzs.zzc()
            com.google.android.gms.ads.internal.util.zzr.zzu(r5, r9)
            com.google.android.gms.ads.internal.zzs.zzc()
            com.google.android.gms.ads.internal.util.zzr.zzu(r5, r11)
        L_0x00c4:
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbqc.zzc(r9, r2, r5, r6, r7)
            if (r3 == 0) goto L_0x00cf
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqc.zzd(r9, r3, r5, r6, r7)
            goto L_0x0133
        L_0x00cf:
            if (r11 == 0) goto L_0x00e1
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbqc.zzb(r11, r5, r6, r7)
            if (r3 == 0) goto L_0x00e1
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqc.zzd(r9, r3, r5, r6, r7)
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbqc.zzb(r11, r5, r6, r7)
            if (r3 != 0) goto L_0x0133
        L_0x00e1:
            int r3 = r2.size()
            if (r3 != 0) goto L_0x00e8
            goto L_0x0132
        L_0x00e8:
            if (r12 == 0) goto L_0x0124
            if (r8 == 0) goto L_0x0124
            java.util.List r3 = r8.getRunningAppProcesses()
            if (r3 == 0) goto L_0x0124
            int r8 = r2.size()
            r11 = 0
        L_0x00f7:
            if (r11 >= r8) goto L_0x0124
            java.lang.Object r12 = r2.get(r11)
            android.content.pm.ResolveInfo r12 = (android.content.pm.ResolveInfo) r12
            java.util.Iterator r14 = r3.iterator()
        L_0x0103:
            int r15 = r11 + 1
            boolean r16 = r14.hasNext()
            if (r16 == 0) goto L_0x0122
            java.lang.Object r15 = r14.next()
            android.app.ActivityManager$RunningAppProcessInfo r15 = (android.app.ActivityManager.RunningAppProcessInfo) r15
            java.lang.String r15 = r15.processName
            android.content.pm.ActivityInfo r13 = r12.activityInfo
            java.lang.String r13 = r13.packageName
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0103
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqc.zzd(r9, r12, r5, r6, r7)
            goto L_0x0133
        L_0x0122:
            r11 = r15
            goto L_0x00f7
        L_0x0124:
            if (r10 == 0) goto L_0x0132
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqc.zzd(r9, r2, r5, r6, r7)
            goto L_0x0133
        L_0x0132:
            r11 = r9
        L_0x0133:
            if (r20 == 0) goto L_0x0151
            com.google.android.gms.internal.ads.zzedb r2 = r1.zzf
            if (r2 == 0) goto L_0x0151
            if (r11 == 0) goto L_0x0151
            android.content.Context r2 = r4.getContext()
            android.net.Uri r3 = r11.getData()
            java.lang.String r3 = r3.toString()
            r4 = r21
            boolean r2 = r1.zzh(r0, r2, r3, r4)
            if (r2 != 0) goto L_0x0150
            goto L_0x0151
        L_0x0150:
            return
        L_0x0151:
            com.google.android.gms.internal.ads.zzcnx r0 = (com.google.android.gms.internal.ads.zzcnx) r0     // Catch:{ ActivityNotFoundException -> 0x015e }
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc     // Catch:{ ActivityNotFoundException -> 0x015e }
            com.google.android.gms.ads.internal.overlay.zzt r3 = r1.zzg     // Catch:{ ActivityNotFoundException -> 0x015e }
            r2.<init>(r11, r3)     // Catch:{ ActivityNotFoundException -> 0x015e }
            r0.zzaF(r2)     // Catch:{ ActivityNotFoundException -> 0x015e }
            return
        L_0x015e:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.google.android.gms.internal.ads.zzcgs.zzi(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqd.zzi(com.google.android.gms.internal.ads.zzbcz, java.util.Map, boolean, java.lang.String):void");
    }

    private final void zzj(boolean z) {
        zzbyk zzbyk = this.zze;
        if (zzbyk != null) {
            zzbyk.zzb(z);
        }
    }

    /* access modifiers changed from: private */
    public final void zzk(int i) {
        if (this.zzb != null) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfU)).booleanValue()) {
                zzfdh zzfdh = this.zzc;
                zzfdg zza2 = zzfdg.zza("cct_action");
                zza2.zzc("cct_open_status", zzbkk.zza(i));
                zzfdh.zza(zza2);
                return;
            }
            zzdut zza3 = this.zzb.zza();
            zza3.zzc("action", "cct_action");
            zza3.zzc("cct_open_status", zzbkk.zza(i));
            zza3.zzd();
        }
    }

    /* renamed from: zzb */
    public final void zza(T t, Map<String, String> map) {
        boolean z;
        T t2 = t;
        Map<String, String> map2 = map;
        zzcmr zzcmr = (zzcmr) t2;
        String zza2 = zzcfd.zza(map2.get(AnalyticsEventKey.URL), zzcmr.getContext(), true);
        String str = map2.get("a");
        if (str == null) {
            zzcgs.zzi("Action missing from an open GMSG.");
            return;
        }
        zzb zzb2 = this.zza;
        if (zzb2 == null || zzb2.zzb()) {
            zzeye zzF = zzcmr.zzF();
            zzeyh zzaB = zzcmr.zzaB();
            boolean z2 = false;
            String str2 = "";
            if (zzF == null || zzaB == null) {
                z = false;
            } else {
                boolean z3 = zzF.zzae;
                str2 = zzaB.zzb;
                z = z3;
            }
            if ("expand".equalsIgnoreCase(str)) {
                if (zzcmr.zzW()) {
                    zzcgs.zzi("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzj(false);
                ((zzcnx) t2).zzaG(zzc(map), zzd(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                zzj(false);
                if (zza2 != null) {
                    ((zzcnx) t2).zzaH(zzc(map), zzd(map), zza2);
                } else {
                    ((zzcnx) t2).zzaI(zzc(map), zzd(map), map2.get("html"), map2.get("baseurl"));
                }
            } else if ("chrome_custom_tab".equalsIgnoreCase(str)) {
                Context context = zzcmr.getContext();
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcP)).booleanValue()) {
                    if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcV)).booleanValue()) {
                        zze.zza("User opt out chrome custom tab.");
                    } else {
                        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzcT)).booleanValue()) {
                            z2 = true;
                        } else {
                            String str3 = (String) zzbex.zzc().zzb(zzbjn.zzcU);
                            if (!str3.isEmpty() && context != null) {
                                String packageName = context.getPackageName();
                                Iterator<String> it = zzfkk.zza(zzfjr.zzb(';')).zzb(str3).iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().equals(packageName)) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                boolean zza3 = zzbkl.zza(zzcmr.getContext());
                if (z2) {
                    if (!zza3) {
                        zzk(4);
                    } else {
                        zzj(true);
                        if (TextUtils.isEmpty(zza2)) {
                            zzcgs.zzi("Cannot open browser with null or empty url");
                            zzk(7);
                            return;
                        }
                        Uri zzf2 = zzf(zze(zzcmr.getContext(), zzcmr.zzU(), Uri.parse(zza2), zzcmr.zzH(), zzcmr.zzj()));
                        if (!z || this.zzf == null || !zzh(t2, zzcmr.getContext(), zzf2.toString(), str2)) {
                            this.zzg = new zzbqa(this);
                            ((zzcnx) t2).zzaF(new zzc((String) null, zzf2.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (Intent) null, ObjectWrapper.wrap(this.zzg).asBinder(), true));
                            return;
                        }
                        return;
                    }
                }
                map2.put("use_first_package", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                map2.put("use_running_process", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                zzi(t2, map2, z, str2);
            } else if ("app".equalsIgnoreCase(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(map2.get("system_browser"))) {
                zzi(t2, map2, z, str2);
            } else if ("open_app".equalsIgnoreCase(str)) {
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfE)).booleanValue()) {
                    zzj(true);
                    String str4 = map2.get(AnalyticsEventKey.PROTOCOL);
                    if (str4 == null) {
                        zzcgs.zzi("Package name missing from open app action.");
                    } else if (!z || this.zzf == null || !zzh(t2, zzcmr.getContext(), str4, str2)) {
                        PackageManager packageManager = zzcmr.getContext().getPackageManager();
                        if (packageManager == null) {
                            zzcgs.zzi("Cannot get package manager from open app action.");
                            return;
                        }
                        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str4);
                        if (launchIntentForPackage != null) {
                            ((zzcnx) t2).zzaF(new zzc(launchIntentForPackage, this.zzg));
                        }
                    }
                }
            } else {
                zzj(true);
                String str5 = map2.get("intent_url");
                Intent intent = null;
                if (!TextUtils.isEmpty(str5)) {
                    try {
                        intent = Intent.parseUri(str5, 0);
                    } catch (URISyntaxException e) {
                        URISyntaxException uRISyntaxException = e;
                        String valueOf = String.valueOf(str5);
                        zzcgs.zzg(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), uRISyntaxException);
                    }
                }
                if (!(intent == null || intent.getData() == null)) {
                    Uri data = intent.getData();
                    if (!Uri.EMPTY.equals(data)) {
                        Uri zzf3 = zzf(zze(zzcmr.getContext(), zzcmr.zzU(), data, zzcmr.zzH(), zzcmr.zzj()));
                        if (!TextUtils.isEmpty(intent.getType())) {
                            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfF)).booleanValue()) {
                                intent.setDataAndType(zzf3, intent.getType());
                            }
                        }
                        intent.setData(zzf3);
                    }
                }
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfQ)).booleanValue() && "intent_async".equalsIgnoreCase(str) && map2.containsKey(LogEntry.LOG_ITEM_EVENT_ID)) {
                    z2 = true;
                }
                HashMap hashMap = new HashMap();
                if (z2) {
                    this.zzg = new zzbqb(this, hashMap, map2, t2);
                }
                if (intent == null) {
                    if (!TextUtils.isEmpty(zza2)) {
                        zza2 = zzf(zze(zzcmr.getContext(), zzcmr.zzU(), Uri.parse(zza2), zzcmr.zzH(), zzcmr.zzj())).toString();
                    }
                    String str6 = zza2;
                    if (!z || this.zzf == null || !zzh(t2, zzcmr.getContext(), str6, str2)) {
                        ((zzcnx) t2).zzaF(new zzc(map2.get("i"), str6, map2.get(PaintCompat.EM_STRING), map2.get(AnalyticsEventKey.PROTOCOL), map2.get("c"), map2.get("f"), map2.get("e"), this.zzg));
                    } else if (z2) {
                        hashMap.put(map2.get(LogEntry.LOG_ITEM_EVENT_ID), Boolean.TRUE);
                        ((zzbsj) t2).zze("openIntentAsync", hashMap);
                    }
                } else if (!z || this.zzf == null || !zzh(t2, zzcmr.getContext(), intent.getData().toString(), str2)) {
                    ((zzcnx) t2).zzaF(new zzc(intent, this.zzg));
                } else if (z2) {
                    hashMap.put(map2.get(LogEntry.LOG_ITEM_EVENT_ID), Boolean.TRUE);
                    ((zzbsj) t2).zze("openIntentAsync", hashMap);
                }
            }
        } else {
            this.zza.zzc(zza2);
        }
    }
}
