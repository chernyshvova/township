package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class EncodedPayload {
    public final byte[] bytes;
    public final Encoding encoding;

    public EncodedPayload(@NonNull Encoding encoding2, @NonNull byte[] bArr) {
        if (encoding2 == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.encoding = encoding2;
            this.bytes = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.encoding.equals(encodedPayload.encoding)) {
            return false;
        }
        return Arrays.equals(this.bytes, encodedPayload.bytes);
    }

    public int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("EncodedPayload{encoding=");
        outline24.append(this.encoding);
        outline24.append(", bytes=[...]}");
        return outline24.toString();
    }
}
