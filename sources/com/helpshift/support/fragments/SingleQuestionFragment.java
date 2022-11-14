package com.helpshift.support.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.C2466R;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.C2500F;
import com.helpshift.support.ContactUsFilter;
import com.helpshift.support.Faq;
import com.helpshift.support.HSApiData;
import com.helpshift.support.contracts.FaqFlowViewParent;
import com.helpshift.support.contracts.FaqFragmentListener;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.util.FragmentUtil;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.support.webkit.CustomWebChromeClient;
import com.helpshift.support.webkit.CustomWebView;
import com.helpshift.support.webkit.CustomWebViewClient;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftConnectionUtil;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.StringUtils;
import com.helpshift.util.Styles;
import com.helpshift.views.FontApplier;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SingleQuestionFragment extends MainFragment implements View.OnClickListener, CustomWebViewClient.CustomWebViewClientListeners {
    public static final String BUNDLE_ARG_QUESTION_LANGUAGE = "questionLanguage";
    public static final String BUNDLE_ARG_QUESTION_PUBLISH_ID = "questionPublishId";
    public static final String BUNDLE_ARG_QUESTION_SOURCE = "questionSource";
    public static final String JS_inlineScriptTag = "javascript:";
    public static final String JS_scriptTag = "<script";
    public static final String TAG = "Helpshift_SingleQstn";
    public Button contactUsButton;
    public HSApiData data;
    public boolean decomp;
    public boolean eventSent;
    public Faq highlightedQuestion;
    public int isHelpful = 0;
    public boolean isHighlighted;
    public Button noButton;
    public View progressBar;
    public Faq question;
    public View questionFooter;
    public TextView questionFooterMessage;
    public String questionPublishId;
    public QuestionReadListener questionReadListener;
    public String questionSource;
    public boolean showRootLayoutInsideCardView = false;
    public int singleQuestionMode = 1;
    public SupportController supportController;
    public String textColor;
    public String textColorLink;
    public CustomWebView webView;
    public Button yesButton;

    public static class Failure extends Handler {
        public WeakReference<SingleQuestionFragment> singleQuestionFragmentWeakReference;

        public Failure(SingleQuestionFragment singleQuestionFragment) {
            this.singleQuestionFragmentWeakReference = new WeakReference<>(singleQuestionFragment);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            SingleQuestionFragment singleQuestionFragment = (SingleQuestionFragment) this.singleQuestionFragmentWeakReference.get();
            if (singleQuestionFragment != null && !singleQuestionFragment.isDetached() && singleQuestionFragment.question == null) {
                SnackbarUtil.showErrorSnackbar(102, singleQuestionFragment.getView());
            }
        }
    }

    public interface QuestionReadListener {
        void onQuestionRead(String str);
    }

    public static class SingleQuestionModes {
        public static final int ADMIN_SUGGESTED = 3;
        public static final int DONE = 2;
        public static final int STANDARD = 1;
    }

    public static class Success extends Handler {
        public WeakReference<SingleQuestionFragment> singleQuestionFragmentWeakReference;

        public Success(SingleQuestionFragment singleQuestionFragment) {
            this.singleQuestionFragmentWeakReference = new WeakReference<>(singleQuestionFragment);
        }

        public void handleMessage(Message message) {
            Faq faq;
            super.handleMessage(message);
            SingleQuestionFragment singleQuestionFragment = (SingleQuestionFragment) this.singleQuestionFragmentWeakReference.get();
            if (singleQuestionFragment != null && (faq = (Faq) message.obj) != null) {
                singleQuestionFragment.setQuestion(faq);
                String id = faq.getId();
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("FAQ question loaded : ");
                outline24.append(faq.title);
                HSLogger.m3237d(SingleQuestionFragment.TAG, outline24.toString());
                if (!singleQuestionFragment.eventSent && !TextUtils.isEmpty(id)) {
                    singleQuestionFragment.reportReadFaqEvent();
                }
            }
        }
    }

    private void getColorsFromTheme(Context context) {
        this.textColor = Styles.getHexColor(context, 16842806);
        this.textColorLink = Styles.getHexColor(context, C2466R.attr.hs__faqTextColorLink);
    }

    private String getStyledBody(Faq faq) {
        String str;
        String str2;
        StringBuilder sb;
        String fontPath = FontApplier.getFontPath();
        if (!TextUtils.isEmpty(fontPath)) {
            str2 = GeneratedOutlineSupport.outline17("@font-face {    font-family: custom;    src: url('", GeneratedOutlineSupport.outline16("file:///android_asset/", fontPath), "');}");
            str = "font-family: custom, sans-serif;";
        } else {
            str2 = "";
            str = str2;
        }
        String str3 = faq.body;
        String str4 = faq.title;
        if (!TextUtils.isEmpty(str3)) {
            str3 = str3.replace(JS_scriptTag, "").replace(JS_inlineScriptTag, "");
        }
        if (!TextUtils.isEmpty(str4)) {
            str4 = str4.replace(JS_scriptTag, "").replace(JS_inlineScriptTag, "");
        }
        if (faq.is_rtl.booleanValue()) {
            sb = new StringBuilder("<html dir=\"rtl\">");
        } else {
            sb = new StringBuilder("<html>");
        }
        GeneratedOutlineSupport.outline34(sb, "<head>", "    <style type='text/css'>", str2, "        img,");
        GeneratedOutlineSupport.outline34(sb, "        object,", "        embed {", "            max-width: 100%;", "        }");
        GeneratedOutlineSupport.outline34(sb, "        a,", "        a:visited,", "        a:active,", "        a:hover {");
        sb.append("            color: ");
        GeneratedOutlineSupport.outline34(sb, this.textColorLink, ";", "        }", "        body {");
        GeneratedOutlineSupport.outline34(sb, "            background-color: transparent;", "            margin: 0;", "            padding: ", "16px 16px 96px 16px;");
        GeneratedOutlineSupport.outline34(sb, "            font-size: ", "16px", ";", str);
        GeneratedOutlineSupport.outline34(sb, "            line-height: ", "1.5", ";", "            white-space: normal;");
        sb.append("            word-wrap: break-word;");
        sb.append("            color: ");
        GeneratedOutlineSupport.outline34(sb, this.textColor, ";", "        }", "        .title {");
        sb.append("            display: block;");
        sb.append("            margin: 0;");
        sb.append("            padding: 0 0 ");
        sb.append(16);
        GeneratedOutlineSupport.outline34(sb, " 0;", "            font-size: ", "24px", ";");
        GeneratedOutlineSupport.outline34(sb, str, "            line-height: ", "32px", ";");
        GeneratedOutlineSupport.outline34(sb, "        }", "        h1, h2, h3 { ", "            line-height: 1.4; ", "        }");
        GeneratedOutlineSupport.outline34(sb, "    </style>", "    <script language='javascript'>", "     window.onload = function () {", "        var w = window,");
        GeneratedOutlineSupport.outline34(sb, "            d = document,", "            e = d.documentElement,", "            g = d.getElementsByTagName('body')[0],", "            sWidth = Math.min (w.innerWidth || Infinity, e.clientWidth || Infinity, g.clientWidth || Infinity),");
        GeneratedOutlineSupport.outline34(sb, "            sHeight = Math.min (w.innerHeight || Infinity, e.clientHeight || Infinity, g.clientHeight || Infinity);", "        var frame, fw, fh;", "        var iframes = document.getElementsByTagName('iframe');", "        var padding = ");
        sb.append(32);
        sb.append(";");
        sb.append("        for (var i=0; i < iframes.length; i++) {");
        sb.append("            frame = iframes[i];");
        GeneratedOutlineSupport.outline34(sb, "            fw = frame.offsetWidth;", "            fh = frame.offsetHeight;", "            if (fw >= fh && fw > (sWidth - padding)) {", "                frame.style.width = sWidth - padding;");
        GeneratedOutlineSupport.outline34(sb, "                frame.style.height = ((sWidth - padding) * fh/fw).toString();", "            }", "        }", "        document.addEventListener('click', function (event) {");
        GeneratedOutlineSupport.outline34(sb, "            if (event.target instanceof HTMLImageElement) {", "                event.preventDefault();", "                event.stopPropagation();", "            }");
        GeneratedOutlineSupport.outline34(sb, "        }, false);", "    };", "    </script>", "</head>");
        GeneratedOutlineSupport.outline34(sb, "<body>", "    <strong class='title'> ", str4, " </strong> ");
        return GeneratedOutlineSupport.outline19(sb, str3, "</body>", "</html>");
    }

    private void hideQuestionFooter() {
        this.questionFooter.setVisibility(8);
    }

    private void highlightAndReloadQuestion() {
        this.isHighlighted = true;
        final ArrayList<String> stringArrayList = getArguments().getStringArrayList("searchTerms");
        HelpshiftContext.getCoreApi().getDomain().runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                SingleQuestionFragment singleQuestionFragment = SingleQuestionFragment.this;
                Faq unused = singleQuestionFragment.highlightedQuestion = com.helpshift.support.util.Styles.getQuestionWithHighlightedSearchTerms(singleQuestionFragment.getContext(), SingleQuestionFragment.this.question, stringArrayList);
                HelpshiftContext.getCoreApi().getDomain().runOnUI(new C2500F() {
                    /* renamed from: f */
                    public void mo33949f() {
                        if (SingleQuestionFragment.this.highlightedQuestion != null) {
                            SingleQuestionFragment singleQuestionFragment = SingleQuestionFragment.this;
                            singleQuestionFragment.setQuestion(singleQuestionFragment.highlightedQuestion);
                        }
                    }
                });
            }
        });
    }

    private void markQuestion(boolean z) {
        Faq faq = this.question;
        if (faq != null) {
            String id = faq.getId();
            this.data.markFaqInDB(id, z);
            HelpshiftContext.getCoreApi().getFaqDM().markHelpful(id, z);
        }
    }

    public static SingleQuestionFragment newInstance(Bundle bundle, int i, boolean z, QuestionReadListener questionReadListener2) {
        SingleQuestionFragment singleQuestionFragment = new SingleQuestionFragment();
        singleQuestionFragment.setArguments(bundle);
        singleQuestionFragment.singleQuestionMode = i;
        singleQuestionFragment.showRootLayoutInsideCardView = z;
        singleQuestionFragment.questionReadListener = questionReadListener2;
        return singleQuestionFragment;
    }

    private void setIsHelpful(int i) {
        if (i != 0) {
            this.isHelpful = i;
        }
        updateFooter();
    }

    private void showHelpfulFooter() {
        this.questionFooter.setVisibility(0);
        this.questionFooterMessage.setText(getResources().getString(C2466R.string.hs__question_helpful_message));
        this.questionFooterMessage.setGravity(17);
        this.contactUsButton.setVisibility(8);
        this.yesButton.setVisibility(8);
        this.noButton.setVisibility(8);
    }

    private void showProgress(boolean z) {
        View view = this.progressBar;
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    private void showQuestionFooter() {
        this.questionFooter.setVisibility(0);
        this.questionFooterMessage.setText(getResources().getString(C2466R.string.hs__mark_yes_no_question));
        this.contactUsButton.setVisibility(8);
        this.yesButton.setVisibility(0);
        this.noButton.setVisibility(0);
    }

    private void showQuestionFooterContactUs() {
        if (ContactUsFilter.showContactUs(ContactUsFilter.LOCATION.QUESTION_FOOTER)) {
            this.contactUsButton.setVisibility(0);
        } else {
            this.contactUsButton.setVisibility(8);
        }
    }

    private void showUnhelpfulFooter() {
        this.questionFooter.setVisibility(0);
        this.questionFooterMessage.setText(getResources().getString(C2466R.string.hs__question_unhelpful_message));
        showQuestionFooterContactUs();
        this.yesButton.setVisibility(8);
        this.noButton.setVisibility(8);
    }

    private void updateFooter() {
        if (this.singleQuestionMode == 3) {
            hideQuestionFooter();
            return;
        }
        int i = this.isHelpful;
        if (i == -1) {
            showUnhelpfulFooter();
        } else if (i == 0) {
            showQuestionFooter();
        } else if (i == 1) {
            showHelpfulFooter();
        }
    }

    public FaqFragmentListener getFaqFlowListener() {
        FaqFlowViewParent faqFlowViewParent = (FaqFlowViewParent) getParentFragment();
        if (faqFlowViewParent != null) {
            return faqFlowViewParent.getFaqFlowListener();
        }
        return null;
    }

    public String getQuestionId() {
        Faq faq = this.question;
        return faq != null ? faq.getId() : "";
    }

    public String getQuestionPublishId() {
        return this.questionPublishId;
    }

    public void onAttach(Context context) {
        try {
            super.onAttach(context);
            this.data = new HSApiData(context);
            SupportFragment supportFragment = FragmentUtil.getSupportFragment(this);
            if (supportFragment != null) {
                this.supportController = supportFragment.getSupportController();
            }
            this.fragmentName = SingleQuestionFragment.class.getName() + this.singleQuestionMode;
        } catch (Exception e) {
            Log.e(TAG, "Caught exception in SingleQuestionFragment.onAttach()", e);
        }
    }

    public void onClick(View view) {
        SupportFragment supportFragment;
        if (view.getId() == C2466R.C2468id.helpful_button) {
            markQuestion(true);
            setIsHelpful(1);
            if (this.singleQuestionMode == 2 && (supportFragment = FragmentUtil.getSupportFragment(this)) != null) {
                supportFragment.getSupportController().actionDone();
            }
        } else if (view.getId() == C2466R.C2468id.unhelpful_button) {
            markQuestion(false);
            setIsHelpful(-1);
        } else if (view.getId() == C2466R.C2468id.contact_us_button && this.supportController != null) {
            if (this.singleQuestionMode == 1) {
                FaqFragmentListener faqFlowListener = getFaqFlowListener();
                if (faqFlowListener != null) {
                    faqFlowListener.onContactUsClicked((String) null);
                    return;
                }
                return;
            }
            SupportFragment supportFragment2 = FragmentUtil.getSupportFragment(this);
            if (supportFragment2 != null) {
                supportFragment2.getSupportController().sendAnyway();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.decomp = arguments.getBoolean(SupportFragmentConstants.DECOMPOSED, false);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = C2466R.layout.hs__single_question_fragment;
        if (this.showRootLayoutInsideCardView) {
            i = C2466R.layout.hs__single_question_layout_with_cardview;
        }
        return layoutInflater.inflate(i, viewGroup, false);
    }

    public void onDestroyView() {
        SnackbarUtil.hideSnackbar(getView());
        this.questionFooter = null;
        this.webView.setWebViewClient((WebViewClient) null);
        this.webView = null;
        this.noButton = null;
        this.yesButton = null;
        this.contactUsButton = null;
        super.onDestroyView();
    }

    public void onPageFinished() {
        if (isVisible()) {
            showProgress(false);
            setIsHelpful(this.question.is_helpful);
            if (this.isHighlighted) {
                this.isHighlighted = false;
            } else {
                highlightAndReloadQuestion();
            }
        }
    }

    public void onPageStarted() {
        showProgress(true);
    }

    public void onPause() {
        super.onPause();
        this.webView.onPause();
    }

    public void onResume() {
        super.onResume();
        if (isScreenLarge()) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof FaqFlowFragment) {
                ((FaqFlowFragment) parentFragment).updateSelectQuestionUI(false);
            }
        }
        this.webView.onResume();
        if (this.decomp || !isScreenLarge()) {
            setToolbarTitle(getString(C2466R.string.hs__question_header));
        }
        Faq faq = this.question;
        if (faq != null && !TextUtils.isEmpty(faq.getId()) && !this.eventSent) {
            reportReadFaqEvent();
        }
    }

    public void onStart() {
        super.onStart();
        if (!isChangingConfigurations()) {
            this.eventSent = false;
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        CustomWebView customWebView = (CustomWebView) view.findViewById(C2466R.C2468id.web_view);
        this.webView = customWebView;
        customWebView.setBackgroundColor(0);
        this.webView.setWebViewClient(new CustomWebViewClient(HelpshiftContext.getApplicationContext(), this));
        this.webView.setWebChromeClient(new CustomWebChromeClient(getActivity().getWindow().getDecorView(), view.findViewById(C2466R.C2468id.faq_content_view)));
        Button button = (Button) view.findViewById(C2466R.C2468id.helpful_button);
        this.yesButton = button;
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(C2466R.C2468id.unhelpful_button);
        this.noButton = button2;
        button2.setOnClickListener(this);
        this.questionFooter = view.findViewById(C2466R.C2468id.question_footer);
        this.questionFooterMessage = (TextView) view.findViewById(C2466R.C2468id.question_footer_message);
        Button button3 = (Button) view.findViewById(C2466R.C2468id.contact_us_button);
        this.contactUsButton = button3;
        button3.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= 24) {
            this.yesButton.setText(C2466R.string.hs__mark_yes);
            this.noButton.setText(C2466R.string.hs__mark_no);
            this.contactUsButton.setText(C2466R.string.hs__contact_us_btn);
        }
        if (this.singleQuestionMode == 2) {
            this.contactUsButton.setText(getResources().getString(C2466R.string.hs__send_anyway));
        }
        Bundle arguments = getArguments();
        this.questionSource = arguments.getString(BUNDLE_ARG_QUESTION_SOURCE);
        this.questionPublishId = arguments.getString(BUNDLE_ARG_QUESTION_PUBLISH_ID);
        int i = arguments.getInt(SupportFragment.SUPPORT_MODE);
        String string = arguments.getString(BUNDLE_ARG_QUESTION_LANGUAGE, "");
        boolean z = this.singleQuestionMode == 3;
        this.data.getQuestion(new Success(this), new Failure(this), z || i == 3, z, this.questionPublishId, string);
        this.progressBar = view.findViewById(C2466R.C2468id.progress_bar);
    }

    public void reportReadFaqEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", this.question.getId());
        hashMap.put("nt", Boolean.valueOf(HelpshiftConnectionUtil.isOnline(getContext())));
        if (!StringUtils.isEmpty(this.questionSource)) {
            hashMap.put(AnalyticsEventKey.FAQ_SOURCE, this.questionSource);
        }
        HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.READ_FAQ, (Map<String, Object>) hashMap);
        QuestionReadListener questionReadListener2 = this.questionReadListener;
        if (questionReadListener2 != null) {
            questionReadListener2.onQuestionRead(this.question.getId());
        }
        this.eventSent = true;
    }

    public void setQuestion(Faq faq) {
        this.question = faq;
        if (this.webView != null) {
            getColorsFromTheme(getContext());
            this.webView.loadDataWithBaseURL((String) null, getStyledBody(faq), "text/html", "utf-8", (String) null);
        }
    }

    public boolean shouldRefreshMenu() {
        return true;
    }
}
