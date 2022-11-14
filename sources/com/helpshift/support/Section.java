package com.helpshift.support;

import android.os.Parcel;
import android.os.Parcelable;

public class Section implements Parcelable {
    public static final Parcelable.Creator<Section> CREATOR = new Parcelable.Creator<Section>() {
        public Section createFromParcel(Parcel parcel) {
            return new Section(parcel);
        }

        public Section[] newArray(int i) {
            return new Section[i];
        }
    };

    /* renamed from: id */
    public long f3348id;
    public String publish_id;
    public String section_id;
    public String title;

    public Section() {
        this.f3348id = -1;
        this.section_id = "";
        this.publish_id = "";
        this.title = "";
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Section section = (Section) obj;
        if (section != null && this.title.equals(section.title) && this.publish_id.equals(section.publish_id) && this.section_id.equals(section.section_id)) {
            return true;
        }
        return false;
    }

    public String getPublishId() {
        return this.publish_id;
    }

    public String getSectionId() {
        return this.section_id;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return this.title;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.section_id);
        parcel.writeString(this.title);
        parcel.writeString(this.publish_id);
    }

    public Section(long j, String str, String str2, String str3) {
        this.f3348id = j;
        this.section_id = str;
        this.title = str2;
        this.publish_id = str3;
    }

    public Section(Parcel parcel) {
        this.section_id = parcel.readString();
        this.title = parcel.readString();
        this.publish_id = parcel.readString();
    }
}
