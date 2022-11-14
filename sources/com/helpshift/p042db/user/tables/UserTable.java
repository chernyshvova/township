package com.helpshift.p042db.user.tables;

/* renamed from: com.helpshift.db.user.tables.UserTable */
public interface UserTable {
    public static final String TABLE_NAME = "user_table";

    /* renamed from: com.helpshift.db.user.tables.UserTable$Columns */
    public interface Columns {
        public static final String ACTIVE = "active";
        public static final String ANONOYMOUS = "anonymous";
        public static final String AUTH_TOKEN = "auth_token";
        public static final String COLUMN_ID = "_id";
        public static final String DEVICE_ID = "deviceid";
        public static final String EMAIL = "email";
        public static final String IDENTIFIER = "identifier";
        public static final String INITIAL_STATE_SYNCED = "initial_state_synced";
        public static final String ISSUE_EXISTS = "issue_exists";
        public static final String NAME = "name";
        public static final String PUSH_TOKEN_SYNCED = "push_token_synced";
    }
}
