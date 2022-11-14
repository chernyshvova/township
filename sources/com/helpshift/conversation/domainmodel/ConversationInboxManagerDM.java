package com.helpshift.conversation.domainmodel;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.account.domainmodel.UserManagerDM;
import com.helpshift.common.HSBlockReason;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversationInboxManagerDM {
    public static final String TAG = "ConvInboxManagerDM";
    public Map<Long, ConversationController> activeUserAndInboxMapping = new HashMap();
    public final Domain domain;
    public final Platform platform;
    public final UserManagerDM userManagerDM;

    public ConversationInboxManagerDM(Platform platform2, Domain domain2, UserManagerDM userManagerDM2) {
        this.platform = platform2;
        this.domain = domain2;
        this.userManagerDM = userManagerDM2;
    }

    private ConversationController buildConversationInboxDM(UserDM userDM) {
        return new ConversationController(this.platform, this.domain, userDM);
    }

    public synchronized void deleteConversations(UserDM userDM) {
        ConversationController conversationInboxDM = getConversationInboxDM(userDM);
        if (conversationInboxDM != null) {
            conversationInboxDM.deleteAllConversationsData();
        }
    }

    public synchronized ConversationController getActiveConversationInboxDM() {
        ConversationController conversationController;
        ConversationController conversationController2 = null;
        try {
            UserDM activeUser = this.userManagerDM.getActiveUser();
            conversationController = this.activeUserAndInboxMapping.get(activeUser.getLocalId());
            if (conversationController == null) {
                try {
                    conversationController2 = buildConversationInboxDM(activeUser);
                    conversationController2.initialize();
                    this.activeUserAndInboxMapping.clear();
                    this.activeUserAndInboxMapping.put(activeUser.getLocalId(), conversationController2);
                } catch (Exception e) {
                    e = e;
                    conversationController2 = conversationController;
                    HSLogger.m3242e(TAG, "Exception while setting up active conversation controller", e);
                    this.domain.blockPublicAPI(HSBlockReason.FETCH_ACTIVE_USER_ERROR);
                    conversationController = conversationController2;
                    return conversationController;
                }
                conversationController = conversationController2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return conversationController;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.conversation.domainmodel.ConversationController getConversationInboxDM(com.helpshift.account.domainmodel.UserDM r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0006
            r3 = 0
            monitor-exit(r2)
            return r3
        L_0x0006:
            java.util.Map<java.lang.Long, com.helpshift.conversation.domainmodel.ConversationController> r0 = r2.activeUserAndInboxMapping     // Catch:{ all -> 0x001a }
            java.lang.Long r1 = r3.getLocalId()     // Catch:{ all -> 0x001a }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x001a }
            com.helpshift.conversation.domainmodel.ConversationController r0 = (com.helpshift.conversation.domainmodel.ConversationController) r0     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x0018
            com.helpshift.conversation.domainmodel.ConversationController r0 = r2.buildConversationInboxDM(r3)     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r2)
            return r0
        L_0x001a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.domainmodel.ConversationInboxManagerDM.getConversationInboxDM(com.helpshift.account.domainmodel.UserDM):com.helpshift.conversation.domainmodel.ConversationController");
    }

    public synchronized void resetPreIssueConversations() {
        List<UserDM> allUsers = this.domain.getUserManagerDM().getAllUsers();
        if (!ListUtils.isEmpty(allUsers)) {
            for (UserDM next : allUsers) {
                ConversationController conversationInboxDM = getConversationInboxDM(next);
                if (conversationInboxDM != null) {
                    conversationInboxDM.resetPreIssueConversationsForUser(next);
                }
            }
        }
    }
}
