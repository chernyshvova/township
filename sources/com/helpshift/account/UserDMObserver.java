package com.helpshift.account;

import com.helpshift.account.domainmodel.UserDM;

public interface UserDMObserver {
    void onUserDataChange(UserDM userDM, UserDM userDM2);
}
