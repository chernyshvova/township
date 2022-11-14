package com.helpshift.conversation.domainmodel;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.AuthenticationFailureNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.Network;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.conversation.dto.ConversationHistory;
import java.util.HashMap;
import java.util.Map;

public class ConversationHistoryRemoteDataFetcher {
    public Domain domain;
    public Platform platform;
    public UserDM userDM;

    public ConversationHistoryRemoteDataFetcher(Platform platform2, Domain domain2, UserDM userDM2) {
        this.platform = platform2;
        this.domain = domain2;
        this.userDM = userDM2;
    }

    private Network buildFetchNetwork() {
        return new GuardOKNetwork(new TSCorrectedNetwork(new FailedAPICallNetworkDecorator(new AuthenticationFailureNetwork(new POSTNetwork("/conversations/history/", this.domain, this.platform))), this.platform));
    }

    private RequestData buildRequestData(String str) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(this.userDM);
        userRequestData.put("cursor", str);
        return new RequestData((Map<String, String>) userRequestData);
    }

    public ConversationHistory fetchConversations(String str) throws RootAPIException {
        return this.platform.getResponseParser().parseConversationHistory(buildFetchNetwork().makeRequest(buildRequestData(str)).responseString);
    }
}
