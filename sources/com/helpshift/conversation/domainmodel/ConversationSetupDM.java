package com.helpshift.conversation.domainmodel;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.account.domainmodel.UserSetupDM;
import com.helpshift.account.domainmodel.UserSetupState;
import com.helpshift.common.domain.network.NetworkConstants;
import com.helpshift.common.platform.Platform;
import com.helpshift.configuration.domainmodel.ConfigFetchDM;
import com.helpshift.conversation.viewmodel.ConversationSetupVMCallback;
import com.helpshift.util.Callback;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;

public class ConversationSetupDM implements UserSetupDM.UserSetupListener, Callback<Void, Void> {
    public static final String TAG = "Helpshift_ConvStpFrg";
    public ConversationSetupVMCallback callback;
    public ConfigFetchDM configFetchDM;
    public final Platform platform;
    public UserSetupDM userSetupDM;

    /* renamed from: com.helpshift.conversation.domainmodel.ConversationSetupDM$1 */
    public static /* synthetic */ class C25601 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$account$domainmodel$UserSetupState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        static {
            /*
                com.helpshift.account.domainmodel.UserSetupState[] r0 = com.helpshift.account.domainmodel.UserSetupState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$account$domainmodel$UserSetupState = r0
                com.helpshift.account.domainmodel.UserSetupState r1 = com.helpshift.account.domainmodel.UserSetupState.IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$com$helpshift$account$domainmodel$UserSetupState     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.account.domainmodel.UserSetupState r1 = com.helpshift.account.domainmodel.UserSetupState.NON_STARTED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r0 = $SwitchMap$com$helpshift$account$domainmodel$UserSetupState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.account.domainmodel.UserSetupState r1 = com.helpshift.account.domainmodel.UserSetupState.FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.domainmodel.ConversationSetupDM.C25601.<clinit>():void");
        }
    }

    public enum ConversationSetupState {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED,
        FAILED
    }

    public ConversationSetupDM(Platform platform2, ConfigFetchDM configFetchDM2, UserSetupDM userSetupDM2) {
        this.platform = platform2;
        this.configFetchDM = configFetchDM2;
        this.userSetupDM = userSetupDM2;
    }

    private void handleConfigFetchSuccessCallback() {
        HSLogger.m3237d(TAG, "Handling config fetch complete.");
        if (UserSetupState.COMPLETED == this.userSetupDM.getState()) {
            handleConversationSetupComplete();
        }
    }

    private void handleConversationSetupComplete() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Conversation setup complete. Callback: ");
        outline24.append(this.callback);
        HSLogger.m3237d(TAG, outline24.toString());
        ConversationSetupVMCallback conversationSetupVMCallback = this.callback;
        if (conversationSetupVMCallback != null) {
            conversationSetupVMCallback.onConversationSetupStateUpdate(ConversationSetupState.COMPLETED);
        }
    }

    private void handleUserSetupComplete() {
        HSLogger.m3237d(TAG, "Handling user setup complete.");
        if (StringUtils.isEmpty(this.platform.getNetworkRequestDAO().getETag(NetworkConstants.SUPPORT_CONFIG_ROUTE))) {
            this.configFetchDM.fetchServerConfig(true);
        } else {
            handleConversationSetupComplete();
        }
    }

    public ConversationSetupState getState() {
        ConversationSetupState conversationSetupState;
        UserSetupState state = this.userSetupDM.getState();
        int ordinal = state.ordinal();
        if (ordinal == 0) {
            conversationSetupState = ConversationSetupState.NOT_STARTED;
        } else if (ordinal == 1) {
            conversationSetupState = ConversationSetupState.IN_PROGRESS;
        } else if (ordinal != 3) {
            conversationSetupState = null;
        } else {
            conversationSetupState = ConversationSetupState.FAILED;
        }
        if (state != UserSetupState.COMPLETED) {
            return conversationSetupState;
        }
        if (!StringUtils.isEmpty(this.platform.getNetworkRequestDAO().getETag(NetworkConstants.SUPPORT_CONFIG_ROUTE))) {
            return ConversationSetupState.COMPLETED;
        }
        if (this.configFetchDM.isFetchInProgress()) {
            return ConversationSetupState.IN_PROGRESS;
        }
        return ConversationSetupState.IN_PROGRESS;
    }

    public void init() {
        HSLogger.m3237d(TAG, "Registering for usersetup and config fetch updates: " + this);
        this.userSetupDM.registerUserSetupListener(this);
        this.configFetchDM.setListener(this);
    }

    public void onFailure(Void voidR) {
    }

    public void setCallback(ConversationSetupVMCallback conversationSetupVMCallback) {
        this.callback = conversationSetupVMCallback;
    }

    public void startSetup() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Starting conversation setup. Callback: ");
        outline24.append(this.callback);
        HSLogger.m3237d(TAG, outline24.toString());
        ConversationSetupVMCallback conversationSetupVMCallback = this.callback;
        if (conversationSetupVMCallback != null) {
            conversationSetupVMCallback.onConversationSetupStateUpdate(getState());
        }
        if (this.userSetupDM.getState() == UserSetupState.COMPLETED) {
            handleUserSetupComplete();
        } else {
            this.userSetupDM.startSetup();
        }
    }

    public void userSetupStateChanged(UserDM userDM, UserSetupState userSetupState) {
        HSLogger.m3237d(TAG, "User setup state update: " + userSetupState);
        if (userSetupState == UserSetupState.COMPLETED) {
            handleUserSetupComplete();
        }
    }

    public void onSuccess(Void voidR) {
        handleConfigFetchSuccessCallback();
    }
}
