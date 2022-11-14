package com.helpshift.migration.legacyUser;

import com.helpshift.account.dao.ProfileDTO;
import java.util.List;

public interface LegacyProfileDAO {
    void deleteProfiles();

    List<ProfileDTO> fetchProfiles();
}
