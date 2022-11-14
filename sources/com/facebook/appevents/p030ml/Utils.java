package com.facebook.appevents.p030ml;

import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.helpshift.analytics.AnalyticsEventKey;
import com.playrix.gplay.billing.Base64;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.ml.Utils */
/* compiled from: Utils.kt */
public final class Utils {
    public static final String DIR_NAME = "facebook_ml/";
    public static final Utils INSTANCE = new Utils();

    public static final File getMlDir() {
        Class<Utils> cls = Utils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final Map<String, MTensor> parseModelWeights(File file) {
        int i;
        File file2 = file;
        Class<Utils> cls = Utils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(file2, "file");
            try {
                FileInputStream fileInputStream = new FileInputStream(file2);
                int available = fileInputStream.available();
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                byte[] bArr = new byte[available];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                if (available < 4) {
                    return null;
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i2 = wrap.getInt();
                int i3 = i2 + 4;
                if (available < i3) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(new String(bArr, 4, i2, Charsets.UTF_8));
                JSONArray names = jSONObject.names();
                int length = names.length();
                String[] strArr = new String[length];
                int i4 = length - 1;
                if (i4 >= 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        strArr[i5] = names.getString(i5);
                        if (i6 > i4) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                Intrinsics.checkNotNullParameter(strArr, "$this$sort");
                if (length > 1) {
                    Arrays.sort(strArr);
                }
                HashMap hashMap = new HashMap();
                int i7 = 0;
                while (i7 < length) {
                    String str = strArr[i7];
                    i7++;
                    if (str != null) {
                        JSONArray jSONArray = jSONObject.getJSONArray(str);
                        int length2 = jSONArray.length();
                        int[] iArr = new int[length2];
                        int i8 = length2 - 1;
                        if (i8 >= 0) {
                            int i9 = 0;
                            int i10 = 1;
                            while (true) {
                                int i11 = i9 + 1;
                                iArr[i9] = jSONArray.getInt(i9);
                                i10 *= iArr[i9];
                                if (i11 > i8) {
                                    break;
                                }
                                i9 = i11;
                            }
                            i = i10;
                        } else {
                            i = 1;
                        }
                        int i12 = i * 4;
                        int i13 = i3 + i12;
                        if (i13 > available) {
                            return null;
                        }
                        ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i3, i12);
                        wrap2.order(ByteOrder.LITTLE_ENDIAN);
                        MTensor mTensor = new MTensor(iArr);
                        wrap2.asFloatBuffer().get(mTensor.getData(), 0, i);
                        hashMap.put(str, mTensor);
                        i3 = i13;
                    }
                }
                return hashMap;
            } catch (Exception unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public final String normalizeString(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, AnalyticsEventKey.STR);
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (true) {
                if (i > length) {
                    break;
                }
                boolean z2 = Intrinsics.compare(str.charAt(!z ? i : length), 32) <= 0;
                if (!z) {
                    if (!z2) {
                        z = true;
                    } else {
                        i++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            Object[] array = new Regex("\\s+").split(str.subSequence(i, length + 1).toString(), 0).toArray(new String[0]);
            if (array != null) {
                String join = TextUtils.join(" ", (String[]) array);
                Intrinsics.checkNotNullExpressionValue(join, "join(\" \", strArray)");
                return join;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int[] vectorize(String str, int i) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "texts");
            int[] iArr = new int[i];
            String normalizeString = normalizeString(str);
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
            if (normalizeString != null) {
                byte[] bytes = normalizeString.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                if (i > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        if (i2 < bytes.length) {
                            iArr[i2] = bytes[i2] & Base64.EQUALS_SIGN_ENC;
                        } else {
                            iArr[i2] = 0;
                        }
                        if (i3 >= i) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                return iArr;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
