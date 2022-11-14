package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.AuthDataProvider;
import com.helpshift.common.platform.Platform;
import com.helpshift.downloader.AdminFileInfo;
import com.helpshift.downloader.SupportDownloadStateChangeListener;
import com.helpshift.downloader.SupportDownloader;
import com.helpshift.util.Callback;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ImageUtil;

public class URLBitmapProvider implements BitmapProvider {
    public static final String TAG = "Helpshift_URLBtmpPrvdr";
    public Domain domain;
    public SupportDownloader downloader;
    public String imgUrl;
    public Platform platform;

    public URLBitmapProvider(String str, SupportDownloader supportDownloader, Domain domain2, Platform platform2) {
        this.imgUrl = str;
        this.downloader = supportDownloader;
        this.domain = domain2;
        this.platform = platform2;
    }

    public void getBitmap(final int i, boolean z, final Callback<Bitmap, String> callback) {
        String str = this.imgUrl;
        this.downloader.startDownload(new AdminFileInfo(str, str, (String) null, true), SupportDownloader.StorageDirType.EXTERNAL_ONLY, new AuthDataProvider(this.domain, this.platform, this.imgUrl), new SupportDownloadStateChangeListener() {
            public void onFailure(String str, int i) {
                Callback callback = callback;
                callback.onFailure("Unable to load image from: " + str);
            }

            public void onProgressChange(String str, int i) {
            }

            public void onSuccess(String str, String str2, String str3) {
                HSLogger.m3237d(URLBitmapProvider.TAG, "Image downloaded from url: " + str + " cached at path: " + str2);
                callback.onSuccess(ImageUtil.decodeFile(str2, i));
            }
        });
    }

    public String getSource() {
        return this.imgUrl;
    }
}
