package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.vungle.warren.log.LogEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

@WorkerThread
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class SQLiteEventStore implements EventStore, SynchronizationGuard {
    public static final Encoding PROTOBUF_ENCODING = new Encoding("proto");
    public final EventStoreConfig config;
    public final Clock monotonicClock;
    public final SchemaManager schemaManager;
    public final Clock wallClock;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public interface Function<T, U> {
        U apply(T t);
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static class Metadata {
        public final String key;
        public final String value;

        public Metadata(String str, String str2, C16181 r3) {
            this.key = str;
            this.value = str2;
        }
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public interface Producer<T> {
        T produce();
    }

    public SQLiteEventStore(Clock clock, Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager2) {
        this.schemaManager = schemaManager2;
        this.wallClock = clock;
        this.monotonicClock = clock2;
        this.config = eventStoreConfig;
    }

    public static /* synthetic */ Object lambda$ensureBeginTransaction$15(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ SQLiteDatabase lambda$getDb$0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Long lambda$getNextCallTime$4(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ Long lambda$getTransportContextId$2(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    public static Boolean lambda$hasPendingEventsFor$5(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long transportContextId = sQLiteEventStore.getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return Boolean.FALSE;
        }
        return (Boolean) tryWithCursor(sQLiteEventStore.getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()}), SQLiteEventStore$$Lambda$20.instance);
    }

    public static List lambda$loadActiveContexts$8(Cursor cursor) {
        byte[] bArr;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            TransportContext.Builder builder = TransportContext.builder();
            builder.setBackendName(cursor.getString(1));
            builder.setPriority(PriorityMapping.valueOf(cursor.getInt(2)));
            String string = cursor.getString(3);
            if (string == null) {
                bArr = null;
            } else {
                bArr = Base64.decode(string, 0);
            }
            AutoValue_TransportContext.Builder builder2 = (AutoValue_TransportContext.Builder) builder;
            builder2.extras = bArr;
            arrayList.add(builder2.build());
        }
        return arrayList;
    }

    public static List lambda$loadActiveContexts$9(SQLiteDatabase sQLiteDatabase) {
        return (List) tryWithCursor(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), SQLiteEventStore$$Lambda$19.instance);
    }

    public static List lambda$loadBatch$7(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        SQLiteEventStore sQLiteEventStore2 = sQLiteEventStore;
        TransportContext transportContext2 = transportContext;
        if (sQLiteEventStore2 != null) {
            ArrayList arrayList = new ArrayList();
            Long transportContextId = sQLiteEventStore.getTransportContextId(sQLiteDatabase, transportContext);
            if (transportContextId != null) {
                String[] strArr = {transportContextId.toString()};
                Cursor query = sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code"}, "context_id = ?", strArr, (String) null, (String) null, (String) null, String.valueOf(((AutoValue_EventStoreConfig) sQLiteEventStore2.config).loadBatchSize));
                try {
                    lambda$loadEvents$12(arrayList, transportContext, query);
                    query.close();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    query.close();
                    throw th2;
                }
            }
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder("event_id IN (");
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(((AutoValue_PersistedEvent) ((PersistedEvent) arrayList.get(i))).f2765id);
                if (i < arrayList.size() - 1) {
                    sb.append(',');
                }
            }
            sb.append(')');
            Cursor query2 = sQLiteDatabase.query("event_metadata", new String[]{LogEntry.LOG_ITEM_EVENT_ID, "name", "value"}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null);
            try {
                lambda$loadMetadata$13(hashMap, query2);
                query2.close();
                ListIterator listIterator = arrayList.listIterator();
                while (listIterator.hasNext()) {
                    AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) ((PersistedEvent) listIterator.next());
                    if (hashMap.containsKey(Long.valueOf(autoValue_PersistedEvent.f2765id))) {
                        EventInternal.Builder builder = autoValue_PersistedEvent.event.toBuilder();
                        for (Metadata metadata : (Set) hashMap.get(Long.valueOf(autoValue_PersistedEvent.f2765id))) {
                            builder.addMetadata(metadata.key, metadata.value);
                        }
                        listIterator.set(new AutoValue_PersistedEvent(autoValue_PersistedEvent.f2765id, autoValue_PersistedEvent.transportContext, builder.build()));
                    }
                }
                return arrayList;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                query2.close();
                throw th4;
            }
        } else {
            throw null;
        }
    }

    public static Object lambda$loadEvents$12(List list, TransportContext transportContext, Cursor cursor) {
        Encoding encoding;
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            AutoValue_EventInternal.Builder builder = new AutoValue_EventInternal.Builder();
            builder.autoMetadata = new HashMap();
            builder.setTransportName(cursor.getString(1));
            builder.setEventMillis(cursor.getLong(2));
            builder.setUptimeMillis(cursor.getLong(3));
            String string = cursor.getString(4);
            if (string == null) {
                encoding = PROTOBUF_ENCODING;
            } else {
                encoding = new Encoding(string);
            }
            builder.setEncodedPayload(new EncodedPayload(encoding, cursor.getBlob(5)));
            if (!cursor.isNull(6)) {
                builder.code = Integer.valueOf(cursor.getInt(6));
            }
            list.add(new AutoValue_PersistedEvent(j, transportContext, builder.build()));
        }
        return null;
    }

    public static /* synthetic */ Object lambda$loadMetadata$13(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new Metadata(cursor.getString(1), cursor.getString(2), (C16181) null));
        }
        return null;
    }

    public static Long lambda$persist$1(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal, SQLiteDatabase sQLiteDatabase) {
        long j;
        if (sQLiteEventStore.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong() >= ((AutoValue_EventStoreConfig) sQLiteEventStore.config).maxStorageSizeInBytes) {
            return -1L;
        }
        Long transportContextId = sQLiteEventStore.getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId != null) {
            j = transportContextId.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext;
            contentValues.put("backend_name", autoValue_TransportContext.backendName);
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority)));
            contentValues.put("next_request_ms", 0);
            byte[] bArr = autoValue_TransportContext.extras;
            if (bArr != null) {
                contentValues.put("extras", Base64.encodeToString(bArr, 0));
            }
            j = sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(j));
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) eventInternal;
        contentValues2.put("transport_name", autoValue_EventInternal.transportName);
        contentValues2.put("timestamp_ms", Long.valueOf(autoValue_EventInternal.eventMillis));
        contentValues2.put("uptime_ms", Long.valueOf(autoValue_EventInternal.uptimeMillis));
        contentValues2.put("payload_encoding", autoValue_EventInternal.encodedPayload.encoding.name);
        contentValues2.put("payload", autoValue_EventInternal.encodedPayload.bytes);
        contentValues2.put("code", autoValue_EventInternal.code);
        contentValues2.put("num_attempts", 0);
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues2);
        for (Map.Entry next : Collections.unmodifiableMap(autoValue_EventInternal.autoMetadata).entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put(LogEntry.LOG_ITEM_EVENT_ID, Long.valueOf(insert));
            contentValues3.put("name", (String) next.getKey());
            contentValues3.put("value", (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    public static /* synthetic */ Object lambda$recordFailure$3(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 10").execute();
        return null;
    }

    public static Object lambda$recordNextCallTime$6(long j, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{((AutoValue_TransportContext) transportContext).backendName, String.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority))}) < 1) {
            contentValues.put("backend_name", autoValue_TransportContext.backendName);
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority)));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    public static String toIdList(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((AutoValue_PersistedEvent) it.next()).f2765id);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> T tryWithCursor(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public int cleanUp() {
        long time = this.wallClock.getTime() - ((AutoValue_EventStoreConfig) this.config).eventCleanUpAge;
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            Integer lambda$cleanUp$10 = Integer.valueOf(db.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(time)}));
            db.setTransactionSuccessful();
            db.endTransaction();
            return lambda$cleanUp$10.intValue();
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    public void close() {
        this.schemaManager.close();
    }

    public final SQLiteDatabase getDb() {
        SchemaManager schemaManager2 = this.schemaManager;
        schemaManager2.getClass();
        return (SQLiteDatabase) retryIfDbLocked(new SQLiteEventStore$$Lambda$1(schemaManager2), SQLiteEventStore$$Lambda$4.instance);
    }

    /* JADX INFO: finally extract failed */
    public long getNextCallTime(TransportContext transportContext) {
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext;
        Cursor rawQuery = getDb().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{autoValue_TransportContext.backendName, String.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority))});
        try {
            Long lambda$getNextCallTime$4 = lambda$getNextCallTime$4(rawQuery);
            rawQuery.close();
            return lambda$getNextCallTime$4.longValue();
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Nullable
    public final Long getTransportContextId(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext;
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{((AutoValue_TransportContext) transportContext).backendName, String.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority))}));
        if (autoValue_TransportContext.extras != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(autoValue_TransportContext.extras, 0));
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null);
        try {
            return lambda$getTransportContextId$2(query);
        } finally {
            query.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean hasPendingEventsFor(TransportContext transportContext) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            Boolean lambda$hasPendingEventsFor$5 = lambda$hasPendingEventsFor$5(this, transportContext, db);
            db.setTransactionSuccessful();
            db.endTransaction();
            return lambda$hasPendingEventsFor$5.booleanValue();
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    public Iterable<TransportContext> loadActiveContexts() {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            List lambda$loadActiveContexts$9 = lambda$loadActiveContexts$9(db);
            db.setTransactionSuccessful();
            return lambda$loadActiveContexts$9;
        } finally {
            db.endTransaction();
        }
    }

    public Iterable<PersistedEvent> loadBatch(TransportContext transportContext) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            List lambda$loadBatch$7 = lambda$loadBatch$7(this, transportContext, db);
            db.setTransactionSuccessful();
            return lambda$loadBatch$7;
        } finally {
            db.endTransaction();
        }
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public PersistedEvent persist(TransportContext transportContext, EventInternal eventInternal) {
        zzam.m36d("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", ((AutoValue_TransportContext) transportContext).priority, ((AutoValue_EventInternal) eventInternal).transportName, ((AutoValue_TransportContext) transportContext).backendName);
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            Long lambda$persist$1 = lambda$persist$1(this, transportContext, eventInternal, db);
            db.setTransactionSuccessful();
            db.endTransaction();
            long longValue = lambda$persist$1.longValue();
            if (longValue < 1) {
                return null;
            }
            return new AutoValue_PersistedEvent(longValue, transportContext, eventInternal);
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    public void recordFailure(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            outline24.append(toIdList(iterable));
            String sb = outline24.toString();
            SQLiteDatabase db = getDb();
            db.beginTransaction();
            try {
                lambda$recordFailure$3(sb, db);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }
    }

    public void recordNextCallTime(TransportContext transportContext, long j) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            lambda$recordNextCallTime$6(j, transportContext, db);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public void recordSuccess(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("DELETE FROM events WHERE _id in ");
            outline24.append(toIdList(iterable));
            getDb().compileStatement(outline24.toString()).execute();
        }
    }

    public final <T> T retryIfDbLocked(Producer<T> producer, Function<Throwable, T> function) {
        long time = this.monotonicClock.getTime();
        while (true) {
            try {
                return producer.produce();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.monotonicClock.getTime() >= ((long) ((AutoValue_EventStoreConfig) this.config).criticalSectionEnterTimeoutMs) + time) {
                    return function.apply(e);
                }
                SystemClock.sleep(50);
            }
        }
    }

    public <T> T runCriticalSection(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase db = getDb();
        retryIfDbLocked(new SQLiteEventStore$$Lambda$17(db), SQLiteEventStore$$Lambda$18.instance);
        try {
            T execute = criticalSection.execute();
            db.setTransactionSuccessful();
            return execute;
        } finally {
            db.endTransaction();
        }
    }
}
