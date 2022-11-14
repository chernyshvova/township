package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class HandshakeBuilder {
    public static final String[] CONNECTION_HEADER = {"Connection", "Upgrade"};

    /* renamed from: RN */
    public static final String f3368RN = "\r\n";
    public static final String[] UPGRADE_HEADER = {"Upgrade", "websocket"};
    public static final String[] VERSION_HEADER = {"Sec-WebSocket-Version", "13"};
    public List<WebSocketExtension> mExtensions;
    public List<String[]> mHeaders;
    public final String mHost;
    public String mKey;
    public final String mPath;
    public Set<String> mProtocols;
    public boolean mSecure;
    public final URI mUri;
    public String mUserInfo;

    public HandshakeBuilder(boolean z, String str, String str2, String str3) {
        this.mSecure = z;
        this.mUserInfo = str;
        this.mHost = str2;
        this.mPath = str3;
        Object[] objArr = new Object[3];
        objArr[0] = z ? "wss" : "ws";
        objArr[1] = str2;
        objArr[2] = str3;
        this.mUri = URI.create(String.format("%s://%s%s", objArr));
    }

    public static String build(String str, List<String[]> list) {
        StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, "\r\n");
        for (String[] next : list) {
            outline26.append(next[0]);
            outline26.append(": ");
            outline26.append(next[1]);
            outline26.append("\r\n");
        }
        outline26.append("\r\n");
        return outline26.toString();
    }

    public static List<WebSocketExtension> copyExtensions(List<WebSocketExtension> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (WebSocketExtension webSocketExtension : list) {
            arrayList.add(new WebSocketExtension(webSocketExtension));
        }
        return arrayList;
    }

    public static String[] copyHeader(String[] strArr) {
        return new String[]{strArr[0], strArr[1]};
    }

    public static List<String[]> copyHeaders(List<String[]> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String[] copyHeader : list) {
            arrayList.add(copyHeader(copyHeader));
        }
        return arrayList;
    }

    public static Set<String> copyProtocols(Set<String> set) {
        if (set == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(set.size());
        linkedHashSet.addAll(set);
        return linkedHashSet;
    }

    public static boolean isValidProtocol(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < '!' || '~' < charAt || Token.isSeparator(charAt)) {
                return false;
            }
        }
        return true;
    }

    public void addExtension(WebSocketExtension webSocketExtension) {
        if (webSocketExtension != null) {
            synchronized (this) {
                if (this.mExtensions == null) {
                    this.mExtensions = new ArrayList();
                }
                this.mExtensions.add(webSocketExtension);
            }
        }
    }

    public void addHeader(String str, String str2) {
        if (str != null && str.length() != 0) {
            if (str2 == null) {
                str2 = "";
            }
            synchronized (this) {
                if (this.mHeaders == null) {
                    this.mHeaders = new ArrayList();
                }
                this.mHeaders.add(new String[]{str, str2});
            }
        }
    }

    public void addProtocol(String str) {
        if (isValidProtocol(str)) {
            synchronized (this) {
                if (this.mProtocols == null) {
                    this.mProtocols = new LinkedHashSet();
                }
                this.mProtocols.add(str);
            }
            return;
        }
        throw new IllegalArgumentException("'protocol' must be a non-empty string with characters in the range U+0021 to U+007E not including separator characters.");
    }

    public List<String[]> buildHeaders() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new String[]{"Host", this.mHost});
        arrayList.add(CONNECTION_HEADER);
        arrayList.add(UPGRADE_HEADER);
        arrayList.add(VERSION_HEADER);
        arrayList.add(new String[]{"Sec-WebSocket-Key", this.mKey});
        Set<String> set = this.mProtocols;
        if (!(set == null || set.size() == 0)) {
            arrayList.add(new String[]{"Sec-WebSocket-Protocol", Misc.join(this.mProtocols, RESTClient.COMMA_SEPARATOR)});
        }
        List<WebSocketExtension> list = this.mExtensions;
        if (!(list == null || list.size() == 0)) {
            arrayList.add(new String[]{"Sec-WebSocket-Extensions", Misc.join(this.mExtensions, RESTClient.COMMA_SEPARATOR)});
        }
        String str = this.mUserInfo;
        if (!(str == null || str.length() == 0)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Basic ");
            outline24.append(Base64.encode(this.mUserInfo));
            arrayList.add(new String[]{"Authorization", outline24.toString()});
        }
        List<String[]> list2 = this.mHeaders;
        if (!(list2 == null || list2.size() == 0)) {
            arrayList.addAll(this.mHeaders);
        }
        return arrayList;
    }

    public String buildRequestLine() {
        return String.format("GET %s HTTP/1.1", new Object[]{this.mPath});
    }

    public void clearExtensions() {
        synchronized (this) {
            this.mExtensions = null;
        }
    }

    public void clearHeaders() {
        synchronized (this) {
            this.mHeaders = null;
        }
    }

    public void clearProtocols() {
        synchronized (this) {
            this.mProtocols = null;
        }
    }

    public void clearUserInfo() {
        synchronized (this) {
            this.mUserInfo = null;
        }
    }

    public boolean containsExtension(WebSocketExtension webSocketExtension) {
        if (webSocketExtension == null) {
            return false;
        }
        synchronized (this) {
            if (this.mExtensions == null) {
                return false;
            }
            boolean contains = this.mExtensions.contains(webSocketExtension);
            return contains;
        }
    }

    public boolean containsProtocol(String str) {
        synchronized (this) {
            if (this.mProtocols == null) {
                return false;
            }
            boolean contains = this.mProtocols.contains(str);
            return contains;
        }
    }

    public URI getURI() {
        return this.mUri;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeExtension(com.helpshift.websockets.WebSocketExtension r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            return
        L_0x0003:
            monitor-enter(r1)
            java.util.List<com.helpshift.websockets.WebSocketExtension> r0 = r1.mExtensions     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x000a
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            return
        L_0x000a:
            java.util.List<com.helpshift.websockets.WebSocketExtension> r0 = r1.mExtensions     // Catch:{ all -> 0x001c }
            r0.remove(r2)     // Catch:{ all -> 0x001c }
            java.util.List<com.helpshift.websockets.WebSocketExtension> r2 = r1.mExtensions     // Catch:{ all -> 0x001c }
            int r2 = r2.size()     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x001a
            r2 = 0
            r1.mExtensions = r2     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.HandshakeBuilder.removeExtension(com.helpshift.websockets.WebSocketExtension):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeExtensions(java.lang.String r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            monitor-enter(r4)
            java.util.List<com.helpshift.websockets.WebSocketExtension> r0 = r4.mExtensions     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x000a
            monitor-exit(r4)     // Catch:{ all -> 0x0052 }
            return
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r0.<init>()     // Catch:{ all -> 0x0052 }
            java.util.List<com.helpshift.websockets.WebSocketExtension> r1 = r4.mExtensions     // Catch:{ all -> 0x0052 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0052 }
        L_0x0015:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0052 }
            com.helpshift.websockets.WebSocketExtension r2 = (com.helpshift.websockets.WebSocketExtension) r2     // Catch:{ all -> 0x0052 }
            java.lang.String r3 = r2.getName()     // Catch:{ all -> 0x0052 }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x0015
            r0.add(r2)     // Catch:{ all -> 0x0052 }
            goto L_0x0015
        L_0x002f:
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0052 }
        L_0x0033:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0045
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x0052 }
            com.helpshift.websockets.WebSocketExtension r0 = (com.helpshift.websockets.WebSocketExtension) r0     // Catch:{ all -> 0x0052 }
            java.util.List<com.helpshift.websockets.WebSocketExtension> r1 = r4.mExtensions     // Catch:{ all -> 0x0052 }
            r1.remove(r0)     // Catch:{ all -> 0x0052 }
            goto L_0x0033
        L_0x0045:
            java.util.List<com.helpshift.websockets.WebSocketExtension> r5 = r4.mExtensions     // Catch:{ all -> 0x0052 }
            int r5 = r5.size()     // Catch:{ all -> 0x0052 }
            if (r5 != 0) goto L_0x0050
            r5 = 0
            r4.mExtensions = r5     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r4)     // Catch:{ all -> 0x0052 }
            return
        L_0x0052:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0055:
            throw r5
        L_0x0056:
            goto L_0x0055
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.HandshakeBuilder.removeExtensions(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeHeaders(java.lang.String r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x005a
            int r0 = r5.length()
            if (r0 != 0) goto L_0x0009
            goto L_0x005a
        L_0x0009:
            monitor-enter(r4)
            java.util.List<java.lang.String[]> r0 = r4.mHeaders     // Catch:{ all -> 0x0057 }
            if (r0 != 0) goto L_0x0010
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            return
        L_0x0010:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0057 }
            r0.<init>()     // Catch:{ all -> 0x0057 }
            java.util.List<java.lang.String[]> r1 = r4.mHeaders     // Catch:{ all -> 0x0057 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0057 }
        L_0x001b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0057 }
            java.lang.String[] r2 = (java.lang.String[]) r2     // Catch:{ all -> 0x0057 }
            r3 = 0
            r3 = r2[r3]     // Catch:{ all -> 0x0057 }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x001b
            r0.add(r2)     // Catch:{ all -> 0x0057 }
            goto L_0x001b
        L_0x0034:
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0057 }
        L_0x0038:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x004a
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x0057 }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x0057 }
            java.util.List<java.lang.String[]> r1 = r4.mHeaders     // Catch:{ all -> 0x0057 }
            r1.remove(r0)     // Catch:{ all -> 0x0057 }
            goto L_0x0038
        L_0x004a:
            java.util.List<java.lang.String[]> r5 = r4.mHeaders     // Catch:{ all -> 0x0057 }
            int r5 = r5.size()     // Catch:{ all -> 0x0057 }
            if (r5 != 0) goto L_0x0055
            r5 = 0
            r4.mHeaders = r5     // Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            return
        L_0x0057:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            throw r5
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.HandshakeBuilder.removeHeaders(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeProtocol(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            return
        L_0x0003:
            monitor-enter(r1)
            java.util.Set<java.lang.String> r0 = r1.mProtocols     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x000a
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            return
        L_0x000a:
            java.util.Set<java.lang.String> r0 = r1.mProtocols     // Catch:{ all -> 0x001c }
            r0.remove(r2)     // Catch:{ all -> 0x001c }
            java.util.Set<java.lang.String> r2 = r1.mProtocols     // Catch:{ all -> 0x001c }
            int r2 = r2.size()     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x001a
            r2 = 0
            r1.mProtocols = r2     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.HandshakeBuilder.removeProtocol(java.lang.String):void");
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public void setUserInfo(String str) {
        synchronized (this) {
            this.mUserInfo = str;
        }
    }

    public void setUserInfo(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        setUserInfo(String.format("%s:%s", new Object[]{str, str2}));
    }

    public void addExtension(String str) {
        addExtension(WebSocketExtension.parse(str));
    }

    public boolean containsExtension(String str) {
        if (str == null) {
            return false;
        }
        synchronized (this) {
            if (this.mExtensions == null) {
                return false;
            }
            for (WebSocketExtension name : this.mExtensions) {
                if (name.getName().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public HandshakeBuilder(HandshakeBuilder handshakeBuilder) {
        this.mSecure = handshakeBuilder.mSecure;
        this.mUserInfo = handshakeBuilder.mUserInfo;
        this.mHost = handshakeBuilder.mHost;
        this.mPath = handshakeBuilder.mPath;
        this.mUri = handshakeBuilder.mUri;
        this.mKey = handshakeBuilder.mKey;
        this.mProtocols = copyProtocols(handshakeBuilder.mProtocols);
        this.mExtensions = copyExtensions(handshakeBuilder.mExtensions);
        this.mHeaders = copyHeaders(handshakeBuilder.mHeaders);
    }
}
