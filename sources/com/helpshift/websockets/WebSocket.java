package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class WebSocket {
    public static final long DEFAULT_CLOSE_DELAY = 10000;
    public List<WebSocketExtension> mAgreedExtensions;
    public String mAgreedProtocol;
    public boolean mAutoFlush = true;
    public WebSocketFrame mClientCloseFrame;
    public boolean mExtended;
    public int mFrameQueueSize;
    public HandshakeBuilder mHandshakeBuilder;
    public WebSocketInputStream mInput;
    public final ListenerManager mListenerManager;
    public int mMaxPayloadSize;
    public boolean mMissingCloseFrameAllowed = true;
    public boolean mOnConnectedCalled;
    public Object mOnConnectedCalledLock = new Object();
    public WebSocketOutputStream mOutput;
    public PerMessageCompressionExtension mPerMessageCompressionExtension;
    public final PingSender mPingSender;
    public final PongSender mPongSender;
    public ReadingThread mReadingThread;
    public boolean mReadingThreadFinished;
    public boolean mReadingThreadStarted;
    public WebSocketFrame mServerCloseFrame;
    public Map<String, List<String>> mServerHeaders;
    public final SocketConnector mSocketConnector;
    public final StateManager mStateManager;
    public final Object mThreadsLock = new Object();
    public final WebSocketFactory mWebSocketFactory;
    public WritingThread mWritingThread;
    public boolean mWritingThreadFinished;
    public boolean mWritingThreadStarted;

    /* renamed from: com.helpshift.websockets.WebSocket$1 */
    public static /* synthetic */ class C28311 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$websockets$WebSocketState;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.helpshift.websockets.WebSocketState[] r0 = com.helpshift.websockets.WebSocketState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$websockets$WebSocketState = r0
                com.helpshift.websockets.WebSocketState r1 = com.helpshift.websockets.WebSocketState.CREATED     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 0
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketState     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.websockets.WebSocketState r1 = com.helpshift.websockets.WebSocketState.OPEN     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.WebSocket.C28311.<clinit>():void");
        }
    }

    public WebSocket(WebSocketFactory webSocketFactory, boolean z, String str, String str2, String str3, SocketConnector socketConnector) {
        this.mWebSocketFactory = webSocketFactory;
        this.mSocketConnector = socketConnector;
        this.mStateManager = new StateManager();
        this.mHandshakeBuilder = new HandshakeBuilder(z, str, str2, str3);
        this.mListenerManager = new ListenerManager(this);
        this.mPingSender = new PingSender(this, new CounterPayloadGenerator());
        this.mPongSender = new PongSender(this, new CounterPayloadGenerator());
    }

    private void callOnConnectedIfNotYet() {
        synchronized (this.mOnConnectedCalledLock) {
            if (!this.mOnConnectedCalled) {
                this.mOnConnectedCalled = true;
                this.mListenerManager.callOnConnected(this.mServerHeaders);
            }
        }
    }

    private void changeStateOnConnect() throws WebSocketException {
        synchronized (this.mStateManager) {
            if (this.mStateManager.getState() == WebSocketState.CREATED) {
                this.mStateManager.setState(WebSocketState.CONNECTING);
            } else {
                throw new WebSocketException(WebSocketError.NOT_IN_CREATED_STATE, "The current state of the WebSocket is not CREATED.");
            }
        }
        this.mListenerManager.callOnStateChanged(WebSocketState.CONNECTING);
    }

    private PerMessageCompressionExtension findAgreedPerMessageCompressionExtension() {
        List<WebSocketExtension> list = this.mAgreedExtensions;
        if (list == null) {
            return null;
        }
        for (WebSocketExtension next : list) {
            if (next instanceof PerMessageCompressionExtension) {
                return (PerMessageCompressionExtension) next;
            }
        }
        return null;
    }

    private void finishAsynchronously() {
        FinishThread finishThread = new FinishThread(this);
        finishThread.callOnThreadCreated();
        finishThread.start();
    }

    private boolean isInState(WebSocketState webSocketState) {
        boolean z;
        synchronized (this.mStateManager) {
            z = this.mStateManager.getState() == webSocketState;
        }
        return z;
    }

    private void onThreadsFinished() {
        finish();
    }

    private void onThreadsStarted() {
        this.mPingSender.start();
        this.mPongSender.start();
    }

    private WebSocketInputStream openInputStream(Socket socket) throws WebSocketException {
        try {
            return new WebSocketInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            WebSocketError webSocketError = WebSocketError.SOCKET_INPUT_STREAM_FAILURE;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to get the input stream of the raw socket: ");
            outline24.append(e.getMessage());
            throw new WebSocketException(webSocketError, outline24.toString(), e);
        }
    }

    private WebSocketOutputStream openOutputStream(Socket socket) throws WebSocketException {
        try {
            return new WebSocketOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        } catch (IOException e) {
            WebSocketError webSocketError = WebSocketError.SOCKET_OUTPUT_STREAM_FAILURE;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to get the output stream from the raw socket: ");
            outline24.append(e.getMessage());
            throw new WebSocketException(webSocketError, outline24.toString(), e);
        }
    }

    private Map<String, List<String>> readHandshake(WebSocketInputStream webSocketInputStream, String str) throws WebSocketException {
        return new HandshakeReader(this).readHandshake(webSocketInputStream, str);
    }

    private Map<String, List<String>> shakeHands() throws WebSocketException {
        Socket socket = this.mSocketConnector.getSocket();
        WebSocketInputStream openInputStream = openInputStream(socket);
        WebSocketOutputStream openOutputStream = openOutputStream(socket);
        byte[] bArr = new byte[16];
        Misc.nextBytes(bArr);
        String encode = Base64.encode(bArr);
        writeHandshake(openOutputStream, encode);
        Map<String, List<String>> readHandshake = readHandshake(openInputStream, encode);
        this.mInput = openInputStream;
        this.mOutput = openOutputStream;
        return readHandshake;
    }

    private List<WebSocketFrame> splitIfNecessary(WebSocketFrame webSocketFrame) {
        return WebSocketFrame.splitIfNecessary(webSocketFrame, this.mMaxPayloadSize, this.mPerMessageCompressionExtension);
    }

    private void startThreads() {
        ReadingThread readingThread = new ReadingThread(this);
        WritingThread writingThread = new WritingThread(this);
        synchronized (this.mThreadsLock) {
            this.mReadingThread = readingThread;
            this.mWritingThread = writingThread;
        }
        readingThread.callOnThreadCreated();
        writingThread.callOnThreadCreated();
        readingThread.start();
        writingThread.start();
    }

    private void stopThreads(long j) {
        ReadingThread readingThread;
        WritingThread writingThread;
        synchronized (this.mThreadsLock) {
            readingThread = this.mReadingThread;
            writingThread = this.mWritingThread;
            this.mReadingThread = null;
            this.mWritingThread = null;
        }
        if (readingThread != null) {
            readingThread.requestStop(j);
        }
        if (writingThread != null) {
            writingThread.requestStop();
        }
    }

    private void writeHandshake(WebSocketOutputStream webSocketOutputStream, String str) throws WebSocketException {
        this.mHandshakeBuilder.setKey(str);
        String buildRequestLine = this.mHandshakeBuilder.buildRequestLine();
        List<String[]> buildHeaders = this.mHandshakeBuilder.buildHeaders();
        String build = HandshakeBuilder.build(buildRequestLine, buildHeaders);
        this.mListenerManager.callOnSendingHandshake(buildRequestLine, buildHeaders);
        try {
            webSocketOutputStream.write(build);
            webSocketOutputStream.flush();
        } catch (IOException e) {
            WebSocketError webSocketError = WebSocketError.OPENING_HAHDSHAKE_REQUEST_FAILURE;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to send an opening handshake request to the server: ");
            outline24.append(e.getMessage());
            throw new WebSocketException(webSocketError, outline24.toString(), e);
        }
    }

    public WebSocket addExtension(String str) {
        this.mHandshakeBuilder.addExtension(str);
        return this;
    }

    public WebSocket addHeader(String str, String str2) {
        this.mHandshakeBuilder.addHeader(str, str2);
        return this;
    }

    public WebSocket addListener(WebSocketListener webSocketListener) {
        this.mListenerManager.addListener(webSocketListener);
        return this;
    }

    public WebSocket addListeners(List<WebSocketListener> list) {
        this.mListenerManager.addListeners(list);
        return this;
    }

    public WebSocket addProtocol(String str) {
        this.mHandshakeBuilder.addProtocol(str);
        return this;
    }

    public WebSocket clearExtensions() {
        this.mHandshakeBuilder.clearExtensions();
        return this;
    }

    public WebSocket clearHeaders() {
        this.mHandshakeBuilder.clearHeaders();
        return this;
    }

    public WebSocket clearListeners() {
        this.mListenerManager.clearListeners();
        return this;
    }

    public WebSocket clearProtocols() {
        this.mHandshakeBuilder.clearProtocols();
        return this;
    }

    public WebSocket clearUserInfo() {
        this.mHandshakeBuilder.clearUserInfo();
        return this;
    }

    public WebSocket connect() throws WebSocketException {
        changeStateOnConnect();
        try {
            this.mSocketConnector.connect();
            this.mServerHeaders = shakeHands();
            this.mPerMessageCompressionExtension = findAgreedPerMessageCompressionExtension();
            this.mStateManager.setState(WebSocketState.OPEN);
            this.mListenerManager.callOnStateChanged(WebSocketState.OPEN);
            startThreads();
            return this;
        } catch (WebSocketException e) {
            this.mSocketConnector.closeSilently();
            this.mStateManager.setState(WebSocketState.CLOSED);
            this.mListenerManager.callOnStateChanged(WebSocketState.CLOSED);
            throw e;
        }
    }

    public WebSocket disconnect() {
        return disconnect(1000, (String) null);
    }

    public void finalize() throws Throwable {
        if (isInState(WebSocketState.CREATED)) {
            finish();
        }
        super.finalize();
    }

    public void finish() {
        this.mPingSender.stop();
        this.mPongSender.stop();
        try {
            this.mSocketConnector.getSocket().close();
        } catch (Throwable unused) {
        }
        synchronized (this.mStateManager) {
            this.mStateManager.setState(WebSocketState.CLOSED);
        }
        this.mListenerManager.callOnStateChanged(WebSocketState.CLOSED);
        this.mListenerManager.callOnDisconnected(this.mServerCloseFrame, this.mClientCloseFrame, this.mStateManager.getClosedByServer());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r0 = r3.mWritingThread;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r0 == null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r0.queueFlush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.helpshift.websockets.WebSocket flush() {
        /*
            r3 = this;
            com.helpshift.websockets.StateManager r0 = r3.mStateManager
            monitor-enter(r0)
            com.helpshift.websockets.StateManager r1 = r3.mStateManager     // Catch:{ all -> 0x001c }
            com.helpshift.websockets.WebSocketState r1 = r1.getState()     // Catch:{ all -> 0x001c }
            com.helpshift.websockets.WebSocketState r2 = com.helpshift.websockets.WebSocketState.OPEN     // Catch:{ all -> 0x001c }
            if (r1 == r2) goto L_0x0013
            com.helpshift.websockets.WebSocketState r2 = com.helpshift.websockets.WebSocketState.CLOSING     // Catch:{ all -> 0x001c }
            if (r1 == r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            return r3
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            com.helpshift.websockets.WritingThread r0 = r3.mWritingThread
            if (r0 == 0) goto L_0x001b
            r0.queueFlush()
        L_0x001b:
            return r3
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.WebSocket.flush():com.helpshift.websockets.WebSocket");
    }

    public List<WebSocketExtension> getAgreedExtensions() {
        return this.mAgreedExtensions;
    }

    public String getAgreedProtocol() {
        return this.mAgreedProtocol;
    }

    public int getFrameQueueSize() {
        return this.mFrameQueueSize;
    }

    public HandshakeBuilder getHandshakeBuilder() {
        return this.mHandshakeBuilder;
    }

    public WebSocketInputStream getInput() {
        return this.mInput;
    }

    public ListenerManager getListenerManager() {
        return this.mListenerManager;
    }

    public int getMaxPayloadSize() {
        return this.mMaxPayloadSize;
    }

    public WebSocketOutputStream getOutput() {
        return this.mOutput;
    }

    public PerMessageCompressionExtension getPerMessageCompressionExtension() {
        return this.mPerMessageCompressionExtension;
    }

    public long getPingInterval() {
        return this.mPingSender.getInterval();
    }

    public PayloadGenerator getPingPayloadGenerator() {
        return this.mPingSender.getPayloadGenerator();
    }

    public long getPongInterval() {
        return this.mPongSender.getInterval();
    }

    public PayloadGenerator getPongPayloadGenerator() {
        return this.mPongSender.getPayloadGenerator();
    }

    public Socket getSocket() {
        return this.mSocketConnector.getSocket();
    }

    public WebSocketState getState() {
        WebSocketState state;
        synchronized (this.mStateManager) {
            state = this.mStateManager.getState();
        }
        return state;
    }

    public StateManager getStateManager() {
        return this.mStateManager;
    }

    public URI getURI() {
        return this.mHandshakeBuilder.getURI();
    }

    public boolean isAutoFlush() {
        return this.mAutoFlush;
    }

    public boolean isExtended() {
        return this.mExtended;
    }

    public boolean isMissingCloseFrameAllowed() {
        return this.mMissingCloseFrameAllowed;
    }

    public boolean isOpen() {
        return isInState(WebSocketState.OPEN);
    }

    public void onReadingThreadFinished(WebSocketFrame webSocketFrame) {
        synchronized (this.mThreadsLock) {
            this.mReadingThreadFinished = true;
            this.mServerCloseFrame = webSocketFrame;
            if (this.mWritingThreadFinished) {
                onThreadsFinished();
            }
        }
    }

    public void onReadingThreadStarted() {
        boolean z;
        synchronized (this.mThreadsLock) {
            this.mReadingThreadStarted = true;
            z = this.mWritingThreadStarted;
        }
        callOnConnectedIfNotYet();
        if (z) {
            onThreadsStarted();
        }
    }

    public void onWritingThreadFinished(WebSocketFrame webSocketFrame) {
        synchronized (this.mThreadsLock) {
            this.mWritingThreadFinished = true;
            this.mClientCloseFrame = webSocketFrame;
            if (this.mReadingThreadFinished) {
                onThreadsFinished();
            }
        }
    }

    public void onWritingThreadStarted() {
        boolean z;
        synchronized (this.mThreadsLock) {
            this.mWritingThreadStarted = true;
            z = this.mReadingThreadStarted;
        }
        callOnConnectedIfNotYet();
        if (z) {
            onThreadsStarted();
        }
    }

    public WebSocket removeExtension(WebSocketExtension webSocketExtension) {
        this.mHandshakeBuilder.removeExtension(webSocketExtension);
        return this;
    }

    public WebSocket removeHeaders(String str) {
        this.mHandshakeBuilder.removeHeaders(str);
        return this;
    }

    public WebSocket removeListener(WebSocketListener webSocketListener) {
        this.mListenerManager.removeListener(webSocketListener);
        return this;
    }

    public WebSocket removeListeners(List<WebSocketListener> list) {
        this.mListenerManager.removeListeners(list);
        return this;
    }

    public WebSocket removeProtocol(String str) {
        this.mHandshakeBuilder.removeProtocol(str);
        return this;
    }

    public WebSocket sendBinary(byte[] bArr) {
        return sendFrame(WebSocketFrame.createBinaryFrame(bArr));
    }

    public WebSocket sendClose() {
        return sendFrame(WebSocketFrame.createCloseFrame());
    }

    public WebSocket sendContinuation() {
        return sendFrame(WebSocketFrame.createContinuationFrame());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r0 = r3.mWritingThread;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r0 != null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        r1 = splitIfNecessary(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        if (r1 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        r0.queueFrame(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        r4 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r4.hasNext() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        r0.queueFrame(r4.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.helpshift.websockets.WebSocket sendFrame(com.helpshift.websockets.WebSocketFrame r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return r3
        L_0x0003:
            com.helpshift.websockets.StateManager r0 = r3.mStateManager
            monitor-enter(r0)
            com.helpshift.websockets.StateManager r1 = r3.mStateManager     // Catch:{ all -> 0x003b }
            com.helpshift.websockets.WebSocketState r1 = r1.getState()     // Catch:{ all -> 0x003b }
            com.helpshift.websockets.WebSocketState r2 = com.helpshift.websockets.WebSocketState.OPEN     // Catch:{ all -> 0x003b }
            if (r1 == r2) goto L_0x0016
            com.helpshift.websockets.WebSocketState r2 = com.helpshift.websockets.WebSocketState.CLOSING     // Catch:{ all -> 0x003b }
            if (r1 == r2) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            com.helpshift.websockets.WritingThread r0 = r3.mWritingThread
            if (r0 != 0) goto L_0x001c
            return r3
        L_0x001c:
            java.util.List r1 = r3.splitIfNecessary(r4)
            if (r1 != 0) goto L_0x0026
            r0.queueFrame(r4)
            goto L_0x003a
        L_0x0026:
            java.util.Iterator r4 = r1.iterator()
        L_0x002a:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r4.next()
            com.helpshift.websockets.WebSocketFrame r1 = (com.helpshift.websockets.WebSocketFrame) r1
            r0.queueFrame(r1)
            goto L_0x002a
        L_0x003a:
            return r3
        L_0x003b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            goto L_0x003f
        L_0x003e:
            throw r4
        L_0x003f:
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.WebSocket.sendFrame(com.helpshift.websockets.WebSocketFrame):com.helpshift.websockets.WebSocket");
    }

    public WebSocket sendPing() {
        return sendFrame(WebSocketFrame.createPingFrame());
    }

    public WebSocket sendPong() {
        return sendFrame(WebSocketFrame.createPongFrame());
    }

    public WebSocket sendText(String str) {
        return sendFrame(WebSocketFrame.createTextFrame(str));
    }

    public void setAgreedExtensions(List<WebSocketExtension> list) {
        this.mAgreedExtensions = list;
    }

    public void setAgreedProtocol(String str) {
        this.mAgreedProtocol = str;
    }

    public WebSocket setAutoFlush(boolean z) {
        this.mAutoFlush = z;
        return this;
    }

    public WebSocket setExtended(boolean z) {
        this.mExtended = z;
        return this;
    }

    public WebSocket setFrameQueueSize(int i) throws IllegalArgumentException {
        if (i >= 0) {
            this.mFrameQueueSize = i;
            return this;
        }
        throw new IllegalArgumentException("size must not be negative.");
    }

    public WebSocket setMaxPayloadSize(int i) throws IllegalArgumentException {
        if (i >= 0) {
            this.mMaxPayloadSize = i;
            return this;
        }
        throw new IllegalArgumentException("size must not be negative.");
    }

    public WebSocket setMissingCloseFrameAllowed(boolean z) {
        this.mMissingCloseFrameAllowed = z;
        return this;
    }

    public WebSocket setPingInterval(long j) {
        this.mPingSender.setInterval(j);
        return this;
    }

    public WebSocket setPingPayloadGenerator(PayloadGenerator payloadGenerator) {
        this.mPingSender.setPayloadGenerator(payloadGenerator);
        return this;
    }

    public WebSocket setPongInterval(long j) {
        this.mPongSender.setInterval(j);
        return this;
    }

    public WebSocket setPongPayloadGenerator(PayloadGenerator payloadGenerator) {
        this.mPongSender.setPayloadGenerator(payloadGenerator);
        return this;
    }

    public WebSocket setUserInfo(String str) {
        this.mHandshakeBuilder.setUserInfo(str);
        return this;
    }

    public WebSocket disconnect(int i) {
        return disconnect(i, (String) null);
    }

    public WebSocket sendBinary(byte[] bArr, boolean z) {
        return sendFrame(WebSocketFrame.createBinaryFrame(bArr).setFin(z));
    }

    public WebSocket sendClose(int i) {
        return sendFrame(WebSocketFrame.createCloseFrame(i));
    }

    public WebSocket sendContinuation(boolean z) {
        return sendFrame(WebSocketFrame.createContinuationFrame().setFin(z));
    }

    public WebSocket sendPing(byte[] bArr) {
        return sendFrame(WebSocketFrame.createPingFrame(bArr));
    }

    public WebSocket sendPong(byte[] bArr) {
        return sendFrame(WebSocketFrame.createPongFrame(bArr));
    }

    public WebSocket sendText(String str, boolean z) {
        return sendFrame(WebSocketFrame.createTextFrame(str).setFin(z));
    }

    public WebSocket setUserInfo(String str, String str2) {
        this.mHandshakeBuilder.setUserInfo(str, str2);
        return this;
    }

    public WebSocket disconnect(String str) {
        return disconnect(1000, str);
    }

    public WebSocket sendClose(int i, String str) {
        return sendFrame(WebSocketFrame.createCloseFrame(i, str));
    }

    public WebSocket sendContinuation(String str) {
        return sendFrame(WebSocketFrame.createContinuationFrame(str));
    }

    public WebSocket sendPing(String str) {
        return sendFrame(WebSocketFrame.createPingFrame(str));
    }

    public WebSocket sendPong(String str) {
        return sendFrame(WebSocketFrame.createPongFrame(str));
    }

    public WebSocket disconnect(int i, String str) {
        return disconnect(i, str, 10000);
    }

    public WebSocket sendContinuation(String str, boolean z) {
        return sendFrame(WebSocketFrame.createContinuationFrame(str).setFin(z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        r3.mListenerManager.callOnStateChanged(com.helpshift.websockets.WebSocketState.CLOSING);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r6 >= 0) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        r6 = 10000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        stopThreads(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.helpshift.websockets.WebSocket disconnect(int r4, java.lang.String r5, long r6) {
        /*
            r3 = this;
            com.helpshift.websockets.StateManager r0 = r3.mStateManager
            monitor-enter(r0)
            com.helpshift.websockets.StateManager r1 = r3.mStateManager     // Catch:{ all -> 0x003b }
            com.helpshift.websockets.WebSocketState r1 = r1.getState()     // Catch:{ all -> 0x003b }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0036
            r2 = 2
            if (r1 == r2) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r3
        L_0x0014:
            com.helpshift.websockets.StateManager r1 = r3.mStateManager     // Catch:{ all -> 0x003b }
            com.helpshift.websockets.StateManager$CloseInitiator r2 = com.helpshift.websockets.StateManager.CloseInitiator.CLIENT     // Catch:{ all -> 0x003b }
            r1.changeToClosing(r2)     // Catch:{ all -> 0x003b }
            com.helpshift.websockets.WebSocketFrame r4 = com.helpshift.websockets.WebSocketFrame.createCloseFrame(r4, r5)     // Catch:{ all -> 0x003b }
            r3.sendFrame(r4)     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            com.helpshift.websockets.ListenerManager r4 = r3.mListenerManager
            com.helpshift.websockets.WebSocketState r5 = com.helpshift.websockets.WebSocketState.CLOSING
            r4.callOnStateChanged(r5)
            r4 = 0
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0032
            r6 = 10000(0x2710, double:4.9407E-320)
        L_0x0032:
            r3.stopThreads(r6)
            return r3
        L_0x0036:
            r3.finishAsynchronously()     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r3
        L_0x003b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.WebSocket.disconnect(int, java.lang.String, long):com.helpshift.websockets.WebSocket");
    }

    public WebSocket sendContinuation(byte[] bArr) {
        return sendFrame(WebSocketFrame.createContinuationFrame(bArr));
    }

    public WebSocket sendContinuation(byte[] bArr, boolean z) {
        return sendFrame(WebSocketFrame.createContinuationFrame(bArr).setFin(z));
    }
}
