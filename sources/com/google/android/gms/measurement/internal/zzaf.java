package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.app.FrameMetricsAggregator;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.log.LogEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzaf extends zzki {
    public static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", VungleApiClient.ANDROID_ID, "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    public static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public final zzag zzj = new zzag(this, zzm(), "google_app_measurement.db");
    public final zzke zzk = new zzke(zzl());

    public zzaf(zzkl zzkl) {
        super(zzkl);
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = mo31260c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                rawQuery.close();
                return j2;
            }
            rawQuery.close();
            return j;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @VisibleForTesting
    private final boolean zzal() {
        return zzm().getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = mo31260c_().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                cursor.close();
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    /* renamed from: b_ */
    public final void mo31259b_() {
        zzaj();
        mo31260c_().setTransactionSuccessful();
    }

    @WorkerThread
    @VisibleForTesting
    /* renamed from: c_ */
    public final SQLiteDatabase mo31260c_() {
        zzc();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzq().zzh().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d  */
    @androidx.annotation.WorkerThread
    /* renamed from: d_ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo31261d_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.mo31260c_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0025, all -> 0x0020 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001e }
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0027
        L_0x0020:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003b
        L_0x0025:
            r2 = move-exception
            r0 = r1
        L_0x0027:
            com.google.android.gms.measurement.internal.zzeq r3 = r6.zzq()     // Catch:{ all -> 0x003a }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0039
            r0.close()
        L_0x0039:
            return r1
        L_0x003a:
            r1 = move-exception
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            r0.close()
        L_0x0040:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.mo31261d_():java.lang.String");
    }

    /* renamed from: e_ */
    public final boolean mo31262e_() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzkw zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzc()
            r18.zzaj()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.mo31260c_()     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            r1 = 0
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            r2 = 1
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            boolean r3 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0072 }
            if (r3 != 0) goto L_0x003d
            r10.close()
            return r9
        L_0x003d:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0072 }
            r11 = r18
            java.lang.Object r7 = r11.zza((android.database.Cursor) r10, (int) r2)     // Catch:{ SQLiteException -> 0x0070 }
            java.lang.String r3 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ SQLiteException -> 0x0070 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0070 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0070 }
            if (r1 == 0) goto L_0x006c
            com.google.android.gms.measurement.internal.zzeq r1 = r18.zzq()     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ SQLiteException -> 0x0070 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x0070 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0070 }
        L_0x006c:
            r10.close()
            return r0
        L_0x0070:
            r0 = move-exception
            goto L_0x0082
        L_0x0072:
            r0 = move-exception
            r11 = r18
            goto L_0x00a2
        L_0x0076:
            r0 = move-exception
            r11 = r18
            goto L_0x0082
        L_0x007a:
            r0 = move-exception
            r11 = r18
            goto L_0x00a3
        L_0x007e:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x0082:
            com.google.android.gms.measurement.internal.zzeq r1 = r18.zzq()     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r19)     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzeo r4 = r18.zzn()     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = r4.zzc(r8)     // Catch:{ all -> 0x00a1 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x00a1 }
            if (r10 == 0) goto L_0x00a0
            r10.close()
        L_0x00a0:
            return r9
        L_0x00a1:
            r0 = move-exception
        L_0x00a2:
            r9 = r10
        L_0x00a3:
            if (r9 == 0) goto L_0x00a8
            r9.close()
        L_0x00a8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzkw");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0121  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzz zzd(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r7 = r31
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzc()
            r29.zzaj()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r29.mo31260c_()     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            java.lang.String r12 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            r1 = 0
            r13[r1] = r30     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            r2 = 1
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            boolean r3 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            if (r3 != 0) goto L_0x004c
            r9.close()
            return r8
        L_0x004c:
            java.lang.String r16 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            r10 = r29
            java.lang.Object r5 = r10.zza((android.database.Cursor) r9, (int) r2)     // Catch:{ SQLiteException -> 0x00ec }
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00ec }
            if (r0 == 0) goto L_0x005f
            r20 = 1
            goto L_0x0061
        L_0x005f:
            r20 = 0
        L_0x0061:
            r0 = 3
            java.lang.String r21 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00ec }
            r0 = 4
            long r23 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzkr r0 = r29.mo31422f_()     // Catch:{ SQLiteException -> 0x00ec }
            r1 = 5
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r2 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00ec }
            r22 = r0
            com.google.android.gms.measurement.internal.zzaq r22 = (com.google.android.gms.measurement.internal.zzaq) r22     // Catch:{ SQLiteException -> 0x00ec }
            r0 = 6
            long r18 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzkr r0 = r29.mo31422f_()     // Catch:{ SQLiteException -> 0x00ec }
            r1 = 7
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r2 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00ec }
            r25 = r0
            com.google.android.gms.measurement.internal.zzaq r25 = (com.google.android.gms.measurement.internal.zzaq) r25     // Catch:{ SQLiteException -> 0x00ec }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ec }
            r0 = 9
            long r26 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzkr r0 = r29.mo31422f_()     // Catch:{ SQLiteException -> 0x00ec }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r2 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00ec }
            r28 = r0
            com.google.android.gms.measurement.internal.zzaq r28 = (com.google.android.gms.measurement.internal.zzaq) r28     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzku r17 = new com.google.android.gms.measurement.internal.zzku     // Catch:{ SQLiteException -> 0x00ec }
            r1 = r17
            r2 = r31
            r6 = r16
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzz r0 = new com.google.android.gms.measurement.internal.zzz     // Catch:{ SQLiteException -> 0x00ec }
            r14 = r0
            r15 = r30
            r14.<init>(r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r28)     // Catch:{ SQLiteException -> 0x00ec }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00ec }
            if (r1 == 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzeq r1 = r29.zzq()     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r30)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzeo r4 = r29.zzn()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ SQLiteException -> 0x00ec }
            r1.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x00ec }
        L_0x00e8:
            r9.close()
            return r0
        L_0x00ec:
            r0 = move-exception
            goto L_0x00fe
        L_0x00ee:
            r0 = move-exception
            r10 = r29
            goto L_0x011e
        L_0x00f2:
            r0 = move-exception
            r10 = r29
            goto L_0x00fe
        L_0x00f6:
            r0 = move-exception
            r10 = r29
            goto L_0x011f
        L_0x00fa:
            r0 = move-exception
            r10 = r29
            r9 = r8
        L_0x00fe:
            com.google.android.gms.measurement.internal.zzeq r1 = r29.zzq()     // Catch:{ all -> 0x011d }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ all -> 0x011d }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r30)     // Catch:{ all -> 0x011d }
            com.google.android.gms.measurement.internal.zzeo r4 = r29.zzn()     // Catch:{ all -> 0x011d }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ all -> 0x011d }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x011d }
            if (r9 == 0) goto L_0x011c
            r9.close()
        L_0x011c:
            return r8
        L_0x011d:
            r0 = move-exception
        L_0x011e:
            r8 = r9
        L_0x011f:
            if (r8 == 0) goto L_0x0124
            r8.close()
        L_0x0124:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzz");
    }

    public final boolean zzd() {
        return false;
    }

    @WorkerThread
    public final void zze() {
        zzaj();
        mo31260c_().beginTransaction();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bb A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbv.zzb>> zzf(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzaj()
            r12.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.mo31260c_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0092 }
            r14.close()
            return r13
        L_0x0040:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.internal.measurement.zzbv$zzb$zza r2 = com.google.android.gms.internal.measurement.zzbv.zzb.zzl()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzji r1 = com.google.android.gms.measurement.internal.zzkr.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzbv$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzbv.zzb.zza) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzy()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzbv$zzb r1 = (com.google.android.gms.internal.measurement.zzbv.zzb) r1     // Catch:{ IOException -> 0x0076 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0092 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0092 }
            if (r3 != 0) goto L_0x0072
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0092 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0072:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0092 }
            goto L_0x0088
        L_0x0076:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzeq r2 = r12.zzq()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0092 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0088:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            r14.close()
            return r0
        L_0x0092:
            r0 = move-exception
            goto L_0x0098
        L_0x0094:
            r13 = move-exception
            goto L_0x00cd
        L_0x0096:
            r0 = move-exception
            r14 = r9
        L_0x0098:
            com.google.android.gms.measurement.internal.zzeq r1 = r12.zzq()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r13)     // Catch:{ all -> 0x00cb }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x00cb }
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzab r0 = r12.zzs()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch:{ all -> 0x00cb }
            boolean r13 = r0.zze(r13, r1)     // Catch:{ all -> 0x00cb }
            if (r13 == 0) goto L_0x00c5
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00cb }
            if (r14 == 0) goto L_0x00c4
            r14.close()
        L_0x00c4:
            return r13
        L_0x00c5:
            if (r14 == 0) goto L_0x00ca
            r14.close()
        L_0x00ca:
            return r9
        L_0x00cb:
            r13 = move-exception
            r9 = r14
        L_0x00cd:
            if (r9 == 0) goto L_0x00d2
            r9.close()
        L_0x00d2:
            goto L_0x00d4
        L_0x00d3:
            throw r13
        L_0x00d4:
            goto L_0x00d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    @WorkerThread
    public final void zzg() {
        zzaj();
        mo31260c_().endTransaction();
    }

    @WorkerThread
    @VisibleForTesting
    public final long zzh(String str, String str2) {
        long zza;
        String str3 = str;
        String str4 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        SQLiteDatabase c_ = mo31260c_();
        c_.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str4);
            sb.append(" from app2 where app_id=?");
            try {
                zza = zza(sb.toString(), new String[]{str3}, -1);
                if (zza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", 0);
                    contentValues.put("previous_install_count", 0);
                    if (c_.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                        zzq().zze().zza("Failed to insert column (got -1). appId", zzeq.zza(str), str4);
                        c_.endTransaction();
                        return -1;
                    }
                    zza = 0;
                }
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzq().zze().zza("Error inserting column. appId", zzeq.zza(str), str4, e);
                    c_.endTransaction();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    c_.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put(str4, Long.valueOf(1 + zza));
                if (((long) c_.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                    zzq().zze().zza("Failed to update column (got 0). appId", zzeq.zza(str), str4);
                    c_.endTransaction();
                    return -1;
                }
                c_.setTransactionSuccessful();
                c_.endTransaction();
                return zza;
            } catch (SQLiteException e2) {
                e = e2;
                j = zza;
                zzq().zze().zza("Error inserting column. appId", zzeq.zza(str), str4, e);
                c_.endTransaction();
                return j;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzq().zze().zza("Error inserting column. appId", zzeq.zza(str), str4, e);
            c_.endTransaction();
            return j;
        } catch (Throwable th2) {
            th = th2;
            c_.endTransaction();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzi(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzc()
            r7.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.mo31260c_()     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r2 != 0) goto L_0x002e
            com.google.android.gms.measurement.internal.zzeq r8 = r7.zzq()     // Catch:{ SQLiteException -> 0x00b6 }
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzw()     // Catch:{ SQLiteException -> 0x00b6 }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x00b6 }
            r1.close()
            return r0
        L_0x002e:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x00b6 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r3 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzji r2 = com.google.android.gms.measurement.internal.zzkr.zza(r3, (byte[]) r2)     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzy()     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ IOException -> 0x00a0 }
            r7.mo31422f_()     // Catch:{ SQLiteException -> 0x00b6 }
            java.util.List r8 = r2.zza()     // Catch:{ SQLiteException -> 0x00b6 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00b6 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00b6 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00b6 }
        L_0x0054:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r3 == 0) goto L_0x009c
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00b6 }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3     // Catch:{ SQLiteException -> 0x00b6 }
            java.lang.String r4 = r3.zzb()     // Catch:{ SQLiteException -> 0x00b6 }
            boolean r5 = r3.zzi()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r5 == 0) goto L_0x0072
            double r5 = r3.zzj()     // Catch:{ SQLiteException -> 0x00b6 }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00b6 }
            goto L_0x0054
        L_0x0072:
            boolean r5 = r3.zzg()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r5 == 0) goto L_0x0080
            float r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x00b6 }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00b6 }
            goto L_0x0054
        L_0x0080:
            boolean r5 = r3.zzc()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r5 == 0) goto L_0x008e
            java.lang.String r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x00b6 }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00b6 }
            goto L_0x0054
        L_0x008e:
            boolean r5 = r3.zze()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r5 == 0) goto L_0x0054
            long r5 = r3.zzf()     // Catch:{ SQLiteException -> 0x00b6 }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00b6 }
            goto L_0x0054
        L_0x009c:
            r1.close()
            return r2
        L_0x00a0:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzeq r3 = r7.zzq()     // Catch:{ SQLiteException -> 0x00b6 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ SQLiteException -> 0x00b6 }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x00b6 }
            r3.zza(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00b6 }
            r1.close()
            return r0
        L_0x00b6:
            r8 = move-exception
            goto L_0x00bc
        L_0x00b8:
            r8 = move-exception
            goto L_0x00d1
        L_0x00ba:
            r8 = move-exception
            r1 = r0
        L_0x00bc:
            com.google.android.gms.measurement.internal.zzeq r2 = r7.zzq()     // Catch:{ all -> 0x00cf }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r8)     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x00ce
            r1.close()
        L_0x00ce:
            return r0
        L_0x00cf:
            r8 = move-exception
            r0 = r1
        L_0x00d1:
            if (r0 == 0) goto L_0x00d6
            r0.close()
        L_0x00d6:
            goto L_0x00d8
        L_0x00d7:
            throw r8
        L_0x00d8:
            goto L_0x00d7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzi(java.lang.String):android.os.Bundle");
    }

    public final zzac zzj(String str) {
        Preconditions.checkNotNull(str);
        zzc();
        zzaj();
        return zzac.zza(zza("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str}, "G1"));
    }

    @WorkerThread
    public final void zzu() {
        int delete;
        zzc();
        zzaj();
        if (zzal()) {
            long zza = zzr().zzf.zza();
            long elapsedRealtime = zzl().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzas.zzx.zza(null).longValue()) {
                zzr().zzf.zza(elapsedRealtime);
                zzc();
                zzaj();
                if (zzal() && (delete = mo31260c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzl().currentTimeMillis()), String.valueOf(zzab.zzu())})) > 0) {
                    zzq().zzw().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    @WorkerThread
    public final long zzv() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    @WorkerThread
    public final long zzw() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzz() {
        Cursor cursor = null;
        try {
            cursor = mo31260c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return -1;
            }
            long j = cursor.getLong(0);
            cursor.close();
            return j;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            return mo31260c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting conditional property", zzeq.zza(str), zzn().zzc(str2), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bb A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbv.zze>> zzg(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzaj()
            r12.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.mo31260c_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0092 }
            r14.close()
            return r13
        L_0x0040:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.internal.measurement.zzbv$zze$zza r2 = com.google.android.gms.internal.measurement.zzbv.zze.zzi()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzji r1 = com.google.android.gms.measurement.internal.zzkr.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzbv$zze$zza r1 = (com.google.android.gms.internal.measurement.zzbv.zze.zza) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzy()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzbv$zze r1 = (com.google.android.gms.internal.measurement.zzbv.zze) r1     // Catch:{ IOException -> 0x0076 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0092 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0092 }
            if (r3 != 0) goto L_0x0072
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0092 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0072:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0092 }
            goto L_0x0088
        L_0x0076:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzeq r2 = r12.zzq()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0092 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0088:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            r14.close()
            return r0
        L_0x0092:
            r0 = move-exception
            goto L_0x0098
        L_0x0094:
            r13 = move-exception
            goto L_0x00cd
        L_0x0096:
            r0 = move-exception
            r14 = r9
        L_0x0098:
            com.google.android.gms.measurement.internal.zzeq r1 = r12.zzq()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r13)     // Catch:{ all -> 0x00cb }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x00cb }
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzab r0 = r12.zzs()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch:{ all -> 0x00cb }
            boolean r13 = r0.zze(r13, r1)     // Catch:{ all -> 0x00cb }
            if (r13 == 0) goto L_0x00c5
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00cb }
            if (r14 == 0) goto L_0x00c4
            r14.close()
        L_0x00c4:
            return r13
        L_0x00c5:
            if (r14 == 0) goto L_0x00ca
            r14.close()
        L_0x00ca:
            return r9
        L_0x00cb:
            r13 = move-exception
            r9 = r14
        L_0x00cd:
            if (r9 == 0) goto L_0x00d2
            r9.close()
        L_0x00d2:
            goto L_0x00d4
        L_0x00d3:
            throw r13
        L_0x00d4:
            goto L_0x00d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    @WorkerThread
    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = mo31260c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                rawQuery.close();
                return string;
            }
            rawQuery.close();
            return str2;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            mo31260c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting user property. appId", zzeq.zza(str), zzn().zzc(str2), e);
        }
    }

    public final Map<Integer, List<zzbv.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = mo31260c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzbv.zzb>> emptyMap = Collections.emptyMap();
                cursor.close();
                return emptyMap;
            }
            do {
                try {
                    zzbv.zzb zzb2 = (zzbv.zzb) ((zzhy) ((zzbv.zzb.zza) zzkr.zza(zzbv.zzb.zzl(), cursor.getBlob(1))).zzy());
                    if (zzb2.zzf()) {
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e) {
                    zzq().zze().zza("Failed to merge filter. appId", zzeq.zza(str), e);
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayMap;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e2);
            Map<Integer, List<zzbv.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014b  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzam zza(java.lang.String r26, java.lang.String r27) {
        /*
            r25 = this;
            r15 = r27
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            r25.zzc()
            r25.zzaj()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r1 = "lifetime_count"
            java.lang.String r2 = "current_bundle_count"
            java.lang.String r3 = "last_fire_timestamp"
            java.lang.String r4 = "last_bundled_timestamp"
            java.lang.String r5 = "last_bundled_day"
            java.lang.String r6 = "last_sampled_complex_event_id"
            java.lang.String r7 = "last_sampling_rate"
            java.lang.String r8 = "last_exempt_from_sampling"
            java.lang.String r9 = "current_session_count"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r18 = 0
            android.database.sqlite.SQLiteDatabase r1 = r25.mo31260c_()     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            java.lang.String r2 = "events"
            r9 = 0
            java.lang.String[] r3 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r3 = r0
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            java.lang.String r4 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r5[r9] = r26     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r10 = 1
            r5[r10] = r15     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r1 != 0) goto L_0x005a
            r14.close()
            return r18
        L_0x005a:
            long r4 = r14.getLong(r9)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            long r6 = r14.getLong(r10)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            long r11 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r0 = 3
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r2 = 0
            if (r1 == 0) goto L_0x0072
            r16 = r2
            goto L_0x0078
        L_0x0072:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r16 = r0
        L_0x0078:
            r0 = 4
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r1 == 0) goto L_0x0082
            r0 = r18
            goto L_0x008a
        L_0x0082:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
        L_0x008a:
            r1 = 5
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 == 0) goto L_0x0094
            r19 = r18
            goto L_0x009e
        L_0x0094:
            long r19 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            java.lang.Long r1 = java.lang.Long.valueOf(r19)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r19 = r1
        L_0x009e:
            r1 = 6
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 == 0) goto L_0x00a8
            r20 = r18
            goto L_0x00b2
        L_0x00a8:
            long r20 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            java.lang.Long r1 = java.lang.Long.valueOf(r20)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r20 = r1
        L_0x00b2:
            r1 = 7
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 != 0) goto L_0x00cd
            long r21 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x00cb }
            r23 = 1
            int r1 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r1 != 0) goto L_0x00c4
            r9 = 1
        L_0x00c4:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)     // Catch:{ SQLiteException -> 0x00cb }
            r21 = r1
            goto L_0x00cf
        L_0x00cb:
            r0 = move-exception
            goto L_0x0125
        L_0x00cd:
            r21 = r18
        L_0x00cf:
            r1 = 8
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 == 0) goto L_0x00d9
            r8 = r2
            goto L_0x00de
        L_0x00d9:
            long r1 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r8 = r1
        L_0x00de:
            com.google.android.gms.measurement.internal.zzam r22 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r1 = r22
            r2 = r26
            r3 = r27
            r10 = r11
            r12 = r16
            r23 = r14
            r14 = r0
            r15 = r19
            r16 = r20
            r17 = r21
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            boolean r0 = r23.moveToNext()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            if (r0 == 0) goto L_0x010c
            com.google.android.gms.measurement.internal.zzeq r0 = r25.zzq()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zze()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            java.lang.String r1 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r26)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
        L_0x010c:
            r23.close()
            return r22
        L_0x0110:
            r0 = move-exception
            goto L_0x0119
        L_0x0112:
            r0 = move-exception
            r14 = r23
            goto L_0x0125
        L_0x0116:
            r0 = move-exception
            r23 = r14
        L_0x0119:
            r18 = r23
            goto L_0x0149
        L_0x011c:
            r0 = move-exception
            r23 = r14
            goto L_0x0125
        L_0x0120:
            r0 = move-exception
            goto L_0x0149
        L_0x0122:
            r0 = move-exception
            r14 = r18
        L_0x0125:
            com.google.android.gms.measurement.internal.zzeq r1 = r25.zzq()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r26)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.measurement.internal.zzeo r4 = r25.zzn()     // Catch:{ all -> 0x0146 }
            r5 = r27
            java.lang.String r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x0146 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0146 }
            if (r14 == 0) goto L_0x0145
            r14.close()
        L_0x0145:
            return r18
        L_0x0146:
            r0 = move-exception
            r18 = r14
        L_0x0149:
            if (r18 == 0) goto L_0x014e
            r18.close()
        L_0x014e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzam");
    }

    @WorkerThread
    public final List<zzz> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        try {
            return (long) mo31260c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(FrameMetricsAggregator.FrameMetricsApi24Impl.NANOS_PER_MS, zzs().zzb(str, zzas.zzo))))});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting over the limit events. appId", zzeq.zza(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008a A[Catch:{ all -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzf(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzaj()
            r7.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.mo31260c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0065, all -> 0x0063 }
            r5 = 0
            r4[r5] = r8     // Catch:{ SQLiteException -> 0x0065, all -> 0x0063 }
            r6 = 1
            r4[r6] = r8     // Catch:{ SQLiteException -> 0x0065, all -> 0x0063 }
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0065, all -> 0x0063 }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0061 }
            if (r3 != 0) goto L_0x0030
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0061 }
            r1.close()
            return r8
        L_0x0030:
            int r3 = r1.getInt(r5)     // Catch:{ SQLiteException -> 0x0061 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0061 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ SQLiteException -> 0x0061 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x0061 }
            if (r4 != 0) goto L_0x004c
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0061 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0061 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0061 }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x0061 }
        L_0x004c:
            int r3 = r1.getInt(r6)     // Catch:{ SQLiteException -> 0x0061 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0061 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x0061 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0061 }
            if (r3 != 0) goto L_0x0030
            r1.close()
            return r0
        L_0x0061:
            r0 = move-exception
            goto L_0x0067
        L_0x0063:
            r8 = move-exception
            goto L_0x009c
        L_0x0065:
            r0 = move-exception
            r1 = r2
        L_0x0067:
            com.google.android.gms.measurement.internal.zzeq r3 = r7.zzq()     // Catch:{ all -> 0x009a }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ all -> 0x009a }
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r8)     // Catch:{ all -> 0x009a }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x009a }
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch:{ all -> 0x009a }
            if (r0 == 0) goto L_0x0094
            com.google.android.gms.measurement.internal.zzab r0 = r7.zzs()     // Catch:{ all -> 0x009a }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch:{ all -> 0x009a }
            boolean r8 = r0.zze(r8, r3)     // Catch:{ all -> 0x009a }
            if (r8 == 0) goto L_0x0094
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x0093
            r1.close()
        L_0x0093:
            return r8
        L_0x0094:
            if (r1 == 0) goto L_0x0099
            r1.close()
        L_0x0099:
            return r2
        L_0x009a:
            r8 = move-exception
            r2 = r1
        L_0x009c:
            if (r2 == 0) goto L_0x00a1
            r2.close()
        L_0x00a1:
            goto L_0x00a3
        L_0x00a2:
            throw r8
        L_0x00a3:
            goto L_0x00a2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzf(java.lang.String):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bb A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzcd.zzi> zzg(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzaj()
            r11.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.mo31260c_()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r10 = 0
            r4[r10] = r12     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x004b
            boolean r1 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 == 0) goto L_0x0047
            com.google.android.gms.measurement.internal.zzab r1 = r11.zzs()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch:{ SQLiteException -> 0x0092 }
            boolean r1 = r1.zze(r12, r2)     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 == 0) goto L_0x0047
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0092 }
            r0.close()
            return r12
        L_0x0047:
            r0.close()
            return r8
        L_0x004b:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0092 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0050:
            int r2 = r0.getInt(r10)     // Catch:{ SQLiteException -> 0x0092 }
            byte[] r3 = r0.getBlob(r9)     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r4 = com.google.android.gms.internal.measurement.zzcd.zzi.zzi()     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzji r3 = com.google.android.gms.measurement.internal.zzkr.zza(r4, (byte[]) r3)     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r3 = (com.google.android.gms.internal.measurement.zzcd.zzi.zza) r3     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzjj r3 = r3.zzy()     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzhy r3 = (com.google.android.gms.internal.measurement.zzhy) r3     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzcd$zzi r3 = (com.google.android.gms.internal.measurement.zzcd.zzi) r3     // Catch:{ IOException -> 0x0072 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
            goto L_0x0088
        L_0x0072:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzeq r4 = r11.zzq()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zze()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r4.zza(r5, r6, r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0088:
            boolean r2 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x0092 }
            if (r2 != 0) goto L_0x0050
            r0.close()
            return r1
        L_0x0092:
            r1 = move-exception
            goto L_0x0098
        L_0x0094:
            r12 = move-exception
            goto L_0x00cd
        L_0x0096:
            r1 = move-exception
            r0 = r8
        L_0x0098:
            com.google.android.gms.measurement.internal.zzeq r2 = r11.zzq()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r12)     // Catch:{ all -> 0x00cb }
            r2.zza(r3, r4, r1)     // Catch:{ all -> 0x00cb }
            boolean r1 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzab r1 = r11.zzs()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch:{ all -> 0x00cb }
            boolean r12 = r1.zze(r12, r2)     // Catch:{ all -> 0x00cb }
            if (r12 == 0) goto L_0x00c5
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00c4
            r0.close()
        L_0x00c4:
            return r12
        L_0x00c5:
            if (r0 == 0) goto L_0x00ca
            r0.close()
        L_0x00ca:
            return r8
        L_0x00cb:
            r12 = move-exception
            r8 = r0
        L_0x00cd:
            if (r8 == 0) goto L_0x00d2
            r8.close()
        L_0x00d2:
            goto L_0x00d4
        L_0x00d3:
            throw r12
        L_0x00d4:
            goto L_0x00d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzg(java.lang.String):java.util.Map");
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0119 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x011d A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0157 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0170 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0185 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a1 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a2 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01b1 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01e7 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0229  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzb(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r35
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r35)
            r34.zzc()
            r34.zzaj()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r34.mo31260c_()     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            java.lang.String r4 = "apps"
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "ssaid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33}     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            java.lang.String r6 = "app_id=?"
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            r11 = 0
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0202, all -> 0x01fe }
            if (r4 != 0) goto L_0x0069
            r3.close()
            return r2
        L_0x0069:
            com.google.android.gms.measurement.internal.zzf r4 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ SQLiteException -> 0x0202, all -> 0x01fe }
            r5 = r34
            com.google.android.gms.measurement.internal.zzkl r6 = r5.zza     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzu()     // Catch:{ SQLiteException -> 0x01fc }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x01fc }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            java.lang.String r6 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzb((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 2
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zze((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 3
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzg((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zza((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 5
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzb((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 6
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzg((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 7
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzh((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 8
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzd((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 9
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zze((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 10
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r7 != 0) goto L_0x00d7
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 == 0) goto L_0x00d5
            goto L_0x00d7
        L_0x00d5:
            r6 = 0
            goto L_0x00d8
        L_0x00d7:
            r6 = 1
        L_0x00d8:
            r4.zza((boolean) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 11
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzj(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 12
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzk(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 13
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzl(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 14
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzm(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 15
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzh((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 16
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzi((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 17
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r7 == 0) goto L_0x011d
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0122
        L_0x011d:
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01fc }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x01fc }
        L_0x0122:
            r4.zzc((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 18
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzf((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 19
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzo(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 20
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzn(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 21
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzi((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzab r6 = r34.zzs()     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzas.zzbx     // Catch:{ SQLiteException -> 0x01fc }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x01fc }
            r7 = 0
            if (r6 != 0) goto L_0x0168
            r6 = 22
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r9 == 0) goto L_0x0161
            r9 = r7
            goto L_0x0165
        L_0x0161:
            long r9 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x0165:
            r4.zzp(r9)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x0168:
            r6 = 23
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r9 != 0) goto L_0x0179
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 == 0) goto L_0x0177
            goto L_0x0179
        L_0x0177:
            r6 = 0
            goto L_0x017a
        L_0x0179:
            r6 = 1
        L_0x017a:
            r4.zzb((boolean) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 24
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r9 != 0) goto L_0x018d
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 == 0) goto L_0x018c
            goto L_0x018d
        L_0x018c:
            r0 = 0
        L_0x018d:
            r4.zzc((boolean) r0)     // Catch:{ SQLiteException -> 0x01fc }
            r0 = 25
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzc((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x01fc }
            r0 = 26
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 == 0) goto L_0x01a2
            goto L_0x01a6
        L_0x01a2:
            long r7 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x01a6:
            r4.zzf((long) r7)     // Catch:{ SQLiteException -> 0x01fc }
            r0 = 27
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 != 0) goto L_0x01c3
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01fc }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x01fc }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zza((java.util.List<java.lang.String>) r0)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x01c3:
            boolean r0 = com.google.android.gms.internal.measurement.zznv.zzb()     // Catch:{ SQLiteException -> 0x01fc }
            if (r0 == 0) goto L_0x01de
            com.google.android.gms.measurement.internal.zzab r0 = r34.zzs()     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzbi     // Catch:{ SQLiteException -> 0x01fc }
            boolean r0 = r0.zze(r1, r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r0 == 0) goto L_0x01de
            r0 = 28
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzd((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x01de:
            r4.zzb()     // Catch:{ SQLiteException -> 0x01fc }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x01fc }
            if (r0 == 0) goto L_0x01f8
            com.google.android.gms.measurement.internal.zzeq r0 = r34.zzq()     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zze()     // Catch:{ SQLiteException -> 0x01fc }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r35)     // Catch:{ SQLiteException -> 0x01fc }
            r0.zza(r6, r7)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x01f8:
            r3.close()
            return r4
        L_0x01fc:
            r0 = move-exception
            goto L_0x020e
        L_0x01fe:
            r0 = move-exception
            r5 = r34
            goto L_0x0226
        L_0x0202:
            r0 = move-exception
            r5 = r34
            goto L_0x020e
        L_0x0206:
            r0 = move-exception
            r5 = r34
            goto L_0x0227
        L_0x020a:
            r0 = move-exception
            r5 = r34
            r3 = r2
        L_0x020e:
            com.google.android.gms.measurement.internal.zzeq r4 = r34.zzq()     // Catch:{ all -> 0x0225 }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zze()     // Catch:{ all -> 0x0225 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r35)     // Catch:{ all -> 0x0225 }
            r4.zza(r6, r1, r0)     // Catch:{ all -> 0x0225 }
            if (r3 == 0) goto L_0x0224
            r3.close()
        L_0x0224:
            return r2
        L_0x0225:
            r0 = move-exception
        L_0x0226:
            r2 = r3
        L_0x0227:
            if (r2 == 0) goto L_0x022c
            r2.close()
        L_0x022c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzd(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r10.zzc()
            r10.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.mo31260c_()     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            r9 = 0
            r5[r9] = r11     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x004e }
            if (r2 != 0) goto L_0x002f
            r1.close()
            return r0
        L_0x002f:
            byte[] r2 = r1.getBlob(r9)     // Catch:{ SQLiteException -> 0x004e }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x004e }
            if (r3 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzeq r3 = r10.zzq()     // Catch:{ SQLiteException -> 0x004e }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ SQLiteException -> 0x004e }
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x004e }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x004e }
        L_0x004a:
            r1.close()
            return r2
        L_0x004e:
            r2 = move-exception
            goto L_0x0054
        L_0x0050:
            r11 = move-exception
            goto L_0x006d
        L_0x0052:
            r2 = move-exception
            r1 = r0
        L_0x0054:
            com.google.android.gms.measurement.internal.zzeq r3 = r10.zzq()     // Catch:{ all -> 0x006b }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ all -> 0x006b }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r11)     // Catch:{ all -> 0x006b }
            r3.zza(r4, r11, r2)     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x006a
            r1.close()
        L_0x006a:
            return r0
        L_0x006b:
            r11 = move-exception
            r0 = r1
        L_0x006d:
            if (r0 == 0) goto L_0x0072
            r0.close()
        L_0x0072:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzd(java.lang.String):byte[]");
    }

    @WorkerThread
    public final void zza(zzam zzam) {
        Preconditions.checkNotNull(zzam);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzam.zza);
        contentValues.put("name", zzam.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzam.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzam.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzam.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzam.zzg));
        contentValues.put("last_bundled_day", zzam.zzh);
        contentValues.put("last_sampled_complex_event_id", zzam.zzi);
        contentValues.put("last_sampling_rate", zzam.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzam.zze));
        Boolean bool = zzam.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (mo31260c_().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update event aggregates (got -1). appId", zzeq.zza(zzam.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing event aggregates. appId", zzeq.zza(zzam.zza), e);
        }
    }

    @WorkerThread
    public final boolean zza(zzkw zzkw) {
        Preconditions.checkNotNull(zzkw);
        zzc();
        zzaj();
        if (zzc(zzkw.zza, zzkw.zzc) == null) {
            if (zzkv.zza(zzkw.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzkw.zza}) >= ((long) zzs().zzd(zzkw.zza))) {
                    return false;
                }
            } else if (!"_npa".equals(zzkw.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzkw.zza, zzkw.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkw.zza);
        contentValues.put("origin", zzkw.zzb);
        contentValues.put("name", zzkw.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzkw.zzd));
        zza(contentValues, "value", zzkw.zze);
        try {
            if (mo31260c_().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update user property (got -1). appId", zzeq.zza(zzkw.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing user property. appId", zzeq.zza(zzkw.zza), e);
        }
        return true;
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzaj();
        zzc();
        SQLiteDatabase c_ = mo31260c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzs().zzb(str, zzas.zzae)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            String outline12 = GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(join, 2), "(", join, ")");
            return c_.delete("audience_filter_values", GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(outline12, 140), "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", outline12, " order by rowid desc limit -1 offset ?)"), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5 A[Catch:{ all -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b9  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkw> zza(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r13.zzc()
            r13.zzaj()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.mo31260c_()     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            r12 = 0
            r6[r12] = r14     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x007c }
            if (r3 != 0) goto L_0x003d
            r2.close()
            return r0
        L_0x003d:
            java.lang.String r7 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x007c }
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x007c }
            if (r3 != 0) goto L_0x0049
            java.lang.String r3 = ""
        L_0x0049:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x007c }
            r3 = 3
            java.lang.Object r10 = r13.zza((android.database.Cursor) r2, (int) r3)     // Catch:{ SQLiteException -> 0x007c }
            if (r10 != 0) goto L_0x0068
            com.google.android.gms.measurement.internal.zzeq r3 = r13.zzq()     // Catch:{ SQLiteException -> 0x007c }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ SQLiteException -> 0x007c }
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r14)     // Catch:{ SQLiteException -> 0x007c }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x007c }
            goto L_0x0072
        L_0x0068:
            com.google.android.gms.measurement.internal.zzkw r3 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ SQLiteException -> 0x007c }
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x007c }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x007c }
        L_0x0072:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x007c }
            if (r3 != 0) goto L_0x003d
            r2.close()
            return r0
        L_0x007c:
            r0 = move-exception
            goto L_0x0082
        L_0x007e:
            r14 = move-exception
            goto L_0x00b7
        L_0x0080:
            r0 = move-exception
            r2 = r1
        L_0x0082:
            com.google.android.gms.measurement.internal.zzeq r3 = r13.zzq()     // Catch:{ all -> 0x00b5 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r14)     // Catch:{ all -> 0x00b5 }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x00b5 }
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzab r0 = r13.zzs()     // Catch:{ all -> 0x00b5 }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch:{ all -> 0x00b5 }
            boolean r14 = r0.zze(r14, r3)     // Catch:{ all -> 0x00b5 }
            if (r14 == 0) goto L_0x00af
            java.util.List r14 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00ae
            r2.close()
        L_0x00ae:
            return r14
        L_0x00af:
            if (r2 == 0) goto L_0x00b4
            r2.close()
        L_0x00b4:
            return r1
        L_0x00b5:
            r14 = move-exception
            r1 = r2
        L_0x00b7:
            if (r1 == 0) goto L_0x00bc
            r1.close()
        L_0x00bc:
            goto L_0x00be
        L_0x00bd:
            throw r14
        L_0x00be:
            goto L_0x00bd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f8, code lost:
        r12 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fc, code lost:
        r12 = r20;
        r3 = r22;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0124 A[Catch:{ all -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0138  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkw> zza(java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r20 = this;
            r8 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r20.zzc()
            r20.zzaj()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            r10 = 3
            r1.<init>(r10)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            r1.add(r8)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            java.lang.String r3 = "app_id=?"
            r2.<init>(r3)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            boolean r3 = android.text.TextUtils.isEmpty(r22)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            if (r3 != 0) goto L_0x0032
            r3 = r22
            r1.add(r3)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r4 = " and origin=?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            goto L_0x0034
        L_0x0032:
            r3 = r22
        L_0x0034:
            boolean r4 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            if (r4 != 0) goto L_0x004c
            java.lang.String r4 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r5 = "*"
            java.lang.String r4 = r4.concat(r5)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            r1.add(r4)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r4 = " and name glob ?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
        L_0x004c:
            int r4 = r1.size()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            r15 = r1
            java.lang.String[] r15 = (java.lang.String[]) r15     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            android.database.sqlite.SQLiteDatabase r11 = r20.mo31260c_()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r12 = "user_attributes"
            java.lang.String r1 = "name"
            java.lang.String r4 = "set_timestamp"
            java.lang.String r5 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r1, r4, r5, r6}     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r14 = r2.toString()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "1001"
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            boolean r1 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            if (r1 != 0) goto L_0x0085
            r11.close()
            return r0
        L_0x0085:
            int r1 = r0.size()     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 < r2) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzeq r1 = r20.zzq()     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r1.zza(r4, r2)     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r12 = r20
            goto L_0x00e0
        L_0x00a1:
            r1 = 0
            java.lang.String r4 = r11.getString(r1)     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r1 = 1
            long r5 = r11.getLong(r1)     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r1 = 2
            r12 = r20
            java.lang.Object r7 = r12.zza((android.database.Cursor) r11, (int) r1)     // Catch:{ SQLiteException -> 0x00e9 }
            java.lang.String r13 = r11.getString(r10)     // Catch:{ SQLiteException -> 0x00e9 }
            if (r7 != 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzeq r1 = r20.zzq()     // Catch:{ SQLiteException -> 0x00e6 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ SQLiteException -> 0x00e6 }
            java.lang.String r2 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r21)     // Catch:{ SQLiteException -> 0x00e6 }
            r14 = r23
            r1.zza(r2, r3, r13, r14)     // Catch:{ SQLiteException -> 0x00e6 }
            goto L_0x00da
        L_0x00cc:
            r14 = r23
            com.google.android.gms.measurement.internal.zzkw r15 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ SQLiteException -> 0x00e6 }
            r1 = r15
            r2 = r21
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x00e6 }
            r0.add(r15)     // Catch:{ SQLiteException -> 0x00e6 }
        L_0x00da:
            boolean r1 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x00e6 }
            if (r1 != 0) goto L_0x00e4
        L_0x00e0:
            r11.close()
            return r0
        L_0x00e4:
            r3 = r13
            goto L_0x0085
        L_0x00e6:
            r0 = move-exception
            r3 = r13
            goto L_0x0101
        L_0x00e9:
            r0 = move-exception
            goto L_0x0101
        L_0x00eb:
            r0 = move-exception
            r12 = r20
            goto L_0x0135
        L_0x00ef:
            r0 = move-exception
            r12 = r20
            goto L_0x0101
        L_0x00f3:
            r0 = move-exception
            r12 = r20
            goto L_0x0100
        L_0x00f7:
            r0 = move-exception
            r12 = r20
            goto L_0x0136
        L_0x00fb:
            r0 = move-exception
            r12 = r20
            r3 = r22
        L_0x0100:
            r11 = r9
        L_0x0101:
            com.google.android.gms.measurement.internal.zzeq r1 = r20.zzq()     // Catch:{ all -> 0x0134 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r21)     // Catch:{ all -> 0x0134 }
            r1.zza(r2, r4, r3, r0)     // Catch:{ all -> 0x0134 }
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch:{ all -> 0x0134 }
            if (r0 == 0) goto L_0x012e
            com.google.android.gms.measurement.internal.zzab r0 = r20.zzs()     // Catch:{ all -> 0x0134 }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch:{ all -> 0x0134 }
            boolean r0 = r0.zze(r8, r1)     // Catch:{ all -> 0x0134 }
            if (r0 == 0) goto L_0x012e
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0134 }
            if (r11 == 0) goto L_0x012d
            r11.close()
        L_0x012d:
            return r0
        L_0x012e:
            if (r11 == 0) goto L_0x0133
            r11.close()
        L_0x0133:
            return r9
        L_0x0134:
            r0 = move-exception
        L_0x0135:
            r9 = r11
        L_0x0136:
            if (r9 == 0) goto L_0x013b
            r9.close()
        L_0x013b:
            goto L_0x013d
        L_0x013c:
            throw r0
        L_0x013d:
            goto L_0x013c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @WorkerThread
    public final boolean zza(zzz zzz) {
        Preconditions.checkNotNull(zzz);
        zzc();
        zzaj();
        if (zzc(zzz.zza, zzz.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzz.zza}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzz.zza);
        contentValues.put("origin", zzz.zzb);
        contentValues.put("name", zzz.zzc.zza);
        zza(contentValues, "value", zzz.zzc.zza());
        contentValues.put("active", Boolean.valueOf(zzz.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzz.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzz.zzh));
        zzo();
        contentValues.put("timed_out_event", zzkv.zza((Parcelable) zzz.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzz.zzd));
        zzo();
        contentValues.put("triggered_event", zzkv.zza((Parcelable) zzz.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzz.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzz.zzj));
        zzo();
        contentValues.put("expired_event", zzkv.zza((Parcelable) zzz.zzk));
        try {
            if (mo31260c_().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update conditional user property (got -1)", zzeq.zza(zzz.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing conditional user property", zzeq.zza(zzz.zza), e);
        }
        return true;
    }

    public final List<zzz> zza(String str, String[] strArr) {
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = mo31260c_().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    long j2 = cursor.getLong(8);
                    long j3 = cursor.getLong(10);
                    boolean z2 = z;
                    zzz zzz = r3;
                    zzz zzz2 = new zzz(string, string2, new zzku(string3, j3, zza, string2), j2, z2, string4, (zzaq) mo31422f_().zza(cursor.getBlob(7), zzaq.CREATOR), j, (zzaq) mo31422f_().zza(cursor.getBlob(9), zzaq.CREATOR), cursor.getLong(11), (zzaq) mo31422f_().zza(cursor.getBlob(12), zzaq.CREATOR));
                    arrayList.add(zzz);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzq().zze().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            cursor.close();
            return arrayList;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error querying conditional user property value", e);
            List<zzz> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void zza(zzf zzf2) {
        Preconditions.checkNotNull(zzf2);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzf2.zzc());
        contentValues.put("app_instance_id", zzf2.zzd());
        contentValues.put("gmp_app_id", zzf2.zze());
        contentValues.put("resettable_device_id_hash", zzf2.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzf2.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzf2.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzf2.zzk()));
        contentValues.put("app_version", zzf2.zzl());
        contentValues.put("app_store", zzf2.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzf2.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzf2.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzf2.zzr()));
        contentValues.put("day", Long.valueOf(zzf2.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzf2.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzf2.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzf2.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzf2.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzf2.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzf2.zzm()));
        contentValues.put("firebase_instance_id", zzf2.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzf2.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzf2.zzaa()));
        contentValues.put("health_monitor_sample", zzf2.zzac());
        contentValues.put(VungleApiClient.ANDROID_ID, Long.valueOf(zzf2.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzf2.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzf2.zzag()));
        contentValues.put("admob_app_id", zzf2.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzf2.zzq()));
        if (zzf2.zzai() != null) {
            if (zzf2.zzai().size() == 0) {
                zzq().zzh().zza("Safelisted events should not be an empty list. appId", zzf2.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzf2.zzai()));
            }
        }
        if (zznv.zzb() && zzs().zze(zzf2.zzc(), zzas.zzbi)) {
            contentValues.put("ga_app_id", zzf2.zzg());
        }
        try {
            SQLiteDatabase c_ = mo31260c_();
            if (((long) c_.update("apps", contentValues, "app_id = ?", new String[]{zzf2.zzc()})) == 0 && c_.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update app (got -1). appId", zzeq.zza(zzf2.zzc()));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing app. appId", zzeq.zza(zzf2.zzc()), e);
        }
    }

    @WorkerThread
    public final zzae zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1, false, false, z3, false, z5);
    }

    @WorkerThread
    public final zzae zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        String[] strArr = {str};
        zzae zzae = new zzae();
        Cursor cursor = null;
        try {
            SQLiteDatabase c_ = mo31260c_();
            cursor = c_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                zzq().zzh().zza("Not updating daily counts, app is not known. appId", zzeq.zza(str));
                cursor.close();
                return zzae;
            }
            if (cursor.getLong(0) == j) {
                zzae.zzb = cursor.getLong(1);
                zzae.zza = cursor.getLong(2);
                zzae.zzc = cursor.getLong(3);
                zzae.zzd = cursor.getLong(4);
                zzae.zze = cursor.getLong(5);
            }
            if (z) {
                zzae.zzb += j2;
            }
            if (z2) {
                zzae.zza += j2;
            }
            if (z3) {
                zzae.zzc += j2;
            }
            if (z4) {
                zzae.zzd += j2;
            }
            if (z5) {
                zzae.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzae.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzae.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzae.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzae.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzae.zze));
            c_.update("apps", contentValues, "app_id=?", strArr);
            cursor.close();
            return zzae;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error updating daily counts. appId", zzeq.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzae;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final boolean zza(zzcd.zzg zzg2, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        Preconditions.checkState(zzg2.zzk());
        zzu();
        long currentTimeMillis = zzl().currentTimeMillis();
        if (zzg2.zzl() < currentTimeMillis - zzab.zzu() || zzg2.zzl() > zzab.zzu() + currentTimeMillis) {
            zzq().zzh().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeq.zza(zzg2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzg2.zzl()));
        }
        try {
            byte[] zzc2 = mo31422f_().zzc(zzg2.zzbk());
            zzq().zzw().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzg2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzg2.zzl()));
            contentValues.put("data", zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzg2.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzg2.zzba()));
            }
            try {
                if (mo31260c_().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzq().zze().zza("Failed to insert bundle (got -1). appId", zzeq.zza(zzg2.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzq().zze().zza("Error storing bundle. appId", zzeq.zza(zzg2.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzq().zze().zza("Data loss. Failed to serialize bundle. appId", zzeq.zza(zzg2.zzx()), e2);
            return false;
        }
    }

    @WorkerThread
    public final List<Pair<zzcd.zzg, Long>> zza(String str, int i, int i2) {
        zzc();
        zzaj();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = mo31260c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", String.valueOf(i));
            if (!cursor.moveToFirst()) {
                List<Pair<zzcd.zzg, Long>> emptyList = Collections.emptyList();
                cursor.close();
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = cursor.getLong(0);
                try {
                    byte[] zzb2 = mo31422f_().zzb(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && zzb2.length + i3 > i2) {
                        break;
                    }
                    try {
                        zzcd.zzg.zza zza = (zzcd.zzg.zza) zzkr.zza(zzcd.zzg.zzbh(), zzb2);
                        if (!cursor.isNull(2)) {
                            zza.zzi(cursor.getInt(2));
                        }
                        i3 += zzb2.length;
                        arrayList.add(Pair.create((zzcd.zzg) ((zzhy) zza.zzy()), Long.valueOf(j)));
                    } catch (IOException e) {
                        zzq().zze().zza("Failed to merge queued bundle. appId", zzeq.zza(str), e);
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzq().zze().zza("Failed to unzip queued bundle. appId", zzeq.zza(str), e2);
                }
            } while (i3 <= i2);
            cursor.close();
            return arrayList;
        } catch (SQLiteException e3) {
            zzq().zze().zza("Error querying bundles. appId", zzeq.zza(str), e3);
            List<Pair<zzcd.zzg, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    @VisibleForTesting
    public final void zza(List<Long> list) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzal()) {
            String join = TextUtils.join(",", list);
            String outline12 = GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(join, 2), "(", join, ")");
            if (zzb(GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(outline12, 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", outline12, " AND retry_count =  2147483647 LIMIT 1"), (String[]) null) > 0) {
                zzq().zzh().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase c_ = mo31260c_();
                StringBuilder sb = new StringBuilder(String.valueOf(outline12).length() + 127);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(outline12);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                c_.execSQL(sb.toString());
            } catch (SQLiteException e) {
                zzq().zze().zza("Error incrementing retry count. error", e);
            }
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbv.zzb zzb2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (TextUtils.isEmpty(zzb2.zzc())) {
            zzes zzh2 = zzq().zzh();
            Object zza = zzeq.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zza()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzh2.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbk = zzb2.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zza() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put(BoltsMeasurementEventListener.MEASUREMENT_EVENT_NAME_KEY, zzb2.zzc());
        contentValues.put("session_scoped", zzb2.zzj() ? Boolean.valueOf(zzb2.zzk()) : null);
        contentValues.put("data", zzbk);
        try {
            if (mo31260c_().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert event filter (got -1). appId", zzeq.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing event filter. appId", zzeq.zza(str), e);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbv.zze zze2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (TextUtils.isEmpty(zze2.zzc())) {
            zzes zzh2 = zzq().zzh();
            Object zza = zzeq.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zza()) {
                num = Integer.valueOf(zze2.zzb());
            }
            zzh2.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbk = zze2.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zza() ? Integer.valueOf(zze2.zzb()) : null);
        contentValues.put("property_name", zze2.zzc());
        contentValues.put("session_scoped", zze2.zzg() ? Boolean.valueOf(zze2.zzh()) : null);
        contentValues.put("data", zzbk);
        try {
            if (mo31260c_().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert property filter (got -1). appId", zzeq.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing property filter. appId", zzeq.zza(str), e);
            return false;
        }
    }

    @WorkerThread
    public static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzq().zze().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzq().zze().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzq().zze().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final long zza(zzcd.zzg zzg2) throws IOException {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        byte[] zzbk = zzg2.zzbk();
        long zza = mo31422f_().zza(zzbk);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put(LogEntry.LOG_METADATA, zzbk);
        try {
            mo31260c_().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing raw event metadata. appId", zzeq.zza(zzg2.zzx()), e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzc()
            r4.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.mo31260c_()     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003a }
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzeq r6 = r4.zzq()     // Catch:{ SQLiteException -> 0x003a }
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzw()     // Catch:{ SQLiteException -> 0x003a }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch:{ SQLiteException -> 0x003a }
            r5.close()
            return r0
        L_0x0032:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003a }
            r5.close()
            return r6
        L_0x003a:
            r6 = move-exception
            goto L_0x0040
        L_0x003c:
            r6 = move-exception
            goto L_0x0055
        L_0x003e:
            r6 = move-exception
            r5 = r0
        L_0x0040:
            com.google.android.gms.measurement.internal.zzeq r1 = r4.zzq()     // Catch:{ all -> 0x0053 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x0052
            r5.close()
        L_0x0052:
            return r0
        L_0x0053:
            r6 = move-exception
            r0 = r5
        L_0x0055:
            if (r0 == 0) goto L_0x005a
            r0.close()
        L_0x005a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzcd.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzc()
            r7.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.mo31260c_()     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0071 }
            if (r2 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzeq r8 = r7.zzq()     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzw()     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x0071 }
            r1.close()
            return r0
        L_0x0035:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0071 }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r4 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzji r2 = com.google.android.gms.measurement.internal.zzkr.zza(r4, (byte[]) r2)     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzy()     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ IOException -> 0x005b }
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0071 }
            r1.close()
            return r8
        L_0x005b:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzeq r3 = r7.zzq()     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x0071 }
            r3.zza(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x0071 }
            r1.close()
            return r0
        L_0x0071:
            r8 = move-exception
            goto L_0x0077
        L_0x0073:
            r8 = move-exception
            goto L_0x008c
        L_0x0075:
            r8 = move-exception
            r1 = r0
        L_0x0077:
            com.google.android.gms.measurement.internal.zzeq r9 = r7.zzq()     // Catch:{ all -> 0x008a }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zze()     // Catch:{ all -> 0x008a }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0089
            r1.close()
        L_0x0089:
            return r0
        L_0x008a:
            r8 = move-exception
            r0 = r1
        L_0x008c:
            if (r0 == 0) goto L_0x0091
            r0.close()
        L_0x0091:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzcd.zzc zzc2) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzc2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbk = zzc2.zzbk();
        zzq().zzw().zza("Saving complex main event, appId, data size", zzn().zza(str), Integer.valueOf(zzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(LogEntry.LOG_ITEM_EVENT_ID, l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbk);
        try {
            if (mo31260c_().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert complex main event (got -1). appId", zzeq.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing complex main event. appId", zzeq.zza(str), e);
            return false;
        }
    }

    public final boolean zza(String str, Bundle bundle) {
        zzc();
        zzaj();
        byte[] zzbk = mo31422f_().zza(new zzan(this.zzy, "", str, "dep", 0, 0, bundle)).zzbk();
        zzq().zzw().zza("Saving default event parameters, appId, data size", zzn().zza(str), Integer.valueOf(zzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbk);
        try {
            if (mo31260c_().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert default event parameters (got -1). appId", zzeq.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing default event parameters. appId", zzeq.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzan zzan, long j, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzan);
        Preconditions.checkNotEmpty(zzan.zza);
        byte[] zzbk = mo31422f_().zza(zzan).zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzan.zza);
        contentValues.put("name", zzan.zzb);
        contentValues.put("timestamp", Long.valueOf(zzan.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbk);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (mo31260c_().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert raw event (got -1). appId", zzeq.zza(zzan.zza));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing raw event. appId", zzeq.zza(zzan.zza), e);
            return false;
        }
    }

    @WorkerThread
    public final void zza(String str, List<zzbv.zza> list) {
        boolean z;
        boolean z2;
        String str2 = str;
        List<zzbv.zza> list2 = list;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbv.zza.C3366zza zza = (zzbv.zza.C3366zza) list2.get(i).zzbo();
            if (zza.zzb() != 0) {
                for (int i2 = 0; i2 < zza.zzb(); i2++) {
                    zzbv.zzb.zza zza2 = (zzbv.zzb.zza) zza.zzb(i2).zzbo();
                    zzbv.zzb.zza zza3 = (zzbv.zzb.zza) ((zzhy.zzb) zza2.clone());
                    String zzb2 = zzgv.zzb(zza2.zza());
                    if (zzb2 != null) {
                        zza3.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zza2.zzb(); i3++) {
                        zzbv.zzc zza4 = zza2.zza(i3);
                        String zza5 = zzgu.zza(zza4.zzh());
                        if (zza5 != null) {
                            zza3.zza(i3, (zzbv.zzc) ((zzhy) ((zzbv.zzc.zza) zza4.zzbo()).zza(zza5).zzy()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza = zza.zza(i2, zza3);
                        list2.set(i, (zzbv.zza) ((zzhy) zza.zzy()));
                    }
                }
            }
            if (zza.zza() != 0) {
                for (int i4 = 0; i4 < zza.zza(); i4++) {
                    zzbv.zze zza6 = zza.zza(i4);
                    String zza7 = zzgx.zza(zza6.zzc());
                    if (zza7 != null) {
                        zza = zza.zza(i4, ((zzbv.zze.zza) zza6.zzbo()).zza(zza7));
                        list2.set(i, (zzbv.zza) ((zzhy) zza.zzy()));
                    }
                }
            }
        }
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase c_ = mo31260c_();
        c_.beginTransaction();
        try {
            zzaj();
            zzc();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase c_2 = mo31260c_();
            c_2.delete("property_filters", "app_id=?", new String[]{str2});
            c_2.delete("event_filters", "app_id=?", new String[]{str2});
            for (zzbv.zza next : list) {
                zzaj();
                zzc();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(next);
                if (!next.zza()) {
                    zzq().zzh().zza("Audience with no ID. appId", zzeq.zza(str));
                } else {
                    int zzb3 = next.zzb();
                    Iterator<zzbv.zzb> it = next.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                zzq().zzh().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzeq.zza(str), Integer.valueOf(zzb3));
                                break;
                            }
                        } else {
                            Iterator<zzbv.zze> it2 = next.zzc().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        zzq().zzh().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzeq.zza(str), Integer.valueOf(zzb3));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbv.zzb> it3 = next.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str2, zzb3, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbv.zze> it4 = next.zzc().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str2, zzb3, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzaj();
                                        zzc();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase c_3 = mo31260c_();
                                        c_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zzb3)});
                                        c_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zzb3)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbv.zza next2 : list) {
                arrayList.add(next2.zza() ? Integer.valueOf(next2.zzb()) : null);
            }
            zzb(str2, (List<Integer>) arrayList);
            c_.setTransactionSuccessful();
        } finally {
            c_.endTransaction();
        }
    }
}
