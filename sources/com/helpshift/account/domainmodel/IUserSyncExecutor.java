package com.helpshift.account.domainmodel;

import com.helpshift.common.exception.RootAPIException;

public interface IUserSyncExecutor {
    void executeUserSync() throws RootAPIException;
}
