package com.helpshift.logger.logmodels;

import java.util.Map;

public class LogExtrasModelProvider {
    public static ILogExtrasModelFactory factory;

    public static ILogExtrasModel fromMap(String str, Map map) {
        ILogExtrasModelFactory iLogExtrasModelFactory = factory;
        if (iLogExtrasModelFactory != null) {
            return iLogExtrasModelFactory.fromMap(str, map);
        }
        return null;
    }

    public static ILogExtrasModel fromString(String str, String str2) {
        ILogExtrasModelFactory iLogExtrasModelFactory = factory;
        if (iLogExtrasModelFactory != null) {
            return iLogExtrasModelFactory.fromString(str, str2);
        }
        return null;
    }

    public static void initialize(ILogExtrasModelFactory iLogExtrasModelFactory) {
        factory = iLogExtrasModelFactory;
    }
}
