package com.microsoft.appcenter.utils.context;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

public class SessionContext {
    public static SessionContext sInstance;
    public final long mAppLaunchTimestamp = System.currentTimeMillis();
    public final NavigableMap<Long, SessionInfo> mSessions = new TreeMap();

    public static class SessionInfo {
        public final long mAppLaunchTimestamp;
        public final UUID mSessionId;
        public final long mTimestamp;

        public SessionInfo(long j, UUID uuid, long j2) {
            this.mTimestamp = j;
            this.mSessionId = uuid;
            this.mAppLaunchTimestamp = j2;
        }

        @NonNull
        public String toString() {
            String str = this.mTimestamp + "/";
            if (this.mSessionId != null) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24(str);
                outline24.append(this.mSessionId);
                str = outline24.toString();
            }
            StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, "/");
            outline26.append(this.mAppLaunchTimestamp);
            return outline26.toString();
        }
    }

    @WorkerThread
    public SessionContext() {
        Set<String> stringSet = SharedPreferencesManager.sSharedPreferences.getStringSet("sessions", (Set) null);
        if (stringSet != null) {
            for (String next : stringSet) {
                String[] split = next.split("/", -1);
                try {
                    long parseLong = Long.parseLong(split[0]);
                    String str = split[1];
                    this.mSessions.put(Long.valueOf(parseLong), new SessionInfo(parseLong, str.isEmpty() ? null : UUID.fromString(str), split.length > 2 ? Long.parseLong(split[2]) : parseLong));
                } catch (RuntimeException e) {
                    AppCenterLog.warn("AppCenter", "Ignore invalid session in store: " + next, e);
                }
            }
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loaded stored sessions: ");
        outline24.append(this.mSessions);
        AppCenterLog.debug("AppCenter", outline24.toString());
        addSession((UUID) null);
    }

    @WorkerThread
    public static synchronized SessionContext getInstance() {
        SessionContext sessionContext;
        synchronized (SessionContext.class) {
            if (sInstance == null) {
                sInstance = new SessionContext();
            }
            sessionContext = sInstance;
        }
        return sessionContext;
    }

    public synchronized void addSession(UUID uuid) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mSessions.put(Long.valueOf(currentTimeMillis), new SessionInfo(currentTimeMillis, uuid, this.mAppLaunchTimestamp));
        if (this.mSessions.size() > 10) {
            this.mSessions.pollFirstEntry();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (SessionInfo sessionInfo : this.mSessions.values()) {
            linkedHashSet.add(sessionInfo.toString());
        }
        SharedPreferences.Editor edit = SharedPreferencesManager.sSharedPreferences.edit();
        edit.putStringSet("sessions", linkedHashSet);
        edit.apply();
    }

    public synchronized SessionInfo getSessionAt(long j) {
        Map.Entry<Long, SessionInfo> floorEntry = this.mSessions.floorEntry(Long.valueOf(j));
        if (floorEntry == null) {
            return null;
        }
        return floorEntry.getValue();
    }
}
