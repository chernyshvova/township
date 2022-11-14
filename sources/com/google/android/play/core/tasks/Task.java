package com.google.android.play.core.tasks;

public abstract class Task<ResultT> {
    public abstract ResultT getResult();

    public abstract boolean isSuccessful();
}
