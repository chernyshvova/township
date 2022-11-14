package com.microsoft.appcenter.crashes.ingestion.models;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.crashes.ingestion.models.json.StackFrameFactory;
import com.microsoft.appcenter.ingestion.models.Model;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Thread implements Model {
    public List<StackFrame> frames;

    /* renamed from: id */
    public long f3580id;
    public String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Thread.class != obj.getClass()) {
            return false;
        }
        Thread thread = (Thread) obj;
        if (this.f3580id != thread.f3580id) {
            return false;
        }
        String str = this.name;
        if (str == null ? thread.name != null : !str.equals(thread.name)) {
            return false;
        }
        List<StackFrame> list = this.frames;
        List<StackFrame> list2 = thread.frames;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f3580id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<StackFrame> list = this.frames;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        this.f3580id = jSONObject.getLong("id");
        this.name = jSONObject.optString("name", (String) null);
        this.frames = zzam.readArray(jSONObject, "frames", StackFrameFactory.sInstance);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "id", Long.valueOf(this.f3580id));
        zzam.write(jSONStringer, "name", this.name);
        zzam.writeArray(jSONStringer, "frames", this.frames);
    }
}
