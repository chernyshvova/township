package com.helpshift.support.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.helpshift.C2466R;
import com.helpshift.common.domain.AttachmentFileManagerDM;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.conversation.activeconversation.AttachmentPreviewRenderer;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.viewmodel.AttachmentPreviewVM;
import com.helpshift.support.contracts.AttachmentPreviewListener;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.imageloader.ImageLoader;
import com.helpshift.support.storage.IMAppSessionStorage;
import com.helpshift.support.util.AppSessionConstants;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.support.util.Styles;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.AttachmentFileSize;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.StringUtils;

public class AttachmentPreviewFragment extends MainFragment implements View.OnClickListener, AttachmentFileManagerDM.Listener, AttachmentPreviewRenderer {
    public static final String FRAGMENT_TAG = "AttachmentPreviewFragment";
    public static final String KEY_ATTACHMENT_MODE = "key_attachment_mode";
    public static final String KEY_ATTACHMENT_TYPE = "key_attachment_type";
    public static final String KEY_MESSAGE_REFERS_ID = "key_refers_id";
    public static final AppSessionConstants.Screen screenType = AppSessionConstants.Screen.SCREENSHOT_PREVIEW;
    public TextView attachmentFileNameView;
    public TextView attachmentFileSizeView;
    public TextView attachmentFileTypeView;
    public String attachmentMessageRefersId;
    public AttachmentPickerFile attachmentPickerFile;
    public int attachmentPickerType;
    public AttachmentPreviewListener attachmentPreviewListener;
    public AttachmentPreviewVM attachmentPreviewVM;
    public View buttonsContainer;
    public View genericAttachmentPreview;
    public LaunchSource launchSource;
    public int mode;
    public ProgressBar progressBar;
    public ImageView screenshotPreview;
    public Button secondaryButton;

    public enum AttachmentAction {
        ADD,
        SEND,
        REMOVE,
        CHANGE
    }

    public enum LaunchSource {
        ATTACHMENT_DRAFT,
        GALLERY_APP
    }

    public static class Modes {
        public static final int ADD = 1;
        public static final int REMOVE = 2;
        public static final int SEND = 3;
    }

    public static Drawable getSendIconAsDrawable(Context context) {
        Drawable mutate = context.getResources().getDrawable(Styles.getResourceIdForAttribute(context, C2466R.attr.hs__messageSendIcon)).mutate();
        com.helpshift.util.Styles.setColorFilter(context, mutate, 16842809);
        return mutate;
    }

    public static AttachmentPreviewFragment newInstance(AttachmentPreviewListener attachmentPreviewListener2) {
        AttachmentPreviewFragment attachmentPreviewFragment = new AttachmentPreviewFragment();
        attachmentPreviewFragment.attachmentPreviewListener = attachmentPreviewListener2;
        return attachmentPreviewFragment;
    }

    private void setAttachmentPreview() {
        if (isResumed()) {
            AttachmentPickerFile attachmentPickerFile2 = this.attachmentPickerFile;
            if (attachmentPickerFile2 == null) {
                AttachmentPreviewListener attachmentPreviewListener2 = this.attachmentPreviewListener;
                if (attachmentPreviewListener2 != null) {
                    attachmentPreviewListener2.removeAttachmentPreviewFragment();
                    return;
                }
                return;
            }
            String str = attachmentPickerFile2.filePath;
            if (str != null) {
                renderPreview(str);
            } else if (attachmentPickerFile2.transientUri != null) {
                toggleProgressBarViewsVisibility(true);
                HelpshiftContext.getCoreApi().getAttachmentFileManagerDM().compressAndCopyAttachment(this.attachmentPickerFile, this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setSecondaryButtonTextAndDrawable(android.widget.Button r3, int r4) {
        /*
            android.content.res.Resources r0 = r3.getResources()
            r1 = 1
            r2 = 0
            if (r4 == r1) goto L_0x0027
            r1 = 2
            if (r4 == r1) goto L_0x0020
            r1 = 3
            if (r4 == r1) goto L_0x0011
            java.lang.String r4 = ""
            goto L_0x002d
        L_0x0011:
            int r4 = com.helpshift.C2466R.string.hs__send_msg_btn
            java.lang.String r4 = r0.getString(r4)
            android.content.Context r0 = r3.getContext()
            android.graphics.drawable.Drawable r0 = getSendIconAsDrawable(r0)
            goto L_0x002e
        L_0x0020:
            int r4 = com.helpshift.C2466R.string.hs__screenshot_remove
            java.lang.String r4 = r0.getString(r4)
            goto L_0x002d
        L_0x0027:
            int r4 = com.helpshift.C2466R.string.hs__screenshot_add
            java.lang.String r4 = r0.getString(r4)
        L_0x002d:
            r0 = r2
        L_0x002e:
            r3.setText(r4)
            if (r0 == 0) goto L_0x0036
            r3.setCompoundDrawablesWithIntrinsicBounds(r0, r2, r2, r2)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.fragments.AttachmentPreviewFragment.setSecondaryButtonTextAndDrawable(android.widget.Button, int):void");
    }

    public void deleteAttachmentLocalCopy() {
        if (this.launchSource == LaunchSource.GALLERY_APP) {
            HelpshiftContext.getCoreApi().getAttachmentFileManagerDM().deleteAttachmentLocalCopy(this.attachmentPickerFile);
        }
    }

    public void onAuthenticationFailure() {
        SupportController supportController = ((SupportFragment) getParentFragment()).getSupportController();
        if (supportController != null) {
            supportController.onAuthenticationFailure();
        }
    }

    public void onClick(View view) {
        AttachmentPickerFile attachmentPickerFile2;
        int id = view.getId();
        if (id == C2466R.C2468id.secondary_button && (attachmentPickerFile2 = this.attachmentPickerFile) != null) {
            int i = this.mode;
            if (i == 1) {
                this.attachmentPreviewListener.addAttachment(attachmentPickerFile2);
            } else if (i == 2) {
                HelpshiftContext.getCoreApi().getAttachmentFileManagerDM().deleteAttachmentLocalCopy(this.attachmentPickerFile);
                this.attachmentPreviewListener.removeAttachment();
            } else if (i == 3) {
                this.attachmentPreviewListener.sendAttachment(attachmentPickerFile2, this.attachmentMessageRefersId);
            }
        } else if (id == C2466R.C2468id.change) {
            if (this.mode == 2) {
                this.mode = 1;
            }
            HelpshiftContext.getCoreApi().getAttachmentFileManagerDM().deleteAttachmentLocalCopy(this.attachmentPickerFile);
            this.attachmentPickerFile = null;
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_ATTACHMENT_MODE, this.mode);
            bundle.putString(KEY_MESSAGE_REFERS_ID, this.attachmentMessageRefersId);
            bundle.putInt(KEY_ATTACHMENT_TYPE, this.attachmentPickerType);
            this.attachmentPreviewListener.changeAttachment(bundle);
        }
    }

    public void onCompressAndCopyFailure(RootAPIException rootAPIException) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    AttachmentPreviewFragment.this.progressBar.setVisibility(8);
                    SnackbarUtil.showSnackbar(AttachmentPreviewFragment.this.getView(), C2466R.string.hs__screenshot_cloud_attach_error, -2);
                }
            });
        }
    }

    public void onCompressAndCopySuccess(final AttachmentPickerFile attachmentPickerFile2) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    AttachmentPreviewFragment.this.toggleProgressBarViewsVisibility(false);
                    AttachmentPreviewFragment.this.renderPreview(attachmentPickerFile2.filePath);
                }
            });
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__attachment_preview_fragment, viewGroup, false);
    }

    public void onDestroyView() {
        this.attachmentPreviewVM.unregisterRenderer();
        ImageLoader.getInstance().cancelAll();
        super.onDestroyView();
    }

    public void onPause() {
        SnackbarUtil.hideSnackbar(getView());
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        setSecondaryButtonTextAndDrawable(this.secondaryButton, this.mode);
        setAttachmentPreview();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        setToolbarTitle(getString(C2466R.string.hs__preview_header));
    }

    public void onStart() {
        super.onStart();
        IMAppSessionStorage.getInstance().set(AppSessionConstants.CURRENT_OPEN_SCREEN, screenType);
    }

    public void onStop() {
        super.onStop();
        AppSessionConstants.Screen screen = (AppSessionConstants.Screen) IMAppSessionStorage.getInstance().get(AppSessionConstants.CURRENT_OPEN_SCREEN);
        if (screen != null && screen.equals(screenType)) {
            IMAppSessionStorage.getInstance().removeKey(AppSessionConstants.CURRENT_OPEN_SCREEN);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.attachmentPreviewVM = HelpshiftContext.getCoreApi().getAttachmentPreviewModel(this);
        this.screenshotPreview = (ImageView) view.findViewById(C2466R.C2468id.screenshot_preview);
        this.genericAttachmentPreview = view.findViewById(C2466R.C2468id.generic_attachment_preview);
        this.attachmentFileNameView = (TextView) view.findViewById(C2466R.C2468id.attachment_file_name);
        this.attachmentFileTypeView = (TextView) view.findViewById(C2466R.C2468id.attachment_file_type);
        this.attachmentFileSizeView = (TextView) view.findViewById(C2466R.C2468id.attachment_file_size);
        ((Button) view.findViewById(C2466R.C2468id.change)).setOnClickListener(this);
        Button button = (Button) view.findViewById(C2466R.C2468id.secondary_button);
        this.secondaryButton = button;
        button.setOnClickListener(this);
        this.progressBar = (ProgressBar) view.findViewById(C2466R.C2468id.screenshot_loading_indicator);
        this.buttonsContainer = view.findViewById(C2466R.C2468id.button_containers);
    }

    public void renderPreview(String str) {
        if (this.attachmentPickerFile.attachmentType == 1) {
            this.genericAttachmentPreview.setVisibility(8);
            this.screenshotPreview.setVisibility(0);
            ImageLoader.getInstance().loadImageWithoutSampling(str, this.screenshotPreview, getContext().getResources().getDrawable(C2466R.C2467drawable.hs__placeholder_image), -1);
            return;
        }
        this.genericAttachmentPreview.setVisibility(0);
        this.screenshotPreview.setVisibility(8);
        this.attachmentFileNameView.setText(this.attachmentPickerFile.originalFileName);
        String fileExtension = AndroidFileUtil.getFileExtension(this.attachmentPickerFile.originalFileName);
        String str2 = "";
        if (!StringUtils.isEmpty(fileExtension)) {
            String upperCase = fileExtension.replace(CodelessMatcher.CURRENT_CLASS_NAME, str2).toUpperCase();
            str2 = getString(C2466R.string.hs__file_type, upperCase);
        }
        this.attachmentFileTypeView.setText(str2);
        this.attachmentFileSizeView.setText(AttachmentFileSize.getFormattedFileSize((double) this.attachmentPickerFile.originalFileSize.longValue()));
    }

    public void setAttachmentPreviewListener(AttachmentPreviewListener attachmentPreviewListener2) {
        this.attachmentPreviewListener = attachmentPreviewListener2;
    }

    public void setParams(@NonNull Bundle bundle, AttachmentPickerFile attachmentPickerFile2, LaunchSource launchSource2) {
        this.mode = bundle.getInt(KEY_ATTACHMENT_MODE);
        this.attachmentMessageRefersId = bundle.getString(KEY_MESSAGE_REFERS_ID);
        this.attachmentPickerType = bundle.getInt(KEY_ATTACHMENT_TYPE);
        this.attachmentPickerFile = attachmentPickerFile2;
        this.launchSource = launchSource2;
        setAttachmentPreview();
    }

    public boolean shouldRefreshMenu() {
        return true;
    }

    public void toggleProgressBarViewsVisibility(boolean z) {
        if (z) {
            this.progressBar.setVisibility(0);
            this.buttonsContainer.setVisibility(8);
            this.screenshotPreview.setVisibility(8);
            this.genericAttachmentPreview.setVisibility(8);
            return;
        }
        this.progressBar.setVisibility(8);
        this.buttonsContainer.setVisibility(0);
        if (this.attachmentPickerFile.attachmentType == 1) {
            this.screenshotPreview.setVisibility(0);
        } else {
            this.genericAttachmentPreview.setVisibility(0);
        }
    }
}
