package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.ShareApi;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePhoto.kt */
public final class SharePhoto extends ShareMedia<SharePhoto, Builder> {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new SharePhoto$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final Bitmap bitmap;
    public final String caption;
    public final Uri imageUrl;
    public final ShareMedia.Type mediaType;
    public final boolean userGenerated;

    /* compiled from: SharePhoto.kt */
    public static final class Builder extends ShareMedia.Builder<SharePhoto, Builder> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public Bitmap bitmap;
        public String caption;
        public Uri imageUrl;
        public boolean userGenerated;

        /* compiled from: SharePhoto.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final List<SharePhoto> readPhotoListFrom$facebook_common_release(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                List<ShareMedia<?, ?>> readListFrom$facebook_common_release = ShareMedia.Builder.Companion.readListFrom$facebook_common_release(parcel);
                ArrayList arrayList = new ArrayList();
                for (T next : readListFrom$facebook_common_release) {
                    if (next instanceof SharePhoto) {
                        arrayList.add(next);
                    }
                }
                return arrayList;
            }

            public final void writePhotoListTo$facebook_common_release(Parcel parcel, int i, List<SharePhoto> list) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                Intrinsics.checkNotNullParameter(list, ShareApi.PHOTOS_EDGE);
                Object[] array = list.toArray(new SharePhoto[0]);
                if (array != null) {
                    parcel.writeParcelableArray((SharePhoto[]) array, i);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }

        public final Bitmap getBitmap$facebook_common_release() {
            return this.bitmap;
        }

        public final String getCaption$facebook_common_release() {
            return this.caption;
        }

        public final Uri getImageUrl$facebook_common_release() {
            return this.imageUrl;
        }

        public final boolean getUserGenerated$facebook_common_release() {
            return this.userGenerated;
        }

        public final Builder readFrom$facebook_common_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        public final Builder setBitmap(Bitmap bitmap2) {
            this.bitmap = bitmap2;
            return this;
        }

        public final Builder setCaption(String str) {
            this.caption = str;
            return this;
        }

        public final Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public final Builder setUserGenerated(boolean z) {
            this.userGenerated = z;
            return this;
        }

        public SharePhoto build() {
            return new SharePhoto(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(SharePhoto sharePhoto) {
            if (sharePhoto == null) {
                return this;
            }
            return ((Builder) super.readFrom(sharePhoto)).setBitmap(sharePhoto.getBitmap()).setImageUrl(sharePhoto.getImageUrl()).setUserGenerated(sharePhoto.getUserGenerated()).setCaption(sharePhoto.getCaption());
        }
    }

    /* compiled from: SharePhoto.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SharePhoto(Builder builder) {
        super(builder);
        this.mediaType = ShareMedia.Type.PHOTO;
        this.bitmap = builder.getBitmap$facebook_common_release();
        this.imageUrl = builder.getImageUrl$facebook_common_release();
        this.userGenerated = builder.getUserGenerated$facebook_common_release();
        this.caption = builder.getCaption$facebook_common_release();
    }

    public /* synthetic */ SharePhoto(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public ShareMedia.Type getMediaType() {
        return this.mediaType;
    }

    public final boolean getUserGenerated() {
        return this.userGenerated;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.bitmap, 0);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeByte(this.userGenerated ? (byte) 1 : 0);
        parcel.writeString(this.caption);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharePhoto(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.mediaType = ShareMedia.Type.PHOTO;
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel.readByte() != 0;
        this.caption = parcel.readString();
    }
}
