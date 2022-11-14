package okhttp3.internal.http;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okio.ByteString;

public final class HttpHeaders {
    static {
        ByteString.encodeUtf8("\"\\");
        ByteString.encodeUtf8("\t ,=");
    }

    public static long contentLength(Response response) {
        String str = response.headers.get("Content-Length");
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static boolean hasBody(Response response) {
        if (response.request.method.equals("HEAD")) {
            return false;
        }
        int i = response.code;
        if (((i >= 100 && i < 200) || i == 204 || i == 304) && contentLength(response) == -1) {
            String str = response.headers.get("Transfer-Encoding");
            if (str == null) {
                str = null;
            }
            if ("chunked".equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static int parseSeconds(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.NO_COOKIES && !Cookie.parseAll(httpUrl, headers).isEmpty() && ((CookieJar.C20571) cookieJar) == null) {
            throw null;
        }
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }
}
