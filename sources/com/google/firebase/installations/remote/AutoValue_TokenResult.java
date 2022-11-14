package com.google.firebase.installations.remote;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.firebase.installations.remote.TokenResult;

public final class AutoValue_TokenResult extends TokenResult {
    public final TokenResult.ResponseCode responseCode;
    public final String token;
    public final long tokenExpirationTimestamp;

    public static final class Builder extends TokenResult.Builder {
        public TokenResult.ResponseCode responseCode;
        public String token;
        public Long tokenExpirationTimestamp;

        public TokenResult build() {
            String str = this.tokenExpirationTimestamp == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.responseCode, (C23621) null);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str));
        }

        public TokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.tokenExpirationTimestamp = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_TokenResult(String str, long j, TokenResult.ResponseCode responseCode2, C23621 r5) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.responseCode = responseCode2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.token;
        if (str != null ? str.equals(((AutoValue_TokenResult) tokenResult).token) : ((AutoValue_TokenResult) tokenResult).token == null) {
            if (this.tokenExpirationTimestamp == ((AutoValue_TokenResult) tokenResult).tokenExpirationTimestamp) {
                TokenResult.ResponseCode responseCode2 = this.responseCode;
                if (responseCode2 == null) {
                    if (((AutoValue_TokenResult) tokenResult).responseCode == null) {
                        return true;
                    }
                } else if (responseCode2.equals(((AutoValue_TokenResult) tokenResult).responseCode)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.token;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.tokenExpirationTimestamp;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode2 = this.responseCode;
        if (responseCode2 != null) {
            i = responseCode2.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("TokenResult{token=");
        outline24.append(this.token);
        outline24.append(", tokenExpirationTimestamp=");
        outline24.append(this.tokenExpirationTimestamp);
        outline24.append(", responseCode=");
        outline24.append(this.responseCode);
        outline24.append("}");
        return outline24.toString();
    }
}
