package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.FacebookSdk;
import com.vungle.warren.log.LogEntry;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageRequest.kt */
public final class ImageRequest {
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HEIGHT_PARAM = "height";
    public static final String MIGRATION_PARAM = "migration_overrides";
    public static final String MIGRATION_VALUE = "{october_2012:true}";
    public static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    public static final String WIDTH_PARAM = "width";
    public final boolean allowCachedRedirects;
    public final Callback callback;
    public final Object callerTag;
    public final Context context;
    public final Uri imageUri;

    /* compiled from: ImageRequest.kt */
    public static final class Builder {
        public boolean allowCachedRedirects;
        public Callback callback;
        public Object callerTag;
        public final Context context;
        public final Uri imageUri;

        public Builder(Context context2, Uri uri) {
            Intrinsics.checkNotNullParameter(context2, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(uri, "imageUri");
            this.context = context2;
            this.imageUri = uri;
        }

        private final Context component1() {
            return this.context;
        }

        private final Uri component2() {
            return this.imageUri;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, Context context2, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                context2 = builder.context;
            }
            if ((i & 2) != 0) {
                uri = builder.imageUri;
            }
            return builder.copy(context2, uri);
        }

        public final ImageRequest build() {
            Context context2 = this.context;
            Uri uri = this.imageUri;
            Callback callback2 = this.callback;
            boolean z = this.allowCachedRedirects;
            Object obj = this.callerTag;
            if (obj == null) {
                obj = new Object();
            } else if (obj == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            return new ImageRequest(context2, uri, callback2, z, obj, (DefaultConstructorMarker) null);
        }

        public final Builder copy(Context context2, Uri uri) {
            Intrinsics.checkNotNullParameter(context2, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(uri, "imageUri");
            return new Builder(context2, uri);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual(this.context, builder.context) && Intrinsics.areEqual(this.imageUri, builder.imageUri);
        }

        public int hashCode() {
            return this.imageUri.hashCode() + (this.context.hashCode() * 31);
        }

        public final Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        public final Builder setCallback(Callback callback2) {
            this.callback = callback2;
            return this;
        }

        public final Builder setCallerTag(Object obj) {
            this.callerTag = obj;
            return this;
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Builder(context=");
            outline24.append(this.context);
            outline24.append(", imageUri=");
            outline24.append(this.imageUri);
            outline24.append(')');
            return outline24.toString();
        }
    }

    /* compiled from: ImageRequest.kt */
    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    /* compiled from: ImageRequest.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Uri getProfilePictureUri(String str, int i, int i2) {
            return getProfilePictureUri(str, i, i2, "");
        }

        public final Uri getProfilePictureUri(String str, int i, int i2, String str2) {
            Validate validate = Validate.INSTANCE;
            Validate.notNullOrEmpty(str, "userId");
            int max = Math.max(i, 0);
            int max2 = Math.max(i2, 0);
            if ((max == 0 && max2 == 0) ? false : true) {
                ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                Uri.Builder buildUpon = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon();
                Locale locale = Locale.US;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                String format = String.format(locale, ImageRequest.PATH, Arrays.copyOf(new Object[]{FacebookSdk.getGraphApiVersion(), str}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                Uri.Builder path = buildUpon.path(format);
                if (max2 != 0) {
                    path.appendQueryParameter("height", String.valueOf(max2));
                }
                if (max != 0) {
                    path.appendQueryParameter("width", String.valueOf(max));
                }
                path.appendQueryParameter(ImageRequest.MIGRATION_PARAM, ImageRequest.MIGRATION_VALUE);
                Utility utility = Utility.INSTANCE;
                if (!Utility.isNullOrEmpty(str2)) {
                    path.appendQueryParameter("access_token", str2);
                } else {
                    Utility utility2 = Utility.INSTANCE;
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    if (!Utility.isNullOrEmpty(FacebookSdk.getClientToken())) {
                        Utility utility3 = Utility.INSTANCE;
                        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                        if (!Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
                            StringBuilder sb = new StringBuilder();
                            FacebookSdk facebookSdk4 = FacebookSdk.INSTANCE;
                            sb.append(FacebookSdk.getApplicationId());
                            sb.append('|');
                            FacebookSdk facebookSdk5 = FacebookSdk.INSTANCE;
                            sb.append(FacebookSdk.getClientToken());
                            path.appendQueryParameter("access_token", sb.toString());
                        }
                    }
                    Log.d("ImageRequest", "Needs access token to fetch profile picture. Without an access token a default silhoutte picture is returned");
                }
                Uri build = path.build();
                Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
                return build;
            }
            throw new IllegalArgumentException("Either width or height must be greater than 0".toString());
        }
    }

    public ImageRequest(Context context2, Uri uri, Callback callback2, boolean z, Object obj) {
        this.context = context2;
        this.imageUri = uri;
        this.callback = callback2;
        this.allowCachedRedirects = z;
        this.callerTag = obj;
    }

    public /* synthetic */ ImageRequest(Context context2, Uri uri, Callback callback2, boolean z, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, uri, callback2, z, obj);
    }

    public static final Uri getProfilePictureUri(String str, int i, int i2) {
        return Companion.getProfilePictureUri(str, i, i2);
    }

    public static final Uri getProfilePictureUri(String str, int i, int i2, String str2) {
        return Companion.getProfilePictureUri(str, i, i2, str2);
    }

    public final boolean getAllowCachedRedirects() {
        return this.allowCachedRedirects;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final Object getCallerTag() {
        return this.callerTag;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Uri getImageUri() {
        return this.imageUri;
    }

    public final boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }
}
