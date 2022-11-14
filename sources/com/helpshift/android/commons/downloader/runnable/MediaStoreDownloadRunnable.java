package com.helpshift.android.commons.downloader.runnable;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.android.commons.downloader.HsUriUtils;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.storage.DownloadInProgressCacheDbStorage;
import com.helpshift.util.HSLogger;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

public class MediaStoreDownloadRunnable extends BaseDownloadRunnable {
    public static final String TAG = "Helpshift_mediaRun";
    public Context context;
    public DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage;

    public MediaStoreDownloadRunnable(Context context2, DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage2, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        super(downloadRequestedFileInfo, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        this.context = context2;
        this.downloadInProgressCacheDbStorage = downloadInProgressCacheDbStorage2;
    }

    private Uri buildUri(String str) {
        if (!HsUriUtils.canReadFileAtUri(this.context, str)) {
            return null;
        }
        try {
            return Uri.parse(str);
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error while converting filePath to uri", e);
            return null;
        }
    }

    private Uri createFile(String str, String str2) {
        Uri uri;
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = this.context.getContentResolver();
        if (isImageType(str2)) {
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", str2);
            contentValues.put("is_pending", 1);
            uri = MediaStore.Images.Media.getContentUri("external_primary");
        } else {
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", str2);
            contentValues.put("is_pending", 1);
            uri = MediaStore.Downloads.getContentUri("external_primary");
        }
        return contentResolver.insert(uri, contentValues);
    }

    private void deleteUri(Uri uri) {
        if (uri != null) {
            try {
                this.context.getContentResolver().delete(uri, (String) null, (String[]) null);
            } catch (Exception e) {
                HSLogger.m3242e(TAG, "Error when deleting a file via uri", e);
            }
        }
    }

    private String generateFileName() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Support_");
        outline24.append(System.currentTimeMillis());
        String str = this.requestInfo.url;
        outline24.append(str.substring(str.lastIndexOf("/") + 1));
        return outline24.toString();
    }

    private Uri getCachedFileUri() {
        String filePath = this.downloadInProgressCacheDbStorage.getFilePath();
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        Uri buildUri = buildUri(filePath);
        if (buildUri != null) {
            return buildUri;
        }
        this.downloadInProgressCacheDbStorage.removeFilePath();
        return null;
    }

    private Uri getFileUriToWriteResponseData() {
        Uri cachedFileUri = getCachedFileUri();
        if (cachedFileUri != null) {
            return cachedFileUri;
        }
        return createFile(generateFileName(), this.requestInfo.contentType);
    }

    private boolean isImageType(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Pattern.compile("image/.*").matcher(str).matches();
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error when check image mime type", e);
            return false;
        }
    }

    private void updateIsPendingFlag(Uri uri, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            if (isImageType(str)) {
                contentValues.put("is_pending", 0);
            } else {
                contentValues.put("is_pending", 0);
            }
            this.context.getContentResolver().update(uri, contentValues, (String) null, (String[]) null);
        }
    }

    public void clearCache() {
        Uri cachedFileUri = getCachedFileUri();
        this.downloadInProgressCacheDbStorage.removeFilePath();
        deleteUri(cachedFileUri);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r3 == null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r3 != null) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r3.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getAlreadyDownloadedBytes() {
        /*
            r6 = this;
            android.net.Uri r0 = r6.getCachedFileUri()
            r1 = 0
            if (r0 == 0) goto L_0x0034
            r3 = 0
            android.content.Context r4 = r6.context     // Catch:{ Exception -> 0x0023 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r5 = "r"
            android.os.ParcelFileDescriptor r3 = r4.openFileDescriptor(r0, r5)     // Catch:{ Exception -> 0x0023 }
            if (r3 == 0) goto L_0x001b
            long r1 = r3.getStatSize()     // Catch:{ Exception -> 0x0023 }
        L_0x001b:
            if (r3 == 0) goto L_0x0034
        L_0x001d:
            r3.close()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0034
        L_0x0021:
            r0 = move-exception
            goto L_0x002e
        L_0x0023:
            r0 = move-exception
            java.lang.String r4 = "Helpshift_mediaRun"
            java.lang.String r5 = "Exception while getting file size via Uri"
            com.helpshift.util.HSLogger.m3242e(r4, r5, r0)     // Catch:{ all -> 0x0021 }
            if (r3 == 0) goto L_0x0034
            goto L_0x001d
        L_0x002e:
            if (r3 == 0) goto L_0x0033
            r3.close()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            throw r0
        L_0x0034:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.android.commons.downloader.runnable.MediaStoreDownloadRunnable.getAlreadyDownloadedBytes():long");
    }

    public boolean isGzipSupported() {
        return false;
    }

    public void processHttpResponse(InputStream inputStream, int i, int i2, String str) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor;
        int i3 = i2;
        String str2 = str;
        long alreadyDownloadedBytes = getAlreadyDownloadedBytes();
        Uri fileUriToWriteResponseData = getFileUriToWriteResponseData();
        int i4 = 0;
        FileOutputStream fileOutputStream = null;
        if (fileUriToWriteResponseData == null) {
            notifyDownloadFinish(false, (Object) null, i3, str2);
            return;
        }
        this.downloadInProgressCacheDbStorage.insertFilePath(fileUriToWriteResponseData.toString());
        try {
            parcelFileDescriptor = this.context.getContentResolver().openFileDescriptor(fileUriToWriteResponseData, "w");
            if (parcelFileDescriptor == null) {
                try {
                    notifyDownloadFinish(false, (Object) null, i3, str2);
                    closeFileStream((Closeable) null);
                    HsUriUtils.closeParcelFileDescriptor(parcelFileDescriptor);
                } catch (Throwable th) {
                    th = th;
                    closeFileStream(fileOutputStream);
                    HsUriUtils.closeParcelFileDescriptor(parcelFileDescriptor);
                    throw th;
                }
            } else {
                FileOutputStream fileOutputStream2 = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                int i5 = 8192;
                try {
                    byte[] bArr = new byte[8192];
                    long j = 0;
                    InputStream inputStream2 = inputStream;
                    while (true) {
                        int read = inputStream2.read(bArr, i4, i5);
                        if (read == -1) {
                            updateIsPendingFlag(fileUriToWriteResponseData, this.requestInfo.contentType);
                            this.downloadInProgressCacheDbStorage.removeFilePath();
                            HSLogger.m3237d(TAG, "Download finished : " + this.requestInfo.url + "\n URI : " + fileUriToWriteResponseData);
                            notifyDownloadFinish(true, fileUriToWriteResponseData, i3, str2);
                            closeFileStream(fileOutputStream2);
                            HsUriUtils.closeParcelFileDescriptor(parcelFileDescriptor);
                            return;
                        } else if (read >= 0) {
                            fileOutputStream2.write(bArr, i4, read);
                            long statSize = (long) ((((float) parcelFileDescriptor.getStatSize()) / ((float) (((long) i) + alreadyDownloadedBytes))) * 100.0f);
                            if (statSize != j) {
                                notifyProgressChange((int) statSize);
                                j = statSize;
                            }
                            i4 = 0;
                            i5 = 8192;
                        } else {
                            throw new EOFException();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    closeFileStream(fileOutputStream);
                    HsUriUtils.closeParcelFileDescriptor(parcelFileDescriptor);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            parcelFileDescriptor = null;
            closeFileStream(fileOutputStream);
            HsUriUtils.closeParcelFileDescriptor(parcelFileDescriptor);
            throw th;
        }
    }
}
