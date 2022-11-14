package com.helpshift.logger.logmodels;

import java.util.Map;

public interface ILogExtrasModelFactory {
    ILogExtrasModel fromMap(String str, Map map);

    ILogExtrasModel fromString(String str, String str2);
}
