package com.google.android.play.core.assetpacks;

import com.android.billingclient.api.zzam;
import com.google.android.play.core.internal.C2292ag;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.play.core.assetpacks.dv */
public final class C2261dv {

    /* renamed from: a */
    public static final C2292ag f3184a = new C2292ag("VerifySliceTaskHandler");

    /* renamed from: b */
    public final C2198bb f3185b;

    public C2261dv(C2198bb bbVar) {
        this.f3185b = bbVar;
    }

    /* renamed from: a */
    public final void mo33258a(C2260du duVar) {
        File a = this.f3185b.mo33175a(duVar.f3089k, duVar.f3180a, duVar.f3181b, duVar.f3182c);
        if (a.exists()) {
            try {
                File f = this.f3185b.mo33184f(duVar.f3089k, duVar.f3180a, duVar.f3181b, duVar.f3182c);
                if (f.exists()) {
                    try {
                        if (zzam.m22a(C2259dt.m2946a(a, f)).equals(duVar.f3183d)) {
                            f3184a.mo33278a(4, "Verification of slice %s of pack %s successful.", new Object[]{duVar.f3182c, duVar.f3089k});
                            File b = this.f3185b.mo33178b(duVar.f3089k, duVar.f3180a, duVar.f3181b, duVar.f3182c);
                            if (!b.exists()) {
                                b.mkdirs();
                            }
                            if (!a.renameTo(b)) {
                                throw new C2214bv(String.format("Failed to move slice %s after verification.", new Object[]{duVar.f3182c}), duVar.f3088j);
                            }
                            return;
                        }
                        throw new C2214bv(String.format("Verification failed for slice %s.", new Object[]{duVar.f3182c}), duVar.f3088j);
                    } catch (NoSuchAlgorithmException e) {
                        throw new C2214bv("SHA256 algorithm not supported.", e, duVar.f3088j);
                    } catch (IOException e2) {
                        throw new C2214bv(String.format("Could not digest file during verification for slice %s.", new Object[]{duVar.f3182c}), e2, duVar.f3088j);
                    }
                } else {
                    throw new C2214bv(String.format("Cannot find metadata files for slice %s.", new Object[]{duVar.f3182c}), duVar.f3088j);
                }
            } catch (IOException e3) {
                throw new C2214bv(String.format("Could not reconstruct slice archive during verification for slice %s.", new Object[]{duVar.f3182c}), e3, duVar.f3088j);
            }
        } else {
            throw new C2214bv(String.format("Cannot find unverified files for slice %s.", new Object[]{duVar.f3182c}), duVar.f3088j);
        }
    }
}
