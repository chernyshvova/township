package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zay;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    public final Context zaa;
    @Nullable
    public final String zab;
    public final Api<O> zac;
    public final O zad;
    public final ApiKey<O> zae;
    public final Looper zaf;
    public final int zag;
    @NotOnlyInitialized
    public final GoogleApiClient zah;
    public final StatusExceptionMapper zai;
    public final GoogleApiManager zaj;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class Settings {
        @RecentlyNonNull
        @KeepForSdk
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        @RecentlyNonNull
        public final StatusExceptionMapper zaa;
        @RecentlyNonNull
        public final Looper zab;

        @KeepForSdk
        /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
        public static class Builder {
            public StatusExceptionMapper zaa;
            public Looper zab;

            @RecentlyNonNull
            @KeepForSdk
            public Settings build() {
                if (this.zaa == null) {
                    this.zaa = new ApiExceptionMapper();
                }
                if (this.zab == null) {
                    this.zab = Looper.getMainLooper();
                }
                return new Settings(this.zaa, this.zab);
            }

            @RecentlyNonNull
            @KeepForSdk
            public Builder setLooper(@RecentlyNonNull Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zab = looper;
                return this;
            }

            @RecentlyNonNull
            @KeepForSdk
            public Builder setMapper(@RecentlyNonNull StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zaa = statusExceptionMapper;
                return this;
            }
        }

        @KeepForSdk
        public Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
        }
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(@RecentlyNonNull Context context, @RecentlyNonNull Api<O> api, @RecentlyNonNull O o, @RecentlyNonNull Looper looper, @RecentlyNonNull StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Settings.Builder().setLooper(looper).setMapper(statusExceptionMapper).build());
    }

    private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaa(int i, @NonNull T t) {
        t.zab();
        this.zaj.zaa(this, i, (BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>) t);
        return t;
    }

    @RecentlyNonNull
    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.zah;
    }

    @RecentlyNonNull
    @KeepForSdk
    public ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        O o = this.zad;
        if (!(o instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o).getGoogleSignInAccount()) == null) {
            O o2 = this.zad;
            account = o2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) o2).getAccount() : null;
        } else {
            account = googleSignInAccount2.getAccount();
        }
        ClientSettings.Builder zaa2 = builder.zaa(account);
        O o3 = this.zad;
        if (!(o3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o3).getGoogleSignInAccount()) == null) {
            set = Collections.emptySet();
        } else {
            set = googleSignInAccount.getRequestedScopes();
        }
        return zaa2.zaa((Collection<Scope>) set).zaa(this.zaa.getClass().getName()).setRealClientPackageName(this.zaa.getPackageName());
    }

    @RecentlyNonNull
    @KeepForSdk
    public Task<Boolean> disconnectService() {
        return this.zaj.zab((GoogleApi<?>) this);
    }

    @RecentlyNonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(@RecentlyNonNull T t) {
        return zaa(2, t);
    }

    @RecentlyNonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(@RecentlyNonNull T t) {
        return zaa(0, t);
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(@RecentlyNonNull T t, @RecentlyNonNull U u) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(u);
        Preconditions.checkNotNull(t.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(u.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(Objects.equal(t.getListenerKey(), u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaj.zaa(this, (RegisterListenerMethod<Api.AnyClient, ?>) t, (UnregisterListenerMethod<Api.AnyClient, ?>) u, zac.zaa);
    }

    @RecentlyNonNull
    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(@RecentlyNonNull ListenerHolder.ListenerKey<?> listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    @RecentlyNonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(@RecentlyNonNull T t) {
        return zaa(1, t);
    }

    @RecentlyNonNull
    public ApiKey<O> getApiKey() {
        return this.zae;
    }

    @RecentlyNonNull
    @KeepForSdk
    public O getApiOptions() {
        return this.zad;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Context getApplicationContext() {
        return this.zaa;
    }

    @KeepForSdk
    @RecentlyNullable
    public String getContextAttributionTag() {
        return this.zab;
    }

    @KeepForSdk
    @Deprecated
    @RecentlyNullable
    public String getContextFeatureId() {
        return this.zab;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Looper getLooper() {
        return this.zaf;
    }

    @RecentlyNonNull
    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(@RecentlyNonNull L l, @RecentlyNonNull String str) {
        return ListenerHolders.createListenerHolder(l, this.zaf, str);
    }

    @MainThread
    @KeepForSdk
    public GoogleApi(@RecentlyNonNull Activity activity, @RecentlyNonNull Api<O> api, @RecentlyNonNull O o, @RecentlyNonNull Settings settings) {
        Preconditions.checkNotNull(activity, "Null activity is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zaa = activity.getApplicationContext();
        String zaa2 = zaa(activity);
        this.zab = zaa2;
        this.zac = api;
        this.zad = o;
        this.zaf = settings.zab;
        this.zae = ApiKey.zaa(api, o, zaa2);
        this.zah = new zabl(this);
        GoogleApiManager zaa3 = GoogleApiManager.zaa(this.zaa);
        this.zaj = zaa3;
        this.zag = zaa3.zab();
        this.zai = settings.zaa;
        if (!(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zay.zaa(activity, this.zaj, this.zae);
        }
        this.zaj.zaa((GoogleApi<?>) this);
    }

    @RecentlyNonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(@RecentlyNonNull TaskApiCall<A, TResult> taskApiCall) {
        return zaa(2, taskApiCall);
    }

    @RecentlyNonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(@RecentlyNonNull TaskApiCall<A, TResult> taskApiCall) {
        return zaa(0, taskApiCall);
    }

    @RecentlyNonNull
    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(@RecentlyNonNull ListenerHolder.ListenerKey<?> listenerKey, int i) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.zaj.zaa(this, listenerKey, i);
    }

    @RecentlyNonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(@RecentlyNonNull TaskApiCall<A, TResult> taskApiCall) {
        return zaa(1, taskApiCall);
    }

    private final <TResult, A extends Api.AnyClient> Task<TResult> zaa(int i, @NonNull TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaj.zaa(this, i, taskApiCall, taskCompletionSource, this.zai);
        return taskCompletionSource.getTask();
    }

    @WorkerThread
    public final Api.Client zaa(Looper looper, GoogleApiManager.zaa<O> zaa2) {
        Looper looper2 = looper;
        Api.Client buildClient = ((Api.AbstractClientBuilder) Preconditions.checkNotNull(this.zac.zab())).buildClient(this.zaa, looper2, createClientSettingsBuilder().build(), this.zad, (GoogleApiClient.ConnectionCallbacks) zaa2, (GoogleApiClient.OnConnectionFailedListener) zaa2);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (buildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) buildClient).zaa(contextAttributionTag);
        }
        return buildClient;
    }

    @RecentlyNonNull
    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(@RecentlyNonNull RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.register.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(registrationMethods.zaa.getListenerKey(), "Listener has already been released.");
        return this.zaj.zaa(this, (RegisterListenerMethod<Api.AnyClient, ?>) registrationMethods.register, (UnregisterListenerMethod<Api.AnyClient, ?>) registrationMethods.zaa, registrationMethods.zab);
    }

    public final int zaa() {
        return this.zag;
    }

    @Nullable
    public static String zaa(Object obj) {
        if (!PlatformVersion.isAtLeastR()) {
            return null;
        }
        try {
            return (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public final zace zaa(Context context, Handler handler) {
        return new zace(context, handler, createClientSettingsBuilder().build());
    }

    @KeepForSdk
    public GoogleApi(@RecentlyNonNull Context context, @RecentlyNonNull Api<O> api, @RecentlyNonNull O o, @RecentlyNonNull Settings settings) {
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zaa = context.getApplicationContext();
        String zaa2 = zaa(context);
        this.zab = zaa2;
        this.zac = api;
        this.zad = o;
        this.zaf = settings.zab;
        this.zae = ApiKey.zaa(api, o, zaa2);
        this.zah = new zabl(this);
        GoogleApiManager zaa3 = GoogleApiManager.zaa(this.zaa);
        this.zaj = zaa3;
        this.zag = zaa3.zab();
        this.zai = settings.zaa;
        this.zaj.zaa((GoogleApi<?>) this);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(@RecentlyNonNull Activity activity, @RecentlyNonNull Api<O> api, @RecentlyNonNull O o, @RecentlyNonNull StatusExceptionMapper statusExceptionMapper) {
        this(activity, api, o, new Settings.Builder().setMapper(statusExceptionMapper).setLooper(activity.getMainLooper()).build());
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(@RecentlyNonNull Context context, @RecentlyNonNull Api<O> api, @RecentlyNonNull O o, @RecentlyNonNull StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Settings.Builder().setMapper(statusExceptionMapper).build());
    }
}
