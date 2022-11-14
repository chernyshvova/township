package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePhotoContent.kt */
public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new SharePhotoContent$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final List<SharePhoto> photos;

    /* compiled from: SharePhotoContent.kt */
    public static final class Builder extends ShareContent.Builder<SharePhotoContent, Builder> {
        public final List<SharePhoto> photos = new ArrayList();

        public final Builder addPhoto(SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                this.photos.add(new SharePhoto.Builder().readFrom(sharePhoto).build());
            }
            return this;
        }

        public final Builder addPhotos(List<SharePhoto> list) {
            if (list != null) {
                for (SharePhoto addPhoto : list) {
                    addPhoto(addPhoto);
                }
            }
            return this;
        }

        public final List<SharePhoto> getPhotos$facebook_common_release() {
            return this.photos;
        }

        public final Builder setPhotos(List<SharePhoto> list) {
            this.photos.clear();
            addPhotos(list);
            return this;
        }

        public SharePhotoContent build() {
            return new SharePhotoContent(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(SharePhotoContent sharePhotoContent) {
            return sharePhotoContent == null ? this : ((Builder) super.readFrom(sharePhotoContent)).addPhotos(sharePhotoContent.getPhotos());
        }
    }

    /* compiled from: SharePhotoContent.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SharePhotoContent(Builder builder) {
        super(builder);
        this.photos = CollectionsKt__CollectionsKt.toList(builder.getPhotos$facebook_common_release());
    }

    public /* synthetic */ SharePhotoContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final List<SharePhoto> getPhotos() {
        return this.photos;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        SharePhoto.Builder.Companion.writePhotoListTo$facebook_common_release(parcel, i, this.photos);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharePhotoContent(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.photos = CollectionsKt__CollectionsKt.toList(SharePhoto.Builder.Companion.readPhotoListFrom$facebook_common_release(parcel));
    }
}
