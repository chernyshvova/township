package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdp> CREATOR = new zzbdq();
    @SafeParcelable.Field(mo17147id = 2)
    public final String zza;
    @SafeParcelable.Field(mo17147id = 3)
    public final int zzb;
    @SafeParcelable.Field(mo17147id = 4)
    public final int zzc;
    @SafeParcelable.Field(mo17147id = 5)
    public final boolean zzd;
    @SafeParcelable.Field(mo17147id = 6)
    public final int zze;
    @SafeParcelable.Field(mo17147id = 7)
    public final int zzf;
    @SafeParcelable.Field(mo17147id = 8)
    public final zzbdp[] zzg;
    @SafeParcelable.Field(mo17147id = 9)
    public final boolean zzh;
    @SafeParcelable.Field(mo17147id = 10)
    public final boolean zzi;
    @SafeParcelable.Field(mo17147id = 11)
    public boolean zzj;
    @SafeParcelable.Field(mo17147id = 12)
    public boolean zzk;
    @SafeParcelable.Field(mo17147id = 13)
    public boolean zzl;
    @SafeParcelable.Field(mo17147id = 14)
    public boolean zzm;
    @SafeParcelable.Field(mo17147id = 15)
    public boolean zzn;
    @SafeParcelable.Field(mo17147id = 16)
    public boolean zzo;

    public zzbdp() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzbdp[]) null, false, false, false, false, false, false, false, false);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return (int) (((float) zzf(displayMetrics)) * displayMetrics.density);
    }

    public static zzbdp zzb() {
        return new zzbdp("320x50_mb", 0, 0, false, 0, 0, (zzbdp[]) null, true, false, false, false, false, false, false, false);
    }

    public static zzbdp zzc() {
        return new zzbdp("reward_mb", 0, 0, true, 0, 0, (zzbdp[]) null, false, false, false, false, false, false, false, false);
    }

    public static zzbdp zzd() {
        return new zzbdp("interstitial_mb", 0, 0, false, 0, 0, (zzbdp[]) null, false, false, false, false, true, false, false, false);
    }

    public static zzbdp zze() {
        return new zzbdp("invalid", 0, 0, false, 0, 0, (zzbdp[]) null, false, false, false, true, false, false, false, false);
    }

    public static int zzf(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeInt(parcel, 6, this.zze);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzbdp(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbdp(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            r12 = this;
            r12.<init>()
            r0 = 0
            r1 = r14[r0]
            r12.zzd = r0
            boolean r2 = r1.isFluid()
            r12.zzi = r2
            boolean r2 = com.google.android.gms.ads.zza.zzf(r1)
            r12.zzm = r2
            boolean r2 = com.google.android.gms.ads.zza.zzg(r1)
            r12.zzn = r2
            boolean r2 = com.google.android.gms.ads.zza.zzd(r1)
            r12.zzo = r2
            boolean r3 = r12.zzi
            if (r3 == 0) goto L_0x0035
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getWidth()
            r12.zze = r2
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getHeight()
            r12.zzb = r2
            goto L_0x0061
        L_0x0035:
            boolean r3 = r12.zzn
            if (r3 == 0) goto L_0x0046
            int r2 = r1.getWidth()
            r12.zze = r2
            int r2 = com.google.android.gms.ads.zza.zzh(r1)
            r12.zzb = r2
            goto L_0x0061
        L_0x0046:
            if (r2 == 0) goto L_0x0055
            int r2 = r1.getWidth()
            r12.zze = r2
            int r2 = com.google.android.gms.ads.zza.zze(r1)
            r12.zzb = r2
            goto L_0x0061
        L_0x0055:
            int r2 = r1.getWidth()
            r12.zze = r2
            int r2 = r1.getHeight()
            r12.zzb = r2
        L_0x0061:
            int r3 = r12.zze
            android.content.res.Resources r4 = r13.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            r5 = -1
            if (r3 != r5) goto L_0x013a
            com.google.android.gms.internal.ads.zzbev.zza()
            android.content.res.Resources r6 = r13.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            r7 = 2
            if (r6 == r7) goto L_0x0080
            goto L_0x011c
        L_0x0080:
            android.content.res.Resources r6 = r13.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r7 = r6.heightPixels
            float r7 = (float) r7
            float r6 = r6.density
            float r7 = r7 / r6
            int r6 = (int) r7
            r7 = 600(0x258, float:8.41E-43)
            if (r6 >= r7) goto L_0x011c
            com.google.android.gms.internal.ads.zzbev.zza()
            android.content.res.Resources r6 = r13.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            java.lang.String r7 = "window"
            java.lang.Object r7 = r13.getSystemService(r7)
            android.view.WindowManager r7 = (android.view.WindowManager) r7
            if (r7 == 0) goto L_0x011c
            android.view.Display r7 = r7.getDefaultDisplay()
            boolean r8 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()
            if (r8 == 0) goto L_0x00ba
            r7.getRealMetrics(r6)
            int r8 = r6.heightPixels
            int r9 = r6.widthPixels
            goto L_0x00ee
        L_0x00ba:
            java.lang.Class<android.view.Display> r8 = android.view.Display.class
            java.lang.String r9 = "getRawHeight"
            java.lang.Class[] r10 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x011c }
            java.lang.reflect.Method r8 = r8.getMethod(r9, r10)     // Catch:{ Exception -> 0x011c }
            java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x011c }
            java.lang.Object r8 = r8.invoke(r7, r9)     // Catch:{ Exception -> 0x011c }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x011c }
            java.lang.Class<android.view.Display> r9 = android.view.Display.class
            java.lang.String r10 = "getRawWidth"
            java.lang.Class[] r11 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x011c }
            java.lang.reflect.Method r9 = r9.getMethod(r10, r11)     // Catch:{ Exception -> 0x011c }
            java.lang.Object[] r10 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x011c }
            java.lang.Object r9 = r9.invoke(r7, r10)     // Catch:{ Exception -> 0x011c }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ Exception -> 0x011c }
            if (r8 != 0) goto L_0x00e2
            r8 = 0
            goto L_0x00e6
        L_0x00e2:
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x011c }
        L_0x00e6:
            if (r9 != 0) goto L_0x00ea
            r9 = 0
            goto L_0x00ee
        L_0x00ea:
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x011c }
        L_0x00ee:
            r7.getMetrics(r6)
            int r7 = r6.heightPixels
            int r6 = r6.widthPixels
            if (r7 != r8) goto L_0x011c
            if (r6 != r9) goto L_0x011c
            int r6 = r4.widthPixels
            com.google.android.gms.internal.ads.zzbev.zza()
            android.content.res.Resources r7 = r13.getResources()
            java.lang.String r8 = "navigation_bar_width"
            java.lang.String r9 = "dimen"
            java.lang.String r10 = "android"
            int r7 = r7.getIdentifier(r8, r9, r10)
            if (r7 <= 0) goto L_0x0117
            android.content.res.Resources r8 = r13.getResources()
            int r7 = r8.getDimensionPixelSize(r7)
            goto L_0x0118
        L_0x0117:
            r7 = 0
        L_0x0118:
            int r6 = r6 - r7
            r12.zzf = r6
            goto L_0x0120
        L_0x011c:
            int r6 = r4.widthPixels
            r12.zzf = r6
        L_0x0120:
            float r6 = (float) r6
            float r7 = r4.density
            float r6 = r6 / r7
            double r6 = (double) r6
            int r8 = (int) r6
            double r9 = (double) r8
            java.lang.Double.isNaN(r6)
            java.lang.Double.isNaN(r9)
            double r6 = r6 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0147
            int r8 = r8 + 1
            goto L_0x0147
        L_0x013a:
            int r8 = r12.zze
            com.google.android.gms.internal.ads.zzbev.zza()
            int r6 = r12.zze
            int r6 = com.google.android.gms.internal.ads.zzcgl.zzk(r4, r6)
            r12.zzf = r6
        L_0x0147:
            r6 = -2
            if (r2 != r6) goto L_0x014f
            int r7 = zzf(r4)
            goto L_0x0151
        L_0x014f:
            int r7 = r12.zzb
        L_0x0151:
            com.google.android.gms.internal.ads.zzbev.zza()
            int r4 = com.google.android.gms.internal.ads.zzcgl.zzk(r4, r7)
            r12.zzc = r4
            java.lang.String r4 = "_as"
            java.lang.String r9 = "x"
            r10 = 26
            if (r3 == r5) goto L_0x0198
            if (r2 != r6) goto L_0x0165
            goto L_0x0198
        L_0x0165:
            boolean r2 = r12.zzn
            if (r2 != 0) goto L_0x017c
            boolean r2 = r12.zzo
            if (r2 == 0) goto L_0x016e
            goto L_0x017c
        L_0x016e:
            boolean r2 = r12.zzi
            if (r2 == 0) goto L_0x0175
            java.lang.String r1 = "320x50_mb"
            goto L_0x0195
        L_0x0175:
            java.lang.String r1 = r1.toString()
            r12.zza = r1
            goto L_0x01af
        L_0x017c:
            int r1 = r12.zze
            int r2 = r12.zzb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r10)
            r3.append(r1)
            r3.append(r9)
            r3.append(r2)
            r3.append(r4)
            java.lang.String r1 = r3.toString()
        L_0x0195:
            r12.zza = r1
            goto L_0x01af
        L_0x0198:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r10)
            r1.append(r8)
            r1.append(r9)
            r1.append(r7)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r12.zza = r1
        L_0x01af:
            int r1 = r14.length
            r2 = 1
            if (r1 <= r2) goto L_0x01c9
            com.google.android.gms.internal.ads.zzbdp[] r1 = new com.google.android.gms.internal.ads.zzbdp[r1]
            r12.zzg = r1
            r1 = 0
        L_0x01b8:
            int r2 = r14.length
            if (r1 >= r2) goto L_0x01cc
            com.google.android.gms.internal.ads.zzbdp[] r2 = r12.zzg
            com.google.android.gms.internal.ads.zzbdp r3 = new com.google.android.gms.internal.ads.zzbdp
            r4 = r14[r1]
            r3.<init>((android.content.Context) r13, (com.google.android.gms.ads.AdSize) r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x01b8
        L_0x01c9:
            r13 = 0
            r12.zzg = r13
        L_0x01cc:
            r12.zzh = r0
            r12.zzj = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdp.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    public zzbdp(@SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) int i, @SafeParcelable.Param(mo17150id = 4) int i2, @SafeParcelable.Param(mo17150id = 5) boolean z, @SafeParcelable.Param(mo17150id = 6) int i3, @SafeParcelable.Param(mo17150id = 7) int i4, @SafeParcelable.Param(mo17150id = 8) zzbdp[] zzbdpArr, @SafeParcelable.Param(mo17150id = 9) boolean z2, @SafeParcelable.Param(mo17150id = 10) boolean z3, @SafeParcelable.Param(mo17150id = 11) boolean z4, @SafeParcelable.Param(mo17150id = 12) boolean z5, @SafeParcelable.Param(mo17150id = 13) boolean z6, @SafeParcelable.Param(mo17150id = 14) boolean z7, @SafeParcelable.Param(mo17150id = 15) boolean z8, @SafeParcelable.Param(mo17150id = 16) boolean z9) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = z;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = zzbdpArr;
        this.zzh = z2;
        this.zzi = z3;
        this.zzj = z4;
        this.zzk = z5;
        this.zzl = z6;
        this.zzm = z7;
        this.zzn = z8;
        this.zzo = z9;
    }
}
