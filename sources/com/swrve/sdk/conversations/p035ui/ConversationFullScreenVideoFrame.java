package com.swrve.sdk.conversations.p035ui;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;

/* renamed from: com.swrve.sdk.conversations.ui.ConversationFullScreenVideoFrame */
public class ConversationFullScreenVideoFrame extends FrameLayout {
    public WebChromeClient webCromeClient;

    public ConversationFullScreenVideoFrame(Context context) {
        super(context);
    }

    public void disableFullScreen() {
        WebChromeClient webChromeClient = this.webCromeClient;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
            this.webCromeClient = null;
        }
        setVisibility(8);
    }

    public void removeWebCromeClient(WebChromeClient webChromeClient) {
        if (this.webCromeClient == webChromeClient) {
            this.webCromeClient = null;
        }
    }

    public void setWebCromeClient(WebChromeClient webChromeClient) {
        this.webCromeClient = webChromeClient;
    }

    public ConversationFullScreenVideoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(false);
    }
}
