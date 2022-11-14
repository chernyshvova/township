package com.helpshift.conversation;

import com.helpshift.common.domain.C2500F;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import java.lang.ref.WeakReference;
import java.util.List;

public class CreatePreIssueDM extends C2500F {
    public static final String TAG = "Helpshift_CrtePreIsue";
    public final Conversation conversation;
    public final ConversationController conversationController;
    public final ConversationManager conversationManager;
    public final String greetingMessage;
    public List<String> intentLabels;
    public WeakReference<ConversationController.StartNewConversationListener> listener;
    public final String userMessage;

    public CreatePreIssueDM(ConversationController conversationController2, ConversationManager conversationManager2, Conversation conversation2, ConversationController.StartNewConversationListener startNewConversationListener, String str, String str2, List<String> list) {
        this.conversationController = conversationController2;
        this.conversationManager = conversationManager2;
        this.conversation = conversation2;
        this.listener = new WeakReference<>(startNewConversationListener);
        this.greetingMessage = str;
        this.userMessage = str2;
        this.intentLabels = list;
    }

    /* renamed from: f */
    public void mo33949f() {
        try {
            if (!this.conversationManager.isSynced(this.conversation)) {
                HSLogger.m3237d(TAG, "Filing preissue with backend.");
                this.conversationController.createPreIssueNetwork(this.conversation, this.greetingMessage, this.userMessage, this.intentLabels);
                this.conversationController.conversationManager.updateLastUserActivityTime(this.conversation, System.currentTimeMillis());
                ConversationController.StartNewConversationListener startNewConversationListener = (ConversationController.StartNewConversationListener) this.listener.get();
                if (startNewConversationListener != null) {
                    startNewConversationListener.onCreateConversationSuccess(this.conversation.localId.longValue());
                }
            }
        } catch (RootAPIException e) {
            HSLogger.m3242e(TAG, "Error filing a pre-issue", e);
            ConversationController.StartNewConversationListener startNewConversationListener2 = (ConversationController.StartNewConversationListener) this.listener.get();
            if (startNewConversationListener2 != null && StringUtils.isEmpty(this.conversation.getPreIssueId())) {
                startNewConversationListener2.onCreateConversationFailure(e);
            }
        }
    }

    public void setListener(ConversationController.StartNewConversationListener startNewConversationListener) {
        this.listener = new WeakReference<>(startNewConversationListener);
    }
}
