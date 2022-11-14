package com.applovin.impl.sdk.network;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* renamed from: com.applovin.impl.sdk.network.i */
public class C1231i {

    /* renamed from: a */
    public final Bundle f2361a;

    /* renamed from: b */
    public final String f2362b;

    /* renamed from: com.applovin.impl.sdk.network.i$a */
    public static class C1233a {

        /* renamed from: a */
        public final Bundle f2363a;
        @Nullable

        /* renamed from: b */
        public String f2364b;

        public C1233a() {
            this((C1231i) null);
        }

        public C1233a(@Nullable C1231i iVar) {
            this.f2363a = new Bundle();
            if (iVar != null) {
                for (String str : iVar.mo11196a().keySet()) {
                    mo11200a(str, iVar.mo11196a().getString(str));
                }
                this.f2364b = iVar.mo11197b();
            }
        }

        /* renamed from: a */
        public C1233a mo11199a(@Nullable String str) {
            this.f2364b = str;
            return this;
        }

        /* renamed from: a */
        public C1233a mo11200a(String str, String str2) {
            if (str != null) {
                this.f2363a.putString(str, str2);
                return this;
            }
            throw new IllegalArgumentException("No key specified");
        }

        /* renamed from: a */
        public C1231i mo11201a() {
            return new C1231i(this);
        }

        @Nullable
        /* renamed from: b */
        public String mo11202b(String str) {
            if (str != null) {
                return this.f2363a.getString(str);
            }
            throw new IllegalArgumentException("No key specified");
        }

        /* renamed from: c */
        public C1233a mo11203c(String str) {
            if (str != null) {
                this.f2363a.remove(str);
                return this;
            }
            throw new IllegalArgumentException("No key specified.");
        }
    }

    public C1231i(C1233a aVar) {
        this.f2361a = new Bundle(aVar.f2363a);
        this.f2362b = aVar.f2364b;
    }

    /* renamed from: a */
    public Bundle mo11196a() {
        return this.f2361a;
    }

    @Nullable
    /* renamed from: b */
    public String mo11197b() {
        return this.f2362b;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("RequestParameters{extraParameters=");
        outline24.append(this.f2361a);
        outline24.append('}');
        return outline24.toString();
    }
}
