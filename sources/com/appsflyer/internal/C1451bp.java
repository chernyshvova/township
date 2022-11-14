package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFInAppEventType;

/* renamed from: com.appsflyer.internal.bp */
public final class C1451bp extends C1445bj {
    public C1451bp(@NonNull Context context) {
        super(AFInAppEventType.PURCHASE, Boolean.TRUE, context);
    }

    public final C1480h values(String str) {
        return super.values(AFInAppEventType(str));
    }
}
