package com.helpshift.migration;

import com.helpshift.migration.legacyUser.LegacyProfile;
import java.util.List;

public interface LegacyProfileMigrationDAO {
    void deleteLegacyProfile(String str);

    LegacyProfile fetchLegacyProfile(String str);

    void storeLegacyProfiles(List<LegacyProfile> list);

    boolean updateMigrationState(String str, MigrationState migrationState);
}
