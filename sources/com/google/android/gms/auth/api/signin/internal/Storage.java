package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class Storage {
    public static final Lock zaa = new ReentrantLock();
    @GuardedBy("sLk")
    @Nullable
    public static Storage zab;
    public final Lock zac = new ReentrantLock();
    @GuardedBy("mLk")
    public final SharedPreferences zad;

    @VisibleForTesting
    public Storage(Context context) {
        this.zad = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static Storage getInstance(@RecentlyNonNull Context context) {
        Preconditions.checkNotNull(context);
        zaa.lock();
        try {
            if (zab == null) {
                zab = new Storage(context.getApplicationContext());
            }
            return zab;
        } finally {
            zaa.unlock();
        }
    }

    private final void zaa(String str, String str2) {
        this.zac.lock();
        try {
            this.zad.edit().putString(str, str2).apply();
        } finally {
            this.zac.unlock();
        }
    }

    @Nullable
    @VisibleForTesting
    private final GoogleSignInOptions zab(@Nullable String str) {
        String zac2;
        if (!TextUtils.isEmpty(str) && (zac2 = zac(zab("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.zaa(zac2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    private final String zac(String str) {
        this.zac.lock();
        try {
            return this.zad.getString(str, (String) null);
        } finally {
            this.zac.unlock();
        }
    }

    private final void zad(String str) {
        this.zac.lock();
        try {
            this.zad.edit().remove(str).apply();
        } finally {
            this.zac.unlock();
        }
    }

    @KeepForSdk
    public void clear() {
        this.zac.lock();
        try {
            this.zad.edit().clear().apply();
        } finally {
            this.zac.unlock();
        }
    }

    @KeepForSdk
    @RecentlyNullable
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        return zaa(zac("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    @RecentlyNullable
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        return zab(zac("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    @RecentlyNullable
    public String getSavedRefreshToken() {
        return zac("refreshToken");
    }

    @KeepForSdk
    public void saveDefaultGoogleSignInAccount(@RecentlyNonNull GoogleSignInAccount googleSignInAccount, @RecentlyNonNull GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        zaa("defaultGoogleSignInAccount", googleSignInAccount.zaa());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String zaa2 = googleSignInAccount.zaa();
        zaa(zab("googleSignInAccount", zaa2), googleSignInAccount.zab());
        zaa(zab("googleSignInOptions", zaa2), googleSignInOptions.zaa());
    }

    public static String zab(String str, String str2) {
        return GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(str2, GeneratedOutlineSupport.outline3(str, 1)), str, CertificateUtil.DELIMITER, str2);
    }

    @Nullable
    @VisibleForTesting
    private final GoogleSignInAccount zaa(@Nullable String str) {
        String zac2;
        if (!TextUtils.isEmpty(str) && (zac2 = zac(zab("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.zaa(zac2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final void zaa() {
        String zac2 = zac("defaultGoogleSignInAccount");
        zad("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(zac2)) {
            zad(zab("googleSignInAccount", zac2));
            zad(zab("googleSignInOptions", zac2));
        }
    }
}
