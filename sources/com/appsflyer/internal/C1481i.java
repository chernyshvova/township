package com.appsflyer.internal;

import android.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.appsflyer.internal.i */
public final class C1481i {
    public String AFInAppEventParameterName;
    public String AFInAppEventType;
    public byte[] AFKeystoreWrapper;
    public String valueOf;

    public C1481i() {
    }

    public final byte[] values() {
        return this.AFKeystoreWrapper;
    }

    public C1481i(String str, byte[] bArr, String str2) {
        this.AFInAppEventType = str;
        this.AFKeystoreWrapper = bArr;
        this.AFInAppEventParameterName = str2;
    }

    public C1481i(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i = 0;
        int i2 = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.AFInAppEventType = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.AFInAppEventParameterName = nextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.AFInAppEventParameterName);
                if (matcher.matches()) {
                    i = Integer.parseInt(matcher.group(1));
                    i2 = Integer.parseInt(matcher.group(2));
                }
            } else if (nextLine.startsWith("data=")) {
                String trim = nextLine.substring(5).trim();
                this.AFKeystoreWrapper = (i > 4 || i2 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
            }
        }
        scanner.close();
    }
}
