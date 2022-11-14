package com.google.android.play.core.assetpacks;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.play.core.internal.C2292ag;
import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.assetpacks.df */
public final class C2245df {

    /* renamed from: a */
    public static final C2292ag f3130a = new C2292ag("MergeSliceTaskHandler");

    /* renamed from: b */
    public final C2198bb f3131b;

    public C2245df(C2198bb bbVar) {
        this.f3131b = bbVar;
    }

    /* renamed from: a */
    public static void m2922a(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            for (File file3 : file.listFiles()) {
                m2922a(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                throw new C2214bv(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 28), "Unable to delete directory: ", valueOf));
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            throw new C2214bv(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf2.length() + 51), "File clashing with existing file from other slice: ", valueOf2));
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            throw new C2214bv(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf3.length() + 21), "Unable to move file: ", valueOf3));
        }
    }

    /* renamed from: a */
    public final void mo33234a(C2244de deVar) {
        File b = this.f3131b.mo33178b(deVar.f3089k, deVar.f3127a, deVar.f3128b, deVar.f3129c);
        if (b.exists()) {
            File c = this.f3131b.mo33179c(deVar.f3089k, deVar.f3127a, deVar.f3128b);
            if (!c.exists()) {
                c.mkdirs();
            }
            m2922a(b, c);
            try {
                this.f3131b.mo33176a(deVar.f3089k, deVar.f3127a, deVar.f3128b, this.f3131b.mo33181d(deVar.f3089k, deVar.f3127a, deVar.f3128b) + 1);
            } catch (IOException e) {
                f3130a.mo33278a(6, "Writing merge checkpoint failed with %s.", new Object[]{e.getMessage()});
                throw new C2214bv("Writing merge checkpoint failed.", e, deVar.f3088j);
            }
        } else {
            throw new C2214bv(String.format("Cannot find verified files for slice %s.", new Object[]{deVar.f3129c}), deVar.f3088j);
        }
    }
}
