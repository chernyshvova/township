package com.helpshift.p042db.legacy_profile.tables;

/* renamed from: com.helpshift.db.legacy_profile.tables.ProfileTable */
public interface ProfileTable {
    public static final String TABLE_NAME = "profiles";

    /* renamed from: com.helpshift.db.legacy_profile.tables.ProfileTable$Columns */
    public interface Columns {
        public static final String COLUMN_DID = "did";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_IDENTIFIER = "IDENTIFIER";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PROFILE_ID = "profile_id";
        public static final String COLUMN_PUSH_TOKEN_SYNC_STATUS = "push_token_sync";
        public static final String COLUMN_SALT = "salt";
        public static final String COLUMN_UID = "uid";
    }
}
