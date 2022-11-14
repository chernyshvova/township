package com.helpshift.p042db.conversation.migration;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.helpshift.account.dao.UserDB;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.p042db.conversation.tables.ConversationTable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.helpshift.db.conversation.migration.ConversationDbMigration_6_to_7 */
public class ConversationDbMigration_6_to_7 implements IMigrator {
    public String ADD_EPOCH_TIME_CREATE_AT_COLUMN_INTO_CONVERSATIONS_TABLE = "ALTER TABLE issues ADD COLUMN epoch_time_created_at INTEGER NOT NULL DEFAULT 0 ;";
    public String ADD_EPOCH_TIME_CREATE_AT_COLUMN_INTO_MESSAGES_TABLE = "ALTER TABLE messages ADD COLUMN epoch_time_created_at INTEGER NOT NULL DEFAULT 0 ;";
    public String ADD_FULL_PRIVACY_ENABLED_COLUMN_INTO_CONVERSATIONS_TABLE = "ALTER TABLE issues ADD COLUMN full_privacy_enabled INTEGER ;";
    public String ADD_HAS_OLDER_MESSAGES_COLUMN_INTO_INBOX_TABLE = "ALTER TABLE conversation_inbox ADD COLUMN has_older_messages INT ;";
    public String ADD_IS_REDACTED_COLUMN_INTO_CONVERSATIONS_TABLE = "ALTER TABLE issues ADD COLUMN is_redacted INTEGER ;";
    public String ADD_IS_REDACTED_COLUMN_INTO_MESSAGES_TABLE = "ALTER TABLE messages ADD COLUMN is_redacted INTEGER ;";
    public String ADD_LAST_CONVERSATIONS_REDACTED_TIME_COLUMN_INTO_INBOX_TABLE = "ALTER TABLE conversation_inbox ADD COLUMN last_conv_redaction_time INT ;";

    private void migrateData(SQLiteDatabase sQLiteDatabase) {
        HashMap hashMap = new HashMap();
        String[] strArr = {"_id", "created_at"};
        Cursor query = sQLiteDatabase.query(ConversationTable.TABLE_NAME, strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query.moveToFirst()) {
            do {
                long j = query.getLong(query.getColumnIndex("_id"));
                hashMap.put(Long.valueOf(j), query.getString(query.getColumnIndex("created_at")));
            } while (query.moveToNext());
        }
        query.close();
        HashMap hashMap2 = new HashMap();
        Cursor query2 = sQLiteDatabase.query("messages", strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query2.moveToFirst()) {
            do {
                long j2 = query2.getLong(query2.getColumnIndex("_id"));
                hashMap2.put(Long.valueOf(j2), query2.getString(query2.getColumnIndex("created_at")));
            } while (query2.moveToNext());
        }
        query2.close();
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            hashMap3.put(entry.getKey(), Long.valueOf(HSDateFormatSpec.convertToEpochTime((String) entry.getValue())));
        }
        HashMap hashMap4 = new HashMap();
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            hashMap4.put(entry2.getKey(), Long.valueOf(HSDateFormatSpec.convertToEpochTime((String) entry2.getValue())));
        }
        for (Map.Entry entry3 : hashMap3.entrySet()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("epoch_time_created_at", (Long) entry3.getValue());
            sQLiteDatabase.update(ConversationTable.TABLE_NAME, contentValues, UserDB.WHERE_LOCAL_ID_IS, new String[]{String.valueOf((Long) entry3.getKey())});
        }
        for (Map.Entry entry4 : hashMap4.entrySet()) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("epoch_time_created_at", (Long) entry4.getValue());
            sQLiteDatabase.update("messages", contentValues2, UserDB.WHERE_LOCAL_ID_IS, new String[]{String.valueOf((Long) entry4.getKey())});
        }
    }

    private void migrateTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.ADD_HAS_OLDER_MESSAGES_COLUMN_INTO_INBOX_TABLE);
        sQLiteDatabase.execSQL(this.ADD_LAST_CONVERSATIONS_REDACTED_TIME_COLUMN_INTO_INBOX_TABLE);
        sQLiteDatabase.execSQL(this.ADD_FULL_PRIVACY_ENABLED_COLUMN_INTO_CONVERSATIONS_TABLE);
        sQLiteDatabase.execSQL(this.ADD_IS_REDACTED_COLUMN_INTO_CONVERSATIONS_TABLE);
        sQLiteDatabase.execSQL(this.ADD_EPOCH_TIME_CREATE_AT_COLUMN_INTO_MESSAGES_TABLE);
        sQLiteDatabase.execSQL(this.ADD_IS_REDACTED_COLUMN_INTO_MESSAGES_TABLE);
        sQLiteDatabase.execSQL(this.ADD_EPOCH_TIME_CREATE_AT_COLUMN_INTO_CONVERSATIONS_TABLE);
    }

    public void migrate(@NonNull SQLiteDatabase sQLiteDatabase) {
        migrateTable(sQLiteDatabase);
        migrateData(sQLiteDatabase);
    }
}
