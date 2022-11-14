package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;
import com.facebook.FacebookException;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.facebook.internal.FacebookDialogBase$createActivityResultContractForShowingDialog$1 */
/* compiled from: FacebookDialogBase.kt */
public final class C1558x81c24930 extends ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> {
    public final /* synthetic */ CallbackManager $callbackManager;
    public final /* synthetic */ Object $mode;
    public final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

    public C1558x81c24930(FacebookDialogBase<CONTENT, RESULT> facebookDialogBase, Object obj, CallbackManager callbackManager) {
        this.this$0 = facebookDialogBase;
        this.$mode = obj;
        this.$callbackManager = callbackManager;
    }

    public Intent createIntent(Context context, CONTENT content) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        AppCall access$createAppCallForMode = this.this$0.createAppCallForMode(content, this.$mode);
        if (access$createAppCallForMode == null) {
            intent = null;
        } else {
            intent = access$createAppCallForMode.getRequestIntent();
        }
        if (intent != null) {
            access$createAppCallForMode.setPending();
            return intent;
        }
        throw new FacebookException("Content " + content + " is not supported");
    }

    public CallbackManager.ActivityResultParameters parseResult(int i, Intent intent) {
        CallbackManager callbackManager = this.$callbackManager;
        if (callbackManager != null) {
            callbackManager.onActivityResult(this.this$0.getRequestCode(), i, intent);
        }
        return new CallbackManager.ActivityResultParameters(this.this$0.getRequestCode(), i, intent);
    }
}
