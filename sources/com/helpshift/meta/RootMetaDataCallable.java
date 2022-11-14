package com.helpshift.meta;

import java.io.Serializable;
import java.util.Map;

public interface RootMetaDataCallable {
    Map<String, Serializable> call();
}
