package com.helpshift.conversation.loaders;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dao.ConversationInboxDAO;
import com.helpshift.conversation.domainmodel.ConversationHistoryRemoteDataFetcher;
import com.helpshift.conversation.domainmodel.ConversationHistoryRemoteDataMerger;
import com.helpshift.conversation.dto.ConversationHistory;
import com.helpshift.util.StringUtils;

public class RemoteConversationLoader {
    public ConversationDAO conversationDAO;
    public ConversationInboxDAO conversationInboxDAO;
    public Domain domain;
    public Platform platform;
    public ConversationHistoryRemoteDataFetcher remoteDataFetcher;
    public ConversationHistoryRemoteDataMerger remoteDataMerger;
    public UserDM userDM;

    public RemoteConversationLoader(Platform platform2, Domain domain2, UserDM userDM2, ConversationManager conversationManager) {
        this.platform = platform2;
        this.domain = domain2;
        this.userDM = userDM2;
        this.conversationDAO = platform2.getConversationDAO();
        this.conversationInboxDAO = platform2.getConversationInboxDAO();
        this.remoteDataFetcher = new ConversationHistoryRemoteDataFetcher(platform2, domain2, userDM2);
        this.remoteDataMerger = new ConversationHistoryRemoteDataMerger(platform2, domain2, userDM2, conversationManager);
    }

    public boolean hasMoreMessage() {
        return this.conversationInboxDAO.getHasOlderMessages(this.userDM.getLocalId().longValue());
    }

    public synchronized boolean loadMoreMessages() throws RootAPIException {
        if (!hasMoreMessage()) {
            return false;
        }
        String oldestMessageCursor = this.conversationDAO.getOldestMessageCursor(this.userDM.getLocalId().longValue());
        if (StringUtils.isEmpty(oldestMessageCursor)) {
            return false;
        }
        try {
            ConversationHistory fetchConversations = this.remoteDataFetcher.fetchConversations(oldestMessageCursor);
            this.conversationInboxDAO.saveHasOlderMessages(this.userDM.getLocalId().longValue(), fetchConversations.hasOlderMessages);
            this.remoteDataMerger.merge(fetchConversations.conversations);
            return true;
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.INVALID_AUTH_TOKEN || e.exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(this.userDM, e.exceptionType);
            }
            throw e;
        }
    }
}
