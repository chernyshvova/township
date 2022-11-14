package com.helpshift.migration.legacyUser;

import com.helpshift.migration.MigrationState;

public class LegacyProfile {
    public final String email;
    public final String identifier;
    public final MigrationState migrationState;
    public final String name;
    public final String serverId;

    public LegacyProfile(String str, String str2, String str3, String str4, MigrationState migrationState2) {
        this.identifier = str;
        this.email = str2;
        this.name = str3;
        this.serverId = str4;
        this.migrationState = migrationState2;
    }
}
