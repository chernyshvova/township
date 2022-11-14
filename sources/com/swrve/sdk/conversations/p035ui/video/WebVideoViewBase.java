package com.swrve.sdk.conversations.p035ui.video;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.conversations.engine.model.Content;
import com.swrve.sdk.conversations.p035ui.ConversationFullScreenVideoFrame;
import java.util.Locale;

/* renamed from: com.swrve.sdk.conversations.ui.video.WebVideoViewBase */
public abstract class WebVideoViewBase extends WebView {
    public static final String PLAYER_VIDEO_VIMEO = "vimeo";
    public static final String PLAYER_VIDEO_YOUTUBE = "youtube";
    public String errorHtml;
    public ConversationFullScreenVideoFrame fullScreenContainer;
    public int height;
    public Content model;
    public String url;
    public String videoHtml;

    /* renamed from: com.swrve.sdk.conversations.ui.video.WebVideoViewBase$SwrveVideoWebViewClient */
    public class SwrveVideoWebViewClient extends WebViewClient {
        public SwrveVideoWebViewClient() {
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            SwrveLogger.m2754e("Could not display url: %s\nError code: %s\nMessage: %s", str2, Integer.toString(i), str);
            WebVideoViewBase.this.loadDataWithBaseURL((String) null, GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline26("<html><body style=\"margin: 0; padding: 0;\">", "<div style=\"width: 100%; height: " + WebVideoViewBase.this.height + "px\"></div>"), WebVideoViewBase.this.errorHtml, "</body></html>"), "text/html", "utf-8", (String) null);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            WebVideoViewBase.this.getContext().startActivity(intent);
            return true;
        }
    }

    /* renamed from: com.swrve.sdk.conversations.ui.video.WebVideoViewBase$SwrveWebCromeClient */
    public class SwrveWebCromeClient extends WebChromeClient {
        public WebChromeClient.CustomViewCallback mCustomViewCallback;
        public View mView;

        public SwrveWebCromeClient() {
        }

        public void onHideCustomView() {
            if (this.mView != null) {
                this.mView = null;
                WebVideoViewBase.this.fullScreenContainer.removeWebCromeClient(this);
                WebVideoViewBase.this.fullScreenContainer.removeView(this.mView);
                this.mCustomViewCallback.onCustomViewHidden();
                this.mCustomViewCallback = null;
                WebVideoViewBase.this.fullScreenContainer.setVisibility(8);
            }
            super.onHideCustomView();
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            this.mCustomViewCallback = customViewCallback;
            this.mView = view;
            WebVideoViewBase.this.fullScreenContainer.setWebCromeClient(this);
            WebVideoViewBase.this.fullScreenContainer.setVisibility(0);
            WebVideoViewBase.this.fullScreenContainer.addView(view, -1);
        }
    }

    public WebVideoViewBase(Context context, Content content, ConversationFullScreenVideoFrame conversationFullScreenVideoFrame) {
        super(context);
        this.model = content;
        this.fullScreenContainer = conversationFullScreenVideoFrame;
        this.url = content.getValue();
        int parseInt = Integer.parseInt(content.getHeight());
        this.height = parseInt;
        if (parseInt <= 0) {
            this.height = 220;
        }
        this.errorHtml = "<p " + "style='text-align:center; margin-top:8px'" + ">" + "<a " + "style='font-size: 0.6875em; color: #666; width:100%;'" + " href='" + this.url.toString() + "'>" + "Can't see the video?</a>";
        if (SwrveHelper.isNullOrEmpty(this.url)) {
            Toast.makeText(getContext(), "Unknown Video Player Detected", 0).show();
            this.videoHtml = "<p>Sorry, a malformed URL was detected. This video cannot be played.</p> ";
        } else if (this.url.toLowerCase(Locale.ENGLISH).contains(PLAYER_VIDEO_YOUTUBE) || this.url.toLowerCase(Locale.ENGLISH).contains(PLAYER_VIDEO_VIMEO)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("<iframe type='text/html' width='100%' height='");
            outline24.append(this.height);
            outline24.append("' src=");
            outline24.append(this.url);
            outline24.append(" frameborder='0' webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>");
            outline24.append(this.errorHtml);
            this.videoHtml = outline24.toString();
        } else {
            Toast.makeText(getContext(), "Unknown Video Player Detected", 0).show();
            this.videoHtml = this.errorHtml;
        }
    }
}
