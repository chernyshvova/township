package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AtomicReference<Object> mInternalScopeRef = new AtomicReference<>();

    /* renamed from: androidx.lifecycle.Lifecycle$1 */
    public static /* synthetic */ class C03231 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|(2:15|16)|17|19|20|21|22|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|12|13|(2:15|16)|17|19|20|21|22|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0058 */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$lifecycle$Lifecycle$Event = r0
                r1 = 0
                r2 = 1
                androidx.lifecycle.Lifecycle$Event r3 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 4
                int[] r4 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0017 }
                androidx.lifecycle.Lifecycle$Event r5 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                r4 = 3
                int[] r5 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x001e }
                androidx.lifecycle.Lifecycle$Event r6 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x001e }
                r5[r2] = r4     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                int[] r5 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0024 }
                androidx.lifecycle.Lifecycle$Event r6 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0024 }
                r5[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r5 = 5
                int[] r6 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x002b }
                androidx.lifecycle.Lifecycle$Event r7 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x002b }
                r6[r0] = r5     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r6 = 6
                int[] r7 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0032 }
                androidx.lifecycle.Lifecycle$Event r8 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0032 }
                r7[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r7 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0039 }
                androidx.lifecycle.Lifecycle$Event r8 = androidx.lifecycle.Lifecycle.Event.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0039 }
                r8 = 7
                r7[r6] = r8     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                androidx.lifecycle.Lifecycle$State[] r6 = androidx.lifecycle.Lifecycle.State.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$androidx$lifecycle$Lifecycle$State = r6
                androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0046 }
                r6[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                int[] r6 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x004c }
                androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x004c }
                r6[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x0052 }
                androidx.lifecycle.Lifecycle$State r6 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.DESTROYED     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x005e }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x005e }
                r0[r2] = r5     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.Lifecycle.C03231.<clinit>():void");
        }
    }

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        @Nullable
        public static Event downFrom(@NonNull State state) {
            int ordinal = state.ordinal();
            if (ordinal == 2) {
                return ON_DESTROY;
            }
            if (ordinal == 3) {
                return ON_STOP;
            }
            if (ordinal != 4) {
                return null;
            }
            return ON_PAUSE;
        }

        @Nullable
        public static Event downTo(@NonNull State state) {
            int ordinal = state.ordinal();
            if (ordinal == 0) {
                return ON_DESTROY;
            }
            if (ordinal == 2) {
                return ON_STOP;
            }
            if (ordinal != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        @Nullable
        public static Event upFrom(@NonNull State state) {
            int ordinal = state.ordinal();
            if (ordinal == 1) {
                return ON_CREATE;
            }
            if (ordinal == 2) {
                return ON_START;
            }
            if (ordinal != 3) {
                return null;
            }
            return ON_RESUME;
        }

        @Nullable
        public static Event upTo(@NonNull State state) {
            int ordinal = state.ordinal();
            if (ordinal == 2) {
                return ON_CREATE;
            }
            if (ordinal == 3) {
                return ON_START;
            }
            if (ordinal != 4) {
                return null;
            }
            return ON_RESUME;
        }

        @NonNull
        public State getTargetState() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        return State.RESUMED;
                    }
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                return State.DESTROYED;
                            }
                            throw new IllegalArgumentException(this + " has no target state");
                        }
                    }
                }
                return State.STARTED;
            }
            return State.CREATED;
        }
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            return compareTo(state) >= 0;
        }
    }

    @MainThread
    public abstract void addObserver(@NonNull LifecycleObserver lifecycleObserver);

    @MainThread
    @NonNull
    public abstract State getCurrentState();

    @MainThread
    public abstract void removeObserver(@NonNull LifecycleObserver lifecycleObserver);
}
