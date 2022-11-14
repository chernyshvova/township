package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

public final class Jdk9Platform extends Platform {
    public final Method getProtocolMethod;
    public final Method setProtocolMethod;

    public Jdk9Platform(Method method, Method method2) {
        this.setProtocolMethod = method;
        this.getProtocolMethod = method2;
    }

    public static Jdk9Platform buildIfSupported() {
        try {
            return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> alpnProtocolNames = Platform.alpnProtocolNames(list);
            Method method = this.setProtocolMethod;
            Object[] objArr = new Object[1];
            ArrayList arrayList = (ArrayList) alpnProtocolNames;
            objArr[0] = arrayList.toArray(new String[arrayList.size()]);
            method.invoke(sSLParameters, objArr);
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.assertionError("unable to set ssl parameters", e);
        }
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            String str = (String) this.getProtocolMethod.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw Util.assertionError("failed to get ALPN selected protocol", e);
        } catch (IllegalAccessException e2) {
            throw Util.assertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
