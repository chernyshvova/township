package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class zaap implements Runnable {
    public final /* synthetic */ zaaf zaa;

    public zaap(zaaf zaaf) {
        this.zaa = zaaf;
    }

    @WorkerThread
    public void run() {
        this.zaa.zab.lock();
        try {
            if (!Thread.interrupted()) {
                zaa();
                this.zaa.zab.unlock();
            }
        } catch (RuntimeException e) {
            this.zaa.zaa.zaa(e);
        } finally {
            this.zaa.zab.unlock();
        }
    }

    @WorkerThread
    public abstract void zaa();

    public /* synthetic */ zaap(zaaf zaaf, zaae zaae) {
        this(zaaf);
    }
}
