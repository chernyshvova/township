package com.google.android.gms.signin;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class SignInOptions implements Api.ApiOptions.Optional {
    @RecentlyNonNull
    public static final SignInOptions zaa = new SignInOptions(false, false, (String) null, false, (String) null, (String) null, false, (Long) null, (Long) null);
    public final boolean zab = false;
    public final boolean zac = false;
    @Nullable
    public final String zad = null;
    public final boolean zae = false;
    @Nullable
    public final String zaf = null;
    @Nullable
    public final String zag = null;
    public final boolean zah = false;
    @Nullable
    public final Long zai = null;
    @Nullable
    public final Long zaj = null;

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class zaa {
    }

    static {
        new zaa();
    }

    public SignInOptions(boolean z, boolean z2, @Nullable String str, boolean z3, @Nullable String str2, @Nullable String str3, boolean z4, @Nullable Long l, @Nullable Long l2) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        SignInOptions signInOptions = (SignInOptions) obj;
        return Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.hashCode(bool, bool, null, bool, bool, null, null, null, null);
    }
}
