package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.play.core.assetpacks.by */
public final class C2217by extends OutputStream {

    /* renamed from: a */
    public final C2243dd f3040a = new C2243dd();

    /* renamed from: b */
    public final File f3041b;

    /* renamed from: c */
    public final C2257dr f3042c;

    /* renamed from: d */
    public long f3043d;

    /* renamed from: e */
    public long f3044e;

    /* renamed from: f */
    public FileOutputStream f3045f;

    /* renamed from: g */
    public C2263dx f3046g;

    public C2217by(File file, C2257dr drVar) {
        this.f3041b = file;
        this.f3042c = drVar;
    }

    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        while (i2 > 0) {
            if (this.f3043d == 0 && this.f3044e == 0) {
                int a = this.f3040a.mo33231a(bArr, i, i2);
                if (a != -1) {
                    i += a;
                    i2 -= a;
                    C2263dx a2 = this.f3040a.mo33232a();
                    this.f3046g = a2;
                    if (a2.f3191e) {
                        this.f3043d = 0;
                        C2257dr drVar = this.f3042c;
                        byte[] bArr2 = a2.f3192f;
                        drVar.mo33252b(bArr2, bArr2.length);
                        this.f3044e = (long) this.f3046g.f3192f.length;
                    } else if (!a2.mo33260b() || this.f3046g.mo33259a()) {
                        byte[] bArr3 = this.f3046g.f3192f;
                        this.f3042c.mo33252b(bArr3, bArr3.length);
                        this.f3043d = this.f3046g.f3188b;
                    } else {
                        this.f3042c.mo33247a(this.f3046g.f3192f);
                        File file = new File(this.f3041b, this.f3046g.f3187a);
                        file.getParentFile().mkdirs();
                        this.f3043d = this.f3046g.f3188b;
                        this.f3045f = new FileOutputStream(file);
                    }
                } else {
                    return;
                }
            }
            if (!this.f3046g.mo33259a()) {
                C2263dx dxVar = this.f3046g;
                if (dxVar.f3191e) {
                    this.f3042c.mo33244a(this.f3044e, bArr, i, i2);
                    this.f3044e += (long) i2;
                    i3 = i2;
                } else if (dxVar.mo33260b()) {
                    i3 = (int) Math.min((long) i2, this.f3043d);
                    this.f3045f.write(bArr, i, i3);
                    long j = this.f3043d - ((long) i3);
                    this.f3043d = j;
                    if (j == 0) {
                        this.f3045f.close();
                    }
                } else {
                    i3 = (int) Math.min((long) i2, this.f3043d);
                    C2263dx dxVar2 = this.f3046g;
                    int length = dxVar2.f3192f.length;
                    long j2 = dxVar2.f3188b;
                    this.f3042c.mo33244a((((long) length) + j2) - this.f3043d, bArr, i, i3);
                    this.f3043d -= (long) i3;
                }
                i += i3;
                i2 -= i3;
            }
        }
    }
}
