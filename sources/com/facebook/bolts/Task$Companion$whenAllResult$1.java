package com.facebook.bolts;

import com.playrix.engine.Shortcuts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Task.kt */
public final class Task$Companion$whenAllResult$1 implements Continuation<Void, List<? extends TResult>> {
    public final /* synthetic */ Collection<Task<TResult>> $tasks;

    public Task$Companion$whenAllResult$1(Collection<Task<TResult>> collection) {
        this.$tasks = collection;
    }

    public List<TResult> then(Task<Void> task) {
        Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
        if (this.$tasks.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (Task<TResult> result : this.$tasks) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
