package com.microsoft.appcenter.ingestion.models.json;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.ingestion.models.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DefaultLogSerializer {
    public final Map<String, LogFactory> mLogFactories = new HashMap();

    @NonNull
    public Log deserializeLog(@NonNull String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (str2 == null) {
            str2 = jSONObject.getString("type");
        }
        LogFactory logFactory = this.mLogFactories.get(str2);
        if (logFactory != null) {
            Log create = logFactory.create();
            create.read(jSONObject);
            return create;
        }
        throw new JSONException(GeneratedOutlineSupport.outline16("Unknown log type: ", str2));
    }

    @NonNull
    public String serializeLog(@NonNull Log log) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer();
        jSONStringer.object();
        log.write(jSONStringer);
        jSONStringer.endObject();
        return jSONStringer.toString();
    }
}
