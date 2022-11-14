package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class BaseGmsClient<T extends IInterface> {
    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @RecentlyNonNull
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @RecentlyNonNull
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    @RecentlyNonNull
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    public static final Feature[] zze = new Feature[0];
    @Nullable
    public volatile String zzA;
    @Nullable
    public ConnectionResult zzB;
    public boolean zzC;
    @Nullable
    public volatile zzi zzD;
    @VisibleForTesting
    public zzt zza;
    public final Handler zzb;
    @RecentlyNonNull
    @VisibleForTesting
    public ConnectionProgressReportCallbacks zzc;
    @RecentlyNonNull
    @VisibleForTesting
    public AtomicInteger zzd;
    public int zzf;
    public long zzg;
    public long zzh;
    public int zzi;
    public long zzj;
    @Nullable
    public volatile String zzk;
    public final Context zzl;
    public final Looper zzm;
    public final GmsClientSupervisor zzn;
    public final GoogleApiAvailabilityLight zzo;
    public final Object zzp;
    public final Object zzq;
    @GuardedBy("mServiceBrokerLock")
    @Nullable
    public IGmsServiceBroker zzr;
    @GuardedBy("mLock")
    @Nullable
    public T zzs;
    public final ArrayList<zzc<?>> zzt;
    @GuardedBy("mLock")
    @Nullable
    public zze zzu;
    @GuardedBy("mLock")
    public int zzv;
    @Nullable
    public final BaseConnectionCallbacks zzw;
    @Nullable
    public final BaseOnConnectionFailedListener zzx;
    public final int zzy;
    @Nullable
    public final String zzz;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface BaseConnectionCallbacks {
        @KeepForSdk
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
        @KeepForSdk
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        @KeepForSdk
        void onConnected(@Nullable Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i);
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void onConnectionFailed(@RecentlyNonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        public final void onReportServiceBinding(@RecentlyNonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService((IAccountAccessor) null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.onConnectionFailed(connectionResult);
            }
        }
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    @KeepForSdk
    @VisibleForTesting
    public BaseGmsClient(@RecentlyNonNull Context context, @RecentlyNonNull Handler handler, @RecentlyNonNull GmsClientSupervisor gmsClientSupervisor, @RecentlyNonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zzb = handler;
        this.zzm = handler.getLooper();
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = null;
    }

    public static /* synthetic */ void zzc(BaseGmsClient baseGmsClient, int i) {
        int i2;
        int i3;
        synchronized (baseGmsClient.zzp) {
            i2 = baseGmsClient.zzv;
        }
        if (i2 == 3) {
            baseGmsClient.zzC = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = baseGmsClient.zzb;
        handler.sendMessage(handler.obtainMessage(i3, baseGmsClient.zzd.get(), 16));
    }

    public static /* synthetic */ boolean zzg(BaseGmsClient baseGmsClient) {
        if (baseGmsClient.zzC || TextUtils.isEmpty(baseGmsClient.getServiceDescriptor()) || TextUtils.isEmpty(baseGmsClient.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(baseGmsClient.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean zzl(BaseGmsClient baseGmsClient, int i, int i2, IInterface iInterface) {
        synchronized (baseGmsClient.zzp) {
            if (baseGmsClient.zzv != i) {
                return false;
            }
            baseGmsClient.zzp(i2, iInterface);
            return true;
        }
    }

    public static /* synthetic */ void zzo(BaseGmsClient baseGmsClient, zzi zzi2) {
        baseGmsClient.zzD = zzi2;
        if (baseGmsClient.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzi2.zzd;
            RootTelemetryConfigManager.getInstance().zza(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.getRootTelemetryConfiguration());
        }
    }

    /* access modifiers changed from: private */
    public final void zzp(int i, @Nullable T t) {
        zzt zzt2;
        String str;
        zzt zzt3;
        boolean z = false;
        if ((i == 4) == (t != null)) {
            z = true;
        }
        Preconditions.checkArgument(z);
        synchronized (this.zzp) {
            this.zzv = i;
            this.zzs = t;
            if (i == 1) {
                zze zze2 = this.zzu;
                if (zze2 != null) {
                    GmsClientSupervisor gmsClientSupervisor = this.zzn;
                    String zza2 = this.zza.zza();
                    Preconditions.checkNotNull(zza2);
                    gmsClientSupervisor.zza(zza2, this.zza.zzb(), this.zza.zzc(), zze2, zza(), this.zza.zzd());
                    this.zzu = null;
                }
            } else if (i == 2 || i == 3) {
                zze zze3 = this.zzu;
                if (!(zze3 == null || (zzt3 = this.zza) == null)) {
                    String zza3 = zzt3.zza();
                    String zzb2 = this.zza.zzb();
                    StringBuilder sb = new StringBuilder(String.valueOf(zza3).length() + 70 + String.valueOf(zzb2).length());
                    sb.append("Calling connect() while still connected, missing disconnect() for ");
                    sb.append(zza3);
                    sb.append(" on ");
                    sb.append(zzb2);
                    Log.e("GmsClient", sb.toString());
                    GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                    String zza4 = this.zza.zza();
                    Preconditions.checkNotNull(zza4);
                    gmsClientSupervisor2.zza(zza4, this.zza.zzb(), this.zza.zzc(), zze3, zza(), this.zza.zzd());
                    this.zzd.incrementAndGet();
                }
                zze zze4 = new zze(this, this.zzd.get());
                this.zzu = zze4;
                if (this.zzv != 3 || getLocalStartServiceAction() == null) {
                    zzt2 = new zzt(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup());
                } else {
                    zzt2 = new zzt(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false);
                }
                this.zza = zzt2;
                if (!zzt2.zzd() || getMinApkVersion() >= 17895000) {
                    GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                    String zza5 = this.zza.zza();
                    Preconditions.checkNotNull(zza5);
                    if (!gmsClientSupervisor3.zzb(new zzm(zza5, this.zza.zzb(), this.zza.zzc(), this.zza.zzd()), zze4, zza())) {
                        String zza6 = this.zza.zza();
                        String zzb3 = this.zza.zzb();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(zza6).length() + 34 + String.valueOf(zzb3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(zza6);
                        sb2.append(" on ");
                        sb2.append(zzb3);
                        Log.e("GmsClient", sb2.toString());
                        zzb(16, (Bundle) null, this.zzd.get());
                    }
                } else {
                    String valueOf = String.valueOf(this.zza.zza());
                    if (valueOf.length() != 0) {
                        str = "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf);
                    } else {
                        str = new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ");
                    }
                    throw new IllegalStateException(str);
                }
            } else if (i == 4) {
                Preconditions.checkNotNull(t);
                onConnectedLocked(t);
            }
        }
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            zzp(1, (IInterface) null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, (PendingIntent) null);
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    @KeepForSdk
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public void connect(@RecentlyNonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        zzp(2, (IInterface) null);
    }

    @KeepForSdk
    @RecentlyNullable
    public abstract T createServiceInterface(@RecentlyNonNull IBinder iBinder);

    @KeepForSdk
    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i = 0; i < size; i++) {
                this.zzt.get(i).zzg();
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, (IInterface) null);
    }

    @KeepForSdk
    public void dump(@RecentlyNonNull String str, @RecentlyNonNull FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, @RecentlyNonNull String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzp) {
            i = this.zzv;
            t = this.zzs;
        }
        synchronized (this.zzq) {
            iGmsServiceBroker = this.zzr;
        }
        printWriter.append(str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.zzh;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzg > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i2 = this.zzf;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i2 != 3) {
                printWriter.append(String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzg;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzj > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzi));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzj;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    @KeepForSdk
    public boolean enableLocalFallback() {
        return false;
    }

    @KeepForSdk
    @RecentlyNullable
    public Account getAccount() {
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Feature[] getApiFeatures() {
        return zze;
    }

    @KeepForSdk
    @RecentlyNullable
    public final Feature[] getAvailableFeatures() {
        zzi zzi2 = this.zzD;
        if (zzi2 == null) {
            return null;
        }
        return zzi2.zzb;
    }

    @KeepForSdk
    @RecentlyNullable
    public Bundle getConnectionHint() {
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final Context getContext() {
        return this.zzl;
    }

    @RecentlyNonNull
    @KeepForSdk
    public String getEndpointPackageName() {
        zzt zzt2;
        if (isConnected() && (zzt2 = this.zza) != null) {
            return zzt2.zzb();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @KeepForSdk
    public int getGCoreServiceId() {
        return this.zzy;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @KeepForSdk
    @RecentlyNullable
    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    @KeepForSdk
    @RecentlyNullable
    public String getLocalStartServiceAction() {
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final Looper getLooper() {
        return this.zzm;
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @WorkerThread
    @KeepForSdk
    public void getRemoteService(@Nullable IAccountAccessor iAccountAccessor, @RecentlyNonNull Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzy, this.zzA);
        getServiceRequest.zzd = this.zzl.getPackageName();
        getServiceRequest.zzg = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzf = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.zzh = account;
            if (iAccountAccessor != null) {
                getServiceRequest.zze = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zzh = getAccount();
        }
        getServiceRequest.zzi = zze;
        getServiceRequest.zzj = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.zzm = true;
        }
        try {
            synchronized (this.zzq) {
                IGmsServiceBroker iGmsServiceBroker = this.zzr;
                if (iGmsServiceBroker != null) {
                    iGmsServiceBroker.getService(new zzd(this, this.zzd.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(3);
        } catch (SecurityException e2) {
            throw e2;
        } catch (RemoteException | RuntimeException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            onPostInitHandler(8, (IBinder) null, (Bundle) null, this.zzd.get());
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    @RecentlyNonNull
    @KeepForSdk
    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.zzp) {
            if (this.zzv != 5) {
                checkConnected();
                t = this.zzs;
                Preconditions.checkNotNull(t, "Client is connected but service is null");
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    @KeepForSdk
    @RecentlyNullable
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            IGmsServiceBroker iGmsServiceBroker = this.zzr;
            if (iGmsServiceBroker == null) {
                return null;
            }
            IBinder asBinder = iGmsServiceBroker.asBinder();
            return asBinder;
        }
    }

    @NonNull
    @KeepForSdk
    public abstract String getServiceDescriptor();

    @RecentlyNonNull
    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @NonNull
    @KeepForSdk
    public abstract String getStartServiceAction();

    @RecentlyNonNull
    @KeepForSdk
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @KeepForSdk
    @RecentlyNullable
    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzi zzi2 = this.zzD;
        if (zzi2 == null) {
            return null;
        }
        return zzi2.zzd;
    }

    @KeepForSdk
    public boolean getUseDynamicLookup() {
        return false;
    }

    @KeepForSdk
    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            z = true;
            if (i != 2) {
                if (i != 3) {
                    z = false;
                }
            }
        }
        return z;
    }

    @CallSuper
    @KeepForSdk
    public void onConnectedLocked(@RecentlyNonNull T t) {
        this.zzh = System.currentTimeMillis();
    }

    @CallSuper
    @KeepForSdk
    public void onConnectionFailed(@RecentlyNonNull ConnectionResult connectionResult) {
        this.zzi = connectionResult.getErrorCode();
        this.zzj = System.currentTimeMillis();
    }

    @CallSuper
    @KeepForSdk
    public void onConnectionSuspended(int i) {
        this.zzf = i;
        this.zzg = System.currentTimeMillis();
    }

    @KeepForSdk
    public void onPostInitHandler(int i, @Nullable IBinder iBinder, @Nullable Bundle bundle, int i2) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(this, i, iBinder, bundle)));
    }

    @KeepForSdk
    public void onUserSignOut(@RecentlyNonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    public void setAttributionTag(@RecentlyNonNull String str) {
        this.zzA = str;
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.zzd.get(), i));
    }

    @KeepForSdk
    @VisibleForTesting
    public void triggerNotAvailable(@RecentlyNonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, @Nullable PendingIntent pendingIntent) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(3, this.zzd.get(), i, pendingIntent));
    }

    @KeepForSdk
    public boolean usesClientTelemetry() {
        return false;
    }

    @RecentlyNonNull
    public final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzb(int i, @Nullable Bundle bundle, int i2) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(this, i, (Bundle) null)));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BaseGmsClient(@androidx.annotation.RecentlyNonNull android.content.Context r10, @androidx.annotation.RecentlyNonNull android.os.Looper r11, int r12, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks r13, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener r14, @androidx.annotation.Nullable java.lang.String r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.GmsClientSupervisor r3 = com.google.android.gms.common.internal.GmsClientSupervisor.getInstance(r10)
            com.google.android.gms.common.GoogleApiAvailabilityLight r4 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks, com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener, java.lang.String):void");
    }

    @KeepForSdk
    public void disconnect(@RecentlyNonNull String str) {
        this.zzk = str;
        disconnect();
    }

    @KeepForSdk
    @VisibleForTesting
    public BaseGmsClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull GmsClientSupervisor gmsClientSupervisor, @RecentlyNonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzm = looper;
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzb = new zzb(this, looper);
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }
}
