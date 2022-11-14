package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C2344d;
import com.google.android.play.core.tasks.C2346f;
import com.google.android.play.core.tasks.C2353m;
import com.google.android.play.core.tasks.Task;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.e */
public final /* synthetic */ class C2264e implements Runnable {

    /* renamed from: a */
    public final C2267j f3193a;

    public C2264e(C2267j jVar) {
        this.f3193a = jVar;
    }

    public final void run() {
        C2267j jVar = this.f3193a;
        C2281w a = jVar.f3198c.mo33293a();
        C2198bb bbVar = jVar.f3197b;
        if (bbVar != null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            try {
                Iterator it = ((ArrayList) bbVar.mo33186g()).iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    AssetPackLocation b = bbVar.mo33177b(file.getName());
                    if (b != null) {
                        hashMap2.put(file.getName(), b);
                    }
                }
            } catch (IOException e) {
                C2198bb.f2948a.mo33278a(6, "Could not process directory while scanning installed packs: %s", new Object[]{e});
            }
            for (String str : hashMap2.keySet()) {
                hashMap.put(str, Long.valueOf(bbVar.mo33183f(str)));
            }
            Task<List<String>> a2 = a.mo33159a((Map<String, Long>) hashMap);
            C2198bb bbVar2 = jVar.f3197b;
            bbVar2.getClass();
            C2353m mVar = (C2353m) a2;
            mVar.f3305b.mo33329a(new C2346f(jVar.f3200i.mo33293a(), new C2265g(bbVar2)));
            mVar.mo33336c();
            mVar.f3305b.mo33329a(new C2344d(jVar.f3200i.mo33293a(), C2266h.f3195a));
            mVar.mo33336c();
            return;
        }
        throw null;
    }
}
