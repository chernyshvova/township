package com.unity3d.services.core.log;

import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DeviceLog {
    public static boolean FORCE_DEBUG_LOG = true;
    public static final int LOGLEVEL_DEBUG = 8;
    public static final int LOGLEVEL_ERROR = 1;
    public static final int LOGLEVEL_INFO = 4;
    public static final int LOGLEVEL_WARNING = 2;
    public static boolean LOG_DEBUG = true;
    public static boolean LOG_ERROR = true;
    public static boolean LOG_INFO = true;
    public static boolean LOG_WARNING = true;
    public static final int MAX_DEBUG_MSG_LENGTH = 3072;
    public static final HashMap<UnityAdsLogLevel, DeviceLogLevel> _deviceLogLevel;

    /* renamed from: com.unity3d.services.core.log.DeviceLog$1 */
    public static /* synthetic */ class C18331 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$log$DeviceLog$UnityAdsLogLevel */
        public static final /* synthetic */ int[] f2844xf32d8d1;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel[] r0 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2844xf32d8d1 = r0
                r1 = 1
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel r2 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f2844xf32d8d1     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel r3 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f2844xf32d8d1     // Catch:{ NoSuchFieldError -> 0x001d }
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel r3 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2844xf32d8d1     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel r2 = com.unity3d.services.core.log.DeviceLog.UnityAdsLogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.log.DeviceLog.C18331.<clinit>():void");
        }
    }

    public enum UnityAdsLogLevel {
        INFO,
        DEBUG,
        WARNING,
        ERROR
    }

    static {
        HashMap<UnityAdsLogLevel, DeviceLogLevel> hashMap = new HashMap<>();
        _deviceLogLevel = hashMap;
        if (hashMap.size() == 0) {
            _deviceLogLevel.put(UnityAdsLogLevel.INFO, new DeviceLogLevel("i"));
            _deviceLogLevel.put(UnityAdsLogLevel.DEBUG, new DeviceLogLevel(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG));
            _deviceLogLevel.put(UnityAdsLogLevel.WARNING, new DeviceLogLevel("w"));
            _deviceLogLevel.put(UnityAdsLogLevel.ERROR, new DeviceLogLevel("e"));
        }
        if (new File("/data/local/tmp/UnityAdsForceDebugMode").exists()) {
        }
    }

    public static String checkMessage(String str) {
        return (str == null || str.length() == 0) ? "DO NOT USE EMPTY MESSAGES, use DeviceLog.entered() instead" : str;
    }

    public static DeviceLogEntry createLogEntry(UnityAdsLogLevel unityAdsLogLevel, String str) {
        Class<DeviceLog> cls = DeviceLog.class;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        DeviceLogLevel logLevel = getLogLevel(unityAdsLogLevel);
        if (logLevel == null) {
            return null;
        }
        int i = 0;
        boolean z = false;
        while (i < stackTrace.length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.getClassName().equals(cls.getName())) {
                z = true;
            }
            if (!stackTraceElement.getClassName().equals(cls.getName()) && z) {
                break;
            }
            i++;
        }
        StackTraceElement stackTraceElement2 = i < stackTrace.length ? stackTrace[i] : null;
        if (stackTraceElement2 != null) {
            return new DeviceLogEntry(logLevel, str, stackTraceElement2);
        }
        return null;
    }

    public static void debug(String str) {
        if (!LOG_DEBUG && !FORCE_DEBUG_LOG) {
            return;
        }
        if (str.length() > 3072) {
            debug(str.substring(0, MAX_DEBUG_MSG_LENGTH));
            if (str.length() < 30720) {
                debug(str.substring(MAX_DEBUG_MSG_LENGTH));
                return;
            }
            return;
        }
        write(UnityAdsLogLevel.DEBUG, checkMessage(str));
    }

    public static void entered() {
        debug("ENTERED METHOD");
    }

    public static void error(String str) {
        write(UnityAdsLogLevel.ERROR, checkMessage(str));
    }

    public static void exception(String str, Exception exc) {
        String str2 = "";
        if (str != null) {
            str2 = GeneratedOutlineSupport.outline16(str2, str);
        }
        if (exc != null) {
            StringBuilder outline26 = GeneratedOutlineSupport.outline26(str2, ": ");
            outline26.append(exc.getMessage());
            str2 = outline26.toString();
        }
        if (!(exc == null || exc.getCause() == null)) {
            StringBuilder outline262 = GeneratedOutlineSupport.outline26(str2, ": ");
            outline262.append(exc.getCause().getMessage());
            str2 = outline262.toString();
        }
        write(UnityAdsLogLevel.ERROR, str2);
    }

    public static DeviceLogLevel getLogLevel(UnityAdsLogLevel unityAdsLogLevel) {
        return _deviceLogLevel.get(unityAdsLogLevel);
    }

    public static void info(String str) {
        write(UnityAdsLogLevel.INFO, checkMessage(str));
    }

    public static void setLogLevel(int i) {
        if (i >= 8) {
            LOG_ERROR = true;
            LOG_WARNING = true;
            LOG_INFO = true;
            LOG_DEBUG = true;
        } else if (i >= 4) {
            LOG_ERROR = true;
            LOG_WARNING = true;
            LOG_INFO = true;
            LOG_DEBUG = false;
        } else if (i >= 2) {
            LOG_ERROR = true;
            LOG_WARNING = true;
            LOG_INFO = false;
            LOG_DEBUG = false;
        } else if (i >= 1) {
            LOG_ERROR = true;
            LOG_WARNING = false;
            LOG_INFO = false;
            LOG_DEBUG = false;
        } else {
            LOG_ERROR = false;
            LOG_WARNING = false;
            LOG_INFO = false;
            LOG_DEBUG = false;
        }
    }

    public static void warning(String str) {
        write(UnityAdsLogLevel.WARNING, checkMessage(str));
    }

    public static void write(UnityAdsLogLevel unityAdsLogLevel, String str) {
        boolean z;
        int ordinal = unityAdsLogLevel.ordinal();
        boolean z2 = true;
        if (ordinal == 0) {
            z = LOG_INFO;
        } else if (ordinal == 1) {
            z = LOG_DEBUG;
        } else if (ordinal == 2) {
            z = LOG_WARNING;
        } else if (ordinal != 3) {
            z = true;
        } else {
            z = LOG_ERROR;
        }
        if (!FORCE_DEBUG_LOG) {
            z2 = z;
        }
        if (z2) {
            writeToLog(createLogEntry(unityAdsLogLevel, str));
        }
    }

    public static void writeToLog(DeviceLogEntry deviceLogEntry) {
        Method method;
        Class<String> cls = String.class;
        if (deviceLogEntry != null && deviceLogEntry.getLogLevel() != null) {
            try {
                method = Log.class.getMethod(deviceLogEntry.getLogLevel().getReceivingMethodName(), new Class[]{cls, cls});
            } catch (Exception e) {
                Log.e(DeviceLogLevel.LOG_TAG, "Writing to log failed!", e);
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke((Object) null, new Object[]{deviceLogEntry.getLogLevel().getLogTag(), deviceLogEntry.getParsedMessage()});
                } catch (Exception e2) {
                    Log.e(DeviceLogLevel.LOG_TAG, "Writing to log failed!", e2);
                }
            }
        }
    }

    public static void error(String str, Object... objArr) {
        error(String.format(str, objArr));
    }

    public static void info(String str, Object... objArr) {
        info(String.format(str, objArr));
    }

    public static void warning(String str, Object... objArr) {
        warning(String.format(str, objArr));
    }

    public static void debug(String str, Object... objArr) {
        debug(String.format(str, objArr));
    }
}
