package com.swrve.sdk.messaging.p036ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.swrve.sdk.C1667R;
import com.swrve.sdk.QaUser;
import com.swrve.sdk.SwrveBase;
import com.swrve.sdk.SwrveDeeplinkManager;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.SwrveSDKBase;
import com.swrve.sdk.config.SwrveConfigBase;
import com.swrve.sdk.config.SwrveInAppMessageConfig;
import com.swrve.sdk.messaging.SwrveButton;
import com.swrve.sdk.messaging.SwrveMessage;
import com.swrve.sdk.messaging.SwrveMessageFormat;
import com.swrve.sdk.messaging.SwrveOrientation;
import com.swrve.sdk.messaging.view.SwrveMessageView;
import com.swrve.sdk.messaging.view.SwrveMessageViewBuildException;
import java.util.Map;

/* renamed from: com.swrve.sdk.messaging.ui.SwrveInAppMessageActivity */
public class SwrveInAppMessageActivity extends Activity {
    public static final String MESSAGE_ID_KEY = "message_id";
    public static final String SWRVE_AD_MESSAGE = "ad_message_key";
    public static final String SWRVE_PERSONALISATION_KEY = "message_personalization";
    public SwrveMessageFormat format;
    public SwrveInAppMessageConfig inAppConfig;
    public Map<String, String> inAppPersonalization;
    public SwrveMessage message;
    public int minSampleSize;
    public SwrveBase sdk;

    /* renamed from: com.swrve.sdk.messaging.ui.SwrveInAppMessageActivity$1 */
    public static /* synthetic */ class C17101 {
        public static final /* synthetic */ int[] $SwitchMap$com$swrve$sdk$messaging$SwrveActionType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                com.swrve.sdk.messaging.SwrveActionType[] r0 = com.swrve.sdk.messaging.SwrveActionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$swrve$sdk$messaging$SwrveActionType = r0
                r1 = 1
                r2 = 2
                com.swrve.sdk.messaging.SwrveActionType r3 = com.swrve.sdk.messaging.SwrveActionType.Install     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$swrve$sdk$messaging$SwrveActionType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.messaging.SwrveActionType r3 = com.swrve.sdk.messaging.SwrveActionType.Dismiss     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3 = 0
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 3
                int[] r2 = $SwitchMap$com$swrve$sdk$messaging$SwrveActionType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.swrve.sdk.messaging.SwrveActionType r3 = com.swrve.sdk.messaging.SwrveActionType.Custom     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r1 = $SwitchMap$com$swrve$sdk$messaging$SwrveActionType     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.swrve.sdk.messaging.SwrveActionType r2 = com.swrve.sdk.messaging.SwrveActionType.CopyToClipboard     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.messaging.p036ui.SwrveInAppMessageActivity.C17101.<clinit>():void");
        }
    }

    private SwrveOrientation getDeviceOrientation() {
        return SwrveOrientation.parse(getResources().getConfiguration().orientation);
    }

    private void qaUserCampaignButtonClicked(SwrveButton swrveButton) {
        if (QaUser.isLoggingEnabled()) {
            int id = this.message.getCampaign().getId();
            int variantId = this.message.getCampaign().getVariantId();
            String name = swrveButton.getName();
            int ordinal = swrveButton.getActionType().ordinal();
            String str = ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? "" : "clipboard" : SwrveDeeplinkManager.SWRVE_AD_INSTALL : "deeplink" : "dismiss";
            QaUser.campaignButtonClicked(id, variantId, name, str, SwrveHelper.isNullOrEmpty(swrveButton.getAction()) ? str : swrveButton.getAction());
        }
    }

    @VisibleForTesting
    public SwrveMessageFormat getFormat() {
        return this.format;
    }

    public void notifyOfClipboardButtonPress(SwrveButton swrveButton, String str) {
        this.sdk.buttonWasPressedByUser(swrveButton);
        this.message.getCampaign().messageDismissed();
        try {
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", str));
            if (this.sdk.getClipboardButtonListener() != null) {
                this.sdk.getClipboardButtonListener().onAction(str);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Couldn't copy text to clipboard: %s", e, str);
        }
    }

    public void notifyOfCustomButtonPress(SwrveButton swrveButton, String str) {
        this.sdk.buttonWasPressedByUser(swrveButton);
        this.message.getCampaign().messageDismissed();
        if (this.sdk.getCustomButtonListener() != null) {
            this.sdk.getCustomButtonListener().onAction(str);
        } else {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e) {
                SwrveLogger.m2753e("Couldn't launch default custom action: %s", e, str);
            }
        }
        qaUserCampaignButtonClicked(swrveButton);
    }

    public void notifyOfDismissButtonPress(SwrveButton swrveButton) {
        if (this.sdk.getDismissButtonListener() != null) {
            this.sdk.getDismissButtonListener().onAction(this.message.getCampaign().getSubject(), swrveButton.getName());
        }
        qaUserCampaignButtonClicked(swrveButton);
    }

    public void notifyOfImpression(SwrveMessageFormat swrveMessageFormat) {
        this.sdk.messageWasShownToUser(swrveMessageFormat);
    }

    public void notifyOfInstallButtonPress(SwrveButton swrveButton) {
        this.sdk.buttonWasPressedByUser(swrveButton);
        this.message.getCampaign().messageDismissed();
        String appStoreURLForApp = this.sdk.getAppStoreURLForApp(swrveButton.getAppId());
        if (SwrveHelper.isNullOrEmpty(appStoreURLForApp)) {
            SwrveLogger.m2754e("Could not launch install action as there was no app install link found. Please supply a valid app install link.", new Object[0]);
            return;
        }
        if (this.sdk.getInstallButtonListener() != null ? this.sdk.getInstallButtonListener().onAction(appStoreURLForApp) : true) {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(appStoreURLForApp)));
            } catch (ActivityNotFoundException e) {
                SwrveLogger.m2753e("Couldn't launch install action. No activity found for: %s", e, appStoreURLForApp);
            } catch (Exception e2) {
                SwrveLogger.m2753e("Couldn't launch install action for: %s", e2, appStoreURLForApp);
            }
        }
        qaUserCampaignButtonClicked(swrveButton);
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.sdk.getDismissButtonListener() != null) {
            this.sdk.getDismissButtonListener().onAction(this.message.getCampaign().getSubject(), (String) null);
        }
    }

    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        SwrveBase swrveBase = (SwrveBase) SwrveSDKBase.getInstance();
        this.sdk = swrveBase;
        if (swrveBase == null) {
            finish();
            return;
        }
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            SwrveMessage messageForId = this.sdk.getMessageForId(extras.getInt("message_id"));
            this.message = messageForId;
            if (messageForId == null && extras.getBoolean("ad_message_key")) {
                this.message = this.sdk.getAdMesage();
            }
            this.inAppPersonalization = (Map) extras.getSerializable(SWRVE_PERSONALISATION_KEY);
            SwrveConfigBase config = this.sdk.getConfig();
            this.minSampleSize = config.getMinSampleSize();
            this.inAppConfig = config.getInAppMessageConfig();
        }
        if (this.message == null) {
            finish();
            return;
        }
        SwrveMessageFormat format2 = this.message.getFormat(getDeviceOrientation());
        this.format = format2;
        if (format2 == null) {
            this.format = this.message.getFormats().get(0);
        }
        if (this.message.getFormats().size() == 1) {
            try {
                if (Build.VERSION.SDK_INT == 26 && SwrveHelper.getTargetSdkVersion(this) >= 27) {
                    SwrveLogger.m2758w("Oreo bug with setRequestedOrientation so Message may appear in wrong orientation.", new Object[0]);
                } else if (this.format.getOrientation() == SwrveOrientation.Landscape) {
                    setRequestedOrientation(11);
                } else {
                    setRequestedOrientation(12);
                }
            } catch (RuntimeException e) {
                SwrveLogger.m2753e("Bugs with setRequestedOrientation can happen: https://issuetracker.google.com/issues/68454482", e, new Object[0]);
            }
        }
        if (!this.inAppConfig.isHideToolbar()) {
            setTheme(C1667R.style.Theme_InAppMessageWithToolbar);
        }
        try {
            setContentView(new SwrveMessageView(this, this.message, this.format, this.minSampleSize, this.inAppConfig, this.inAppPersonalization));
            if (bundle == null) {
                notifyOfImpression(this.format);
            }
        } catch (SwrveMessageViewBuildException e2) {
            SwrveLogger.m2753e("Error while creating the SwrveMessageView", e2, new Object[0]);
        }
        if (this.inAppConfig.getWindowListener() != null) {
            this.inAppConfig.getWindowListener().onCreate(getWindow());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        SwrveMessage swrveMessage = this.message;
        if (swrveMessage != null && swrveMessage.getCampaign() != null) {
            this.message.getCampaign().messageDismissed();
        }
    }
}
