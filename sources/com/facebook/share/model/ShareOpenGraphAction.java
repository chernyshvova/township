package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphValueContainer;

@Deprecated
public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new Parcelable.Creator<ShareOpenGraphAction>() {
        public ShareOpenGraphAction createFromParcel(Parcel parcel) {
            return new ShareOpenGraphAction(parcel);
        }

        public ShareOpenGraphAction[] newArray(int i) {
            return new ShareOpenGraphAction[i];
        }
    };

    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder> {
        public static final String ACTION_TYPE_KEY = "og:type";

        public Builder setActionType(String str) {
            putString(ACTION_TYPE_KEY, str);
            return this;
        }

        public ShareOpenGraphAction build() {
            return new ShareOpenGraphAction(this);
        }

        public Builder readFrom(ShareOpenGraphAction shareOpenGraphAction) {
            return shareOpenGraphAction == null ? this : ((Builder) super.readFrom(shareOpenGraphAction)).setActionType(shareOpenGraphAction.getActionType());
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }
    }

    @Nullable
    public String getActionType() {
        return getString(Builder.ACTION_TYPE_KEY);
    }

    public ShareOpenGraphAction(Builder builder) {
        super((ShareOpenGraphValueContainer.Builder) builder);
    }

    public ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }
}
