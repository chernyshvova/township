package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareHashtag.kt */
public final class ShareHashtag implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new ShareHashtag$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final String hashtag;

    /* compiled from: ShareHashtag.kt */
    public static final class Builder implements ShareModelBuilder<ShareHashtag, Builder> {
        public String hashtag;

        public final String getHashtag() {
            return this.hashtag;
        }

        public final Builder readFrom$facebook_common_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
        }

        public final Builder setHashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public ShareHashtag build() {
            return new ShareHashtag(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(ShareHashtag shareHashtag) {
            return shareHashtag == null ? this : setHashtag(shareHashtag.getHashtag());
        }
    }

    /* compiled from: ShareHashtag.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShareHashtag(Builder builder) {
        this.hashtag = builder.getHashtag();
    }

    public /* synthetic */ ShareHashtag(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final String getHashtag() {
        return this.hashtag;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.hashtag);
    }

    public ShareHashtag(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.hashtag = parcel.readString();
    }
}
