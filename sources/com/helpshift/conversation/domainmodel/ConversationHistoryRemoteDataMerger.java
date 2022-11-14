package com.helpshift.conversation.domainmodel;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.ConversationUpdate;
import com.helpshift.conversation.activeconversation.model.Conversation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConversationHistoryRemoteDataMerger {
    public ConversationManager conversationManager;
    public Domain domain;
    public Platform platform;
    public UserDM userDM;

    public ConversationHistoryRemoteDataMerger(Platform platform2, Domain domain2, UserDM userDM2, ConversationManager conversationManager2) {
        this.platform = platform2;
        this.domain = domain2;
        this.userDM = userDM2;
        this.conversationManager = conversationManager2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: com.helpshift.conversation.activeconversation.model.Conversation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: com.helpshift.conversation.activeconversation.model.Conversation} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void merge(java.util.List<com.helpshift.conversation.activeconversation.model.Conversation> r14) {
        /*
            r13 = this;
            boolean r0 = com.helpshift.util.ListUtils.isEmpty(r14)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            int r3 = r14.size()
            r4 = 1
            if (r3 <= r4) goto L_0x0020
            com.helpshift.conversation.ConversationUtil.sortConversationsBasedOnCreatedAt(r14)
        L_0x0020:
            com.helpshift.common.platform.Platform r3 = r13.platform
            com.helpshift.conversation.dao.ConversationDAO r3 = r3.getConversationDAO()
            com.helpshift.account.domainmodel.UserDM r5 = r13.userDM
            java.lang.Long r5 = r5.getLocalId()
            long r5 = r5.longValue()
            com.helpshift.common.dao.DAOResult r3 = r3.readConversationsWithoutMessages(r5)
            java.lang.Object r3 = r3.getData()
            java.util.List r3 = (java.util.List) r3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x004d:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0075
            java.lang.Object r8 = r3.next()
            com.helpshift.conversation.activeconversation.model.Conversation r8 = (com.helpshift.conversation.activeconversation.model.Conversation) r8
            java.lang.String r9 = r8.serverId
            boolean r9 = com.helpshift.util.StringUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0067
            java.lang.String r9 = r8.serverId
            r6.put(r9, r8)
            goto L_0x004d
        L_0x0067:
            java.lang.String r9 = r8.preConversationServerId
            boolean r9 = com.helpshift.util.StringUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x004d
            java.lang.String r9 = r8.preConversationServerId
            r7.put(r9, r8)
            goto L_0x004d
        L_0x0075:
            java.util.Iterator r14 = r14.iterator()
        L_0x0079:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x0152
            java.lang.Object r3 = r14.next()
            com.helpshift.conversation.activeconversation.model.Conversation r3 = (com.helpshift.conversation.activeconversation.model.Conversation) r3
            java.lang.String r8 = r3.serverId
            java.lang.String r9 = r3.preConversationServerId
            r10 = 0
            com.helpshift.account.domainmodel.UserDM r11 = r13.userDM
            java.lang.Long r11 = r11.getLocalId()
            long r11 = r11.longValue()
            r3.userLocalId = r11
            boolean r11 = r6.containsKey(r8)
            if (r11 == 0) goto L_0x00a4
            java.lang.Object r8 = r6.get(r8)
            r10 = r8
            com.helpshift.conversation.activeconversation.model.Conversation r10 = (com.helpshift.conversation.activeconversation.model.Conversation) r10
            goto L_0x00b1
        L_0x00a4:
            boolean r8 = r7.containsKey(r9)
            if (r8 == 0) goto L_0x00b1
            java.lang.Object r8 = r7.get(r9)
            r10 = r8
            com.helpshift.conversation.activeconversation.model.Conversation r10 = (com.helpshift.conversation.activeconversation.model.Conversation) r10
        L_0x00b1:
            if (r10 == 0) goto L_0x0107
            com.helpshift.account.domainmodel.UserDM r8 = r13.userDM
            java.lang.Long r8 = r8.getLocalId()
            long r8 = r8.longValue()
            r10.userLocalId = r8
            java.lang.Long r8 = r10.localId
            boolean r8 = r1.containsKey(r8)
            if (r8 == 0) goto L_0x00d0
            java.lang.Long r8 = r10.localId
            java.lang.Object r8 = r1.get(r8)
            com.helpshift.conversation.activeconversation.ConversationUpdate r8 = (com.helpshift.conversation.activeconversation.ConversationUpdate) r8
            goto L_0x00d5
        L_0x00d0:
            com.helpshift.conversation.activeconversation.ConversationUpdate r8 = new com.helpshift.conversation.activeconversation.ConversationUpdate
            r8.<init>()
        L_0x00d5:
            boolean r9 = r3.isInPreIssueMode()
            r11 = 0
            if (r9 == 0) goto L_0x00f8
            boolean r9 = r10.isInPreIssueMode()
            if (r9 == 0) goto L_0x00e8
            com.helpshift.conversation.activeconversation.ConversationManager r9 = r13.conversationManager
            r9.mergePreIssue(r10, r3, r11, r8)
            goto L_0x00fd
        L_0x00e8:
            com.helpshift.util.HSObservableList<com.helpshift.conversation.activeconversation.message.MessageDM> r9 = r3.messageDMs
            boolean r9 = com.helpshift.util.ListUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00fd
            com.helpshift.conversation.activeconversation.ConversationManager r9 = r13.conversationManager
            com.helpshift.util.HSObservableList<com.helpshift.conversation.activeconversation.message.MessageDM> r3 = r3.messageDMs
            r9.updateMessageDMs(r10, r11, r3, r8)
            goto L_0x00fd
        L_0x00f8:
            com.helpshift.conversation.activeconversation.ConversationManager r9 = r13.conversationManager
            r9.mergeIssue(r10, r3, r11, r8)
        L_0x00fd:
            r0.add(r10)
            java.lang.Long r3 = r10.localId
            r1.put(r3, r8)
            goto L_0x0079
        L_0x0107:
            boolean r8 = r3.isInPreIssueMode()
            if (r8 == 0) goto L_0x011d
            long r8 = java.lang.System.currentTimeMillis()
            r3.lastUserActivityTime = r8
            com.helpshift.conversation.dto.IssueState r8 = r3.state
            com.helpshift.conversation.dto.IssueState r9 = com.helpshift.conversation.dto.IssueState.RESOLUTION_REQUESTED
            if (r8 != r9) goto L_0x011d
            com.helpshift.conversation.dto.IssueState r8 = com.helpshift.conversation.dto.IssueState.RESOLUTION_ACCEPTED
            r3.state = r8
        L_0x011d:
            com.helpshift.conversation.dto.IssueState r8 = r3.state
            com.helpshift.conversation.dto.IssueState r9 = com.helpshift.conversation.dto.IssueState.RESOLUTION_ACCEPTED
            if (r8 == r9) goto L_0x012f
            com.helpshift.conversation.dto.IssueState r9 = com.helpshift.conversation.dto.IssueState.RESOLUTION_REJECTED
            if (r8 == r9) goto L_0x012f
            com.helpshift.conversation.dto.IssueState r9 = com.helpshift.conversation.dto.IssueState.REJECTED
            if (r8 == r9) goto L_0x012f
            com.helpshift.conversation.dto.IssueState r9 = com.helpshift.conversation.dto.IssueState.ARCHIVED
            if (r8 != r9) goto L_0x0131
        L_0x012f:
            r3.isStartNewConversationClicked = r4
        L_0x0131:
            if (r8 == 0) goto L_0x0143
            boolean r8 = r3.isRedacted
            if (r8 == 0) goto L_0x0143
            com.helpshift.conversation.dto.IssueState r8 = r3.state
            com.helpshift.conversation.dto.IssueState r9 = com.helpshift.conversation.dto.IssueState.RESOLUTION_REQUESTED
            if (r8 != r9) goto L_0x0143
            r3.isStartNewConversationClicked = r4
            com.helpshift.conversation.dto.IssueState r8 = com.helpshift.conversation.dto.IssueState.RESOLUTION_ACCEPTED
            r3.state = r8
        L_0x0143:
            boolean r8 = r3.shouldAllowNewConversationCreation
            if (r8 == 0) goto L_0x014d
            r3.isStartNewConversationClicked = r4
            com.helpshift.conversation.dto.IssueState r8 = com.helpshift.conversation.dto.IssueState.CLOSED
            r3.state = r8
        L_0x014d:
            r5.add(r3)
            goto L_0x0079
        L_0x0152:
            int r14 = r5.size()
            if (r14 > r4) goto L_0x015f
            r2.addAll(r5)
            r13.putConversations(r0, r2, r1)
            return
        L_0x015f:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>(r5)
            int r3 = r14.size()
            int r3 = r3 - r4
        L_0x0169:
            if (r3 < 0) goto L_0x01ae
            java.lang.Object r4 = r14.get(r3)
            com.helpshift.conversation.activeconversation.model.Conversation r4 = (com.helpshift.conversation.activeconversation.model.Conversation) r4
            boolean r6 = r4.isInPreIssueMode()
            if (r6 != 0) goto L_0x01ab
            int r6 = r3 + -1
        L_0x0179:
            if (r6 < 0) goto L_0x01ab
            java.lang.Object r7 = r14.get(r6)
            com.helpshift.conversation.activeconversation.model.Conversation r7 = (com.helpshift.conversation.activeconversation.model.Conversation) r7
            java.lang.String r8 = r4.preConversationServerId
            boolean r8 = com.helpshift.util.StringUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x01a8
            java.lang.String r8 = r4.preConversationServerId
            java.lang.String r9 = r7.preConversationServerId
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x01a8
            java.lang.String r8 = r4.serverId
            java.lang.String r9 = r7.serverId
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x01a8
            com.helpshift.util.HSObservableList<com.helpshift.conversation.activeconversation.message.MessageDM> r4 = r4.messageDMs
            com.helpshift.util.HSObservableList<com.helpshift.conversation.activeconversation.message.MessageDM> r7 = r7.messageDMs
            r4.addAll(r7)
            r5.remove(r6)
            goto L_0x01ab
        L_0x01a8:
            int r6 = r6 + -1
            goto L_0x0179
        L_0x01ab:
            int r3 = r3 + -1
            goto L_0x0169
        L_0x01ae:
            r2.addAll(r5)
            r13.putConversations(r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.domainmodel.ConversationHistoryRemoteDataMerger.merge(java.util.List):void");
    }

    public void putConversations(Set<Conversation> set, Set<Conversation> set2, Map<Long, ConversationUpdate> map) {
        for (Conversation conversation : set) {
            conversation.userLocalId = this.userDM.getLocalId().longValue();
        }
        for (Conversation conversation2 : set2) {
            conversation2.userLocalId = this.userDM.getLocalId().longValue();
        }
        this.platform.getConversationDAO().updateConversations((List<Conversation>) new ArrayList(set), map);
        this.platform.getConversationDAO().insertConversations(new ArrayList(set2));
    }
}
