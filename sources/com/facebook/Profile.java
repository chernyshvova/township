package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Profile.kt */
public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Profile$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FIRST_NAME_KEY = "first_name";
    public static final String ID_KEY = "id";
    public static final String LAST_NAME_KEY = "last_name";
    public static final String LINK_URI_KEY = "link_uri";
    public static final String MIDDLE_NAME_KEY = "middle_name";
    public static final String NAME_KEY = "name";
    public static final String PICTURE_URI_KEY = "picture_uri";
    public static final String TAG;
    public final String firstName;

    /* renamed from: id */
    public final String f2750id;
    public final String lastName;
    public final Uri linkUri;
    public final String middleName;
    public final String name;
    public final Uri pictureUri;

    /* compiled from: Profile.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void fetchProfileForCurrentAccessToken() {
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            if (currentAccessToken != null) {
                if (!AccessToken.Companion.isCurrentAccessTokenActive()) {
                    setCurrentProfile((Profile) null);
                    return;
                }
                Utility utility = Utility.INSTANCE;
                Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new Profile$Companion$fetchProfileForCurrentAccessToken$1());
            }
        }

        public final Profile getCurrentProfile() {
            return ProfileManager.Companion.getInstance().getCurrentProfile();
        }

        public final void setCurrentProfile(Profile profile) {
            ProfileManager.Companion.getInstance().setCurrentProfile(profile);
        }
    }

    static {
        String simpleName = Profile.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "Profile::class.java.simpleName");
        TAG = simpleName;
    }

    public /* synthetic */ Profile(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        this(str, str2, str3, str4, str5, uri, (Uri) null, 64, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, uri, (i & 64) != 0 ? null : uri2);
    }

    public static final void fetchProfileForCurrentAccessToken() {
        Companion.fetchProfileForCurrentAccessToken();
    }

    public static final Profile getCurrentProfile() {
        return Companion.getCurrentProfile();
    }

    public static final void setCurrentProfile(Profile profile) {
        Companion.setCurrentProfile(profile);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        if (((this.f2750id != null || ((Profile) obj).f2750id != null) && !Intrinsics.areEqual(this.f2750id, ((Profile) obj).f2750id)) || (((this.firstName != null || ((Profile) obj).firstName != null) && !Intrinsics.areEqual(this.firstName, ((Profile) obj).firstName)) || (((this.middleName != null || ((Profile) obj).middleName != null) && !Intrinsics.areEqual(this.middleName, ((Profile) obj).middleName)) || (((this.lastName != null || ((Profile) obj).lastName != null) && !Intrinsics.areEqual(this.lastName, ((Profile) obj).lastName)) || (((this.name != null || ((Profile) obj).name != null) && !Intrinsics.areEqual(this.name, ((Profile) obj).name)) || (((this.linkUri != null || ((Profile) obj).linkUri != null) && !Intrinsics.areEqual(this.linkUri, ((Profile) obj).linkUri)) || ((this.pictureUri != null || ((Profile) obj).pictureUri != null) && !Intrinsics.areEqual(this.pictureUri, ((Profile) obj).pictureUri)))))))) {
            return false;
        }
        return true;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getId() {
        return this.f2750id;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getPictureUri() {
        return this.pictureUri;
    }

    public final Uri getProfilePictureUri(int i, int i2) {
        String str;
        Uri uri = this.pictureUri;
        if (uri != null) {
            return uri;
        }
        if (AccessToken.Companion.isCurrentAccessTokenActive()) {
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            str = currentAccessToken == null ? null : currentAccessToken.getToken();
        } else {
            str = "";
        }
        return ImageRequest.Companion.getProfilePictureUri(this.f2750id, i, i2, str);
    }

    public int hashCode() {
        String str = this.f2750id;
        int hashCode = 527 + (str != null ? str.hashCode() : 0);
        String str2 = this.firstName;
        if (str2 != null) {
            hashCode = (hashCode * 31) + str2.hashCode();
        }
        String str3 = this.middleName;
        if (str3 != null) {
            hashCode = (hashCode * 31) + str3.hashCode();
        }
        String str4 = this.lastName;
        if (str4 != null) {
            hashCode = (hashCode * 31) + str4.hashCode();
        }
        String str5 = this.name;
        if (str5 != null) {
            hashCode = (hashCode * 31) + str5.hashCode();
        }
        Uri uri = this.linkUri;
        if (uri != null) {
            hashCode = (hashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.pictureUri;
        return uri2 != null ? (hashCode * 31) + uri2.hashCode() : hashCode;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f2750id);
            jSONObject.put(FIRST_NAME_KEY, this.firstName);
            jSONObject.put("middle_name", this.middleName);
            jSONObject.put(LAST_NAME_KEY, this.lastName);
            jSONObject.put("name", this.name);
            if (this.linkUri != null) {
                jSONObject.put(LINK_URI_KEY, this.linkUri.toString());
            }
            if (this.pictureUri != null) {
                jSONObject.put(PICTURE_URI_KEY, this.pictureUri.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.f2750id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        Uri uri = this.linkUri;
        String str = null;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.pictureUri;
        if (uri2 != null) {
            str = uri2.toString();
        }
        parcel.writeString(str);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2) {
        Validate validate = Validate.INSTANCE;
        Validate.notNullOrEmpty(str, "id");
        this.f2750id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
        this.pictureUri = uri2;
    }

    public Profile(JSONObject jSONObject) {
        Uri uri;
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Uri uri2 = null;
        this.f2750id = jSONObject.optString("id", (String) null);
        this.firstName = jSONObject.optString(FIRST_NAME_KEY, (String) null);
        this.middleName = jSONObject.optString("middle_name", (String) null);
        this.lastName = jSONObject.optString(LAST_NAME_KEY, (String) null);
        this.name = jSONObject.optString("name", (String) null);
        String optString = jSONObject.optString(LINK_URI_KEY, (String) null);
        if (optString == null) {
            uri = null;
        } else {
            uri = Uri.parse(optString);
        }
        this.linkUri = uri;
        String optString2 = jSONObject.optString(PICTURE_URI_KEY, (String) null);
        this.pictureUri = optString2 != null ? Uri.parse(optString2) : uri2;
    }

    public Profile(Parcel parcel) {
        Uri uri;
        this.f2750id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        Uri uri2 = null;
        if (readString == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString);
        }
        this.linkUri = uri;
        String readString2 = parcel.readString();
        this.pictureUri = readString2 != null ? Uri.parse(readString2) : uri2;
    }
}
