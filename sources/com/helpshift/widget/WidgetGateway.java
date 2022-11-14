package com.helpshift.widget;

import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.message.ConversationFooterState;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.util.StringUtils;

public class WidgetGateway {
    public final SDKConfigurationDM config;
    public final ConversationController conversationController;

    public WidgetGateway(SDKConfigurationDM sDKConfigurationDM, ConversationController conversationController2) {
        this.config = sDKConfigurationDM;
        this.conversationController = conversationController2;
    }

    private boolean getVisibilityForNewConversationAttachImageButton(MutableImageAttachmentViewState mutableImageAttachmentViewState) {
        if (!getDefaultVisibilityForAttachImageButtonNewConversation() || !StringUtils.isEmpty(mutableImageAttachmentViewState.getImagePath()) || this.conversationController.isCreateConversationInProgress()) {
            return false;
        }
        return true;
    }

    private boolean isEmailRequired() {
        if (this.config.getBoolean(SDKConfigurationDM.ENABLE_FULL_PRIVACY)) {
            return false;
        }
        if (this.config.getBoolean(SDKConfigurationDM.REQUIRE_NAME_AND_EMAIL)) {
            return true;
        }
        if (!this.config.getBoolean(SDKConfigurationDM.PROFILE_FORM_ENABLE) || !this.config.getBoolean(SDKConfigurationDM.REQUIRE_EMAIL)) {
            return false;
        }
        return true;
    }

    private boolean isProfileFormVisible(TextViewState textViewState, TextViewState textViewState2) {
        if (this.config.getBoolean(SDKConfigurationDM.ENABLE_FULL_PRIVACY)) {
            return false;
        }
        boolean z = this.config.getBoolean(SDKConfigurationDM.PROFILE_FORM_ENABLE);
        boolean z2 = this.config.getBoolean(SDKConfigurationDM.HIDE_NAME_AND_EMAIL);
        boolean z3 = textViewState.getText().length() > 0;
        boolean z4 = textViewState2.getText().length() > 0;
        if (!this.config.getBoolean(SDKConfigurationDM.REQUIRE_NAME_AND_EMAIL) || !z2) {
            if (!z) {
                return false;
            }
            if (!z2 || ((this.config.getBoolean(SDKConfigurationDM.REQUIRE_EMAIL) && !z4) || !z3)) {
                return true;
            }
            return false;
        } else if (!z3 || !z4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getDefaultVisibilityForAttachImageButton(Conversation conversation) {
        return !conversation.isInPreIssueMode() && getDefaultVisibilityForAttachImageButtonNewConversation();
    }

    public boolean getDefaultVisibilityForAttachImageButtonNewConversation() {
        return !this.config.getBoolean(SDKConfigurationDM.ENABLE_FULL_PRIVACY) && this.config.getBoolean(SDKConfigurationDM.ALLOW_USER_ATTACHMENTS);
    }

    public boolean getDefaultVisibilityForConversationInfoButtonWidget(Conversation conversation) {
        return !conversation.isInPreIssueMode() && this.config.getBoolean(SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN);
    }

    public MutableBaseViewState makeAttachImageButtonViewState(Conversation conversation) {
        MutableBaseViewState mutableBaseViewState = new MutableBaseViewState();
        mutableBaseViewState.setVisible(getDefaultVisibilityForAttachImageButton(conversation));
        return mutableBaseViewState;
    }

    public MutableBaseViewState makeConfirmationBoxViewState(Conversation conversation) {
        MutableBaseViewState mutableBaseViewState = new MutableBaseViewState();
        updateConfirmationBoxViewState(mutableBaseViewState, conversation);
        return mutableBaseViewState;
    }

    public MutableConversationFooterViewState makeConversationFooterViewState(Conversation conversation, boolean z) {
        MutableConversationFooterViewState mutableConversationFooterViewState = new MutableConversationFooterViewState();
        updateConversationFooterViewState(mutableConversationFooterViewState, conversation, z);
        return mutableConversationFooterViewState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.helpshift.widget.MutableTextViewState makeDescriptionViewState() {
        /*
            r10 = this;
            com.helpshift.widget.MutableTextViewState r0 = new com.helpshift.widget.MutableTextViewState
            r1 = 1
            r0.<init>(r1)
            com.helpshift.conversation.domainmodel.ConversationController r2 = r10.conversationController
            java.lang.String r2 = r2.getConversationArchivalPrefillText()
            com.helpshift.configuration.domainmodel.SDKConfigurationDM r3 = r10.config
            java.lang.String r4 = "conversationPrefillText"
            java.lang.String r3 = r3.getString(r4)
            com.helpshift.conversation.domainmodel.ConversationController r4 = r10.conversationController
            com.helpshift.conversation.dto.ConversationDetailDTO r4 = r4.getConversationDetail()
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0043
            int r6 = r4.type
            if (r6 != r1) goto L_0x0043
            java.lang.String r1 = r4.title
            long r6 = java.lang.System.nanoTime()
            long r8 = r4.timestamp
            long r6 = r6 - r8
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x003d
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r6 = r4.toSeconds(r6)
            r8 = 7200(0x1c20, double:3.5573E-320)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x0044
        L_0x003d:
            com.helpshift.conversation.domainmodel.ConversationController r1 = r10.conversationController
            r4 = 0
            r1.saveDescriptionDetail(r5, r4)
        L_0x0043:
            r1 = r5
        L_0x0044:
            boolean r4 = com.helpshift.util.StringUtils.isEmpty(r1)
            if (r4 != 0) goto L_0x004c
            r2 = r1
            goto L_0x0068
        L_0x004c:
            boolean r1 = com.helpshift.util.StringUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0059
            com.helpshift.conversation.domainmodel.ConversationController r1 = r10.conversationController
            r3 = 3
            r1.saveDescriptionDetail(r2, r3)
            goto L_0x0068
        L_0x0059:
            boolean r1 = com.helpshift.util.StringUtils.isEmpty(r3)
            if (r1 != 0) goto L_0x0067
            com.helpshift.conversation.domainmodel.ConversationController r1 = r10.conversationController
            r2 = 2
            r1.saveDescriptionDetail(r3, r2)
            r2 = r3
            goto L_0x0068
        L_0x0067:
            r2 = r5
        L_0x0068:
            r0.setText(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.widget.WidgetGateway.makeDescriptionViewState():com.helpshift.widget.MutableTextViewState");
    }

    public MutableTextViewState makeEmailViewState() {
        MutableTextViewState mutableTextViewState = new MutableTextViewState(isEmailRequired());
        if (!this.config.shouldCreateConversationAnonymously()) {
            mutableTextViewState.setText(this.conversationController.getEmail());
        }
        return mutableTextViewState;
    }

    public MutableImageAttachmentViewState makeImageAttachmentWidget() {
        MutableImageAttachmentViewState mutableImageAttachmentViewState = new MutableImageAttachmentViewState();
        if (this.config.getBoolean(SDKConfigurationDM.ENABLE_FULL_PRIVACY)) {
            mutableImageAttachmentViewState.setAttachmentPickerFile((AttachmentPickerFile) null);
            save(mutableImageAttachmentViewState);
        } else {
            mutableImageAttachmentViewState.setAttachmentPickerFile(this.conversationController.getImageAttachmentDraft());
            mutableImageAttachmentViewState.setClickable(!this.conversationController.isCreateConversationInProgress());
        }
        return mutableImageAttachmentViewState;
    }

    public MutableTextViewState makeNameViewState() {
        MutableTextViewState mutableTextViewState = new MutableTextViewState(true);
        mutableTextViewState.setText(!this.config.shouldCreateConversationAnonymously() ? this.conversationController.getName() : "Anonymous");
        return mutableTextViewState;
    }

    public MutableBaseViewState makeNewConversationAttachImageButtonViewState(MutableImageAttachmentViewState mutableImageAttachmentViewState) {
        MutableBaseViewState mutableBaseViewState = new MutableBaseViewState();
        mutableBaseViewState.setVisible(getVisibilityForNewConversationAttachImageButton(mutableImageAttachmentViewState));
        return mutableBaseViewState;
    }

    public MutableBaseViewState makeProfileFormViewState(TextViewState textViewState, TextViewState textViewState2) {
        MutableBaseViewState mutableBaseViewState = new MutableBaseViewState();
        mutableBaseViewState.setVisible(isProfileFormVisible(textViewState, textViewState2));
        return mutableBaseViewState;
    }

    public MutableBaseViewState makeProgressBarViewState() {
        MutableBaseViewState mutableBaseViewState = new MutableBaseViewState();
        mutableBaseViewState.setVisible(this.conversationController.isCreateConversationInProgress());
        return mutableBaseViewState;
    }

    public MutableReplyBoxViewState makeReplyBoxViewState(Conversation conversation, boolean z) {
        MutableReplyBoxViewState mutableReplyBoxViewState = new MutableReplyBoxViewState();
        updateReplyBoxWidget(mutableReplyBoxViewState, conversation, z);
        return mutableReplyBoxViewState;
    }

    public MutableReplyFieldViewState makeReplyFieldViewState() {
        return new MutableReplyFieldViewState();
    }

    public MutableScrollJumperViewState makeScrollJumperViewState() {
        return new MutableScrollJumperViewState(false, false);
    }

    public MutableBaseViewState makeStartConversationButtonViewState() {
        MutableBaseViewState mutableBaseViewState = new MutableBaseViewState();
        mutableBaseViewState.setVisible(!this.conversationController.isCreateConversationInProgress());
        return mutableBaseViewState;
    }

    public void save(MutableTextViewState mutableTextViewState) {
        this.conversationController.saveDescriptionDetail(mutableTextViewState.getText(), 1);
    }

    public void updateConfirmationBoxViewState(MutableBaseViewState mutableBaseViewState, Conversation conversation) {
        mutableBaseViewState.setVisible(!conversation.isRedacted && !conversation.isFeedbackBotEnabled && conversation.state == IssueState.RESOLUTION_REQUESTED && this.config.shouldShowConversationResolutionQuestion());
    }

    public void updateConversationFooterViewState(MutableConversationFooterViewState mutableConversationFooterViewState, Conversation conversation, boolean z) {
        ConversationFooterState conversationFooterState = ConversationFooterState.NONE;
        if (conversation.isRedacted) {
            conversationFooterState = ConversationFooterState.REDACTED_STATE;
        } else {
            IssueState issueState = conversation.state;
            if (issueState == IssueState.RESOLUTION_ACCEPTED || issueState == IssueState.RESOLUTION_EXPIRED) {
                if (this.conversationController.conversationManager.shouldShowCSATInFooter(conversation)) {
                    conversationFooterState = ConversationFooterState.CSAT_RATING;
                } else {
                    conversationFooterState = ConversationFooterState.START_NEW_CONVERSATION;
                }
            } else if (issueState == IssueState.REJECTED) {
                conversationFooterState = ConversationFooterState.REJECTED_MESSAGE;
            } else if (issueState == IssueState.ARCHIVED) {
                conversationFooterState = ConversationFooterState.ARCHIVAL_MESSAGE;
            } else if (issueState != IssueState.RESOLUTION_REQUESTED || !this.config.shouldShowConversationResolutionQuestion() || conversation.isFeedbackBotEnabled) {
                IssueState issueState2 = conversation.state;
                if (issueState2 == IssueState.RESOLUTION_REJECTED) {
                    if (z) {
                        conversationFooterState = ConversationFooterState.NONE;
                    } else if (this.conversationController.conversationManager.shouldShowCSATInFooter(conversation)) {
                        conversationFooterState = ConversationFooterState.CSAT_RATING;
                    } else {
                        conversationFooterState = ConversationFooterState.START_NEW_CONVERSATION;
                    }
                } else if (issueState2 == IssueState.CLOSED) {
                    conversationFooterState = ConversationFooterState.START_NEW_CONVERSATION;
                } else if (issueState2 == IssueState.AUTHOR_MISMATCH) {
                    conversationFooterState = ConversationFooterState.AUTHOR_MISMATCH;
                }
            } else {
                conversationFooterState = ConversationFooterState.CONVERSATION_ENDED_MESSAGE;
            }
        }
        mutableConversationFooterViewState.setState(conversationFooterState);
    }

    public void updateReplyBoxWidget(MutableReplyBoxViewState mutableReplyBoxViewState, Conversation conversation, boolean z) {
        boolean z2 = true;
        if (conversation.isRedacted || (!conversation.isIssueInProgress() && (conversation.state != IssueState.RESOLUTION_REJECTED || !z))) {
            z2 = false;
        }
        mutableReplyBoxViewState.setVisible(z2);
    }

    public void save(MutableImageAttachmentViewState mutableImageAttachmentViewState) {
        this.conversationController.saveImageAttachmentDraft(mutableImageAttachmentViewState.getAttachmentPickerFile());
    }
}
