package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zas;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    public static final ThreadLocal<Boolean> zaa = new zao();
    @KeepName
    public zaa mResultGuardian;
    public final Object zab;
    public final CallbackHandler<R> zac;
    public final WeakReference<GoogleApiClient> zad;
    public final CountDownLatch zae;
    public final ArrayList<PendingResult.StatusListener> zaf;
    @Nullable
    public ResultCallback<? super R> zag;
    public final AtomicReference<zacq> zah;
    @Nullable
    public R zai;
    public Status zaj;
    public volatile boolean zak;
    public boolean zal;
    public boolean zam;
    @Nullable
    public ICancelToken zan;
    public volatile zacn<R> zao;
    public boolean zap;

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class CallbackHandler<R extends Result> extends zas {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public void handleMessage(@RecentlyNonNull Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.onResult(result);
                } catch (RuntimeException e) {
                    BasePendingResult.zaa(result);
                    throw e;
                }
            } else if (i != 2) {
                Log.wtf("BasePendingResult", GeneratedOutlineSupport.outline9(45, "Don't know how to handle message: ", i), new Exception());
            } else {
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        }

        public final void zaa(@RecentlyNonNull ResultCallback<? super R> resultCallback, @RecentlyNonNull R r) {
            sendMessage(obtainMessage(1, new Pair((ResultCallback) Preconditions.checkNotNull(BasePendingResult.zab(resultCallback)), r)));
        }

        public CallbackHandler(@RecentlyNonNull Looper looper) {
            super(looper);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public final class zaa {
        public zaa() {
        }

        public final void finalize() throws Throwable {
            BasePendingResult.zaa(BasePendingResult.this.zai);
            super.finalize();
        }

        public /* synthetic */ zaa(BasePendingResult basePendingResult, zao zao) {
            this();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(Looper.getMainLooper());
        this.zad = new WeakReference<>((Object) null);
    }

    @Nullable
    public static <R extends Result> ResultCallback<R> zab(@Nullable ResultCallback<R> resultCallback) {
        return resultCallback;
    }

    private final R zac() {
        R r;
        synchronized (this.zab) {
            Preconditions.checkState(!this.zak, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            r = this.zai;
            this.zai = null;
            this.zag = null;
            this.zak = true;
        }
        zacq andSet = this.zah.getAndSet((Object) null);
        if (andSet != null) {
            andSet.zaa(this);
        }
        return (Result) Preconditions.checkNotNull(r);
    }

    public final void addStatusListener(@RecentlyNonNull PendingResult.StatusListener statusListener) {
        Preconditions.checkArgument(statusListener != null, "Callback cannot be null.");
        synchronized (this.zab) {
            if (isReady()) {
                statusListener.onComplete(this.zaj);
            } else {
                this.zaf.add(statusListener);
            }
        }
    }

    @RecentlyNonNull
    public final R await() {
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        boolean z = true;
        Preconditions.checkState(!this.zak, "Result has already been consumed");
        if (this.zao != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            this.zae.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return zac();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|(2:10|11)|12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.zab
            monitor-enter(r0)
            boolean r1 = r2.zal     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0028
            boolean r1 = r2.zak     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x000c
            goto L_0x0028
        L_0x000c:
            com.google.android.gms.common.internal.ICancelToken r1 = r2.zan     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.common.internal.ICancelToken r1 = r2.zan     // Catch:{ RemoteException -> 0x0015 }
            r1.cancel()     // Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            R r1 = r2.zai     // Catch:{ all -> 0x002a }
            zaa((com.google.android.gms.common.api.Result) r1)     // Catch:{ all -> 0x002a }
            r1 = 1
            r2.zal = r1     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.RESULT_CANCELED     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.Result r1 = r2.createFailedResult(r1)     // Catch:{ all -> 0x002a }
            r2.zab(r1)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.cancel():void");
    }

    @NonNull
    @KeepForSdk
    public abstract R createFailedResult(@RecentlyNonNull Status status);

    @KeepForSdk
    @Deprecated
    public final void forceFailureUnlessReady(@RecentlyNonNull Status status) {
        synchronized (this.zab) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zam = true;
            }
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zab) {
            z = this.zal;
        }
        return z;
    }

    @KeepForSdk
    public final boolean isReady() {
        return this.zae.getCount() == 0;
    }

    @KeepForSdk
    public final void setCancelToken(@RecentlyNonNull ICancelToken iCancelToken) {
        synchronized (this.zab) {
            this.zan = iCancelToken;
        }
    }

    @KeepForSdk
    public final void setResult(@RecentlyNonNull R r) {
        synchronized (this.zab) {
            if (this.zam || this.zal) {
                zaa((Result) r);
                return;
            }
            isReady();
            boolean z = true;
            Preconditions.checkState(!isReady(), "Results have already been set");
            if (this.zak) {
                z = false;
            }
            Preconditions.checkState(z, "Result has already been consumed");
            zab(r);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(@androidx.annotation.Nullable com.google.android.gms.common.api.ResultCallback<? super R> r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.zab
            monitor-enter(r0)
            if (r6 != 0) goto L_0x000a
            r6 = 0
            r5.zag = r6     // Catch:{ all -> 0x003f }
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x000a:
            boolean r1 = r5.zak     // Catch:{ all -> 0x003f }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.Preconditions.checkState(r1, r4)     // Catch:{ all -> 0x003f }
            com.google.android.gms.common.api.internal.zacn<R> r1 = r5.zao     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.Preconditions.checkState(r2, r1)     // Catch:{ all -> 0x003f }
            boolean r1 = r5.isCanceled()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x002b:
            boolean r1 = r5.isReady()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003b
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r1 = r5.zac     // Catch:{ all -> 0x003f }
            com.google.android.gms.common.api.Result r2 = r5.zac()     // Catch:{ all -> 0x003f }
            r1.zaa(r6, r2)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x003b:
            r5.zag = r6     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    @RecentlyNonNull
    public <S extends Result> TransformedResult<S> then(@RecentlyNonNull ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        Preconditions.checkState(!this.zak, "Result has already been consumed.");
        synchronized (this.zab) {
            boolean z = false;
            Preconditions.checkState(this.zao == null, "Cannot call then() twice.");
            Preconditions.checkState(this.zag == null, "Cannot call then() if callbacks are set.");
            if (!this.zal) {
                z = true;
            }
            Preconditions.checkState(z, "Cannot call then() if result was canceled.");
            this.zap = true;
            this.zao = new zacn<>(this.zad);
            then = this.zao.then(resultTransform);
            if (isReady()) {
                this.zac.zaa(this.zao, zac());
            } else {
                this.zag = this.zao;
            }
        }
        return then;
    }

    public final boolean zaa() {
        boolean isCanceled;
        synchronized (this.zab) {
            if (((GoogleApiClient) this.zad.get()) == null || !this.zap) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zab() {
        this.zap = this.zap || zaa.get().booleanValue();
    }

    private final void zab(R r) {
        this.zai = r;
        this.zaj = r.getStatus();
        this.zan = null;
        this.zae.countDown();
        if (this.zal) {
            this.zag = null;
        } else {
            ResultCallback<? super R> resultCallback = this.zag;
            if (resultCallback != null) {
                this.zac.removeMessages(2);
                this.zac.zaa(resultCallback, zac());
            } else if (this.zai instanceof Releasable) {
                this.mResultGuardian = new zaa(this, (zao) null);
            }
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.zaf;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i);
            i++;
            statusListener.onComplete(this.zaj);
        }
        this.zaf.clear();
    }

    public final void zaa(@Nullable zacq zacq) {
        this.zah.set(zacq);
    }

    public static void zaa(@Nullable Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    @RecentlyNonNull
    public final R await(long j, @RecentlyNonNull TimeUnit timeUnit) {
        if (j > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        Preconditions.checkState(!this.zak, "Result has already been consumed.");
        if (this.zao != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            if (!this.zae.await(j, timeUnit)) {
                forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return zac();
    }

    @KeepForSdk
    public BasePendingResult(@Nullable GoogleApiClient googleApiClient) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zad = new WeakReference<>(googleApiClient);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.ResultCallback<? super R> r6, long r7, @androidx.annotation.RecentlyNonNull java.util.concurrent.TimeUnit r9) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.zab
            monitor-enter(r0)
            if (r6 != 0) goto L_0x000a
            r6 = 0
            r5.zag = r6     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x000a:
            boolean r1 = r5.zak     // Catch:{ all -> 0x004d }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.Preconditions.checkState(r1, r4)     // Catch:{ all -> 0x004d }
            com.google.android.gms.common.api.internal.zacn<R> r1 = r5.zao     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.Preconditions.checkState(r2, r1)     // Catch:{ all -> 0x004d }
            boolean r1 = r5.isCanceled()     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x002b
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x002b:
            boolean r1 = r5.isReady()     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x003b
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r7 = r5.zac     // Catch:{ all -> 0x004d }
            com.google.android.gms.common.api.Result r8 = r5.zac()     // Catch:{ all -> 0x004d }
            r7.zaa(r6, r8)     // Catch:{ all -> 0x004d }
            goto L_0x004b
        L_0x003b:
            r5.zag = r6     // Catch:{ all -> 0x004d }
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r6 = r5.zac     // Catch:{ all -> 0x004d }
            long r7 = r9.toMillis(r7)     // Catch:{ all -> 0x004d }
            r9 = 2
            android.os.Message r9 = r6.obtainMessage(r9, r5)     // Catch:{ all -> 0x004d }
            r6.sendMessageDelayed(r9, r7)     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x004d:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    @KeepForSdk
    @Deprecated
    public BasePendingResult(@RecentlyNonNull Looper looper) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(looper);
        this.zad = new WeakReference<>((Object) null);
    }

    @KeepForSdk
    @VisibleForTesting
    public BasePendingResult(@RecentlyNonNull CallbackHandler<R> callbackHandler) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = (CallbackHandler) Preconditions.checkNotNull(callbackHandler, "CallbackHandler must not be null");
        this.zad = new WeakReference<>((Object) null);
    }
}
