package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareFeedContent.kt */
public final class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new ShareFeedContent$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final String link;
    public final String linkCaption;
    public final String linkDescription;
    public final String linkName;
    public final String mediaSource;
    public final String picture;
    public final String toId;

    /* compiled from: ShareFeedContent.kt */
    public static final class Builder extends ShareContent.Builder<ShareFeedContent, Builder> {
        public String link;
        public String linkCaption;
        public String linkDescription;
        public String linkName;
        public String mediaSource;
        public String picture;
        public String toId;

        public final String getLink$facebook_common_release() {
            return this.link;
        }

        public final String getLinkCaption$facebook_common_release() {
            return this.linkCaption;
        }

        public final String getLinkDescription$facebook_common_release() {
            return this.linkDescription;
        }

        public final String getLinkName$facebook_common_release() {
            return this.linkName;
        }

        public final String getMediaSource$facebook_common_release() {
            return this.mediaSource;
        }

        public final String getPicture$facebook_common_release() {
            return this.picture;
        }

        public final String getToId$facebook_common_release() {
            return this.toId;
        }

        public final Builder setLink(String str) {
            this.link = str;
            return this;
        }

        public final void setLink$facebook_common_release(String str) {
            this.link = str;
        }

        public final Builder setLinkCaption(String str) {
            this.linkCaption = str;
            return this;
        }

        public final void setLinkCaption$facebook_common_release(String str) {
            this.linkCaption = str;
        }

        public final Builder setLinkDescription(String str) {
            this.linkDescription = str;
            return this;
        }

        public final void setLinkDescription$facebook_common_release(String str) {
            this.linkDescription = str;
        }

        public final Builder setLinkName(String str) {
            this.linkName = str;
            return this;
        }

        public final void setLinkName$facebook_common_release(String str) {
            this.linkName = str;
        }

        public final Builder setMediaSource(String str) {
            this.mediaSource = str;
            return this;
        }

        public final void setMediaSource$facebook_common_release(String str) {
            this.mediaSource = str;
        }

        public final Builder setPicture(String str) {
            this.picture = str;
            return this;
        }

        public final void setPicture$facebook_common_release(String str) {
            this.picture = str;
        }

        public final Builder setToId(String str) {
            this.toId = str;
            return this;
        }

        public final void setToId$facebook_common_release(String str) {
            this.toId = str;
        }

        public ShareFeedContent build() {
            return new ShareFeedContent(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(ShareFeedContent shareFeedContent) {
            if (shareFeedContent == null) {
                return this;
            }
            return ((Builder) super.readFrom(shareFeedContent)).setToId(shareFeedContent.getToId()).setLink(shareFeedContent.getLink()).setLinkName(shareFeedContent.getLinkName()).setLinkCaption(shareFeedContent.getLinkCaption()).setLinkDescription(shareFeedContent.getLinkDescription()).setPicture(shareFeedContent.getPicture()).setMediaSource(shareFeedContent.getMediaSource());
        }
    }

    /* compiled from: ShareFeedContent.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShareFeedContent(Builder builder) {
        super(builder);
        this.toId = builder.getToId$facebook_common_release();
        this.link = builder.getLink$facebook_common_release();
        this.linkName = builder.getLinkName$facebook_common_release();
        this.linkCaption = builder.getLinkCaption$facebook_common_release();
        this.linkDescription = builder.getLinkDescription$facebook_common_release();
        this.picture = builder.getPicture$facebook_common_release();
        this.mediaSource = builder.getMediaSource$facebook_common_release();
    }

    public /* synthetic */ ShareFeedContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getLinkCaption() {
        return this.linkCaption;
    }

    public final String getLinkDescription() {
        return this.linkDescription;
    }

    public final String getLinkName() {
        return this.linkName;
    }

    public final String getMediaSource() {
        return this.mediaSource;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getToId() {
        return this.toId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.toId);
        parcel.writeString(this.link);
        parcel.writeString(this.linkName);
        parcel.writeString(this.linkCaption);
        parcel.writeString(this.linkDescription);
        parcel.writeString(this.picture);
        parcel.writeString(this.mediaSource);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareFeedContent(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
    }
}
