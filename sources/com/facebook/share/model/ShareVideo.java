package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareVideo.kt */
public final class ShareVideo extends ShareMedia<ShareVideo, Builder> {
    public static final Parcelable.Creator<ShareVideo> CREATOR = new ShareVideo$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final Uri localUrl;
    public final ShareMedia.Type mediaType;

    /* compiled from: ShareVideo.kt */
    public static final class Builder extends ShareMedia.Builder<ShareVideo, Builder> {
        public Uri localUrl;

        public final Uri getLocalUrl$facebook_common_release() {
            return this.localUrl;
        }

        public final Builder readFrom$facebook_common_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }

        public final Builder setLocalUrl(Uri uri) {
            this.localUrl = uri;
            return this;
        }

        public final void setLocalUrl$facebook_common_release(Uri uri) {
            this.localUrl = uri;
        }

        public ShareVideo build() {
            return new ShareVideo(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(ShareVideo shareVideo) {
            return shareVideo == null ? this : setLocalUrl(shareVideo.getLocalUrl());
        }
    }

    /* compiled from: ShareVideo.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShareVideo(Builder builder) {
        super(builder);
        this.mediaType = ShareMedia.Type.VIDEO;
        this.localUrl = builder.getLocalUrl$facebook_common_release();
    }

    public /* synthetic */ ShareVideo(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final Uri getLocalUrl() {
        return this.localUrl;
    }

    public ShareMedia.Type getMediaType() {
        return this.mediaType;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.localUrl, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareVideo(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.mediaType = ShareMedia.Type.VIDEO;
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}
