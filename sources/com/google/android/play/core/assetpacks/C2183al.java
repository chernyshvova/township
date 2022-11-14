package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.assetpacks.al */
public final class C2183al extends C2182ak<ParcelFileDescriptor> {
    public C2183al(C2187ar arVar, C2349i<ParcelFileDescriptor> iVar) {
        super(arVar, iVar);
    }

    /* renamed from: b */
    public final void mo33158b(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.f2899b.f2910e.mo33285a();
        C2187ar.f2906a.mo33278a(4, "onGetChunkFileDescriptor", new Object[0]);
        this.f2898a.mo33331b((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
