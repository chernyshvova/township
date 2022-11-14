package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.playrix.gplay.billing.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebSocketFrame {
    public boolean mFin;
    public boolean mMask;
    public int mOpcode;
    public byte[] mPayload;
    public boolean mRsv1;
    public boolean mRsv2;
    public boolean mRsv3;

    private void appendPayloadBinary(StringBuilder sb) {
        byte[] bArr;
        if (!appendPayloadCommon(sb)) {
            int i = 0;
            while (true) {
                bArr = this.mPayload;
                if (i >= bArr.length) {
                    break;
                }
                sb.append(String.format("%02X ", new Object[]{Integer.valueOf(bArr[i] & Base64.EQUALS_SIGN_ENC)}));
                i++;
            }
            if (bArr.length != 0) {
                sb.setLength(sb.length() - 1);
            }
        }
    }

    private void appendPayloadClose(StringBuilder sb) {
        sb.append(",CloseCode=");
        sb.append(getCloseCode());
        sb.append(",Reason=");
        String closeReason = getCloseReason();
        if (closeReason == null) {
            sb.append("null");
            return;
        }
        sb.append("\"");
        sb.append(closeReason);
        sb.append("\"");
    }

    private boolean appendPayloadCommon(StringBuilder sb) {
        sb.append(",Payload=");
        if (this.mPayload == null) {
            sb.append("null");
            return true;
        } else if (!this.mRsv1) {
            return false;
        } else {
            sb.append("compressed");
            return true;
        }
    }

    private void appendPayloadText(StringBuilder sb) {
        if (!appendPayloadCommon(sb)) {
            sb.append("\"");
            sb.append(getPayloadText());
            sb.append("\"");
        }
    }

    public static byte[] compress(byte[] bArr, PerMessageCompressionExtension perMessageCompressionExtension) {
        try {
            return perMessageCompressionExtension.compress(bArr);
        } catch (WebSocketException unused) {
            return bArr;
        }
    }

    public static WebSocketFrame compressFrame(WebSocketFrame webSocketFrame, PerMessageCompressionExtension perMessageCompressionExtension) {
        byte[] payload;
        if (perMessageCompressionExtension == null) {
            return webSocketFrame;
        }
        if ((webSocketFrame.isTextFrame() || webSocketFrame.isBinaryFrame()) && webSocketFrame.getFin() && !webSocketFrame.getRsv1() && (payload = webSocketFrame.getPayload()) != null && payload.length != 0) {
            webSocketFrame.setPayload(compress(payload, perMessageCompressionExtension));
            webSocketFrame.setRsv1(true);
        }
        return webSocketFrame;
    }

    public static WebSocketFrame createBinaryFrame(byte[] bArr) {
        return new WebSocketFrame().setFin(true).setOpcode(2).setPayload(bArr);
    }

    public static WebSocketFrame createCloseFrame() {
        return new WebSocketFrame().setFin(true).setOpcode(8);
    }

    public static WebSocketFrame createContinuationFrame() {
        return new WebSocketFrame().setOpcode(0);
    }

    public static WebSocketFrame createPingFrame() {
        return new WebSocketFrame().setFin(true).setOpcode(9);
    }

    public static WebSocketFrame createPongFrame() {
        return new WebSocketFrame().setFin(true).setOpcode(10);
    }

    public static WebSocketFrame createTextFrame(String str) {
        return new WebSocketFrame().setFin(true).setOpcode(1).setPayload(str);
    }

    public static byte[] mask(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr.length < 4 || bArr2 == null)) {
            for (int i = 0; i < bArr2.length; i++) {
                bArr2[i] = (byte) (bArr2[i] ^ bArr[i % 4]);
            }
        }
        return bArr2;
    }

    public static List<WebSocketFrame> split(WebSocketFrame webSocketFrame, int i) {
        byte[] payload = webSocketFrame.getPayload();
        boolean fin = webSocketFrame.getFin();
        ArrayList arrayList = new ArrayList();
        webSocketFrame.setFin(false).setPayload(Arrays.copyOf(payload, i));
        arrayList.add(webSocketFrame);
        int i2 = i;
        while (i2 < payload.length) {
            int i3 = i2 + i;
            arrayList.add(createContinuationFrame(Arrays.copyOfRange(payload, i2, Math.min(i3, payload.length))));
            i2 = i3;
        }
        if (fin) {
            ((WebSocketFrame) arrayList.get(arrayList.size() - 1)).setFin(true);
        }
        return arrayList;
    }

    public static List<WebSocketFrame> splitIfNecessary(WebSocketFrame webSocketFrame, int i, PerMessageCompressionExtension perMessageCompressionExtension) {
        if (i == 0 || webSocketFrame.getPayloadLength() <= i) {
            return null;
        }
        if (webSocketFrame.isBinaryFrame() || webSocketFrame.isTextFrame()) {
            webSocketFrame = compressFrame(webSocketFrame, perMessageCompressionExtension);
            if (webSocketFrame.getPayloadLength() <= i) {
                return null;
            }
        } else if (!webSocketFrame.isContinuationFrame()) {
            return null;
        }
        return split(webSocketFrame, i);
    }

    public int getCloseCode() {
        byte[] bArr = this.mPayload;
        if (bArr == null || bArr.length < 2) {
            return WebSocketCloseCode.NONE;
        }
        return (bArr[1] & Base64.EQUALS_SIGN_ENC) | ((bArr[0] & Base64.EQUALS_SIGN_ENC) << 8);
    }

    public String getCloseReason() {
        byte[] bArr = this.mPayload;
        if (bArr == null || bArr.length < 3) {
            return null;
        }
        return Misc.toStringUTF8(bArr, 2, bArr.length - 2);
    }

    public boolean getFin() {
        return this.mFin;
    }

    public boolean getMask() {
        return this.mMask;
    }

    public int getOpcode() {
        return this.mOpcode;
    }

    public byte[] getPayload() {
        return this.mPayload;
    }

    public int getPayloadLength() {
        byte[] bArr = this.mPayload;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public String getPayloadText() {
        byte[] bArr = this.mPayload;
        if (bArr == null) {
            return null;
        }
        return Misc.toStringUTF8(bArr);
    }

    public boolean getRsv1() {
        return this.mRsv1;
    }

    public boolean getRsv2() {
        return this.mRsv2;
    }

    public boolean getRsv3() {
        return this.mRsv3;
    }

    public boolean hasPayload() {
        return this.mPayload != null;
    }

    public boolean isBinaryFrame() {
        return this.mOpcode == 2;
    }

    public boolean isCloseFrame() {
        return this.mOpcode == 8;
    }

    public boolean isContinuationFrame() {
        return this.mOpcode == 0;
    }

    public boolean isControlFrame() {
        int i = this.mOpcode;
        return 8 <= i && i <= 15;
    }

    public boolean isDataFrame() {
        int i = this.mOpcode;
        return 1 <= i && i <= 7;
    }

    public boolean isPingFrame() {
        return this.mOpcode == 9;
    }

    public boolean isPongFrame() {
        return this.mOpcode == 10;
    }

    public boolean isTextFrame() {
        return this.mOpcode == 1;
    }

    public WebSocketFrame setCloseFramePayload(int i, String str) {
        byte[] bArr = {(byte) ((i >> 8) & 255), (byte) (i & 255)};
        if (str == null || str.length() == 0) {
            return setPayload(bArr);
        }
        byte[] bytesUTF8 = Misc.getBytesUTF8(str);
        byte[] bArr2 = new byte[(bytesUTF8.length + 2)];
        System.arraycopy(bArr, 0, bArr2, 0, 2);
        System.arraycopy(bytesUTF8, 0, bArr2, 2, bytesUTF8.length);
        return setPayload(bArr2);
    }

    public WebSocketFrame setFin(boolean z) {
        this.mFin = z;
        return this;
    }

    public WebSocketFrame setMask(boolean z) {
        this.mMask = z;
        return this;
    }

    public WebSocketFrame setOpcode(int i) {
        this.mOpcode = i;
        return this;
    }

    public WebSocketFrame setPayload(String str) {
        if (str == null || str.length() == 0) {
            return setPayload((byte[]) null);
        }
        return setPayload(Misc.getBytesUTF8(str));
    }

    public WebSocketFrame setRsv1(boolean z) {
        this.mRsv1 = z;
        return this;
    }

    public WebSocketFrame setRsv2(boolean z) {
        this.mRsv2 = z;
        return this;
    }

    public WebSocketFrame setRsv3(boolean z) {
        this.mRsv3 = z;
        return this;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("WebSocketFrame(FIN=");
        boolean z = this.mFin;
        String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        outline24.append(z ? str : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        outline24.append(",RSV1=");
        outline24.append(this.mRsv1 ? str : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        outline24.append(",RSV2=");
        outline24.append(this.mRsv2 ? str : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        outline24.append(",RSV3=");
        if (!this.mRsv3) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        outline24.append(str);
        outline24.append(",Opcode=");
        outline24.append(Misc.toOpcodeName(this.mOpcode));
        outline24.append(",Length=");
        outline24.append(getPayloadLength());
        int i = this.mOpcode;
        if (i == 1) {
            appendPayloadText(outline24);
        } else if (i == 2) {
            appendPayloadBinary(outline24);
        } else if (i == 8) {
            appendPayloadClose(outline24);
        }
        outline24.append(")");
        return outline24.toString();
    }

    public static WebSocketFrame createContinuationFrame(byte[] bArr) {
        return createContinuationFrame().setPayload(bArr);
    }

    public static WebSocketFrame createCloseFrame(int i) {
        return createCloseFrame().setCloseFramePayload(i, (String) null);
    }

    public static WebSocketFrame createContinuationFrame(String str) {
        return createContinuationFrame().setPayload(str);
    }

    public static WebSocketFrame createPingFrame(byte[] bArr) {
        return createPingFrame().setPayload(bArr);
    }

    public static WebSocketFrame createPongFrame(byte[] bArr) {
        return createPongFrame().setPayload(bArr);
    }

    public WebSocketFrame setPayload(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        this.mPayload = bArr;
        return this;
    }

    public static WebSocketFrame createCloseFrame(int i, String str) {
        return createCloseFrame().setCloseFramePayload(i, str);
    }

    public static WebSocketFrame createPingFrame(String str) {
        return createPingFrame().setPayload(str);
    }

    public static WebSocketFrame createPongFrame(String str) {
        return createPongFrame().setPayload(str);
    }
}
