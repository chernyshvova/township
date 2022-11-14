package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bh */
public final class C2203bh extends AssetPackState {

    /* renamed from: a */
    public final String f2961a;

    /* renamed from: b */
    public final int f2962b;

    /* renamed from: c */
    public final int f2963c;

    /* renamed from: d */
    public final long f2964d;

    /* renamed from: e */
    public final long f2965e;

    /* renamed from: f */
    public final int f2966f;

    /* renamed from: g */
    public final int f2967g;

    public C2203bh(String str, int i, int i2, long j, long j2, int i3, int i4) {
        if (str != null) {
            this.f2961a = str;
            this.f2962b = i;
            this.f2963c = i2;
            this.f2964d = j;
            this.f2965e = j2;
            this.f2966f = i3;
            this.f2967g = i4;
            return;
        }
        throw new NullPointerException("Null name");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            C2203bh bhVar = (C2203bh) ((AssetPackState) obj);
            return this.f2961a.equals(bhVar.f2961a) && this.f2962b == bhVar.f2962b && this.f2963c == bhVar.f2963c && this.f2964d == bhVar.f2964d && this.f2965e == bhVar.f2965e && this.f2966f == bhVar.f2966f && this.f2967g == bhVar.f2967g;
        }
    }

    public final int hashCode() {
        int hashCode = this.f2961a.hashCode();
        int i = this.f2962b;
        int i2 = this.f2963c;
        long j = this.f2964d;
        long j2 = this.f2965e;
        return ((((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f2966f) * 1000003) ^ this.f2967g;
    }

    public final String toString() {
        String str = this.f2961a;
        int i = this.f2962b;
        int i2 = this.f2963c;
        long j = this.f2964d;
        long j2 = this.f2965e;
        int i3 = this.f2966f;
        int i4 = this.f2967g;
        StringBuilder sb = new StringBuilder(str.length() + 217);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i3);
        sb.append(", updateAvailability=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }
}
