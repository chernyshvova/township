package com.google.firebase.components;

import com.android.billingclient.api.zzam;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class ComponentRuntime extends AbstractComponentContainer {
    public static final Provider<Set<Object>> EMPTY_PROVIDER = ComponentRuntime$$Lambda$5.instance;
    public final Map<Component<?>, Lazy<?>> components = new HashMap();
    public final EventBus eventBus;
    public final Map<Class<?>, Lazy<?>> lazyInstanceMap = new HashMap();
    public final Map<Class<?>, Lazy<Set<?>>> lazySetMap = new HashMap();

    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        Set<CycleDetector$ComponentNode> set;
        this.eventBus = new EventBus(executor);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.m3054of(this.eventBus, EventBus.class, Subscriber.class, Publisher.class));
        for (ComponentRegistrar components2 : iterable) {
            arrayList.addAll(components2.getComponents());
        }
        for (Component<?> component : componentArr) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        HashMap hashMap = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Component component2 = (Component) it.next();
            CycleDetector$ComponentNode cycleDetector$ComponentNode = new CycleDetector$ComponentNode(component2);
            Iterator<Class<? super T>> it2 = component2.providedInterfaces.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Class next = it2.next();
                    CycleDetector$Dep cycleDetector$Dep = new CycleDetector$Dep(next, !component2.isValue(), (CycleDetector$1) null);
                    if (!hashMap.containsKey(cycleDetector$Dep)) {
                        hashMap.put(cycleDetector$Dep, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(cycleDetector$Dep);
                    if (set2.isEmpty() || cycleDetector$Dep.set) {
                        set2.add(cycleDetector$ComponentNode);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{next}));
                    }
                }
            }
        }
        for (Set<CycleDetector$ComponentNode> it3 : hashMap.values()) {
            for (CycleDetector$ComponentNode cycleDetector$ComponentNode2 : it3) {
                for (Dependency next2 : cycleDetector$ComponentNode2.component.dependencies) {
                    if ((next2.injection == 0) && (set = (Set) hashMap.get(new CycleDetector$Dep(next2.anInterface, next2.isSet(), (CycleDetector$1) null))) != null) {
                        for (CycleDetector$ComponentNode cycleDetector$ComponentNode3 : set) {
                            cycleDetector$ComponentNode2.dependencies.add(cycleDetector$ComponentNode3);
                            cycleDetector$ComponentNode3.dependents.add(cycleDetector$ComponentNode2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        HashSet hashSet2 = new HashSet();
        Iterator it4 = hashSet.iterator();
        while (it4.hasNext()) {
            CycleDetector$ComponentNode cycleDetector$ComponentNode4 = (CycleDetector$ComponentNode) it4.next();
            if (cycleDetector$ComponentNode4.isRoot()) {
                hashSet2.add(cycleDetector$ComponentNode4);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            CycleDetector$ComponentNode cycleDetector$ComponentNode5 = (CycleDetector$ComponentNode) hashSet2.iterator().next();
            hashSet2.remove(cycleDetector$ComponentNode5);
            i++;
            for (CycleDetector$ComponentNode next3 : cycleDetector$ComponentNode5.dependencies) {
                next3.dependents.remove(cycleDetector$ComponentNode5);
                if (next3.isRoot()) {
                    hashSet2.add(next3);
                }
            }
        }
        if (i == arrayList.size()) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                Component component3 = (Component) it5.next();
                this.components.put(component3, new Lazy(new ComponentRuntime$$Lambda$1(this, component3)));
            }
            for (Map.Entry next4 : this.components.entrySet()) {
                Component component4 = (Component) next4.getKey();
                if (component4.isValue()) {
                    Lazy lazy = (Lazy) next4.getValue();
                    for (Class<? super T> put : component4.providedInterfaces) {
                        this.lazyInstanceMap.put(put, lazy);
                    }
                }
            }
            for (Component next5 : this.components.keySet()) {
                Iterator<Dependency> it6 = next5.dependencies.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        Dependency next6 = it6.next();
                        if ((next6.type == 1) && !this.lazyInstanceMap.containsKey(next6.anInterface)) {
                            throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next5, next6.anInterface}));
                        }
                    }
                }
            }
            HashMap hashMap2 = new HashMap();
            for (Map.Entry next7 : this.components.entrySet()) {
                Component component5 = (Component) next7.getKey();
                if (!component5.isValue()) {
                    Lazy lazy2 = (Lazy) next7.getValue();
                    for (Class next8 : component5.providedInterfaces) {
                        if (!hashMap2.containsKey(next8)) {
                            hashMap2.put(next8, new HashSet());
                        }
                        ((Set) hashMap2.get(next8)).add(lazy2);
                    }
                }
            }
            for (Map.Entry entry : hashMap2.entrySet()) {
                this.lazySetMap.put((Class) entry.getKey(), new Lazy(new ComponentRuntime$$Lambda$4((Set) entry.getValue())));
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it7 = hashSet.iterator();
        while (it7.hasNext()) {
            CycleDetector$ComponentNode cycleDetector$ComponentNode6 = (CycleDetector$ComponentNode) it7.next();
            if (!cycleDetector$ComponentNode6.isRoot() && !cycleDetector$ComponentNode6.dependencies.isEmpty()) {
                arrayList2.add(cycleDetector$ComponentNode6.component);
            }
        }
        throw new DependencyCycleException(arrayList2);
    }

    public static Object lambda$new$0(ComponentRuntime componentRuntime, Component component) {
        return component.factory.create(new RestrictedComponentContainer(component, componentRuntime));
    }

    public static /* synthetic */ Set lambda$processSetComponents$1(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((Lazy) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        zzam.checkNotNull(cls, "Null interface requested.");
        return this.lazyInstanceMap.get(cls);
    }

    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        Lazy lazy = this.lazySetMap.get(cls);
        if (lazy != null) {
            return lazy;
        }
        return EMPTY_PROVIDER;
    }
}
