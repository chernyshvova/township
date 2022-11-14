package com.helpshift.support.p043db.faq.tables;

import android.provider.BaseColumns;

/* renamed from: com.helpshift.support.db.faq.tables.SectionTable */
public interface SectionTable {
    public static final String TABLE_NAME = "sections";

    /* renamed from: com.helpshift.support.db.faq.tables.SectionTable$Columns */
    public interface Columns extends BaseColumns {
        public static final String PUBLISH_ID = "publish_id";
        public static final String SECTION_ID = "section_id";
        public static final String TITLE = "title";
    }
}
