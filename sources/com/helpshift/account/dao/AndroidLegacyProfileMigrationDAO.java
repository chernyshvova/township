package com.helpshift.account.dao;

import com.helpshift.migration.LegacyProfileMigrationDAO;
import com.helpshift.migration.MigrationState;
import com.helpshift.migration.legacyUser.LegacyProfile;
import com.helpshift.util.ListUtils;
import java.util.List;

public class AndroidLegacyProfileMigrationDAO implements LegacyProfileMigrationDAO {
    public final UserDB userDB;

    public AndroidLegacyProfileMigrationDAO(UserDB userDB2) {
        this.userDB = userDB2;
    }

    public void deleteLegacyProfile(String str) {
        if (str != null) {
            this.userDB.deleteLegacyProfile(str);
        }
    }

    public LegacyProfile fetchLegacyProfile(String str) {
        if (str == null) {
            return null;
        }
        return this.userDB.fetchLegacyProfile(str);
    }

    public void storeLegacyProfiles(List<LegacyProfile> list) {
        if (!ListUtils.isEmpty(list)) {
            this.userDB.storeLegacyProfiles(list);
        }
    }

    public boolean updateMigrationState(String str, MigrationState migrationState) {
        if (str == null || migrationState == null) {
            return false;
        }
        return this.userDB.updateUserMigrationState(str, migrationState);
    }
}
