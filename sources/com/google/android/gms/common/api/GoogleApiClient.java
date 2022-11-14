package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaar;
import com.google.android.gms.common.api.internal.zacn;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zab;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class GoogleApiClient {
    @RecentlyNonNull
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    @GuardedBy("sAllClients")
    public static final Set<GoogleApiClient> zaa = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    public static void dumpAll(@RecentlyNonNull String str, @RecentlyNonNull FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, @RecentlyNonNull String[] strArr) {
        synchronized (zaa) {
            int i = 0;
            String concat = String.valueOf(str).concat("  ");
            for (GoogleApiClient dump : zaa) {
                printWriter.append(str).append("GoogleApiClient#").println(i);
                dump.dump(concat, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public static Set<GoogleApiClient> getAllClients() {
        Set<GoogleApiClient> set;
        synchronized (zaa) {
            set = zaa;
        }
        return set;
    }

    @RecentlyNonNull
    public abstract ConnectionResult blockingConnect();

    @RecentlyNonNull
    public abstract ConnectionResult blockingConnect(long j, @RecentlyNonNull TimeUnit timeUnit);

    @RecentlyNonNull
    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(@RecentlyNonNull String str, @RecentlyNonNull FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, @RecentlyNonNull String[] strArr);

    @RecentlyNonNull
    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@RecentlyNonNull T t) {
        throw new UnsupportedOperationException();
    }

    @RecentlyNonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@RecentlyNonNull T t) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public <C extends Api.Client> C getClient(@RecentlyNonNull Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract ConnectionResult getConnectionResult(@RecentlyNonNull Api<?> api);

    @RecentlyNonNull
    @KeepForSdk
    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    @RecentlyNonNull
    @KeepForSdk
    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean hasApi(@RecentlyNonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@RecentlyNonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@RecentlyNonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@RecentlyNonNull OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public boolean maybeSignIn(@RecentlyNonNull SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@RecentlyNonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@RecentlyNonNull OnConnectionFailedListener onConnectionFailedListener);

    @RecentlyNonNull
    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(@RecentlyNonNull L l) {
        throw new UnsupportedOperationException();
    }

    public abstract void stopAutoManage(@RecentlyNonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@RecentlyNonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@RecentlyNonNull OnConnectionFailedListener onConnectionFailedListener);

    public void zaa(zacn zacn) {
        throw new UnsupportedOperationException();
    }

    public void zab(zacn zacn) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    @Deprecated
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class Builder {
        @Nullable
        public Account zaa;
        public final Set<Scope> zab;
        public final Set<Scope> zac;
        public int zad;
        public View zae;
        public String zaf;
        public String zag;
        public final Map<Api<?>, ClientSettings.zaa> zah;
        public boolean zai;
        public final Context zaj;
        public final Map<Api<?>, Api.ApiOptions> zak;
        public LifecycleActivity zal;
        public int zam;
        @Nullable
        public OnConnectionFailedListener zan;
        public Looper zao;
        public GoogleApiAvailability zap;
        public Api.AbstractClientBuilder<? extends zae, SignInOptions> zaq;
        public final ArrayList<ConnectionCallbacks> zar;
        public final ArrayList<OnConnectionFailedListener> zas;

        @KeepForSdk
        public Builder(@RecentlyNonNull Context context) {
            this.zab = new HashSet();
            this.zac = new HashSet();
            this.zah = new ArrayMap();
            this.zai = false;
            this.zak = new ArrayMap();
            this.zam = -1;
            this.zap = GoogleApiAvailability.getInstance();
            this.zaq = zab.zaa;
            this.zar = new ArrayList<>();
            this.zas = new ArrayList<>();
            this.zaj = context;
            this.zao = context.getMainLooper();
            this.zaf = context.getPackageName();
            this.zag = context.getClass().getName();
        }

        private final <O extends Api.ApiOptions> void zaa(Api<O> api, @Nullable O o, Scope... scopeArr) {
            HashSet hashSet = new HashSet(((Api.BaseClientBuilder) Preconditions.checkNotNull(api.zaa(), "Base client builder must not be null")).getImpliedScopes(o));
            for (Scope add : scopeArr) {
                hashSet.add(add);
            }
            this.zah.put(api, new ClientSettings.zaa(hashSet));
        }

        @RecentlyNonNull
        public final Builder addApi(@RecentlyNonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            Preconditions.checkNotNull(api, "Api must not be null");
            this.zak.put(api, (Object) null);
            List<Scope> impliedScopes = ((Api.BaseClientBuilder) Preconditions.checkNotNull(api.zaa(), "Base client builder must not be null")).getImpliedScopes(null);
            this.zac.addAll(impliedScopes);
            this.zab.addAll(impliedScopes);
            return this;
        }

        @RecentlyNonNull
        public final <T extends Api.ApiOptions.NotRequiredOptions> Builder addApiIfAvailable(@RecentlyNonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, @RecentlyNonNull Scope... scopeArr) {
            Preconditions.checkNotNull(api, "Api must not be null");
            this.zak.put(api, (Object) null);
            zaa(api, (Api.ApiOptions) null, scopeArr);
            return this;
        }

        @RecentlyNonNull
        public final Builder addConnectionCallbacks(@RecentlyNonNull ConnectionCallbacks connectionCallbacks) {
            Preconditions.checkNotNull(connectionCallbacks, "Listener must not be null");
            this.zar.add(connectionCallbacks);
            return this;
        }

        @RecentlyNonNull
        public final Builder addOnConnectionFailedListener(@RecentlyNonNull OnConnectionFailedListener onConnectionFailedListener) {
            Preconditions.checkNotNull(onConnectionFailedListener, "Listener must not be null");
            this.zas.add(onConnectionFailedListener);
            return this;
        }

        @RecentlyNonNull
        public final Builder addScope(@RecentlyNonNull Scope scope) {
            Preconditions.checkNotNull(scope, "Scope must not be null");
            this.zab.add(scope);
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public final Builder addScopeNames(@RecentlyNonNull String[] strArr) {
            for (String scope : strArr) {
                this.zab.add(new Scope(scope));
            }
            return this;
        }

        @RecentlyNonNull
        public final GoogleApiClient build() {
            Preconditions.checkArgument(!this.zak.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings buildClientSettings = buildClientSettings();
            Api api = null;
            Map<Api<?>, ClientSettings.zaa> zaa2 = buildClientSettings.zaa();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Api next : this.zak.keySet()) {
                Api.ApiOptions apiOptions = this.zak.get(next);
                boolean z2 = zaa2.get(next) != null;
                arrayMap.put(next, Boolean.valueOf(z2));
                zaq zaq2 = new zaq(next, z2);
                arrayList.add(zaq2);
                Api.AbstractClientBuilder abstractClientBuilder = (Api.AbstractClientBuilder) Preconditions.checkNotNull(next.zab());
                Api api2 = next;
                Api.Client buildClient = abstractClientBuilder.buildClient(this.zaj, this.zao, buildClientSettings, apiOptions, (ConnectionCallbacks) zaq2, (OnConnectionFailedListener) zaq2);
                arrayMap2.put(api2.zac(), buildClient);
                if (abstractClientBuilder.getPriority() == 1) {
                    z = apiOptions != null;
                }
                if (buildClient.providesSignIn()) {
                    if (api == null) {
                        api = api2;
                    } else {
                        String zad2 = api2.zad();
                        String zad3 = api.zad();
                        throw new IllegalStateException(GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(zad3, GeneratedOutlineSupport.outline3(zad2, 21)), zad2, " cannot be used with ", zad3));
                    }
                }
            }
            if (api != null) {
                if (!z) {
                    Preconditions.checkState(this.zaa == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.zad());
                    Preconditions.checkState(this.zab.equals(this.zac), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.zad());
                } else {
                    String zad4 = api.zad();
                    throw new IllegalStateException(GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(zad4, 82), "With using ", zad4, ", GamesOptions can only be specified within GoogleSignInOptions.Builder"));
                }
            }
            zaar zaar = new zaar(this.zaj, new ReentrantLock(), this.zao, buildClientSettings, this.zap, this.zaq, arrayMap, this.zar, this.zas, arrayMap2, this.zam, zaar.zaa((Iterable<Api.Client>) arrayMap2.values(), true), arrayList);
            synchronized (GoogleApiClient.zaa) {
                GoogleApiClient.zaa.add(zaar);
            }
            if (this.zam >= 0) {
                zai.zaa(this.zal).zaa(this.zam, zaar, this.zan);
            }
            return zaar;
        }

        @RecentlyNonNull
        @KeepForSdk
        @VisibleForTesting
        public final ClientSettings buildClientSettings() {
            SignInOptions signInOptions = SignInOptions.zaa;
            if (this.zak.containsKey(zab.zab)) {
                signInOptions = (SignInOptions) this.zak.get(zab.zab);
            }
            return new ClientSettings(this.zaa, this.zab, this.zah, this.zad, this.zae, this.zaf, this.zag, signInOptions, false);
        }

        @RecentlyNonNull
        public final Builder enableAutoManage(@RecentlyNonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
            Preconditions.checkArgument(i >= 0, "clientId must be non-negative");
            this.zam = i;
            this.zan = onConnectionFailedListener;
            this.zal = lifecycleActivity;
            return this;
        }

        @RecentlyNonNull
        public final Builder setAccountName(@RecentlyNonNull String str) {
            this.zaa = str == null ? null : new Account(str, "com.google");
            return this;
        }

        @RecentlyNonNull
        public final Builder setGravityForPopups(int i) {
            this.zad = i;
            return this;
        }

        @RecentlyNonNull
        public final Builder setHandler(@RecentlyNonNull Handler handler) {
            Preconditions.checkNotNull(handler, "Handler must not be null");
            this.zao = handler.getLooper();
            return this;
        }

        @RecentlyNonNull
        public final Builder setViewForPopups(@RecentlyNonNull View view) {
            Preconditions.checkNotNull(view, "View must not be null");
            this.zae = view;
            return this;
        }

        @RecentlyNonNull
        public final Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        @RecentlyNonNull
        public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@RecentlyNonNull Api<O> api, @RecentlyNonNull O o, @RecentlyNonNull Scope... scopeArr) {
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.zak.put(api, o);
            zaa(api, o, scopeArr);
            return this;
        }

        @RecentlyNonNull
        public final Builder enableAutoManage(@RecentlyNonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        @RecentlyNonNull
        public final <O extends Api.ApiOptions.HasOptions> Builder addApi(@RecentlyNonNull Api<O> api, @RecentlyNonNull O o) {
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.zak.put(api, o);
            List<Scope> impliedScopes = ((Api.BaseClientBuilder) Preconditions.checkNotNull(api.zaa(), "Base client builder must not be null")).getImpliedScopes(o);
            this.zac.addAll(impliedScopes);
            this.zab.addAll(impliedScopes);
            return this;
        }

        @KeepForSdk
        public Builder(@RecentlyNonNull Context context, @RecentlyNonNull ConnectionCallbacks connectionCallbacks, @RecentlyNonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            Preconditions.checkNotNull(connectionCallbacks, "Must provide a connected listener");
            this.zar.add(connectionCallbacks);
            Preconditions.checkNotNull(onConnectionFailedListener, "Must provide a connection failed listener");
            this.zas.add(onConnectionFailedListener);
        }
    }
}
