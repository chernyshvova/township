package com.helpshift.conversation.viewmodel;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.AuthenticationFailureDM;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.PlatformException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.ConversationalRenderer;
import com.helpshift.conversation.activeconversation.UIConversation;
import com.helpshift.conversation.activeconversation.ViewableConversation;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithTextInputDM;
import com.helpshift.conversation.activeconversation.message.AdminResolutionMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.AvatarImageDownloader;
import com.helpshift.conversation.activeconversation.message.ConversationFooterState;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.HistoryLoadingState;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.MessageType;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemRedactedConversationMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageState;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.conversation.activeconversation.message.input.TextInput;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.smartintent.BaseSmartIntentViewState;
import com.helpshift.conversation.smartintent.LeafIntentUIModel;
import com.helpshift.conversation.smartintent.RootIntentUIModel;
import com.helpshift.conversation.smartintent.SearchIntentUIModel;
import com.helpshift.conversation.smartintent.SmartIntentCollapsedRootViewState;
import com.helpshift.conversation.smartintent.SmartIntentDM;
import com.helpshift.conversation.smartintent.SmartIntentSavedState;
import com.helpshift.util.AttachmentConstants;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HSObservableList;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.widget.BaseViewState;
import com.helpshift.widget.ConversationFooterViewState;
import com.helpshift.widget.HistoryLoadingViewState;
import com.helpshift.widget.MutableBaseViewState;
import com.helpshift.widget.MutableConversationFooterViewState;
import com.helpshift.widget.MutableHistoryLoadingViewState;
import com.helpshift.widget.MutableReplyBoxViewState;
import com.helpshift.widget.MutableReplyFieldViewState;
import com.helpshift.widget.MutableScrollJumperViewState;
import com.helpshift.widget.ReplyBoxViewState;
import com.helpshift.widget.ReplyFieldViewState;
import com.helpshift.widget.ScrollJumperViewState;
import com.helpshift.widget.WidgetGateway;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConversationalVM implements ConversationController.StartNewConversationListener, ListPickerVMCallback, ConversationVMCallback, MessageListVMCallback, AuthenticationFailureDM.AuthenticationFailureObserver, SmartIntentVMCallback {
    public static final String CREATE_NEW_PRE_ISSUE = "create_new_pre_issue";
    public static final int NO_NETWORK_ERROR = 1;
    public static final int POLL_FAILURE_ERROR = 2;
    public static final String TAG = "Helpshift_ConvsatnlVM";
    public MutableBaseViewState attachImageButtonViewState;
    public boolean awaitingUserInputForBotStep;
    public MessageDM botMessageDM;
    public MutableBaseViewState confirmationBoxViewState;
    public final ConversationController conversationController;
    public MutableConversationFooterViewState conversationFooterViewState;
    public ConversationManager conversationManager;
    public Domain domain;
    public MutableHistoryLoadingViewState historyLoadingViewState;
    public boolean isConversationRejected;
    public boolean isInBetweenBotExecution;
    public boolean isNetworkAvailable = true;
    public boolean isScreenCurrentlyVisible;
    public boolean isShowingPollFailureError;
    public boolean isUserReplyDraftClearedForBotChange;
    public String lastCSATRequestedEventId = "";
    public String lastCSATStartRatingEventId = "";
    public ListPickerVM listPickerVM;
    public MessageListVM messageListVM;
    public Map<MessageDM, Boolean> messageToAvatarTriggeredMap = new HashMap();
    public Platform platform;
    public ConversationalRenderer renderer;
    public MutableReplyBoxViewState replyBoxViewState;
    public MutableBaseViewState replyButtonViewState;
    public MutableReplyFieldViewState replyFieldViewState;
    public boolean retainMessageBoxOnUI;
    public MutableScrollJumperViewState scrollJumperViewState;
    public final SDKConfigurationDM sdkConfigurationDM;
    public boolean showConversationHistory;
    public SmartIntentDM smartIntentDM;
    public SmartIntentVM smartIntentVM;
    public final ViewableConversation viewableConversation;
    public WidgetGateway widgetGateway;

    /* renamed from: com.helpshift.conversation.viewmodel.ConversationalVM$33 */
    public static /* synthetic */ class C260233 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$conversation$dto$IssueState;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.helpshift.conversation.dto.IssueState[] r0 = com.helpshift.conversation.dto.IssueState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$conversation$dto$IssueState = r0
                com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.RESOLUTION_ACCEPTED     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 8
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x0018 }
                com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.REJECTED     // Catch:{ NoSuchFieldError -> 0x0018 }
                r1 = 5
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.viewmodel.ConversationalVM.C260233.<clinit>():void");
        }
    }

    public ConversationalVM(Platform platform2, Domain domain2, ConversationController conversationController2, ViewableConversation viewableConversation2, ConversationalRenderer conversationalRenderer, boolean z, boolean z2) {
        this.domain = domain2;
        this.platform = platform2;
        this.conversationController = conversationController2;
        this.viewableConversation = viewableConversation2;
        this.sdkConfigurationDM = domain2.getSDKConfigurationDM();
        this.retainMessageBoxOnUI = z2;
        this.conversationManager = conversationController2.conversationManager;
        domain2.getAuthenticationFailureDM().registerListener(this);
        this.widgetGateway = new WidgetGateway(this.sdkConfigurationDM, conversationController2);
        Conversation activeConversation = viewableConversation2.getActiveConversation();
        this.conversationManager.updateConversationExpiryProperties(activeConversation);
        UserDM activeUser = domain2.getUserManagerDM().getActiveUser();
        SmartIntentDM smartIntentDM2 = domain2.getSmartIntentDM();
        this.smartIntentDM = smartIntentDM2;
        this.smartIntentVM = new SmartIntentVM(platform2, domain2, smartIntentDM2, activeUser, activeConversation, this);
        this.replyFieldViewState = this.widgetGateway.makeReplyFieldViewState();
        this.historyLoadingViewState = new MutableHistoryLoadingViewState();
        this.scrollJumperViewState = this.widgetGateway.makeScrollJumperViewState();
        boolean shouldShowReplyBoxOnConversationRejected = shouldShowReplyBoxOnConversationRejected();
        this.conversationManager.setEnableMessageClickOnResolutionRejected(activeConversation, shouldShowReplyBoxOnConversationRejected);
        this.conversationFooterViewState = this.widgetGateway.makeConversationFooterViewState(activeConversation, shouldShowReplyBoxOnConversationRejected);
        this.attachImageButtonViewState = this.widgetGateway.makeAttachImageButtonViewState(viewableConversation2.getActiveConversation());
        this.replyButtonViewState = new MutableBaseViewState();
        this.replyBoxViewState = this.widgetGateway.makeReplyBoxViewState(activeConversation, shouldShowReplyBoxOnConversationRejected);
        this.confirmationBoxViewState = this.widgetGateway.makeConfirmationBoxViewState(activeConversation);
        conversationController2.setConversationViewState(this.replyBoxViewState.isVisible() ? 2 : -1);
        if (!shouldShowReplyBoxOnConversationRejected && activeConversation.state == IssueState.RESOLUTION_REJECTED) {
            this.conversationManager.handleConversationEnded(activeConversation);
        }
        retryFallbackAvatarImageDownload();
        viewableConversation2.setConversationVMCallback(this);
        this.renderer = conversationalRenderer;
        this.conversationManager.removeFeedbackMessagesFromConversations(viewableConversation2);
        initMessagesList();
        this.showConversationHistory = z;
    }

    private void addPreIssueFirstUserMessage(Conversation conversation, String str, List<String> list) {
        clearUserReplyDraft();
        disableUserInputOptions();
        if (ListUtils.isNotEmpty(list)) {
            this.conversationManager.addPreissueFirstUserMessageViaSmartIntent(conversation, list);
        } else {
            this.conversationManager.addPreissueFirstUserMessage(conversation, str);
        }
    }

    private void clearNotifications() {
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        this.conversationController.clearNotification(activeConversation);
        this.conversationController.resetPushNotificationCount(activeConversation);
    }

    private OptionInputMessageDM createOptionsBotMessage(FAQListMessageWithOptionInputDM fAQListMessageWithOptionInputDM) {
        if (fAQListMessageWithOptionInputDM == null) {
            return null;
        }
        OptionInputMessageDM optionInputMessageDM = new OptionInputMessageDM(fAQListMessageWithOptionInputDM);
        optionInputMessageDM.setDependencies(this.domain, this.platform);
        return optionInputMessageDM;
    }

    private void createPreIssue(Conversation conversation, String str, List<String> list) {
        updateLastUserActivityTime();
        String string = this.sdkConfigurationDM.getString(SDKConfigurationDM.CONVERSATION_GREETING_MESSAGE);
        if (!this.isNetworkAvailable) {
            onCreateConversationFailure(new Exception("No internet connection."));
        } else if (ListUtils.isEmpty(list)) {
            this.conversationController.createPreIssueViaConversationalFlow(conversation, string, str, this);
        } else {
            this.conversationController.createPreIssueViaSmartIntent(conversation, string, str, list, this);
        }
    }

    private void createPreIssueViaSmartIntent(String str, List<String> list, List<String> list2, String str2) {
        HSLogger.m3237d(TAG, "Trigger preissue creation via Smart intent");
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        this.conversationManager.updateSmartIntentData(activeConversation, str, list, str2);
        addPreIssueFirstUserMessage(activeConversation, str2, list2);
        createPreIssue(activeConversation, str2, list2);
    }

    private void disableUserInputOptions() {
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            conversationalRenderer.hideKeyboard();
        }
        this.attachImageButtonViewState.setVisible(false);
        disableUserTextInput();
    }

    private void disableUserTextInput() {
        this.replyBoxViewState.setVisible(false);
    }

    private List<MessageDM> evaluateBotMessages(Collection<? extends MessageDM> collection) {
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        boolean z = this.isInBetweenBotExecution;
        List<MessageDM> processMessagesForBots = processMessagesForBots(collection, z);
        if (!activeConversation.isInPreIssueMode()) {
            if (z && !this.isInBetweenBotExecution) {
                ConversationManager conversationManager2 = this.conversationManager;
                conversationManager2.updateMessagesClickOnBotSwitch(activeConversation, conversationManager2.shouldEnableMessagesClick(activeConversation));
                removeOptionsMessageFromUI();
                removeCSATBotFromUI(activeConversation);
                if (activeConversation.isIssueInProgress()) {
                    this.replyBoxViewState.setStandardTextInput();
                    this.domain.runOnUI(new C2500F() {
                        /* renamed from: f */
                        public void mo33949f() {
                            ConversationalVM.this.resetDefaultMenuItemsVisibility();
                            ConversationalRenderer conversationalRenderer = ConversationalVM.this.renderer;
                            if (conversationalRenderer != null) {
                                conversationalRenderer.hideReplyValidationFailedError();
                            }
                        }
                    });
                }
            } else if (this.isInBetweenBotExecution && !z) {
                this.conversationManager.updateMessagesClickOnBotSwitch(activeConversation, false);
            }
        }
        updateUserInputState();
        return processMessagesForBots;
    }

    private SystemRedactedConversationMessageDM generateSystemRedactedConversationMessageDM(Conversation conversation) {
        SystemRedactedConversationMessageDM systemRedactedConversationMessageDM = new SystemRedactedConversationMessageDM(conversation.getCreatedAt(), conversation.getEpochCreatedAtTime(), 1);
        systemRedactedConversationMessageDM.setDependencies(this.domain, this.platform);
        systemRedactedConversationMessageDM.conversationLocalId = conversation.localId;
        return systemRedactedConversationMessageDM;
    }

    private List<MessageDM> getUIMessages(Conversation conversation) {
        ArrayList arrayList = new ArrayList();
        if (conversation.isRedacted) {
            arrayList.add(generateSystemRedactedConversationMessageDM(conversation));
        } else {
            arrayList.addAll(buildUIMessages(conversation));
        }
        return arrayList;
    }

    private List<MessageDM> getUIMessagesForHistory(Conversation conversation) {
        ArrayList arrayList = new ArrayList();
        if (conversation.isRedacted) {
            arrayList.add(generateSystemRedactedConversationMessageDM(conversation));
        } else {
            arrayList.addAll(conversation.messageDMs);
        }
        return arrayList;
    }

    private void hideListPicker(final boolean z) {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalRenderer conversationalRenderer = ConversationalVM.this.renderer;
                if (conversationalRenderer != null) {
                    conversationalRenderer.hideListPicker(z);
                }
            }
        });
    }

    private void incrementCreatedAt(MessageDM messageDM, MessageDM messageDM2, long j) {
        String format = HSDateFormatSpec.STORAGE_TIME_FORMAT.format(new Date(messageDM2.getEpochCreatedAtTime() + j));
        long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(format);
        messageDM.setCreatedAt(format);
        messageDM.setEpochCreatedAtTime(convertToEpochTime);
    }

    private void loadHistoryMessagesInternal() {
        if (this.historyLoadingViewState.getState() != HistoryLoadingState.LOADING) {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    ConversationalVM.this.viewableConversation.loadMoreMessages();
                }
            });
        }
    }

    private void markMessagesAsSeenOnEntry() {
        final Conversation activeConversation = this.viewableConversation.getActiveConversation();
        if (this.conversationManager.isSynced(activeConversation)) {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    Conversation conversation = activeConversation;
                    if (conversation != null) {
                        ConversationalVM.this.conversationManager.markMessagesAsSeen(conversation);
                    }
                }
            });
        }
    }

    private void markMessagesAsSeenOnExit() {
        final ArrayList arrayList = new ArrayList(this.viewableConversation.getAllConversations());
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        if (!this.conversationManager.isSynced(activeConversation)) {
            arrayList.remove(activeConversation);
        }
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                for (Conversation markMessagesAsSeen : arrayList) {
                    ConversationalVM.this.conversationManager.markMessagesAsSeen(markMessagesAsSeen);
                }
            }
        });
    }

    private void notifyRendererForScrollToBottom() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalRenderer conversationalRenderer = ConversationalVM.this.renderer;
                if (conversationalRenderer != null) {
                    conversationalRenderer.scrollToBottom();
                }
            }
        });
    }

    private List<MessageDM> processMessagesForBots(Collection<? extends MessageDM> collection, boolean z) {
        MessageType messageType;
        OptionInputMessageDM optionInputMessageDM;
        ArrayList arrayList = new ArrayList(collection);
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        boolean evaluateBotExecutionState = this.conversationManager.evaluateBotExecutionState(arrayList, z);
        this.isInBetweenBotExecution = evaluateBotExecutionState;
        if (evaluateBotExecutionState) {
            MessageDM latestUnansweredBotMessage = this.conversationManager.getLatestUnansweredBotMessage(activeConversation);
            MessageDM messageDM = this.botMessageDM;
            if (messageDM == null || latestUnansweredBotMessage == null || !messageDM.serverId.equals(latestUnansweredBotMessage.serverId)) {
                if (latestUnansweredBotMessage == null || !((messageType = latestUnansweredBotMessage.messageType) == MessageType.ADMIN_TEXT_WITH_OPTION_INPUT || messageType == MessageType.FAQ_LIST_WITH_OPTION_INPUT || messageType == MessageType.ADMIN_RESOLUTION_QUESTION_MESSAGE)) {
                    this.botMessageDM = latestUnansweredBotMessage;
                } else {
                    int indexOf = arrayList.indexOf(latestUnansweredBotMessage);
                    if (indexOf != -1) {
                        MessageType messageType2 = latestUnansweredBotMessage.messageType;
                        if (messageType2 == MessageType.ADMIN_TEXT_WITH_OPTION_INPUT) {
                            AdminMessageWithOptionInputDM adminMessageWithOptionInputDM = (AdminMessageWithOptionInputDM) latestUnansweredBotMessage;
                            optionInputMessageDM = createOptionsBotMessage(adminMessageWithOptionInputDM);
                            incrementCreatedAt(optionInputMessageDM, latestUnansweredBotMessage, (long) (adminMessageWithOptionInputDM.attachmentCount + 1));
                        } else if (messageType2 == MessageType.ADMIN_RESOLUTION_QUESTION_MESSAGE) {
                            AdminResolutionMessageWithOptions adminResolutionMessageWithOptions = (AdminResolutionMessageWithOptions) latestUnansweredBotMessage;
                            optionInputMessageDM = createOptionsBotMessage(adminResolutionMessageWithOptions);
                            incrementCreatedAt(optionInputMessageDM, latestUnansweredBotMessage, (long) (adminResolutionMessageWithOptions.attachmentCount + 1));
                        } else {
                            optionInputMessageDM = createOptionsBotMessage((FAQListMessageWithOptionInputDM) latestUnansweredBotMessage);
                            incrementCreatedAt(optionInputMessageDM, latestUnansweredBotMessage, 1);
                        }
                        if (optionInputMessageDM.input.type == OptionInput.Type.PILL) {
                            arrayList.add(indexOf + 1, optionInputMessageDM);
                        }
                        this.botMessageDM = optionInputMessageDM;
                    }
                }
                if (latestUnansweredBotMessage != null) {
                    removeOptionsMessageFromUI();
                    this.awaitingUserInputForBotStep = true;
                } else {
                    this.awaitingUserInputForBotStep = false;
                }
            } else {
                this.awaitingUserInputForBotStep = true;
                return arrayList;
            }
        } else {
            this.awaitingUserInputForBotStep = false;
        }
        return arrayList;
    }

    private void pushAnalyticsEvent(AnalyticsEventType analyticsEventType, Map<String, Object> map) {
        this.domain.getAnalyticsEventDM().pushEvent(analyticsEventType, map);
    }

    private void removeCSATBotFromUI(Conversation conversation) {
        MessageListVM messageListVM2 = this.messageListVM;
        if (messageListVM2 != null && conversation.isFeedbackBotEnabled) {
            List<MessageDM> copyOfUIMessageDMs = messageListVM2.copyOfUIMessageDMs();
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(copyOfUIMessageDMs)) {
                for (MessageDM next : copyOfUIMessageDMs) {
                    if (next.messageType == MessageType.ADMIN_CSAT_MESSAGE) {
                        arrayList.add(next);
                    }
                }
                this.messageListVM.remove(arrayList);
            }
        }
    }

    private void removeOptionsMessageFromUI() {
        MessageListVM messageListVM2 = this.messageListVM;
        if (messageListVM2 != null) {
            List<MessageDM> copyOfUIMessageDMs = messageListVM2.copyOfUIMessageDMs();
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(copyOfUIMessageDMs)) {
                for (MessageDM next : copyOfUIMessageDMs) {
                    if (next.messageType == MessageType.OPTION_INPUT) {
                        arrayList.add(next);
                    }
                }
                this.messageListVM.remove(arrayList);
            }
            hideListPicker(false);
        }
    }

    private void resetIncrementMessageCountFlag() {
        this.conversationManager.setShouldIncrementMessageCount(this.viewableConversation.getActiveConversation(), false, true);
    }

    private void retryFallbackAvatarImageDownload() {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM conversationalVM = ConversationalVM.this;
                AvatarImageDownloader.retryFallbackImagesDownload(conversationalVM.platform, conversationalVM.domain);
            }
        });
    }

    private void sendCSATEvent(AnalyticsEventType analyticsEventType) {
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        HashMap hashMap = new HashMap();
        if (activeConversation != null && StringUtils.isNotEmpty(activeConversation.acid)) {
            hashMap.put("acid", activeConversation.acid);
        }
        this.domain.getAnalyticsEventDM().pushEvent(analyticsEventType, (Map<String, Object>) hashMap);
    }

    private void sendNormalTextMessage(final String str) {
        clearReply();
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM conversationalVM = ConversationalVM.this;
                conversationalVM.conversationManager.sendTextMessage(conversationalVM.viewableConversation.getActiveConversation(), str);
            }
        });
    }

    private void setScreenVisibility(boolean z) {
        this.isScreenCurrentlyVisible = z;
    }

    private void setUserCanReadMessages(boolean z) {
        this.conversationController.setUserCanReadMessages(z);
        onAgentTypingUpdate(this.viewableConversation.isAgentTyping());
    }

    private boolean shouldShowReplyBoxOnConversationRejected() {
        return !StringUtils.isEmpty(this.conversationController.getUserReplyText()) || this.conversationController.shouldPersistMessageBox() || this.retainMessageBoxOnUI;
    }

    private void showConfirmationBox() {
        this.replyBoxViewState.setVisible(false);
        updateAttachmentButtonViewState();
        this.confirmationBoxViewState.setVisible(true);
        this.conversationFooterViewState.setState(ConversationFooterState.NONE);
    }

    /* access modifiers changed from: private */
    public void showErrorForNoNetwork(RootAPIException rootAPIException) {
        if ((rootAPIException.exceptionType instanceof NetworkException) && !this.platform.isOnline()) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    ConversationalRenderer conversationalRenderer = ConversationalVM.this.renderer;
                    if (conversationalRenderer != null) {
                        conversationalRenderer.showNetworkErrorFooter(1);
                    }
                }
            });
        }
    }

    private void showListPicker(final OptionInputMessageDM optionInputMessageDM) {
        this.listPickerVM = new ListPickerVM(this.domain, optionInputMessageDM, this);
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM conversationalVM = ConversationalVM.this;
                ConversationalRenderer conversationalRenderer = conversationalVM.renderer;
                List<OptionUIModel> allOptions = conversationalVM.listPickerVM.getAllOptions();
                OptionInput optionInput = optionInputMessageDM.input;
                conversationalRenderer.showListPicker(allOptions, optionInput.inputLabel, optionInput.required, optionInput.skipLabel);
            }
        });
    }

    private void showMessageBox() {
        this.replyBoxViewState.setVisible(true);
        updateAttachmentButtonViewState();
        this.confirmationBoxViewState.setVisible(false);
        this.conversationFooterViewState.setState(ConversationFooterState.NONE);
    }

    /* access modifiers changed from: private */
    public void showOptions(OptionInputMessageDM optionInputMessageDM) {
        OptionInput optionInput = optionInputMessageDM.input;
        if (optionInput.type == OptionInput.Type.PILL) {
            this.renderer.showOptionInput(optionInput);
        } else {
            showListPicker(optionInputMessageDM);
        }
    }

    private void showUnreadMessagesIndicator() {
        this.scrollJumperViewState.setShouldShowUnreadMessagesIndicator(true);
    }

    private void updateAttachmentButtonViewState() {
        resetDefaultMenuItemsVisibility();
        if (this.attachImageButtonViewState.isVisible()) {
            this.attachImageButtonViewState.setVisible(!this.isConversationRejected && this.replyBoxViewState.isVisible());
        }
    }

    /* access modifiers changed from: private */
    public void updateReplyBoxVisibility() {
        if (!this.isInBetweenBotExecution) {
            if (this.replyBoxViewState.isVisible()) {
                this.replyBoxViewState.setStandardTextInput();
            }
            hideListPicker(false);
        } else if (this.botMessageDM == null) {
            this.replyBoxViewState.setVisible(false);
        } else {
            Conversation activeConversation = this.viewableConversation.getActiveConversation();
            if (ConversationUtil.isInProgressState(activeConversation.state) || (activeConversation.state == IssueState.RESOLUTION_REQUESTED && activeConversation.isFeedbackBotEnabled)) {
                MessageDM messageDM = this.botMessageDM;
                MessageType messageType = messageDM.messageType;
                if (messageType == MessageType.ADMIN_TEXT_WITH_TEXT_INPUT) {
                    this.replyBoxViewState.setInput(((AdminMessageWithTextInputDM) messageDM).input);
                } else if (messageType == MessageType.OPTION_INPUT) {
                    this.domain.runOnUI(new C2500F() {
                        /* renamed from: f */
                        public void mo33949f() {
                            ConversationalVM conversationalVM = ConversationalVM.this;
                            if (conversationalVM.renderer != null) {
                                conversationalVM.replyBoxViewState.setVisible(false);
                                ConversationalVM conversationalVM2 = ConversationalVM.this;
                                conversationalVM2.showOptions((OptionInputMessageDM) conversationalVM2.botMessageDM);
                            }
                        }
                    });
                } else if (messageType == MessageType.ADMIN_CSAT_MESSAGE) {
                    this.replyBoxViewState.setVisible(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        if ((r0 instanceof com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput) == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007d, code lost:
        if (((com.helpshift.conversation.activeconversation.message.UserMessageDM) r0).getState() == com.helpshift.conversation.activeconversation.message.UserMessageState.SENT) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateUserInputState() {
        /*
            r5 = this;
            com.helpshift.conversation.activeconversation.ViewableConversation r0 = r5.viewableConversation
            com.helpshift.conversation.activeconversation.model.Conversation r0 = r0.getActiveConversation()
            com.helpshift.conversation.dto.IssueState r1 = r0.state
            com.helpshift.conversation.dto.IssueState r2 = com.helpshift.conversation.dto.IssueState.REJECTED
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x0014
            r5.disableUserInputOptions()
        L_0x0011:
            r3 = 0
            goto L_0x007f
        L_0x0014:
            com.helpshift.conversation.dto.IssueState r2 = com.helpshift.conversation.dto.IssueState.RESOLUTION_REQUESTED
            if (r1 != r2) goto L_0x001c
            boolean r2 = r0.isFeedbackBotEnabled
            if (r2 == 0) goto L_0x0011
        L_0x001c:
            com.helpshift.conversation.dto.IssueState r2 = com.helpshift.conversation.dto.IssueState.RESOLUTION_ACCEPTED
            if (r1 == r2) goto L_0x0011
            com.helpshift.conversation.dto.IssueState r2 = com.helpshift.conversation.dto.IssueState.COMPLETED_ISSUE_CREATED
            if (r1 != r2) goto L_0x0025
            goto L_0x0011
        L_0x0025:
            boolean r2 = r5.isInBetweenBotExecution
            if (r2 != 0) goto L_0x004b
            boolean r2 = r0.isFeedbackBotEnabled
            if (r2 == 0) goto L_0x0032
            com.helpshift.conversation.dto.IssueState r2 = com.helpshift.conversation.dto.IssueState.RESOLUTION_REQUESTED
            if (r1 != r2) goto L_0x0032
            goto L_0x004b
        L_0x0032:
            boolean r1 = r0.isInPreIssueMode()
            if (r1 == 0) goto L_0x0044
            java.lang.String r0 = r0.preConversationServerId
            boolean r0 = com.helpshift.util.StringUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0044
            r5.disableUserInputOptions()
            goto L_0x007f
        L_0x0044:
            com.helpshift.conversation.viewmodel.SmartIntentVM r0 = r5.smartIntentVM
            boolean r3 = r0.shouldShowSmartIntentFakeTypingIndicator()
            goto L_0x007f
        L_0x004b:
            com.helpshift.widget.MutableBaseViewState r1 = r5.attachImageButtonViewState
            r1.setVisible(r4)
            boolean r1 = r5.awaitingUserInputForBotStep
            if (r1 == 0) goto L_0x0055
            goto L_0x0011
        L_0x0055:
            r5.disableUserInputOptions()
            com.helpshift.conversation.viewmodel.MessageListVM r1 = r5.messageListVM
            if (r1 == 0) goto L_0x007f
            com.helpshift.util.HSObservableList<com.helpshift.conversation.activeconversation.message.MessageDM> r1 = r0.messageDMs
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x007f
            com.helpshift.util.HSObservableList<com.helpshift.conversation.activeconversation.message.MessageDM> r0 = r0.messageDMs
            int r1 = r1 - r3
            java.lang.Object r0 = r0.get(r1)
            com.helpshift.conversation.activeconversation.message.MessageDM r0 = (com.helpshift.conversation.activeconversation.message.MessageDM) r0
            boolean r1 = r0 instanceof com.helpshift.conversation.activeconversation.message.UserResponseMessageForTextInputDM
            if (r1 != 0) goto L_0x0075
            boolean r1 = r0 instanceof com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput
            if (r1 == 0) goto L_0x007f
        L_0x0075:
            com.helpshift.conversation.activeconversation.message.UserMessageDM r0 = (com.helpshift.conversation.activeconversation.message.UserMessageDM) r0
            com.helpshift.conversation.activeconversation.message.UserMessageState r0 = r0.getState()
            com.helpshift.conversation.activeconversation.message.UserMessageState r1 = com.helpshift.conversation.activeconversation.message.UserMessageState.SENT
            if (r0 != r1) goto L_0x0011
        L_0x007f:
            r5.showFakeTypingIndicator(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.viewmodel.ConversationalVM.updateUserInputState():void");
    }

    public void addAll(Collection<? extends MessageDM> collection) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("addAll called : ");
        outline24.append(collection.size());
        HSLogger.m3237d(TAG, outline24.toString());
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        if (this.conversationManager.hasBotSwitchedToAnotherBotInPollerResponse(collection)) {
            this.conversationManager.updateMessagesClickOnBotSwitch(activeConversation, false);
        }
        List<MessageDM> evaluateBotMessages = evaluateBotMessages(collection);
        if (!this.isInBetweenBotExecution) {
            this.isUserReplyDraftClearedForBotChange = false;
        } else if (!this.isUserReplyDraftClearedForBotChange && this.conversationManager.containsAtleastOneUserMessage(activeConversation)) {
            clearUserReplyDraft();
            this.isUserReplyDraftClearedForBotChange = true;
        }
        MessageListVM messageListVM2 = this.messageListVM;
        if (messageListVM2 != null) {
            messageListVM2.addMessages(evaluateBotMessages);
        }
    }

    public void appendMessages(int i, int i2) {
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            conversationalRenderer.appendMessages(i, i2);
        }
    }

    public List<MessageDM> buildUIMessages(Conversation conversation) {
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        if (!activeConversation.localId.equals(conversation.localId) || !this.conversationManager.shouldOpen(activeConversation)) {
            return new ArrayList(conversation.messageDMs);
        }
        return processMessagesForBots(conversation.messageDMs, false);
    }

    public void clearReply() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalRenderer conversationalRenderer = ConversationalVM.this.renderer;
                if (conversationalRenderer != null) {
                    conversationalRenderer.setReply("");
                }
            }
        });
    }

    public void clearUserReplyDraft() {
        this.conversationController.saveUserReplyText("");
        this.replyFieldViewState.clearReplyText();
    }

    public void createPreIssueFromSmartIntentSelection(String str, List<String> list, List<String> list2, String str2) {
        createPreIssueViaSmartIntent(str, list, list2, str2);
    }

    public void createPreIssueFromSmartIntentSendButton(String str, String str2) {
        createPreIssueViaSmartIntent(str, (List<String>) null, (List<String>) null, str2);
    }

    public void createPreIssueViaConversationalFlow(String str) {
        HSLogger.m3237d(TAG, "Trigger preissue creation via Conversational flow");
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        addPreIssueFirstUserMessage(activeConversation, str, (List<String>) null);
        createPreIssue(activeConversation, str, (List<String>) null);
    }

    public void createPreIssueViaUserRetry(String str, List<String> list) {
        HSLogger.m3237d(TAG, "Trigger preissue creation via User retry");
        createPreIssue(this.viewableConversation.getActiveConversation(), str, list);
    }

    public void downloadAvatarImage(MessageDM messageDM) {
        if ((this.sdkConfigurationDM.isPersonalisedBotEnabled() && messageDM.author.role == Author.AuthorRole.BOT) || (this.sdkConfigurationDM.isPersonalisedAgentEnabled() && messageDM.author.role == Author.AuthorRole.AGENT)) {
            Boolean bool = this.messageToAvatarTriggeredMap.get(messageDM);
            if (bool == null || !bool.booleanValue()) {
                this.messageToAvatarTriggeredMap.put(messageDM, Boolean.TRUE);
                this.conversationManager.downloadAvatarImage(messageDM);
            }
        }
    }

    public void forceClickOnNewConversationButton() {
        if (this.viewableConversation.getActiveConversation().isStartNewConversationClicked) {
            onNewConversationButtonClicked();
        }
    }

    public BaseViewState getAttachImageButtonViewState() {
        return this.attachImageButtonViewState;
    }

    public BaseViewState getConfirmationBoxViewState() {
        return this.confirmationBoxViewState;
    }

    public ConversationFooterViewState getConversationFooterViewState() {
        return this.conversationFooterViewState;
    }

    public HistoryLoadingViewState getHistoryLoadingViewState() {
        return this.historyLoadingViewState;
    }

    public ReplyBoxViewState getReplyBoxViewState() {
        return this.replyBoxViewState;
    }

    public BaseViewState getReplyButtonViewState() {
        return this.replyButtonViewState;
    }

    public ReplyFieldViewState getReplyFieldViewState() {
        return this.replyFieldViewState;
    }

    public ScrollJumperViewState getScrollJumperViewState() {
        return this.scrollJumperViewState;
    }

    public BaseViewState getSmartIntentClearSearchButtonViewState() {
        return this.smartIntentVM.getClearSearchButtonViewState();
    }

    public SmartIntentSavedState getSmartIntentInstanceSaveState() {
        return this.smartIntentVM.buildInstanceSaveState();
    }

    public BaseViewState getSmartIntentReplyButtonViewState() {
        return this.smartIntentVM.getReplyButtonViewState();
    }

    public ReplyFieldViewState getSmartIntentReplyFieldViewState() {
        return this.smartIntentVM.getReplyFieldViewState();
    }

    public List<Integer> getWhiteListedAttachmentTypes() {
        HashSet hashSet = new HashSet();
        List<String> whiteListAttachmentMimeTypes = this.sdkConfigurationDM.getWhiteListAttachmentMimeTypes();
        if (whiteListAttachmentMimeTypes != null && !whiteListAttachmentMimeTypes.contains(AttachmentConstants.ALLOW_ALL_MIME)) {
            for (String next : whiteListAttachmentMimeTypes) {
                if (next.startsWith(AttachmentConstants.IMAGE_MIME_PREFIX)) {
                    hashSet.add(1);
                } else if (next.startsWith(AttachmentConstants.VIDEO_MIME_PREFIX)) {
                    hashSet.add(2);
                } else {
                    hashSet.add(3);
                }
                if (hashSet.size() == 3) {
                    break;
                }
            }
        } else {
            hashSet.add(1);
            hashSet.add(2);
            hashSet.add(3);
        }
        return new ArrayList(hashSet);
    }

    public void handleAdminAttachmentMessageClick(AttachmentMessageDM attachmentMessageDM) {
        this.viewableConversation.onAdminAttachmentMessageClicked(attachmentMessageDM);
    }

    public void handleAdminSuggestedQuestionRead(FAQListMessageDM fAQListMessageDM, String str, String str2) {
        if (!StringUtils.isEmpty(str2)) {
            final Long l = fAQListMessageDM.conversationLocalId;
            final FAQListMessageDM fAQListMessageDM2 = fAQListMessageDM;
            final String str3 = str;
            final String str4 = str2;
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    Conversation conversation;
                    Iterator<Conversation> it = ConversationalVM.this.viewableConversation.getAllConversations().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            conversation = null;
                            break;
                        }
                        conversation = it.next();
                        if (conversation.localId.equals(l)) {
                            break;
                        }
                    }
                    if (conversation != null) {
                        ConversationalVM.this.conversationManager.handleAdminSuggestedQuestionRead(conversation, fAQListMessageDM2, str3, str4);
                    }
                }
            });
        }
    }

    public void handleAppReviewRequestClick(RequestAppReviewMessageDM requestAppReviewMessageDM) {
        String trim = this.sdkConfigurationDM.getString(SDKConfigurationDM.REVIEW_URL).trim();
        if (!StringUtils.isEmpty(trim)) {
            this.sdkConfigurationDM.setAppReviewed(true);
            ConversationalRenderer conversationalRenderer = this.renderer;
            if (conversationalRenderer != null) {
                conversationalRenderer.openAppReviewStore(trim);
            }
        }
        this.conversationManager.handleAppReviewRequestClick(this.viewableConversation.getActiveConversation(), requestAppReviewMessageDM);
    }

    public boolean handleBackPressedForSmartIntent() {
        return this.smartIntentVM.handleBackPressedForSmartIntent();
    }

    public void handleConversationRejectedState() {
        ConversationFooterState conversationFooterState;
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        this.conversationController.saveUserReplyText("");
        if (activeConversation.isRedacted) {
            conversationFooterState = ConversationFooterState.REDACTED_STATE;
        } else {
            conversationFooterState = ConversationFooterState.REJECTED_MESSAGE;
        }
        showStartNewConversation(conversationFooterState);
        this.isConversationRejected = true;
    }

    public void handleIdempotentPreIssueCreationSuccess() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM.this.handlePreIssueCreationSuccess();
                ConversationalVM conversationalVM = ConversationalVM.this;
                if (conversationalVM.renderer != null) {
                    conversationalVM.refreshVM();
                }
            }
        });
    }

    public void handleLeafIntentSelected(LeafIntentUIModel leafIntentUIModel) {
        this.smartIntentVM.handleLeafIntentSelected(leafIntentUIModel);
    }

    public void handleOptionSelected(final OptionInputMessageDM optionInputMessageDM, final OptionInput.Option option, final boolean z) {
        MessageListVM messageListVM2 = this.messageListVM;
        if (messageListVM2 != null) {
            if (optionInputMessageDM.input.type == OptionInput.Type.PILL) {
                int indexOf = messageListVM2.getUiMessageDMs().indexOf(optionInputMessageDM);
                this.messageListVM.remove(Collections.singletonList(optionInputMessageDM));
                this.renderer.updateMessages(indexOf - 1, 1);
            }
            updateLastUserActivityTime();
            OptionInput.Type type = optionInputMessageDM.input.type;
            if (type == OptionInput.Type.PILL) {
                disableUserInputOptions();
            } else if (type == OptionInput.Type.PICKER) {
                hideListPicker(true);
            }
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    try {
                        ConversationalVM.this.conversationManager.sendOptionInputMessage(ConversationalVM.this.viewableConversation.getActiveConversation(), optionInputMessageDM, option, z);
                        if (ConversationalVM.this.viewableConversation.getActiveConversation().isIssueInProgress()) {
                            ConversationalVM conversationalVM = ConversationalVM.this;
                            conversationalVM.showFakeTypingIndicator(!conversationalVM.awaitingUserInputForBotStep);
                        }
                    } catch (RootAPIException e) {
                        ConversationalVM.this.showErrorForNoNetwork(e);
                        throw e;
                    }
                }
            });
        }
    }

    public void handleOptionSelectedForPicker(OptionInputMessageDM optionInputMessageDM, OptionInput.Option option, boolean z) {
        this.listPickerVM = null;
        handleOptionSelected(optionInputMessageDM, option, z);
    }

    public void handlePreIssueCreationSuccess() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (ConversationalVM.this.renderer != null) {
                    HSLogger.m3237d(ConversationalVM.TAG, "Preissue creation success. Handling on UI.");
                    ConversationalVM.this.conversationController.getConversationInboxPoller().startChatPoller();
                    ConversationalVM.this.initMessagesList();
                    ConversationalVM.this.renderer.notifyRefreshList();
                    ConversationalVM conversationalVM = ConversationalVM.this;
                    if (!conversationalVM.isInBetweenBotExecution && conversationalVM.viewableConversation.getActiveConversation().isInPreIssueMode()) {
                        ConversationalVM.this.showFakeTypingIndicator(true);
                    }
                    ConversationalVM.this.renderer.hideNetworkErrorFooter();
                    if (IssueType.ISSUE.equals(ConversationalVM.this.viewableConversation.getActiveConversation().issueType)) {
                        ConversationalVM.this.replyBoxViewState.setVisible(true);
                        ConversationalVM.this.renderMenuItems();
                    }
                }
            }
        });
    }

    public void handleRootIntentSelected(RootIntentUIModel rootIntentUIModel) {
        this.smartIntentVM.handleRootIntentSelected(rootIntentUIModel);
    }

    public void handleScreenshotMessageClick(ScreenshotMessageDM screenshotMessageDM) {
        this.viewableConversation.onScreenshotMessageClicked(screenshotMessageDM);
    }

    public void handleSearchIntentSelected(SearchIntentUIModel searchIntentUIModel) {
        this.smartIntentVM.handleSearchIntentSelected(searchIntentUIModel);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleStateChangeForIssueMode(com.helpshift.conversation.dto.IssueState r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Changing conversation status to: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Helpshift_ConvsatnlVM"
            com.helpshift.util.HSLogger.m3237d(r1, r0)
            com.helpshift.conversation.activeconversation.ViewableConversation r0 = r6.viewableConversation
            com.helpshift.conversation.activeconversation.model.Conversation r0 = r0.getActiveConversation()
            boolean r1 = com.helpshift.conversation.ConversationUtil.isInProgressState(r7)
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = -1
            if (r1 == 0) goto L_0x002d
            r6.showMessageBox()
            r7 = 0
        L_0x002a:
            r0 = 0
            goto L_0x00be
        L_0x002d:
            com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.RESOLUTION_REQUESTED
            if (r7 != r1) goto L_0x0055
            boolean r7 = r0.isFeedbackBotEnabled
            if (r7 == 0) goto L_0x0039
            r6.hideAllFooterWidgets()
            goto L_0x0044
        L_0x0039:
            com.helpshift.configuration.domainmodel.SDKConfigurationDM r7 = r6.sdkConfigurationDM
            boolean r7 = r7.shouldShowConversationResolutionQuestion()
            if (r7 == 0) goto L_0x0044
            r6.showConfirmationBox()
        L_0x0044:
            com.helpshift.widget.MutableScrollJumperViewState r7 = r6.scrollJumperViewState
            boolean r7 = r7.isVisible()
            if (r7 != 0) goto L_0x004f
            r6.notifyRendererForScrollToBottom()
        L_0x004f:
            r7 = 1
            r0 = 0
            r2 = -1
            r3 = 0
            goto L_0x00be
        L_0x0055:
            com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.REJECTED
            if (r7 != r1) goto L_0x0060
            r6.handleConversationRejectedState()
            r7 = 1
            r0 = 1
        L_0x005e:
            r2 = -1
            goto L_0x00be
        L_0x0060:
            com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.RESOLUTION_ACCEPTED
            if (r7 == r1) goto L_0x009e
            com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.RESOLUTION_EXPIRED
            if (r7 != r1) goto L_0x0069
            goto L_0x009e
        L_0x0069:
            com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.RESOLUTION_REJECTED
            if (r7 != r1) goto L_0x007c
            com.helpshift.conversation.domainmodel.ConversationController r7 = r6.conversationController
            r7.setPersistMessageBox(r4)
            r6.showMessageBox()
            com.helpshift.conversation.activeconversation.ConversationManager r7 = r6.conversationManager
            r7.setEnableMessageClickOnResolutionRejected(r0, r3)
            r7 = 1
            goto L_0x002a
        L_0x007c:
            com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.ARCHIVED
            if (r7 != r1) goto L_0x0086
            com.helpshift.conversation.activeconversation.message.ConversationFooterState r7 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.ARCHIVAL_MESSAGE
            r6.showStartNewConversation(r7)
            goto L_0x00bb
        L_0x0086:
            com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.AUTHOR_MISMATCH
            if (r7 != r1) goto L_0x0090
            com.helpshift.conversation.activeconversation.message.ConversationFooterState r7 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.AUTHOR_MISMATCH
            r6.showStartNewConversation(r7)
            goto L_0x00bb
        L_0x0090:
            com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.CLOSED
            if (r7 != r1) goto L_0x00bb
            boolean r7 = r0.isFeedbackBotEnabled
            if (r7 == 0) goto L_0x00bb
            com.helpshift.conversation.activeconversation.message.ConversationFooterState r7 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.START_NEW_CONVERSATION
            r6.showStartNewConversation(r7)
            goto L_0x00bb
        L_0x009e:
            com.helpshift.conversation.domainmodel.ConversationController r7 = r6.conversationController
            java.lang.String r1 = ""
            r7.saveUserReplyText(r1)
            com.helpshift.conversation.activeconversation.ConversationManager r7 = r6.conversationManager
            boolean r7 = r7.shouldShowCSATInFooter(r0)
            if (r7 == 0) goto L_0x00b6
            com.helpshift.conversation.activeconversation.message.ConversationFooterState r7 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.CSAT_RATING
            r6.showStartNewConversation(r7)
            r6.onCSATSurveyRequested()
            goto L_0x00bb
        L_0x00b6:
            com.helpshift.conversation.activeconversation.message.ConversationFooterState r7 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.START_NEW_CONVERSATION
            r6.showStartNewConversation(r7)
        L_0x00bb:
            r7 = 1
            r0 = 0
            goto L_0x005e
        L_0x00be:
            if (r3 == 0) goto L_0x00c3
            r6.updateUIOnNewMessageReceived()
        L_0x00c3:
            if (r7 == 0) goto L_0x00c8
            r6.onAgentTypingUpdate(r4)
        L_0x00c8:
            com.helpshift.conversation.domainmodel.ConversationController r7 = r6.conversationController
            r7.setConversationViewState(r2)
            r6.isConversationRejected = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.viewmodel.ConversationalVM.handleStateChangeForIssueMode(com.helpshift.conversation.dto.IssueState):void");
    }

    public void handleUserAttachmentMessageClick(UserAttachmentMessageDM userAttachmentMessageDM) {
        this.viewableConversation.onUserAttachmentMessageClicked(userAttachmentMessageDM);
    }

    public void hideAllFooterWidgets() {
        this.replyBoxViewState.setVisible(false);
        updateAttachmentButtonViewState();
        this.confirmationBoxViewState.setVisible(false);
        this.conversationFooterViewState.setState(ConversationFooterState.NONE);
    }

    public void hideFakeTypingIndicatorFromSmartIntent() {
        showFakeTypingIndicator(false);
    }

    public void hidePickerClearButton() {
        this.renderer.hidePickerClearButton();
    }

    public void hideReplyFooterFromSmartIntent() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM.this.replyBoxViewState.setVisible(false);
                ConversationalVM.this.updateReplyBoxVisibility();
            }
        });
    }

    public void hideSmartIntentView() {
        HSLogger.m3237d(TAG, "hideSmartIntentView called");
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            conversationalRenderer.hideSendReplyUI();
            this.renderer.hideSmartIntentView();
        }
    }

    public void initMessagesList() {
        MessageListVM messageListVM2 = this.messageListVM;
        if (messageListVM2 != null) {
            messageListVM2.unregisterMessageListVMCallback();
        }
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        this.viewableConversation.initializeConversationsForUI();
        this.conversationManager.initializeIssueStatusForUI(activeConversation);
        boolean hasMoreMessages = this.viewableConversation.hasMoreMessages();
        this.messageListVM = new MessageListVM(this.platform, this.domain);
        List<UIConversation> uIConversations = this.viewableConversation.getUIConversations();
        ArrayList arrayList = new ArrayList();
        for (Conversation uIMessages : this.viewableConversation.getAllConversations()) {
            arrayList.addAll(getUIMessages(uIMessages));
        }
        this.messageListVM.initializeMessageList(uIConversations, arrayList, hasMoreMessages, this);
        this.renderer.initializeMessages(this.messageListVM.getUiMessageDMs());
        this.viewableConversation.registerMessagesObserver(this);
        this.isConversationRejected = activeConversation.state == IssueState.REJECTED;
        prefillReplyBox();
    }

    public boolean isMessageBoxVisible() {
        return this.replyBoxViewState.isVisible();
    }

    public boolean isVisibleOnUI() {
        return this.isScreenCurrentlyVisible;
    }

    public void launchAttachment(String str, String str2) {
        this.renderer.launchAttachment(str, str2);
    }

    public void launchScreenshotAttachment(String str, String str2) {
        this.renderer.launchScreenshotAttachment(str, str2);
    }

    public void markConversationResolutionStatus(boolean z) {
        HSLogger.m3237d(TAG, "Sending resolution event : Accepted? " + z);
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        if (activeConversation.state == IssueState.RESOLUTION_REQUESTED) {
            this.conversationManager.markConversationResolutionStatus(activeConversation, z);
        }
    }

    public void newAdminMessagesAdded() {
        updateUIOnNewMessageReceived();
    }

    public void newUserMessagesAdded() {
        notifyRendererForScrollToBottom();
    }

    public void onActionCardMessageClicked(AdminActionCardMessageDM adminActionCardMessageDM) {
        this.viewableConversation.onActionCardMessageClicked(adminActionCardMessageDM);
        this.renderer.openActionLink(adminActionCardMessageDM.getUriAsStringForAction());
    }

    public void onAdminMessageLinkClickFailed() {
        this.renderer.showErrorView(PlatformException.NO_APPS_FOR_OPENING_ATTACHMENT);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x002e A[EDGE_INSN: B:28:0x002e->B:13:0x002e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdminMessageLinkClicked(java.lang.String r6, com.helpshift.conversation.activeconversation.message.MessageDM r7) {
        /*
            r5 = this;
            r0 = 0
            java.net.URI r1 = java.net.URI.create(r6)     // Catch:{ Exception -> 0x000c }
            if (r1 == 0) goto L_0x000c
            java.lang.String r1 = r1.getScheme()     // Catch:{ Exception -> 0x000c }
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            java.lang.Long r7 = r7.conversationLocalId
            com.helpshift.conversation.activeconversation.ViewableConversation r2 = r5.viewableConversation
            java.util.List r2 = r2.getAllConversations()
            java.util.Iterator r2 = r2.iterator()
        L_0x0019:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x002e
            java.lang.Object r3 = r2.next()
            com.helpshift.conversation.activeconversation.model.Conversation r3 = (com.helpshift.conversation.activeconversation.model.Conversation) r3
            java.lang.Long r4 = r3.localId
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0019
            r0 = r3
        L_0x002e:
            boolean r7 = com.helpshift.util.StringUtils.isEmpty(r1)
            if (r7 != 0) goto L_0x0077
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            if (r0 == 0) goto L_0x0068
            java.lang.String r2 = r0.preConversationServerId
            boolean r2 = com.helpshift.util.StringUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x004a
            java.lang.String r2 = r0.preConversationServerId
            java.lang.String r3 = "preissue_id"
            r7.put(r3, r2)
        L_0x004a:
            java.lang.String r2 = r0.serverId
            boolean r2 = com.helpshift.util.StringUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0059
            java.lang.String r2 = r0.serverId
            java.lang.String r3 = "issue_id"
            r7.put(r3, r2)
        L_0x0059:
            java.lang.String r2 = r0.acid
            boolean r2 = com.helpshift.util.StringUtils.isNotEmpty(r2)
            if (r2 == 0) goto L_0x0068
            java.lang.String r0 = r0.acid
            java.lang.String r2 = "acid"
            r7.put(r2, r0)
        L_0x0068:
            java.lang.String r0 = "p"
            r7.put(r0, r1)
            java.lang.String r0 = "u"
            r7.put(r0, r6)
            com.helpshift.analytics.AnalyticsEventType r6 = com.helpshift.analytics.AnalyticsEventType.ADMIN_MESSAGE_DEEPLINK_CLICKED
            r5.pushAnalyticsEvent(r6, r7)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.viewmodel.ConversationalVM.onAdminMessageLinkClicked(java.lang.String, com.helpshift.conversation.activeconversation.message.MessageDM):void");
    }

    public void onAgentTypingUpdate(final boolean z) {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM conversationalVM = ConversationalVM.this;
                if (conversationalVM.renderer != null) {
                    boolean z = false;
                    if (conversationalVM.viewableConversation.getActiveConversation().isIssueInProgress()) {
                        z = z;
                    }
                    ConversationalVM.this.updateTypingIndicatorStatus(z);
                }
            }
        });
    }

    public void onAttachmentButtonClick() {
        this.conversationController.setPersistMessageBox(true);
    }

    public void onAuthenticationFailure() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalRenderer conversationalRenderer = ConversationalVM.this.renderer;
                if (conversationalRenderer != null) {
                    conversationalRenderer.onAuthenticationFailure();
                }
            }
        });
    }

    public void onCSATSurveyCancelled() {
        sendCSATEvent(AnalyticsEventType.CANCEL_CSAT_RATING);
    }

    public void onCSATSurveyRequested() {
        sendCSATEvent(AnalyticsEventType.CSAT_REQUESTED);
    }

    public void onCSATSurveyRequestedFromBot(String str) {
        if (!this.lastCSATRequestedEventId.equals(str)) {
            sendCSATEvent(AnalyticsEventType.CSAT_REQUESTED);
            this.lastCSATRequestedEventId = str;
        }
    }

    public void onCSATSurveyStarted() {
        sendCSATEvent(AnalyticsEventType.START_CSAT_RATING);
    }

    public void onCSATSurveyStartedFromBot(String str) {
        if (!this.lastCSATStartRatingEventId.equals(str)) {
            sendCSATEvent(AnalyticsEventType.START_CSAT_RATING);
            this.lastCSATStartRatingEventId = str;
        }
    }

    public void onCSATSurveySubmitted(int i, String str) {
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            conversationalRenderer.showCSATSubmittedView();
        }
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        if (!activeConversation.isIssueInProgress()) {
            showStartNewConversation(ConversationFooterState.START_NEW_CONVERSATION);
        }
        HSLogger.m3237d(TAG, "Sending CSAT rating : " + i + ", feedback: " + str);
        this.conversationManager.sendCSATSurvey(activeConversation, i, str);
        sendCSATEvent(AnalyticsEventType.CSAT_SUBMITTED);
    }

    public void onConversationInboxPollFailure() {
        HSLogger.m3241e(TAG, "On conversation inbox poll failure");
        showFakeTypingIndicator(false);
        if (this.platform.isOnline() && !this.awaitingUserInputForBotStep && !this.smartIntentVM.isSmartIntentUIVisible() && this.viewableConversation.getActiveConversation().isIssueInProgress()) {
            if (this.isInBetweenBotExecution || this.viewableConversation.getActiveConversation().isInPreIssueMode()) {
                this.domain.runOnUI(new C2500F() {
                    /* renamed from: f */
                    public void mo33949f() {
                        ConversationalRenderer conversationalRenderer = ConversationalVM.this.renderer;
                        if (conversationalRenderer != null) {
                            conversationalRenderer.showNetworkErrorFooter(2);
                        }
                    }
                });
                this.isShowingPollFailureError = true;
            }
        }
    }

    public void onConversationInboxPollSuccess() {
        if (this.isShowingPollFailureError) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    ConversationalRenderer conversationalRenderer = ConversationalVM.this.renderer;
                    if (conversationalRenderer != null) {
                        conversationalRenderer.hideNetworkErrorFooter();
                    }
                }
            });
            this.isShowingPollFailureError = false;
        }
    }

    public void onCreateConversationFailure(Exception exc) {
        HSLogger.m3242e(TAG, "Error filing a pre-issue", exc);
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM.this.showFakeTypingIndicator(false);
                ConversationalVM conversationalVM = ConversationalVM.this;
                if (conversationalVM.renderer != null) {
                    MessageDM lastUIMessage = conversationalVM.messageListVM.getLastUIMessage();
                    if (lastUIMessage instanceof UserMessageDM) {
                        ((UserMessageDM) lastUIMessage).setState(UserMessageState.UNSENT_RETRYABLE);
                    }
                    ConversationalVM conversationalVM2 = ConversationalVM.this;
                    if (!conversationalVM2.isNetworkAvailable) {
                        conversationalVM2.renderer.showNetworkErrorFooter(1);
                    }
                }
            }
        });
    }

    public void onCreateConversationSuccess(long j) {
        handlePreIssueCreationSuccess();
    }

    public void onDestroy() {
        this.conversationController.resetLastNotificationCountFetchTime();
    }

    public void onHistoryLoadingError() {
        this.historyLoadingViewState.setState(HistoryLoadingState.ERROR);
    }

    public void onHistoryLoadingStarted() {
        this.historyLoadingViewState.setState(HistoryLoadingState.LOADING);
    }

    public void onHistoryLoadingSuccess() {
        this.historyLoadingViewState.setState(HistoryLoadingState.NONE);
    }

    public void onIssueStatusChange(IssueState issueState) {
        if (!this.viewableConversation.getActiveConversation().isInPreIssueMode()) {
            handleStateChangeForIssueMode(issueState);
            if (this.isInBetweenBotExecution) {
                this.attachImageButtonViewState.setVisible(false);
                return;
            }
            return;
        }
        int ordinal = issueState.ordinal();
        if (ordinal == 5) {
            this.awaitingUserInputForBotStep = false;
            removeOptionsMessageFromUI();
            handleConversationRejectedState();
            updateUIOnNewMessageReceived();
        } else if (ordinal == 8) {
            this.awaitingUserInputForBotStep = false;
            showStartNewConversation(ConversationFooterState.START_NEW_CONVERSATION);
            updateUIOnNewMessageReceived();
        }
        updateUserInputState();
    }

    public void onListPickerSearchQueryChange(String str) {
        ListPickerVM listPickerVM2 = this.listPickerVM;
        if (listPickerVM2 != null) {
            listPickerVM2.onListPickerSearchQueryChange(str);
        }
    }

    public void onNetworkAvailable() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM conversationalVM = ConversationalVM.this;
                conversationalVM.isNetworkAvailable = true;
                if (conversationalVM.renderer != null) {
                    conversationalVM.updateUserInputState();
                    ConversationalVM.this.renderer.hideNetworkErrorFooter();
                }
            }
        });
    }

    public void onNetworkUnAvailable() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM conversationalVM = ConversationalVM.this;
                boolean z = false;
                conversationalVM.isNetworkAvailable = false;
                if (conversationalVM.renderer != null) {
                    Conversation activeConversation = conversationalVM.viewableConversation.getActiveConversation();
                    ConversationalVM.this.showFakeTypingIndicator(false);
                    boolean z2 = activeConversation.isInPreIssueMode() && !StringUtils.isEmpty(activeConversation.preConversationServerId) && !ConversationalVM.this.awaitingUserInputForBotStep;
                    ConversationalVM conversationalVM2 = ConversationalVM.this;
                    if (conversationalVM2.isInBetweenBotExecution && !conversationalVM2.awaitingUserInputForBotStep) {
                        z = true;
                    }
                    if (z2 || z) {
                        ConversationalVM.this.renderer.showNetworkErrorFooter(1);
                    }
                }
            }
        });
    }

    public void onNewConversationButtonClicked() {
        boolean z = false;
        this.isInBetweenBotExecution = false;
        stopLiveUpdates();
        this.conversationManager.setStartNewConversationButtonClicked(this.viewableConversation.getActiveConversation(), true, true);
        if (this.showConversationHistory) {
            hideAllFooterWidgets();
            Conversation openConversationWithMessages = this.conversationController.getOpenConversationWithMessages();
            if (openConversationWithMessages == null) {
                openConversationWithMessages = this.conversationController.createLocalPreIssueConversation();
            }
            this.viewableConversation.onNewConversationStarted(openConversationWithMessages);
            this.smartIntentVM.onNewConversationStarted(openConversationWithMessages);
            pushChatScreenOpenAnalyticsEvent();
            refreshVM();
            renderMenuItems();
            initMessagesList();
            this.renderer.notifyRefreshList();
            return;
        }
        HashMap hashMap = new HashMap();
        if (this.showConversationHistory != this.sdkConfigurationDM.shouldShowConversationHistory()) {
            z = true;
        }
        hashMap.put(CREATE_NEW_PRE_ISSUE, Boolean.valueOf(z));
        this.renderer.openFreshConversationScreen(hashMap);
    }

    public void onPause() {
        setScreenVisibility(false);
        setUserCanReadMessages(false);
        markMessagesAsSeenOnExit();
        clearNotifications();
        resetIncrementMessageCountFlag();
        saveReplyText(this.renderer.getReply());
    }

    public void onRestoreSmartIntentInstanceState(SmartIntentSavedState smartIntentSavedState) {
        this.smartIntentVM.onRestoreInstanceState(smartIntentSavedState);
    }

    public void onResume() {
        refreshVM();
        renderMenuItems();
        setScreenVisibility(true);
        setUserCanReadMessages(true);
        markMessagesAsSeenOnEntry();
        clearNotifications();
    }

    public void onScrollJumperViewClicked() {
        notifyRendererForScrollToBottom();
    }

    public void onScrolledToBottom() {
        this.scrollJumperViewState.setVisible(false);
        this.scrollJumperViewState.setShouldShowUnreadMessagesIndicator(false);
    }

    public void onScrolledToTop() {
        if (this.historyLoadingViewState.getState() == HistoryLoadingState.NONE) {
            loadHistoryMessagesInternal();
        }
    }

    public void onScrolling() {
        this.scrollJumperViewState.setVisible(true);
    }

    public void onSendFeedBackClick(final int i, final AdminCSATMessageWithOptions adminCSATMessageWithOptions) {
        int indexOf = this.messageListVM.getUiMessageDMs().indexOf(adminCSATMessageWithOptions);
        this.messageListVM.remove(Collections.singletonList(adminCSATMessageWithOptions));
        this.renderer.updateMessages(indexOf - 1, 1);
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    ConversationalVM.this.conversationManager.sendCSATBotResponse(ConversationalVM.this.viewableConversation.getActiveConversation(), i, false, adminCSATMessageWithOptions);
                } catch (Exception e) {
                    HSLogger.m3242e(ConversationalVM.TAG, "Error sending csat response", e);
                }
            }
        });
        sendCSATEvent(AnalyticsEventType.CSAT_SUBMITTED);
    }

    public void onSkipClick() {
        updateLastUserActivityTime();
        final MessageDM messageDM = this.botMessageDM;
        if (messageDM instanceof AdminMessageWithTextInputDM) {
            clearUserReplyDraft();
            disableUserInputOptions();
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    AdminMessageWithTextInputDM adminMessageWithTextInputDM = (AdminMessageWithTextInputDM) messageDM;
                    try {
                        ConversationalVM.this.conversationManager.sendTextMessage(ConversationalVM.this.viewableConversation.getActiveConversation(), adminMessageWithTextInputDM.input.skipLabel, adminMessageWithTextInputDM, true);
                        ConversationalVM conversationalVM = ConversationalVM.this;
                        conversationalVM.showFakeTypingIndicator(!conversationalVM.awaitingUserInputForBotStep);
                    } catch (RootAPIException e) {
                        ConversationalVM.this.showErrorForNoNetwork(e);
                        throw e;
                    }
                }
            });
        }
        this.renderer.hideSkipButton();
    }

    public void onSmartIntentBottomSheetCollapsed() {
        this.smartIntentVM.onSmartIntentBottomSheetCollapsed();
    }

    public void onSmartIntentBottomSheetExpanded() {
        this.smartIntentVM.onSmartIntentBottomSheetExpanded();
    }

    public void onSmartIntentSendButtonClick() {
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            this.smartIntentVM.onSmartIntentSendButtonClick(conversationalRenderer.getSmartIntentUserQuery());
        }
    }

    public void onSmartIntentTextChanged(CharSequence charSequence) {
        this.smartIntentVM.onSmartIntentTextChanged(charSequence);
    }

    public void onStartNewConversationButtonClickFromCSATBot(final AdminCSATMessageWithOptions adminCSATMessageWithOptions) {
        int indexOf = this.messageListVM.getUiMessageDMs().indexOf(adminCSATMessageWithOptions);
        this.messageListVM.remove(Collections.singletonList(adminCSATMessageWithOptions));
        this.renderer.updateMessages(indexOf - 1, 1);
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    ConversationalVM.this.conversationManager.sendCSATBotResponse(ConversationalVM.this.viewableConversation.getActiveConversation(), 0, true, adminCSATMessageWithOptions);
                } catch (Exception unused) {
                    HSLogger.m3241e(ConversationalVM.TAG, "Error sending csat response");
                }
            }
        });
        onNewConversationButtonClicked();
    }

    public void onUIMessageListUpdated() {
        updateReplyBoxVisibility();
    }

    public void prefillReplyBox() {
        String userReplyText = this.conversationController.getUserReplyText();
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        if (StringUtils.isEmpty(userReplyText) && !this.conversationManager.containsAtleastOneUserMessage(activeConversation)) {
            userReplyText = this.conversationController.getConversationArchivalPrefillText();
            if (StringUtils.isEmpty(userReplyText)) {
                userReplyText = this.sdkConfigurationDM.getString(SDKConfigurationDM.CONVERSATION_PRE_FILL_TEXT);
            }
        }
        if (userReplyText != null) {
            this.replyFieldViewState.setReplyText(userReplyText);
        }
    }

    public void prependConversations(List<Conversation> list, boolean z) {
        if (!ListUtils.isEmpty(list)) {
            List<UIConversation> uIConversations = this.viewableConversation.getUIConversations();
            ArrayList arrayList = new ArrayList();
            for (Conversation uIMessagesForHistory : list) {
                arrayList.addAll(getUIMessagesForHistory(uIMessagesForHistory));
            }
            MessageListVM messageListVM2 = this.messageListVM;
            if (messageListVM2 != null) {
                messageListVM2.updateUIConversationOrder(uIConversations);
                this.messageListVM.prependMessages(arrayList, z);
            }
        } else if (!z) {
            this.messageListVM.prependMessages(new ArrayList(), false);
        }
    }

    public void pushChatScreenOpenAnalyticsEvent() {
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        String str = activeConversation.serverId;
        String str2 = activeConversation.preConversationServerId;
        HashMap hashMap = new HashMap();
        if (StringUtils.isNotEmpty(activeConversation.acid)) {
            hashMap.put("acid", activeConversation.acid);
        }
        if (StringUtils.isNotEmpty(str)) {
            hashMap.put("id", str);
            pushAnalyticsEvent(AnalyticsEventType.OPEN_ISSUE, hashMap);
            return;
        }
        if (StringUtils.isNotEmpty(str2)) {
            hashMap.put(AnalyticsEventKey.PREISSUE_ID, str2);
        }
        pushAnalyticsEvent(AnalyticsEventType.REPORTED_ISSUE, hashMap);
    }

    public void refreshAll() {
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            conversationalRenderer.notifyRefreshList();
        }
    }

    public void refreshVM() {
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        this.conversationManager.updateConversationExpiryProperties(activeConversation);
        boolean shouldShowReplyBoxOnConversationRejected = shouldShowReplyBoxOnConversationRejected();
        this.widgetGateway.updateReplyBoxWidget(this.replyBoxViewState, activeConversation, shouldShowReplyBoxOnConversationRejected);
        this.widgetGateway.updateConfirmationBoxViewState(this.confirmationBoxViewState, activeConversation);
        this.widgetGateway.updateConversationFooterViewState(this.conversationFooterViewState, activeConversation, shouldShowReplyBoxOnConversationRejected);
        this.conversationController.setConversationViewState(this.replyBoxViewState.isVisible() ? 2 : -1);
        this.viewableConversation.registerMessagesObserver(this);
        this.viewableConversation.setConversationVMCallback(this);
        if (!(activeConversation.serverId == null && activeConversation.preConversationServerId == null && this.viewableConversation.getAllConversations().size() <= 1)) {
            this.conversationController.getConversationInboxPoller().startChatPoller();
        }
        if (this.conversationManager.isSynced(activeConversation) || !this.conversationManager.containsAtleastOneUserMessage(activeConversation)) {
            if (!this.conversationManager.isSynced(activeConversation) && this.sdkConfigurationDM.shouldAutoFillPreissueFirstMessage()) {
                String string = this.sdkConfigurationDM.getString(SDKConfigurationDM.INITIAL_USER_MESSAGE_TO_AUTOSEND_IN_PREISSUE);
                if (!StringUtils.isEmpty(string)) {
                    HSLogger.m3237d(TAG, "Auto-filing preissue with client set user message.");
                    this.conversationManager.updateIsAutoFilledPreissueFlag(activeConversation, true);
                    createPreIssueViaConversationalFlow(string);
                    return;
                }
            }
            if (this.smartIntentDM.shouldShowSmartIntent(activeConversation)) {
                this.smartIntentVM.showSmartIntentUI();
                return;
            }
            if (this.conversationManager.isSynced(activeConversation)) {
                evaluateBotMessages(activeConversation.messageDMs);
            }
            updateReplyBoxVisibility();
            return;
        }
        HSObservableList<MessageDM> hSObservableList = activeConversation.messageDMs;
        MessageDM messageDM = (MessageDM) hSObservableList.get(hSObservableList.size() - 1);
        if (messageDM instanceof UserMessageDM) {
            UserMessageDM userMessageDM = (UserMessageDM) messageDM;
            if (userMessageDM.getState() != UserMessageState.SENT) {
                this.replyBoxViewState.setVisible(false);
            }
            if (this.conversationController.isPreissueCreationInProgress(activeConversation.localId.longValue())) {
                userMessageDM.setState(UserMessageState.SENDING);
            }
        }
    }

    public void renderMenuItems() {
        this.replyButtonViewState.setEnabled(!StringUtils.isEmpty(this.replyFieldViewState.getReplyText()));
        updateAttachmentButtonViewState();
    }

    public void resetDefaultMenuItemsVisibility() {
        this.attachImageButtonViewState.setVisible(this.widgetGateway.getDefaultVisibilityForAttachImageButton(this.viewableConversation.getActiveConversation()));
    }

    public void retryHistoryLoadingMessages() {
        if (this.historyLoadingViewState.getState() == HistoryLoadingState.ERROR) {
            loadHistoryMessagesInternal();
        }
    }

    public void retryMessage(final MessageDM messageDM) {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                Conversation activeConversation = ConversationalVM.this.viewableConversation.getActiveConversation();
                if (!ConversationalVM.this.conversationManager.isSynced(activeConversation)) {
                    MessageDM messageDM = messageDM;
                    if (messageDM instanceof UserSmartIntentMessageDM) {
                        HSLogger.m3237d(ConversationalVM.TAG, "User retrying smart intent message to file preissue.");
                        UserSmartIntentMessageDM userSmartIntentMessageDM = (UserSmartIntentMessageDM) messageDM;
                        userSmartIntentMessageDM.setState(UserMessageState.SENDING);
                        ConversationalVM.this.createPreIssueViaUserRetry(messageDM.body, userSmartIntentMessageDM.intentLabels);
                    } else if (messageDM instanceof UserMessageDM) {
                        HSLogger.m3237d(ConversationalVM.TAG, "User retrying message to file preissue.");
                        ((UserMessageDM) messageDM).setState(UserMessageState.SENDING);
                        ConversationalVM.this.createPreIssueViaUserRetry(messageDM.body, (List<String>) null);
                    }
                } else {
                    ConversationalVM conversationalVM = ConversationalVM.this;
                    if (conversationalVM.isNetworkAvailable) {
                        conversationalVM.conversationManager.retryMessage(activeConversation, messageDM);
                        ConversationalVM conversationalVM2 = ConversationalVM.this;
                        conversationalVM2.showFakeTypingIndicator(conversationalVM2.isInBetweenBotExecution);
                    }
                }
            }
        });
    }

    public void saveReplyText(String str) {
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        if (!(str.equals(this.sdkConfigurationDM.getString(SDKConfigurationDM.CONVERSATION_PRE_FILL_TEXT)) || str.equals(this.conversationController.getConversationArchivalPrefillText())) || this.conversationManager.containsAtleastOneUserMessage(activeConversation)) {
            this.replyFieldViewState.setReplyText(str);
            this.conversationController.saveUserReplyText(str);
            return;
        }
        this.conversationController.saveUserReplyText("");
    }

    public void sendAttachment(final AttachmentPickerFile attachmentPickerFile, final String str) {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM conversationalVM = ConversationalVM.this;
                conversationalVM.conversationManager.sendAttachment(conversationalVM.viewableConversation.getActiveConversation(), attachmentPickerFile, str);
            }
        });
    }

    public void sendTextMessage() {
        String reply = this.renderer.getReply();
        if (!StringUtils.isEmpty(reply)) {
            this.conversationController.setPersistMessageBox(true);
            sendTextMessage(reply.trim());
        }
    }

    public void setConversationViewState(int i) {
        this.conversationController.setConversationViewState(i);
    }

    public boolean shouldShowUnreadMessagesIndicator() {
        return this.scrollJumperViewState.shouldShowUnreadMessagesIndicator();
    }

    public void showEmptyListPickerView() {
        this.renderer.showEmptyListPickerView();
    }

    public void showFakeTypingIndicator(final boolean z) {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM conversationalVM = ConversationalVM.this;
                if (conversationalVM.renderer != null) {
                    boolean z = false;
                    if ((conversationalVM.viewableConversation.getActiveConversation().isIssueInProgress() || ConversationalVM.this.viewableConversation.getActiveConversation().isInPreIssueMode() || ConversationalVM.this.isInBetweenBotExecution) && (ConversationalVM.this.viewableConversation.isAgentTyping() || z)) {
                        z = true;
                    }
                    ConversationalVM.this.updateTypingIndicatorStatus(z);
                }
            }
        });
    }

    public void showFakeTypingIndicatorFromSmartIntent() {
        showFakeTypingIndicator(true);
    }

    public void showPickerClearButton() {
        this.renderer.showPickerClearButton();
    }

    public void showReplyFooterFromSmartIntent() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationalVM.this.replyBoxViewState.setVisible(true);
                ConversationalVM.this.updateReplyBoxVisibility();
            }
        });
    }

    public void showSmartIntentReplyValidationFailedError() {
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            conversationalRenderer.showSmartIntentReplyValidationFailedError();
        }
    }

    public void showSmartIntentUI(SmartIntentCollapsedRootViewState smartIntentCollapsedRootViewState) {
        HSLogger.m3237d(TAG, "showSmartIntentUI : " + smartIntentCollapsedRootViewState);
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            conversationalRenderer.showSmartIntentView(smartIntentCollapsedRootViewState);
        }
    }

    public void showStartNewConversation(ConversationFooterState conversationFooterState) {
        this.replyBoxViewState.setVisible(false);
        updateAttachmentButtonViewState();
        this.confirmationBoxViewState.setVisible(false);
        this.conversationFooterViewState.setState(conversationFooterState);
    }

    public void startLiveUpdates() {
        this.viewableConversation.startLiveUpdates();
    }

    public void stopLiveUpdates() {
        this.viewableConversation.stopLiveUpdates();
    }

    public void toggleReplySendButton(boolean z) {
        this.replyButtonViewState.setEnabled(z);
    }

    public void unregisterRenderer() {
        this.viewableConversation.unregisterConversationVMCallback();
        MessageListVM messageListVM2 = this.messageListVM;
        if (messageListVM2 != null) {
            messageListVM2.unregisterMessageListVMCallback();
            this.messageListVM = null;
        }
        this.smartIntentVM.onDestroy();
        this.renderer = null;
        this.domain.getAuthenticationFailureDM().unregisterListener(this);
    }

    public void updateLastUserActivityTime() {
        this.conversationManager.updateLastUserActivityTime(this.viewableConversation.getActiveConversation(), System.currentTimeMillis());
    }

    public void updateListPickerOptions(List<OptionUIModel> list) {
        this.renderer.updateListPickerOptions(list);
    }

    public void updateMessages(int i, int i2) {
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            conversationalRenderer.updateMessages(i, i2);
        }
    }

    public void updateSmartIntentView(BaseSmartIntentViewState baseSmartIntentViewState) {
        HSLogger.m3237d(TAG, "updateSmartIntentView : " + baseSmartIntentViewState);
        ConversationalRenderer conversationalRenderer = this.renderer;
        if (conversationalRenderer != null) {
            conversationalRenderer.updateSmartIntentView(baseSmartIntentViewState);
        }
    }

    public void updateTypingIndicatorStatus(boolean z) {
        boolean z2;
        if (z) {
            this.renderer.showAgentTypingIndicator();
            z2 = !this.scrollJumperViewState.isVisible();
        } else {
            this.renderer.hideAgentTypingIndicator();
            z2 = false;
        }
        if (z2) {
            notifyRendererForScrollToBottom();
        }
    }

    public void updateUIOnNewMessageReceived() {
        if (this.scrollJumperViewState.isVisible()) {
            showUnreadMessagesIndicator();
        } else {
            notifyRendererForScrollToBottom();
        }
    }

    public void updateUnreadMessageCountIndicator(boolean z) {
        this.scrollJumperViewState.setShouldShowUnreadMessagesIndicator(z);
    }

    public void add(MessageDM messageDM) {
        addAll(Collections.singletonList(messageDM));
    }

    public void update(MessageDM messageDM) {
        HSLogger.m3237d(TAG, "update called : " + messageDM);
        updateUserInputState();
        MessageListVM messageListVM2 = this.messageListVM;
        if (messageListVM2 != null) {
            messageListVM2.insertOrUpdateMessage(messageDM);
        }
    }

    private OptionInputMessageDM createOptionsBotMessage(AdminMessageWithOptionInputDM adminMessageWithOptionInputDM) {
        if (adminMessageWithOptionInputDM == null) {
            return null;
        }
        OptionInputMessageDM optionInputMessageDM = new OptionInputMessageDM(adminMessageWithOptionInputDM);
        optionInputMessageDM.setDependencies(this.domain, this.platform);
        return optionInputMessageDM;
    }

    public void handleOptionSelectedForPicker(OptionUIModel optionUIModel, boolean z) {
        ListPickerVM listPickerVM2 = this.listPickerVM;
        if (listPickerVM2 != null) {
            listPickerVM2.handleOptionSelectedForPicker(optionUIModel, z);
        }
    }

    private OptionInputMessageDM createOptionsBotMessage(AdminResolutionMessageWithOptions adminResolutionMessageWithOptions) {
        if (adminResolutionMessageWithOptions == null) {
            return null;
        }
        OptionInputMessageDM optionInputMessageDM = new OptionInputMessageDM(adminResolutionMessageWithOptions);
        optionInputMessageDM.setDependencies(this.domain, this.platform);
        return optionInputMessageDM;
    }

    public void sendTextMessage(final String str) {
        updateLastUserActivityTime();
        Conversation activeConversation = this.viewableConversation.getActiveConversation();
        if (!this.conversationManager.containsAtleastOneUserMessage(activeConversation)) {
            if (StringUtils.userVisibleCharacterCount(str) < this.sdkConfigurationDM.getMinimumConversationDescriptionLength()) {
                this.renderer.showReplyValidationFailedError(1);
                return;
            } else if (StringUtils.isEmpty(activeConversation.preConversationServerId)) {
                clearReply();
                createPreIssueViaConversationalFlow(str);
                return;
            }
        }
        if (!this.isInBetweenBotExecution) {
            sendNormalTextMessage(str);
            return;
        }
        MessageDM messageDM = this.botMessageDM;
        if (!(messageDM instanceof AdminMessageWithTextInputDM)) {
            sendNormalTextMessage(str);
            return;
        }
        final AdminMessageWithTextInputDM adminMessageWithTextInputDM = (AdminMessageWithTextInputDM) messageDM;
        TextInput textInput = adminMessageWithTextInputDM.input;
        if (!textInput.validate(str)) {
            this.renderer.showReplyValidationFailedError(textInput.keyboard);
            return;
        }
        this.renderer.hideReplyValidationFailedError();
        disableUserInputOptions();
        clearReply();
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    ConversationalVM.this.conversationManager.sendTextMessage(ConversationalVM.this.viewableConversation.getActiveConversation(), str, adminMessageWithTextInputDM, false);
                    ConversationalVM conversationalVM = ConversationalVM.this;
                    conversationalVM.showFakeTypingIndicator(!conversationalVM.awaitingUserInputForBotStep);
                } catch (RootAPIException e) {
                    ConversationalVM.this.showErrorForNoNetwork(e);
                    throw e;
                }
            }
        });
    }
}
