package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.util.SparseArray;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemDateMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemDividerMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemPublishIdMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemRedactedConversationMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;

public class MessageViewTypeConverter {
    public AgentTypingMessageDataBinder agentTypingMessageDataBinder;
    public final Context context;
    public ConversationFooterViewBinder conversationFooterViewBinder;
    public HistoryLoadingViewBinder historyLoadingViewBinder;
    public SparseArray<MessageViewDataBinder> viewTypeToDataBinderMap = new SparseArray<>();

    /* renamed from: com.helpshift.support.conversations.messages.MessageViewTypeConverter$1 */
    public static /* synthetic */ class C27671 {

        /* renamed from: $SwitchMap$com$helpshift$support$conversations$messages$MessageViewType */
        public static final /* synthetic */ int[] f3360xff23e33d;

        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|(2:19|20)|21|23|24|25|26|(2:27|28)|29|(2:31|32)|33|(2:35|36)|37|39|40|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|56|57|(2:59|60)|61|(2:63|64)|65|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|(2:27|28)|29|31|32|33|35|36|37|39|40|41|42|43|45|46|47|49|50|51|53|54|55|56|57|59|60|61|63|64|65|67|68|69|70|71|72|74) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0041 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00ad */
        static {
            /*
                com.helpshift.support.conversations.messages.MessageViewType[] r0 = com.helpshift.support.conversations.messages.MessageViewType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3360xff23e33d = r0
                com.helpshift.support.conversations.messages.MessageViewType r1 = com.helpshift.support.conversations.messages.MessageViewType.ADMIN_TEXT_MESSAGE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.support.conversations.messages.MessageViewType r2 = com.helpshift.support.conversations.messages.MessageViewType.USER_TEXT_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.support.conversations.messages.MessageViewType r3 = com.helpshift.support.conversations.messages.MessageViewType.USER_SCREENSHOT_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.support.conversations.messages.MessageViewType r3 = com.helpshift.support.conversations.messages.MessageViewType.ADMIN_ATTACHMENT_IMAGE     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x002b }
                com.helpshift.support.conversations.messages.MessageViewType r3 = com.helpshift.support.conversations.messages.MessageViewType.ADMIN_ATTACHMENT_GENERIC     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.helpshift.support.conversations.messages.MessageViewType r2 = com.helpshift.support.conversations.messages.MessageViewType.REQUESTED_APP_REVIEW     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 6
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r0 = 7
                r2 = 8
                int[] r3 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x003b }
                com.helpshift.support.conversations.messages.MessageViewType r4 = com.helpshift.support.conversations.messages.MessageViewType.CONFIRMATION_REJECTED     // Catch:{ NoSuchFieldError -> 0x003b }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                int[] r3 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0041 }
                com.helpshift.support.conversations.messages.MessageViewType r4 = com.helpshift.support.conversations.messages.MessageViewType.ADMIN_REQUEST_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0041 }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                int[] r1 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.helpshift.support.conversations.messages.MessageViewType r2 = com.helpshift.support.conversations.messages.MessageViewType.REQUEST_FOR_REOPEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 9
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r0 = 14
                int[] r1 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0053 }
                com.helpshift.support.conversations.messages.MessageViewType r2 = com.helpshift.support.conversations.messages.MessageViewType.ADMIN_SUGGESTIONS_LIST     // Catch:{ NoSuchFieldError -> 0x0053 }
                r2 = 10
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                r1 = 11
                r2 = 13
                int[] r3 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x005d }
                com.helpshift.support.conversations.messages.MessageViewType r4 = com.helpshift.support.conversations.messages.MessageViewType.USER_SELECTABLE_OPTION     // Catch:{ NoSuchFieldError -> 0x005d }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                r3 = 12
                int[] r4 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0065 }
                com.helpshift.support.conversations.messages.MessageViewType r5 = com.helpshift.support.conversations.messages.MessageViewType.SYSTEM_DATE     // Catch:{ NoSuchFieldError -> 0x0065 }
                r4[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r1 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x006b }
                com.helpshift.support.conversations.messages.MessageViewType r4 = com.helpshift.support.conversations.messages.MessageViewType.SYSTEM_DIVIDER     // Catch:{ NoSuchFieldError -> 0x006b }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x006b }
            L_0x006b:
                r1 = 15
                int[] r2 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.helpshift.support.conversations.messages.MessageViewType r3 = com.helpshift.support.conversations.messages.MessageViewType.SYSTEM_PUBLISH_ID     // Catch:{ NoSuchFieldError -> 0x0073 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                r0 = 18
                int[] r2 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x007b }
                com.helpshift.support.conversations.messages.MessageViewType r3 = com.helpshift.support.conversations.messages.MessageViewType.ADMIN_REDACTED_MESSAGE     // Catch:{ NoSuchFieldError -> 0x007b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                r1 = 16
                r2 = 19
                int[] r3 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0085 }
                com.helpshift.support.conversations.messages.MessageViewType r4 = com.helpshift.support.conversations.messages.MessageViewType.USER_REDACTED_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0085 }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r3 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x008d }
                com.helpshift.support.conversations.messages.MessageViewType r4 = com.helpshift.support.conversations.messages.MessageViewType.SYSTEM_CONVERSATION_REDACTED_MESSAGE     // Catch:{ NoSuchFieldError -> 0x008d }
                r4 = 17
                r3[r1] = r4     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                r1 = 20
                int[] r3 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.helpshift.support.conversations.messages.MessageViewType r4 = com.helpshift.support.conversations.messages.MessageViewType.USER_ATTACHMENT_GENERIC     // Catch:{ NoSuchFieldError -> 0x0095 }
                r3[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                r0 = 21
                int[] r3 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x009d }
                com.helpshift.support.conversations.messages.MessageViewType r4 = com.helpshift.support.conversations.messages.MessageViewType.ACTION_CARD_MESSAGE     // Catch:{ NoSuchFieldError -> 0x009d }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                r2 = 22
                int[] r3 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x00a5 }
                com.helpshift.support.conversations.messages.MessageViewType r4 = com.helpshift.support.conversations.messages.MessageViewType.USER_SMART_INTENT_MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a5 }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x00a5 }
            L_0x00a5:
                int[] r1 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x00ad }
                com.helpshift.support.conversations.messages.MessageViewType r3 = com.helpshift.support.conversations.messages.MessageViewType.ADMIN_CSAT_MESSAGE     // Catch:{ NoSuchFieldError -> 0x00ad }
                r3 = 23
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f3360xff23e33d     // Catch:{ NoSuchFieldError -> 0x00b5 }
                com.helpshift.support.conversations.messages.MessageViewType r1 = com.helpshift.support.conversations.messages.MessageViewType.USER_RSP_CSAT_BOT     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r1 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.MessageViewTypeConverter.C27671.<clinit>():void");
        }
    }

    public MessageViewTypeConverter(Context context2) {
        this.context = context2;
        this.conversationFooterViewBinder = new ConversationFooterViewBinder(context2);
        this.agentTypingMessageDataBinder = new AgentTypingMessageDataBinder(context2);
        this.historyLoadingViewBinder = new HistoryLoadingViewBinder(context2);
    }

    public AgentTypingMessageDataBinder getAgentTypingMessageDataBinder() {
        return this.agentTypingMessageDataBinder;
    }

    public ConversationFooterViewBinder getConversationFooterViewBinder() {
        return this.conversationFooterViewBinder;
    }

    public HistoryLoadingViewBinder getHistoryLoadingViewBinder() {
        return this.historyLoadingViewBinder;
    }

    public int messageToViewType(MessageDM messageDM) {
        if (messageDM.isRedacted) {
            if (messageDM.isAdminMessage) {
                return MessageViewType.ADMIN_REDACTED_MESSAGE.key;
            }
            return MessageViewType.USER_REDACTED_MESSAGE.key;
        } else if (messageDM instanceof UserResponseMessageForCSATInput) {
            return MessageViewType.USER_RSP_CSAT_BOT.key;
        } else {
            if (messageDM instanceof AdminCSATMessageWithOptions) {
                return MessageViewType.ADMIN_CSAT_MESSAGE.key;
            }
            if (messageDM instanceof FAQListMessageDM) {
                return MessageViewType.ADMIN_SUGGESTIONS_LIST.key;
            }
            if (messageDM instanceof OptionInputMessageDM) {
                return MessageViewType.USER_SELECTABLE_OPTION.key;
            }
            if (messageDM instanceof AdminActionCardMessageDM) {
                return MessageViewType.ACTION_CARD_MESSAGE.key;
            }
            if (messageDM instanceof UserSmartIntentMessageDM) {
                return MessageViewType.USER_SMART_INTENT_MESSAGE.key;
            }
            if (messageDM instanceof AdminMessageDM) {
                return MessageViewType.ADMIN_TEXT_MESSAGE.key;
            }
            if (messageDM instanceof UserMessageDM) {
                return MessageViewType.USER_TEXT_MESSAGE.key;
            }
            if (messageDM instanceof ScreenshotMessageDM) {
                return MessageViewType.USER_SCREENSHOT_ATTACHMENT.key;
            }
            if (messageDM instanceof UserAttachmentMessageDM) {
                return MessageViewType.USER_ATTACHMENT_GENERIC.key;
            }
            if (messageDM instanceof AdminImageAttachmentMessageDM) {
                return MessageViewType.ADMIN_ATTACHMENT_IMAGE.key;
            }
            if (messageDM instanceof AdminAttachmentMessageDM) {
                return MessageViewType.ADMIN_ATTACHMENT_GENERIC.key;
            }
            if (messageDM instanceof RequestAppReviewMessageDM) {
                return MessageViewType.REQUESTED_APP_REVIEW.key;
            }
            if (messageDM instanceof ConfirmationRejectedMessageDM) {
                return MessageViewType.CONFIRMATION_REJECTED.key;
            }
            if (messageDM instanceof RequestScreenshotMessageDM) {
                return MessageViewType.ADMIN_REQUEST_ATTACHMENT.key;
            }
            if (messageDM instanceof RequestForReopenMessageDM) {
                return MessageViewType.REQUEST_FOR_REOPEN.key;
            }
            if (messageDM instanceof SystemDateMessageDM) {
                return MessageViewType.SYSTEM_DATE.key;
            }
            if (messageDM instanceof SystemDividerMessageDM) {
                return MessageViewType.SYSTEM_DIVIDER.key;
            }
            if (messageDM instanceof SystemPublishIdMessageDM) {
                return MessageViewType.SYSTEM_PUBLISH_ID.key;
            }
            if (messageDM instanceof SystemRedactedConversationMessageDM) {
                return MessageViewType.SYSTEM_CONVERSATION_REDACTED_MESSAGE.key;
            }
            return -1;
        }
    }

    public MessageViewDataBinder viewTypeToDataBinder(int i) {
        MessageViewDataBinder messageViewDataBinder = this.viewTypeToDataBinderMap.get(i);
        if (messageViewDataBinder != null) {
            return messageViewDataBinder;
        }
        MessageViewType messageViewType = MessageViewType.getEnum(i);
        if (messageViewType == null) {
            return new AdminMessageViewDataBinder(this.context);
        }
        switch (messageViewType.ordinal()) {
            case 0:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_TEXT_MESSAGE.key, new UserMessageViewDataBinder(this.context));
                break;
            case 1:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_TEXT_MESSAGE.key, new AdminMessageViewDataBinder(this.context));
                break;
            case 2:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_SCREENSHOT_ATTACHMENT.key, new ScreenshotMessageViewDataBinder(this.context));
                break;
            case 3:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_ATTACHMENT_IMAGE.key, new AdminImageAttachmentMessageDataBinder(this.context));
                break;
            case 4:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_ATTACHMENT_GENERIC.key, new AdminAttachmentMessageDataBinder(this.context));
                break;
            case 5:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_REQUEST_ATTACHMENT.key, new RequestScreenshotMessageDataBinder(this.context));
                break;
            case 6:
                this.viewTypeToDataBinderMap.put(MessageViewType.REQUESTED_APP_REVIEW.key, new RequestAppReviewMessageDataBinder(this.context));
                break;
            case 7:
                this.viewTypeToDataBinderMap.put(MessageViewType.REQUEST_FOR_REOPEN.key, new AdminMessageViewDataBinder(this.context));
                break;
            case 8:
                this.viewTypeToDataBinderMap.put(MessageViewType.CONFIRMATION_REJECTED.key, new ConfirmationRejectedMessageDataBinder(this.context));
                break;
            case 11:
                this.viewTypeToDataBinderMap.put(MessageViewType.SYSTEM_DATE.key, new SystemDateMessageDataBinder(this.context));
                break;
            case 12:
                this.viewTypeToDataBinderMap.put(MessageViewType.SYSTEM_DIVIDER.key, new SystemDividerMessageDataBinder(this.context));
                break;
            case 13:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_SELECTABLE_OPTION.key, new UserSelectableOptionViewDataBinder(this.context));
                break;
            case 14:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_SUGGESTIONS_LIST.key, new AdminSuggestionsMessageViewDataBinder(this.context));
                break;
            case 15:
                this.viewTypeToDataBinderMap.put(MessageViewType.SYSTEM_PUBLISH_ID.key, new SystemPublishIdMessageDataBinder(this.context));
                break;
            case 16:
                this.viewTypeToDataBinderMap.put(MessageViewType.SYSTEM_CONVERSATION_REDACTED_MESSAGE.key, new SystemRedactedConversationDataBinder(this.context));
                break;
            case 18:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_REDACTED_MESSAGE.key, new AdminRedactedMessageDataBinder(this.context));
                break;
            case 19:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_REDACTED_MESSAGE.key, new UserRedactedMessageDataBinder(this.context));
                break;
            case 20:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_ATTACHMENT_GENERIC.key, new UserAttachmentMessageViewDataBinder(this.context));
                break;
            case 21:
                this.viewTypeToDataBinderMap.put(MessageViewType.ACTION_CARD_MESSAGE.key, new AdminActionCardMessageViewDataBinder(this.context));
                break;
            case 22:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_SMART_INTENT_MESSAGE.key, new UserSmartIntentMessageViewDataBinder(this.context));
                break;
            case 23:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_CSAT_MESSAGE.key, new AdminCSATMessageViewBinder(this.context));
                break;
            case 24:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_RSP_CSAT_BOT.key, new UserResponseCSATMessageViewDataBinder(this.context));
                break;
        }
        return this.viewTypeToDataBinderMap.get(i);
    }
}
