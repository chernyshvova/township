package com.helpshift.p042db.conversation;

import android.content.Context;
import com.helpshift.p042db.base.BaseSqliteHelper;
import com.helpshift.util.HelpshiftContext;

/* renamed from: com.helpshift.db.conversation.ConversationDBHelper */
public class ConversationDBHelper extends BaseSqliteHelper implements BaseSqliteHelper.IDbMigrationListener {
    public ConversationDBHelper(Context context, ConversationDatabaseContract conversationDatabaseContract) {
        super(context, conversationDatabaseContract);
        setListener(this);
    }

    public void onDbMigrationFailed(BaseSqliteHelper.MigrationType migrationType, String str) {
        if (migrationType == BaseSqliteHelper.MigrationType.UPGRADE) {
            HelpshiftContext.getCoreApi().resetUsersSyncStatusAndStartSetupForActiveUser();
        }
    }

    public void onDbMigrationSuccess(BaseSqliteHelper.MigrationType migrationType, String str) {
        if (migrationType == BaseSqliteHelper.MigrationType.DOWNGRADE) {
            HelpshiftContext.getCoreApi().resetUsersSyncStatusAndStartSetupForActiveUser();
        }
    }
}
