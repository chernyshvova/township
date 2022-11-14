package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LiveDataUtils {
    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> liveData, @NonNull final Function<In, Out> function, @NonNull final TaskExecutor taskExecutor) {
        final Object obj = new Object();
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<In>() {
            public Out mCurrentOutput = null;

            public void onChanged(@Nullable final In in) {
                TaskExecutor.this.executeOnBackgroundThread(new Runnable() {
                    public void run() {
                        synchronized (obj) {
                            Out apply = function.apply(in);
                            if (C06111.this.mCurrentOutput == null && apply != null) {
                                C06111.this.mCurrentOutput = apply;
                                mediatorLiveData.postValue(apply);
                            } else if (C06111.this.mCurrentOutput != null && !C06111.this.mCurrentOutput.equals(apply)) {
                                C06111.this.mCurrentOutput = apply;
                                mediatorLiveData.postValue(apply);
                            }
                        }
                    }
                });
            }
        });
        return mediatorLiveData;
    }
}
