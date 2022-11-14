package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@SuppressLint({"NewApi"})
public class Android10Platform extends AndroidPlatform {
    public Android10Platform(Class<?> cls) {
        super(cls, (OptionalMethod<Socket>) null, (OptionalMethod<Socket>) null, (OptionalMethod<Socket>) null, (OptionalMethod<Socket>) null);
    }

    @Nullable
    public static Platform buildIfSupported() {
        int i;
        if (!Platform.isAndroid()) {
            return null;
        }
        try {
            i = Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            i = 0;
        }
        if (i >= 29) {
            try {
                return new Android10Platform(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            } catch (ClassNotFoundException unused2) {
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        try {
            if (SSLSockets.isSupportedSocket(sSLSocket)) {
                SSLSockets.setUseSessionTickets(sSLSocket, true);
            }
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) ((ArrayList) Platform.alpnProtocolNames(list)).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    @Nullable
    @IgnoreJRERequirement
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }
}
