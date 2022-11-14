package com.google.android.play.core.internal;

import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.w */
public abstract class C2327w extends C2320k implements IInterface {
    public C2327w() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService");
    }

    /* JADX WARNING: type inference failed for: r12v7, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo33277a(int r11, android.os.Parcel r12) throws android.os.RemoteException {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            r3 = 3
            r4 = 2
            if (r11 == r4) goto L_0x0042
            if (r11 == r3) goto L_0x000a
            return r2
        L_0x000a:
            android.os.Parcelable$Creator r11 = android.os.Bundle.CREATOR
            android.os.Parcelable r11 = com.google.android.play.core.internal.C2321l.m3011a((android.os.Parcel) r12, r11)
            android.os.Bundle r11 = (android.os.Bundle) r11
            android.os.IBinder r11 = r12.readStrongBinder()
            if (r11 != 0) goto L_0x0019
            goto L_0x002c
        L_0x0019:
            java.lang.String r12 = "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback"
            android.os.IInterface r12 = r11.queryLocalInterface(r12)
            boolean r1 = r12 instanceof com.google.android.play.core.internal.C2329z
            if (r1 == 0) goto L_0x0027
            r1 = r12
            com.google.android.play.core.internal.z r1 = (com.google.android.play.core.internal.C2329z) r1
            goto L_0x002c
        L_0x0027:
            com.google.android.play.core.internal.y r1 = new com.google.android.play.core.internal.y
            r1.<init>(r11)
        L_0x002c:
            r11 = r10
            com.google.android.play.core.assetpacks.b r11 = (com.google.android.play.core.assetpacks.C2196b) r11
            com.google.android.play.core.assetpacks.bb r11 = r11.f2946d
            java.io.File r11 = r11.mo33188i()
            com.google.android.play.core.assetpacks.C2198bb.m2858c(r11)
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            r1.mo33308b(r11)
            goto L_0x00e2
        L_0x0042:
            android.os.Parcelable$Creator r11 = android.os.Bundle.CREATOR
            android.os.Parcelable r11 = com.google.android.play.core.internal.C2321l.m3011a((android.os.Parcel) r12, r11)
            android.os.Bundle r11 = (android.os.Bundle) r11
            android.os.IBinder r12 = r12.readStrongBinder()
            if (r12 != 0) goto L_0x0051
            goto L_0x0063
        L_0x0051:
            java.lang.String r1 = "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback"
            android.os.IInterface r1 = r12.queryLocalInterface(r1)
            boolean r5 = r1 instanceof com.google.android.play.core.internal.C2329z
            if (r5 == 0) goto L_0x005e
            com.google.android.play.core.internal.z r1 = (com.google.android.play.core.internal.C2329z) r1
            goto L_0x0063
        L_0x005e:
            com.google.android.play.core.internal.y r1 = new com.google.android.play.core.internal.y
            r1.<init>(r12)
        L_0x0063:
            r12 = r10
            com.google.android.play.core.assetpacks.b r12 = (com.google.android.play.core.assetpacks.C2196b) r12
            com.google.android.play.core.internal.ag r5 = r12.f2943a
            java.lang.String r6 = "updateServiceState AIDL call"
            java.lang.Object[] r7 = new java.lang.Object[r2]
            r5.mo33278a((int) r3, (java.lang.String) r6, (java.lang.Object[]) r7)
            android.content.Context r5 = r12.f2944b
            boolean r5 = com.google.android.play.core.internal.C2304bz.m2991a(r5)
            if (r5 == 0) goto L_0x00d5
            android.content.Context r5 = r12.f2944b
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            int r6 = android.os.Binder.getCallingUid()
            java.lang.String[] r5 = r5.getPackagesForUid(r6)
            if (r5 == 0) goto L_0x00d5
            java.util.List r5 = java.util.Arrays.asList(r5)
            java.lang.String r6 = "com.android.vending"
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x00d5
            com.google.android.play.core.assetpacks.AssetPackExtractionService r12 = r12.f2945c
            monitor-enter(r12)
            java.lang.String r5 = "action_type"
            int r5 = r11.getInt(r5)     // Catch:{ all -> 0x00d2 }
            com.google.android.play.core.internal.ag r6 = r12.f2867d     // Catch:{ all -> 0x00d2 }
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d2 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00d2 }
            r7[r2] = r8     // Catch:{ all -> 0x00d2 }
            java.lang.String r9 = "updateServiceState: %d"
            r6.mo33278a((int) r3, (java.lang.String) r9, (java.lang.Object[]) r7)     // Catch:{ all -> 0x00d2 }
            if (r5 != r0) goto L_0x00b1
            r12.mo33151b(r11)     // Catch:{ all -> 0x00d2 }
            goto L_0x00c3
        L_0x00b1:
            if (r5 != r4) goto L_0x00b7
            r12.mo33150a()     // Catch:{ all -> 0x00d2 }
            goto L_0x00c3
        L_0x00b7:
            com.google.android.play.core.internal.ag r11 = r12.f2867d     // Catch:{ all -> 0x00d2 }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d2 }
            r3[r2] = r8     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = "Unknown action type received: %d"
            r4 = 6
            r11.mo33278a((int) r4, (java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x00d2 }
        L_0x00c3:
            android.os.Bundle r11 = new android.os.Bundle     // Catch:{ all -> 0x00d2 }
            r11.<init>()     // Catch:{ all -> 0x00d2 }
            monitor-exit(r12)
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            r1.mo33307a(r11, r12)
            goto L_0x00e2
        L_0x00d2:
            r11 = move-exception
            monitor-exit(r12)
            throw r11
        L_0x00d5:
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            r1.mo33306a(r11)
            com.google.android.play.core.assetpacks.AssetPackExtractionService r11 = r12.f2945c
            r11.mo33150a()
        L_0x00e2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.C2327w.mo33277a(int, android.os.Parcel):boolean");
    }
}
