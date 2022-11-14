package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.stats.CodePackage;
import java.util.Set;
import java.util.regex.Pattern;

@ShowFirstParty
@SafeParcelable.Class(creator = "DriveSpaceCreator")
@SafeParcelable.Reserved({1})
public class DriveSpace extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DriveSpace> CREATOR = new zzm();
    public static final DriveSpace zzah = new DriveSpace(CodePackage.DRIVE);
    public static final DriveSpace zzai = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzaj;
    public static final Set<DriveSpace> zzak;
    public static final String zzal;
    public static final Pattern zzam = Pattern.compile("[A-Z0-9_]*");
    @SafeParcelable.Field(getter = "getName", mo17147id = 2)
    public final String name;

    static {
        DriveSpace driveSpace = new DriveSpace(ShareConstants.PHOTOS);
        zzaj = driveSpace;
        Set<DriveSpace> of = CollectionUtils.setOf(zzah, zzai, driveSpace);
        zzak = of;
        zzal = TextUtils.join(",", of.toArray());
    }

    @SafeParcelable.Constructor
    public DriveSpace(@SafeParcelable.Param(mo17150id = 2) String str) {
        this.name = (String) Preconditions.checkNotNull(str);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != DriveSpace.class) {
            return false;
        }
        return this.name.equals(((DriveSpace) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode() ^ 1247068382;
    }

    public String toString() {
        return this.name;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
