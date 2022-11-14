package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMessengerActionButton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMessengerURLActionButton.kt */
public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Parcelable.Creator<ShareMessengerURLActionButton> CREATOR = new ShareMessengerURLActionButton$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final Uri fallbackUrl;
    public final boolean isMessengerExtensionURL;
    public final boolean shouldHideWebviewShareButton;
    public final Uri url;
    public final WebviewHeightRatio webviewHeightRatio;

    /* compiled from: ShareMessengerURLActionButton.kt */
    public static final class Builder extends ShareMessengerActionButton.Builder<ShareMessengerURLActionButton, Builder> {
        public Uri fallbackUrl;
        public boolean isMessengerExtensionURL;
        public boolean shouldHideWebviewShareButton;
        public Uri url;
        public WebviewHeightRatio webviewHeightRatio;

        public final Uri getFallbackUrl$facebook_common_release() {
            return this.fallbackUrl;
        }

        public final boolean getShouldHideWebviewShareButton$facebook_common_release() {
            return this.shouldHideWebviewShareButton;
        }

        public final Uri getUrl$facebook_common_release() {
            return this.url;
        }

        public final WebviewHeightRatio getWebviewHeightRatio$facebook_common_release() {
            return this.webviewHeightRatio;
        }

        public final boolean isMessengerExtensionURL$facebook_common_release() {
            return this.isMessengerExtensionURL;
        }

        public final Builder setFallbackUrl(Uri uri) {
            this.fallbackUrl = uri;
            return this;
        }

        public final void setFallbackUrl$facebook_common_release(Uri uri) {
            this.fallbackUrl = uri;
        }

        public final Builder setIsMessengerExtensionURL(boolean z) {
            this.isMessengerExtensionURL = z;
            return this;
        }

        public final void setMessengerExtensionURL$facebook_common_release(boolean z) {
            this.isMessengerExtensionURL = z;
        }

        public final Builder setShouldHideWebviewShareButton(boolean z) {
            this.shouldHideWebviewShareButton = z;
            return this;
        }

        public final void setShouldHideWebviewShareButton$facebook_common_release(boolean z) {
            this.shouldHideWebviewShareButton = z;
        }

        public final Builder setUrl(Uri uri) {
            this.url = uri;
            return this;
        }

        public final void setUrl$facebook_common_release(Uri uri) {
            this.url = uri;
        }

        public final Builder setWebviewHeightRatio(WebviewHeightRatio webviewHeightRatio2) {
            this.webviewHeightRatio = webviewHeightRatio2;
            return this;
        }

        public final void setWebviewHeightRatio$facebook_common_release(WebviewHeightRatio webviewHeightRatio2) {
            this.webviewHeightRatio = webviewHeightRatio2;
        }

        public ShareMessengerURLActionButton build() {
            return new ShareMessengerURLActionButton(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(ShareMessengerURLActionButton shareMessengerURLActionButton) {
            if (shareMessengerURLActionButton == null) {
                return this;
            }
            return setUrl(shareMessengerURLActionButton.getUrl()).setIsMessengerExtensionURL(shareMessengerURLActionButton.isMessengerExtensionURL()).setFallbackUrl(shareMessengerURLActionButton.getFallbackUrl()).setWebviewHeightRatio(shareMessengerURLActionButton.getWebviewHeightRatio()).setShouldHideWebviewShareButton(shareMessengerURLActionButton.getShouldHideWebviewShareButton());
        }
    }

    /* compiled from: ShareMessengerURLActionButton.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ShareMessengerURLActionButton.kt */
    public enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact
    }

    public ShareMessengerURLActionButton(Builder builder) {
        super((ShareMessengerActionButton.Builder<?, ?>) builder);
        this.url = builder.getUrl$facebook_common_release();
        this.isMessengerExtensionURL = builder.isMessengerExtensionURL$facebook_common_release();
        this.fallbackUrl = builder.getFallbackUrl$facebook_common_release();
        this.webviewHeightRatio = builder.getWebviewHeightRatio$facebook_common_release();
        this.shouldHideWebviewShareButton = builder.getShouldHideWebviewShareButton$facebook_common_release();
    }

    public /* synthetic */ ShareMessengerURLActionButton(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final Uri getFallbackUrl() {
        return this.fallbackUrl;
    }

    public final boolean getIsMessengerExtensionURL() {
        return this.isMessengerExtensionURL;
    }

    public final boolean getShouldHideWebviewShareButton() {
        return this.shouldHideWebviewShareButton;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final WebviewHeightRatio getWebviewHeightRatio() {
        return this.webviewHeightRatio;
    }

    public final boolean isMessengerExtensionURL() {
        return this.isMessengerExtensionURL;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.url, 0);
        parcel.writeByte(this.isMessengerExtensionURL ? (byte) 1 : 0);
        parcel.writeParcelable(this.fallbackUrl, 0);
        parcel.writeSerializable(this.webviewHeightRatio);
        parcel.writeByte(this.isMessengerExtensionURL ? (byte) 1 : 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareMessengerURLActionButton(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        boolean z = true;
        this.isMessengerExtensionURL = parcel.readByte() != 0;
        this.fallbackUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.webviewHeightRatio = (WebviewHeightRatio) parcel.readSerializable();
        this.shouldHideWebviewShareButton = parcel.readByte() == 0 ? false : z;
    }
}
