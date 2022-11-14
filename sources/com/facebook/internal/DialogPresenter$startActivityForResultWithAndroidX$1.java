package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import androidx.activity.result.contract.ActivityResultContract;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogPresenter.kt */
public final class DialogPresenter$startActivityForResultWithAndroidX$1 extends ActivityResultContract<Intent, Pair<Integer, Intent>> {
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
