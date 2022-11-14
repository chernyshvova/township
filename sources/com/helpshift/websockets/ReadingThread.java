package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.websockets.StateManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ReadingThread extends WebSocketThread {
    public long mCloseDelay;
    public WebSocketFrame mCloseFrame;
    public Object mCloseLock = new Object();
    public CloseTask mCloseTask;
    public Timer mCloseTimer;
    public List<WebSocketFrame> mContinuation = new ArrayList();
    public boolean mNotWaitForCloseFrame;
    public final PerMessageCompressionExtension mPMCE;
    public boolean mStopRequested;

    /* renamed from: com.helpshift.websockets.ReadingThread$1 */
    public static /* synthetic */ class C28301 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$websockets$WebSocketError;

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.helpshift.websockets.WebSocketError[] r0 = com.helpshift.websockets.WebSocketError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$websockets$WebSocketError = r0
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.INSUFFICENT_DATA     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 19
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x0019 }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.INVALID_PAYLOAD_LENGTH     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 20
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x0022 }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.NO_MORE_FRAME     // Catch:{ NoSuchFieldError -> 0x0022 }
                r1 = 47
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x002b }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.TOO_LONG_PAYLOAD     // Catch:{ NoSuchFieldError -> 0x002b }
                r1 = 21
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x0034 }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.INSUFFICIENT_MEMORY_FOR_PAYLOAD     // Catch:{ NoSuchFieldError -> 0x0034 }
                r1 = 22
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x003d }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.NON_ZERO_RESERVED_BITS     // Catch:{ NoSuchFieldError -> 0x003d }
                r1 = 27
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x0046 }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.UNEXPECTED_RESERVED_BIT     // Catch:{ NoSuchFieldError -> 0x0046 }
                r1 = 28
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x0050 }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.UNKNOWN_OPCODE     // Catch:{ NoSuchFieldError -> 0x0050 }
                r1 = 30
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x005a }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.FRAME_MASKED     // Catch:{ NoSuchFieldError -> 0x005a }
                r1 = 29
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.FRAGMENTED_CONTROL_FRAME     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1 = 31
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x006e }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.UNEXPECTED_CONTINUATION_FRAME     // Catch:{ NoSuchFieldError -> 0x006e }
                r1 = 32
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.CONTINUATION_NOT_CLOSED     // Catch:{ NoSuchFieldError -> 0x0078 }
                r1 = 33
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x0082 }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.TOO_LONG_CONTROL_FRAME_PAYLOAD     // Catch:{ NoSuchFieldError -> 0x0082 }
                r1 = 34
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x008c }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.INTERRUPTED_IN_READING     // Catch:{ NoSuchFieldError -> 0x008c }
                r1 = 23
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                int[] r0 = $SwitchMap$com$helpshift$websockets$WebSocketError     // Catch:{ NoSuchFieldError -> 0x0096 }
                com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.IO_ERROR_IN_READING     // Catch:{ NoSuchFieldError -> 0x0096 }
                r1 = 24
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.ReadingThread.C28301.<clinit>():void");
        }
    }

    public class CloseTask extends TimerTask {
        public CloseTask() {
        }

        public void run() {
            try {
                ReadingThread.this.mWebSocket.getSocket().close();
            } catch (Throwable unused) {
            }
        }
    }

    public ReadingThread(WebSocket webSocket) {
        super("ReadingThread", webSocket, ThreadType.READING_THREAD);
        this.mPMCE = webSocket.getPerMessageCompressionExtension();
    }

    private void callOnBinaryMessage(byte[] bArr) {
        this.mWebSocket.getListenerManager().callOnBinaryMessage(bArr);
    }

    private void callOnError(WebSocketException webSocketException) {
        this.mWebSocket.getListenerManager().callOnError(webSocketException);
    }

    private void callOnTextMessage(byte[] bArr) {
        try {
            callOnTextMessage(Misc.toStringUTF8(bArr));
        } catch (Throwable th) {
            WebSocketError webSocketError = WebSocketError.TEXT_MESSAGE_CONSTRUCTION_ERROR;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to convert payload data into a string: ");
            outline24.append(th.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, outline24.toString(), th);
            callOnError(webSocketException);
            this.mWebSocket.getListenerManager().callOnTextMessageError(webSocketException, bArr);
        }
    }

    private void cancelClose() {
        synchronized (this.mCloseLock) {
            cancelCloseTask();
        }
    }

    private void cancelCloseTask() {
        Timer timer = this.mCloseTimer;
        if (timer != null) {
            timer.cancel();
            this.mCloseTimer = null;
        }
        CloseTask closeTask = this.mCloseTask;
        if (closeTask != null) {
            closeTask.cancel();
            this.mCloseTask = null;
        }
    }

    private byte[] concatenatePayloads(List<WebSocketFrame> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (WebSocketFrame payload : list) {
                byte[] payload2 = payload.getPayload();
                if (payload2 != null) {
                    if (payload2.length != 0) {
                        byteArrayOutputStream.write(payload2);
                    }
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException | OutOfMemoryError e) {
            WebSocketError webSocketError = WebSocketError.MESSAGE_CONSTRUCTION_ERROR;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to concatenate payloads of multiple frames to construct a message: ");
            outline24.append(e.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, outline24.toString(), e);
            callOnError(webSocketException);
            this.mWebSocket.getListenerManager().callOnMessageError(webSocketException, list);
            this.mWebSocket.sendFrame(WebSocketFrame.createCloseFrame(1009, webSocketException.getMessage()));
            return null;
        }
    }

    private WebSocketFrame createCloseFrame(WebSocketException webSocketException) {
        int ordinal = webSocketException.getError().ordinal();
        int i = 1008;
        if (ordinal != 47) {
            switch (ordinal) {
                case 19:
                case 20:
                    break;
                case 21:
                case 22:
                    i = 1009;
                    break;
                case 23:
                case 24:
                    break;
                default:
                    switch (ordinal) {
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                            break;
                    }
            }
        }
        i = 1002;
        return WebSocketFrame.createCloseFrame(i, webSocketException.getMessage());
    }

    private byte[] decompress(byte[] bArr) {
        try {
            return this.mPMCE.decompress(bArr);
        } catch (WebSocketException e) {
            callOnError(e);
            this.mWebSocket.getListenerManager().callOnMessageDecompressionError(e, bArr);
            this.mWebSocket.sendFrame(WebSocketFrame.createCloseFrame(1003, e.getMessage()));
            return null;
        }
    }

    private byte[] getMessage(List<WebSocketFrame> list) {
        byte[] concatenatePayloads = concatenatePayloads(this.mContinuation);
        if (concatenatePayloads == null) {
            return null;
        }
        return (this.mPMCE == null || !list.get(0).getRsv1()) ? concatenatePayloads : decompress(concatenatePayloads);
    }

    private boolean handleBinaryFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnBinaryFrame(webSocketFrame);
        if (!webSocketFrame.getFin()) {
            this.mContinuation.add(webSocketFrame);
            return true;
        }
        callOnBinaryMessage(getMessage(webSocketFrame));
        return true;
    }

    private boolean handleCloseFrame(WebSocketFrame webSocketFrame) {
        boolean z;
        StateManager stateManager = this.mWebSocket.getStateManager();
        this.mCloseFrame = webSocketFrame;
        synchronized (stateManager) {
            WebSocketState state = stateManager.getState();
            if (state == WebSocketState.CLOSING || state == WebSocketState.CLOSED) {
                z = false;
            } else {
                stateManager.changeToClosing(StateManager.CloseInitiator.SERVER);
                this.mWebSocket.sendFrame(webSocketFrame);
                z = true;
            }
        }
        if (z) {
            this.mWebSocket.getListenerManager().callOnStateChanged(WebSocketState.CLOSING);
        }
        this.mWebSocket.getListenerManager().callOnCloseFrame(webSocketFrame);
        return false;
    }

    private boolean handleContinuationFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnContinuationFrame(webSocketFrame);
        this.mContinuation.add(webSocketFrame);
        if (!webSocketFrame.getFin()) {
            return true;
        }
        byte[] message = getMessage(this.mContinuation);
        if (message == null) {
            return false;
        }
        if (this.mContinuation.get(0).isTextFrame()) {
            callOnTextMessage(message);
        } else {
            callOnBinaryMessage(message);
        }
        this.mContinuation.clear();
        return true;
    }

    private boolean handleFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnFrame(webSocketFrame);
        int opcode = webSocketFrame.getOpcode();
        if (opcode == 0) {
            return handleContinuationFrame(webSocketFrame);
        }
        if (opcode == 1) {
            return handleTextFrame(webSocketFrame);
        }
        if (opcode == 2) {
            return handleBinaryFrame(webSocketFrame);
        }
        switch (opcode) {
            case 8:
                return handleCloseFrame(webSocketFrame);
            case 9:
                return handlePingFrame(webSocketFrame);
            case 10:
                return handlePongFrame(webSocketFrame);
            default:
                return true;
        }
    }

    private boolean handlePingFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnPingFrame(webSocketFrame);
        this.mWebSocket.sendFrame(WebSocketFrame.createPongFrame(webSocketFrame.getPayload()));
        return true;
    }

    private boolean handlePongFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnPongFrame(webSocketFrame);
        return true;
    }

    private boolean handleTextFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnTextFrame(webSocketFrame);
        if (!webSocketFrame.getFin()) {
            this.mContinuation.add(webSocketFrame);
            return true;
        }
        callOnTextMessage(getMessage(webSocketFrame));
        return true;
    }

    private void main() {
        this.mWebSocket.onReadingThreadStarted();
        while (true) {
            synchronized (this) {
                if (!this.mStopRequested) {
                    WebSocketFrame readFrame = readFrame();
                    if (readFrame != null) {
                        if (!handleFrame(readFrame)) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        waitForCloseFrame();
        cancelClose();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0026 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.helpshift.websockets.WebSocketFrame readFrame() {
        /*
            r7 = this;
            r0 = 0
            com.helpshift.websockets.WebSocket r1 = r7.mWebSocket     // Catch:{ InterruptedIOException -> 0x0040, IOException -> 0x0019, WebSocketException -> 0x0015 }
            com.helpshift.websockets.WebSocketInputStream r1 = r1.getInput()     // Catch:{ InterruptedIOException -> 0x0040, IOException -> 0x0019, WebSocketException -> 0x0015 }
            com.helpshift.websockets.WebSocketFrame r1 = r1.readFrame()     // Catch:{ InterruptedIOException -> 0x0040, IOException -> 0x0019, WebSocketException -> 0x0015 }
            r7.verifyFrame(r1)     // Catch:{ InterruptedIOException -> 0x0013, IOException -> 0x0011, WebSocketException -> 0x000f }
            return r1
        L_0x000f:
            r2 = move-exception
            goto L_0x0061
        L_0x0011:
            r2 = move-exception
            goto L_0x001c
        L_0x0013:
            r2 = move-exception
            goto L_0x0043
        L_0x0015:
            r1 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x0061
        L_0x0019:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x001c:
            boolean r3 = r7.mStopRequested
            if (r3 == 0) goto L_0x0027
            boolean r3 = r7.isInterrupted()
            if (r3 == 0) goto L_0x0027
            return r0
        L_0x0027:
            com.helpshift.websockets.WebSocketException r3 = new com.helpshift.websockets.WebSocketException
            com.helpshift.websockets.WebSocketError r4 = com.helpshift.websockets.WebSocketError.IO_ERROR_IN_READING
            java.lang.String r5 = "An I/O error occurred while a frame was being read from the web socket: "
            java.lang.StringBuilder r5 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r5)
            java.lang.String r6 = r2.getMessage()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r3.<init>(r4, r5, r2)
            goto L_0x0060
        L_0x0040:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x0043:
            boolean r3 = r7.mStopRequested
            if (r3 == 0) goto L_0x0048
            return r0
        L_0x0048:
            com.helpshift.websockets.WebSocketException r3 = new com.helpshift.websockets.WebSocketException
            com.helpshift.websockets.WebSocketError r4 = com.helpshift.websockets.WebSocketError.INTERRUPTED_IN_READING
            java.lang.String r5 = "Interruption occurred while a frame was being read from the web socket: "
            java.lang.StringBuilder r5 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r5)
            java.lang.String r6 = r2.getMessage()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r3.<init>(r4, r5, r2)
        L_0x0060:
            r2 = r3
        L_0x0061:
            boolean r3 = r2 instanceof com.helpshift.websockets.NoMoreFrameException
            r4 = 1
            if (r3 == 0) goto L_0x0072
            r7.mNotWaitForCloseFrame = r4
            com.helpshift.websockets.WebSocket r3 = r7.mWebSocket
            boolean r3 = r3.isMissingCloseFrameAllowed()
            if (r3 == 0) goto L_0x0072
            r4 = 0
        L_0x0072:
            if (r4 == 0) goto L_0x0080
            r7.callOnError(r2)
            com.helpshift.websockets.WebSocket r3 = r7.mWebSocket
            com.helpshift.websockets.ListenerManager r3 = r3.getListenerManager()
            r3.callOnFrameError(r2, r1)
        L_0x0080:
            com.helpshift.websockets.WebSocketFrame r1 = r7.createCloseFrame(r2)
            com.helpshift.websockets.WebSocket r2 = r7.mWebSocket
            r2.sendFrame(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.ReadingThread.readFrame():com.helpshift.websockets.WebSocketFrame");
    }

    private void scheduleClose() {
        synchronized (this.mCloseLock) {
            cancelCloseTask();
            scheduleCloseTask();
        }
    }

    private void scheduleCloseTask() {
        this.mCloseTask = new CloseTask();
        Timer timer = new Timer("ReadingThreadCloseTimer");
        this.mCloseTimer = timer;
        timer.schedule(this.mCloseTask, this.mCloseDelay);
    }

    private void verifyFrame(WebSocketFrame webSocketFrame) throws WebSocketException {
        verifyReservedBits(webSocketFrame);
        verifyFrameOpcode(webSocketFrame);
        verifyFrameMask(webSocketFrame);
        verifyFrameFragmentation(webSocketFrame);
        verifyFrameSize(webSocketFrame);
    }

    private void verifyFrameFragmentation(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (!webSocketFrame.isControlFrame()) {
            boolean z = this.mContinuation.size() != 0;
            if (webSocketFrame.isContinuationFrame()) {
                if (!z) {
                    throw new WebSocketException(WebSocketError.UNEXPECTED_CONTINUATION_FRAME, "A continuation frame was detected although a continuation had not started.");
                }
            } else if (z) {
                throw new WebSocketException(WebSocketError.CONTINUATION_NOT_CLOSED, "A non-control frame was detected although the existing continuation had not been closed.");
            }
        } else if (!webSocketFrame.getFin()) {
            throw new WebSocketException(WebSocketError.FRAGMENTED_CONTROL_FRAME, "A control frame is fragmented.");
        }
    }

    private void verifyFrameMask(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (webSocketFrame.getMask()) {
            throw new WebSocketException(WebSocketError.FRAME_MASKED, "A frame from the server is masked.");
        }
    }

    private void verifyFrameOpcode(WebSocketFrame webSocketFrame) throws WebSocketException {
        int opcode = webSocketFrame.getOpcode();
        if (opcode != 0 && opcode != 1 && opcode != 2) {
            switch (opcode) {
                case 8:
                case 9:
                case 10:
                    return;
                default:
                    if (!this.mWebSocket.isExtended()) {
                        WebSocketError webSocketError = WebSocketError.UNKNOWN_OPCODE;
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("A frame has an unknown opcode: 0x");
                        outline24.append(Integer.toHexString(webSocketFrame.getOpcode()));
                        throw new WebSocketException(webSocketError, outline24.toString());
                    }
                    return;
            }
        }
    }

    private void verifyFrameSize(WebSocketFrame webSocketFrame) throws WebSocketException {
        byte[] payload;
        if (webSocketFrame.isControlFrame() && (payload = webSocketFrame.getPayload()) != null && 125 < payload.length) {
            WebSocketError webSocketError = WebSocketError.TOO_LONG_CONTROL_FRAME_PAYLOAD;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("The payload size of a control frame exceeds the maximum size (125 bytes): ");
            outline24.append(payload.length);
            throw new WebSocketException(webSocketError, outline24.toString());
        }
    }

    private void verifyReservedBit1(WebSocketFrame webSocketFrame) throws WebSocketException {
        if ((this.mPMCE == null || !verifyReservedBit1ForPMCE(webSocketFrame)) && webSocketFrame.getRsv1()) {
            throw new WebSocketException(WebSocketError.UNEXPECTED_RESERVED_BIT, "The RSV1 bit of a frame is set unexpectedly.");
        }
    }

    private boolean verifyReservedBit1ForPMCE(WebSocketFrame webSocketFrame) throws WebSocketException {
        return webSocketFrame.isTextFrame() || webSocketFrame.isBinaryFrame();
    }

    private void verifyReservedBit2(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (webSocketFrame.getRsv2()) {
            throw new WebSocketException(WebSocketError.UNEXPECTED_RESERVED_BIT, "The RSV2 bit of a frame is set unexpectedly.");
        }
    }

    private void verifyReservedBit3(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (webSocketFrame.getRsv3()) {
            throw new WebSocketException(WebSocketError.UNEXPECTED_RESERVED_BIT, "The RSV3 bit of a frame is set unexpectedly.");
        }
    }

    private void verifyReservedBits(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (!this.mWebSocket.isExtended()) {
            verifyReservedBit1(webSocketFrame);
            verifyReservedBit2(webSocketFrame);
            verifyReservedBit3(webSocketFrame);
        }
    }

    private void waitForCloseFrame() {
        if (!this.mNotWaitForCloseFrame && this.mCloseFrame == null) {
            scheduleClose();
            do {
                try {
                    WebSocketFrame readFrame = this.mWebSocket.getInput().readFrame();
                    if (readFrame.isCloseFrame()) {
                        this.mCloseFrame = readFrame;
                        return;
                    }
                } catch (Throwable unused) {
                    return;
                }
            } while (!isInterrupted());
        }
    }

    public void requestStop(long j) {
        synchronized (this) {
            if (!this.mStopRequested) {
                this.mStopRequested = true;
                interrupt();
                this.mCloseDelay = j;
                scheduleClose();
            }
        }
    }

    public void runMain() {
        try {
            main();
        } catch (Throwable th) {
            WebSocketError webSocketError = WebSocketError.UNEXPECTED_ERROR_IN_READING_THREAD;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("An uncaught throwable was detected in the reading thread: ");
            outline24.append(th.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, outline24.toString(), th);
            ListenerManager listenerManager = this.mWebSocket.getListenerManager();
            listenerManager.callOnError(webSocketException);
            listenerManager.callOnUnexpectedError(webSocketException);
        }
        this.mWebSocket.onReadingThreadFinished(this.mCloseFrame);
    }

    private byte[] getMessage(WebSocketFrame webSocketFrame) {
        byte[] payload = webSocketFrame.getPayload();
        return (this.mPMCE == null || !webSocketFrame.getRsv1()) ? payload : decompress(payload);
    }

    private void callOnTextMessage(String str) {
        this.mWebSocket.getListenerManager().callOnTextMessage(str);
    }
}
