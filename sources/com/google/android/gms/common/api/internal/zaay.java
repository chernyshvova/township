package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class zaay {
    public final zaaw zaa;

    public zaay(zaaw zaaw) {
        this.zaa = zaaw;
    }

    public abstract void zaa();

    public final void zaa(zaaz zaaz) {
        zaaz.zaf.lock();
        try {
            if (zaaz.zan == this.zaa) {
                zaa();
                zaaz.zaf.unlock();
            }
        } finally {
            zaaz.zaf.unlock();
        }
    }
}
