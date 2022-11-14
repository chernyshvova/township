package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zznk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzii extends zzg {
    @VisibleForTesting
    public zzij zza;
    public volatile zzij zzb;
    public zzij zzc;
    public final Map<Activity, zzij> zzd = new ConcurrentHashMap();
    public Activity zze;
    public volatile boolean zzf;
    public volatile zzij zzg;
    public zzij zzh;
    public boolean zzi;
    public final Object zzj = new Object();
    public zzij zzk;
    public String zzl;

    public zzii(zzfu zzfu) {
        super(zzfu);
    }

    @MainThread
    private final zzij zzd(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzij zzij = this.zzd.get(activity);
        if (zzij == null) {
            zzij zzij2 = new zzij((String) null, zza(activity.getClass().getCanonicalName()), zzo().zzf());
            this.zzd.put(activity, zzij2);
            zzij = zzij2;
        }
        return (zzs().zza(zzas.zzbu) && this.zzg != null) ? this.zzg : zzij;
    }

    @WorkerThread
    public final zzij zza(boolean z) {
        zzv();
        zzc();
        if (!zzs().zza(zzas.zzbu) || !z) {
            return this.zza;
        }
        zzij zzij = this.zza;
        return zzij != null ? zzij : this.zzh;
    }

    public final zzij zzaa() {
        return this.zzb;
    }

    @MainThread
    public final void zzb(Activity activity) {
        if (zzs().zza(zzas.zzbu)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long elapsedRealtime = zzl().elapsedRealtime();
        if (!zzs().zza(zzas.zzbt) || zzs().zzh().booleanValue()) {
            zzij zzd2 = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzp().zza((Runnable) new zzip(this, zzd2, elapsedRealtime));
            return;
        }
        this.zzb = null;
        zzp().zza((Runnable) new zzim(this, elapsedRealtime));
    }

    @MainThread
    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zzs().zzh().booleanValue()) {
            this.zzd.remove(activity);
        }
    }

    public final /* bridge */ /* synthetic */ zzhb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzen zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzir zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzii zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzem zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzjx zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    public final boolean zzy() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00da, code lost:
        r1 = zzq().zzw();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e4, code lost:
        if (r10 != null) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e6, code lost:
        r3 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e9, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ea, code lost:
        if (r11 != null) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ec, code lost:
        r4 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ef, code lost:
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f0, code lost:
        r1.zza("Logging screen view with name, class", r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f5, code lost:
        if (r8.zzb != null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f7, code lost:
        r1 = r8.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fa, code lost:
        r1 = r8.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fc, code lost:
        r5 = r1;
        r9 = new com.google.android.gms.measurement.internal.zzij(r10, r11, zzo().zzf(), true, r19);
        r8.zzb = r9;
        r8.zzc = r5;
        r8.zzg = r9;
        zzp().zza((java.lang.Runnable) new com.google.android.gms.measurement.internal.zzil(r17, r18, r9, r5, zzl().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.os.Bundle r18, long r19) {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            com.google.android.gms.measurement.internal.zzab r1 = r17.zzs()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzbu
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r2)
            if (r1 != 0) goto L_0x001e
            com.google.android.gms.measurement.internal.zzeq r0 = r17.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()
            java.lang.String r1 = "Manual screen reporting is disabled."
            r0.zza(r1)
            return
        L_0x001e:
            java.lang.Object r1 = r8.zzj
            monitor-enter(r1)
            boolean r2 = r8.zzi     // Catch:{ all -> 0x012e }
            if (r2 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzeq r0 = r17.zzq()     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = "Cannot log screen view event when the app is in the background."
            r0.zza(r2)     // Catch:{ all -> 0x012e }
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            return
        L_0x0034:
            r2 = 0
            if (r0 == 0) goto L_0x0092
            java.lang.String r2 = "screen_name"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x012e }
            r3 = 100
            if (r2 == 0) goto L_0x0064
            int r4 = r2.length()     // Catch:{ all -> 0x012e }
            if (r4 <= 0) goto L_0x004d
            int r4 = r2.length()     // Catch:{ all -> 0x012e }
            if (r4 <= r3) goto L_0x0064
        L_0x004d:
            com.google.android.gms.measurement.internal.zzeq r0 = r17.zzq()     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()     // Catch:{ all -> 0x012e }
            java.lang.String r3 = "Invalid screen name length for screen view. Length"
            int r2 = r2.length()     // Catch:{ all -> 0x012e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x012e }
            r0.zza(r3, r2)     // Catch:{ all -> 0x012e }
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            return
        L_0x0064:
            java.lang.String r4 = "screen_class"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x012e }
            if (r4 == 0) goto L_0x008f
            int r5 = r4.length()     // Catch:{ all -> 0x012e }
            if (r5 <= 0) goto L_0x0078
            int r5 = r4.length()     // Catch:{ all -> 0x012e }
            if (r5 <= r3) goto L_0x008f
        L_0x0078:
            com.google.android.gms.measurement.internal.zzeq r0 = r17.zzq()     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = "Invalid screen class length for screen view. Length"
            int r3 = r4.length()     // Catch:{ all -> 0x012e }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x012e }
            r0.zza(r2, r3)     // Catch:{ all -> 0x012e }
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            return
        L_0x008f:
            r10 = r2
            r2 = r4
            goto L_0x0093
        L_0x0092:
            r10 = r2
        L_0x0093:
            if (r2 != 0) goto L_0x00aa
            android.app.Activity r2 = r8.zze     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00a8
            android.app.Activity r2 = r8.zze     // Catch:{ all -> 0x012e }
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = r2.getCanonicalName()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = zza((java.lang.String) r2)     // Catch:{ all -> 0x012e }
            goto L_0x00aa
        L_0x00a8:
            java.lang.String r2 = "Activity"
        L_0x00aa:
            r11 = r2
            boolean r2 = r8.zzf     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzij r2 = r8.zzb     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00d9
            r2 = 0
            r8.zzf = r2     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzij r2 = r8.zzb     // Catch:{ all -> 0x012e }
            java.lang.String r2 = r2.zzb     // Catch:{ all -> 0x012e }
            boolean r2 = com.google.android.gms.measurement.internal.zzkv.zzc((java.lang.String) r2, (java.lang.String) r11)     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzij r3 = r8.zzb     // Catch:{ all -> 0x012e }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x012e }
            boolean r3 = com.google.android.gms.measurement.internal.zzkv.zzc((java.lang.String) r3, (java.lang.String) r10)     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00d9
            if (r3 == 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzeq r0 = r17.zzq()     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = "Ignoring call to log screen view event with duplicate parameters."
            r0.zza(r2)     // Catch:{ all -> 0x012e }
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            return
        L_0x00d9:
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzeq r1 = r17.zzq()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzw()
            java.lang.String r2 = "Logging screen view with name, class"
            if (r10 != 0) goto L_0x00e9
            java.lang.String r3 = "null"
            goto L_0x00ea
        L_0x00e9:
            r3 = r10
        L_0x00ea:
            if (r11 != 0) goto L_0x00ef
            java.lang.String r4 = "null"
            goto L_0x00f0
        L_0x00ef:
            r4 = r11
        L_0x00f0:
            r1.zza(r2, r3, r4)
            com.google.android.gms.measurement.internal.zzij r1 = r8.zzb
            if (r1 != 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.zzij r1 = r8.zzc
            goto L_0x00fc
        L_0x00fa:
            com.google.android.gms.measurement.internal.zzij r1 = r8.zzb
        L_0x00fc:
            r5 = r1
            com.google.android.gms.measurement.internal.zzij r4 = new com.google.android.gms.measurement.internal.zzij
            com.google.android.gms.measurement.internal.zzkv r1 = r17.zzo()
            long r12 = r1.zzf()
            r14 = 1
            r9 = r4
            r15 = r19
            r9.<init>(r10, r11, r12, r14, r15)
            r8.zzb = r4
            r8.zzc = r5
            r8.zzg = r4
            com.google.android.gms.common.util.Clock r1 = r17.zzl()
            long r6 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzfr r9 = r17.zzp()
            com.google.android.gms.measurement.internal.zzil r10 = new com.google.android.gms.measurement.internal.zzil
            r1 = r10
            r2 = r17
            r3 = r18
            r1.<init>(r2, r3, r4, r5, r6)
            r9.zza((java.lang.Runnable) r10)
            return
        L_0x012e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzii.zza(android.os.Bundle, long):void");
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    @MainThread
    public final void zzb(Activity activity, Bundle bundle) {
        zzij zzij;
        if (zzs().zzh().booleanValue() && bundle != null && (zzij = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzij.zzc);
            bundle2.putString("name", zzij.zza);
            bundle2.putString("referrer_name", zzij.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(Bundle bundle, @NonNull zzij zzij, zzij zzij2, long j) {
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zza(zzij, zzij2, j, true, zzo().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, true, true));
    }

    @MainThread
    @Deprecated
    public final void zza(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        if (!zzs().zzh().booleanValue()) {
            zzq().zzj().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
        } else if (this.zzb == null) {
            zzq().zzj().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzq().zzj().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean zzc2 = zzkv.zzc(this.zzb.zzb, str2);
            boolean zzc3 = zzkv.zzc(this.zzb.zza, str);
            if (zzc2 && zzc3) {
                zzq().zzj().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzq().zzj().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzq().zzw().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzij zzij = new zzij(str, str2, zzo().zzf());
                this.zzd.put(activity, zzij);
                zza(activity, zzij, true);
            } else {
                zzq().zzj().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    @MainThread
    private final void zza(Activity activity, zzij zzij, boolean z) {
        zzij zzij2;
        zzij zzij3 = zzij;
        zzij zzij4 = this.zzb == null ? this.zzc : this.zzb;
        if (zzij3.zzb == null) {
            zzij2 = new zzij(zzij3.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zzij3.zzc, zzij3.zze, zzij3.zzf);
        } else {
            zzij2 = zzij3;
        }
        this.zzc = this.zzb;
        this.zzb = zzij2;
        zzp().zza((Runnable) new zzik(this, zzij2, zzij4, zzl().elapsedRealtime(), z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzij zzij, zzij zzij2, long j, boolean z, Bundle bundle) {
        boolean z2;
        long j2;
        long j3;
        zzij zzij3;
        zzc();
        boolean z3 = false;
        if (zzs().zza(zzas.zzas)) {
            z2 = z && this.zza != null;
            if (z2) {
                zza(this.zza, true, j);
            }
        } else {
            if (z && (zzij3 = this.zza) != null) {
                zza(zzij3, true, j);
            }
            z2 = false;
        }
        if (zzij2 == null || zzij2.zzc != zzij.zzc || !zzkv.zzc(zzij2.zzb, zzij.zzb) || !zzkv.zzc(zzij2.zza, zzij.zza)) {
            z3 = true;
        }
        if (z3) {
            Bundle bundle2 = new Bundle();
            if (zzs().zza(zzas.zzbu)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            Bundle bundle3 = bundle2;
            zza(zzij, bundle3, true);
            if (zzij2 != null) {
                String str = zzij2.zza;
                if (str != null) {
                    bundle3.putString("_pn", str);
                }
                String str2 = zzij2.zzb;
                if (str2 != null) {
                    bundle3.putString("_pc", str2);
                }
                bundle3.putLong("_pi", zzij2.zzc);
            }
            if (zzs().zza(zzas.zzas) && z2) {
                if (!zznk.zzb() || !zzs().zza(zzas.zzau)) {
                    j3 = zzj().zzb.zzb();
                } else {
                    j3 = zzj().zza(j);
                }
                if (j3 > 0) {
                    zzo().zza(bundle3, j3);
                }
            }
            String str3 = "auto";
            if (zzs().zza(zzas.zzbu)) {
                if (!zzs().zzh().booleanValue()) {
                    bundle3.putLong("_mst", 1);
                }
                if (zzij.zze) {
                    str3 = "app";
                }
            }
            String str4 = str3;
            if (zzs().zza(zzas.zzbu)) {
                long currentTimeMillis = zzl().currentTimeMillis();
                if (zzij.zze) {
                    long j4 = zzij.zzf;
                    if (j4 != 0) {
                        j2 = j4;
                        zze().zza(str4, "_vs", j2, bundle3);
                    }
                }
                j2 = currentTimeMillis;
                zze().zza(str4, "_vs", j2, bundle3);
            } else {
                zze().zzb(str4, "_vs", bundle3);
            }
        }
        this.zza = zzij;
        if (zzs().zza(zzas.zzbu) && zzij.zze) {
            this.zzh = zzij;
        }
        zzg().zza(zzij);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzij zzij, boolean z, long j) {
        zzd().zza(zzl().elapsedRealtime());
        if (zzj().zza(zzij != null && zzij.zzd, z, j) && zzij != null) {
            zzij.zzd = false;
        }
    }

    public static void zza(zzij zzij, Bundle bundle, boolean z) {
        if (bundle != null && zzij != null && (!bundle.containsKey("_sc") || z)) {
            String str = zzij.zza;
            if (str != null) {
                bundle.putString("_sn", str);
            } else {
                bundle.remove("_sn");
            }
            String str2 = zzij.zzb;
            if (str2 != null) {
                bundle.putString("_sc", str2);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", zzij.zzc);
        } else if (bundle != null && zzij == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @WorkerThread
    public final void zza(String str, zzij zzij) {
        zzc();
        synchronized (this) {
            if (this.zzl == null || this.zzl.equals(str) || zzij != null) {
                this.zzl = str;
                this.zzk = zzij;
            }
        }
    }

    @VisibleForTesting
    public static String zza(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (zzs().zzh().booleanValue() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzij(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    @MainThread
    public final void zza(Activity activity) {
        if (zzs().zza(zzas.zzbu)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (zzs().zza(zzas.zzbt) && zzs().zzh().booleanValue()) {
                        this.zzg = null;
                        zzp().zza((Runnable) new zzio(this));
                    }
                }
            }
        }
        if (!zzs().zza(zzas.zzbt) || zzs().zzh().booleanValue()) {
            zza(activity, zzd(activity), false);
            zza zzd2 = zzd();
            zzd2.zzp().zza((Runnable) new zze(zzd2, zzd2.zzl().elapsedRealtime()));
            return;
        }
        this.zzb = this.zzg;
        zzp().zza((Runnable) new zzin(this));
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
