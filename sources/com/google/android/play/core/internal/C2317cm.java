package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cm */
public final class C2317cm<T> implements C2318co, C2315ck {

    /* renamed from: a */
    public static final Object f3261a = new Object();

    /* renamed from: b */
    public volatile C2318co<T> f3262b;

    /* renamed from: c */
    public volatile Object f3263c = f3261a;

    public C2317cm(C2318co<T> coVar) {
        this.f3262b = coVar;
    }

    /* renamed from: a */
    public static <P extends C2318co<T>, T> C2318co<T> m3004a(P p) {
        return p instanceof C2317cm ? p : new C2317cm(p);
    }

    /* renamed from: b */
    public static <P extends C2318co<T>, T> C2315ck<T> m3005b(P p) {
        if (p instanceof C2315ck) {
            return (C2315ck) p;
        }
        if (p != null) {
            return new C2317cm(p);
        }
        throw null;
    }

    /* renamed from: a */
    public final T mo33167a() {
        T t = this.f3263c;
        if (t == f3261a) {
            synchronized (this) {
                t = this.f3263c;
                if (t == f3261a) {
                    t = this.f3262b.mo33167a();
                    T t2 = this.f3263c;
                    if (t2 != f3261a) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 118 + valueOf2.length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.f3263c = t;
                    this.f3262b = null;
                }
            }
        }
        return t;
    }
}
