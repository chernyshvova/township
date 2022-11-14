package com.swrve.sdk;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

public class SwrveLogger {
    public static final String LOG_TAG = "SwrveSDK";
    public static boolean enabled = true;
    public static boolean isPlanted = false;
    public static int logLevel = -1;
    public static Timber.Tree swrveLoggerTree = null;
    public static boolean useCustomLogger = false;

    public static class SwrveLoggerTree extends Timber.DebugTree {
        public boolean isLoggable(String str, int i) {
            return str.equals(SwrveLogger.LOG_TAG) && i >= SwrveLogger.logLevel;
        }
    }

    public static void checkSwrveLogger() {
        if (logLevel == -1) {
            logLevel = getLogLevelFromSystemProps();
        }
        if (!useCustomLogger && !isPlanted) {
            plantSwrveLogger();
        }
    }

    /* renamed from: d */
    public static void m2752d(String str, Object... objArr) {
        debug(LOG_TAG, str, objArr);
    }

    public static void debug(String str, String str2, Object... objArr) {
        if (enabled) {
            checkSwrveLogger();
            Timber.tag(str);
            Timber.TREE_OF_SOULS.mo23036d(str2, objArr);
        }
    }

    /* renamed from: e */
    public static void m2754e(String str, Object... objArr) {
        error(LOG_TAG, str, objArr);
    }

    public static void error(String str, String str2, Object... objArr) {
        if (enabled) {
            checkSwrveLogger();
            Timber.tag(str);
            Timber.TREE_OF_SOULS.mo23039e(str2, objArr);
        }
    }

    public static int getLogLevel() {
        return logLevel;
    }

    public static int getLogLevelFromSystemProps() {
        if (Log.isLoggable(LOG_TAG, 2)) {
            return 2;
        }
        if (Log.isLoggable(LOG_TAG, 3)) {
            return 3;
        }
        if (!Log.isLoggable(LOG_TAG, 4)) {
            if (Log.isLoggable(LOG_TAG, 5)) {
                return 5;
            }
            if (Log.isLoggable(LOG_TAG, 6)) {
                return 6;
            }
            if (Log.isLoggable(LOG_TAG, 7)) {
                return 7;
            }
        }
        return 4;
    }

    /* renamed from: i */
    public static void m2755i(String str, Object... objArr) {
        info(LOG_TAG, str, objArr);
    }

    public static void info(String str, String str2, Object... objArr) {
        if (enabled) {
            checkSwrveLogger();
            Timber.tag(str);
            Timber.TREE_OF_SOULS.mo23042i(str2, objArr);
        }
    }

    public static boolean isSwrveLoggerTreeAlreadyPlanted() {
        List unmodifiableList;
        synchronized (Timber.FOREST) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(Timber.FOREST));
        }
        Iterator it = unmodifiableList.iterator();
        boolean z = false;
        while (!z && it.hasNext()) {
            z = ((Timber.Tree) it.next()).getClass().equals(SwrveLoggerTree.class);
        }
        return z;
    }

    public static synchronized void plantSwrveLogger() {
        synchronized (SwrveLogger.class) {
            if (!isSwrveLoggerTreeAlreadyPlanted()) {
                SwrveLoggerTree swrveLoggerTree2 = new SwrveLoggerTree();
                swrveLoggerTree = swrveLoggerTree2;
                Timber.plant(swrveLoggerTree2);
            }
            isPlanted = true;
        }
    }

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void setLoggingEnabled(boolean z) {
        Timber.Tree tree;
        enabled = z;
        if (!z && (tree = swrveLoggerTree) != null) {
            synchronized (Timber.FOREST) {
                if (Timber.FOREST.remove(tree)) {
                    Timber.forestAsArray = (Timber.Tree[]) Timber.FOREST.toArray(new Timber.Tree[Timber.FOREST.size()]);
                } else {
                    throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + tree);
                }
            }
        }
    }

    public static void useCustomLogger(boolean z) {
        useCustomLogger = z;
    }

    /* renamed from: v */
    public static void m2756v(String str, Object... objArr) {
        if (enabled) {
            verbose(LOG_TAG, str, objArr);
        }
    }

    public static void verbose(String str, String str2, Object... objArr) {
        if (enabled) {
            checkSwrveLogger();
            Timber.tag(str);
            Timber.TREE_OF_SOULS.mo23049v(str2, objArr);
        }
    }

    /* renamed from: w */
    public static void m2758w(String str, Object... objArr) {
        warn(LOG_TAG, str, objArr);
    }

    public static void warn(String str, String str2, Object... objArr) {
        if (enabled) {
            checkSwrveLogger();
            Timber.tag(str);
            Timber.TREE_OF_SOULS.mo23052w(str2, objArr);
        }
    }

    public static void wtf(String str, Object... objArr) {
        wtf(LOG_TAG, str, objArr);
    }

    /* renamed from: e */
    public static void m2753e(String str, Throwable th, Object... objArr) {
        error(LOG_TAG, str, th, objArr);
    }

    /* renamed from: w */
    public static void m2757w(String str, String str2, Throwable th, Object... objArr) {
        warn(str, str2, th, objArr);
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (enabled) {
            checkSwrveLogger();
            Timber.tag(str);
            Timber.TREE_OF_SOULS.wtf(str2, objArr);
        }
    }

    public static void error(String str, String str2, Throwable th, Object... objArr) {
        if (enabled) {
            checkSwrveLogger();
            Timber.tag(str);
            Timber.TREE_OF_SOULS.mo23041e(th, str2, objArr);
        }
    }

    public static void warn(String str, String str2, Throwable th, Object... objArr) {
        if (enabled) {
            checkSwrveLogger();
            Timber.tag(str);
            Timber.TREE_OF_SOULS.mo23054w(th, str2, objArr);
        }
    }

    public static void wtf(String str, String str2, Throwable th, Object... objArr) {
        if (enabled) {
            checkSwrveLogger();
            Timber.tag(str);
            Timber.TREE_OF_SOULS.wtf(th, str2, objArr);
        }
    }
}
