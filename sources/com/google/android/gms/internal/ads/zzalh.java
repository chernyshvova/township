package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.DisplayCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.drive.DriveFile;
import com.google.android.material.textfield.TextInputLayout;
import com.helpshift.support.conversations.ConversationalFragmentRenderer;
import com.helpshift.support.views.HSTypingIndicatorView;
import com.playrix.gplay.billing.Base64;
import com.swrve.sdk.ISwrveCommon;
import com.swrve.sdk.rest.RESTClient;
import com.vungle.warren.VisionController;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalh {
    public static final int zza;
    public static final String zzb = Build.DEVICE;
    public static final String zzc = Build.MANUFACTURER;
    public static final String zzd;
    public static final String zze;
    public static final byte[] zzf = new byte[0];
    public static final Pattern zzg = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    public static final Pattern zzh = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    public static final Pattern zzi = Pattern.compile("%([A-Fa-f0-9]{2})");
    public static final Pattern zzj = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
    @Nullable
    public static HashMap<String, String> zzk;
    public static final String[] zzl = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_GEO, "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
    public static final String[] zzm = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    public static final int[] zzn = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    public static final int[] zzo = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, HSTypingIndicatorView.ALPHA_DARK, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, ConversationalFragmentRenderer.OPTIONS_PICKER_PEEK_HEIGHT, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, DrawerLayout.PEEK_DELAY, TextInputLayout.LABEL_SCALE_ANIMATION_DURATION, 178, 181, 188, 187, SwipeRefreshLayout.SCALE_DOWN_DURATION, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};

    static {
        int i;
        if ("S".equals(Build.VERSION.CODENAME)) {
            i = 31;
        } else {
            i = "R".equals(Build.VERSION.CODENAME) ? 30 : Build.VERSION.SDK_INT;
        }
        zza = i;
        String str = Build.MODEL;
        zzd = str;
        String str2 = zzb;
        String str3 = zzc;
        int i2 = zza;
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(str2).length(), 17, String.valueOf(str).length(), String.valueOf(str3).length()));
        GeneratedOutlineSupport.outline34(sb, str2, RESTClient.COMMA_SEPARATOR, str, RESTClient.COMMA_SEPARATOR);
        sb.append(str3);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(i2);
        zze = sb.toString();
    }

    public static long zzA(long j, long j2, long j3) {
        long j4 = j + j2;
        return ((j ^ j4) & (j2 ^ j4)) < 0 ? RecyclerView.FOREVER_NS : j4;
    }

    public static long zzB(long j, long j2, long j3) {
        long j4 = j - j2;
        if (((j ^ j4) & (j2 ^ j)) < 0) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    public static int zzC(int[] iArr, int i, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(iArr, i);
        if (binarySearch < 0) {
            return -(binarySearch + 2);
        }
        do {
            binarySearch--;
            if (binarySearch < 0 || iArr[binarySearch] != i) {
            }
            binarySearch--;
            break;
        } while (iArr[binarySearch] != i);
        return binarySearch;
    }

    public static int zzD(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j) {
                    i = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (jArr[binarySearch] != j);
            i = binarySearch + 1;
        }
        return z2 ? Math.max(0, i) : i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzE(long[] r3, long r4, boolean r6, boolean r7) {
        /*
            int r7 = java.util.Arrays.binarySearch(r3, r4)
            if (r7 >= 0) goto L_0x0009
            r3 = r7 ^ -1
            goto L_0x0017
        L_0x0009:
            int r7 = r7 + 1
            int r0 = r3.length
            if (r7 >= r0) goto L_0x0014
            r0 = r3[r7]
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0009
        L_0x0014:
            if (r6 != 0) goto L_0x0018
            r3 = r7
        L_0x0017:
            return r3
        L_0x0018:
            int r7 = r7 + -1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalh.zzE(long[], long, boolean, boolean):int");
    }

    public static long zzF(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return (j2 / j3) * j;
        }
        double d = (double) j;
        double d2 = (double) j2;
        double d3 = (double) j3;
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d);
        return (long) ((d2 / d3) * d);
    }

    public static void zzG(long[] jArr, long j, long j2) {
        int i = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
        } else if (j2 >= 1000000 || 1000000 % j2 != 0) {
            double d = (double) j2;
            Double.isNaN(d);
            double d2 = 1000000.0d / d;
            while (i < jArr.length) {
                double d3 = (double) jArr[i];
                Double.isNaN(d3);
                jArr[i] = (long) (d3 * d2);
                i++;
            }
        } else {
            long j4 = 1000000 / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j4;
                i++;
            }
        }
    }

    public static long zzH(long j, float f) {
        if (f == 1.0f) {
            return j;
        }
        double d = (double) j;
        double d2 = (double) f;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.round(d * d2);
    }

    public static long zzI(long j, float f) {
        if (f == 1.0f) {
            return j;
        }
        double d = (double) j;
        double d2 = (double) f;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.round(d / d2);
    }

    public static long zzJ(int i, int i2) {
        return (((long) i2) & 4294967295L) | ((((long) i) & 4294967295L) << 32);
    }

    public static String zzK(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int length = objArr.length;
            if (i >= length) {
                return sb.toString();
            }
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < length - 1) {
                sb.append(RESTClient.COMMA_SEPARATOR);
            }
            i++;
        }
    }

    public static zzkc zzL(int i, int i2, int i3) {
        zzkb zzkb = new zzkb();
        zzkb.zzj("audio/raw");
        zzkb.zzw(i2);
        zzkb.zzx(i3);
        zzkb.zzy(i);
        return zzkb.zzD();
    }

    public static int zzM(int i) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 2;
        }
        if (i == 24) {
            return DriveFile.MODE_WRITE_ONLY;
        }
        if (i != 32) {
            return 0;
        }
        return DriveFile.MODE_READ_WRITE;
    }

    public static boolean zzN(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4;
    }

    public static boolean zzO(int i) {
        return i == 536870912 || i == 805306368 || i == 4;
    }

    public static int zzP(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i2 = zza;
                return (i2 < 23 && i2 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int zzQ(int i, int i2) {
        if (i != 2) {
            if (i == 3) {
                return i2;
            }
            if (i != 4) {
                if (i != 268435456) {
                    if (i == 536870912) {
                        return i2 * 3;
                    }
                    if (i != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i2 * 4;
        }
        return i2 + i2;
    }

    public static int zzR(byte[] bArr, int i, int i2, int i3) {
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = zzn[(i4 >>> 24) ^ (bArr[i5] & Base64.EQUALS_SIGN_ENC)] ^ (i4 << 8);
        }
        return i4;
    }

    public static int zzS(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i < i2) {
            i4 = zzo[i4 ^ (bArr[i] & Base64.EQUALS_SIGN_ENC)];
            i++;
        }
        return i4;
    }

    public static String zzT(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null)) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return zzfjm.zzb(networkCountryIso);
            }
        }
        return zzfjm.zzb(Locale.getDefault().getCountry());
    }

    public static String[] zzU() {
        String[] strArr;
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (zza >= 24) {
            strArr = configuration.getLocales().toLanguageTags().split(",", -1);
        } else {
            strArr = new String[]{zzp(configuration.locale)};
        }
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = zzq(strArr[i]);
        }
        return strArr;
    }

    public static boolean zzV(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Point zzW(Context context) {
        String str;
        String str2;
        WindowManager windowManager = (WindowManager) context.getSystemService(VisionController.WINDOW);
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (zza <= 29 && defaultDisplay.getDisplayId() == 0 && zzV(context)) {
                if ("Sony".equals(zzc) && zzd.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                    return new Point(DisplayCompat.DISPLAY_SIZE_4K_WIDTH, DisplayCompat.DISPLAY_SIZE_4K_HEIGHT);
                }
                if (zza < 28) {
                    str = zzY("sys.display-size");
                } else {
                    str = zzY("vendor.display-size");
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        String[] split = str.trim().split("x", -1);
                        if (split.length == 2) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            if (parseInt > 0 && parseInt2 > 0) {
                                return new Point(parseInt, parseInt2);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                    String valueOf = String.valueOf(str);
                    if (valueOf.length() != 0) {
                        str2 = "Invalid display size: ".concat(valueOf);
                    } else {
                        str2 = new String("Invalid display size: ");
                    }
                    Log.e("Util", str2);
                }
            }
            Point point = new Point();
            int i = zza;
            if (i >= 23) {
                Display.Mode mode = defaultDisplay.getMode();
                point.x = mode.getPhysicalWidth();
                point.y = mode.getPhysicalHeight();
                return point;
            } else if (i >= 17) {
                defaultDisplay.getRealSize(point);
                return point;
            } else {
                defaultDisplay.getSize(point);
                return point;
            }
        } else {
            throw null;
        }
    }

    public static long zzX(long j) {
        if (j == -9223372036854775807L) {
            return System.currentTimeMillis();
        }
        return j + SystemClock.elapsedRealtime();
    }

    @Nullable
    public static String zzY(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e) {
            zzaka.zzb("Util", str.length() != 0 ? "Failed to read system property ".concat(str) : new String("Failed to read system property "), e);
            return null;
        }
    }

    public static HashMap<String, String> zzZ() {
        int length = zzl.length;
        HashMap<String, String> hashMap = new HashMap<>(r2 + 86);
        int i = 0;
        for (String str : Locale.getISOLanguages()) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = zzl;
            int length2 = strArr.length;
            if (i >= 86) {
                return hashMap;
            }
            hashMap.put(strArr[i], strArr[i + 1]);
            i += 2;
        }
    }

    public static byte[] zza(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean zzb(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean zzc(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @EnsuresNonNull({"#1"})
    public static <T> T zzd(@Nullable T t) {
        return t;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] zze(T[] tArr) {
        return tArr;
    }

    public static <T> T[] zzf(T[] tArr, int i) {
        zzajg.zza(i <= tArr.length);
        return Arrays.copyOf(tArr, i);
    }

    public static <T> T[] zzg(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] copyOf = Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static Handler zzh(@Nullable Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        zzajg.zze(myLooper);
        return new Handler(myLooper, callback);
    }

    public static Handler zzi(Looper looper, @Nullable Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static boolean zzj(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static Looper zzk() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return myLooper;
        }
        return Looper.getMainLooper();
    }

    public static ExecutorService zzl(String str) {
        return Executors.newSingleThreadExecutor(new zzalg("ExoPlayer:Loader:ProgressiveMediaPeriod"));
    }

    public static void zzm(@Nullable zzaht zzaht) {
        try {
            zzaht.zzf();
        } catch (IOException unused) {
        }
    }

    public static boolean zzn(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void zzo(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static String zzp(Locale locale) {
        if (zza >= 21) {
            return locale.toLanguageTag();
        }
        return locale.toString();
    }

    public static String zzq(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String zza2 = zzfjm.zza(str);
        int i = 0;
        String str2 = zza2.split("-", 2)[0];
        if (zzk == null) {
            zzk = zzZ();
        }
        String str3 = zzk.get(str2);
        if (str3 != null) {
            String valueOf = String.valueOf(zza2.substring(str2.length()));
            if (valueOf.length() != 0) {
                zza2 = str3.concat(valueOf);
            } else {
                zza2 = new String(str3);
            }
            str2 = str3;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return zza2;
        }
        while (true) {
            String[] strArr = zzm;
            int length = strArr.length;
            if (i >= 18) {
                return zza2;
            }
            if (zza2.startsWith(strArr[i])) {
                String valueOf2 = String.valueOf(zzm[i + 1]);
                String valueOf3 = String.valueOf(zza2.substring(zzm[i].length()));
                return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
            }
            i += 2;
        }
    }

    public static String zzr(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, zzfjs.zzc);
    }

    public static byte[] zzs(String str) {
        return str.getBytes(zzfjs.zzc);
    }

    public static String[] zzt(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] zzu(String str, String str2) {
        return str.split(str2, 2);
    }

    public static String zzv(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int zzw(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int zzx(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static long zzy(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    public static float zzz(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }
}
