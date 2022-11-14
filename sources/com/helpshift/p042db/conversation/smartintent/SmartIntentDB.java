package com.helpshift.p042db.conversation.smartintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.conversation.smartintent.dto.SISearchModelDTO;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;
import com.helpshift.conversation.smartintent.dto.SmartIntentDTO;
import com.helpshift.p042db.smartintents.SmartIntentDatabaseContract;
import com.helpshift.p042db.smartintents.SmartIntentsDBHelper;
import com.helpshift.p042db.smartintents.tables.SmartIntentModelsTable;
import com.helpshift.p042db.smartintents.tables.SmartIntentTreeTable;
import com.helpshift.p042db.smartintents.tables.SmartIntentWordProbabilitiesTable;
import com.helpshift.p042db.smartintents.tables.SmartIntentsTable;
import com.helpshift.util.DatabaseUtils;
import com.helpshift.util.HSJSONUtils;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.helpshift.db.conversation.smartintent.SmartIntentDB */
public class SmartIntentDB {
    public static final String TAG = "Helpshift_SiDB";
    public static SmartIntentDB mInstance;
    public final SmartIntentsDBHelper siDbHelper;

    public SmartIntentDB(Context context) {
        this.siDbHelper = new SmartIntentsDBHelper(context, new SmartIntentDatabaseContract());
    }

    private Map<String, List<SmartIntentDTO>> buildIntentIdToChildIntentMap(List<SmartIntentDTO> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SmartIntentDTO next : list) {
            if (!StringUtils.isEmpty(next.parentServerId)) {
                List list2 = (List) linkedHashMap.get(next.parentServerId);
                if (ListUtils.isEmpty(list2)) {
                    list2 = new LinkedList();
                }
                list2.add(next);
                linkedHashMap.put(next.parentServerId, list2);
            }
        }
        return linkedHashMap;
    }

    private List<SmartIntentDTO> buildIntentTree(List<SmartIntentDTO> list) {
        List<SmartIntentDTO> filterRootIntents = filterRootIntents(list);
        Map<String, List<SmartIntentDTO>> buildIntentIdToChildIntentMap = buildIntentIdToChildIntentMap(list);
        LinkedList linkedList = new LinkedList();
        for (SmartIntentDTO next : filterRootIntents) {
            List<SmartIntentDTO> list2 = buildIntentIdToChildIntentMap.get(next.serverId);
            if (ListUtils.isNotEmpty(list2)) {
                next.children = list2;
                linkedList.addAll(list2);
            }
        }
        while (!linkedList.isEmpty()) {
            SmartIntentDTO smartIntentDTO = (SmartIntentDTO) linkedList.poll();
            List<SmartIntentDTO> list3 = buildIntentIdToChildIntentMap.get(smartIntentDTO.serverId);
            if (ListUtils.isNotEmpty(list3)) {
                smartIntentDTO.children = list3;
                linkedList.addAll(list3);
            }
        }
        return filterRootIntents;
    }

    private SISearchModelDTO cursorToModelWithoutWordProbabilities(Cursor cursor) {
        Cursor cursor2 = cursor;
        long j = cursor2.getLong(cursor2.getColumnIndex("local_id"));
        int i = cursor2.getInt(cursor2.getColumnIndex("version"));
        double d = cursor2.getDouble(cursor2.getColumnIndex(SmartIntentModelsTable.Columns.CONFIDENCE_THRESHOLD));
        double d2 = cursor2.getDouble(cursor2.getColumnIndex(SmartIntentModelsTable.Columns.MAX_COMBINED_CONFIDENCE));
        long j2 = cursor2.getLong(cursor2.getColumnIndex("last_refreshed_at"));
        SISearchModelDTO sISearchModelDTO = new SISearchModelDTO(Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2), HSJSONUtils.jsonArrayToStringArrayList(cursor2.getString(cursor2.getColumnIndex(SmartIntentModelsTable.Columns.LEAF_INTENT_SERVER_IDS))), HSJSONUtils.jsonToDoubleArrayList(cursor2.getString(cursor2.getColumnIndex(SmartIntentModelsTable.Columns.LEAF_INTENT_BASE_PROBABILITIES))), (Map<String, List<Double>>) null);
        sISearchModelDTO.localId = Long.valueOf(j);
        sISearchModelDTO.lastRefreshedAt = j2;
        return sISearchModelDTO;
    }

    private SmartIntentDTO cursorToSmartIntent(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("local_id"));
        SmartIntentDTO smartIntentDTO = new SmartIntentDTO(cursor.getString(cursor.getColumnIndex("label")), cursor.getString(cursor.getColumnIndex("server_id")), cursor.getString(cursor.getColumnIndex(SmartIntentsTable.Columns.SI_INTENT_PARENT_SERVER_ID)), (List<SmartIntentDTO>) null);
        smartIntentDTO.localId = Long.valueOf(j);
        return smartIntentDTO;
    }

    private SITreeDTO cursorToSmartIntentTree(Cursor cursor, List<SmartIntentDTO> list) {
        Cursor cursor2 = cursor;
        long j = cursor2.getLong(cursor2.getColumnIndex("local_id"));
        String string = cursor2.getString(cursor2.getColumnIndex("server_id"));
        boolean parseBooleanColumnSafe = DatabaseUtils.parseBooleanColumnSafe(cursor2, SmartIntentTreeTable.Columns.SI_TREE_ENFORCE_INTENT_SELECTION, false);
        long j2 = j;
        SITreeDTO sITreeDTO = new SITreeDTO(string, cursor2.getInt(cursor2.getColumnIndex(SmartIntentTreeTable.Columns.TREE_VERSION)), cursor2.getString(cursor2.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_PROMPT_TITLE)), cursor2.getString(cursor2.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_TEXT_INPUT_HINT)), cursor2.getString(cursor2.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_SEARCH_TITLE)), cursor2.getString(cursor2.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_TITLE)), cursor2.getString(cursor2.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_DESCRIPTION)), parseBooleanColumnSafe, HSJSONUtils.jsonArrayToStringArrayList(cursor2.getString(cursor2.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_TOKEN_DELIMITER))), list);
        sITreeDTO.lastRefreshedAt = cursor2.getLong(cursor2.getColumnIndex("last_refreshed_at"));
        sITreeDTO.localId = Long.valueOf(j2);
        return sITreeDTO;
    }

    private List<Double> cursorToWordProbabilities(Cursor cursor) {
        return HSJSONUtils.jsonToDoubleArrayList(cursor.getString(cursor.getColumnIndex(SmartIntentWordProbabilitiesTable.Columns.SI_WORD_PROBABILITIES_PROBABILITIES)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Exception in ending transaction : word probabilites table or models table with " + java.util.Arrays.toString(r3), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a3, code lost:
        if (r8 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a9, code lost:
        if (r8.inTransaction() != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        r8.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Exception in ending transaction : word probabilites table or models table with " + java.util.Arrays.toString(r3), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ca, code lost:
        throw r9;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0026, B:18:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean deleteModelAndWordProbabilities(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "model_local_id = ?"
            java.lang.String r1 = "local_id = ?"
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ all -> 0x00cb }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00cb }
            r9 = 0
            r3[r9] = r8     // Catch:{ all -> 0x00cb }
            r8 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r4 = r7.siDbHelper     // Catch:{ Exception -> 0x004e }
            android.database.sqlite.SQLiteDatabase r8 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x004e }
            r8.beginTransaction()     // Catch:{ Exception -> 0x004e }
            java.lang.String r4 = "si_word_probabilities_table"
            r8.delete(r4, r0, r3)     // Catch:{ Exception -> 0x004e }
            java.lang.String r4 = "si_models_table"
            r8.delete(r4, r1, r3)     // Catch:{ Exception -> 0x004e }
            r8.setTransactionSuccessful()     // Catch:{ Exception -> 0x004e }
            boolean r9 = r8.inTransaction()     // Catch:{ Exception -> 0x0030 }
            if (r9 == 0) goto L_0x00a1
            r8.endTransaction()     // Catch:{ Exception -> 0x0030 }
            goto L_0x00a1
        L_0x0030:
            r8 = move-exception
            java.lang.String r9 = "Helpshift_SiDB"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r0.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = "Exception in ending transaction : word probabilites table or models table with "
            r0.append(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = java.util.Arrays.toString(r3)     // Catch:{ all -> 0x00cb }
            r0.append(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00cb }
            com.helpshift.util.HSLogger.m3242e(r9, r0, r8)     // Catch:{ all -> 0x00cb }
            goto L_0x00a1
        L_0x004c:
            r9 = move-exception
            goto L_0x00a3
        L_0x004e:
            r2 = move-exception
            java.lang.String r4 = "Helpshift_SiDB"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r5.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r6 = "Error in delete word probabilities table or models table for selection :"
            r5.append(r6)     // Catch:{ all -> 0x004c }
            r5.append(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = "  "
            r5.append(r0)     // Catch:{ all -> 0x004c }
            r5.append(r1)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = "and selectionArgs"
            r5.append(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = java.util.Arrays.toString(r3)     // Catch:{ all -> 0x004c }
            r5.append(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x004c }
            com.helpshift.util.HSLogger.m3242e(r4, r0, r2)     // Catch:{ all -> 0x004c }
            if (r8 == 0) goto L_0x00a0
            boolean r0 = r8.inTransaction()     // Catch:{ Exception -> 0x0085 }
            if (r0 == 0) goto L_0x00a0
            r8.endTransaction()     // Catch:{ Exception -> 0x0085 }
            goto L_0x00a0
        L_0x0085:
            r8 = move-exception
            java.lang.String r0 = "Helpshift_SiDB"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r1.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Exception in ending transaction : word probabilites table or models table with "
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = java.util.Arrays.toString(r3)     // Catch:{ all -> 0x00cb }
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00cb }
            com.helpshift.util.HSLogger.m3242e(r0, r1, r8)     // Catch:{ all -> 0x00cb }
        L_0x00a0:
            r2 = 0
        L_0x00a1:
            monitor-exit(r7)
            return r2
        L_0x00a3:
            if (r8 == 0) goto L_0x00ca
            boolean r0 = r8.inTransaction()     // Catch:{ Exception -> 0x00af }
            if (r0 == 0) goto L_0x00ca
            r8.endTransaction()     // Catch:{ Exception -> 0x00af }
            goto L_0x00ca
        L_0x00af:
            r8 = move-exception
            java.lang.String r0 = "Helpshift_SiDB"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r1.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Exception in ending transaction : word probabilites table or models table with "
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = java.util.Arrays.toString(r3)     // Catch:{ all -> 0x00cb }
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00cb }
            com.helpshift.util.HSLogger.m3242e(r0, r1, r8)     // Catch:{ all -> 0x00cb }
        L_0x00ca:
            throw r9     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.deleteModelAndWordProbabilities(long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Exception in ending transaction : smartintents table or tree table with " + java.util.Arrays.toString(r3), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a3, code lost:
        if (r8 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a9, code lost:
        if (r8.inTransaction() != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        r8.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Exception in ending transaction : smartintents table or tree table with " + java.util.Arrays.toString(r3), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ca, code lost:
        throw r9;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0026, B:18:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean deleteTreeAndSmartIntents(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "tree_local_id = ? "
            java.lang.String r1 = "local_id = ?"
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ all -> 0x00cb }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00cb }
            r9 = 0
            r3[r9] = r8     // Catch:{ all -> 0x00cb }
            r8 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r4 = r7.siDbHelper     // Catch:{ Exception -> 0x004e }
            android.database.sqlite.SQLiteDatabase r8 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x004e }
            r8.beginTransaction()     // Catch:{ Exception -> 0x004e }
            java.lang.String r4 = "si_intents_table"
            r8.delete(r4, r0, r3)     // Catch:{ Exception -> 0x004e }
            java.lang.String r4 = "si_tree_table"
            r8.delete(r4, r1, r3)     // Catch:{ Exception -> 0x004e }
            r8.setTransactionSuccessful()     // Catch:{ Exception -> 0x004e }
            boolean r9 = r8.inTransaction()     // Catch:{ Exception -> 0x0030 }
            if (r9 == 0) goto L_0x00a1
            r8.endTransaction()     // Catch:{ Exception -> 0x0030 }
            goto L_0x00a1
        L_0x0030:
            r8 = move-exception
            java.lang.String r9 = "Helpshift_SiDB"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r0.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = "Exception in ending transaction : smartintents table or tree table with "
            r0.append(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = java.util.Arrays.toString(r3)     // Catch:{ all -> 0x00cb }
            r0.append(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00cb }
            com.helpshift.util.HSLogger.m3242e(r9, r0, r8)     // Catch:{ all -> 0x00cb }
            goto L_0x00a1
        L_0x004c:
            r9 = move-exception
            goto L_0x00a3
        L_0x004e:
            r2 = move-exception
            java.lang.String r4 = "Helpshift_SiDB"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r5.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r6 = "Error in delete smart intents table or tree table for selection :"
            r5.append(r6)     // Catch:{ all -> 0x004c }
            r5.append(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = "  "
            r5.append(r0)     // Catch:{ all -> 0x004c }
            r5.append(r1)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = "and selectionArgs"
            r5.append(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = java.util.Arrays.toString(r3)     // Catch:{ all -> 0x004c }
            r5.append(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x004c }
            com.helpshift.util.HSLogger.m3242e(r4, r0, r2)     // Catch:{ all -> 0x004c }
            if (r8 == 0) goto L_0x00a0
            boolean r0 = r8.inTransaction()     // Catch:{ Exception -> 0x0085 }
            if (r0 == 0) goto L_0x00a0
            r8.endTransaction()     // Catch:{ Exception -> 0x0085 }
            goto L_0x00a0
        L_0x0085:
            r8 = move-exception
            java.lang.String r0 = "Helpshift_SiDB"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r1.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Exception in ending transaction : smartintents table or tree table with "
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = java.util.Arrays.toString(r3)     // Catch:{ all -> 0x00cb }
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00cb }
            com.helpshift.util.HSLogger.m3242e(r0, r1, r8)     // Catch:{ all -> 0x00cb }
        L_0x00a0:
            r2 = 0
        L_0x00a1:
            monitor-exit(r7)
            return r2
        L_0x00a3:
            if (r8 == 0) goto L_0x00ca
            boolean r0 = r8.inTransaction()     // Catch:{ Exception -> 0x00af }
            if (r0 == 0) goto L_0x00ca
            r8.endTransaction()     // Catch:{ Exception -> 0x00af }
            goto L_0x00ca
        L_0x00af:
            r8 = move-exception
            java.lang.String r0 = "Helpshift_SiDB"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r1.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Exception in ending transaction : smartintents table or tree table with "
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = java.util.Arrays.toString(r3)     // Catch:{ all -> 0x00cb }
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00cb }
            com.helpshift.util.HSLogger.m3242e(r0, r1, r8)     // Catch:{ all -> 0x00cb }
        L_0x00ca:
            throw r9     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.deleteTreeAndSmartIntents(long):boolean");
    }

    private List<SmartIntentDTO> filterRootIntents(List<SmartIntentDTO> list) {
        ArrayList arrayList = new ArrayList();
        for (SmartIntentDTO next : list) {
            if (StringUtils.isEmpty(next.parentServerId)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static synchronized SmartIntentDB getInstance(Context context) {
        SmartIntentDB smartIntentDB;
        synchronized (SmartIntentDB.class) {
            if (mInstance == null) {
                mInstance = new SmartIntentDB(context);
            }
            smartIntentDB = mInstance;
        }
        return smartIntentDB;
    }

    private List<SmartIntentDTO> getIntentsFlatList(List<SmartIntentDTO> list) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList(list);
        if (ListUtils.isEmpty(list)) {
            return arrayList;
        }
        while (!linkedList.isEmpty()) {
            SmartIntentDTO smartIntentDTO = (SmartIntentDTO) linkedList.poll();
            arrayList.add(smartIntentDTO);
            if (ListUtils.isNotEmpty(smartIntentDTO.children)) {
                linkedList.addAll(smartIntentDTO.children);
                smartIntentDTO.children.clear();
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r10 == null) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.helpshift.conversation.smartintent.dto.SmartIntentDTO> getSmartIntents(long r9) {
        /*
            r8 = this;
            java.lang.String r3 = "tree_local_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r10 = 0
            r4[r10] = r9
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r0 = r8.siDbHelper     // Catch:{ Exception -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r1 = "si_intents_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0038 }
            boolean r0 = r10.moveToFirst()     // Catch:{ Exception -> 0x0038 }
            if (r0 == 0) goto L_0x0042
        L_0x0028:
            com.helpshift.conversation.smartintent.dto.SmartIntentDTO r0 = r8.cursorToSmartIntent(r10)     // Catch:{ Exception -> 0x0038 }
            r9.add(r0)     // Catch:{ Exception -> 0x0038 }
            boolean r0 = r10.moveToNext()     // Catch:{ Exception -> 0x0038 }
            if (r0 != 0) goto L_0x0028
            goto L_0x0042
        L_0x0036:
            r9 = move-exception
            goto L_0x0046
        L_0x0038:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in reading smart intents from db"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0036 }
            if (r10 == 0) goto L_0x0045
        L_0x0042:
            r10.close()
        L_0x0045:
            return r9
        L_0x0046:
            if (r10 == 0) goto L_0x004b
            r10.close()
        L_0x004b:
            goto L_0x004d
        L_0x004c:
            throw r9
        L_0x004d:
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.getSmartIntents(long):java.util.List");
    }

    private synchronized long insert(ContentValues contentValues, String str) {
        long j;
        try {
            j = this.siDbHelper.getWritableDatabase().insert(str, (String) null, contentValues);
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in inserting in table: " + str, e);
            j = -1;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070 A[SYNTHETIC, Splitter:B:25:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082 A[SYNTHETIC, Splitter:B:34:0x0082] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.Long> insertSmartIntents(long r7, java.util.List<com.helpshift.conversation.smartintent.dto.SmartIntentDTO> r9) {
        /*
            r6 = this;
            java.lang.String r0 = "Error in ending the insert txn in smart intents table: "
            java.lang.String r1 = "Helpshift_SiDB"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x0012:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0026
            java.lang.Object r4 = r9.next()
            com.helpshift.conversation.smartintent.dto.SmartIntentDTO r4 = (com.helpshift.conversation.smartintent.dto.SmartIntentDTO) r4
            android.content.ContentValues r4 = r6.smartIntentToContentValues(r4, r7)
            r3.add(r4)
            goto L_0x0012
        L_0x0026:
            r7 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r8 = r6.siDbHelper     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            android.database.sqlite.SQLiteDatabase r8 = r8.getWritableDatabase()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            r8.beginTransaction()     // Catch:{ Exception -> 0x005b }
            java.util.Iterator r9 = r3.iterator()     // Catch:{ Exception -> 0x005b }
        L_0x0034:
            boolean r3 = r9.hasNext()     // Catch:{ Exception -> 0x005b }
            if (r3 == 0) goto L_0x004e
            java.lang.Object r3 = r9.next()     // Catch:{ Exception -> 0x005b }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = "si_intents_table"
            long r3 = r8.insert(r4, r7, r3)     // Catch:{ Exception -> 0x005b }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x005b }
            r2.add(r3)     // Catch:{ Exception -> 0x005b }
            goto L_0x0034
        L_0x004e:
            r8.setTransactionSuccessful()     // Catch:{ Exception -> 0x005b }
            boolean r7 = r8.inTransaction()     // Catch:{ Exception -> 0x007a }
            if (r7 == 0) goto L_0x007e
            r8.endTransaction()     // Catch:{ Exception -> 0x007a }
            goto L_0x007e
        L_0x005b:
            r7 = move-exception
            goto L_0x0066
        L_0x005d:
            r8 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x0080
        L_0x0062:
            r8 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0066:
            r2.clear()     // Catch:{ all -> 0x007f }
            java.lang.String r9 = "Error in inserting in smart intents table: "
            com.helpshift.util.HSLogger.m3242e(r1, r9, r7)     // Catch:{ all -> 0x007f }
            if (r8 == 0) goto L_0x007e
            boolean r7 = r8.inTransaction()     // Catch:{ Exception -> 0x007a }
            if (r7 == 0) goto L_0x007e
            r8.endTransaction()     // Catch:{ Exception -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r7 = move-exception
            com.helpshift.util.HSLogger.m3242e(r1, r0, r7)
        L_0x007e:
            return r2
        L_0x007f:
            r7 = move-exception
        L_0x0080:
            if (r8 == 0) goto L_0x0090
            boolean r9 = r8.inTransaction()     // Catch:{ Exception -> 0x008c }
            if (r9 == 0) goto L_0x0090
            r8.endTransaction()     // Catch:{ Exception -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r8 = move-exception
            com.helpshift.util.HSLogger.m3242e(r1, r0, r8)
        L_0x0090:
            goto L_0x0092
        L_0x0091:
            throw r7
        L_0x0092:
            goto L_0x0091
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.insertSmartIntents(long, java.util.List):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080 A[SYNTHETIC, Splitter:B:25:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092 A[SYNTHETIC, Splitter:B:34:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.Long> insertWordProbabilities(long r8, java.util.Map<java.lang.String, java.util.List<java.lang.Double>> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "Error in ending the insert txn in word probabilities table: "
            java.lang.String r1 = "Helpshift_SiDB"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0016:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x0036
            java.lang.Object r4 = r10.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.getValue()
            java.util.List r4 = (java.util.List) r4
            android.content.ContentValues r4 = r7.wordProbabilitiesToContentValues(r8, r5, r4)
            r3.add(r4)
            goto L_0x0016
        L_0x0036:
            r8 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r9 = r7.siDbHelper     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            android.database.sqlite.SQLiteDatabase r9 = r9.getWritableDatabase()     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            r9.beginTransaction()     // Catch:{ Exception -> 0x006b }
            java.util.Iterator r10 = r3.iterator()     // Catch:{ Exception -> 0x006b }
        L_0x0044:
            boolean r3 = r10.hasNext()     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x005e
            java.lang.Object r3 = r10.next()     // Catch:{ Exception -> 0x006b }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "si_word_probabilities_table"
            long r3 = r9.insert(r4, r8, r3)     // Catch:{ Exception -> 0x006b }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x006b }
            r2.add(r3)     // Catch:{ Exception -> 0x006b }
            goto L_0x0044
        L_0x005e:
            r9.setTransactionSuccessful()     // Catch:{ Exception -> 0x006b }
            boolean r8 = r9.inTransaction()     // Catch:{ Exception -> 0x008a }
            if (r8 == 0) goto L_0x008e
            r9.endTransaction()     // Catch:{ Exception -> 0x008a }
            goto L_0x008e
        L_0x006b:
            r8 = move-exception
            goto L_0x0076
        L_0x006d:
            r9 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x0090
        L_0x0072:
            r9 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0076:
            r2.clear()     // Catch:{ all -> 0x008f }
            java.lang.String r10 = "Error in inserting in word probabilities table: "
            com.helpshift.util.HSLogger.m3242e(r1, r10, r8)     // Catch:{ all -> 0x008f }
            if (r9 == 0) goto L_0x008e
            boolean r8 = r9.inTransaction()     // Catch:{ Exception -> 0x008a }
            if (r8 == 0) goto L_0x008e
            r9.endTransaction()     // Catch:{ Exception -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r8 = move-exception
            com.helpshift.util.HSLogger.m3242e(r1, r0, r8)
        L_0x008e:
            return r2
        L_0x008f:
            r8 = move-exception
        L_0x0090:
            if (r9 == 0) goto L_0x00a0
            boolean r10 = r9.inTransaction()     // Catch:{ Exception -> 0x009c }
            if (r10 == 0) goto L_0x00a0
            r9.endTransaction()     // Catch:{ Exception -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r9 = move-exception
            com.helpshift.util.HSLogger.m3242e(r1, r0, r9)
        L_0x00a0:
            goto L_0x00a2
        L_0x00a1:
            throw r8
        L_0x00a2:
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.insertWordProbabilities(long, java.util.Map):java.util.List");
    }

    private ContentValues smartIntentModelToContentValues(long j, SISearchModelDTO sISearchModelDTO) {
        String jSONArray = HSJSONUtils.listToJsonArray(sISearchModelDTO.leafIntentServerIds).toString();
        String jSONArray2 = HSJSONUtils.doubleListToJsonArray(sISearchModelDTO.leafIntentBaseProbabilities).toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("local_id", sISearchModelDTO.localId);
        contentValues.put("tree_local_id", Long.valueOf(j));
        contentValues.put("version", sISearchModelDTO.version);
        contentValues.put("last_refreshed_at", Long.valueOf(sISearchModelDTO.lastRefreshedAt));
        contentValues.put(SmartIntentModelsTable.Columns.CONFIDENCE_THRESHOLD, sISearchModelDTO.confidenceThreshold);
        contentValues.put(SmartIntentModelsTable.Columns.MAX_COMBINED_CONFIDENCE, sISearchModelDTO.maxCombinedConfidence);
        contentValues.put(SmartIntentModelsTable.Columns.LEAF_INTENT_SERVER_IDS, jSONArray);
        contentValues.put(SmartIntentModelsTable.Columns.LEAF_INTENT_BASE_PROBABILITIES, jSONArray2);
        return contentValues;
    }

    private ContentValues smartIntentToContentValues(SmartIntentDTO smartIntentDTO, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tree_local_id", Long.valueOf(j));
        contentValues.put("label", smartIntentDTO.label);
        contentValues.put("server_id", smartIntentDTO.serverId);
        contentValues.put(SmartIntentsTable.Columns.SI_INTENT_PARENT_SERVER_ID, smartIntentDTO.parentServerId);
        return contentValues;
    }

    private ContentValues smartIntentTreeToContentValues(SITreeDTO sITreeDTO, UserDM userDM) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_local_id", userDM.getLocalId());
        contentValues.put("server_id", sITreeDTO.serverId);
        contentValues.put(SmartIntentTreeTable.Columns.TREE_VERSION, Integer.valueOf(sITreeDTO.version));
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_ENFORCE_INTENT_SELECTION, Integer.valueOf(sITreeDTO.enforceIntentSelection ? 1 : 0));
        contentValues.put("last_refreshed_at", Long.valueOf(sITreeDTO.lastRefreshedAt));
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_PROMPT_TITLE, sITreeDTO.promptTitle);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_TEXT_INPUT_HINT, sITreeDTO.textInputHint);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_SEARCH_TITLE, sITreeDTO.searchTitle);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_TITLE, sITreeDTO.emptySearchTitle);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_DESCRIPTION, sITreeDTO.emptySearchDescription);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_TOKEN_DELIMITER, HSJSONUtils.listToJsonArray(sITreeDTO.tokenDelimiter).toString());
        return contentValues;
    }

    private ContentValues wordProbabilitiesToContentValues(long j, String str, List<Double> list) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SmartIntentWordProbabilitiesTable.Columns.SI_WORD_PROBABILITIES_MODEL_LOCAL_ID, Long.valueOf(j));
        contentValues.put(SmartIntentWordProbabilitiesTable.Columns.SI_WORD_PROBABILITIES_WORD, str);
        contentValues.put(SmartIntentWordProbabilitiesTable.Columns.SI_WORD_PROBABILITIES_PROBABILITIES, HSJSONUtils.doubleListToJsonArray(list).toString());
        return contentValues;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (r9 == null) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean deleteModel(long r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r3 = "tree_local_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ all -> 0x004b }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x004b }
            r10 = 0
            r4[r10] = r9     // Catch:{ all -> 0x004b }
            r9 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r0 = r8.siDbHelper     // Catch:{ Exception -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r1 = "si_models_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0038 }
            boolean r0 = r9.moveToFirst()     // Catch:{ Exception -> 0x0038 }
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = "local_id"
            int r0 = r9.getColumnIndex(r0)     // Catch:{ Exception -> 0x0038 }
            long r0 = r9.getLong(r0)     // Catch:{ Exception -> 0x0038 }
            boolean r10 = r8.deleteModelAndWordProbabilities(r0)     // Catch:{ Exception -> 0x0038 }
        L_0x0032:
            r9.close()     // Catch:{ all -> 0x004b }
            goto L_0x0043
        L_0x0036:
            r10 = move-exception
            goto L_0x0045
        L_0x0038:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in deleting the model table"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0036 }
            if (r9 == 0) goto L_0x0043
            goto L_0x0032
        L_0x0043:
            monitor-exit(r8)
            return r10
        L_0x0045:
            if (r9 == 0) goto L_0x004a
            r9.close()     // Catch:{ all -> 0x004b }
        L_0x004a:
            throw r10     // Catch:{ all -> 0x004b }
        L_0x004b:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x004f
        L_0x004e:
            throw r9
        L_0x004f:
            goto L_0x004e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.deleteModel(long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (deleteModel(r0) != false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r11 != null) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean deleteTreeAndModel(com.helpshift.account.domainmodel.UserDM r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r3 = "user_local_id = ? "
            r8 = 1
            java.lang.String[] r4 = new java.lang.String[r8]     // Catch:{ all -> 0x005d }
            java.lang.Long r11 = r11.getLocalId()     // Catch:{ all -> 0x005d }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x005d }
            r9 = 0
            r4[r9] = r11     // Catch:{ all -> 0x005d }
            r11 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r0 = r10.siDbHelper     // Catch:{ Exception -> 0x004a }
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x004a }
            java.lang.String r1 = "si_tree_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x004a }
            boolean r0 = r11.moveToFirst()     // Catch:{ Exception -> 0x004a }
            if (r0 == 0) goto L_0x0044
            java.lang.String r0 = "local_id"
            int r0 = r11.getColumnIndex(r0)     // Catch:{ Exception -> 0x004a }
            long r0 = r11.getLong(r0)     // Catch:{ Exception -> 0x004a }
            boolean r2 = r10.deleteTreeAndSmartIntents(r0)     // Catch:{ Exception -> 0x004a }
            if (r2 == 0) goto L_0x0042
            boolean r0 = r10.deleteModel(r0)     // Catch:{ Exception -> 0x003f }
            if (r0 == 0) goto L_0x0042
            goto L_0x0043
        L_0x003f:
            r0 = move-exception
            r9 = r2
            goto L_0x004b
        L_0x0042:
            r8 = 0
        L_0x0043:
            r9 = r8
        L_0x0044:
            r11.close()     // Catch:{ all -> 0x005d }
            goto L_0x0055
        L_0x0048:
            r0 = move-exception
            goto L_0x0057
        L_0x004a:
            r0 = move-exception
        L_0x004b:
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in deleting the tree and model"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0048 }
            if (r11 == 0) goto L_0x0055
            goto L_0x0044
        L_0x0055:
            monitor-exit(r10)
            return r9
        L_0x0057:
            if (r11 == 0) goto L_0x005c
            r11.close()     // Catch:{ all -> 0x005d }
        L_0x005c:
            throw r0     // Catch:{ all -> 0x005d }
        L_0x005d:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0061
        L_0x0060:
            throw r11
        L_0x0061:
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.deleteTreeAndModel(com.helpshift.account.domainmodel.UserDM):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r11 != null) goto L_0x0027;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.helpshift.conversation.smartintent.dto.SISearchModelDTO getModelWithoutWordProbabilities(long r10) {
        /*
            r9 = this;
            java.lang.String r3 = "tree_local_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r11 = 0
            r4[r11] = r10
            r10 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r11 = r9.siDbHelper     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            android.database.sqlite.SQLiteDatabase r0 = r11.getReadableDatabase()     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            java.lang.String r1 = "si_models_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            boolean r0 = r11.moveToFirst()     // Catch:{ Exception -> 0x002b }
            if (r0 == 0) goto L_0x0027
            com.helpshift.conversation.smartintent.dto.SISearchModelDTO r10 = r9.cursorToModelWithoutWordProbabilities(r11)     // Catch:{ Exception -> 0x002b }
        L_0x0027:
            r11.close()
            goto L_0x003e
        L_0x002b:
            r0 = move-exception
            goto L_0x0034
        L_0x002d:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x0040
        L_0x0032:
            r0 = move-exception
            r11 = r10
        L_0x0034:
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in reading the search model "
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x003f }
            if (r11 == 0) goto L_0x003e
            goto L_0x0027
        L_0x003e:
            return r10
        L_0x003f:
            r10 = move-exception
        L_0x0040:
            if (r11 == 0) goto L_0x0045
            r11.close()
        L_0x0045:
            goto L_0x0047
        L_0x0046:
            throw r10
        L_0x0047:
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.getModelWithoutWordProbabilities(long):com.helpshift.conversation.smartintent.dto.SISearchModelDTO");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r11 != null) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.helpshift.conversation.smartintent.dto.SITreeDTO getSmartIntentTree(long r10) {
        /*
            r9 = this;
            java.lang.String r3 = "user_local_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r11 = 0
            r4[r11] = r10
            r10 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r11 = r9.siDbHelper     // Catch:{ Exception -> 0x0044, all -> 0x003f }
            android.database.sqlite.SQLiteDatabase r0 = r11.getReadableDatabase()     // Catch:{ Exception -> 0x0044, all -> 0x003f }
            java.lang.String r1 = "si_tree_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0044, all -> 0x003f }
            boolean r0 = r11.moveToFirst()     // Catch:{ Exception -> 0x003d }
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = "local_id"
            int r0 = r11.getColumnIndex(r0)     // Catch:{ Exception -> 0x003d }
            long r0 = r11.getLong(r0)     // Catch:{ Exception -> 0x003d }
            java.util.List r0 = r9.getSmartIntents(r0)     // Catch:{ Exception -> 0x003d }
            java.util.List r0 = r9.buildIntentTree(r0)     // Catch:{ Exception -> 0x003d }
            com.helpshift.conversation.smartintent.dto.SITreeDTO r10 = r9.cursorToSmartIntentTree(r11, r0)     // Catch:{ Exception -> 0x003d }
        L_0x0039:
            r11.close()
            goto L_0x0050
        L_0x003d:
            r0 = move-exception
            goto L_0x0046
        L_0x003f:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x0052
        L_0x0044:
            r0 = move-exception
            r11 = r10
        L_0x0046:
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in reading smart intent tree"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0051 }
            if (r11 == 0) goto L_0x0050
            goto L_0x0039
        L_0x0050:
            return r10
        L_0x0051:
            r10 = move-exception
        L_0x0052:
            if (r11 == 0) goto L_0x0057
            r11.close()
        L_0x0057:
            goto L_0x0059
        L_0x0058:
            throw r10
        L_0x0059:
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.getSmartIntentTree(long):com.helpshift.conversation.smartintent.dto.SITreeDTO");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r11 != null) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Double> getWordToIntentProbabilities(long r10, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r3 = "model_local_id = ? AND word = ?"
            r0 = 2
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r11 = 0
            r4[r11] = r10
            java.lang.String r10 = java.lang.String.valueOf(r12)
            r11 = 1
            r4[r11] = r10
            r10 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r11 = r9.siDbHelper     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            android.database.sqlite.SQLiteDatabase r0 = r11.getReadableDatabase()     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            java.lang.String r1 = "si_word_probabilities_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x0032 }
            if (r12 == 0) goto L_0x002e
            java.util.List r10 = r9.cursorToWordProbabilities(r11)     // Catch:{ Exception -> 0x0032 }
        L_0x002e:
            r11.close()
            goto L_0x0045
        L_0x0032:
            r12 = move-exception
            goto L_0x003b
        L_0x0034:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x0047
        L_0x0039:
            r12 = move-exception
            r11 = r10
        L_0x003b:
            java.lang.String r0 = "Helpshift_SiDB"
            java.lang.String r1 = "Error in getting word probabilities "
            com.helpshift.util.HSLogger.m3242e(r0, r1, r12)     // Catch:{ all -> 0x0046 }
            if (r11 == 0) goto L_0x0045
            goto L_0x002e
        L_0x0045:
            return r10
        L_0x0046:
            r10 = move-exception
        L_0x0047:
            if (r11 == 0) goto L_0x004c
            r11.close()
        L_0x004c:
            goto L_0x004e
        L_0x004d:
            throw r10
        L_0x004e:
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.conversation.smartintent.SmartIntentDB.getWordToIntentProbabilities(long, java.lang.String):java.util.List");
    }

    public synchronized boolean insertModel(long j, SISearchModelDTO sISearchModelDTO) {
        long insert = insert(smartIntentModelToContentValues(j, sISearchModelDTO), SmartIntentModelsTable.TABLE_NAME);
        if (insert == -1) {
            return false;
        }
        if (!ListUtils.isEmpty(insertWordProbabilities(insert, sISearchModelDTO.wordToLeafIntentProbabilitiesMapping))) {
            return true;
        }
        deleteModelAndWordProbabilities(insert);
        return false;
    }

    public synchronized boolean insertTree(UserDM userDM, SITreeDTO sITreeDTO) {
        long insert = insert(smartIntentTreeToContentValues(sITreeDTO, userDM), SmartIntentTreeTable.TABLE_NAME);
        if (insert == -1) {
            return false;
        }
        if (!ListUtils.isEmpty(insertSmartIntents(insert, getIntentsFlatList(sITreeDTO.rootIntents)))) {
            return true;
        }
        deleteTreeAndSmartIntents(insert);
        return false;
    }

    public synchronized boolean updateModelRefreshedAt(long j, long j2) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_refreshed_at", Long.valueOf(j2));
        z = true;
        try {
            this.siDbHelper.getWritableDatabase().update(SmartIntentModelsTable.TABLE_NAME, contentValues, "tree_local_id = ? ", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in updating model refreshedAt", e);
            z = false;
        }
        return z;
    }

    public synchronized boolean updateTreeRefreshedAt(UserDM userDM, long j) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_refreshed_at", Long.valueOf(j));
        z = true;
        try {
            this.siDbHelper.getWritableDatabase().update(SmartIntentTreeTable.TABLE_NAME, contentValues, "user_local_id = ? ", new String[]{String.valueOf(userDM.getLocalId())});
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in updating tree refreshedAt", e);
            z = false;
        }
        return z;
    }
}
