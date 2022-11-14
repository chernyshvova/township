package com.helpshift.support.controllers;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.C2466R;
import com.helpshift.CoreApi;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.domainmodel.ConversationSetupDM;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.ConversationDetailDTO;
import com.helpshift.support.contracts.AttachmentPreviewListener;
import com.helpshift.support.contracts.SearchResultListener;
import com.helpshift.support.contracts.SupportScreenView;
import com.helpshift.support.conversations.AuthenticationFailureFragment;
import com.helpshift.support.conversations.BaseConversationFragment;
import com.helpshift.support.conversations.ConversationalFragment;
import com.helpshift.support.conversations.NewConversationFragment;
import com.helpshift.support.conversations.usersetup.ConversationSetupFragment;
import com.helpshift.support.flows.CustomContactUsFlowListHolder;
import com.helpshift.support.flows.DynamicFormFlowListHolder;
import com.helpshift.support.flows.Flow;
import com.helpshift.support.fragments.AttachmentPreviewFragment;
import com.helpshift.support.fragments.DynamicFormFragment;
import com.helpshift.support.fragments.FaqFlowFragment;
import com.helpshift.support.fragments.SearchResultFragment;
import com.helpshift.support.fragments.SingleQuestionFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.fragments.SupportFragmentConstants;
import com.helpshift.support.util.FragmentUtil;
import com.helpshift.support.util.Styles;
import com.helpshift.support.util.SupportNotification;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupportController implements SearchResultListener, AttachmentPreviewListener {
    public static final String TAG = "Helpshift_SupportContr";
    public final String KEY_CONVERSATION_ADD_TO_BACK_STACK = "key_conversation_add_to_back_stack";
    public final String KEY_CONVERSATION_BUNDLE = "key_conversation_bundle";
    public final String KEY_SUPPORT_CONTROLLER_STARTED_STATE = "key_support_controller_started";
    public final Bundle bundle;
    public final Context context;
    public boolean conversationAddToBackStack;
    public Bundle conversationBundle;
    public FragmentManager fragmentManager;
    public boolean isControllerStarted;
    public boolean searchPerformed = false;
    public String sourceSearchQuery;
    public int supportMode;
    public final SupportScreenView supportScreenView;

    /* renamed from: com.helpshift.support.controllers.SupportController$1 */
    public static /* synthetic */ class C26931 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$domainmodel$ConversationSetupDM$ConversationSetupState */
        public static final /* synthetic */ int[] f3350x25662d92;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState[] r0 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3350x25662d92 = r0
                r1 = 1
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState r2 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.NOT_STARTED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f3350x25662d92     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState r3 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f3350x25662d92     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState r2 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r2] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r1 = f3350x25662d92     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState r2 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.COMPLETED     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.controllers.SupportController.C26931.<clinit>():void");
        }
    }

    public SupportController(Context context2, SupportScreenView supportScreenView2, FragmentManager fragmentManager2, Bundle bundle2) {
        this.context = context2;
        this.supportScreenView = supportScreenView2;
        this.fragmentManager = fragmentManager2;
        this.bundle = bundle2;
    }

    private void clearConversationStack() {
        boolean z;
        List<Fragment> fragments = this.fragmentManager.getFragments();
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if ((fragment instanceof AttachmentPreviewFragment) || (fragment instanceof BaseConversationFragment) || (fragment instanceof ConversationSetupFragment) || (fragment instanceof AuthenticationFailureFragment)) {
                if (size == 0) {
                    FragmentUtil.removeFragment(this.fragmentManager, fragment);
                    List<Fragment> fragments2 = this.fragmentManager.getFragments();
                    if (fragments2 != null && fragments2.size() > 0) {
                        FragmentUtil.popBackStack(this.fragmentManager, fragment.getClass().getName());
                    }
                } else {
                    FragmentUtil.popBackStack(this.fragmentManager, fragment.getClass().getName());
                }
            }
        }
        Fragment findFragmentByTag = this.fragmentManager.findFragmentByTag(ConversationalFragment.FRAGMENT_TAG);
        if (findFragmentByTag != null) {
            FragmentUtil.popBackStackImmediate(this.fragmentManager, findFragmentByTag.getClass().getName());
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            this.conversationAddToBackStack = true;
        }
    }

    private boolean handleCustomContactUsFlows() {
        FaqFlowFragment faqFlowFragment;
        List<Flow> customContactUsFlows;
        if (HelpshiftContext.getCoreApi().getActiveConversation() != null || (faqFlowFragment = FragmentUtil.getFaqFlowFragment(this.fragmentManager)) == null || (customContactUsFlows = faqFlowFragment.getCustomContactUsFlows()) == null || customContactUsFlows.isEmpty()) {
            return false;
        }
        startDynamicForm(customContactUsFlows, true);
        return true;
    }

    private boolean isDuplicateFAQScreenAlreadyOpen(Bundle bundle2) {
        FaqFlowController faqFlowController;
        Fragment topMostFragment = FragmentUtil.getTopMostFragment(this.fragmentManager);
        if (!(topMostFragment instanceof FaqFlowFragment) || (faqFlowController = ((FaqFlowFragment) topMostFragment).getFaqFlowController()) == null) {
            return false;
        }
        Fragment topMostFaqFragment = faqFlowController.getTopMostFaqFragment();
        if (!(topMostFaqFragment instanceof SingleQuestionFragment)) {
            return true;
        }
        String string = bundle2.getString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_PUBLISH_ID);
        String questionPublishId = ((SingleQuestionFragment) topMostFaqFragment).getQuestionPublishId();
        if (string == null || !string.equals(questionPublishId)) {
            return false;
        }
        return true;
    }

    private void replaceConversationFlow(Bundle bundle2) {
        Long valueOf = Long.valueOf(bundle2.getLong(SupportNotification.BUNGLE_ARG_NOTIFICATION_CONVERSATION_ID));
        Bundle bundle3 = this.conversationBundle;
        boolean equals = valueOf.equals(bundle3 != null ? Long.valueOf(bundle3.getLong(ConversationalFragment.BUNDLE_ARG_CONVERSATION_LOCAL_ID)) : null);
        boolean z = true;
        boolean z2 = !equals;
        List<Fragment> fragments = this.fragmentManager.getFragments();
        if (z2) {
            clearConversationStack();
        } else if (fragments.size() > 0) {
            Fragment fragment = fragments.get(fragments.size() - 1);
            if (!(fragment instanceof AttachmentPreviewFragment)) {
                z = true ^ (fragment instanceof BaseConversationFragment);
            } else {
                return;
            }
        }
        if (z) {
            this.conversationBundle = bundle2;
            startConversationFlow();
        }
    }

    private void sendTicketAvoidedEvent() {
        SingleQuestionFragment singleQuestionFragment = FragmentUtil.getSingleQuestionFragment(this.fragmentManager);
        if (singleQuestionFragment != null) {
            String questionId = singleQuestionFragment.getQuestionId();
            if (!TextUtils.isEmpty(questionId)) {
                HashMap outline28 = GeneratedOutlineSupport.outline28("id", questionId);
                ConversationDetailDTO descriptionDetail = HelpshiftContext.getPlatform().getConversationInboxDAO().getDescriptionDetail(HelpshiftContext.getCoreApi().getUserManagerDM().getActiveUser().getLocalId().longValue());
                if (descriptionDetail != null) {
                    outline28.put(AnalyticsEventKey.STR, descriptionDetail.title);
                }
                HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.TICKET_AVOIDED, (Map<String, Object>) outline28);
            }
        }
    }

    private void showAuthenticationFailureFragment() {
        HSLogger.m3237d(TAG, "Starting authentication failure fragment");
        AuthenticationFailureFragment newInstance = AuthenticationFailureFragment.newInstance();
        String name = this.conversationAddToBackStack ? newInstance.getClass().getName() : null;
        clearConversationStack();
        FragmentUtil.startFragment(this.fragmentManager, C2466R.C2468id.flow_fragment_container, newInstance, AuthenticationFailureFragment.FRAGMENT_TAG, name, false, false);
    }

    private void showConversationFragment(boolean z, @Nullable Long l, Map<String, Boolean> map) {
        HSLogger.m3237d(TAG, "Starting conversation fragment: " + l);
        if (!z) {
            if (l != null) {
                this.conversationBundle.putLong(ConversationalFragment.BUNDLE_ARG_CONVERSATION_LOCAL_ID, l.longValue());
            } else {
                return;
            }
        }
        this.conversationBundle.putBoolean(ConversationalFragment.BUNDLE_ARG_SHOW_CONVERSATION_HISTORY, z);
        for (String next : map.keySet()) {
            this.conversationBundle.putBoolean(next, map.get(next).booleanValue());
        }
        ConversationalFragment newInstance = ConversationalFragment.newInstance(this.conversationBundle);
        String str = null;
        if (this.conversationAddToBackStack) {
            str = newInstance.getClass().getName();
            clearConversationStack();
        }
        FragmentUtil.startFragment(this.fragmentManager, C2466R.C2468id.flow_fragment_container, newInstance, ConversationalFragment.FRAGMENT_TAG, str, false, false);
    }

    private void showNewConversationFragment() {
        String str;
        HSLogger.m3237d(TAG, "Starting new conversation fragment");
        this.conversationBundle.putBoolean(NewConversationFragment.SEARCH_PERFORMED, this.searchPerformed);
        this.conversationBundle.putString(NewConversationFragment.SOURCE_SEARCH_QUERY, this.sourceSearchQuery);
        NewConversationFragment newInstance = NewConversationFragment.newInstance(this.conversationBundle);
        if (this.conversationAddToBackStack) {
            str = newInstance.getClass().getName();
            clearConversationStack();
        } else {
            str = null;
        }
        FragmentUtil.startFragment(this.fragmentManager, C2466R.C2468id.flow_fragment_container, newInstance, NewConversationFragment.FRAGMENT_TAG, str, false, false);
    }

    private void startConversationFlowInternal(Map<String, Boolean> map) {
        String name;
        Conversation activeConversationOrPreIssue;
        if (this.conversationBundle == null) {
            this.conversationBundle = this.bundle;
        }
        boolean z = HelpshiftContext.getCoreApi().getSDKConfigurationDM().getBoolean(SDKConfigurationDM.DISABLE_IN_APP_CONVERSATION);
        Long l = null;
        if (!HelpshiftContext.getCoreApi().getSDKConfigurationDM().shouldShowConversationHistory() || z) {
            long j = this.conversationBundle.getLong(SupportNotification.BUNGLE_ARG_NOTIFICATION_CONVERSATION_ID, 0);
            if (j != 0) {
                this.conversationBundle.remove(SupportNotification.BUNGLE_ARG_NOTIFICATION_CONVERSATION_ID);
                if (HelpshiftContext.getCoreApi().getConversationController().shouldOpenConversationFromNotification(j)) {
                    showConversationFragment(false, Long.valueOf(j), map);
                    return;
                }
            }
            if (!z && (activeConversationOrPreIssue = HelpshiftContext.getCoreApi().getActiveConversationOrPreIssue()) != null) {
                l = activeConversationOrPreIssue.localId;
            }
            if (l == null) {
                List<Flow> flowList = CustomContactUsFlowListHolder.getFlowList();
                if (flowList == null || flowList.isEmpty()) {
                    showNewConversationFragment();
                    return;
                }
                FragmentManager.BackStackEntry backStackEntryAt = getFragmentManager().getBackStackEntryAt(this.fragmentManager.getBackStackEntryCount() - 1);
                if (!(backStackEntryAt == null || (name = backStackEntryAt.getName()) == null || !name.equals(ConversationalFragment.class.getName()))) {
                    FragmentUtil.popBackStackImmediate(this.fragmentManager, name);
                }
                startDynamicForm(flowList, true);
                return;
            }
            showConversationFragment(false, l, map);
            return;
        }
        showConversationFragment(true, (Long) null, map);
    }

    public void actionDone() {
        sendTicketAvoidedEvent();
        Long localId = HelpshiftContext.getCoreApi().getUserManagerDM().getActiveUser().getLocalId();
        HelpshiftContext.getPlatform().getConversationInboxDAO().saveDescriptionDetail(localId.longValue(), new ConversationDetailDTO("", System.nanoTime(), 0));
        HelpshiftContext.getPlatform().getConversationInboxDAO().saveImageAttachment(localId.longValue(), (AttachmentPickerFile) null);
        if (getSupportMode() == 1) {
            this.supportScreenView.exitSdkSession();
        } else {
            FragmentUtil.popBackStackImmediate(getFragmentManager(), NewConversationFragment.class.getName());
        }
    }

    public void addAttachment(AttachmentPickerFile attachmentPickerFile) {
        FragmentUtil.popBackStack(this.fragmentManager, AttachmentPreviewFragment.class.getName());
        NewConversationFragment newConversationFragment = (NewConversationFragment) this.fragmentManager.findFragmentByTag(NewConversationFragment.FRAGMENT_TAG);
        if (newConversationFragment != null) {
            newConversationFragment.handleScreenshotAction(AttachmentPreviewFragment.AttachmentAction.ADD, attachmentPickerFile);
        }
    }

    public void changeAttachment(Bundle bundle2) {
        this.supportScreenView.launchAttachmentPicker(bundle2);
        NewConversationFragment newConversationFragment = (NewConversationFragment) this.fragmentManager.findFragmentByTag(NewConversationFragment.FRAGMENT_TAG);
        if (newConversationFragment != null) {
            newConversationFragment.handleScreenshotAction(AttachmentPreviewFragment.AttachmentAction.REMOVE, (AttachmentPickerFile) null);
        }
    }

    public FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public int getSupportMode() {
        return this.supportMode;
    }

    public void onAdminSuggestedQuestionSelected(String str, String str2, String str3, SingleQuestionFragment.QuestionReadListener questionReadListener) {
        boolean isTablet = Styles.isTablet(this.context);
        this.bundle.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_PUBLISH_ID, str);
        this.bundle.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_LANGUAGE, str2);
        this.bundle.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_SOURCE, str3);
        Bundle bundle2 = new Bundle(this.bundle);
        bundle2.putBoolean(SupportFragmentConstants.DECOMPOSED, true);
        FragmentUtil.startFragmentWithBackStack(this.fragmentManager, C2466R.C2468id.flow_fragment_container, SingleQuestionFragment.newInstance(bundle2, 3, isTablet, questionReadListener), (String) null, false);
    }

    public void onAuthenticationFailure() {
        showAuthenticationFailureFragment();
    }

    public void onContactUsClicked(String str) {
        if (!handleCustomContactUsFlows()) {
            if (!TextUtils.isEmpty(str)) {
                this.sourceSearchQuery = str;
            }
            startConversationFlow(this.bundle, true);
        }
    }

    public void onConversationSetupCompleted() {
        startConversationFlowInternal(new HashMap());
    }

    public void onFragmentManagerUpdate(FragmentManager fragmentManager2) {
        this.fragmentManager = fragmentManager2;
    }

    public void onNewIntent(Bundle bundle2) {
        int i = bundle2.getInt(SupportFragment.SUPPORT_MODE);
        if (i == 1) {
            replaceConversationFlow(bundle2);
        } else if (i != 4) {
            startFaqFlow(bundle2, true, CustomContactUsFlowListHolder.getFlowList());
        } else {
            startDynamicForm(bundle2.getString(SupportFragmentConstants.FLOW_TITLE), DynamicFormFlowListHolder.getFlowList(), true);
        }
    }

    public void onQuestionSelected(String str, ArrayList<String> arrayList) {
        boolean isTablet = Styles.isTablet(this.context);
        this.bundle.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_PUBLISH_ID, str);
        if (arrayList != null) {
            this.bundle.putStringArrayList("searchTerms", arrayList);
        }
        FragmentUtil.startFragmentWithBackStack(this.fragmentManager, C2466R.C2468id.flow_fragment_container, SingleQuestionFragment.newInstance(this.bundle, 2, isTablet, (SingleQuestionFragment.QuestionReadListener) null), (String) null, false);
    }

    public void onSaveInstanceState(Bundle bundle2) {
        bundle2.putBoolean("key_support_controller_started", this.isControllerStarted);
        bundle2.putBundle("key_conversation_bundle", this.conversationBundle);
        bundle2.putBoolean("key_conversation_add_to_back_stack", this.conversationAddToBackStack);
    }

    public void onViewStateRestored(Bundle bundle2) {
        if (!this.isControllerStarted) {
            if (bundle2.containsKey("key_support_controller_started")) {
                this.isControllerStarted = bundle2.containsKey("key_support_controller_started");
                this.supportMode = this.bundle.getInt(SupportFragment.SUPPORT_MODE, 0);
                FragmentManager fragmentManager2 = this.fragmentManager;
                if (fragmentManager2 != null) {
                    AttachmentPreviewFragment attachmentPreviewFragment = (AttachmentPreviewFragment) fragmentManager2.findFragmentByTag(AttachmentPreviewFragment.FRAGMENT_TAG);
                    if (attachmentPreviewFragment != null) {
                        attachmentPreviewFragment.setAttachmentPreviewListener(this);
                    }
                    SearchResultFragment searchResultFragment = (SearchResultFragment) this.fragmentManager.findFragmentByTag(SearchResultFragment.FRAGMENT_TAG);
                    if (searchResultFragment != null) {
                        searchResultFragment.setSearchResultListener(this);
                    }
                    DynamicFormFragment dynamicFormFragment = (DynamicFormFragment) this.fragmentManager.findFragmentByTag(DynamicFormFragment.FRAGMENT_TAG);
                    if (dynamicFormFragment != null) {
                        dynamicFormFragment.setSupportController(this);
                    }
                }
            }
            if (bundle2.containsKey("key_conversation_bundle") && bundle2.containsKey("key_conversation_add_to_back_stack")) {
                this.conversationBundle = bundle2.getBundle("key_conversation_bundle");
                this.conversationAddToBackStack = bundle2.getBoolean("key_conversation_add_to_back_stack");
            }
        }
    }

    public void removeAttachment() {
        FragmentUtil.popBackStack(this.fragmentManager, AttachmentPreviewFragment.class.getName());
        NewConversationFragment newConversationFragment = (NewConversationFragment) this.fragmentManager.findFragmentByTag(NewConversationFragment.FRAGMENT_TAG);
        if (newConversationFragment != null) {
            newConversationFragment.handleScreenshotAction(AttachmentPreviewFragment.AttachmentAction.REMOVE, (AttachmentPickerFile) null);
        }
    }

    public void removeAttachmentPreviewFragment() {
        FragmentUtil.popBackStack(this.fragmentManager, AttachmentPreviewFragment.class.getName());
    }

    public void sendAnyway() {
        HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.TICKET_AVOIDANCE_FAILED);
        FragmentUtil.popBackStackImmediate(getFragmentManager(), SearchResultFragment.class.getName());
        NewConversationFragment newConversationFragment = (NewConversationFragment) this.fragmentManager.findFragmentByTag(NewConversationFragment.FRAGMENT_TAG);
        if (newConversationFragment != null) {
            newConversationFragment.startNewConversation();
        }
    }

    public void sendAttachment(AttachmentPickerFile attachmentPickerFile, @Nullable String str) {
        FragmentUtil.popBackStack(this.fragmentManager, AttachmentPreviewFragment.class.getName());
        ConversationalFragment conversationalFragment = (ConversationalFragment) this.fragmentManager.findFragmentByTag(ConversationalFragment.FRAGMENT_TAG);
        if (conversationalFragment != null) {
            conversationalFragment.handleAttachmentAction(AttachmentPreviewFragment.AttachmentAction.SEND, attachmentPickerFile, str);
        }
    }

    public void setSearchPerformed(boolean z) {
        this.searchPerformed = z;
    }

    public void showConversationSearchResultFragment(Bundle bundle2) {
        FragmentUtil.startFragmentWithBackStack(this.fragmentManager, C2466R.C2468id.flow_fragment_container, SearchResultFragment.newInstance(bundle2, this), SearchResultFragment.FRAGMENT_TAG, false);
    }

    public void showConversationSetupFragment() {
        String str;
        HSLogger.m3237d(TAG, "Starting conversation setup fragment.");
        ConversationSetupFragment newInstance = ConversationSetupFragment.newInstance();
        if (this.conversationAddToBackStack) {
            str = newInstance.getClass().getName();
            clearConversationStack();
        } else {
            str = null;
        }
        FragmentUtil.startFragment(this.fragmentManager, C2466R.C2468id.flow_fragment_container, newInstance, ConversationSetupFragment.FRAGMENT_TAG, str, false, false);
    }

    public void start() {
        if (!this.isControllerStarted) {
            int i = this.bundle.getInt(SupportFragment.SUPPORT_MODE, 0);
            this.supportMode = i;
            if (i == 1) {
                startConversationFlow(this.bundle, false);
            } else if (i != 4) {
                startFaqFlow(this.bundle, false, CustomContactUsFlowListHolder.getFlowList());
            } else {
                startDynamicForm(DynamicFormFlowListHolder.getFlowList(), false);
            }
        }
        this.isControllerStarted = true;
    }

    public void startConversationFlow(Bundle bundle2, boolean z) {
        this.conversationAddToBackStack = z;
        this.conversationBundle = bundle2;
        startConversationFlow();
    }

    public void startDynamicForm(List<Flow> list, boolean z) {
        FragmentUtil.startFragment(this.fragmentManager, C2466R.C2468id.flow_fragment_container, DynamicFormFragment.newInstance(this.bundle, list, this), DynamicFormFragment.FRAGMENT_TAG, z ? DynamicFormFragment.class.getName() : null, false, false);
    }

    public void startFaqFlow(Bundle bundle2, boolean z, List<Flow> list) {
        if (!isDuplicateFAQScreenAlreadyOpen(bundle2)) {
            FaqFlowFragment newInstance = FaqFlowFragment.newInstance(bundle2, list);
            String str = null;
            if (z) {
                str = FaqFlowFragment.class.getName();
            }
            FragmentUtil.startFragment(this.fragmentManager, C2466R.C2468id.flow_fragment_container, newInstance, FaqFlowFragment.FRAGMENT_TAG, str, false, false);
        }
    }

    public void startScreenshotPreviewFragment(AttachmentPickerFile attachmentPickerFile, Bundle bundle2, AttachmentPreviewFragment.LaunchSource launchSource) {
        AttachmentPreviewFragment screenshotPreviewFragment = FragmentUtil.getScreenshotPreviewFragment(getFragmentManager());
        if (screenshotPreviewFragment == null) {
            screenshotPreviewFragment = AttachmentPreviewFragment.newInstance(this);
            FragmentUtil.startFragmentWithBackStack(getFragmentManager(), C2466R.C2468id.flow_fragment_container, screenshotPreviewFragment, AttachmentPreviewFragment.FRAGMENT_TAG, false);
        }
        screenshotPreviewFragment.setParams(bundle2, attachmentPickerFile, launchSource);
    }

    public void startConversationFlow() {
        startConversationFlow(new HashMap());
    }

    public void startDynamicForm(String str, List<Flow> list, boolean z) {
        Bundle bundle2 = this.bundle;
        if (bundle2 != null) {
            bundle2.putString(SupportFragmentConstants.FLOW_TITLE, str);
        }
        startDynamicForm(list, z);
    }

    public void startConversationFlow(Map<String, Boolean> map) {
        CoreApi coreApi = HelpshiftContext.getCoreApi();
        int ordinal = new ConversationSetupDM(HelpshiftContext.getPlatform(), coreApi.getConfigFetchDM(), coreApi.getUserManagerDM().getActiveUserSetupDM()).getState().ordinal();
        if (!(ordinal == 0 || ordinal == 1)) {
            if (ordinal == 2) {
                startConversationFlowInternal(map);
                return;
            } else if (ordinal != 3) {
                return;
            }
        }
        showConversationSetupFragment();
    }

    public void startDynamicForm(int i, List<Flow> list, boolean z) {
        Bundle bundle2 = this.bundle;
        if (!(bundle2 == null || i == 0)) {
            bundle2.putString(SupportFragmentConstants.FLOW_TITLE, this.context.getResources().getString(i));
        }
        startDynamicForm(list, z);
    }
}
