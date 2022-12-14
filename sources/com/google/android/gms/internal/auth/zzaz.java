package com.google.android.gms.internal.auth;

import android.util.Log;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.io.UnsupportedEncodingException;

public abstract class zzaz extends FastSafeParcelableJsonResponse {
    public static String zzem = "AUTH";

    public byte[] toByteArray() {
        try {
            return toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(zzem, "Error serializing object.", e);
            return null;
        }
    }
}
