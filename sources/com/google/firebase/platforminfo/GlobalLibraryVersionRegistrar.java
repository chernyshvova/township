package com.google.firebase.platforminfo;

import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class GlobalLibraryVersionRegistrar {
    public static volatile GlobalLibraryVersionRegistrar INSTANCE;
    public final Set<LibraryVersion> infos = new HashSet();
}
