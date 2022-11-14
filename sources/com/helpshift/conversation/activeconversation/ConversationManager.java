package com.helpshift.conversation.activeconversation;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.bots.BotControlActions;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.idempotent.SuccessOrNonRetriableStatusCodeIdempotentPolicy;
import com.helpshift.common.domain.network.AuthenticationFailureNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardAgainstCSATExpiryNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.IdempotentNetwork;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.PUTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.message.AcceptedAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithTextInputDM;
import com.helpshift.conversation.activeconversation.message.AttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.AutoRetriableMessageDM;
import com.helpshift.conversation.activeconversation.message.AvatarImageDownloader;
import com.helpshift.conversation.activeconversation.message.ConfirmationAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.FollowupAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.FollowupRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.MessageType;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UnsupportedAdminMessageWithInputDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.UserBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageState;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForTextInputDM;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.CSATRatingsInput;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.conversation.util.predicate.MessagePredicates;
import com.helpshift.meta.RootMetaDataCallable;
import com.helpshift.p042db.conversation.tables.MessagesTable;
import com.helpshift.util.Callback;
import com.helpshift.util.FileUtil;
import com.helpshift.util.Filters;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HSObservableList;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import com.swrve.sdk.ISwrveCommon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class ConversationManager {
    public static final String TAG = "Helpshift_ConvManager";
    public ConversationDAO conversationDAO;
    public Domain domain;
    public Platform platform;
    public SDKConfigurationDM sdkConfigurationDM;
    public UserDM userDM;

    /* renamed from: com.helpshift.conversation.activeconversation.ConversationManager$16 */
    public static /* synthetic */ class C252816 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$MessageType */
        public static final /* synthetic */ int[] f3332x18a4a544;
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$conversation$dto$IssueState;

        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|56) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|56) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|53|54|56) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|53|54|56) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|27|28|29|31|32|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|53|54|56) */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0074 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x009b */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.MessageType[] r0 = com.helpshift.conversation.activeconversation.message.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3332x18a4a544 = r0
                r1 = 1
                com.helpshift.conversation.activeconversation.message.MessageType r2 = com.helpshift.conversation.activeconversation.message.MessageType.UNSUPPORTED_ADMIN_MESSAGE_WITH_INPUT     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 18
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r0 = 2
                int[] r2 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x0017 }
                com.helpshift.conversation.activeconversation.message.MessageType r3 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_TEXT     // Catch:{ NoSuchFieldError -> 0x0017 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                r2 = 13
                r3 = 3
                int[] r4 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x0020 }
                com.helpshift.conversation.activeconversation.message.MessageType r5 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_TEXT_WITH_TEXT_INPUT     // Catch:{ NoSuchFieldError -> 0x0020 }
                r4[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0020 }
            L_0x0020:
                r4 = 14
                r5 = 4
                int[] r6 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x0029 }
                com.helpshift.conversation.activeconversation.message.MessageType r7 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_TEXT_WITH_OPTION_INPUT     // Catch:{ NoSuchFieldError -> 0x0029 }
                r6[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                r6 = 5
                int[] r7 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.helpshift.conversation.activeconversation.message.MessageType r8 = com.helpshift.conversation.activeconversation.message.MessageType.FAQ_LIST     // Catch:{ NoSuchFieldError -> 0x0032 }
                r8 = 15
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r7 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x003b }
                com.helpshift.conversation.activeconversation.message.MessageType r8 = com.helpshift.conversation.activeconversation.message.MessageType.FAQ_LIST_WITH_OPTION_INPUT     // Catch:{ NoSuchFieldError -> 0x003b }
                r8 = 16
                r9 = 6
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                r7 = 7
                r8 = 10
                int[] r9 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x0044 }
                com.helpshift.conversation.activeconversation.message.MessageType r10 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0044 }
                r9[r8] = r7     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                r9 = 8
                r10 = 11
                int[] r11 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x004e }
                com.helpshift.conversation.activeconversation.message.MessageType r12 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_IMAGE_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x004e }
                r11[r10] = r9     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                r11 = 9
                r12 = 12
                int[] r13 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.helpshift.conversation.activeconversation.message.MessageType r14 = com.helpshift.conversation.activeconversation.message.MessageType.REQUEST_FOR_REOPEN     // Catch:{ NoSuchFieldError -> 0x0058 }
                r13[r12] = r11     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r13 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x005e }
                com.helpshift.conversation.activeconversation.message.MessageType r14 = com.helpshift.conversation.activeconversation.message.MessageType.REQUESTED_SCREENSHOT     // Catch:{ NoSuchFieldError -> 0x005e }
                r13[r11] = r8     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r11 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.helpshift.conversation.activeconversation.message.MessageType r13 = com.helpshift.conversation.activeconversation.message.MessageType.REQUESTED_APP_REVIEW     // Catch:{ NoSuchFieldError -> 0x0064 }
                r11[r3] = r10     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r10 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x006c }
                com.helpshift.conversation.activeconversation.message.MessageType r11 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_ACTION_CARD     // Catch:{ NoSuchFieldError -> 0x006c }
                r11 = 28
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r10 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.helpshift.conversation.activeconversation.message.MessageType r11 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_CSAT_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0074 }
                r11 = 31
                r10[r11] = r2     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r2 = f3332x18a4a544     // Catch:{ NoSuchFieldError -> 0x007c }
                com.helpshift.conversation.activeconversation.message.MessageType r10 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_RESOLUTION_QUESTION_MESSAGE     // Catch:{ NoSuchFieldError -> 0x007c }
                r10 = 30
                r2[r10] = r4     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                com.helpshift.conversation.dto.IssueState[] r2 = com.helpshift.conversation.dto.IssueState.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$helpshift$conversation$dto$IssueState = r2
                com.helpshift.conversation.dto.IssueState r4 = com.helpshift.conversation.dto.IssueState.ARCHIVED     // Catch:{ NoSuchFieldError -> 0x0089 }
                r2[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r1 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x008f }
                com.helpshift.conversation.dto.IssueState r2 = com.helpshift.conversation.dto.IssueState.RESOLUTION_ACCEPTED     // Catch:{ NoSuchFieldError -> 0x008f }
                r1[r9] = r0     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.REJECTED     // Catch:{ NoSuchFieldError -> 0x0095 }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r0 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x009b }
                com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.COMPLETED_ISSUE_CREATED     // Catch:{ NoSuchFieldError -> 0x009b }
                r0[r7] = r5     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                int[] r0 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.RESOLUTION_REQUESTED     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.activeconversation.ConversationManager.C252816.<clinit>():void");
        }
    }

    public ConversationManager(Platform platform2, Domain domain2, UserDM userDM2) {
        this.platform = platform2;
        this.domain = domain2;
        this.userDM = userDM2;
        this.conversationDAO = platform2.getConversationDAO();
        this.sdkConfigurationDM = domain2.getSDKConfigurationDM();
    }

    private void addMessageToDBAndGlobalList(Conversation conversation, MessageDM messageDM) {
        this.conversationDAO.insertOrUpdateMessage(messageDM);
        messageDM.setDependencies(this.domain, this.platform);
        messageDM.addObserver(conversation);
        conversation.messageDMs.add(messageDM);
    }

    private void addMessageToDbAndUI(Conversation conversation, MessageDM messageDM) {
        this.conversationDAO.insertOrUpdateMessage(messageDM);
        addMessageToUI(conversation, messageDM);
    }

    private boolean canAutoRetryMessage(Conversation conversation, AutoRetriableMessageDM autoRetriableMessageDM) {
        if (!canAutoRetryMessages(conversation) || !autoRetriableMessageDM.isRetriable()) {
            return false;
        }
        if (((autoRetriableMessageDM instanceof ConfirmationAcceptedMessageDM) || (autoRetriableMessageDM instanceof ConfirmationRejectedMessageDM)) && ConversationUtil.isResolutionQuestionExpired(this.platform, conversation)) {
            return false;
        }
        return true;
    }

    private void deleteOptionsForAdminMessageWithOptionsInput(OptionInputMessageDM optionInputMessageDM) {
        if (optionInputMessageDM.referredMessageType == MessageType.ADMIN_TEXT_WITH_OPTION_INPUT) {
            AdminMessageWithOptionInputDM adminMessageWithOptionInputDM = (AdminMessageWithOptionInputDM) this.conversationDAO.readMessage(optionInputMessageDM.serverId);
            adminMessageWithOptionInputDM.input.options.clear();
            this.conversationDAO.insertOrUpdateMessage(adminMessageWithOptionInputDM);
        }
    }

    private MessageDM getMessageDMForUpdate(MessageDM messageDM, Map<String, MessageDM> map, Map<String, MessageDM> map2, ConversationUpdate conversationUpdate) {
        if (map.containsKey(messageDM.serverId)) {
            return map.get(messageDM.serverId);
        }
        if (!map2.containsKey(messageDM.createdRequestId)) {
            return null;
        }
        MessageDM messageDM2 = map2.get(messageDM.createdRequestId);
        conversationUpdate.localIdsForResolvedRequestIds.add(String.valueOf(messageDM2.localId));
        return messageDM2;
    }

    private String getRouteForSendingMessage(Conversation conversation) {
        if (conversation.isInPreIssueMode()) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(ConversationController.CREATE_PRE_ISSUE_ROUTE);
            outline24.append(conversation.getPreIssueId());
            outline24.append("/messages/");
            return outline24.toString();
        }
        StringBuilder outline242 = GeneratedOutlineSupport.outline24(ConversationController.CREATE_ISSUE_ROUTE);
        outline242.append(conversation.getIssueId());
        outline242.append("/messages/");
        return outline242.toString();
    }

    private boolean handleConversationErrorUpdate(Conversation conversation, RootAPIException rootAPIException) {
        ExceptionType exceptionType = rootAPIException.exceptionType;
        if (exceptionType == NetworkException.CONVERSATION_ARCHIVED) {
            updateIssueStatus(conversation, IssueState.ARCHIVED);
        } else if (exceptionType == NetworkException.USER_PRE_CONDITION_FAILED) {
            updateIssueStatus(conversation, IssueState.AUTHOR_MISMATCH);
        } else if (exceptionType != NetworkException.CONVERSATION_REOPEN_EXPIRED) {
            return false;
        } else {
            markConversationStateToResolutionExpired(conversation);
        }
        return true;
    }

    private void markSeenMessagesAsRead(Conversation conversation, Set<Long> set) {
        String str = (String) HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform).first;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = conversation.messageDMs.iterator();
        while (it.hasNext()) {
            MessageDM messageDM = (MessageDM) it.next();
            Long l = messageDM.localId;
            if (l != null) {
                hashMap.put(l, messageDM);
            }
        }
        for (Long l2 : set) {
            MessageDM messageDM2 = (MessageDM) hashMap.get(l2);
            if (messageDM2 != null) {
                messageDM2.readAt = str;
                messageDM2.deliveryState = 1;
                messageDM2.seenAtMessageCursor = conversation.messageCursor;
                arrayList.add(messageDM2);
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.conversationDAO.insertOrUpdateMessages(arrayList);
            markMessagesAsSeen(conversation, arrayList);
        }
    }

    private void populateMessageDMLookup(Conversation conversation, Map<String, MessageDM> map, Map<String, MessageDM> map2) {
        ArrayList arrayList = new ArrayList();
        List<MessageDM> data = this.conversationDAO.readMessages(conversation.localId.longValue()).getData();
        HashMap hashMap = new HashMap();
        Iterator<E> it = conversation.messageDMs.iterator();
        while (it.hasNext()) {
            MessageDM messageDM = (MessageDM) it.next();
            Long l = messageDM.localId;
            if (l != null) {
                hashMap.put(l, messageDM);
            }
        }
        for (MessageDM messageDM2 : data) {
            MessageDM messageDM3 = (MessageDM) hashMap.get(messageDM2.localId);
            if (messageDM3 == null) {
                arrayList.add(messageDM2);
            } else {
                arrayList.add(messageDM3);
            }
        }
        Iterator it2 = arrayList.iterator();
        Map<String, String> messagesLocalIdToPendingRequestIdMap = getMessagesLocalIdToPendingRequestIdMap(conversation);
        while (it2.hasNext()) {
            MessageDM messageDM4 = (MessageDM) it2.next();
            if (!StringUtils.isEmpty(messageDM4.serverId)) {
                map.put(messageDM4.serverId, messageDM4);
            }
            Long l2 = messageDM4.localId;
            if (l2 != null) {
                String valueOf = String.valueOf(l2);
                if (messagesLocalIdToPendingRequestIdMap != null && messagesLocalIdToPendingRequestIdMap.containsKey(valueOf)) {
                    map2.put(messagesLocalIdToPendingRequestIdMap.get(valueOf), messageDM4);
                }
            }
        }
    }

    private void sendAttachmentMessageInternal(final Conversation conversation, UserAttachmentMessageDM userAttachmentMessageDM) {
        userAttachmentMessageDM.uploadAttachment(this.userDM, conversation, new Callback<Void, RootAPIException>() {
            public void onFailure(RootAPIException rootAPIException) {
                ExceptionType exceptionType = rootAPIException.exceptionType;
                if (exceptionType == NetworkException.CONVERSATION_REOPEN_EXPIRED) {
                    ConversationManager.this.markConversationStateToResolutionExpired(conversation);
                } else if (exceptionType == NetworkException.CONVERSATION_ARCHIVED) {
                    ConversationManager.this.updateIssueStatus(conversation, IssueState.ARCHIVED);
                }
            }

            public void onSuccess(Void voidR) {
                Conversation conversation = conversation;
                if (conversation.state == IssueState.RESOLUTION_REJECTED) {
                    ConversationManager.this.updateIssueStatus(conversation, IssueState.WAITING_FOR_AGENT);
                }
            }
        });
    }

    private void sendGenericAttachment(Conversation conversation, AttachmentPickerFile attachmentPickerFile) {
        int i;
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        String str = (String) currentAdjustedTimeForStorage.first;
        long longValue = ((Long) currentAdjustedTimeForStorage.second).longValue();
        Long l = attachmentPickerFile.originalFileSize;
        if (l == null) {
            i = 0;
        } else {
            i = l.intValue();
        }
        UserAttachmentMessageDM userAttachmentMessageDM = new UserAttachmentMessageDM((String) null, str, longValue, new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER), i, (String) null, (String) null, attachmentPickerFile.originalFileName, false);
        userAttachmentMessageDM.filePath = attachmentPickerFile.filePath;
        userAttachmentMessageDM.updateState(shouldEnableMessagesClick(conversation));
        userAttachmentMessageDM.conversationLocalId = conversation.localId;
        addMessageToDbAndUI(conversation, userAttachmentMessageDM);
        sendAttachmentMessageInternal(conversation, userAttachmentMessageDM);
    }

    private void sendMessageWithAutoRetry(final C2500F f) {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    f.mo33949f();
                } catch (RootAPIException e) {
                    ExceptionType exceptionType = e.exceptionType;
                    if (exceptionType != NetworkException.NON_RETRIABLE && exceptionType != NetworkException.USER_PRE_CONDITION_FAILED) {
                        ConversationManager.this.domain.getAutoRetryFailedEventDM().scheduleRetryTaskForEventType(AutoRetryFailedEventDM.EventType.CONVERSATION, e.getServerStatusCode());
                        throw e;
                    }
                }
            }
        });
    }

    private void sendReOpenRejectedMessage(final Conversation conversation, int i, String str, String str2) {
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        final FollowupRejectedMessageDM followupRejectedMessageDM = new FollowupRejectedMessageDM((String) null, (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER), str2, 1);
        followupRejectedMessageDM.reason = i;
        followupRejectedMessageDM.openConversationId = str;
        followupRejectedMessageDM.conversationLocalId = conversation.localId;
        followupRejectedMessageDM.setDependencies(this.domain, this.platform);
        addMessageToDBAndGlobalList(conversation, followupRejectedMessageDM);
        sendMessageWithAutoRetry(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                followupRejectedMessageDM.send(ConversationManager.this.userDM, conversation);
            }
        });
    }

    private void sendScreenshotMessageInternal(final Conversation conversation, ScreenshotMessageDM screenshotMessageDM, boolean z) {
        screenshotMessageDM.uploadImage(this.userDM, conversation, z, new Callback<Void, RootAPIException>() {
            public void onFailure(RootAPIException rootAPIException) {
                ExceptionType exceptionType = rootAPIException.exceptionType;
                if (exceptionType == NetworkException.CONVERSATION_REOPEN_EXPIRED) {
                    ConversationManager.this.markConversationStateToResolutionExpired(conversation);
                } else if (exceptionType == NetworkException.CONVERSATION_ARCHIVED) {
                    ConversationManager.this.updateIssueStatus(conversation, IssueState.ARCHIVED);
                }
            }

            public void onSuccess(Void voidR) {
                Conversation conversation = conversation;
                if (conversation.state == IssueState.RESOLUTION_REJECTED) {
                    ConversationManager.this.updateIssueStatus(conversation, IssueState.WAITING_FOR_AGENT);
                }
            }
        });
    }

    private void setCSATState(Conversation conversation, ConversationCSATState conversationCSATState) {
        if (conversation.csatState != conversationCSATState) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Update CSAT state : Conversation : ");
            outline24.append(conversation.serverId);
            outline24.append(", state : ");
            outline24.append(conversationCSATState.toString());
            HSLogger.m3237d(TAG, outline24.toString());
        }
        conversation.csatState = conversationCSATState;
        this.conversationDAO.updateConversationWithoutMessages(conversation);
    }

    private void updateMessageClickableState(MessageDM messageDM, boolean z) {
        if (messageDM instanceof UserMessageDM) {
            ((UserMessageDM) messageDM).updateState(z);
        } else if (messageDM instanceof RequestScreenshotMessageDM) {
            ((RequestScreenshotMessageDM) messageDM).setAttachmentButtonClickable(z);
        } else if (messageDM instanceof ScreenshotMessageDM) {
            ((ScreenshotMessageDM) messageDM).updateState(z);
        } else if (messageDM instanceof UserAttachmentMessageDM) {
            ((UserAttachmentMessageDM) messageDM).updateState(z);
        }
    }

    public void addMessageToUI(Conversation conversation, MessageDM messageDM) {
        messageDM.setDependencies(this.domain, this.platform);
        if (messageDM.isUISupportedMessage()) {
            messageDM.addObserver(conversation);
            conversation.messageDMs.add(messageDM);
            ConversationUtil.sortMessagesBasedOnCreatedAt(conversation.messageDMs);
        }
    }

    public void addPreissueFirstUserMessage(Conversation conversation, String str) {
        HSLogger.m3237d(TAG, "Adding first user message to DB and UI.");
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        UserMessageDM userMessageDM = new UserMessageDM(str, (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER));
        userMessageDM.setDependencies(this.domain, this.platform);
        userMessageDM.conversationLocalId = conversation.localId;
        userMessageDM.setState(UserMessageState.SENDING);
        addMessageToDbAndUI(conversation, userMessageDM);
    }

    public void addPreissueFirstUserMessageViaSmartIntent(Conversation conversation, List<String> list) {
        HSLogger.m3237d(TAG, "Adding first user message via smart intent to DB and UI.");
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        UserSmartIntentMessageDM userSmartIntentMessageDM = new UserSmartIntentMessageDM(list, (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER));
        userSmartIntentMessageDM.setDependencies(this.domain, this.platform);
        userSmartIntentMessageDM.conversationLocalId = conversation.localId;
        userSmartIntentMessageDM.setState(UserMessageState.SENDING);
        addMessageToDbAndUI(conversation, userSmartIntentMessageDM);
    }

    public boolean canAutoRetryMessages(Conversation conversation) {
        IssueState issueState = conversation.state;
        return (issueState == IssueState.ARCHIVED || issueState == IssueState.AUTHOR_MISMATCH) ? false : true;
    }

    public void checkAndReopen(final Conversation conversation, RequestForReopenMessageDM requestForReopenMessageDM, int i, String str, boolean z) {
        if (i == 1) {
            sendReOpenRejectedMessage(conversation, 1, (String) null, requestForReopenMessageDM.serverId);
        } else if (z) {
            sendReOpenRejectedMessage(conversation, 4, (String) null, requestForReopenMessageDM.serverId);
        } else if (ConversationUtil.isInProgressState(conversation.state) || (conversation.state == IssueState.RESOLUTION_REJECTED && i == 2)) {
            sendReOpenRejectedMessage(conversation, 3, (String) null, requestForReopenMessageDM.serverId);
        } else if (str == null || str.equals(conversation.serverId)) {
            conversation.state = IssueState.WAITING_FOR_AGENT;
            conversation.isConversationEndedDelegateSent = false;
            this.conversationDAO.updateConversationWithoutMessages(conversation);
            ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
            final FollowupAcceptedMessageDM followupAcceptedMessageDM = new FollowupAcceptedMessageDM((String) null, (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER), requestForReopenMessageDM.serverId, 1);
            followupAcceptedMessageDM.conversationLocalId = conversation.localId;
            followupAcceptedMessageDM.setDependencies(this.domain, this.platform);
            addMessageToDBAndGlobalList(conversation, followupAcceptedMessageDM);
            requestForReopenMessageDM.setAnsweredAndNotify(true);
            this.conversationDAO.insertOrUpdateMessage(requestForReopenMessageDM);
            sendMessageWithAutoRetry(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    followupAcceptedMessageDM.send(ConversationManager.this.userDM, conversation);
                }
            });
        } else {
            sendReOpenRejectedMessage(conversation, 2, str, requestForReopenMessageDM.serverId);
        }
    }

    public void clearRedactedAttachmentsResources(final List<MessageDM> list) {
        if (list.size() != 0) {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    for (MessageDM messageDM : list) {
                        try {
                            if (messageDM instanceof AttachmentMessageDM) {
                                AttachmentMessageDM attachmentMessageDM = (AttachmentMessageDM) messageDM;
                                if (FileUtil.deleteFile(attachmentMessageDM.filePath)) {
                                    attachmentMessageDM.filePath = null;
                                }
                            } else if (messageDM instanceof AdminActionCardMessageDM) {
                                AdminActionCardMessageDM adminActionCardMessageDM = (AdminActionCardMessageDM) messageDM;
                                if (FileUtil.deleteFile(adminActionCardMessageDM.actionCard.filePath)) {
                                    adminActionCardMessageDM.actionCard.filePath = null;
                                }
                            }
                        } catch (Exception e) {
                            HSLogger.m3242e(ConversationManager.TAG, "Exception while deleting redacted AttachmentMessageDM file", e);
                        }
                    }
                }
            });
        }
    }

    public void clearRequestIdForPendingCreateConversationCalls(List<Conversation> list) {
        if (!ListUtils.isEmpty(list)) {
            String pendingRequestId = this.platform.getNetworkRequestDAO().getPendingRequestId(ConversationController.CREATE_ISSUE_ROUTE, ConversationController.CREATE_ISSUE_UNIQUE_MAPPING_KEY);
            String pendingRequestId2 = this.platform.getNetworkRequestDAO().getPendingRequestId(ConversationController.CREATE_PRE_ISSUE_ROUTE, ConversationController.CREATE_PRE_ISSUE_UNIQUE_MAPPING_KEY);
            if (pendingRequestId != null || pendingRequestId2 != null) {
                for (Conversation next : list) {
                    String str = next.createdRequestId;
                    if (str != null) {
                        if (str.equals(pendingRequestId)) {
                            this.platform.getNetworkRequestDAO().deletePendingRequestId(ConversationController.CREATE_ISSUE_ROUTE, ConversationController.CREATE_ISSUE_UNIQUE_MAPPING_KEY);
                        } else if (next.createdRequestId.equals(pendingRequestId2)) {
                            this.platform.getNetworkRequestDAO().deletePendingRequestId(ConversationController.CREATE_PRE_ISSUE_ROUTE, ConversationController.CREATE_PRE_ISSUE_UNIQUE_MAPPING_KEY);
                        }
                    }
                }
            }
        }
    }

    public void clearRequestIdForPendingSendMessageCalls(Conversation conversation, List<MessageDM> list) {
        if (!ListUtils.isEmpty(list)) {
            String routeForSendingMessage = getRouteForSendingMessage(conversation);
            if (getMessagesLocalIdToPendingRequestIdMap(conversation) != null) {
                for (MessageDM messageDM : list) {
                    this.platform.getNetworkRequestDAO().deletePendingRequestId(routeForSendingMessage, String.valueOf(messageDM.localId));
                }
            }
        }
    }

    public boolean containsAtleastOneUserMessage(Conversation conversation) {
        if (!conversation.isInPreIssueMode()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = conversation.messageDMs.iterator();
        while (it.hasNext()) {
            MessageDM messageDM = (MessageDM) it.next();
            if (messageDM.isUISupportedMessage()) {
                if (messageDM instanceof UserMessageDM) {
                    return true;
                }
                arrayList.add(messageDM);
                if (arrayList.size() > 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteCachedAttachmentFiles(Conversation conversation) {
        ArrayList arrayList = new ArrayList();
        for (MessageDM messageDM : this.conversationDAO.readMessages(conversation.localId.longValue()).getData()) {
            if (messageDM instanceof ScreenshotMessageDM) {
                ScreenshotMessageDM screenshotMessageDM = (ScreenshotMessageDM) messageDM;
                try {
                    if (FileUtil.deleteFile(screenshotMessageDM.getFilePath())) {
                        screenshotMessageDM.filePath = null;
                        arrayList.add(screenshotMessageDM);
                    }
                } catch (Exception e) {
                    HSLogger.m3242e(TAG, "Exception while deleting ScreenshotMessageDM file", e);
                }
            } else if (messageDM instanceof UserAttachmentMessageDM) {
                UserAttachmentMessageDM userAttachmentMessageDM = (UserAttachmentMessageDM) messageDM;
                try {
                    if (FileUtil.deleteFile(userAttachmentMessageDM.getFilePath())) {
                        userAttachmentMessageDM.filePath = null;
                        arrayList.add(userAttachmentMessageDM);
                    }
                } catch (Exception e2) {
                    HSLogger.m3242e(TAG, "Exception while deleting UserAttachmentMessageDM file", e2);
                }
            }
            if (messageDM instanceof AdminActionCardMessageDM) {
                AdminActionCardMessageDM adminActionCardMessageDM = (AdminActionCardMessageDM) messageDM;
                try {
                    if (FileUtil.deleteFile(adminActionCardMessageDM.actionCard.filePath)) {
                        adminActionCardMessageDM.actionCard.filePath = null;
                        arrayList.add(adminActionCardMessageDM);
                    }
                } catch (Exception e3) {
                    HSLogger.m3242e(TAG, "Exception while deleting AdminActionCardMessageDM file", e3);
                }
            }
        }
        this.conversationDAO.insertOrUpdateMessages(arrayList);
    }

    public void downloadAvatarImage(final MessageDM messageDM) {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationManager conversationManager = ConversationManager.this;
                AvatarImageDownloader.downloadAvatarImage(conversationManager.platform, conversationManager.domain, messageDM);
            }
        });
    }

    public void dropCustomMetaData() {
        this.domain.getMetaDataDM().setCustomMetaDataCallable((RootMetaDataCallable) null);
        this.domain.getMetaDataDM().clearCustomMetaData();
    }

    public void evaluateBotControlMessages(Conversation conversation, Collection<? extends MessageDM> collection) {
        final Conversation conversation2 = conversation;
        for (MessageDM messageDM : collection) {
            if (messageDM.messageType.ordinal() == 18) {
                ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
                UnsupportedAdminMessageWithInputDM unsupportedAdminMessageWithInputDM = (UnsupportedAdminMessageWithInputDM) messageDM;
                final UserBotControlMessageDM userBotControlMessageDM = new UserBotControlMessageDM("Unsupported bot input", (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER), BotControlActions.BOT_CANCELLED, BotControlActions.UNSUPPORTED_BOT_INPUT, unsupportedAdminMessageWithInputDM.botInfo, unsupportedAdminMessageWithInputDM.serverId, 1);
                userBotControlMessageDM.conversationLocalId = conversation2.localId;
                addMessageToDbAndUI(conversation2, userBotControlMessageDM);
                sendMessageWithAutoRetry(new C2500F() {
                    /* renamed from: f */
                    public void mo33949f() {
                        userBotControlMessageDM.send(ConversationManager.this.userDM, conversation2);
                    }
                });
            }
        }
    }

    public boolean evaluateBotExecutionState(List<MessageDM> list, boolean z) {
        if (!(list == null || list.size() == 0)) {
            for (int size = list.size() - 1; size >= 0; size--) {
                MessageDM messageDM = list.get(size);
                if (MessageType.ADMIN_BOT_CONTROL == messageDM.messageType) {
                    AdminBotControlMessageDM adminBotControlMessageDM = (AdminBotControlMessageDM) messageDM;
                    String str = adminBotControlMessageDM.actionType;
                    if (BotControlActions.BOT_STARTED.equals(str)) {
                        return true;
                    }
                    if (BotControlActions.BOT_ENDED.equals(str)) {
                        return adminBotControlMessageDM.hasNextBot;
                    }
                }
            }
        }
        return z;
    }

    public boolean filterMessagesOlderThanLastMessageInDb(Conversation conversation) {
        String oldestMessageCursor = this.conversationDAO.getOldestMessageCursor(this.userDM.getLocalId().longValue());
        boolean z = false;
        if (!StringUtils.isEmpty(oldestMessageCursor)) {
            List<MessageDM> filter = Filters.filter(conversation.messageDMs, MessagePredicates.olderThanLastDbMessagePredicate(HSDateFormatSpec.convertToEpochTime(oldestMessageCursor)));
            int size = conversation.messageDMs.size();
            int size2 = filter.size();
            if (size != 0 && size2 == 0) {
                z = true;
            }
            if (size != size2) {
                conversation.setMessageDMs(filter);
            }
        }
        return z;
    }

    public MessageDM getLatestUnansweredBotMessage(Conversation conversation) {
        MessageDM messageDM;
        MessageType messageType;
        boolean z = true;
        for (int size = conversation.messageDMs.size() - 1; size >= 0 && (messageType = messageDM.messageType) != MessageType.ADMIN_BOT_CONTROL; size--) {
            if (messageType == MessageType.ADMIN_TEXT_WITH_TEXT_INPUT || messageType == MessageType.ADMIN_TEXT_WITH_OPTION_INPUT || messageType == MessageType.FAQ_LIST_WITH_OPTION_INPUT || messageType == MessageType.ADMIN_RESOLUTION_QUESTION_MESSAGE || messageType == MessageType.OPTION_INPUT || messageType == MessageType.ADMIN_CSAT_MESSAGE) {
                int i = size + 1;
                while (true) {
                    if (i >= conversation.messageDMs.size()) {
                        z = false;
                        break;
                    }
                    MessageDM messageDM2 = (MessageDM) conversation.messageDMs.get(i);
                    MessageType messageType2 = messageDM2.messageType;
                    if ((messageType2 == MessageType.USER_RESP_FOR_OPTION_INPUT || messageType2 == MessageType.USER_RESP_FOR_TEXT_INPUT) && (messageDM = (MessageDM) conversation.messageDMs.get(size)).serverId.equals(((UserMessageDM) messageDM2).getReferredMessageId())) {
                        break;
                    }
                    i++;
                }
                if (z) {
                    return null;
                }
                return messageDM;
            }
        }
        return null;
    }

    public Map<String, String> getMessagesLocalIdToPendingRequestIdMap(Conversation conversation) {
        return this.platform.getNetworkRequestDAO().getPendingRequestIdMapForRoute(getRouteForSendingMessage(conversation));
    }

    public int getUnSeenMessageCount(Conversation conversation) {
        int i = 0;
        if (!shouldOpen(conversation)) {
            return 0;
        }
        List<MessageDM> data = this.conversationDAO.readMessages(conversation.localId.longValue()).getData();
        if (data != null) {
            for (MessageDM messageDM : data) {
                if (messageDM.isUISupportedMessage() && messageDM.deliveryState != 1) {
                    int ordinal = messageDM.messageType.ordinal();
                    if (!(ordinal == 1 || ordinal == 3 || ordinal == 30 || ordinal == 31)) {
                        switch (ordinal) {
                            case 13:
                                if (messageDM instanceof AdminMessageWithTextInputDM) {
                                    if (((AdminMessageWithTextInputDM) messageDM).isMessageEmpty) {
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 14:
                            case 15:
                            case 16:
                                i++;
                                break;
                        }
                    }
                    i++;
                }
            }
        }
        return conversation.shouldIncrementMessageCount ? i + 1 : i;
    }

    public void handleAdminSuggestedQuestionRead(Conversation conversation, FAQListMessageDM fAQListMessageDM, String str, String str2) {
        final FAQListMessageDM fAQListMessageDM2 = fAQListMessageDM;
        final Conversation conversation2 = conversation;
        final String str3 = str;
        final String str4 = str2;
        sendMessageWithAutoRetry(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                fAQListMessageDM2.handleSuggestionClick(conversation2, ConversationManager.this.userDM, str3, str4);
            }
        });
    }

    public void handleAppReviewRequestClick(final Conversation conversation, final RequestAppReviewMessageDM requestAppReviewMessageDM) {
        final AcceptedAppReviewMessageDM handleRequestReviewClick = requestAppReviewMessageDM.handleRequestReviewClick(this.domain, this.platform);
        if (handleRequestReviewClick != null) {
            sendMessageWithAutoRetry(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    try {
                        handleRequestReviewClick.send(ConversationManager.this.userDM, conversation);
                        requestAppReviewMessageDM.handleAcceptedReviewSuccess(ConversationManager.this.platform);
                    } catch (RootAPIException e) {
                        if (e.exceptionType == NetworkException.CONVERSATION_ARCHIVED) {
                            ConversationManager.this.updateIssueStatus(conversation, IssueState.ARCHIVED);
                        } else {
                            requestAppReviewMessageDM.setIsReviewButtonClickable(true);
                            throw e;
                        }
                    }
                }
            });
        }
    }

    public void handleConversationEnded(final Conversation conversation) {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationManager.this.deleteOptionsForAdminMessageWithOptionsInput(conversation);
                ConversationManager.this.sendConversationEndedDelegate(conversation);
            }
        });
    }

    public void handlePreIssueCreationSuccess(Conversation conversation) {
        conversation.lastUserActivityTime = System.currentTimeMillis();
        sendMessageAddedEventOnPreissueCreation(conversation);
    }

    public boolean hasBotSwitchedToAnotherBotInPollerResponse(Collection<? extends MessageDM> collection) {
        if (!(collection == null || collection.size() == 0)) {
            ArrayList arrayList = new ArrayList(collection);
            boolean z = false;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                MessageDM messageDM = (MessageDM) arrayList.get(size);
                if (MessageType.ADMIN_BOT_CONTROL == messageDM.messageType) {
                    String str = ((AdminBotControlMessageDM) messageDM).actionType;
                    if (BotControlActions.BOT_ENDED.equals(str)) {
                        return z;
                    }
                    if (BotControlActions.BOT_STARTED.equals(str)) {
                        z = true;
                    }
                }
            }
        }
        return false;
    }

    public void initializeHistoryMessageListForUI(Conversation conversation, boolean z) {
        removeFeedbackMessagesFromConversations(conversation);
        Iterator<E> it = conversation.messageDMs.iterator();
        while (it.hasNext()) {
            MessageDM messageDM = (MessageDM) it.next();
            messageDM.setDependencies(this.domain, this.platform);
            updateMessageOnConversationUpdate(messageDM, z);
            updateAcceptedRequestForReopenMessageDMs(conversation, messageDM);
        }
    }

    public void initializeIssueStatusForUI(Conversation conversation) {
        if (conversation.state == IssueState.RESOLUTION_REQUESTED && !conversation.isFeedbackBotEnabled && !this.sdkConfigurationDM.shouldShowConversationResolutionQuestion()) {
            markConversationResolutionStatus(conversation, true);
        }
    }

    public void initializeMessagesForUI(Conversation conversation, boolean z) {
        ConversationUtil.sortMessagesBasedOnCreatedAt(conversation.messageDMs);
        if (z) {
            conversation.isInBetweenBotExecution = evaluateBotExecutionState(conversation.messageDMs, false);
            Iterator<E> it = conversation.messageDMs.iterator();
            while (it.hasNext()) {
                MessageDM messageDM = (MessageDM) it.next();
                messageDM.setDependencies(this.domain, this.platform);
                if (messageDM instanceof AdminImageAttachmentMessageDM) {
                    ((AdminImageAttachmentMessageDM) messageDM).downloadThumbnailImage(this.platform);
                }
                if (messageDM instanceof AdminActionCardMessageDM) {
                    ((AdminActionCardMessageDM) messageDM).downloadImage(this.platform);
                }
                updateMessageOnConversationUpdate(messageDM, shouldEnableMessagesClick(conversation));
                updateAcceptedRequestForReopenMessageDMs(conversation, messageDM);
            }
            if (conversation.messageDMs.size() > 0 && (conversation.isIssueInProgress() || (conversation.isFeedbackBotEnabled && conversation.state == IssueState.RESOLUTION_REQUESTED))) {
                HSObservableList<MessageDM> hSObservableList = conversation.messageDMs;
                MessageDM messageDM2 = (MessageDM) hSObservableList.get(hSObservableList.size() - 1);
                MessageType messageType = messageDM2.messageType;
                if (messageType == MessageType.USER_RESP_FOR_OPTION_INPUT || messageType == MessageType.USER_RESP_FOR_TEXT_INPUT || messageType == MessageType.USER_RESP_FOR_CSAT) {
                    MessageDM latestUnansweredBotMessage = getLatestUnansweredBotMessage(conversation);
                    if (conversation.isInBetweenBotExecution && latestUnansweredBotMessage == null) {
                        ((UserMessageDM) messageDM2).updateState(true);
                    }
                }
            }
        } else {
            Iterator<E> it2 = conversation.messageDMs.iterator();
            while (it2.hasNext()) {
                MessageDM messageDM3 = (MessageDM) it2.next();
                messageDM3.setDependencies(this.domain, this.platform);
                if (messageDM3 instanceof AdminImageAttachmentMessageDM) {
                    ((AdminImageAttachmentMessageDM) messageDM3).downloadThumbnailImage(this.platform);
                }
                if (messageDM3 instanceof AdminActionCardMessageDM) {
                    ((AdminActionCardMessageDM) messageDM3).downloadImage(this.platform);
                }
                updateMessageOnConversationUpdate(messageDM3, false);
            }
        }
        ListIterator<E> listIterator = conversation.messageDMs.listIterator();
        while (listIterator.hasNext()) {
            MessageDM messageDM4 = (MessageDM) listIterator.next();
            if ((messageDM4 instanceof AdminCSATMessageWithOptions) && (!z || conversation.messageDMs.indexOf(messageDM4) != conversation.messageDMs.size() - 1)) {
                listIterator.remove();
            }
        }
    }

    public boolean isConversationActionable(Conversation conversation, boolean z) {
        IssueState issueState;
        if (conversation == null || !isSynced(conversation)) {
            return false;
        }
        if ((conversation.isInPreIssueMode() && StringUtils.isNotEmpty(conversation.preConversationServerId) && conversation.isIssueInProgress()) || conversation.isIssueInProgress() || (issueState = conversation.state) == IssueState.RESOLUTION_REQUESTED) {
            return true;
        }
        if (issueState != IssueState.RESOLUTION_REJECTED || !z) {
            return false;
        }
        return true;
    }

    public boolean isSynced(Conversation conversation) {
        return !StringUtils.isEmpty(conversation.serverId) || !StringUtils.isEmpty(conversation.preConversationServerId);
    }

    public void markConversationCSATStateToExpired(Conversation conversation) {
        ConversationCSATState conversationCSATState = conversation.csatState;
        ConversationCSATState conversationCSATState2 = ConversationCSATState.EXPIRED;
        if (conversationCSATState != conversationCSATState2) {
            setCSATState(conversation, conversationCSATState2);
            sendCSATExpiryEvent(conversation);
        }
    }

    public void markConversationResolutionStatus(final Conversation conversation, boolean z) {
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        String str = (String) currentAdjustedTimeForStorage.first;
        long longValue = ((Long) currentAdjustedTimeForStorage.second).longValue();
        if (z) {
            sendConfirmationAcceptedMessageAndDelegates(conversation);
            updateIssueStatus(conversation, IssueState.RESOLUTION_ACCEPTED);
            return;
        }
        final ConfirmationRejectedMessageDM confirmationRejectedMessageDM = new ConfirmationRejectedMessageDM("Did not accept the solution", str, longValue, new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.SYSTEM), 1);
        confirmationRejectedMessageDM.conversationLocalId = conversation.localId;
        addMessageToDbAndUI(conversation, confirmationRejectedMessageDM);
        sendMessageWithAutoRetry(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    confirmationRejectedMessageDM.send(ConversationManager.this.userDM, conversation);
                } catch (RootAPIException e) {
                    ExceptionType exceptionType = e.exceptionType;
                    if (exceptionType == NetworkException.CONVERSATION_ARCHIVED) {
                        ConversationManager.this.updateIssueStatus(conversation, IssueState.ARCHIVED);
                    } else if (exceptionType == NetworkException.CONVERSATION_REOPEN_EXPIRED) {
                        ConversationManager.this.markConversationStateToResolutionExpired(conversation);
                    } else {
                        throw e;
                    }
                }
            }
        });
        updateIssueStatus(conversation, IssueState.RESOLUTION_REJECTED);
        HashMap hashMap = new HashMap();
        hashMap.put("id", conversation.serverId);
        if (StringUtils.isNotEmpty(conversation.acid)) {
            hashMap.put("acid", conversation.acid);
        }
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.RESOLUTION_REJECTED, (Map<String, Object>) hashMap);
        this.domain.getDelegate().userRepliedToConversation("User rejected the solution");
    }

    public void markConversationStateToResolutionExpired(Conversation conversation) {
        IssueState issueState = conversation.state;
        IssueState issueState2 = IssueState.RESOLUTION_EXPIRED;
        if (issueState != issueState2) {
            updateIssueStatus(conversation, issueState2);
            sendResolutionQuestionExpiryEvent(conversation);
            handleConversationEnded(conversation);
        }
    }

    public void markMessagesAsSeen(Conversation conversation) {
        HashSet hashSet = new HashSet();
        for (MessageDM messageDM : this.conversationDAO.readMessages(conversation.localId.longValue()).getData()) {
            if (messageDM.deliveryState != 1) {
                int ordinal = messageDM.messageType.ordinal();
                if (!(ordinal == 1 || ordinal == 3 || ordinal == 28 || ordinal == 30 || ordinal == 31)) {
                    switch (ordinal) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                            break;
                    }
                }
                hashSet.add(messageDM.localId);
            }
        }
        if (hashSet.size() != 0) {
            markSeenMessagesAsRead(conversation, hashSet);
        }
    }

    public void mergeIssue(Conversation conversation, Conversation conversation2, boolean z, ConversationUpdate conversationUpdate) {
        IssueState issueState = conversation2.state;
        IssueState issueState2 = conversation.state;
        if (conversation2.shouldAllowNewConversationCreation) {
            issueState = IssueState.CLOSED;
        } else if (!conversation2.isFeedbackBotEnabled && issueState == IssueState.RESOLUTION_REQUESTED && (issueState2 == IssueState.RESOLUTION_ACCEPTED || issueState2 == IssueState.RESOLUTION_REJECTED || issueState2 == IssueState.RESOLUTION_EXPIRED)) {
            issueState = issueState2;
        }
        String str = conversation2.messageCursor;
        if (str != null) {
            conversation.messageCursor = str;
        }
        conversation.serverId = conversation2.serverId;
        conversation.preConversationServerId = conversation2.preConversationServerId;
        conversation.issueType = conversation2.issueType;
        conversation.title = conversation2.title;
        conversation.publishId = conversation2.publishId;
        conversation.createdAt = conversation2.createdAt;
        conversation.epochCreatedAtTime = conversation2.getEpochCreatedAtTime();
        conversation.isRedacted = conversation2.isRedacted;
        conversation.resolutionExpiryAt = conversation2.resolutionExpiryAt;
        conversation.csatExpiryAt = conversation2.csatExpiryAt;
        conversation.updatedAt = conversation2.updatedAt;
        conversation.state = issueState;
        conversation.isFeedbackBotEnabled = conversation2.isFeedbackBotEnabled;
        conversation.shouldAllowNewConversationCreation = conversation2.shouldAllowNewConversationCreation;
        ConversationCSATState conversationCSATState = conversation2.csatState;
        if (conversationCSATState == ConversationCSATState.SUBMITTED_SYNCED) {
            conversation.csatState = conversationCSATState;
        } else if (ConversationUtil.isCSATTimerExpired(this.platform, conversation)) {
            conversation.csatState = ConversationCSATState.EXPIRED;
        }
        updateMessageDMs(conversation, z, conversation2.messageDMs, conversationUpdate);
    }

    public void mergePreIssue(Conversation conversation, Conversation conversation2, boolean z, ConversationUpdate conversationUpdate) {
        IssueState issueState = conversation2.state;
        int ordinal = issueState.ordinal();
        if (ordinal == 4) {
            issueState = IssueState.RESOLUTION_ACCEPTED;
        } else if (ordinal == 7) {
            issueState = IssueState.COMPLETED_ISSUE_CREATED;
            conversation.serverId = conversation2.serverId;
        }
        String str = conversation2.messageCursor;
        if (str != null) {
            conversation.messageCursor = str;
        }
        conversation.preConversationServerId = conversation2.preConversationServerId;
        conversation.serverId = conversation2.serverId;
        conversation.issueType = conversation2.issueType;
        conversation.title = conversation2.title;
        conversation.publishId = conversation2.publishId;
        conversation.createdAt = conversation2.createdAt;
        conversation.epochCreatedAtTime = conversation2.getEpochCreatedAtTime();
        conversation.updatedAt = conversation2.updatedAt;
        conversation.state = issueState;
        updateMessageDMs(conversation, z, conversation2.messageDMs, conversationUpdate);
    }

    public void refreshConversationOnIssueStateUpdate(Conversation conversation) {
        int ordinal = conversation.state.ordinal();
        if (ordinal == 5 || ordinal == 8) {
            handleConversationEnded(conversation);
        } else if (ordinal == 10) {
            ArrayList arrayList = new ArrayList();
            for (MessageDM messageDM : this.conversationDAO.readMessages(conversation.localId.longValue()).getData()) {
                if ((messageDM instanceof UserMessageDM) && messageDM.serverId == null) {
                    arrayList.add((UserMessageDM) messageDM);
                }
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append(((UserMessageDM) it.next()).body);
                sb.append("\n");
            }
            this.platform.getConversationInboxDAO().saveConversationArchivalPrefillText(this.userDM.getLocalId().longValue(), sb.toString());
            handleConversationEnded(conversation);
        }
        updateMessagesOnIssueStatusUpdate(conversation);
    }

    public void removeFeedbackMessagesFromConversations(Conversation conversation) {
        if (conversation.state == IssueState.CLOSED) {
            ListIterator<E> listIterator = conversation.messageDMs.listIterator();
            while (listIterator.hasNext()) {
                if (((MessageDM) listIterator.next()).isFeedbackMessage) {
                    listIterator.remove();
                }
            }
        }
    }

    public void retryMessage(Conversation conversation, MessageDM messageDM) {
        if (messageDM instanceof UserMessageDM) {
            sendTextMessage(conversation, (UserMessageDM) messageDM);
        } else if (messageDM instanceof ScreenshotMessageDM) {
            sendScreenshotMessageInternal(conversation, (ScreenshotMessageDM) messageDM, false);
        } else if (messageDM instanceof UserAttachmentMessageDM) {
            sendAttachmentMessageInternal(conversation, (UserAttachmentMessageDM) messageDM);
        }
    }

    public void retryMessages(Conversation conversation, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (MessageDM messageDM : this.conversationDAO.readMessages(conversation.localId.longValue()).getData()) {
            messageDM.setDependencies(this.domain, this.platform);
            if (messageDM instanceof AutoRetriableMessageDM) {
                AutoRetriableMessageDM autoRetriableMessageDM = (AutoRetriableMessageDM) messageDM;
                if (canAutoRetryMessage(conversation, autoRetriableMessageDM)) {
                    arrayList.add(autoRetriableMessageDM);
                }
            }
            if (!StringUtils.isEmpty(messageDM.readAt) && !messageDM.isMessageSeenSynced) {
                arrayList2.add(messageDM);
            }
            if (messageDM instanceof RequestAppReviewMessageDM) {
                hashMap.put(messageDM.serverId, (RequestAppReviewMessageDM) messageDM);
            }
            if (messageDM instanceof FAQListMessageDM) {
                FAQListMessageDM fAQListMessageDM = (FAQListMessageDM) messageDM;
                if (fAQListMessageDM.isSuggestionsReadEventPending()) {
                    arrayList3.add(fAQListMessageDM);
                }
            }
            if (messageDM instanceof UserResponseMessageForCSATInput) {
                UserResponseMessageForCSATInput userResponseMessageForCSATInput = (UserResponseMessageForCSATInput) messageDM;
                if (userResponseMessageForCSATInput.isNewConversationStarted && StringUtils.isEmpty(userResponseMessageForCSATInput.serverId) && userResponseMessageForCSATInput.messageSyncState == 1) {
                    arrayList4.add(userResponseMessageForCSATInput);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AutoRetriableMessageDM autoRetriableMessageDM2 = (AutoRetriableMessageDM) it.next();
            if (canAutoRetryMessages(conversation)) {
                if (canAutoRetryMessage(conversation, autoRetriableMessageDM2)) {
                    try {
                        autoRetriableMessageDM2.send(this.userDM, conversation);
                        if (autoRetriableMessageDM2 instanceof AcceptedAppReviewMessageDM) {
                            ArrayList arrayList5 = new ArrayList();
                            AcceptedAppReviewMessageDM acceptedAppReviewMessageDM = (AcceptedAppReviewMessageDM) autoRetriableMessageDM2;
                            String str = acceptedAppReviewMessageDM.referredMessageId;
                            if (hashMap.containsKey(str)) {
                                RequestAppReviewMessageDM requestAppReviewMessageDM = (RequestAppReviewMessageDM) hashMap.get(str);
                                requestAppReviewMessageDM.handleAcceptedReviewSuccess(this.platform);
                                arrayList5.add(requestAppReviewMessageDM);
                            }
                            if (z) {
                                arrayList5.add(autoRetriableMessageDM2);
                                addMessageToUI(conversation, acceptedAppReviewMessageDM);
                                updateMessageDMs(conversation, true, arrayList5, (ConversationUpdate) null);
                            }
                        }
                    } catch (RootAPIException e) {
                        if (!handleConversationErrorUpdate(conversation, e) && e.exceptionType != NetworkException.NON_RETRIABLE) {
                            throw e;
                        }
                    }
                }
            } else {
                return;
            }
        }
        HashMap hashMap2 = new HashMap();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            MessageDM messageDM2 = (MessageDM) it2.next();
            String str2 = messageDM2.readAt;
            List list = (List) hashMap2.get(str2);
            if (list == null) {
                list = new ArrayList();
            }
            list.add(messageDM2);
            hashMap2.put(str2, list);
        }
        for (String str3 : hashMap2.keySet()) {
            try {
                markMessagesAsSeen(conversation, (List) hashMap2.get(str3));
            } catch (RootAPIException e2) {
                if (e2.exceptionType != NetworkException.NON_RETRIABLE) {
                    throw e2;
                }
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            ((FAQListMessageDM) it3.next()).sendSuggestionReadEvent(conversation, this.userDM);
        }
        Iterator it4 = arrayList4.iterator();
        while (it4.hasNext()) {
            UserResponseMessageForCSATInput userResponseMessageForCSATInput2 = (UserResponseMessageForCSATInput) it4.next();
            try {
                userResponseMessageForCSATInput2.send(this.userDM, conversation);
            } catch (RootAPIException e3) {
                if (handleConversationErrorUpdate(conversation, e3) || e3.exceptionType == NetworkException.NON_RETRIABLE) {
                    userResponseMessageForCSATInput2.messageSyncState = 3;
                    this.conversationDAO.insertOrUpdateMessage(userResponseMessageForCSATInput2);
                } else {
                    throw e3;
                }
            }
        }
    }

    public void sendAttachment(Conversation conversation, AttachmentPickerFile attachmentPickerFile, String str) {
        if (1 == attachmentPickerFile.attachmentType) {
            sendScreenshot(conversation, attachmentPickerFile, str);
        } else {
            sendGenericAttachment(conversation, attachmentPickerFile);
        }
    }

    public void sendCSATBotResponse(Conversation conversation, int i, boolean z, AdminCSATMessageWithOptions adminCSATMessageWithOptions) {
        String str;
        String str2;
        final Conversation conversation2 = conversation;
        AdminCSATMessageWithOptions adminCSATMessageWithOptions2 = adminCSATMessageWithOptions;
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        String str3 = (String) currentAdjustedTimeForStorage.first;
        long longValue = ((Long) currentAdjustedTimeForStorage.second).longValue();
        if (z) {
            str2 = adminCSATMessageWithOptions2.csatRatingsInput.startNewConversationLabel;
            int i2 = i;
            str = JsonUtils.EMPTY_JSON;
        } else {
            CSATRatingsInput.Rating rating = adminCSATMessageWithOptions2.csatRatingsInput.ratings.get(0);
            Iterator<CSATRatingsInput.Rating> it = adminCSATMessageWithOptions2.csatRatingsInput.ratings.iterator();
            while (true) {
                if (!it.hasNext()) {
                    int i3 = i;
                    break;
                }
                CSATRatingsInput.Rating next = it.next();
                if (next.value == i) {
                    rating = next;
                    break;
                }
            }
            String str4 = rating.title;
            str = rating.jsonData;
            str2 = str4;
        }
        final UserResponseMessageForCSATInput userResponseMessageForCSATInput = new UserResponseMessageForCSATInput(str2, str3, longValue, new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER), i, z, adminCSATMessageWithOptions2.csatRatingsInput.botInfo, str, adminCSATMessageWithOptions2.serverId, 1);
        userResponseMessageForCSATInput.conversationLocalId = conversation2.localId;
        userResponseMessageForCSATInput.updateState(true);
        addMessageToDbAndUI(conversation2, userResponseMessageForCSATInput);
        if (!z) {
            sendTextMessage(conversation2, (UserMessageDM) userResponseMessageForCSATInput);
        } else {
            sendMessageWithAutoRetry(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    userResponseMessageForCSATInput.send(ConversationManager.this.userDM, conversation2);
                }
            });
        }
    }

    public void sendCSATExpiryEvent(Conversation conversation) {
        HashMap outline28 = GeneratedOutlineSupport.outline28("type", "csat");
        outline28.put("id", conversation.getIssueId());
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.TIMER_EXPIRED, (Map<String, Object>) outline28);
    }

    public void sendCSATSurvey(final Conversation conversation, int i, String str) {
        if (i > 5) {
            i = 5;
        } else if (i < 0) {
            i = 0;
        }
        conversation.csatRating = i;
        if (str != null) {
            str = str.trim();
        }
        conversation.csatFeedback = str;
        setCSATState(conversation, ConversationCSATState.SUBMITTED_NOT_SYNCED);
        sendMessageWithAutoRetry(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationManager.this.sendCSATSurveyInternal(conversation);
            }
        });
        this.domain.getDelegate().userCompletedCustomerSatisfactionSurvey(conversation.csatRating, conversation.csatFeedback);
    }

    public void sendCSATSurveyInternal(Conversation conversation) {
        if (ConversationUtil.isCSATTimerExpired(this.platform, conversation)) {
            markConversationCSATStateToExpired(conversation);
            return;
        }
        String outline18 = GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24(ConversationController.CREATE_ISSUE_ROUTE), conversation.serverId, "/customer-survey/");
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(this.userDM);
        userRequestData.put("rating", String.valueOf(conversation.csatRating));
        userRequestData.put("feedback", conversation.csatFeedback);
        try {
            new GuardOKNetwork(new FailedAPICallNetworkDecorator(new GuardAgainstCSATExpiryNetwork(new TSCorrectedNetwork(new IdempotentNetwork(new POSTNetwork(outline18, this.domain, this.platform), this.platform, new SuccessOrNonRetriableStatusCodeIdempotentPolicy(), outline18, conversation.serverId), this.platform), this.platform))).makeRequest(new RequestData((Map<String, String>) userRequestData));
            ConversationCSATState conversationCSATState = ConversationCSATState.SUBMITTED_SYNCED;
            if (conversationCSATState != null) {
                setCSATState(conversation, conversationCSATState);
            }
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.CSAT_EXPIRED) {
                ConversationCSATState conversationCSATState2 = ConversationCSATState.EXPIRED;
                sendCSATExpiryEvent(conversation);
                if (conversationCSATState2 != null) {
                    setCSATState(conversation, conversationCSATState2);
                    return;
                }
                return;
            }
            if (e.exceptionType == NetworkException.INVALID_AUTH_TOKEN || e.exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(this.userDM, e.exceptionType);
            } else if (e.exceptionType == NetworkException.NON_RETRIABLE) {
                ConversationCSATState conversationCSATState3 = ConversationCSATState.SUBMITTED_SYNCED;
            }
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                setCSATState(conversation, (ConversationCSATState) null);
            }
            throw th;
        }
    }

    public void sendConfirmationAcceptedMessageAndDelegates(final Conversation conversation) {
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        final ConfirmationAcceptedMessageDM confirmationAcceptedMessageDM = new ConfirmationAcceptedMessageDM("Accepted the solution", (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER), 1);
        confirmationAcceptedMessageDM.setDependencies(this.domain, this.platform);
        confirmationAcceptedMessageDM.conversationLocalId = conversation.localId;
        this.conversationDAO.insertOrUpdateMessage(confirmationAcceptedMessageDM);
        sendMessageWithAutoRetry(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    confirmationAcceptedMessageDM.send(ConversationManager.this.userDM, conversation);
                } catch (RootAPIException e) {
                    ExceptionType exceptionType = e.exceptionType;
                    if (exceptionType == NetworkException.CONVERSATION_ARCHIVED) {
                        ConversationManager.this.updateIssueStatus(conversation, IssueState.ARCHIVED);
                    } else if (exceptionType == NetworkException.CONVERSATION_REOPEN_EXPIRED) {
                        ConversationManager.this.markConversationStateToResolutionExpired(conversation);
                    } else {
                        throw e;
                    }
                }
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("id", conversation.serverId);
        if (StringUtils.isNotEmpty(conversation.acid)) {
            hashMap.put("acid", conversation.acid);
        }
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.RESOLUTION_ACCEPTED, (Map<String, Object>) hashMap);
        this.domain.getDelegate().userRepliedToConversation("User accepted the solution");
    }

    public void sendConversationEndedDelegate(Conversation conversation) {
        if (!conversation.isConversationEndedDelegateSent) {
            this.domain.getDelegate().conversationEnded();
            conversation.isConversationEndedDelegateSent = true;
            this.conversationDAO.updateConversationWithoutMessages(conversation);
        }
    }

    public void sendConversationPostedEvent(Conversation conversation) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", conversation.serverId);
        if (StringUtils.isNotEmpty(conversation.acid)) {
            hashMap.put("acid", conversation.acid);
        }
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.CONVERSATION_POSTED, (Map<String, Object>) hashMap);
    }

    public void sendMessageAddedEventOnPreissueCreation(Conversation conversation) {
        String str;
        HashMap hashMap = new HashMap();
        if (StringUtils.isNotEmpty(conversation.acid)) {
            hashMap.put("acid", conversation.acid);
        }
        Iterator<E> it = conversation.messageDMs.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((MessageDM) it.next()) instanceof UserSmartIntentMessageDM) {
                    str = "si";
                    break;
                }
            } else {
                str = "txt";
                break;
            }
        }
        hashMap.put("type", str);
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.MESSAGE_ADDED, (Map<String, Object>) hashMap);
    }

    public void sendOptionInputMessage(Conversation conversation, OptionInputMessageDM optionInputMessageDM, OptionInput.Option option, boolean z) {
        String str;
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        String str2 = (String) currentAdjustedTimeForStorage.first;
        long longValue = ((Long) currentAdjustedTimeForStorage.second).longValue();
        if (z) {
            str = optionInputMessageDM.input.skipLabel;
        } else {
            str = option.title;
        }
        UserResponseMessageForOptionInput userResponseMessageForOptionInput = new UserResponseMessageForOptionInput(str, str2, longValue, new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER), optionInputMessageDM, z);
        userResponseMessageForOptionInput.conversationLocalId = conversation.localId;
        userResponseMessageForOptionInput.updateState(true);
        addMessageToDbAndUI(conversation, userResponseMessageForOptionInput);
        deleteOptionsForAdminMessageWithOptionsInput(optionInputMessageDM);
        sendTextMessage(conversation, (UserMessageDM) userResponseMessageForOptionInput);
    }

    public void sendResolutionQuestionExpiryEvent(Conversation conversation) {
        HashMap outline28 = GeneratedOutlineSupport.outline28("type", "reopen");
        outline28.put("id", conversation.getIssueId());
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.TIMER_EXPIRED, (Map<String, Object>) outline28);
    }

    public void sendScreenshot(Conversation conversation, AttachmentPickerFile attachmentPickerFile, String str) {
        Conversation conversation2 = conversation;
        AttachmentPickerFile attachmentPickerFile2 = attachmentPickerFile;
        String str2 = str;
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        ScreenshotMessageDM screenshotMessageDM = new ScreenshotMessageDM((String) null, (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER), (String) null, (String) null, (String) null, (String) null, 0, false);
        screenshotMessageDM.fileName = attachmentPickerFile2.originalFileName;
        screenshotMessageDM.filePath = attachmentPickerFile2.filePath;
        screenshotMessageDM.setRefersMessageId(str2);
        screenshotMessageDM.updateState(shouldEnableMessagesClick(conversation));
        screenshotMessageDM.conversationLocalId = conversation2.localId;
        addMessageToDbAndUI(conversation2, screenshotMessageDM);
        if (str2 != null) {
            Iterator<E> it = conversation2.messageDMs.iterator();
            while (true) {
                if (it.hasNext()) {
                    MessageDM messageDM = (MessageDM) it.next();
                    String str3 = messageDM.serverId;
                    if (str3 != null && str3.equals(str2) && messageDM.messageType == MessageType.REQUESTED_SCREENSHOT) {
                        ((RequestScreenshotMessageDM) messageDM).setIsAnswered(this.platform, true);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        sendScreenshotMessageInternal(conversation2, screenshotMessageDM, !attachmentPickerFile2.isFileCompressionAndCopyingDone);
    }

    public void sendTextMessage(Conversation conversation, String str) {
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        UserMessageDM userMessageDM = new UserMessageDM(str, (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER));
        userMessageDM.conversationLocalId = conversation.localId;
        userMessageDM.updateState(shouldEnableMessagesClick(conversation));
        addMessageToDbAndUI(conversation, userMessageDM);
        sendTextMessage(conversation, userMessageDM);
    }

    public void setEnableMessageClickOnResolutionRejected(Conversation conversation, boolean z) {
        conversation.enableMessageClickOnResolutionRejected = z;
        if (conversation.state == IssueState.RESOLUTION_REJECTED) {
            updateMessagesOnIssueStatusUpdate(conversation);
        }
    }

    public void setShouldIncrementMessageCount(Conversation conversation, boolean z, boolean z2) {
        if (conversation.shouldIncrementMessageCount != z) {
            conversation.shouldIncrementMessageCount = z;
            if (z2) {
                this.conversationDAO.updateConversationWithoutMessages(conversation);
            }
        }
    }

    public void setStartNewConversationButtonClicked(Conversation conversation, boolean z, boolean z2) {
        conversation.isStartNewConversationClicked = z;
        if (z2) {
            this.conversationDAO.updateConversationWithoutMessages(conversation);
        }
    }

    public boolean shouldEnableMessagesClick(Conversation conversation) {
        if (conversation.isInBetweenBotExecution) {
            return false;
        }
        if (conversation.isIssueInProgress()) {
            return true;
        }
        IssueState issueState = conversation.state;
        if (issueState == IssueState.RESOLUTION_REQUESTED || issueState == IssueState.RESOLUTION_ACCEPTED || issueState == IssueState.RESOLUTION_EXPIRED || issueState == IssueState.ARCHIVED || issueState == IssueState.REJECTED || issueState == IssueState.CLOSED || issueState != IssueState.RESOLUTION_REJECTED) {
            return false;
        }
        return conversation.enableMessageClickOnResolutionRejected;
    }

    public boolean shouldOpen(Conversation conversation) {
        boolean z;
        if (!this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.CONVERSATIONAL_ISSUE_FILING) && conversation.isInPreIssueMode() && StringUtils.isEmpty(conversation.preConversationServerId)) {
            return false;
        }
        if (conversation.isInPreIssueMode() && conversation.isIssueInProgress()) {
            return true;
        }
        IssueState issueState = conversation.state;
        if (conversation.isRedacted) {
            return false;
        }
        if (issueState == IssueState.CLOSED || issueState == IssueState.RESOLUTION_REQUESTED) {
            z = conversation.isStartNewConversationClicked;
        } else {
            if (!conversation.isIssueInProgress()) {
                if (issueState == IssueState.RESOLUTION_ACCEPTED || issueState == IssueState.RESOLUTION_REJECTED || issueState == IssueState.RESOLUTION_EXPIRED || issueState == IssueState.ARCHIVED) {
                    z = conversation.isStartNewConversationClicked;
                } else if (issueState != IssueState.REJECTED || conversation.isStartNewConversationClicked) {
                    return false;
                } else {
                    if (conversation.isInPreIssueMode() && ConversationUtil.getUserMessageCountForConversationLocalId(this.conversationDAO, conversation.localId) <= 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        return !z;
    }

    public boolean shouldShowCSATInFooter(Conversation conversation) {
        if (!conversation.isInPreIssueMode() && conversation.csatState == ConversationCSATState.NONE && this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.CUSTOMER_SATISFACTION_SURVEY)) {
            return true;
        }
        return false;
    }

    public void updateAcceptedRequestForReopenMessageDMs(Conversation conversation, MessageDM messageDM) {
        if (messageDM instanceof RequestForReopenMessageDM) {
            RequestForReopenMessageDM requestForReopenMessageDM = (RequestForReopenMessageDM) messageDM;
            if (!requestForReopenMessageDM.isAnswered()) {
                conversation.unansweredRequestForReopenMessageDMs.put(messageDM.serverId, requestForReopenMessageDM);
            }
        } else if (messageDM instanceof FollowupAcceptedMessageDM) {
            String str = ((FollowupAcceptedMessageDM) messageDM).referredMessageId;
            if (conversation.unansweredRequestForReopenMessageDMs.containsKey(str)) {
                RequestForReopenMessageDM remove = conversation.unansweredRequestForReopenMessageDMs.remove(str);
                remove.setDependencies(this.domain, this.platform);
                remove.setAnsweredAndNotify(true);
                this.conversationDAO.insertOrUpdateMessage(remove);
            }
        }
    }

    public void updateConversationExpiryProperties(Conversation conversation) {
        if (conversation != null) {
            if (ConversationUtil.isResolutionQuestionExpired(this.platform, conversation)) {
                markConversationStateToResolutionExpired(conversation);
            }
            if (ConversationUtil.isCSATTimerExpired(this.platform, conversation)) {
                markConversationCSATStateToExpired(conversation);
            }
        }
    }

    public void updateIsAutoFilledPreissueFlag(Conversation conversation, boolean z) {
        conversation.isAutoFilledPreIssue = z;
        this.conversationDAO.updateConversationWithoutMessages(conversation);
    }

    public void updateIssueStatus(Conversation conversation, IssueState issueState) {
        if (conversation.state != issueState) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Changing conversation status from: ");
            outline24.append(conversation.state);
            outline24.append(", new status: ");
            outline24.append(issueState);
            outline24.append(", for: ");
            outline24.append(conversation.serverId);
            HSLogger.m3237d(TAG, outline24.toString());
            conversation.state = issueState;
            refreshConversationOnIssueStateUpdate(conversation);
            this.conversationDAO.updateConversationWithoutMessages(conversation);
            ConversationDMListener conversationDMListener = conversation.conversationDMListener;
            if (conversationDMListener != null) {
                conversationDMListener.onIssueStatusChange(conversation.state);
            }
        }
    }

    public void updateLastUserActivityTime(Conversation conversation, long j) {
        conversation.lastUserActivityTime = j;
        this.conversationDAO.updateLastUserActivityTimeInConversation(conversation.localId, j);
    }

    public void updateMessageDMs(Conversation conversation, boolean z, List<MessageDM> list, ConversationUpdate conversationUpdate) {
        if (conversationUpdate == null) {
            conversationUpdate = new ConversationUpdate();
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        populateMessageDMLookup(conversation, hashMap, hashMap2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MessageDM next : list) {
            MessageDM messageDMForUpdate = getMessageDMForUpdate(next, hashMap, hashMap2, conversationUpdate);
            if (messageDMForUpdate != null) {
                if (messageDMForUpdate instanceof UserMessageDM) {
                    messageDMForUpdate.merge(next);
                    ((UserMessageDM) messageDMForUpdate).setState(UserMessageState.SENT);
                } else if (messageDMForUpdate instanceof ScreenshotMessageDM) {
                    messageDMForUpdate.merge(next);
                    ((ScreenshotMessageDM) messageDMForUpdate).setState(UserMessageState.SENT);
                    if (messageDMForUpdate.isRedacted) {
                        arrayList2.add(messageDMForUpdate);
                    }
                } else if (messageDMForUpdate instanceof UserAttachmentMessageDM) {
                    messageDMForUpdate.merge(next);
                    ((UserAttachmentMessageDM) messageDMForUpdate).setState(UserAttachmentMessageDM.UserGenericAttachmentState.SENT);
                    if (messageDMForUpdate.isRedacted) {
                        arrayList2.add(messageDMForUpdate);
                    }
                } else if ((messageDMForUpdate instanceof AttachmentMessageDM) || (messageDMForUpdate instanceof AdminActionCardMessageDM)) {
                    messageDMForUpdate.mergeAndNotify(next);
                    if (messageDMForUpdate.isRedacted) {
                        arrayList2.add(messageDMForUpdate);
                    }
                } else {
                    messageDMForUpdate.mergeAndNotify(next);
                }
                conversationUpdate.updatedMessageDMs.add(messageDMForUpdate);
            } else {
                arrayList.add(next);
            }
        }
        clearRedactedAttachmentsResources(arrayList2);
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MessageDM messageDM = (MessageDM) it.next();
                messageDM.setDependencies(this.domain, this.platform);
                messageDM.conversationLocalId = conversation.localId;
                if (messageDM instanceof UserMessageDM) {
                    ((UserMessageDM) messageDM).setState(UserMessageState.SENT);
                } else if (messageDM instanceof ScreenshotMessageDM) {
                    ((ScreenshotMessageDM) messageDM).setState(UserMessageState.SENT);
                } else if (messageDM instanceof UserAttachmentMessageDM) {
                    ((UserAttachmentMessageDM) messageDM).setState(UserAttachmentMessageDM.UserGenericAttachmentState.SENT);
                }
                messageDM.addObserver(conversation);
            }
            if (z) {
                ConversationUtil.sortMessagesBasedOnCreatedAt(arrayList);
                conversation.isInBetweenBotExecution = evaluateBotExecutionState(arrayList, conversation.isInBetweenBotExecution);
                conversation.messageDMs.addAll(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    MessageDM messageDM2 = (MessageDM) it2.next();
                    if (messageDM2 instanceof AdminImageAttachmentMessageDM) {
                        ((AdminImageAttachmentMessageDM) messageDM2).downloadThumbnailImage(this.platform);
                    }
                    if (messageDM2 instanceof AdminActionCardMessageDM) {
                        ((AdminActionCardMessageDM) messageDM2).downloadImage(this.platform);
                    }
                    updateAcceptedRequestForReopenMessageDMs(conversation, messageDM2);
                }
            } else {
                conversation.messageDMs.addAll(arrayList);
            }
            conversationUpdate.newMessageDMs.addAll(arrayList);
            evaluateBotControlMessages(conversation, arrayList);
        }
    }

    public void updateMessageOnConversationUpdate(MessageDM messageDM, boolean z) {
        updateMessageClickableState(messageDM, z);
        if (messageDM instanceof ScreenshotMessageDM) {
            ((ScreenshotMessageDM) messageDM).checkAndReDownloadImageIfNotExist(this.platform);
        }
    }

    public void updateMessagesClickOnBotSwitch(Conversation conversation, boolean z) {
        Iterator<E> it = conversation.messageDMs.iterator();
        while (it.hasNext()) {
            updateMessageClickableState((MessageDM) it.next(), z);
        }
    }

    public void updateMessagesOnIssueStatusUpdate(Conversation conversation) {
        boolean shouldEnableMessagesClick = shouldEnableMessagesClick(conversation);
        Iterator<E> it = conversation.messageDMs.iterator();
        while (it.hasNext()) {
            updateMessageOnConversationUpdate((MessageDM) it.next(), shouldEnableMessagesClick);
        }
    }

    public void updateSmartIntentData(Conversation conversation, String str, List<String> list, String str2) {
        conversation.smartIntentTreeId = str;
        conversation.smartIntentIds = list;
        conversation.smartIntentUserQuery = str2;
        this.conversationDAO.updateConversationWithoutMessages(conversation);
    }

    public void updateStateBasedOnMessages(Conversation conversation) {
        HSObservableList<MessageDM> hSObservableList;
        if (conversation.state == IssueState.RESOLUTION_REQUESTED && !conversation.isFeedbackBotEnabled && (hSObservableList = conversation.messageDMs) != null && hSObservableList.size() > 0) {
            MessageDM messageDM = null;
            for (int size = conversation.messageDMs.size() - 1; size >= 0; size--) {
                messageDM = (MessageDM) conversation.messageDMs.get(size);
                if (!(messageDM instanceof FollowupRejectedMessageDM) && !(messageDM instanceof RequestForReopenMessageDM)) {
                    break;
                }
            }
            if (messageDM instanceof ConfirmationAcceptedMessageDM) {
                conversation.state = IssueState.RESOLUTION_ACCEPTED;
            } else if (messageDM instanceof ConfirmationRejectedMessageDM) {
                conversation.state = IssueState.RESOLUTION_REJECTED;
            }
        }
    }

    /* access modifiers changed from: private */
    public void deleteOptionsForAdminMessageWithOptionsInput(Conversation conversation) {
        List<MessageDM> readMessages = this.conversationDAO.readMessages(conversation.localId.longValue(), MessageType.ADMIN_TEXT_WITH_OPTION_INPUT);
        Iterator<MessageDM> it = readMessages.iterator();
        while (it.hasNext()) {
            ((AdminMessageWithOptionInputDM) it.next()).input.options.clear();
        }
        this.conversationDAO.insertOrUpdateMessages(readMessages);
    }

    public void removeFeedbackMessagesFromConversations(ViewableConversation viewableConversation) {
        for (Conversation removeFeedbackMessagesFromConversations : viewableConversation.getAllConversations()) {
            removeFeedbackMessagesFromConversations(removeFeedbackMessagesFromConversations);
        }
    }

    private void markMessagesAsSeen(Conversation conversation, List<MessageDM> list) {
        if (!ListUtils.isEmpty(list)) {
            String str = list.get(0).readAt;
            String str2 = list.get(0).seenAtMessageCursor;
            HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(this.userDM);
            userRequestData.put("read_at", str);
            userRequestData.put("mc", str2);
            userRequestData.put(MessagesTable.Columns.DELIVERY_STATE, "read");
            try {
                new GuardOKNetwork(new FailedAPICallNetworkDecorator(new TSCorrectedNetwork(new AuthenticationFailureNetwork(new PUTNetwork(getRouteForSendingMessage(conversation), this.domain, this.platform)), this.platform))).makeRequest(new RequestData((Map<String, String>) userRequestData));
            } catch (RootAPIException e) {
                ExceptionType exceptionType = e.exceptionType;
                if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                    this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(this.userDM, e.exceptionType);
                } else if (exceptionType != NetworkException.NON_RETRIABLE) {
                    throw e;
                }
            }
            for (MessageDM messageDM : list) {
                messageDM.isMessageSeenSynced = true;
            }
            this.conversationDAO.insertOrUpdateMessages(list);
        }
    }

    private void sendTextMessage(Conversation conversation, UserMessageDM userMessageDM) {
        try {
            userMessageDM.send(this.userDM, conversation);
            if (conversation.state == IssueState.RESOLUTION_REJECTED) {
                updateIssueStatus(conversation, IssueState.WAITING_FOR_AGENT);
            }
        } catch (RootAPIException e) {
            ExceptionType exceptionType = e.exceptionType;
            if (exceptionType == NetworkException.CONVERSATION_ARCHIVED) {
                updateIssueStatus(conversation, IssueState.ARCHIVED);
            } else if (exceptionType == NetworkException.USER_PRE_CONDITION_FAILED) {
                updateIssueStatus(conversation, IssueState.AUTHOR_MISMATCH);
            } else if (exceptionType == NetworkException.CONVERSATION_REOPEN_EXPIRED) {
                markConversationStateToResolutionExpired(conversation);
            } else {
                throw e;
            }
        }
    }

    public void sendTextMessage(Conversation conversation, String str, AdminMessageWithTextInputDM adminMessageWithTextInputDM, boolean z) {
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        UserResponseMessageForTextInputDM userResponseMessageForTextInputDM = new UserResponseMessageForTextInputDM(str, (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.LOCAL_USER), adminMessageWithTextInputDM, z);
        userResponseMessageForTextInputDM.conversationLocalId = conversation.localId;
        userResponseMessageForTextInputDM.updateState(true);
        addMessageToDbAndUI(conversation, userResponseMessageForTextInputDM);
        sendTextMessage(conversation, (UserMessageDM) userResponseMessageForTextInputDM);
    }
}
