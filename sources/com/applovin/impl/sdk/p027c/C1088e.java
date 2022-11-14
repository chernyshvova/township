package com.applovin.impl.sdk.p027c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.Utils;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.c.e */
public final class C1088e {

    /* renamed from: a */
    public static C1188m f1846a;

    /* renamed from: b */
    public static SharedPreferences f1847b;

    /* renamed from: c */
    public final SharedPreferences f1848c;

    public C1088e(C1188m mVar) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("com.applovin.sdk.preferences.");
        outline24.append(mVar.mo11010z());
        this.f1848c = mVar.mo10932L().getSharedPreferences(outline24.toString(), 0);
        if (!mVar.mo10988e()) {
            f1846a = mVar;
        }
    }

    /* renamed from: a */
    public static SharedPreferences m1667a(Context context) {
        if (f1847b == null) {
            f1847b = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f1847b;
    }

    @Nullable
    /* renamed from: a */
    public static <T> T m1668a(String str, @Nullable T t, Class cls, SharedPreferences sharedPreferences) {
        T t2;
        long j;
        int i;
        Class<Long> cls2 = Long.class;
        Class<Integer> cls3 = Integer.class;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (sharedPreferences.contains(str)) {
                if (Boolean.class.equals(cls)) {
                    t2 = Boolean.valueOf(t != null ? sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()) : sharedPreferences.getBoolean(str, false));
                } else if (Float.class.equals(cls)) {
                    t2 = Float.valueOf(t != null ? sharedPreferences.getFloat(str, ((Float) t).floatValue()) : sharedPreferences.getFloat(str, 0.0f));
                } else if (cls3.equals(cls)) {
                    if (t != null) {
                        i = sharedPreferences.getInt(str, t.getClass().equals(cls2) ? ((Long) t).intValue() : ((Integer) t).intValue());
                    } else {
                        i = sharedPreferences.getInt(str, 0);
                    }
                    t2 = Integer.valueOf(i);
                } else if (cls2.equals(cls)) {
                    if (t != null) {
                        j = sharedPreferences.getLong(str, t.getClass().equals(cls3) ? ((Integer) t).longValue() : ((Long) t).longValue());
                    } else {
                        j = sharedPreferences.getLong(str, 0);
                    }
                    t2 = Long.valueOf(j);
                } else if (Double.class.equals(cls)) {
                    t2 = Double.valueOf(t != null ? Double.longBitsToDouble(sharedPreferences.getLong(str, Double.doubleToRawLongBits(((Double) t).doubleValue()))) : Double.longBitsToDouble(sharedPreferences.getLong(str, 0)));
                } else {
                    t2 = String.class.equals(cls) ? sharedPreferences.getString(str, (String) t) : Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) t) : t;
                }
                if (t2 != null) {
                    return cls.cast(t2);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return t;
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return t;
        } catch (Throwable th) {
            C1314v.m2659c("SharedPreferencesManager", "Error getting value for key: " + str, th);
            return t;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: a */
    public static void m1669a(final SharedPreferences.Editor editor) {
        try {
            if (f1846a != null && ((Boolean) f1846a.mo10946a(C1085b.f1766eO)).booleanValue()) {
                if (!Utils.isMainThread()) {
                    editor.commit();
                    return;
                } else if (f1846a.mo10938S() != null) {
                    f1846a.mo10938S().mo10829a((C1109a) new C1166z(f1846a, new Runnable() {
                        public void run() {
                            editor.commit();
                        }
                    }), C1140o.C1142a.BACKGROUND);
                    return;
                }
            }
            editor.apply();
        } catch (Throwable th) {
            C1314v.m2659c("SharedPreferencesManager", "Unable to apply changes", th);
        }
    }

    /* renamed from: a */
    public static <T> void m1670a(C1087d<T> dVar, Context context) {
        m1669a(m1667a(context).edit().remove(dVar.mo10687a()));
    }

    /* renamed from: a */
    public static <T> void m1671a(C1087d<T> dVar, @Nullable T t, Context context) {
        m1672a(dVar.mo10687a(), t, m1667a(context), (SharedPreferences.Editor) null);
    }

    /* renamed from: a */
    public static <T> void m1672a(String str, @Nullable T t, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        long doubleToRawLongBits;
        boolean z = true;
        boolean z2 = editor != null;
        if (!z2) {
            editor = sharedPreferences.edit();
        }
        if (t == null) {
            editor.remove(str);
        } else if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        } else {
            if (t instanceof Long) {
                doubleToRawLongBits = ((Long) t).longValue();
            } else if (t instanceof Double) {
                doubleToRawLongBits = Double.doubleToRawLongBits(((Double) t).doubleValue());
            } else if (t instanceof String) {
                editor.putString(str, (String) t);
            } else if (t instanceof Set) {
                editor.putStringSet(str, (Set) t);
            } else {
                C1314v.m2663i("SharedPreferencesManager", "Unable to put default value of invalid type: " + t);
                z = false;
            }
            editor.putLong(str, doubleToRawLongBits);
        }
        if (z && !z2) {
            m1669a(editor);
        }
    }

    @Nullable
    /* renamed from: b */
    public static <T> T m1673b(C1087d<T> dVar, @Nullable T t, Context context) {
        return m1668a(dVar.mo10687a(), t, (Class) dVar.mo10688b(), m1667a(context));
    }

    /* renamed from: a */
    public void mo10690a(SharedPreferences sharedPreferences) {
        m1669a(sharedPreferences.edit().clear());
    }

    /* renamed from: a */
    public <T> void mo10691a(C1087d<T> dVar) {
        m1669a(this.f1848c.edit().remove(dVar.mo10687a()));
    }

    /* renamed from: a */
    public <T> void mo10692a(C1087d<T> dVar, @Nullable T t) {
        mo10693a(dVar, t, this.f1848c);
    }

    /* renamed from: a */
    public <T> void mo10693a(C1087d<T> dVar, @Nullable T t, SharedPreferences sharedPreferences) {
        mo10695a(dVar.mo10687a(), t, sharedPreferences);
    }

    /* renamed from: a */
    public <T> void mo10694a(String str, @Nullable T t, SharedPreferences.Editor editor) {
        m1672a(str, t, (SharedPreferences) null, editor);
    }

    /* renamed from: a */
    public <T> void mo10695a(String str, @Nullable T t, SharedPreferences sharedPreferences) {
        m1672a(str, t, sharedPreferences, (SharedPreferences.Editor) null);
    }

    @Nullable
    /* renamed from: b */
    public <T> T mo10696b(C1087d<T> dVar, @Nullable T t) {
        return mo10697b(dVar, t, this.f1848c);
    }

    @Nullable
    /* renamed from: b */
    public <T> T mo10697b(C1087d<T> dVar, @Nullable T t, SharedPreferences sharedPreferences) {
        return m1668a(dVar.mo10687a(), t, (Class) dVar.mo10688b(), sharedPreferences);
    }
}
