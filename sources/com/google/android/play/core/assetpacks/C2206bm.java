package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.bm */
public final class C2206bm extends FilterInputStream {

    /* renamed from: a */
    public final C2243dd f2970a = new C2243dd();

    /* renamed from: b */
    public byte[] f2971b = new byte[4096];

    /* renamed from: c */
    public long f2972c;

    /* renamed from: d */
    public boolean f2973d = false;

    /* renamed from: e */
    public boolean f2974e = false;

    public C2206bm(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: a */
    public final int mo33203a(byte[] bArr, int i, int i2) throws IOException {
        return Math.max(0, super.read(bArr, i, i2));
    }

    /* renamed from: a */
    public final C2263dx mo33204a() throws IOException {
        byte[] bArr;
        if (this.f2972c > 0) {
            do {
                bArr = this.f2971b;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.f2973d || this.f2974e) {
            return new C2263dx((String) null, -1, -1, false, false, (byte[]) null);
        }
        if (!mo33205a(30)) {
            this.f2973d = true;
            return this.f2970a.mo33232a();
        }
        C2263dx a = this.f2970a.mo33232a();
        if (a.f3191e) {
            this.f2974e = true;
            return a;
        } else if (a.f3188b != 4294967295L) {
            int i = this.f2970a.f3123f - 30;
            long j = (long) i;
            int length = this.f2971b.length;
            if (j > ((long) length)) {
                do {
                    length += length;
                } while (((long) length) < j);
                this.f2971b = Arrays.copyOf(this.f2971b, length);
            }
            if (!mo33205a(i)) {
                this.f2973d = true;
                return this.f2970a.mo33232a();
            }
            C2263dx a2 = this.f2970a.mo33232a();
            this.f2972c = a2.f3188b;
            return a2;
        } else {
            throw new C2214bv("Files bigger than 4GiB are not supported.");
        }
    }

    /* renamed from: a */
    public final boolean mo33205a(int i) throws IOException {
        int a = mo33203a(this.f2971b, 0, i);
        if (a != i) {
            int i2 = i - a;
            if (mo33203a(this.f2971b, a, i2) != i2) {
                this.f2970a.mo33231a(this.f2971b, 0, a);
                return false;
            }
        }
        this.f2970a.mo33231a(this.f2971b, 0, i);
        return true;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f2972c;
        if (j <= 0 || this.f2973d) {
            return -1;
        }
        int max = Math.max(0, super.read(bArr, i, (int) Math.min(j, (long) i2)));
        this.f2972c -= (long) max;
        if (max != 0) {
            return max;
        }
        this.f2973d = true;
        return 0;
    }
}
