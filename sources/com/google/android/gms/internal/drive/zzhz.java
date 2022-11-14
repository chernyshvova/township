package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.internal.zzl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class zzhz extends zzl<DriveSpace> {
    public zzhz(int i) {
        super("spaces", Arrays.asList(new String[]{"inDriveSpace", "isAppData", "inGooglePhotosSpace"}), Collections.emptySet(), GmsVersion.VERSION_ORLA);
    }

    /* renamed from: zzd */
    public final Collection<DriveSpace> zzc(DataHolder dataHolder, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (dataHolder.getBoolean("inDriveSpace", i, i2)) {
            arrayList.add(DriveSpace.zzah);
        }
        if (dataHolder.getBoolean("isAppData", i, i2)) {
            arrayList.add(DriveSpace.zzai);
        }
        if (dataHolder.getBoolean("inGooglePhotosSpace", i, i2)) {
            arrayList.add(DriveSpace.zzaj);
        }
        return arrayList;
    }
}
