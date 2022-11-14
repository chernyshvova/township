package com.microsoft.appcenter.utils.context;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserIdContext {
    public static UserIdContext sInstance;
    public final Set<Listener> mListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    public String mUserId;

    public interface Listener {
        void onNewUserId(String str);
    }

    public static boolean checkUserIdValidForOneCollector(String str) {
        if (str.isEmpty()) {
            AppCenterLog.error("AppCenter", "userId must not be empty.");
            return false;
        }
        int indexOf = str.indexOf(CertificateUtil.DELIMITER);
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            if (!substring.equals("c")) {
                AppCenterLog.error("AppCenter", String.format("userId prefix must be '%s%s', '%s%s' is not supported.", new Object[]{"c", CertificateUtil.DELIMITER, substring, CertificateUtil.DELIMITER}));
                return false;
            } else if (indexOf == str.length() - 1) {
                AppCenterLog.error("AppCenter", "userId must not be empty.");
                return false;
            }
        }
        return true;
    }

    public static synchronized UserIdContext getInstance() {
        UserIdContext userIdContext;
        synchronized (UserIdContext.class) {
            if (sInstance == null) {
                sInstance = new UserIdContext();
            }
            userIdContext = sInstance;
        }
        return userIdContext;
    }

    public synchronized String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        boolean z;
        synchronized (this) {
            if (TextUtils.equals(this.mUserId, str)) {
                z = false;
            } else {
                this.mUserId = str;
                z = true;
            }
        }
        if (z) {
            for (Listener onNewUserId : this.mListeners) {
                onNewUserId.onNewUserId(this.mUserId);
            }
        }
    }
}
