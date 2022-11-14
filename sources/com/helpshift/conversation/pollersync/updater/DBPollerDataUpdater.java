package com.helpshift.conversation.pollersync.updater;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.dao.DAOResult;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.pollersync.exception.PollerSyncException;
import com.helpshift.conversation.pollersync.merger.ConversationDataMerger;
import com.helpshift.conversation.pollersync.merger.MessagesDataMerger;
import com.helpshift.conversation.pollersync.model.ConversationsDiff;
import com.helpshift.conversation.pollersync.model.ConversationsLookup;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.util.CloneUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBPollerDataUpdater implements PollerDataUpdater {
    public static final String TAG = "HS_DBPollerDataUpdater";
    public ConversationDAO conversationDAO;
    public ConversationDataMerger conversationDataMerger;
    public MessagesDataMerger messagesDataMerger;
    public Platform platform;
    public PollerSyncDataProvider syncDataProvider;
    public UserDM userDM;

    /* renamed from: com.helpshift.conversation.pollersync.updater.DBPollerDataUpdater$1 */
    public static /* synthetic */ class C25611 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$conversation$dto$IssueState;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|(2:5|6)|7|9|10|11|12|13|14|16) */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|9|10|11|12|13|14|16) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
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
                int[] r0 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x0019 }
                com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.RESOLUTION_REJECTED     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 9
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r0 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x0022 }
                com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.RESOLUTION_EXPIRED     // Catch:{ NoSuchFieldError -> 0x0022 }
                r1 = 12
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r0 = 5
                int[] r1 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x002a }
                com.helpshift.conversation.dto.IssueState r2 = com.helpshift.conversation.dto.IssueState.REJECTED     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 4
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.helpshift.conversation.dto.IssueState r2 = com.helpshift.conversation.dto.IssueState.ARCHIVED     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 10
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = $SwitchMap$com$helpshift$conversation$dto$IssueState     // Catch:{ NoSuchFieldError -> 0x003b }
                com.helpshift.conversation.dto.IssueState r1 = com.helpshift.conversation.dto.IssueState.CLOSED     // Catch:{ NoSuchFieldError -> 0x003b }
                r1 = 13
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.pollersync.updater.DBPollerDataUpdater.C25611.<clinit>():void");
        }
    }

    public DBPollerDataUpdater(Platform platform2, Domain domain, UserDM userDM2, PollerSyncDataProvider pollerSyncDataProvider) {
        this.platform = platform2;
        this.userDM = userDM2;
        this.conversationDataMerger = new ConversationDataMerger(platform2, domain.getSDKConfigurationDM());
        this.messagesDataMerger = new MessagesDataMerger(pollerSyncDataProvider);
        this.conversationDAO = platform2.getConversationDAO();
        this.syncDataProvider = pollerSyncDataProvider;
    }

    private void checkAndUpdateCSATStateToExpired(Conversation conversation) {
        if (ConversationUtil.isCSATTimerExpired(this.platform, conversation)) {
            conversation.csatState = ConversationCSATState.EXPIRED;
        }
    }

    private void checkAndUpdateLastUserActivityTime(Conversation conversation) {
        if (conversation.isInPreIssueMode()) {
            conversation.lastUserActivityTime = System.currentTimeMillis();
        }
    }

    private void checkAndUpdateStartNewConversationClickedFlag(Conversation conversation, boolean z) {
        boolean z2 = false;
        switch (conversation.state.ordinal()) {
            case 5:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                if (!z || conversation.isRedacted) {
                    z2 = true;
                    break;
                }
        }
        conversation.isStartNewConversationClicked = z2;
    }

    private void checkAndUpdateStateToClosed(Conversation conversation) {
        if (conversation.shouldAllowNewConversationCreation) {
            conversation.state = IssueState.CLOSED;
        }
    }

    private void checkAndUpdateStateToResolutionAccepted(Conversation conversation) {
        if (conversation.state != IssueState.RESOLUTION_REQUESTED) {
            return;
        }
        if (conversation.isInPreIssueMode() || conversation.isRedacted) {
            conversation.state = IssueState.RESOLUTION_ACCEPTED;
        }
    }

    private void checkAndUpdateStateToResolutionExpired(Conversation conversation) {
        if (ConversationUtil.isResolutionQuestionExpired(this.platform, conversation)) {
            conversation.state = IssueState.RESOLUTION_EXPIRED;
        }
    }

    private void deleteLocalMessagesForPreIssue(Conversation conversation) {
        this.conversationDAO.deleteMessagesForConversation(conversation.localId.longValue());
    }

    private List<Conversation> readConversationsWithoutMessagesFromDB() throws PollerSyncException {
        DAOResult<List<Conversation>> readConversationsWithoutMessages = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue());
        if (readConversationsWithoutMessages.isSuccess()) {
            return readConversationsWithoutMessages.getData();
        }
        throw new PollerSyncException("Exception occurred while reading conversations from DB");
    }

    private List<MessageDM> readMessagesFromDB(Conversation conversation) throws PollerSyncException {
        DAOResult<List<MessageDM>> readMessages = this.conversationDAO.readMessages(conversation.localId.longValue());
        if (readMessages.isSuccess()) {
            return readMessages.getData();
        }
        throw new PollerSyncException("Exception occurred while reading messages from DB");
    }

    private void setUserLocalId(Conversation conversation) {
        conversation.userLocalId = this.userDM.getLocalId().longValue();
    }

    private void writeToDB(ConversationsDiff conversationsDiff) throws PollerSyncException {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Writing data to DAO, updated conversations size: ");
        outline24.append(conversationsDiff.updatedConversations.size());
        HSLogger.m3237d(TAG, outline24.toString());
        if (this.conversationDAO.updateConversations(conversationsDiff.messagesDiffMap, conversationsDiff.updatedConversations)) {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Writing data to DAO, new conversations size: ");
            outline242.append(conversationsDiff.newConversations.size());
            HSLogger.m3237d(TAG, outline242.toString());
            if (!this.conversationDAO.insertConversations(conversationsDiff.newConversations)) {
                throw new PollerSyncException("Exception occurred while inserting conversations in DB");
            }
            return;
        }
        throw new PollerSyncException("Exception occurred while updating conversations in DB");
    }

    public void deriveConversationPropertiesForNewConversations(Conversation conversation, boolean z) {
        setUserLocalId(conversation);
        checkAndUpdateLastUserActivityTime(conversation);
        checkAndUpdateStateToClosed(conversation);
        checkAndUpdateStateToResolutionExpired(conversation);
        checkAndUpdateStateToResolutionAccepted(conversation);
        checkAndUpdateStartNewConversationClickedFlag(conversation, z);
        checkAndUpdateCSATStateToExpired(conversation);
    }

    public void removeConvertedPreIssueConversations(List<Conversation> list) {
        if (list.size() > 1) {
            ArrayList arrayList = new ArrayList(list);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Conversation conversation = (Conversation) arrayList.get(size);
                if (!conversation.isInPreIssueMode()) {
                    int i = size - 1;
                    while (true) {
                        if (i < 0) {
                            break;
                        }
                        Conversation conversation2 = (Conversation) arrayList.get(i);
                        if (!StringUtils.isEmpty(conversation.preConversationServerId) && conversation.preConversationServerId.equals(conversation2.preConversationServerId) && conversation.serverId.equals(conversation2.serverId)) {
                            conversation.messageDMs.addAll(conversation2.messageDMs);
                            list.remove(conversation2);
                            break;
                        }
                        i--;
                    }
                }
            }
        }
    }

    public ConversationsDiff updateData(List<Conversation> list) throws PollerSyncException {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Starting with updating the fetched data in DB, conversations size: ");
        outline24.append(list.size());
        HSLogger.m3237d(TAG, outline24.toString());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        List<Conversation> readConversationsWithoutMessagesFromDB = readConversationsWithoutMessagesFromDB();
        ArrayList<T> deepClone = CloneUtil.deepClone(readConversationsWithoutMessagesFromDB);
        ConversationsLookup conversationsLookup = new ConversationsLookup(readConversationsWithoutMessagesFromDB, this.syncDataProvider);
        for (int i = 0; i < list.size(); i++) {
            Conversation conversation = list.get(i);
            ValuePair<ConversationsLookup.MatchingID, Conversation> find = conversationsLookup.find(conversation);
            if (find == null) {
                HSLogger.m3237d(TAG, "Matching conversation not found from DB, processing as new conversation");
                boolean z = true;
                if (i != list.size() - 1) {
                    z = false;
                }
                deriveConversationPropertiesForNewConversations(conversation, z);
                arrayList.add(conversation);
            } else {
                HSLogger.m3237d(TAG, "Matching conversation found from DB, processing as updated conversation");
                ConversationsLookup.MatchingID matchingID = (ConversationsLookup.MatchingID) find.first;
                Conversation conversation2 = (Conversation) find.second;
                if (matchingID == ConversationsLookup.MatchingID.PREISSUE_REQUEST_ID) {
                    deleteLocalMessagesForPreIssue(conversation2);
                }
                this.conversationDataMerger.mergeProperties(conversation2, conversation);
                if (!ListUtils.isEmpty(conversation.messageDMs)) {
                    hashMap.put(conversation2, this.messagesDataMerger.mergeMessages(conversation2, readMessagesFromDB(conversation2), conversation.messageDMs));
                }
                arrayList2.add(conversation2);
            }
        }
        removeConvertedPreIssueConversations(arrayList);
        ConversationsDiff conversationsDiff = new ConversationsDiff(deepClone, arrayList, arrayList2, hashMap);
        writeToDB(conversationsDiff);
        return conversationsDiff;
    }
}
