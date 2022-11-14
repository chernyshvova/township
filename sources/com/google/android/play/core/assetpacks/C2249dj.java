package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2315ck;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.dj */
public final class C2249dj {

    /* renamed from: a */
    public final C2198bb f3136a;

    /* renamed from: b */
    public final C2315ck<C2281w> f3137b;

    /* renamed from: c */
    public final C2232cp f3138c;

    /* renamed from: d */
    public final C2315ck<Executor> f3139d;

    /* renamed from: e */
    public final C2218bz f3140e;

    public C2249dj(C2198bb bbVar, C2315ck<C2281w> ckVar, C2232cp cpVar, C2315ck<Executor> ckVar2, C2218bz bzVar) {
        this.f3136a = bbVar;
        this.f3137b = ckVar;
        this.f3138c = cpVar;
        this.f3139d = ckVar2;
        this.f3140e = bzVar;
    }

    /* renamed from: a */
    public final void mo33236a(C2247dh dhVar) {
        File c = this.f3136a.mo33179c(dhVar.f3089k, dhVar.f3133a, dhVar.f3134b);
        C2198bb bbVar = this.f3136a;
        String str = dhVar.f3089k;
        int i = dhVar.f3133a;
        long j = dhVar.f3134b;
        if (bbVar != null) {
            File file = new File(new File(bbVar.mo33187h(str, i, j), "_slices"), "_metadata");
            if (!c.exists() || !file.exists()) {
                throw new C2214bv(String.format("Cannot find pack files to move for pack %s.", new Object[]{dhVar.f3089k}), dhVar.f3088j);
            }
            File a = this.f3136a.mo33174a(dhVar.f3089k, dhVar.f3133a, dhVar.f3134b);
            a.mkdirs();
            if (c.renameTo(a)) {
                new File(this.f3136a.mo33174a(dhVar.f3089k, dhVar.f3133a, dhVar.f3134b), "merge.tmp").delete();
                C2198bb bbVar2 = this.f3136a;
                String str2 = dhVar.f3089k;
                int i2 = dhVar.f3133a;
                long j2 = dhVar.f3134b;
                if (bbVar2 != null) {
                    File file2 = new File(bbVar2.mo33174a(str2, i2, j2), "_metadata");
                    file2.mkdirs();
                    if (file.renameTo(file2)) {
                        C2198bb bbVar3 = this.f3136a;
                        bbVar3.getClass();
                        this.f3139d.mo33293a().execute(new C2248di(bbVar3));
                        C2232cp cpVar = this.f3138c;
                        cpVar.mo33217a(new C2223ce(cpVar, dhVar.f3089k, dhVar.f3133a, dhVar.f3134b));
                        this.f3140e.mo33215a(dhVar.f3089k);
                        this.f3137b.mo33293a().mo33162a(dhVar.f3088j, dhVar.f3089k);
                        return;
                    }
                    throw new C2214bv("Cannot move metadata files to final location.", dhVar.f3088j);
                }
                throw null;
            }
            throw new C2214bv("Cannot move merged pack files to final location.", dhVar.f3088j);
        }
        throw null;
    }
}
