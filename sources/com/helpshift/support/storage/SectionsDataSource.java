package com.helpshift.support.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.Section;
import com.helpshift.support.p043db.faq.FaqsDBHelper;
import com.helpshift.util.HSLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SectionsDataSource implements SectionDAO {
    public static final String TAG = "HelpShiftDebug";
    public final FaqsDBHelper dbHelper;
    public FaqDAO faqDAO;

    public static final class LazyHolder {
        public static final SectionsDataSource INSTANCE = new SectionsDataSource();
    }

    public static Section cursorToSection(Cursor cursor) {
        return new Section(cursor.getLong(0), cursor.getString(1), cursor.getString(3), cursor.getString(2));
    }

    public static SectionsDataSource getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static ContentValues sectionToContentValues(JSONObject jSONObject) throws JSONException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", jSONObject.getString("title"));
        contentValues.put("publish_id", jSONObject.getString("publish_id"));
        contentValues.put("section_id", jSONObject.getString("id"));
        return contentValues;
    }

    public synchronized void clearSectionsData() {
        this.dbHelper.dropAndCreateAllTables(this.dbHelper.getWritableDatabase());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r1 == null) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.helpshift.support.Section> getAllSections() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0046 }
            r0.<init>()     // Catch:{ all -> 0x0046 }
            r1 = 0
            com.helpshift.support.db.faq.FaqsDBHelper r2 = r11.dbHelper     // Catch:{ Exception -> 0x0033 }
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r4 = "sections"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0033 }
            r1.moveToFirst()     // Catch:{ Exception -> 0x0033 }
        L_0x001c:
            boolean r2 = r1.isAfterLast()     // Catch:{ Exception -> 0x0033 }
            if (r2 != 0) goto L_0x002d
            com.helpshift.support.Section r2 = cursorToSection(r1)     // Catch:{ Exception -> 0x0033 }
            r0.add(r2)     // Catch:{ Exception -> 0x0033 }
            r1.moveToNext()     // Catch:{ Exception -> 0x0033 }
            goto L_0x001c
        L_0x002d:
            r1.close()     // Catch:{ all -> 0x0046 }
            goto L_0x003e
        L_0x0031:
            r0 = move-exception
            goto L_0x0040
        L_0x0033:
            r2 = move-exception
            java.lang.String r3 = "HelpShiftDebug"
            java.lang.String r4 = "Error in getAllSections"
            com.helpshift.util.HSLogger.m3242e(r3, r4, r2)     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x003e
            goto L_0x002d
        L_0x003e:
            monitor-exit(r11)
            return r0
        L_0x0040:
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ all -> 0x0046 }
        L_0x0045:
            throw r0     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r0 = move-exception
            monitor-exit(r11)
            goto L_0x004a
        L_0x0049:
            throw r0
        L_0x004a:
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.SectionsDataSource.getAllSections():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        if (r12 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004e A[SYNTHETIC, Splitter:B:28:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.support.Section getSection(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 == 0) goto L_0x0052
            java.lang.String r0 = ""
            boolean r0 = r12.equals(r0)     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x000c
            goto L_0x0052
        L_0x000c:
            r0 = 0
            com.helpshift.support.db.faq.FaqsDBHelper r1 = r11.dbHelper     // Catch:{ Exception -> 0x003d, all -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x003d, all -> 0x0038 }
            java.lang.String r3 = "sections"
            r4 = 0
            java.lang.String r5 = "publish_id = ?"
            r1 = 1
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch:{ Exception -> 0x003d, all -> 0x0038 }
            r1 = 0
            r6[r1] = r12     // Catch:{ Exception -> 0x003d, all -> 0x0038 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x003d, all -> 0x0038 }
            r12.moveToFirst()     // Catch:{ Exception -> 0x0036 }
            boolean r1 = r12.isAfterLast()     // Catch:{ Exception -> 0x0036 }
            if (r1 != 0) goto L_0x0032
            com.helpshift.support.Section r0 = cursorToSection(r12)     // Catch:{ Exception -> 0x0036 }
        L_0x0032:
            r12.close()     // Catch:{ all -> 0x0059 }
            goto L_0x0049
        L_0x0036:
            r1 = move-exception
            goto L_0x003f
        L_0x0038:
            r12 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x004c
        L_0x003d:
            r1 = move-exception
            r12 = r0
        L_0x003f:
            java.lang.String r2 = "HelpShiftDebug"
            java.lang.String r3 = "Error in getSection"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r1)     // Catch:{ all -> 0x004b }
            if (r12 == 0) goto L_0x0049
            goto L_0x0032
        L_0x0049:
            monitor-exit(r11)
            return r0
        L_0x004b:
            r0 = move-exception
        L_0x004c:
            if (r12 == 0) goto L_0x0051
            r12.close()     // Catch:{ all -> 0x0059 }
        L_0x0051:
            throw r0     // Catch:{ all -> 0x0059 }
        L_0x0052:
            com.helpshift.support.Section r12 = new com.helpshift.support.Section     // Catch:{ all -> 0x0059 }
            r12.<init>()     // Catch:{ all -> 0x0059 }
            monitor-exit(r11)
            return r12
        L_0x0059:
            r12 = move-exception
            monitor-exit(r11)
            goto L_0x005d
        L_0x005c:
            throw r12
        L_0x005d:
            goto L_0x005c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.SectionsDataSource.getSection(java.lang.String):com.helpshift.support.Section");
    }

    public synchronized void storeSections(JSONArray jSONArray) {
        String str;
        String str2;
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                writableDatabase.insert("sections", (String) null, sectionToContentValues(jSONObject));
                JSONArray optJSONArray = jSONObject.optJSONArray("faqs");
                if (optJSONArray != null) {
                    FaqsDataSource.addFaqsUnsafe(writableDatabase, jSONObject.getString("publish_id"), optJSONArray);
                }
            }
            writableDatabase.setTransactionSuccessful();
            try {
                if (writableDatabase.inTransaction()) {
                    writableDatabase.endTransaction();
                }
            } catch (Exception e) {
                e = e;
                str = "HelpShiftDebug";
                str2 = "Error in storeSections inside finally block";
                HSLogger.m3242e(str, str2, e);
            }
        } catch (JSONException e2) {
            try {
                HSLogger.m3242e("HelpShiftDebug", "Error in storeSections", e2);
                if (writableDatabase != null) {
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        str = "HelpShiftDebug";
                        str2 = "Error in storeSections inside finally block";
                        HSLogger.m3242e(str, str2, e);
                    }
                }
            } finally {
                if (writableDatabase != null) {
                    try {
                        if (writableDatabase.inTransaction()) {
                            writableDatabase.endTransaction();
                        }
                    } catch (Exception e4) {
                        HSLogger.m3242e("HelpShiftDebug", "Error in storeSections inside finally block", e4);
                    }
                }
            }
        }
    }

    public SectionsDataSource() {
        this.dbHelper = FaqsDBHelper.getInstance();
        this.faqDAO = FaqsDataSource.getInstance();
    }

    public List<Section> getAllSections(FaqTagFilter faqTagFilter) {
        List<Section> allSections = getAllSections();
        if (faqTagFilter == null) {
            return allSections;
        }
        ArrayList arrayList = new ArrayList();
        for (Section next : allSections) {
            if (!this.faqDAO.getFaqsForSection(next.getPublishId(), faqTagFilter).isEmpty()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
