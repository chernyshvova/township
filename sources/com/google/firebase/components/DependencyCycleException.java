package com.google.firebase.components;

import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class DependencyCycleException extends DependencyException {
    public final List<Component<?>> componentsInCycle;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DependencyCycleException(java.util.List<com.google.firebase.components.Component<?>> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Dependency cycle detected: "
            java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r0)
            java.lang.Object[] r1 = r3.toArray()
            java.lang.String r1 = java.util.Arrays.toString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            r2.componentsInCycle = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.DependencyCycleException.<init>(java.util.List):void");
    }
}
