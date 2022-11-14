package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.g */
public final /* synthetic */ class C2265g implements OnSuccessListener {

    /* renamed from: a */
    public final C2198bb f3194a;

    public C2265g(C2198bb bbVar) {
        this.f3194a = bbVar;
    }

    public final void onSuccess(Object obj) {
        C2198bb bbVar = this.f3194a;
        List list = (List) obj;
        int a = bbVar.f2950e.mo33237a();
        Iterator it = ((ArrayList) bbVar.mo33186g()).iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!list.contains(file.getName()) && C2198bb.m2857b(file) != ((long) a)) {
                C2198bb.m2858c(file);
            }
        }
    }
}
