package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfox<V> extends zzfrf implements zzfqn<V> {
    public static final boolean zzaI;
    public static final Logger zzaL = Logger.getLogger(zzfox.class.getName());
    public static final zza zzaM;
    public static final Object zzaN = new Object();
    @NullableDecl
    public volatile zzd listeners;
    @NullableDecl
    public volatile Object value;
    @NullableDecl
    public volatile zzk waiters;

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public final class zzb {
        public static final zzb zza;
        public static final zzb zzb;
        public final boolean zzc;
        @NullableDecl
        public final Throwable zzd;

        static {
            if (zzfox.zzaI) {
                zzb = null;
                zza = null;
                return;
            }
            zzb = new zzb(false, (Throwable) null);
            zza = new zzb(true, (Throwable) null);
        }

        public zzb(boolean z, @NullableDecl Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public final class zzd {
        public static final zzd zza = new zzd((Runnable) null, (Executor) null);
        @NullableDecl
        public zzd next;
        public final Runnable zzb;
        public final Executor zzc;

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public interface zzh<V> extends zzfqn<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public abstract class zzi<V> extends zzfox<V> implements zzh<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public final class zzk {
        public static final zzk zza = new zzk(false);
        @NullableDecl
        public volatile zzk next;
        @NullableDecl
        public volatile Thread thread;

        public zzk() {
            zzfox.zzaM.zza(this, Thread.currentThread());
        }

        public zzk(boolean z) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public abstract class zza {
        public /* synthetic */ zza(C16351 r1) {
        }

        public abstract void zza(zzk zzk, Thread thread);

        public abstract void zzb(zzk zzk, zzk zzk2);

        public abstract boolean zzc(zzfox<?> zzfox, zzk zzk, zzk zzk2);

        public abstract boolean zzd(zzfox<?> zzfox, zzd zzd, zzd zzd2);

        public abstract boolean zze(zzfox<?> zzfox, Object obj, Object obj2);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public final class zzc {
        public static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") {
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        public final Throwable zzb;

        public zzc(Throwable th) {
            if (th != null) {
                this.zzb = th;
                return;
            }
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public final class zze extends zza {
        public final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        public final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        public final AtomicReferenceFieldUpdater<zzfox, zzk> zzc;
        public final AtomicReferenceFieldUpdater<zzfox, zzd> zzd;
        public final AtomicReferenceFieldUpdater<zzfox, Object> zze;

        public zze(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzfox, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzfox, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzfox, Object> atomicReferenceFieldUpdater5) {
            super((C16351) null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        public final void zza(zzk zzk, Thread thread) {
            this.zza.lazySet(zzk, thread);
        }

        public final void zzb(zzk zzk, zzk zzk2) {
            this.zzb.lazySet(zzk, zzk2);
        }

        public final boolean zzc(zzfox<?> zzfox, zzk zzk, zzk zzk2) {
            return this.zzc.compareAndSet(zzfox, zzk, zzk2);
        }

        public final boolean zzd(zzfox<?> zzfox, zzd zzd2, zzd zzd3) {
            return this.zzd.compareAndSet(zzfox, zzd2, zzd3);
        }

        public final boolean zze(zzfox<?> zzfox, Object obj, Object obj2) {
            return this.zze.compareAndSet(zzfox, obj, obj2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public final class zzf<V> implements Runnable {
        public final zzfox<V> zza;
        public final zzfqn<? extends V> zzb;

        public zzf(zzfox<V> zzfox, zzfqn<? extends V> zzfqn) {
            this.zza = zzfox;
            this.zzb = zzfqn;
        }

        public final void run() {
            if (this.zza.value == this) {
                if (zzfox.zzaM.zze(this.zza, this, zzfox.zzb(this.zzb))) {
                    zzfox.zzx(this.zza);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public final class zzg extends zza {
        public zzg() {
            super((C16351) null);
        }

        public /* synthetic */ zzg(C16351 r1) {
            super((C16351) null);
        }

        public final void zza(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        public final void zzb(zzk zzk, zzk zzk2) {
            zzk.next = zzk2;
        }

        public final boolean zzc(zzfox<?> zzfox, zzk zzk, zzk zzk2) {
            synchronized (zzfox) {
                if (zzfox.waiters != zzk) {
                    return false;
                }
                zzk unused = zzfox.waiters = zzk2;
                return true;
            }
        }

        public final boolean zzd(zzfox<?> zzfox, zzd zzd, zzd zzd2) {
            synchronized (zzfox) {
                if (zzfox.listeners != zzd) {
                    return false;
                }
                zzd unused = zzfox.listeners = zzd2;
                return true;
            }
        }

        public final boolean zze(zzfox<?> zzfox, Object obj, Object obj2) {
            synchronized (zzfox) {
                if (zzfox.value != obj) {
                    return false;
                }
                Object unused = zzfox.value = obj2;
                return true;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
    public final class zzj extends zza {
        public static final Unsafe zza;
        public static final long zzb;
        public static final long zzc;
        public static final long zzd;
        public static final long zze;
        public static final long zzf;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.ads.zzfox.zzj.C16371());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.android.gms.internal.ads.zzfox$zzk> r0 = com.google.android.gms.internal.ads.zzfox.zzk.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.android.gms.internal.ads.zzfox$zzj$1 r1 = new com.google.android.gms.internal.ads.zzfox$zzj$1     // Catch:{ PrivilegedActionException -> 0x005d }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005d }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005d }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005d }
            L_0x0012:
                java.lang.Class<com.google.android.gms.internal.ads.zzfox> r2 = com.google.android.gms.internal.ads.zzfox.class
                java.lang.String r3 = "waiters"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzc = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "listeners"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzb = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "value"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zzd = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zze = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "next"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ Exception -> 0x0053 }
                zzf = r2     // Catch:{ Exception -> 0x0053 }
                zza = r1     // Catch:{ Exception -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                com.google.android.gms.internal.ads.zzfko.zza(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005d:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfox.zzj.<clinit>():void");
        }

        public zzj() {
            super((C16351) null);
        }

        public /* synthetic */ zzj(C16351 r1) {
            super((C16351) null);
        }

        public final void zza(zzk zzk, Thread thread) {
            zza.putObject(zzk, zze, thread);
        }

        public final void zzb(zzk zzk, zzk zzk2) {
            zza.putObject(zzk, zzf, zzk2);
        }

        public final boolean zzc(zzfox<?> zzfox, zzk zzk, zzk zzk2) {
            return zza.compareAndSwapObject(zzfox, zzc, zzk, zzk2);
        }

        public final boolean zzd(zzfox<?> zzfox, zzd zzd2, zzd zzd3) {
            return zza.compareAndSwapObject(zzfox, zzb, zzd2, zzd3);
        }

        public final boolean zze(zzfox<?> zzfox, Object obj, Object obj2) {
            return zza.compareAndSwapObject(zzfox, zzd, obj, obj2);
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zza2;
        Class<zzk> cls = zzk.class;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zzaI = z;
        try {
            zza2 = new zzj((C16351) null);
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            zza2 = new zzg((C16351) null);
        }
        zzaM = zza2;
        if (th != null) {
            zzaL.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzaL.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    private final void zzA(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    public static void zzB(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzaL;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", GeneratedOutlineSupport.outline20(new StringBuilder(valueOf.length() + 57 + valueOf2.length()), "RuntimeException while executing runnable ", valueOf, " with executor ", valueOf2), e);
        }
    }

    public static final V zzC(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        } else if (obj == zzaN) {
            return null;
        } else {
            return obj;
        }
    }

    private final void zza(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zza) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (!zzaM.zzc(this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    public static Object zzb(zzfqn<?> zzfqn) {
        Throwable zzk2;
        if (zzfqn instanceof zzh) {
            Object obj = ((zzfox) zzfqn).value;
            if (!(obj instanceof zzb)) {
                return obj;
            }
            zzb zzb2 = (zzb) obj;
            if (!zzb2.zzc) {
                return obj;
            }
            Throwable th = zzb2.zzd;
            return th != null ? new zzb(false, th) : zzb.zzb;
        } else if ((zzfqn instanceof zzfrf) && (zzk2 = ((zzfrf) zzfqn).zzk()) != null) {
            return new zzc(zzk2);
        } else {
            boolean isCancelled = zzfqn.isCancelled();
            if ((!zzaI) && isCancelled) {
                return zzb.zzb;
            }
            try {
                Object zzw = zzw(zzfqn);
                if (!isCancelled) {
                    return zzw == null ? zzaN : zzw;
                }
                String valueOf = String.valueOf(zzfqn);
                StringBuilder sb = new StringBuilder(valueOf.length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new zzb(false, new IllegalArgumentException(sb.toString()));
            } catch (ExecutionException e) {
                if (!isCancelled) {
                    return new zzc(e.getCause());
                }
                String valueOf2 = String.valueOf(zzfqn);
                return new zzb(false, new IllegalArgumentException(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf2.length() + 84), "get() did not throw CancellationException, despite reporting isCancelled() == true: ", valueOf2), e));
            } catch (CancellationException e2) {
                if (isCancelled) {
                    return new zzb(false, e2);
                }
                String valueOf3 = String.valueOf(zzfqn);
                return new zzc(new IllegalArgumentException(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf3.length() + 77), "get() threw CancellationException, despite reporting isCancelled() == false: ", valueOf3), e2));
            } catch (Throwable th2) {
                return new zzc(th2);
            }
        }
    }

    public static <V> V zzw(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public static void zzx(zzfox<?> zzfox) {
        zzfox<V> zzfox2;
        zzd zzd2;
        zzd zzd3;
        zzd zzd4 = null;
        zzfox<?> zzfox3 = zzfox;
        while (true) {
            zzk zzk2 = zzfox3.waiters;
            if (zzaM.zzc(zzfox3, zzk2, zzk.zza)) {
                while (zzk2 != null) {
                    Thread thread = zzk2.thread;
                    if (thread != null) {
                        zzk2.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzk2 = zzk2.next;
                }
                zzfox3.zzd();
                do {
                    zzd2 = zzfox3.listeners;
                } while (!zzaM.zzd(zzfox3, zzd2, zzd.zza));
                while (true) {
                    zzd3 = zzd4;
                    zzd4 = zzd2;
                    if (zzd4 == null) {
                        break;
                    }
                    zzd2 = zzd4.next;
                    zzd4.next = zzd3;
                }
                while (zzd3 != null) {
                    zzd4 = zzd3.next;
                    Runnable runnable = zzd3.zzb;
                    if (runnable instanceof zzf) {
                        zzf zzf2 = (zzf) runnable;
                        zzfox<V> zzfox4 = zzf2.zza;
                        if (zzfox4.value == zzf2) {
                            if (zzaM.zze(zzfox4, zzf2, zzb(zzf2.zzb))) {
                                zzfox2 = zzfox4;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        zzB(runnable, zzd3.zzc);
                    }
                    zzd3 = zzd4;
                }
                return;
            }
            zzfox2 = zzfox3;
            zzfox3 = zzfox2;
        }
    }

    private final void zzy(StringBuilder sb) {
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzA(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                str = zzfkm.zzb(zzc());
            } catch (RuntimeException | StackOverflowError e) {
                String valueOf = String.valueOf(e.getClass());
                str = GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 38), "Exception thrown from implementation: ", valueOf);
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzz(sb);
        }
    }

    private final void zzz(StringBuilder sb) {
        try {
            Object zzw = zzw(this);
            sb.append("SUCCESS, result=[");
            if (zzw == null) {
                sb.append("null");
            } else if (zzw == this) {
                sb.append("this future");
            } else {
                sb.append(zzw.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzw)));
            }
            sb.append("]");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.android.gms.internal.ads.zzfqn<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfox.zzf
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = zzaI
            if (r3 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzfox$zzb r3 = new com.google.android.gms.internal.ads.zzfox$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzfox$zzb r3 = com.google.android.gms.internal.ads.zzfox.zzb.zza
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzfox$zzb r3 = com.google.android.gms.internal.ads.zzfox.zzb.zzb
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            com.google.android.gms.internal.ads.zzfox$zza r6 = zzaM
            boolean r6 = r6.zze(r4, r0, r3)
            if (r6 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x0035
            r4.zzf()
        L_0x0035:
            zzx(r4)
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfox.zzf
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzfox$zzf r0 = (com.google.android.gms.internal.ads.zzfox.zzf) r0
            com.google.android.gms.internal.ads.zzfqn<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfox.zzh
            if (r4 == 0) goto L_0x0055
            r4 = r0
            com.google.android.gms.internal.ads.zzfox r4 = (com.google.android.gms.internal.ads.zzfox) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzfox.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0058
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
        L_0x0058:
            r1 = 1
            goto L_0x0061
        L_0x005a:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzfox.zzf
            if (r6 != 0) goto L_0x0028
            r1 = r5
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfox.cancel(boolean):boolean");
    }

    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                return zzC(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zza) {
                zzk zzk3 = new zzk();
                do {
                    zzaM.zzb(zzk3, zzk2);
                    if (zzaM.zzc(this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zza(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zzf))));
                        return zzC(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zza);
            }
            return zzC(this.value);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.value instanceof zzb;
    }

    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof zzf)) & (obj != null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzz(sb);
        } else {
            zzy(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    @NullableDecl
    public String zzc() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    public void zzd() {
    }

    public void zze(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzfke.zzc(runnable, "Runnable was null.");
        zzfke.zzc(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zza) {
            zzB(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzaM.zzd(this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zza);
        zzB(runnable, executor);
    }

    public void zzf() {
    }

    public final boolean zzg() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    public boolean zzh(@NullableDecl V v) {
        if (v == null) {
            v = zzaN;
        }
        if (!zzaM.zze(this, (Object) null, v)) {
            return false;
        }
        zzx(this);
        return true;
    }

    public boolean zzi(Throwable th) {
        if (th != null) {
            if (!zzaM.zze(this, (Object) null, new zzc(th))) {
                return false;
            }
            zzx(this);
            return true;
        }
        throw null;
    }

    public final boolean zzj(zzfqn<? extends V> zzfqn) {
        zzf zzf2;
        zzc zzc2;
        if (zzfqn != null) {
            Object obj = this.value;
            if (obj == null) {
                if (zzfqn.isDone()) {
                    if (!zzaM.zze(this, (Object) null, zzb(zzfqn))) {
                        return false;
                    }
                    zzx(this);
                    return true;
                }
                zzf2 = new zzf(this, zzfqn);
                if (zzaM.zze(this, (Object) null, zzf2)) {
                    try {
                        zzfqn.zze(zzf2, zzfps.INSTANCE);
                    } catch (Throwable unused) {
                        zzc2 = zzc.zza;
                    }
                    return true;
                }
                obj = this.value;
            }
            if (obj instanceof zzb) {
                zzfqn.cancel(((zzb) obj).zzc);
            }
            return false;
        }
        throw null;
        zzaM.zze(this, zzf2, zzc2);
        return true;
    }

    @NullableDecl
    public final Throwable zzk() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    public final void zzl(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzg());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(long r19, java.util.concurrent.TimeUnit r21) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException, java.util.concurrent.ExecutionException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r3 = r21
            long r4 = r3.toNanos(r1)
            boolean r6 = java.lang.Thread.interrupted()
            if (r6 != 0) goto L_0x01cd
            java.lang.Object r6 = r0.value
            r7 = 1
            if (r6 == 0) goto L_0x0017
            r8 = 1
            goto L_0x0018
        L_0x0017:
            r8 = 0
        L_0x0018:
            boolean r9 = r6 instanceof com.google.android.gms.internal.ads.zzfox.zzf
            r9 = r9 ^ r7
            r8 = r8 & r9
            if (r8 == 0) goto L_0x0023
            java.lang.Object r1 = zzC(r6)
            return r1
        L_0x0023:
            r8 = 0
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x002f
            long r10 = java.lang.System.nanoTime()
            long r10 = r10 + r4
            goto L_0x0030
        L_0x002f:
            r10 = r8
        L_0x0030:
            r12 = 1000(0x3e8, double:4.94E-321)
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 < 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzfox$zzk r6 = r0.waiters
            com.google.android.gms.internal.ads.zzfox$zzk r14 = com.google.android.gms.internal.ads.zzfox.zzk.zza
            if (r6 == r14) goto L_0x0093
            com.google.android.gms.internal.ads.zzfox$zzk r14 = new com.google.android.gms.internal.ads.zzfox$zzk
            r14.<init>()
        L_0x0041:
            com.google.android.gms.internal.ads.zzfox$zza r15 = zzaM
            r15.zzb(r14, r6)
            com.google.android.gms.internal.ads.zzfox$zza r15 = zzaM
            boolean r6 = r15.zzc(r0, r6, r14)
            if (r6 == 0) goto L_0x0089
        L_0x004e:
            r8 = 2147483647999999999(0x1dcd64ffffffffff, double:3.98785104510193E-165)
            long r4 = java.lang.Math.min(r4, r8)
            java.util.concurrent.locks.LockSupport.parkNanos(r0, r4)
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x0080
            java.lang.Object r4 = r0.value
            if (r4 == 0) goto L_0x0066
            r5 = 1
            goto L_0x0067
        L_0x0066:
            r5 = 0
        L_0x0067:
            boolean r6 = r4 instanceof com.google.android.gms.internal.ads.zzfox.zzf
            r6 = r6 ^ r7
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0072
            java.lang.Object r1 = zzC(r4)
            return r1
        L_0x0072:
            long r4 = java.lang.System.nanoTime()
            long r4 = r10 - r4
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 >= 0) goto L_0x004e
            r0.zza(r14)
            goto L_0x00bc
        L_0x0080:
            r0.zza(r14)
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x0089:
            com.google.android.gms.internal.ads.zzfox$zzk r6 = r0.waiters
            com.google.android.gms.internal.ads.zzfox$zzk r8 = com.google.android.gms.internal.ads.zzfox.zzk.zza
            if (r6 != r8) goto L_0x0090
            goto L_0x0093
        L_0x0090:
            r8 = 0
            goto L_0x0041
        L_0x0093:
            java.lang.Object r1 = r0.value
            java.lang.Object r1 = zzC(r1)
            return r1
        L_0x009a:
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c5
            java.lang.Object r4 = r0.value
            if (r4 == 0) goto L_0x00a4
            r5 = 1
            goto L_0x00a5
        L_0x00a4:
            r5 = 0
        L_0x00a5:
            boolean r6 = r4 instanceof com.google.android.gms.internal.ads.zzfox.zzf
            r6 = r6 ^ r7
            r5 = r5 & r6
            if (r5 == 0) goto L_0x00b0
            java.lang.Object r1 = zzC(r4)
            return r1
        L_0x00b0:
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x00bf
            long r4 = java.lang.System.nanoTime()
            long r4 = r10 - r4
        L_0x00bc:
            r8 = 0
            goto L_0x009a
        L_0x00bf:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x00c5:
            java.lang.String r6 = r18.toString()
            java.lang.String r8 = r21.toString()
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r9)
            java.lang.String r9 = r21.toString()
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.String r9 = r9.toLowerCase(r10)
            java.lang.String r10 = java.lang.String.valueOf(r9)
            int r10 = r10.length()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            int r10 = r10 + 28
            r11.<init>(r10)
            java.lang.String r10 = "Waited "
            r11.append(r10)
            r11.append(r1)
            java.lang.String r1 = " "
            r11.append(r1)
            r11.append(r9)
            java.lang.String r2 = r11.toString()
            long r9 = r4 + r12
            r14 = 0
            int r11 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r11 >= 0) goto L_0x0193
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r9 = " (plus "
            java.lang.String r2 = r2.concat(r9)
            long r4 = -r4
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r9 = r3.convert(r4, r9)
            long r16 = r3.toNanos(r9)
            long r4 = r4 - r16
            int r3 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x0129
            int r3 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x0128
            goto L_0x0129
        L_0x0128:
            r7 = 0
        L_0x0129:
            int r3 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r3 <= 0) goto L_0x0169
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            java.lang.String r11 = java.lang.String.valueOf(r8)
            int r11 = r11.length()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            int r3 = r3 + 21
            int r3 = r3 + r11
            r12.<init>(r3)
            r12.append(r2)
            r12.append(r9)
            r12.append(r1)
            r12.append(r8)
            java.lang.String r2 = r12.toString()
            if (r7 == 0) goto L_0x0161
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = ","
            java.lang.String r2 = r2.concat(r3)
        L_0x0161:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r2 = r2.concat(r1)
        L_0x0169:
            if (r7 == 0) goto L_0x0189
            java.lang.String r1 = java.lang.String.valueOf(r2)
            int r2 = r1.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = r2 + 33
            r3.<init>(r2)
            r3.append(r1)
            r3.append(r4)
            java.lang.String r1 = " nanoseconds "
            r3.append(r1)
            java.lang.String r2 = r3.toString()
        L_0x0189:
            java.lang.String r1 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "delay)"
            java.lang.String r2 = r1.concat(r2)
        L_0x0193:
            boolean r1 = r18.isDone()
            if (r1 == 0) goto L_0x01a9
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = " but future completed as timeout expired"
            java.lang.String r2 = r2.concat(r3)
            r1.<init>(r2)
            throw r1
        L_0x01a9:
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            java.lang.String r4 = java.lang.String.valueOf(r6)
            int r4 = r4.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r3 = r3 + 5
            int r3 = r3 + r4
            r5.<init>(r3)
            java.lang.String r3 = " for "
            java.lang.String r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline19(r5, r2, r3, r6)
            r1.<init>(r2)
            throw r1
        L_0x01cd:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            goto L_0x01d4
        L_0x01d3:
            throw r1
        L_0x01d4:
            goto L_0x01d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfox.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }
}
