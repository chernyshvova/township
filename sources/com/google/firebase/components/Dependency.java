package com.google.firebase.components;

import com.android.billingclient.api.zzam;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final class Dependency {
    public final Class<?> anInterface;
    public final int injection;
    public final int type;

    public Dependency(Class<?> cls, int i, int i2) {
        zzam.checkNotNull(cls, "Null dependency anInterface.");
        this.anInterface = cls;
        this.type = i;
        this.injection = i2;
    }

    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (this.anInterface == dependency.anInterface && this.type == dependency.type && this.injection == dependency.injection) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ this.type) * 1000003) ^ this.injection;
    }

    public boolean isSet() {
        return this.type == 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.anInterface);
        sb.append(", type=");
        int i = this.type;
        boolean z = true;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        if (this.injection != 0) {
            z = false;
        }
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
