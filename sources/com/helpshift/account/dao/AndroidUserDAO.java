package com.helpshift.account.dao;

import com.helpshift.account.domainmodel.UserDM;
import java.util.List;

public class AndroidUserDAO implements UserDAO {
    public final UserDB userDB;

    public AndroidUserDAO(UserDB userDB2) {
        this.userDB = userDB2;
    }

    public boolean activateUser(Long l) {
        if (l == null || this.userDB.fetchUser(l) == null) {
            return false;
        }
        return this.userDB.activateUser(l);
    }

    public UserDM createUser(UserDM userDM) {
        if (userDM == null) {
            return null;
        }
        return this.userDB.createUser(userDM);
    }

    public boolean deleteUser(Long l) {
        if (l == null) {
            return false;
        }
        return this.userDB.deleteUser(l);
    }

    public void dropAndCreateDatabase() {
        this.userDB.dropAndCreateDatabase();
    }

    public UserDM fetchUser(Long l) {
        if (l == null) {
            return null;
        }
        return this.userDB.fetchUser(l);
    }

    public List<UserDM> fetchUsers() {
        return this.userDB.fetchUsers();
    }

    public UserDM getActiveUser() {
        return this.userDB.getActiveUser();
    }

    public UserDM getAnonymousUser() {
        return this.userDB.getAnonymousUser();
    }

    public boolean updateUser(UserDM userDM) {
        if (userDM == null) {
            return false;
        }
        return this.userDB.updateUser(userDM);
    }

    public UserDM fetchUser(String str, String str2) {
        if (str == null && str2 == null) {
            return null;
        }
        return this.userDB.fetchUser(str, str2);
    }
}
