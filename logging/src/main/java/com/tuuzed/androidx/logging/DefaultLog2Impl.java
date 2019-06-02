package com.tuuzed.androidx.logging;

import androidx.annotation.NonNull;

public class DefaultLog2Impl implements Log2.Interface {

    private final int level;

    public DefaultLog2Impl() {
        this(Log2.ALL);
    }

    public DefaultLog2Impl(@Log2.Level int level) {
        this.level = level;
    }

    @Override
    public int v(@NonNull String tag, @NonNull String msg) {
        return level <= Log2.VERBOSE ? android.util.Log.v(tag, msg) : 0;
    }

    @Override
    public int v(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return level <= Log2.VERBOSE ? android.util.Log.v(tag, msg, tr) : 0;
    }

    @Override
    public int d(@NonNull String tag, @NonNull String msg) {
        return level <= Log2.DEBUG ? android.util.Log.d(tag, msg) : 0;
    }

    @Override
    public int d(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return level <= Log2.DEBUG ? android.util.Log.d(tag, msg, tr) : 0;
    }

    @Override
    public int i(@NonNull String tag, @NonNull String msg) {
        return level <= Log2.INFO ? android.util.Log.i(tag, msg) : 0;
    }

    @Override
    public int i(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return level <= Log2.INFO ? android.util.Log.i(tag, msg, tr) : 0;
    }


    @Override
    public int w(@NonNull String tag, @NonNull String msg) {
        return level <= Log2.WARN ? android.util.Log.w(tag, msg) : 0;
    }

    @Override
    public int w(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return level <= Log2.WARN ? android.util.Log.w(tag, msg, tr) : 0;
    }

    @Override
    public int e(@NonNull String tag, @NonNull String msg) {
        return level <= Log2.ERROR ? android.util.Log.e(tag, msg) : 0;
    }

    @Override
    public int e(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return level <= Log2.ERROR ? android.util.Log.e(tag, msg, tr) : 0;
    }

    @Override
    public int wtf(@NonNull String tag, @NonNull String msg) {
        return level <= Log2.FATAL ? android.util.Log.wtf(tag, msg) : 0;
    }

    @Override
    public int wtf(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return level <= Log2.FATAL ? android.util.Log.wtf(tag, msg, tr) : 0;
    }
}
