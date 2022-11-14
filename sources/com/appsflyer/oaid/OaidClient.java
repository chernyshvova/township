package com.appsflyer.oaid;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.swrve.sdk.SwrveAppStore;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OaidClient {
    public final Context context;
    public final Logger logger;
    public final long timeout;
    public final TimeUnit unit;

    public OaidClient(Context context2, long j, TimeUnit timeUnit) {
        Logger logger2 = Logger.getLogger("AppsFlyerOaid6.2.4");
        this.logger = logger2;
        this.context = context2;
        this.timeout = j;
        this.unit = timeUnit;
        logger2.setLevel(Level.OFF);
    }

    @Nullable
    private Info fetchHuawei() {
        try {
            FutureTask futureTask = new FutureTask(new Callable<Info>() {
                public Info call() {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(OaidClient.this.context);
                    if (advertisingIdInfo == null) {
                        return null;
                    }
                    return new Info(advertisingIdInfo.getId(), Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled()));
                }
            });
            new Thread(futureTask).start();
            return (Info) futureTask.get(this.timeout, this.unit);
        } catch (Throwable th) {
            this.logger.info(th.getMessage());
            return null;
        }
    }

    public static boolean isHuawei() {
        try {
            if (Build.BRAND.equalsIgnoreCase(SwrveAppStore.Huawei) || ((Integer) Class.forName("com.huawei.android.os.BuildEx$VERSION").getDeclaredField("EMUI_SDK_INT").get((Object) null)).intValue() > 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }

    public static boolean isMsaAvailableAtRuntime() {
        Class<IIdentifierListener> cls = IIdentifierListener.class;
        return true;
    }

    @Nullable
    public Info fetch() {
        Info info;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (isHuawei()) {
                info = fetchHuawei();
            } else {
                info = isMsaAvailableAtRuntime() ? OaidMsaClient.fetchMsa(this.context, this.logger, this.timeout, this.unit) : null;
            }
            Logger logger2 = this.logger;
            logger2.info("Fetch " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return info;
        } catch (Throwable th) {
            this.logger.info(th.getMessage());
            return null;
        }
    }

    public void setLogging(boolean z) {
        this.logger.setLevel(z ? null : Level.OFF);
    }

    public static class Info {

        /* renamed from: id */
        public final String f2746id;
        public final Boolean lat;

        @VisibleForTesting
        public Info(String str, Boolean bool) {
            this.f2746id = str;
            this.lat = bool;
        }

        public String getId() {
            return this.f2746id;
        }

        @Nullable
        public Boolean getLat() {
            return this.lat;
        }

        public Info(String str) {
            this(str, (Boolean) null);
        }
    }

    public OaidClient(Context context2) {
        this(context2, 1, TimeUnit.SECONDS);
    }
}
