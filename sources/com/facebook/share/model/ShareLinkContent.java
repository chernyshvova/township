package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareLinkContent.kt */
public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new ShareLinkContent$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final String quote;

    /* compiled from: ShareLinkContent.kt */
    public static final class Builder extends ShareContent.Builder<ShareLinkContent, Builder> {
        public String quote;

        public final String getQuote$facebook_common_release() {
            return this.quote;
        }

        public final Builder setQuote(String str) {
            this.quote = str;
            return this;
        }

        public final void setQuote$facebook_common_release(String str) {
            this.quote = str;
        }

        public ShareLinkContent build() {
            return new ShareLinkContent(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(ShareLinkContent shareLinkContent) {
            return shareLinkContent == null ? this : ((Builder) super.readFrom(shareLinkContent)).setQuote(shareLinkContent.getQuote());
        }
    }

    /* compiled from: ShareLinkContent.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShareLinkContent(Builder builder) {
        super(builder);
        this.quote = builder.getQuote$facebook_common_release();
    }

    public /* synthetic */ ShareLinkContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final String getQuote() {
        return this.quote;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.quote);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareLinkContent(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
        this.quote = parcel.readString();
    }
}
