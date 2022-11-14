package com.helpshift.support.search.storage;

import android.database.sqlite.SQLiteOpenHelper;
import com.helpshift.support.p043db.search.SearchDBHelper;
import com.helpshift.support.p043db.search.SearchDatabaseContract;
import com.helpshift.support.p043db.search.tables.SearchTable;
import com.helpshift.support.search.SearchTokenDao;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.util.HashMap;
import java.util.Map;

public class SearchTokenDaoImpl implements SearchTokenDao {
    public static final String TAG = "Helpshift_SearchToknDao";
    public final SQLiteOpenHelper dbHelper = new SearchDBHelper(HelpshiftContext.getApplicationContext(), new SearchDatabaseContract());
    public final char scoreMapKeyValueStringSeparator = ':';
    public final char scoreMapStringSeparator = '$';

    public static class LazyHolder {
        public static final SearchTokenDao INSTANCE = new SearchTokenDaoImpl();
    }

    private String convertScoreMapToScoreString(Map<Integer, Double> map) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append('$');
            }
            sb.append(next.getKey());
            sb.append(':');
            sb.append(next.getValue());
        }
        return sb.toString();
    }

    private Map<Integer, Double> convertScoreStringToScoreMap(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        if (str == null) {
            return hashMap;
        }
        String[] split2 = str.split("[$]");
        for (String str2 : split2) {
            if (str2 != null && str2.length() > 0 && (split = str2.split("[:]")) != null && split.length == 2) {
                hashMap.put(Integer.valueOf(Integer.valueOf(split[0]).intValue()), Double.valueOf(Double.valueOf(split[1]).doubleValue()));
            }
        }
        return hashMap;
    }

    public static SearchTokenDao getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void clear() {
        synchronized (this.dbHelper) {
            try {
                this.dbHelper.getWritableDatabase().delete(SearchTable.TABLE_NAME, (String) null, (String[]) null);
            } catch (Exception e) {
                HSLogger.m3242e(TAG, "Error occurred when calling clear method", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        if (r13 != null) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A[Catch:{ all -> 0x006f }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.helpshift.support.search.SearchTokenDto get(java.lang.String r13) {
        /*
            r12 = this;
            android.database.sqlite.SQLiteOpenHelper r0 = r12.dbHelper
            monitor-enter(r0)
            r1 = 0
            android.database.sqlite.SQLiteOpenHelper r2 = r12.dbHelper     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r2 = "token"
            java.lang.String r4 = "type"
            java.lang.String r5 = "score"
            java.lang.String[] r5 = new java.lang.String[]{r2, r4, r5}     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r4 = "search_token_table"
            java.lang.String r6 = "token=?"
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            r2 = 0
            r7[r2] = r13     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            int r2 = r13.getCount()     // Catch:{ Exception -> 0x005a }
            if (r2 <= 0) goto L_0x0056
            r13.moveToFirst()     // Catch:{ Exception -> 0x005a }
            java.lang.String r2 = "token"
            int r2 = r13.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x005a }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x005a }
            java.lang.String r3 = "type"
            int r3 = r13.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x005a }
            int r3 = r13.getInt(r3)     // Catch:{ Exception -> 0x005a }
            java.lang.String r4 = "score"
            int r4 = r13.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x005a }
            java.lang.String r4 = r13.getString(r4)     // Catch:{ Exception -> 0x005a }
            java.util.Map r4 = r12.convertScoreStringToScoreMap(r4)     // Catch:{ Exception -> 0x005a }
            com.helpshift.support.search.SearchTokenDto r5 = new com.helpshift.support.search.SearchTokenDto     // Catch:{ Exception -> 0x005a }
            r5.<init>(r2, r3, r4)     // Catch:{ Exception -> 0x005a }
            r1 = r5
        L_0x0056:
            r13.close()     // Catch:{ all -> 0x0076 }
            goto L_0x006d
        L_0x005a:
            r2 = move-exception
            goto L_0x0063
        L_0x005c:
            r13 = move-exception
            r11 = r1
            r1 = r13
            r13 = r11
            goto L_0x0070
        L_0x0061:
            r2 = move-exception
            r13 = r1
        L_0x0063:
            java.lang.String r3 = "Helpshift_SearchToknDao"
            java.lang.String r4 = "Error occurred when calling get method"
            com.helpshift.util.HSLogger.m3242e(r3, r4, r2)     // Catch:{ all -> 0x006f }
            if (r13 == 0) goto L_0x006d
            goto L_0x0056
        L_0x006d:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return r1
        L_0x006f:
            r1 = move-exception
        L_0x0070:
            if (r13 == 0) goto L_0x0075
            r13.close()     // Catch:{ all -> 0x0076 }
        L_0x0075:
            throw r1     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            goto L_0x007a
        L_0x0079:
            throw r13
        L_0x007a:
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.search.storage.SearchTokenDaoImpl.get(java.lang.String):com.helpshift.support.search.SearchTokenDto");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089 A[SYNTHETIC, Splitter:B:35:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009d A[SYNTHETIC, Splitter:B:45:0x009d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void save(java.util.List<com.helpshift.support.search.SearchTokenDto> r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x000c:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r7.next()
            com.helpshift.support.search.SearchTokenDto r1 = (com.helpshift.support.search.SearchTokenDto) r1
            java.util.Map<java.lang.Integer, java.lang.Double> r2 = r1.scoreMap
            java.lang.String r2 = r6.convertScoreMapToScoreString(r2)
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r4 = "token"
            java.lang.String r5 = r1.wordValue
            r3.put(r4, r5)
            java.lang.String r4 = "type"
            int r1 = r1.wordType
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.put(r4, r1)
            java.lang.String r1 = "score"
            r3.put(r1, r2)
            r0.add(r3)
            goto L_0x000c
        L_0x003e:
            android.database.sqlite.SQLiteOpenHelper r7 = r6.dbHelper
            monitor-enter(r7)
            r1 = 0
            android.database.sqlite.SQLiteOpenHelper r2 = r6.dbHelper     // Catch:{ Exception -> 0x007f }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x007f }
            r2.beginTransaction()     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
        L_0x004f:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
            java.lang.String r4 = "search_token_table"
            r2.insert(r4, r1, r3)     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
            goto L_0x004f
        L_0x0061:
            r2.setTransactionSuccessful()     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
            boolean r0 = r2.inTransaction()     // Catch:{ Exception -> 0x006e }
            if (r0 == 0) goto L_0x0099
            r2.endTransaction()     // Catch:{ Exception -> 0x006e }
            goto L_0x0099
        L_0x006e:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_SearchToknDao"
            java.lang.String r2 = "Error occurred when calling save method inside finally block"
        L_0x0073:
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x00a7 }
            goto L_0x0099
        L_0x0077:
            r0 = move-exception
            r1 = r2
            goto L_0x009b
        L_0x007a:
            r0 = move-exception
            r1 = r2
            goto L_0x0080
        L_0x007d:
            r0 = move-exception
            goto L_0x009b
        L_0x007f:
            r0 = move-exception
        L_0x0080:
            java.lang.String r2 = "Helpshift_SearchToknDao"
            java.lang.String r3 = "Error occurred when calling save method"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r0)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0099
            boolean r0 = r1.inTransaction()     // Catch:{ Exception -> 0x0093 }
            if (r0 == 0) goto L_0x0099
            r1.endTransaction()     // Catch:{ Exception -> 0x0093 }
            goto L_0x0099
        L_0x0093:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_SearchToknDao"
            java.lang.String r2 = "Error occurred when calling save method inside finally block"
            goto L_0x0073
        L_0x0099:
            monitor-exit(r7)     // Catch:{ all -> 0x00a7 }
            return
        L_0x009b:
            if (r1 == 0) goto L_0x00b1
            boolean r2 = r1.inTransaction()     // Catch:{ Exception -> 0x00a9 }
            if (r2 == 0) goto L_0x00b1
            r1.endTransaction()     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00b1
        L_0x00a7:
            r0 = move-exception
            goto L_0x00b2
        L_0x00a9:
            r1 = move-exception
            java.lang.String r2 = "Helpshift_SearchToknDao"
            java.lang.String r3 = "Error occurred when calling save method inside finally block"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r1)     // Catch:{ all -> 0x00a7 }
        L_0x00b1:
            throw r0     // Catch:{ all -> 0x00a7 }
        L_0x00b2:
            monitor-exit(r7)     // Catch:{ all -> 0x00a7 }
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.search.storage.SearchTokenDaoImpl.save(java.util.List):void");
    }
}
