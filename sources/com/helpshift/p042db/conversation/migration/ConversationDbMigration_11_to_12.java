package com.helpshift.p042db.conversation.migration;

import android.database.sqlite.SQLiteDatabase;
import com.helpshift.p042db.base.IMigrator;

/* renamed from: com.helpshift.db.conversation.migration.ConversationDbMigration_11_to_12 */
public class ConversationDbMigration_11_to_12 implements IMigrator {
    public final String ADD_CAN_START_NEW_CONVERSATION_COLUMN = "ALTER TABLE issues ADD COLUMN can_start_new_conversation INTEGER ;";
    public final String ADD_FEEDBACK_BOT_ENABLED_COLUMN = "ALTER TABLE issues ADD COLUMN feedback_bots_enabled INTEGER ;";
    public final String TAG = "Helpshft_dbMgrte11_12";

    public void migrate(SQLiteDatabase sQLiteDatabase) throws Exception {
        sQLiteDatabase.execSQL("ALTER TABLE issues ADD COLUMN feedback_bots_enabled INTEGER ;");
        sQLiteDatabase.execSQL("ALTER TABLE issues ADD COLUMN can_start_new_conversation INTEGER ;");
    }
}
