package com.helpshift.conversation.pollersync.model;

import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversationsLookup {
    public final Map<String, Conversation> lookupByIssueId = new HashMap();
    public final Map<String, Conversation> lookupByPreIssueId = new HashMap();
    public ValuePair<String, Conversation> lookupByPreIssueRequestId;
    public PollerSyncDataProvider pollerSyncDataProvider;

    public enum MatchingID {
        SERVER_ID,
        PREISSUE_ID,
        PREISSUE_REQUEST_ID
    }

    public ConversationsLookup(List<Conversation> list, PollerSyncDataProvider pollerSyncDataProvider2) {
        this.pollerSyncDataProvider = pollerSyncDataProvider2;
        populateLookup(list);
    }

    private void populateLookup(List<Conversation> list) {
        if (!ListUtils.isEmpty(list)) {
            ConversationUtil.sortConversationsBasedOnCreatedAt(list);
            for (Conversation next : list) {
                if (!StringUtils.isEmpty(next.serverId)) {
                    this.lookupByIssueId.put(next.serverId, next);
                } else if (!StringUtils.isEmpty(next.preConversationServerId)) {
                    this.lookupByPreIssueId.put(next.preConversationServerId, next);
                }
            }
            String pendingRequestIdForPreissue = this.pollerSyncDataProvider.getPendingRequestIdForPreissue();
            if (pendingRequestIdForPreissue != null) {
                this.lookupByPreIssueRequestId = new ValuePair<>(pendingRequestIdForPreissue, list.get(list.size() - 1));
            }
        }
    }

    public ValuePair<MatchingID, Conversation> find(Conversation conversation) {
        ValuePair<String, Conversation> valuePair;
        String str = conversation.serverId;
        String str2 = conversation.preConversationServerId;
        String str3 = conversation.createdRequestId;
        if (this.lookupByIssueId.containsKey(str)) {
            return new ValuePair<>(MatchingID.SERVER_ID, this.lookupByIssueId.get(str));
        } else if (this.lookupByPreIssueId.containsKey(str2)) {
            return new ValuePair<>(MatchingID.PREISSUE_ID, this.lookupByPreIssueId.get(str2));
        } else if (StringUtils.isEmpty(str3) || (valuePair = this.lookupByPreIssueRequestId) == null || !((String) valuePair.first).equals(str3)) {
            return null;
        } else {
            return new ValuePair<>(MatchingID.PREISSUE_REQUEST_ID, (Conversation) this.lookupByPreIssueRequestId.second);
        }
    }
}
