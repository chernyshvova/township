package com.helpshift.conversation.activeconversation;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.auth.dto.WebSocketAuthData;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Device;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.websockets.HSWebSocket;
import com.helpshift.common.platform.network.websockets.IHSWebSocketListener;
import com.helpshift.conversation.dto.WSPingMessage;
import com.helpshift.conversation.dto.WSTypingActionMessage;
import com.helpshift.conversation.dto.WebSocketMessage;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import com.helpshift.websockets.PerMessageDeflateExtension;
import com.helpshift.websockets.WebSocketExtension;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LiveUpdateDM implements IHSWebSocketListener {
    public static final int MESSAGE_TYPE_EVENT = 100;
    public static final int MESSAGE_TYPE_PING = 107;
    public static final String TAG = "Helpshift_LiveUpdateDM";
    public final String MESSAGE_TYPE_PONG = "[110]";
    public final long NETWORK_PROPOGATION_DELAY = TimeUnit.SECONDS.toMillis(3);
    public final String SDK_VERSION_HEADER_KEY = "hs-sdk-ver";
    public String conversationServerId;
    public C2500F disconnectWebSocketF = new C2500F() {
        /* renamed from: f */
        public void mo33949f() {
            LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
            if (liveUpdateDM.webSocket == null) {
                return;
            }
            if (liveUpdateDM.isConnecting) {
                liveUpdateDM.shouldDisconnectOnConnect = true;
                return;
            }
            try {
                HSLogger.m3237d(LiveUpdateDM.TAG, "Disconnecting web-socket");
                LiveUpdateDM.this.webSocket.disconnect();
            } catch (Exception e) {
                HSLogger.m3242e(LiveUpdateDM.TAG, "Exception in disconnecting web-socket", e);
            }
            LiveUpdateDM.this.webSocket = null;
        }
    };
    public Domain domain;
    public boolean isAgentTyping;
    public boolean isConnecting;
    public boolean isTokenRefreshed;
    public TypingIndicatorListener listener;
    public AtomicInteger pingCount;
    public Platform platform;
    public C2500F refreshAuthTokenAndConnectF = new C2500F() {
        /* renamed from: f */
        public void mo33949f() {
            LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
            if (liveUpdateDM.listener != null) {
                liveUpdateDM.domain.getWebSocketAuthDM().refreshAuthToken();
                LiveUpdateDM liveUpdateDM2 = LiveUpdateDM.this;
                liveUpdateDM2.isTokenRefreshed = true;
                new ConnectWebSocketF(liveUpdateDM2.pingCount.incrementAndGet()).mo33949f();
            }
        }
    };
    public final String sdkVersionHeaderValue;
    public boolean shouldDisconnectOnConnect;
    public boolean socketConnected;
    public AtomicInteger startTypingId;
    public HSWebSocket webSocket;

    public class ConnectWebSocketF extends C2500F {

        /* renamed from: id */
        public final int f3333id;

        public ConnectWebSocketF(int i) {
            this.f3333id = i;
        }

        /* renamed from: f */
        public void mo33949f() {
            LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
            if (liveUpdateDM.listener != null && this.f3333id == liveUpdateDM.pingCount.get()) {
                LiveUpdateDM liveUpdateDM2 = LiveUpdateDM.this;
                if (!liveUpdateDM2.socketConnected && !liveUpdateDM2.isConnecting) {
                    WebSocketAuthData authToken = liveUpdateDM2.domain.getWebSocketAuthDM().getAuthToken();
                    if (authToken == null) {
                        LiveUpdateDM.this.scheduleConnectionRetry();
                        return;
                    }
                    HSLogger.m3237d(LiveUpdateDM.TAG, "Connecting web-socket");
                    try {
                        LiveUpdateDM.this.webSocket = new HSWebSocket.Builder(LiveUpdateDM.this.getWebSocketPath(authToken)).setConnectionTimeout((int) TimeUnit.SECONDS.toMillis(60)).addExtension(WebSocketExtension.PERMESSAGE_DEFLATE).addExtension(PerMessageDeflateExtension.CLIENT_NO_CONTEXT_TAKEOVER).addExtension(PerMessageDeflateExtension.SERVER_NO_CONTEXT_TAKEOVER).addProtocol("dirigent-pubsub-v1").addHeader("hs-sdk-ver", LiveUpdateDM.this.sdkVersionHeaderValue).setWebSocketListener(LiveUpdateDM.this).build();
                        LiveUpdateDM.this.isConnecting = true;
                        LiveUpdateDM.this.webSocket.connect();
                    } catch (Exception e) {
                        HSLogger.m3242e(LiveUpdateDM.TAG, "Exception in connecting web-socket", e);
                        LiveUpdateDM.this.scheduleConnectionRetry();
                    }
                }
            }
        }
    }

    public class HandleWebSocketMessageF extends C2500F {
        public final String message;

        public HandleWebSocketMessageF(String str) {
            this.message = str;
        }

        /* renamed from: f */
        public void mo33949f() {
            WebSocketMessage parseWebSocketMessage = LiveUpdateDM.this.platform.getResponseParser().parseWebSocketMessage(this.message);
            if (parseWebSocketMessage instanceof WSPingMessage) {
                long j = ((WSPingMessage) parseWebSocketMessage).pingWaitTimeMillis;
                LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
                liveUpdateDM.domain.runDelayedInParallel(new PingTimeoutF(liveUpdateDM.pingCount.incrementAndGet()), j + liveUpdateDM.NETWORK_PROPOGATION_DELAY);
                HSWebSocket hSWebSocket = LiveUpdateDM.this.webSocket;
                if (hSWebSocket != null) {
                    hSWebSocket.sendMessage("[110]");
                    return;
                }
                return;
            }
            LiveUpdateDM liveUpdateDM2 = LiveUpdateDM.this;
            if (liveUpdateDM2.listener != null && (parseWebSocketMessage instanceof WSTypingActionMessage)) {
                WSTypingActionMessage wSTypingActionMessage = (WSTypingActionMessage) parseWebSocketMessage;
                if (wSTypingActionMessage.isAgentTyping) {
                    liveUpdateDM2.isAgentTyping = true;
                    liveUpdateDM2.domain.runDelayedInParallel(new StartTypingTimeoutF(liveUpdateDM2.startTypingId.incrementAndGet()), wSTypingActionMessage.typingActionTimeoutMillis + liveUpdateDM2.NETWORK_PROPOGATION_DELAY);
                } else {
                    liveUpdateDM2.isAgentTyping = false;
                }
                LiveUpdateDM.this.notifyListener();
            }
        }
    }

    public class PingTimeoutF extends C2500F {
        public int pingId;

        public PingTimeoutF(int i) {
            this.pingId = i;
        }

        /* renamed from: f */
        public void mo33949f() {
            if (this.pingId == LiveUpdateDM.this.pingCount.get() && LiveUpdateDM.this.listener != null) {
                HSLogger.m3237d(LiveUpdateDM.TAG, "Ping timed out, resetting connection");
                LiveUpdateDM.this.disconnectWebSocketF.mo33949f();
                LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
                new ConnectWebSocketF(liveUpdateDM.pingCount.incrementAndGet()).mo33949f();
            }
        }
    }

    public class StartTypingTimeoutF extends C2500F {

        /* renamed from: id */
        public int f3334id;

        public StartTypingTimeoutF(int i) {
            this.f3334id = i;
        }

        /* renamed from: f */
        public void mo33949f() {
            if (this.f3334id == LiveUpdateDM.this.startTypingId.get() && LiveUpdateDM.this.listener != null) {
                HSLogger.m3237d(LiveUpdateDM.TAG, "Start Typing action timed out, disabling TAI");
                LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
                liveUpdateDM.isAgentTyping = false;
                liveUpdateDM.notifyListener();
            }
        }
    }

    public interface TypingIndicatorListener {
        void onAgentTypingUpdate(boolean z);
    }

    public LiveUpdateDM(Domain domain2, Platform platform2) {
        this.domain = domain2;
        this.platform = platform2;
        this.pingCount = new AtomicInteger(-1);
        this.startTypingId = new AtomicInteger(-1);
        Device device = platform2.getDevice();
        this.sdkVersionHeaderValue = device.getPlatformName().toLowerCase() + "-" + device.getSDKVersion();
    }

    private int getErrorCode(String str) {
        String[] split = str.split("The status line is: ");
        if (2 != split.length) {
            return -1;
        }
        String[] split2 = split[1].split(" +");
        return (split2.length < 2 || !"403".equals(split2[1])) ? -1 : 403;
    }

    private String getTopicRequest() {
        return GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline26("[104, [\"", "agent_type_act.issue."), this.conversationServerId, "\"]]");
    }

    public String getWebSocketPath(WebSocketAuthData webSocketAuthData) {
        String appId = this.platform.getAppId();
        String[] split = this.platform.getDomain().split("\\.");
        String str = "";
        String str2 = split.length == 3 ? split[0] : str;
        try {
            str = URLEncoder.encode(webSocketAuthData.authToken, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            HSLogger.m3242e(TAG, "Exception in encoding authToken", e);
        }
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(webSocketAuthData.webSocketRoute)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(webSocketAuthData.webSocketRoute);
        GeneratedOutlineSupport.outline34(sb, "/subscribe/websocket/?origin_v3=", str, "&platform_id=", appId);
        return GeneratedOutlineSupport.outline18(sb, "&domain=", str2);
    }

    public boolean isAgentTyping() {
        return this.isAgentTyping;
    }

    public void notifyListener() {
        TypingIndicatorListener typingIndicatorListener = this.listener;
        if (typingIndicatorListener != null) {
            typingIndicatorListener.onAgentTypingUpdate(this.isAgentTyping);
        }
    }

    public void onConnected(HSWebSocket hSWebSocket) {
        HSLogger.m3237d(TAG, "web-socket connected");
        this.isConnecting = false;
        this.socketConnected = true;
        if (this.shouldDisconnectOnConnect) {
            this.disconnectWebSocketF.mo33949f();
        } else if (this.listener != null) {
            HSLogger.m3237d(TAG, "Subscribing to conversation topic");
            hSWebSocket.sendMessage(getTopicRequest());
            this.domain.runDelayedInParallel(new PingTimeoutF(this.pingCount.incrementAndGet()), TimeUnit.SECONDS.toMillis(60));
        } else {
            this.disconnectWebSocketF.mo33949f();
        }
    }

    public void onDisconnected() {
        HSLogger.m3237d(TAG, "web-socket disconnected");
        this.socketConnected = false;
        this.shouldDisconnectOnConnect = false;
    }

    public void onError(HSWebSocket hSWebSocket, String str) {
        HSLogger.m3237d(TAG, "Error in web-socket connection: " + str);
        this.isConnecting = false;
        if (this.listener == null) {
            return;
        }
        if (getErrorCode(str) != 403) {
            scheduleConnectionRetry();
        } else if (!this.isTokenRefreshed) {
            this.domain.runParallel(this.refreshAuthTokenAndConnectF);
        }
    }

    public void onMessage(HSWebSocket hSWebSocket, String str) {
        this.domain.runParallel(new HandleWebSocketMessageF(str));
    }

    public synchronized void registerListener(TypingIndicatorListener typingIndicatorListener, String str) {
        if (this.listener == null) {
            this.listener = typingIndicatorListener;
            this.conversationServerId = str;
            this.isTokenRefreshed = false;
            this.shouldDisconnectOnConnect = false;
            this.domain.runParallel(new ConnectWebSocketF(this.pingCount.incrementAndGet()));
        }
    }

    public void scheduleConnectionRetry() {
        this.domain.runDelayedInParallel(new ConnectWebSocketF(this.pingCount.incrementAndGet()), TimeUnit.SECONDS.toMillis(10));
    }

    public synchronized void unregisterListener() {
        if (this.listener != null) {
            this.isAgentTyping = false;
            notifyListener();
            this.startTypingId.incrementAndGet();
            this.pingCount.incrementAndGet();
            this.listener = null;
        }
        this.domain.runParallel(this.disconnectWebSocketF);
    }
}
