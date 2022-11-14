package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Builder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: ShareMedia.kt */
public abstract class ShareMedia<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModel {
    public final Bundle params;

    /* compiled from: ShareMedia.kt */
    public static abstract class Builder<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public Bundle params = new Bundle();

        /* compiled from: ShareMedia.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final List<ShareMedia<?, ?>> readListFrom$facebook_common_release(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
                if (readParcelableArray == null) {
                    return EmptyList.INSTANCE;
                }
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : readParcelableArray) {
                    if (parcelable instanceof ShareMedia) {
                        arrayList.add(parcelable);
                    }
                }
                return arrayList;
            }

            public final void writeListTo$facebook_common_release(Parcel parcel, int i, List<? extends ShareMedia<?, ?>> list) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                Intrinsics.checkNotNullParameter(list, ShareConstants.WEB_DIALOG_PARAM_MEDIA);
                Object[] array = list.toArray(new ShareMedia[0]);
                if (array != null) {
                    parcel.writeParcelableArray((Parcelable[]) array, i);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }

        public static final List<ShareMedia<?, ?>> readListFrom$facebook_common_release(Parcel parcel) {
            return Companion.readListFrom$facebook_common_release(parcel);
        }

        public static final void writeListTo$facebook_common_release(Parcel parcel, int i, List<? extends ShareMedia<?, ?>> list) {
            Companion.writeListTo$facebook_common_release(parcel, i, list);
        }

        public final Bundle getParams$facebook_common_release() {
            return this.params;
        }

        public final B setParameter(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.params.putString(str, str2);
            return this;
        }

        public final B setParameters(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "parameters");
            this.params.putAll(bundle);
            return this;
        }

        public final void setParams$facebook_common_release(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "<set-?>");
            this.params = bundle;
        }

        public B readFrom(M m) {
            return m == null ? this : setParameters(m.params);
        }
    }

    /* compiled from: ShareMedia.kt */
    public enum Type {
        PHOTO,
        VIDEO
    }

    public ShareMedia(Builder<M, B> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.params = new Bundle(builder.getParams$facebook_common_release());
    }

    public int describeContents() {
        return 0;
    }

    public abstract Type getMediaType();

    public final Bundle getParameters() {
        return new Bundle(this.params);
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeBundle(this.params);
    }

    public ShareMedia(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Bundle readBundle = parcel.readBundle(getClass().getClassLoader());
        this.params = readBundle == null ? new Bundle() : readBundle;
    }
}
