package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.internal.ai */
public final /* synthetic */ class C2294ai implements IBinder.DeathRecipient {

    /* renamed from: a */
    public final C2302aq f3231a;

    public C2294ai(C2302aq aqVar) {
        this.f3231a = aqVar;
    }

    public final void binderDied() {
        C2302aq aqVar = this.f3231a;
        aqVar.f3241c.mo33278a(4, "reportBinderDeath", new Object[0]);
        C2297al alVar = (C2297al) aqVar.f3247i.get();
        if (alVar == null) {
            aqVar.f3241c.mo33278a(4, "%s : Binder has died.", new Object[]{aqVar.f3242d});
            for (C2293ah ahVar : aqVar.f3243e) {
                C2349i<?> iVar = ahVar.f3230a;
                if (iVar != null) {
                    iVar.mo33330b((Exception) new RemoteException(String.valueOf(aqVar.f3242d).concat(" : Binder has died.")));
                }
            }
            aqVar.f3243e.clear();
            return;
        }
        aqVar.f3241c.mo33278a(4, "calling onBinderDied", new Object[0]);
        alVar.mo33282a();
    }
}
