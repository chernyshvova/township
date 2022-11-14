package com.helpshift.p042db.conversation.migration;

import android.database.sqlite.SQLiteDatabase;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.p042db.conversation.ConversationDatabaseContract;

/* renamed from: com.helpshift.db.conversation.migration.ConversationDbMigration_10_to_11 */
public class ConversationDbMigration_10_to_11 implements IMigrator {
    public final String TAG = "Helpshft_dbMgrte10_11";

    public void migrate(SQLiteDatabase sQLiteDatabase) throws Exception {
        sQLiteDatabase.execSQL(ConversationDatabaseContract.CREATE_ACTION_CARD_TABLE);
        sQLiteDatabase.execSQL(ConversationDatabaseContract.CREATE_ACTION_TABLE);
    }
}
