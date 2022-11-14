package com.microsoft.appcenter.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.CancellationException;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpResponse;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.AppCenterIngestion;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.persistence.DatabasePersistence;
import com.microsoft.appcenter.persistence.Persistence;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.storage.DatabaseManager;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class DefaultChannel implements Channel {
    public final Handler mAppCenterHandler;
    public String mAppSecret;
    public final Context mContext;
    public int mCurrentState;
    public Device mDevice;
    public boolean mDiscardLogs;
    public boolean mEnabled;
    public final Map<String, GroupState> mGroupStates = new HashMap();
    public final Ingestion mIngestion;
    public final Set<Ingestion> mIngestions;
    public final UUID mInstallId = zzam.getInstallId();
    public final Collection<Channel.Listener> mListeners = new LinkedHashSet();
    public final Persistence mPersistence;

    @VisibleForTesting
    public class GroupState {
        public final long mBatchTimeInterval;
        public final Ingestion mIngestion;
        public final Channel.GroupListener mListener;
        public final int mMaxLogsPerBatch;
        public final int mMaxParallelBatches;
        public final String mName;
        public boolean mPaused;
        public final Collection<String> mPausedTargetKeys = new HashSet();
        public int mPendingLogCount;
        public final Runnable mRunnable = new Runnable() {
            public void run() {
                GroupState groupState = GroupState.this;
                groupState.mScheduled = false;
                DefaultChannel.this.triggerIngestion(groupState);
            }
        };
        public boolean mScheduled;
        public final Map<String, List<Log>> mSendingBatches = new HashMap();

        public GroupState(String str, int i, long j, int i2, Ingestion ingestion, Channel.GroupListener groupListener) {
            this.mName = str;
            this.mMaxLogsPerBatch = i;
            this.mBatchTimeInterval = j;
            this.mMaxParallelBatches = i2;
            this.mIngestion = ingestion;
            this.mListener = groupListener;
        }
    }

    public DefaultChannel(@NonNull Context context, String str, @NonNull DefaultLogSerializer defaultLogSerializer, @NonNull HttpClient httpClient, @NonNull Handler handler) {
        DatabasePersistence databasePersistence = new DatabasePersistence(context);
        databasePersistence.mLogSerializer = defaultLogSerializer;
        AppCenterIngestion appCenterIngestion = new AppCenterIngestion(httpClient, defaultLogSerializer);
        this.mContext = context;
        this.mAppSecret = str;
        this.mPersistence = databasePersistence;
        this.mIngestion = appCenterIngestion;
        HashSet hashSet = new HashSet();
        this.mIngestions = hashSet;
        hashSet.add(this.mIngestion);
        this.mAppCenterHandler = handler;
        this.mEnabled = true;
    }

    public void addGroup(String str, int i, long j, int i2, Ingestion ingestion, Channel.GroupListener groupListener) {
        Cursor cursor;
        String str2 = str;
        AppCenterLog.debug("AppCenter", "addGroup(" + str2 + ")");
        Ingestion ingestion2 = ingestion == null ? this.mIngestion : ingestion;
        this.mIngestions.add(ingestion2);
        GroupState groupState = new GroupState(str, i, j, i2, ingestion2, groupListener);
        this.mGroupStates.put(str2, groupState);
        DatabasePersistence databasePersistence = (DatabasePersistence) this.mPersistence;
        if (databasePersistence != null) {
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.appendWhere("persistence_group = ?");
            int i3 = 0;
            try {
                cursor = databasePersistence.mDatabaseManager.getCursor(sQLiteQueryBuilder, new String[]{"COUNT(*)"}, new String[]{str2}, (String) null);
                cursor.moveToNext();
                i3 = cursor.getInt(0);
                cursor.close();
            } catch (RuntimeException e) {
                AppCenterLog.error("AppCenter", "Failed to get logs count: ", e);
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
            groupState.mPendingLogCount = i3;
            if (!(this.mAppSecret == null && this.mIngestion == ingestion2)) {
                checkPendingLogs(groupState);
            }
            for (Channel.Listener onGroupAdded : this.mListeners) {
                onGroupAdded.onGroupAdded(str2, groupListener, j);
            }
            return;
        }
        throw null;
    }

    @VisibleForTesting
    public void cancelTimer(GroupState groupState) {
        if (groupState.mScheduled) {
            groupState.mScheduled = false;
            this.mAppCenterHandler.removeCallbacks(groupState.mRunnable);
            SharedPreferencesManager.remove("startTimerPrefix." + groupState.mName);
        }
    }

    @VisibleForTesting
    public void checkPendingLogs(@NonNull GroupState groupState) {
        AppCenterLog.debug("AppCenter", String.format("checkPendingLogs(%s) pendingLogCount=%s batchTimeInterval=%s", new Object[]{groupState.mName, Integer.valueOf(groupState.mPendingLogCount), Long.valueOf(groupState.mBatchTimeInterval)}));
        long j = groupState.mBatchTimeInterval;
        Long l = null;
        if (j > 3000) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("startTimerPrefix.");
            outline24.append(groupState.mName);
            long j2 = SharedPreferencesManager.sSharedPreferences.getLong(outline24.toString(), 0);
            if (groupState.mPendingLogCount > 0) {
                if (j2 == 0 || j2 > currentTimeMillis) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("startTimerPrefix.");
                    outline242.append(groupState.mName);
                    String sb = outline242.toString();
                    SharedPreferences.Editor edit = SharedPreferencesManager.sSharedPreferences.edit();
                    edit.putLong(sb, currentTimeMillis);
                    edit.apply();
                    AppCenterLog.debug("AppCenter", "The timer value for " + groupState.mName + " has been saved.");
                    l = Long.valueOf(groupState.mBatchTimeInterval);
                } else {
                    l = Long.valueOf(Math.max(groupState.mBatchTimeInterval - (currentTimeMillis - j2), 0));
                }
            } else if (j2 + groupState.mBatchTimeInterval < currentTimeMillis) {
                StringBuilder outline243 = GeneratedOutlineSupport.outline24("startTimerPrefix.");
                outline243.append(groupState.mName);
                SharedPreferencesManager.remove(outline243.toString());
                AppCenterLog.debug("AppCenter", "The timer for " + groupState.mName + " channel finished.");
            }
        } else {
            int i = groupState.mPendingLogCount;
            if (i >= groupState.mMaxLogsPerBatch) {
                l = 0L;
            } else if (i > 0) {
                l = Long.valueOf(j);
            }
        }
        if (l != null && !groupState.mPaused) {
            if (l.longValue() == 0) {
                triggerIngestion(groupState);
            } else if (!groupState.mScheduled) {
                groupState.mScheduled = true;
                this.mAppCenterHandler.postDelayed(groupState.mRunnable, l.longValue());
            }
        }
    }

    public void clear(String str) {
        if (this.mGroupStates.containsKey(str)) {
            AppCenterLog.debug("AppCenter", "clear(" + str + ")");
            this.mPersistence.deleteLogs(str);
            for (Channel.Listener onClear : this.mListeners) {
                onClear.onClear(str);
            }
        }
    }

    public final void deleteLogsOnSuspended(GroupState groupState) {
        ArrayList arrayList = new ArrayList();
        this.mPersistence.getLogs(groupState.mName, Collections.emptyList(), 100, arrayList);
        if (arrayList.size() > 0 && groupState.mListener != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Log log = (Log) it.next();
                groupState.mListener.onBeforeSending(log);
                groupState.mListener.onFailure(log, new CancellationException());
            }
        }
        if (arrayList.size() < 100 || groupState.mListener == null) {
            this.mPersistence.deleteLogs(groupState.mName);
        } else {
            deleteLogsOnSuspended(groupState);
        }
    }

    public void enqueue(@NonNull Log log, @NonNull String str, int i) {
        boolean z;
        GroupState groupState = this.mGroupStates.get(str);
        if (groupState == null) {
            AppCenterLog.error("AppCenter", "Invalid group name:" + str);
        } else if (this.mDiscardLogs) {
            AppCenterLog.warn("AppCenter", "Channel is disabled, the log is discarded.");
            Channel.GroupListener groupListener = groupState.mListener;
            if (groupListener != null) {
                groupListener.onBeforeSending(log);
                groupState.mListener.onFailure(log, new CancellationException());
            }
        } else {
            for (Channel.Listener onPreparingLog : this.mListeners) {
                onPreparingLog.onPreparingLog(log, str);
            }
            if (log.getDevice() == null) {
                if (this.mDevice == null) {
                    try {
                        this.mDevice = DeviceInfoHelper.getDeviceInfo(this.mContext);
                    } catch (DeviceInfoHelper.DeviceInfoException e) {
                        AppCenterLog.error("AppCenter", "Device log cannot be generated", e);
                        return;
                    }
                }
                log.setDevice(this.mDevice);
            }
            if (log.getTimestamp() == null) {
                log.setTimestamp(new Date());
            }
            for (Channel.Listener onPreparedLog : this.mListeners) {
                onPreparedLog.onPreparedLog(log, str, i);
            }
            Iterator<Channel.Listener> it = this.mListeners.iterator();
            loop2:
            while (true) {
                z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break loop2;
                    }
                    Channel.Listener next = it.next();
                    if (z || next.shouldFilter(log)) {
                        z = true;
                    }
                }
            }
            if (z) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Log of type '");
                outline24.append(log.getType());
                outline24.append("' was filtered out by listener(s)");
                AppCenterLog.debug("AppCenter", outline24.toString());
            } else if (this.mAppSecret == null && groupState.mIngestion == this.mIngestion) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Log of type '");
                outline242.append(log.getType());
                outline242.append("' was not filtered out by listener(s) but no app secret was provided. Not persisting/sending the log.");
                AppCenterLog.debug("AppCenter", outline242.toString());
            } else {
                try {
                    this.mPersistence.putLog(log, str, i);
                    Iterator<String> it2 = log.getTransmissionTargetTokens().iterator();
                    String targetKey = it2.hasNext() ? PartAUtils.getTargetKey(it2.next()) : null;
                    if (groupState.mPausedTargetKeys.contains(targetKey)) {
                        AppCenterLog.debug("AppCenter", "Transmission target ikey=" + targetKey + " is paused.");
                        return;
                    }
                    groupState.mPendingLogCount++;
                    StringBuilder outline243 = GeneratedOutlineSupport.outline24("enqueue(");
                    outline243.append(groupState.mName);
                    outline243.append(") pendingLogCount=");
                    outline243.append(groupState.mPendingLogCount);
                    AppCenterLog.debug("AppCenter", outline243.toString());
                    if (this.mEnabled) {
                        checkPendingLogs(groupState);
                    } else {
                        AppCenterLog.debug("AppCenter", "Channel is temporarily disabled, log was saved to disk.");
                    }
                } catch (Persistence.PersistenceException e2) {
                    AppCenterLog.error("AppCenter", "Error persisting log", e2);
                    Channel.GroupListener groupListener2 = groupState.mListener;
                    if (groupListener2 != null) {
                        groupListener2.onBeforeSending(log);
                        groupState.mListener.onFailure(log, e2);
                    }
                }
            }
        }
    }

    public void removeGroup(String str) {
        AppCenterLog.debug("AppCenter", "removeGroup(" + str + ")");
        GroupState remove = this.mGroupStates.remove(str);
        if (remove != null) {
            cancelTimer(remove);
        }
        for (Channel.Listener onGroupRemoved : this.mListeners) {
            onGroupRemoved.onGroupRemoved(str);
        }
    }

    @WorkerThread
    public boolean setMaxStorageSize(long j) {
        DatabaseManager databaseManager = ((DatabasePersistence) this.mPersistence).mDatabaseManager;
        if (databaseManager != null) {
            try {
                SQLiteDatabase database = databaseManager.getDatabase();
                long maximumSize = database.setMaximumSize(j);
                long pageSize = database.getPageSize();
                long j2 = j / pageSize;
                if (j % pageSize != 0) {
                    j2++;
                }
                if (maximumSize != j2 * pageSize) {
                    AppCenterLog.error("AppCenter", "Could not change maximum database size to " + j + " bytes, current maximum size is " + maximumSize + " bytes.");
                    return false;
                }
                if (j == maximumSize) {
                    AppCenterLog.info("AppCenter", "Changed maximum database size to " + maximumSize + " bytes.");
                } else {
                    AppCenterLog.info("AppCenter", "Changed maximum database size to " + maximumSize + " bytes (next multiple of page size).");
                }
                return true;
            } catch (RuntimeException e) {
                AppCenterLog.error("AppCenter", "Could not change maximum database size.", e);
                return false;
            }
        } else {
            throw null;
        }
    }

    public final void suspend(boolean z, Exception exc) {
        Channel.GroupListener groupListener;
        this.mDiscardLogs = z;
        this.mCurrentState++;
        for (GroupState next : this.mGroupStates.values()) {
            cancelTimer(next);
            Iterator<Map.Entry<String, List<Log>>> it = next.mSendingBatches.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next2 = it.next();
                it.remove();
                if (z && (groupListener = next.mListener) != null) {
                    for (Log onFailure : (List) next2.getValue()) {
                        groupListener.onFailure(onFailure, exc);
                    }
                }
            }
        }
        for (Ingestion next3 : this.mIngestions) {
            try {
                next3.close();
            } catch (IOException e) {
                AppCenterLog.error("AppCenter", "Failed to close ingestion: " + next3, e);
            }
        }
        if (z) {
            for (GroupState deleteLogsOnSuspended : this.mGroupStates.values()) {
                deleteLogsOnSuspended(deleteLogsOnSuspended);
            }
            return;
        }
        DatabasePersistence databasePersistence = (DatabasePersistence) this.mPersistence;
        databasePersistence.mPendingDbIdentifiers.clear();
        databasePersistence.mPendingDbIdentifiersGroups.clear();
        AppCenterLog.debug("AppCenter", "Cleared pending log states");
    }

    public final void triggerIngestion(@NonNull final GroupState groupState) {
        if (this.mEnabled) {
            if (!this.mIngestion.isEnabled()) {
                AppCenterLog.debug("AppCenter", "SDK is in offline mode.");
                return;
            }
            int i = groupState.mPendingLogCount;
            int min = Math.min(i, groupState.mMaxLogsPerBatch);
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("triggerIngestion(");
            outline24.append(groupState.mName);
            outline24.append(") pendingLogCount=");
            outline24.append(i);
            AppCenterLog.debug("AppCenter", outline24.toString());
            cancelTimer(groupState);
            if (groupState.mSendingBatches.size() == groupState.mMaxParallelBatches) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Already sending ");
                outline242.append(groupState.mMaxParallelBatches);
                outline242.append(" batches of analytics data to the server.");
                AppCenterLog.debug("AppCenter", outline242.toString());
                return;
            }
            ArrayList arrayList = new ArrayList(min);
            final String logs = this.mPersistence.getLogs(groupState.mName, groupState.mPausedTargetKeys, min, arrayList);
            groupState.mPendingLogCount -= min;
            if (logs != null) {
                StringBuilder outline243 = GeneratedOutlineSupport.outline24("ingestLogs(");
                GeneratedOutlineSupport.outline34(outline243, groupState.mName, ",", logs, ") pendingLogCount=");
                outline243.append(groupState.mPendingLogCount);
                AppCenterLog.debug("AppCenter", outline243.toString());
                if (groupState.mListener != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        groupState.mListener.onBeforeSending((Log) it.next());
                    }
                }
                groupState.mSendingBatches.put(logs, arrayList);
                final int i2 = this.mCurrentState;
                LogContainer logContainer = new LogContainer();
                logContainer.logs = arrayList;
                groupState.mIngestion.sendAsync(this.mAppSecret, this.mInstallId, logContainer, new ServiceCallback() {
                    public void onCallFailed(final Exception exc) {
                        DefaultChannel.this.mAppCenterHandler.post(new Runnable() {
                            public void run() {
                                C29431 r0 = C29431.this;
                                DefaultChannel defaultChannel = DefaultChannel.this;
                                GroupState groupState = groupState;
                                String str = logs;
                                Exception exc = exc;
                                if (defaultChannel != null) {
                                    String str2 = groupState.mName;
                                    List<Log> remove = groupState.mSendingBatches.remove(str);
                                    if (remove != null) {
                                        AppCenterLog.error("AppCenter", "Sending logs groupName=" + str2 + " id=" + str + " failed", exc);
                                        boolean isRecoverableError = HttpUtils.isRecoverableError(exc);
                                        if (isRecoverableError) {
                                            groupState.mPendingLogCount = remove.size() + groupState.mPendingLogCount;
                                        } else {
                                            Channel.GroupListener groupListener = groupState.mListener;
                                            if (groupListener != null) {
                                                for (Log onFailure : remove) {
                                                    groupListener.onFailure(onFailure, exc);
                                                }
                                            }
                                        }
                                        defaultChannel.mEnabled = false;
                                        defaultChannel.suspend(!isRecoverableError, exc);
                                        return;
                                    }
                                    return;
                                }
                                throw null;
                            }
                        });
                    }

                    public void onCallSucceeded(HttpResponse httpResponse) {
                        DefaultChannel.this.mAppCenterHandler.post(new Runnable() {
                            public void run() {
                                C29431 r0 = C29431.this;
                                DefaultChannel defaultChannel = DefaultChannel.this;
                                GroupState groupState = groupState;
                                String str = logs;
                                if (defaultChannel != null) {
                                    List<Log> remove = groupState.mSendingBatches.remove(str);
                                    if (remove != null) {
                                        Persistence persistence = defaultChannel.mPersistence;
                                        String str2 = groupState.mName;
                                        DatabasePersistence databasePersistence = (DatabasePersistence) persistence;
                                        if (databasePersistence != null) {
                                            AppCenterLog.debug("AppCenter", "Deleting logs from the Persistence database for " + str2 + " with " + str);
                                            AppCenterLog.debug("AppCenter", "The IDs for deleting log(s) is/are:");
                                            Map<String, List<Long>> map = databasePersistence.mPendingDbIdentifiersGroups;
                                            List<Long> remove2 = map.remove(str2 + str);
                                            File largePayloadGroupDirectory = databasePersistence.getLargePayloadGroupDirectory(str2);
                                            if (remove2 != null) {
                                                for (Long l : remove2) {
                                                    AppCenterLog.debug("AppCenter", "\t" + l);
                                                    databasePersistence.deleteLog(largePayloadGroupDirectory, l.longValue());
                                                    databasePersistence.mPendingDbIdentifiers.remove(l);
                                                }
                                            }
                                            Channel.GroupListener groupListener = groupState.mListener;
                                            if (groupListener != null) {
                                                for (Log onSuccess : remove) {
                                                    groupListener.onSuccess(onSuccess);
                                                }
                                            }
                                            defaultChannel.checkPendingLogs(groupState);
                                            return;
                                        }
                                        throw null;
                                    }
                                    return;
                                }
                                throw null;
                            }
                        });
                    }
                });
                this.mAppCenterHandler.post(new Runnable() {
                    public void run() {
                        DefaultChannel defaultChannel = DefaultChannel.this;
                        GroupState groupState = groupState;
                        if (i2 == defaultChannel.mCurrentState && groupState == defaultChannel.mGroupStates.get(groupState.mName)) {
                            defaultChannel.checkPendingLogs(groupState);
                        }
                    }
                });
            }
        }
    }
}
