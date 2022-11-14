package com.helpshift.p042db.conversation.migration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.p042db.base.IMigrator;

/* renamed from: com.helpshift.db.conversation.migration.ConversationDbMigration_7_to_8 */
public class ConversationDbMigration_7_to_8 implements IMigrator {
    public final String CREATE_CONVERSATION_TABLE_DB_VERSION_8;
    public String RENAME_CONVERSATION_TABLE;
    public String TEMP_TABLE_CONVERSATIONS = "issues_old";

    public ConversationDbMigration_7_to_8() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("ALTER TABLE issues RENAME TO ");
        outline24.append(this.TEMP_TABLE_CONVERSATIONS);
        this.RENAME_CONVERSATION_TABLE = outline24.toString();
        this.CREATE_CONVERSATION_TABLE_DB_VERSION_8 = "CREATE TABLE issues ( _id INTEGER PRIMARY KEY AUTOINCREMENT,server_id TEXT UNIQUE, pre_conv_server_id TEXT UNIQUE, publish_id TEXT, uuid TEXT NOT NULL, user_local_id TEXT NOT NULL, title TEXT NOT NULL,issue_type TEXT NOT NULL, state INTEGER NOT NULL, show_agent_name INTEGER,message_cursor TEXT,start_new_conversation_action INTEGER, is_redacted INTEGER, meta TEXT,last_user_activity_time INTEGER, full_privacy_enabled INTEGER, epoch_time_created_at INTEGER NOT NULL, created_at TEXT NOT NULL,updated_at TEXT NOT NULL  );";
    }

    private void dropTemporaryTables(SQLiteDatabase sQLiteDatabase) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("DROP TABLE IF EXISTS ");
        outline24.append(this.TEMP_TABLE_CONVERSATIONS);
        sQLiteDatabase.execSQL(outline24.toString());
    }

    private int getDuplicacyRecord(SQLiteDatabase sQLiteDatabase) {
        return getDuplicateRecord("SELECT Count(server_id) , Count(DISTINCT server_id) FROM issues", sQLiteDatabase) + getDuplicateRecord("SELECT Count(pre_conv_server_id) , Count(DISTINCT pre_conv_server_id) FROM issues", sQLiteDatabase);
    }

    private int getDuplicateRecord(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, (String[]) null);
        try {
            int i = 0;
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0) - rawQuery.getInt(1);
            }
            rawQuery.close();
            return i;
        } catch (Throwable th) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    private void migrateData(SQLiteDatabase sQLiteDatabase) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("INSERT INTO issues (_id, server_id, pre_conv_server_id, publish_id, uuid, user_local_id, title,issue_type, state, show_agent_name,message_cursor,start_new_conversation_action, is_redacted, meta,last_user_activity_time, full_privacy_enabled, epoch_time_created_at, created_at, updated_at ) SELECT _id, server_id, pre_conv_server_id, publish_id, uuid, user_local_id, title,issue_type, state, show_agent_name,message_cursor,start_new_conversation_action, is_redacted, meta,last_user_activity_time, full_privacy_enabled, epoch_time_created_at, created_at, updated_at FROM ");
        outline24.append(this.TEMP_TABLE_CONVERSATIONS);
        sQLiteDatabase.execSQL(outline24.toString());
    }

    private void migrateTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.RENAME_CONVERSATION_TABLE);
        sQLiteDatabase.execSQL("CREATE TABLE issues ( _id INTEGER PRIMARY KEY AUTOINCREMENT,server_id TEXT UNIQUE, pre_conv_server_id TEXT UNIQUE, publish_id TEXT, uuid TEXT NOT NULL, user_local_id TEXT NOT NULL, title TEXT NOT NULL,issue_type TEXT NOT NULL, state INTEGER NOT NULL, show_agent_name INTEGER,message_cursor TEXT,start_new_conversation_action INTEGER, is_redacted INTEGER, meta TEXT,last_user_activity_time INTEGER, full_privacy_enabled INTEGER, epoch_time_created_at INTEGER NOT NULL, created_at TEXT NOT NULL,updated_at TEXT NOT NULL  );");
    }

    public void migrate(SQLiteDatabase sQLiteDatabase) throws Exception {
        if (getDuplicacyRecord(sQLiteDatabase) == 0) {
            migrateTable(sQLiteDatabase);
            migrateData(sQLiteDatabase);
            dropTemporaryTables(sQLiteDatabase);
            return;
        }
        throw new Exception("Migration not possible as duplicate issue exists");
    }
}
