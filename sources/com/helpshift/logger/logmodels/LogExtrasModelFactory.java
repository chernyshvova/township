package com.helpshift.logger.logmodels;

import java.util.Map;

public class LogExtrasModelFactory implements ILogExtrasModelFactory {
    public ILogExtrasModel fromMap(String str, Map map) {
        return new MapExtrasModel(str, map);
    }

    public ILogExtrasModel fromString(String str, String str2) {
        return new StringExtrasModel(str, str2);
    }
}
