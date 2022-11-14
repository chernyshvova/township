package com.helpshift.support.p043db.faq;

import android.content.Context;
import com.helpshift.p042db.base.BaseSqliteHelper;
import com.helpshift.p042db.base.DatabaseContract;
import com.helpshift.util.HelpshiftContext;

/* renamed from: com.helpshift.support.db.faq.FaqsDBHelper */
public class FaqsDBHelper extends BaseSqliteHelper {

    /* renamed from: com.helpshift.support.db.faq.FaqsDBHelper$LazyHolder */
    public static class LazyHolder {
        public static final FaqsDBHelper INSTANCE = new FaqsDBHelper(HelpshiftContext.getApplicationContext(), new FaqDatabaseContract());
    }

    public FaqsDBHelper(Context context, DatabaseContract databaseContract) {
        super(context, databaseContract);
    }

    public static FaqsDBHelper getInstance() {
        return LazyHolder.INSTANCE;
    }
}
