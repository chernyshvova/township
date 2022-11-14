package com.helpshift.support.p043db.faq;

import com.helpshift.p042db.base.DatabaseContract;
import com.helpshift.p042db.base.DropAndCreateDatabaseMigrator;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.support.p043db.SupportDBNameRepo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.helpshift.support.db.faq.FaqDatabaseContract */
public class FaqDatabaseContract implements DatabaseContract {
    public static final String TAG = "Helpshift_FaqDB";
    public final String CREATE_FAQ_TABLE = "CREATE TABLE faqs (_id INTEGER PRIMARY KEY AUTOINCREMENT,question_id TEXT NOT NULL,publish_id TEXT NOT NULL,language TEXT NOT NULL,section_id TEXT NOT NULL,title TEXT NOT NULL,body TEXT NOT NULL,helpful INTEGER,rtl INTEGER,tags TEXT,c_tags TEXT,FOREIGN KEY(section_id) REFERENCES sections (_id));";
    public final String CREATE_SECTION_TABLE = "CREATE TABLE sections (_id INTEGER PRIMARY KEY AUTOINCREMENT,section_id TEXT NOT NULL,publish_id INTEGER NOT NULL,title TEXT NOT NULL);";

    public List<String> getCreateTableQueries() {
        return Arrays.asList(new String[]{"CREATE TABLE faqs (_id INTEGER PRIMARY KEY AUTOINCREMENT,question_id TEXT NOT NULL,publish_id TEXT NOT NULL,language TEXT NOT NULL,section_id TEXT NOT NULL,title TEXT NOT NULL,body TEXT NOT NULL,helpful INTEGER,rtl INTEGER,tags TEXT,c_tags TEXT,FOREIGN KEY(section_id) REFERENCES sections (_id));", "CREATE TABLE sections (_id INTEGER PRIMARY KEY AUTOINCREMENT,section_id TEXT NOT NULL,publish_id INTEGER NOT NULL,title TEXT NOT NULL);"});
    }

    public String getDatabaseName() {
        return SupportDBNameRepo.getFaqsDbName();
    }

    public int getDatabaseVersion() {
        return 3;
    }

    public List<IMigrator> getMigratorsForUpgrade(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DropAndCreateDatabaseMigrator(this));
        return arrayList;
    }

    public List<String> getTableNames() {
        return Arrays.asList(new String[]{"faqs", "sections"});
    }

    public String getTag() {
        return TAG;
    }
}
