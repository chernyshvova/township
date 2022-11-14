package com.google.firebase.installations;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
public final class AutoValue_InstallationTokenResult extends InstallationTokenResult {
    public final String token;
    public final long tokenCreationTimestamp;
    public final long tokenExpirationTimestamp;

    public AutoValue_InstallationTokenResult(String str, long j, long j2, C23581 r6) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.tokenCreationTimestamp = j2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        AutoValue_InstallationTokenResult autoValue_InstallationTokenResult = (AutoValue_InstallationTokenResult) ((InstallationTokenResult) obj);
        if (this.token.equals(autoValue_InstallationTokenResult.token) && this.tokenExpirationTimestamp == autoValue_InstallationTokenResult.tokenExpirationTimestamp && this.tokenCreationTimestamp == autoValue_InstallationTokenResult.tokenCreationTimestamp) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.tokenExpirationTimestamp;
        long j2 = this.tokenCreationTimestamp;
        return ((((this.token.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("InstallationTokenResult{token=");
        outline24.append(this.token);
        outline24.append(", tokenExpirationTimestamp=");
        outline24.append(this.tokenExpirationTimestamp);
        outline24.append(", tokenCreationTimestamp=");
        outline24.append(this.tokenCreationTimestamp);
        outline24.append("}");
        return outline24.toString();
    }
}
