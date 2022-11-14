package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.WebDialog;
import com.google.android.gms.common.Scopes;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalw extends zzaaj {
    public static final int[] zzc = {1920, 1600, 1440, WebDialog.MAX_PADDING_SCREEN_HEIGHT, 960, 854, 640, 540, WebDialog.NO_PADDING_SCREEN_WIDTH};
    public static boolean zzd;
    public static boolean zze;
    public long zzA;
    public long zzB;
    public int zzC;
    public int zzD = -1;
    public int zzE = -1;
    public int zzF;
    public float zzG = -1.0f;
    @Nullable
    public zzamp zzH = null;
    public boolean zzI;
    public int zzJ = 0;
    @Nullable
    public zzalx zzK;
    @Nullable
    public zzalv zzb;
    public final Context zzf;
    public final zzama zzg;
    public final zzamm zzh;
    public final boolean zzi = "NVIDIA".equals(zzalh.zzc);
    public zzalu zzj;
    public boolean zzk;
    public boolean zzl;
    @Nullable
    public Surface zzm;
    @Nullable
    public Surface zzn;
    public boolean zzo;
    public int zzp = 1;
    public boolean zzq;
    public boolean zzr;
    public boolean zzs;
    public long zzt;
    public long zzu = -9223372036854775807L;
    public long zzv;
    public int zzw;
    public int zzx;
    public int zzy;
    public long zzz;

    public zzalw(Context context, zzaal zzaal, long j, @Nullable Handler handler, @Nullable zzamn zzamn, int i) {
        super(2, zzaae.zza, zzaal, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zzf = applicationContext;
        this.zzg = new zzama(applicationContext);
        this.zzh = new zzamm(handler, zzamn);
    }

    public static int zzaA(zzaah zzaah, zzkc zzkc) {
        if (zzkc.zzm == -1) {
            return zzaN(zzaah, zzkc.zzl, zzkc.zzq, zzkc.zzr);
        }
        int size = zzkc.zzn.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += zzkc.zzn.get(i2).length;
        }
        return zzkc.zzm + i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0355, code lost:
        if (r1.equals("602LV") != false) goto L_0x0717;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:486:0x0751, code lost:
        if (r7 != 2) goto L_0x0753;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzaG(java.lang.String r13) {
        /*
            java.lang.String r0 = "OMX.google"
            boolean r13 = r13.startsWith(r0)
            r0 = 0
            if (r13 == 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.Class<com.google.android.gms.internal.ads.zzalw> r13 = com.google.android.gms.internal.ads.zzalw.class
            monitor-enter(r13)
            boolean r1 = zzd     // Catch:{ all -> 0x075b }
            if (r1 != 0) goto L_0x0757
            int r1 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ all -> 0x075b }
            r2 = 4
            r3 = 5
            r4 = 3
            r5 = 6
            r6 = 28
            r7 = -1
            r8 = 2
            r9 = 1
            if (r1 > r6) goto L_0x0076
            java.lang.String r1 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ all -> 0x075b }
            int r10 = r1.hashCode()     // Catch:{ all -> 0x075b }
            switch(r10) {
                case -1339091551: goto L_0x0064;
                case -1220081023: goto L_0x005a;
                case -1220066608: goto L_0x0050;
                case -1012436106: goto L_0x0046;
                case -64886864: goto L_0x003c;
                case 3415681: goto L_0x0032;
                case 825323514: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x006e
        L_0x0028:
            java.lang.String r10 = "machuca"
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x006e
            r1 = 4
            goto L_0x006f
        L_0x0032:
            java.lang.String r10 = "once"
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x006e
            r1 = 5
            goto L_0x006f
        L_0x003c:
            java.lang.String r10 = "magnolia"
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x006e
            r1 = 3
            goto L_0x006f
        L_0x0046:
            java.lang.String r10 = "oneday"
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x006e
            r1 = 6
            goto L_0x006f
        L_0x0050:
            java.lang.String r10 = "dangalUHD"
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x006e
            r1 = 1
            goto L_0x006f
        L_0x005a:
            java.lang.String r10 = "dangalFHD"
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x006e
            r1 = 2
            goto L_0x006f
        L_0x0064:
            java.lang.String r10 = "dangal"
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x006e
            r1 = 0
            goto L_0x006f
        L_0x006e:
            r1 = -1
        L_0x006f:
            switch(r1) {
                case 0: goto L_0x0073;
                case 1: goto L_0x0073;
                case 2: goto L_0x0073;
                case 3: goto L_0x0073;
                case 4: goto L_0x0073;
                case 5: goto L_0x0073;
                case 6: goto L_0x0073;
                default: goto L_0x0072;
            }
        L_0x0072:
            goto L_0x0076
        L_0x0073:
            r0 = 1
            goto L_0x0753
        L_0x0076:
            int r1 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ all -> 0x075b }
            r10 = 27
            if (r1 > r10) goto L_0x0087
            java.lang.String r1 = "HWEML"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ all -> 0x075b }
            boolean r1 = r1.equals(r11)     // Catch:{ all -> 0x075b }
            if (r1 == 0) goto L_0x0087
            goto L_0x0073
        L_0x0087:
            int r1 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ all -> 0x075b }
            r11 = 26
            if (r1 > r11) goto L_0x0753
            java.lang.String r1 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ all -> 0x075b }
            int r12 = r1.hashCode()     // Catch:{ all -> 0x075b }
            switch(r12) {
                case -2144781245: goto L_0x070b;
                case -2144781185: goto L_0x0700;
                case -2144781160: goto L_0x06f5;
                case -2097309513: goto L_0x06ea;
                case -2022874474: goto L_0x06df;
                case -1978993182: goto L_0x06d4;
                case -1978990237: goto L_0x06c9;
                case -1936688988: goto L_0x06be;
                case -1936688066: goto L_0x06b3;
                case -1936688065: goto L_0x06a7;
                case -1931988508: goto L_0x069b;
                case -1885099851: goto L_0x068f;
                case -1696512866: goto L_0x0683;
                case -1680025915: goto L_0x0677;
                case -1615810839: goto L_0x066b;
                case -1600724499: goto L_0x065f;
                case -1554255044: goto L_0x0653;
                case -1481772737: goto L_0x0647;
                case -1481772730: goto L_0x063b;
                case -1481772729: goto L_0x062f;
                case -1320080169: goto L_0x0623;
                case -1217592143: goto L_0x0617;
                case -1180384755: goto L_0x060b;
                case -1139198265: goto L_0x05ff;
                case -1052835013: goto L_0x05f3;
                case -993250464: goto L_0x05e8;
                case -993250458: goto L_0x05dd;
                case -965403638: goto L_0x05d1;
                case -958336948: goto L_0x05c5;
                case -879245230: goto L_0x05b9;
                case -842500323: goto L_0x05ad;
                case -821392978: goto L_0x05a1;
                case -797483286: goto L_0x0595;
                case -794946968: goto L_0x0589;
                case -788334647: goto L_0x057d;
                case -782144577: goto L_0x0571;
                case -575125681: goto L_0x0565;
                case -521118391: goto L_0x0559;
                case -430914369: goto L_0x054d;
                case -290434366: goto L_0x0541;
                case -282781963: goto L_0x0535;
                case -277133239: goto L_0x0529;
                case -173639913: goto L_0x051d;
                case -56598463: goto L_0x0511;
                case 2126: goto L_0x0505;
                case 2564: goto L_0x04f9;
                case 2715: goto L_0x04ed;
                case 2719: goto L_0x04e1;
                case 3091: goto L_0x04d5;
                case 3483: goto L_0x04c9;
                case 73405: goto L_0x04bd;
                case 75537: goto L_0x04b1;
                case 75739: goto L_0x04a5;
                case 76779: goto L_0x0499;
                case 78669: goto L_0x048d;
                case 79305: goto L_0x0481;
                case 80618: goto L_0x0475;
                case 88274: goto L_0x0469;
                case 98846: goto L_0x045d;
                case 98848: goto L_0x0451;
                case 99329: goto L_0x0445;
                case 101481: goto L_0x0439;
                case 1513190: goto L_0x042e;
                case 1514184: goto L_0x0423;
                case 1514185: goto L_0x0418;
                case 2133089: goto L_0x040c;
                case 2133091: goto L_0x0400;
                case 2133120: goto L_0x03f4;
                case 2133151: goto L_0x03e8;
                case 2133182: goto L_0x03dc;
                case 2133184: goto L_0x03d0;
                case 2436959: goto L_0x03c4;
                case 2463773: goto L_0x03b8;
                case 2464648: goto L_0x03ac;
                case 2689555: goto L_0x03a0;
                case 3154429: goto L_0x0394;
                case 3284551: goto L_0x0388;
                case 3351335: goto L_0x037c;
                case 3386211: goto L_0x0370;
                case 41325051: goto L_0x0364;
                case 51349633: goto L_0x0359;
                case 51350594: goto L_0x034f;
                case 55178625: goto L_0x0343;
                case 61542055: goto L_0x0338;
                case 65355429: goto L_0x032c;
                case 66214468: goto L_0x0320;
                case 66214470: goto L_0x0314;
                case 66214473: goto L_0x0308;
                case 66215429: goto L_0x02fc;
                case 66215431: goto L_0x02f0;
                case 66215433: goto L_0x02e4;
                case 66216390: goto L_0x02d8;
                case 76402249: goto L_0x02cc;
                case 76404105: goto L_0x02c0;
                case 76404911: goto L_0x02b4;
                case 80963634: goto L_0x02a8;
                case 82882791: goto L_0x029c;
                case 98715550: goto L_0x0290;
                case 101370885: goto L_0x0284;
                case 102844228: goto L_0x0278;
                case 165221241: goto L_0x026c;
                case 182191441: goto L_0x0260;
                case 245388979: goto L_0x0254;
                case 287431619: goto L_0x0248;
                case 307593612: goto L_0x023c;
                case 308517133: goto L_0x0230;
                case 316215098: goto L_0x0224;
                case 316215116: goto L_0x0218;
                case 316246811: goto L_0x020c;
                case 316246818: goto L_0x0200;
                case 407160593: goto L_0x01f4;
                case 507412548: goto L_0x01e8;
                case 793982701: goto L_0x01dc;
                case 794038622: goto L_0x01d0;
                case 794040393: goto L_0x01c4;
                case 835649806: goto L_0x01b8;
                case 917340916: goto L_0x01ac;
                case 958008161: goto L_0x01a0;
                case 1060579533: goto L_0x0194;
                case 1150207623: goto L_0x0188;
                case 1176899427: goto L_0x017c;
                case 1280332038: goto L_0x0170;
                case 1306947716: goto L_0x0164;
                case 1349174697: goto L_0x0158;
                case 1522194893: goto L_0x014c;
                case 1691543273: goto L_0x0140;
                case 1691544261: goto L_0x0134;
                case 1709443163: goto L_0x0128;
                case 1865889110: goto L_0x011c;
                case 1906253259: goto L_0x0110;
                case 1977196784: goto L_0x0104;
                case 2006372676: goto L_0x00f8;
                case 2019281702: goto L_0x00ec;
                case 2029784656: goto L_0x00e0;
                case 2030379515: goto L_0x00d4;
                case 2033393791: goto L_0x00c8;
                case 2047190025: goto L_0x00bc;
                case 2047252157: goto L_0x00b0;
                case 2048319463: goto L_0x00a4;
                case 2048855701: goto L_0x0098;
                default: goto L_0x0096;
            }
        L_0x0096:
            goto L_0x0716
        L_0x0098:
            java.lang.String r2 = "HWWAS-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 66
            goto L_0x0717
        L_0x00a4:
            java.lang.String r2 = "HWVNS-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 65
            goto L_0x0717
        L_0x00b0:
            java.lang.String r2 = "ELUGA_Prim"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 33
            goto L_0x0717
        L_0x00bc:
            java.lang.String r2 = "ELUGA_Note"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 32
            goto L_0x0717
        L_0x00c8:
            java.lang.String r2 = "ASUS_X00AD_2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 14
            goto L_0x0717
        L_0x00d4:
            java.lang.String r2 = "HWCAM-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 64
            goto L_0x0717
        L_0x00e0:
            java.lang.String r2 = "HWBLN-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 63
            goto L_0x0717
        L_0x00ec:
            java.lang.String r2 = "DM-01K"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 29
            goto L_0x0717
        L_0x00f8:
            java.lang.String r2 = "BRAVIA_ATV3_4K"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 19
            goto L_0x0717
        L_0x0104:
            java.lang.String r2 = "Infinix-X572"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 69
            goto L_0x0717
        L_0x0110:
            java.lang.String r2 = "PB2-670M"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 100
            goto L_0x0717
        L_0x011c:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 117(0x75, float:1.64E-43)
            goto L_0x0717
        L_0x0128:
            java.lang.String r2 = "iball8735_9806"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 68
            goto L_0x0717
        L_0x0134:
            java.lang.String r2 = "CPH1715"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 24
            goto L_0x0717
        L_0x0140:
            java.lang.String r2 = "CPH1609"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 23
            goto L_0x0717
        L_0x014c:
            java.lang.String r2 = "woods_f"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 133(0x85, float:1.86E-43)
            goto L_0x0717
        L_0x0158:
            java.lang.String r2 = "htc_e56ml_dtul"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 61
            goto L_0x0717
        L_0x0164:
            java.lang.String r2 = "EverStar_S"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 35
            goto L_0x0717
        L_0x0170:
            java.lang.String r2 = "hwALE-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 62
            goto L_0x0717
        L_0x017c:
            java.lang.String r2 = "itel_S41"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 71
            goto L_0x0717
        L_0x0188:
            java.lang.String r2 = "LS-5017"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 78
            goto L_0x0717
        L_0x0194:
            java.lang.String r2 = "panell_d"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 96
            goto L_0x0717
        L_0x01a0:
            java.lang.String r2 = "j2xlteins"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 72
            goto L_0x0717
        L_0x01ac:
            java.lang.String r2 = "A7000plus"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 10
            goto L_0x0717
        L_0x01b8:
            java.lang.String r2 = "manning"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 81
            goto L_0x0717
        L_0x01c4:
            java.lang.String r2 = "GIONEE_WBL7519"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 59
            goto L_0x0717
        L_0x01d0:
            java.lang.String r2 = "GIONEE_WBL7365"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 58
            goto L_0x0717
        L_0x01dc:
            java.lang.String r2 = "GIONEE_WBL5708"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 57
            goto L_0x0717
        L_0x01e8:
            java.lang.String r2 = "QM16XE_U"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 114(0x72, float:1.6E-43)
            goto L_0x0717
        L_0x01f4:
            java.lang.String r2 = "Pixi5-10_4G"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 106(0x6a, float:1.49E-43)
            goto L_0x0717
        L_0x0200:
            java.lang.String r2 = "TB3-850M"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 125(0x7d, float:1.75E-43)
            goto L_0x0717
        L_0x020c:
            java.lang.String r2 = "TB3-850F"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 124(0x7c, float:1.74E-43)
            goto L_0x0717
        L_0x0218:
            java.lang.String r2 = "TB3-730X"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 123(0x7b, float:1.72E-43)
            goto L_0x0717
        L_0x0224:
            java.lang.String r2 = "TB3-730F"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 122(0x7a, float:1.71E-43)
            goto L_0x0717
        L_0x0230:
            java.lang.String r2 = "A7020a48"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 12
            goto L_0x0717
        L_0x023c:
            java.lang.String r2 = "A7010a48"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 11
            goto L_0x0717
        L_0x0248:
            java.lang.String r2 = "griffin"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 60
            goto L_0x0717
        L_0x0254:
            java.lang.String r2 = "marino_f"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 82
            goto L_0x0717
        L_0x0260:
            java.lang.String r2 = "CPY83_I00"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 25
            goto L_0x0717
        L_0x026c:
            java.lang.String r2 = "A2016a40"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 8
            goto L_0x0717
        L_0x0278:
            java.lang.String r2 = "le_x6"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 77
            goto L_0x0717
        L_0x0284:
            java.lang.String r2 = "l5460"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 76
            goto L_0x0717
        L_0x0290:
            java.lang.String r2 = "i9031"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 67
            goto L_0x0717
        L_0x029c:
            java.lang.String r2 = "X3_HK"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 135(0x87, float:1.89E-43)
            goto L_0x0717
        L_0x02a8:
            java.lang.String r2 = "V23GB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 128(0x80, float:1.794E-43)
            goto L_0x0717
        L_0x02b4:
            java.lang.String r2 = "Q4310"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 112(0x70, float:1.57E-43)
            goto L_0x0717
        L_0x02c0:
            java.lang.String r2 = "Q4260"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 110(0x6e, float:1.54E-43)
            goto L_0x0717
        L_0x02cc:
            java.lang.String r2 = "PRO7S"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 108(0x6c, float:1.51E-43)
            goto L_0x0717
        L_0x02d8:
            java.lang.String r2 = "F3311"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 48
            goto L_0x0717
        L_0x02e4:
            java.lang.String r2 = "F3215"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 47
            goto L_0x0717
        L_0x02f0:
            java.lang.String r2 = "F3213"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 46
            goto L_0x0717
        L_0x02fc:
            java.lang.String r2 = "F3211"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 45
            goto L_0x0717
        L_0x0308:
            java.lang.String r2 = "F3116"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 44
            goto L_0x0717
        L_0x0314:
            java.lang.String r2 = "F3113"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 43
            goto L_0x0717
        L_0x0320:
            java.lang.String r2 = "F3111"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 42
            goto L_0x0717
        L_0x032c:
            java.lang.String r2 = "E5643"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 30
            goto L_0x0717
        L_0x0338:
            java.lang.String r2 = "A1601"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 7
            goto L_0x0717
        L_0x0343:
            java.lang.String r2 = "Aura_Note_2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 15
            goto L_0x0717
        L_0x034f:
            java.lang.String r3 = "602LV"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0716
            goto L_0x0717
        L_0x0359:
            java.lang.String r2 = "601LV"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 3
            goto L_0x0717
        L_0x0364:
            java.lang.String r2 = "MEIZU_M5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 83
            goto L_0x0717
        L_0x0370:
            java.lang.String r2 = "p212"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 92
            goto L_0x0717
        L_0x037c:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 85
            goto L_0x0717
        L_0x0388:
            java.lang.String r2 = "kate"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 75
            goto L_0x0717
        L_0x0394:
            java.lang.String r2 = "fugu"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 50
            goto L_0x0717
        L_0x03a0:
            java.lang.String r2 = "XE2X"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 136(0x88, float:1.9E-43)
            goto L_0x0717
        L_0x03ac:
            java.lang.String r2 = "Q427"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 111(0x6f, float:1.56E-43)
            goto L_0x0717
        L_0x03b8:
            java.lang.String r2 = "Q350"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 109(0x6d, float:1.53E-43)
            goto L_0x0717
        L_0x03c4:
            java.lang.String r2 = "P681"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 93
            goto L_0x0717
        L_0x03d0:
            java.lang.String r2 = "F04J"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 41
            goto L_0x0717
        L_0x03dc:
            java.lang.String r2 = "F04H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 40
            goto L_0x0717
        L_0x03e8:
            java.lang.String r2 = "F03H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 39
            goto L_0x0717
        L_0x03f4:
            java.lang.String r2 = "F02H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 38
            goto L_0x0717
        L_0x0400:
            java.lang.String r2 = "F01J"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 37
            goto L_0x0717
        L_0x040c:
            java.lang.String r2 = "F01H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 36
            goto L_0x0717
        L_0x0418:
            java.lang.String r2 = "1714"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 2
            goto L_0x0717
        L_0x0423:
            java.lang.String r2 = "1713"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 1
            goto L_0x0717
        L_0x042e:
            java.lang.String r2 = "1601"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 0
            goto L_0x0717
        L_0x0439:
            java.lang.String r2 = "flo"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 49
            goto L_0x0717
        L_0x0445:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 28
            goto L_0x0717
        L_0x0451:
            java.lang.String r2 = "cv3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 27
            goto L_0x0717
        L_0x045d:
            java.lang.String r2 = "cv1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 26
            goto L_0x0717
        L_0x0469:
            java.lang.String r2 = "Z80"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 139(0x8b, float:1.95E-43)
            goto L_0x0717
        L_0x0475:
            java.lang.String r2 = "QX1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 115(0x73, float:1.61E-43)
            goto L_0x0717
        L_0x0481:
            java.lang.String r2 = "PLE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 107(0x6b, float:1.5E-43)
            goto L_0x0717
        L_0x048d:
            java.lang.String r2 = "P85"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 94
            goto L_0x0717
        L_0x0499:
            java.lang.String r2 = "MX6"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 86
            goto L_0x0717
        L_0x04a5:
            java.lang.String r2 = "M5c"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 80
            goto L_0x0717
        L_0x04b1:
            java.lang.String r2 = "M04"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 79
            goto L_0x0717
        L_0x04bd:
            java.lang.String r2 = "JGZ"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 73
            goto L_0x0717
        L_0x04c9:
            java.lang.String r2 = "mh"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 84
            goto L_0x0717
        L_0x04d5:
            java.lang.String r2 = "b5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 16
            goto L_0x0717
        L_0x04e1:
            java.lang.String r2 = "V5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 129(0x81, float:1.81E-43)
            goto L_0x0717
        L_0x04ed:
            java.lang.String r2 = "V1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 127(0x7f, float:1.78E-43)
            goto L_0x0717
        L_0x04f9:
            java.lang.String r2 = "Q5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 113(0x71, float:1.58E-43)
            goto L_0x0717
        L_0x0505:
            java.lang.String r2 = "C1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 20
            goto L_0x0717
        L_0x0511:
            java.lang.String r2 = "woods_fn"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 134(0x86, float:1.88E-43)
            goto L_0x0717
        L_0x051d:
            java.lang.String r2 = "ELUGA_A3_Pro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 31
            goto L_0x0717
        L_0x0529:
            java.lang.String r2 = "Z12_PRO"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 138(0x8a, float:1.93E-43)
            goto L_0x0717
        L_0x0535:
            java.lang.String r2 = "BLACK-1X"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 17
            goto L_0x0717
        L_0x0541:
            java.lang.String r2 = "taido_row"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 121(0x79, float:1.7E-43)
            goto L_0x0717
        L_0x054d:
            java.lang.String r2 = "Pixi4-7_3G"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 105(0x69, float:1.47E-43)
            goto L_0x0717
        L_0x0559:
            java.lang.String r2 = "GIONEE_GBL7360"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 53
            goto L_0x0717
        L_0x0565:
            java.lang.String r2 = "GiONEE_CBL7513"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 51
            goto L_0x0717
        L_0x0571:
            java.lang.String r2 = "OnePlus5T"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 91
            goto L_0x0717
        L_0x057d:
            java.lang.String r2 = "whyred"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 132(0x84, float:1.85E-43)
            goto L_0x0717
        L_0x0589:
            java.lang.String r2 = "watson"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 131(0x83, float:1.84E-43)
            goto L_0x0717
        L_0x0595:
            java.lang.String r2 = "SVP-DTV15"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 119(0x77, float:1.67E-43)
            goto L_0x0717
        L_0x05a1:
            java.lang.String r2 = "A7000-a"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 9
            goto L_0x0717
        L_0x05ad:
            java.lang.String r2 = "nicklaus_f"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 88
            goto L_0x0717
        L_0x05b9:
            java.lang.String r2 = "tcl_eu"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 126(0x7e, float:1.77E-43)
            goto L_0x0717
        L_0x05c5:
            java.lang.String r2 = "ELUGA_Ray_X"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 34
            goto L_0x0717
        L_0x05d1:
            java.lang.String r2 = "s905x018"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 120(0x78, float:1.68E-43)
            goto L_0x0717
        L_0x05dd:
            java.lang.String r2 = "A10-70L"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 6
            goto L_0x0717
        L_0x05e8:
            java.lang.String r2 = "A10-70F"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 5
            goto L_0x0717
        L_0x05f3:
            java.lang.String r2 = "namath"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 87
            goto L_0x0717
        L_0x05ff:
            java.lang.String r2 = "Slate_Pro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 118(0x76, float:1.65E-43)
            goto L_0x0717
        L_0x060b:
            java.lang.String r2 = "iris60"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 70
            goto L_0x0717
        L_0x0617:
            java.lang.String r2 = "BRAVIA_ATV2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 18
            goto L_0x0717
        L_0x0623:
            java.lang.String r2 = "GiONEE_GBL7319"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 52
            goto L_0x0717
        L_0x062f:
            java.lang.String r2 = "panell_dt"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 99
            goto L_0x0717
        L_0x063b:
            java.lang.String r2 = "panell_ds"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 98
            goto L_0x0717
        L_0x0647:
            java.lang.String r2 = "panell_dl"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 97
            goto L_0x0717
        L_0x0653:
            java.lang.String r2 = "vernee_M5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 130(0x82, float:1.82E-43)
            goto L_0x0717
        L_0x065f:
            java.lang.String r2 = "pacificrim"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 95
            goto L_0x0717
        L_0x066b:
            java.lang.String r2 = "Phantom6"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 104(0x68, float:1.46E-43)
            goto L_0x0717
        L_0x0677:
            java.lang.String r2 = "ComioS1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 21
            goto L_0x0717
        L_0x0683:
            java.lang.String r2 = "XT1663"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 137(0x89, float:1.92E-43)
            goto L_0x0717
        L_0x068f:
            java.lang.String r2 = "RAIJIN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 116(0x74, float:1.63E-43)
            goto L_0x0717
        L_0x069b:
            java.lang.String r2 = "AquaPowerM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 13
            goto L_0x0717
        L_0x06a7:
            java.lang.String r2 = "PGN611"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 103(0x67, float:1.44E-43)
            goto L_0x0717
        L_0x06b3:
            java.lang.String r2 = "PGN610"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 102(0x66, float:1.43E-43)
            goto L_0x0717
        L_0x06be:
            java.lang.String r2 = "PGN528"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 101(0x65, float:1.42E-43)
            goto L_0x0717
        L_0x06c9:
            java.lang.String r2 = "NX573J"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 90
            goto L_0x0717
        L_0x06d4:
            java.lang.String r2 = "NX541J"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 89
            goto L_0x0717
        L_0x06df:
            java.lang.String r2 = "CP8676_I02"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 22
            goto L_0x0717
        L_0x06ea:
            java.lang.String r2 = "K50a40"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 74
            goto L_0x0717
        L_0x06f5:
            java.lang.String r2 = "GIONEE_SWW1631"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 56
            goto L_0x0717
        L_0x0700:
            java.lang.String r2 = "GIONEE_SWW1627"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 55
            goto L_0x0717
        L_0x070b:
            java.lang.String r2 = "GIONEE_SWW1609"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0716
            r2 = 54
            goto L_0x0717
        L_0x0716:
            r2 = -1
        L_0x0717:
            switch(r2) {
                case 0: goto L_0x0073;
                case 1: goto L_0x0073;
                case 2: goto L_0x0073;
                case 3: goto L_0x0073;
                case 4: goto L_0x0073;
                case 5: goto L_0x0073;
                case 6: goto L_0x0073;
                case 7: goto L_0x0073;
                case 8: goto L_0x0073;
                case 9: goto L_0x0073;
                case 10: goto L_0x0073;
                case 11: goto L_0x0073;
                case 12: goto L_0x0073;
                case 13: goto L_0x0073;
                case 14: goto L_0x0073;
                case 15: goto L_0x0073;
                case 16: goto L_0x0073;
                case 17: goto L_0x0073;
                case 18: goto L_0x0073;
                case 19: goto L_0x0073;
                case 20: goto L_0x0073;
                case 21: goto L_0x0073;
                case 22: goto L_0x0073;
                case 23: goto L_0x0073;
                case 24: goto L_0x0073;
                case 25: goto L_0x0073;
                case 26: goto L_0x0073;
                case 27: goto L_0x0073;
                case 28: goto L_0x0073;
                case 29: goto L_0x0073;
                case 30: goto L_0x0073;
                case 31: goto L_0x0073;
                case 32: goto L_0x0073;
                case 33: goto L_0x0073;
                case 34: goto L_0x0073;
                case 35: goto L_0x0073;
                case 36: goto L_0x0073;
                case 37: goto L_0x0073;
                case 38: goto L_0x0073;
                case 39: goto L_0x0073;
                case 40: goto L_0x0073;
                case 41: goto L_0x0073;
                case 42: goto L_0x0073;
                case 43: goto L_0x0073;
                case 44: goto L_0x0073;
                case 45: goto L_0x0073;
                case 46: goto L_0x0073;
                case 47: goto L_0x0073;
                case 48: goto L_0x0073;
                case 49: goto L_0x0073;
                case 50: goto L_0x0073;
                case 51: goto L_0x0073;
                case 52: goto L_0x0073;
                case 53: goto L_0x0073;
                case 54: goto L_0x0073;
                case 55: goto L_0x0073;
                case 56: goto L_0x0073;
                case 57: goto L_0x0073;
                case 58: goto L_0x0073;
                case 59: goto L_0x0073;
                case 60: goto L_0x0073;
                case 61: goto L_0x0073;
                case 62: goto L_0x0073;
                case 63: goto L_0x0073;
                case 64: goto L_0x0073;
                case 65: goto L_0x0073;
                case 66: goto L_0x0073;
                case 67: goto L_0x0073;
                case 68: goto L_0x0073;
                case 69: goto L_0x0073;
                case 70: goto L_0x0073;
                case 71: goto L_0x0073;
                case 72: goto L_0x0073;
                case 73: goto L_0x0073;
                case 74: goto L_0x0073;
                case 75: goto L_0x0073;
                case 76: goto L_0x0073;
                case 77: goto L_0x0073;
                case 78: goto L_0x0073;
                case 79: goto L_0x0073;
                case 80: goto L_0x0073;
                case 81: goto L_0x0073;
                case 82: goto L_0x0073;
                case 83: goto L_0x0073;
                case 84: goto L_0x0073;
                case 85: goto L_0x0073;
                case 86: goto L_0x0073;
                case 87: goto L_0x0073;
                case 88: goto L_0x0073;
                case 89: goto L_0x0073;
                case 90: goto L_0x0073;
                case 91: goto L_0x0073;
                case 92: goto L_0x0073;
                case 93: goto L_0x0073;
                case 94: goto L_0x0073;
                case 95: goto L_0x0073;
                case 96: goto L_0x0073;
                case 97: goto L_0x0073;
                case 98: goto L_0x0073;
                case 99: goto L_0x0073;
                case 100: goto L_0x0073;
                case 101: goto L_0x0073;
                case 102: goto L_0x0073;
                case 103: goto L_0x0073;
                case 104: goto L_0x0073;
                case 105: goto L_0x0073;
                case 106: goto L_0x0073;
                case 107: goto L_0x0073;
                case 108: goto L_0x0073;
                case 109: goto L_0x0073;
                case 110: goto L_0x0073;
                case 111: goto L_0x0073;
                case 112: goto L_0x0073;
                case 113: goto L_0x0073;
                case 114: goto L_0x0073;
                case 115: goto L_0x0073;
                case 116: goto L_0x0073;
                case 117: goto L_0x0073;
                case 118: goto L_0x0073;
                case 119: goto L_0x0073;
                case 120: goto L_0x0073;
                case 121: goto L_0x0073;
                case 122: goto L_0x0073;
                case 123: goto L_0x0073;
                case 124: goto L_0x0073;
                case 125: goto L_0x0073;
                case 126: goto L_0x0073;
                case 127: goto L_0x0073;
                case 128: goto L_0x0073;
                case 129: goto L_0x0073;
                case 130: goto L_0x0073;
                case 131: goto L_0x0073;
                case 132: goto L_0x0073;
                case 133: goto L_0x0073;
                case 134: goto L_0x0073;
                case 135: goto L_0x0073;
                case 136: goto L_0x0073;
                case 137: goto L_0x0073;
                case 138: goto L_0x0073;
                case 139: goto L_0x0073;
                default: goto L_0x071a;
            }
        L_0x071a:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzalh.zzd     // Catch:{ all -> 0x075b }
            int r2 = r1.hashCode()     // Catch:{ all -> 0x075b }
            r3 = -594534941(0xffffffffdc901de3, float:-3.2452206E17)
            if (r2 == r3) goto L_0x0744
            r3 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r3) goto L_0x073a
            r3 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r3) goto L_0x0730
            goto L_0x074d
        L_0x0730:
            java.lang.String r2 = "AFTN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x074d
            r7 = 1
            goto L_0x074d
        L_0x073a:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x074d
            r7 = 0
            goto L_0x074d
        L_0x0744:
            java.lang.String r2 = "JSN-L21"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x074d
            r7 = 2
        L_0x074d:
            if (r7 == 0) goto L_0x0073
            if (r7 == r9) goto L_0x0073
            if (r7 == r8) goto L_0x0073
        L_0x0753:
            zze = r0     // Catch:{ all -> 0x075b }
            zzd = r9     // Catch:{ all -> 0x075b }
        L_0x0757:
            monitor-exit(r13)     // Catch:{ all -> 0x075b }
            boolean r13 = zze
            return r13
        L_0x075b:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x075b }
            goto L_0x075f
        L_0x075e:
            throw r0
        L_0x075f:
            goto L_0x075e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalw.zzaG(java.lang.String):boolean");
    }

    public static List<zzaah> zzaH(zzaal zzaal, zzkc zzkc, boolean z, boolean z2) throws zzaas {
        Pair<Integer, Integer> zzf2;
        String str = zzkc.zzl;
        if (str == null) {
            return Collections.emptyList();
        }
        List<zzaah> zzd2 = zzaax.zzd(zzaax.zzc(str, z, z2), zzkc);
        if ("video/dolby-vision".equals(str) && (zzf2 = zzaax.zzf(zzkc)) != null) {
            int intValue = ((Integer) zzf2.first).intValue();
            if (intValue == 16 || intValue == 256) {
                zzd2.addAll(zzaax.zzc("video/hevc", z, z2));
            } else if (intValue == 512) {
                zzd2.addAll(zzaax.zzc("video/avc", z, z2));
            }
        }
        return Collections.unmodifiableList(zzd2);
    }

    private final boolean zzaI(zzaah zzaah) {
        if (zzalh.zza < 23 || this.zzI || zzaG(zzaah.zza) || (zzaah.zzf && !zzalp.zza(this.zzf))) {
            return false;
        }
        return true;
    }

    private final void zzaJ() {
        zzabb zzay;
        this.zzq = false;
        if (zzalh.zza >= 23 && this.zzI && (zzay = zzay()) != null) {
            this.zzb = new zzalv(this, zzay, (byte[]) null);
        }
    }

    private final void zzaK() {
        int i = this.zzD;
        if (i == -1) {
            if (this.zzE != -1) {
                i = -1;
            } else {
                return;
            }
        }
        zzamp zzamp = this.zzH;
        if (zzamp == null || zzamp.zzb != i || zzamp.zzc != this.zzE || zzamp.zzd != this.zzF || zzamp.zze != this.zzG) {
            zzamp zzamp2 = new zzamp(i, this.zzE, this.zzF, this.zzG);
            this.zzH = zzamp2;
            this.zzh.zzf(zzamp2);
        }
    }

    private final void zzaL() {
        zzamp zzamp = this.zzH;
        if (zzamp != null) {
            this.zzh.zzf(zzamp);
        }
    }

    public static boolean zzaM(long j) {
        return j < -30000;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzaN(com.google.android.gms.internal.ads.zzaah r5, java.lang.String r6, int r7, int r8) {
        /*
            r0 = -1
            if (r7 == r0) goto L_0x00a4
            if (r8 != r0) goto L_0x0007
            goto L_0x00a4
        L_0x0007:
            int r1 = r6.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1851077871: goto L_0x004e;
                case -1664118616: goto L_0x0044;
                case -1662541442: goto L_0x003a;
                case 1187890754: goto L_0x0030;
                case 1331836730: goto L_0x0026;
                case 1599127256: goto L_0x001c;
                case 1599127257: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0058
        L_0x0012:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0058
            r6 = 6
            goto L_0x0059
        L_0x001c:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0058
            r6 = 4
            goto L_0x0059
        L_0x0026:
            java.lang.String r1 = "video/avc"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0058
            r6 = 3
            goto L_0x0059
        L_0x0030:
            java.lang.String r1 = "video/mp4v-es"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0058
            r6 = 1
            goto L_0x0059
        L_0x003a:
            java.lang.String r1 = "video/hevc"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0058
            r6 = 5
            goto L_0x0059
        L_0x0044:
            java.lang.String r1 = "video/3gpp"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0058
            r6 = 0
            goto L_0x0059
        L_0x004e:
            java.lang.String r1 = "video/dolby-vision"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0058
            r6 = 2
            goto L_0x0059
        L_0x0058:
            r6 = -1
        L_0x0059:
            switch(r6) {
                case 0: goto L_0x009c;
                case 1: goto L_0x009c;
                case 2: goto L_0x0060;
                case 3: goto L_0x0060;
                case 4: goto L_0x009c;
                case 5: goto L_0x005d;
                case 6: goto L_0x005d;
                default: goto L_0x005c;
            }
        L_0x005c:
            return r0
        L_0x005d:
            int r7 = r7 * r8
            goto L_0x009f
        L_0x0060:
            java.lang.String r6 = com.google.android.gms.internal.ads.zzalh.zzd
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r6 = r1.equals(r6)
            if (r6 != 0) goto L_0x009b
            java.lang.String r6 = com.google.android.gms.internal.ads.zzalh.zzc
            java.lang.String r1 = "Amazon"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x008c
            java.lang.String r6 = com.google.android.gms.internal.ads.zzalh.zzd
            java.lang.String r1 = "KFSOWI"
            boolean r6 = r1.equals(r6)
            if (r6 != 0) goto L_0x009b
            java.lang.String r6 = com.google.android.gms.internal.ads.zzalh.zzd
            java.lang.String r1 = "AFTS"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x008c
            boolean r5 = r5.zzf
            if (r5 != 0) goto L_0x009b
        L_0x008c:
            r5 = 16
            int r6 = com.google.android.gms.internal.ads.zzalh.zzw(r7, r5)
            int r5 = com.google.android.gms.internal.ads.zzalh.zzw(r8, r5)
            int r5 = r5 * r6
            int r7 = r5 * 256
            goto L_0x009e
        L_0x009b:
            return r0
        L_0x009c:
            int r7 = r7 * r8
        L_0x009e:
            r2 = 2
        L_0x009f:
            int r7 = r7 * 3
            int r2 = r2 + r2
            int r7 = r7 / r2
            return r7
        L_0x00a4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalw.zzaN(com.google.android.gms.internal.ads.zzaah, java.lang.String, int, int):int");
    }

    public final void zzA() {
        try {
            super.zzA();
        } finally {
            Surface surface = this.zzn;
            if (surface != null) {
                if (this.zzm == surface) {
                    this.zzm = null;
                }
                surface.release();
                this.zzn = null;
            }
        }
    }

    public final void zzI(float f, float f2) throws zzio {
        super.zzI(f, f2);
        this.zzg.zze(f);
    }

    public final String zzJ() {
        return "MediaCodecVideoRenderer";
    }

    public final boolean zzL() {
        Surface surface;
        if (super.zzL() && (this.zzq || (((surface = this.zzn) != null && this.zzm == surface) || zzay() == null || this.zzI))) {
            this.zzu = -9223372036854775807L;
            return true;
        } else if (this.zzu == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzu) {
                return true;
            }
            this.zzu = -9223372036854775807L;
            return false;
        }
    }

    public final int zzO(zzaal zzaal, zzkc zzkc) throws zzaas {
        int i = 0;
        if (!zzakg.zzb(zzkc.zzl)) {
            return 0;
        }
        boolean z = zzkc.zzo != null;
        List<zzaah> zzaH = zzaH(zzaal, zzkc, z, false);
        if (z && zzaH.isEmpty()) {
            zzaH = zzaH(zzaal, zzkc, false, false);
        }
        if (zzaH.isEmpty()) {
            return 1;
        }
        if (!zzaaj.zzax(zzkc)) {
            return 2;
        }
        zzaah zzaah = zzaH.get(0);
        boolean zzc2 = zzaah.zzc(zzkc);
        int i2 = true != zzaah.zzd(zzkc) ? 8 : 16;
        if (zzc2) {
            List<zzaah> zzaH2 = zzaH(zzaal, zzkc, z, true);
            if (!zzaH2.isEmpty()) {
                zzaah zzaah2 = zzaH2.get(0);
                if (zzaah2.zzc(zzkc) && zzaah2.zzd(zzkc)) {
                    i = 32;
                }
            }
        }
        return (true != zzc2 ? 3 : 4) | i2 | i;
    }

    public final List<zzaah> zzP(zzaal zzaal, zzkc zzkc, boolean z) throws zzaas {
        return zzaH(zzaal, zzkc, false, this.zzI);
    }

    public final zzaad zzR(zzaah zzaah, zzkc zzkc, @Nullable MediaCrypto mediaCrypto, float f) {
        String str;
        zzalu zzalu;
        boolean z;
        Pair<Integer, Integer> zzf2;
        String str2;
        String str3;
        Point point;
        int zzaN;
        zzaah zzaah2 = zzaah;
        zzkc zzkc2 = zzkc;
        float f2 = f;
        String str4 = zzaah2.zzc;
        zzkc[] zzC2 = zzC();
        int i = zzkc2.zzq;
        int i2 = zzkc2.zzr;
        int zzaA = zzaA(zzaah, zzkc);
        int length = zzC2.length;
        if (length == 1) {
            if (!(zzaA == -1 || (zzaN = zzaN(zzaah2, zzkc2.zzl, zzkc2.zzq, zzkc2.zzr)) == -1)) {
                zzaA = Math.min((int) (((float) zzaA) * 1.5f), zzaN);
            }
            zzalu = new zzalu(i, i2, zzaA);
            str = str4;
        } else {
            boolean z2 = false;
            for (int i3 = 0; i3 < length; i3++) {
                zzkc zzkc3 = zzC2[i3];
                if (zzkc2.zzx != null && zzkc3.zzx == null) {
                    zzkb zza = zzkc3.zza();
                    zza.zzv(zzkc2.zzx);
                    zzkc3 = zza.zzD();
                }
                if (zzaah2.zze(zzkc2, zzkc3).zzd != 0) {
                    int i4 = zzkc3.zzq;
                    z2 |= i4 == -1 || zzkc3.zzr == -1;
                    i = Math.max(i, i4);
                    i2 = Math.max(i2, zzkc3.zzr);
                    zzaA = Math.max(zzaA, zzaA(zzaah2, zzkc3));
                }
            }
            if (z2) {
                String str5 = "x";
                String str6 = "MediaCodecVideoRenderer";
                Log.w(str6, GeneratedOutlineSupport.outline11(66, "Resolutions unknown. Codec max resolution: ", i, str5, i2));
                int i5 = zzkc2.zzr;
                int i6 = zzkc2.zzq;
                int i7 = i5 > i6 ? i5 : i6;
                int i8 = i5 <= i6 ? i5 : i6;
                float f3 = ((float) i8) / ((float) i7);
                int[] iArr = zzc;
                str = str4;
                int i9 = 0;
                while (i9 < 9) {
                    int i10 = iArr[i9];
                    int[] iArr2 = iArr;
                    int i11 = (int) (((float) i10) * f3);
                    if (i10 <= i7 || i11 <= i8) {
                        break;
                    }
                    int i12 = i7;
                    int i13 = i8;
                    if (zzalh.zza >= 21) {
                        int i14 = i5 <= i6 ? i10 : i11;
                        if (i5 <= i6) {
                            i10 = i11;
                        }
                        Point zzg2 = zzaah2.zzg(i14, i10);
                        str2 = str6;
                        str3 = str5;
                        if (zzaah2.zzf(zzg2.x, zzg2.y, (double) zzkc2.zzs)) {
                            point = zzg2;
                            break;
                        }
                    } else {
                        str2 = str6;
                        str3 = str5;
                        try {
                            int zzw2 = zzalh.zzw(i10, 16) * 16;
                            int zzw3 = zzalh.zzw(i11, 16) * 16;
                            if (zzw2 * zzw3 <= zzaax.zze()) {
                                int i15 = i5 <= i6 ? zzw2 : zzw3;
                                if (i5 <= i6) {
                                    zzw2 = zzw3;
                                }
                                point = new Point(i15, zzw2);
                            }
                        } catch (zzaas unused) {
                        }
                    }
                    i9++;
                    iArr = iArr2;
                    i7 = i12;
                    i8 = i13;
                    str5 = str3;
                    str6 = str2;
                }
                str2 = str6;
                str3 = str5;
                point = null;
                if (point != null) {
                    i = Math.max(i, point.x);
                    i2 = Math.max(i2, point.y);
                    zzaA = Math.max(zzaA, zzaN(zzaah2, zzkc2.zzl, i, i2));
                    Log.w(str2, GeneratedOutlineSupport.outline11(57, "Codec max resolution adjusted to: ", i, str3, i2));
                }
            } else {
                str = str4;
            }
            zzalu = new zzalu(i, i2, zzaA);
        }
        this.zzj = zzalu;
        boolean z3 = this.zzi;
        int i16 = this.zzI ? this.zzJ : 0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", zzkc2.zzq);
        mediaFormat.setInteger("height", zzkc2.zzr);
        zzakd.zza(mediaFormat, zzkc2.zzn);
        float f4 = zzkc2.zzs;
        if (f4 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f4);
        }
        zzakd.zzb(mediaFormat, "rotation-degrees", zzkc2.zzt);
        zzall zzall = zzkc2.zzx;
        if (zzall != null) {
            zzakd.zzb(mediaFormat, "color-transfer", zzall.zzc);
            zzakd.zzb(mediaFormat, "color-standard", zzall.zza);
            zzakd.zzb(mediaFormat, "color-range", zzall.zzb);
            byte[] bArr = zzall.zzd;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzkc2.zzl) && (zzf2 = zzaax.zzf(zzkc)) != null) {
            zzakd.zzb(mediaFormat, Scopes.PROFILE, ((Integer) zzf2.first).intValue());
        }
        mediaFormat.setInteger("max-width", zzalu.zza);
        mediaFormat.setInteger("max-height", zzalu.zzb);
        zzakd.zzb(mediaFormat, "max-input-size", zzalu.zzc);
        if (zzalh.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            float f5 = f;
            if (f5 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f5);
            }
        }
        if (z3) {
            z = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z = true;
        }
        if (i16 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z);
            mediaFormat.setInteger("audio-session-id", i16);
        }
        if (this.zzm == null) {
            if (zzaI(zzaah)) {
                if (this.zzn == null) {
                    this.zzn = zzalp.zzb(this.zzf, zzaah2.zzf);
                }
                this.zzm = this.zzn;
            } else {
                throw new IllegalStateException();
            }
        }
        return new zzaad(zzaah, mediaFormat, zzkc, this.zzm, (MediaCrypto) null, 0);
    }

    public final zzrs zzS(zzaah zzaah, zzkc zzkc, zzkc zzkc2) {
        int i;
        int i2;
        zzrs zze2 = zzaah.zze(zzkc, zzkc2);
        int i3 = zze2.zze;
        int i4 = zzkc2.zzq;
        zzalu zzalu = this.zzj;
        if (i4 > zzalu.zza || zzkc2.zzr > zzalu.zzb) {
            i3 |= 256;
        }
        if (zzaA(zzaah, zzkc2) > this.zzj.zzc) {
            i3 |= 64;
        }
        String str = zzaah.zza;
        if (i3 != 0) {
            i = i3;
            i2 = 0;
        } else {
            i2 = zze2.zzd;
            i = 0;
        }
        return new zzrs(str, zzkc, zzkc2, i2, i);
    }

    public final float zzT(float f, zzkc zzkc, zzkc[] zzkcArr) {
        float f2 = -1.0f;
        for (zzkc zzkc2 : zzkcArr) {
            float f3 = zzkc2.zzs;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    public final void zzU(String str, long j, long j2) {
        this.zzh.zzb(str, j, j2);
        this.zzk = zzaG(str);
        zzaah zzal = zzal();
        if (zzal != null) {
            boolean z = false;
            if (zzalh.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzal.zzb)) {
                MediaCodecInfo.CodecProfileLevel[] zzb2 = zzal.zzb();
                int length = zzb2.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (zzb2[i].profile == 16384) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.zzl = z;
            if (zzalh.zza >= 23 && this.zzI) {
                zzabb zzay = zzay();
                if (zzay != null) {
                    this.zzb = new zzalv(this, zzay, (byte[]) null);
                    return;
                }
                throw null;
            }
            return;
        }
        throw null;
    }

    public final void zzV(String str) {
        this.zzh.zzh(str);
    }

    public final void zzW(Exception exc) {
        zzaka.zzb("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzh.zzj(exc);
    }

    @Nullable
    public final zzrs zzX(zzkd zzkd) throws zzio {
        zzrs zzX = super.zzX(zzkd);
        this.zzh.zzc(zzkd.zza, zzX);
        return zzX;
    }

    public final void zzY(zzkc zzkc, @Nullable MediaFormat mediaFormat) {
        int i;
        int i2;
        zzabb zzay = zzay();
        if (zzay != null) {
            zzay.zzo(this.zzp);
        }
        if (this.zzI) {
            this.zzD = zzkc.zzq;
            this.zzE = zzkc.zzr;
        } else if (mediaFormat != null) {
            boolean z = false;
            if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
                z = true;
            }
            if (z) {
                i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                i = mediaFormat.getInteger("width");
            }
            this.zzD = i;
            if (z) {
                i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                i2 = mediaFormat.getInteger("height");
            }
            this.zzE = i2;
        } else {
            throw null;
        }
        this.zzG = zzkc.zzu;
        if (zzalh.zza >= 21) {
            int i3 = zzkc.zzt;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzD;
                this.zzD = this.zzE;
                this.zzE = i4;
                this.zzG = 1.0f / this.zzG;
            }
        } else {
            this.zzF = zzkc.zzt;
        }
        this.zzg.zzf(zzkc.zzs);
    }

    public final void zzZ(long j) throws zzio {
        zzak(j);
        zzaK();
        this.zza.zze++;
        zzaz();
        zzat(j);
    }

    public final void zzaD(zzabb zzabb, int i, long j) {
        zzalf.zza("skipVideoBuffer");
        zzabb.zzh(i, false);
        zzalf.zzb();
        this.zza.zzf++;
    }

    public final void zzaE(zzabb zzabb, int i, long j) {
        zzaK();
        zzalf.zza("releaseOutputBuffer");
        zzabb.zzh(i, true);
        zzalf.zzb();
        this.zzA = SystemClock.elapsedRealtime() * 1000;
        this.zza.zze++;
        this.zzx = 0;
        zzaz();
    }

    @RequiresApi(21)
    public final void zzaF(zzabb zzabb, int i, long j, long j2) {
        zzaK();
        zzalf.zza("releaseOutputBuffer");
        zzabb.zzi(i, j2);
        zzalf.zzb();
        this.zzA = SystemClock.elapsedRealtime() * 1000;
        this.zza.zze++;
        this.zzx = 0;
        zzaz();
    }

    @CallSuper
    public final void zzaa(zzrr zzrr) throws zzio {
        if (!this.zzI) {
            this.zzy++;
        }
        if (zzalh.zza < 23 && this.zzI) {
            zzZ(zzrr.zzd);
        }
    }

    public final void zzab() {
        zzaJ();
    }

    public final void zzad(int i) {
        zzro zzro = this.zza;
        zzro.zzg += i;
        this.zzw += i;
        int i2 = this.zzx + i;
        this.zzx = i2;
        zzro.zzh = Math.max(i2, zzro.zzh);
    }

    public final void zzae(long j) {
        zzro zzro = this.zza;
        zzro.zzj += j;
        zzro.zzk++;
        this.zzB += j;
        this.zzC++;
    }

    public final boolean zzaf(long j, long j2, @Nullable zzabb zzabb, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzkc zzkc) throws zzio {
        boolean z3;
        int zzG2;
        long j4 = j;
        zzabb zzabb2 = zzabb;
        int i4 = i;
        long j5 = j3;
        if (zzabb2 != null) {
            if (this.zzt == -9223372036854775807L) {
                this.zzt = j4;
            }
            if (j5 != this.zzz) {
                this.zzg.zzg(j5);
                this.zzz = j5;
            }
            long zzaw = zzaw();
            long j6 = j5 - zzaw;
            if (!z || z2) {
                float zzau = zzau();
                int zze2 = zze();
                long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                double d = (double) (j5 - j4);
                double d2 = (double) zzau;
                Double.isNaN(d);
                Double.isNaN(d2);
                long j7 = (long) (d / d2);
                if (zze2 == 2) {
                    j7 -= elapsedRealtime - j2;
                }
                if (this.zzm != this.zzn) {
                    long j8 = elapsedRealtime - this.zzA;
                    boolean z4 = this.zzs ? !this.zzq : !(zze2 != 2 && !this.zzr);
                    if (this.zzu == -9223372036854775807L && j4 >= zzaw && (z4 || (zze2 == 2 && zzaM(j7) && j8 > 100000))) {
                        long nanoTime = System.nanoTime();
                        if (zzalh.zza >= 21) {
                            zzaF(zzabb, i, j6, nanoTime);
                        } else {
                            zzaE(zzabb2, i4, j6);
                        }
                        zzae(j7);
                        return true;
                    } else if (zze2 != 2 || j4 == this.zzt) {
                        return false;
                    } else {
                        long nanoTime2 = System.nanoTime();
                        long zzj2 = this.zzg.zzj((j7 * 1000) + nanoTime2);
                        long j9 = (zzj2 - nanoTime2) / 1000;
                        long j10 = this.zzu;
                        if (j9 < -500000 && !z2 && (zzG2 = zzG(j)) != 0) {
                            zzro zzro = this.zza;
                            zzro.zzi++;
                            int i5 = this.zzy + zzG2;
                            if (j10 != -9223372036854775807L) {
                                zzro.zzf += i5;
                            } else {
                                zzad(i5);
                            }
                            zzan();
                            return false;
                        } else if (zzaM(j9) && !z2) {
                            if (j10 != -9223372036854775807L) {
                                zzaD(zzabb2, i4, j6);
                                z3 = true;
                            } else {
                                zzalf.zza("dropVideoBuffer");
                                zzabb2.zzh(i4, false);
                                zzalf.zzb();
                                z3 = true;
                                zzad(1);
                            }
                            zzae(j9);
                            return z3;
                        } else if (zzalh.zza >= 21) {
                            if (j9 >= 50000) {
                                return false;
                            }
                            zzaF(zzabb, i, j6, zzj2);
                            zzae(j9);
                            return true;
                        } else if (j9 >= 30000) {
                            return false;
                        } else {
                            if (j9 > 11000) {
                                try {
                                    Thread.sleep((-10000 + j9) / 1000);
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                    return false;
                                }
                            }
                            zzaE(zzabb2, i4, j6);
                            zzae(j9);
                            return true;
                        }
                    }
                } else if (!zzaM(j7)) {
                    return false;
                } else {
                    zzaD(zzabb2, i4, j6);
                    zzae(j7);
                    return true;
                }
            } else {
                zzaD(zzabb2, i4, j6);
                return true;
            }
        } else {
            throw null;
        }
    }

    public final boolean zzah(zzaah zzaah) {
        return this.zzm != null || zzaI(zzaah);
    }

    public final boolean zzai() {
        return this.zzI && zzalh.zza < 23;
    }

    @CallSuper
    public final void zzap() {
        super.zzap();
        this.zzy = 0;
    }

    public final zzaag zzar(Throwable th, @Nullable zzaah zzaah) {
        return new zzalt(th, zzaah, this.zzm);
    }

    @TargetApi(29)
    public final void zzas(zzrr zzrr) throws zzio {
        if (this.zzl) {
            ByteBuffer byteBuffer = zzrr.zze;
            if (byteBuffer == null) {
                throw null;
            } else if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    zzabb zzay = zzay();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    zzay.zzn(bundle);
                }
            }
        }
    }

    @CallSuper
    public final void zzat(long j) {
        super.zzat(j);
        if (!this.zzI) {
            this.zzy--;
        }
    }

    public final void zzaz() {
        this.zzs = true;
        if (!this.zzq) {
            this.zzq = true;
            this.zzh.zzg(this.zzm);
            this.zzo = true;
        }
    }

    public final void zzt(int i, @Nullable Object obj) throws zzio {
        int intValue;
        if (i == 1) {
            Surface surface = obj instanceof Surface ? (Surface) obj : null;
            if (surface == null) {
                Surface surface2 = this.zzn;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzaah zzal = zzal();
                    if (zzal != null && zzaI(zzal)) {
                        surface = zzalp.zzb(this.zzf, zzal.zzf);
                        this.zzn = surface;
                    }
                }
            }
            if (this.zzm != surface) {
                this.zzm = surface;
                this.zzg.zzc(surface);
                this.zzo = false;
                int zze2 = zze();
                zzabb zzay = zzay();
                if (zzay != null) {
                    if (zzalh.zza < 23 || surface == null || this.zzk) {
                        zzam();
                        zzag();
                    } else {
                        zzay.zzm(surface);
                    }
                }
                if (surface == null || surface == this.zzn) {
                    this.zzH = null;
                    zzaJ();
                    return;
                }
                zzaL();
                zzaJ();
                if (zze2 == 2) {
                    this.zzu = -9223372036854775807L;
                }
            } else if (surface != null && surface != this.zzn) {
                zzaL();
                if (this.zzo) {
                    this.zzh.zzg(this.zzm);
                }
            }
        } else if (i == 4) {
            this.zzp = ((Integer) obj).intValue();
            zzabb zzay2 = zzay();
            if (zzay2 != null) {
                zzay2.zzo(this.zzp);
            }
        } else if (i == 6) {
            this.zzK = (zzalx) obj;
        } else if (i == 102 && this.zzJ != (intValue = ((Integer) obj).intValue())) {
            this.zzJ = intValue;
            if (this.zzI) {
                zzam();
            }
        }
    }

    public final void zzu(boolean z, boolean z2) throws zzio {
        super.zzu(z, z2);
        boolean z3 = zzD().zzb;
        boolean z4 = true;
        if (z3 && this.zzJ == 0) {
            z4 = false;
        }
        zzajg.zzd(z4);
        if (this.zzI != z3) {
            this.zzI = z3;
            zzam();
        }
        this.zzh.zza(this.zza);
        this.zzg.zza();
        this.zzr = z2;
        this.zzs = false;
    }

    public final void zzw(long j, boolean z) throws zzio {
        super.zzw(j, z);
        zzaJ();
        this.zzg.zzd();
        this.zzz = -9223372036854775807L;
        this.zzt = -9223372036854775807L;
        this.zzx = 0;
        this.zzu = -9223372036854775807L;
    }

    public final void zzx() {
        this.zzw = 0;
        this.zzv = SystemClock.elapsedRealtime();
        this.zzA = SystemClock.elapsedRealtime() * 1000;
        this.zzB = 0;
        this.zzC = 0;
        this.zzg.zzb();
    }

    public final void zzy() {
        this.zzu = -9223372036854775807L;
        if (this.zzw > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzh.zzd(this.zzw, elapsedRealtime - this.zzv);
            this.zzw = 0;
            this.zzv = elapsedRealtime;
        }
        int i = this.zzC;
        if (i != 0) {
            this.zzh.zze(this.zzB, i);
            this.zzB = 0;
            this.zzC = 0;
        }
        this.zzg.zzh();
    }

    public final void zzz() {
        this.zzH = null;
        zzaJ();
        this.zzo = false;
        this.zzg.zzi();
        this.zzb = null;
        try {
            super.zzz();
        } finally {
            this.zzh.zzi(this.zza);
        }
    }
}
