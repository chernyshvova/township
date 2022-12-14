package com.google.firebase.components;

import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class CycleDetector$ComponentNode {
    public final Component<?> component;
    public final Set<CycleDetector$ComponentNode> dependencies = new HashSet();
    public final Set<CycleDetector$ComponentNode> dependents = new HashSet();

    public CycleDetector$ComponentNode(Component<?> component2) {
        this.component = component2;
    }

    public boolean isRoot() {
        return this.dependents.isEmpty();
    }
}
