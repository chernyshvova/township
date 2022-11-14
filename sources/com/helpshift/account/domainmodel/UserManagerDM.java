package com.helpshift.account.domainmodel;

import com.helpshift.HelpshiftUser;
import com.helpshift.account.UserDMObserver;
import com.helpshift.account.dao.ClearedUserDAO;
import com.helpshift.account.dao.ClearedUserSyncState;
import com.helpshift.account.dao.UserDAO;
import com.helpshift.account.dao.UserManagerDAO;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.AutoRetriableDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.HelpshiftUtils;
import com.helpshift.common.dao.BackupDAO;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.AuthenticationFailureNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.Network;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.PUTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.domain.network.UserNotFoundNetwork;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Device;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserManagerDM implements AutoRetriableDM {
    public static final String ANONYMOUS_USER_ID_BACKUP_KEY = "anonymous_user_id_backup_key";
    public UserDM activeUserDM;
    public UserSetupDM activeUserSetupDM;
    public BackupDAO backupDAO;
    public ClearedUserDAO clearedUserDAO;
    public Device device;
    public Domain domain;
    public Platform platform;
    public UserDAO userDAO;
    public Set<UserDMObserver> userDMObservers;
    public UserManagerDAO userManagerDAO;

    /* renamed from: com.helpshift.account.domainmodel.UserManagerDM$3 */
    public static /* synthetic */ class C24733 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.helpshift.common.AutoRetryFailedEventDM$EventType[] r0 = com.helpshift.common.AutoRetryFailedEventDM.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType = r0
                r1 = 2
                com.helpshift.common.AutoRetryFailedEventDM$EventType r2 = com.helpshift.common.AutoRetryFailedEventDM.EventType.PUSH_TOKEN     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.common.AutoRetryFailedEventDM$EventType r2 = com.helpshift.common.AutoRetryFailedEventDM.EventType.CLEAR_USER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 3
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.domainmodel.UserManagerDM.C24733.<clinit>():void");
        }
    }

    public UserManagerDM(Platform platform2, Domain domain2) {
        this.platform = platform2;
        this.domain = domain2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void activateUser(com.helpshift.account.domainmodel.UserDM r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            com.helpshift.account.domainmodel.UserDM r0 = r2.activeUserDM     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x001b
            com.helpshift.account.domainmodel.UserDM r0 = r2.activeUserDM     // Catch:{ all -> 0x0058 }
            java.lang.Long r0 = r0.getLocalId()     // Catch:{ all -> 0x0058 }
            java.lang.Long r1 = r3.getLocalId()     // Catch:{ all -> 0x0058 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x001b
            monitor-exit(r2)
            return
        L_0x001b:
            com.helpshift.account.dao.UserDAO r0 = r2.userDAO     // Catch:{ all -> 0x0058 }
            java.lang.Long r1 = r3.getLocalId()     // Catch:{ all -> 0x0058 }
            boolean r0 = r0.activateUser(r1)     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x0056
            com.helpshift.account.domainmodel.UserDM r0 = r2.activeUserDM     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x0040
            com.helpshift.account.domainmodel.UserDM$Builder r0 = new com.helpshift.account.domainmodel.UserDM$Builder     // Catch:{ all -> 0x0058 }
            com.helpshift.account.domainmodel.UserDM r1 = r2.activeUserDM     // Catch:{ all -> 0x0058 }
            r0.<init>(r1)     // Catch:{ all -> 0x0058 }
            r1 = 0
            com.helpshift.account.domainmodel.UserDM$Builder r0 = r0.setIsActiveUser(r1)     // Catch:{ all -> 0x0058 }
            com.helpshift.account.domainmodel.UserDM r0 = r0.build()     // Catch:{ all -> 0x0058 }
            com.helpshift.account.domainmodel.UserDM r1 = r2.activeUserDM     // Catch:{ all -> 0x0058 }
            r2.notifyUserDMObservers(r1, r0)     // Catch:{ all -> 0x0058 }
        L_0x0040:
            com.helpshift.account.domainmodel.UserDM$Builder r0 = new com.helpshift.account.domainmodel.UserDM$Builder     // Catch:{ all -> 0x0058 }
            r0.<init>(r3)     // Catch:{ all -> 0x0058 }
            r3 = 1
            com.helpshift.account.domainmodel.UserDM$Builder r3 = r0.setIsActiveUser(r3)     // Catch:{ all -> 0x0058 }
            com.helpshift.account.domainmodel.UserDM r3 = r3.build()     // Catch:{ all -> 0x0058 }
            r2.activeUserDM = r3     // Catch:{ all -> 0x0058 }
            r0 = 0
            r2.activeUserSetupDM = r0     // Catch:{ all -> 0x0058 }
            r2.addUserDMObserver(r3)     // Catch:{ all -> 0x0058 }
        L_0x0056:
            monitor-exit(r2)
            return
        L_0x0058:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.domainmodel.UserManagerDM.activateUser(com.helpshift.account.domainmodel.UserDM):void");
    }

    private synchronized void addUserDMObserver(UserDMObserver userDMObserver) {
        if (userDMObserver != null) {
            if (this.userDMObservers == null) {
                this.userDMObservers = new HashSet();
            }
            this.userDMObservers.add(userDMObserver);
        }
    }

    private Network buildCreateProfileNetwork() {
        return new GuardOKNetwork(new TSCorrectedNetwork(new AuthenticationFailureNetwork(new POSTNetwork("/profiles/", this.domain, this.platform)), this.platform));
    }

    private synchronized UserDM buildUser(HelpshiftUser helpshiftUser) {
        return new UserDM((Long) null, helpshiftUser.getIdentifier(), helpshiftUser.getEmail(), helpshiftUser.getName(), this.device.getDeviceId(), false, false, false, helpshiftUser.getAuthToken(), true, UserSyncStatus.NOT_STARTED);
    }

    /* access modifiers changed from: private */
    public void clearAnonymousUserInternal(ClearedUserDM clearedUserDM) {
        ClearedUserSyncState clearedUserSyncState;
        if (clearedUserDM != null && clearedUserDM.localId != null && (clearedUserSyncState = clearedUserDM.syncState) != ClearedUserSyncState.COMPLETED && clearedUserSyncState != ClearedUserSyncState.IN_PROGRESS) {
            GuardOKNetwork guardOKNetwork = new GuardOKNetwork(new FailedAPICallNetworkDecorator(new UserNotFoundNetwork(new TSCorrectedNetwork(new PUTNetwork("/clear-profile/", this.domain, this.platform), this.platform))));
            HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(clearedUserDM);
            this.clearedUserDAO.updateSyncState(clearedUserDM.localId, ClearedUserSyncState.IN_PROGRESS);
            try {
                guardOKNetwork.makeRequest(new RequestData((Map<String, String>) userRequestData));
                this.clearedUserDAO.updateSyncState(clearedUserDM.localId, ClearedUserSyncState.COMPLETED);
                this.clearedUserDAO.deleteClearedUser(clearedUserDM.localId);
            } catch (RootAPIException e) {
                ExceptionType exceptionType = e.exceptionType;
                if (exceptionType == NetworkException.USER_NOT_FOUND || exceptionType == NetworkException.NON_RETRIABLE) {
                    this.clearedUserDAO.updateSyncState(clearedUserDM.localId, ClearedUserSyncState.COMPLETED);
                    this.clearedUserDAO.deleteClearedUser(clearedUserDM.localId);
                    return;
                }
                this.clearedUserDAO.updateSyncState(clearedUserDM.localId, ClearedUserSyncState.FAILED);
                throw e;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String generateAnonymousUserId() {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            com.helpshift.common.dao.BackupDAO r1 = r5.backupDAO     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "anonymous_user_id_backup_key"
            java.io.Serializable r1 = r1.getValue(r2)     // Catch:{ all -> 0x0054 }
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0054 }
            if (r2 == 0) goto L_0x0011
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0054 }
        L_0x0011:
            boolean r1 = com.helpshift.util.StringUtils.isEmpty(r0)     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0052
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0054 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r2.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = "hsft_anon_"
            r2.append(r3)     // Catch:{ all -> 0x0054 }
            com.helpshift.util.HSSimpleDateFormat r3 = com.helpshift.util.HSFormat.timeStampAnonymousUserFormat     // Catch:{ all -> 0x0054 }
            java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x0054 }
            r4.<init>(r0)     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = r3.format((java.util.Date) r4)     // Catch:{ all -> 0x0054 }
            r2.append(r0)     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = "-"
            r2.append(r0)     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = "abcdefghijklmnopqrstuvwxyz0123456789"
            char[] r0 = r0.toCharArray()     // Catch:{ all -> 0x0054 }
            r1 = 15
            java.lang.String r0 = com.helpshift.util.StringUtils.generateRandomString(r0, r1)     // Catch:{ all -> 0x0054 }
            r2.append(r0)     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0054 }
            com.helpshift.common.dao.BackupDAO r1 = r5.backupDAO     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "anonymous_user_id_backup_key"
            r1.storeValue(r2, r0)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r5)
            return r0
        L_0x0054:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.domainmodel.UserManagerDM.generateAnonymousUserId():java.lang.String");
    }

    private synchronized void notifyUserDMObservers(UserDM userDM, UserDM userDM2) {
        if (this.userDMObservers != null) {
            for (UserDMObserver onUserDataChange : this.userDMObservers) {
                onUserDataChange.onUserDataChange(userDM, userDM2);
            }
        }
    }

    private void sendPushTokenInternal() {
        String pushToken = this.device.getPushToken();
        UserDM activeUser = getActiveUser();
        if (!StringUtils.isEmpty(pushToken) && !activeUser.isPushTokenSynced() && activeUser.issueExists() && getActiveUserSetupDM().getState() == UserSetupState.COMPLETED) {
            HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(activeUser);
            userRequestData.put("token", pushToken);
            try {
                new GuardOKNetwork(new FailedAPICallNetworkDecorator(new UserNotFoundNetwork(new AuthenticationFailureNetwork(new TSCorrectedNetwork(new POSTNetwork("/update-push-token/", this.domain, this.platform), this.platform))))).makeRequest(new RequestData((Map<String, String>) userRequestData));
                updateIsPushTokenSynced(activeUser, true);
            } catch (RootAPIException e) {
                ExceptionType exceptionType = e.exceptionType;
                if (exceptionType != NetworkException.USER_NOT_FOUND) {
                    if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                        this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(activeUser, e.exceptionType);
                        throw e;
                    } else if (exceptionType == NetworkException.NON_RETRIABLE) {
                        updateIsPushTokenSynced(activeUser, true);
                    } else {
                        throw e;
                    }
                }
            }
        }
    }

    private void updateAnonymousIDInBackupDAO() {
        UserDM anonymousUser = getAnonymousUser();
        if (anonymousUser != null) {
            this.backupDAO.storeValue(ANONYMOUS_USER_ID_BACKUP_KEY, anonymousUser.getIdentifier());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void updateIsPushTokenSynced(com.helpshift.account.domainmodel.UserDM r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r2.isPushTokenSynced()     // Catch:{ all -> 0x0023 }
            if (r0 != r3) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            com.helpshift.account.domainmodel.UserDM$Builder r0 = new com.helpshift.account.domainmodel.UserDM$Builder     // Catch:{ all -> 0x0023 }
            r0.<init>(r2)     // Catch:{ all -> 0x0023 }
            com.helpshift.account.domainmodel.UserDM$Builder r3 = r0.setIsPushTokenSynced(r3)     // Catch:{ all -> 0x0023 }
            com.helpshift.account.domainmodel.UserDM r3 = r3.build()     // Catch:{ all -> 0x0023 }
            com.helpshift.account.dao.UserDAO r0 = r1.userDAO     // Catch:{ all -> 0x0023 }
            boolean r0 = r0.updateUser(r3)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0021
            r1.notifyUserDMObservers(r2, r3)     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r1)
            return
        L_0x0023:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.domainmodel.UserManagerDM.updateIsPushTokenSynced(com.helpshift.account.domainmodel.UserDM, boolean):void");
    }

    public void clearAnonymousUser(UserDM userDM) {
        final ClearedUserDM insertClearedUser = this.clearedUserDAO.insertClearedUser(new ClearedUserDM((Long) null, userDM.getIdentifier(), userDM.getEmail(), userDM.getAuthToken(), userDM.getDeviceId(), ClearedUserSyncState.NOT_STARTED));
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    UserManagerDM.this.clearAnonymousUserInternal(insertClearedUser);
                } catch (RootAPIException e) {
                    UserManagerDM.this.domain.getAutoRetryFailedEventDM().scheduleRetryTaskForEventType(AutoRetryFailedEventDM.EventType.CLEAR_USER, e.getServerStatusCode());
                    throw e;
                }
            }
        });
    }

    public synchronized UserDM createAnonymousUser() {
        return this.userDAO.createUser(new UserDM((Long) null, generateAnonymousUserId(), (String) null, (String) null, this.device.getDeviceId(), false, true, false, (String) null, true, UserSyncStatus.NOT_STARTED));
    }

    public boolean deleteUser(UserDM userDM) {
        Long localId;
        if (userDM == null) {
            return false;
        }
        boolean deleteUser = this.userDAO.deleteUser(userDM.getLocalId());
        if (deleteUser) {
            if (userDM.isAnonymousUser()) {
                this.backupDAO.removeKey(ANONYMOUS_USER_ID_BACKUP_KEY);
            }
            UserDM userDM2 = this.activeUserDM;
            if (!(userDM2 == null || (localId = userDM2.getLocalId()) == null || !localId.equals(userDM.getLocalId()))) {
                Set<UserDMObserver> set = this.userDMObservers;
                if (set != null) {
                    set.remove(this.activeUserDM);
                }
                this.activeUserDM = null;
                this.activeUserSetupDM = null;
            }
        }
        return deleteUser;
    }

    public synchronized void destroyUserSetupDM() {
        this.activeUserSetupDM = null;
    }

    public UserDM getActiveUser() {
        UserDM userDM = this.activeUserDM;
        if (userDM != null) {
            return userDM;
        }
        UserDM activeUser = this.userDAO.getActiveUser();
        this.activeUserDM = activeUser;
        if (activeUser == null) {
            loginWithAnonymousUser();
        } else {
            addUserDMObserver(activeUser);
            this.activeUserSetupDM = null;
        }
        return this.activeUserDM;
    }

    public synchronized UserSetupDM getActiveUserSetupDM() {
        if (this.activeUserSetupDM == null) {
            UserSetupDM userSetupDM = new UserSetupDM(this.platform, this.domain, getActiveUser(), this, this.domain.getConversationInboxManagerDM().getActiveConversationInboxDM());
            userSetupDM.init();
            this.activeUserSetupDM = userSetupDM;
        }
        return this.activeUserSetupDM;
    }

    public List<UserDM> getAllUsers() {
        return this.userDAO.fetchUsers();
    }

    public UserDM getAnonymousUser() {
        UserDM userDM = this.activeUserDM;
        if (userDM == null || !userDM.isAnonymousUser()) {
            return this.userDAO.getAnonymousUser();
        }
        return this.activeUserDM;
    }

    public List<UserDM> getInactiveLoggedInUsers() {
        List<UserDM> fetchUsers = this.userDAO.fetchUsers();
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(fetchUsers)) {
            return arrayList;
        }
        for (UserDM next : fetchUsers) {
            if (!next.isAnonymousUser() && !next.isActiveUser()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public String getUserMetaIdentifier() {
        UserDM activeUser = getActiveUser();
        if (activeUser.isAnonymousUser()) {
            return this.userManagerDAO.getUserMetaIdentifier();
        }
        return activeUser.getIdentifier();
    }

    public void init() {
        this.device = this.platform.getDevice();
        this.userDAO = this.platform.getUserDAO();
        this.userManagerDAO = this.platform.getUserManagerDAO();
        this.backupDAO = this.platform.getBackupDAO();
        this.clearedUserDAO = this.platform.getClearedUserDAO();
        this.domain.getAutoRetryFailedEventDM().register(AutoRetryFailedEventDM.EventType.PUSH_TOKEN, this);
        this.domain.getAutoRetryFailedEventDM().register(AutoRetryFailedEventDM.EventType.CLEAR_USER, this);
        updateAnonymousIDInBackupDAO();
    }

    public boolean isActiveUser(HelpshiftUser helpshiftUser) {
        if (!HelpshiftUtils.isValidHelpshiftUser(helpshiftUser)) {
            return false;
        }
        UserDM userDM = this.activeUserDM;
        if (userDM == null) {
            userDM = this.userDAO.getActiveUser();
        }
        if (userDM == null) {
            return false;
        }
        if (StringUtils.isEmptyWithoutTrim(helpshiftUser.getIdentifier())) {
            if (StringUtils.isEmptyWithoutTrim(userDM.getIdentifier())) {
                return helpshiftUser.getEmail().equals(userDM.getEmail());
            }
            return false;
        } else if (StringUtils.isEmptyWithoutTrim(helpshiftUser.getEmail())) {
            if (StringUtils.isEmptyWithoutTrim(userDM.getEmail())) {
                return helpshiftUser.getIdentifier().equals(userDM.getIdentifier());
            }
            return false;
        } else if (!helpshiftUser.getIdentifier().equals(userDM.getIdentifier()) || !helpshiftUser.getEmail().equals(userDM.getEmail())) {
            return false;
        } else {
            return true;
        }
    }

    public synchronized void login(HelpshiftUser helpshiftUser) {
        UserDM fetchUser = this.userDAO.fetchUser(helpshiftUser.getIdentifier(), helpshiftUser.getEmail());
        if (fetchUser == null) {
            fetchUser = this.userDAO.createUser(buildUser(helpshiftUser));
        }
        if (fetchUser != null) {
            addUserDMObserver(fetchUser);
            activateUser(fetchUser);
        }
    }

    public synchronized boolean loginWithAnonymousUser() {
        UserDM anonymousUser = getAnonymousUser();
        if (anonymousUser == null) {
            anonymousUser = createAnonymousUser();
        }
        activateUser(anonymousUser);
        return true;
    }

    public void registerUserWithServer(UserDM userDM) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
        userRequestData.put("name", userDM.getName());
        try {
            buildCreateProfileNetwork().makeRequest(new RequestData((Map<String, String>) userRequestData));
        } catch (RootAPIException e) {
            ExceptionType exceptionType = e.exceptionType;
            if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(userDM, e.exceptionType);
            }
            throw e;
        }
    }

    public void resetNameAndEmail(UserDM userDM) {
        UserDM build = new UserDM.Builder(userDM).setEmail((String) null).setName((String) null).build();
        if (this.userDAO.updateUser(build)) {
            notifyUserDMObservers(userDM, build);
        }
    }

    public synchronized void resetPushTokenSyncStatusForUsers() {
        for (UserDM next : this.userDAO.fetchUsers()) {
            if (this.activeUserDM == null || !next.getLocalId().equals(this.activeUserDM.getLocalId())) {
                updateIsPushTokenSynced(next, false);
            } else {
                updateIsPushTokenSynced(this.activeUserDM, false);
            }
        }
    }

    public synchronized void resetSyncState(UserDM userDM) {
        updateSyncState(userDM, UserSyncStatus.NOT_STARTED);
    }

    public synchronized void resetSyncStateForAllUsers() {
        for (UserDM resetSyncState : getAllUsers()) {
            resetSyncState(resetSyncState);
        }
        destroyUserSetupDM();
    }

    public void sendFailedApiCalls(AutoRetryFailedEventDM.EventType eventType) {
        int ordinal = eventType.ordinal();
        if (ordinal == 2) {
            sendPushTokenInternal();
        } else if (ordinal == 3) {
            List<ClearedUserDM> fetchClearedUsers = this.clearedUserDAO.fetchClearedUsers();
            if (!ListUtils.isEmpty(fetchClearedUsers)) {
                for (ClearedUserDM next : fetchClearedUsers) {
                    if (next.syncState == ClearedUserSyncState.COMPLETED) {
                        this.clearedUserDAO.deleteClearedUser(next.localId);
                    } else {
                        clearAnonymousUserInternal(next);
                    }
                }
            }
        }
    }

    public synchronized void sendPushToken() {
        if (getActiveUserSetupDM().getState() == UserSetupState.COMPLETED) {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UserManagerDM.this.sendPushTokenSync();
                }
            });
        }
    }

    public synchronized void sendPushTokenSync() {
        try {
            sendPushTokenInternal();
        } catch (RootAPIException e) {
            this.domain.getAutoRetryFailedEventDM().scheduleRetryTaskForEventType(AutoRetryFailedEventDM.EventType.PUSH_TOKEN, e.getServerStatusCode());
            throw e;
        }
    }

    public void setUserMetaIdentifier(String str) {
        this.userManagerDAO.setUserMetaIdentifier(str);
    }

    public synchronized void updateAuthToken(UserDM userDM, String str) {
        UserDM build = new UserDM.Builder(userDM).setAuthToken(str).build();
        if (this.userDAO.updateUser(build)) {
            notifyUserDMObservers(userDM, build);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateIssueExists(com.helpshift.account.domainmodel.UserDM r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r2.issueExists()     // Catch:{ all -> 0x0023 }
            if (r0 != r3) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            com.helpshift.account.domainmodel.UserDM$Builder r0 = new com.helpshift.account.domainmodel.UserDM$Builder     // Catch:{ all -> 0x0023 }
            r0.<init>(r2)     // Catch:{ all -> 0x0023 }
            com.helpshift.account.domainmodel.UserDM$Builder r3 = r0.setIssueExists(r3)     // Catch:{ all -> 0x0023 }
            com.helpshift.account.domainmodel.UserDM r3 = r3.build()     // Catch:{ all -> 0x0023 }
            com.helpshift.account.dao.UserDAO r0 = r1.userDAO     // Catch:{ all -> 0x0023 }
            boolean r0 = r0.updateUser(r3)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0021
            r1.notifyUserDMObservers(r2, r3)     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r1)
            return
        L_0x0023:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.domainmodel.UserManagerDM.updateIssueExists(com.helpshift.account.domainmodel.UserDM, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateSyncState(com.helpshift.account.domainmodel.UserDM r2, com.helpshift.account.domainmodel.UserSyncStatus r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.helpshift.account.domainmodel.UserSyncStatus r0 = r2.getSyncState()     // Catch:{ all -> 0x0023 }
            if (r0 != r3) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            com.helpshift.account.domainmodel.UserDM$Builder r0 = new com.helpshift.account.domainmodel.UserDM$Builder     // Catch:{ all -> 0x0023 }
            r0.<init>(r2)     // Catch:{ all -> 0x0023 }
            com.helpshift.account.domainmodel.UserDM$Builder r3 = r0.setSyncState(r3)     // Catch:{ all -> 0x0023 }
            com.helpshift.account.domainmodel.UserDM r3 = r3.build()     // Catch:{ all -> 0x0023 }
            com.helpshift.account.dao.UserDAO r0 = r1.userDAO     // Catch:{ all -> 0x0023 }
            boolean r0 = r0.updateUser(r3)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0021
            r1.notifyUserDMObservers(r2, r3)     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r1)
            return
        L_0x0023:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.domainmodel.UserManagerDM.updateSyncState(com.helpshift.account.domainmodel.UserDM, com.helpshift.account.domainmodel.UserSyncStatus):void");
    }

    public synchronized void updateUserName(UserDM userDM, String str) {
        UserDM build = new UserDM.Builder(userDM).setName(str).build();
        if (this.userDAO.updateUser(build)) {
            notifyUserDMObservers(userDM, build);
        }
    }
}
