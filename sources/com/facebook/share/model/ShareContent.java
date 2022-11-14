package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;
import com.facebook.share.model.ShareHashtag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareContent.kt */
public abstract class ShareContent<M extends ShareContent<M, B>, B extends Builder<M, B>> implements ShareModel {
    public final Uri contentUrl;
    public final String pageId;
    public final List<String> peopleIds;
    public final String placeId;
    public final String ref;
    public final ShareHashtag shareHashtag;

    /* compiled from: ShareContent.kt */
    public static abstract class Builder<M extends ShareContent<M, B>, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        public Uri contentUrl;
        public ShareHashtag hashtag;
        public String pageId;
        public List<String> peopleIds;
        public String placeId;
        public String ref;

        public final Uri getContentUrl$facebook_common_release() {
            return this.contentUrl;
        }

        public final ShareHashtag getHashtag$facebook_common_release() {
            return this.hashtag;
        }

        public final String getPageId$facebook_common_release() {
            return this.pageId;
        }

        public final List<String> getPeopleIds$facebook_common_release() {
            return this.peopleIds;
        }

        public final String getPlaceId$facebook_common_release() {
            return this.placeId;
        }

        public final String getRef$facebook_common_release() {
            return this.ref;
        }

        public final B setContentUrl(Uri uri) {
            this.contentUrl = uri;
            return this;
        }

        public final void setContentUrl$facebook_common_release(Uri uri) {
            this.contentUrl = uri;
        }

        public final void setHashtag$facebook_common_release(ShareHashtag shareHashtag) {
            this.hashtag = shareHashtag;
        }

        public final B setPageId(String str) {
            this.pageId = str;
            return this;
        }

        public final void setPageId$facebook_common_release(String str) {
            this.pageId = str;
        }

        public final B setPeopleIds(List<String> list) {
            this.peopleIds = list == null ? null : Collections.unmodifiableList(list);
            return this;
        }

        public final void setPeopleIds$facebook_common_release(List<String> list) {
            this.peopleIds = list;
        }

        public final B setPlaceId(String str) {
            this.placeId = str;
            return this;
        }

        public final void setPlaceId$facebook_common_release(String str) {
            this.placeId = str;
        }

        public final B setRef(String str) {
            this.ref = str;
            return this;
        }

        public final void setRef$facebook_common_release(String str) {
            this.ref = str;
        }

        public final B setShareHashtag(ShareHashtag shareHashtag) {
            this.hashtag = shareHashtag;
            return this;
        }

        public B readFrom(M m) {
            if (m == null) {
                return this;
            }
            return setContentUrl(m.getContentUrl()).setPeopleIds(m.getPeopleIds()).setPlaceId(m.getPlaceId()).setPageId(m.getPageId()).setRef(m.getRef()).setShareHashtag(m.getShareHashtag());
        }
    }

    public ShareContent(Builder<M, B> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.contentUrl = builder.getContentUrl$facebook_common_release();
        this.peopleIds = builder.getPeopleIds$facebook_common_release();
        this.placeId = builder.getPlaceId$facebook_common_release();
        this.pageId = builder.getPageId$facebook_common_release();
        this.ref = builder.getRef$facebook_common_release();
        this.shareHashtag = builder.getHashtag$facebook_common_release();
    }

    private final List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public final Uri getContentUrl() {
        return this.contentUrl;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final List<String> getPeopleIds() {
        return this.peopleIds;
    }

    public final String getPlaceId() {
        return this.placeId;
    }

    public final String getRef() {
        return this.ref;
    }

    public final ShareHashtag getShareHashtag() {
        return this.shareHashtag;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.contentUrl, 0);
        parcel.writeStringList(this.peopleIds);
        parcel.writeString(this.placeId);
        parcel.writeString(this.pageId);
        parcel.writeString(this.ref);
        parcel.writeParcelable(this.shareHashtag, 0);
    }

    public ShareContent(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.contentUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.peopleIds = readUnmodifiableStringList(parcel);
        this.placeId = parcel.readString();
        this.pageId = parcel.readString();
        this.ref = parcel.readString();
        this.shareHashtag = new ShareHashtag.Builder().readFrom$facebook_common_release(parcel).build();
    }
}
