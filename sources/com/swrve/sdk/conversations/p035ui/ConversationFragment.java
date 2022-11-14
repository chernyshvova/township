package com.swrve.sdk.conversations.p035ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.UiModeManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.SwrveBaseConversation;
import com.swrve.sdk.SwrveConversationConstants;
import com.swrve.sdk.SwrveConversationEventHelper;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveIntentHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.conversations.C1694R;
import com.swrve.sdk.conversations.engine.model.ButtonControl;
import com.swrve.sdk.conversations.engine.model.ChoiceInputItem;
import com.swrve.sdk.conversations.engine.model.Content;
import com.swrve.sdk.conversations.engine.model.ControlActions;
import com.swrve.sdk.conversations.engine.model.ControlBase;
import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.ConversationInputChangedListener;
import com.swrve.sdk.conversations.engine.model.ConversationPage;
import com.swrve.sdk.conversations.engine.model.ConversationReply;
import com.swrve.sdk.conversations.engine.model.MultiValueInput;
import com.swrve.sdk.conversations.engine.model.StarRating;
import com.swrve.sdk.conversations.engine.model.UserInputResult;
import com.swrve.sdk.conversations.engine.model.styles.ConversationColorStyle;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import com.swrve.sdk.conversations.p035ui.video.WebVideoViewBase;
import com.swrve.sdk.conversations.p035ui.video.YoutubeVideoView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.swrve.sdk.conversations.ui.ConversationFragment */
public class ConversationFragment extends Fragment implements View.OnClickListener, ConversationInputChangedListener {
    public LinearLayout contentLayout;
    public LinearLayout controlLayout;
    public LinearLayout.LayoutParams controlLp;
    public SwrveConversationEventHelper eventHelper;
    public ConversationFullScreenVideoFrame fullScreenFrame;
    public ConversationPage page;
    public ViewGroup root;
    public SwrveBaseConversation swrveConversation;
    public HashMap<String, UserInputResult> userInteractionData;

    /* renamed from: com.swrve.sdk.conversations.ui.ConversationFragment$2 */
    public static /* synthetic */ class C17022 {

        /* renamed from: $SwitchMap$com$swrve$sdk$conversations$engine$model$styles$ConversationStyle$FONT_NATIVE_STYLE */
        public static final /* synthetic */ int[] f2793xe4761156;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.swrve.sdk.conversations.engine.model.styles.ConversationStyle$FONT_NATIVE_STYLE[] r0 = com.swrve.sdk.conversations.engine.model.styles.ConversationStyle.FONT_NATIVE_STYLE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2793xe4761156 = r0
                r1 = 1
                com.swrve.sdk.conversations.engine.model.styles.ConversationStyle$FONT_NATIVE_STYLE r2 = com.swrve.sdk.conversations.engine.model.styles.ConversationStyle.FONT_NATIVE_STYLE.NORMAL     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f2793xe4761156     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.conversations.engine.model.styles.ConversationStyle$FONT_NATIVE_STYLE r3 = com.swrve.sdk.conversations.engine.model.styles.ConversationStyle.FONT_NATIVE_STYLE.BOLD     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f2793xe4761156     // Catch:{ NoSuchFieldError -> 0x001d }
                com.swrve.sdk.conversations.engine.model.styles.ConversationStyle$FONT_NATIVE_STYLE r3 = com.swrve.sdk.conversations.engine.model.styles.ConversationStyle.FONT_NATIVE_STYLE.ITALIC     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2793xe4761156     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.swrve.sdk.conversations.engine.model.styles.ConversationStyle$FONT_NATIVE_STYLE r2 = com.swrve.sdk.conversations.engine.model.styles.ConversationStyle.FONT_NATIVE_STYLE.BOLDITALIC     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.conversations.p035ui.ConversationFragment.C17022.<clinit>():void");
        }
    }

    private void applyButtonStyles(ConversationStyle conversationStyle) {
        conversationStyle.setTypeface(getTypeface(conversationStyle, SwrveConversationConstants.DEFAULT_BUTTON_TYPEFACE));
        if (conversationStyle.getTextSize() == 0) {
            conversationStyle.setTextSize(getResources().getInteger(C1694R.integer.swrve__conversation_control_default_text_size));
        }
    }

    private void applyMultiValueInputStyles(MultiValueInput multiValueInput) {
        ConversationStyle style = multiValueInput.getStyle();
        style.setTypeface(getTypeface(style, SwrveConversationConstants.DEFAULT_MVI_TITLE_TYPEFACE));
        if (style.getTextSize() == 0) {
            style.setTextSize(getResources().getInteger(C1694R.integer.swrve__conversation_mvi_title_default_text_size));
        }
        Iterator<ChoiceInputItem> it = multiValueInput.getValues().iterator();
        while (it.hasNext()) {
            ChoiceInputItem next = it.next();
            if (next.getStyle() == null) {
                ConversationStyle conversationStyle = new ConversationStyle(0, "", style.getBg(), style.getFg(), (ConversationColorStyle) null);
                conversationStyle.setFg(style.getFg());
                conversationStyle.setTextSize(getResources().getInteger(C1694R.integer.swrve__conversation_mvi_option_default_text_size));
                conversationStyle.setTypeface(getTypeface(conversationStyle, SwrveConversationConstants.DEFAULT_MVI_OPTION_TYPEFACE));
                next.setStyle(conversationStyle);
            } else {
                next.getStyle().setTypeface(getTypeface(next.getStyle(), SwrveConversationConstants.DEFAULT_MVI_OPTION_TYPEFACE));
            }
        }
    }

    public static ConversationFragment create(SwrveBaseConversation swrveBaseConversation) {
        ConversationFragment conversationFragment = new ConversationFragment();
        conversationFragment.swrveConversation = swrveBaseConversation;
        conversationFragment.eventHelper = new SwrveConversationEventHelper();
        return conversationFragment;
    }

    @SuppressLint({"NewApi"})
    private LinearLayout.LayoutParams getContentLayoutParams(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.controlLp);
        layoutParams.width = i;
        layoutParams.height = i2;
        return layoutParams;
    }

    private Typeface getTypeface(ConversationStyle conversationStyle, Typeface typeface) {
        if (conversationStyle.isSystemFont()) {
            int ordinal = conversationStyle.getFontNativeStyle().ordinal();
            if (ordinal == 0) {
                return Typeface.defaultFromStyle(0);
            }
            if (ordinal == 1) {
                return Typeface.defaultFromStyle(1);
            }
            if (ordinal == 2) {
                return Typeface.defaultFromStyle(2);
            }
            if (ordinal != 3) {
                return typeface;
            }
            return Typeface.defaultFromStyle(3);
        } else if (!SwrveHelper.isNotNullOrEmpty(conversationStyle.getFontFile())) {
            return typeface;
        } else {
            File file = new File(this.swrveConversation.getCacheDir(), conversationStyle.getFontFile());
            return file.exists() ? Typeface.createFromFile(file) : typeface;
        }
    }

    private void initLayout() {
        ((ConversationRoundedLinearLayout) this.root.findViewById(C1694R.C1696id.swrve__conversation_modal)).setRadius(SwrveConversationHelper.getRadiusInPixels(getContext(), this.page.getStyle().getBorderRadius()));
        this.contentLayout = (LinearLayout) this.root.findViewById(C1694R.C1696id.swrve__content);
        this.controlLayout = (LinearLayout) this.root.findViewById(C1694R.C1696id.swrve__controls);
        this.fullScreenFrame = (ConversationFullScreenVideoFrame) this.root.findViewById(C1694R.C1696id.swrve__full_screen);
        if (this.contentLayout.getChildCount() > 0) {
            this.contentLayout.removeAllViews();
        }
        if (this.controlLayout.getChildCount() > 0) {
            this.controlLayout.removeAllViews();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.root.getLayoutParams());
        this.controlLp = layoutParams;
        layoutParams.height = -2;
        SwrveConversationHelper.setBackgroundDrawable(this.contentLayout, this.page.getBackground());
        SwrveConversationHelper.setBackgroundDrawable(this.controlLayout, this.page.getBackground());
        this.controlLayout.setGravity(17);
        getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.page.getStyle().getLb().getValue())));
    }

    private void renderContent(Activity activity) {
        Iterator<ConversationAtom> it = this.page.getContent().iterator();
        while (it.hasNext()) {
            ConversationAtom next = it.next();
            ConversationColorStyle bg = next.getStyle().getBg();
            if (next instanceof Content) {
                Content content = (Content) next;
                ConversationAtom.TYPE type = content.getType();
                if (type == ConversationAtom.TYPE.CONTENT_IMAGE) {
                    String str = this.swrveConversation.getCacheDir().getAbsolutePath() + "/" + content.getValue();
                    if (SwrveHelper.hasFileAccess(str)) {
                        ConversationImageView conversationImageView = new ConversationImageView(activity);
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        conversationImageView.setTag(next.getTag());
                        conversationImageView.setImageBitmap(decodeFile);
                        conversationImageView.setAdjustViewBounds(true);
                        conversationImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        SwrveConversationHelper.setBackgroundDrawable(conversationImageView, bg.getPrimaryDrawable());
                        this.contentLayout.addView(conversationImageView);
                    } else {
                        SwrveLogger.m2754e("Could not render conversation asset image because there is no read access to:%s", str);
                    }
                } else if (type == ConversationAtom.TYPE.CONTENT_HTML) {
                    HtmlSnippetView htmlSnippetView = new HtmlSnippetView(activity, content, this.swrveConversation.getCacheDir());
                    htmlSnippetView.setTag(next.getTag());
                    htmlSnippetView.setLayoutParams(getContentLayoutParams(-1, -2));
                    htmlSnippetView.setBackgroundColor(0);
                    SwrveConversationHelper.setBackgroundDrawable(htmlSnippetView, bg.getPrimaryDrawable());
                    this.contentLayout.addView(htmlSnippetView);
                } else if (type == ConversationAtom.TYPE.CONTENT_VIDEO) {
                    final YoutubeVideoView youtubeVideoView = new YoutubeVideoView(activity, content, this.fullScreenFrame);
                    youtubeVideoView.setTag(next.getTag());
                    youtubeVideoView.setBackgroundColor(0);
                    SwrveConversationHelper.setBackgroundDrawable(youtubeVideoView, bg.getPrimaryDrawable());
                    youtubeVideoView.setLayoutParams(getContentLayoutParams(-1, -2));
                    final String tag = next.getTag();
                    youtubeVideoView.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ConversationFragment conversationFragment = ConversationFragment.this;
                            conversationFragment.stashVideoViewed(conversationFragment.page.getTag(), tag, youtubeVideoView);
                            return false;
                        }
                    });
                    this.contentLayout.addView(youtubeVideoView);
                } else if (type == ConversationAtom.TYPE.CONTENT_SPACER) {
                    View view = new View(activity);
                    view.setTag(next.getTag());
                    view.setBackgroundColor(0);
                    SwrveConversationHelper.setBackgroundDrawable(view, bg.getPrimaryDrawable());
                    view.setLayoutParams(getContentLayoutParams(-1, Integer.parseInt(content.getHeight())));
                    this.contentLayout.addView(view);
                }
            } else if (next instanceof MultiValueInput) {
                MultiValueInput multiValueInput = (MultiValueInput) next;
                applyMultiValueInputStyles(multiValueInput);
                MultiValueInputControl inflate = MultiValueInputControl.inflate(activity, this.contentLayout, multiValueInput);
                inflate.setLayoutParams(getContentLayoutParams(-1, -2));
                inflate.setTag(next.getTag());
                inflate.setContentChangedListener(this);
                this.contentLayout.addView(inflate);
            } else if (next instanceof StarRating) {
                ConversationRatingBar conversationRatingBar = new ConversationRatingBar(activity, (StarRating) next, this.swrveConversation.getCacheDir());
                conversationRatingBar.setContentChangedListener(this);
                this.contentLayout.addView(conversationRatingBar);
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void renderControls(Activity activity) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(C1694R.dimen.swrve__control_tray_item_margin);
        int size = this.page.getControls().size();
        for (int i = 0; i < size; i++) {
            ButtonControl buttonControl = this.page.getControls().get(i);
            applyButtonStyles(buttonControl.getStyle());
            ConversationButton conversationButton = new ConversationButton(activity, buttonControl);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.controlLp);
            layoutParams.weight = 1.0f;
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize;
            layoutParams.topMargin = dimensionPixelSize;
            layoutParams.bottomMargin = dimensionPixelSize;
            conversationButton.setLayoutParams(layoutParams);
            this.controlLayout.addView(conversationButton);
            conversationButton.setOnClickListener(this);
        }
    }

    private void sendCallActionEvent(String str, ConversationAtom conversationAtom) {
        this.eventHelper.conversationCallActionCalledByUser(this.swrveConversation, str, conversationAtom.getTag());
    }

    private void sendCancelNavigationEvent(String str) {
        this.eventHelper.conversationWasCancelledByUser(this.swrveConversation, str);
    }

    private void sendDeepLinkActionEvent(String str, ConversationAtom conversationAtom) {
        this.eventHelper.conversationDeeplinkActionCalledByUser(this.swrveConversation, str, conversationAtom.getTag());
    }

    private void sendDoneNavigationEvent(String str, String str2) {
        this.eventHelper.conversationWasFinishedByUser(this.swrveConversation, str, str2);
    }

    private void sendErrorNavigationEvent(String str, Exception exc) {
        this.eventHelper.conversationEncounteredError(this.swrveConversation, str, exc);
    }

    private void sendLinkVisitActionEvent(String str, ConversationAtom conversationAtom) {
        this.eventHelper.conversationLinkVisitActionCalledByUser(this.swrveConversation, str, conversationAtom.getTag());
    }

    private void sendPageImpressionEvent(String str) {
        this.eventHelper.conversationPageWasViewedByUser(this.swrveConversation, str);
    }

    private void sendReply(ControlBase controlBase, ConversationReply conversationReply) {
        conversationReply.setControl(controlBase.getTag());
        ConversationPage pageForControl = this.swrveConversation.getPageForControl(controlBase);
        if (pageForControl != null) {
            sendTransitionPageEvent(this.page.getTag(), controlBase.getTarget(), controlBase.getTag());
            this.eventHelper.sendQueuedEvents();
            openConversationOnPage(pageForControl);
        } else if (controlBase.hasActions()) {
            SwrveLogger.m2755i("User has selected an Action. They are now finished the conversation", new Object[0]);
            sendDoneNavigationEvent(this.page.getTag(), controlBase.getTag());
            FragmentActivity activity = getActivity();
            if (isAdded() && activity != null) {
                activity.finish();
            }
        } else {
            SwrveLogger.m2755i("No more pages in this conversation", new Object[0]);
            sendDoneNavigationEvent(this.page.getTag(), controlBase.getTag());
            FragmentActivity activity2 = getActivity();
            if (isAdded() && activity2 != null) {
                activity2.finish();
            }
        }
    }

    private void sendStartNavigationEvent(String str) {
        this.eventHelper.conversationWasStartedByUser(this.swrveConversation, str);
    }

    private void sendTransitionPageEvent(String str, String str2, String str3) {
        this.eventHelper.conversationTransitionedToOtherPage(this.swrveConversation, str, str2, str3);
    }

    private void stashMultiChoiceInputData(String str, String str2, Map<String, Object> map) {
        String outline17 = GeneratedOutlineSupport.outline17(str, "-", str2);
        for (String str3 : map.keySet()) {
            UserInputResult userInputResult = new UserInputResult();
            userInputResult.type = UserInputResult.TYPE_SINGLE_CHOICE;
            userInputResult.conversationId = this.swrveConversation.getId();
            userInputResult.fragmentTag = str2;
            userInputResult.pageTag = str;
            userInputResult.result = map.get(str3);
            this.userInteractionData.put(outline17, userInputResult);
        }
    }

    private void stashStarRatingInputData(String str, String str2, Map<String, Object> map) {
        String outline17 = GeneratedOutlineSupport.outline17(str, "-", str2);
        for (String str3 : map.keySet()) {
            UserInputResult userInputResult = new UserInputResult();
            userInputResult.type = UserInputResult.TYPE_STAR_RATING;
            userInputResult.conversationId = this.swrveConversation.getId();
            userInputResult.fragmentTag = str2;
            userInputResult.pageTag = str;
            userInputResult.result = map.get(str3);
            this.userInteractionData.put(outline17, userInputResult);
        }
    }

    /* access modifiers changed from: private */
    public void stashVideoViewed(String str, String str2, WebVideoViewBase webVideoViewBase) {
        String outline17 = GeneratedOutlineSupport.outline17(str, "-", str2);
        UserInputResult userInputResult = new UserInputResult();
        userInputResult.type = UserInputResult.TYPE_VIDEO_PLAY;
        userInputResult.conversationId = this.swrveConversation.getId();
        userInputResult.fragmentTag = str2;
        userInputResult.pageTag = str;
        userInputResult.result = "";
        this.userInteractionData.put(outline17, userInputResult);
    }

    public void commitConversationFragment(FragmentManager fragmentManager) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(16908290, (Fragment) this, ConversationActivity.EXTRA_CONVERSATION_KEY);
        beginTransaction.commit();
    }

    public void commitUserInputsToEvents() {
        SwrveLogger.m2755i("Commiting all stashed events", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (String str : this.userInteractionData.keySet()) {
            arrayList.add(this.userInteractionData.get(str));
        }
        this.eventHelper.conversationEventsCommitedByUser(this.swrveConversation, arrayList);
        this.userInteractionData.clear();
    }

    public ConversationPage getPage() {
        return this.page;
    }

    public HashMap<String, UserInputResult> getUserInteractionData() {
        return this.userInteractionData;
    }

    public boolean onBackPressed() {
        if (this.fullScreenFrame.getVisibility() != 8) {
            this.fullScreenFrame.disableFullScreen();
            return false;
        }
        sendCancelNavigationEvent(this.page.getTag());
        commitUserInputsToEvents();
        return true;
    }

    public void onClick(View view) {
        FragmentActivity activity = getActivity();
        if (isAdded() && activity != null && (view instanceof IConversationControl)) {
            commitUserInputsToEvents();
            try {
                if (view instanceof ConversationButton) {
                    ConversationReply conversationReply = new ConversationReply();
                    ButtonControl model = ((ConversationButton) view).getModel();
                    if (((IConversationControl) view).getModel().hasActions()) {
                        ControlActions actions = ((IConversationControl) view).getModel().getActions();
                        if (actions.isCall()) {
                            sendReply(model, conversationReply);
                            sendCallActionEvent(this.page.getTag(), model);
                            SwrveIntentHelper.openDialer(actions.getCallUri(), activity);
                        } else if (actions.isVisit()) {
                            HashMap<String, String> visitDetails = actions.getVisitDetails();
                            Uri parse = Uri.parse(visitDetails.get("url"));
                            sendReply(model, conversationReply);
                            sendLinkVisitActionEvent(this.page.getTag(), model);
                            SwrveIntentHelper.openIntentWebView(parse, activity, visitDetails.get(ControlActions.VISIT_URL_REFERER_KEY));
                        } else if (actions.isDeepLink()) {
                            sendReply(model, conversationReply);
                            sendDeepLinkActionEvent(this.page.getTag(), model);
                            SwrveIntentHelper.openDeepLink(activity, actions.getDeepLinkDetails().get("url"));
                        }
                    } else {
                        sendReply(model, conversationReply);
                    }
                }
            } catch (Exception e) {
                SwrveLogger.m2753e("Could not process button action", e, new Object[0]);
            }
        }
    }

    public void onContentChanged(Map<String, Object> map, ConversationAtom conversationAtom) {
        if (conversationAtom instanceof MultiValueInput) {
            stashMultiChoiceInputData(this.page.getTag(), conversationAtom.getTag(), map);
        } else if (conversationAtom instanceof StarRating) {
            stashStarRatingInputData(this.page.getTag(), conversationAtom.getTag(), map);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C1694R.layout.swrve__conversation_fragment, viewGroup, false);
    }

    public void onPause() {
        super.onPause();
        this.eventHelper.sendQueuedEvents();
    }

    public void onResume() {
        super.onResume();
        HashMap<String, UserInputResult> hashMap = this.userInteractionData;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        this.userInteractionData = hashMap;
        if (this.page != null) {
            View view = getView();
            openConversationOnPage(this.page);
            for (String str : this.userInteractionData.keySet()) {
                UserInputResult userInputResult = this.userInteractionData.get(str);
                View findViewWithTag = view.findViewWithTag(userInputResult.getFragmentTag());
                if (findViewWithTag instanceof IConversationInput) {
                    ((IConversationInput) findViewWithTag).setUserInput(userInputResult);
                }
            }
        } else {
            openFirstPage();
        }
        if (((UiModeManager) getContext().getSystemService("uimode")).getCurrentModeType() == 4 && this.controlLayout.getChildCount() > 0) {
            this.controlLayout.getChildAt(0).requestFocus();
        }
    }

    public void openConversationOnPage(ConversationPage conversationPage) {
        FragmentActivity activity = getActivity();
        if (isAdded() && activity != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            this.root = viewGroup;
            if (viewGroup != null) {
                this.page = conversationPage;
                activity.setTitle(conversationPage.getTitle());
                try {
                    initLayout();
                    renderControls(activity);
                    renderContent(activity);
                    sendPageImpressionEvent(this.page.getTag());
                    this.root.requestFocus();
                } catch (Exception e) {
                    SwrveLogger.m2753e("Error rendering conversation page. Exiting conversation.", e, new Object[0]);
                    sendErrorNavigationEvent(this.page.getTag(), e);
                    activity.finish();
                }
            }
        }
    }

    public void openFirstPage() {
        ConversationPage firstPage = this.swrveConversation.getFirstPage();
        this.page = firstPage;
        if (firstPage == null) {
            getActivity().finish();
            return;
        }
        sendStartNavigationEvent(firstPage.getTag());
        openConversationOnPage(this.page);
    }

    public void setPage(ConversationPage conversationPage) {
        this.page = conversationPage;
    }

    public void setUserInteractionData(HashMap<String, UserInputResult> hashMap) {
        this.userInteractionData = hashMap;
    }
}
