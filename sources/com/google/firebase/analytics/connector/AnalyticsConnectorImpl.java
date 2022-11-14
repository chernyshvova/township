package com.google.firebase.analytics.connector;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    public static volatile AnalyticsConnector zzb;
    @VisibleForTesting
    public final AppMeasurementSdk zzc;

    public AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zzc = appMeasurementSdk;
        new ConcurrentHashMap();
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ac  */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void logEvent(@androidx.annotation.NonNull java.lang.String r7, @androidx.annotation.NonNull java.lang.String r8, android.os.Bundle r9) {
        /*
            r6 = this;
            boolean r0 = com.google.firebase.analytics.connector.internal.zzd.zza(r7)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.util.List<java.lang.String> r0 = com.google.firebase.analytics.connector.internal.zzd.zzb
            boolean r0 = r0.contains(r8)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0012
            goto L_0x002a
        L_0x0012:
            java.util.List<java.lang.String> r0 = com.google.firebase.analytics.connector.internal.zzd.zzd
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r9.containsKey(r3)
            if (r3 == 0) goto L_0x0018
        L_0x002a:
            r0 = 0
            goto L_0x002d
        L_0x002c:
            r0 = 1
        L_0x002d:
            if (r0 != 0) goto L_0x0030
            return
        L_0x0030:
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x003a
            goto L_0x00a8
        L_0x003a:
            boolean r0 = com.google.firebase.analytics.connector.internal.zzd.zza(r7)
            if (r0 != 0) goto L_0x0042
            goto L_0x00a9
        L_0x0042:
            java.util.List<java.lang.String> r0 = com.google.firebase.analytics.connector.internal.zzd.zzd
            java.util.Iterator r0 = r0.iterator()
        L_0x0048:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x005b
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r9.containsKey(r3)
            if (r3 == 0) goto L_0x0048
            goto L_0x00a9
        L_0x005b:
            r0 = -1
            int r3 = r7.hashCode()
            r4 = 101200(0x18b50, float:1.41811E-40)
            r5 = 2
            if (r3 == r4) goto L_0x0085
            r4 = 101230(0x18b6e, float:1.41853E-40)
            if (r3 == r4) goto L_0x007b
            r4 = 3142703(0x2ff42f, float:4.403865E-39)
            if (r3 == r4) goto L_0x0071
            goto L_0x008e
        L_0x0071:
            java.lang.String r3 = "fiam"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x008e
            r0 = 2
            goto L_0x008e
        L_0x007b:
            java.lang.String r3 = "fdl"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x008e
            r0 = 1
            goto L_0x008e
        L_0x0085:
            java.lang.String r3 = "fcm"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x008e
            r0 = 0
        L_0x008e:
            java.lang.String r3 = "_cis"
            if (r0 == 0) goto L_0x00a3
            if (r0 == r2) goto L_0x009d
            if (r0 == r5) goto L_0x0097
            goto L_0x00a9
        L_0x0097:
            java.lang.String r0 = "fiam_integration"
            r9.putString(r3, r0)
            goto L_0x00a8
        L_0x009d:
            java.lang.String r0 = "fdl_integration"
            r9.putString(r3, r0)
            goto L_0x00a8
        L_0x00a3:
            java.lang.String r0 = "fcm_integration"
            r9.putString(r3, r0)
        L_0x00a8:
            r1 = 1
        L_0x00a9:
            if (r1 != 0) goto L_0x00ac
            return
        L_0x00ac:
            java.lang.String r0 = "clx"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = "_ae"
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x00c3
            r0 = 1
            java.lang.String r2 = "_r"
            r9.putLong(r2, r0)
        L_0x00c3:
            com.google.android.gms.measurement.api.AppMeasurementSdk r0 = r6.zzc
            r0.logEvent(r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.logEvent(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (r4.equals(com.google.android.gms.measurement.AppMeasurement.FIAM_ORIGIN) == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (r4.equals("frc") == false) goto L_0x0063;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setUserProperty(@androidx.annotation.NonNull java.lang.String r4, @androidx.annotation.NonNull java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            boolean r0 = com.google.firebase.analytics.connector.internal.zzd.zza(r4)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = "_ce1"
            boolean r0 = r0.equals(r5)
            java.lang.String r1 = "fcm"
            r2 = 1
            if (r0 != 0) goto L_0x0054
            java.lang.String r0 = "_ce2"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x001b
            goto L_0x0054
        L_0x001b:
            java.lang.String r0 = "_ln"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0032
            boolean r0 = r4.equals(r1)
            if (r0 != 0) goto L_0x0064
            java.lang.String r0 = "fiam"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0032:
            java.util.List<java.lang.String> r0 = com.google.firebase.analytics.connector.internal.zzd.zze
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x003b
            goto L_0x0063
        L_0x003b:
            java.util.List<java.lang.String> r0 = com.google.firebase.analytics.connector.internal.zzd.zzf
            java.util.Iterator r0 = r0.iterator()
        L_0x0041:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r5.matches(r1)
            if (r1 == 0) goto L_0x0041
            goto L_0x0063
        L_0x0054:
            boolean r0 = r4.equals(r1)
            if (r0 != 0) goto L_0x0064
            java.lang.String r0 = "frc"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r2 = 0
        L_0x0064:
            if (r2 != 0) goto L_0x0067
            return
        L_0x0067:
            com.google.android.gms.measurement.api.AppMeasurementSdk r0 = r3.zzc
            r0.setUserProperty(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.setUserProperty(java.lang.String, java.lang.String, java.lang.Object):void");
    }
}
