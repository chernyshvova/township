package com.helpshift.support.widget;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.helpshift.common.platform.Device;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.support.fragments.AttachmentPreviewFragment;
import com.helpshift.support.widget.AttachmentPicker.AttachmentPickerListener;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.AttachmentConstants;
import com.helpshift.util.AttachmentDataProvider;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HSPattern;
import com.helpshift.util.ImageUtil;
import java.lang.ref.WeakReference;
import java.util.List;

public class AttachmentPicker<T extends Fragment & AttachmentPickerListener> {
    public static final int ATTACHMENT_FILE_NOT_FOUND = -1;
    public static final int ATTACHMENT_FILE_SIZE_LIMIT_EXCEEDED = -3;
    public static final int INVALID_URI = -5;
    public static final long MAX_ATTACHMENT_FILE_SIZE_LIMIT = 26214400;
    public static final int NO_APPS_TO_OPEN_ATTACHMENTS_INTENT = -4;
    public static final String TAG = "Helpshift_AttPicker";
    public static final int UNSUPPORTED_ATTACHMENT_TYPE = -2;
    public final String KEY_EXTRA_DATA = "key_extra_data";
    public WeakReference<T> attachmentPickerListenerRef;
    public final Context context;
    public final Device device;
    public Bundle extraData;
    public SDKConfigurationDM sdkConfigurationDM;
    public int selectedAttachmentTypeOption;

    /* renamed from: com.helpshift.support.widget.AttachmentPicker$1 */
    public static /* synthetic */ class C28171 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$common$platform$Device$PermissionState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.helpshift.common.platform.Device$PermissionState[] r0 = com.helpshift.common.platform.Device.PermissionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$common$platform$Device$PermissionState = r0
                r1 = 1
                com.helpshift.common.platform.Device$PermissionState r2 = com.helpshift.common.platform.Device.PermissionState.AVAILABLE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$helpshift$common$platform$Device$PermissionState     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.common.platform.Device$PermissionState r3 = com.helpshift.common.platform.Device.PermissionState.UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = $SwitchMap$com$helpshift$common$platform$Device$PermissionState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.common.platform.Device$PermissionState r2 = com.helpshift.common.platform.Device.PermissionState.REQUESTABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.widget.AttachmentPicker.C28171.<clinit>():void");
        }
    }

    public interface AttachmentPickerListener {
        void askForReadStoragePermission();

        void onAttachmentPickerResultFailure(int i, Long l);

        void onAttachmentPickerResultSuccess(AttachmentPickerFile attachmentPickerFile, Bundle bundle);
    }

    public AttachmentPicker(Context context2, Device device2, T t, SDKConfigurationDM sDKConfigurationDM) {
        this.context = context2;
        this.device = device2;
        this.attachmentPickerListenerRef = new WeakReference<>(t);
        this.sdkConfigurationDM = sDKConfigurationDM;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.helpshift.conversation.dto.AttachmentPickerFile createAttachmentPickerFileFromUri(android.net.Uri r9) {
        /*
            r8 = this;
            android.content.Context r0 = r8.context
            android.content.ContentResolver r0 = r0.getContentResolver()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r0
            r2 = r9
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)
            r2 = 0
            if (r1 == 0) goto L_0x0069
            boolean r3 = r1.moveToFirst()     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x0069
            java.lang.String r3 = "_display_name"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = r0.getType(r9)     // Catch:{ all -> 0x0064 }
            boolean r4 = com.helpshift.util.StringUtils.isEmpty(r3)     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0035
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0064 }
        L_0x0035:
            java.lang.String r4 = "_size"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ all -> 0x0064 }
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x006b
            java.lang.String r4 = r1.getString(r4)     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x006b
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x004c }
            goto L_0x006b
        L_0x004c:
            r4 = move-exception
            java.lang.String r5 = "Helpshift_AttPicker"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r6.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r7 = "Error getting size due to "
            r6.append(r7)     // Catch:{ all -> 0x0064 }
            r6.append(r4)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0064 }
            com.helpshift.util.HSLogger.m3237d(r5, r4)     // Catch:{ all -> 0x0064 }
            goto L_0x006b
        L_0x0064:
            r9 = move-exception
            r1.close()
            throw r9
        L_0x0069:
            r0 = r2
            r3 = r0
        L_0x006b:
            if (r1 == 0) goto L_0x0070
            r1.close()
        L_0x0070:
            com.helpshift.conversation.dto.AttachmentPickerFile r1 = new com.helpshift.conversation.dto.AttachmentPickerFile
            r1.<init>((java.lang.Object) r9, (java.lang.String) r3, (java.lang.Long) r2)
            boolean r9 = com.helpshift.util.StringUtils.isEmpty(r0)
            if (r9 != 0) goto L_0x0087
            java.lang.String r9 = "image/"
            boolean r9 = r0.startsWith(r9)
            if (r9 == 0) goto L_0x0087
            r9 = 1
            r1.attachmentType = r9
            goto L_0x008b
        L_0x0087:
            int r9 = r8.selectedAttachmentTypeOption
            r1.attachmentType = r9
        L_0x008b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.widget.AttachmentPicker.createAttachmentPickerFileFromUri(android.net.Uri):com.helpshift.conversation.dto.AttachmentPickerFile");
    }

    private int getSelectedAttachmentTypeOption() {
        return this.extraData.getInt(AttachmentPreviewFragment.KEY_ATTACHMENT_TYPE);
    }

    private boolean isAttachmentWhiteListed(Uri uri) {
        List<String> whiteListAttachmentMimeTypes = this.sdkConfigurationDM.getWhiteListAttachmentMimeTypes();
        if (whiteListAttachmentMimeTypes.contains(AttachmentConstants.ALLOW_ALL_MIME)) {
            return true;
        }
        String type = this.context.getContentResolver().getType(uri);
        boolean equals = AttachmentConstants.UNKNOWN_FILE_MIME.equals(type);
        if (whiteListAttachmentMimeTypes.contains(type) || !HSPattern.isValidMime(type) || equals) {
            return true;
        }
        return false;
    }

    private boolean isUriValid(Uri uri) {
        return "content".equals(uri.getScheme());
    }

    private void processUriForAttachment(Uri uri) {
        if (!isUriValid(uri)) {
            HSLogger.m3237d(TAG, "Attachment picker file invalid mime type, returning failure");
            sendAttachmentPickerResultFailureCallback(-5, (Long) null);
        } else if (!isAttachmentWhiteListed(uri)) {
            HSLogger.m3237d(TAG, "Attachment picker file invalid mime type, returning failure");
            sendAttachmentPickerResultFailureCallback(-2, (Long) null);
        } else if (AndroidFileUtil.doesFileFromUriExistAndCanRead(uri, this.context)) {
            AttachmentPickerFile createAttachmentPickerFileFromUri = createAttachmentPickerFileFromUri(uri);
            Long l = createAttachmentPickerFileFromUri.originalFileSize;
            if (l == null || l.longValue() <= MAX_ATTACHMENT_FILE_SIZE_LIMIT || (createAttachmentPickerFileFromUri.attachmentType == 1 && ImageUtil.isResizableImage(uri, this.context))) {
                HSLogger.m3237d(TAG, "Attachment picker result success, path: " + uri);
                sendAttachmentPickerResultSuccessCallback(createAttachmentPickerFileFromUri, this.extraData);
                return;
            }
            HSLogger.m3237d(TAG, "Attachment picker file size limit exceeded (in bytes): " + l + ", returning failure");
            sendAttachmentPickerResultFailureCallback(-3, Long.valueOf(MAX_ATTACHMENT_FILE_SIZE_LIMIT));
        } else {
            HSLogger.m3237d(TAG, "Attachment picker file reading error, returning failure");
            sendAttachmentPickerResultFailureCallback(-1, (Long) null);
        }
    }

    private void sendAttachmentPickerResultFailureCallback(int i, Long l) {
        Fragment fragment = (Fragment) this.attachmentPickerListenerRef.get();
        if (fragment != null) {
            ((AttachmentPickerListener) fragment).onAttachmentPickerResultFailure(i, l);
        }
    }

    private void sendAttachmentPickerResultSuccessCallback(AttachmentPickerFile attachmentPickerFile, Bundle bundle) {
        Fragment fragment = (Fragment) this.attachmentPickerListenerRef.get();
        if (fragment != null) {
            ((AttachmentPickerListener) fragment).onAttachmentPickerResultSuccess(attachmentPickerFile, bundle);
        }
    }

    private void startActivityForResult(Intent intent, int i) {
        try {
            Fragment fragment = (Fragment) this.attachmentPickerListenerRef.get();
            if (fragment != null && fragment.getActivity() != null) {
                fragment.startActivityForResult(intent, i);
            }
        } catch (ActivityNotFoundException e) {
            HSLogger.m3241e(TAG, "Error occurred while starting app for handling attachment pick intent " + e);
            sendAttachmentPickerResultFailureCallback(-4, (Long) null);
        }
    }

    public void launchPicker(Bundle bundle) {
        this.extraData = bundle;
        this.selectedAttachmentTypeOption = getSelectedAttachmentTypeOption();
        HSLogger.m3237d(TAG, "Checking permission before launching attachment picker");
        int ordinal = this.device.checkPermission(Device.PermissionType.READ_STORAGE).ordinal();
        if (ordinal == 0) {
            startActivityForResult(AttachmentDataProvider.getIntentForAttachmentType(this.context, this.selectedAttachmentTypeOption, 1, this.sdkConfigurationDM.getWhiteListAttachmentMimeTypes()), 1);
        } else if (ordinal == 1) {
            HSLogger.m3237d(TAG, "READ_STORAGE permission is not granted and can't be requested, starting alternate flow");
            startActivityForResult(AttachmentDataProvider.getIntentForAttachmentType(this.context, this.selectedAttachmentTypeOption, 2, this.sdkConfigurationDM.getWhiteListAttachmentMimeTypes()), 2);
        } else if (ordinal == 2) {
            HSLogger.m3237d(TAG, "READ_STORAGE permission is not granted but can be requested");
            Fragment fragment = (Fragment) this.attachmentPickerListenerRef.get();
            if (fragment != null) {
                ((AttachmentPickerListener) fragment).askForReadStoragePermission();
            }
        }
    }

    public void onAttachmentPickRequestResult(int i, Intent intent) {
        Uri data = intent.getData();
        if (i == 1) {
            HSLogger.m3237d(TAG, "Processing attachment uri with flow when permissions are available");
            processUriForAttachment(data);
        } else if (i == 2) {
            HSLogger.m3237d(TAG, "Processing attachment uri with flow when permissions are not available");
            this.context.getContentResolver().takePersistableUriPermission(data, intent.getFlags() & 1);
            processUriForAttachment(data);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBundle("key_extra_data", this.extraData);
    }

    public void onViewStateRestored(Bundle bundle) {
        if (bundle.containsKey("key_extra_data")) {
            this.extraData = bundle.getBundle("key_extra_data");
        }
    }
}
