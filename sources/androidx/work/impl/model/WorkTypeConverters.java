package androidx.work.impl.model;

import androidx.room.TypeConverter;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;

public class WorkTypeConverters {

    /* renamed from: androidx.work.impl.model.WorkTypeConverters$1 */
    public static /* synthetic */ class C06061 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$work$BackoffPolicy;
        public static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType;
        public static final /* synthetic */ int[] $SwitchMap$androidx$work$WorkInfo$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|(2:17|18)|19|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0057 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0063 */
        static {
            /*
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$work$NetworkType = r0
                r1 = 0
                r2 = 1
                androidx.work.NetworkType r3 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r3 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0016 }
                androidx.work.NetworkType r4 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r3 = 3
                int[] r4 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.work.NetworkType r5 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x001d }
                r4[r0] = r3     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r4 = 4
                int[] r5 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0024 }
                androidx.work.NetworkType r6 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0024 }
                r5[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r5 = 5
                int[] r6 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x002b }
                androidx.work.NetworkType r7 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x002b }
                r6[r4] = r5     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.work.BackoffPolicy[] r6 = androidx.work.BackoffPolicy.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$androidx$work$BackoffPolicy = r6
                androidx.work.BackoffPolicy r7 = androidx.work.BackoffPolicy.EXPONENTIAL     // Catch:{ NoSuchFieldError -> 0x0038 }
                r6[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r6 = $SwitchMap$androidx$work$BackoffPolicy     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.work.BackoffPolicy r7 = androidx.work.BackoffPolicy.LINEAR     // Catch:{ NoSuchFieldError -> 0x003e }
                r6[r2] = r0     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                androidx.work.WorkInfo$State[] r6 = androidx.work.WorkInfo.State.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$androidx$work$WorkInfo$State = r6
                androidx.work.WorkInfo$State r7 = androidx.work.WorkInfo.State.ENQUEUED     // Catch:{ NoSuchFieldError -> 0x004b }
                r6[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r1 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x0051 }
                androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.RUNNING     // Catch:{ NoSuchFieldError -> 0x0051 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                int[] r1 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x0057 }
                androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo.State.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0057 }
                r1[r0] = r3     // Catch:{ NoSuchFieldError -> 0x0057 }
            L_0x0057:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x005d }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.FAILED     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x0063 }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.BLOCKED     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x006a }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.CANCELLED     // Catch:{ NoSuchFieldError -> 0x006a }
                r1 = 6
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.C06061.<clinit>():void");
        }
    }

    public interface BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        public static final int LINEAR = 1;
    }

    public interface NetworkTypeIds {
        public static final int CONNECTED = 1;
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int UNMETERED = 2;
    }

    public interface StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;
    }

    @TypeConverter
    public static int backoffPolicyToInt(BackoffPolicy backoffPolicy) {
        int ordinal = backoffPolicy.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        if (ordinal == 1) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + backoffPolicy + " to int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046 A[SYNTHETIC, Splitter:B:25:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a A[SYNTHETIC, Splitter:B:36:0x005a] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0033=Splitter:B:15:0x0033, B:29:0x004e=Splitter:B:29:0x004e} */
    @androidx.room.TypeConverter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.ContentUriTriggers byteArrayToContentUriTriggers(byte[] r6) {
        /*
            androidx.work.ContentUriTriggers r0 = new androidx.work.ContentUriTriggers
            r0.<init>()
            if (r6 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x003d, all -> 0x0039 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x003d, all -> 0x0039 }
            int r6 = r2.readInt()     // Catch:{ IOException -> 0x0037 }
        L_0x0017:
            if (r6 <= 0) goto L_0x002b
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException -> 0x0037 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ IOException -> 0x0037 }
            boolean r4 = r2.readBoolean()     // Catch:{ IOException -> 0x0037 }
            r0.add(r3, r4)     // Catch:{ IOException -> 0x0037 }
            int r6 = r6 + -1
            goto L_0x0017
        L_0x002b:
            r2.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0033:
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0037:
            r6 = move-exception
            goto L_0x0041
        L_0x0039:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto L_0x0058
        L_0x003d:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0041:
            r6.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004e:
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0056:
            return r0
        L_0x0057:
            r6 = move-exception
        L_0x0058:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0062:
            r1.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006a:
            goto L_0x006c
        L_0x006b:
            throw r6
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.byteArrayToContentUriTriggers(byte[]):androidx.work.ContentUriTriggers");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[SYNTHETIC, Splitter:B:26:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071 A[SYNTHETIC, Splitter:B:37:0x0071] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0062=Splitter:B:30:0x0062, B:15:0x0048=Splitter:B:15:0x0048} */
    @androidx.room.TypeConverter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] contentUriTriggersToByteArray(androidx.work.ContentUriTriggers r4) {
        /*
            int r0 = r4.size()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0054 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0054 }
            int r1 = r4.size()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.util.Set r4 = r4.getTriggers()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
        L_0x0021:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            if (r1 == 0) goto L_0x0040
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            androidx.work.ContentUriTriggers$Trigger r1 = (androidx.work.ContentUriTriggers.Trigger) r1     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            android.net.Uri r3 = r1.getUri()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            boolean r1 = r1.shouldTriggerForDescendants()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r2.writeBoolean(r1)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            goto L_0x0021
        L_0x0040:
            r2.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0048:
            r0.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x004c:
            r4 = move-exception
            r1 = r2
            goto L_0x006f
        L_0x004f:
            r4 = move-exception
            r1 = r2
            goto L_0x0055
        L_0x0052:
            r4 = move-exception
            goto L_0x006f
        L_0x0054:
            r4 = move-exception
        L_0x0055:
            r4.printStackTrace()     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0062:
            r0.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006a:
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x006f:
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0079:
            r0.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0081:
            goto L_0x0083
        L_0x0082:
            throw r4
        L_0x0083:
            goto L_0x0082
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.contentUriTriggersToByteArray(androidx.work.ContentUriTriggers):byte[]");
    }

    @TypeConverter
    public static BackoffPolicy intToBackoffPolicy(int i) {
        if (i == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
    }

    @TypeConverter
    public static NetworkType intToNetworkType(int i) {
        if (i == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i == 1) {
            return NetworkType.CONNECTED;
        }
        if (i == 2) {
            return NetworkType.UNMETERED;
        }
        if (i == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i == 4) {
            return NetworkType.METERED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
    }

    @TypeConverter
    public static WorkInfo.State intToState(int i) {
        if (i == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to State");
    }

    @TypeConverter
    public static int networkTypeToInt(NetworkType networkType) {
        int ordinal = networkType.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        return 4;
                    }
                    throw new IllegalArgumentException("Could not convert " + networkType + " to int");
                }
            }
        }
        return i;
    }

    @TypeConverter
    public static int stateToInt(WorkInfo.State state) {
        int ordinal = state.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (ordinal != 3) {
                    i = 4;
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return 5;
                        }
                        throw new IllegalArgumentException("Could not convert " + state + " to int");
                    }
                }
            }
        }
        return i;
    }
}
