package com.helpshift.support.conversations;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.ConversationFooterState;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.HistoryLoadingState;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.support.conversations.messages.AgentTypingMessageDataBinder;
import com.helpshift.support.conversations.messages.ConversationFooterViewBinder;
import com.helpshift.support.conversations.messages.HistoryLoadingViewBinder;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;
import com.helpshift.support.conversations.messages.MessageViewType;
import com.helpshift.support.conversations.messages.MessageViewTypeConverter;
import com.helpshift.support.conversations.messages.MessagesAdapterClickListener;
import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MessageViewDataBinder.MessageItemClickListener, ConversationFooterViewBinder.ConversationFooterClickListener, HistoryLoadingViewBinder.HistoryLoadingClickListener {
    public ConversationFooterState conversationFooterState = ConversationFooterState.NONE;
    public HistoryLoadingState historyLoadingState = HistoryLoadingState.NONE;
    public boolean isAgentTypingIndicatorVisible = false;
    public boolean isAvatarEnabledInChatFeed;
    public MessageViewTypeConverter messageViewTypeConverter;
    public List<MessageDM> messages;
    public MessagesAdapterClickListener messagesAdapterClickListener;

    public MessagesAdapter(Context context, List<MessageDM> list, boolean z, MessagesAdapterClickListener messagesAdapterClickListener2) {
        this.messageViewTypeConverter = new MessageViewTypeConverter(context);
        this.messages = list;
        this.isAvatarEnabledInChatFeed = z;
        this.messagesAdapterClickListener = messagesAdapterClickListener2;
    }

    private int getFooterCount() {
        int i = this.isAgentTypingIndicatorVisible ? 1 : 0;
        return this.conversationFooterState != ConversationFooterState.NONE ? i + 1 : i;
    }

    private int getFooterViewType(int i) {
        int messageCount = i - (getMessageCount() + getHeaderCount());
        boolean z = this.conversationFooterState != ConversationFooterState.NONE;
        if (messageCount != 0) {
            if (messageCount == 1 && z) {
                return MessageViewType.CONVERSATION_FOOTER.key;
            }
        } else if (this.isAgentTypingIndicatorVisible) {
            return MessageViewType.AGENT_TYPING_FOOTER.key;
        } else {
            if (z) {
                return MessageViewType.CONVERSATION_FOOTER.key;
            }
        }
        return -1;
    }

    private int getHeaderCount() {
        return this.historyLoadingState != HistoryLoadingState.NONE ? 1 : 0;
    }

    private int getHeaderViewType() {
        return MessageViewType.HISTORY_LOADING_VIEW.key;
    }

    private MessageDM getMessageFromUIMessageList(int i) {
        return this.messages.get(i - getHeaderCount());
    }

    public void downloadAvatarImage(MessageDM messageDM) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.downloadAvatarImage(messageDM);
        }
    }

    public int getItemCount() {
        return getMessageCount() + getHeaderCount() + getFooterCount();
    }

    public int getItemViewType(int i) {
        if (i < getHeaderCount()) {
            return getHeaderViewType();
        }
        if (i < getMessageCount() + getHeaderCount()) {
            return this.messageViewTypeConverter.messageToViewType(getMessageFromUIMessageList(i));
        }
        return getFooterViewType(i);
    }

    public int getMessageCount() {
        return this.messages.size();
    }

    public void handleAdminImageAttachmentMessageClick(AdminImageAttachmentMessageDM adminImageAttachmentMessageDM) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.handleAdminImageAttachmentMessageClick(adminImageAttachmentMessageDM);
        }
    }

    public void handleGenericAttachmentMessageClick(AdminAttachmentMessageDM adminAttachmentMessageDM) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.handleGenericAttachmentMessageClick(adminAttachmentMessageDM);
        }
    }

    public void handleOptionSelected(OptionInputMessageDM optionInputMessageDM, OptionInput.Option option, boolean z) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.handleOptionSelected(optionInputMessageDM, option, z);
        }
    }

    public void handleReplyReviewButtonClick(RequestAppReviewMessageDM requestAppReviewMessageDM) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.handleReplyReviewButtonClick(requestAppReviewMessageDM);
        }
    }

    public void launchImagePicker(RequestScreenshotMessageDM requestScreenshotMessageDM) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.launchImagePicker(requestScreenshotMessageDM);
        }
    }

    public void onActionCardClicked(AdminActionCardMessageDM adminActionCardMessageDM) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onActionCardClicked(adminActionCardMessageDM);
        }
    }

    public void onAdminMessageLinkClickFailed() {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onAdminMessageLinkClickFailed();
        }
    }

    public void onAdminMessageLinkClicked(String str, MessageDM messageDM) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onAdminMessageLinkClicked(str, messageDM);
        }
    }

    public void onAdminSuggestedQuestionSelected(FAQListMessageDM fAQListMessageDM, String str, String str2) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onAdminSuggestedQuestionSelected(fAQListMessageDM, str, str2);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == MessageViewType.HISTORY_LOADING_VIEW.key) {
            this.messageViewTypeConverter.getHistoryLoadingViewBinder().bind((HistoryLoadingViewBinder.ViewHolder) viewHolder, this.historyLoadingState);
        } else if (itemViewType == MessageViewType.CONVERSATION_FOOTER.key) {
            this.messageViewTypeConverter.getConversationFooterViewBinder().bind((ConversationFooterViewBinder.ViewHolder) viewHolder, this.conversationFooterState);
        } else if (itemViewType == MessageViewType.AGENT_TYPING_FOOTER.key) {
            this.messageViewTypeConverter.getAgentTypingMessageDataBinder().bind((AgentTypingMessageDataBinder.ViewHolder) viewHolder, this.isAvatarEnabledInChatFeed);
        } else {
            this.messageViewTypeConverter.viewTypeToDataBinder(itemViewType).bind(viewHolder, getMessageFromUIMessageList(i));
        }
    }

    public void onCSATSurveyCancelled() {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onCSATSurveyCancelled();
        }
    }

    public void onCSATSurveyRequestedFromBot(String str) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onCSATSurveyRequestedFromBot(str);
        }
    }

    public void onCSATSurveyStarted() {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onCSATSurveyStarted();
        }
    }

    public void onCSATSurveyStartedFromBot(String str) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onCSATSurveyStartedFromBot(str);
        }
    }

    public void onCSATSurveySubmitted(int i, String str) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onCSATSurveySubmitted(i, str);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, String str) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onCreateContextMenu(contextMenu, str);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == MessageViewType.HISTORY_LOADING_VIEW.key) {
            HistoryLoadingViewBinder historyLoadingViewBinder = this.messageViewTypeConverter.getHistoryLoadingViewBinder();
            historyLoadingViewBinder.setHistoryLoadingClickListener(this);
            return historyLoadingViewBinder.createViewHolder(viewGroup);
        } else if (i == MessageViewType.CONVERSATION_FOOTER.key) {
            ConversationFooterViewBinder conversationFooterViewBinder = this.messageViewTypeConverter.getConversationFooterViewBinder();
            conversationFooterViewBinder.setConversationFooterClickListener(this);
            return conversationFooterViewBinder.createViewHolder(viewGroup);
        } else if (i == MessageViewType.AGENT_TYPING_FOOTER.key) {
            return this.messageViewTypeConverter.getAgentTypingMessageDataBinder().createViewHolder(viewGroup);
        } else {
            MessageViewDataBinder viewTypeToDataBinder = this.messageViewTypeConverter.viewTypeToDataBinder(i);
            viewTypeToDataBinder.setMessageItemClickListener(this);
            return viewTypeToDataBinder.createViewHolder(viewGroup);
        }
    }

    public void onHistoryLoadingRetryClicked() {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onHistoryLoadingRetryClicked();
        }
    }

    public void onItemRangeChanged(int i, int i2) {
        notifyItemRangeChanged(i + getHeaderCount(), i2);
    }

    public void onItemRangeInserted(int i, int i2) {
        notifyItemRangeInserted(i + getHeaderCount(), i2);
    }

    public void onItemRangeRemoved(int i, int i2) {
        notifyItemRangeRemoved(i + getHeaderCount(), i2);
    }

    public void onScreenshotMessageClicked(ScreenshotMessageDM screenshotMessageDM) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onScreenshotMessageClicked(screenshotMessageDM);
        }
    }

    public void onSendFeedbackClick(int i, AdminCSATMessageWithOptions adminCSATMessageWithOptions) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onSendFeedbackClick(i, adminCSATMessageWithOptions);
        }
    }

    public void onStartNewConversationButtonClick() {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onStartNewConversationButtonClick();
        }
    }

    public void onStartNewConversationButtonClickFromCSATBot(AdminCSATMessageWithOptions adminCSATMessageWithOptions) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onStartNewConversationButtonClickFromCSATBot(adminCSATMessageWithOptions);
        }
    }

    public void onUserAttachmentMessageClicked(UserAttachmentMessageDM userAttachmentMessageDM) {
        MessagesAdapterClickListener messagesAdapterClickListener2 = this.messagesAdapterClickListener;
        if (messagesAdapterClickListener2 != null) {
            messagesAdapterClickListener2.onUserAttachmentMessageClicked(userAttachmentMessageDM);
        }
    }

    public void retryMessage(int i) {
        if (this.messagesAdapterClickListener != null) {
            this.messagesAdapterClickListener.retryMessage(getMessageFromUIMessageList(i));
        }
    }

    public void setAgentTypingIndicatorVisibility(boolean z) {
        if (this.isAgentTypingIndicatorVisible != z) {
            this.isAgentTypingIndicatorVisible = z;
            if (z) {
                notifyItemRangeInserted(this.messages.size(), 1);
            } else {
                notifyItemRangeRemoved(this.messages.size(), 1);
            }
        }
    }

    public void setConversationFooterState(ConversationFooterState conversationFooterState2) {
        if (conversationFooterState2 == null) {
            conversationFooterState2 = ConversationFooterState.NONE;
        }
        this.conversationFooterState = conversationFooterState2;
        notifyDataSetChanged();
    }

    public void setHistoryLoadingState(HistoryLoadingState historyLoadingState2) {
        HistoryLoadingState historyLoadingState3;
        if (historyLoadingState2 != null && (historyLoadingState3 = this.historyLoadingState) != historyLoadingState2) {
            HistoryLoadingState historyLoadingState4 = HistoryLoadingState.NONE;
            if (historyLoadingState3 == historyLoadingState4) {
                this.historyLoadingState = historyLoadingState2;
                notifyItemInserted(0);
            } else if (historyLoadingState2 == historyLoadingState4) {
                this.historyLoadingState = historyLoadingState2;
                notifyItemRemoved(0);
            } else {
                this.historyLoadingState = historyLoadingState2;
                notifyItemChanged(0);
            }
        }
    }

    public void unregisterAdapterClickListener() {
        this.messagesAdapterClickListener = null;
    }
}
