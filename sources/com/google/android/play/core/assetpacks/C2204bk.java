package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.android.billingclient.api.zzam;
import com.google.android.play.core.internal.C2315ck;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.play.core.assetpacks.bk */
public final class C2204bk {

    /* renamed from: a */
    public final C2315ck<C2281w> f2968a;

    public C2204bk(C2315ck<C2281w> ckVar) {
        this.f2968a = ckVar;
    }

    /* renamed from: a */
    public final InputStream mo33202a(int i, String str, String str2, int i2) {
        try {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzam.await(this.f2968a.mo33293a().mo33166b(i, str, str2, i2));
            if (parcelFileDescriptor != null && parcelFileDescriptor.getFileDescriptor() != null) {
                return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            }
            throw new C2214bv(String.format("Corrupted ParcelFileDescriptor, session %s packName %s sliceId %s, chunkNumber %s", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)}), i);
        } catch (ExecutionException e) {
            throw new C2214bv(String.format("Error opening chunk file, session %s packName %s sliceId %s, chunkNumber %s", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)}), e, i);
        } catch (InterruptedException e2) {
            throw new C2214bv("Extractor was interrupted while waiting for chunk file.", e2, i);
        }
    }
}
