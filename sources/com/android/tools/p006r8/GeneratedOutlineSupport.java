package com.android.tools.p006r8;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.applovin.impl.sdk.p027c.C1085b;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcgs;
import com.playrix.engine.Logger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.android.tools.r8.GeneratedOutlineSupport */
/* compiled from: outline */
public class GeneratedOutlineSupport {
    public static float outline0(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static int outline1(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static String outline10(int i, String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        return sb.toString();
    }

    public static String outline11(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    public static String outline12(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String outline13(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String outline14(String str, int i) {
        return str + i;
    }

    public static String outline15(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String outline16(String str, String str2) {
        return str + str2;
    }

    public static String outline17(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String outline18(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String outline19(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static int outline2(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    public static String outline20(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static String outline21(Object[] objArr, int i, String str, String str2) {
        String format = String.format(str, Arrays.copyOf(objArr, i));
        Intrinsics.checkNotNullExpressionValue(format, str2);
        return format;
    }

    public static StringBuilder outline22(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb;
    }

    public static StringBuilder outline23(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    public static StringBuilder outline24(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder outline25(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder outline26(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder outline27(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static HashMap outline28(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        return hashMap;
    }

    public static void outline29(int i, String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        Log.w(str2, sb.toString());
    }

    public static int outline3(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    public static void outline30(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        Log.w(str3, sb.toString());
    }

    public static void outline31(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        Log.w(str4, sb.toString());
    }

    public static void outline32(Exception exc, StringBuilder sb) {
        sb.append(exc.toString());
        Logger.logError(sb.toString());
    }

    public static void outline33(StringBuilder sb, String str, char c, String str2) {
        sb.append(str);
        sb.append(c);
        sb.append(str2);
    }

    public static void outline34(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static int outline4(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static Bundle outline5(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    public static RemoteException outline6(String str, Throwable th) {
        zzcgs.zzg(str, th);
        return new RemoteException();
    }

    public static C1085b outline7(TimeUnit timeUnit, long j, String str) {
        return C1085b.m1648a(str, Long.valueOf(timeUnit.toMillis(j)));
    }

    public static IObjectWrapper outline8(Parcel parcel) {
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return asInterface;
    }

    public static String outline9(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }
}
