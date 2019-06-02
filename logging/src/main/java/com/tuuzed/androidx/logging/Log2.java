package com.tuuzed.androidx.logging;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class Log2 {

    public static final int ALL = Integer.MIN_VALUE;
    public static final int VERBOSE = 1;
    public static final int DEBUG = 1 << 1; // 2
    public static final int INFO = 3;
    public static final int WARN = 1 << 2; // 4
    public static final int ERROR = 5;
    public static final int FATAL = 6;
    public static final int OFF = Integer.MAX_VALUE;

    @IntDef(flag = true, value = {
            Log2.ALL,
            Log2.VERBOSE,
            Log2.DEBUG,
            Log2.INFO,
            Log2.WARN,
            Log2.ERROR,
            Log2.FATAL,
            Log2.OFF,
    })
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Level {
    }

    public interface Interface {
        int v(@NonNull String tag, @NonNull String msg);

        int v(@NonNull String tag, @NonNull String msg, Throwable tr);

        int d(@NonNull String tag, @NonNull String msg);

        int d(@NonNull String tag, @NonNull String msg, Throwable tr);

        int i(@NonNull String tag, @NonNull String msg);

        int i(@NonNull String tag, @NonNull String msg, Throwable tr);

        int w(@NonNull String tag, @NonNull String msg);

        int w(@NonNull String tag, @NonNull String msg, Throwable tr);

        int e(@NonNull String tag, @NonNull String msg);

        int e(@NonNull String tag, @NonNull String msg, Throwable tr);

        int wtf(@NonNull String tag, @NonNull String msg);

        int wtf(@NonNull String tag, @NonNull String msg, Throwable tr);
    }

    private static Interface impl = new DefaultLog2Impl();

    public static void setImpl(@NonNull Interface impl) {
        Log2.impl = impl;
    }

    public static int v(@NonNull String tag, @NonNull String msg) {
        return impl.v(tag, msg);
    }

    public static int v(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return impl.v(tag, msg, tr);
    }


    public static int d(@NonNull String tag, @NonNull String msg) {
        return impl.d(tag, msg);
    }

    public static int d(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return impl.d(tag, msg, tr);
    }

    public static int i(@NonNull String tag, @NonNull String msg) {
        return impl.i(tag, msg);
    }

    public static int i(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return impl.i(tag, msg, tr);
    }

    public static int w(@NonNull String tag, @NonNull String msg) {
        return impl.w(tag, msg);
    }

    public static int w(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return impl.w(tag, msg, tr);
    }


    public static int e(@NonNull String tag, @NonNull String msg) {
        return impl.e(tag, msg);
    }

    public static int e(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return impl.e(tag, msg, tr);
    }

    public static int wtf(@NonNull String tag, @NonNull String msg) {
        return impl.wtf(tag, msg);
    }

    public static int wtf(@NonNull String tag, @NonNull String msg, Throwable tr) {
        return impl.wtf(tag, msg, tr);
    }

}
