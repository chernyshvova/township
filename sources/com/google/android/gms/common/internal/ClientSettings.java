package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@KeepForSdk
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class ClientSettings {
    @Nullable
    public final Account zaa;
    public final Set<Scope> zab;
    public final Set<Scope> zac;
    public final Map<Api<?>, zaa> zad;
    public final int zae;
    public final View zaf;
    public final String zag;
    public final String zah;
    public final SignInOptions zai;
    public final boolean zaj;
    public Integer zak;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class Builder {
        @Nullable
        public Account zaa;
        public ArraySet<Scope> zab;
        public int zac = 0;
        public String zad;
        public String zae;
        public SignInOptions zaf = SignInOptions.zaa;

        @RecentlyNonNull
        @KeepForSdk
        public final ClientSettings build() {
            return new ClientSettings(this.zaa, this.zab, (Map<Api<?>, zaa>) null, 0, (View) null, this.zad, this.zae, this.zaf, false);
        }

        @RecentlyNonNull
        @KeepForSdk
        public final Builder setRealClientPackageName(@RecentlyNonNull String str) {
            this.zad = str;
            return this;
        }

        @RecentlyNonNull
        public final Builder zaa(@Nullable Account account) {
            this.zaa = account;
            return this;
        }

        @RecentlyNonNull
        public final Builder zaa(@RecentlyNonNull Collection<Scope> collection) {
            if (this.zab == null) {
                this.zab = new ArraySet<>();
            }
            this.zab.addAll(collection);
            return this;
        }

        @RecentlyNonNull
        public final Builder zaa(@RecentlyNonNull String str) {
            this.zae = str;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class zaa {
        public final Set<Scope> zaa;

        public zaa(Set<Scope> set) {
            Preconditions.checkNotNull(set);
            this.zaa = Collections.unmodifiableSet(set);
        }
    }

    @KeepForSdk
    public ClientSettings(@RecentlyNonNull Account account, @RecentlyNonNull Set<Scope> set, @RecentlyNonNull Map<Api<?>, zaa> map, int i, @RecentlyNonNull View view, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull SignInOptions signInOptions) {
        this(account, set, map, i, view, str, str2, signInOptions, false);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static ClientSettings createDefault(@RecentlyNonNull Context context) {
        return new GoogleApiClient.Builder(context).buildClientSettings();
    }

    @KeepForSdk
    @RecentlyNullable
    public final Account getAccount() {
        return this.zaa;
    }

    @KeepForSdk
    @Deprecated
    @RecentlyNullable
    public final String getAccountName() {
        Account account = this.zaa;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final Account getAccountOrDefault() {
        Account account = this.zaa;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    @RecentlyNonNull
    @KeepForSdk
    public final Set<Scope> getAllRequestedScopes() {
        return this.zac;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final Set<Scope> getApplicableScopes(@RecentlyNonNull Api<?> api) {
        zaa zaa2 = this.zad.get(api);
        if (zaa2 == null || zaa2.zaa.isEmpty()) {
            return this.zab;
        }
        HashSet hashSet = new HashSet(this.zab);
        hashSet.addAll(zaa2.zaa);
        return hashSet;
    }

    @KeepForSdk
    public final int getGravityForPopups() {
        return this.zae;
    }

    @KeepForSdk
    @RecentlyNullable
    public final String getRealClientPackageName() {
        return this.zag;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final Set<Scope> getRequiredScopes() {
        return this.zab;
    }

    @KeepForSdk
    @RecentlyNullable
    public final View getViewForPopups() {
        return this.zaf;
    }

    @RecentlyNonNull
    public final Map<Api<?>, zaa> zaa() {
        return this.zad;
    }

    @RecentlyNullable
    public final String zab() {
        return this.zah;
    }

    @RecentlyNonNull
    public final SignInOptions zac() {
        return this.zai;
    }

    @RecentlyNullable
    public final Integer zad() {
        return this.zak;
    }

    public ClientSettings(@Nullable Account account, @RecentlyNonNull Set<Scope> set, @RecentlyNonNull Map<Api<?>, zaa> map, int i, @RecentlyNonNull View view, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull SignInOptions signInOptions, boolean z) {
        this.zaa = account;
        this.zab = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zad = map == null ? Collections.emptyMap() : map;
        this.zaf = view;
        this.zae = i;
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions;
        this.zaj = false;
        HashSet hashSet = new HashSet(this.zab);
        for (zaa zaa2 : this.zad.values()) {
            hashSet.addAll(zaa2.zaa);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }

    public final void zaa(@RecentlyNonNull Integer num) {
        this.zak = num;
    }
}
