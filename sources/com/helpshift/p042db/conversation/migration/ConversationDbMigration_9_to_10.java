package com.helpshift.p042db.conversation.migration;

import android.database.sqlite.SQLiteDatabase;
import com.helpshift.p042db.base.IMigrator;

/* renamed from: com.helpshift.db.conversation.migration.ConversationDbMigration_9_to_10 */
public class ConversationDbMigration_9_to_10 implements IMigrator {
    public String ADD_AUTHOR_ID_COLUMN_TO_MESSAGE_TABLE = "ALTER TABLE messages ADD COLUMN author_id TEXT; ";
    public String ADD_AUTHOR_ROLE_COLUMN_TO_MESSAGE_TABLE = "ALTER TABLE messages ADD COLUMN author_role TEXT; ";
    public String ADD_AVATAR_IMAGE_PATH_COLUMN_TO_MESSAGE_TABLE = "ALTER TABLE messages ADD COLUMN local_avatar_image_path TEXT; ";
    public String ADD_CSAT_EXPIRY_AT_COLUMN_TO_CONVERSATION_TABLE = "ALTER TABLE issues ADD COLUMN csat_expiry_at INTEGER ;";
    public String ADD_RESOLUTION_EXPIRY_AT_COLUMN_TO_CONVERSATION_TABLE = "ALTER TABLE issues ADD COLUMN resolution_expiry_at INTEGER ;";
    public final String TAG = "Helpshft_dbMigrate9_10";

    private void migrateTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.ADD_AUTHOR_ID_COLUMN_TO_MESSAGE_TABLE);
        sQLiteDatabase.execSQL(this.ADD_AUTHOR_ROLE_COLUMN_TO_MESSAGE_TABLE);
        sQLiteDatabase.execSQL(this.ADD_AVATAR_IMAGE_PATH_COLUMN_TO_MESSAGE_TABLE);
        sQLiteDatabase.execSQL(this.ADD_RESOLUTION_EXPIRY_AT_COLUMN_TO_CONVERSATION_TABLE);
        sQLiteDatabase.execSQL(this.ADD_CSAT_EXPIRY_AT_COLUMN_TO_CONVERSATION_TABLE);
    }

    public void migrate(SQLiteDatabase sQLiteDatabase) throws Exception {
        migrateTable(sQLiteDatabase);
    }
}
