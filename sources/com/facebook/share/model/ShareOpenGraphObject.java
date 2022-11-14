package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareOpenGraphObject.kt */
public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR = new ShareOpenGraphObject$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* compiled from: ShareOpenGraphObject.kt */
    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder> {
        public Builder() {
            putBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY, true);
        }

        public final Builder readFrom$facebook_common_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return (Builder) readFrom((ShareOpenGraphValueContainer) parcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
        }

        public ShareOpenGraphObject build() {
            return new ShareOpenGraphObject(this, (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: ShareOpenGraphObject.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShareOpenGraphObject(Builder builder) {
        super((ShareOpenGraphValueContainer.Builder) builder);
    }

    public /* synthetic */ ShareOpenGraphObject(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }
}
