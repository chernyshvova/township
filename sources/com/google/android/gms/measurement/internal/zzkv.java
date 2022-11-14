package com.google.android.gms.measurement.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzlz;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzw;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.util.ErrorReportProvider;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzkv extends zzgq {
    public static final String[] zza = {"firebase_", "google_", "ga_"};
    public static final String[] zzb = {"_err"};
    public SecureRandom zzc;
    public final AtomicLong zzd = new AtomicLong(0);
    public int zze;
    public Integer zzf = null;

    public zzkv(zzfu zzfu) {
        super(zzfu);
    }

    public static boolean zza(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    public static boolean zzd(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    private final int zzh(String str) {
        if (!zzb("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        if (!zza("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    @VisibleForTesting
    public static boolean zzi(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int zzj(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (!zzs().zza(zzas.zzbg) || !"_lgclid".equals(str)) ? 36 : 100;
    }

    @WorkerThread
    /* renamed from: g_ */
    public final void mo31500g_() {
        zzc();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzq().zzh().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(nextLong);
    }

    public final boolean zzb(String str, String str2) {
        if (str2 == null) {
            zzq().zzg().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzq().zzg().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzq().zzg().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzq().zzg().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public final Object zzc(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzj(str), obj, true, false);
        }
        return zza(zzj(str), obj, false, false);
    }

    public final boolean zzd() {
        return true;
    }

    public final boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zzs().zzw().equals(str);
    }

    public final long zzf() {
        long andIncrement;
        long j;
        if (this.zzd.get() == 0) {
            synchronized (this.zzd) {
                long nextLong = new Random(System.nanoTime() ^ zzl().currentTimeMillis()).nextLong();
                int i = this.zze + 1;
                this.zze = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzd) {
            this.zzd.compareAndSet(-1, 1);
            andIncrement = this.zzd.getAndIncrement();
        }
        return andIncrement;
    }

    @WorkerThread
    public final SecureRandom zzg() {
        zzc();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    public final Bundle zza(@NonNull Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("campaign", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("source", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzq().zzh().zza("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final int zzi() {
        if (this.zzf == null) {
            this.zzf = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zzm()) / 1000);
        }
        return this.zzf.intValue();
    }

    public static MessageDigest zzh() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    @WorkerThread
    public final boolean zzc(String str) {
        zzc();
        if (Wrappers.packageManager(zzm()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzq().zzv().zza("Permission not granted", str);
        return false;
    }

    private final int zzg(String str) {
        if (!zza("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        if (!zza("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final boolean zzj() {
        try {
            zzm().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean zzc(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    @VisibleForTesting
    private final boolean zzc(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            zzq().zze().zza("Error obtaining certificate", e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            zzq().zze().zza("Package name not found", e2);
            return true;
        }
    }

    public static boolean zzf(String str) {
        for (String equals : zzb) {
            if (equals.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public final int zzb(String str) {
        if (!zzb("user property", str)) {
            return 6;
        }
        if (!zza("user property", zzgx.zza, str)) {
            return 15;
        }
        if (!zza("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public static Bundle[] zzb(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public static boolean zzb(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    public final int zzb(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = zza("user property referrer", str, zzj(str), obj);
        } else {
            z = zza("user property", str, zzj(str), obj);
        }
        return z ? 0 : 7;
    }

    public static boolean zzb(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean zza(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static Bundle zzb(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    public final boolean zza(String str, String str2) {
        if (str2 == null) {
            zzq().zzg().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzq().zzg().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzq().zzg().zza("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzq().zzg().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public static ArrayList<Bundle> zzb(List<zzz> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzz next : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", next.zza);
            bundle.putString("origin", next.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, next.zzd);
            bundle.putString("name", next.zzc.zza);
            zzgs.zza(bundle, next.zzc.zza());
            bundle.putBoolean("active", next.zze);
            String str = next.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzaq zzaq = next.zzg;
            if (zzaq != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzaq.zza);
                zzap zzap = next.zzg.zzb;
                if (zzap != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzap.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, next.zzh);
            zzaq zzaq2 = next.zzi;
            if (zzaq2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzaq2.zza);
                zzap zzap2 = next.zzi.zzb;
                if (zzap2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzap2.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, next.zzc.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, next.zzj);
            zzaq zzaq3 = next.zzk;
            if (zzaq3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzaq3.zza);
                zzap zzap3 = next.zzk.zzb;
                if (zzap3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzap3.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final boolean zza(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z;
        if (str2 == null) {
            zzq().zzg().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zza;
        int length = strArr3.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr3[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzq().zzg().zza("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (strArr == null || !zza(str2, strArr) || (strArr2 != null && zza(str2, strArr2))) {
            return true;
        } else {
            zzq().zzg().zza("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public final boolean zza(String str, String[] strArr, String str2) {
        return zza(str, strArr, (String[]) null, str2);
    }

    public final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzq().zzg().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzq().zzg().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public final int zza(String str, boolean z) {
        if (!zzb("event", str)) {
            return 2;
        }
        if (z) {
            if (!zza("event", zzgv.zza, zzgv.zzb, str)) {
                return 13;
            }
        } else if (!zza("event", zzgv.zza, str)) {
            return 13;
        }
        if (!zza("event", 40, str)) {
            return 2;
        }
        return 0;
    }

    public static boolean zza(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public final boolean zza(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                zzq().zzj().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    public static boolean zza(Bundle bundle, int i) {
        int i2 = 0;
        if (bundle.size() <= i) {
            return false;
        }
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            i2++;
            if (i2 > i) {
                bundle.remove(str);
            }
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    private final void zza(String str, String str2, String str3, Bundle bundle, @Nullable List<String> list, boolean z) {
        int i;
        String str4;
        int i2;
        String str5 = str2;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        if (bundle2 != null) {
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i3 = 0;
            while (it.hasNext()) {
                String str6 = (String) it.next();
                if (list2 == null || !list2.contains(str6)) {
                    i = z ? zzg(str6) : 0;
                    if (i == 0) {
                        i = zzh(str6);
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    zza(bundle2, i, str6, str6, (Object) i == 3 ? str6 : null);
                    bundle2.remove(str6);
                } else {
                    if (zza(bundle2.get(str6))) {
                        zzq().zzj().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str5, str3, str6);
                        i2 = 22;
                        str4 = str6;
                    } else {
                        String str7 = str3;
                        str4 = str6;
                        i2 = zza(str, str2, str6, bundle2.get(str6), bundle, list, z, false);
                    }
                    if (i2 != 0 && !"_ev".equals(str4)) {
                        zza(bundle2, i2, str4, str4, bundle2.get(str4));
                        bundle2.remove(str4);
                    } else if (zza(str4) && !zza(str4, zzgu.zzd) && (i3 = i3 + 1) > 0) {
                        zzq().zzg().zza("Item cannot contain custom parameters", zzn().zza(str5), zzn().zza(bundle2));
                        zzb(bundle2, 23);
                        bundle2.remove(str4);
                    }
                }
            }
        }
    }

    public final boolean zza(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (zzi(str)) {
                return true;
            }
            if (this.zzy.zzk()) {
                zzq().zzg().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzeq.zza(str));
            }
            return false;
        } else if (zznv.zzb() && zzs().zza(zzas.zzbi) && !TextUtils.isEmpty(str3)) {
            return true;
        } else {
            if (TextUtils.isEmpty(str2)) {
                if (this.zzy.zzk()) {
                    zzq().zzg().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                }
                return false;
            } else if (zzi(str2)) {
                return true;
            } else {
                zzq().zzg().zza("Invalid admob_app_id. Analytics disabled.", zzeq.zza(str2));
                return false;
            }
        }
    }

    public static boolean zza(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    private final Object zza(int i, Object obj, boolean z, boolean z2) {
        Bundle zza2;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if ((parcelable instanceof Bundle) && (zza2 = zza((Bundle) parcelable)) != null && !zza2.isEmpty()) {
                    arrayList.add(zza2);
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.Object r20, android.os.Bundle r21, @androidx.annotation.Nullable java.util.List<java.lang.String> r22, boolean r23, boolean r24) {
        /*
            r16 = this;
            r7 = r16
            r8 = r19
            r0 = r20
            r1 = r21
            r16.zzc()
            boolean r2 = zza((java.lang.Object) r20)
            java.lang.String r3 = "param"
            r9 = 0
            r10 = 1
            if (r2 == 0) goto L_0x0092
            if (r24 == 0) goto L_0x008f
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzgu.zzc
            boolean r2 = zza((java.lang.String) r8, (java.lang.String[]) r2)
            if (r2 != 0) goto L_0x0022
            r0 = 20
            return r0
        L_0x0022:
            com.google.android.gms.measurement.internal.zzfu r2 = r7.zzy
            com.google.android.gms.measurement.internal.zzir r2 = r2.zzv()
            boolean r2 = r2.zzah()
            if (r2 != 0) goto L_0x0031
            r0 = 25
            return r0
        L_0x0031:
            boolean r2 = r0 instanceof android.os.Parcelable[]
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 == 0) goto L_0x003c
            r5 = r0
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r5 = r5.length
            goto L_0x0047
        L_0x003c:
            boolean r5 = r0 instanceof java.util.ArrayList
            if (r5 == 0) goto L_0x005c
            r5 = r0
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r5 = r5.size()
        L_0x0047:
            if (r5 <= r4) goto L_0x005c
            com.google.android.gms.measurement.internal.zzeq r6 = r16.zzq()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzj()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r11 = "Parameter array is too long; discarded. Value kind, name, array length"
            r6.zza(r11, r3, r8, r5)
            r5 = 0
            goto L_0x005d
        L_0x005c:
            r5 = 1
        L_0x005d:
            if (r5 != 0) goto L_0x0092
            r5 = 17
            if (r2 == 0) goto L_0x0073
            r2 = r0
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            int r6 = r2.length
            if (r6 <= r4) goto L_0x008c
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
            goto L_0x008c
        L_0x0073:
            boolean r2 = r0 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x008c
            r2 = r0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r6 = r2.size()
            if (r6 <= r4) goto L_0x008c
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r2 = r2.subList(r9, r4)
            r6.<init>(r2)
            r1.putParcelableArrayList(r8, r6)
        L_0x008c:
            r11 = 17
            goto L_0x0093
        L_0x008f:
            r0 = 21
            return r0
        L_0x0092:
            r11 = 0
        L_0x0093:
            com.google.android.gms.measurement.internal.zzab r1 = r16.zzs()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzaq
            r12 = r17
            boolean r1 = r1.zze(r12, r2)
            if (r1 == 0) goto L_0x00a7
            boolean r1 = zzd(r18)
            if (r1 != 0) goto L_0x00ad
        L_0x00a7:
            boolean r1 = zzd(r19)
            if (r1 == 0) goto L_0x00b0
        L_0x00ad:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x00b2
        L_0x00b0:
            r1 = 100
        L_0x00b2:
            boolean r1 = r7.zza((java.lang.String) r3, (java.lang.String) r8, (int) r1, (java.lang.Object) r0)
            if (r1 == 0) goto L_0x00b9
            return r11
        L_0x00b9:
            if (r24 == 0) goto L_0x014d
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00d4
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r22
            r6 = r23
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6)
        L_0x00d1:
            r9 = 1
            goto L_0x014a
        L_0x00d4:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x010c
            r13 = r0
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13
            int r14 = r13.length
            r15 = 0
        L_0x00dd:
            if (r15 >= r14) goto L_0x00d1
            r0 = r13[r15]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzeq r1 = r16.zzq()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzj()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.zza(r2, r0, r8)
            goto L_0x014a
        L_0x00f7:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r22
            r6 = r23
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6)
            int r15 = r15 + 1
            goto L_0x00dd
        L_0x010c:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x014a
            r13 = r0
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            int r14 = r13.size()
            r0 = 0
        L_0x0118:
            if (r0 >= r14) goto L_0x00d1
            java.lang.Object r1 = r13.get(r0)
            int r15 = r0 + 1
            boolean r0 = r1 instanceof android.os.Bundle
            if (r0 != 0) goto L_0x0136
            com.google.android.gms.measurement.internal.zzeq r0 = r16.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()
            java.lang.Class r1 = r1.getClass()
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r0.zza(r2, r1, r8)
            goto L_0x014a
        L_0x0136:
            r4 = r1
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r22
            r6 = r23
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6)
            r0 = r15
            goto L_0x0118
        L_0x014a:
            if (r9 == 0) goto L_0x014d
            return r11
        L_0x014d:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkv.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final Object zza(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return zza(256, obj, true, true);
        }
        if (!zzd(str)) {
            i = 100;
        }
        return zza(i, obj, false, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza(java.lang.String r19, java.lang.String r20, android.os.Bundle r21, @androidx.annotation.Nullable java.util.List<java.lang.String> r22, boolean r23, boolean r24) {
        /*
            r18 = this;
            r9 = r18
            r10 = r20
            r11 = r21
            r12 = r22
            java.lang.String[] r0 = com.google.android.gms.measurement.internal.zzgv.zzd
            boolean r13 = zza((java.lang.String) r10, (java.lang.String[]) r0)
            if (r11 == 0) goto L_0x00f0
            android.os.Bundle r14 = new android.os.Bundle
            r14.<init>(r11)
            com.google.android.gms.measurement.internal.zzab r0 = r18.zzs()
            int r15 = r0.zzd()
            com.google.android.gms.measurement.internal.zzab r0 = r18.zzs()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzay
            r8 = r19
            boolean r0 = r0.zze(r8, r1)
            if (r0 == 0) goto L_0x0035
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r21.keySet()
            r0.<init>(r1)
            goto L_0x0039
        L_0x0035:
            java.util.Set r0 = r21.keySet()
        L_0x0039:
            java.util.Iterator r16 = r0.iterator()
            r0 = 0
            r17 = 0
        L_0x0040:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x00f1
            java.lang.Object r0 = r16.next()
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            if (r12 == 0) goto L_0x0058
            boolean r0 = r12.contains(r7)
            if (r0 != 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r0 = 0
            goto L_0x0066
        L_0x0058:
            if (r23 == 0) goto L_0x005f
            int r0 = r9.zzg(r7)
            goto L_0x0060
        L_0x005f:
            r0 = 0
        L_0x0060:
            if (r0 != 0) goto L_0x0066
            int r0 = r9.zzh(r7)
        L_0x0066:
            if (r0 == 0) goto L_0x0076
            r1 = 3
            if (r0 != r1) goto L_0x006d
            r1 = r7
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            zza((android.os.Bundle) r14, (int) r0, (java.lang.String) r7, (java.lang.String) r7, (java.lang.Object) r1)
            r14.remove(r7)
            goto L_0x00ea
        L_0x0076:
            java.lang.Object r4 = r11.get(r7)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r7
            r5 = r14
            r6 = r22
            r9 = r7
            r7 = r23
            r8 = r13
            int r0 = r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (android.os.Bundle) r5, (java.util.List<java.lang.String>) r6, (boolean) r7, (boolean) r8)
            r1 = 17
            if (r0 != r1) goto L_0x0096
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            zza((android.os.Bundle) r14, (int) r0, (java.lang.String) r9, (java.lang.String) r9, (java.lang.Object) r1)
            goto L_0x00b2
        L_0x0096:
            if (r0 == 0) goto L_0x00b2
            java.lang.String r1 = "_ev"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x00b2
            r1 = 21
            if (r0 != r1) goto L_0x00a6
            r7 = r10
            goto L_0x00a7
        L_0x00a6:
            r7 = r9
        L_0x00a7:
            java.lang.Object r1 = r11.get(r9)
            zza((android.os.Bundle) r14, (int) r0, (java.lang.String) r7, (java.lang.String) r9, (java.lang.Object) r1)
            r14.remove(r9)
            goto L_0x00ea
        L_0x00b2:
            boolean r0 = zza((java.lang.String) r9)
            if (r0 == 0) goto L_0x00ea
            int r0 = r17 + 1
            if (r0 <= r15) goto L_0x00e8
            r1 = 48
            java.lang.String r2 = "Event can't contain more than "
            java.lang.String r3 = " params"
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline10(r1, r2, r15, r3)
            com.google.android.gms.measurement.internal.zzeq r2 = r18.zzq()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzg()
            com.google.android.gms.measurement.internal.zzeo r3 = r18.zzn()
            java.lang.String r3 = r3.zza((java.lang.String) r10)
            com.google.android.gms.measurement.internal.zzeo r4 = r18.zzn()
            java.lang.String r4 = r4.zza((android.os.Bundle) r11)
            r2.zza(r1, r3, r4)
            r1 = 5
            zzb((android.os.Bundle) r14, (int) r1)
            r14.remove(r9)
        L_0x00e8:
            r17 = r0
        L_0x00ea:
            r9 = r18
            r8 = r19
            goto L_0x0040
        L_0x00f0:
            r14 = 0
        L_0x00f1:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkv.zza(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    public final void zza(zzeu zzeu, int i) {
        Iterator it = new TreeSet(zzeu.zzb.keySet()).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (zza(str) && (i2 = i2 + 1) > i) {
                zzq().zzg().zza(GeneratedOutlineSupport.outline10(48, "Event can't contain more than ", i, " params"), zzn().zza(zzeu.zza), zzn().zza(zzeu.zzb));
                zzb(zzeu.zzb, 5);
                zzeu.zzb.remove(str);
            }
        }
    }

    public final void zza(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    zzo().zza(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    public static void zza(Bundle bundle, int i, String str, String str2, Object obj) {
        if (zzb(bundle, i)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) String.valueOf(obj).length());
                }
            }
        }
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                zzq().zzj().zza("Not putting event parameter. Invalid value type. name, type", zzn().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(zzky zzky, int i, String str, String str2, int i2) {
        zza(zzky, (String) null, i, str, str2, i2);
    }

    public final void zza(zzky zzky, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzb(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        if (!zzlz.zzb() || !zzs().zza(zzas.zzcn)) {
            this.zzy.zzg().zza("auto", "_err", bundle);
        } else {
            zzky.zza(str, bundle);
        }
    }

    @VisibleForTesting
    public static long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return zzb(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzb(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean zza(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    public static boolean zza(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    public final Bundle zza(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zza2 = zza(str, bundle.get(str));
                if (zza2 == null) {
                    zzq().zzj().zza("Param value can't be null", zzn().zzb(str));
                } else {
                    zza(bundle2, str, zza2);
                }
            }
        }
        return bundle2;
    }

    public final zzaq zza(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2, boolean z3) {
        String str4 = str2;
        Bundle bundle2 = bundle;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zza(str2, z3) == 0) {
            Bundle bundle3 = bundle2 != null ? new Bundle(bundle) : new Bundle();
            String str5 = str3;
            bundle3.putString("_o", str3);
            Bundle zza2 = zza(str, str2, bundle3, (List<String>) CollectionUtils.listOf("_o"), false, false);
            if (z) {
                zza2 = zza(zza2);
            }
            return new zzaq(str2, new zzap(zza2), str3, j);
        }
        zzq().zze().zza("Invalid conditional property event name", zzn().zzc(str2));
        throw new IllegalArgumentException();
    }

    @WorkerThread
    public final long zza(Context context, String str) {
        zzc();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzh = zzh();
        if (zzh == null) {
            zzq().zze().zza("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zzc(context, str)) {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(zzm().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zza(zzh.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzq().zzh().zza("Could not get signatures");
                    return -1;
                }
            } catch (PackageManager.NameNotFoundException e) {
                zzq().zze().zza("Package name not found", e);
            }
        }
        return 0;
    }

    public static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static boolean zza(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String zzc2 : strArr) {
            if (zzc(str, zzc2)) {
                return true;
            }
        }
        return false;
    }

    public final int zza(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzm(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public static long zza(long j, long j2) {
        return ((j2 * ConversationController.ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT) + j) / ErrorReportProvider.BATCH_TIME;
    }

    @WorkerThread
    public final void zza(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzq().zzh().zza("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zza(zzw zzw, String str) {
        try {
            zzw.zza(GeneratedOutlineSupport.outline5(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, str));
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning string value to wrapper", e);
        }
    }

    public final void zza(zzw zzw, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, j);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning long value to wrapper", e);
        }
    }

    public final void zza(zzw zzw, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, i);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning int value to wrapper", e);
        }
    }

    public final void zza(zzw zzw, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, bArr);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning byte array to wrapper", e);
        }
    }

    public final void zza(zzw zzw, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, z);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning boolean value to wrapper", e);
        }
    }

    public final void zza(zzw zzw, Bundle bundle) {
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning bundle value to wrapper", e);
        }
    }

    public static Bundle zza(List<zzku> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzku next : list) {
            String str = next.zzd;
            if (str != null) {
                bundle.putString(next.zza, str);
            } else {
                Long l = next.zzc;
                if (l != null) {
                    bundle.putLong(next.zza, l.longValue());
                } else {
                    Double d = next.zzf;
                    if (d != null) {
                        bundle.putDouble(next.zza, d.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public final void zza(zzw zzw, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, arrayList);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning bundle list to wrapper", e);
        }
    }

    public final URL zza(long j, @NonNull String str, @NonNull String str2, long j2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{Long.valueOf(j), Integer.valueOf(zzi())}), str2, str, Long.valueOf(j2)});
            if (str.equals(zzs().zzx())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e) {
            zzq().zze().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public final boolean zza(String str, double d) {
        try {
            SharedPreferences.Editor edit = zzm().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return edit.commit();
        } catch (Exception e) {
            zzq().zze().zza("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    public static long zza(zzap zzap) {
        long j = 0;
        if (zzap == null) {
            return 0;
        }
        Iterator<String> it = zzap.iterator();
        while (it.hasNext()) {
            Object zza2 = zzap.zza(it.next());
            if (zza2 instanceof Parcelable[]) {
                j += (long) ((Parcelable[]) zza2).length;
            }
        }
        return j;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
