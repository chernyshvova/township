package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import com.android.billingclient.api.zzam;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.dd */
public final class C2243dd {

    /* renamed from: a */
    public byte[] f3118a = new byte[4096];

    /* renamed from: b */
    public int f3119b;

    /* renamed from: c */
    public long f3120c;

    /* renamed from: d */
    public long f3121d;

    /* renamed from: e */
    public int f3122e;

    /* renamed from: f */
    public int f3123f;

    /* renamed from: g */
    public int f3124g;

    /* renamed from: h */
    public boolean f3125h;
    @Nullable

    /* renamed from: i */
    public String f3126i;

    public C2243dd() {
        mo33233c();
    }

    /* renamed from: a */
    public final int mo33230a(int i, byte[] bArr, int i2, int i3) {
        int i4 = this.f3119b;
        if (i4 >= i) {
            return 0;
        }
        int min = Math.min(i3, i - i4);
        System.arraycopy(bArr, i2, this.f3118a, this.f3119b, min);
        int i5 = this.f3119b + min;
        this.f3119b = i5;
        if (i5 < i) {
            return -1;
        }
        return min;
    }

    /* renamed from: a */
    public final int mo33231a(byte[] bArr, int i, int i2) {
        int a = mo33230a(30, bArr, i, i2);
        if (a == -1) {
            return -1;
        }
        if (this.f3120c == -1) {
            long b = zzam.m30b(this.f3118a, 0);
            this.f3120c = b;
            if (b == 67324752) {
                this.f3125h = false;
                this.f3121d = zzam.m30b(this.f3118a, 18);
                this.f3124g = zzam.m33c(this.f3118a, 8);
                this.f3122e = zzam.m33c(this.f3118a, 26);
                int c = this.f3122e + 30 + zzam.m33c(this.f3118a, 28);
                this.f3123f = c;
                int length = this.f3118a.length;
                if (length < c) {
                    do {
                        length += length;
                    } while (length < c);
                    this.f3118a = Arrays.copyOf(this.f3118a, length);
                }
            } else {
                this.f3125h = true;
            }
        }
        int a2 = mo33230a(this.f3123f, bArr, i + a, i2 - a);
        if (a2 == -1) {
            return -1;
        }
        int i3 = a + a2;
        if (!this.f3125h && this.f3126i == null) {
            this.f3126i = new String(this.f3118a, 30, this.f3122e);
        }
        return i3;
    }

    /* renamed from: a */
    public final C2263dx mo33232a() {
        int i = this.f3119b;
        int i2 = this.f3123f;
        if (i < i2) {
            return new C2263dx(this.f3126i, this.f3121d, this.f3124g, true, this.f3125h, Arrays.copyOf(this.f3118a, i));
        }
        C2263dx dxVar = new C2263dx(this.f3126i, this.f3121d, this.f3124g, false, this.f3125h, Arrays.copyOf(this.f3118a, i2));
        mo33233c();
        return dxVar;
    }

    /* renamed from: c */
    public final void mo33233c() {
        this.f3119b = 0;
        this.f3122e = -1;
        this.f3120c = -1;
        this.f3125h = false;
        this.f3123f = 30;
        this.f3121d = -1;
        this.f3124g = -1;
        this.f3126i = null;
    }
}
