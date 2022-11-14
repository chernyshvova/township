package com.vungle.warren;

import com.vungle.warren.error.VungleException;
import java.util.concurrent.ExecutorService;

public class InitCallbackWrapper implements InitCallback {
    public final InitCallback callback;
    public final ExecutorService executorService;

    public InitCallbackWrapper(ExecutorService executorService2, InitCallback initCallback) {
        this.callback = initCallback;
        this.executorService = executorService2;
    }

    public void onAutoCacheAdAvailable(final String str) {
        if (this.callback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    InitCallbackWrapper.this.callback.onAutoCacheAdAvailable(str);
                }
            });
        }
    }

    public void onError(final VungleException vungleException) {
        if (this.callback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    InitCallbackWrapper.this.callback.onError(vungleException);
                }
            });
        }
    }

    public void onSuccess() {
        if (this.callback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    InitCallbackWrapper.this.callback.onSuccess();
                }
            });
        }
    }
}
