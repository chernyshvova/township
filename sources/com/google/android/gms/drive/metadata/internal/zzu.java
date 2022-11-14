package com.google.android.gms.drive.metadata.internal;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collections;

public final class zzu extends zzm<UserMetadata> {
    public zzu(String str, int i) {
        super(str, Arrays.asList(new String[]{zza(str, "permissionId"), zza(str, "displayName"), zza(str, "picture"), zza(str, "isAuthenticatedUser"), zza(str, "emailAddress")}), Collections.emptyList(), GmsVersion.VERSION_MANCHEGO);
    }

    public static String zza(String str, String str2) {
        return GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(str2, GeneratedOutlineSupport.outline3(str, 1)), str, CodelessMatcher.CURRENT_CLASS_NAME, str2);
    }

    private final String zzh(String str) {
        return zza(getName(), str);
    }

    public final boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.hasColumn(zzh("permissionId")) && !dataHolder.hasNull(zzh("permissionId"), i, i2);
    }

    public final /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        String string = dataHolder.getString(zzh("permissionId"), i, i2);
        if (string == null) {
            return null;
        }
        String string2 = dataHolder.getString(zzh("displayName"), i, i2);
        String string3 = dataHolder.getString(zzh("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.getBoolean(zzh("isAuthenticatedUser"), i, i2));
        return new UserMetadata(string, string2, string3, valueOf.booleanValue(), dataHolder.getString(zzh("emailAddress"), i, i2));
    }
}
