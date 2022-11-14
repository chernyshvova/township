package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.android.play.core.assetpacks.di */
public final /* synthetic */ class C2248di implements Runnable {

    /* renamed from: a */
    public final C2198bb f3135a;

    public C2248di(C2198bb bbVar) {
        this.f3135a = bbVar;
    }

    public final void run() {
        C2198bb bbVar = this.f3135a;
        Iterator it = ((ArrayList) bbVar.mo33186g()).iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file.listFiles() != null) {
                C2198bb.m2856a(file);
                long b = C2198bb.m2857b(file);
                if (((long) bbVar.f2950e.mo33237a()) != b) {
                    try {
                        new File(new File(file, String.valueOf(b)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        C2198bb.f2948a.mo33278a(6, "Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File a : file.listFiles()) {
                    C2198bb.m2856a(a);
                }
            }
        }
    }
}
