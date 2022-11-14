package com.helpshift.conversation.pollersync.updater;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.ViewableConversation;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.pollersync.merger.ConversationDataMerger;
import com.helpshift.conversation.pollersync.merger.MessagesDataMerger;
import com.helpshift.conversation.pollersync.model.ConversationsDiff;
import com.helpshift.conversation.pollersync.model.ConversationsLookup;
import com.helpshift.util.CloneUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.ValuePair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IMPollerDataUpdater implements PollerDataUpdater {
    public static final String TAG = "HS_IMPollerDataUpdater";
    public ConversationDataMerger conversationDataMerger;
    public MessagesDataMerger messagesDataMerger;
    public PollerSyncDataProvider syncDataProvider;

    public IMPollerDataUpdater(Platform platform, Domain domain, PollerSyncDataProvider pollerSyncDataProvider) {
        this.syncDataProvider = pollerSyncDataProvider;
        this.conversationDataMerger = new ConversationDataMerger(platform, domain.getSDKConfigurationDM());
        this.messagesDataMerger = new MessagesDataMerger(pollerSyncDataProvider);
    }

    public ConversationsDiff updateData(List<Conversation> list) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Starting with updating the fetched data in-memory, conversations size: ");
        outline24.append(list.size());
        HSLogger.m3237d(TAG, outline24.toString());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        ViewableConversation aliveViewableConversation = this.syncDataProvider.getAliveViewableConversation();
        if (aliveViewableConversation == null) {
            HSLogger.m3237d(TAG, "In-memory conversation not alive, returning!");
            return null;
        }
        List<Conversation> allConversations = aliveViewableConversation.getAllConversations();
        ArrayList<T> deepClone = CloneUtil.deepClone(allConversations);
        ConversationsLookup conversationsLookup = new ConversationsLookup(allConversations, this.syncDataProvider);
        for (Conversation next : list) {
            ValuePair<ConversationsLookup.MatchingID, Conversation> find = conversationsLookup.find(next);
            if (find != null) {
                HSLogger.m3237d(TAG, "Matching conversation found in-memory, processing as updated conversation");
                Conversation conversation = (Conversation) find.second;
                this.conversationDataMerger.mergeProperties(conversation, next);
                if (!ListUtils.isEmpty(next.messageDMs)) {
                    hashMap.put(conversation, this.messagesDataMerger.mergeMessages(conversation, conversation.messageDMs, next.messageDMs));
                }
                arrayList2.add(conversation);
            }
        }
        return new ConversationsDiff(deepClone, arrayList, arrayList2, hashMap);
    }
}
