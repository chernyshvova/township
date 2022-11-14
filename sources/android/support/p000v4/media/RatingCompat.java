package android.support.p000v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

@SuppressLint({"BanParcelableUsage"})
/* renamed from: android.support.v4.media.RatingCompat */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        public Object createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public Object[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    public final int mRatingStyle;
    public final float mRatingValue;

    public RatingCompat(int i, float f) {
        this.mRatingStyle = i;
        this.mRatingValue = f;
    }

    public int describeContents() {
        return this.mRatingStyle;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rating:style=");
        outline24.append(this.mRatingStyle);
        outline24.append(" rating=");
        float f = this.mRatingValue;
        outline24.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return outline24.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
