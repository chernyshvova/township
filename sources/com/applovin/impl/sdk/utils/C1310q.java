package com.applovin.impl.sdk.utils;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.q */
public class C1310q {

    /* renamed from: a */
    public static final C1310q f2561a = new C1310q();

    /* renamed from: b */
    public String f2562b;

    /* renamed from: c */
    public final List<C1310q> f2563c;

    /* renamed from: d */
    public final C1310q f2564d;

    /* renamed from: e */
    public final String f2565e;

    /* renamed from: f */
    public final Map<String, String> f2566f;

    public C1310q() {
        this.f2564d = null;
        this.f2565e = "";
        this.f2566f = Collections.emptyMap();
        this.f2562b = "";
        this.f2563c = Collections.emptyList();
    }

    public C1310q(String str, Map<String, String> map, C1310q qVar) {
        this.f2564d = qVar;
        this.f2565e = str;
        this.f2566f = Collections.unmodifiableMap(map);
        this.f2563c = new ArrayList();
    }

    /* renamed from: a */
    public String mo11348a() {
        return this.f2565e;
    }

    /* renamed from: a */
    public List<C1310q> mo11349a(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(this.f2563c.size());
            for (C1310q next : this.f2563c) {
                if (str.equalsIgnoreCase(next.mo11348a())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public C1310q mo11350b(String str) {
        if (str != null) {
            for (C1310q next : this.f2563c) {
                if (str.equalsIgnoreCase(next.mo11348a())) {
                    return next;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public Map<String, String> mo11351b() {
        return this.f2566f;
    }

    @Nullable
    /* renamed from: c */
    public C1310q mo11352c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        } else if (this.f2563c.size() <= 0) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            while (!arrayList.isEmpty()) {
                C1310q qVar = (C1310q) arrayList.get(0);
                arrayList.remove(0);
                if (str.equalsIgnoreCase(qVar.mo11348a())) {
                    return qVar;
                }
                arrayList.addAll(qVar.mo11354d());
            }
            return null;
        }
    }

    /* renamed from: c */
    public String mo11353c() {
        return this.f2562b;
    }

    /* renamed from: d */
    public List<C1310q> mo11354d() {
        return Collections.unmodifiableList(this.f2563c);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("XmlNode{elementName='");
        GeneratedOutlineSupport.outline33(outline24, this.f2565e, '\'', ", text='");
        GeneratedOutlineSupport.outline33(outline24, this.f2562b, '\'', ", attributes=");
        outline24.append(this.f2566f);
        outline24.append('}');
        return outline24.toString();
    }
}
