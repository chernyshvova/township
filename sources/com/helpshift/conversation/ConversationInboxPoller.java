package com.helpshift.conversation;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.app.AppLifeCycleStateHolder;
import com.helpshift.common.domain.PollFunction;
import com.helpshift.common.domain.Poller;
import com.helpshift.common.domain.PollingInterval;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ConversationInboxPoller implements Observer {
    public static final long INITIAL_DELAY = 3000;
    public static final String TAG = "Helpshift_ConvPoller";
    public final ConversationDAO conversationDAO;
    public PollingInterval currentPollingInterval;
    public PollFunction.PollFunctionListener pollFunctionListener = new PollFunction.PollFunctionListener() {
        public void onPollingStoppedViaBackoffStrategy() {
            HSLogger.m3237d(ConversationInboxPoller.TAG, "Poll stopped via backoff, resetting currentPollingInterval");
            ConversationInboxPoller.this.stop();
        }
    };
    public final Poller poller;
    public final SDKConfigurationDM sdkConfigurationDM;
    public final UserDM userDM;

    public ConversationInboxPoller(UserDM userDM2, SDKConfigurationDM sDKConfigurationDM, Poller poller2, ConversationDAO conversationDAO2) {
        this.userDM = userDM2;
        this.sdkConfigurationDM = sDKConfigurationDM;
        this.poller = poller2;
        this.conversationDAO = conversationDAO2;
    }

    private boolean shouldStartSDKPoller() {
        return AppLifeCycleStateHolder.isAppInForeground() && this.userDM.issueExists() && !this.userDM.isPushTokenSynced() && !this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.DISABLE_IN_APP_CONVERSATION);
    }

    public void refreshPoller(boolean z) {
        if (!AppLifeCycleStateHolder.isAppInForeground() || !this.userDM.isActiveUser()) {
            stop();
        } else if (this.currentPollingInterval == PollingInterval.AGGRESSIVE) {
            startChatPoller();
        } else {
            startAppPoller(z);
        }
    }

    public void startAppPoller(boolean z) {
        if (!shouldStartSDKPoller()) {
            stop();
            return;
        }
        List data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (ListUtils.isEmpty(data) || ConversationUtil.getLastConversationBasedOnCreatedAt(data).state == IssueState.REJECTED) {
            HSLogger.m3237d(TAG, "Stopped listening for conversation updates : no issues or latest is rejected.");
            stop();
            return;
        }
        PollingInterval pollingInterval = !ConversationUtil.shouldPollActivelyForConversations(data) ? PollingInterval.PASSIVE : PollingInterval.CONSERVATIVE;
        if (this.currentPollingInterval != pollingInterval) {
            stop();
            this.currentPollingInterval = pollingInterval;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Listening for conversation updates : ");
            outline24.append(this.currentPollingInterval);
            HSLogger.m3237d(TAG, outline24.toString());
            this.poller.start(pollingInterval, z ? 3000 : 0, this.pollFunctionListener);
        }
    }

    public void startChatPoller() {
        if (!AppLifeCycleStateHolder.isAppInForeground()) {
            stop();
        } else if (this.currentPollingInterval != PollingInterval.AGGRESSIVE) {
            stop();
            this.currentPollingInterval = PollingInterval.AGGRESSIVE;
            HSLogger.m3237d(TAG, "Listening for in-chat conversation updates");
            this.poller.start(PollingInterval.AGGRESSIVE, 0, this.pollFunctionListener);
        }
    }

    public void stop() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Stopped listening for conversation updates : ");
        outline24.append(this.currentPollingInterval);
        HSLogger.m3237d(TAG, outline24.toString());
        this.poller.stop();
        this.currentPollingInterval = null;
    }

    public void update(Observable observable, Object obj) {
        refreshPoller(true);
    }
}
