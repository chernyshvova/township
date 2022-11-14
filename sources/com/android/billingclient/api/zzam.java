package com.android.billingclient.api;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.LegacyTokenHelper;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.play.core.assetpacks.C2210br;
import com.google.android.play.core.internal.C2305ca;
import com.google.android.play.core.internal.C2306cb;
import com.google.android.play.core.internal.C2314cj;
import com.google.android.play.core.tasks.C2344d;
import com.google.android.play.core.tasks.C2346f;
import com.google.android.play.core.tasks.C2353m;
import com.google.android.play.core.tasks.C2354n;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.TaskExecutors;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$$Lambda$3;
import com.google.firebase.platforminfo.AutoValue_LibraryVersion;
import com.google.firebase.platforminfo.LibraryVersion;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.helpshift.common.util.HSDateFormatSpec;
import com.iab.omid.library.vungle.C2883a;
import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.ModelFactory;
import com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import com.playrix.gplay.billing.Base64;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import kotlin.Pair;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.EmptySet;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p038io.FileTreeWalk;
import kotlin.p038io.FileWalkDirection;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzam {

    /* renamed from: a */
    public static C2210br f38a;
    public static Method setConstantStateMethod;
    public static boolean setConstantStateMethodFetched;

    /* renamed from: a */
    public static <ResultT> Task<ResultT> m17a(ResultT resultt) {
        C2353m mVar = new C2353m();
        mVar.mo33335a(resultt);
        return mVar;
    }

    /* renamed from: a */
    public static <ResultT> ResultT m18a(Task<ResultT> task) throws ExecutionException {
        Exception exc;
        if (task.isSuccessful()) {
            return task.getResult();
        }
        C2353m mVar = (C2353m) task;
        synchronized (mVar.f3304a) {
            exc = mVar.f3308e;
        }
        throw new ExecutionException(exc);
    }

    /* renamed from: a */
    public static String m19a(File file) {
        if (file.getName().endsWith(".apk")) {
            String str = "";
            String replaceFirst = file.getName().replaceFirst("(_\\d+)?\\.apk", str);
            if (replaceFirst.equals("base-master")) {
                return str;
            }
            String str2 = "base-";
            if (replaceFirst.startsWith(str2)) {
                str = "config.";
            } else {
                replaceFirst = replaceFirst.replace("-", ".config.");
                str2 = ".config.master";
            }
            return replaceFirst.replace(str2, str);
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    /* renamed from: a */
    public static String m20a(String str, String str2) {
        return GeneratedOutlineSupport.outline19(new StringBuilder(str.length() + 1 + String.valueOf(str2).length()), str, CertificateUtil.DELIMITER, str2);
    }

    /* renamed from: a */
    public static String m21a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(str.length(), 2, String.valueOf(str2).length(), String.valueOf(str3).length()));
        GeneratedOutlineSupport.outline34(sb, str, CertificateUtil.DELIMITER, str2, CertificateUtil.DELIMITER);
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: a */
    public static void m23a(PackageManager packageManager, ComponentName componentName, int i) {
        ComponentInfo componentInfo;
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
        if (componentEnabledSetting != 1) {
            if (componentEnabledSetting != 2) {
                String packageName = componentName.getPackageName();
                String className = componentName.getClassName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, i | 512);
                    ComponentInfo[][] componentInfoArr = {packageInfo.activities, packageInfo.services, packageInfo.providers};
                    int i2 = 0;
                    loop0:
                    while (true) {
                        if (i2 >= 3) {
                            componentInfo = null;
                            break;
                        }
                        ComponentInfo[] componentInfoArr2 = componentInfoArr[i2];
                        if (componentInfoArr2 != null) {
                            int length = componentInfoArr2.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                componentInfo = componentInfoArr2[i3];
                                if (componentInfo.name.equals(className)) {
                                    break loop0;
                                }
                            }
                            continue;
                        }
                        i2++;
                    }
                    if (componentInfo != null) {
                        if (componentInfo.isEnabled()) {
                            return;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    /* renamed from: a */
    public static void m24a(C2306cb cbVar, InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[16384];
        InputStream inputStream2 = inputStream;
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 4096));
        int readInt = dataInputStream.readInt();
        if (readInt != -771763713) {
            String valueOf = String.valueOf(String.format("%x", new Object[]{Integer.valueOf(readInt)}));
            throw new C2305ca(valueOf.length() != 0 ? "Unexpected magic=".concat(valueOf) : new String("Unexpected magic="));
        }
        int read = dataInputStream.read();
        if (read == 4) {
            long j2 = 0;
            while (true) {
                long j3 = j - j2;
                try {
                    int read2 = dataInputStream.read();
                    if (read2 == -1) {
                        throw new IOException("Patch file overrun");
                    } else if (read2 != 0) {
                        switch (read2) {
                            case 247:
                                read2 = dataInputStream.readUnsignedShort();
                                m28a(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                            case 248:
                                read2 = dataInputStream.readInt();
                                m28a(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                            case 249:
                                long readUnsignedShort = (long) dataInputStream.readUnsignedShort();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    m27a(bArr, cbVar, outputStream, readUnsignedShort, read2, j3);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case 250:
                                long readUnsignedShort2 = (long) dataInputStream.readUnsignedShort();
                                read2 = dataInputStream.readUnsignedShort();
                                m27a(bArr, cbVar, outputStream, readUnsignedShort2, read2, j3);
                                break;
                            case 251:
                                long readUnsignedShort3 = (long) dataInputStream.readUnsignedShort();
                                read2 = dataInputStream.readInt();
                                m27a(bArr, cbVar, outputStream, readUnsignedShort3, read2, j3);
                                break;
                            case 252:
                                long readInt2 = (long) dataInputStream.readInt();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    m27a(bArr, cbVar, outputStream, readInt2, read2, j3);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case 253:
                                long readInt3 = (long) dataInputStream.readInt();
                                read2 = dataInputStream.readUnsignedShort();
                                m27a(bArr, cbVar, outputStream, readInt3, read2, j3);
                                break;
                            case 254:
                                long readInt4 = (long) dataInputStream.readInt();
                                read2 = dataInputStream.readInt();
                                m27a(bArr, cbVar, outputStream, readInt4, read2, j3);
                                break;
                            case 255:
                                long readLong = dataInputStream.readLong();
                                read2 = dataInputStream.readInt();
                                m27a(bArr, cbVar, outputStream, readLong, read2, j3);
                                break;
                            default:
                                m28a(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                        }
                        j2 += (long) read2;
                    } else {
                        return;
                    }
                } finally {
                    outputStream.flush();
                }
            }
        } else {
            throw new C2305ca(GeneratedOutlineSupport.outline9(30, "Unexpected version=", read));
        }
    }

    /* renamed from: a */
    public static void m25a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m26a(String str, Exception exc) {
        if (C2883a.f3487a.booleanValue()) {
            boolean isEmpty = TextUtils.isEmpty(str);
        }
        Log.e("OMIDLIB", str, exc);
    }

    /* renamed from: a */
    public static void m28a(byte[] bArr, DataInputStream dataInputStream, OutputStream outputStream, int i, long j) throws IOException {
        if (i < 0) {
            throw new IOException("copyLength negative");
        } else if (((long) i) <= j) {
            while (i > 0) {
                try {
                    int min = Math.min(i, 16384);
                    dataInputStream.readFully(bArr, 0, min);
                    outputStream.write(bArr, 0, min);
                    i -= min;
                } catch (EOFException unused) {
                    throw new IOException("patch underrun");
                }
            }
        } else {
            throw new IOException("Output length overrun");
        }
    }

    /* renamed from: a */
    public static boolean m29a(int i, int i2) {
        if (i == 5) {
            if (i2 != 5) {
                return true;
            }
            i = 5;
        }
        if (i == 6 && i2 != 6 && i2 != 5) {
            return true;
        }
        if (i == 4 && i2 != 4) {
            return true;
        }
        if (i == 3 && (i2 == 2 || i2 == 7 || i2 == 1 || i2 == 8)) {
            return true;
        }
        if (i == 2) {
            return i2 == 1 || i2 == 8;
        }
        return false;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "$this$addAll");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z = true;
            }
        }
        return z;
    }

    public static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int i;
        int i2;
        if (z) {
            i = byteMatrix.height;
        } else {
            i = byteMatrix.width;
        }
        if (z) {
            i2 = byteMatrix.width;
        } else {
            i2 = byteMatrix.height;
        }
        byte[][] bArr = byteMatrix.bytes;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            byte b = -1;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                byte b2 = z ? bArr[i4][i6] : bArr[i6][i4];
                if (b2 == b) {
                    i5++;
                } else {
                    if (i5 >= 5) {
                        i3 += (i5 - 5) + 3;
                    }
                    b = b2;
                    i5 = 1;
                }
            }
            if (i5 >= 5) {
                i3 = (i5 - 5) + 3 + i3;
            }
        }
        return i3;
    }

    public static final <T> List<T> asList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$asList");
        List<T> asList = Arrays.asList(tArr);
        Intrinsics.checkNotNullExpressionValue(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    public static <ResultT> ResultT await(Task<ResultT> task) throws ExecutionException, InterruptedException {
        boolean z;
        if (task != null) {
            C2353m mVar = (C2353m) task;
            synchronized (mVar.f3304a) {
                z = mVar.f3306c;
            }
            if (z) {
                return m18a(task);
            }
            C2354n nVar = new C2354n((byte[]) null);
            mVar.f3305b.mo33329a(new C2346f(TaskExecutors.f3283a, nVar));
            mVar.mo33336c();
            mVar.f3305b.mo33329a(new C2344d(TaskExecutors.f3283a, nVar));
            mVar.mo33336c();
            nVar.f3309a.await();
            return m18a(task);
        }
        throw new NullPointerException("Task must not be null");
    }

    /* renamed from: b */
    public static long m30b(byte[] bArr, int i) {
        return ((long) ((m33c(bArr, i + 2) << 16) | m33c(bArr, i))) & 4294967295L;
    }

    /* renamed from: b */
    public static <T> void m31b(T t) {
        if (t == null) {
            throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }

    /* renamed from: b */
    public static boolean m32b(int i) {
        return i == 5 || i == 6 || i == 4;
    }

    /* renamed from: c */
    public static int m33c(byte[] bArr, int i) {
        return ((bArr[i + 1] & Base64.EQUALS_SIGN_ENC) << 8) | (bArr[i] & Base64.EQUALS_SIGN_ENC);
    }

    /* renamed from: c */
    public static boolean m34c(int i) {
        return i == 2 || i == 7 || i == 3;
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static <T> T checkNotNull1(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static boolean cleanUpEmptyObjectsInMetadata(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            JSONObject optJSONObject = jSONObject.optJSONObject(keys.next());
            if (optJSONObject != null && cleanUpEmptyObjectsInMetadata(optJSONObject)) {
                keys.remove();
            }
        }
        return jSONObject.length() == 0;
    }

    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            Intrinsics.checkNotNullParameter(th, "$this$addSuppressed");
            Intrinsics.checkNotNullParameter(th2, "exception");
            if (th != th2) {
                PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, th2);
            }
        }
    }

    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    public static final <T> boolean contains(T[] tArr, T t) {
        int i;
        Intrinsics.checkNotNullParameter(tArr, "$this$contains");
        Intrinsics.checkNotNullParameter(tArr, "$this$indexOf");
        if (t != null) {
            int length = tArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (Intrinsics.areEqual(t, tArr[i2])) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            int length2 = tArr.length;
            i = 0;
            while (true) {
                if (i >= length2) {
                    break;
                } else if (tArr[i] == null) {
                    break;
                } else {
                    i++;
                }
            }
        }
        i = -1;
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public static Component<?> create(String str, String str2) {
        AutoValue_LibraryVersion autoValue_LibraryVersion = new AutoValue_LibraryVersion(str, str2);
        Component.Builder<LibraryVersion> builder = Component.builder(LibraryVersion.class);
        builder.type = 1;
        builder.factory(new Component$$Lambda$3(autoValue_LibraryVersion));
        return builder.build();
    }

    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f, (int) f2, revealInfo.radius, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    /* renamed from: d */
    public static void m35d(String str, String str2, Object obj) {
        Log.d(getTag(str), String.format(str2, new Object[]{obj}));
    }

    public static final boolean deleteRecursively(File file) {
        Intrinsics.checkNotNullParameter(file, "$this$deleteRecursively");
        Intrinsics.checkNotNullParameter(file, "$this$walkBottomUp");
        FileWalkDirection fileWalkDirection = FileWalkDirection.BOTTOM_UP;
        Intrinsics.checkNotNullParameter(file, "$this$walk");
        Intrinsics.checkNotNullParameter(fileWalkDirection, "direction");
        FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk.FileTreeWalkIterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!fileTreeWalkIterator.hasNext()) {
                    return z;
                }
                File file2 = (File) fileTreeWalkIterator.next();
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                    }
                }
                z = false;
            }
        }
    }

    public static float dist(float f, float f2, float f3, float f4) {
        return (float) Math.hypot((double) (f3 - f), (double) (f4 - f2));
    }

    /* renamed from: e */
    public static String m37e(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        int visibility = view.getVisibility();
        if (visibility != 0) {
            return visibility != 4 ? visibility != 8 ? "viewNotVisible" : "viewGone" : "viewInvisible";
        }
        if (view.getAlpha() == 0.0f) {
            return "viewAlphaZero";
        }
        return null;
    }

    public static int findMinimums(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i2 = 0; i2 < 6; i2++) {
            iArr[i2] = (int) Math.ceil((double) fArr[i2]);
            int i3 = iArr[i2];
            if (i > i3) {
                Arrays.fill(bArr, (byte) 0);
                i = i3;
            }
            if (i == i3) {
                bArr[i2] = (byte) (bArr[i2] + 1);
            }
        }
        return i;
    }

    @Nullable
    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        ColorStateList colorStateList;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) {
            return typedArray.getColorStateList(i);
        }
        return colorStateList;
    }

    @Nullable
    public static Drawable getDrawable(Context context, TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        Drawable drawable;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawable = AppCompatResources.getDrawable(context, resourceId)) == null) {
            return typedArray.getDrawable(i);
        }
        return drawable;
    }

    @NonNull
    public static UUID getInstallId() {
        try {
            return UUID.fromString(SharedPreferencesManager.sSharedPreferences.getString("installId", ""));
        } catch (Exception unused) {
            AppCenterLog.warn("AppCenter", "Unable to get installID from Shared Preferences");
            UUID randomUUID = UUID.randomUUID();
            String uuid = randomUUID.toString();
            SharedPreferences.Editor edit = SharedPreferencesManager.sSharedPreferences.edit();
            edit.putString("installId", uuid);
            edit.apply();
            return randomUUID;
        }
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$javaObjectType");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!jClass.isPrimitive()) {
            return jClass;
        }
        String name = jClass.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return name.equals(LegacyTokenHelper.TYPE_DOUBLE) ? Double.class : jClass;
            case 104431:
                if (name.equals(LegacyTokenHelper.TYPE_INTEGER)) {
                    return Integer.class;
                }
                return jClass;
            case 3039496:
                if (name.equals(LegacyTokenHelper.TYPE_BYTE)) {
                    return Byte.class;
                }
                return jClass;
            case 3052374:
                if (name.equals(LegacyTokenHelper.TYPE_CHAR)) {
                    return Character.class;
                }
                return jClass;
            case 3327612:
                if (name.equals(LegacyTokenHelper.TYPE_LONG)) {
                    return Long.class;
                }
                return jClass;
            case 3625364:
                if (name.equals("void")) {
                    return Void.class;
                }
                return jClass;
            case 64711720:
                if (name.equals("boolean")) {
                    return Boolean.class;
                }
                return jClass;
            case 97526364:
                if (name.equals(LegacyTokenHelper.TYPE_FLOAT)) {
                    return Float.class;
                }
                return jClass;
            case 109413500:
                if (name.equals(LegacyTokenHelper.TYPE_SHORT)) {
                    return Short.class;
                }
                return jClass;
            default:
                return jClass;
        }
    }

    public static int getPersistenceFlag(int i, boolean z) {
        int i2 = i & 255;
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        if (i2 != 0 && z) {
            AppCenterLog.warn("AppCenter", "Invalid value=" + i2 + " for persistence flag, using NORMAL as a default.");
        }
        return 1;
    }

    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i >= i2) {
                return i2;
            }
            return i2 - mod(mod(i2, i3) - mod(i, i3), i3);
        } else if (i3 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (i <= i2) {
            return i2;
        } else {
            int i4 = -i3;
            return i2 + mod(mod(i, i4) - mod(i2, i4), i4);
        }
    }

    public static String getTag(String str) {
        return GeneratedOutlineSupport.outline16("TransportRuntime.", str);
    }

    public static DateFormat getUSDateTimeFormat(int i, int i2) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            str = "EEEE, MMMM d, yyyy";
        } else if (i == 1) {
            str = "MMMM d, yyyy";
        } else if (i == 2) {
            str = "MMM d, yyyy";
        } else if (i == 3) {
            str = "M/d/yy";
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline14("Unknown DateFormat style: ", i));
        }
        sb.append(str);
        sb.append(" ");
        if (i2 == 0 || i2 == 1) {
            str2 = "h:mm:ss a z";
        } else if (i2 == 2) {
            str2 = "h:mm:ss a";
        } else if (i2 == 3) {
            str2 = HSDateFormatSpec.DISPLAY_TIME_PATTERN_12HR;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline14("Unknown DateFormat style: ", i2));
        }
        sb.append(str2);
        return new SimpleDateFormat(sb.toString(), Locale.US);
    }

    public static final <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(mapCapacity(pairArr.length));
        putAll(hashMap, pairArr);
        return hashMap;
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        HashSet<T> hashSet = new HashSet<>(mapCapacity(tArr.length));
        toCollection(tArr, hashSet);
        return hashSet;
    }

    /* renamed from: i */
    public static void m38i(String str, String str2) {
        Log.i(getTag(str), str2);
    }

    public static void illegalCharacter(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isExtendedASCII(char c) {
        return c >= 128 && c <= 255;
    }

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static boolean isNativeX12(char c) {
        if (isX12TermSep(c) || c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static boolean isWhiteHorizontal(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhiteVertical(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == 1) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static boolean isX12TermSep(char c) {
        return c == 13 || c == '*' || c == '>';
    }

    public static float lerp(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }

    public static final <T> List<T> listOf(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static int lookAheadTest(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        CharSequence charSequence2 = charSequence;
        int i3 = i;
        if (i3 >= charSequence.length()) {
            return i2;
        }
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int findMinimums = findMinimums(fArr, iArr, Integer.MAX_VALUE, bArr);
                int i6 = 0;
                for (int i7 = 0; i7 < 6; i7++) {
                    i6 += bArr[i7];
                }
                if (iArr[0] == findMinimums) {
                    return 0;
                }
                if (i6 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (i6 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (i6 != 1 || bArr[2] <= 0) {
                    return (i6 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence2.charAt(i5);
            i4++;
            if (isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (isExtendedASCII(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (charAt == ' ' || (charAt >= '0' && charAt <= '9') || (charAt >= 'A' && charAt <= 'Z')) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (charAt == ' ' || (charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z')) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (isNativeX12(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (charAt >= ' ' && charAt <= '^') {
                fArr[4] = fArr[4] + 0.75f;
            } else if (isExtendedASCII(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            fArr[5] = fArr[5] + 1.0f;
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                findMinimums(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int i8 = 0;
                for (int i9 = 0; i9 < 6; i9++) {
                    i8 += bArr2[i9];
                }
                if (iArr2[0] < iArr2[5] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (i8 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (i8 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (i8 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        int i10 = i3 + i4 + 1;
                        while (i10 < charSequence.length()) {
                            char charAt2 = charSequence2.charAt(i10);
                            if (!isX12TermSep(charAt2)) {
                                if (!isNativeX12(charAt2)) {
                                    break;
                                }
                                i10++;
                            } else {
                                return 3;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    public static final int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        if (pairArr.length <= 0) {
            return EmptyMap.INSTANCE;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(pairArr.length));
        Intrinsics.checkNotNullParameter(pairArr, "$this$toMap");
        Intrinsics.checkNotNullParameter(linkedHashMap, "destination");
        putAll(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final int mod(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static final int nextInt(Random random, IntRange intRange) {
        Intrinsics.checkNotNullParameter(random, "$this$nextInt");
        Intrinsics.checkNotNullParameter(intRange, "range");
        if (!intRange.isEmpty()) {
            int i = intRange.last;
            if (i < Integer.MAX_VALUE) {
                return random.nextInt(intRange.first, i + 1);
            }
            int i2 = intRange.first;
            if (i2 > Integer.MIN_VALUE) {
                return random.nextInt(i2 - 1, i) + 1;
            }
            return random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + intRange);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.google.gson.JsonIOException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.google.gson.JsonNull.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: MalformedJsonException (r2v4 'e' com.google.gson.stream.MalformedJsonException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.gson.JsonElement parse(com.google.gson.stream.JsonReader r2) throws com.google.gson.JsonParseException {
        /*
            r2.peek()     // Catch:{ EOFException -> 0x0024, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.google.gson.TypeAdapter<com.google.gson.JsonElement> r1 = com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.read(r2)     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.google.gson.JsonElement r2 = (com.google.gson.JsonElement) r2     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.google.gson.JsonIOException r0 = new com.google.gson.JsonIOException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.google.gson.JsonNull r2 = com.google.gson.JsonNull.INSTANCE
            return r2
        L_0x002b:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzam.parse(com.google.gson.stream.JsonReader):com.google.gson.JsonElement");
    }

    public static JsonElement parseReader(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            JsonElement parse = parse(jsonReader);
            jsonReader.setLenient(isLenient);
            return parse;
        } catch (StackOverflowError e) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e);
        } catch (OutOfMemoryError e2) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
            throw th;
        }
    }

    public static JsonElement parseString(String str) throws JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            JsonElement parseReader = parseReader(jsonReader);
            if (parseReader != null) {
                if (!(parseReader instanceof JsonNull)) {
                    if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                        throw new JsonSyntaxException("Did not consume the entire document.");
                    }
                }
                return parseReader;
            }
            throw null;
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException((Throwable) e);
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException((Throwable) e3);
        }
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static boolean permitsRequestBody(String str) {
        return !str.equals("GET") && !str.equals("HEAD");
    }

    public static void playTogether(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            j = Math.max(j, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 0});
        ofInt.setDuration(j);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(map, "$this$putAll");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.first, pair.second);
        }
    }

    public static <M extends Model> List<M> readArray(JSONObject jSONObject, String str, ModelFactory<M> modelFactory) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List<M> createList = modelFactory.createList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            M create = modelFactory.create();
            create.read(jSONObject2);
            createList.add(create);
        }
        return createList;
    }

    public static Integer readInteger(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        return null;
    }

    public static Long readLong(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        return null;
    }

    public static List<String> readStringArray(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return arrayList;
    }

    public static final String readText(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        Intrinsics.checkNotNullParameter(reader, "$this$copyTo");
        Intrinsics.checkNotNullParameter(stringWriter, "out");
        char[] cArr = new char[8192];
        int read = reader.read(cArr);
        while (read >= 0) {
            stringWriter.write(cArr, 0, read);
            read = reader.read(cArr);
        }
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    public static String requestPath(HttpUrl httpUrl) {
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        if (encodedQuery == null) {
            return encodedPath;
        }
        return encodedPath + '?' + encodedQuery;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <TInput, TResult, TException extends java.lang.Throwable> TResult retry(int r6, TInput r7, com.google.android.datatransport.cct.zza<TInput, TResult, TException> r8, com.google.android.datatransport.runtime.retries.RetryStrategy<TInput, TResult> r9) throws java.lang.Throwable {
        /*
            r0 = 1
            if (r6 >= r0) goto L_0x0008
            java.lang.Object r6 = r8.apply(r7)
            return r6
        L_0x0008:
            java.lang.Object r1 = r8.apply(r7)
            r2 = r9
            com.google.android.datatransport.cct.zzb r2 = (com.google.android.datatransport.cct.zzb) r2
            r2 = 0
            com.google.android.datatransport.cct.zzc$zza r7 = (com.google.android.datatransport.cct.zzc.zza) r7
            r3 = r1
            com.google.android.datatransport.cct.zzc$zzb r3 = (com.google.android.datatransport.cct.zzc.zzb) r3
            java.net.URL r4 = r3.zzb
            if (r4 == 0) goto L_0x002d
            java.lang.String r2 = "CctTransportBackend"
            java.lang.String r5 = "Following redirect to: %s"
            m35d((java.lang.String) r2, (java.lang.String) r5, (java.lang.Object) r4)
            java.net.URL r2 = r3.zzb
            com.google.android.datatransport.cct.zzc$zza r3 = new com.google.android.datatransport.cct.zzc$zza
            com.google.android.datatransport.cct.a.zzo r4 = r7.zzb
            java.lang.String r7 = r7.zzc
            r3.<init>(r2, r4, r7)
            r7 = r3
            goto L_0x002e
        L_0x002d:
            r7 = r2
        L_0x002e:
            if (r7 == 0) goto L_0x0034
            int r6 = r6 + -1
            if (r6 >= r0) goto L_0x0008
        L_0x0034:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzam.retry(int, java.lang.Object, com.google.android.datatransport.cct.zza, com.google.android.datatransport.runtime.retries.RetryStrategy):java.lang.Object");
    }

    public static void runOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, 0);
    }

    public static final <T> Set<T> setOf(T t) {
        Set<T> singleton = Collections.singleton(t);
        Intrinsics.checkNotNullExpressionValue(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }

    public static final char single(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final String stackTraceToString(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$stackTraceToString");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C c) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c, "destination");
        for (T add : tArr) {
            c.add(add);
        }
        return c;
    }

    public static final <T> List<T> toList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toList");
        int length = tArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        if (length == 1) {
            return listOf(tArr[0]);
        }
        Intrinsics.checkNotNullParameter(tArr, "$this$toMutableList");
        Intrinsics.checkNotNullParameter(tArr, "$this$asCollection");
        return new ArrayList(new ArrayAsCollection(tArr, false));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toMap");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(m, "$this$putAll");
        Intrinsics.checkNotNullParameter(iterable, "pairs");
        for (Pair pair : iterable) {
            m.put(pair.first, pair.second);
        }
        return m;
    }

    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "$this$toSingletonMap");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static final IntRange until(int i, int i2) {
        if (i2 > Integer.MIN_VALUE) {
            return new IntRange(i, i2 - 1);
        }
        IntRange intRange = IntRange.Companion;
        return IntRange.EMPTY;
    }

    @Nullable
    public static PorterDuffColorFilter updateTintFilter(Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static Object validateProperty(TypedProperty typedProperty) throws IllegalArgumentException, JSONException {
        Object obj;
        String str = typedProperty.name;
        if (str == null) {
            throw new IllegalArgumentException("Property key cannot be null.");
        } else if (str.equals("baseType") && !(typedProperty instanceof StringTypedProperty)) {
            throw new IllegalArgumentException("baseType must be a string.");
        } else if (str.startsWith("baseType.")) {
            throw new IllegalArgumentException("baseType must be a string.");
        } else if (!str.equals("baseData")) {
            if (typedProperty instanceof StringTypedProperty) {
                obj = ((StringTypedProperty) typedProperty).value;
            } else if (typedProperty instanceof LongTypedProperty) {
                obj = Long.valueOf(((LongTypedProperty) typedProperty).value);
            } else if (typedProperty instanceof DoubleTypedProperty) {
                obj = Double.valueOf(((DoubleTypedProperty) typedProperty).value);
            } else if (typedProperty instanceof DateTimeTypedProperty) {
                obj = JSONDateUtils.toString(((DateTimeTypedProperty) typedProperty).value);
            } else if (typedProperty instanceof BooleanTypedProperty) {
                obj = Boolean.valueOf(((BooleanTypedProperty) typedProperty).value);
            } else {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unsupported property type: ");
                outline24.append(typedProperty.getType());
                throw new IllegalArgumentException(outline24.toString());
            }
            if (obj != null) {
                return obj;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline17("Value of property with key '", str, "' cannot be null."));
        } else {
            throw new IllegalArgumentException("baseData must be an object.");
        }
    }

    public static <T> Class<T> wrap(Class<T> cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        return cls == Void.TYPE ? Void.class : cls;
    }

    public static void write(JSONStringer jSONStringer, String str, Object obj) throws JSONException {
        if (obj != null) {
            jSONStringer.key(str).value(obj);
        }
    }

    public static void writeArray(JSONStringer jSONStringer, String str, List<? extends Model> list) throws JSONException {
        if (list != null) {
            jSONStringer.key(str).array();
            for (Model write : list) {
                jSONStringer.object();
                write.write(jSONStringer);
                jSONStringer.endObject();
            }
            jSONStringer.endArray();
        }
    }

    public static void writeStringArray(JSONStringer jSONStringer, String str, List<String> list) throws JSONException {
        if (list != null) {
            jSONStringer.key(str).array();
            for (String value : list) {
                jSONStringer.value(value);
            }
            jSONStringer.endArray();
        }
    }

    public static String zza(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static <T> T checkNotNull1(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: d */
    public static void m36d(String str, String str2, Object... objArr) {
        Log.d(getTag(str), String.format(str2, objArr));
    }

    public static final <T> Set<T> setOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length <= 0) {
            return EmptySet.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(tArr, "$this$toSet");
        int length = tArr.length;
        if (length == 0) {
            return EmptySet.INSTANCE;
        }
        if (length == 1) {
            return setOf(tArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(mapCapacity(tArr.length));
        toCollection(tArr, linkedHashSet);
        return linkedHashSet;
    }

    /* renamed from: a */
    public static String m22a(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        for (File fileInputStream : list) {
            FileInputStream fileInputStream2 = new FileInputStream(fileInputStream);
            do {
                try {
                    read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    C2314cj.f3259a.mo33290a(th, th);
                }
            } while (read != -1);
            fileInputStream2.close();
        }
        return android.util.Base64.encodeToString(instance.digest(), 11);
        throw th;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m27a(byte[] r11, com.google.android.play.core.internal.C2306cb r12, java.io.OutputStream r13, long r14, int r16, long r17) throws java.io.IOException {
        /*
            r0 = r11
            r1 = r16
            if (r1 < 0) goto L_0x0079
            r2 = 0
            int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0071
            long r8 = (long) r1
            int r4 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r4 > 0) goto L_0x0069
            com.google.android.play.core.internal.cc r10 = new com.google.android.play.core.internal.cc     // Catch:{ EOFException -> 0x0060 }
            r4 = r10
            r5 = r12
            r6 = r14
            r4.<init>(r5, r6, r8)     // Catch:{ EOFException -> 0x0060 }
            monitor-enter(r10)     // Catch:{ EOFException -> 0x0060 }
            long r4 = r10.mo33192a()     // Catch:{ all -> 0x005d }
            java.io.InputStream r2 = r10.mo33193a(r2, r4)     // Catch:{ all -> 0x005d }
            monitor-exit(r10)     // Catch:{ EOFException -> 0x0060 }
        L_0x0022:
            if (r1 <= 0) goto L_0x0057
            r3 = 16384(0x4000, float:2.2959E-41)
            int r3 = java.lang.Math.min(r1, r3)     // Catch:{ all -> 0x0047 }
            r4 = 0
            r5 = 0
        L_0x002c:
            if (r5 >= r3) goto L_0x0041
            int r6 = r3 - r5
            int r6 = r2.read(r11, r5, r6)     // Catch:{ all -> 0x0047 }
            r7 = -1
            if (r6 == r7) goto L_0x0039
            int r5 = r5 + r6
            goto L_0x002c
        L_0x0039:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "truncated input stream"
            r0.<init>(r1)     // Catch:{ all -> 0x0047 }
            throw r0     // Catch:{ all -> 0x0047 }
        L_0x0041:
            r5 = r13
            r13.write(r11, r4, r3)     // Catch:{ all -> 0x0047 }
            int r1 = r1 - r3
            goto L_0x0022
        L_0x0047:
            r0 = move-exception
            r1 = r0
            if (r2 == 0) goto L_0x0056
            r2.close()     // Catch:{ all -> 0x004f }
            goto L_0x0056
        L_0x004f:
            r0 = move-exception
            r2 = r0
            com.google.android.play.core.internal.cd r0 = com.google.android.play.core.internal.C2314cj.f3259a     // Catch:{ EOFException -> 0x0060 }
            r0.mo33290a(r1, r2)     // Catch:{ EOFException -> 0x0060 }
        L_0x0056:
            throw r1     // Catch:{ EOFException -> 0x0060 }
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ EOFException -> 0x0060 }
        L_0x005c:
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ EOFException -> 0x0060 }
            throw r0     // Catch:{ EOFException -> 0x0060 }
        L_0x0060:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "patch underrun"
            r1.<init>(r2, r0)
            throw r1
        L_0x0069:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Output length overrun"
            r0.<init>(r1)
            throw r0
        L_0x0071:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "inputOffset negative"
            r0.<init>(r1)
            throw r0
        L_0x0079:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "copyLength negative"
            r0.<init>(r1)
            goto L_0x0082
        L_0x0081:
            throw r0
        L_0x0082:
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzam.m27a(byte[], com.google.android.play.core.internal.cb, java.io.OutputStream, long, int, long):void");
    }

    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "$this$toMap");
        int size = map.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size != 1) {
            return toMutableMap(map);
        }
        return toSingletonMap(map);
    }
}
