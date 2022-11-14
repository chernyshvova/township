package com.google.android.gms.internal.drive;

public final class zzjw {
    public static final Class<?> zzok = zzce();

    public static Class<?> zzce() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzjx zzcf() {
        if (zzok != null) {
            try {
                return zzn("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzjx.zzoo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.drive.zzjx zzcg() {
        /*
            java.lang.Class<?> r0 = zzok
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.drive.zzjx r0 = zzn(r0)     // Catch:{ Exception -> 0x000b }
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 != 0) goto L_0x0012
            com.google.android.gms.internal.drive.zzjx r0 = com.google.android.gms.internal.drive.zzjx.zzcg()
        L_0x0012:
            if (r0 != 0) goto L_0x0018
            com.google.android.gms.internal.drive.zzjx r0 = zzcf()
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzjw.zzcg():com.google.android.gms.internal.drive.zzjx");
    }

    public static final zzjx zzn(String str) throws Exception {
        return (zzjx) zzok.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }
}
