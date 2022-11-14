package com.helpshift.support.util;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.helpshift.common.domain.AttachmentFileManagerDM;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.support.HSApiData;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.IOUtils;
import com.helpshift.util.ImageUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public final class AttachmentUtil {
    public static final int IMAGE_MAX_DIMENSION = 1024;
    public static final String TAG = "Helpshift_AttachUtil";

    public static String buildLocalAttachmentCopyFileName(String str) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(AttachmentFileManagerDM.LOCAL_RSC_MESSAGE_PREFIX);
        outline24.append(UUID.randomUUID().toString());
        outline24.append("0-thumbnail");
        String sb = outline24.toString();
        return str != null ? GeneratedOutlineSupport.outline17(sb, CodelessMatcher.CURRENT_CLASS_NAME, str) : sb;
    }

    public static String copyAttachment(String str) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Context applicationContext = HelpshiftContext.getApplicationContext();
        HSApiData hSApiData = new HSApiData(applicationContext);
        FileOutputStream fileOutputStream2 = null;
        try {
            String buildLocalAttachmentCopyFileName = buildLocalAttachmentCopyFileName(AndroidFileUtil.getFileExtension(str));
            File file = new File(applicationContext.getFilesDir(), buildLocalAttachmentCopyFileName);
            String absolutePath = file.getAbsolutePath();
            if (!file.exists()) {
                hSApiData.storeFile(buildLocalAttachmentCopyFileName);
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = applicationContext.openFileOutput(buildLocalAttachmentCopyFileName, 0);
                } catch (NullPointerException e) {
                    e = e;
                    fileOutputStream = null;
                    try {
                        HSLogger.m3238d(TAG, "NPE", (Throwable) e);
                        IOUtils.closeQuitely(fileOutputStream);
                        IOUtils.closeQuitely(fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        IOUtils.closeQuitely(fileOutputStream2);
                        IOUtils.closeQuitely(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuitely(fileOutputStream2);
                    IOUtils.closeQuitely(fileInputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    if (ImageUtil.isResizableImage(absolutePath)) {
                        ImageUtil.scaleDownAndSaveWithMaxDimension(absolutePath, 1024);
                    }
                    fileOutputStream2 = fileOutputStream;
                } catch (NullPointerException e2) {
                    e = e2;
                    HSLogger.m3238d(TAG, "NPE", (Throwable) e);
                    IOUtils.closeQuitely(fileOutputStream);
                    IOUtils.closeQuitely(fileInputStream);
                    return null;
                }
            } else {
                fileInputStream = null;
            }
            IOUtils.closeQuitely(fileOutputStream2);
            IOUtils.closeQuitely(fileInputStream);
            return absolutePath;
        } catch (NullPointerException e3) {
            e = e3;
            fileOutputStream = null;
            fileInputStream = null;
            HSLogger.m3238d(TAG, "NPE", (Throwable) e);
            IOUtils.closeQuitely(fileOutputStream);
            IOUtils.closeQuitely(fileInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            IOUtils.closeQuitely(fileOutputStream2);
            IOUtils.closeQuitely(fileInputStream);
            throw th;
        }
    }

    public static void copyAttachment(@NonNull AttachmentPickerFile attachmentPickerFile) throws IOException {
        InputStream inputStream;
        Uri uri = (Uri) attachmentPickerFile.transientUri;
        if (uri == null) {
            HSLogger.m3237d(TAG, "Can't proceed if uri is null");
            return;
        }
        Context applicationContext = HelpshiftContext.getApplicationContext();
        HSApiData hSApiData = new HSApiData(applicationContext);
        FileOutputStream fileOutputStream = null;
        try {
            String buildLocalAttachmentCopyFileName = buildLocalAttachmentCopyFileName(AndroidFileUtil.getFileExtensionFromMimeType(applicationContext, uri));
            File file = new File(applicationContext.getFilesDir(), buildLocalAttachmentCopyFileName);
            String absolutePath = file.getAbsolutePath();
            if (!file.exists()) {
                hSApiData.storeFile(buildLocalAttachmentCopyFileName);
                inputStream = applicationContext.getContentResolver().openInputStream(uri);
                try {
                    fileOutputStream = applicationContext.openFileOutput(buildLocalAttachmentCopyFileName, 0);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    attachmentPickerFile.filePath = absolutePath;
                    attachmentPickerFile.isFileCompressionAndCopyingDone = true;
                    if (ImageUtil.isResizableImage(absolutePath)) {
                        ImageUtil.scaleDownAndSaveWithMaxDimension(absolutePath, 1024, ImageUtil.getExifOrientation(applicationContext, uri));
                    }
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuitely((Closeable) null);
                    IOUtils.closeQuitely(inputStream);
                    throw th;
                }
            } else {
                attachmentPickerFile.filePath = absolutePath;
                attachmentPickerFile.isFileCompressionAndCopyingDone = true;
                inputStream = null;
            }
            IOUtils.closeQuitely(fileOutputStream);
            IOUtils.closeQuitely(inputStream);
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            IOUtils.closeQuitely((Closeable) null);
            IOUtils.closeQuitely(inputStream);
            throw th;
        }
    }
}
