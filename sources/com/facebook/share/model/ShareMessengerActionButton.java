package com.facebook.share.model;

import android.os.Parcel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMessengerActionButton.kt */
public abstract class ShareMessengerActionButton implements ShareModel {
    public final String title;

    /* compiled from: ShareMessengerActionButton.kt */
    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        public String title;

        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        public final B setTitle(String str) {
            this.title = str;
            return this;
        }

        public final void setTitle$facebook_common_release(String str) {
            this.title = str;
        }

        public B readFrom(M m) {
            return m == null ? this : setTitle(m.getTitle());
        }
    }

    public ShareMessengerActionButton(Builder<?, ?> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.title = builder.getTitle$facebook_common_release();
    }

    public int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.title;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.title);
    }

    public ShareMessengerActionButton(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.title = parcel.readString();
    }
}
