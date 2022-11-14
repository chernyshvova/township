package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.websockets.StateManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class WritingThread extends WebSocketThread {
    public static final int FLUSH_THRESHOLD = 1000;
    public static final int SHOULD_CONTINUE = 2;
    public static final int SHOULD_FLUSH = 3;
    public static final int SHOULD_SEND = 0;
    public static final int SHOULD_STOP = 1;
    public WebSocketFrame mCloseFrame;
    public boolean mFlushNeeded;
    public final LinkedList<WebSocketFrame> mFrames = new LinkedList<>();
    public final PerMessageCompressionExtension mPMCE;
    public boolean mStopRequested;
    public boolean mStopped;

    public WritingThread(WebSocket webSocket) {
        super("WritingThread", webSocket, ThreadType.WRITING_THREAD);
        this.mPMCE = webSocket.getPerMessageCompressionExtension();
    }

    private void addHighPriorityFrame(WebSocketFrame webSocketFrame) {
        Iterator it = this.mFrames.iterator();
        int i = 0;
        while (it.hasNext() && isHighPriorityFrame((WebSocketFrame) it.next())) {
            i++;
        }
        this.mFrames.add(i, webSocketFrame);
    }

    private void changeToClosing() {
        boolean z;
        StateManager stateManager = this.mWebSocket.getStateManager();
        synchronized (stateManager) {
            WebSocketState state = stateManager.getState();
            if (state == WebSocketState.CLOSING || state == WebSocketState.CLOSED) {
                z = false;
            } else {
                stateManager.changeToClosing(StateManager.CloseInitiator.CLIENT);
                z = true;
            }
        }
        if (z) {
            this.mWebSocket.getListenerManager().callOnStateChanged(WebSocketState.CLOSING);
        }
    }

    private void doFlush() throws WebSocketException {
        try {
            flush();
            synchronized (this) {
                this.mFlushNeeded = false;
            }
        } catch (IOException e) {
            WebSocketError webSocketError = WebSocketError.FLUSH_ERROR;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Flushing frames to the server failed: ");
            outline24.append(e.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, outline24.toString(), e);
            ListenerManager listenerManager = this.mWebSocket.getListenerManager();
            listenerManager.callOnError(webSocketException);
            listenerManager.callOnSendError(webSocketException, (WebSocketFrame) null);
            throw webSocketException;
        }
    }

    private void flush() throws IOException {
        this.mWebSocket.getOutput().flush();
    }

    private long flushIfLongInterval(long j) throws WebSocketException {
        long currentTimeMillis = System.currentTimeMillis();
        if (1000 >= currentTimeMillis - j) {
            return j;
        }
        doFlush();
        return currentTimeMillis;
    }

    private void flushIgnoreError() {
        try {
            flush();
        } catch (IOException unused) {
        }
    }

    private boolean isFlushNeeded(boolean z) {
        return z || this.mWebSocket.isAutoFlush() || this.mFlushNeeded || this.mCloseFrame != null;
    }

    public static boolean isHighPriorityFrame(WebSocketFrame webSocketFrame) {
        return webSocketFrame.isPingFrame() || webSocketFrame.isPongFrame();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:1|(3:3|(2:5|15)(2:6|(1:16)(3:8|9|10))|14)|11|12|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void main() {
        /*
            r3 = this;
            com.helpshift.websockets.WebSocket r0 = r3.mWebSocket
            r0.onWritingThreadStarted()
        L_0x0005:
            int r0 = r3.waitForFrames()
            r1 = 1
            if (r0 != r1) goto L_0x000d
            goto L_0x001d
        L_0x000d:
            r2 = 3
            if (r0 != r2) goto L_0x0014
            r3.flushIgnoreError()
            goto L_0x0005
        L_0x0014:
            r2 = 2
            if (r0 != r2) goto L_0x0018
            goto L_0x0005
        L_0x0018:
            r0 = 0
            r3.sendFrames(r0)     // Catch:{ WebSocketException -> 0x001d }
            goto L_0x0005
        L_0x001d:
            r3.sendFrames(r1)     // Catch:{ WebSocketException -> 0x0020 }
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.WritingThread.main():void");
    }

    private void notifyFinished() {
        this.mWebSocket.onWritingThreadFinished(this.mCloseFrame);
    }

    private void sendFrame(WebSocketFrame webSocketFrame) throws WebSocketException {
        boolean z;
        WebSocketFrame compressFrame = WebSocketFrame.compressFrame(webSocketFrame, this.mPMCE);
        this.mWebSocket.getListenerManager().callOnSendingFrame(compressFrame);
        if (this.mCloseFrame != null) {
            z = true;
        } else {
            if (compressFrame.isCloseFrame()) {
                this.mCloseFrame = compressFrame;
            }
            z = false;
        }
        if (z) {
            this.mWebSocket.getListenerManager().callOnFrameUnsent(compressFrame);
            return;
        }
        if (compressFrame.isCloseFrame()) {
            changeToClosing();
        }
        try {
            this.mWebSocket.getOutput().write(compressFrame);
            this.mWebSocket.getListenerManager().callOnFrameSent(compressFrame);
        } catch (IOException e) {
            WebSocketError webSocketError = WebSocketError.IO_ERROR_IN_WRITING;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("An I/O error occurred when a frame was tried to be sent: ");
            outline24.append(e.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, outline24.toString(), e);
            ListenerManager listenerManager = this.mWebSocket.getListenerManager();
            listenerManager.callOnError(webSocketException);
            listenerManager.callOnSendError(webSocketException, compressFrame);
            throw webSocketException;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        sendFrame(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r2.isPingFrame() != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        if (r2.isPongFrame() == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        if (isFlushNeeded(r5) != false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r0 = flushIfLongInterval(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        doFlush();
        r0 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (isFlushNeeded(r5) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        doFlush();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendFrames(boolean r5) throws com.helpshift.websockets.WebSocketException {
        /*
            r4 = this;
            long r0 = java.lang.System.currentTimeMillis()
        L_0x0004:
            monitor-enter(r4)
            java.util.LinkedList<com.helpshift.websockets.WebSocketFrame> r2 = r4.mFrames     // Catch:{ all -> 0x0042 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x0042 }
            com.helpshift.websockets.WebSocketFrame r2 = (com.helpshift.websockets.WebSocketFrame) r2     // Catch:{ all -> 0x0042 }
            r4.notifyAll()     // Catch:{ all -> 0x0042 }
            if (r2 != 0) goto L_0x001d
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            boolean r5 = r4.isFlushNeeded(r5)
            if (r5 == 0) goto L_0x001c
            r4.doFlush()
        L_0x001c:
            return
        L_0x001d:
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            r4.sendFrame(r2)
            boolean r3 = r2.isPingFrame()
            if (r3 != 0) goto L_0x003a
            boolean r2 = r2.isPongFrame()
            if (r2 == 0) goto L_0x002e
            goto L_0x003a
        L_0x002e:
            boolean r2 = r4.isFlushNeeded(r5)
            if (r2 != 0) goto L_0x0035
            goto L_0x0004
        L_0x0035:
            long r0 = r4.flushIfLongInterval(r0)
            goto L_0x0004
        L_0x003a:
            r4.doFlush()
            long r0 = java.lang.System.currentTimeMillis()
            goto L_0x0004
        L_0x0042:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            goto L_0x0046
        L_0x0045:
            throw r5
        L_0x0046:
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.WritingThread.sendFrames(boolean):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:10|(2:12|(3:14|15|16)(2:17|18))|19|20|(2:22|23)(2:24|(2:26|(3:28|29|30)(3:31|32|33))(2:34|35))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0023 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0027 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int waitForFrames() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.mStopRequested     // Catch:{ all -> 0x003e }
            r1 = 1
            if (r0 == 0) goto L_0x0008
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            return r1
        L_0x0008:
            com.helpshift.websockets.WebSocketFrame r0 = r4.mCloseFrame     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            return r1
        L_0x000e:
            java.util.LinkedList<com.helpshift.websockets.WebSocketFrame> r0 = r4.mFrames     // Catch:{ all -> 0x003e }
            int r0 = r0.size()     // Catch:{ all -> 0x003e }
            r2 = 3
            r3 = 0
            if (r0 != 0) goto L_0x0023
            boolean r0 = r4.mFlushNeeded     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0020
            r4.mFlushNeeded = r3     // Catch:{ all -> 0x003e }
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            return r2
        L_0x0020:
            r4.wait()     // Catch:{ InterruptedException -> 0x0023 }
        L_0x0023:
            boolean r0 = r4.mStopRequested     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0029
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            return r1
        L_0x0029:
            java.util.LinkedList<com.helpshift.websockets.WebSocketFrame> r0 = r4.mFrames     // Catch:{ all -> 0x003e }
            int r0 = r0.size()     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x003c
            boolean r0 = r4.mFlushNeeded     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0039
            r4.mFlushNeeded = r3     // Catch:{ all -> 0x003e }
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            return r2
        L_0x0039:
            r0 = 2
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            return r0
        L_0x003c:
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            return r3
        L_0x003e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.WritingThread.waitForFrames():int");
    }

    public void queueFlush() {
        synchronized (this) {
            this.mFlushNeeded = true;
            notifyAll();
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:33:0x0001, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean queueFrame(com.helpshift.websockets.WebSocketFrame r3) {
        /*
            r2 = this;
            monitor-enter(r2)
        L_0x0001:
            boolean r0 = r2.mStopped     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0008
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0043 }
            return r3
        L_0x0008:
            boolean r0 = r2.mStopRequested     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x002e
            com.helpshift.websockets.WebSocketFrame r0 = r2.mCloseFrame     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0011
            goto L_0x002e
        L_0x0011:
            boolean r0 = r3.isControlFrame()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0018
            goto L_0x002e
        L_0x0018:
            com.helpshift.websockets.WebSocket r0 = r2.mWebSocket     // Catch:{ all -> 0x0043 }
            int r0 = r0.getFrameQueueSize()     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x0021
            goto L_0x002e
        L_0x0021:
            java.util.LinkedList<com.helpshift.websockets.WebSocketFrame> r1 = r2.mFrames     // Catch:{ all -> 0x0043 }
            int r1 = r1.size()     // Catch:{ all -> 0x0043 }
            if (r1 >= r0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            r2.wait()     // Catch:{ InterruptedException -> 0x0001 }
            goto L_0x0001
        L_0x002e:
            boolean r0 = isHighPriorityFrame(r3)     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0038
            r2.addHighPriorityFrame(r3)     // Catch:{ all -> 0x0043 }
            goto L_0x003d
        L_0x0038:
            java.util.LinkedList<com.helpshift.websockets.WebSocketFrame> r0 = r2.mFrames     // Catch:{ all -> 0x0043 }
            r0.addLast(r3)     // Catch:{ all -> 0x0043 }
        L_0x003d:
            r2.notifyAll()     // Catch:{ all -> 0x0043 }
            monitor-exit(r2)     // Catch:{ all -> 0x0043 }
            r3 = 1
            return r3
        L_0x0043:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0043 }
            goto L_0x0047
        L_0x0046:
            throw r3
        L_0x0047:
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.WritingThread.queueFrame(com.helpshift.websockets.WebSocketFrame):boolean");
    }

    public void requestStop() {
        synchronized (this) {
            this.mStopRequested = true;
            notifyAll();
        }
    }

    public void runMain() {
        try {
            main();
        } catch (Throwable th) {
            WebSocketError webSocketError = WebSocketError.UNEXPECTED_ERROR_IN_WRITING_THREAD;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("An uncaught throwable was detected in the writing thread: ");
            outline24.append(th.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, outline24.toString(), th);
            ListenerManager listenerManager = this.mWebSocket.getListenerManager();
            listenerManager.callOnError(webSocketException);
            listenerManager.callOnUnexpectedError(webSocketException);
        }
        synchronized (this) {
            this.mStopped = true;
            notifyAll();
        }
        notifyFinished();
    }
}
