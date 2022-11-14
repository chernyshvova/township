package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgz;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public class AppMeasurementSdk {
    public final zzag zza;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public static final class ConditionalUserProperty {
        @KeepForSdk
        public static final String ACTIVE = "active";
        @KeepForSdk
        public static final String CREATION_TIMESTAMP = "creation_timestamp";
        @KeepForSdk
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";
        @KeepForSdk
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
        @KeepForSdk
        public static final String NAME = "name";
        @KeepForSdk
        public static final String ORIGIN = "origin";
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
        @KeepForSdk
        public static final String TIME_TO_LIVE = "time_to_live";
        @KeepForSdk
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
        @KeepForSdk
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
        @KeepForSdk
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
        @KeepForSdk
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
        @KeepForSdk
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";
        @KeepForSdk
        public static final String VALUE = "value";
    }

    @ShowFirstParty
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public interface EventInterceptor extends zzgw {
        @WorkerThread
        @ShowFirstParty
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    @ShowFirstParty
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public interface OnEventListener extends zzgz {
        @WorkerThread
        @ShowFirstParty
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    public AppMeasurementSdk(zzag zzag) {
        this.zza = zzag;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @ShowFirstParty
    @KeepForSdk
    public static AppMeasurementSdk getInstance(@NonNull Context context) {
        return zzag.zza(context).zza();
    }

    @KeepForSdk
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zza.zzb(str);
    }

    @KeepForSdk
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    @KeepForSdk
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zza.zzc(str);
    }

    @KeepForSdk
    public long generateEventId() {
        return this.zza.zze();
    }

    @KeepForSdk
    public String getAppIdOrigin() {
        return this.zza.zzi();
    }

    @KeepForSdk
    @Nullable
    public String getAppInstanceId() {
        return this.zza.zzd();
    }

    @WorkerThread
    @KeepForSdk
    public List<Bundle> getConditionalUserProperties(@Nullable String str, @Size(max = 23, min = 1) @Nullable String str2) {
        return this.zza.zzb(str, str2);
    }

    @KeepForSdk
    @Nullable
    public String getCurrentScreenClass() {
        return this.zza.zzg();
    }

    @KeepForSdk
    @Nullable
    public String getCurrentScreenName() {
        return this.zza.zzf();
    }

    @KeepForSdk
    @Nullable
    public String getGmpAppId() {
        return this.zza.zzc();
    }

    @WorkerThread
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zza.zzd(str);
    }

    @WorkerThread
    @KeepForSdk
    public Map<String, Object> getUserProperties(@Nullable String str, @Size(max = 24, min = 1) @Nullable String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    @KeepForSdk
    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    @KeepForSdk
    public void performAction(Bundle bundle) {
        this.zza.zza(bundle, false);
    }

    @KeepForSdk
    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zza.zza(bundle, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zza((zzgz) onEventListener);
    }

    @KeepForSdk
    public void setConditionalUserProperty(@NonNull Bundle bundle) {
        this.zza.zza(bundle);
    }

    @KeepForSdk
    public void setConsent(Bundle bundle) {
        this.zza.zzb(bundle);
    }

    @KeepForSdk
    public void setCurrentScreen(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        this.zza.zza(activity, str, str2);
    }

    @WorkerThread
    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zza.zza((zzgw) eventInterceptor);
    }

    @KeepForSdk
    public void setMeasurementEnabled(boolean z) {
        this.zza.zza(Boolean.valueOf(z));
    }

    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        this.zza.zza(str, str2, obj, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzb((zzgz) onEventListener);
    }

    public final void zza(boolean z) {
        this.zza.zza(z);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static AppMeasurementSdk getInstance(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, Bundle bundle) {
        return zzag.zza(context, str, str2, str3, bundle).zza();
    }

    @KeepForSdk
    public void setMeasurementEnabled(@Nullable Boolean bool) {
        this.zza.zza(bool);
    }
}
