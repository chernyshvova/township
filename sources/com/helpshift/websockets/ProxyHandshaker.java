package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class ProxyHandshaker {

    /* renamed from: RN */
    public static final String f3369RN = "\r\n";
    public final String mHost;
    public final int mPort;
    public final ProxySettings mSettings;
    public final Socket mSocket;

    public ProxyHandshaker(Socket socket, String str, int i, ProxySettings proxySettings) {
        this.mSocket = socket;
        this.mHost = str;
        this.mPort = i;
        this.mSettings = proxySettings;
    }

    private void addHeaders(StringBuilder sb) {
        for (Map.Entry next : this.mSettings.getHeaders().entrySet()) {
            String str = (String) next.getKey();
            for (String str2 : (List) next.getValue()) {
                if (str2 == null) {
                    str2 = "";
                }
                GeneratedOutlineSupport.outline34(sb, str, ": ", str2, "\r\n");
            }
        }
    }

    private void addProxyAuthorization(StringBuilder sb) {
        String id = this.mSettings.getId();
        if (id != null && id.length() != 0) {
            String password = this.mSettings.getPassword();
            if (password == null) {
                password = "";
            }
            String format = String.format("%s:%s", new Object[]{id, password});
            sb.append("Proxy-Authorization: Basic ");
            sb.append(Base64.encode(format));
            sb.append("\r\n");
        }
    }

    private String buildRequest() {
        String format = String.format("%s:%d", new Object[]{this.mHost, Integer.valueOf(this.mPort)});
        StringBuilder sb = new StringBuilder();
        sb.append("CONNECT ");
        sb.append(format);
        sb.append(" HTTP/1.1");
        sb.append("\r\n");
        sb.append("Host: ");
        sb.append(format);
        sb.append("\r\n");
        addHeaders(sb);
        addProxyAuthorization(sb);
        sb.append("\r\n");
        return sb.toString();
    }

    private void readStatusLine(InputStream inputStream) throws IOException {
        String readLine = Misc.readLine(inputStream, "UTF-8");
        if (readLine == null || readLine.length() == 0) {
            throw new IOException("The response from the proxy server does not contain a status line.");
        }
        String[] split = readLine.split(" +", 3);
        if (split.length < 2) {
            throw new IOException(GeneratedOutlineSupport.outline16("The status line in the response from the proxy server is badly formatted. The status line is: ", readLine));
        } else if (!"200".equals(split[1])) {
            throw new IOException(GeneratedOutlineSupport.outline16("The status code in the response from the proxy server is not '200 Connection established'. The status line is: ", readLine));
        }
    }

    private void receiveResponse() throws IOException {
        InputStream inputStream = this.mSocket.getInputStream();
        readStatusLine(inputStream);
        skipHeaders(inputStream);
    }

    private void sendRequest() throws IOException {
        byte[] bytesUTF8 = Misc.getBytesUTF8(buildRequest());
        OutputStream outputStream = this.mSocket.getOutputStream();
        outputStream.write(bytesUTF8);
        outputStream.flush();
    }

    private void skipHeaders(InputStream inputStream) throws IOException {
        while (true) {
            int i = 0;
            while (true) {
                int read = inputStream.read();
                if (read == -1) {
                    throw new EOFException("The end of the stream from the proxy server was reached unexpectedly.");
                } else if (read == 10) {
                    if (i == 0) {
                        return;
                    }
                } else if (read != 13) {
                    i++;
                } else {
                    int read2 = inputStream.read();
                    if (read2 == -1) {
                        throw new EOFException("The end of the stream from the proxy server was reached unexpectedly after a carriage return.");
                    } else if (read2 != 10) {
                        i += 2;
                    } else if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    public String getProxiedHostname() {
        return this.mHost;
    }

    public void perform() throws IOException {
        sendRequest();
        receiveResponse();
    }
}
