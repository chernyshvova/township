package com.swrve.sdk.notifications.model;

public class SwrveNotificationChannel {

    /* renamed from: id */
    public String f2804id;
    public ImportanceLevel importance;
    public String name;

    /* renamed from: com.swrve.sdk.notifications.model.SwrveNotificationChannel$1 */
    public static /* synthetic */ class C17111 {

        /* renamed from: $SwitchMap$com$swrve$sdk$notifications$model$SwrveNotificationChannel$ImportanceLevel */
        public static final /* synthetic */ int[] f2805xb9360352;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002b */
        static {
            /*
                com.swrve.sdk.notifications.model.SwrveNotificationChannel$ImportanceLevel[] r0 = com.swrve.sdk.notifications.model.SwrveNotificationChannel.ImportanceLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2805xb9360352 = r0
                r1 = 1
                com.swrve.sdk.notifications.model.SwrveNotificationChannel$ImportanceLevel r2 = com.swrve.sdk.notifications.model.SwrveNotificationChannel.ImportanceLevel.DEFAULT     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f2805xb9360352     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.notifications.model.SwrveNotificationChannel$ImportanceLevel r3 = com.swrve.sdk.notifications.model.SwrveNotificationChannel.ImportanceLevel.HIGH     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f2805xb9360352     // Catch:{ NoSuchFieldError -> 0x001d }
                com.swrve.sdk.notifications.model.SwrveNotificationChannel$ImportanceLevel r3 = com.swrve.sdk.notifications.model.SwrveNotificationChannel.ImportanceLevel.LOW     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = f2805xb9360352     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.swrve.sdk.notifications.model.SwrveNotificationChannel$ImportanceLevel r3 = com.swrve.sdk.notifications.model.SwrveNotificationChannel.ImportanceLevel.MAX     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = f2805xb9360352     // Catch:{ NoSuchFieldError -> 0x002b }
                com.swrve.sdk.notifications.model.SwrveNotificationChannel$ImportanceLevel r3 = com.swrve.sdk.notifications.model.SwrveNotificationChannel.ImportanceLevel.MIN     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = f2805xb9360352     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.swrve.sdk.notifications.model.SwrveNotificationChannel$ImportanceLevel r2 = com.swrve.sdk.notifications.model.SwrveNotificationChannel.ImportanceLevel.NONE     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.notifications.model.SwrveNotificationChannel.C17111.<clinit>():void");
        }
    }

    public enum ImportanceLevel {
        DEFAULT,
        HIGH,
        LOW,
        MAX,
        MIN,
        NONE;

        public int androidImportance() {
            int ordinal = ordinal();
            if (ordinal == 1) {
                return 4;
            }
            int i = 2;
            if (ordinal != 2) {
                i = 5;
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        return ordinal != 5 ? 3 : 0;
                    }
                    return 1;
                }
            }
            return i;
        }
    }

    public int getAndroidImportance() {
        return this.importance.androidImportance();
    }

    public String getId() {
        return this.f2804id;
    }

    public ImportanceLevel getImportance() {
        return this.importance;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String str) {
        this.f2804id = str;
    }

    public void setImportance(ImportanceLevel importanceLevel) {
        this.importance = importanceLevel;
    }

    public void setName(String str) {
        this.name = str;
    }
}
