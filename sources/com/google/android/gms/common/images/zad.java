package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.internal.base.zal;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zad extends zab {
    public WeakReference<ImageView> zac;

    public zad(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference<>(imageView);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zad)) {
            return false;
        }
        ImageView imageView = (ImageView) this.zac.get();
        ImageView imageView2 = (ImageView) ((zad) obj).zac.get();
        return (imageView2 == null || imageView == null || !Objects.equal(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }

    public final void zaa(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageView imageView = (ImageView) this.zac.get();
        if (imageView != null) {
            int i = 0;
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof zal)) {
                zal zal = (zal) imageView;
                int zaa = zal.zaa();
                int i2 = this.zab;
                if (i2 != 0 && zaa == i2) {
                    return;
                }
            }
            boolean zaa2 = zaa(z, z2);
            if (zaa2) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof zaf) {
                    drawable2 = ((zaf) drawable2).zaa();
                }
                drawable = new zaf(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zal) {
                zal zal2 = (zal) imageView;
                zal.zaa(z3 ? this.zaa.zaa : Uri.EMPTY);
                if (z4) {
                    i = this.zab;
                }
                zal.zaa(i);
            }
            if (drawable != null && zaa2) {
                ((zaf) drawable).zaa(250);
            }
        }
    }

    public zad(ImageView imageView, int i) {
        super(Uri.EMPTY, i);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference<>(imageView);
    }
}
