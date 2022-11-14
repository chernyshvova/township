package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import androidx.activity.result.contract.ActivityResultContract;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.facebook.login.LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1 */
/* compiled from: LoginManager.kt */
public final class C1561x357b4191 extends ActivityResultContract<Intent, Pair<Integer, Intent>> {
    public Intent createIntent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(intent, "input");
        return intent;
    }

    public Pair<Integer, Intent> parseResult(int i, Intent intent) {
        Pair<Integer, Intent> create = Pair.create(Integer.valueOf(i), intent);
        Intrinsics.checkNotNullExpressionValue(create, "create(resultCode, intent)");
        return create;
    }
}
