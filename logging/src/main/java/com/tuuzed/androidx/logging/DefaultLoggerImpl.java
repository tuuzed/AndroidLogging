package com.tuuzed.androidx.logging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DefaultLoggerImpl implements Logger.Interface {

    private final int level;

    public DefaultLoggerImpl() {
        this(Logger.ALL);
    }

    public DefaultLoggerImpl(@Logger.Level int level) {
        this.level = level;
    }

    @Override
    public int v(@NonNull String tag, @NonNull String msg) {
        return level <= Logger.VERBOSE ? android.util.Log.v(tag, msg) : 0;
    }

    @Override
    public int v(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        return level <= Logger.VERBOSE ? android.util.Log.v(tag, msg, tr) : 0;
    }

    @Override
    public int d(@NonNull String tag, @NonNull String msg) {
        return level <= Logger.DEBUG ? android.util.Log.d(tag, msg) : 0;
    }

    @Override
    public int d(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        return level <= Logger.DEBUG ? android.util.Log.d(tag, msg, tr) : 0;
    }

    @Override
    public int i(@NonNull String tag, @NonNull String msg) {
        return level <= Logger.INFO ? android.util.Log.i(tag, msg) : 0;
    }

    @Override
    public int i(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        return level <= Logger.INFO ? android.util.Log.i(tag, msg, tr) : 0;
    }


    @Override
    public int w(@NonNull String tag, @NonNull String msg) {
        return level <= Logger.WARN ? android.util.Log.w(tag, msg) : 0;
    }

    @Override
    public int w(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        return level <= Logger.WARN ? android.util.Log.w(tag, msg, tr) : 0;
    }

    @Override
    public int e(@NonNull String tag, @NonNull String msg) {
        return level <= Logger.ERROR ? android.util.Log.e(tag, msg) : 0;
    }

    @Override
    public int e(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        return level <= Logger.ERROR ? android.util.Log.e(tag, msg, tr) : 0;
    }

    @Override
    public int wtf(@NonNull String tag, @NonNull String msg) {
        return level <= Logger.FATAL ? android.util.Log.wtf(tag, msg) : 0;
    }

    @Override
    public int wtf(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        return level <= Logger.FATAL ? android.util.Log.wtf(tag, msg, tr) : 0;
    }
}
