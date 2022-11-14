package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final class RestrictedComponentContainer extends AbstractComponentContainer {
    public final Set<Class<?>> allowedDirectInterfaces;
    public final Set<Class<?>> allowedProviderInterfaces;
    public final Set<Class<?>> allowedPublishedEvents;
    public final Set<Class<?>> allowedSetDirectInterfaces;
    public final Set<Class<?>> allowedSetProviderInterfaces;
    public final ComponentContainer delegateContainer;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    public static class RestrictedPublisher implements Publisher {
        public RestrictedPublisher(Set<Class<?>> set, Publisher publisher) {
        }
    }

    public RestrictedComponentContainer(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (Dependency next : component.dependencies) {
            if (next.injection == 0) {
                if (next.isSet()) {
                    hashSet3.add(next.anInterface);
                } else {
                    hashSet.add(next.anInterface);
                }
            } else if (next.isSet()) {
                hashSet4.add(next.anInterface);
            } else {
                hashSet2.add(next.anInterface);
            }
        }
        if (!component.publishedEvents.isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.allowedDirectInterfaces = Collections.unmodifiableSet(hashSet);
        this.allowedProviderInterfaces = Collections.unmodifiableSet(hashSet2);
        this.allowedSetDirectInterfaces = Collections.unmodifiableSet(hashSet3);
        this.allowedSetProviderInterfaces = Collections.unmodifiableSet(hashSet4);
        this.allowedPublishedEvents = component.publishedEvents;
        this.delegateContainer = componentContainer;
    }

    public <T> T get(Class<T> cls) {
        if (this.allowedDirectInterfaces.contains(cls)) {
            T t = this.delegateContainer.get(cls);
            if (!cls.equals(Publisher.class)) {
                return t;
            }
            return new RestrictedPublisher(this.allowedPublishedEvents, (Publisher) t);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        if (this.allowedProviderInterfaces.contains(cls)) {
            return this.delegateContainer.getProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    public <T> Set<T> setOf(Class<T> cls) {
        if (this.allowedSetDirectInterfaces.contains(cls)) {
            return this.delegateContainer.setOf(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }

    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        if (this.allowedSetProviderInterfaces.contains(cls)) {
            return this.delegateContainer.setOfProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }
}
