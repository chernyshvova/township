package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.collection.ArrayMap;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzms;
import com.google.android.gms.internal.measurement.zzmy;
import com.google.android.gms.internal.measurement.zznj;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.services.ads.gmascar.bridges.MobileAdsBridge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhb extends zzg {
    @VisibleForTesting
    public zzhy zza;
    public final zzo zzb;
    public zzgw zzc;
    public final Set<zzgz> zzd = new CopyOnWriteArraySet();
    public boolean zze;
    public final AtomicReference<String> zzf = new AtomicReference<>();
    public final Object zzg = new Object();
    @GuardedBy("consentLock")
    public zzac zzh = new zzac((Boolean) null, (Boolean) null);
    @GuardedBy("consentLock")
    public int zzi = 100;
    public final AtomicLong zzj = new AtomicLong(0);
    public long zzk = -1;
    public int zzl = 100;
    @VisibleForTesting
    public boolean zzm = true;
    public final zzky zzn = new zzhq(this);

    public zzhb(zzfu zzfu) {
        super(zzfu);
        this.zzb = new zzo(zzfu);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzal() {
        zzc();
        String zza2 = zzr().zzn.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zza("app", "_npa", (Object) null, zzl().currentTimeMillis());
            } else {
                zza("app", "_npa", (Object) Long.valueOf(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(zza2) ? 1 : 0), zzl().currentTimeMillis());
            }
        }
        if (!this.zzy.zzaa() || !this.zzm) {
            zzq().zzv().zza("Updating Scion state (FE)");
            zzg().zzab();
            return;
        }
        zzq().zzv().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzah();
        if (zznj.zzb() && zzs().zza(zzas.zzbp)) {
            zzj().zza.zza();
        }
        if (zzmy.zzb() && zzs().zza(zzas.zzbs)) {
            if (!(this.zzy.zze().zza.zzb().zzi.zza() > 0)) {
                zzfl zze2 = this.zzy.zze();
                zze2.zza(zze2.zza.zzm().getPackageName());
            }
        }
        if (zzs().zza(zzas.zzcc)) {
            zzp().zza((Runnable) new zzhe(this));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzd(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzku zzku = new zzku(bundle2.getString("name"), 0, (Object) null, (String) null);
        try {
            zzg().zza(new zzz(bundle2.getString("app_id"), bundle2.getString("origin"), zzku, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean("active"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzaq) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzaq) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false, zzlo.zzb() && zzs().zza(zzas.zzck))));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void zza(@Nullable Boolean bool) {
        zzv();
        zzp().zza((Runnable) new zzhu(this, bool));
    }

    public final void zzaa() {
        if (zzm().getApplicationContext() instanceof Application) {
            ((Application) zzm().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzp().zza(atomicReference, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "boolean test flag value", new zzhc(this, atomicReference));
    }

    public final String zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzp().zza(atomicReference, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "String test flag value", new zzhm(this, atomicReference));
    }

    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzp().zza(atomicReference, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "long test flag value", new zzht(this, atomicReference));
    }

    public final Integer zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzp().zza(atomicReference, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "int test flag value", new zzhs(this, atomicReference));
    }

    public final Double zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzp().zza(atomicReference, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "double test flag value", new zzhv(this, atomicReference));
    }

    @Nullable
    public final String zzag() {
        return this.zzf.get();
    }

    @WorkerThread
    public final void zzah() {
        zzc();
        zzv();
        if (this.zzy.zzaf()) {
            if (zzs().zza(zzas.zzbc)) {
                Boolean zzf2 = zzs().zzf("google_analytics_deferred_deep_link_enabled");
                if (zzf2 != null && zzf2.booleanValue()) {
                    zzq().zzv().zza("Deferred Deep Link feature enabled.");
                    zzp().zza((Runnable) new zzhd(this));
                }
            }
            zzg().zzad();
            this.zzm = false;
            String zzy = zzr().zzy();
            if (!TextUtils.isEmpty(zzy)) {
                zzk().zzab();
                if (!zzy.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzy);
                    zza("auto", "_ou", bundle);
                }
            }
        }
    }

    @Nullable
    public final String zzai() {
        zzij zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zza;
        }
        return null;
    }

    @Nullable
    public final String zzaj() {
        zzij zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zzb;
        }
        return null;
    }

    @Nullable
    public final String zzak() {
        if (this.zzy.zzn() != null) {
            return this.zzy.zzn();
        }
        try {
            return zzig.zza(zzm(), "google_app_id");
        } catch (IllegalStateException e) {
            this.zzy.zzq().zze().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @WorkerThread
    public final void zzb(String str, String str2, Bundle bundle) {
        zzc();
        zza(str, str2, zzl().currentTimeMillis(), bundle);
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        long currentTimeMillis = zzl().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzp().zza((Runnable) new zzhp(this, bundle2));
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

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzp().zza((Runnable) new zzhj(this, str, str2, j, zzkv.zzb(bundle), z, z2, z3, str3));
    }

    public final void zza(Bundle bundle, int i, long j) {
        if (zzml.zzb() && zzs().zza(zzas.zzcg)) {
            zzv();
            String zza2 = zzac.zza(bundle);
            if (zza2 != null) {
                zzq().zzj().zza("Ignoring invalid consent setting", zza2);
                zzq().zzj().zza("Valid consent values are 'granted', 'denied'");
            }
            zza(zzac.zzb(bundle), i, j);
        }
    }

    public final void zzb(zzgz zzgz) {
        zzv();
        Preconditions.checkNotNull(zzgz);
        if (!this.zzd.remove(zzgz)) {
            zzq().zzh().zza("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        try {
            zzg().zza(new zzz(bundle2.getString("app_id"), bundle2.getString("origin"), new zzku(bundle2.getString("name"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin")), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlo.zzb() && zzs().zza(zzas.zzck)), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlo.zzb() && zzs().zza(zzas.zzck)), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlo.zzb() && zzs().zza(zzas.zzck))));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void zza(zzac zzac, int i, long j) {
        boolean z;
        boolean z2;
        zzac zzac2;
        boolean z3;
        if (zzml.zzb() && zzs().zza(zzas.zzcg)) {
            zzv();
            if ((!zzs().zza(zzas.zzch) || i != 20) && zzac.zzb() == null && zzac.zzd() == null) {
                zzq().zzj().zza("Discarding empty consent settings");
                return;
            }
            synchronized (this.zzg) {
                z = false;
                if (zzac.zza(i, this.zzi)) {
                    z3 = zzac.zza(this.zzh);
                    if (zzac.zze() && !this.zzh.zze()) {
                        z = true;
                    }
                    zzac zzc2 = zzac.zzc(this.zzh);
                    this.zzh = zzc2;
                    this.zzi = i;
                    zzac2 = zzc2;
                    z2 = z;
                    z = true;
                } else {
                    zzac2 = zzac;
                    z2 = false;
                    z3 = false;
                }
            }
            if (!z) {
                zzq().zzu().zza("Ignoring lower-priority consent settings, proposed settings", zzac2);
                return;
            }
            long andIncrement = this.zzj.getAndIncrement();
            if (z3) {
                zza((String) null);
                zzp().zzb((Runnable) new zzhx(this, zzac2, j, i, andIncrement, z2));
            } else if (!zzs().zza(zzas.zzch) || !(i == 40 || i == 20)) {
                zzp().zza((Runnable) new zzhz(this, zzac2, i, andIncrement, z2));
            } else {
                zzp().zzb((Runnable) new zzhw(this, zzac2, i, andIncrement, z2));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* synthetic */ void zzb(Bundle bundle) {
        if (zznw.zzb() && zzs().zza(zzas.zzby)) {
            if (bundle == null) {
                zzr().zzx.zza(new Bundle());
                return;
            }
            Bundle zza2 = zzr().zzx.zza();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzo();
                    if (zzkv.zza(obj)) {
                        zzo().zza(this.zzn, 27, (String) null, (String) null, 0);
                    }
                    zzq().zzj().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzkv.zzd(str)) {
                    zzq().zzj().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    zza2.remove(str);
                } else if (zzo().zza("param", str, 100, obj)) {
                    zzo().zza(zza2, str, obj);
                }
            }
            zzo();
            if (zzkv.zza(zza2, zzs().zzd())) {
                zzo().zza(this.zzn, 26, (String) null, (String) null, 0);
                zzq().zzj().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            zzr().zzx.zza(zza2);
            zzg().zza(zza2);
        }
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    @WorkerThread
    public final void zza(zzac zzac) {
        zzc();
        boolean z = (zzac.zze() && zzac.zzc()) || zzg().zzai();
        if (z != this.zzy.zzac()) {
            this.zzy.zzb(z);
            Boolean zzv = zzr().zzv();
            if (!z || zzv == null || zzv.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(@Nullable Boolean bool, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Setting app measurement enabled (FE)", bool);
        zzr().zza(bool);
        if (zzml.zzb() && zzs().zza(zzas.zzcg) && z) {
            zzr().zzb(bool);
        }
        if (!zzml.zzb() || !zzs().zza(zzas.zzcg) || this.zzy.zzac() || !bool.booleanValue()) {
            zzal();
        }
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzac zzac, int i, long j, boolean z, boolean z2) {
        zzc();
        zzv();
        if (j <= this.zzk && zzac.zza(this.zzl, i)) {
            zzq().zzu().zza("Dropped out-of-date consent setting, proposed settings", zzac);
        } else if (zzr().zza(zzac, i)) {
            this.zzk = j;
            this.zzl = i;
            zzg().zza(z);
            if (z2) {
                zzg().zza((AtomicReference<String>) new AtomicReference());
            }
        } else {
            zzq().zzu().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
        }
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzl().currentTimeMillis());
    }

    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzc();
        zza(str, str2, j, bundle, true, this.zzc == null || zzkv.zzd(str2), false, (String) null);
    }

    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        long j2;
        String str4;
        boolean z4;
        Class<?> cls;
        String str5 = str;
        String str6 = str2;
        long j3 = j;
        Bundle bundle2 = bundle;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzc();
        zzv();
        if (!this.zzy.zzaa()) {
            zzq().zzv().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> zzag = zzf().zzag();
        if (zzag == null || zzag.contains(str6)) {
            int i = 0;
            if (!this.zze) {
                this.zze = true;
                try {
                    if (!this.zzy.zzs()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zzm().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod(MobileAdsBridge.initializeMethodName, new Class[]{Context.class}).invoke((Object) null, new Object[]{zzm()});
                    } catch (Exception e) {
                        zzq().zzh().zza("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException unused) {
                    zzq().zzu().zza("Tag Manager is not found and thus will not be used");
                }
            }
            if (zzs().zza(zzas.zzbd) && "_cmp".equals(str6) && bundle2.containsKey("gclid")) {
                zza("auto", "_lgclid", (Object) bundle2.getString("gclid"), zzl().currentTimeMillis());
            }
            if (zznw.zzb() && zzs().zza(zzas.zzby) && z && zzkv.zzf(str2)) {
                zzo().zza(bundle2, zzr().zzx.zza());
            }
            if (z3 && !"_iap".equals(str6)) {
                zzkv zzh2 = this.zzy.zzh();
                boolean z5 = zzlo.zzb() && zzs().zza(zzas.zzck);
                int i2 = 2;
                if (zzh2.zza("event", str6)) {
                    if (!z5 ? !zzh2.zza("event", zzgv.zza, str6) : !zzh2.zza("event", zzgv.zza, zzgv.zzb, str6)) {
                        i2 = 13;
                    } else if (zzh2.zza("event", 40, str6)) {
                        i2 = 0;
                    }
                }
                if (i2 != 0) {
                    zzq().zzg().zza("Invalid public event name. Event will not be logged (FE)", zzn().zza(str6));
                    this.zzy.zzh();
                    String zza2 = zzkv.zza(str6, 40, true);
                    if (str6 != null) {
                        i = str2.length();
                    }
                    this.zzy.zzh().zza(this.zzn, i2, "_ev", zza2, i);
                    return;
                }
            }
            zzij zza3 = zzh().zza(false);
            if (zza3 != null && !bundle2.containsKey("_sc")) {
                zza3.zzd = true;
            }
            zzii.zza(zza3, bundle2, z && z3);
            boolean equals = "am".equals(str5);
            boolean zzd2 = zzkv.zzd(str2);
            if (z && this.zzc != null && !zzd2 && !equals) {
                zzq().zzv().zza("Passing event to registered event handler (FE)", zzn().zza(str6), zzn().zza(bundle2));
                this.zzc.interceptEvent(str, str2, bundle, j);
            } else if (this.zzy.zzaf()) {
                int zza4 = zzo().zza(str6, zzlo.zzb() && zzs().zza(zzas.zzck));
                if (zza4 != 0) {
                    zzq().zzg().zza("Invalid event name. Event will not be logged (FE)", zzn().zza(str6));
                    zzo();
                    String zza5 = zzkv.zza(str6, 40, true);
                    if (str6 != null) {
                        i = str2.length();
                    }
                    this.zzy.zzh().zza(this.zzn, str3, zza4, "_ev", zza5, i);
                    return;
                }
                String str7 = str6;
                Bundle zza6 = zzo().zza(str3, str2, bundle, (List<String>) CollectionUtils.listOf((T[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3, true);
                if (zza6 != null && zza6.containsKey("_sc") && zza6.containsKey("_si")) {
                    new zzij(zza6.getString("_sn"), zza6.getString("_sc"), Long.valueOf(zza6.getLong("_si")).longValue());
                }
                if (zzs().zza(zzas.zzas) && zzh().zza(false) != null && "_ae".equals(str7)) {
                    long zzb2 = zzj().zzb.zzb();
                    if (zzb2 > 0) {
                        zzo().zza(zza6, zzb2);
                    }
                }
                if (zzms.zzb() && zzs().zza(zzas.zzbo)) {
                    if (!"auto".equals(str5) && "_ssr".equals(str7)) {
                        zzkv zzo = zzo();
                        String string = zza6.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            str4 = null;
                        } else {
                            str4 = string.trim();
                        }
                        if (zzkv.zzc(str4, zzo.zzr().zzu.zza())) {
                            zzo.zzq().zzv().zza("Not logging duplicate session_start_with_rollout event");
                            z4 = false;
                        } else {
                            zzo.zzr().zzu.zza(str4);
                            z4 = true;
                        }
                        if (!z4) {
                            return;
                        }
                    } else if ("_ae".equals(str7)) {
                        String zza7 = zzo().zzr().zzu.zza();
                        if (!TextUtils.isEmpty(zza7)) {
                            zza6.putString("_ffr", zza7);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza6);
                zzo().zzg().nextLong();
                if (zzr().zzp.zza() > 0) {
                    j2 = j;
                    if (zzr().zza(j2) && zzr().zzr.zza()) {
                        zzq().zzw().zza("Current session is expired, remove the session number, ID, and engagement time");
                        zza("auto", "_sid", (Object) null, zzl().currentTimeMillis());
                        zza("auto", "_sno", (Object) null, zzl().currentTimeMillis());
                        zza("auto", "_se", (Object) null, zzl().currentTimeMillis());
                    }
                } else {
                    j2 = j;
                }
                if (zza6.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0) == 1) {
                    zzq().zzw().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    this.zzy.zzd().zza.zza(j2, true);
                }
                String[] strArr = (String[]) zza6.keySet().toArray(new String[zza6.size()]);
                Arrays.sort(strArr);
                for (String str8 : strArr) {
                    zzo();
                    Bundle[] zzb3 = zzkv.zzb(zza6.get(str8));
                    if (zzb3 != null) {
                        zza6.putParcelableArray(str8, zzb3);
                    }
                }
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    Bundle bundle3 = (Bundle) arrayList.get(i3);
                    String str9 = i3 != 0 ? "_ep" : str2;
                    bundle3.putString("_o", str5);
                    if (z2) {
                        bundle3 = zzo().zza(bundle3);
                    }
                    Bundle bundle4 = bundle3;
                    zzaq zzaq = r1;
                    zzaq zzaq2 = new zzaq(str9, new zzap(bundle4), str, j);
                    zzg().zza(zzaq, str3);
                    if (!equals) {
                        for (zzgz onEvent : this.zzd) {
                            onEvent.onEvent(str, str2, new Bundle(bundle4), j);
                            String str10 = str3;
                        }
                    }
                    i3++;
                }
                if (zzh().zza(false) != null && "_ae".equals(str2)) {
                    zzj().zza(true, true, zzl().elapsedRealtime());
                }
            }
        } else {
            zzq().zzv().zza("Dropping non-safelisted event. event name, origin", str6, str5);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zza();
        zzb(str, str2, zzl().currentTimeMillis(), bundle, false, true, false, str3);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (zzs().zza(zzas.zzbu)) {
            String str4 = str2;
            if (zzkv.zzc(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
                zzh().zza(bundle2, j);
                return;
            }
        } else {
            String str5 = str2;
        }
        long j2 = j;
        zzb(str3, str2, j, bundle2, z2, !z2 || this.zzc == null || zzkv.zzd(str2), !z, (String) null);
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, true, zzl().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int i2;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z) {
            i = zzo().zzb(str2);
        } else {
            zzkv zzo = zzo();
            if (zzo.zza("user property", str2)) {
                if (!zzo.zza("user property", zzgx.zza, str2)) {
                    i = 15;
                } else if (zzo.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzo();
            this.zzy.zzh().zza(this.zzn, i, "_ev", zzkv.zza(str2, 24, true), str2 != null ? str2.length() : 0);
        } else if (obj != null) {
            int zzb2 = zzo().zzb(str2, obj);
            if (zzb2 != 0) {
                zzo();
                String zza2 = zzkv.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                } else {
                    i2 = 0;
                }
                this.zzy.zzh().zza(this.zzn, zzb2, "_ev", zza2, i2);
                return;
            }
            Object zzc2 = zzo().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzp().zza((Runnable) new zzhi(this, str, str2, obj, j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzc()
            r8.zzv()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0060
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0050
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0050
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0035
            r4 = r2
            goto L_0x0037
        L_0x0035:
            r4 = 0
        L_0x0037:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzfc r0 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzn
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004b
            java.lang.String r11 = "true"
        L_0x004b:
            r0.zza(r11)
            r6 = r10
            goto L_0x005e
        L_0x0050:
            if (r11 != 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzfc r10 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzn
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L_0x005e:
            r3 = r1
            goto L_0x0062
        L_0x0060:
            r3 = r10
            r6 = r11
        L_0x0062:
            com.google.android.gms.measurement.internal.zzfu r10 = r8.zzy
            boolean r10 = r10.zzaa()
            if (r10 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzeq r9 = r8.zzq()
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzw()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x0078:
            com.google.android.gms.measurement.internal.zzfu r10 = r8.zzy
            boolean r10 = r10.zzaf()
            if (r10 != 0) goto L_0x0081
            return
        L_0x0081:
            com.google.android.gms.measurement.internal.zzku r10 = new com.google.android.gms.measurement.internal.zzku
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzir r9 = r8.zzg()
            r9.zza((com.google.android.gms.measurement.internal.zzku) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhb.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzku> zza(boolean z) {
        zzv();
        zzq().zzw().zza("Getting user properties (FE)");
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzw.zza()) {
            zzq().zze().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, 5000, "get user properties", new zzhl(this, atomicReference, z));
            List<zzku> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzq().zze().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final void zza(@Nullable String str) {
        this.zzf.set(str);
    }

    public final void zza(long j, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Resetting analytics data (FE)");
        zzjx zzj2 = zzj();
        zzj2.zzc();
        zzj2.zzb.zza();
        boolean zzaa = this.zzy.zzaa();
        zzfc zzr = zzr();
        zzr.zzh.zza(j);
        if (!TextUtils.isEmpty(zzr.zzr().zzu.zza())) {
            zzr.zzu.zza((String) null);
        }
        if (zznj.zzb() && zzr.zzs().zza(zzas.zzbp)) {
            zzr.zzp.zza(0);
        }
        if (!zzr.zzs().zzf()) {
            zzr.zzb(!zzaa);
        }
        zzr.zzv.zza((String) null);
        zzr.zzw.zza(0);
        zzr.zzx.zza((Bundle) null);
        if (z) {
            zzg().zzac();
        }
        if (zznj.zzb() && zzs().zza(zzas.zzbp)) {
            zzj().zza.zza();
        }
        this.zzm = !zzaa;
    }

    @WorkerThread
    public final void zza(zzgw zzgw) {
        zzgw zzgw2;
        zzc();
        zzv();
        if (!(zzgw == null || zzgw == (zzgw2 = this.zzc))) {
            Preconditions.checkState(zzgw2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzgw;
    }

    public final void zza(zzgz zzgz) {
        zzv();
        Preconditions.checkNotNull(zzgz);
        if (!this.zzd.add(zzgz)) {
            zzq().zzh().zza("OnEventListener already registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzl().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzq().zzh().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgs.zza(bundle2, "app_id", cls2, null);
        zzgs.zza(bundle2, "origin", cls2, null);
        zzgs.zza(bundle2, "name", cls2, null);
        zzgs.zza(bundle2, "value", Object.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls2, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls, 0L);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls2, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls2, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls, 0L);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls2, null);
        zzgs.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzo().zzb(string) != 0) {
            zzq().zze().zza("Invalid conditional user property name", zzn().zzc(string));
        } else if (zzo().zzb(string, obj) != 0) {
            zzq().zze().zza("Invalid conditional user property value", zzn().zzc(string), obj);
        } else {
            Object zzc2 = zzo().zzc(string, obj);
            if (zzc2 == null) {
                zzq().zze().zza("Unable to normalize conditional user property value", zzn().zzc(string), obj);
                return;
            }
            zzgs.zza(bundle2, zzc2);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzq().zze().zza("Invalid conditional user property time to live", zzn().zzc(string), Long.valueOf(j3));
                } else {
                    zzp().zza((Runnable) new zzhn(this, bundle2));
                }
            } else {
                zzq().zze().zza("Invalid conditional user property timeout", zzn().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzw.zza()) {
            zzq().zze().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, 5000, "get conditional user properties", new zzho(this, atomicReference, (String) null, str, str2));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzkv.zzb((List<zzz>) list);
            }
            zzq().zze().zza("Timed out waiting for get conditional user properties", (Object) null);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzw.zza()) {
            zzq().zze().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, 5000, "get user properties", new zzhr(this, atomicReference, (String) null, str, str2, z));
            List<zzku> list = (List) atomicReference.get();
            if (list == null) {
                zzq().zze().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzku zzku : list) {
                arrayMap.put(zzku.zza, zzku.zza());
            }
            return arrayMap;
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
