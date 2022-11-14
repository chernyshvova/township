package android.support.p000v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.swrve.sdk.rest.RESTClient;

@SuppressLint({"BanParcelableUsage"})
/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        public Object createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        public Object[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    public final CharSequence mDescription;
    public MediaDescription mDescriptionFwk;
    public final Bundle mExtras;
    public final Bitmap mIcon;
    public final Uri mIconUri;
    public final String mMediaId;
    public final Uri mMediaUri;
    public final CharSequence mSubtitle;
    public final CharSequence mTitle;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mMediaId = str;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.media.MediaDescriptionCompat fromMediaDescription(java.lang.Object r13) {
        /*
            r0 = 0
            if (r13 == 0) goto L_0x0069
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x0069
            android.media.MediaDescription r13 = (android.media.MediaDescription) r13
            java.lang.String r2 = r13.getMediaId()
            java.lang.CharSequence r3 = r13.getTitle()
            java.lang.CharSequence r4 = r13.getSubtitle()
            java.lang.CharSequence r5 = r13.getDescription()
            android.graphics.Bitmap r6 = r13.getIconBitmap()
            android.net.Uri r7 = r13.getIconUri()
            android.os.Bundle r1 = r13.getExtras()
            if (r1 == 0) goto L_0x002d
            android.os.Bundle r1 = android.support.p000v4.media.session.MediaSessionCompat.unparcelWithClassLoader(r1)
        L_0x002d:
            java.lang.String r8 = "android.support.v4.media.description.MEDIA_URI"
            if (r1 == 0) goto L_0x0038
            android.os.Parcelable r9 = r1.getParcelable(r8)
            android.net.Uri r9 = (android.net.Uri) r9
            goto L_0x0039
        L_0x0038:
            r9 = r0
        L_0x0039:
            if (r9 == 0) goto L_0x0052
            java.lang.String r10 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r11 = r1.containsKey(r10)
            if (r11 == 0) goto L_0x004c
            int r11 = r1.size()
            r12 = 2
            if (r11 != r12) goto L_0x004c
            r8 = r0
            goto L_0x0053
        L_0x004c:
            r1.remove(r8)
            r1.remove(r10)
        L_0x0052:
            r8 = r1
        L_0x0053:
            if (r9 == 0) goto L_0x0056
            goto L_0x0061
        L_0x0056:
            int r1 = android.os.Build.VERSION.SDK_INT
            r9 = 23
            if (r1 < r9) goto L_0x0060
            android.net.Uri r0 = r13.getMediaUri()
        L_0x0060:
            r9 = r0
        L_0x0061:
            android.support.v4.media.MediaDescriptionCompat r0 = new android.support.v4.media.MediaDescriptionCompat
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r0.mDescriptionFwk = r13
        L_0x0069:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.MediaDescriptionCompat.fromMediaDescription(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.mTitle + RESTClient.COMMA_SEPARATOR + this.mSubtitle + RESTClient.COMMA_SEPARATOR + this.mDescription;
    }

    public void writeToParcel(Parcel parcel, int i) {
        MediaDescription mediaDescription;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            parcel.writeString(this.mMediaId);
            TextUtils.writeToParcel(this.mTitle, parcel, i);
            TextUtils.writeToParcel(this.mSubtitle, parcel, i);
            TextUtils.writeToParcel(this.mDescription, parcel, i);
            parcel.writeParcelable(this.mIcon, i);
            parcel.writeParcelable(this.mIconUri, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.mMediaUri, i);
            return;
        }
        if (this.mDescriptionFwk != null || i2 < 21) {
            mediaDescription = this.mDescriptionFwk;
        } else {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.mMediaId);
            builder.setTitle(this.mTitle);
            builder.setSubtitle(this.mSubtitle);
            builder.setDescription(this.mDescription);
            builder.setIconBitmap(this.mIcon);
            builder.setIconUri(this.mIconUri);
            Bundle bundle = this.mExtras;
            if (Build.VERSION.SDK_INT < 23 && this.mMediaUri != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.mMediaUri);
            }
            builder.setExtras(bundle);
            if (Build.VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.mMediaUri);
            }
            mediaDescription = builder.build();
            this.mDescriptionFwk = mediaDescription;
        }
        mediaDescription.writeToParcel(parcel, i);
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.mMediaId = parcel.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.mIcon = (Bitmap) parcel.readParcelable(classLoader);
        this.mIconUri = (Uri) parcel.readParcelable(classLoader);
        this.mExtras = parcel.readBundle(classLoader);
        this.mMediaUri = (Uri) parcel.readParcelable(classLoader);
    }
}
