package com.helpshift.account.dao;

import com.helpshift.account.domainmodel.ClearedUserDM;
import java.util.List;

public interface ClearedUserDAO {
    boolean deleteClearedUser(Long l);

    List<ClearedUserDM> fetchClearedUsers();

    ClearedUserDM insertClearedUser(ClearedUserDM clearedUserDM);

    boolean updateSyncState(Long l, ClearedUserSyncState clearedUserSyncState);
}
