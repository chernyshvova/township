package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.appsflyer.internal.ah */
public final class C1400ah {
    public static C1406e AFInAppEventType = null;
    @VisibleForTesting
    public static long AFKeystoreWrapper = 500;

    /* renamed from: com.appsflyer.internal.ah$e */
    public interface C1406e {
        void AFInAppEventType(Activity activity);

        void valueOf(Context context);
    }

    public static void AFInAppEventType(Context context, final C1406e eVar) {
        AFInAppEventType = eVar;
        C14011 r0 = new Application.ActivityLifecycleCallbacks() {
            public Executor AFInAppEventType = Executors.newSingleThreadExecutor();
            public boolean valueOf = true;
            public boolean values;

            public final void onActivityCreated(@NonNull final Activity activity, Bundle bundle) {
                this.AFInAppEventType.execute(new Runnable() {
                    public final void run() {
                        C1474f.AFInAppEventParameterName();
                        Intent intent = activity.getIntent();
                        if (C1474f.AFKeystoreWrapper(intent) != null && intent != C1474f.AFInAppEventParameterName) {
                            C1474f.AFInAppEventParameterName = intent;
                        }
                    }
                });
            }

            public final void onActivityDestroyed(Activity activity) {
            }

            public final void onActivityPaused(@NonNull final Activity activity) {
                this.AFInAppEventType.execute(new Runnable() {
                    public final void run() {
                        C14011.this.valueOf = true;
                        final Context applicationContext = activity.getApplicationContext();
                        try {
                            new Timer().schedule(new TimerTask() {
                                public final void run() {
                                    C14011 r0 = C14011.this;
                                    if (r0.values && r0.valueOf) {
                                        r0.values = false;
                                        try {
                                            eVar.valueOf(applicationContext);
                                        } catch (Exception e) {
                                            AFLogger.values("Listener threw exception! ", e);
                                        }
                                    }
                                }
                            }, C1400ah.AFKeystoreWrapper);
                        } catch (Throwable th) {
                            AFLogger.values("Background task failed with a throwable: ", th);
                        }
                    }
                });
            }

            public final void onActivityResumed(final Activity activity) {
                this.AFInAppEventType.execute(new Runnable() {
                    public final void run() {
                        C14011 r0 = C14011.this;
                        if (!r0.values) {
                            try {
                                eVar.AFInAppEventType(activity);
                            } catch (Exception e) {
                                AFLogger.AFInAppEventParameterName("Listener thrown an exception: ", (Throwable) e);
                            }
                        }
                        C14011 r02 = C14011.this;
                        r02.valueOf = false;
                        r02.values = true;
                    }
                });
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }
        };
        if (context instanceof Activity) {
            r0.onActivityResumed((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(r0);
    }
}
