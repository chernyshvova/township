package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class SchemaManager extends SQLiteOpenHelper {
    public static final List<Migration> INCREMENTAL_MIGRATIONS;
    public static final Migration MIGRATE_TO_V1 = SchemaManager$$Lambda$1.instance;
    public static final Migration MIGRATE_TO_V2 = SchemaManager$$Lambda$2.instance;
    public static final Migration MIGRATE_TO_V3;
    public static int SCHEMA_VERSION = 3;
    public boolean configured = false;
    public final int schemaVersion;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public interface Migration {
        void upgrade(SQLiteDatabase sQLiteDatabase);
    }

    static {
        SchemaManager$$Lambda$3 schemaManager$$Lambda$3 = SchemaManager$$Lambda$3.instance;
        MIGRATE_TO_V3 = schemaManager$$Lambda$3;
        INCREMENTAL_MIGRATIONS = Arrays.asList(new Migration[]{MIGRATE_TO_V1, MIGRATE_TO_V2, schemaManager$$Lambda$3});
    }

    public SchemaManager(Context context, int i) {
        super(context, "com.google.android.datatransport.events", (SQLiteDatabase.CursorFactory) null, i);
        this.schemaVersion = i;
    }

    public static /* synthetic */ void lambda$static$0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void lambda$static$1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.configured = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
        upgrade(sQLiteDatabase, 0, this.schemaVersion);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
        upgrade(sQLiteDatabase, 0, this.schemaVersion);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
        upgrade(sQLiteDatabase, i, i2);
    }

    public final void upgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= INCREMENTAL_MIGRATIONS.size()) {
            while (i < i2) {
                INCREMENTAL_MIGRATIONS.get(i).upgrade(sQLiteDatabase);
                i++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i + " to " + i2 + " was requested, but cannot be performed. Only " + INCREMENTAL_MIGRATIONS.size() + " migrations are provided");
    }
}
