package com.vungle.warren;

import java.util.concurrent.ExecutorService;

public class HeaderBiddingCallbackWrapper implements HeaderBiddingCallback {
    public final HeaderBiddingCallback callback;
    public final ExecutorService executorService;

    public HeaderBiddingCallbackWrapper(ExecutorService executorService2, HeaderBiddingCallback headerBiddingCallback) {
        this.callback = headerBiddingCallback;
        this.executorService = executorService2;
    }

    public void adAvailableForBidToken(final String str, final String str2) {
        if (this.callback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    HeaderBiddingCallbackWrapper.this.callback.adAvailableForBidToken(str, str2);
                }
            });
        }
    }

    public void onBidTokenAvailable(final String str, final String str2) {
        if (this.callback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    HeaderBiddingCallbackWrapper.this.callback.onBidTokenAvailable(str, str2);
                }
            });
        }
    }
}
