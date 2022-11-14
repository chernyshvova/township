package com.swrve.sdk.conversations.p035ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.drive.DriveFile;
import com.swrve.sdk.SwrveBaseConversation;
import com.swrve.sdk.SwrveConversationEventHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.ConversationPage;
import com.swrve.sdk.messaging.SwrveOrientation;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.swrve.sdk.conversations.ui.ConversationActivity */
public class ConversationActivity extends FragmentActivity {
    public static final String EXTRA_CONVERSATION_KEY = "conversation";
    public static final String EXTRA_ORIENTATION_KEY = "orientation";
    public ConversationFragment conversationFragment;
    public SwrveBaseConversation localConversation;

    /* renamed from: com.swrve.sdk.conversations.ui.ConversationActivity$1 */
    public static /* synthetic */ class C17001 {

        /* renamed from: $SwitchMap$com$swrve$sdk$conversations$engine$model$ConversationAtom$TYPE */
        public static final /* synthetic */ int[] f2792x6c668315;

        static {
            int[] iArr = new int[ConversationAtom.TYPE.values().length];
            f2792x6c668315 = iArr;
            try {
                ConversationAtom.TYPE type = ConversationAtom.TYPE.UNKNOWN;
                iArr[6] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static boolean hasUnknownContentAtoms(SwrveBaseConversation swrveBaseConversation) {
        Iterator<ConversationPage> it = swrveBaseConversation.getPages().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Iterator<ConversationAtom> it2 = it.next().getContent().iterator();
            while (it2.hasNext()) {
                if (it2.next().getType().ordinal() == 6) {
                    z = true;
                }
            }
            if (z) {
                break;
            }
        }
        return z;
    }

    public static boolean showConversation(Context context, SwrveBaseConversation swrveBaseConversation, SwrveOrientation swrveOrientation) {
        if (context == null) {
            SwrveLogger.m2754e("Can't display ConversationActivity without a context.", new Object[0]);
            return false;
        } else if (hasUnknownContentAtoms(swrveBaseConversation)) {
            SwrveLogger.m2754e("This sdk cannot display Conversations with Unknown Atoms. Conversation.id:%s", Integer.valueOf(swrveBaseConversation.getId()));
            new SwrveConversationEventHelper().conversationEncounteredError(swrveBaseConversation, "UNKNOWN_ATOM", (Exception) null);
            return false;
        } else {
            Intent intent = new Intent(context, ConversationActivity.class);
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.putExtra(EXTRA_CONVERSATION_KEY, swrveBaseConversation);
            intent.putExtra("orientation", swrveOrientation);
            context.startActivity(intent);
            return true;
        }
    }

    public ConversationFragment getConversationFragment() {
        return this.conversationFragment;
    }

    public void onBackPressed() {
        boolean z;
        try {
            z = this.conversationFragment.onBackPressed();
        } catch (NullPointerException e) {
            SwrveLogger.m2753e("Could not call the ConversationFragments onBackPressed()", e, new Object[0]);
            z = true;
        }
        if (z) {
            super.onBackPressed();
        }
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            android.content.Intent r5 = r4.getIntent()
            com.swrve.sdk.messaging.SwrveOrientation r0 = com.swrve.sdk.messaging.SwrveOrientation.Both
            if (r5 == 0) goto L_0x0024
            android.os.Bundle r5 = r5.getExtras()
            if (r5 == 0) goto L_0x0024
            java.lang.String r0 = "conversation"
            java.io.Serializable r0 = r5.getSerializable(r0)
            com.swrve.sdk.SwrveBaseConversation r0 = (com.swrve.sdk.SwrveBaseConversation) r0
            r4.localConversation = r0
            java.lang.String r0 = "orientation"
            java.io.Serializable r5 = r5.getSerializable(r0)
            r0 = r5
            com.swrve.sdk.messaging.SwrveOrientation r0 = (com.swrve.sdk.messaging.SwrveOrientation) r0
        L_0x0024:
            r5 = 0
            com.swrve.sdk.SwrveBaseConversation r1 = r4.localConversation     // Catch:{ Exception -> 0x0044 }
            if (r1 == 0) goto L_0x0039
            com.swrve.sdk.SwrveBaseConversation r1 = r4.localConversation     // Catch:{ Exception -> 0x0044 }
            com.swrve.sdk.conversations.ui.ConversationFragment r1 = com.swrve.sdk.conversations.p035ui.ConversationFragment.create(r1)     // Catch:{ Exception -> 0x0044 }
            r4.conversationFragment = r1     // Catch:{ Exception -> 0x0044 }
            androidx.fragment.app.FragmentManager r2 = r4.getSupportFragmentManager()     // Catch:{ Exception -> 0x0044 }
            r1.commitConversationFragment(r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x004f
        L_0x0039:
            java.lang.String r1 = "Could not render ConversationActivity. No SwrveConversation was detected"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0044 }
            com.swrve.sdk.SwrveLogger.m2754e(r1, r2)     // Catch:{ Exception -> 0x0044 }
            r4.finish()     // Catch:{ Exception -> 0x0044 }
            goto L_0x004f
        L_0x0044:
            r1 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.String r3 = "Could not render ConversationActivity."
            com.swrve.sdk.SwrveLogger.m2753e(r3, r1, r2)
            r4.finish()
        L_0x004f:
            com.swrve.sdk.messaging.SwrveOrientation r1 = com.swrve.sdk.messaging.SwrveOrientation.Both
            if (r0 == r1) goto L_0x0085
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ RuntimeException -> 0x007d }
            r2 = 26
            if (r1 != r2) goto L_0x0069
            int r1 = com.swrve.sdk.SwrveHelper.getTargetSdkVersion(r4)     // Catch:{ RuntimeException -> 0x007d }
            r2 = 27
            if (r1 < r2) goto L_0x0069
            java.lang.String r0 = "Oreo bug with setRequestedOrientation so Conversation may appear in wrong orientation."
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ RuntimeException -> 0x007d }
            com.swrve.sdk.SwrveLogger.m2758w(r0, r1)     // Catch:{ RuntimeException -> 0x007d }
            goto L_0x0085
        L_0x0069:
            com.swrve.sdk.messaging.SwrveOrientation r1 = com.swrve.sdk.messaging.SwrveOrientation.Landscape     // Catch:{ RuntimeException -> 0x007d }
            if (r0 != r1) goto L_0x0073
            r0 = 11
            r4.setRequestedOrientation(r0)     // Catch:{ RuntimeException -> 0x007d }
            goto L_0x0085
        L_0x0073:
            com.swrve.sdk.messaging.SwrveOrientation r1 = com.swrve.sdk.messaging.SwrveOrientation.Portrait     // Catch:{ RuntimeException -> 0x007d }
            if (r0 != r1) goto L_0x0085
            r0 = 12
            r4.setRequestedOrientation(r0)     // Catch:{ RuntimeException -> 0x007d }
            goto L_0x0085
        L_0x007d:
            r0 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r1 = "Bugs with setRequestedOrientation can happen: https://issuetracker.google.com/issues/68454482"
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r5)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.conversations.p035ui.ConversationActivity.onCreate(android.os.Bundle):void");
    }

    public void onRestoreInstanceState(Bundle bundle) {
        SwrveBaseConversation swrveBaseConversation;
        super.onRestoreInstanceState(bundle);
        if (bundle != null && (swrveBaseConversation = this.localConversation) != null) {
            this.conversationFragment = ConversationFragment.create(swrveBaseConversation);
            ConversationPage conversationPage = (ConversationPage) bundle.getSerializable("page");
            HashMap hashMap = (HashMap) bundle.getSerializable("userdata");
            if (conversationPage != null) {
                this.conversationFragment.setPage(conversationPage);
            }
            if (hashMap != null) {
                this.conversationFragment.setUserInteractionData(hashMap);
            }
            this.conversationFragment.commitConversationFragment(getSupportFragmentManager());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("page", this.conversationFragment.getPage());
        bundle.putSerializable("userdata", this.conversationFragment.getUserInteractionData());
        super.onSaveInstanceState(bundle);
    }
}
