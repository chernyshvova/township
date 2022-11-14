package com.playrix.engine;

import android.os.StrictMode;
import android.util.Log;
import android.view.SurfaceHolder;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.engine.EglContextManager;
import java.util.ArrayList;

public class NativeThread extends Thread {
    public static final NativeThread mInstance = new NativeThread();
    public boolean mBadSurface = false;
    public final ArrayList<Runnable> mEventQueue = new ArrayList<>();
    public int mEventQueueLockPosition = -1;
    public boolean mExited = false;
    public int mHeight = 0;
    public final FifoQueue mInitializeQueue = new FifoQueue();
    public boolean mLibrariesLoaded = false;
    public boolean mPaused = false;
    public boolean mRenderComplete = false;
    public boolean mRequestBadSurface = false;
    public boolean mRequestExit = false;
    public boolean mRequestLostContext = false;
    public boolean mRequestPaused = false;
    public boolean mRequestSurface = false;
    public boolean mSizeChanged = false;
    public boolean mStarted = false;
    public SurfaceHolder mSurfaceHolder = null;
    public EglContextManager.Renderer mSurfaceRenderer = null;
    public final Thread mThread;
    public int mWidth = 0;

    public static class FifoQueue {
        public QueueEntry firstEntry = null;
        public QueueEntry lastEntry = null;

        /* access modifiers changed from: private */
        public QueueEntry pop() {
            QueueEntry queueEntry = this.firstEntry;
            if (queueEntry != null) {
                QueueEntry queueEntry2 = queueEntry.next;
                this.firstEntry = queueEntry2;
                if (queueEntry2 == null) {
                    this.lastEntry = null;
                }
            }
            return queueEntry;
        }

        public QueueEntry push(Runnable runnable) {
            QueueEntry queueEntry = new QueueEntry();
            queueEntry.runnable = runnable;
            QueueEntry queueEntry2 = this.lastEntry;
            if (queueEntry2 != null) {
                queueEntry2.next = queueEntry;
            } else {
                this.firstEntry = queueEntry;
            }
            this.lastEntry = queueEntry;
            return queueEntry;
        }
    }

    public static class QueueEntry {
        public QueueEntry next = null;
        public Runnable runnable = null;
    }

    public NativeThread() {
        EglContextManager.getInstance();
        this.mThread = new Thread(new Runnable() {
            public void run() {
                NativeThread nativeThread = NativeThread.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("NativeThread ");
                outline24.append(NativeThread.this.getId());
                nativeThread.setName(outline24.toString());
                try {
                    EglContextManager.getInstance().initDisplay();
                } catch (Throwable th) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("Error initializing EGLDisplay: ");
                    outline242.append(th.toString());
                    Log.e(EngineActivity.LOG_TAG, outline242.toString());
                    NativeThread.this.onExit();
                }
                try {
                    StrictMode.ThreadPolicy SwitchThreadPolicy = StrictMode.SwitchThreadPolicy(StrictMode.NewPermissiveThreadPolicy());
                    System.loadLibrary("fmod");
                    System.loadLibrary("fmodstudio");
                    System.loadLibrary("game");
                    Engine.nativeOnLaunchConfig();
                    StrictMode.SwitchThreadPolicy(SwitchThreadPolicy);
                    NativeThread.this.setLibrariesLoaded();
                } catch (Throwable th2) {
                    StringBuilder outline243 = GeneratedOutlineSupport.outline24("Error loading native libraries: ");
                    outline243.append(th2.toString());
                    Log.e(EngineActivity.LOG_TAG, outline243.toString());
                    NativeThread.this.onExit();
                }
                EglContextManager.getInstance().createRenderContext();
                try {
                    NativeThread.this.guardedRun();
                } catch (InterruptedException unused) {
                } catch (Throwable th3) {
                    NativeThread.this.onExit();
                    throw th3;
                }
                NativeThread.this.onExit();
                EglContextManager.getInstance().close();
                NativeThread.this.closeApplication();
            }
        });
    }

    /* access modifiers changed from: private */
    public void closeApplication() {
        EngineActivity activity = Engine.getActivity();
        if (activity != null) {
            activity.finish();
            System.exit(0);
        }
    }

    private Runnable fetchEventFromQueue() {
        int i;
        if (!this.mLibrariesLoaded) {
            return null;
        }
        if (this.mEventQueueLockPosition >= 0 && (this.mPaused || this.mRenderComplete || !readyToDraw())) {
            this.mEventQueueLockPosition = -1;
        }
        if (this.mEventQueue.isEmpty() || (i = this.mEventQueueLockPosition) == 0) {
            return null;
        }
        if (i > 0) {
            this.mEventQueueLockPosition = i - 1;
        }
        return this.mEventQueue.remove(0);
    }

    public static NativeThread getInstance() {
        return mInstance;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0071, code lost:
        if (r4 == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0073, code lost:
        r4.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0077, code lost:
        r2 = !r3.draw(r5, r10, r6, r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007e, code lost:
        if (r2 != false) goto L_0x0003;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0080, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void guardedRun() throws java.lang.InterruptedException {
        /*
            r12 = this;
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x0003:
            com.playrix.engine.EglContextManager r3 = com.playrix.engine.EglContextManager.getInstance()
            monitor-enter(r12)
        L_0x0008:
            r9 = 1
            if (r1 == 0) goto L_0x001f
            boolean r4 = r12.mRequestLostContext     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x0014
            r12.mRequestLostContext = r0     // Catch:{ all -> 0x008b }
            r3.onLostRenderContext()     // Catch:{ all -> 0x008b }
        L_0x0014:
            boolean r4 = r12.mRequestBadSurface     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x001f
            r12.mRequestBadSurface = r0     // Catch:{ all -> 0x008b }
            r3.destroyWindowSurface()     // Catch:{ all -> 0x008b }
            r1 = 0
            r2 = 1
        L_0x001f:
            boolean r4 = r3.isRenderContextCreated()     // Catch:{ all -> 0x008b }
            if (r4 != 0) goto L_0x0027
            monitor-exit(r12)     // Catch:{ all -> 0x008b }
            return
        L_0x0027:
            java.lang.Runnable r4 = r12.fetchEventFromQueue()     // Catch:{ all -> 0x008b }
            r5 = 0
            if (r4 == 0) goto L_0x0033
            r8 = r5
            r6 = 0
            r7 = 0
            r10 = 0
            goto L_0x0070
        L_0x0033:
            boolean r5 = r12.mRequestExit     // Catch:{ all -> 0x008b }
            if (r5 != 0) goto L_0x0086
            boolean r5 = r12.mExited     // Catch:{ all -> 0x008b }
            if (r5 == 0) goto L_0x003c
            goto L_0x0086
        L_0x003c:
            r12.updateSurfaceState()     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x004b
            boolean r1 = r12.mRenderComplete     // Catch:{ all -> 0x008b }
            if (r1 != 0) goto L_0x004a
            r12.mRenderComplete = r9     // Catch:{ all -> 0x008b }
            r12.notifyAll()     // Catch:{ all -> 0x008b }
        L_0x004a:
            r1 = 0
        L_0x004b:
            boolean r5 = r12.mBadSurface     // Catch:{ all -> 0x008b }
            if (r2 == r5) goto L_0x0054
            r12.mBadSurface = r2     // Catch:{ all -> 0x008b }
            r12.notifyAll()     // Catch:{ all -> 0x008b }
        L_0x0054:
            boolean r5 = r12.mSizeChanged     // Catch:{ all -> 0x008b }
            if (r5 == 0) goto L_0x005a
            r12.mBadSurface = r0     // Catch:{ all -> 0x008b }
        L_0x005a:
            boolean r5 = r12.readyToDraw()     // Catch:{ all -> 0x008b }
            if (r5 == 0) goto L_0x0082
            android.view.SurfaceHolder r5 = r12.mSurfaceHolder     // Catch:{ all -> 0x008b }
            com.playrix.engine.EglContextManager$Renderer r6 = r12.mSurfaceRenderer     // Catch:{ all -> 0x008b }
            int r7 = r12.mWidth     // Catch:{ all -> 0x008b }
            int r8 = r12.mHeight     // Catch:{ all -> 0x008b }
            boolean r10 = r12.mSizeChanged     // Catch:{ all -> 0x008b }
            r12.mSizeChanged = r0     // Catch:{ all -> 0x008b }
            r11 = r8
            r8 = r6
            r6 = r7
            r7 = r11
        L_0x0070:
            monitor-exit(r12)     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x0077
            r4.run()
            goto L_0x0003
        L_0x0077:
            r4 = r5
            r5 = r10
            boolean r2 = r3.draw(r4, r5, r6, r7, r8)
            r2 = r2 ^ r9
            if (r2 != 0) goto L_0x0003
            r1 = 1
            goto L_0x0003
        L_0x0082:
            r12.wait()     // Catch:{ all -> 0x008b }
            goto L_0x0008
        L_0x0086:
            r12.onExit()     // Catch:{ all -> 0x008b }
            monitor-exit(r12)     // Catch:{ all -> 0x008b }
            return
        L_0x008b:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x008b }
            goto L_0x008f
        L_0x008e:
            throw r0
        L_0x008f:
            goto L_0x008e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.NativeThread.guardedRun():void");
    }

    private void lockEventQueue() {
        if (this.mEventQueueLockPosition < 0) {
            this.mEventQueueLockPosition = this.mEventQueue.size();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onExit() {
        this.mExited = true;
        notifyAll();
    }

    private void processInitializeEvents() {
        QueueEntry access$400;
        synchronized (this) {
            access$400 = this.mInitializeQueue.pop();
        }
        while (access$400 != null) {
            access$400.runnable.run();
            synchronized (this) {
                access$400.runnable = null;
                notifyAll();
                access$400 = this.mInitializeQueue.pop();
            }
        }
    }

    private boolean readyToDraw() {
        return !this.mPaused && !this.mBadSurface && this.mSurfaceHolder != null && this.mWidth > 0 && this.mHeight > 0;
    }

    /* access modifiers changed from: private */
    public synchronized void setLibrariesLoaded() {
        this.mLibrariesLoaded = true;
        notifyAll();
    }

    private void updateSurfaceState() {
        boolean z = this.mPaused;
        boolean z2 = this.mRequestPaused;
        if (z != z2) {
            if (z2) {
                EglContextManager.getInstance().destroyWindowSurface();
                this.mBadSurface = false;
            }
            this.mPaused = this.mRequestPaused;
            notifyAll();
        }
        if (this.mSurfaceHolder == null && !this.mRequestSurface) {
            EglContextManager.getInstance().destroyWindowSurface();
            this.mBadSurface = false;
            this.mRequestSurface = true;
            notifyAll();
        }
        if (this.mSurfaceHolder != null && this.mRequestSurface) {
            this.mRequestSurface = false;
            notifyAll();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean waitOrExit(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.mExited     // Catch:{ all -> 0x001d }
            r1 = 0
            if (r0 == 0) goto L_0x000b
            r2.closeApplication()     // Catch:{ all -> 0x001d }
            monitor-exit(r2)
            return r1
        L_0x000b:
            if (r3 == 0) goto L_0x000f
            monitor-exit(r2)
            return r1
        L_0x000f:
            r2.wait()     // Catch:{ InterruptedException -> 0x0013 }
            goto L_0x001a
        L_0x0013:
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x001d }
            r3.interrupt()     // Catch:{ all -> 0x001d }
        L_0x001a:
            r3 = 1
            monitor-exit(r2)
            return r3
        L_0x001d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.NativeThread.waitOrExit(boolean):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|28|24|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0011, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean executeInitializeEvent(java.lang.Runnable r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x002b
            boolean r0 = r1.mLibrariesLoaded     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0008
            goto L_0x002b
        L_0x0008:
            com.playrix.engine.NativeThread$FifoQueue r0 = r1.mInitializeQueue     // Catch:{ all -> 0x0028 }
            com.playrix.engine.NativeThread$QueueEntry r2 = r0.push(r2)     // Catch:{ all -> 0x0028 }
            r1.notifyAll()     // Catch:{ all -> 0x0028 }
        L_0x0011:
            java.lang.Runnable r0 = r2.runnable     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0025
            boolean r0 = r1.mExited     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0025
            r1.wait()     // Catch:{ InterruptedException -> 0x001d }
            goto L_0x0011
        L_0x001d:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0028 }
            r0.interrupt()     // Catch:{ all -> 0x0028 }
            goto L_0x0011
        L_0x0025:
            r2 = 1
            monitor-exit(r1)
            return r2
        L_0x0028:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x002b:
            r2 = 0
            monitor-exit(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.NativeThread.executeInitializeEvent(java.lang.Runnable):boolean");
    }

    public synchronized boolean isLibrariesLoaded() {
        return this.mLibrariesLoaded;
    }

    public boolean loadNativeLibraries() {
        synchronized (this) {
            if (!this.mStarted) {
                this.mStarted = true;
                this.mThread.start();
            }
        }
        while (waitOrExit(isLibrariesLoaded())) {
            processInitializeEvents();
        }
        synchronized (this) {
            if (this.mExited) {
                return false;
            }
            processInitializeEvents();
            return true;
        }
    }

    public synchronized void onPause() {
        boolean z;
        this.mRequestPaused = true;
        notifyAll();
        do {
            if (!this.mPaused) {
                if (this.mRequestPaused) {
                    z = false;
                }
            }
            z = true;
        } while (waitOrExit(z));
    }

    public synchronized void onResume() {
        boolean z;
        this.mRequestPaused = false;
        this.mRenderComplete = false;
        notifyAll();
        do {
            if (this.mPaused) {
                if (!this.mRequestPaused) {
                    z = false;
                }
            }
            z = true;
        } while (waitOrExit(z));
    }

    public synchronized void onWindowResize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mSizeChanged = true;
        this.mRenderComplete = false;
        lockEventQueue();
        notifyAll();
    }

    public synchronized boolean queueEvent(Runnable runnable) {
        if (runnable != null) {
            if (!this.mExited) {
                this.mEventQueue.add(runnable);
                notifyAll();
                return true;
            }
        }
        return false;
    }

    public synchronized boolean queueInitalizeEvent(Runnable runnable) {
        if (runnable != null) {
            if (!this.mLibrariesLoaded) {
                this.mInitializeQueue.push(runnable);
                notifyAll();
                return true;
            }
        }
        return false;
    }

    public synchronized void requestBadSurface() {
        this.mRequestBadSurface = true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|8|9|18|15|4) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0007, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void requestExitAndWait() {
        /*
            r1 = this;
            monitor-enter(r1)
            r0 = 1
            r1.mRequestExit = r0     // Catch:{ all -> 0x0019 }
            r1.notifyAll()     // Catch:{ all -> 0x0019 }
        L_0x0007:
            boolean r0 = r1.mExited     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x0017
            r1.wait()     // Catch:{ InterruptedException -> 0x000f }
            goto L_0x0007
        L_0x000f:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0019 }
            r0.interrupt()     // Catch:{ all -> 0x0019 }
            goto L_0x0007
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r0 = move-exception
            monitor-exit(r1)
            goto L_0x001d
        L_0x001c:
            throw r0
        L_0x001d:
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.NativeThread.requestExitAndWait():void");
    }

    public synchronized void requestLostContext() {
        this.mRequestLostContext = true;
    }

    public synchronized void surfaceCreated(SurfaceHolder surfaceHolder, EglContextManager.Renderer renderer) {
        if (surfaceHolder == null) {
            surfaceDestroyed();
        }
        this.mSurfaceHolder = surfaceHolder;
        this.mSurfaceRenderer = renderer;
        this.mRequestSurface = true;
        notifyAll();
        do {
        } while (waitOrExit(!this.mRequestSurface));
    }

    public synchronized void surfaceDestroyed() {
        this.mSurfaceHolder = null;
        this.mRequestSurface = false;
        notifyAll();
        do {
        } while (waitOrExit(this.mRequestSurface));
    }
}
