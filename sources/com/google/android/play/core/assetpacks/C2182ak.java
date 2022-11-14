package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2325u;
import com.google.android.play.core.tasks.C2349i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ak */
public class C2182ak<T> extends C2325u {

    /* renamed from: a */
    public final C2349i<T> f2898a;

    /* renamed from: b */
    public final /* synthetic */ C2187ar f2899b;

    public C2182ak(C2187ar arVar, C2349i<T> iVar) {
        this.f2899b = arVar;
        this.f2898a = iVar;
    }

    public C2182ak(C2187ar arVar, C2349i iVar, byte[] bArr) {
        this.f2899b = arVar;
        this.f2898a = iVar;
    }

    /* renamed from: a */
    public void mo33155a(Bundle bundle) {
        this.f2899b.f2910e.mo33285a();
        int i = bundle.getInt("error_code");
        C2187ar.f2906a.mo33278a(6, "onError(%d)", new Object[]{Integer.valueOf(i)});
        this.f2898a.mo33330b((Exception) new AssetPackException(i));
    }

    /* renamed from: b */
    public void mo33158b(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.f2899b.f2910e.mo33285a();
        C2187ar.f2906a.mo33278a(4, "onGetChunkFileDescriptor", new Object[0]);
    }

    public C2182ak(C2187ar arVar, C2349i iVar, char[] cArr) {
        this.f2899b = arVar;
        this.f2898a = iVar;
    }

    public C2182ak(C2187ar arVar, C2349i iVar, int[] iArr) {
        this.f2899b = arVar;
        this.f2898a = iVar;
    }

    /* renamed from: a */
    public void mo33156a(Bundle bundle, Bundle bundle2) {
        this.f2899b.f2911f.mo33285a();
        C2187ar.f2906a.mo33278a(4, "onKeepAlive(%b)", new Object[]{Boolean.valueOf(bundle.getBoolean("keep_alive"))});
    }

    /* renamed from: a */
    public void mo33157a(List<Bundle> list) {
        this.f2899b.f2910e.mo33285a();
        C2187ar.f2906a.mo33278a(4, "onGetSessionStates", new Object[0]);
    }
}
