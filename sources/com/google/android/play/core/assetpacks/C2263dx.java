package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.dx */
public final class C2263dx {

    /* renamed from: a */
    public final String f3187a;

    /* renamed from: b */
    public final long f3188b;

    /* renamed from: c */
    public final int f3189c;

    /* renamed from: d */
    public final boolean f3190d;

    /* renamed from: e */
    public final boolean f3191e;

    /* renamed from: f */
    public final byte[] f3192f;

    public C2263dx() {
    }

    public C2263dx(@Nullable String str, long j, int i, boolean z, boolean z2, @Nullable byte[] bArr) {
        this.f3187a = str;
        this.f3188b = j;
        this.f3189c = i;
        this.f3190d = z;
        this.f3191e = z2;
        this.f3192f = bArr;
    }

    /* renamed from: a */
    public final boolean mo33259a() {
        String str = this.f3187a;
        if (str == null) {
            return false;
        }
        return str.endsWith("/");
    }

    /* renamed from: b */
    public final boolean mo33260b() {
        return this.f3189c == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2263dx) {
            C2263dx dxVar = (C2263dx) obj;
            String str = this.f3187a;
            if (str != null ? str.equals(dxVar.f3187a) : dxVar.f3187a == null) {
                return this.f3188b == dxVar.f3188b && this.f3189c == dxVar.f3189c && this.f3190d == dxVar.f3190d && this.f3191e == dxVar.f3191e && Arrays.equals(this.f3192f, dxVar.f3192f);
            }
        }
    }

    public int hashCode() {
        String str = this.f3187a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f3188b;
        int i = 1237;
        int i2 = (((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f3189c) * 1000003) ^ (true != this.f3190d ? 1237 : 1231)) * 1000003;
        if (true == this.f3191e) {
            i = 1231;
        }
        return ((i2 ^ i) * 1000003) ^ Arrays.hashCode(this.f3192f);
    }

    public String toString() {
        String str = this.f3187a;
        long j = this.f3188b;
        int i = this.f3189c;
        boolean z = this.f3190d;
        boolean z2 = this.f3191e;
        String arrays = Arrays.toString(this.f3192f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        return GeneratedOutlineSupport.outline19(sb, ", headerBytes=", arrays, "}");
    }
}
