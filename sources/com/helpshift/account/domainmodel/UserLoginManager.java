package com.helpshift.account.domainmodel;

import com.helpshift.CoreApi;
import com.helpshift.HelpshiftUser;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.NetworkConstants;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.providers.ICampaignsModuleAPIs;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;

public class UserLoginManager {
    public static final String TAG = "Helpshift_ULoginM";
    public CoreApi coreApi;
    public Domain domain;
    public Platform platform;

    public UserLoginManager(CoreApi coreApi2, Domain domain2, Platform platform2) {
        this.coreApi = coreApi2;
        this.domain = domain2;
        this.platform = platform2;
    }

    private boolean cleanUpActiveUser() {
        ConversationController activeConversationInboxDM = this.domain.getConversationInboxManagerDM().getActiveConversationInboxDM();
        if (activeConversationInboxDM == null) {
            return false;
        }
        activeConversationInboxDM.clearPushNotifications();
        activeConversationInboxDM.getConversationInboxPoller().stop();
        return true;
    }

    private void clearConfigRouteETag() {
        this.platform.getNetworkRequestDAO().removeETag(NetworkConstants.SUPPORT_CONFIG_ROUTE);
    }

    private boolean deleteUser(UserDM userDM) {
        boolean deleteUser = this.coreApi.getUserManagerDM().deleteUser(userDM);
        if (deleteUser) {
            this.platform.getRedactionDAO().deleteRedactionDetail(userDM.getLocalId().longValue());
            this.domain.getConversationInboxManagerDM().deleteConversations(userDM);
            this.domain.getSmartIntentDM().clearUserData(userDM);
        }
        return deleteUser;
    }

    private void setUpActiveUser() {
        ConversationController activeConversationInboxDM = this.domain.getConversationInboxManagerDM().getActiveConversationInboxDM();
        activeConversationInboxDM.showPushNotifications();
        UserSetupDM activeUserSetupDM = this.coreApi.getUserManagerDM().getActiveUserSetupDM();
        if (UserSetupState.COMPLETED == activeUserSetupDM.getState()) {
            activeConversationInboxDM.getConversationInboxPoller().startAppPoller(false);
        } else {
            activeUserSetupDM.startSetup();
        }
    }

    private void updateUserNameAndAuthToken(HelpshiftUser helpshiftUser, UserManagerDM userManagerDM) {
        UserDM activeUser = userManagerDM.getActiveUser();
        String authToken = activeUser.getAuthToken();
        if (StringUtils.isNotEqual(activeUser.getName(), helpshiftUser.getName())) {
            userManagerDM.updateUserName(activeUser, helpshiftUser.getName());
        }
        if (StringUtils.isNotEqual(authToken, helpshiftUser.getAuthToken())) {
            userManagerDM.updateAuthToken(activeUser, helpshiftUser.getAuthToken());
        }
    }

    public boolean clearAnonymousUser() {
        UserManagerDM userManagerDM = this.coreApi.getUserManagerDM();
        UserDM anonymousUser = this.coreApi.getUserManagerDM().getAnonymousUser();
        if (anonymousUser == null) {
            return true;
        }
        if (anonymousUser.isActiveUser()) {
            HSLogger.m3237d(TAG, "clearAnonymousUser should be called when a logged-in user is active");
            return false;
        } else if (!deleteUser(anonymousUser)) {
            return true;
        } else {
            userManagerDM.clearAnonymousUser(anonymousUser);
            return true;
        }
    }

    public void clearPersonallyIdentifiableInformation() {
        if (this.coreApi.isSDKSessionActive()) {
            HSLogger.m3237d(TAG, "clear PII should not be called after starting a Helpshift session");
            return;
        }
        UserManagerDM userManagerDM = this.coreApi.getUserManagerDM();
        UserDM activeUser = userManagerDM.getActiveUser();
        if (!StringUtils.isEmpty(activeUser.getIdentifier())) {
            userManagerDM.resetNameAndEmail(activeUser);
            this.coreApi.getConversationController().saveName((String) null);
            this.coreApi.getConversationController().saveEmail((String) null);
        } else if (logout()) {
            deleteUser(activeUser);
            ICampaignsModuleAPIs campaignModuleAPIs = this.platform.getCampaignModuleAPIs();
            if (campaignModuleAPIs != null) {
                campaignModuleAPIs.logout();
            }
        }
    }

    public boolean login(HelpshiftUser helpshiftUser) {
        boolean z;
        UserManagerDM userManagerDM = this.coreApi.getUserManagerDM();
        boolean z2 = false;
        if (userManagerDM.isActiveUser(helpshiftUser)) {
            z = StringUtils.isNotEqual(userManagerDM.getActiveUser().getAuthToken(), helpshiftUser.getAuthToken());
        } else if (this.coreApi.isSDKSessionActive()) {
            HSLogger.m3237d(TAG, "Login should be called before starting a Helpshift session");
            return false;
        } else {
            cleanUpActiveUser();
            userManagerDM.login(helpshiftUser);
            for (UserDM deleteUser : userManagerDM.getInactiveLoggedInUsers()) {
                deleteUser(deleteUser);
            }
            setUpActiveUser();
            z = true;
            z2 = true;
        }
        updateUserNameAndAuthToken(helpshiftUser, userManagerDM);
        if (z2) {
            clearConfigRouteETag();
        }
        if (z) {
            this.domain.getAutoRetryFailedEventDM().onUserAuthenticationUpdated();
        }
        return true;
    }

    public boolean logout() {
        if (this.coreApi.isSDKSessionActive()) {
            HSLogger.m3237d(TAG, "Logout should be called before starting a Helpshift session");
            return false;
        }
        UserManagerDM userManagerDM = this.coreApi.getUserManagerDM();
        UserDM activeUser = userManagerDM.getActiveUser();
        if (activeUser != null && activeUser.isAnonymousUser()) {
            return true;
        }
        if (!cleanUpActiveUser()) {
            return false;
        }
        boolean loginWithAnonymousUser = userManagerDM.loginWithAnonymousUser();
        setUpActiveUser();
        if (loginWithAnonymousUser) {
            clearConfigRouteETag();
            this.domain.getAutoRetryFailedEventDM().onUserAuthenticationUpdated();
        }
        return loginWithAnonymousUser;
    }
}
