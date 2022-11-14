package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
public final class Encoding {
    public final String name;

    public Encoding(@NonNull String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.name.equals(((Encoding) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24("Encoding{name=\""), this.name, "\"}");
    }
}
