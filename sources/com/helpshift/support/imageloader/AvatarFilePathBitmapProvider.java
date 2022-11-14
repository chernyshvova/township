package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.helpshift.util.Callback;
import com.helpshift.util.ImageUtil;

public class AvatarFilePathBitmapProvider extends FilePathBitmapProvider {
    public AvatarFilePathBitmapProvider(String str) {
        super(str);
    }

    public Bitmap decodeFile(String str, int i) {
        return ImageUtil.decodeAvatarImageFile(str);
    }

    public /* bridge */ /* synthetic */ void getBitmap(int i, boolean z, Callback callback) {
        super.getBitmap(i, z, callback);
    }

    @NonNull
    public /* bridge */ /* synthetic */ String getSource() {
        return super.getSource();
    }
}
