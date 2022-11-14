package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;

/* compiled from: FileLruCache.kt */
public final class FileLruCache$openPutStream$renameToTargetCallback$1 implements FileLruCache.StreamCloseCallback {
    public final /* synthetic */ File $buffer;
    public final /* synthetic */ long $bufferFileCreateTime;
    public final /* synthetic */ String $key;
    public final /* synthetic */ FileLruCache this$0;

    public FileLruCache$openPutStream$renameToTargetCallback$1(long j, FileLruCache fileLruCache, File file, String str) {
        this.$bufferFileCreateTime = j;
        this.this$0 = fileLruCache;
        this.$buffer = file;
        this.$key = str;
    }

    public void onClose() {
        if (this.$bufferFileCreateTime < this.this$0.lastClearCacheTime.get()) {
            this.$buffer.delete();
        } else {
            this.this$0.renameToTargetAndTrim(this.$key, this.$buffer);
        }
    }
}
