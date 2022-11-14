package com.google.firebase.platforminfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public final /* synthetic */ class DefaultUserAgentPublisher$$Lambda$1 implements ComponentFactory {
    public static final DefaultUserAgentPublisher$$Lambda$1 instance = new DefaultUserAgentPublisher$$Lambda$1();

    public Object create(ComponentContainer componentContainer) {
        Set<LibraryVersion> of = ((RestrictedComponentContainer) componentContainer).setOf(LibraryVersion.class);
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.INSTANCE;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.INSTANCE;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    GlobalLibraryVersionRegistrar.INSTANCE = globalLibraryVersionRegistrar;
                }
            }
        }
        return new DefaultUserAgentPublisher(of, globalLibraryVersionRegistrar);
    }
}
