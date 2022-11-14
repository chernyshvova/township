package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzw;
import com.helpshift.conversation.domainmodel.ConversationController;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzir extends zzg {
    public final zzjl zza;
    public zzei zzb;
    public volatile Boolean zzc;
    public final zzai zzd;
    public final zzke zze;
    public final List<Runnable> zzf = new ArrayList();
    public final zzai zzg;

    public zzir(zzfu zzfu) {
        super(zzfu);
        this.zze = new zzke(zzfu.zzl());
        this.zza = new zzjl(this);
        this.zzd = new zziq(this, zzfu);
        this.zzg = new zzja(this, zzfu);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzaj() {
        zzc();
        this.zze.zza();
        this.zzd.zza(zzas.zzai.zza(null).longValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f4  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzak() {
        /*
            r5 = this;
            r5.zzc()
            r5.zzv()
            java.lang.Boolean r0 = r5.zzc
            if (r0 != 0) goto L_0x0101
            r5.zzc()
            r5.zzv()
            com.google.android.gms.measurement.internal.zzfc r0 = r5.zzr()
            java.lang.Boolean r0 = r0.zzi()
            r1 = 1
            if (r0 == 0) goto L_0x0023
            boolean r2 = r0.booleanValue()
            if (r2 == 0) goto L_0x0023
            goto L_0x00fb
        L_0x0023:
            com.google.android.gms.measurement.internal.zzen r2 = r5.zzf()
            int r2 = r2.zzaf()
            r3 = 0
            if (r2 != r1) goto L_0x0031
        L_0x002e:
            r0 = 1
            goto L_0x00d7
        L_0x0031:
            com.google.android.gms.measurement.internal.zzeq r2 = r5.zzq()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzw()
            java.lang.String r4 = "Checking service availability"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzkv r2 = r5.zzo()
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r2 = r2.zza((int) r4)
            if (r2 == 0) goto L_0x00c8
            if (r2 == r1) goto L_0x00b8
            r4 = 2
            if (r2 == r4) goto L_0x0098
            r0 = 3
            if (r2 == r0) goto L_0x0089
            r0 = 9
            if (r2 == r0) goto L_0x007b
            r0 = 18
            if (r2 == r0) goto L_0x006d
            com.google.android.gms.measurement.internal.zzeq r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzh()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "Unexpected service status"
            r0.zza(r2, r1)
            goto L_0x0096
        L_0x006d:
            com.google.android.gms.measurement.internal.zzeq r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzh()
            java.lang.String r2 = "Service updating"
            r0.zza(r2)
            goto L_0x002e
        L_0x007b:
            com.google.android.gms.measurement.internal.zzeq r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzh()
            java.lang.String r1 = "Service invalid"
            r0.zza(r1)
            goto L_0x0096
        L_0x0089:
            com.google.android.gms.measurement.internal.zzeq r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzh()
            java.lang.String r1 = "Service disabled"
            r0.zza(r1)
        L_0x0096:
            r0 = 0
            goto L_0x00c6
        L_0x0098:
            com.google.android.gms.measurement.internal.zzeq r2 = r5.zzq()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzv()
            java.lang.String r4 = "Service container out of date"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzkv r2 = r5.zzo()
            int r2 = r2.zzi()
            r4 = 17443(0x4423, float:2.4443E-41)
            if (r2 >= r4) goto L_0x00b2
            goto L_0x00c5
        L_0x00b2:
            if (r0 != 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r1 = 0
        L_0x00b6:
            r0 = 0
            goto L_0x00d7
        L_0x00b8:
            com.google.android.gms.measurement.internal.zzeq r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzw()
            java.lang.String r2 = "Service missing"
            r0.zza(r2)
        L_0x00c5:
            r0 = 1
        L_0x00c6:
            r1 = 0
            goto L_0x00d7
        L_0x00c8:
            com.google.android.gms.measurement.internal.zzeq r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzw()
            java.lang.String r2 = "Service available"
            r0.zza(r2)
            goto L_0x002e
        L_0x00d7:
            if (r1 != 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.zzab r2 = r5.zzs()
            boolean r2 = r2.zzy()
            if (r2 == 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.zzeq r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zze()
            java.lang.String r2 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r2)
            goto L_0x00f2
        L_0x00f1:
            r3 = r0
        L_0x00f2:
            if (r3 == 0) goto L_0x00fb
            com.google.android.gms.measurement.internal.zzfc r0 = r5.zzr()
            r0.zza((boolean) r1)
        L_0x00fb:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r5.zzc = r0
        L_0x0101:
            java.lang.Boolean r0 = r5.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzir.zzak():boolean");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzal() {
        zzc();
        if (zzaa()) {
            zzq().zzw().zza("Inactivity, disconnecting from the service");
            zzag();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzam() {
        zzc();
        zzq().zzw().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (Exception e) {
                zzq().zze().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    @WorkerThread
    @Nullable
    private final zzn zzb(boolean z) {
        return zzf().zza(z ? zzq().zzx() : null);
    }

    @WorkerThread
    public final void zza(boolean z) {
        if (zzml.zzb() && zzs().zza(zzas.zzcg)) {
            zzc();
            zzv();
            if (z) {
                zzi().zzaa();
            }
            if (zzai()) {
                zza((Runnable) new zzjf(this, zzb(false)));
            }
        }
    }

    @WorkerThread
    public final boolean zzaa() {
        zzc();
        zzv();
        return this.zzb != null;
    }

    @WorkerThread
    public final void zzab() {
        zzc();
        zzv();
        zza((Runnable) new zzjc(this, zzb(true)));
    }

    @WorkerThread
    public final void zzac() {
        zzc();
        zzv();
        zzn zzb2 = zzb(false);
        zzi().zzaa();
        zza((Runnable) new zziu(this, zzb2));
    }

    @WorkerThread
    public final void zzad() {
        zzc();
        zzv();
        zzn zzb2 = zzb(true);
        zzi().zzab();
        zza((Runnable) new zziz(this, zzb2));
    }

    @WorkerThread
    public final void zzae() {
        zzc();
        zzv();
        if (!zzaa()) {
            if (zzak()) {
                this.zza.zzb();
            } else if (!zzs().zzy()) {
                List<ResolveInfo> queryIntentServices = zzm().getPackageManager().queryIntentServices(new Intent().setClassName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    intent.setComponent(new ComponentName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent);
                    return;
                }
                zzq().zze().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    public final Boolean zzaf() {
        return this.zzc;
    }

    @WorkerThread
    public final void zzag() {
        zzc();
        zzv();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzm(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    @WorkerThread
    public final boolean zzah() {
        zzc();
        zzv();
        if (zzak() && zzo().zzi() < 200900) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzai() {
        zzc();
        zzv();
        if (!zzs().zza(zzas.zzci)) {
            return false;
        }
        if (zzak() && zzo().zzi() < zzas.zzcj.zza(null).intValue()) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
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

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @WorkerThread
    @VisibleForTesting
    public final void zza(zzei zzei, AbstractSafeParcelable abstractSafeParcelable, zzn zzn) {
        int i;
        zzc();
        zzv();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zza2 = zzi().zza(100);
            if (zza2 != null) {
                arrayList.addAll(zza2);
                i = zza2.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzaq) {
                    try {
                        zzei.zza((zzaq) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e) {
                        zzq().zze().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzku) {
                    try {
                        zzei.zza((zzku) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e2) {
                        zzq().zze().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzz) {
                    try {
                        zzei.zza((zzz) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e3) {
                        zzq().zze().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzq().zze().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    @WorkerThread
    public final void zza(zzaq zzaq, String str) {
        Preconditions.checkNotNull(zzaq);
        zzc();
        zzv();
        zza((Runnable) new zzje(this, true, zzi().zza(zzaq), zzaq, zzb(true), str));
    }

    @WorkerThread
    public final void zza(zzz zzz) {
        Preconditions.checkNotNull(zzz);
        zzc();
        zzv();
        zza((Runnable) new zzjh(this, true, zzi().zza(zzz), new zzz(zzz), zzb(true), zzz));
    }

    @WorkerThread
    public final void zza(AtomicReference<List<zzz>> atomicReference, String str, String str2, String str3) {
        zzc();
        zzv();
        zza((Runnable) new zzjg(this, atomicReference, str, str2, str3, zzb(false)));
    }

    @WorkerThread
    public final void zza(zzw zzw, String str, String str2) {
        zzc();
        zzv();
        zza((Runnable) new zzjj(this, str, str2, zzb(false), zzw));
    }

    @WorkerThread
    public final void zza(AtomicReference<List<zzku>> atomicReference, String str, String str2, String str3, boolean z) {
        zzc();
        zzv();
        zza((Runnable) new zzji(this, atomicReference, str, str2, str3, z, zzb(false)));
    }

    @WorkerThread
    public final void zza(zzw zzw, String str, String str2, boolean z) {
        zzc();
        zzv();
        zza((Runnable) new zzit(this, str, str2, z, zzb(false), zzw));
    }

    @WorkerThread
    public final void zza(zzku zzku) {
        zzc();
        zzv();
        zza((Runnable) new zzis(this, zzi().zza(zzku), zzku, zzb(true)));
    }

    @WorkerThread
    public final void zza(AtomicReference<List<zzku>> atomicReference, boolean z) {
        zzc();
        zzv();
        zza((Runnable) new zziv(this, atomicReference, zzb(false), z));
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzc();
        zzv();
        zza((Runnable) new zzix(this, atomicReference, zzb(false)));
    }

    @WorkerThread
    public final void zza(zzw zzw) {
        zzc();
        zzv();
        zza((Runnable) new zziw(this, zzb(false), zzw));
    }

    @WorkerThread
    public final void zza(zzij zzij) {
        zzc();
        zzv();
        zza((Runnable) new zziy(this, zzij));
    }

    @WorkerThread
    public final void zza(Bundle bundle) {
        zzc();
        zzv();
        zza((Runnable) new zzjb(this, bundle, zzb(false)));
    }

    @WorkerThread
    @VisibleForTesting
    public final void zza(zzei zzei) {
        zzc();
        Preconditions.checkNotNull(zzei);
        this.zzb = zzei;
        zzaj();
        zzam();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(ComponentName componentName) {
        zzc();
        if (this.zzb != null) {
            this.zzb = null;
            zzq().zzw().zza("Disconnected from device MeasurementService", componentName);
            zzc();
            zzae();
        }
    }

    @WorkerThread
    private final void zza(Runnable runnable) throws IllegalStateException {
        zzc();
        if (zzaa()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzq().zze().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(ConversationController.ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT);
            zzae();
        }
    }

    @WorkerThread
    public final void zza(zzw zzw, zzaq zzaq, String str) {
        zzc();
        zzv();
        if (zzo().zza((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzq().zzh().zza("Not bundling data. Service unavailable or out of date");
            zzo().zza(zzw, new byte[0]);
            return;
        }
        zza((Runnable) new zzjd(this, zzaq, str, zzw));
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
