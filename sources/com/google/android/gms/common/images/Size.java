package com.google.android.gms.common.images;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class Size {
    public final int zaa;
    public final int zab;

    public Size(int i, int i2) {
        this.zaa = i;
        this.zab = i2;
    }

    @RecentlyNonNull
    public static Size parseSize(@RecentlyNonNull String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw zaa(str);
                }
            } else {
                throw zaa(str);
            }
        } else {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    public static NumberFormatException zaa(String str) {
        throw new NumberFormatException(GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(str, 16), "Invalid Size: \"", str, "\""));
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.zaa == size.zaa && this.zab == size.zab;
        }
    }

    public final int getHeight() {
        return this.zab;
    }

    public final int getWidth() {
        return this.zaa;
    }

    public final int hashCode() {
        int i = this.zab;
        int i2 = this.zaa;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    @RecentlyNonNull
    public final String toString() {
        int i = this.zaa;
        int i2 = this.zab;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }
}
