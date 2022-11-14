package com.swrve.sdk.conversations.p035ui.video;

import android.content.Context;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.conversations.engine.model.Content;
import com.swrve.sdk.conversations.p035ui.ConversationFullScreenVideoFrame;
import com.swrve.sdk.conversations.p035ui.video.WebVideoViewBase;
import java.io.IOException;

/* renamed from: com.swrve.sdk.conversations.ui.video.YoutubeVideoView */
public class YoutubeVideoView extends WebVideoViewBase {
    public static final String VIDEO_HEIGHT_PLACEHOLDER = "VIDEO_HEIGHT_PLACEHOLDER";
    public static final String VIDEO_ID_PLACEHOLDER = "VIDEO_ID_PLACEHOLDER";

    public YoutubeVideoView(Context context, Content content, ConversationFullScreenVideoFrame conversationFullScreenVideoFrame) {
        super(context, content, conversationFullScreenVideoFrame);
    }

    public void init(Content content) {
        String str;
        String youtubeVideoId = content.getYoutubeVideoId();
        String height = content.getHeight();
        try {
            str = SwrveHelper.readStringFromInputStream(getContext().getAssets().open("youtubeapi.html"));
        } catch (IOException e) {
            SwrveLogger.m2754e(Log.getStackTraceString(e), new Object[0]);
            str = "";
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(str.replaceAll(VIDEO_ID_PLACEHOLDER, youtubeVideoId).replaceAll(VIDEO_HEIGHT_PLACEHOLDER, height));
        outline24.append(this.errorHtml);
        String sb = outline24.toString();
        loadDataWithBaseURL((String) null, sb, "text/html", "utf-8", (String) null);
        setWebChromeClient(new WebVideoViewBase.SwrveWebCromeClient());
        setWebViewClient(new WebVideoViewBase.SwrveVideoWebViewClient());
        getSettings().setJavaScriptEnabled(true);
        loadDataWithBaseURL((String) null, sb, "text/html", "utf-8", (String) null);
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            SwrveLogger.m2755i("Stopping the Video!", new Object[0]);
            stopLoading();
            loadData("<p></p>", "text/html", "utf8");
            return;
        }
        stopLoading();
        init(this.model);
    }
}
