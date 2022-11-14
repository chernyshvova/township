package com.helpshift.support.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.helpshift.support.Faq;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.p043db.faq.FaqsDBHelper;
import com.helpshift.util.DatabaseUtils;
import com.helpshift.util.HSJSONUtils;
import com.helpshift.util.HSLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FaqsDataSource implements FaqDAO {
    public static final String TAG = "HelpShiftDebug";
    public final FaqsDBHelper dbHelper;

    public static final class LazyHolder {
        public static final FaqsDataSource INSTANCE = new FaqsDataSource();
    }

    public static void addFaqsUnsafe(SQLiteDatabase sQLiteDatabase, String str, JSONArray jSONArray) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                sQLiteDatabase.insert("faqs", (String) null, faqToContentValues(str, jSONArray.getJSONObject(i)));
                i++;
            } catch (JSONException e) {
                HSLogger.m3238d("HelpShiftDebug", "addFaqsUnsafe", (Throwable) e);
                return;
            }
        }
    }

    public static Faq cursorToFaq(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("question_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("publish_id"));
        String string3 = cursor.getString(cursor.getColumnIndex("language"));
        String string4 = cursor.getString(cursor.getColumnIndex("section_id"));
        String string5 = cursor.getString(cursor.getColumnIndex("title"));
        String string6 = cursor.getString(cursor.getColumnIndex("body"));
        int i = cursor.getInt(cursor.getColumnIndex("helpful"));
        boolean z = true;
        if (cursor.getInt(cursor.getColumnIndex("rtl")) != 1) {
            z = false;
        }
        return new Faq(j, string, string2, string3, string4, string5, string6, i, Boolean.valueOf(z), HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex("tags"))), HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex("c_tags"))));
    }

    public static ContentValues faqToContentValues(Faq faq) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("question_id", faq.getId());
        contentValues.put("publish_id", faq.publish_id);
        contentValues.put("language", faq.language);
        contentValues.put("section_id", faq.section_publish_id);
        contentValues.put("title", faq.title);
        contentValues.put("body", faq.body);
        contentValues.put("helpful", Integer.valueOf(faq.is_helpful));
        contentValues.put("rtl", faq.is_rtl);
        contentValues.put("tags", String.valueOf(new JSONArray(faq.getTags())));
        contentValues.put("c_tags", String.valueOf(new JSONArray(faq.getCategoryTags())));
        return contentValues;
    }

    private List<Faq> getANDFilteredFaqs(List<Faq> list, FaqTagFilter faqTagFilter) {
        ArrayList arrayList = new ArrayList();
        for (Faq next : list) {
            ArrayList arrayList2 = new ArrayList(Arrays.asList(faqTagFilter.getTags()));
            arrayList2.removeAll(next.getCategoryTags());
            if (arrayList2.isEmpty()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static FaqsDataSource getInstance() {
        return LazyHolder.INSTANCE;
    }

    private List<Faq> getNOTFilteredFaqs(List<Faq> list, FaqTagFilter faqTagFilter) {
        ArrayList arrayList = new ArrayList();
        for (Faq next : list) {
            if (!new ArrayList(Arrays.asList(faqTagFilter.getTags())).removeAll(next.getCategoryTags())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private List<Faq> getORFilteredFaqs(List<Faq> list, FaqTagFilter faqTagFilter) {
        ArrayList arrayList = new ArrayList();
        for (Faq next : list) {
            if (new ArrayList(Arrays.asList(faqTagFilter.getTags())).removeAll(next.getCategoryTags())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public synchronized void addFaq(Faq faq) {
        ContentValues faqToContentValues = faqToContentValues(faq);
        String[] strArr = {faq.getId()};
        try {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            if (!DatabaseUtils.exists(writableDatabase, "faqs", "question_id=?", strArr)) {
                writableDatabase.insert("faqs", (String) null, faqToContentValues);
            } else {
                writableDatabase.update("faqs", faqToContentValues, "question_id=?", strArr);
            }
        } catch (Exception e) {
            HSLogger.m3242e("HelpShiftDebug", "Error in addFaq", e);
        }
        return;
    }

    public synchronized void clearDB() {
        this.dbHelper.dropAndCreateAllTables(this.dbHelper.getWritableDatabase());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r1 == null) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<java.lang.String> getAllFaqPublishIds() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0054 }
            r0.<init>()     // Catch:{ all -> 0x0054 }
            r1 = 0
            java.lang.String r2 = "publish_id"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0041 }
            com.helpshift.support.db.faq.FaqsDBHelper r2 = r11.dbHelper     // Catch:{ Exception -> 0x0041 }
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0041 }
            java.lang.String r4 = "faqs"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0041 }
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0041 }
            if (r2 == 0) goto L_0x003b
        L_0x0024:
            boolean r2 = r1.isAfterLast()     // Catch:{ Exception -> 0x0041 }
            if (r2 != 0) goto L_0x003b
            java.lang.String r2 = "publish_id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0041 }
            r0.add(r2)     // Catch:{ Exception -> 0x0041 }
            r1.moveToNext()     // Catch:{ Exception -> 0x0041 }
            goto L_0x0024
        L_0x003b:
            r1.close()     // Catch:{ all -> 0x0054 }
            goto L_0x004c
        L_0x003f:
            r0 = move-exception
            goto L_0x004e
        L_0x0041:
            r2 = move-exception
            java.lang.String r3 = "HelpShiftDebug"
            java.lang.String r4 = "Error in getFaqsDataForSection"
            com.helpshift.util.HSLogger.m3242e(r3, r4, r2)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x004c
            goto L_0x003b
        L_0x004c:
            monitor-exit(r11)
            return r0
        L_0x004e:
            if (r1 == 0) goto L_0x0053
            r1.close()     // Catch:{ all -> 0x0054 }
        L_0x0053:
            throw r0     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r0 = move-exception
            monitor-exit(r11)
            goto L_0x0058
        L_0x0057:
            throw r0
        L_0x0058:
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.FaqsDataSource.getAllFaqPublishIds():java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.helpshift.support.Faq} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        if (r11 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        return r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046 A[SYNTHETIC, Splitter:B:28:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.support.Faq getFaq(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x004a }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r10)
            return r1
        L_0x000a:
            com.helpshift.support.db.faq.FaqsDBHelper r0 = r10.dbHelper     // Catch:{ Exception -> 0x0034, all -> 0x0032 }
            android.database.sqlite.SQLiteDatabase r2 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x0034, all -> 0x0032 }
            java.lang.String r3 = "faqs"
            r4 = 0
            java.lang.String r5 = "publish_id = ?"
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0034, all -> 0x0032 }
            r0 = 0
            r6[r0] = r11     // Catch:{ Exception -> 0x0034, all -> 0x0032 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0034, all -> 0x0032 }
            boolean r0 = r11.moveToFirst()     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x002c
            com.helpshift.support.Faq r1 = cursorToFaq(r11)     // Catch:{ Exception -> 0x0030 }
        L_0x002c:
            r11.close()     // Catch:{ all -> 0x004a }
            goto L_0x0040
        L_0x0030:
            r0 = move-exception
            goto L_0x0036
        L_0x0032:
            r0 = move-exception
            goto L_0x0044
        L_0x0034:
            r0 = move-exception
            r11 = r1
        L_0x0036:
            java.lang.String r2 = "HelpShiftDebug"
            java.lang.String r3 = "Error in getFaq"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r0)     // Catch:{ all -> 0x0042 }
            if (r11 == 0) goto L_0x0040
            goto L_0x002c
        L_0x0040:
            monitor-exit(r10)
            return r1
        L_0x0042:
            r0 = move-exception
            r1 = r11
        L_0x0044:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ all -> 0x004a }
        L_0x0049:
            throw r0     // Catch:{ all -> 0x004a }
        L_0x004a:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x004e
        L_0x004d:
            throw r11
        L_0x004e:
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.FaqsDataSource.getFaq(java.lang.String):com.helpshift.support.Faq");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        if (r1 == null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.helpshift.support.Faq> getFaqsDataForSection(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x000e
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x005c }
            r12.<init>()     // Catch:{ all -> 0x005c }
            monitor-exit(r11)
            return r12
        L_0x000e:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x005c }
            r0.<init>()     // Catch:{ all -> 0x005c }
            r1 = 0
            com.helpshift.support.db.faq.FaqsDBHelper r2 = r11.dbHelper     // Catch:{ Exception -> 0x0049 }
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = "faqs"
            r5 = 0
            java.lang.String r6 = "section_id = ?"
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0049 }
            r2 = 0
            r7[r2] = r12     // Catch:{ Exception -> 0x0049 }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0049 }
            boolean r12 = r1.moveToFirst()     // Catch:{ Exception -> 0x0049 }
            if (r12 == 0) goto L_0x0043
        L_0x0032:
            boolean r12 = r1.isAfterLast()     // Catch:{ Exception -> 0x0049 }
            if (r12 != 0) goto L_0x0043
            com.helpshift.support.Faq r12 = cursorToFaq(r1)     // Catch:{ Exception -> 0x0049 }
            r0.add(r12)     // Catch:{ Exception -> 0x0049 }
            r1.moveToNext()     // Catch:{ Exception -> 0x0049 }
            goto L_0x0032
        L_0x0043:
            r1.close()     // Catch:{ all -> 0x005c }
            goto L_0x0054
        L_0x0047:
            r12 = move-exception
            goto L_0x0056
        L_0x0049:
            r12 = move-exception
            java.lang.String r2 = "HelpShiftDebug"
            java.lang.String r3 = "Error in getFaqsDataForSection"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r12)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0054
            goto L_0x0043
        L_0x0054:
            monitor-exit(r11)
            return r0
        L_0x0056:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ all -> 0x005c }
        L_0x005b:
            throw r12     // Catch:{ all -> 0x005c }
        L_0x005c:
            r12 = move-exception
            monitor-exit(r11)
            goto L_0x0060
        L_0x005f:
            throw r12
        L_0x0060:
            goto L_0x005f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.FaqsDataSource.getFaqsDataForSection(java.lang.String):java.util.List");
    }

    public List<Faq> getFaqsForSection(String str, FaqTagFilter faqTagFilter) {
        return getFilteredFaqs(getFaqsDataForSection(str), faqTagFilter);
    }

    public List<Faq> getFilteredFaqs(List<Faq> list, FaqTagFilter faqTagFilter) {
        if (faqTagFilter == null) {
            return list;
        }
        String operator = faqTagFilter.getOperator();
        char c = 65535;
        int hashCode = operator.hashCode();
        if (hashCode != -1038130864) {
            if (hashCode != 3555) {
                if (hashCode != 96727) {
                    if (hashCode == 109267 && operator.equals(FaqTagFilter.Operator.NOT)) {
                        c = 2;
                    }
                } else if (operator.equals(FaqTagFilter.Operator.AND)) {
                    c = 0;
                }
            } else if (operator.equals(FaqTagFilter.Operator.f3347OR)) {
                c = 1;
            }
        } else if (operator.equals("undefined")) {
            c = 3;
        }
        if (c == 0) {
            return getANDFilteredFaqs(list, faqTagFilter);
        }
        if (c == 1) {
            return getORFilteredFaqs(list, faqTagFilter);
        }
        if (c != 2) {
            return list;
        }
        return getNOTFilteredFaqs(list, faqTagFilter);
    }

    public synchronized void removeFaq(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dbHelper.getWritableDatabase().delete("faqs", "publish_id=?", new String[]{str});
            } catch (Exception e) {
                HSLogger.m3242e("HelpShiftDebug", "Error in removeFaq", e);
            }
        }
        return;
    }

    public synchronized int setIsHelpful(String str, Boolean bool) {
        int i;
        i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("helpful", Integer.valueOf(bool.booleanValue() ? 1 : -1));
        try {
            i = this.dbHelper.getWritableDatabase().update("faqs", contentValues, "question_id = ?", new String[]{str});
        } catch (Exception e) {
            HSLogger.m3242e("HelpShiftDebug", "Error in setIsHelpful", e);
        }
        return i;
    }

    public FaqsDataSource() {
        this.dbHelper = FaqsDBHelper.getInstance();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.helpshift.support.Faq} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (r11 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
        return null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.support.Faq getFaq(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0054 }
            r1 = 0
            if (r0 != 0) goto L_0x0052
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x000f
            goto L_0x0052
        L_0x000f:
            com.helpshift.support.db.faq.FaqsDBHelper r0 = r10.dbHelper     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            android.database.sqlite.SQLiteDatabase r2 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            java.lang.String r3 = "faqs"
            r4 = 0
            java.lang.String r5 = "publish_id = ? AND language = ?"
            r0 = 2
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            r0 = 0
            r6[r0] = r11     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            r11 = 1
            r6[r11] = r12     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x0038 }
            if (r12 == 0) goto L_0x0034
            com.helpshift.support.Faq r1 = cursorToFaq(r11)     // Catch:{ Exception -> 0x0038 }
        L_0x0034:
            r11.close()     // Catch:{ all -> 0x0054 }
            goto L_0x0048
        L_0x0038:
            r12 = move-exception
            goto L_0x003e
        L_0x003a:
            r12 = move-exception
            goto L_0x004c
        L_0x003c:
            r12 = move-exception
            r11 = r1
        L_0x003e:
            java.lang.String r0 = "HelpShiftDebug"
            java.lang.String r2 = "Error in getFaq"
            com.helpshift.util.HSLogger.m3242e(r0, r2, r12)     // Catch:{ all -> 0x004a }
            if (r11 == 0) goto L_0x0048
            goto L_0x0034
        L_0x0048:
            monitor-exit(r10)
            return r1
        L_0x004a:
            r12 = move-exception
            r1 = r11
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ all -> 0x0054 }
        L_0x0051:
            throw r12     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r10)
            return r1
        L_0x0054:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0058
        L_0x0057:
            throw r11
        L_0x0058:
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.FaqsDataSource.getFaq(java.lang.String, java.lang.String):com.helpshift.support.Faq");
    }

    public static ContentValues faqToContentValues(String str, JSONObject jSONObject) throws JSONException {
        String str2;
        String str3;
        ContentValues contentValues = new ContentValues();
        contentValues.put("question_id", jSONObject.getString("id"));
        contentValues.put("publish_id", jSONObject.getString("publish_id"));
        contentValues.put("language", jSONObject.getString("language"));
        contentValues.put("section_id", str);
        contentValues.put("title", jSONObject.getString("title"));
        contentValues.put("body", jSONObject.getString("body"));
        contentValues.put("helpful", 0);
        contentValues.put("rtl", Boolean.valueOf(jSONObject.getString("is_rtl").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)));
        if (jSONObject.has("stags")) {
            str2 = jSONObject.optJSONArray("stags").toString();
        } else {
            str2 = new JSONArray().toString();
        }
        contentValues.put("tags", str2);
        if (jSONObject.has("issue_tags")) {
            str3 = jSONObject.optJSONArray("issue_tags").toString();
        } else {
            str3 = new JSONArray().toString();
        }
        contentValues.put("c_tags", str3);
        return contentValues;
    }
}
