package com.google.android.play.core.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.util.IllegalFormatException;
import java.util.Locale;

/* renamed from: com.google.android.play.core.internal.ag */
public final class C2292ag {

    /* renamed from: a */
    public final String f3229a;

    public C2292ag(String str) {
        StringBuilder outline22 = GeneratedOutlineSupport.outline22(39, "UID: [", Process.myUid(), "]  PID: [", Process.myPid());
        outline22.append("] ");
        String valueOf = String.valueOf(outline22.toString());
        this.f3229a = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    /* renamed from: a */
    public static String m2978a(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                String valueOf = String.valueOf(str2);
                Log.e("PlayCore", valueOf.length() != 0 ? "Unable to format ".concat(valueOf) : new String("Unable to format "), e);
                String join = TextUtils.join(RESTClient.COMMA_SEPARATOR, objArr);
                str2 = GeneratedOutlineSupport.outline20(new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(join).length()), str2, " [", join, "]");
            }
        }
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()), str, " : ", str2);
    }

    /* renamed from: a */
    public final int mo33278a(int i, String str, Object[] objArr) {
        if (Log.isLoggable("PlayCore", i)) {
            return Log.i("PlayCore", m2978a(this.f3229a, str, objArr));
        }
        return 0;
    }

    /* renamed from: a */
    public final void mo33279a(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", m2978a(this.f3229a, str, objArr), th);
        }
    }
}
