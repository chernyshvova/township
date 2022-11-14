package com.google.android.play.core.assetpacks;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.google.android.play.core.assetpacks.at */
public final /* synthetic */ class C2189at implements Runnable {

    /* renamed from: a */
    public final C2192aw f2915a;

    /* renamed from: b */
    public final AssetPackState f2916b;

    public C2189at(C2192aw awVar, AssetPackState assetPackState) {
        this.f2915a = awVar;
        this.f2916b = assetPackState;
    }

    public final void run() {
        C2192aw awVar = this.f2915a;
        AssetPackState assetPackState = this.f2916b;
        synchronized (awVar) {
            Iterator it = new HashSet(awVar.f2923b).iterator();
            while (it.hasNext()) {
                ((StateUpdatedListener) it.next()).onStateUpdate(assetPackState);
            }
        }
    }
}
