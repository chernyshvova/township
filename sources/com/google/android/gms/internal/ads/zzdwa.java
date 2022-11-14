package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdwa extends zzbqp {
    public final zzdwd zza;
    public final zzdvy zzb;
    public final Map<Long, zzdvt> zzc = new HashMap();

    public zzdwa(zzdwd zzdwd, zzdvy zzdvy) {
        this.zza = zzdwd;
        this.zzb = zzdvy;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzbdk zzc(java.util.Map<java.lang.String, java.lang.String> r30) {
        /*
            com.google.android.gms.internal.ads.zzbdl r0 = new com.google.android.gms.internal.ads.zzbdl
            r0.<init>()
            java.lang.String r1 = "ad_request"
            r2 = r30
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0016
            com.google.android.gms.internal.ads.zzbdk r0 = r0.zza()
            return r0
        L_0x0016:
            java.lang.String r1 = android.net.Uri.decode(r1)
            android.util.JsonReader r2 = new android.util.JsonReader
            java.io.StringReader r3 = new java.io.StringReader
            r3.<init>(r1)
            r2.<init>(r3)
            r2.beginObject()     // Catch:{ IOException -> 0x010e }
        L_0x0027:
            boolean r1 = r2.hasNext()     // Catch:{ IOException -> 0x010e }
            if (r1 == 0) goto L_0x010a
            java.lang.String r1 = r2.nextName()     // Catch:{ IOException -> 0x010e }
            int r3 = r1.hashCode()     // Catch:{ IOException -> 0x010e }
            r4 = 1
            r5 = 0
            switch(r3) {
                case -1289032093: goto L_0x0077;
                case -839117230: goto L_0x006d;
                case -733436947: goto L_0x0063;
                case -99890337: goto L_0x0059;
                case 523149226: goto L_0x004f;
                case 597632527: goto L_0x0045;
                case 1411582723: goto L_0x003b;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0081
        L_0x003b:
            java.lang.String r3 = "tagForChildDirectedTreatment"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 3
            goto L_0x0082
        L_0x0045:
            java.lang.String r3 = "maxAdContentRating"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 5
            goto L_0x0082
        L_0x004f:
            java.lang.String r3 = "keywords"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 1
            goto L_0x0082
        L_0x0059:
            java.lang.String r3 = "httpTimeoutMillis"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 6
            goto L_0x0082
        L_0x0063:
            java.lang.String r3 = "tagForUnderAgeOfConsent"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 4
            goto L_0x0082
        L_0x006d:
            java.lang.String r3 = "isTestDevice"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 2
            goto L_0x0082
        L_0x0077:
            java.lang.String r3 = "extras"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 0
            goto L_0x0082
        L_0x0081:
            r1 = -1
        L_0x0082:
            switch(r1) {
                case 0: goto L_0x00e8;
                case 1: goto L_0x00ca;
                case 2: goto L_0x00c1;
                case 3: goto L_0x00b1;
                case 4: goto L_0x00a1;
                case 5: goto L_0x0091;
                case 6: goto L_0x0089;
                default: goto L_0x0085;
            }
        L_0x0085:
            r2.skipValue()     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x0089:
            int r1 = r2.nextInt()     // Catch:{ IOException -> 0x010e }
            r0.zzh(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x0091:
            java.lang.String r1 = r2.nextString()     // Catch:{ IOException -> 0x010e }
            java.util.List<java.lang.String> r3 = com.google.android.gms.ads.RequestConfiguration.zza     // Catch:{ IOException -> 0x010e }
            boolean r3 = r3.contains(r1)     // Catch:{ IOException -> 0x010e }
            if (r3 == 0) goto L_0x0027
            r0.zzg(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00a1:
            boolean r1 = r2.nextBoolean()     // Catch:{ IOException -> 0x010e }
            if (r1 == 0) goto L_0x00ac
            r0.zzf(r4)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00ac:
            r0.zzf(r5)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00b1:
            boolean r1 = r2.nextBoolean()     // Catch:{ IOException -> 0x010e }
            if (r1 == 0) goto L_0x00bc
            r0.zze(r4)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00bc:
            r0.zze(r5)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00c1:
            boolean r1 = r2.nextBoolean()     // Catch:{ IOException -> 0x010e }
            r0.zzd(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00ca:
            r2.beginArray()     // Catch:{ IOException -> 0x010e }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ IOException -> 0x010e }
            r1.<init>()     // Catch:{ IOException -> 0x010e }
        L_0x00d2:
            boolean r3 = r2.hasNext()     // Catch:{ IOException -> 0x010e }
            if (r3 == 0) goto L_0x00e0
            java.lang.String r3 = r2.nextString()     // Catch:{ IOException -> 0x010e }
            r1.add(r3)     // Catch:{ IOException -> 0x010e }
            goto L_0x00d2
        L_0x00e0:
            r2.endArray()     // Catch:{ IOException -> 0x010e }
            r0.zzc(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00e8:
            r2.beginObject()     // Catch:{ IOException -> 0x010e }
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ IOException -> 0x010e }
            r1.<init>()     // Catch:{ IOException -> 0x010e }
        L_0x00f0:
            boolean r3 = r2.hasNext()     // Catch:{ IOException -> 0x010e }
            if (r3 == 0) goto L_0x0102
            java.lang.String r3 = r2.nextName()     // Catch:{ IOException -> 0x010e }
            java.lang.String r4 = r2.nextString()     // Catch:{ IOException -> 0x010e }
            r1.putString(r3, r4)     // Catch:{ IOException -> 0x010e }
            goto L_0x00f0
        L_0x0102:
            r2.endObject()     // Catch:{ IOException -> 0x010e }
            r0.zzb(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x010a:
            r2.endObject()     // Catch:{ IOException -> 0x010e }
            goto L_0x0113
        L_0x010e:
            java.lang.String r1 = "Ad Request json was malformed, parsing ended early."
            com.google.android.gms.internal.ads.zzcgs.zzd(r1)
        L_0x0113:
            com.google.android.gms.internal.ads.zzbdk r0 = r0.zza()
            android.os.Bundle r1 = r0.zzm
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            android.os.Bundle r1 = r1.getBundle(r2)
            if (r1 != 0) goto L_0x0128
            android.os.Bundle r1 = r0.zzc
            android.os.Bundle r3 = r0.zzm
            r3.putBundle(r2, r1)
        L_0x0128:
            r8 = r1
            com.google.android.gms.internal.ads.zzbdk r1 = new com.google.android.gms.internal.ads.zzbdk
            r4 = r1
            int r5 = r0.zza
            long r6 = r0.zzb
            int r9 = r0.zzd
            java.util.List<java.lang.String> r10 = r0.zze
            boolean r11 = r0.zzf
            int r12 = r0.zzg
            boolean r13 = r0.zzh
            java.lang.String r14 = r0.zzi
            com.google.android.gms.internal.ads.zzbir r15 = r0.zzj
            android.location.Location r2 = r0.zzk
            r16 = r2
            java.lang.String r2 = r0.zzl
            r17 = r2
            android.os.Bundle r2 = r0.zzm
            r18 = r2
            android.os.Bundle r2 = r0.zzn
            r19 = r2
            java.util.List<java.lang.String> r2 = r0.zzo
            r20 = r2
            java.lang.String r2 = r0.zzp
            r21 = r2
            java.lang.String r2 = r0.zzq
            r22 = r2
            boolean r2 = r0.zzr
            r23 = r2
            com.google.android.gms.internal.ads.zzbdb r2 = r0.zzs
            r24 = r2
            int r2 = r0.zzt
            r25 = r2
            java.lang.String r2 = r0.zzu
            r26 = r2
            java.util.List<java.lang.String> r2 = r0.zzv
            r27 = r2
            int r2 = r0.zzw
            r28 = r2
            java.lang.String r0 = r0.zzx
            r29 = r0
            r4.<init>(r5, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwa.zzc(java.util.Map):com.google.android.gms.internal.ads.zzbdk");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b1, code lost:
        if (r0.equals("create_interstitial_ad") != false) goto L_0x00d3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(java.lang.String r12) throws android.os.RemoteException {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzgu
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r1 = "Received H5 gmsg: "
            int r2 = r0.length()
            if (r2 == 0) goto L_0x0024
            java.lang.String r0 = r1.concat(r0)
            goto L_0x0029
        L_0x0024:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x0029:
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            android.net.Uri r12 = android.net.Uri.parse(r12)
            com.google.android.gms.ads.internal.zzs.zzc()
            java.util.Map r12 = com.google.android.gms.ads.internal.util.zzr.zzR(r12)
            java.lang.String r0 = "action"
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x004b
            java.lang.String r12 = "H5 gmsg did not contain an action"
            com.google.android.gms.internal.ads.zzcgs.zzd(r12)
            return
        L_0x004b:
            int r1 = r0.hashCode()
            r2 = 579053441(0x2283a781, float:3.5684973E-18)
            r3 = 0
            r4 = -1
            r5 = 1
            if (r1 == r2) goto L_0x0067
            r2 = 871091088(0x33ebcb90, float:1.0980068E-7)
            if (r1 == r2) goto L_0x005d
            goto L_0x0071
        L_0x005d:
            java.lang.String r1 = "initialize"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0071
            r1 = 0
            goto L_0x0072
        L_0x0067:
            java.lang.String r1 = "dispose_all"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0071
            r1 = 1
            goto L_0x0072
        L_0x0071:
            r1 = -1
        L_0x0072:
            if (r1 == 0) goto L_0x02fa
            if (r1 == r5) goto L_0x02da
            java.lang.String r1 = "obj_id"
            java.lang.Object r1 = r12.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r1.getClass()     // Catch:{ NullPointerException | NumberFormatException -> 0x02bf }
            long r1 = java.lang.Long.parseLong(r1)     // Catch:{ NullPointerException | NumberFormatException -> 0x02bf }
            int r6 = r0.hashCode()
            switch(r6) {
                case -1790951212: goto L_0x00c8;
                case -1266374734: goto L_0x00be;
                case -257098725: goto L_0x00b4;
                case 393881811: goto L_0x00ab;
                case 585513149: goto L_0x00a1;
                case 1671767583: goto L_0x0097;
                case 2109237041: goto L_0x008d;
                default: goto L_0x008c;
            }
        L_0x008c:
            goto L_0x00d2
        L_0x008d:
            java.lang.String r3 = "create_rewarded_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d2
            r3 = 3
            goto L_0x00d3
        L_0x0097:
            java.lang.String r3 = "dispose"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d2
            r3 = 6
            goto L_0x00d3
        L_0x00a1:
            java.lang.String r3 = "load_interstitial_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d2
            r3 = 1
            goto L_0x00d3
        L_0x00ab:
            java.lang.String r5 = "create_interstitial_ad"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x00d2
            goto L_0x00d3
        L_0x00b4:
            java.lang.String r3 = "load_rewarded_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d2
            r3 = 4
            goto L_0x00d3
        L_0x00be:
            java.lang.String r3 = "show_rewarded_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d2
            r3 = 5
            goto L_0x00d3
        L_0x00c8:
            java.lang.String r3 = "show_interstitial_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d2
            r3 = 2
            goto L_0x00d3
        L_0x00d2:
            r3 = -1
        L_0x00d3:
            java.lang.String r4 = "Could not create H5 ad, missing ad unit id"
            java.lang.String r5 = " with ad unit "
            java.lang.String r6 = "Could not create H5 ad, object ID already exists"
            java.lang.String r7 = "ad_unit"
            java.lang.String r8 = "Could not show H5 ad, object ID does not exist"
            java.lang.String r9 = "Could not load H5 ad, object ID does not exist"
            java.lang.String r10 = "Could not create H5 ad, too many existing objects"
            switch(r3) {
                case 0: goto L_0x0227;
                case 1: goto L_0x0208;
                case 2: goto L_0x01ed;
                case 3: goto L_0x015f;
                case 4: goto L_0x0140;
                case 5: goto L_0x0125;
                case 6: goto L_0x00f2;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            java.lang.String r12 = "H5 gmsg contained invalid action: "
            int r1 = r0.length()
            if (r1 == 0) goto L_0x02b5
            java.lang.String r12 = r12.concat(r0)
            goto L_0x02bb
        L_0x00f2:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r12 = r11.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r1)
            java.lang.Object r12 = r12.get(r0)
            com.google.android.gms.internal.ads.zzdvt r12 = (com.google.android.gms.internal.ads.zzdvt) r12
            if (r12 != 0) goto L_0x0106
            java.lang.String r12 = "Could not dispose H5 ad, object ID does not exist"
            com.google.android.gms.internal.ads.zzcgs.zzd(r12)
            return
        L_0x0106:
            r12.zzc()
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r12 = r11.zzc
            r12.remove(r0)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r0 = 36
            r12.<init>(r0)
            java.lang.String r0 = "Disposed H5 ad #"
            r12.append(r0)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r12)
            return
        L_0x0125:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r12 = r11.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r1)
            java.lang.Object r12 = r12.get(r0)
            com.google.android.gms.internal.ads.zzdvt r12 = (com.google.android.gms.internal.ads.zzdvt) r12
            if (r12 != 0) goto L_0x013c
            com.google.android.gms.internal.ads.zzcgs.zzd(r8)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzj(r1)
            return
        L_0x013c:
            r12.zzb()
            return
        L_0x0140:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r0 = r11.zzc
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.ads.zzdvt r0 = (com.google.android.gms.internal.ads.zzdvt) r0
            if (r0 != 0) goto L_0x0157
            com.google.android.gms.internal.ads.zzcgs.zzd(r9)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzj(r1)
            return
        L_0x0157:
            com.google.android.gms.internal.ads.zzbdk r12 = zzc(r12)
            r0.zza(r12)
            return
        L_0x015f:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r0 = r11.zzc
            int r0 = r0.size()
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r3 = com.google.android.gms.internal.ads.zzbjn.zzgv
            com.google.android.gms.internal.ads.zzbjl r8 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r3 = r8.zzb(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r0 < r3) goto L_0x0180
            com.google.android.gms.internal.ads.zzcgs.zzi(r10)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzc(r1)
            return
        L_0x0180:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r0 = r11.zzc
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x0195
            com.google.android.gms.internal.ads.zzcgs.zzd(r6)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzc(r1)
            return
        L_0x0195:
            java.lang.Object r12 = r12.get(r7)
            java.lang.String r12 = (java.lang.String) r12
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x01aa
            com.google.android.gms.internal.ads.zzcgs.zzi(r4)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzc(r1)
            return
        L_0x01aa:
            com.google.android.gms.internal.ads.zzdwd r0 = r11.zza
            com.google.android.gms.internal.ads.zzdvu r0 = r0.zzb()
            r0.zzc(r1)
            r0.zzb(r12)
            com.google.android.gms.internal.ads.zzdvv r0 = r0.zza()
            com.google.android.gms.internal.ads.zzdwj r0 = r0.zzb()
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r4 = r11.zzc
            r4.put(r3, r0)
            com.google.android.gms.internal.ads.zzdvy r0 = r11.zzb
            r0.zzb(r1)
            java.lang.String r0 = java.lang.String.valueOf(r12)
            int r0 = r0.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r0 = r0 + 55
            r3.<init>(r0)
            java.lang.String r0 = "Created H5 rewarded #"
            r3.append(r0)
            r3.append(r1)
            r3.append(r5)
            r3.append(r12)
            java.lang.String r12 = r3.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r12)
            return
        L_0x01ed:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r12 = r11.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r1)
            java.lang.Object r12 = r12.get(r0)
            com.google.android.gms.internal.ads.zzdvt r12 = (com.google.android.gms.internal.ads.zzdvt) r12
            if (r12 != 0) goto L_0x0204
            com.google.android.gms.internal.ads.zzcgs.zzd(r8)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzd(r1)
            return
        L_0x0204:
            r12.zzb()
            return
        L_0x0208:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r0 = r11.zzc
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.ads.zzdvt r0 = (com.google.android.gms.internal.ads.zzdvt) r0
            if (r0 != 0) goto L_0x021f
            com.google.android.gms.internal.ads.zzcgs.zzd(r9)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzd(r1)
            return
        L_0x021f:
            com.google.android.gms.internal.ads.zzbdk r12 = zzc(r12)
            r0.zza(r12)
            return
        L_0x0227:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r0 = r11.zzc
            int r0 = r0.size()
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r3 = com.google.android.gms.internal.ads.zzbjn.zzgv
            com.google.android.gms.internal.ads.zzbjl r8 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r3 = r8.zzb(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r0 < r3) goto L_0x0248
            com.google.android.gms.internal.ads.zzcgs.zzi(r10)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzc(r1)
            return
        L_0x0248:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r0 = r11.zzc
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x025d
            com.google.android.gms.internal.ads.zzcgs.zzd(r6)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzc(r1)
            return
        L_0x025d:
            java.lang.Object r12 = r12.get(r7)
            java.lang.String r12 = (java.lang.String) r12
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x0272
            com.google.android.gms.internal.ads.zzcgs.zzi(r4)
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zzc(r1)
            return
        L_0x0272:
            com.google.android.gms.internal.ads.zzdwd r0 = r11.zza
            com.google.android.gms.internal.ads.zzdvu r0 = r0.zzb()
            r0.zzc(r1)
            r0.zzb(r12)
            com.google.android.gms.internal.ads.zzdvv r0 = r0.zza()
            com.google.android.gms.internal.ads.zzdwf r0 = r0.zza()
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r4 = r11.zzc
            r4.put(r3, r0)
            com.google.android.gms.internal.ads.zzdvy r0 = r11.zzb
            r0.zzb(r1)
            java.lang.String r0 = java.lang.String.valueOf(r12)
            int r0 = r0.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r0 = r0 + 59
            r3.<init>(r0)
            java.lang.String r0 = "Created H5 interstitial #"
            r3.append(r0)
            r3.append(r1)
            r3.append(r5)
            r3.append(r12)
            java.lang.String r12 = r3.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r12)
            return
        L_0x02b5:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r12)
            r12 = r0
        L_0x02bb:
            com.google.android.gms.internal.ads.zzcgs.zzd(r12)
            return
        L_0x02bf:
            java.lang.String r12 = java.lang.String.valueOf(r1)
            java.lang.String r0 = "H5 gmsg did not contain a valid object id: "
            int r1 = r12.length()
            if (r1 == 0) goto L_0x02d1
            java.lang.String r12 = r0.concat(r12)
            goto L_0x02d6
        L_0x02d1:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r0)
        L_0x02d6:
            com.google.android.gms.internal.ads.zzcgs.zzd(r12)
            return
        L_0x02da:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r12 = r11.zzc
            java.util.Collection r12 = r12.values()
            java.util.Iterator r12 = r12.iterator()
        L_0x02e4:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x02f4
            java.lang.Object r0 = r12.next()
            com.google.android.gms.internal.ads.zzdvt r0 = (com.google.android.gms.internal.ads.zzdvt) r0
            r0.zzc()
            goto L_0x02e4
        L_0x02f4:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r12 = r11.zzc
            r12.clear()
            return
        L_0x02fa:
            java.util.Map<java.lang.Long, com.google.android.gms.internal.ads.zzdvt> r12 = r11.zzc
            r12.clear()
            com.google.android.gms.internal.ads.zzdvy r12 = r11.zzb
            r12.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwa.zze(java.lang.String):void");
    }

    public final void zzf() {
        this.zzc.clear();
    }
}
