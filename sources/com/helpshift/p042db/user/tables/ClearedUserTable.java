package com.helpshift.p042db.user.tables;

/* renamed from: com.helpshift.db.user.tables.ClearedUserTable */
public interface ClearedUserTable {
    public static final String TABLE_NAME = "cleared_user_table";

    /* renamed from: com.helpshift.db.user.tables.ClearedUserTable$Columns */
    public interface Columns {
        public static final String AUTH_TOKEN = "auth_token";
        public static final String COLUMN_ID = "_id";
        public static final String DEVICE_ID = "deviceid";
        public static final String EMAIL = "email";
        public static final String IDENTIFIER = "identifier";
        public static final String NAME = "name";
        public static final String SYNC_STATE = "sync_state";
    }
}
