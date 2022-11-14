package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzab;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.internal.measurement.zzw;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Map;

@DynamiteApi
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public class AppMeasurementDynamiteService extends zzu {
    @VisibleForTesting
    public zzfu zza = null;
    @GuardedBy("listenerMap")
    public final Map<Integer, zzgz> zzb = new ArrayMap();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
    public class zza implements zzgw {
        public zzab zza;

        public zza(zzab zzab) {
            this.zza = zzab;
        }

        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzq().zzh().zza("Event interceptor threw exception", e);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
    public class zzb implements zzgz {
        public zzab zza;

        public zzb(zzab zzab) {
            this.zza = zzab;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzq().zzh().zza("Event listener threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzy().zza(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzg().zzc(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) throws RemoteException {
        zza();
        this.zza.zzg().zza((Boolean) null);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzy().zzb(str, j);
    }

    public void generateEventId(zzw zzw) throws RemoteException {
        zza();
        this.zza.zzh().zza(zzw, this.zza.zzh().zzf());
    }

    public void getAppInstanceId(zzw zzw) throws RemoteException {
        zza();
        this.zza.zzp().zza((Runnable) new zzh(this, zzw));
    }

    public void getCachedAppInstanceId(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzg().zzag());
    }

    public void getConditionalUserProperties(String str, String str2, zzw zzw) throws RemoteException {
        zza();
        this.zza.zzp().zza((Runnable) new zzk(this, zzw, str, str2));
    }

    public void getCurrentScreenClass(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzg().zzaj());
    }

    public void getCurrentScreenName(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzg().zzai());
    }

    public void getGmpAppId(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzg().zzak());
    }

    public void getMaxUserProperties(String str, zzw zzw) throws RemoteException {
        zza();
        this.zza.zzg();
        Preconditions.checkNotEmpty(str);
        this.zza.zzh().zza(zzw, 25);
    }

    public void getTestFlag(zzw zzw, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzh().zza(zzw, this.zza.zzg().zzac());
        } else if (i == 1) {
            this.zza.zzh().zza(zzw, this.zza.zzg().zzad().longValue());
        } else if (i == 2) {
            zzkv zzh = this.zza.zzh();
            double doubleValue = this.zza.zzg().zzaf().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, doubleValue);
            try {
                zzw.zza(bundle);
            } catch (RemoteException e) {
                zzh.zzy.zzq().zzh().zza("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzh().zza(zzw, this.zza.zzg().zzae().intValue());
        } else if (i == 4) {
            this.zza.zzh().zza(zzw, this.zza.zzg().zzab().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzw zzw) throws RemoteException {
        zza();
        this.zza.zzp().zza((Runnable) new zzi(this, zzw, str, str2, z));
    }

    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzae zzae, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfu zzfu = this.zza;
        if (zzfu == null) {
            this.zza = zzfu.zza(context, zzae, Long.valueOf(j));
        } else {
            zzfu.zzq().zzh().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzw zzw) throws RemoteException {
        zza();
        this.zza.zzp().zza((Runnable) new zzm(this, zzw));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzg().zza(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzw zzw, long j) throws RemoteException {
        Bundle bundle2;
        zza();
        Preconditions.checkNotEmpty(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.zza.zzp().zza((Runnable) new zzj(this, zzw, new zzaq(str2, new zzap(bundle), "app", j), str));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zza();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzq().zza(i, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzhy zzhy = this.zza.zzg().zza;
        if (zzhy != null) {
            this.zza.zzg().zzaa();
            zzhy.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhy = this.zza.zzg().zza;
        if (zzhy != null) {
            this.zza.zzg().zzaa();
            zzhy.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhy = this.zza.zzg().zza;
        if (zzhy != null) {
            this.zza.zzg().zzaa();
            zzhy.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhy = this.zza.zzg().zza;
        if (zzhy != null) {
            this.zza.zzg().zzaa();
            zzhy.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzw zzw, long j) throws RemoteException {
        zza();
        zzhy zzhy = this.zza.zzg().zza;
        Bundle bundle = new Bundle();
        if (zzhy != null) {
            this.zza.zzg().zzaa();
            zzhy.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzq().zzh().zza("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhy = this.zza.zzg().zza;
        if (zzhy != null) {
            this.zza.zzg().zzaa();
            zzhy.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhy = this.zza.zzg().zza;
        if (zzhy != null) {
            this.zza.zzg().zzaa();
            zzhy.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void performAction(Bundle bundle, zzw zzw, long j) throws RemoteException {
        zza();
        zzw.zza((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzab zzab) throws RemoteException {
        zzgz zzgz;
        zza();
        synchronized (this.zzb) {
            zzgz = this.zzb.get(Integer.valueOf(zzab.zza()));
            if (zzgz == null) {
                zzgz = new zzb(zzab);
                this.zzb.put(Integer.valueOf(zzab.zza()), zzgz);
            }
        }
        this.zza.zzg().zza(zzgz);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        zzhb zzg = this.zza.zzg();
        zzg.zza((String) null);
        zzg.zzp().zza((Runnable) new zzhk(zzg, j));
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzq().zze().zza("Conditional user property must not be null");
        } else {
            this.zza.zzg().zza(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) throws RemoteException {
        zza();
        zzhb zzg = this.zza.zzg();
        if (zzml.zzb() && zzg.zzs().zzd((String) null, zzas.zzcg)) {
            zzg.zza(bundle, 30, j);
        }
    }

    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zza();
        zzhb zzg = this.zza.zzg();
        if (zzml.zzb() && zzg.zzs().zzd((String) null, zzas.zzch)) {
            zzg.zza(bundle, 10, j);
        }
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzu().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        zzhb zzg = this.zza.zzg();
        zzg.zzv();
        zzg.zzp().zza((Runnable) new zzhf(zzg, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        zza();
        zzhb zzg = this.zza.zzg();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzg.zzp().zza((Runnable) new zzha(zzg, bundle2));
    }

    public void setEventInterceptor(zzab zzab) throws RemoteException {
        zza();
        zza zza2 = new zza(zzab);
        if (this.zza.zzp().zzf()) {
            this.zza.zzg().zza((zzgw) zza2);
        } else {
            this.zza.zzp().zza((Runnable) new zzl(this, zza2));
        }
    }

    public void setInstanceIdProvider(zzac zzac) throws RemoteException {
        zza();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzg().zza(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        zzhb zzg = this.zza.zzg();
        zzg.zzp().zza((Runnable) new zzhh(zzg, j));
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        zzhb zzg = this.zza.zzg();
        zzg.zzp().zza((Runnable) new zzhg(zzg, j));
    }

    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzg().zza((String) null, "_id", (Object) str, true, j);
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzg().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzab zzab) throws RemoteException {
        zzgz remove;
        zza();
        synchronized (this.zzb) {
            remove = this.zzb.remove(Integer.valueOf(zzab.zza()));
        }
        if (remove == null) {
            remove = new zzb(zzab);
        }
        this.zza.zzg().zzb(remove);
    }

    private final void zza(zzw zzw, String str) {
        this.zza.zzh().zza(zzw, str);
    }
}
