package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzz implements Continuation<Void, Task<List<Task<?>>>> {
    public final /* synthetic */ Collection zza;

    public zzz(Collection collection) {
        this.zza = collection;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zza);
        return Tasks.forResult(arrayList);
    }
}
