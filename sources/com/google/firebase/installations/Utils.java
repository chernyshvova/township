package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Utils {
    public static final Pattern API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");
    public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = TimeUnit.HOURS.toSeconds(1);

    public static boolean isValidAppIdFormat(@Nullable String str) {
        return str.contains(CertificateUtil.DELIMITER);
    }

    public long currentTimeInSecs() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public boolean isAuthTokenExpired(PersistedInstallationEntry persistedInstallationEntry) {
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
        if (!TextUtils.isEmpty(autoValue_PersistedInstallationEntry.authToken) && autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs + autoValue_PersistedInstallationEntry.expiresInSecs >= currentTimeInSecs() + AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS) {
            return false;
        }
        return true;
    }
}
