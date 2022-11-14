package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2293ah;
import com.google.android.play.core.internal.C2324t;
import com.google.android.play.core.internal.C2326v;
import com.google.android.play.core.tasks.C2349i;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ac */
public final class C2175ac extends C2293ah {

    /* renamed from: a */
    public final /* synthetic */ List f2870a;

    /* renamed from: b */
    public final /* synthetic */ C2349i f2871b;

    /* renamed from: c */
    public final /* synthetic */ C2187ar f2872c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2175ac(C2187ar arVar, C2349i iVar, List list, C2349i iVar2) {
        super(iVar);
        this.f2872c = arVar;
        this.f2870a = list;
        this.f2871b = iVar2;
    }

    /* renamed from: a */
    public final void mo33154a() {
        List<String> list = this.f2870a;
        ArrayList arrayList = new ArrayList(list.size());
        for (String putString : list) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", putString);
            arrayList.add(bundle);
        }
        try {
            ((C2324t) this.f2872c.f2910e.f3250l).mo33303b(this.f2872c.f2908c, (List<Bundle>) arrayList, C2187ar.m2840e(), (C2326v) new C2182ak(this.f2872c, this.f2871b, (byte[]) null));
        } catch (RemoteException e) {
            C2187ar.f2906a.mo33279a((Throwable) e, "cancelDownloads(%s)", this.f2870a);
        }
    }
}
