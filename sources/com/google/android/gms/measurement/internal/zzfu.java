package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzdh;
import com.google.android.gms.internal.measurement.zzml;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class zzfu implements zzgt {
    public static volatile zzfu zzb;
    @VisibleForTesting
    public final long zza;
    public Boolean zzaa;
    public long zzab;
    public volatile Boolean zzac;
    @VisibleForTesting
    public Boolean zzad;
    @VisibleForTesting
    public Boolean zzae;
    public volatile boolean zzaf;
    public int zzag;
    public AtomicInteger zzah = new AtomicInteger(0);
    public final Context zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final boolean zzg;
    public final zzw zzh;
    public final zzab zzi;
    public final zzfc zzj;
    public final zzeq zzk;
    public final zzfr zzl;
    public final zzjx zzm;
    public final zzkv zzn;
    public final zzeo zzo;
    public final Clock zzp;
    public final zzii zzq;
    public final zzhb zzr;
    public final zza zzs;
    public final zzid zzt;
    public zzem zzu;
    public zzir zzv;
    public zzak zzw;
    public zzen zzx;
    public zzfl zzy;
    public boolean zzz = false;

    public zzfu(zzgy zzgy) {
        long j;
        Bundle bundle;
        boolean z = false;
        Preconditions.checkNotNull(zzgy);
        zzw zzw2 = new zzw(zzgy.zza);
        this.zzh = zzw2;
        zzeg.zza = zzw2;
        this.zzc = zzgy.zza;
        this.zzd = zzgy.zzb;
        this.zze = zzgy.zzc;
        this.zzf = zzgy.zzd;
        this.zzg = zzgy.zzh;
        this.zzac = zzgy.zze;
        this.zzaf = true;
        zzae zzae2 = zzgy.zzg;
        if (!(zzae2 == null || (bundle = zzae2.zzg) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzae2.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        zzdh.zza(this.zzc);
        Clock instance = DefaultClock.getInstance();
        this.zzp = instance;
        Long l = zzgy.zzi;
        if (l != null) {
            j = l.longValue();
        } else {
            j = instance.currentTimeMillis();
        }
        this.zza = j;
        this.zzi = new zzab(this);
        zzfc zzfc = new zzfc(this);
        zzfc.zzac();
        this.zzj = zzfc;
        zzeq zzeq = new zzeq(this);
        zzeq.zzac();
        this.zzk = zzeq;
        zzkv zzkv = new zzkv(this);
        zzkv.zzac();
        this.zzn = zzkv;
        zzeo zzeo = new zzeo(this);
        zzeo.zzac();
        this.zzo = zzeo;
        this.zzs = new zza(this);
        zzii zzii = new zzii(this);
        zzii.zzw();
        this.zzq = zzii;
        zzhb zzhb = new zzhb(this);
        zzhb.zzw();
        this.zzr = zzhb;
        zzjx zzjx = new zzjx(this);
        zzjx.zzw();
        this.zzm = zzjx;
        zzid zzid = new zzid(this);
        zzid.zzac();
        this.zzt = zzid;
        zzfr zzfr = new zzfr(this);
        zzfr.zzac();
        this.zzl = zzfr;
        zzae zzae3 = zzgy.zzg;
        if (!(zzae3 == null || zzae3.zzb == 0)) {
            z = true;
        }
        boolean z2 = !z;
        if (this.zzc.getApplicationContext() instanceof Application) {
            zzhb zzg2 = zzg();
            if (zzg2.zzm().getApplicationContext() instanceof Application) {
                Application application = (Application) zzg2.zzm().getApplicationContext();
                if (zzg2.zza == null) {
                    zzg2.zza = new zzhy(zzg2, (zzhc) null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzg2.zza);
                    application.registerActivityLifecycleCallbacks(zzg2.zza);
                    zzg2.zzq().zzw().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzq().zzh().zza("Application context is not an Application");
        }
        this.zzl.zza((Runnable) new zzfw(this, zzgy));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzgy zzgy) {
        zzes zzes;
        String str;
        zzp().zzc();
        zzak zzak = new zzak(this);
        zzak.zzac();
        this.zzw = zzak;
        zzen zzen = new zzen(this, zzgy.zzf);
        zzen.zzw();
        this.zzx = zzen;
        zzem zzem = new zzem(this);
        zzem.zzw();
        this.zzu = zzem;
        zzir zzir = new zzir(this);
        zzir.zzw();
        this.zzv = zzir;
        this.zzn.zzad();
        this.zzj.zzad();
        this.zzy = new zzfl(this);
        this.zzx.zzx();
        zzq().zzu().zza("App measurement initialized, version", 33025L);
        zzq().zzu().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzaa2 = zzen.zzaa();
        if (TextUtils.isEmpty(this.zzd)) {
            if (zzh().zze(zzaa2)) {
                zzes = zzq().zzu();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzes zzu2 = zzq().zzu();
                String valueOf = String.valueOf(zzaa2);
                zzes zzes2 = zzu2;
                str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzes = zzes2;
            }
            zzes.zza(str);
        }
        zzq().zzv().zza("Debug-level message logging enabled");
        if (this.zzag != this.zzah.get()) {
            zzq().zze().zza("Not all components initialized", Integer.valueOf(this.zzag), Integer.valueOf(this.zzah.get()));
        }
        this.zzz = true;
    }

    private final zzid zzah() {
        zzb((zzgq) this.zzt);
        return this.zzt;
    }

    @WorkerThread
    public final boolean zzaa() {
        return zzab() == 0;
    }

    @WorkerThread
    public final int zzab() {
        zzp().zzc();
        if (this.zzi.zzf()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (zzml.zzb() && this.zzi.zza(zzas.zzcg) && !zzac()) {
            return 8;
        }
        Boolean zzu2 = zzb().zzu();
        if (zzu2 == null) {
            Boolean zzf2 = this.zzi.zzf("firebase_analytics_collection_enabled");
            if (zzf2 == null) {
                Boolean bool2 = this.zzad;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                    return 6;
                } else {
                    if (!this.zzi.zza(zzas.zzar) || this.zzac == null || this.zzac.booleanValue()) {
                        return 0;
                    }
                    return 7;
                }
            } else if (zzf2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzu2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @WorkerThread
    public final boolean zzac() {
        zzp().zzc();
        return this.zzaf;
    }

    public final void zzad() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    public final void zzae() {
        this.zzah.incrementAndGet();
    }

    @WorkerThread
    public final boolean zzaf() {
        if (this.zzz) {
            zzp().zzc();
            Boolean bool = this.zzaa;
            if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
                this.zzab = this.zzp.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzh().zzc("android.permission.INTERNET") && zzh().zzc("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzy() || (zzfm.zza(this.zzc) && zzkv.zza(this.zzc, false))));
                this.zzaa = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzh().zza(zzx().zzab(), zzx().zzac(), zzx().zzad()) && TextUtils.isEmpty(zzx().zzac())) {
                        z = false;
                    }
                    this.zzaa = Boolean.valueOf(z);
                }
            }
            return this.zzaa.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @WorkerThread
    public final void zzag() {
        zzp().zzc();
        zzb((zzgq) zzah());
        String zzaa2 = zzx().zzaa();
        Pair<String, Boolean> zza2 = zzb().zza(zzaa2);
        if (!this.zzi.zzg().booleanValue() || ((Boolean) zza2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza2.first)) {
            zzq().zzv().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!zzah().zzf()) {
            zzq().zzh().zza("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            zzkv zzh2 = zzh();
            zzx();
            URL zza3 = zzh2.zza(33025, zzaa2, (String) zza2.first, zzb().zzt.zza() - 1);
            zzid zzah2 = zzah();
            zzfx zzfx = new zzfx(this);
            zzah2.zzc();
            zzah2.zzab();
            Preconditions.checkNotNull(zza3);
            Preconditions.checkNotNull(zzfx);
            zzah2.zzp().zzc((Runnable) new zzif(zzah2, zzaa2, zza3, (byte[]) null, (Map<String, String>) null, zzfx));
        }
    }

    public final zzfc zzb() {
        zza((zzgr) this.zzj);
        return this.zzj;
    }

    public final zzeq zzc() {
        zzeq zzeq = this.zzk;
        if (zzeq == null || !zzeq.zzaa()) {
            return null;
        }
        return this.zzk;
    }

    public final zzjx zzd() {
        zzb((zzg) this.zzm);
        return this.zzm;
    }

    public final zzfl zze() {
        return this.zzy;
    }

    public final zzfr zzf() {
        return this.zzl;
    }

    public final zzhb zzg() {
        zzb((zzg) this.zzr);
        return this.zzr;
    }

    public final zzkv zzh() {
        zza((zzgr) this.zzn);
        return this.zzn;
    }

    public final zzeo zzi() {
        zza((zzgr) this.zzo);
        return this.zzo;
    }

    public final zzem zzj() {
        zzb((zzg) this.zzu);
        return this.zzu;
    }

    public final boolean zzk() {
        return TextUtils.isEmpty(this.zzd);
    }

    public final Clock zzl() {
        return this.zzp;
    }

    public final Context zzm() {
        return this.zzc;
    }

    public final String zzn() {
        return this.zzd;
    }

    public final String zzo() {
        return this.zze;
    }

    public final zzfr zzp() {
        zzb((zzgq) this.zzl);
        return this.zzl;
    }

    public final zzeq zzq() {
        zzb((zzgq) this.zzk);
        return this.zzk;
    }

    public final String zzr() {
        return this.zzf;
    }

    public final boolean zzs() {
        return this.zzg;
    }

    public final zzw zzt() {
        return this.zzh;
    }

    public final zzii zzu() {
        zzb((zzg) this.zzq);
        return this.zzq;
    }

    public final zzir zzv() {
        zzb((zzg) this.zzv);
        return this.zzv;
    }

    public final zzak zzw() {
        zzb((zzgq) this.zzw);
        return this.zzw;
    }

    public final zzen zzx() {
        zzb((zzg) this.zzx);
        return this.zzx;
    }

    public final zza zzy() {
        zza zza2 = this.zzs;
        if (zza2 != null) {
            return zza2;
        }
        throw new IllegalStateException("Component not created");
    }

    @WorkerThread
    public final boolean zzz() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    public static void zzb(zzgq zzgq) {
        if (zzgq == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgq.zzaa()) {
            String valueOf = String.valueOf(zzgq.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    public static void zzb(zzg zzg2) {
        if (zzg2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzg2.zzu()) {
            String valueOf = String.valueOf(zzg2.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    @WorkerThread
    public final void zzb(boolean z) {
        zzp().zzc();
        this.zzaf = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        if (r10.equals(com.google.android.gms.measurement.internal.zzac.zza) == false) goto L_0x009a;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.measurement.zzae r10) {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzfr r0 = r9.zzp()
            r0.zzc()
            boolean r0 = com.google.android.gms.internal.measurement.zzml.zzb()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.zzab r0 = r9.zzi
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzcg
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r3)
            if (r0 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.zzfc r0 = r9.zzb()
            com.google.android.gms.measurement.internal.zzac r0 = r0.zzx()
            com.google.android.gms.measurement.internal.zzfc r3 = r9.zzb()
            int r3 = r3.zzw()
            com.google.android.gms.measurement.internal.zzab r4 = r9.zzi
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzas.zzch
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r5)
            r5 = 40
            if (r4 == 0) goto L_0x00a6
            com.google.android.gms.measurement.internal.zzab r4 = r9.zzi
            java.lang.Boolean r4 = r4.zzi()
            com.google.android.gms.measurement.internal.zzab r6 = r9.zzi
            java.lang.Boolean r6 = r6.zzj()
            r7 = 20
            if (r4 != 0) goto L_0x0047
            if (r6 == 0) goto L_0x0059
        L_0x0047:
            com.google.android.gms.measurement.internal.zzfc r8 = r9.zzb()
            boolean r8 = r8.zza((int) r7)
            if (r8 == 0) goto L_0x0059
            com.google.android.gms.measurement.internal.zzac r10 = new com.google.android.gms.measurement.internal.zzac
            r10.<init>(r4, r6)
            r5 = 20
            goto L_0x009a
        L_0x0059:
            com.google.android.gms.measurement.internal.zzen r4 = r9.zzx()
            java.lang.String r4 = r4.zzab()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0079
            r4 = 30
            if (r3 == r4) goto L_0x006d
            if (r3 != r5) goto L_0x0079
        L_0x006d:
            com.google.android.gms.measurement.internal.zzhb r10 = r9.zzg()
            com.google.android.gms.measurement.internal.zzac r3 = com.google.android.gms.measurement.internal.zzac.zza
            long r4 = r9.zza
            r10.zza((com.google.android.gms.measurement.internal.zzac) r3, (int) r7, (long) r4)
            goto L_0x0098
        L_0x0079:
            if (r10 == 0) goto L_0x0098
            android.os.Bundle r3 = r10.zzg
            if (r3 == 0) goto L_0x0098
            com.google.android.gms.measurement.internal.zzfc r3 = r9.zzb()
            boolean r3 = r3.zza((int) r5)
            if (r3 == 0) goto L_0x0098
            android.os.Bundle r10 = r10.zzg
            com.google.android.gms.measurement.internal.zzac r10 = com.google.android.gms.measurement.internal.zzac.zzb((android.os.Bundle) r10)
            com.google.android.gms.measurement.internal.zzac r3 = com.google.android.gms.measurement.internal.zzac.zza
            boolean r3 = r10.equals(r3)
            if (r3 != 0) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r10 = r2
            r5 = 0
        L_0x009a:
            if (r10 == 0) goto L_0x00ce
            com.google.android.gms.measurement.internal.zzhb r0 = r9.zzg()
            long r3 = r9.zza
            r0.zza((com.google.android.gms.measurement.internal.zzac) r10, (int) r5, (long) r3)
            goto L_0x00cd
        L_0x00a6:
            if (r10 == 0) goto L_0x00ce
            android.os.Bundle r3 = r10.zzg
            if (r3 == 0) goto L_0x00ce
            com.google.android.gms.measurement.internal.zzfc r3 = r9.zzb()
            boolean r3 = r3.zza((int) r5)
            if (r3 == 0) goto L_0x00ce
            android.os.Bundle r10 = r10.zzg
            com.google.android.gms.measurement.internal.zzac r10 = com.google.android.gms.measurement.internal.zzac.zzb((android.os.Bundle) r10)
            com.google.android.gms.measurement.internal.zzac r3 = com.google.android.gms.measurement.internal.zzac.zza
            boolean r3 = r10.equals(r3)
            if (r3 != 0) goto L_0x00ce
            com.google.android.gms.measurement.internal.zzhb r0 = r9.zzg()
            long r3 = r9.zza
            r0.zza((com.google.android.gms.measurement.internal.zzac) r10, (int) r5, (long) r3)
        L_0x00cd:
            r0 = r10
        L_0x00ce:
            com.google.android.gms.measurement.internal.zzhb r10 = r9.zzg()
            r10.zza((com.google.android.gms.measurement.internal.zzac) r0)
        L_0x00d5:
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfg r10 = r10.zzc
            long r3 = r10.zza()
            r5 = 0
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x00f4
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfg r10 = r10.zzc
            com.google.android.gms.common.util.Clock r0 = r9.zzp
            long r3 = r0.currentTimeMillis()
            r10.zza(r3)
        L_0x00f4:
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfg r10 = r10.zzh
            long r3 = r10.zza()
            java.lang.Long r10 = java.lang.Long.valueOf(r3)
            long r3 = r10.longValue()
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x0128
            com.google.android.gms.measurement.internal.zzeq r10 = r9.zzq()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzw()
            long r3 = r9.zza
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "Persisting first open"
            r10.zza(r3, r0)
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfg r10 = r10.zzh
            long r3 = r9.zza
            r10.zza(r3)
        L_0x0128:
            com.google.android.gms.measurement.internal.zzab r10 = r9.zzi
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzas.zzcc
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r0)
            if (r10 == 0) goto L_0x013b
            com.google.android.gms.measurement.internal.zzhb r10 = r9.zzg()
            com.google.android.gms.measurement.internal.zzo r10 = r10.zzb
            r10.zzb()
        L_0x013b:
            boolean r10 = r9.zzaf()
            if (r10 != 0) goto L_0x01c6
            boolean r10 = r9.zzaa()
            if (r10 == 0) goto L_0x0354
            com.google.android.gms.measurement.internal.zzkv r10 = r9.zzh()
            java.lang.String r0 = "android.permission.INTERNET"
            boolean r10 = r10.zzc(r0)
            if (r10 != 0) goto L_0x0160
            com.google.android.gms.measurement.internal.zzeq r10 = r9.zzq()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zze()
            java.lang.String r0 = "App is missing INTERNET permission"
            r10.zza(r0)
        L_0x0160:
            com.google.android.gms.measurement.internal.zzkv r10 = r9.zzh()
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r10 = r10.zzc(r0)
            if (r10 != 0) goto L_0x0179
            com.google.android.gms.measurement.internal.zzeq r10 = r9.zzq()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zze()
            java.lang.String r0 = "App is missing ACCESS_NETWORK_STATE permission"
            r10.zza(r0)
        L_0x0179:
            android.content.Context r10 = r9.zzc
            com.google.android.gms.common.wrappers.PackageManagerWrapper r10 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r10)
            boolean r10 = r10.isCallerInstantApp()
            if (r10 != 0) goto L_0x01b7
            com.google.android.gms.measurement.internal.zzab r10 = r9.zzi
            boolean r10 = r10.zzy()
            if (r10 != 0) goto L_0x01b7
            android.content.Context r10 = r9.zzc
            boolean r10 = com.google.android.gms.measurement.internal.zzfm.zza(r10)
            if (r10 != 0) goto L_0x01a2
            com.google.android.gms.measurement.internal.zzeq r10 = r9.zzq()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zze()
            java.lang.String r0 = "AppMeasurementReceiver not registered/enabled"
            r10.zza(r0)
        L_0x01a2:
            android.content.Context r10 = r9.zzc
            boolean r10 = com.google.android.gms.measurement.internal.zzkv.zza((android.content.Context) r10, (boolean) r1)
            if (r10 != 0) goto L_0x01b7
            com.google.android.gms.measurement.internal.zzeq r10 = r9.zzq()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zze()
            java.lang.String r0 = "AppMeasurementService not registered/enabled"
            r10.zza(r0)
        L_0x01b7:
            com.google.android.gms.measurement.internal.zzeq r10 = r9.zzq()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zze()
            java.lang.String r0 = "Uploading is not possible. App measurement disabled"
            r10.zza(r0)
            goto L_0x0354
        L_0x01c6:
            com.google.android.gms.measurement.internal.zzen r10 = r9.zzx()
            java.lang.String r10 = r10.zzab()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x01e2
            com.google.android.gms.measurement.internal.zzen r10 = r9.zzx()
            java.lang.String r10 = r10.zzac()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0262
        L_0x01e2:
            r9.zzh()
            com.google.android.gms.measurement.internal.zzen r10 = r9.zzx()
            java.lang.String r10 = r10.zzab()
            com.google.android.gms.measurement.internal.zzfc r0 = r9.zzb()
            java.lang.String r0 = r0.zzg()
            com.google.android.gms.measurement.internal.zzen r1 = r9.zzx()
            java.lang.String r1 = r1.zzac()
            com.google.android.gms.measurement.internal.zzfc r3 = r9.zzb()
            java.lang.String r3 = r3.zzh()
            boolean r10 = com.google.android.gms.measurement.internal.zzkv.zza((java.lang.String) r10, (java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r3)
            if (r10 == 0) goto L_0x0244
            com.google.android.gms.measurement.internal.zzeq r10 = r9.zzq()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzu()
            java.lang.String r0 = "Rechecking which service to use due to a GMP App Id change"
            r10.zza(r0)
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            r10.zzj()
            com.google.android.gms.measurement.internal.zzem r10 = r9.zzj()
            r10.zzaa()
            com.google.android.gms.measurement.internal.zzir r10 = r9.zzv
            r10.zzag()
            com.google.android.gms.measurement.internal.zzir r10 = r9.zzv
            r10.zzae()
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfg r10 = r10.zzh
            long r0 = r9.zza
            r10.zza(r0)
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzj
            r10.zza(r2)
        L_0x0244:
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzen r0 = r9.zzx()
            java.lang.String r0 = r0.zzab()
            r10.zzb((java.lang.String) r0)
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzen r0 = r9.zzx()
            java.lang.String r0 = r0.zzac()
            r10.zzc(r0)
        L_0x0262:
            boolean r10 = com.google.android.gms.internal.measurement.zzml.zzb()
            if (r10 == 0) goto L_0x0289
            com.google.android.gms.measurement.internal.zzab r10 = r9.zzi
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzas.zzcg
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r0)
            if (r10 == 0) goto L_0x0289
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzac r10 = r10.zzx()
            boolean r10 = r10.zze()
            if (r10 != 0) goto L_0x0289
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzj
            r10.zza(r2)
        L_0x0289:
            com.google.android.gms.measurement.internal.zzhb r10 = r9.zzg()
            com.google.android.gms.measurement.internal.zzfc r0 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzj
            java.lang.String r0 = r0.zza()
            r10.zza((java.lang.String) r0)
            boolean r10 = com.google.android.gms.internal.measurement.zzms.zzb()
            if (r10 == 0) goto L_0x02da
            com.google.android.gms.measurement.internal.zzab r10 = r9.zzi
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzas.zzbo
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r0)
            if (r10 == 0) goto L_0x02da
            com.google.android.gms.measurement.internal.zzkv r10 = r9.zzh()
            boolean r10 = r10.zzj()
            if (r10 != 0) goto L_0x02da
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzu
            java.lang.String r10 = r10.zza()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x02da
            com.google.android.gms.measurement.internal.zzeq r10 = r9.zzq()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzh()
            java.lang.String r0 = "Remote config removed with active feature rollouts"
            r10.zza(r0)
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzu
            r10.zza(r2)
        L_0x02da:
            com.google.android.gms.measurement.internal.zzen r10 = r9.zzx()
            java.lang.String r10 = r10.zzab()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x02f6
            com.google.android.gms.measurement.internal.zzen r10 = r9.zzx()
            java.lang.String r10 = r10.zzac()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0354
        L_0x02f6:
            boolean r10 = r9.zzaa()
            com.google.android.gms.measurement.internal.zzfc r0 = r9.zzb()
            boolean r0 = r0.zzz()
            if (r0 != 0) goto L_0x0315
            com.google.android.gms.measurement.internal.zzab r0 = r9.zzi
            boolean r0 = r0.zzf()
            if (r0 != 0) goto L_0x0315
            com.google.android.gms.measurement.internal.zzfc r0 = r9.zzb()
            r1 = r10 ^ 1
            r0.zzb((boolean) r1)
        L_0x0315:
            if (r10 == 0) goto L_0x031e
            com.google.android.gms.measurement.internal.zzhb r10 = r9.zzg()
            r10.zzah()
        L_0x031e:
            com.google.android.gms.measurement.internal.zzjx r10 = r9.zzd()
            com.google.android.gms.measurement.internal.zzkf r10 = r10.zza
            r10.zza()
            com.google.android.gms.measurement.internal.zzir r10 = r9.zzv()
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            r10.zza((java.util.concurrent.atomic.AtomicReference<java.lang.String>) r0)
            boolean r10 = com.google.android.gms.internal.measurement.zznw.zzb()
            if (r10 == 0) goto L_0x0354
            com.google.android.gms.measurement.internal.zzab r10 = r9.zzi
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzas.zzby
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r0)
            if (r10 == 0) goto L_0x0354
            com.google.android.gms.measurement.internal.zzir r10 = r9.zzv()
            com.google.android.gms.measurement.internal.zzfc r0 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfh r0 = r0.zzx
            android.os.Bundle r0 = r0.zza()
            r10.zza((android.os.Bundle) r0)
        L_0x0354:
            com.google.android.gms.measurement.internal.zzfc r10 = r9.zzb()
            com.google.android.gms.measurement.internal.zzfe r10 = r10.zzo
            com.google.android.gms.measurement.internal.zzab r0 = r9.zzi
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzax
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r1)
            r10.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfu.zza(com.google.android.gms.internal.measurement.zzae):void");
    }

    public final zzab zza() {
        return this.zzi;
    }

    public static zzfu zza(Context context, zzae zzae2, Long l) {
        Bundle bundle;
        if (zzae2 != null && (zzae2.zze == null || zzae2.zzf == null)) {
            zzae2 = new zzae(zzae2.zza, zzae2.zzb, zzae2.zzc, zzae2.zzd, (String) null, (String) null, zzae2.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzfu.class) {
                if (zzb == null) {
                    zzb = new zzfu(new zzgy(context, zzae2, l));
                }
            }
        } else if (!(zzae2 == null || (bundle = zzae2.zzg) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            zzb.zza(zzae2.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzb;
    }

    public static void zza(zzgr zzgr) {
        if (zzgr == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    @WorkerThread
    public final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    public final void zza(zzgq zzgq) {
        this.zzag++;
    }

    public final void zza(zzg zzg2) {
        this.zzag++;
    }

    public final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzq().zzh().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzb().zzs.zza(true);
        if (bArr.length == 0) {
            zzq().zzv().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", RoundRectDrawableWithShadow.COS_45);
            if (TextUtils.isEmpty(optString)) {
                zzq().zzv().zza("Deferred Deep Link is empty.");
                return;
            }
            zzkv zzh2 = zzh();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzh2.zzm().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzq().zzh().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zza("auto", "_cmp", bundle);
            zzkv zzh3 = zzh();
            if (!TextUtils.isEmpty(optString) && zzh3.zza(optString, optDouble)) {
                zzh3.zzm().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            zzq().zze().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
