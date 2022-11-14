package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.android.billingclient.api.zzam;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: NativeAppCallAttachmentStore.kt */
public final class NativeAppCallAttachmentStore {
    public static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    public static final NativeAppCallAttachmentStore INSTANCE = new NativeAppCallAttachmentStore();
    public static final String TAG;
    public static File attachmentsDirectory;

    /* compiled from: NativeAppCallAttachmentStore.kt */
    public static final class Attachment {
        public final String attachmentName;
        public final String attachmentUrl;
        public final Bitmap bitmap;
        public final UUID callId;
        public boolean isContentUri;
        public final Uri originalUri;
        public boolean shouldCreateFile;

        public Attachment(UUID uuid, Bitmap bitmap2, Uri uri) {
            String str;
            Intrinsics.checkNotNullParameter(uuid, "callId");
            this.callId = uuid;
            this.bitmap = bitmap2;
            this.originalUri = uri;
            boolean z = true;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (CharsKt__CharKt.equals("content", scheme, true)) {
                    this.isContentUri = true;
                    String authority = this.originalUri.getAuthority();
                    this.shouldCreateFile = (authority == null || CharsKt__CharKt.startsWith$default(authority, ShareConstants.WEB_DIALOG_PARAM_MEDIA, false, 2)) ? false : z;
                } else if (CharsKt__CharKt.equals("file", this.originalUri.getScheme(), true)) {
                    this.shouldCreateFile = true;
                } else {
                    Utility utility = Utility.INSTANCE;
                    if (!Utility.isWebUri(this.originalUri)) {
                        throw new FacebookException(Intrinsics.stringPlus("Unsupported scheme for media Uri : ", scheme));
                    }
                }
            } else if (bitmap2 != null) {
                this.shouldCreateFile = true;
            } else {
                throw new FacebookException("Cannot share media without a bitmap or Uri set");
            }
            this.attachmentName = !this.shouldCreateFile ? null : UUID.randomUUID().toString();
            if (!this.shouldCreateFile) {
                str = String.valueOf(this.originalUri);
            } else {
                FacebookContentProvider.Companion companion = FacebookContentProvider.Companion;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                str = companion.getAttachmentUrl(FacebookSdk.getApplicationId(), this.callId, this.attachmentName);
            }
            this.attachmentUrl = str;
        }

        public final String getAttachmentName() {
            return this.attachmentName;
        }

        public final String getAttachmentUrl() {
            return this.attachmentUrl;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final UUID getCallId() {
            return this.callId;
        }

        public final Uri getOriginalUri() {
            return this.originalUri;
        }

        public final boolean getShouldCreateFile() {
            return this.shouldCreateFile;
        }

        public final boolean isContentUri() {
            return this.isContentUri;
        }

        public final void setContentUri(boolean z) {
            this.isContentUri = z;
        }

        public final void setShouldCreateFile(boolean z) {
            this.shouldCreateFile = z;
        }
    }

    static {
        String name = NativeAppCallAttachmentStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "NativeAppCallAttachmentStore::class.java.name");
        TAG = name;
    }

    public static final void addAttachments(Collection<Attachment> collection) throws FacebookException {
        if (collection != null && !collection.isEmpty()) {
            if (attachmentsDirectory == null) {
                cleanupAllAttachments();
            }
            ensureAttachmentsDirectoryExists();
            ArrayList<File> arrayList = new ArrayList<>();
            try {
                for (Attachment next : collection) {
                    if (next.getShouldCreateFile()) {
                        File attachmentFile = getAttachmentFile(next.getCallId(), next.getAttachmentName(), true);
                        if (attachmentFile != null) {
                            arrayList.add(attachmentFile);
                            if (next.getBitmap() != null) {
                                INSTANCE.processAttachmentBitmap(next.getBitmap(), attachmentFile);
                            } else if (next.getOriginalUri() != null) {
                                INSTANCE.processAttachmentFile(next.getOriginalUri(), next.isContentUri(), attachmentFile);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                Log.e(TAG, Intrinsics.stringPlus("Got unexpected exception:", e));
                for (File file : arrayList) {
                    if (file != null) {
                        try {
                            file.delete();
                        } catch (Exception unused) {
                        }
                    }
                }
                throw new FacebookException((Throwable) e);
            }
        }
    }

    public static final void cleanupAllAttachments() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        if (attachmentsDirectory2 != null) {
            zzam.deleteRecursively(attachmentsDirectory2);
        }
    }

    public static final void cleanupAttachmentsForCall(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, false);
        if (attachmentsDirectoryForCall != null) {
            zzam.deleteRecursively(attachmentsDirectoryForCall);
        }
    }

    public static final Attachment createAttachment(UUID uuid, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        Intrinsics.checkNotNullParameter(bitmap, "attachmentBitmap");
        return new Attachment(uuid, bitmap, (Uri) null);
    }

    public static final File ensureAttachmentsDirectoryExists() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        if (attachmentsDirectory2 != null) {
            attachmentsDirectory2.mkdirs();
        }
        return attachmentsDirectory2;
    }

    public static final File getAttachmentFile(UUID uuid, String str, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, z);
        if (attachmentsDirectoryForCall == null) {
            return null;
        }
        try {
            return new File(attachmentsDirectoryForCall, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static final synchronized File getAttachmentsDirectory() {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            if (attachmentsDirectory == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), ATTACHMENTS_DIR_NAME);
            }
            file = attachmentsDirectory;
        }
        return file;
    }

    public static final File getAttachmentsDirectoryForCall(UUID uuid, boolean z) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        if (attachmentsDirectory == null) {
            return null;
        }
        File file = new File(attachmentsDirectory, uuid.toString());
        if (z && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static final File openAttachment(UUID uuid, String str) throws FileNotFoundException {
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return getAttachmentFile(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }

    private final void processAttachmentBitmap(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            Utility utility = Utility.INSTANCE;
            Utility.closeQuietly(fileOutputStream);
        }
    }

    private final void processAttachmentFile(Uri uri, boolean z, File file) throws IOException {
        InputStream inputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (!z) {
            try {
                inputStream = new FileInputStream(uri.getPath());
            } catch (Throwable th) {
                Utility utility = Utility.INSTANCE;
                Utility.closeQuietly(fileOutputStream);
                throw th;
            }
        } else {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            inputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
        }
        Utility utility2 = Utility.INSTANCE;
        Utility.copyAndCloseInputStream(inputStream, fileOutputStream);
        Utility utility3 = Utility.INSTANCE;
        Utility.closeQuietly(fileOutputStream);
    }

    public static final Attachment createAttachment(UUID uuid, Uri uri) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        Intrinsics.checkNotNullParameter(uri, "attachmentUri");
        return new Attachment(uuid, (Bitmap) null, uri);
    }
}
