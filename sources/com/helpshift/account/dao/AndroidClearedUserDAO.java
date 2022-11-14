package com.helpshift.account.dao;

import com.helpshift.account.domainmodel.ClearedUserDM;
import java.util.List;

public class AndroidClearedUserDAO implements ClearedUserDAO {
    public final UserDB userDB;

    public AndroidClearedUserDAO(UserDB userDB2) {
        this.userDB = userDB2;
    }

    public boolean deleteClearedUser(Long l) {
        if (l == null) {
            return false;
        }
        return this.userDB.deleteClearedUser(l);
    }

    public List<ClearedUserDM> fetchClearedUsers() {
        return this.userDB.fetchClearedUsers();
    }

    public ClearedUserDM insertClearedUser(ClearedUserDM clearedUserDM) {
        if (clearedUserDM == null) {
            return null;
        }
        return this.userDB.insertClearedUser(clearedUserDM);
    }

    public boolean updateSyncState(Long l, ClearedUserSyncState clearedUserSyncState) {
        if (l == null || clearedUserSyncState == null) {
            return false;
        }
        return this.userDB.updateClearedUserSyncState(l, clearedUserSyncState);
    }
}
