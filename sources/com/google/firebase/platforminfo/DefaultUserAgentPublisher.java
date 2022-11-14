package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class DefaultUserAgentPublisher implements UserAgentPublisher {
    public final GlobalLibraryVersionRegistrar gamesSDKRegistrar;
    public final String javaSDKVersionUserAgent;

    public DefaultUserAgentPublisher(Set<LibraryVersion> set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.javaSDKVersionUserAgent = toUserAgent(set);
        this.gamesSDKRegistrar = globalLibraryVersionRegistrar;
    }

    public static String toUserAgent(Set<LibraryVersion> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<LibraryVersion> it = set.iterator();
        while (it.hasNext()) {
            AutoValue_LibraryVersion autoValue_LibraryVersion = (AutoValue_LibraryVersion) it.next();
            sb.append(autoValue_LibraryVersion.libraryName);
            sb.append('/');
            sb.append(autoValue_LibraryVersion.version);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public String getUserAgent() {
        Set<T> unmodifiableSet;
        Set<T> unmodifiableSet2;
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = this.gamesSDKRegistrar;
        synchronized (globalLibraryVersionRegistrar.infos) {
            unmodifiableSet = Collections.unmodifiableSet(globalLibraryVersionRegistrar.infos);
        }
        if (unmodifiableSet.isEmpty()) {
            return this.javaSDKVersionUserAgent;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.javaSDKVersionUserAgent);
        sb.append(' ');
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar2 = this.gamesSDKRegistrar;
        synchronized (globalLibraryVersionRegistrar2.infos) {
            unmodifiableSet2 = Collections.unmodifiableSet(globalLibraryVersionRegistrar2.infos);
        }
        sb.append(toUserAgent(unmodifiableSet2));
        return sb.toString();
    }
}
