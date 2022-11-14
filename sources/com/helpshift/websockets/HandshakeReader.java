package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandshakeReader {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public final WebSocket mWebSocket;

    public HandshakeReader(WebSocket webSocket) {
        this.mWebSocket = webSocket;
    }

    private int getContentLength(Map<String, List<String>> map) {
        try {
            return Integer.parseInt((String) map.get("Content-Length").get(0));
        } catch (Exception unused) {
            return -1;
        }
    }

    private void parseHttpHeader(Map<String, List<String>> map, String str) {
        String[] split = str.split(CertificateUtil.DELIMITER, 2);
        if (split.length >= 2) {
            String trim = split[0].trim();
            String trim2 = split[1].trim();
            List list = map.get(trim);
            if (list == null) {
                list = new ArrayList();
                map.put(trim, list);
            }
            list.add(trim2);
        }
    }

    private byte[] readBody(Map<String, List<String>> map, WebSocketInputStream webSocketInputStream) {
        int contentLength = getContentLength(map);
        if (contentLength <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[contentLength];
            webSocketInputStream.readBytes(bArr, contentLength);
            return bArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> readHttpHeaders(com.helpshift.websockets.WebSocketInputStream r6) throws com.helpshift.websockets.WebSocketException {
        /*
            r5 = this;
            java.util.TreeMap r0 = new java.util.TreeMap
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER
            r0.<init>(r1)
            r1 = 0
        L_0x0008:
            java.lang.String r2 = r6.readLine()     // Catch:{ IOException -> 0x004b }
            if (r2 == 0) goto L_0x0041
            int r3 = r2.length()
            if (r3 != 0) goto L_0x0015
            goto L_0x0041
        L_0x0015:
            r3 = 0
            char r3 = r2.charAt(r3)
            r4 = 32
            if (r3 == r4) goto L_0x0032
            r4 = 9
            if (r3 != r4) goto L_0x0023
            goto L_0x0032
        L_0x0023:
            if (r1 == 0) goto L_0x002c
            java.lang.String r1 = r1.toString()
            r5.parseHttpHeader(r0, r1)
        L_0x002c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            goto L_0x0008
        L_0x0032:
            if (r1 != 0) goto L_0x0035
            goto L_0x0008
        L_0x0035:
            java.lang.String r3 = "^[ \t]+"
            java.lang.String r4 = " "
            java.lang.String r2 = r2.replaceAll(r3, r4)
            r1.append(r2)
            goto L_0x0008
        L_0x0041:
            if (r1 == 0) goto L_0x004a
            java.lang.String r6 = r1.toString()
            r5.parseHttpHeader(r0, r6)
        L_0x004a:
            return r0
        L_0x004b:
            r6 = move-exception
            com.helpshift.websockets.WebSocketException r0 = new com.helpshift.websockets.WebSocketException
            com.helpshift.websockets.WebSocketError r1 = com.helpshift.websockets.WebSocketError.HTTP_HEADER_FAILURE
            java.lang.String r2 = "An error occurred while HTTP header section was being read: "
            java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
            java.lang.String r3 = r6.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r1, r2, r6)
            goto L_0x0066
        L_0x0065:
            throw r0
        L_0x0066:
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.HandshakeReader.readHttpHeaders(com.helpshift.websockets.WebSocketInputStream):java.util.Map");
    }

    private StatusLine readStatusLine(WebSocketInputStream webSocketInputStream) throws WebSocketException {
        try {
            String readLine = webSocketInputStream.readLine();
            if (readLine == null || readLine.length() == 0) {
                throw new WebSocketException(WebSocketError.STATUS_LINE_EMPTY, "The status line of the opening handshake response is empty.");
            }
            try {
                return new StatusLine(readLine);
            } catch (Exception unused) {
                throw new WebSocketException(WebSocketError.STATUS_LINE_BAD_FORMAT, GeneratedOutlineSupport.outline16("The status line of the opening handshake response is badly formatted. The status line is: ", readLine));
            }
        } catch (IOException e) {
            WebSocketError webSocketError = WebSocketError.OPENING_HANDSHAKE_RESPONSE_FAILURE;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to read an opening handshake response from the server: ");
            outline24.append(e.getMessage());
            throw new WebSocketException(webSocketError, outline24.toString(), e);
        }
    }

    private void validateAccept(StatusLine statusLine, Map<String, List<String>> map, String str) throws WebSocketException {
        List list = map.get("Sec-WebSocket-Accept");
        if (list != null) {
            try {
                if (!Base64.encode(MessageDigest.getInstance(Utility.HASH_ALGORITHM_SHA1).digest(Misc.getBytesUTF8(GeneratedOutlineSupport.outline16(str, ACCEPT_MAGIC)))).equals((String) list.get(0))) {
                    throw new OpeningHandshakeException(WebSocketError.UNEXPECTED_SEC_WEBSOCKET_ACCEPT_HEADER, "The value of 'Sec-WebSocket-Accept' header is different from the expected one.", statusLine, map);
                }
            } catch (Exception unused) {
            }
        } else {
            throw new OpeningHandshakeException(WebSocketError.NO_SEC_WEBSOCKET_ACCEPT_HEADER, "The opening handshake response does not contain 'Sec-WebSocket-Accept' header.", statusLine, map);
        }
    }

    private void validateConnection(StatusLine statusLine, Map<String, List<String>> map) throws WebSocketException {
        List<String> list = map.get("Connection");
        if (list == null || list.size() == 0) {
            throw new OpeningHandshakeException(WebSocketError.NO_CONNECTION_HEADER, "The opening handshake response does not contain 'Connection' header.", statusLine, map);
        }
        for (String split : list) {
            String[] split2 = split.split("\\s*,\\s*");
            int length = split2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (!"Upgrade".equalsIgnoreCase(split2[i])) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
        throw new OpeningHandshakeException(WebSocketError.NO_UPGRADE_IN_CONNECTION_HEADER, "'Upgrade' was not found in 'Connection' header.", statusLine, map);
    }

    private void validateExtensionCombination(StatusLine statusLine, Map<String, List<String>> map, List<WebSocketExtension> list) throws WebSocketException {
        WebSocketExtension webSocketExtension = null;
        for (WebSocketExtension next : list) {
            if (next instanceof PerMessageCompressionExtension) {
                if (webSocketExtension == null) {
                    webSocketExtension = next;
                } else {
                    throw new OpeningHandshakeException(WebSocketError.EXTENSIONS_CONFLICT, String.format("'%s' extension and '%s' extension conflict with each other.", new Object[]{webSocketExtension.getName(), next.getName()}), statusLine, map);
                }
            }
        }
    }

    private void validateExtensions(StatusLine statusLine, Map<String, List<String>> map) throws WebSocketException {
        List<String> list = map.get("Sec-WebSocket-Extensions");
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String split : list) {
                String[] split2 = split.split("\\s*,\\s*");
                int length = split2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String str = split2[i];
                        WebSocketExtension parse = WebSocketExtension.parse(str);
                        if (parse != null) {
                            String name = parse.getName();
                            if (this.mWebSocket.getHandshakeBuilder().containsExtension(name)) {
                                parse.validate();
                                arrayList.add(parse);
                                i++;
                            } else {
                                throw new OpeningHandshakeException(WebSocketError.UNSUPPORTED_EXTENSION, GeneratedOutlineSupport.outline16("The extension contained in the Sec-WebSocket-Extensions header is not supported: ", name), statusLine, map);
                            }
                        } else {
                            throw new OpeningHandshakeException(WebSocketError.EXTENSION_PARSE_ERROR, GeneratedOutlineSupport.outline16("The value in 'Sec-WebSocket-Extensions' failed to be parsed: ", str), statusLine, map);
                        }
                    }
                }
            }
            validateExtensionCombination(statusLine, map, arrayList);
            this.mWebSocket.setAgreedExtensions(arrayList);
        }
    }

    private void validateProtocol(StatusLine statusLine, Map<String, List<String>> map) throws WebSocketException {
        String str;
        List list = map.get("Sec-WebSocket-Protocol");
        if (list != null && (str = (String) list.get(0)) != null && str.length() != 0) {
            if (this.mWebSocket.getHandshakeBuilder().containsProtocol(str)) {
                this.mWebSocket.setAgreedProtocol(str);
                return;
            }
            throw new OpeningHandshakeException(WebSocketError.UNSUPPORTED_PROTOCOL, GeneratedOutlineSupport.outline16("The protocol contained in the Sec-WebSocket-Protocol header is not supported: ", str), statusLine, map);
        }
    }

    private void validateStatusLine(StatusLine statusLine, Map<String, List<String>> map, WebSocketInputStream webSocketInputStream) throws WebSocketException {
        if (statusLine.getStatusCode() != 101) {
            byte[] readBody = readBody(map, webSocketInputStream);
            WebSocketError webSocketError = WebSocketError.NOT_SWITCHING_PROTOCOLS;
            throw new OpeningHandshakeException(webSocketError, "The status code of the opening handshake response is not '101 Switching Protocols'. The status line is: " + statusLine, statusLine, map, readBody);
        }
    }

    private void validateUpgrade(StatusLine statusLine, Map<String, List<String>> map) throws WebSocketException {
        List<String> list = map.get("Upgrade");
        if (list == null || list.size() == 0) {
            throw new OpeningHandshakeException(WebSocketError.NO_UPGRADE_HEADER, "The opening handshake response does not contain 'Upgrade' header.", statusLine, map);
        }
        for (String split : list) {
            String[] split2 = split.split("\\s*,\\s*");
            int length = split2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (!"websocket".equalsIgnoreCase(split2[i])) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
        throw new OpeningHandshakeException(WebSocketError.NO_WEBSOCKET_IN_UPGRADE_HEADER, "'websocket' was not found in 'Upgrade' header.", statusLine, map);
    }

    public Map<String, List<String>> readHandshake(WebSocketInputStream webSocketInputStream, String str) throws WebSocketException {
        StatusLine readStatusLine = readStatusLine(webSocketInputStream);
        Map<String, List<String>> readHttpHeaders = readHttpHeaders(webSocketInputStream);
        validateStatusLine(readStatusLine, readHttpHeaders, webSocketInputStream);
        validateUpgrade(readStatusLine, readHttpHeaders);
        validateConnection(readStatusLine, readHttpHeaders);
        validateAccept(readStatusLine, readHttpHeaders, str);
        validateExtensions(readStatusLine, readHttpHeaders);
        validateProtocol(readStatusLine, readHttpHeaders);
        return readHttpHeaders;
    }
}
