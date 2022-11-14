package com.swrve.sdk.conversations.p035ui;

import android.content.Context;
import android.webkit.WebView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.conversations.engine.model.Content;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import com.vungle.warren.model.Advertisement;
import java.io.File;
import java.io.InputStream;
import java.text.MessageFormat;

/* renamed from: com.swrve.sdk.conversations.ui.HtmlSnippetView */
public class HtmlSnippetView extends WebView {
    public static final String FONT_FACE_TEMPLATE = "@font-face '{' font-family: ''{0}''; src: url(''{1}'');'}'";
    public File cacheDir;
    public String css = "";
    public String fontFace = "";

    public HtmlSnippetView(Context context, Content content, File file) {
        super(context);
        this.cacheDir = file;
        initCss();
        initFont(content);
        initHtml(content);
        getSettings().setAllowFileAccess(true);
    }

    private void initCss() {
        try {
            InputStream open = getContext().getAssets().open("swrve__css_defaults.css");
            if (open != null) {
                this.css = SwrveHelper.readStringFromInputStream(open);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Error init'ing default css", e, new Object[0]);
        }
        if (SwrveHelper.isNullOrEmpty(this.css)) {
            this.css = "";
        }
    }

    private void initFont(Content content) {
        if (content.getStyle() != null) {
            ConversationStyle style = content.getStyle();
            if (SwrveHelper.isNotNullOrEmpty(style.getFontFile())) {
                File file = new File(this.cacheDir, style.getFontFile());
                if (file.exists()) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24(Advertisement.FILE_SCHEME);
                    outline24.append(file.getAbsolutePath());
                    this.fontFace = MessageFormat.format(FONT_FACE_TEMPLATE, new Object[]{content.getStyle().getFontPostscriptName(), outline24.toString()});
                }
            }
        }
    }

    public void initHtml(Content content) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("<html><head><style>");
        outline24.append(this.fontFace);
        outline24.append(this.css);
        outline24.append("</style></head><body><div style='max-width:100%; overflow: hidden; word-wrap: break-word;'>");
        outline24.append(content.getValue());
        outline24.append("</div></body></html>");
        loadDataWithBaseURL((String) null, outline24.toString(), "text/html", "UTF-8", (String) null);
    }
}
