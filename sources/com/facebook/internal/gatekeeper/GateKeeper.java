package com.facebook.internal.gatekeeper;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GateKeeper.kt */
public final class GateKeeper {
    public final String name;
    public final boolean value;

    public GateKeeper(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.value = z;
    }

    public static /* synthetic */ GateKeeper copy$default(GateKeeper gateKeeper, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gateKeeper.name;
        }
        if ((i & 2) != 0) {
            z = gateKeeper.value;
        }
        return gateKeeper.copy(str, z);
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.value;
    }

    public final GateKeeper copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new GateKeeper(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GateKeeper)) {
            return false;
        }
        GateKeeper gateKeeper = (GateKeeper) obj;
        return Intrinsics.areEqual(this.name, gateKeeper.name) && this.value == gateKeeper.value;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        boolean z = this.value;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("GateKeeper(name=");
        outline24.append(this.name);
        outline24.append(", value=");
        outline24.append(this.value);
        outline24.append(')');
        return outline24.toString();
    }
}
