package com.facebook.internal;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: FileLruCache.kt */
public final class FileLruCache {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HEADER_CACHEKEY_KEY = "key";
    public static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    public static final String TAG;
    public static final AtomicLong bufferIndex = new AtomicLong();
    public final Condition condition;
    public final File directory = new File(FacebookSdk.getCacheDir(), this.tag);
    public boolean isTrimInProgress;
    public boolean isTrimPending;
    public final AtomicLong lastClearCacheTime;
    public final Limits limits;
    public final ReentrantLock lock;
    public final String tag;

    /* compiled from: FileLruCache.kt */
    public static final class BufferFile {
        public static final String FILE_NAME_PREFIX = "buffer";
        public static final BufferFile INSTANCE = new BufferFile();
        public static final FilenameFilter filterExcludeBufferFiles = $$Lambda$Uwf3BLxDu3AhwSmJosUeq5paAY.INSTANCE;
        public static final FilenameFilter filterExcludeNonBufferFiles = $$Lambda$unX9NeGxjJ5DVb3vL7tbz4CiEM.INSTANCE;

        /* renamed from: filterExcludeBufferFiles$lambda-0  reason: not valid java name */
        public static final boolean m3622filterExcludeBufferFiles$lambda0(File file, String str) {
            Intrinsics.checkNotNullExpressionValue(str, "filename");
            return !CharsKt__CharKt.startsWith$default(str, FILE_NAME_PREFIX, false, 2);
        }

        /* renamed from: filterExcludeNonBufferFiles$lambda-1  reason: not valid java name */
        public static final boolean m3623filterExcludeNonBufferFiles$lambda1(File file, String str) {
            Intrinsics.checkNotNullExpressionValue(str, "filename");
            return CharsKt__CharKt.startsWith$default(str, FILE_NAME_PREFIX, false, 2);
        }

        public final void deleteAll(File file) {
            Intrinsics.checkNotNullParameter(file, "root");
            File[] listFiles = file.listFiles(excludeNonBufferFiles());
            if (listFiles != null) {
                int i = 0;
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    i++;
                    file2.delete();
                }
            }
        }

        public final FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        public final FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        public final File newFile(File file) {
            return new File(file, Intrinsics.stringPlus(FILE_NAME_PREFIX, Long.valueOf(FileLruCache.bufferIndex.incrementAndGet())));
        }
    }

    /* compiled from: FileLruCache.kt */
    public static final class CloseCallbackOutputStream extends OutputStream {
        public final StreamCloseCallback callback;
        public final OutputStream innerStream;

        public CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback streamCloseCallback) {
            Intrinsics.checkNotNullParameter(outputStream, "innerStream");
            Intrinsics.checkNotNullParameter(streamCloseCallback, "callback");
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        public void flush() throws IOException {
            this.innerStream.flush();
        }

        public final StreamCloseCallback getCallback() {
            return this.callback;
        }

        public final OutputStream getInnerStream() {
            return this.innerStream;
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, BufferFile.FILE_NAME_PREFIX);
            this.innerStream.write(bArr, i, i2);
        }

        public void write(byte[] bArr) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, BufferFile.FILE_NAME_PREFIX);
            this.innerStream.write(bArr);
        }

        public void write(int i) throws IOException {
            this.innerStream.write(i);
        }
    }

    /* compiled from: FileLruCache.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return FileLruCache.TAG;
        }
    }

    /* compiled from: FileLruCache.kt */
    public static final class Limits {
        public int byteCount = 1048576;
        public int fileCount = 1024;

        public final int getByteCount() {
            return this.byteCount;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final void setByteCount(int i) {
            if (i >= 0) {
                this.byteCount = i;
                return;
            }
            throw new InvalidParameterException("Cache byte-count limit must be >= 0");
        }

        public final void setFileCount(int i) {
            if (i >= 0) {
                this.fileCount = i;
                return;
            }
            throw new InvalidParameterException("Cache file count limit must be >= 0");
        }
    }

    /* compiled from: FileLruCache.kt */
    public static final class ModifiedFile implements Comparable<ModifiedFile> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int HASH_MULTIPLIER = 37;
        public static final int HASH_SEED = 29;
        public final File file;
        public final long modified;

        /* compiled from: FileLruCache.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ModifiedFile(File file2) {
            Intrinsics.checkNotNullParameter(file2, "file");
            this.file = file2;
            this.modified = file2.lastModified();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0;
        }

        public final File getFile() {
            return this.file;
        }

        public final long getModified() {
            return this.modified;
        }

        public int hashCode() {
            return ((this.file.hashCode() + 1073) * 37) + ((int) (this.modified % ((long) Integer.MAX_VALUE)));
        }

        public int compareTo(ModifiedFile modifiedFile) {
            Intrinsics.checkNotNullParameter(modifiedFile, "another");
            long j = this.modified;
            long j2 = modifiedFile.modified;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
            return this.file.compareTo(modifiedFile.file);
        }
    }

    /* compiled from: FileLruCache.kt */
    public interface StreamCloseCallback {
        void onClose();
    }

    /* compiled from: FileLruCache.kt */
    public static final class StreamHeader {
        public static final int HEADER_VERSION = 0;
        public static final StreamHeader INSTANCE = new StreamHeader();

        public final JSONObject readHeader(InputStream inputStream) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "stream");
            if (inputStream.read() != 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = inputStream.read();
                if (read == -1) {
                    Logger.Companion.log(LoggingBehavior.CACHE, FileLruCache.Companion.getTAG(), "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < i2) {
                int read2 = inputStream.read(bArr, i, i2 - i);
                if (read2 < 1) {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String tag = FileLruCache.Companion.getTAG();
                    companion.log(loggingBehavior, tag, "readHeader: stream.read stopped at " + i + " when expected " + i2);
                    return null;
                }
                i += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr, Charsets.UTF_8)).nextValue();
                if (nextValue instanceof JSONObject) {
                    return (JSONObject) nextValue;
                }
                Logger.Companion.log(LoggingBehavior.CACHE, FileLruCache.Companion.getTAG(), Intrinsics.stringPlus("readHeader: expected JSONObject, got ", nextValue.getClass().getCanonicalName()));
                return null;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final void writeHeader(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            Intrinsics.checkNotNullParameter(outputStream, "stream");
            Intrinsics.checkNotNullParameter(jSONObject, AuthenticationToken.HEADER_KEY);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "header.toString()");
            byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }
    }

    static {
        String simpleName = FileLruCache.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "FileLruCache::class.java.simpleName");
        TAG = simpleName;
    }

    public FileLruCache(String str, Limits limits2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(limits2, "limits");
        this.tag = str;
        this.limits = limits2;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.lastClearCacheTime = new AtomicLong(0);
        if (this.directory.mkdirs() || this.directory.isDirectory()) {
            BufferFile.INSTANCE.deleteAll(this.directory);
        }
    }

    /* renamed from: clearCache$lambda-1  reason: not valid java name */
    public static final void m3620clearCache$lambda1(File[] fileArr) {
        Intrinsics.checkNotNullExpressionValue(fileArr, "filesToDelete");
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            i++;
            file.delete();
        }
    }

    public static /* synthetic */ InputStream get$default(FileLruCache fileLruCache, String str, String str2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.get(str, str2);
    }

    public static /* synthetic */ OutputStream openPutStream$default(FileLruCache fileLruCache, String str, String str2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.openPutStream(str, str2);
    }

    private final void postTrim() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable() {
                    public final void run() {
                        FileLruCache.m3621postTrim$lambda3$lambda2(FileLruCache.this);
                    }
                });
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: postTrim$lambda-3$lambda-2  reason: not valid java name */
    public static final void m3621postTrim$lambda3$lambda2(FileLruCache fileLruCache) {
        Intrinsics.checkNotNullParameter(fileLruCache, "this$0");
        fileLruCache.trim();
    }

    /* access modifiers changed from: private */
    public final void renameToTargetAndTrim(String str, File file) {
        File file2 = this.directory;
        Utility utility = Utility.INSTANCE;
        if (!file.renameTo(new File(file2, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    private final void trim() {
        ReentrantLock reentrantLock;
        long j;
        ReentrantLock reentrantLock2 = this.lock;
        reentrantLock2.lock();
        try {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
            try {
                Logger.Companion.log(LoggingBehavior.CACHE, TAG, "trim started");
                PriorityQueue priorityQueue = new PriorityQueue();
                File[] listFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
                long j2 = 0;
                if (listFiles != null) {
                    int length = listFiles.length;
                    j = 0;
                    int i = 0;
                    while (i < length) {
                        File file = listFiles[i];
                        i++;
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        ModifiedFile modifiedFile = new ModifiedFile(file);
                        priorityQueue.add(modifiedFile);
                        Logger.Companion.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + modifiedFile.getModified() + " name=" + modifiedFile.getFile().getName());
                        j2 += file.length();
                        j++;
                        listFiles = listFiles;
                    }
                } else {
                    j = 0;
                }
                while (true) {
                    if (j2 > ((long) this.limits.getByteCount()) || j > ((long) this.limits.getFileCount())) {
                        File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                        Logger.Companion.log(LoggingBehavior.CACHE, TAG, Intrinsics.stringPlus("  trim removing ", file2.getName()));
                        j2 -= file2.length();
                        j--;
                        file2.delete();
                    } else {
                        reentrantLock = this.lock;
                        reentrantLock.lock();
                        try {
                            this.isTrimInProgress = false;
                            this.condition.signalAll();
                            return;
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                }
            } catch (Throwable th) {
                reentrantLock = this.lock;
                reentrantLock.lock();
                this.isTrimInProgress = false;
                this.condition.signalAll();
                throw th;
            } finally {
                reentrantLock.unlock();
            }
        } finally {
            reentrantLock2.unlock();
        }
    }

    public final void clearCache() {
        File[] listFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable(listFiles) {
                public final /* synthetic */ File[] f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    FileLruCache.m3620clearCache$lambda1(this.f$0);
                }
            });
        }
    }

    public final InputStream get(String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        return get$default(this, str, (String) null, 2, (Object) null);
    }

    public final InputStream get(String str, String str2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        File file = this.directory;
        Utility utility = Utility.INSTANCE;
        File file2 = new File(file, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2), 8192);
            boolean z = false;
            try {
                z = StreamHeader.INSTANCE.readHeader(bufferedInputStream);
                if (z == null) {
                    return null;
                }
                if (!Intrinsics.areEqual(z.optString("key"), str)) {
                    bufferedInputStream.close();
                    return null;
                }
                String optString = z.optString("tag", (String) null);
                if (str2 != null || Intrinsics.areEqual(str2, optString)) {
                    long time = new Date().getTime();
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String str3 = TAG;
                    companion.log(loggingBehavior, str3, "Setting lastModified to " + time + " for " + file2.getName());
                    file2.setLastModified(time);
                    return bufferedInputStream;
                }
                bufferedInputStream.close();
                return null;
            } finally {
                if (!z) {
                    bufferedInputStream.close();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getLocation() {
        String path = this.directory.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "directory.path");
        return path;
    }

    public final InputStream interceptAndPut(String str, InputStream inputStream) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(inputStream, "input");
        return new CopyingInputStream(inputStream, openPutStream$default(this, str, (String) null, 2, (Object) null));
    }

    public final OutputStream openPutStream(String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        return openPutStream$default(this, str, (String) null, 2, (Object) null);
    }

    public final OutputStream openPutStream(String str, String str2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        File newFile = BufferFile.INSTANCE.newFile(this.directory);
        newFile.delete();
        if (newFile.createNewFile()) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(new FileOutputStream(newFile), new FileLruCache$openPutStream$renameToTargetCallback$1(System.currentTimeMillis(), this, newFile, str)), 8192);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    Utility utility = Utility.INSTANCE;
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    StreamHeader.INSTANCE.writeHeader(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e) {
                    Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, Intrinsics.stringPlus("Error creating JSON header for cache file: ", e));
                    throw new IOException(e.getMessage());
                } catch (Throwable th) {
                    if (0 == 0) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, Intrinsics.stringPlus("Error creating buffer output stream: ", e2));
                throw new IOException(e2.getMessage());
            }
        } else {
            throw new IOException(Intrinsics.stringPlus("Could not create file at ", newFile.getAbsolutePath()));
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:1|2|(4:12|13|19|17)(1:18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0005 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A[LOOP:0: B:1:0x0005->B:17:0x0005, LOOP_START, SYNTHETIC, Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long sizeInBytesForTest() {
        /*
            r7 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r7.lock
            r0.lock()
        L_0x0005:
            boolean r1 = r7.isTrimPending     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002a
            boolean r1 = r7.isTrimInProgress     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x000e
            goto L_0x002a
        L_0x000e:
            r0.unlock()
            java.io.File r0 = r7.directory
            java.io.File[] r0 = r0.listFiles()
            r1 = 0
            if (r0 == 0) goto L_0x0029
            r3 = 0
            int r4 = r0.length
        L_0x001d:
            if (r3 >= r4) goto L_0x0029
            r5 = r0[r3]
            int r3 = r3 + 1
            long r5 = r5.length()
            long r1 = r1 + r5
            goto L_0x001d
        L_0x0029:
            return r1
        L_0x002a:
            java.util.concurrent.locks.Condition r1 = r7.condition     // Catch:{ InterruptedException -> 0x0005 }
            r1.await()     // Catch:{ InterruptedException -> 0x0005 }
            goto L_0x0005
        L_0x0030:
            r1 = move-exception
            r0.unlock()
            goto L_0x0036
        L_0x0035:
            throw r1
        L_0x0036:
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FileLruCache.sizeInBytesForTest():long");
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("{FileLruCache: tag:");
        outline24.append(this.tag);
        outline24.append(" file:");
        outline24.append(this.directory.getName());
        outline24.append('}');
        return outline24.toString();
    }

    /* compiled from: FileLruCache.kt */
    public static final class CopyingInputStream extends InputStream {
        public final InputStream input;
        public final OutputStream output;

        public CopyingInputStream(InputStream inputStream, OutputStream outputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "input");
            Intrinsics.checkNotNullParameter(outputStream, "output");
            this.input = inputStream;
            this.output = outputStream;
        }

        public int available() throws IOException {
            return this.input.available();
        }

        public void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        public final InputStream getInput() {
            return this.input;
        }

        public final OutputStream getOutput() {
            return this.output;
        }

        public void mark(int i) {
            throw new UnsupportedOperationException();
        }

        public boolean markSupported() {
            return false;
        }

        public int read(byte[] bArr) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, BufferFile.FILE_NAME_PREFIX);
            int read = this.input.read(bArr);
            if (read > 0) {
                this.output.write(bArr, 0, read);
            }
            return read;
        }

        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        public long skip(long j) throws IOException {
            int read;
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j && (read = read(bArr, 0, (int) Math.min(j - j2, (long) 1024))) >= 0) {
                j2 += (long) read;
            }
            return j2;
        }

        public int read() throws IOException {
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, BufferFile.FILE_NAME_PREFIX);
            int read = this.input.read(bArr, i, i2);
            if (read > 0) {
                this.output.write(bArr, i, read);
            }
            return read;
        }
    }
}
