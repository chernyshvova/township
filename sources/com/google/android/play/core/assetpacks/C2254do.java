package com.google.android.play.core.assetpacks;

import com.android.billingclient.api.zzam;
import com.google.android.play.core.common.C2284a;
import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2314cj;
import com.google.android.play.core.internal.C2315ck;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* renamed from: com.google.android.play.core.assetpacks.do */
public final class C2254do {

    /* renamed from: a */
    public static final C2292ag f3158a = new C2292ag("PatchSliceTaskHandler");

    /* renamed from: b */
    public final C2198bb f3159b;

    /* renamed from: c */
    public final C2315ck<C2281w> f3160c;

    /* renamed from: d */
    public final C2284a f3161d;

    public C2254do(C2198bb bbVar, C2315ck<C2281w> ckVar, C2284a aVar) {
        this.f3159b = bbVar;
        this.f3160c = ckVar;
        this.f3161d = aVar;
    }

    /* renamed from: a */
    public final void mo33238a(C2253dn dnVar) {
        InputStream inputStream;
        Throwable th;
        C2253dn dnVar2 = dnVar;
        File a = this.f3159b.mo33174a(dnVar2.f3089k, dnVar2.f3150a, dnVar2.f3151b);
        C2198bb bbVar = this.f3159b;
        String str = dnVar2.f3089k;
        int i = dnVar2.f3150a;
        long j = dnVar2.f3151b;
        String str2 = dnVar2.f3155f;
        if (bbVar != null) {
            File file = new File(new File(bbVar.mo33174a(str, i, j), "_metadata"), str2);
            try {
                inputStream = dnVar2.f3157h;
                if (dnVar2.f3154e == 2) {
                    inputStream = new GZIPInputStream(inputStream, 8192);
                }
                C2201be beVar = new C2201be(a, file);
                if (this.f3161d.mo33275a()) {
                    File a2 = this.f3159b.mo33175a(dnVar2.f3089k, dnVar2.f3152c, dnVar2.f3153d, dnVar2.f3155f);
                    if (!a2.exists()) {
                        a2.mkdirs();
                    }
                    C2257dr drVar = new C2257dr(this.f3159b, dnVar2.f3089k, dnVar2.f3152c, dnVar2.f3153d, dnVar2.f3155f);
                    zzam.m24a(beVar, inputStream, new C2217by(a2, drVar), dnVar2.f3156g);
                    drVar.mo33251b(0);
                } else {
                    File file2 = new File(this.f3159b.mo33184f(dnVar2.f3089k, dnVar2.f3152c, dnVar2.f3153d, dnVar2.f3155f), "slice.zip.tmp");
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    zzam.m24a(beVar, inputStream, new FileOutputStream(file2), dnVar2.f3156g);
                    if (!file2.renameTo(this.f3159b.mo33182e(dnVar2.f3089k, dnVar2.f3152c, dnVar2.f3153d, dnVar2.f3155f))) {
                        throw new C2214bv(String.format("Error moving patch for slice %s of pack %s.", new Object[]{dnVar2.f3155f, dnVar2.f3089k}), dnVar2.f3088j);
                    }
                }
                inputStream.close();
                if (this.f3161d.mo33275a()) {
                    f3158a.mo33278a(4, "Patching and extraction finished for slice %s of pack %s.", new Object[]{dnVar2.f3155f, dnVar2.f3089k});
                } else {
                    f3158a.mo33278a(4, "Patching finished for slice %s of pack %s.", new Object[]{dnVar2.f3155f, dnVar2.f3089k});
                }
                this.f3160c.mo33293a().mo33164a(dnVar2.f3088j, dnVar2.f3089k, dnVar2.f3155f, 0);
                try {
                    dnVar2.f3157h.close();
                    return;
                } catch (IOException unused) {
                    f3158a.mo33278a(5, "Could not close file for slice %s of pack %s.", new Object[]{dnVar2.f3155f, dnVar2.f3089k});
                    return;
                }
            } catch (IOException e) {
                f3158a.mo33278a(6, "IOException during patching %s.", new Object[]{e.getMessage()});
                throw new C2214bv(String.format("Error patching slice %s of pack %s.", new Object[]{dnVar2.f3155f, dnVar2.f3089k}), e, dnVar2.f3088j);
            } catch (Throwable th2) {
                C2314cj.f3259a.mo33290a(th, th2);
            }
        } else {
            throw null;
        }
        throw th;
    }
}
