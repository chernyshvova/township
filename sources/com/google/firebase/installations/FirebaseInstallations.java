package com.google.firebase.installations;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.AutoValue_TokenResult;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FirebaseInstallations implements FirebaseInstallationsApi {
    public static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        public final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.mCount.getAndIncrement())}));
        }
    };
    public static final Object lockGenerateFid = new Object();
    public final ExecutorService backgroundExecutor;
    @GuardedBy("this")
    public String cachedFid;
    public final RandomFidGenerator fidGenerator;
    public final FirebaseApp firebaseApp;
    public final IidStore iidStore;
    @GuardedBy("lock")
    public final List<StateListener> listeners = new ArrayList();
    public final Object lock = new Object();
    public final ExecutorService networkExecutor;
    public final PersistedInstallation persistedInstallation;
    public final FirebaseInstallationServiceClient serviceClient;
    public final Utils utils;

    public FirebaseInstallations(FirebaseApp firebaseApp2, @Nullable UserAgentPublisher userAgentPublisher, @Nullable HeartBeatInfo heartBeatInfo) {
        FirebaseApp firebaseApp3 = firebaseApp2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        firebaseApp2.checkNotDeleted();
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp3.applicationContext, userAgentPublisher, heartBeatInfo);
        PersistedInstallation persistedInstallation2 = new PersistedInstallation(firebaseApp3);
        Utils utils2 = new Utils();
        IidStore iidStore2 = new IidStore(firebaseApp3);
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        this.firebaseApp = firebaseApp3;
        this.serviceClient = firebaseInstallationServiceClient;
        this.persistedInstallation = persistedInstallation2;
        this.utils = utils2;
        this.iidStore = iidStore2;
        this.fidGenerator = randomFidGenerator;
        this.backgroundExecutor = threadPoolExecutor;
        this.networkExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
    }

    @NonNull
    public static FirebaseInstallations getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        Preconditions.checkArgument(true, "Null is not a valid value of FirebaseApp.");
        instance.checkNotDeleted();
        return (FirebaseInstallations) instance.componentRuntime.get(FirebaseInstallationsApi.class);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void lambda$doRegistrationOrRefresh$2(com.google.firebase.installations.FirebaseInstallations r3, boolean r4) {
        /*
            if (r3 == 0) goto L_0x00ab
            java.lang.Object r0 = lockGenerateFid
            monitor-enter(r0)
            com.google.firebase.FirebaseApp r1 = r3.firebaseApp     // Catch:{ all -> 0x00a8 }
            r1.checkNotDeleted()     // Catch:{ all -> 0x00a8 }
            android.content.Context r1 = r1.applicationContext     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "generatefid.lock"
            com.google.firebase.installations.CrossProcessLock r1 = com.google.firebase.installations.CrossProcessLock.acquire(r1, r2)     // Catch:{ all -> 0x00a8 }
            com.google.firebase.installations.local.PersistedInstallation r2 = r3.persistedInstallation     // Catch:{ all -> 0x00a1 }
            com.google.firebase.installations.local.PersistedInstallationEntry r2 = r2.readPersistedInstallationEntryValue()     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x001d
            r1.releaseAndClose()     // Catch:{ all -> 0x00a8 }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            boolean r0 = r2.isErrored()     // Catch:{ FirebaseInstallationsException -> 0x009c }
            if (r0 != 0) goto L_0x003a
            boolean r0 = r2.isUnregistered()     // Catch:{ FirebaseInstallationsException -> 0x009c }
            if (r0 == 0) goto L_0x002b
            goto L_0x003a
        L_0x002b:
            if (r4 != 0) goto L_0x0035
            com.google.firebase.installations.Utils r4 = r3.utils     // Catch:{ FirebaseInstallationsException -> 0x009c }
            boolean r4 = r4.isAuthTokenExpired(r2)     // Catch:{ FirebaseInstallationsException -> 0x009c }
            if (r4 == 0) goto L_0x00a0
        L_0x0035:
            com.google.firebase.installations.local.PersistedInstallationEntry r4 = r3.fetchAuthTokenFromServer(r2)     // Catch:{ FirebaseInstallationsException -> 0x009c }
            goto L_0x003e
        L_0x003a:
            com.google.firebase.installations.local.PersistedInstallationEntry r4 = r3.registerFidWithServer(r2)     // Catch:{ FirebaseInstallationsException -> 0x009c }
        L_0x003e:
            java.lang.Object r0 = lockGenerateFid
            monitor-enter(r0)
            com.google.firebase.FirebaseApp r1 = r3.firebaseApp     // Catch:{ all -> 0x0099 }
            r1.checkNotDeleted()     // Catch:{ all -> 0x0099 }
            android.content.Context r1 = r1.applicationContext     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = "generatefid.lock"
            com.google.firebase.installations.CrossProcessLock r1 = com.google.firebase.installations.CrossProcessLock.acquire(r1, r2)     // Catch:{ all -> 0x0099 }
            com.google.firebase.installations.local.PersistedInstallation r2 = r3.persistedInstallation     // Catch:{ all -> 0x0092 }
            r2.insertOrUpdatePersistedInstallationEntry(r4)     // Catch:{ all -> 0x0092 }
            if (r1 == 0) goto L_0x0058
            r1.releaseAndClose()     // Catch:{ all -> 0x0099 }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            boolean r0 = r4.isRegistered()
            if (r0 == 0) goto L_0x006c
            r0 = r4
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r0 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry) r0
            java.lang.String r0 = r0.firebaseInstallationId
            monitor-enter(r3)
            r3.cachedFid = r0     // Catch:{ all -> 0x0069 }
            monitor-exit(r3)
            goto L_0x006c
        L_0x0069:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x006c:
            boolean r0 = r4.isErrored()
            if (r0 == 0) goto L_0x007d
            com.google.firebase.installations.FirebaseInstallationsException r0 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r1 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
            r0.<init>(r1)
            r3.triggerOnException(r4, r0)
            goto L_0x00a0
        L_0x007d:
            boolean r0 = r4.isNotGenerated()
            if (r0 == 0) goto L_0x008e
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r0.<init>(r1)
            r3.triggerOnException(r4, r0)
            goto L_0x00a0
        L_0x008e:
            r3.triggerOnStateReached(r4)
            goto L_0x00a0
        L_0x0092:
            r3 = move-exception
            if (r1 == 0) goto L_0x0098
            r1.releaseAndClose()     // Catch:{ all -> 0x0099 }
        L_0x0098:
            throw r3     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            throw r3
        L_0x009c:
            r4 = move-exception
            r3.triggerOnException(r2, r4)
        L_0x00a0:
            return
        L_0x00a1:
            r3 = move-exception
            if (r1 == 0) goto L_0x00a7
            r1.releaseAndClose()     // Catch:{ all -> 0x00a8 }
        L_0x00a7:
            throw r3     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            throw r3
        L_0x00ab:
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.lambda$doRegistrationOrRefresh$2(com.google.firebase.installations.FirebaseInstallations, boolean):void");
    }

    public final void doRegistrationOrRefresh(boolean z) {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (lockGenerateFid) {
            FirebaseApp firebaseApp2 = this.firebaseApp;
            firebaseApp2.checkNotDeleted();
            CrossProcessLock acquire = CrossProcessLock.acquire(firebaseApp2.applicationContext, "generatefid.lock");
            try {
                readPersistedInstallationEntryValue = this.persistedInstallation.readPersistedInstallationEntryValue();
                if (readPersistedInstallationEntryValue.isNotGenerated()) {
                    String readExistingIidOrCreateFid = readExistingIidOrCreateFid(readPersistedInstallationEntryValue);
                    PersistedInstallation persistedInstallation2 = this.persistedInstallation;
                    AutoValue_PersistedInstallationEntry.Builder builder = (AutoValue_PersistedInstallationEntry.Builder) readPersistedInstallationEntryValue.toBuilder();
                    builder.firebaseInstallationId = readExistingIidOrCreateFid;
                    builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED);
                    readPersistedInstallationEntryValue = builder.build();
                    persistedInstallation2.insertOrUpdatePersistedInstallationEntry(readPersistedInstallationEntryValue);
                }
            } finally {
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
            }
        }
        if (z) {
            AutoValue_PersistedInstallationEntry.Builder builder2 = (AutoValue_PersistedInstallationEntry.Builder) readPersistedInstallationEntryValue.toBuilder();
            builder2.authToken = null;
            readPersistedInstallationEntryValue = builder2.build();
        }
        triggerOnStateReached(readPersistedInstallationEntryValue);
        this.networkExecutor.execute(new FirebaseInstallations$$Lambda$4(this, z));
    }

    public final PersistedInstallationEntry fetchAuthTokenFromServer(@NonNull PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        TokenResult readGenerateAuthTokenResponse;
        FirebaseInstallationsException.Status status = FirebaseInstallationsException.Status.UNAVAILABLE;
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.serviceClient;
        String apiKey = getApiKey();
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
        String str = autoValue_PersistedInstallationEntry.firebaseInstallationId;
        String projectIdentifier = getProjectIdentifier();
        String str2 = autoValue_PersistedInstallationEntry.refreshToken;
        if (firebaseInstallationServiceClient != null) {
            int i = 0;
            URL fullyQualifiedRequestUri = firebaseInstallationServiceClient.getFullyQualifiedRequestUri(String.format("projects/%s/installations/%s/authTokens:generate", new Object[]{projectIdentifier, str}));
            while (i <= 1) {
                HttpURLConnection openHttpURLConnection = firebaseInstallationServiceClient.openHttpURLConnection(fullyQualifiedRequestUri, apiKey);
                try {
                    openHttpURLConnection.setRequestMethod("POST");
                    openHttpURLConnection.addRequestProperty("Authorization", "FIS_v2 " + str2);
                    firebaseInstallationServiceClient.writeGenerateAuthTokenRequestBodyToOutputStream(openHttpURLConnection);
                    int responseCode = openHttpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        readGenerateAuthTokenResponse = firebaseInstallationServiceClient.readGenerateAuthTokenResponse(openHttpURLConnection);
                    } else {
                        FirebaseInstallationServiceClient.logFisCommunicationError(openHttpURLConnection, (String) null, apiKey, projectIdentifier);
                        if (responseCode != 401) {
                            if (responseCode != 404) {
                                if (responseCode == 429) {
                                    continue;
                                } else if (responseCode < 500 || responseCode >= 600) {
                                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                                    AutoValue_TokenResult.Builder builder = (AutoValue_TokenResult.Builder) TokenResult.builder();
                                    builder.responseCode = TokenResult.ResponseCode.BAD_CONFIG;
                                    readGenerateAuthTokenResponse = builder.build();
                                }
                                i++;
                                openHttpURLConnection.disconnect();
                            }
                        }
                        AutoValue_TokenResult.Builder builder2 = (AutoValue_TokenResult.Builder) TokenResult.builder();
                        builder2.responseCode = TokenResult.ResponseCode.AUTH_ERROR;
                        readGenerateAuthTokenResponse = builder2.build();
                    }
                    openHttpURLConnection.disconnect();
                    AutoValue_TokenResult autoValue_TokenResult = (AutoValue_TokenResult) readGenerateAuthTokenResponse;
                    int ordinal = autoValue_TokenResult.responseCode.ordinal();
                    if (ordinal == 0) {
                        String str3 = autoValue_TokenResult.token;
                        long j = autoValue_TokenResult.tokenExpirationTimestamp;
                        long currentTimeInSecs = this.utils.currentTimeInSecs();
                        AutoValue_PersistedInstallationEntry.Builder builder3 = (AutoValue_PersistedInstallationEntry.Builder) persistedInstallationEntry.toBuilder();
                        builder3.authToken = str3;
                        builder3.expiresInSecs = Long.valueOf(j);
                        builder3.tokenCreationEpochInSecs = Long.valueOf(currentTimeInSecs);
                        return builder3.build();
                    } else if (ordinal == 1) {
                        AutoValue_PersistedInstallationEntry.Builder builder4 = (AutoValue_PersistedInstallationEntry.Builder) persistedInstallationEntry.toBuilder();
                        builder4.fisError = "BAD CONFIG";
                        builder4.setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR);
                        return builder4.build();
                    } else if (ordinal == 2) {
                        synchronized (this) {
                            this.cachedFid = null;
                        }
                        PersistedInstallationEntry.Builder builder5 = persistedInstallationEntry.toBuilder();
                        builder5.setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED);
                        return builder5.build();
                    } else {
                        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", status);
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    openHttpURLConnection.disconnect();
                    throw th;
                }
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", status);
        }
        throw null;
    }

    @Nullable
    public String getApiKey() {
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        return firebaseApp2.options.apiKey;
    }

    @VisibleForTesting
    public String getApplicationId() {
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        return firebaseApp2.options.applicationId;
    }

    @NonNull
    public Task<String> getId() {
        String str;
        preConditionChecks();
        synchronized (this) {
            str = this.cachedFid;
        }
        if (str != null) {
            return Tasks.forResult(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetIdListener getIdListener = new GetIdListener(taskCompletionSource);
        synchronized (this.lock) {
            this.listeners.add(getIdListener);
        }
        Task<String> task = taskCompletionSource.getTask();
        this.backgroundExecutor.execute(new FirebaseInstallations$$Lambda$1(this));
        return task;
    }

    @Nullable
    public String getProjectIdentifier() {
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        return firebaseApp2.options.projectId;
    }

    @NonNull
    public Task<InstallationTokenResult> getToken(boolean z) {
        preConditionChecks();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(this.utils, taskCompletionSource);
        synchronized (this.lock) {
            this.listeners.add(getAuthTokenListener);
        }
        Task<InstallationTokenResult> task = taskCompletionSource.getTask();
        this.backgroundExecutor.execute(new FirebaseInstallations$$Lambda$2(this, z));
        return task;
    }

    public final void preConditionChecks() {
        Preconditions.checkNotEmpty(getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(getProjectIdentifier(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.isValidAppIdFormat(getApplicationId()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.API_KEY_FORMAT.matcher(getApiKey()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final String readExistingIidOrCreateFid(PersistedInstallationEntry persistedInstallationEntry) {
        String string;
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        if (firebaseApp2.name.equals("CHIME_ANDROID_SDK") || this.firebaseApp.isDefaultApp()) {
            if (((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).registrationStatus == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION) {
                IidStore iidStore2 = this.iidStore;
                synchronized (iidStore2.iidPrefs) {
                    synchronized (iidStore2.iidPrefs) {
                        string = iidStore2.iidPrefs.getString("|S|id", (String) null);
                    }
                    if (string == null) {
                        string = iidStore2.readPublicKeyFromLocalStorageAndCalculateInstanceId();
                    }
                }
                return TextUtils.isEmpty(string) ? this.fidGenerator.createRandomFid() : string;
            }
        }
        return this.fidGenerator.createRandomFid();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0153  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.firebase.installations.local.PersistedInstallationEntry registerFidWithServer(com.google.firebase.installations.local.PersistedInstallationEntry r22) throws com.google.firebase.installations.FirebaseInstallationsException {
        /*
            r21 = this;
            r1 = r21
            com.google.firebase.installations.FirebaseInstallationsException$Status r0 = com.google.firebase.installations.FirebaseInstallationsException.Status.UNAVAILABLE
            r2 = r22
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r2 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry) r2
            java.lang.String r3 = r2.firebaseInstallationId
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x006b
            int r3 = r3.length()
            r6 = 11
            if (r3 != r6) goto L_0x006b
            com.google.firebase.installations.local.IidStore r3 = r1.iidStore
            android.content.SharedPreferences r6 = r3.iidPrefs
            monitor-enter(r6)
            java.lang.String[] r7 = com.google.firebase.installations.local.IidStore.ALLOWABLE_SCOPES     // Catch:{ all -> 0x0068 }
            int r8 = r7.length     // Catch:{ all -> 0x0068 }
            r9 = 0
        L_0x001f:
            if (r9 >= r8) goto L_0x0066
            r10 = r7[r9]     // Catch:{ all -> 0x0068 }
            java.lang.String r11 = r3.defaultSenderId     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r12.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r13 = "|T|"
            r12.append(r13)     // Catch:{ all -> 0x0068 }
            r12.append(r11)     // Catch:{ all -> 0x0068 }
            java.lang.String r11 = "|"
            r12.append(r11)     // Catch:{ all -> 0x0068 }
            r12.append(r10)     // Catch:{ all -> 0x0068 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x0068 }
            android.content.SharedPreferences r11 = r3.iidPrefs     // Catch:{ all -> 0x0068 }
            java.lang.String r10 = r11.getString(r10, r5)     // Catch:{ all -> 0x0068 }
            if (r10 == 0) goto L_0x0063
            boolean r11 = r10.isEmpty()     // Catch:{ all -> 0x0068 }
            if (r11 != 0) goto L_0x0063
            java.lang.String r3 = "{"
            boolean r3 = r10.startsWith(r3)     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x0061
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0060 }
            r3.<init>(r10)     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r7 = "token"
            java.lang.String r10 = r3.getString(r7)     // Catch:{ JSONException -> 0x0060 }
            goto L_0x0061
        L_0x0060:
            r10 = r5
        L_0x0061:
            monitor-exit(r6)     // Catch:{ all -> 0x0068 }
            goto L_0x006c
        L_0x0063:
            int r9 = r9 + 1
            goto L_0x001f
        L_0x0066:
            monitor-exit(r6)     // Catch:{ all -> 0x0068 }
            goto L_0x006b
        L_0x0068:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0068 }
            throw r0
        L_0x006b:
            r10 = r5
        L_0x006c:
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient r3 = r1.serviceClient
            java.lang.String r6 = r21.getApiKey()
            java.lang.String r2 = r2.firebaseInstallationId
            java.lang.String r7 = r21.getProjectIdentifier()
            java.lang.String r8 = r21.getApplicationId()
            if (r3 == 0) goto L_0x0152
            r5 = 1
            java.lang.Object[] r9 = new java.lang.Object[r5]
            r9[r4] = r7
            java.lang.String r11 = "projects/%s/installations"
            java.lang.String r9 = java.lang.String.format(r11, r9)
            java.net.URL r9 = r3.getFullyQualifiedRequestUri(r9)
        L_0x008d:
            if (r4 > r5) goto L_0x014a
            java.net.HttpURLConnection r11 = r3.openHttpURLConnection(r9, r6)
            java.lang.String r12 = "POST"
            r11.setRequestMethod(r12)     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            r11.setDoOutput(r5)     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            if (r10 == 0) goto L_0x00a2
            java.lang.String r12 = "x-goog-fis-android-iid-migration-auth"
            r11.addRequestProperty(r12, r10)     // Catch:{ IOException -> 0x0143, all -> 0x013e }
        L_0x00a2:
            r3.writeFIDCreateRequestBodyToOutputStream(r11, r2, r8)     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            int r12 = r11.getResponseCode()     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            r13 = 200(0xc8, float:2.8E-43)
            if (r12 != r13) goto L_0x00b5
            com.google.firebase.installations.remote.InstallationResponse r2 = r3.readCreateResponse(r11)     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            r11.disconnect()
            goto L_0x00e2
        L_0x00b5:
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.logFisCommunicationError(r11, r8, r6, r7)     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            r13 = 429(0x1ad, float:6.01E-43)
            if (r12 == r13) goto L_0x0143
            r13 = 500(0x1f4, float:7.0E-43)
            if (r12 < r13) goto L_0x00c6
            r13 = 600(0x258, float:8.41E-43)
            if (r12 >= r13) goto L_0x00c6
            goto L_0x0143
        L_0x00c6:
            java.lang.String r12 = "Firebase-Installations"
            java.lang.String r13 = "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase."
            android.util.Log.e(r12, r13)     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            r18 = 0
            r17 = 0
            r16 = 0
            r15 = 0
            com.google.firebase.installations.remote.InstallationResponse$ResponseCode r19 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.BAD_CONFIG     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            com.google.firebase.installations.remote.AutoValue_InstallationResponse r12 = new com.google.firebase.installations.remote.AutoValue_InstallationResponse     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            r20 = 0
            r14 = r12
            r14.<init>(r15, r16, r17, r18, r19, r20)     // Catch:{ IOException -> 0x0143, all -> 0x013e }
            r11.disconnect()
            r2 = r12
        L_0x00e2:
            com.google.firebase.installations.remote.AutoValue_InstallationResponse r2 = (com.google.firebase.installations.remote.AutoValue_InstallationResponse) r2
            com.google.firebase.installations.remote.InstallationResponse$ResponseCode r3 = r2.responseCode
            int r3 = r3.ordinal()
            if (r3 == 0) goto L_0x010a
            if (r3 != r5) goto L_0x0102
            java.lang.String r0 = "BAD CONFIG"
            com.google.firebase.installations.local.PersistedInstallationEntry$Builder r2 = r22.toBuilder()
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder r2 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.Builder) r2
            r2.fisError = r0
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r0 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.REGISTER_ERROR
            r2.setRegistrationStatus(r0)
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r2.build()
            return r0
        L_0x0102:
            com.google.firebase.installations.FirebaseInstallationsException r2 = new com.google.firebase.installations.FirebaseInstallationsException
            java.lang.String r3 = "Firebase Installations Service is unavailable. Please try again later."
            r2.<init>(r3, r0)
            throw r2
        L_0x010a:
            java.lang.String r0 = r2.fid
            java.lang.String r3 = r2.refreshToken
            com.google.firebase.installations.Utils r4 = r1.utils
            long r4 = r4.currentTimeInSecs()
            com.google.firebase.installations.remote.TokenResult r2 = r2.authToken
            com.google.firebase.installations.remote.AutoValue_TokenResult r2 = (com.google.firebase.installations.remote.AutoValue_TokenResult) r2
            java.lang.String r6 = r2.token
            long r7 = r2.tokenExpirationTimestamp
            com.google.firebase.installations.local.PersistedInstallationEntry$Builder r2 = r22.toBuilder()
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder r2 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.Builder) r2
            r2.firebaseInstallationId = r0
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r0 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.REGISTERED
            r2.setRegistrationStatus(r0)
            r2.authToken = r6
            r2.refreshToken = r3
            java.lang.Long r0 = java.lang.Long.valueOf(r7)
            r2.expiresInSecs = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            r2.tokenCreationEpochInSecs = r0
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r2.build()
            return r0
        L_0x013e:
            r0 = move-exception
            r11.disconnect()
            throw r0
        L_0x0143:
            int r4 = r4 + 1
            r11.disconnect()
            goto L_0x008d
        L_0x014a:
            com.google.firebase.installations.FirebaseInstallationsException r2 = new com.google.firebase.installations.FirebaseInstallationsException
            java.lang.String r3 = "Firebase Installations Service is unavailable. Please try again later."
            r2.<init>(r3, r0)
            throw r2
        L_0x0152:
            goto L_0x0154
        L_0x0153:
            throw r5
        L_0x0154:
            goto L_0x0153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.registerFidWithServer(com.google.firebase.installations.local.PersistedInstallationEntry):com.google.firebase.installations.local.PersistedInstallationEntry");
    }

    public final void triggerOnException(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        synchronized (this.lock) {
            Iterator<StateListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (it.next().onException(persistedInstallationEntry, exc)) {
                    it.remove();
                }
            }
        }
    }

    public final void triggerOnStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.lock) {
            Iterator<StateListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (it.next().onStateReached(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }
}
