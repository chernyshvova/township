package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfu;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzia;
import com.google.android.gms.measurement.internal.zzig;
import com.google.android.gms.measurement.internal.zzku;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class AppMeasurement {
    @ShowFirstParty
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";
    @ShowFirstParty
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";
    @ShowFirstParty
    @KeepForSdk
    public static final String FIAM_ORIGIN = "fiam";
    public static volatile AppMeasurement zza;
    public final zzfu zzb;
    public final zzia zzc;
    public final boolean zzd;

    @ShowFirstParty
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
    public static class ConditionalUserProperty {
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public boolean mActive;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public String mAppId;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public String mName;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public String mOrigin;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public String mTriggerEventName;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mTriggeredTimestamp;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public Object mValue;

        @KeepForSdk
        public ConditionalUserProperty() {
        }

        @VisibleForTesting
        public final Bundle zza() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                zzgs.zza(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str4);
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, this.mTriggeredTimestamp);
            return bundle;
        }

        @KeepForSdk
        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                Object zza = zzig.zza(obj);
                this.mValue = zza;
                if (zza == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }

        @VisibleForTesting
        public ConditionalUserProperty(@NonNull Bundle bundle) {
            Class cls = Long.class;
            Class cls2 = String.class;
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzgs.zza(bundle, "app_id", cls2, null);
            this.mOrigin = (String) zzgs.zza(bundle, "origin", cls2, null);
            this.mName = (String) zzgs.zza(bundle, "name", cls2, null);
            this.mValue = zzgs.zza(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls2, null);
            this.mTriggerTimeout = ((Long) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls, 0L)).longValue();
            this.mTimedOutEventName = (String) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls2, null);
            this.mTimedOutEventParams = (Bundle) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
            this.mTriggeredEventName = (String) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls2, null);
            this.mTriggeredEventParams = (Bundle) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
            this.mTimeToLive = ((Long) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls, 0L)).longValue();
            this.mExpiredEventName = (String) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls2, null);
            this.mExpiredEventParams = (Bundle) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
            this.mActive = ((Boolean) zzgs.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, cls, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzgs.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, cls, 0L)).longValue();
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
    public interface EventInterceptor extends zzgw {
        @WorkerThread
        @ShowFirstParty
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    @ShowFirstParty
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
    public interface OnEventListener extends zzgz {
        @WorkerThread
        @ShowFirstParty
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    public AppMeasurement(zzfu zzfu) {
        Preconditions.checkNotNull(zzfu);
        this.zzb = zzfu;
        this.zzc = null;
        this.zzd = false;
    }

    @ShowFirstParty
    @Keep
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zza(context, (String) null, (String) null);
    }

    @VisibleForTesting
    public static AppMeasurement zza(Context context, String str, String str2) {
        if (zza == null) {
            synchronized (AppMeasurement.class) {
                if (zza == null) {
                    zzia zza2 = zza(context, (Bundle) null);
                    if (zza2 != null) {
                        zza = new AppMeasurement(zza2);
                    } else {
                        zza = new AppMeasurement(zzfu.zza(context, new zzae(0, 0, true, (String) null, (String) null, (String) null, (Bundle) null), (Long) null));
                    }
                }
            }
        }
        return zza;
    }

    @Keep
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        if (this.zzd) {
            this.zzc.zza(str);
        } else {
            this.zzb.zzy().zza(str, this.zzb.zzl().elapsedRealtime());
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Keep
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (this.zzd) {
            this.zzc.zzb(str, str2, bundle);
        } else {
            this.zzb.zzg().zzc(str, str2, bundle);
        }
    }

    @Keep
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        if (this.zzd) {
            this.zzc.zzb(str);
        } else {
            this.zzb.zzy().zzb(str, this.zzb.zzl().elapsedRealtime());
        }
    }

    @Keep
    public long generateEventId() {
        if (this.zzd) {
            return this.zzc.zze();
        }
        return this.zzb.zzh().zzf();
    }

    @Keep
    @Nullable
    public String getAppInstanceId() {
        if (this.zzd) {
            return this.zzc.zzc();
        }
        return this.zzb.zzg().zzag();
    }

    @KeepForSdk
    public Boolean getBoolean() {
        if (this.zzd) {
            return (Boolean) this.zzc.zza(4);
        }
        return this.zzb.zzg().zzab();
    }

    @WorkerThread
    @ShowFirstParty
    @Keep
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(@Nullable String str, @Size(max = 23, min = 1) @Nullable String str2) {
        List<Bundle> list;
        int i;
        if (this.zzd) {
            list = this.zzc.zza(str, str2);
        } else {
            list = this.zzb.zzg().zza(str, str2);
        }
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        ArrayList arrayList = new ArrayList(i);
        for (Bundle conditionalUserProperty : list) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    @Keep
    @Nullable
    public String getCurrentScreenClass() {
        if (this.zzd) {
            return this.zzc.zzb();
        }
        return this.zzb.zzg().zzaj();
    }

    @Keep
    @Nullable
    public String getCurrentScreenName() {
        if (this.zzd) {
            return this.zzc.zza();
        }
        return this.zzb.zzg().zzai();
    }

    @KeepForSdk
    public Double getDouble() {
        if (this.zzd) {
            return (Double) this.zzc.zza(2);
        }
        return this.zzb.zzg().zzaf();
    }

    @Keep
    @Nullable
    public String getGmpAppId() {
        if (this.zzd) {
            return this.zzc.zzd();
        }
        return this.zzb.zzg().zzak();
    }

    @KeepForSdk
    public Integer getInteger() {
        if (this.zzd) {
            return (Integer) this.zzc.zza(3);
        }
        return this.zzb.zzg().zzae();
    }

    @KeepForSdk
    public Long getLong() {
        if (this.zzd) {
            return (Long) this.zzc.zza(1);
        }
        return this.zzb.zzg().zzad();
    }

    @WorkerThread
    @ShowFirstParty
    @Keep
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        if (this.zzd) {
            return this.zzc.zzc(str);
        }
        this.zzb.zzg();
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @KeepForSdk
    public String getString() {
        if (this.zzd) {
            return (String) this.zzc.zza(0);
        }
        return this.zzb.zzg().zzac();
    }

    @WorkerThread
    @ShowFirstParty
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        if (this.zzd) {
            return this.zzc.zza((String) null, (String) null, z);
        }
        List<zzku> zza2 = this.zzb.zzg().zza(z);
        ArrayMap arrayMap = new ArrayMap(zza2.size());
        for (zzku next : zza2) {
            arrayMap.put(next.zza, next.zza());
        }
        return arrayMap;
    }

    @ShowFirstParty
    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.zzd) {
            this.zzc.zza(str, str2, bundle);
        } else {
            this.zzb.zzg().zza(str, str2, bundle);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        if (this.zzd) {
            this.zzc.zza(str, str2, bundle, j);
        } else {
            this.zzb.zzg().zza(str, str2, bundle, true, false, j);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        if (this.zzd) {
            this.zzc.zza((zzgz) onEventListener);
        } else {
            this.zzb.zzg().zza((zzgz) onEventListener);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        if (this.zzd) {
            this.zzc.zza(conditionalUserProperty.zza());
        } else {
            this.zzb.zzg().zza(conditionalUserProperty.zza());
        }
    }

    @WorkerThread
    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        if (this.zzd) {
            this.zzc.zza((zzgw) eventInterceptor);
        } else {
            this.zzb.zzg().zza((zzgw) eventInterceptor);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        if (this.zzd) {
            this.zzc.zzb((zzgz) onEventListener);
        } else {
            this.zzb.zzg().zzb((zzgz) onEventListener);
        }
    }

    public AppMeasurement(zzia zzia) {
        Preconditions.checkNotNull(zzia);
        this.zzc = zzia;
        this.zzb = null;
        this.zzd = true;
    }

    @WorkerThread
    @Keep
    @VisibleForTesting
    public Map<String, Object> getUserProperties(@Nullable String str, @Size(max = 24, min = 1) @Nullable String str2, boolean z) {
        if (this.zzd) {
            return this.zzc.zza(str, str2, z);
        }
        return this.zzb.zzg().zza(str, str2, z);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.measurement.internal.zzia zza(android.content.Context r7, android.os.Bundle r8) {
        /*
            r8 = 0
            java.lang.String r0 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0027 }
            java.lang.String r1 = "getScionFrontendApiImplementation"
            r2 = 2
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{  }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r5 = 0
            r3[r5] = r4     // Catch:{  }
            java.lang.Class<android.os.Bundle> r4 = android.os.Bundle.class
            r6 = 1
            r3[r6] = r4     // Catch:{  }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r3)     // Catch:{  }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{  }
            r1[r5] = r7     // Catch:{  }
            r1[r6] = r8     // Catch:{  }
            java.lang.Object r7 = r0.invoke(r8, r1)     // Catch:{  }
            com.google.android.gms.measurement.internal.zzia r7 = (com.google.android.gms.measurement.internal.zzia) r7     // Catch:{  }
            return r7
        L_0x0027:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.zza(android.content.Context, android.os.Bundle):com.google.android.gms.measurement.internal.zzia");
    }
}
