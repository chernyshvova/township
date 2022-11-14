package com.helpshift.p042db.conversation.migration;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.account.dao.UserDB;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.p042db.conversation.tables.ConversationTable;
import java.util.UUID;

/* renamed from: com.helpshift.db.conversation.migration.ConversationDbMigration_8_to_9 */
public class ConversationDbMigration_8_to_9 implements IMigrator {
    public String ADD_ACID_COLUMN_TO_CONVERSATION_TABLE = "ALTER TABLE issues ADD COLUMN acid TEXT ;";
    public String GET_ALL_CONVERSATION_QUERY = "SELECT _id , server_id , pre_conv_server_id FROM issues ;";
    public final String TAG = "Helpshift_dbMigrate8_9";

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        if (r1 == null) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void migrateData(android.database.sqlite.SQLiteDatabase r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = r5.GET_ALL_CONVERSATION_QUERY
            r2 = 0
            android.database.Cursor r1 = r6.rawQuery(r1, r2)
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x0049
        L_0x0012:
            java.lang.String r2 = "_id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x004f }
            long r2 = r1.getLong(r2)     // Catch:{ Exception -> 0x004f }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = "server_id"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r4 = "pre_conv_server_id"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ Exception -> 0x004f }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ Exception -> 0x004f }
            boolean r3 = com.helpshift.util.StringUtils.isEmpty(r3)     // Catch:{ Exception -> 0x004f }
            if (r3 == 0) goto L_0x0043
            boolean r3 = com.helpshift.util.StringUtils.isEmpty(r4)     // Catch:{ Exception -> 0x004f }
            if (r3 == 0) goto L_0x0043
            r0.add(r2)     // Catch:{ Exception -> 0x004f }
        L_0x0043:
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x004f }
            if (r2 != 0) goto L_0x0012
        L_0x0049:
            r1.close()
            goto L_0x005a
        L_0x004d:
            r6 = move-exception
            goto L_0x006f
        L_0x004f:
            r2 = move-exception
            java.lang.String r3 = "Helpshift_dbMigrate8_9"
            java.lang.String r4 = "Failed to read db conversations"
            com.helpshift.util.HSLogger.m3242e(r3, r4, r2)     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x005a
            goto L_0x0049
        L_0x005a:
            java.util.Iterator r0 = r0.iterator()
        L_0x005e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x006e
            java.lang.Object r1 = r0.next()
            java.lang.Long r1 = (java.lang.Long) r1
            r5.updateAcidValueForConversation(r1, r6)
            goto L_0x005e
        L_0x006e:
            return
        L_0x006f:
            if (r1 == 0) goto L_0x0074
            r1.close()
        L_0x0074:
            goto L_0x0076
        L_0x0075:
            throw r6
        L_0x0076:
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.migration.ConversationDbMigration_8_to_9.migrateData(android.database.sqlite.SQLiteDatabase):void");
    }

    private void migrateTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.ADD_ACID_COLUMN_TO_CONVERSATION_TABLE);
    }

    private void updateAcidValueForConversation(Long l, SQLiteDatabase sQLiteDatabase) {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("acid", uuid);
        sQLiteDatabase.update(ConversationTable.TABLE_NAME, contentValues, UserDB.WHERE_LOCAL_ID_IS, new String[]{String.valueOf(l)});
    }

    public void migrate(SQLiteDatabase sQLiteDatabase) throws Exception {
        migrateTable(sQLiteDatabase);
        migrateData(sQLiteDatabase);
    }
}
