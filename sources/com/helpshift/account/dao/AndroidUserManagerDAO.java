package com.helpshift.account.dao;

import com.helpshift.common.platform.KVStore;

public class AndroidUserManagerDAO implements UserManagerDAO {
    public static final String USER_META_IDENTIFIER = "userMetaIdentifier";
    public final KVStore kvStore;

    public AndroidUserManagerDAO(KVStore kVStore) {
        this.kvStore = kVStore;
    }

    public String getUserMetaIdentifier() {
        return this.kvStore.getString(USER_META_IDENTIFIER, "");
    }

    public void setUserMetaIdentifier(String str) {
        this.kvStore.setString(USER_META_IDENTIFIER, str);
    }
}
