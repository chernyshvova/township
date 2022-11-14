package com.facebook.bolts;

import com.vungle.warren.p037ui.contract.AdContract;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: BoltsExecutors.kt */
public final class BoltsExecutors {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final BoltsExecutors INSTANCE = new BoltsExecutors();
    public final ExecutorService background;
    public final Executor immediate;
    public final ScheduledExecutorService scheduled;

    /* compiled from: BoltsExecutors.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean isAndroidRuntime() {
            String property = System.getProperty("java.runtime.name");
            if (property == null) {
                return false;
            }
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = property.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return CharsKt__CharKt.contains$default(lowerCase, "android", false, 2);
        }

        public final ExecutorService background() {
            return BoltsExecutors.INSTANCE.background;
        }

        public final Executor immediate$facebook_bolts_release() {
            return BoltsExecutors.INSTANCE.immediate;
        }

        public final ScheduledExecutorService scheduled$facebook_bolts_release() {
            return BoltsExecutors.INSTANCE.scheduled;
        }
    }

    /* compiled from: BoltsExecutors.kt */
    public static final class ImmediateExecutor implements Executor {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int MAX_DEPTH = 15;
        public final ThreadLocal<Integer> executionDepth = new ThreadLocal<>();

        /* compiled from: BoltsExecutors.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private final int decrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.executionDepth.remove();
            } else {
                this.executionDepth.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        private final int incrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.executionDepth.set(Integer.valueOf(intValue));
            return intValue;
        }

        public void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, AdContract.AdvertisementBus.COMMAND);
            if (incrementDepth() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    decrementDepth();
                    throw th;
                }
            } else {
                BoltsExecutors.Companion.background().execute(runnable);
            }
            decrementDepth();
        }
    }

    public BoltsExecutors() {
        ExecutorService executorService;
        if (!Companion.isAndroidRuntime()) {
            executorService = Executors.newCachedThreadPool();
            Intrinsics.checkNotNullExpressionValue(executorService, "newCachedThreadPool()");
        } else {
            executorService = AndroidExecutors.Companion.newCachedThreadPool();
        }
        this.background = executorService;
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        this.scheduled = newSingleThreadScheduledExecutor;
        this.immediate = new ImmediateExecutor();
    }

    public static final ExecutorService background() {
        return Companion.background();
    }

    public static final Executor immediate$facebook_bolts_release() {
        return Companion.immediate$facebook_bolts_release();
    }

    public static final ScheduledExecutorService scheduled$facebook_bolts_release() {
        return Companion.scheduled$facebook_bolts_release();
    }
}
