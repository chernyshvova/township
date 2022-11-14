package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import com.helpshift.util.Callback;

public interface BitmapProvider {
    void getBitmap(int i, boolean z, Callback<Bitmap, String> callback);

    String getSource();
}
