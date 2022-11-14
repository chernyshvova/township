package com.helpshift.android.commons.downloader;

import com.helpshift.android.commons.downloader.contracts.DownloadDirType;

public class DownloadConfig {
    public DownloadDirType downloadDirType;
    public String externalStorageDirectoryPath;
    public boolean isNoMedia;
    public boolean useCache;
    public boolean writeToFile;

    public static class Builder {
        public DownloadDirType downloadDirType = DownloadDirType.INTERNAL_ONLY;
        public String externalStorageDirectoryPath = "";
        public boolean isNoMedia = false;
        public boolean useCache = true;
        public boolean writeToFile = true;

        public DownloadConfig create() {
            DownloadConfig downloadConfig = new DownloadConfig();
            downloadConfig.useCache = this.useCache;
            downloadConfig.isNoMedia = this.isNoMedia;
            downloadConfig.writeToFile = this.writeToFile;
            downloadConfig.externalStorageDirectoryPath = this.externalStorageDirectoryPath;
            downloadConfig.downloadDirType = this.downloadDirType;
            return downloadConfig;
        }

        public Builder setDownloadDirType(DownloadDirType downloadDirType2) {
            this.downloadDirType = downloadDirType2;
            return this;
        }

        public Builder setExternalStorageDirectoryPath(String str) {
            this.externalStorageDirectoryPath = str;
            return this;
        }

        public Builder setIsNoMedia(boolean z) {
            this.isNoMedia = z;
            return this;
        }

        public Builder setUseCache(boolean z) {
            this.useCache = z;
            return this;
        }

        public Builder setWriteToFile(boolean z) {
            this.writeToFile = z;
            return this;
        }
    }
}
