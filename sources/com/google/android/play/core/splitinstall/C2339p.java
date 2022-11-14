package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.os.Process;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* renamed from: com.google.android.play.core.splitinstall.p */
public final class C2339p {
    static {
        StringBuilder outline22 = GeneratedOutlineSupport.outline22(39, "UID: [", Process.myUid(), "]  PID: [", Process.myPid());
        outline22.append("] ");
        String valueOf = String.valueOf(outline22.toString());
        if ("SplitInstallInfoProvider".length() != 0) {
            valueOf.concat("SplitInstallInfoProvider");
        } else {
            new String(valueOf);
        }
    }

    public C2339p(Context context) {
        context.getPackageName();
    }
}
